package wgpu.enums;

import wgpu.CEnum;
import java.util.*;

public class PrimitiveTopology extends CEnum {
	private static final Map<Integer, PrimitiveTopology> map = new HashMap<>();
	public static final PrimitiveTopology POINT_LIST = new PrimitiveTopology(0x00000000, "POINT_LIST");
	public static final PrimitiveTopology LINE_LIST = new PrimitiveTopology(0x00000001, "LINE_LIST");
	public static final PrimitiveTopology LINE_STRIP = new PrimitiveTopology(0x00000002, "LINE_STRIP");
	public static final PrimitiveTopology TRIANGLE_LIST = new PrimitiveTopology(0x00000003, "TRIANGLE_LIST");
	public static final PrimitiveTopology TRIANGLE_STRIP = new PrimitiveTopology(0x00000004, "TRIANGLE_STRIP");

	public static PrimitiveTopology from(int bits) {
		return map.get(bits);
	}

	private PrimitiveTopology(int bits, String name) {
		super(bits, name);
		map.put(bits, this);
	}
}
