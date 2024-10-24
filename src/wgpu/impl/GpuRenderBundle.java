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

public class GPURenderBundle extends GPUObject {

	public GPURenderBundle(long handle) {
		super(handle);
	}

	public GPURenderBundle() {
		super();
	}

	public void setLabel(final String label) {
		wgpuRenderBundleSetLabel(this.handle, label);
	}

	public void release() {
		wgpuRenderBundleRelease(this.handle);
		this.handle = 0;
	}
}
