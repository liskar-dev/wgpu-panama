package wgpu.enums;

import wgpu.CEnum;
import java.util.*;

public class CompilationInfoRequestStatus extends CEnum {
	private static final Map<Integer, CompilationInfoRequestStatus> map = new HashMap<>();
	public static final CompilationInfoRequestStatus SUCCESS = new CompilationInfoRequestStatus(0x00000000, "Success");
	public static final CompilationInfoRequestStatus ERROR = new CompilationInfoRequestStatus(0x00000001, "Error");
	public static final CompilationInfoRequestStatus DEVICE_LOST = new CompilationInfoRequestStatus(0x00000002, "DeviceLost");
	public static final CompilationInfoRequestStatus UNKNOWN = new CompilationInfoRequestStatus(0x00000003, "Unknown");

	public static CompilationInfoRequestStatus from(int bits) {
		return map.get(bits);
	}

	private CompilationInfoRequestStatus(int bits, String name) {
		super(bits, name);
		map.put(bits, this);
	}
}
