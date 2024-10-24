package wgpu.enums;

import wgpu.CEnum;
import java.util.*;

public class FeatureName extends CEnum {
	private static final Map<Integer, FeatureName> map = new HashMap<>();
	public static final FeatureName UNDEFINED = new FeatureName(0x00000000, "Undefined");
	public static final FeatureName DEPTH_CLIP_CONTROL = new FeatureName(0x00000001, "DepthClipControl");
	public static final FeatureName DEPTH32_FLOAT_STENCIL8 = new FeatureName(0x00000002, "Depth32FloatStencil8");
	public static final FeatureName TIMESTAMP_QUERY = new FeatureName(0x00000003, "TimestampQuery");
	public static final FeatureName TEXTURE_COMPRESSION_BC = new FeatureName(0x00000004, "TextureCompressionBC");
	public static final FeatureName TEXTURE_COMPRESSION_ETC2 = new FeatureName(0x00000005, "TextureCompressionETC2");
	public static final FeatureName TEXTURE_COMPRESSION_ASTC = new FeatureName(0x00000006, "TextureCompressionASTC");
	public static final FeatureName INDIRECT_FIRST_INSTANCE = new FeatureName(0x00000007, "IndirectFirstInstance");
	public static final FeatureName SHADER_F16 = new FeatureName(0x00000008, "ShaderF16");
	public static final FeatureName RG11_B10_UFLOAT_RENDERABLE = new FeatureName(0x00000009, "RG11B10UfloatRenderable");
	public static final FeatureName BGRA8_UNORM_STORAGE = new FeatureName(0x0000000A, "BGRA8UnormStorage");
	public static final FeatureName FLOAT32_FILTERABLE = new FeatureName(0x0000000B, "Float32Filterable");
	public static final FeatureName PUSH_CONSTANTS = new FeatureName(0x00030001, "PushConstants");
	public static final FeatureName TEXTURE_ADAPTER_SPECIFIC_FORMAT_FEATURES = new FeatureName(0x00030002, "TextureAdapterSpecificFormatFeatures");
	public static final FeatureName MULTI_DRAW_INDIRECT = new FeatureName(0x00030003, "MultiDrawIndirect");
	public static final FeatureName MULTI_DRAW_INDIRECT_COUNT = new FeatureName(0x00030004, "MultiDrawIndirectCount");
	public static final FeatureName VERTEX_WRITABLE_STORAGE = new FeatureName(0x00030005, "VertexWritableStorage");
	public static final FeatureName TEXTURE_BINDING_ARRAY = new FeatureName(0x00030006, "TextureBindingArray");
	public static final FeatureName SAMPLED_TEXTURE_AND_STORAGE_BUFFER_ARRAY_NON_UNIFORM_INDEXING = new FeatureName(0x00030007, "SampledTextureAndStorageBufferArrayNonUniformIndexing");
	public static final FeatureName PIPELINE_STATISTICS_QUERY = new FeatureName(0x00030008, "PipelineStatisticsQuery");
	public static final FeatureName STORAGE_RESOURCE_BINDING_ARRAY = new FeatureName(0x00030009, "StorageResourceBindingArray");
	public static final FeatureName PARTIALLY_BOUND_BINDING_ARRAY = new FeatureName(0x0003000A, "PartiallyBoundBindingArray");
	public static final FeatureName TEXTURE_FORMAT16BIT_NORM = new FeatureName(0x0003000B, "TextureFormat16bitNorm");
	public static final FeatureName TEXTURE_COMPRESSION_ASTC_HDR = new FeatureName(0x0003000C, "TextureCompressionAstcHdr");
	public static final FeatureName MAPPABLE_PRIMARY_BUFFERS = new FeatureName(0x0003000E, "MappablePrimaryBuffers");
	public static final FeatureName BUFFER_BINDING_ARRAY = new FeatureName(0x0003000F, "BufferBindingArray");
	public static final FeatureName UNIFORM_BUFFER_AND_STORAGE_TEXTURE_ARRAY_NON_UNIFORM_INDEXING = new FeatureName(0x00030010, "UniformBufferAndStorageTextureArrayNonUniformIndexing");
	public static final FeatureName VERTEX_ATTRIBUTE64BIT = new FeatureName(0x00030019, "VertexAttribute64bit");
	public static final FeatureName TEXTURE_FORMAT_NV12 = new FeatureName(0x0003001A, "TextureFormatNv12");
	public static final FeatureName RAY_TRACING_ACCELERATION_STRUCTURE = new FeatureName(0x0003001B, "RayTracingAccelerationStructure");
	public static final FeatureName RAY_QUERY = new FeatureName(0x0003001C, "RayQuery");
	public static final FeatureName SHADER_F64 = new FeatureName(0x0003001D, "ShaderF64");
	public static final FeatureName SHADER_I16 = new FeatureName(0x0003001E, "ShaderI16");
	public static final FeatureName SHADER_PRIMITIVE_INDEX = new FeatureName(0x0003001F, "ShaderPrimitiveIndex");
	public static final FeatureName SHADER_EARLY_DEPTH_TEST = new FeatureName(0x00030020, "ShaderEarlyDepthTest");

	public static FeatureName from(int bits) {
		return map.get(bits);
	}

	private FeatureName(int bits, String name) {
		super(bits, name);
		map.put(bits, this);
	}
}
