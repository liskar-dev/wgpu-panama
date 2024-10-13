package wgpu.struct;

import wgpu.*;
import wgpu.impl.*;
import wgpu.struct.*;
import wgpu.enums.*;
import wgpu.callback.*;
import static wgpu.Statics.*;

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

	protected int sizeInBytes() {
		return 144;
	}

	protected void writeTo(WGPUWriter out) {
		out.write(maxTextureDimension1D);
		out.write(maxTextureDimension2D);
		out.write(maxTextureDimension3D);
		out.write(maxTextureArrayLayers);
		out.write(maxBindGroups);
		out.write(maxBindGroupsPlusVertexBuffers);
		out.write(maxBindingsPerBindGroup);
		out.write(maxDynamicUniformBuffersPerPipelineLayout);
		out.write(maxDynamicStorageBuffersPerPipelineLayout);
		out.write(maxSampledTexturesPerShaderStage);
		out.write(maxSamplersPerShaderStage);
		out.write(maxStorageBuffersPerShaderStage);
		out.write(maxStorageTexturesPerShaderStage);
		out.write(maxUniformBuffersPerShaderStage);
		out.write(maxUniformBufferBindingSize);
		out.write(maxStorageBufferBindingSize);
		out.write(minUniformBufferOffsetAlignment);
		out.write(minStorageBufferOffsetAlignment);
		out.write(maxVertexBuffers);
		out.padding(4);
		out.write(maxBufferSize);
		out.write(maxVertexAttributes);
		out.write(maxVertexBufferArrayStride);
		out.write(maxInterStageShaderComponents);
		out.write(maxInterStageShaderVariables);
		out.write(maxColorAttachments);
		out.write(maxColorAttachmentBytesPerSample);
		out.write(maxComputeWorkgroupStorageSize);
		out.write(maxComputeInvocationsPerWorkgroup);
		out.write(maxComputeWorkgroupSizeX);
		out.write(maxComputeWorkgroupSizeY);
		out.write(maxComputeWorkgroupSizeZ);
		out.write(maxComputeWorkgroupsPerDimension);
	}

	protected Limits readFrom(WGPUReader in) {
		maxTextureDimension1D = in.read_int();
		maxTextureDimension2D = in.read_int();
		maxTextureDimension3D = in.read_int();
		maxTextureArrayLayers = in.read_int();
		maxBindGroups = in.read_int();
		maxBindGroupsPlusVertexBuffers = in.read_int();
		maxBindingsPerBindGroup = in.read_int();
		maxDynamicUniformBuffersPerPipelineLayout = in.read_int();
		maxDynamicStorageBuffersPerPipelineLayout = in.read_int();
		maxSampledTexturesPerShaderStage = in.read_int();
		maxSamplersPerShaderStage = in.read_int();
		maxStorageBuffersPerShaderStage = in.read_int();
		maxStorageTexturesPerShaderStage = in.read_int();
		maxUniformBuffersPerShaderStage = in.read_int();
		maxUniformBufferBindingSize = in.read_long();
		maxStorageBufferBindingSize = in.read_long();
		minUniformBufferOffsetAlignment = in.read_int();
		minStorageBufferOffsetAlignment = in.read_int();
		maxVertexBuffers = in.read_int();
		in.padding(4);
		maxBufferSize = in.read_long();
		maxVertexAttributes = in.read_int();
		maxVertexBufferArrayStride = in.read_int();
		maxInterStageShaderComponents = in.read_int();
		maxInterStageShaderVariables = in.read_int();
		maxColorAttachments = in.read_int();
		maxColorAttachmentBytesPerSample = in.read_int();
		maxComputeWorkgroupStorageSize = in.read_int();
		maxComputeInvocationsPerWorkgroup = in.read_int();
		maxComputeWorkgroupSizeX = in.read_int();
		maxComputeWorkgroupSizeY = in.read_int();
		maxComputeWorkgroupSizeZ = in.read_int();
		maxComputeWorkgroupsPerDimension = in.read_int();
		return this;
	}

	public Limits() {}

	public Limits(MemorySegment from) {
		readFrom(new WGPUReader(from));
	}

}
