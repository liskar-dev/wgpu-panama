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

public class GPURenderPipeline extends GPUObject {

	public GPURenderPipeline(long handle) {
		super(handle);
	}

	public GPURenderPipeline() {
		super();
	}

	public GPUBindGroupLayout getBindGroupLayout(final int groupIndex) {
		return new GPUBindGroupLayout(wgpuRenderPipelineGetBindGroupLayout(this.handle, groupIndex));
	}

	public long getBindGroupLayout0(final int groupIndex) {
		return wgpuRenderPipelineGetBindGroupLayout(this.handle, groupIndex);
	}

	public void setLabel(final String label) {
		wgpuRenderPipelineSetLabel(this.handle, label);
	}

	public void release() {
		wgpuRenderPipelineRelease(this.handle);
		this.handle = 0;
	}
}
