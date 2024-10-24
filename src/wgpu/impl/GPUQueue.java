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

public class GPUQueue extends GPUObject {

	public GPUQueue(long handle) {
		super(handle);
	}

	public GPUQueue() {
		super();
	}

	public void onSubmittedWorkDone(final QueueOnSubmittedWorkDoneCallback callback, final long userdata) {
		wgpuQueueOnSubmittedWorkDone(this.handle, callback, userdata);
	}

	public void setLabel(final String label) {
		wgpuQueueSetLabel(this.handle, label);
	}

	public void submit(final GPUCommandBuffer[] commands) {
		wgpuQueueSubmit(this.handle, commands);
	}

	public void writeBuffer(final GPUBuffer buffer, final long bufferOffset, final MemorySegment data) {
		wgpuQueueWriteBuffer(this.handle, buffer.handle, bufferOffset, data);
	}

	public void writeTexture(final ImageCopyTexture destination, final MemorySegment data, final TextureDataLayout dataLayout, final Extent3D writeSize) {
		wgpuQueueWriteTexture(this.handle, destination, data, dataLayout, writeSize);
	}

	public void release() {
		wgpuQueueRelease(this.handle);
		this.handle = 0;
	}

	public long submitForIndex(final GPUCommandBuffer[] commands) {
		return wgpuQueueSubmitForIndex(this.handle, commands);
	}
}
