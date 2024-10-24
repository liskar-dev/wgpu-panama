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

public class GPUCommandEncoder extends GPUObject {

	public GPUCommandEncoder(long handle) {
		super(handle);
	}

	public GPUCommandEncoder() {
		super();
	}

	public GPUComputePassEncoder beginComputePass(@Nullable final ComputePassDescriptor descriptor) {
		return new GPUComputePassEncoder(wgpuCommandEncoderBeginComputePass(this.handle, descriptor));
	}

	public long beginComputePass0(@Nullable final ComputePassDescriptor descriptor) {
		return wgpuCommandEncoderBeginComputePass(this.handle, descriptor);
	}

	public GPURenderPassEncoder beginRenderPass(final RenderPassDescriptor descriptor) {
		return new GPURenderPassEncoder(wgpuCommandEncoderBeginRenderPass(this.handle, descriptor));
	}

	public long beginRenderPass0(final RenderPassDescriptor descriptor) {
		return wgpuCommandEncoderBeginRenderPass(this.handle, descriptor);
	}

	public void clearBuffer(final GPUBuffer buffer, final long offset, final long size) {
		wgpuCommandEncoderClearBuffer(this.handle, buffer.handle, offset, size);
	}

	public void copyBufferToBuffer(final GPUBuffer source, final long sourceOffset, final GPUBuffer destination, final long destinationOffset, final long size) {
		wgpuCommandEncoderCopyBufferToBuffer(this.handle, source.handle, sourceOffset, destination.handle, destinationOffset, size);
	}

	public void copyBufferToTexture(final ImageCopyBuffer source, final ImageCopyTexture destination, final Extent3D copySize) {
		wgpuCommandEncoderCopyBufferToTexture(this.handle, source, destination, copySize);
	}

	public void copyTextureToBuffer(final ImageCopyTexture source, final ImageCopyBuffer destination, final Extent3D copySize) {
		wgpuCommandEncoderCopyTextureToBuffer(this.handle, source, destination, copySize);
	}

	public void copyTextureToTexture(final ImageCopyTexture source, final ImageCopyTexture destination, final Extent3D copySize) {
		wgpuCommandEncoderCopyTextureToTexture(this.handle, source, destination, copySize);
	}

	public GPUCommandBuffer finish(@Nullable final CommandBufferDescriptor descriptor) {
		return new GPUCommandBuffer(wgpuCommandEncoderFinish(this.handle, descriptor));
	}

	public long finish0(@Nullable final CommandBufferDescriptor descriptor) {
		return wgpuCommandEncoderFinish(this.handle, descriptor);
	}

	public void insertDebugMarker(final String markerLabel) {
		wgpuCommandEncoderInsertDebugMarker(this.handle, markerLabel);
	}

	public void popDebugGroup() {
		wgpuCommandEncoderPopDebugGroup(this.handle);
	}

	public void pushDebugGroup(final String groupLabel) {
		wgpuCommandEncoderPushDebugGroup(this.handle, groupLabel);
	}

	public void resolveQuerySet(final GPUQuerySet querySet, final int firstQuery, final int queryCount, final GPUBuffer destination, final long destinationOffset) {
		wgpuCommandEncoderResolveQuerySet(this.handle, querySet.handle, firstQuery, queryCount, destination.handle, destinationOffset);
	}

	public void setLabel(final String label) {
		wgpuCommandEncoderSetLabel(this.handle, label);
	}

	public void writeTimestamp(final GPUQuerySet querySet, final int queryIndex) {
		wgpuCommandEncoderWriteTimestamp(this.handle, querySet.handle, queryIndex);
	}

	public void release() {
		wgpuCommandEncoderRelease(this.handle);
		this.handle = 0;
	}
}
