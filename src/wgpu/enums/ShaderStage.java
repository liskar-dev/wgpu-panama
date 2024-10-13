package wgpu.enums;

public interface ShaderStage {
	public static final int NONE = 0x00000000;
	public static final int VERTEX = 0x00000001;
	public static final int FRAGMENT = 0x00000002;
	public static final int COMPUTE = 0x00000004;
}
