package wgpu.enums;

import wgpu.WGPUEnum;
import java.util.*;

public class PresentMode extends WGPUEnum {
	private static final Map<Integer, PresentMode> map = new HashMap<>();
	public static final PresentMode FIFO = new PresentMode(0x00000000, "FIFO");
	public static final PresentMode FIFO_RELAXED = new PresentMode(0x00000001, "FIFO_RELAXED");
	public static final PresentMode IMMEDIATE = new PresentMode(0x00000002, "IMMEDIATE");
	public static final PresentMode MAILBOX = new PresentMode(0x00000003, "MAILBOX");

	public static PresentMode from(int bits) {
		return map.get(bits);
	}

	private PresentMode(int bits, String name) {
		super(bits, name);
		map.put(bits, this);
	}
}
