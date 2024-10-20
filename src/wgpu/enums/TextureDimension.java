package wgpu.enums;

import wgpu.WGPUEnum;
import java.util.*;

public class TextureDimension extends WGPUEnum {
	private static final Map<Integer, TextureDimension> map = new HashMap<>();
	public static final TextureDimension D1 = new TextureDimension(0x00000000, "D1");
	public static final TextureDimension D2 = new TextureDimension(0x00000001, "D2");
	public static final TextureDimension D3 = new TextureDimension(0x00000002, "D3");

	public static TextureDimension from(int bits) {
		return map.get(bits);
	}

	private TextureDimension(int bits, String name) {
		super(bits, name);
		map.put(bits, this);
	}
}
