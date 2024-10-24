package wgpu.enums;

import wgpu.CEnum;
import java.util.*;

public class RequestAdapterStatus extends CEnum {
	private static final Map<Integer, RequestAdapterStatus> map = new HashMap<>();
	public static final RequestAdapterStatus SUCCESS = new RequestAdapterStatus(0x00000000, "Success");
	public static final RequestAdapterStatus UNAVAILABLE = new RequestAdapterStatus(0x00000001, "Unavailable");
	public static final RequestAdapterStatus ERROR = new RequestAdapterStatus(0x00000002, "Error");
	public static final RequestAdapterStatus UNKNOWN = new RequestAdapterStatus(0x00000003, "Unknown");

	public static RequestAdapterStatus from(int bits) {
		return map.get(bits);
	}

	private RequestAdapterStatus(int bits, String name) {
		super(bits, name);
		map.put(bits, this);
	}
}
