package wgpu.enums;

import wgpu.WGPUEnum;
import java.util.*;

public class IndexFormat extends WGPUEnum {
	private static final Map<Integer, IndexFormat> map = new HashMap<>();
	public static final IndexFormat UNDEFINED = new IndexFormat(0x00000000, "UNDEFINED");
	public static final IndexFormat UINT16 = new IndexFormat(0x00000001, "UINT16");
	public static final IndexFormat UINT32 = new IndexFormat(0x00000002, "UINT32");

	public static IndexFormat from(int bits) {
		return map.get(bits);
	}

	private IndexFormat(int bits, String name) {
		super(bits, name);
		map.put(bits, this);
	}
}
