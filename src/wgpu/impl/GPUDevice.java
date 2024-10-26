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

public class GPUDevice extends GPUObject {

	public GPUDevice(long handle) {
		super(handle);
	}

	public GPUDevice() {
		super();
	}

	public long getProcAddress(final String procName) {
		return wgpuGetProcAddress(this.handle, procName);
	}

	public GPUBindGroup createBindGroup(final BindGroupDescriptor descriptor) {
		return new GPUBindGroup(wgpuDeviceCreateBindGroup(this.handle, descriptor));
	}

	public long createBindGroup0(final BindGroupDescriptor descriptor) {
		return wgpuDeviceCreateBindGroup(this.handle, descriptor);
	}

	public GPUBindGroupLayout createBindGroupLayout(final BindGroupLayoutDescriptor descriptor) {
		return new GPUBindGroupLayout(wgpuDeviceCreateBindGroupLayout(this.handle, descriptor));
	}

	public long createBindGroupLayout0(final BindGroupLayoutDescriptor descriptor) {
		return wgpuDeviceCreateBindGroupLayout(this.handle, descriptor);
	}

	public GPUBuffer createBuffer(final BufferDescriptor descriptor) {
		return new GPUBuffer(wgpuDeviceCreateBuffer(this.handle, descriptor));
	}

	public long createBuffer0(final BufferDescriptor descriptor) {
		return wgpuDeviceCreateBuffer(this.handle, descriptor);
	}

	public GPUCommandEncoder createCommandEncoder(@Nullable final CommandEncoderDescriptor descriptor) {
		return new GPUCommandEncoder(wgpuDeviceCreateCommandEncoder(this.handle, descriptor));
	}

	public long createCommandEncoder0(@Nullable final CommandEncoderDescriptor descriptor) {
		return wgpuDeviceCreateCommandEncoder(this.handle, descriptor);
	}

	public GPUComputePipeline createComputePipeline(final ComputePipelineDescriptor descriptor) {
		return new GPUComputePipeline(wgpuDeviceCreateComputePipeline(this.handle, descriptor));
	}

	public long createComputePipeline0(final ComputePipelineDescriptor descriptor) {
		return wgpuDeviceCreateComputePipeline(this.handle, descriptor);
	}

	public void createComputePipelineAsync(final ComputePipelineDescriptor descriptor, final DeviceCreateComputePipelineAsyncCallback callback, final long userdata) {
		wgpuDeviceCreateComputePipelineAsync(this.handle, descriptor, callback, userdata);
	}

	public GPUPipelineLayout createPipelineLayout(final PipelineLayoutDescriptor descriptor) {
		return new GPUPipelineLayout(wgpuDeviceCreatePipelineLayout(this.handle, descriptor));
	}

	public long createPipelineLayout0(final PipelineLayoutDescriptor descriptor) {
		return wgpuDeviceCreatePipelineLayout(this.handle, descriptor);
	}

	public GPUQuerySet createQuerySet(final QuerySetDescriptor descriptor) {
		return new GPUQuerySet(wgpuDeviceCreateQuerySet(this.handle, descriptor));
	}

	public long createQuerySet0(final QuerySetDescriptor descriptor) {
		return wgpuDeviceCreateQuerySet(this.handle, descriptor);
	}

	public GPURenderBundleEncoder createRenderBundleEncoder(final RenderBundleEncoderDescriptor descriptor) {
		return new GPURenderBundleEncoder(wgpuDeviceCreateRenderBundleEncoder(this.handle, descriptor));
	}

	public long createRenderBundleEncoder0(final RenderBundleEncoderDescriptor descriptor) {
		return wgpuDeviceCreateRenderBundleEncoder(this.handle, descriptor);
	}

	public GPURenderPipeline createRenderPipeline(final RenderPipelineDescriptor descriptor) {
		return new GPURenderPipeline(wgpuDeviceCreateRenderPipeline(this.handle, descriptor));
	}

	public long createRenderPipeline0(final RenderPipelineDescriptor descriptor) {
		return wgpuDeviceCreateRenderPipeline(this.handle, descriptor);
	}

	public void createRenderPipelineAsync(final RenderPipelineDescriptor descriptor, final DeviceCreateRenderPipelineAsyncCallback callback, final long userdata) {
		wgpuDeviceCreateRenderPipelineAsync(this.handle, descriptor, callback, userdata);
	}

	public GPUSampler createSampler(@Nullable final SamplerDescriptor descriptor) {
		return new GPUSampler(wgpuDeviceCreateSampler(this.handle, descriptor));
	}

	public long createSampler0(@Nullable final SamplerDescriptor descriptor) {
		return wgpuDeviceCreateSampler(this.handle, descriptor);
	}

	public GPUShaderModule createShaderModule(final ShaderModuleDescriptor descriptor) {
		return new GPUShaderModule(wgpuDeviceCreateShaderModule(this.handle, descriptor));
	}

	public long createShaderModule0(final ShaderModuleDescriptor descriptor) {
		return wgpuDeviceCreateShaderModule(this.handle, descriptor);
	}

	public GPUTexture createTexture(final TextureDescriptor descriptor) {
		return new GPUTexture(wgpuDeviceCreateTexture(this.handle, descriptor));
	}

	public long createTexture0(final TextureDescriptor descriptor) {
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

	public GPUQueue getQueue() {
		return new GPUQueue(wgpuDeviceGetQueue(this.handle));
	}

	public long getQueue0() {
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

	public FeatureName[] enumerateFeatures() {
		int num = (int) wgpuDeviceEnumerateFeatures(this.handle, null);
		FeatureName[] features = new FeatureName[num];
		wgpuDeviceEnumerateFeatures(this.handle, features);
		return features;
	}

}
