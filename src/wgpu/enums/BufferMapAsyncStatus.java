package wgpu.enums;

import wgpu.CEnum;
import java.util.*;

public class BufferMapAsyncStatus extends CEnum {
	private static final Map<Integer, BufferMapAsyncStatus> map = new HashMap<>();
	public static final BufferMapAsyncStatus SUCCESS = new BufferMapAsyncStatus(0x00000000, "Success");
	public static final BufferMapAsyncStatus VALIDATION_ERROR = new BufferMapAsyncStatus(0x00000001, "ValidationError");
	public static final BufferMapAsyncStatus UNKNOWN = new BufferMapAsyncStatus(0x00000002, "Unknown");
	public static final BufferMapAsyncStatus DEVICE_LOST = new BufferMapAsyncStatus(0x00000003, "DeviceLost");
	public static final BufferMapAsyncStatus DESTROYED_BEFORE_CALLBACK = new BufferMapAsyncStatus(0x00000004, "DestroyedBeforeCallback");
	public static final BufferMapAsyncStatus UNMAPPED_BEFORE_CALLBACK = new BufferMapAsyncStatus(0x00000005, "UnmappedBeforeCallback");
	public static final BufferMapAsyncStatus MAPPING_ALREADY_PENDING = new BufferMapAsyncStatus(0x00000006, "MappingAlreadyPending");
	public static final BufferMapAsyncStatus OFFSET_OUT_OF_RANGE = new BufferMapAsyncStatus(0x00000007, "OffsetOutOfRange");
	public static final BufferMapAsyncStatus SIZE_OUT_OF_RANGE = new BufferMapAsyncStatus(0x00000008, "SizeOutOfRange");

	public static BufferMapAsyncStatus from(int bits) {
		return map.get(bits);
	}

	private BufferMapAsyncStatus(int bits, String name) {
		super(bits, name);
		map.put(bits, this);
	}
}
