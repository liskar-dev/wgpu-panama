package wgpu.enums;

import wgpu.CEnum;
import java.util.*;

public class BufferMapState extends CEnum {
	private static final Map<Integer, BufferMapState> map = new HashMap<>();
	public static final BufferMapState UNMAPPED = new BufferMapState(0x00000000, "Unmapped");
	public static final BufferMapState PENDING = new BufferMapState(0x00000001, "Pending");
	public static final BufferMapState MAPPED = new BufferMapState(0x00000002, "Mapped");

	public static BufferMapState from(int bits) {
		return map.get(bits);
	}

	private BufferMapState(int bits, String name) {
		super(bits, name);
		map.put(bits, this);
	}
}
