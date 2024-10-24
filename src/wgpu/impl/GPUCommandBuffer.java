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

public class GPUCommandBuffer extends GPUObject {

	public GPUCommandBuffer(long handle) {
		super(handle);
	}

	public GPUCommandBuffer() {
		super();
	}

	public void setLabel(final String label) {
		wgpuCommandBufferSetLabel(this.handle, label);
	}

	public void release() {
		wgpuCommandBufferRelease(this.handle);
		this.handle = 0;
	}
}
