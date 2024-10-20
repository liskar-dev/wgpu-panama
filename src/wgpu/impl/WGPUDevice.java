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

public class WGPUDevice extends WGPUImpl {
	public WGPUDevice(long handle) {
		super(handle);
	}

	public long cAddress(final String procName) {
		return wgpuGetProcAddress(this.handle, procName);
	}

	public long createBindGroup(final BindGroupDescriptor descriptor) {
		return wgpuDeviceCreateBindGroup(this.handle, descriptor);
	}

	public long createBindGroupLayout(final BindGroupLayoutDescriptor descriptor) {
		return wgpuDeviceCreateBindGroupLayout(this.handle, descriptor);
	}

	public long createBuffer(final BufferDescriptor descriptor) {
		return wgpuDeviceCreateBuffer(this.handle, descriptor);
	}

	public long createCommandEncoder(@Nullable final CommandEncoderDescriptor descriptor) {
		return wgpuDeviceCreateCommandEncoder(this.handle, descriptor);
	}

	public long createComputePipeline(final ComputePipelineDescriptor descriptor) {
		return wgpuDeviceCreateComputePipeline(this.handle, descriptor);
	}

	public void createComputePipelineAsync(final ComputePipelineDescriptor descriptor, final DeviceCreateComputePipelineAsyncCallback callback, final long userdata) {
		wgpuDeviceCreateComputePipelineAsync(this.handle, descriptor, callback, userdata);
	}

	public long createPipelineLayout(final PipelineLayoutDescriptor descriptor) {
		return wgpuDeviceCreatePipelineLayout(this.handle, descriptor);
	}

	public long createQuerySet(final QuerySetDescriptor descriptor) {
		return wgpuDeviceCreateQuerySet(this.handle, descriptor);
	}

	public long createRenderBundleEncoder(final RenderBundleEncoderDescriptor descriptor) {
		return wgpuDeviceCreateRenderBundleEncoder(this.handle, descriptor);
	}

	public long createRenderPipeline(final RenderPipelineDescriptor descriptor) {
		return wgpuDeviceCreateRenderPipeline(this.handle, descriptor);
	}

	public void createRenderPipelineAsync(final RenderPipelineDescriptor descriptor, final DeviceCreateRenderPipelineAsyncCallback callback, final long userdata) {
		wgpuDeviceCreateRenderPipelineAsync(this.handle, descriptor, callback, userdata);
	}

	public long createSampler(@Nullable final SamplerDescriptor descriptor) {
		return wgpuDeviceCreateSampler(this.handle, descriptor);
	}

	public long createShaderModule(final ShaderModuleDescriptor descriptor) {
		return wgpuDeviceCreateShaderModule(this.handle, descriptor);
	}

	public long createTexture(final TextureDescriptor descriptor) {
		return wgpuDeviceCreateTexture(this.handle, descriptor);
	}

	public void destroy() {
		wgpuDeviceDestroy(this.handle);
	}

	public long enumerateFeatures(FeatureName[] features) {
		return wgpuDeviceEnumerateFeatures(this.handle, features);
	}

	public boolean getLimits(SupportedLimits limits) {
		return wgpuDeviceGetLimits(this.handle, limits);
	}

	public long getQueue() {
		return wgpuDeviceGetQueue(this.handle);
	}

	public boolean hasFeature(final FeatureName feature) {
		return wgpuDeviceHasFeature(this.handle, feature);
	}

	public void popErrorScope(final ErrorCallback callback, final long userdata) {
		wgpuDevicePopErrorScope(this.handle, callback, userdata);
	}

	public void pushErrorScope(final ErrorFilter filter) {
		wgpuDevicePushErrorScope(this.handle, filter);
	}

	public void setLabel(final String label) {
		wgpuDeviceSetLabel(this.handle, label);
	}

	public void release() {
		wgpuDeviceRelease(this.handle);
		this.handle = 0;
	}

	public boolean poll(final boolean wait, @Nullable final WrappedSubmissionIndex wrappedSubmissionIndex) {
		return wgpuDevicePoll(this.handle, wait, wrappedSubmissionIndex);
	}
}
