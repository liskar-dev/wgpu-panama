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

public class ComputePassDescriptor extends WGPUStruct {
	public ChainedStruct nextInChain;
	@Nullable
	public String label;
	@Nullable
	public ComputePassTimestampWrites timestampWrites;

	protected int sizeInBytes() {
		return 24;
	}

	protected void writeTo(WGPUWriter out) {
		out.pointer(nextInChain);
		out.pointer(label);
		out.pointer(timestampWrites);
	}

	protected ComputePassDescriptor readFrom(WGPUReader in) {
		nextInChain = ChainedStruct.from(in.read_pointer());
		label = in.read_string();
		var _timestampWrites = in.read_pointer();
		timestampWrites = isNull(_timestampWrites) ? null : new ComputePassTimestampWrites().readFrom(new WGPUReader(_timestampWrites));
		return this;
	}

	public ComputePassDescriptor() {}

	public ComputePassDescriptor(MemorySegment from) {
		readFrom(new WGPUReader(from));
	}

}
