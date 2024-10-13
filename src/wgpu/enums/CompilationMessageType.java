package wgpu.enums;

import wgpu.WGPUEnum;
import java.util.*;

public class CompilationMessageType extends WGPUEnum {
	private static final Map<Integer, CompilationMessageType> map = new HashMap<>();
	public static final CompilationMessageType ERROR = new CompilationMessageType(0x00000000, "ERROR");
	public static final CompilationMessageType WARNING = new CompilationMessageType(0x00000001, "WARNING");
	public static final CompilationMessageType INFO = new CompilationMessageType(0x00000002, "INFO");

	public static CompilationMessageType from(int bits) {
		return map.get(bits);
	}

	private CompilationMessageType(int bits, String name) {
		super(bits, name);
		map.put(bits, this);
	}
}
