package wgpu.enums;

import wgpu.CEnum;
import java.util.*;

public class MipmapFilterMode extends CEnum {
	private static final Map<Integer, MipmapFilterMode> map = new HashMap<>();
	public static final MipmapFilterMode NEAREST = new MipmapFilterMode(0x00000000, "NEAREST");
	public static final MipmapFilterMode LINEAR = new MipmapFilterMode(0x00000001, "LINEAR");

	public static MipmapFilterMode from(int bits) {
		return map.get(bits);
	}

	private MipmapFilterMode(int bits, String name) {
		super(bits, name);
		map.put(bits, this);
	}
}
