package wgpu.impl;

import wgpu.*;
import wgpu.impl.*;
import wgpu.struct.*;
import wgpu.enums.*;
import wgpu.callback.*;
import static wgpu.StaticHelpers.*;

import java.lang.foreign.*;
import org.jspecify.annotations.*;

import static java.lang.foreign.ValueLayout.*;
import static java.lang.foreign.MemoryLayout.*;

import static wgpu.WebGPU.*;

public class WGPUInstance extends WGPUImpl {
	public WGPUInstance(long handle) {
		super(handle);
	}

	public long createSurface(final SurfaceDescriptor descriptor) {
		return wgpuInstanceCreateSurface(this.handle, descriptor);
	}

	public boolean hasWGSLLanguageFeature(final WGSLFeatureName feature) {
		return wgpuInstanceHasWGSLLanguageFeature(this.handle, feature);
	}

	public void processEvents() {
		wgpuInstanceProcessEvents(this.handle);
	}

	public void requestAdapter(@Nullable final RequestAdapterOptions options, final InstanceRequestAdapterCallback callback, final long userdata) {
		wgpuInstanceRequestAdapter(this.handle, options, callback, userdata);
	}

	public void release() {
		wgpuInstanceRelease(this.handle);
		this.handle = 0;
	}

	public void report(GlobalReport report) {
		wgpuGenerateReport(this.handle, report);
	}

	public long enumerateAdapters(@Nullable final InstanceEnumerateAdapterOptions options, WGPUAdapter[] adapters) {
		return wgpuInstanceEnumerateAdapters(this.handle, options, adapters);
	}
}
