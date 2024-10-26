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

public class GPUAdapter extends GPUObject {

	public GPUAdapter(long handle) {
		super(handle);
	}

	public GPUAdapter() {
		super();
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

	public GPUDevice requestDevice(@Nullable final DeviceDescriptor descriptor) {
		var callback = new AdapterRequestDeviceCallback() {
			RequestDeviceStatus status;
			GPUDevice device;
			String message;
			@Override
			public void apply(RequestDeviceStatus _status, GPUDevice _device, String _message, long userdata) {
				status = _status;
				device = _device;
				message = _message;
			}
		};

		wgpuAdapterRequestDevice(this.handle, descriptor, callback, 0L);

		if(callback.status != RequestDeviceStatus.SUCCESS) {
			throw new RuntimeException(callback.message);
		}

		return callback.device;
	}

	public FeatureName[] enumerateFeatures() {
		int num = (int) wgpuAdapterEnumerateFeatures(this.handle, null);
		FeatureName[] features = new FeatureName[num];
		wgpuAdapterEnumerateFeatures(this.handle, features);
		return features;
	}

}
