package wgpu.enums;

import wgpu.CEnum;
import java.util.*;

public class CompareFunction extends CEnum {
	private static final Map<Integer, CompareFunction> map = new HashMap<>();
	public static final CompareFunction UNDEFINED = new CompareFunction(0x00000000, "UNDEFINED");
	public static final CompareFunction NEVER = new CompareFunction(0x00000001, "NEVER");
	public static final CompareFunction LESS = new CompareFunction(0x00000002, "LESS");
	public static final CompareFunction LESS_EQUAL = new CompareFunction(0x00000003, "LESS_EQUAL");
	public static final CompareFunction GREATER = new CompareFunction(0x00000004, "GREATER");
	public static final CompareFunction GREATER_EQUAL = new CompareFunction(0x00000005, "GREATER_EQUAL");
	public static final CompareFunction EQUAL = new CompareFunction(0x00000006, "EQUAL");
	public static final CompareFunction NOT_EQUAL = new CompareFunction(0x00000007, "NOT_EQUAL");
	public static final CompareFunction ALWAYS = new CompareFunction(0x00000008, "ALWAYS");

	public static CompareFunction from(int bits) {
		return map.get(bits);
	}

	private CompareFunction(int bits, String name) {
		super(bits, name);
		map.put(bits, this);
	}
}
