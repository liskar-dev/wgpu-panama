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

public class WGPURenderBundleEncoder extends WGPUImpl {
	public WGPURenderBundleEncoder(long handle) {
		super(handle);
	}

	public void draw(final int vertexCount, final int instanceCount, final int firstVertex, final int firstInstance) {
		wgpuRenderBundleEncoderDraw(this.handle, vertexCount, instanceCount, firstVertex, firstInstance);
	}

	public void drawIndexed(final int indexCount, final int instanceCount, final int firstIndex, final int baseVertex, final int firstInstance) {
		wgpuRenderBundleEncoderDrawIndexed(this.handle, indexCount, instanceCount, firstIndex, baseVertex, firstInstance);
	}

	public void drawIndexedIndirect(final WGPUBuffer indirectBuffer, final long indirectOffset) {
		wgpuRenderBundleEncoderDrawIndexedIndirect(this.handle, indirectBuffer.handle, indirectOffset);
	}

	public void drawIndirect(final WGPUBuffer indirectBuffer, final long indirectOffset) {
		wgpuRenderBundleEncoderDrawIndirect(this.handle, indirectBuffer.handle, indirectOffset);
	}

	public WGPURenderBundle finish(@Nullable final RenderBundleDescriptor descriptor) {
		return new WGPURenderBundle(wgpuRenderBundleEncoderFinish(this.handle, descriptor));
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

	public void setBindGroup(final int groupIndex, @Nullable final WGPUBindGroup group, final int[] dynamicOffsets) {
		wgpuRenderBundleEncoderSetBindGroup(this.handle, groupIndex, group.handle, dynamicOffsets);
	}

	public void setIndexBuffer(final WGPUBuffer buffer, final IndexFormat format, final long offset, final long size) {
		wgpuRenderBundleEncoderSetIndexBuffer(this.handle, buffer.handle, format, offset, size);
	}

	public void setLabel(final String label) {
		wgpuRenderBundleEncoderSetLabel(this.handle, label);
	}

	public void setPipeline(final WGPURenderPipeline pipeline) {
		wgpuRenderBundleEncoderSetPipeline(this.handle, pipeline.handle);
	}

	public void setVertexBuffer(final int slot, @Nullable final WGPUBuffer buffer, final long offset, final long size) {
		wgpuRenderBundleEncoderSetVertexBuffer(this.handle, slot, buffer.handle, offset, size);
	}

	public void release() {
		wgpuRenderBundleEncoderRelease(this.handle);
		this.handle = 0;
	}
}
