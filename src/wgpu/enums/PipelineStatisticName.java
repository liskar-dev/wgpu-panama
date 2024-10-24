package wgpu.enums;

import wgpu.CEnum;
import java.util.*;

public class PipelineStatisticName extends CEnum {
	private static final Map<Integer, PipelineStatisticName> map = new HashMap<>();
	public static final PipelineStatisticName VERTEX_SHADER_INVOCATIONS = new PipelineStatisticName(0x00000000, "VertexShaderInvocations");
	public static final PipelineStatisticName CLIPPER_INVOCATIONS = new PipelineStatisticName(0x00000001, "ClipperInvocations");
	public static final PipelineStatisticName CLIPPER_PRIMITIVES_OUT = new PipelineStatisticName(0x00000002, "ClipperPrimitivesOut");
	public static final PipelineStatisticName FRAGMENT_SHADER_INVOCATIONS = new PipelineStatisticName(0x00000003, "FragmentShaderInvocations");
	public static final PipelineStatisticName COMPUTE_SHADER_INVOCATIONS = new PipelineStatisticName(0x00000004, "ComputeShaderInvocations");

	public static PipelineStatisticName from(int bits) {
		return map.get(bits);
	}

	private PipelineStatisticName(int bits, String name) {
		super(bits, name);
		map.put(bits, this);
	}
}
