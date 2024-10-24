package wgpu.enums;

import wgpu.CEnum;
import java.util.*;

public class AdapterType extends CEnum {
	private static final Map<Integer, AdapterType> map = new HashMap<>();
	public static final AdapterType DISCRETE_GPU = new AdapterType(0x00000000, "DiscreteGPU");
	public static final AdapterType INTEGRATED_GPU = new AdapterType(0x00000001, "IntegratedGPU");
	public static final AdapterType CPU = new AdapterType(0x00000002, "CPU");
	public static final AdapterType UNKNOWN = new AdapterType(0x00000003, "Unknown");

	public static AdapterType from(int bits) {
		return map.get(bits);
	}

	private AdapterType(int bits, String name) {
		super(bits, name);
		map.put(bits, this);
	}
}
