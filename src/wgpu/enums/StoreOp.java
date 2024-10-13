package wgpu.enums;

import wgpu.WGPUEnum;
import java.util.*;

public class StoreOp extends WGPUEnum {
	private static final Map<Integer, StoreOp> map = new HashMap<>();
	public static final StoreOp UNDEFINED = new StoreOp(0x00000000, "UNDEFINED");
	public static final StoreOp STORE = new StoreOp(0x00000001, "STORE");
	public static final StoreOp DISCARD = new StoreOp(0x00000002, "DISCARD");

	public static StoreOp from(int bits) {
		return map.get(bits);
	}

	private StoreOp(int bits, String name) {
		super(bits, name);
		map.put(bits, this);
	}
}
