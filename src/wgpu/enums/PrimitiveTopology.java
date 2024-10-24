package wgpu.enums;

import wgpu.CEnum;
import java.util.*;

public class PrimitiveTopology extends CEnum {
	private static final Map<Integer, PrimitiveTopology> map = new HashMap<>();
	public static final PrimitiveTopology POINT_LIST = new PrimitiveTopology(0x00000000, "PointList");
	public static final PrimitiveTopology LINE_LIST = new PrimitiveTopology(0x00000001, "LineList");
	public static final PrimitiveTopology LINE_STRIP = new PrimitiveTopology(0x00000002, "LineStrip");
	public static final PrimitiveTopology TRIANGLE_LIST = new PrimitiveTopology(0x00000003, "TriangleList");
	public static final PrimitiveTopology TRIANGLE_STRIP = new PrimitiveTopology(0x00000004, "TriangleStrip");

	public static PrimitiveTopology from(int bits) {
		return map.get(bits);
	}

	private PrimitiveTopology(int bits, String name) {
		super(bits, name);
		map.put(bits, this);
	}
}
