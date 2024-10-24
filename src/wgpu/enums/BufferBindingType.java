package wgpu.enums;

import wgpu.CEnum;
import java.util.*;

public class BufferBindingType extends CEnum {
	private static final Map<Integer, BufferBindingType> map = new HashMap<>();
	public static final BufferBindingType UNDEFINED = new BufferBindingType(0x00000000, "Undefined");
	public static final BufferBindingType UNIFORM = new BufferBindingType(0x00000001, "Uniform");
	public static final BufferBindingType STORAGE = new BufferBindingType(0x00000002, "Storage");
	public static final BufferBindingType READ_ONLY_STORAGE = new BufferBindingType(0x00000003, "ReadOnlyStorage");

	public static BufferBindingType from(int bits) {
		return map.get(bits);
	}

	private BufferBindingType(int bits, String name) {
		super(bits, name);
		map.put(bits, this);
	}
}
