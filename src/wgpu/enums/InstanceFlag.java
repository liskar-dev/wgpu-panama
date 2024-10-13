package wgpu.enums;

public interface InstanceFlag {
	public static final int DEFAULT = 0x00000000;
	public static final int DEBUG = 1 << 0;
	public static final int VALIDATION = 1 << 1;
	public static final int DISCARD_HAL_LABELS = 1 << 2;
}
