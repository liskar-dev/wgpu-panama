package wgpu.enums;

import wgpu.WGPUEnum;
import java.util.*;

public class RequestDeviceStatus extends WGPUEnum {
	private static final Map<Integer, RequestDeviceStatus> map = new HashMap<>();
	public static final RequestDeviceStatus SUCCESS = new RequestDeviceStatus(0x00000000, "SUCCESS");
	public static final RequestDeviceStatus ERROR = new RequestDeviceStatus(0x00000001, "ERROR");
	public static final RequestDeviceStatus UNKNOWN = new RequestDeviceStatus(0x00000002, "UNKNOWN");

	public static RequestDeviceStatus from(int bits) {
		return map.get(bits);
	}

	private RequestDeviceStatus(int bits, String name) {
		super(bits, name);
		map.put(bits, this);
	}
}
