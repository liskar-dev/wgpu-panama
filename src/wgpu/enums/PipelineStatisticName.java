package wgpu.enums;

import wgpu.WGPUEnum;
import java.util.*;

public class PipelineStatisticName extends WGPUEnum {
	private static final Map<Integer, PipelineStatisticName> map = new HashMap<>();
	public static final PipelineStatisticName VERTEX_SHADER_INVOCATIONS = new PipelineStatisticName(0x00000000, "VERTEX_SHADER_INVOCATIONS");
	public static final PipelineStatisticName CLIPPER_INVOCATIONS = new PipelineStatisticName(0x00000001, "CLIPPER_INVOCATIONS");
	public static final PipelineStatisticName CLIPPER_PRIMITIVES_OUT = new PipelineStatisticName(0x00000002, "CLIPPER_PRIMITIVES_OUT");
	public static final PipelineStatisticName FRAGMENT_SHADER_INVOCATIONS = new PipelineStatisticName(0x00000003, "FRAGMENT_SHADER_INVOCATIONS");
	public static final PipelineStatisticName COMPUTE_SHADER_INVOCATIONS = new PipelineStatisticName(0x00000004, "COMPUTE_SHADER_INVOCATIONS");

	public static PipelineStatisticName from(int bits) {
		return map.get(bits);
	}

	private PipelineStatisticName(int bits, String name) {
		super(bits, name);
		map.put(bits, this);
	}
}
