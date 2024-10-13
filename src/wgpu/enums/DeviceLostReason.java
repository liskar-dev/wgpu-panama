package wgpu.enums;

import wgpu.WGPUEnum;
import java.util.*;

public class DeviceLostReason extends WGPUEnum {
	private static final Map<Integer, DeviceLostReason> map = new HashMap<>();
	public static final DeviceLostReason UNKNOWN = new DeviceLostReason(0x00000001, "UNKNOWN");
	public static final DeviceLostReason DESTROYED = new DeviceLostReason(0x00000002, "DESTROYED");

	public static DeviceLostReason from(int bits) {
		return map.get(bits);
	}

	private DeviceLostReason(int bits, String name) {
		super(bits, name);
		map.put(bits, this);
	}
}
