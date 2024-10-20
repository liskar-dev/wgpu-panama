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

public class WGPUSurface extends WGPUImpl {
	public WGPUSurface(long handle) {
		super(handle);
	}

	public void configure(final SurfaceConfiguration config) {
		wgpuSurfaceConfigure(this.handle, config);
	}

	public void getCapabilities(final WGPUAdapter adapter, SurfaceCapabilities capabilities) {
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
