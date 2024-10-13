package wgpu.enums;

import wgpu.WGPUEnum;
import java.util.*;

public class BufferBindingType extends WGPUEnum {
	private static final Map<Integer, BufferBindingType> map = new HashMap<>();
	public static final BufferBindingType UNDEFINED = new BufferBindingType(0x00000000, "UNDEFINED");
	public static final BufferBindingType UNIFORM = new BufferBindingType(0x00000001, "UNIFORM");
	public static final BufferBindingType STORAGE = new BufferBindingType(0x00000002, "STORAGE");
	public static final BufferBindingType READ_ONLY_STORAGE = new BufferBindingType(0x00000003, "READ_ONLY_STORAGE");

	public static BufferBindingType from(int bits) {
		return map.get(bits);
	}

	private BufferBindingType(int bits, String name) {
		super(bits, name);
		map.put(bits, this);
	}
}
