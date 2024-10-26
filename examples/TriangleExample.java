import java.nio.ByteBuffer;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWNativeWayland;
import org.lwjgl.glfw.GLFWNativeWin32;
import org.lwjgl.glfw.GLFWNativeX11;
import org.lwjgl.system.windows.WinBase;

import wgpu.WebGPU;
import wgpu.callback.*;
import wgpu.enums.*;
import wgpu.impl.*;
import wgpu.struct.*;

import static org.lwjgl.glfw.GLFW.*;

public class TriangleExample {
	static long window;
	static GPUInstance instance;
	static GPUSurface surface;
	static GPUDevice device;
	static GPUQueue queue;
	static GPURenderPipeline pipeline;
	static TextureFormat preferredSurfaceFormat;

	static final QueueOnSubmittedWorkDoneCallback queueCallback = (status, userdata) -> {
		System.out.println("[Queue]: " + status);
	};

	static final LogCallback logCallback = (level, message, userdata) -> {
		System.err.println("[" + level.name + "]: " + message);
	};

	public static void main(String[] args) {
		WebGPU.setLogCallback(logCallback);
		WebGPU.setLogLevel(LogLevel.WARN);

		createWindow();
		createInstance();
		createGlfwSurface();

		var adapter = requestAdapter();
		requestDevice(adapter);
		setupSurface(adapter);
		adapter.release();

		setupPipeline();

		runMainLoop();

		cleanup();
	}

	static void createWindow() {
		glfwInit();

		glfwWindowHint(GLFW_CLIENT_API, GLFW_NO_API);
		glfwWindowHint(GLFW_RESIZABLE, GLFW_FALSE);

		window = glfwCreateWindow(800, 600, "WebGPU Example", 0, 0);
		if (window == 0)
			throw new NullPointerException("NULL Window");
	}

	static void createInstance() {
		var descriptor = new InstanceDescriptor();
		instance = WebGPU.createInstance(descriptor);
	}

	static void createGlfwSurface() {
		SurfaceDescriptor descriptor = new SurfaceDescriptor();
		descriptor.label = "GLFW Surface";

		int platform = GLFW.glfwGetPlatform();

		switch (platform) {
		case GLFW_PLATFORM_WIN32 -> {
			var win32 = new SurfaceDescriptorFromWindowsHWND();
			win32.hinstance = WinBase.GetModuleHandle((ByteBuffer) null);
			win32.hwnd = GLFWNativeWin32.glfwGetWin32Window(window);
			descriptor.nextInChain = win32;
		}
		case GLFW_PLATFORM_X11 -> {
			var x11 = new SurfaceDescriptorFromXlibWindow();
			x11.display = GLFWNativeX11.glfwGetX11Display();
			x11.window = GLFWNativeX11.glfwGetX11Window(window);
			descriptor.nextInChain = x11;
		}
		case GLFW_PLATFORM_WAYLAND -> {
			var wayland = new SurfaceDescriptorFromWaylandSurface();
			wayland.display = GLFWNativeWayland.glfwGetWaylandDisplay();
			wayland.surface = GLFWNativeWayland.glfwGetWaylandMonitor(window);
			descriptor.nextInChain = wayland;

		}
		case GLFW_PLATFORM_COCOA -> {
			throw new UnsupportedOperationException("MacOS not supported yet");
			// TODO implement from this Objective-C snippet
			// id metal_layer = [CAMetalLayer layer];
			// NSWindow* ns_window = glfwGetCocoaWindow(window);
			// [ns_window.contentView setWantsLayer : YES] ;
			// [ns_window.contentView setLayer : metal_layer] ;
		}
		default -> {
			throw new UnsupportedOperationException("Unknown platform: " + platform);
		}
		}

		surface = instance.createSurface(descriptor);
		if (surface.handle == 0)
			throw new NullPointerException("NULL Surface");
	}

	static GPUAdapter requestAdapter() {
		var options = new RequestAdapterOptions();
		options.powerPreference = PowerPreference.HIGH_PERFORMANCE;
		options.compatibleSurface = surface;

		var adapter = instance.requestAdapter(options);

		AdapterInfo info = new AdapterInfo();
		adapter.getInfo(info);
		System.out.println("Adapter: " + info.adapterType);
		System.out.println("Backend: " + info.backendType);

		System.out.println("Features: ");
		int num = (int) adapter.enumerateFeatures(null);
		FeatureName[] features = new FeatureName[(int) num];
		adapter.enumerateFeatures(features);
		for (var feature : features) {
			System.out.println("  " + feature);
		}
		System.out.println();

		return adapter;
	}

	static void requestDevice(GPUAdapter adapter) {
		var required = new RequiredLimits();
		required.limits.maxTextureDimension2D = 1024 * 4; // require 4K textures

		DeviceDescriptor descriptor = new DeviceDescriptor();
		descriptor.label = "My Device";
		descriptor.requiredFeatures = null;
		descriptor.requiredLimits = required;
		descriptor.defaultQueue.label = "My Queue";
		descriptor.uncapturedErrorCallbackInfo.callback = (type, message, userdata) -> {
			System.err.println("Error Callback: " + type + " " + message);
		};

		device = adapter.requestDevice(descriptor);

		queue = device.getQueue();
		if (queue.handle == 0)
			throw new NullPointerException("NULL Queue");

		queue.onSubmittedWorkDone(queueCallback, 0);
	}

	static void setupSurface(GPUAdapter adapter) {
		SurfaceCapabilities capabilities = new SurfaceCapabilities();
		surface.getCapabilities(adapter, capabilities);
		preferredSurfaceFormat = capabilities.formats[0];

		var config = new SurfaceConfiguration();
		config.alphaMode = CompositeAlphaMode.OPAQUE;
		config.usage = TextureUsage.RENDER_ATTACHMENT;
		config.width = 800;
		config.height = 600;
		config.presentMode = PresentMode.FIFO;
		config.format = preferredSurfaceFormat;
		config.device = device;

		surface.configure(config);
	}

	static void setupPipeline() {
		var wgsl = new ShaderModuleWGSLDescriptor();
		wgsl.code = """
					@vertex
					fn vs_main(@builtin(vertex_index) in_vertex_index: u32) -> @builtin(position) vec4f {
					    var p = vec2f(0.0, 0.0);
					    if (in_vertex_index == 0u) {
					        p = vec2f(-0.5, -0.5);
					    } else if (in_vertex_index == 1u) {
					        p = vec2f(0.5, -0.5);
					    } else {
					        p = vec2f(0.0, 0.5);
					    }
					    return vec4f(p, 0.0, 1.0);
					}

					@fragment
					fn fs_main() -> @location(0) vec4f {
					    return vec4f(0.0, 0.4, 1.0, 1.0);
					}
				""";

		var shaderDesc = new ShaderModuleDescriptor();
		shaderDesc.nextInChain = wgsl;

		GPUShaderModule shader = device.createShaderModule(shaderDesc);

		BlendState blend = new BlendState();
		blend.color.srcFactor = BlendFactor.SRC_ALPHA;
		blend.color.dstFactor = BlendFactor.ONE_MINUS_SRC_ALPHA;
		blend.color.operation = BlendOperation.ADD;

		blend.alpha.srcFactor = BlendFactor.ZERO;
		blend.alpha.dstFactor = BlendFactor.ONE;
		blend.alpha.operation = BlendOperation.ADD;

		ColorTargetState colorTarget = new ColorTargetState();
		colorTarget.format = preferredSurfaceFormat;
		colorTarget.blend = blend;
		colorTarget.writeMask = ColorWriteMask.ALL;

		var pipelineDesc = new RenderPipelineDescriptor();
		FragmentState fragment = new FragmentState();
		fragment.module = shader;
		fragment.entryPoint = "fs_main";
		fragment.constants = null;
		fragment.targets = new ColorTargetState[] { colorTarget };

		pipelineDesc.fragment = fragment;

		pipelineDesc.label = "test";
		pipelineDesc.vertex.entryPoint = "vs_main";
		pipelineDesc.vertex.module = shader;
		pipelineDesc.vertex.constants = null;
		pipelineDesc.vertex.buffers = null;

		pipelineDesc.primitive.topology = PrimitiveTopology.TRIANGLE_LIST;
		pipelineDesc.primitive.stripIndexFormat = IndexFormat.UNDEFINED;
		pipelineDesc.primitive.frontFace = FrontFace.CCW;
		pipelineDesc.primitive.cullMode = CullMode.NONE;
		pipelineDesc.depthStencil = null;
		pipelineDesc.multisample.count = 1;
		pipelineDesc.multisample.mask = ~0;
		pipelineDesc.multisample.alphaToCoverageEnabled = false;

		pipeline = device.createRenderPipeline(pipelineDesc);
		if (pipeline.handle == 0)
			throw new NullPointerException("NULL RenderPipeline");

		shader.release();
	}

	static void runMainLoop() {
		var encoderDesc = new CommandEncoderDescriptor();
		encoderDesc.label = "My Encoder";

		var cbuffDesc = new CommandBufferDescriptor();
		cbuffDesc.label = "My Command buffer";

		var renderPassDesc = new RenderPassDescriptor();
		renderPassDesc.colorAttachments = new RenderPassColorAttachment[] { new RenderPassColorAttachment() };
		renderPassDesc.colorAttachments[0].loadOp = LoadOp.CLEAR;
		renderPassDesc.colorAttachments[0].storeOp = StoreOp.STORE;
		renderPassDesc.colorAttachments[0].clearValue = new Color(0.9, 0.1, 0.2, 1.0);
		renderPassDesc.colorAttachments[0].depthSlice = 0xFFff_ffFF;
		renderPassDesc.depthStencilAttachment = null;
		renderPassDesc.label = "My Pass";

		var textViewDesc = new TextureViewDescriptor();
		textViewDesc.label = "Surface Texture View";
		textViewDesc.dimension = TextureViewDimension.D2;
		textViewDesc.baseMipLevel = 0;
		textViewDesc.mipLevelCount = 1;
		textViewDesc.baseArrayLayer = 0;
		textViewDesc.arrayLayerCount = 1;
		textViewDesc.aspect = TextureAspect.ALL;

		var surfaceTexture = new SurfaceTexture();

		// setup these for reuse to avoid allocation
		GPUCommandEncoder commandEncoder = new GPUCommandEncoder();
		GPURenderPassEncoder renderPassEncoder = new GPURenderPassEncoder();
		GPUCommandBuffer[] commands = { new GPUCommandBuffer() };

		while (!glfwWindowShouldClose(window)) {

			surface.getCurrentTexture(surfaceTexture);
			if (surfaceTexture.status != SurfaceGetCurrentTextureStatus.SUCCESS)
				throw new RuntimeException("Surface Texture status: " + surfaceTexture.status);

			if (surfaceTexture.suboptimal) {
				System.out.println("Surface Texture is suboptimal :(");
			}

			commandEncoder.handle = device.createCommandEncoder0(encoderDesc);

			textViewDesc.format = surfaceTexture.texture.getFormat();
			renderPassDesc.colorAttachments[0].view.handle = surfaceTexture.texture.createView0(textViewDesc);
			renderPassEncoder.handle = commandEncoder.beginRenderPass0(renderPassDesc);
			renderPassDesc.colorAttachments[0].view.release();

			renderPassEncoder.setPipeline(pipeline);

			// draw
			renderPassEncoder.draw(3, 1, 0, 0);

			renderPassEncoder.end();
			renderPassEncoder.release();

			commands[0].handle = commandEncoder.finish0(cbuffDesc);
			queue.submit(commands);
			commands[0].release();
			commandEncoder.release();

			surface.present();

			device.poll(false, null);

			glfwPollEvents();
		}
	}

	static void cleanup() {
		pipeline.release();
		queue.release();
		device.release();
		instance.release();
		glfwTerminate();
	}

}
