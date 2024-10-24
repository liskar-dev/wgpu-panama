package wgpu.enums;

import wgpu.CEnum;
import java.util.*;

public class LogLevel extends CEnum {
	private static final Map<Integer, LogLevel> map = new HashMap<>();
	public static final LogLevel OFF = new LogLevel(0x00000000, "Off");
	public static final LogLevel ERROR = new LogLevel(0x00000001, "Error");
	public static final LogLevel WARN = new LogLevel(0x00000002, "Warn");
	public static final LogLevel INFO = new LogLevel(0x00000003, "Info");
	public static final LogLevel DEBUG = new LogLevel(0x00000004, "Debug");
	public static final LogLevel TRACE = new LogLevel(0x00000005, "Trace");

	public static LogLevel from(int bits) {
		return map.get(bits);
	}

	private LogLevel(int bits, String name) {
		super(bits, name);
		map.put(bits, this);
	}
}
