package wgpu.enums;

import wgpu.CEnum;
import java.util.*;

public class SamplerBindingType extends CEnum {
	private static final Map<Integer, SamplerBindingType> map = new HashMap<>();
	public static final SamplerBindingType UNDEFINED = new SamplerBindingType(0x00000000, "UNDEFINED");
	public static final SamplerBindingType FILTERING = new SamplerBindingType(0x00000001, "FILTERING");
	public static final SamplerBindingType NON_FILTERING = new SamplerBindingType(0x00000002, "NON_FILTERING");
	public static final SamplerBindingType COMPARISON = new SamplerBindingType(0x00000003, "COMPARISON");

	public static SamplerBindingType from(int bits) {
		return map.get(bits);
	}

	private SamplerBindingType(int bits, String name) {
		super(bits, name);
		map.put(bits, this);
	}
}
