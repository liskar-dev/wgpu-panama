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

public class WGPUComputePassEncoder extends WGPUImpl {
	public WGPUComputePassEncoder(long handle) {
		super(handle);
	}

	public void dispatchWorkgroups(final int workgroupCountX, final int workgroupCountY, final int workgroupCountZ) {
		wgpuComputePassEncoderDispatchWorkgroups(this.handle, workgroupCountX, workgroupCountY, workgroupCountZ);
	}

	public void dispatchWorkgroupsIndirect(final WGPUBuffer indirectBuffer, final long indirectOffset) {
		wgpuComputePassEncoderDispatchWorkgroupsIndirect(this.handle, indirectBuffer.handle, indirectOffset);
	}

	public void end() {
		wgpuComputePassEncoderEnd(this.handle);
	}

	public void insertDebugMarker(final String markerLabel) {
		wgpuComputePassEncoderInsertDebugMarker(this.handle, markerLabel);
	}

	public void popDebugGroup() {
		wgpuComputePassEncoderPopDebugGroup(this.handle);
	}

	public void pushDebugGroup(final String groupLabel) {
		wgpuComputePassEncoderPushDebugGroup(this.handle, groupLabel);
	}

	public void setBindGroup(final int groupIndex, @Nullable final WGPUBindGroup group, final int[] dynamicOffsets) {
		wgpuComputePassEncoderSetBindGroup(this.handle, groupIndex, group.handle, dynamicOffsets);
	}

	public void setLabel(final String label) {
		wgpuComputePassEncoderSetLabel(this.handle, label);
	}

	public void setPipeline(final WGPUComputePipeline pipeline) {
		wgpuComputePassEncoderSetPipeline(this.handle, pipeline.handle);
	}

	public void release() {
		wgpuComputePassEncoderRelease(this.handle);
		this.handle = 0;
	}

	public void beginPipelineStatisticsQuery(final WGPUQuerySet querySet, final int queryIndex) {
		wgpuComputePassEncoderBeginPipelineStatisticsQuery(this.handle, querySet.handle, queryIndex);
	}

	public void endPipelineStatisticsQuery() {
		wgpuComputePassEncoderEndPipelineStatisticsQuery(this.handle);
	}
}
