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

public class WGPUComputePipeline extends WGPUImpl {
	public WGPUComputePipeline(long handle) {
		super(handle);
	}

	public WGPUBindGroupLayout getBindGroupLayout(final int groupIndex) {
		return new WGPUBindGroupLayout(wgpuComputePipelineGetBindGroupLayout(this.handle, groupIndex));
	}

	public long getBindGroupLayout0(final int groupIndex) {
		return wgpuComputePipelineGetBindGroupLayout(this.handle, groupIndex);
	}

	public void setLabel(final String label) {
		wgpuComputePipelineSetLabel(this.handle, label);
	}

	public void release() {
		wgpuComputePipelineRelease(this.handle);
		this.handle = 0;
	}
}
