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

public class WGPUSampler extends WGPUImpl {
	public WGPUSampler(long handle) {
		super(handle);
	}

	public void setLabel(final String label) {
		wgpuSamplerSetLabel(this.handle, label);
	}

	public void release() {
		wgpuSamplerRelease(this.handle);
		this.handle = 0;
	}
}
