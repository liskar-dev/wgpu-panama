package wgpu.enums;

import wgpu.CEnum;
import java.util.*;

public class Gles3MinorVersion extends CEnum {
	private static final Map<Integer, Gles3MinorVersion> map = new HashMap<>();
	public static final Gles3MinorVersion AUTOMATIC = new Gles3MinorVersion(0x00000000, "Automatic");
	public static final Gles3MinorVersion VERSION0 = new Gles3MinorVersion(0x00000001, "Version0");
	public static final Gles3MinorVersion VERSION1 = new Gles3MinorVersion(0x00000002, "Version1");
	public static final Gles3MinorVersion VERSION2 = new Gles3MinorVersion(0x00000003, "Version2");

	public static Gles3MinorVersion from(int bits) {
		return map.get(bits);
	}

	private Gles3MinorVersion(int bits, String name) {
		super(bits, name);
		map.put(bits, this);
	}
}
