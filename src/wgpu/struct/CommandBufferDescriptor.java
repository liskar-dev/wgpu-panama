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

public class CommandBufferDescriptor extends WGPUStruct {
	public ChainedStruct nextInChain;
	@Nullable
	public String label;

	protected int sizeInBytes() {
		return 16;
	}

	protected void writeTo(WGPUWriter out) {
		out.pointer(nextInChain);
		out.pointer(label);
	}

	protected CommandBufferDescriptor readFrom(WGPUReader in) {
		nextInChain = ChainedStruct.from(in.read_pointer());
		label = in.read_string();
		return this;
	}

	public CommandBufferDescriptor() {}

	public CommandBufferDescriptor(MemorySegment from) {
		readFrom(new WGPUReader(from));
	}

}
