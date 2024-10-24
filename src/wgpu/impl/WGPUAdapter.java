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

import static wgpu.WebGPU.*;

public class WGPUAdapter extends WGPUImpl {
	public WGPUAdapter(long handle) {
		super(handle);
	}

	public long enumerateFeatures(FeatureName[] features) {
		return wgpuAdapterEnumerateFeatures(this.handle, features);
	}

	public void getInfo(AdapterInfo info) {
		wgpuAdapterGetInfo(this.handle, info);
	}

	public boolean getLimits(SupportedLimits limits) {
		return wgpuAdapterGetLimits(this.handle, limits);
	}

	public boolean hasFeature(final FeatureName feature) {
		return wgpuAdapterHasFeature(this.handle, feature);
	}

	public void requestDevice(@Nullable final DeviceDescriptor descriptor, final AdapterRequestDeviceCallback callback, final long userdata) {
		wgpuAdapterRequestDevice(this.handle, descriptor, callback, userdata);
	}

	public void release() {
		wgpuAdapterRelease(this.handle);
		this.handle = 0;
	}
}
