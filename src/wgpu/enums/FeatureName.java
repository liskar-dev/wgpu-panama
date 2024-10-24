package wgpu.enums;

import wgpu.CEnum;
import java.util.*;

public class FeatureName extends CEnum {
	private static final Map<Integer, FeatureName> map = new HashMap<>();
	public static final FeatureName UNDEFINED = new FeatureName(0x00000000, "UNDEFINED");
	public static final FeatureName DEPTH_CLIP_CONTROL = new FeatureName(0x00000001, "DEPTH_CLIP_CONTROL");
	public static final FeatureName DEPTH32_FLOAT_STENCIL8 = new FeatureName(0x00000002, "DEPTH32_FLOAT_STENCIL8");
	public static final FeatureName TIMESTAMP_QUERY = new FeatureName(0x00000003, "TIMESTAMP_QUERY");
	public static final FeatureName TEXTURE_COMPRESSION_BC = new FeatureName(0x00000004, "TEXTURE_COMPRESSION_BC");
	public static final FeatureName TEXTURE_COMPRESSION_ETC2 = new FeatureName(0x00000005, "TEXTURE_COMPRESSION_ETC2");
	public static final FeatureName TEXTURE_COMPRESSION_ASTC = new FeatureName(0x00000006, "TEXTURE_COMPRESSION_ASTC");
	public static final FeatureName INDIRECT_FIRST_INSTANCE = new FeatureName(0x00000007, "INDIRECT_FIRST_INSTANCE");
	public static final FeatureName SHADER_F16 = new FeatureName(0x00000008, "SHADER_F16");
	public static final FeatureName RG11_B10_UFLOAT_RENDERABLE = new FeatureName(0x00000009, "RG11_B10_UFLOAT_RENDERABLE");
	public static final FeatureName BGRA8_UNORM_STORAGE = new FeatureName(0x0000000A, "BGRA8_UNORM_STORAGE");
	public static final FeatureName FLOAT32_FILTERABLE = new FeatureName(0x0000000B, "FLOAT32_FILTERABLE");
	public static final FeatureName PUSH_CONSTANTS = new FeatureName(0x00030001, "PUSH_CONSTANTS");
	public static final FeatureName TEXTURE_ADAPTER_SPECIFIC_FORMAT_FEATURES = new FeatureName(0x00030002, "TEXTURE_ADAPTER_SPECIFIC_FORMAT_FEATURES");
	public static final FeatureName MULTI_DRAW_INDIRECT = new FeatureName(0x00030003, "MULTI_DRAW_INDIRECT");
	public static final FeatureName MULTI_DRAW_INDIRECT_COUNT = new FeatureName(0x00030004, "MULTI_DRAW_INDIRECT_COUNT");
	public static final FeatureName VERTEX_WRITABLE_STORAGE = new FeatureName(0x00030005, "VERTEX_WRITABLE_STORAGE");
	public static final FeatureName TEXTURE_BINDING_ARRAY = new FeatureName(0x00030006, "TEXTURE_BINDING_ARRAY");
	public static final FeatureName SAMPLED_TEXTURE_AND_STORAGE_BUFFER_ARRAY_NON_UNIFORM_INDEXING = new FeatureName(0x00030007, "SAMPLED_TEXTURE_AND_STORAGE_BUFFER_ARRAY_NON_UNIFORM_INDEXING");
	public static final FeatureName PIPELINE_STATISTICS_QUERY = new FeatureName(0x00030008, "PIPELINE_STATISTICS_QUERY");
	public static final FeatureName STORAGE_RESOURCE_BINDING_ARRAY = new FeatureName(0x00030009, "STORAGE_RESOURCE_BINDING_ARRAY");
	public static final FeatureName PARTIALLY_BOUND_BINDING_ARRAY = new FeatureName(0x0003000A, "PARTIALLY_BOUND_BINDING_ARRAY");
	public static final FeatureName TEXTURE_FORMAT16BIT_NORM = new FeatureName(0x0003000B, "TEXTURE_FORMAT16BIT_NORM");
	public static final FeatureName TEXTURE_COMPRESSION_ASTC_HDR = new FeatureName(0x0003000C, "TEXTURE_COMPRESSION_ASTC_HDR");
	public static final FeatureName MAPPABLE_PRIMARY_BUFFERS = new FeatureName(0x0003000E, "MAPPABLE_PRIMARY_BUFFERS");
	public static final FeatureName BUFFER_BINDING_ARRAY = new FeatureName(0x0003000F, "BUFFER_BINDING_ARRAY");
	public static final FeatureName UNIFORM_BUFFER_AND_STORAGE_TEXTURE_ARRAY_NON_UNIFORM_INDEXING = new FeatureName(0x00030010, "UNIFORM_BUFFER_AND_STORAGE_TEXTURE_ARRAY_NON_UNIFORM_INDEXING");
	public static final FeatureName VERTEX_ATTRIBUTE64BIT = new FeatureName(0x00030019, "VERTEX_ATTRIBUTE64BIT");
	public static final FeatureName TEXTURE_FORMAT_NV12 = new FeatureName(0x0003001A, "TEXTURE_FORMAT_NV12");
	public static final FeatureName RAY_TRACING_ACCELERATION_STRUCTURE = new FeatureName(0x0003001B, "RAY_TRACING_ACCELERATION_STRUCTURE");
	public static final FeatureName RAY_QUERY = new FeatureName(0x0003001C, "RAY_QUERY");
	public static final FeatureName SHADER_F64 = new FeatureName(0x0003001D, "SHADER_F64");
	public static final FeatureName SHADER_I16 = new FeatureName(0x0003001E, "SHADER_I16");
	public static final FeatureName SHADER_PRIMITIVE_INDEX = new FeatureName(0x0003001F, "SHADER_PRIMITIVE_INDEX");
	public static final FeatureName SHADER_EARLY_DEPTH_TEST = new FeatureName(0x00030020, "SHADER_EARLY_DEPTH_TEST");

	public static FeatureName from(int bits) {
		return map.get(bits);
	}

	private FeatureName(int bits, String name) {
		super(bits, name);
		map.put(bits, this);
	}
}
