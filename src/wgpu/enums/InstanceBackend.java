package wgpu.enums;

public interface InstanceBackend {
	public static final int ALL = 0x00000000;
	public static final int VULKAN = 1 << 0;
	public static final int GL = 1 << 1;
	public static final int METAL = 1 << 2;
	public static final int DX12 = 1 << 3;
	public static final int DX11 = 1 << 4;
	public static final int BROWSER_WEB_GPU = 1 << 5;
	public static final int PRIMARY = VULKAN | METAL | DX12 | BROWSER_WEB_GPU;
	public static final int SECONDARY = GL | DX11;
}
