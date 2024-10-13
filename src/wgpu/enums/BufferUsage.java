package wgpu.enums;

public interface BufferUsage {
	public static final int NONE = 0x00000000;
	public static final int MAP_READ = 0x00000001;
	public static final int MAP_WRITE = 0x00000002;
	public static final int COPY_SRC = 0x00000004;
	public static final int COPY_DST = 0x00000008;
	public static final int INDEX = 0x00000010;
	public static final int VERTEX = 0x00000020;
	public static final int UNIFORM = 0x00000040;
	public static final int STORAGE = 0x00000080;
	public static final int INDIRECT = 0x00000100;
	public static final int QUERY_RESOLVE = 0x00000200;
}
