package wgpu.enums;

import wgpu.WGPUEnum;
import java.util.*;

public class TextureAspect extends WGPUEnum {
	private static final Map<Integer, TextureAspect> map = new HashMap<>();
	public static final TextureAspect ALL = new TextureAspect(0x00000000, "ALL");
	public static final TextureAspect STENCIL_ONLY = new TextureAspect(0x00000001, "STENCIL_ONLY");
	public static final TextureAspect DEPTH_ONLY = new TextureAspect(0x00000002, "DEPTH_ONLY");

	public static TextureAspect from(int bits) {
		return map.get(bits);
	}

	private TextureAspect(int bits, String name) {
		super(bits, name);
		map.put(bits, this);
	}
}
