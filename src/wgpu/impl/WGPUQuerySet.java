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

public class WGPUQuerySet extends WGPUImpl {
	public WGPUQuerySet(long handle) {
		super(handle);
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
