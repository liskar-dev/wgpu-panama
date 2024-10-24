package wgpu.enums;

import wgpu.CEnum;
import java.util.*;

public class BlendOperation extends CEnum {
	private static final Map<Integer, BlendOperation> map = new HashMap<>();
	public static final BlendOperation ADD = new BlendOperation(0x00000000, "Add");
	public static final BlendOperation SUBTRACT = new BlendOperation(0x00000001, "Subtract");
	public static final BlendOperation REVERSE_SUBTRACT = new BlendOperation(0x00000002, "ReverseSubtract");
	public static final BlendOperation MIN = new BlendOperation(0x00000003, "Min");
	public static final BlendOperation MAX = new BlendOperation(0x00000004, "Max");

	public static BlendOperation from(int bits) {
		return map.get(bits);
	}

	private BlendOperation(int bits, String name) {
		super(bits, name);
		map.put(bits, this);
	}
}
