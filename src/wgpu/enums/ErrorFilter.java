package wgpu.enums;

import wgpu.CEnum;
import java.util.*;

public class ErrorFilter extends CEnum {
	private static final Map<Integer, ErrorFilter> map = new HashMap<>();
	public static final ErrorFilter VALIDATION = new ErrorFilter(0x00000000, "Validation");
	public static final ErrorFilter OUT_OF_MEMORY = new ErrorFilter(0x00000001, "OutOfMemory");
	public static final ErrorFilter INTERNAL = new ErrorFilter(0x00000002, "Internal");

	public static ErrorFilter from(int bits) {
		return map.get(bits);
	}

	private ErrorFilter(int bits, String name) {
		super(bits, name);
		map.put(bits, this);
	}
}
