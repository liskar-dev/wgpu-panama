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

public class WGPUTextureView extends WGPUImpl {
	public WGPUTextureView(long handle) {
		super(handle);
	}

	public void setLabel(final String label) {
		wgpuTextureViewSetLabel(this.handle, label);
	}

	public void release() {
		wgpuTextureViewRelease(this.handle);
		this.handle = 0;
	}
}
