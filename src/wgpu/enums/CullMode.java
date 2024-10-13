package wgpu.enums;

import wgpu.WGPUEnum;
import java.util.*;

public class CullMode extends WGPUEnum {
	private static final Map<Integer, CullMode> map = new HashMap<>();
	public static final CullMode NONE = new CullMode(0x00000000, "NONE");
	public static final CullMode FRONT = new CullMode(0x00000001, "FRONT");
	public static final CullMode BACK = new CullMode(0x00000002, "BACK");

	public static CullMode from(int bits) {
		return map.get(bits);
	}

	private CullMode(int bits, String name) {
		super(bits, name);
		map.put(bits, this);
	}
}
