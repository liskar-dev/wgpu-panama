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

public class WGPURenderPipeline extends WGPUImpl {
	public WGPURenderPipeline(long handle) {
		super(handle);
	}

	public long getBindGroupLayout(final int groupIndex) {
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
