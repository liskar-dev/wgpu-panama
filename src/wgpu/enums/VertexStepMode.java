package wgpu.enums;

import wgpu.CEnum;
import java.util.*;

public class VertexStepMode extends CEnum {
	private static final Map<Integer, VertexStepMode> map = new HashMap<>();
	public static final VertexStepMode VERTEX = new VertexStepMode(0x00000000, "Vertex");
	public static final VertexStepMode INSTANCE = new VertexStepMode(0x00000001, "Instance");
	public static final VertexStepMode VERTEX_BUFFER_NOT_USED = new VertexStepMode(0x00000002, "VertexBufferNotUsed");

	public static VertexStepMode from(int bits) {
		return map.get(bits);
	}

	private VertexStepMode(int bits, String name) {
		super(bits, name);
		map.put(bits, this);
	}
}
