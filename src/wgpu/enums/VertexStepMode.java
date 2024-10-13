package wgpu.enums;

import wgpu.WGPUEnum;
import java.util.*;

public class VertexStepMode extends WGPUEnum {
	private static final Map<Integer, VertexStepMode> map = new HashMap<>();
	public static final VertexStepMode VERTEX = new VertexStepMode(0x00000000, "VERTEX");
	public static final VertexStepMode INSTANCE = new VertexStepMode(0x00000001, "INSTANCE");
	public static final VertexStepMode VERTEX_BUFFER_NOT_USED = new VertexStepMode(0x00000002, "VERTEX_BUFFER_NOT_USED");

	public static VertexStepMode from(int bits) {
		return map.get(bits);
	}

	private VertexStepMode(int bits, String name) {
		super(bits, name);
		map.put(bits, this);
	}
}
