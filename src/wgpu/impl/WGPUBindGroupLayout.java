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

public class WGPUBindGroupLayout extends WGPUImpl {
	public WGPUBindGroupLayout(long handle) {
		super(handle);
	}

	public void setLabel(final String label) {
		wgpuBindGroupLayoutSetLabel(this.handle, label);
	}

	public void release() {
		wgpuBindGroupLayoutRelease(this.handle);
		this.handle = 0;
	}
}
