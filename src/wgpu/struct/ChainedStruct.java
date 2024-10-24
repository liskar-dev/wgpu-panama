package wgpu.struct;

import wgpu.*;
import wgpu.impl.*;
import wgpu.struct.*;
import wgpu.enums.*;
import wgpu.callback.*;

import java.lang.foreign.*;
import org.jspecify.annotations.*;

import static java.lang.foreign.ValueLayout.*;
import static java.lang.foreign.MemoryLayout.*;

public abstract class ChainedStruct extends WGPUStruct {
	public ChainedStruct next;
	// SType sType;
	// padding 4

	private static ChainedStruct from(int sType) {
		return switch(sType) {
			case SType.PrimitiveDepthClipControl -> new PrimitiveDepthClipControl();
			case SType.RenderPassDescriptorMaxDrawCount -> new RenderPassDescriptorMaxDrawCount();
			case SType.ShaderModuleSPIRVDescriptor -> new ShaderModuleSPIRVDescriptor();
			case SType.ShaderModuleWGSLDescriptor -> new ShaderModuleWGSLDescriptor();
			case SType.SurfaceDescriptorFromAndroidNativeWindow -> new SurfaceDescriptorFromAndroidNativeWindow();
			case SType.SurfaceDescriptorFromCanvasHTMLSelector -> new SurfaceDescriptorFromCanvasHTMLSelector();
			case SType.SurfaceDescriptorFromMetalLayer -> new SurfaceDescriptorFromMetalLayer();
			case SType.SurfaceDescriptorFromWaylandSurface -> new SurfaceDescriptorFromWaylandSurface();
			case SType.SurfaceDescriptorFromWindowsHWND -> new SurfaceDescriptorFromWindowsHWND();
			case SType.SurfaceDescriptorFromXcbWindow -> new SurfaceDescriptorFromXcbWindow();
			case SType.SurfaceDescriptorFromXlibWindow -> new SurfaceDescriptorFromXlibWindow();
			case SType.InstanceExtras -> new InstanceExtras();
			case SType.DeviceExtras -> new DeviceExtras();
			case SType.RequiredLimitsExtras -> new RequiredLimitsExtras();
			case SType.PipelineLayoutExtras -> new PipelineLayoutExtras();
			case SType.ShaderModuleGLSLDescriptor -> new ShaderModuleGLSLDescriptor();
			case SType.BindGroupEntryExtras -> new BindGroupEntryExtras();
			case SType.BindGroupLayoutEntryExtras -> new BindGroupLayoutEntryExtras();
			case SType.QuerySetDescriptorExtras -> new QuerySetDescriptorExtras();
			case SType.SurfaceConfigurationExtras -> new SurfaceConfigurationExtras();
			default -> null;
		};
	}

	protected static ChainedStruct from(long address) {
		if(address == 0L) return null;
		var struct = from(get_int(address + 8));
		struct.load(address);
		return struct;
	}

}
