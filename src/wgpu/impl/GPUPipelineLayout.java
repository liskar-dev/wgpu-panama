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

public class GPUPipelineLayout extends GPUObject {

	public GPUPipelineLayout(long handle) {
		super(handle);
	}

	public GPUPipelineLayout() {
		super();
	}

	public void setLabel(final String label) {
		wgpuPipelineLayoutSetLabel(this.handle, label);
	}

	public void release() {
		wgpuPipelineLayoutRelease(this.handle);
		this.handle = 0;
	}
}
