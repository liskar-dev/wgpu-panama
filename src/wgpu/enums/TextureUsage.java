package wgpu.enums;

public interface TextureUsage {
	public static final int NONE = 0x00000000;
	public static final int COPY_SRC = 0x00000001;
	public static final int COPY_DST = 0x00000002;
	public static final int TEXTURE_BINDING = 0x00000004;
	public static final int STORAGE_BINDING = 0x00000008;
	public static final int RENDER_ATTACHMENT = 0x00000010;
}
