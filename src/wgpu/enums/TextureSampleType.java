package wgpu.enums;

import wgpu.CEnum;
import java.util.*;

public class TextureSampleType extends CEnum {
	private static final Map<Integer, TextureSampleType> map = new HashMap<>();
	public static final TextureSampleType UNDEFINED = new TextureSampleType(0x00000000, "Undefined");
	public static final TextureSampleType FLOAT = new TextureSampleType(0x00000001, "Float");
	public static final TextureSampleType UNFILTERABLE_FLOAT = new TextureSampleType(0x00000002, "UnfilterableFloat");
	public static final TextureSampleType DEPTH = new TextureSampleType(0x00000003, "Depth");
	public static final TextureSampleType SINT = new TextureSampleType(0x00000004, "Sint");
	public static final TextureSampleType UINT = new TextureSampleType(0x00000005, "Uint");

	public static TextureSampleType from(int bits) {
		return map.get(bits);
	}

	private TextureSampleType(int bits, String name) {
		super(bits, name);
		map.put(bits, this);
	}
}
