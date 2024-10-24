package wgpu.enums;

import wgpu.CEnum;
import java.util.*;

public class LoadOp extends CEnum {
	private static final Map<Integer, LoadOp> map = new HashMap<>();
	public static final LoadOp UNDEFINED = new LoadOp(0x00000000, "Undefined");
	public static final LoadOp CLEAR = new LoadOp(0x00000001, "Clear");
	public static final LoadOp LOAD = new LoadOp(0x00000002, "Load");

	public static LoadOp from(int bits) {
		return map.get(bits);
	}

	private LoadOp(int bits, String name) {
		super(bits, name);
		map.put(bits, this);
	}
}
