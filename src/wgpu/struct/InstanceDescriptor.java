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

public class InstanceDescriptor extends WGPUStruct {
	public ChainedStruct nextInChain;

	protected int sizeInBytes() {
		return 8;
	}

	protected void writeTo(WGPUWriter out) {
		out.pointer(nextInChain);
	}

	protected InstanceDescriptor readFrom(WGPUReader in) {
		nextInChain = ChainedStruct.from(in.read_pointer());
		return this;
	}

	public InstanceDescriptor() {}

	public InstanceDescriptor(MemorySegment from) {
		readFrom(new WGPUReader(from));
	}

}
