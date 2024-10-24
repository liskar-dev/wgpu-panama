package wgpu.enums;

import wgpu.CEnum;
import java.util.*;

public class SurfaceGetCurrentTextureStatus extends CEnum {
	private static final Map<Integer, SurfaceGetCurrentTextureStatus> map = new HashMap<>();
	public static final SurfaceGetCurrentTextureStatus SUCCESS = new SurfaceGetCurrentTextureStatus(0x00000000, "Success");
	public static final SurfaceGetCurrentTextureStatus TIMEOUT = new SurfaceGetCurrentTextureStatus(0x00000001, "Timeout");
	public static final SurfaceGetCurrentTextureStatus OUTDATED = new SurfaceGetCurrentTextureStatus(0x00000002, "Outdated");
	public static final SurfaceGetCurrentTextureStatus LOST = new SurfaceGetCurrentTextureStatus(0x00000003, "Lost");
	public static final SurfaceGetCurrentTextureStatus OUT_OF_MEMORY = new SurfaceGetCurrentTextureStatus(0x00000004, "OutOfMemory");
	public static final SurfaceGetCurrentTextureStatus DEVICE_LOST = new SurfaceGetCurrentTextureStatus(0x00000005, "DeviceLost");

	public static SurfaceGetCurrentTextureStatus from(int bits) {
		return map.get(bits);
	}

	private SurfaceGetCurrentTextureStatus(int bits, String name) {
		super(bits, name);
		map.put(bits, this);
	}
}
