package wgpu.enums;

import wgpu.WGPUEnum;
import java.util.*;

public class BufferMapState extends WGPUEnum {
	private static final Map<Integer, BufferMapState> map = new HashMap<>();
	public static final BufferMapState UNMAPPED = new BufferMapState(0x00000000, "UNMAPPED");
	public static final BufferMapState PENDING = new BufferMapState(0x00000001, "PENDING");
	public static final BufferMapState MAPPED = new BufferMapState(0x00000002, "MAPPED");

	public static BufferMapState from(int bits) {
		return map.get(bits);
	}

	private BufferMapState(int bits, String name) {
		super(bits, name);
		map.put(bits, this);
	}
}
