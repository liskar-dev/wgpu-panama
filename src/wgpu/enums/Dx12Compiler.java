package wgpu.enums;

import wgpu.CEnum;
import java.util.*;

public class Dx12Compiler extends CEnum {
	private static final Map<Integer, Dx12Compiler> map = new HashMap<>();
	public static final Dx12Compiler UNDEFINED = new Dx12Compiler(0x00000000, "UNDEFINED");
	public static final Dx12Compiler FXC = new Dx12Compiler(0x00000001, "FXC");
	public static final Dx12Compiler DXC = new Dx12Compiler(0x00000002, "DXC");

	public static Dx12Compiler from(int bits) {
		return map.get(bits);
	}

	private Dx12Compiler(int bits, String name) {
		super(bits, name);
		map.put(bits, this);
	}
}
