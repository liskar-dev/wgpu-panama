package wgpu.enums;

import wgpu.CEnum;
import java.util.*;

public class VertexFormat extends CEnum {
	private static final Map<Integer, VertexFormat> map = new HashMap<>();
	public static final VertexFormat UNDEFINED = new VertexFormat(0x00000000, "UNDEFINED");
	public static final VertexFormat UINT8X2 = new VertexFormat(0x00000001, "UINT8X2");
	public static final VertexFormat UINT8X4 = new VertexFormat(0x00000002, "UINT8X4");
	public static final VertexFormat SINT8X2 = new VertexFormat(0x00000003, "SINT8X2");
	public static final VertexFormat SINT8X4 = new VertexFormat(0x00000004, "SINT8X4");
	public static final VertexFormat UNORM8X2 = new VertexFormat(0x00000005, "UNORM8X2");
	public static final VertexFormat UNORM8X4 = new VertexFormat(0x00000006, "UNORM8X4");
	public static final VertexFormat SNORM8X2 = new VertexFormat(0x00000007, "SNORM8X2");
	public static final VertexFormat SNORM8X4 = new VertexFormat(0x00000008, "SNORM8X4");
	public static final VertexFormat UINT16X2 = new VertexFormat(0x00000009, "UINT16X2");
	public static final VertexFormat UINT16X4 = new VertexFormat(0x0000000A, "UINT16X4");
	public static final VertexFormat SINT16X2 = new VertexFormat(0x0000000B, "SINT16X2");
	public static final VertexFormat SINT16X4 = new VertexFormat(0x0000000C, "SINT16X4");
	public static final VertexFormat UNORM16X2 = new VertexFormat(0x0000000D, "UNORM16X2");
	public static final VertexFormat UNORM16X4 = new VertexFormat(0x0000000E, "UNORM16X4");
	public static final VertexFormat SNORM16X2 = new VertexFormat(0x0000000F, "SNORM16X2");
	public static final VertexFormat SNORM16X4 = new VertexFormat(0x00000010, "SNORM16X4");
	public static final VertexFormat FLOAT16X2 = new VertexFormat(0x00000011, "FLOAT16X2");
	public static final VertexFormat FLOAT16X4 = new VertexFormat(0x00000012, "FLOAT16X4");
	public static final VertexFormat FLOAT32 = new VertexFormat(0x00000013, "FLOAT32");
	public static final VertexFormat FLOAT32X2 = new VertexFormat(0x00000014, "FLOAT32X2");
	public static final VertexFormat FLOAT32X3 = new VertexFormat(0x00000015, "FLOAT32X3");
	public static final VertexFormat FLOAT32X4 = new VertexFormat(0x00000016, "FLOAT32X4");
	public static final VertexFormat UINT32 = new VertexFormat(0x00000017, "UINT32");
	public static final VertexFormat UINT32X2 = new VertexFormat(0x00000018, "UINT32X2");
	public static final VertexFormat UINT32X3 = new VertexFormat(0x00000019, "UINT32X3");
	public static final VertexFormat UINT32X4 = new VertexFormat(0x0000001A, "UINT32X4");
	public static final VertexFormat SINT32 = new VertexFormat(0x0000001B, "SINT32");
	public static final VertexFormat SINT32X2 = new VertexFormat(0x0000001C, "SINT32X2");
	public static final VertexFormat SINT32X3 = new VertexFormat(0x0000001D, "SINT32X3");
	public static final VertexFormat SINT32X4 = new VertexFormat(0x0000001E, "SINT32X4");

	public static VertexFormat from(int bits) {
		return map.get(bits);
	}

	private VertexFormat(int bits, String name) {
		super(bits, name);
		map.put(bits, this);
	}
}
