package wgpu.enums;

import wgpu.WGPUEnum;
import java.util.*;

public class BufferMapAsyncStatus extends WGPUEnum {
	private static final Map<Integer, BufferMapAsyncStatus> map = new HashMap<>();
	public static final BufferMapAsyncStatus SUCCESS = new BufferMapAsyncStatus(0x00000000, "SUCCESS");
	public static final BufferMapAsyncStatus VALIDATION_ERROR = new BufferMapAsyncStatus(0x00000001, "VALIDATION_ERROR");
	public static final BufferMapAsyncStatus UNKNOWN = new BufferMapAsyncStatus(0x00000002, "UNKNOWN");
	public static final BufferMapAsyncStatus DEVICE_LOST = new BufferMapAsyncStatus(0x00000003, "DEVICE_LOST");
	public static final BufferMapAsyncStatus DESTROYED_BEFORE_CALLBACK = new BufferMapAsyncStatus(0x00000004, "DESTROYED_BEFORE_CALLBACK");
	public static final BufferMapAsyncStatus UNMAPPED_BEFORE_CALLBACK = new BufferMapAsyncStatus(0x00000005, "UNMAPPED_BEFORE_CALLBACK");
	public static final BufferMapAsyncStatus MAPPING_ALREADY_PENDING = new BufferMapAsyncStatus(0x00000006, "MAPPING_ALREADY_PENDING");
	public static final BufferMapAsyncStatus OFFSET_OUT_OF_RANGE = new BufferMapAsyncStatus(0x00000007, "OFFSET_OUT_OF_RANGE");
	public static final BufferMapAsyncStatus SIZE_OUT_OF_RANGE = new BufferMapAsyncStatus(0x00000008, "SIZE_OUT_OF_RANGE");

	public static BufferMapAsyncStatus from(int bits) {
		return map.get(bits);
	}

	private BufferMapAsyncStatus(int bits, String name) {
		super(bits, name);
		map.put(bits, this);
	}
}
