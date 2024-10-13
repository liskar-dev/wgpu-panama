package wgpu.enums;

import wgpu.WGPUEnum;
import java.util.*;

public class CompilationInfoRequestStatus extends WGPUEnum {
	private static final Map<Integer, CompilationInfoRequestStatus> map = new HashMap<>();
	public static final CompilationInfoRequestStatus SUCCESS = new CompilationInfoRequestStatus(0x00000000, "SUCCESS");
	public static final CompilationInfoRequestStatus ERROR = new CompilationInfoRequestStatus(0x00000001, "ERROR");
	public static final CompilationInfoRequestStatus DEVICE_LOST = new CompilationInfoRequestStatus(0x00000002, "DEVICE_LOST");
	public static final CompilationInfoRequestStatus UNKNOWN = new CompilationInfoRequestStatus(0x00000003, "UNKNOWN");

	public static CompilationInfoRequestStatus from(int bits) {
		return map.get(bits);
	}

	private CompilationInfoRequestStatus(int bits, String name) {
		super(bits, name);
		map.put(bits, this);
	}
}
