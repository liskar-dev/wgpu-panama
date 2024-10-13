package wgpu.struct;

import wgpu.*;
import wgpu.impl.*;
import wgpu.struct.*;
import wgpu.enums.*;
import wgpu.callback.*;
import static wgpu.Statics.*;

import java.lang.foreign.*;
import org.jspecify.annotations.*;

import static java.lang.foreign.ValueLayout.*;
import static java.lang.foreign.MemoryLayout.*;

public class FragmentState extends WGPUStruct {
	public ChainedStruct nextInChain;
	public WGPUShaderModule module;
	@Nullable
	public String entryPoint;
	// [constantCount]
	public ConstantEntry[] constants;
	// [targetCount]
	public ColorTargetState[] targets;

	protected int sizeInBytes() {
		return 56;
	}

	protected void writeTo(WGPUWriter out) {
		out.pointer(nextInChain);
		out.pointer(module);
		out.pointer(entryPoint);
		out.write((long) (constants == null ? 0 : constants.length));
		out.pointer(constants);
		out.write((long) (targets == null ? 0 : targets.length));
		out.pointer(targets);
	}

	protected FragmentState readFrom(WGPUReader in) {
		nextInChain = ChainedStruct.from(in.read_pointer());
		var _module = in.read_pointer();
		module = isNull(_module) ? null : new WGPUShaderModule(_module);
		entryPoint = in.read_string();
		var constantCount = (int) in.read_long();
		var _constants = in.read_pointer();
		var targetCount = (int) in.read_long();
		var _targets = in.read_pointer();
		if(!isNull(_constants)) {
			constants = new ConstantEntry[constantCount];
			var rin = new WGPUReader(_constants);
			for(int i=0; i<constants.length; i++) {
				constants[i] = new ConstantEntry().readFrom(rin);
			}
		}
		if(!isNull(_targets)) {
			targets = new ColorTargetState[targetCount];
			var rin = new WGPUReader(_targets);
			for(int i=0; i<targets.length; i++) {
				targets[i] = new ColorTargetState().readFrom(rin);
			}
		}
		return this;
	}

	public FragmentState() {}

	public FragmentState(MemorySegment from) {
		readFrom(new WGPUReader(from));
	}

}
