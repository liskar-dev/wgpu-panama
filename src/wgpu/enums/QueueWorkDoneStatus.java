package wgpu.enums;

import wgpu.WGPUEnum;
import java.util.*;

public class QueueWorkDoneStatus extends WGPUEnum {
	private static final Map<Integer, QueueWorkDoneStatus> map = new HashMap<>();
	public static final QueueWorkDoneStatus SUCCESS = new QueueWorkDoneStatus(0x00000000, "SUCCESS");
	public static final QueueWorkDoneStatus ERROR = new QueueWorkDoneStatus(0x00000001, "ERROR");
	public static final QueueWorkDoneStatus UNKNOWN = new QueueWorkDoneStatus(0x00000002, "UNKNOWN");
	public static final QueueWorkDoneStatus DEVICE_LOST = new QueueWorkDoneStatus(0x00000003, "DEVICE_LOST");

	public static QueueWorkDoneStatus from(int bits) {
		return map.get(bits);
	}

	private QueueWorkDoneStatus(int bits, String name) {
		super(bits, name);
		map.put(bits, this);
	}
}
