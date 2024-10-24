package wgpu.enums;

import wgpu.CEnum;
import java.util.*;

public class PresentMode extends CEnum {
	private static final Map<Integer, PresentMode> map = new HashMap<>();
	public static final PresentMode FIFO = new PresentMode(0x00000000, "Fifo");
	public static final PresentMode FIFO_RELAXED = new PresentMode(0x00000001, "FifoRelaxed");
	public static final PresentMode IMMEDIATE = new PresentMode(0x00000002, "Immediate");
	public static final PresentMode MAILBOX = new PresentMode(0x00000003, "Mailbox");

	public static PresentMode from(int bits) {
		return map.get(bits);
	}

	private PresentMode(int bits, String name) {
		super(bits, name);
		map.put(bits, this);
	}
}
