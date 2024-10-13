package wgpu.enums;

import wgpu.WGPUEnum;
import java.util.*;

public class CreatePipelineAsyncStatus extends WGPUEnum {
	private static final Map<Integer, CreatePipelineAsyncStatus> map = new HashMap<>();
	public static final CreatePipelineAsyncStatus SUCCESS = new CreatePipelineAsyncStatus(0x00000000, "SUCCESS");
	public static final CreatePipelineAsyncStatus VALIDATION_ERROR = new CreatePipelineAsyncStatus(0x00000001, "VALIDATION_ERROR");
	public static final CreatePipelineAsyncStatus INTERNAL_ERROR = new CreatePipelineAsyncStatus(0x00000002, "INTERNAL_ERROR");
	public static final CreatePipelineAsyncStatus DEVICE_LOST = new CreatePipelineAsyncStatus(0x00000003, "DEVICE_LOST");
	public static final CreatePipelineAsyncStatus DEVICE_DESTROYED = new CreatePipelineAsyncStatus(0x00000004, "DEVICE_DESTROYED");
	public static final CreatePipelineAsyncStatus UNKNOWN = new CreatePipelineAsyncStatus(0x00000005, "UNKNOWN");

	public static CreatePipelineAsyncStatus from(int bits) {
		return map.get(bits);
	}

	private CreatePipelineAsyncStatus(int bits, String name) {
		super(bits, name);
		map.put(bits, this);
	}
}
