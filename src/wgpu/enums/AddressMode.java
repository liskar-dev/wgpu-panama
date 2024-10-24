package wgpu.enums;

import wgpu.CEnum;
import java.util.*;

public class AddressMode extends CEnum {
	private static final Map<Integer, AddressMode> map = new HashMap<>();
	public static final AddressMode REPEAT = new AddressMode(0x00000000, "REPEAT");
	public static final AddressMode MIRROR_REPEAT = new AddressMode(0x00000001, "MIRROR_REPEAT");
	public static final AddressMode CLAMP_TO_EDGE = new AddressMode(0x00000002, "CLAMP_TO_EDGE");

	public static AddressMode from(int bits) {
		return map.get(bits);
	}

	private AddressMode(int bits, String name) {
		super(bits, name);
		map.put(bits, this);
	}
}
