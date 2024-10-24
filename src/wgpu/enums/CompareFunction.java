package wgpu.enums;

import wgpu.CEnum;
import java.util.*;

public class CompareFunction extends CEnum {
	private static final Map<Integer, CompareFunction> map = new HashMap<>();
	public static final CompareFunction UNDEFINED = new CompareFunction(0x00000000, "Undefined");
	public static final CompareFunction NEVER = new CompareFunction(0x00000001, "Never");
	public static final CompareFunction LESS = new CompareFunction(0x00000002, "Less");
	public static final CompareFunction LESS_EQUAL = new CompareFunction(0x00000003, "LessEqual");
	public static final CompareFunction GREATER = new CompareFunction(0x00000004, "Greater");
	public static final CompareFunction GREATER_EQUAL = new CompareFunction(0x00000005, "GreaterEqual");
	public static final CompareFunction EQUAL = new CompareFunction(0x00000006, "Equal");
	public static final CompareFunction NOT_EQUAL = new CompareFunction(0x00000007, "NotEqual");
	public static final CompareFunction ALWAYS = new CompareFunction(0x00000008, "Always");

	public static CompareFunction from(int bits) {
		return map.get(bits);
	}

	private CompareFunction(int bits, String name) {
		super(bits, name);
		map.put(bits, this);
	}
}
