package wgpu.enums;

import wgpu.WGPUEnum;
import java.util.*;

public class ErrorFilter extends WGPUEnum {
	private static final Map<Integer, ErrorFilter> map = new HashMap<>();
	public static final ErrorFilter VALIDATION = new ErrorFilter(0x00000000, "VALIDATION");
	public static final ErrorFilter OUT_OF_MEMORY = new ErrorFilter(0x00000001, "OUT_OF_MEMORY");
	public static final ErrorFilter INTERNAL = new ErrorFilter(0x00000002, "INTERNAL");

	public static ErrorFilter from(int bits) {
		return map.get(bits);
	}

	private ErrorFilter(int bits, String name) {
		super(bits, name);
		map.put(bits, this);
	}
}
