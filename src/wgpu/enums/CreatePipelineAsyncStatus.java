package wgpu.enums;

import wgpu.CEnum;
import java.util.*;

public class CreatePipelineAsyncStatus extends CEnum {
	private static final Map<Integer, CreatePipelineAsyncStatus> map = new HashMap<>();
	public static final CreatePipelineAsyncStatus SUCCESS = new CreatePipelineAsyncStatus(0x00000000, "Success");
	public static final CreatePipelineAsyncStatus VALIDATION_ERROR = new CreatePipelineAsyncStatus(0x00000001, "ValidationError");
	public static final CreatePipelineAsyncStatus INTERNAL_ERROR = new CreatePipelineAsyncStatus(0x00000002, "InternalError");
	public static final CreatePipelineAsyncStatus DEVICE_LOST = new CreatePipelineAsyncStatus(0x00000003, "DeviceLost");
	public static final CreatePipelineAsyncStatus DEVICE_DESTROYED = new CreatePipelineAsyncStatus(0x00000004, "DeviceDestroyed");
	public static final CreatePipelineAsyncStatus UNKNOWN = new CreatePipelineAsyncStatus(0x00000005, "Unknown");

	public static CreatePipelineAsyncStatus from(int bits) {
		return map.get(bits);
	}

	private CreatePipelineAsyncStatus(int bits, String name) {
		super(bits, name);
		map.put(bits, this);
	}
}
