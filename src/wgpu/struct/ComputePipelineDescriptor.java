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

public class ComputePipelineDescriptor extends WGPUStruct {
	public ChainedStruct nextInChain;
	@Nullable
	public String label;
	@Nullable
	public WGPUPipelineLayout layout;
	public ProgrammableStageDescriptor compute;

	protected int sizeInBytes() {
		return 64;
	}

	protected void writeTo(WGPUWriter out) {
		out.pointer(nextInChain);
		out.pointer(label);
		out.pointer(layout);
		out.write(compute);
	}

	protected ComputePipelineDescriptor readFrom(WGPUReader in) {
		nextInChain = ChainedStruct.from(in.read_pointer());
		label = in.read_string();
		var _layout = in.read_pointer();
		layout = isNull(_layout) ? null : new WGPUPipelineLayout(_layout);
		compute = new ProgrammableStageDescriptor().readFrom(in);
		return this;
	}

	public ComputePipelineDescriptor() {}

	public ComputePipelineDescriptor(MemorySegment from) {
		readFrom(new WGPUReader(from));
	}

}
