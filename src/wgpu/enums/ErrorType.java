package wgpu.enums;

import wgpu.CEnum;
import java.util.*;

public class ErrorType extends CEnum {
	private static final Map<Integer, ErrorType> map = new HashMap<>();
	public static final ErrorType NO_ERROR = new ErrorType(0x00000000, "NoError");
	public static final ErrorType VALIDATION = new ErrorType(0x00000001, "Validation");
	public static final ErrorType OUT_OF_MEMORY = new ErrorType(0x00000002, "OutOfMemory");
	public static final ErrorType INTERNAL = new ErrorType(0x00000003, "Internal");
	public static final ErrorType UNKNOWN = new ErrorType(0x00000004, "Unknown");
	public static final ErrorType DEVICE_LOST = new ErrorType(0x00000005, "DeviceLost");

	public static ErrorType from(int bits) {
		return map.get(bits);
	}

	private ErrorType(int bits, String name) {
		super(bits, name);
		map.put(bits, this);
	}
}
