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

public class GPUBindGroupLayout extends GPUObject {

	public GPUBindGroupLayout(long handle) {
		super(handle);
	}

	public GPUBindGroupLayout() {
		super();
	}

	public void setLabel(final String label) {
		wgpuBindGroupLayoutSetLabel(this.handle, label);
	}

	public void release() {
		wgpuBindGroupLayoutRelease(this.handle);
		this.handle = 0;
	}
}
