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

public class GPUShaderModule extends GPUObject {

	public GPUShaderModule(long handle) {
		super(handle);
	}

	public GPUShaderModule() {
		super();
	}

	public void getCompilationInfo(final ShaderModuleGetCompilationInfoCallback callback, final long userdata) {
		wgpuShaderModuleGetCompilationInfo(this.handle, callback, userdata);
	}

	public void setLabel(final String label) {
		wgpuShaderModuleSetLabel(this.handle, label);
	}

	public void release() {
		wgpuShaderModuleRelease(this.handle);
		this.handle = 0;
	}
}
