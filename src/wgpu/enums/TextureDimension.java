package wgpu.enums;

import wgpu.CEnum;
import java.util.*;

public class TextureDimension extends CEnum {
	private static final Map<Integer, TextureDimension> map = new HashMap<>();
	public static final TextureDimension D1 = new TextureDimension(0x00000000, "1D");
	public static final TextureDimension D2 = new TextureDimension(0x00000001, "2D");
	public static final TextureDimension D3 = new TextureDimension(0x00000002, "3D");

	public static TextureDimension from(int bits) {
		return map.get(bits);
	}

	private TextureDimension(int bits, String name) {
		super(bits, name);
		map.put(bits, this);
	}
}
