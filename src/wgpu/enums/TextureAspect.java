package wgpu.enums;

import wgpu.CEnum;
import java.util.*;

public class TextureAspect extends CEnum {
	private static final Map<Integer, TextureAspect> map = new HashMap<>();
	public static final TextureAspect ALL = new TextureAspect(0x00000000, "All");
	public static final TextureAspect STENCIL_ONLY = new TextureAspect(0x00000001, "StencilOnly");
	public static final TextureAspect DEPTH_ONLY = new TextureAspect(0x00000002, "DepthOnly");

	public static TextureAspect from(int bits) {
		return map.get(bits);
	}

	private TextureAspect(int bits, String name) {
		super(bits, name);
		map.put(bits, this);
	}
}
