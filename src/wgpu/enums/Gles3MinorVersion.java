package wgpu.enums;

import wgpu.WGPUEnum;
import java.util.*;

public class Gles3MinorVersion extends WGPUEnum {
	private static final Map<Integer, Gles3MinorVersion> map = new HashMap<>();
	public static final Gles3MinorVersion AUTOMATIC = new Gles3MinorVersion(0x00000000, "AUTOMATIC");
	public static final Gles3MinorVersion VERSION0 = new Gles3MinorVersion(0x00000001, "VERSION0");
	public static final Gles3MinorVersion VERSION1 = new Gles3MinorVersion(0x00000002, "VERSION1");
	public static final Gles3MinorVersion VERSION2 = new Gles3MinorVersion(0x00000003, "VERSION2");

	public static Gles3MinorVersion from(int bits) {
		return map.get(bits);
	}

	private Gles3MinorVersion(int bits, String name) {
		super(bits, name);
		map.put(bits, this);
	}
}
