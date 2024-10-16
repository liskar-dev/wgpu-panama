package wgpu.enums;

import wgpu.WGPUEnum;
import java.util.*;

public class AdapterType extends WGPUEnum {
	private static final Map<Integer, AdapterType> map = new HashMap<>();
	public static final AdapterType DISCRETE_GPU = new AdapterType(0x00000000, "DISCRETE_GPU");
	public static final AdapterType INTEGRATED_GPU = new AdapterType(0x00000001, "INTEGRATED_GPU");
	public static final AdapterType CPU = new AdapterType(0x00000002, "CPU");
	public static final AdapterType UNKNOWN = new AdapterType(0x00000003, "UNKNOWN");

	public static AdapterType from(int bits) {
		return map.get(bits);
	}

	private AdapterType(int bits, String name) {
		super(bits, name);
		map.put(bits, this);
	}
}
