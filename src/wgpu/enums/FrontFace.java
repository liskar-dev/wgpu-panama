package wgpu.enums;

import wgpu.WGPUEnum;
import java.util.*;

public class FrontFace extends WGPUEnum {
	private static final Map<Integer, FrontFace> map = new HashMap<>();
	public static final FrontFace CCW = new FrontFace(0x00000000, "CCW");
	public static final FrontFace CW = new FrontFace(0x00000001, "CW");

	public static FrontFace from(int bits) {
		return map.get(bits);
	}

	private FrontFace(int bits, String name) {
		super(bits, name);
		map.put(bits, this);
	}
}
