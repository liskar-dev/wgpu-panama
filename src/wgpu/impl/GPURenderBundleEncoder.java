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

public class GPURenderBundleEncoder extends GPUObject {

	public GPURenderBundleEncoder(long handle) {
		super(handle);
	}

	public GPURenderBundleEncoder() {
		super();
	}

	public void draw(final int vertexCount, final int instanceCount, final int firstVertex, final int firstInstance) {
		wgpuRenderBundleEncoderDraw(this.handle, vertexCount, instanceCount, firstVertex, firstInstance);
	}

	public void drawIndexed(final int indexCount, final int instanceCount, final int firstIndex, final int baseVertex, final int firstInstance) {
		wgpuRenderBundleEncoderDrawIndexed(this.handle, indexCount, instanceCount, firstIndex, baseVertex, firstInstance);
	}

	public void drawIndexedIndirect(final GPUBuffer indirectBuffer, final long indirectOffset) {
		wgpuRenderBundleEncoderDrawIndexedIndirect(this.handle, indirectBuffer.handle, indirectOffset);
	}

	public void drawIndirect(final GPUBuffer indirectBuffer, final long indirectOffset) {
		wgpuRenderBundleEncoderDrawIndirect(this.handle, indirectBuffer.handle, indirectOffset);
	}

	public GPURenderBundle finish(@Nullable final RenderBundleDescriptor descriptor) {
		return new GPURenderBundle(wgpuRenderBundleEncoderFinish(this.handle, descriptor));
	}

	public long finish0(@Nullable final RenderBundleDescriptor descriptor) {
		return wgpuRenderBundleEncoderFinish(this.handle, descriptor);
	}

	public void insertDebugMarker(final String markerLabel) {
		wgpuRenderBundleEncoderInsertDebugMarker(this.handle, markerLabel);
	}

	public void popDebugGroup() {
		wgpuRenderBundleEncoderPopDebugGroup(this.handle);
	}

	public void pushDebugGroup(final String groupLabel) {
		wgpuRenderBundleEncoderPushDebugGroup(this.handle, groupLabel);
	}

	public void setBindGroup(final int groupIndex, @Nullable final GPUBindGroup group, final int[] dynamicOffsets) {
		wgpuRenderBundleEncoderSetBindGroup(this.handle, groupIndex, group.handle, dynamicOffsets);
	}

	public void setIndexBuffer(final GPUBuffer buffer, final IndexFormat format, final long offset, final long size) {
		wgpuRenderBundleEncoderSetIndexBuffer(this.handle, buffer.handle, format, offset, size);
	}

	public void setLabel(final String label) {
		wgpuRenderBundleEncoderSetLabel(this.handle, label);
	}

	public void setPipeline(final GPURenderPipeline pipeline) {
		wgpuRenderBundleEncoderSetPipeline(this.handle, pipeline.handle);
	}

	public void setVertexBuffer(final int slot, @Nullable final GPUBuffer buffer, final long offset, final long size) {
		wgpuRenderBundleEncoderSetVertexBuffer(this.handle, slot, buffer.handle, offset, size);
	}

	public void release() {
		wgpuRenderBundleEncoderRelease(this.handle);
		this.handle = 0;
	}
}
