package wgpu.enums;

import wgpu.WGPUEnum;
import java.util.*;

public class TextureFormat extends WGPUEnum {
	private static final Map<Integer, TextureFormat> map = new HashMap<>();
	public static final TextureFormat UNDEFINED = new TextureFormat(0x00000000, "UNDEFINED");
	public static final TextureFormat R8_UNORM = new TextureFormat(0x00000001, "R8_UNORM");
	public static final TextureFormat R8_SNORM = new TextureFormat(0x00000002, "R8_SNORM");
	public static final TextureFormat R8_UINT = new TextureFormat(0x00000003, "R8_UINT");
	public static final TextureFormat R8_SINT = new TextureFormat(0x00000004, "R8_SINT");
	public static final TextureFormat R16_UINT = new TextureFormat(0x00000005, "R16_UINT");
	public static final TextureFormat R16_SINT = new TextureFormat(0x00000006, "R16_SINT");
	public static final TextureFormat R16_FLOAT = new TextureFormat(0x00000007, "R16_FLOAT");
	public static final TextureFormat RG8_UNORM = new TextureFormat(0x00000008, "RG8_UNORM");
	public static final TextureFormat RG8_SNORM = new TextureFormat(0x00000009, "RG8_SNORM");
	public static final TextureFormat RG8_UINT = new TextureFormat(0x0000000A, "RG8_UINT");
	public static final TextureFormat RG8_SINT = new TextureFormat(0x0000000B, "RG8_SINT");
	public static final TextureFormat R32_FLOAT = new TextureFormat(0x0000000C, "R32_FLOAT");
	public static final TextureFormat R32_UINT = new TextureFormat(0x0000000D, "R32_UINT");
	public static final TextureFormat R32_SINT = new TextureFormat(0x0000000E, "R32_SINT");
	public static final TextureFormat RG16_UINT = new TextureFormat(0x0000000F, "RG16_UINT");
	public static final TextureFormat RG16_SINT = new TextureFormat(0x00000010, "RG16_SINT");
	public static final TextureFormat RG16_FLOAT = new TextureFormat(0x00000011, "RG16_FLOAT");
	public static final TextureFormat RGBA8_UNORM = new TextureFormat(0x00000012, "RGBA8_UNORM");
	public static final TextureFormat RGBA8_UNORM_SRGB = new TextureFormat(0x00000013, "RGBA8_UNORM_SRGB");
	public static final TextureFormat RGBA8_SNORM = new TextureFormat(0x00000014, "RGBA8_SNORM");
	public static final TextureFormat RGBA8_UINT = new TextureFormat(0x00000015, "RGBA8_UINT");
	public static final TextureFormat RGBA8_SINT = new TextureFormat(0x00000016, "RGBA8_SINT");
	public static final TextureFormat BGRA8_UNORM = new TextureFormat(0x00000017, "BGRA8_UNORM");
	public static final TextureFormat BGRA8_UNORM_SRGB = new TextureFormat(0x00000018, "BGRA8_UNORM_SRGB");
	public static final TextureFormat RGB10_A2_UINT = new TextureFormat(0x00000019, "RGB10_A2_UINT");
	public static final TextureFormat RGB10_A2_UNORM = new TextureFormat(0x0000001A, "RGB10_A2_UNORM");
	public static final TextureFormat RG11_B10_UFLOAT = new TextureFormat(0x0000001B, "RG11_B10_UFLOAT");
	public static final TextureFormat RGB9_E5_UFLOAT = new TextureFormat(0x0000001C, "RGB9_E5_UFLOAT");
	public static final TextureFormat RG32_FLOAT = new TextureFormat(0x0000001D, "RG32_FLOAT");
	public static final TextureFormat RG32_UINT = new TextureFormat(0x0000001E, "RG32_UINT");
	public static final TextureFormat RG32_SINT = new TextureFormat(0x0000001F, "RG32_SINT");
	public static final TextureFormat RGBA16_UINT = new TextureFormat(0x00000020, "RGBA16_UINT");
	public static final TextureFormat RGBA16_SINT = new TextureFormat(0x00000021, "RGBA16_SINT");
	public static final TextureFormat RGBA16_FLOAT = new TextureFormat(0x00000022, "RGBA16_FLOAT");
	public static final TextureFormat RGBA32_FLOAT = new TextureFormat(0x00000023, "RGBA32_FLOAT");
	public static final TextureFormat RGBA32_UINT = new TextureFormat(0x00000024, "RGBA32_UINT");
	public static final TextureFormat RGBA32_SINT = new TextureFormat(0x00000025, "RGBA32_SINT");
	public static final TextureFormat STENCIL8 = new TextureFormat(0x00000026, "STENCIL8");
	public static final TextureFormat DEPTH16_UNORM = new TextureFormat(0x00000027, "DEPTH16_UNORM");
	public static final TextureFormat DEPTH24_PLUS = new TextureFormat(0x00000028, "DEPTH24_PLUS");
	public static final TextureFormat DEPTH24_PLUS_STENCIL8 = new TextureFormat(0x00000029, "DEPTH24_PLUS_STENCIL8");
	public static final TextureFormat DEPTH32_FLOAT = new TextureFormat(0x0000002A, "DEPTH32_FLOAT");
	public static final TextureFormat DEPTH32_FLOAT_STENCIL8 = new TextureFormat(0x0000002B, "DEPTH32_FLOAT_STENCIL8");
	public static final TextureFormat BC1_RGBAUNORM = new TextureFormat(0x0000002C, "BC1_RGBAUNORM");
	public static final TextureFormat BC1_RGBAUNORM_SRGB = new TextureFormat(0x0000002D, "BC1_RGBAUNORM_SRGB");
	public static final TextureFormat BC2_RGBAUNORM = new TextureFormat(0x0000002E, "BC2_RGBAUNORM");
	public static final TextureFormat BC2_RGBAUNORM_SRGB = new TextureFormat(0x0000002F, "BC2_RGBAUNORM_SRGB");
	public static final TextureFormat BC3_RGBAUNORM = new TextureFormat(0x00000030, "BC3_RGBAUNORM");
	public static final TextureFormat BC3_RGBAUNORM_SRGB = new TextureFormat(0x00000031, "BC3_RGBAUNORM_SRGB");
	public static final TextureFormat BC4_RUNORM = new TextureFormat(0x00000032, "BC4_RUNORM");
	public static final TextureFormat BC4_RSNORM = new TextureFormat(0x00000033, "BC4_RSNORM");
	public static final TextureFormat BC5_RGUNORM = new TextureFormat(0x00000034, "BC5_RGUNORM");
	public static final TextureFormat BC5_RGSNORM = new TextureFormat(0x00000035, "BC5_RGSNORM");
	public static final TextureFormat BC6_HRGBUFLOAT = new TextureFormat(0x00000036, "BC6_HRGBUFLOAT");
	public static final TextureFormat BC6_HRGBFLOAT = new TextureFormat(0x00000037, "BC6_HRGBFLOAT");
	public static final TextureFormat BC7_RGBAUNORM = new TextureFormat(0x00000038, "BC7_RGBAUNORM");
	public static final TextureFormat BC7_RGBAUNORM_SRGB = new TextureFormat(0x00000039, "BC7_RGBAUNORM_SRGB");
	public static final TextureFormat ETC2_RGB8_UNORM = new TextureFormat(0x0000003A, "ETC2_RGB8_UNORM");
	public static final TextureFormat ETC2_RGB8_UNORM_SRGB = new TextureFormat(0x0000003B, "ETC2_RGB8_UNORM_SRGB");
	public static final TextureFormat ETC2_RGB8_A1_UNORM = new TextureFormat(0x0000003C, "ETC2_RGB8_A1_UNORM");
	public static final TextureFormat ETC2_RGB8_A1_UNORM_SRGB = new TextureFormat(0x0000003D, "ETC2_RGB8_A1_UNORM_SRGB");
	public static final TextureFormat ETC2_RGBA8_UNORM = new TextureFormat(0x0000003E, "ETC2_RGBA8_UNORM");
	public static final TextureFormat ETC2_RGBA8_UNORM_SRGB = new TextureFormat(0x0000003F, "ETC2_RGBA8_UNORM_SRGB");
	public static final TextureFormat EACR11_UNORM = new TextureFormat(0x00000040, "EACR11_UNORM");
	public static final TextureFormat EACR11_SNORM = new TextureFormat(0x00000041, "EACR11_SNORM");
	public static final TextureFormat EACRG11_UNORM = new TextureFormat(0x00000042, "EACRG11_UNORM");
	public static final TextureFormat EACRG11_SNORM = new TextureFormat(0x00000043, "EACRG11_SNORM");
	public static final TextureFormat ASTC4X4_UNORM = new TextureFormat(0x00000044, "ASTC4X4_UNORM");
	public static final TextureFormat ASTC4X4_UNORM_SRGB = new TextureFormat(0x00000045, "ASTC4X4_UNORM_SRGB");
	public static final TextureFormat ASTC5X4_UNORM = new TextureFormat(0x00000046, "ASTC5X4_UNORM");
	public static final TextureFormat ASTC5X4_UNORM_SRGB = new TextureFormat(0x00000047, "ASTC5X4_UNORM_SRGB");
	public static final TextureFormat ASTC5X5_UNORM = new TextureFormat(0x00000048, "ASTC5X5_UNORM");
	public static final TextureFormat ASTC5X5_UNORM_SRGB = new TextureFormat(0x00000049, "ASTC5X5_UNORM_SRGB");
	public static final TextureFormat ASTC6X5_UNORM = new TextureFormat(0x0000004A, "ASTC6X5_UNORM");
	public static final TextureFormat ASTC6X5_UNORM_SRGB = new TextureFormat(0x0000004B, "ASTC6X5_UNORM_SRGB");
	public static final TextureFormat ASTC6X6_UNORM = new TextureFormat(0x0000004C, "ASTC6X6_UNORM");
	public static final TextureFormat ASTC6X6_UNORM_SRGB = new TextureFormat(0x0000004D, "ASTC6X6_UNORM_SRGB");
	public static final TextureFormat ASTC8X5_UNORM = new TextureFormat(0x0000004E, "ASTC8X5_UNORM");
	public static final TextureFormat ASTC8X5_UNORM_SRGB = new TextureFormat(0x0000004F, "ASTC8X5_UNORM_SRGB");
	public static final TextureFormat ASTC8X6_UNORM = new TextureFormat(0x00000050, "ASTC8X6_UNORM");
	public static final TextureFormat ASTC8X6_UNORM_SRGB = new TextureFormat(0x00000051, "ASTC8X6_UNORM_SRGB");
	public static final TextureFormat ASTC8X8_UNORM = new TextureFormat(0x00000052, "ASTC8X8_UNORM");
	public static final TextureFormat ASTC8X8_UNORM_SRGB = new TextureFormat(0x00000053, "ASTC8X8_UNORM_SRGB");
	public static final TextureFormat ASTC10X5_UNORM = new TextureFormat(0x00000054, "ASTC10X5_UNORM");
	public static final TextureFormat ASTC10X5_UNORM_SRGB = new TextureFormat(0x00000055, "ASTC10X5_UNORM_SRGB");
	public static final TextureFormat ASTC10X6_UNORM = new TextureFormat(0x00000056, "ASTC10X6_UNORM");
	public static final TextureFormat ASTC10X6_UNORM_SRGB = new TextureFormat(0x00000057, "ASTC10X6_UNORM_SRGB");
	public static final TextureFormat ASTC10X8_UNORM = new TextureFormat(0x00000058, "ASTC10X8_UNORM");
	public static final TextureFormat ASTC10X8_UNORM_SRGB = new TextureFormat(0x00000059, "ASTC10X8_UNORM_SRGB");
	public static final TextureFormat ASTC10X10_UNORM = new TextureFormat(0x0000005A, "ASTC10X10_UNORM");
	public static final TextureFormat ASTC10X10_UNORM_SRGB = new TextureFormat(0x0000005B, "ASTC10X10_UNORM_SRGB");
	public static final TextureFormat ASTC12X10_UNORM = new TextureFormat(0x0000005C, "ASTC12X10_UNORM");
	public static final TextureFormat ASTC12X10_UNORM_SRGB = new TextureFormat(0x0000005D, "ASTC12X10_UNORM_SRGB");
	public static final TextureFormat ASTC12X12_UNORM = new TextureFormat(0x0000005E, "ASTC12X12_UNORM");
	public static final TextureFormat ASTC12X12_UNORM_SRGB = new TextureFormat(0x0000005F, "ASTC12X12_UNORM_SRGB");
	public static final TextureFormat R16_UNORM = new TextureFormat(0x00030001, "R16_UNORM");
	public static final TextureFormat R16_SNORM = new TextureFormat(0x00030002, "R16_SNORM");
	public static final TextureFormat RG16_UNORM = new TextureFormat(0x00030003, "RG16_UNORM");
	public static final TextureFormat RG16_SNORM = new TextureFormat(0x00030004, "RG16_SNORM");
	public static final TextureFormat RGBA16_UNORM = new TextureFormat(0x00030005, "RGBA16_UNORM");
	public static final TextureFormat RGBA16_SNORM = new TextureFormat(0x00030006, "RGBA16_SNORM");
	public static final TextureFormat NV12 = new TextureFormat(0x00030007, "NV12");

	public static TextureFormat from(int bits) {
		return map.get(bits);
	}

	private TextureFormat(int bits, String name) {
		super(bits, name);
		map.put(bits, this);
	}
}
