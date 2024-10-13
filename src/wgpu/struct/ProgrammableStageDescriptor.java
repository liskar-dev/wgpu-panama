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

public class ProgrammableStageDescriptor extends WGPUStruct {
	public ChainedStruct nextInChain;
	public WGPUShaderModule module;
	@Nullable
	public String entryPoint;
	// [constantCount]
	public ConstantEntry[] constants;

	protected int sizeInBytes() {
		return 40;
	}

	protected void writeTo(WGPUWriter out) {
		out.pointer(nextInChain);
		out.pointer(module);
		out.pointer(entryPoint);
		out.write((long) constants.length);
		out.pointer(constants);
	}

	protected ProgrammableStageDescriptor readFrom(WGPUReader in) {
		nextInChain = ChainedStruct.from(in.read_pointer());
		var _module = in.read_pointer();
		module = isNull(_module) ? null : new WGPUShaderModule(_module);
		entryPoint = in.read_string();
		var constantCount = (int) in.read_long();
		var _constants = in.read_pointer();
		if(!isNull(_constants)) {
			constants = new ConstantEntry[constantCount];
			var rin = new WGPUReader(_constants);
			for(int i=0; i<constants.length; i++) {
				constants[i] = new ConstantEntry().readFrom(rin);
			}
		}
		return this;
	}

	public ProgrammableStageDescriptor() {}

	public ProgrammableStageDescriptor(MemorySegment from) {
		readFrom(new WGPUReader(from));
	}

}
