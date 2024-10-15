package wgpu.struct;

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

public class Limits extends WGPUStruct {
	public int maxTextureDimension1D;
	public int maxTextureDimension2D;
	public int maxTextureDimension3D;
	public int maxTextureArrayLayers;
	public int maxBindGroups;
	public int maxBindGroupsPlusVertexBuffers;
	public int maxBindingsPerBindGroup;
	public int maxDynamicUniformBuffersPerPipelineLayout;
	public int maxDynamicStorageBuffersPerPipelineLayout;
	public int maxSampledTexturesPerShaderStage;
	public int maxSamplersPerShaderStage;
	public int maxStorageBuffersPerShaderStage;
	public int maxStorageTexturesPerShaderStage;
	public int maxUniformBuffersPerShaderStage;
	public long maxUniformBufferBindingSize;
	public long maxStorageBufferBindingSize;
	public int minUniformBufferOffsetAlignment;
	public int minStorageBufferOffsetAlignment;
	public int maxVertexBuffers;
	// padding 4
	public long maxBufferSize;
	public int maxVertexAttributes;
	public int maxVertexBufferArrayStride;
	public int maxInterStageShaderComponents;
	public int maxInterStageShaderVariables;
	public int maxColorAttachments;
	public int maxColorAttachmentBytesPerSample;
	public int maxComputeWorkgroupStorageSize;
	public int maxComputeInvocationsPerWorkgroup;
	public int maxComputeWorkgroupSizeX;
	public int maxComputeWorkgroupSizeY;
	public int maxComputeWorkgroupSizeZ;
	public int maxComputeWorkgroupsPerDimension;

	{
		maxTextureDimension1D = 8192;
		maxTextureDimension2D = 8192;
		maxTextureDimension3D = 2048;
		maxTextureArrayLayers = 256;
		maxBindGroups = 4;
		maxBindGroupsPlusVertexBuffers = 0;
		maxBindingsPerBindGroup = 1000;
		maxDynamicUniformBuffersPerPipelineLayout = 8;
		maxDynamicStorageBuffersPerPipelineLayout = 4;
		maxSampledTexturesPerShaderStage = 16;
		maxSamplersPerShaderStage = 16;
		maxStorageBuffersPerShaderStage = 8;
		maxStorageTexturesPerShaderStage = 4;
		maxUniformBuffersPerShaderStage = 12;
		maxUniformBufferBindingSize = 65536;
		maxStorageBufferBindingSize = 134217728;
		minUniformBufferOffsetAlignment = 256;
		minStorageBufferOffsetAlignment = 256;
		maxVertexBuffers = 8;
		maxBufferSize = 268435456;
		maxVertexAttributes = 16;
		maxVertexBufferArrayStride = 2048;
		maxInterStageShaderComponents = 60;
		maxInterStageShaderVariables = 0;
		maxColorAttachments = 0;
		maxColorAttachmentBytesPerSample = 0;
		maxComputeWorkgroupStorageSize = 16384;
		maxComputeInvocationsPerWorkgroup = 256;
		maxComputeWorkgroupSizeX = 256;
		maxComputeWorkgroupSizeY = 256;
		maxComputeWorkgroupSizeZ = 64;
		maxComputeWorkgroupsPerDimension = 65535;
	}

	protected static final int byteSize = 144;
	protected int byteSize() {
		return byteSize;
	}

	protected long store(Stack stack, long address) {
		put_value(address+0, (int) maxTextureDimension1D);
		put_value(address+4, (int) maxTextureDimension2D);
		put_value(address+8, (int) maxTextureDimension3D);
		put_value(address+12, (int) maxTextureArrayLayers);
		put_value(address+16, (int) maxBindGroups);
		put_value(address+20, (int) maxBindGroupsPlusVertexBuffers);
		put_value(address+24, (int) maxBindingsPerBindGroup);
		put_value(address+28, (int) maxDynamicUniformBuffersPerPipelineLayout);
		put_value(address+32, (int) maxDynamicStorageBuffersPerPipelineLayout);
		put_value(address+36, (int) maxSampledTexturesPerShaderStage);
		put_value(address+40, (int) maxSamplersPerShaderStage);
		put_value(address+44, (int) maxStorageBuffersPerShaderStage);
		put_value(address+48, (int) maxStorageTexturesPerShaderStage);
		put_value(address+52, (int) maxUniformBuffersPerShaderStage);
		put_value(address+56, (long) maxUniformBufferBindingSize);
		put_value(address+64, (long) maxStorageBufferBindingSize);
		put_value(address+72, (int) minUniformBufferOffsetAlignment);
		put_value(address+76, (int) minStorageBufferOffsetAlignment);
		put_value(address+80, (int) maxVertexBuffers);
		// padding 4
		put_value(address+88, (long) maxBufferSize);
		put_value(address+96, (int) maxVertexAttributes);
		put_value(address+100, (int) maxVertexBufferArrayStride);
		put_value(address+104, (int) maxInterStageShaderComponents);
		put_value(address+108, (int) maxInterStageShaderVariables);
		put_value(address+112, (int) maxColorAttachments);
		put_value(address+116, (int) maxColorAttachmentBytesPerSample);
		put_value(address+120, (int) maxComputeWorkgroupStorageSize);
		put_value(address+124, (int) maxComputeInvocationsPerWorkgroup);
		put_value(address+128, (int) maxComputeWorkgroupSizeX);
		put_value(address+132, (int) maxComputeWorkgroupSizeY);
		put_value(address+136, (int) maxComputeWorkgroupSizeZ);
		put_value(address+140, (int) maxComputeWorkgroupsPerDimension);
		return address;
	}

	protected Limits load(long address) {
		maxTextureDimension1D = get_int(address+0);
		maxTextureDimension2D = get_int(address+4);
		maxTextureDimension3D = get_int(address+8);
		maxTextureArrayLayers = get_int(address+12);
		maxBindGroups = get_int(address+16);
		maxBindGroupsPlusVertexBuffers = get_int(address+20);
		maxBindingsPerBindGroup = get_int(address+24);
		maxDynamicUniformBuffersPerPipelineLayout = get_int(address+28);
		maxDynamicStorageBuffersPerPipelineLayout = get_int(address+32);
		maxSampledTexturesPerShaderStage = get_int(address+36);
		maxSamplersPerShaderStage = get_int(address+40);
		maxStorageBuffersPerShaderStage = get_int(address+44);
		maxStorageTexturesPerShaderStage = get_int(address+48);
		maxUniformBuffersPerShaderStage = get_int(address+52);
		maxUniformBufferBindingSize = get_long(address+56);
		maxStorageBufferBindingSize = get_long(address+64);
		minUniformBufferOffsetAlignment = get_int(address+72);
		minStorageBufferOffsetAlignment = get_int(address+76);
		maxVertexBuffers = get_int(address+80);
		// padding 4
		maxBufferSize = get_long(address+88);
		maxVertexAttributes = get_int(address+96);
		maxVertexBufferArrayStride = get_int(address+100);
		maxInterStageShaderComponents = get_int(address+104);
		maxInterStageShaderVariables = get_int(address+108);
		maxColorAttachments = get_int(address+112);
		maxColorAttachmentBytesPerSample = get_int(address+116);
		maxComputeWorkgroupStorageSize = get_int(address+120);
		maxComputeInvocationsPerWorkgroup = get_int(address+124);
		maxComputeWorkgroupSizeX = get_int(address+128);
		maxComputeWorkgroupSizeY = get_int(address+132);
		maxComputeWorkgroupSizeZ = get_int(address+136);
		maxComputeWorkgroupsPerDimension = get_int(address+140);
		// padding 4
		return this;
	}
	public Limits() {}
}
