package wgpu.enums;

import wgpu.CEnum;
import java.util.*;

public class FilterMode extends CEnum {
	private static final Map<Integer, FilterMode> map = new HashMap<>();
	public static final FilterMode NEAREST = new FilterMode(0x00000000, "NEAREST");
	public static final FilterMode LINEAR = new FilterMode(0x00000001, "LINEAR");

	public static FilterMode from(int bits) {
		return map.get(bits);
	}

	private FilterMode(int bits, String name) {
		super(bits, name);
		map.put(bits, this);
	}
}
