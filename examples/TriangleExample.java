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
	static GPUAdapter adapter;
	static GPUSurface surface;
	static GPUDevice device;
	static GPUQueue queue;
	static GPURenderPipeline pipeline;

	static QueueOnSubmittedWorkDoneCallback queueCallback;
	static LogCallback logCallback;
	static TextureFormat surfaceFormat;

	public static void main(String[] args) {
		glfwInit();
		
		glfwWindowHint(GLFW_CLIENT_API, GLFW_NO_API); // <-- extra info for glfwCreateWindow
		glfwWindowHint(GLFW_RESIZABLE, GLFW_FALSE);
		window = glfwCreateWindow(640, 480, "Learn WebGPU", 0, 0);
		
		if(window == 0)
			throw new NullPointerException("NULL Window");
		
		logCallback = (level, message, userdata) -> {
			System.err.println("LOG [" +level.name + "]: " + message);
		};
		
		WebGPU.setLogCallback(logCallback);
		WebGPU.setLogLevel(LogLevel.WARN);
		
		createInstance();
		createGlfwSurface();
		requestAdapter();
		requestDevice();
		setupSurface();
		setupPipeline();

		adapter.release();
		
		runMainLoop();
		
		cleanup();
	}
	
	private static void createInstance() {
		var descriptor = new InstanceDescriptor();
		instance = WebGPU.createInstance(descriptor);
		if(instance.handle == 0)
			throw new NullPointerException("Instance is NULL");
	}

	static void createGlfwSurface() {
		SurfaceDescriptor descriptor = new SurfaceDescriptor();
		descriptor.label = "GLFW Surface";
	
		int platform = GLFW.glfwGetPlatform();
		
		switch(platform) {
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
		if(surface.handle == 0)
			throw new NullPointerException("NULL Surface");
	}

	private static void requestAdapter() {
		InstanceRequestAdapterCallback callback = (status, adapter_, message, userdata) -> {
			System.out.println("Adapter callback: " + status + " " + message);
			adapter = adapter_;
		};
		
		var options = new RequestAdapterOptions();
		options.powerPreference = PowerPreference.HIGH_PERFORMANCE;
		options.compatibleSurface = surface;
		
		instance.requestAdapter(options, callback, 0);
		if(adapter.handle == 0)
			throw new RuntimeException("NULL Adapter handle");
		
		AdapterInfo info = new AdapterInfo();
		adapter.getInfo(info);
		System.out.println("Adapter: " + info.adapterType);
		System.out.println("Backend: " + info.backendType);
		
		System.out.println("Features: ");
		int num = (int) adapter.enumerateFeatures(null);
		FeatureName[] features = new FeatureName[(int) num];
		adapter.enumerateFeatures(features);
		for(var feature : features) {
			System.out.println("  " + feature);
		}
		System.out.println();
	}

	private static void requestDevice() {
		AdapterRequestDeviceCallback callback = (status, device_, message, userdata) -> {
			System.out.println("Device callback: " + status + " " + message);
			device = device_;
		};
		
		var required = new RequiredLimits();
		required.limits.maxTextureDimension2D = 1024 * 4; //require 4K textures
		
		DeviceDescriptor descriptor = new DeviceDescriptor();
		descriptor.label = "My Device";
		descriptor.requiredFeatures = null;
		descriptor.requiredLimits = required;
		descriptor.defaultQueue.label = "My Queue";
		descriptor.uncapturedErrorCallbackInfo.callback = (type, message, userdata) -> {
			System.err.println("Error Callback: " + type + " " + message);
		};

		adapter.requestDevice(descriptor, callback, 0L);
		
		if(device == null)
			throw new RuntimeException();
	}

	private static void setupSurface() {
		SurfaceCapabilities capabilities = new SurfaceCapabilities();
		surface.getCapabilities(adapter, capabilities);
		surfaceFormat = capabilities.formats[0];
		
		var config = new SurfaceConfiguration();
		config.alphaMode = CompositeAlphaMode.OPAQUE;
		config.usage = TextureUsage.RENDER_ATTACHMENT;
		config.width = 640;
		config.height = 480;
		config.presentMode = PresentMode.FIFO;
		config.format = surfaceFormat;
		config.device = device;
		
		surface.configure(config);
		
		queue = device.getQueue();
		if(queue.handle == 0)
			throw new NullPointerException("NULL Queue");
		
		queueCallback = (status, userdata) -> {
			System.out.println("Queue work finished with status: " + status);
		};
		
		queue.onSubmittedWorkDone(queueCallback , 0);
	}

	private static void setupPipeline() {
		var shaderDesc = new ShaderModuleDescriptor();
		var wgsl = new ShaderModuleWGSLDescriptor();
		shaderDesc.nextInChain = wgsl;
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
		
		GPUShaderModule shader = device.createShaderModule(shaderDesc);
		if(shader.handle == 0)
			throw new NullPointerException("NULL ShaderModule");
		
		BlendState blend = new BlendState();
		blend.color.srcFactor = BlendFactor.SRC_ALPHA;
		blend.color.dstFactor = BlendFactor.ONE_MINUS_SRC_ALPHA;
		blend.color.operation = BlendOperation.ADD;
		
		blend.alpha.srcFactor = BlendFactor.ZERO;
		blend.alpha.dstFactor = BlendFactor.ONE;
		blend.alpha.operation = BlendOperation.ADD;
		
		ColorTargetState colorTarget = new ColorTargetState();
		colorTarget.format = surfaceFormat;
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
		if(pipeline.handle == 0)
			throw new NullPointerException("NULL RenderPipeline");

		shader.release();
	}

	private static void runMainLoop() {
		var encoderDesc = new CommandEncoderDescriptor();
		encoderDesc.label = "My Encoder";

		var cbuffDesc = new CommandBufferDescriptor();
		cbuffDesc.label = "My Command buffer";

		var colorAttachment = new RenderPassColorAttachment();
		colorAttachment.loadOp = LoadOp.CLEAR;
		colorAttachment.storeOp = StoreOp.STORE;
		colorAttachment.clearValue = new Color(0.9, 0.1, 0.2, 1.0);
		colorAttachment.depthSlice = 0xFFff_ffFF;

		var renderPassDesc = new RenderPassDescriptor();
		renderPassDesc.colorAttachments = new RenderPassColorAttachment[] { colorAttachment };
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
		GPUCommandEncoder encoder = new GPUCommandEncoder();
		GPURenderPassEncoder renderPass = new GPURenderPassEncoder();
		GPUCommandBuffer[] commands = { new GPUCommandBuffer() };
		
		while (!glfwWindowShouldClose(window)) {
			
			surface.getCurrentTexture(surfaceTexture);
			if(surfaceTexture.status != SurfaceGetCurrentTextureStatus.SUCCESS)
				throw new RuntimeException("Surface Texture status: " + surfaceTexture.status);
			
			if(surfaceTexture.suboptimal) {
				System.out.println("Surface Texture is suboptimal :(");
			}
			
			textViewDesc.format = surfaceTexture.texture.getFormat();
			
			
			colorAttachment.view.handle = surfaceTexture.texture.createView0(textViewDesc);
			encoder.handle = device.createCommandEncoder0(encoderDesc);
			renderPass.handle = encoder.beginRenderPass0(renderPassDesc);
			colorAttachment.view.release();
			
			renderPass.setPipeline(pipeline);
			
			// draw
			renderPass.draw(3, 1, 0, 0);
			
			renderPass.end();
			renderPass.release();
			
			commands[0].handle = encoder.finish0(cbuffDesc);
			queue.submit(commands);
			commands[0].release();
			encoder.release();
			

			
			surface.present();
			
			device.poll(false, null);
			
		    glfwPollEvents();
		}
	}

	private static void cleanup() {
		pipeline.release();
		queue.release();
		device.release();
		instance.release();
	}

}
