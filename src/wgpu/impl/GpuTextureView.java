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

public class GPUTextureView extends GPUObject {

	public GPUTextureView(long handle) {
		super(handle);
	}

	public GPUTextureView() {
		super();
	}

	public void setLabel(final String label) {
		wgpuTextureViewSetLabel(this.handle, label);
	}

	public void release() {
		wgpuTextureViewRelease(this.handle);
		this.handle = 0;
	}
}
