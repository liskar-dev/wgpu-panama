package wgpu.enums;

import wgpu.CEnum;
import java.util.*;

public class BlendFactor extends CEnum {
	private static final Map<Integer, BlendFactor> map = new HashMap<>();
	public static final BlendFactor ZERO = new BlendFactor(0x00000000, "Zero");
	public static final BlendFactor ONE = new BlendFactor(0x00000001, "One");
	public static final BlendFactor SRC = new BlendFactor(0x00000002, "Src");
	public static final BlendFactor ONE_MINUS_SRC = new BlendFactor(0x00000003, "OneMinusSrc");
	public static final BlendFactor SRC_ALPHA = new BlendFactor(0x00000004, "SrcAlpha");
	public static final BlendFactor ONE_MINUS_SRC_ALPHA = new BlendFactor(0x00000005, "OneMinusSrcAlpha");
	public static final BlendFactor DST = new BlendFactor(0x00000006, "Dst");
	public static final BlendFactor ONE_MINUS_DST = new BlendFactor(0x00000007, "OneMinusDst");
	public static final BlendFactor DST_ALPHA = new BlendFactor(0x00000008, "DstAlpha");
	public static final BlendFactor ONE_MINUS_DST_ALPHA = new BlendFactor(0x00000009, "OneMinusDstAlpha");
	public static final BlendFactor SRC_ALPHA_SATURATED = new BlendFactor(0x0000000A, "SrcAlphaSaturated");
	public static final BlendFactor CONSTANT = new BlendFactor(0x0000000B, "Constant");
	public static final BlendFactor ONE_MINUS_CONSTANT = new BlendFactor(0x0000000C, "OneMinusConstant");

	public static BlendFactor from(int bits) {
		return map.get(bits);
	}

	private BlendFactor(int bits, String name) {
		super(bits, name);
		map.put(bits, this);
	}
}
