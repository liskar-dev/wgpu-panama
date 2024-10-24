package wgpu.enums;

import wgpu.CEnum;
import java.util.*;

public class CompilationMessageType extends CEnum {
	private static final Map<Integer, CompilationMessageType> map = new HashMap<>();
	public static final CompilationMessageType ERROR = new CompilationMessageType(0x00000000, "Error");
	public static final CompilationMessageType WARNING = new CompilationMessageType(0x00000001, "Warning");
	public static final CompilationMessageType INFO = new CompilationMessageType(0x00000002, "Info");

	public static CompilationMessageType from(int bits) {
		return map.get(bits);
	}

	private CompilationMessageType(int bits, String name) {
		super(bits, name);
		map.put(bits, this);
	}
}
