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

public class GPUSurface extends GPUObject {

	public GPUSurface(long handle) {
		super(handle);
	}

	public GPUSurface() {
		super();
	}

	public void configure(final SurfaceConfiguration config) {
		wgpuSurfaceConfigure(this.handle, config);
	}

	public void getCapabilities(final GPUAdapter adapter, SurfaceCapabilities capabilities) {
		wgpuSurfaceGetCapabilities(this.handle, adapter.handle, capabilities);
	}

	public void getCurrentTexture(SurfaceTexture surfaceTexture) {
		wgpuSurfaceGetCurrentTexture(this.handle, surfaceTexture);
	}

	public void present() {
		wgpuSurfacePresent(this.handle);
	}

	public void setLabel(final String label) {
		wgpuSurfaceSetLabel(this.handle, label);
	}

	public void unconfigure() {
		wgpuSurfaceUnconfigure(this.handle);
	}

	public void release() {
		wgpuSurfaceRelease(this.handle);
		this.handle = 0;
	}
}
