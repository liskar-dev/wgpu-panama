package wgpu.enums;

import wgpu.CEnum;
import java.util.*;

public class StencilOperation extends CEnum {
	private static final Map<Integer, StencilOperation> map = new HashMap<>();
	public static final StencilOperation KEEP = new StencilOperation(0x00000000, "KEEP");
	public static final StencilOperation ZERO = new StencilOperation(0x00000001, "ZERO");
	public static final StencilOperation REPLACE = new StencilOperation(0x00000002, "REPLACE");
	public static final StencilOperation INVERT = new StencilOperation(0x00000003, "INVERT");
	public static final StencilOperation INCREMENT_CLAMP = new StencilOperation(0x00000004, "INCREMENT_CLAMP");
	public static final StencilOperation DECREMENT_CLAMP = new StencilOperation(0x00000005, "DECREMENT_CLAMP");
	public static final StencilOperation INCREMENT_WRAP = new StencilOperation(0x00000006, "INCREMENT_WRAP");
	public static final StencilOperation DECREMENT_WRAP = new StencilOperation(0x00000007, "DECREMENT_WRAP");

	public static StencilOperation from(int bits) {
		return map.get(bits);
	}

	private StencilOperation(int bits, String name) {
		super(bits, name);
		map.put(bits, this);
	}
}
