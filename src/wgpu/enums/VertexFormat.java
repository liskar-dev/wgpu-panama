package wgpu.enums;

import wgpu.CEnum;
import java.util.*;

public class VertexFormat extends CEnum {
	private static final Map<Integer, VertexFormat> map = new HashMap<>();
	public static final VertexFormat UNDEFINED = new VertexFormat(0x00000000, "Undefined");
	public static final VertexFormat UINT8X2 = new VertexFormat(0x00000001, "Uint8x2");
	public static final VertexFormat UINT8X4 = new VertexFormat(0x00000002, "Uint8x4");
	public static final VertexFormat SINT8X2 = new VertexFormat(0x00000003, "Sint8x2");
	public static final VertexFormat SINT8X4 = new VertexFormat(0x00000004, "Sint8x4");
	public static final VertexFormat UNORM8X2 = new VertexFormat(0x00000005, "Unorm8x2");
	public static final VertexFormat UNORM8X4 = new VertexFormat(0x00000006, "Unorm8x4");
	public static final VertexFormat SNORM8X2 = new VertexFormat(0x00000007, "Snorm8x2");
	public static final VertexFormat SNORM8X4 = new VertexFormat(0x00000008, "Snorm8x4");
	public static final VertexFormat UINT16X2 = new VertexFormat(0x00000009, "Uint16x2");
	public static final VertexFormat UINT16X4 = new VertexFormat(0x0000000A, "Uint16x4");
	public static final VertexFormat SINT16X2 = new VertexFormat(0x0000000B, "Sint16x2");
	public static final VertexFormat SINT16X4 = new VertexFormat(0x0000000C, "Sint16x4");
	public static final VertexFormat UNORM16X2 = new VertexFormat(0x0000000D, "Unorm16x2");
	public static final VertexFormat UNORM16X4 = new VertexFormat(0x0000000E, "Unorm16x4");
	public static final VertexFormat SNORM16X2 = new VertexFormat(0x0000000F, "Snorm16x2");
	public static final VertexFormat SNORM16X4 = new VertexFormat(0x00000010, "Snorm16x4");
	public static final VertexFormat FLOAT16X2 = new VertexFormat(0x00000011, "Float16x2");
	public static final VertexFormat FLOAT16X4 = new VertexFormat(0x00000012, "Float16x4");
	public static final VertexFormat FLOAT32 = new VertexFormat(0x00000013, "Float32");
	public static final VertexFormat FLOAT32X2 = new VertexFormat(0x00000014, "Float32x2");
	public static final VertexFormat FLOAT32X3 = new VertexFormat(0x00000015, "Float32x3");
	public static final VertexFormat FLOAT32X4 = new VertexFormat(0x00000016, "Float32x4");
	public static final VertexFormat UINT32 = new VertexFormat(0x00000017, "Uint32");
	public static final VertexFormat UINT32X2 = new VertexFormat(0x00000018, "Uint32x2");
	public static final VertexFormat UINT32X3 = new VertexFormat(0x00000019, "Uint32x3");
	public static final VertexFormat UINT32X4 = new VertexFormat(0x0000001A, "Uint32x4");
	public static final VertexFormat SINT32 = new VertexFormat(0x0000001B, "Sint32");
	public static final VertexFormat SINT32X2 = new VertexFormat(0x0000001C, "Sint32x2");
	public static final VertexFormat SINT32X3 = new VertexFormat(0x0000001D, "Sint32x3");
	public static final VertexFormat SINT32X4 = new VertexFormat(0x0000001E, "Sint32x4");

	public static VertexFormat from(int bits) {
		return map.get(bits);
	}

	private VertexFormat(int bits, String name) {
		super(bits, name);
		map.put(bits, this);
	}
}
