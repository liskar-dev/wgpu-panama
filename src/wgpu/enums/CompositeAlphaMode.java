package wgpu.enums;

import wgpu.CEnum;
import java.util.*;

public class CompositeAlphaMode extends CEnum {
	private static final Map<Integer, CompositeAlphaMode> map = new HashMap<>();
	public static final CompositeAlphaMode AUTO = new CompositeAlphaMode(0x00000000, "AUTO");
	public static final CompositeAlphaMode OPAQUE = new CompositeAlphaMode(0x00000001, "OPAQUE");
	public static final CompositeAlphaMode PREMULTIPLIED = new CompositeAlphaMode(0x00000002, "PREMULTIPLIED");
	public static final CompositeAlphaMode UNPREMULTIPLIED = new CompositeAlphaMode(0x00000003, "UNPREMULTIPLIED");
	public static final CompositeAlphaMode INHERIT = new CompositeAlphaMode(0x00000004, "INHERIT");

	public static CompositeAlphaMode from(int bits) {
		return map.get(bits);
	}

	private CompositeAlphaMode(int bits, String name) {
		super(bits, name);
		map.put(bits, this);
	}
}
