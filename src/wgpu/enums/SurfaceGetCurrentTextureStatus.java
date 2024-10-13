package wgpu.enums;

import wgpu.WGPUEnum;
import java.util.*;

public class SurfaceGetCurrentTextureStatus extends WGPUEnum {
	private static final Map<Integer, SurfaceGetCurrentTextureStatus> map = new HashMap<>();
	public static final SurfaceGetCurrentTextureStatus SUCCESS = new SurfaceGetCurrentTextureStatus(0x00000000, "SUCCESS");
	public static final SurfaceGetCurrentTextureStatus TIMEOUT = new SurfaceGetCurrentTextureStatus(0x00000001, "TIMEOUT");
	public static final SurfaceGetCurrentTextureStatus OUTDATED = new SurfaceGetCurrentTextureStatus(0x00000002, "OUTDATED");
	public static final SurfaceGetCurrentTextureStatus LOST = new SurfaceGetCurrentTextureStatus(0x00000003, "LOST");
	public static final SurfaceGetCurrentTextureStatus OUT_OF_MEMORY = new SurfaceGetCurrentTextureStatus(0x00000004, "OUT_OF_MEMORY");
	public static final SurfaceGetCurrentTextureStatus DEVICE_LOST = new SurfaceGetCurrentTextureStatus(0x00000005, "DEVICE_LOST");

	public static SurfaceGetCurrentTextureStatus from(int bits) {
		return map.get(bits);
	}

	private SurfaceGetCurrentTextureStatus(int bits, String name) {
		super(bits, name);
		map.put(bits, this);
	}
}
