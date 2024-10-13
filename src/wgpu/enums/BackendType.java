package wgpu.enums;

import wgpu.WGPUEnum;
import java.util.*;

public class BackendType extends WGPUEnum {
	private static final Map<Integer, BackendType> map = new HashMap<>();
	public static final BackendType UNDEFINED = new BackendType(0x00000000, "UNDEFINED");
	public static final BackendType NULL = new BackendType(0x00000001, "NULL");
	public static final BackendType WEB_GPU = new BackendType(0x00000002, "WEB_GPU");
	public static final BackendType D3_D11 = new BackendType(0x00000003, "D3_D11");
	public static final BackendType D3_D12 = new BackendType(0x00000004, "D3_D12");
	public static final BackendType METAL = new BackendType(0x00000005, "METAL");
	public static final BackendType VULKAN = new BackendType(0x00000006, "VULKAN");
	public static final BackendType OPEN_GL = new BackendType(0x00000007, "OPEN_GL");
	public static final BackendType OPEN_GLES = new BackendType(0x00000008, "OPEN_GLES");

	public static BackendType from(int bits) {
		return map.get(bits);
	}

	private BackendType(int bits, String name) {
		super(bits, name);
		map.put(bits, this);
	}
}
