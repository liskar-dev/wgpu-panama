package wgpu.enums;

import wgpu.CEnum;
import java.util.*;

public class PowerPreference extends CEnum {
	private static final Map<Integer, PowerPreference> map = new HashMap<>();
	public static final PowerPreference UNDEFINED = new PowerPreference(0x00000000, "Undefined");
	public static final PowerPreference LOW_POWER = new PowerPreference(0x00000001, "LowPower");
	public static final PowerPreference HIGH_PERFORMANCE = new PowerPreference(0x00000002, "HighPerformance");

	public static PowerPreference from(int bits) {
		return map.get(bits);
	}

	private PowerPreference(int bits, String name) {
		super(bits, name);
		map.put(bits, this);
	}
}
