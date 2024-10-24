package wgpu.enums;

import wgpu.CEnum;
import java.util.*;

public class StencilOperation extends CEnum {
	private static final Map<Integer, StencilOperation> map = new HashMap<>();
	public static final StencilOperation KEEP = new StencilOperation(0x00000000, "Keep");
	public static final StencilOperation ZERO = new StencilOperation(0x00000001, "Zero");
	public static final StencilOperation REPLACE = new StencilOperation(0x00000002, "Replace");
	public static final StencilOperation INVERT = new StencilOperation(0x00000003, "Invert");
	public static final StencilOperation INCREMENT_CLAMP = new StencilOperation(0x00000004, "IncrementClamp");
	public static final StencilOperation DECREMENT_CLAMP = new StencilOperation(0x00000005, "DecrementClamp");
	public static final StencilOperation INCREMENT_WRAP = new StencilOperation(0x00000006, "IncrementWrap");
	public static final StencilOperation DECREMENT_WRAP = new StencilOperation(0x00000007, "DecrementWrap");

	public static StencilOperation from(int bits) {
		return map.get(bits);
	}

	private StencilOperation(int bits, String name) {
		super(bits, name);
		map.put(bits, this);
	}
}
