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

public class GPUQuerySet extends GPUObject {

	public GPUQuerySet(long handle) {
		super(handle);
	}

	public GPUQuerySet() {
		super();
	}

	public void destroy() {
		wgpuQuerySetDestroy(this.handle);
	}

	public int getCount() {
		return wgpuQuerySetGetCount(this.handle);
	}

	public QueryType getType() {
		return wgpuQuerySetGetType(this.handle);
	}

	public void setLabel(final String label) {
		wgpuQuerySetSetLabel(this.handle, label);
	}

	public void release() {
		wgpuQuerySetRelease(this.handle);
		this.handle = 0;
	}
}
