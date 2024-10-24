package wgpu.enums;

import wgpu.CEnum;
import java.util.*;

public class BlendFactor extends CEnum {
	private static final Map<Integer, BlendFactor> map = new HashMap<>();
	public static final BlendFactor ZERO = new BlendFactor(0x00000000, "ZERO");
	public static final BlendFactor ONE = new BlendFactor(0x00000001, "ONE");
	public static final BlendFactor SRC = new BlendFactor(0x00000002, "SRC");
	public static final BlendFactor ONE_MINUS_SRC = new BlendFactor(0x00000003, "ONE_MINUS_SRC");
	public static final BlendFactor SRC_ALPHA = new BlendFactor(0x00000004, "SRC_ALPHA");
	public static final BlendFactor ONE_MINUS_SRC_ALPHA = new BlendFactor(0x00000005, "ONE_MINUS_SRC_ALPHA");
	public static final BlendFactor DST = new BlendFactor(0x00000006, "DST");
	public static final BlendFactor ONE_MINUS_DST = new BlendFactor(0x00000007, "ONE_MINUS_DST");
	public static final BlendFactor DST_ALPHA = new BlendFactor(0x00000008, "DST_ALPHA");
	public static final BlendFactor ONE_MINUS_DST_ALPHA = new BlendFactor(0x00000009, "ONE_MINUS_DST_ALPHA");
	public static final BlendFactor SRC_ALPHA_SATURATED = new BlendFactor(0x0000000A, "SRC_ALPHA_SATURATED");
	public static final BlendFactor CONSTANT = new BlendFactor(0x0000000B, "CONSTANT");
	public static final BlendFactor ONE_MINUS_CONSTANT = new BlendFactor(0x0000000C, "ONE_MINUS_CONSTANT");

	public static BlendFactor from(int bits) {
		return map.get(bits);
	}

	private BlendFactor(int bits, String name) {
		super(bits, name);
		map.put(bits, this);
	}
}
