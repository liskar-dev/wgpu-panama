package wgpu.enums;

public interface ColorWriteMask {
	public static final int NONE = 0x00000000;
	public static final int RED = 0x00000001;
	public static final int GREEN = 0x00000002;
	public static final int BLUE = 0x00000004;
	public static final int ALPHA = 0x00000008;
	public static final int ALL = NONE | RED | GREEN | BLUE | ALPHA;
}
