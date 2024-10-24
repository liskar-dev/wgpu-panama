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

public class GPUBuffer extends GPUObject {

	public GPUBuffer(long handle) {
		super(handle);
	}

	public GPUBuffer() {
		super();
	}

	public void destroy() {
		wgpuBufferDestroy(this.handle);
	}

	public MemorySegment getConstMappedRange(final long offset, final long size) {
		var addr = wgpuBufferGetConstMappedRange(this.handle, offset, size);
		return MemorySegment.ofAddress(addr).reinterpret(size);
	}

	public BufferMapState getMapState() {
		return wgpuBufferGetMapState(this.handle);
	}

	public MemorySegment getMappedRange(final long offset, final long size) {
		var addr = wgpuBufferGetMappedRange(this.handle, offset, size);
		return MemorySegment.ofAddress(addr).reinterpret(size);
	}

	public long getSize() {
		return wgpuBufferGetSize(this.handle);
	}

	public int getUsage() {
		return wgpuBufferGetUsage(this.handle);
	}

	public void mapAsync(final int mode, final long offset, final long size, final BufferMapAsyncCallback callback, final long userdata) {
		wgpuBufferMapAsync(this.handle, mode, offset, size, callback, userdata);
	}

	public void setLabel(final String label) {
		wgpuBufferSetLabel(this.handle, label);
	}

	public void unmap() {
		wgpuBufferUnmap(this.handle);
	}

	public void release() {
		wgpuBufferRelease(this.handle);
		this.handle = 0;
	}
}
