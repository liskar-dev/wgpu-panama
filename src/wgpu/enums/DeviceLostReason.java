package wgpu.enums;

import wgpu.CEnum;
import java.util.*;

public class DeviceLostReason extends CEnum {
	private static final Map<Integer, DeviceLostReason> map = new HashMap<>();
	public static final DeviceLostReason UNKNOWN = new DeviceLostReason(0x00000001, "Unknown");
	public static final DeviceLostReason DESTROYED = new DeviceLostReason(0x00000002, "Destroyed");

	public static DeviceLostReason from(int bits) {
		return map.get(bits);
	}

	private DeviceLostReason(int bits, String name) {
		super(bits, name);
		map.put(bits, this);
	}
}
