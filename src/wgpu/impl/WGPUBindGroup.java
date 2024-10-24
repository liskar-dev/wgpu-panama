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

import static wgpu.WebGPU.*;

public class WGPUBindGroup extends WGPUImpl {
	public WGPUBindGroup(long handle) {
		super(handle);
	}

	public void setLabel(final String label) {
		wgpuBindGroupSetLabel(this.handle, label);
	}

	public void release() {
		wgpuBindGroupRelease(this.handle);
		this.handle = 0;
	}
}
