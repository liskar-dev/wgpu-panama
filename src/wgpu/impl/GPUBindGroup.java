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

public class GPUBindGroup extends GPUObject {

	public GPUBindGroup(long handle) {
		super(handle);
	}

	public GPUBindGroup() {
		super();
	}

	public void setLabel(final String label) {
		wgpuBindGroupSetLabel(this.handle, label);
	}

	public void release() {
		wgpuBindGroupRelease(this.handle);
		this.handle = 0;
	}
}
