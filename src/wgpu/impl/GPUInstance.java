package wgpu.impl;

import wgpu.*;
import wgpu.impl.*;
import wgpu.struct.*;
import wgpu.enums.*;
import wgpu.callback.*;

import java.lang.foreign.*;
import org.jspecify.annotations.*;

import static java.lang.foreign.ValueLayout.*;
import static java.lang.foreign.MemoryLayout.*;

import static wgpu.WGPU.*;

public class GPUInstance extends GPUObject {

	public GPUInstance(long handle) {
		super(handle);
	}

	public GPUInstance() {
		super();
	}

	public GPUSurface createSurface(final SurfaceDescriptor descriptor) {
		return new GPUSurface(wgpuInstanceCreateSurface(this.handle, descriptor));
	}

	public long createSurface0(final SurfaceDescriptor descriptor) {
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

	public void generateReport(GlobalReport report) {
		wgpuGenerateReport(this.handle, report);
	}

	public long enumerateAdapters(@Nullable final InstanceEnumerateAdapterOptions options, GPUAdapter[] adapters) {
		return wgpuInstanceEnumerateAdapters(this.handle, options, adapters);
	}
}
