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

public class GPURenderPassEncoder extends GPUObject {

	public GPURenderPassEncoder(long handle) {
		super(handle);
	}

	public GPURenderPassEncoder() {
		super();
	}

	public void beginOcclusionQuery(final int queryIndex) {
		wgpuRenderPassEncoderBeginOcclusionQuery(this.handle, queryIndex);
	}

	public void draw(final int vertexCount, final int instanceCount, final int firstVertex, final int firstInstance) {
		wgpuRenderPassEncoderDraw(this.handle, vertexCount, instanceCount, firstVertex, firstInstance);
	}

	public void drawIndexed(final int indexCount, final int instanceCount, final int firstIndex, final int baseVertex, final int firstInstance) {
		wgpuRenderPassEncoderDrawIndexed(this.handle, indexCount, instanceCount, firstIndex, baseVertex, firstInstance);
	}

	public void drawIndexedIndirect(final GPUBuffer indirectBuffer, final long indirectOffset) {
		wgpuRenderPassEncoderDrawIndexedIndirect(this.handle, indirectBuffer.handle, indirectOffset);
	}

	public void drawIndirect(final GPUBuffer indirectBuffer, final long indirectOffset) {
		wgpuRenderPassEncoderDrawIndirect(this.handle, indirectBuffer.handle, indirectOffset);
	}

	public void end() {
		wgpuRenderPassEncoderEnd(this.handle);
	}

	public void endOcclusionQuery() {
		wgpuRenderPassEncoderEndOcclusionQuery(this.handle);
	}

	public void executeBundles(final GPURenderBundle[] bundles) {
		wgpuRenderPassEncoderExecuteBundles(this.handle, bundles);
	}

	public void insertDebugMarker(final String markerLabel) {
		wgpuRenderPassEncoderInsertDebugMarker(this.handle, markerLabel);
	}

	public void popDebugGroup() {
		wgpuRenderPassEncoderPopDebugGroup(this.handle);
	}

	public void pushDebugGroup(final String groupLabel) {
		wgpuRenderPassEncoderPushDebugGroup(this.handle, groupLabel);
	}

	public void setBindGroup(final int groupIndex, @Nullable final GPUBindGroup group, final int[] dynamicOffsets) {
		wgpuRenderPassEncoderSetBindGroup(this.handle, groupIndex, group.handle, dynamicOffsets);
	}

	public void setBlendConstant(final Color color) {
		wgpuRenderPassEncoderSetBlendConstant(this.handle, color);
	}

	public void setIndexBuffer(final GPUBuffer buffer, final IndexFormat format, final long offset, final long size) {
		wgpuRenderPassEncoderSetIndexBuffer(this.handle, buffer.handle, format, offset, size);
	}

	public void setLabel(final String label) {
		wgpuRenderPassEncoderSetLabel(this.handle, label);
	}

	public void setPipeline(final GPURenderPipeline pipeline) {
		wgpuRenderPassEncoderSetPipeline(this.handle, pipeline.handle);
	}

	public void setScissorRect(final int x, final int y, final int width, final int height) {
		wgpuRenderPassEncoderSetScissorRect(this.handle, x, y, width, height);
	}

	public void setStencilReference(final int reference) {
		wgpuRenderPassEncoderSetStencilReference(this.handle, reference);
	}

	public void setVertexBuffer(final int slot, @Nullable final GPUBuffer buffer, final long offset, final long size) {
		wgpuRenderPassEncoderSetVertexBuffer(this.handle, slot, buffer.handle, offset, size);
	}

	public void setViewport(final float x, final float y, final float width, final float height, final float minDepth, final float maxDepth) {
		wgpuRenderPassEncoderSetViewport(this.handle, x, y, width, height, minDepth, maxDepth);
	}

	public void release() {
		wgpuRenderPassEncoderRelease(this.handle);
		this.handle = 0;
	}

	public void setPushConstants(final int stages, final int offset, final int sizeBytes, final MemorySegment data) {
		wgpuRenderPassEncoderSetPushConstants(this.handle, stages, offset, sizeBytes, data);
	}

	public void multiDrawIndirect(final GPUBuffer buffer, final long offset, final int count) {
		wgpuRenderPassEncoderMultiDrawIndirect(this.handle, buffer.handle, offset, count);
	}

	public void multiDrawIndexedIndirect(final GPUBuffer buffer, final long offset, final int count) {
		wgpuRenderPassEncoderMultiDrawIndexedIndirect(this.handle, buffer.handle, offset, count);
	}

	public void multiDrawIndirectCount(final GPUBuffer buffer, final long offset, final GPUBuffer count_buffer, final long count_buffer_offset, final int max_count) {
		wgpuRenderPassEncoderMultiDrawIndirectCount(this.handle, buffer.handle, offset, count_buffer.handle, count_buffer_offset, max_count);
	}

	public void multiDrawIndexedIndirectCount(final GPUBuffer buffer, final long offset, final GPUBuffer count_buffer, final long count_buffer_offset, final int max_count) {
		wgpuRenderPassEncoderMultiDrawIndexedIndirectCount(this.handle, buffer.handle, offset, count_buffer.handle, count_buffer_offset, max_count);
	}

	public void beginPipelineStatisticsQuery(final GPUQuerySet querySet, final int queryIndex) {
		wgpuRenderPassEncoderBeginPipelineStatisticsQuery(this.handle, querySet.handle, queryIndex);
	}

	public void endPipelineStatisticsQuery() {
		wgpuRenderPassEncoderEndPipelineStatisticsQuery(this.handle);
	}
}
