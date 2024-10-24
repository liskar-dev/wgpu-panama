package wgpu.enums;

import wgpu.CEnum;
import java.util.*;

public class TextureViewDimension extends CEnum {
	private static final Map<Integer, TextureViewDimension> map = new HashMap<>();
	public static final TextureViewDimension UNDEFINED = new TextureViewDimension(0x00000000, "Undefined");
	public static final TextureViewDimension D1 = new TextureViewDimension(0x00000001, "1D");
	public static final TextureViewDimension D2 = new TextureViewDimension(0x00000002, "2D");
	public static final TextureViewDimension D2_ARRAY = new TextureViewDimension(0x00000003, "2DArray");
	public static final TextureViewDimension CUBE = new TextureViewDimension(0x00000004, "Cube");
	public static final TextureViewDimension CUBE_ARRAY = new TextureViewDimension(0x00000005, "CubeArray");
	public static final TextureViewDimension D3 = new TextureViewDimension(0x00000006, "3D");

	public static TextureViewDimension from(int bits) {
		return map.get(bits);
	}

	private TextureViewDimension(int bits, String name) {
		super(bits, name);
		map.put(bits, this);
	}
}
