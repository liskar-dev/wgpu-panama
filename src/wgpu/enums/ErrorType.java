package wgpu.enums;

import wgpu.WGPUEnum;
import java.util.*;

public class ErrorType extends WGPUEnum {
	private static final Map<Integer, ErrorType> map = new HashMap<>();
	public static final ErrorType NO_ERROR = new ErrorType(0x00000000, "NO_ERROR");
	public static final ErrorType VALIDATION = new ErrorType(0x00000001, "VALIDATION");
	public static final ErrorType OUT_OF_MEMORY = new ErrorType(0x00000002, "OUT_OF_MEMORY");
	public static final ErrorType INTERNAL = new ErrorType(0x00000003, "INTERNAL");
	public static final ErrorType UNKNOWN = new ErrorType(0x00000004, "UNKNOWN");
	public static final ErrorType DEVICE_LOST = new ErrorType(0x00000005, "DEVICE_LOST");

	public static ErrorType from(int bits) {
		return map.get(bits);
	}

	private ErrorType(int bits, String name) {
		super(bits, name);
		map.put(bits, this);
	}
}
