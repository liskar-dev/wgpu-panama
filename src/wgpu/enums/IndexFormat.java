package wgpu.enums;

import wgpu.CEnum;
import java.util.*;

public class IndexFormat extends CEnum {
	private static final Map<Integer, IndexFormat> map = new HashMap<>();
	public static final IndexFormat UNDEFINED = new IndexFormat(0x00000000, "Undefined");
	public static final IndexFormat UINT16 = new IndexFormat(0x00000001, "Uint16");
	public static final IndexFormat UINT32 = new IndexFormat(0x00000002, "Uint32");

	public static IndexFormat from(int bits) {
		return map.get(bits);
	}

	private IndexFormat(int bits, String name) {
		super(bits, name);
		map.put(bits, this);
	}
}
