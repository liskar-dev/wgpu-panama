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

public class SamplerBindingLayout extends WGPUStruct {
	public ChainedStruct nextInChain;
	public SamplerBindingType type;
	// padding 4

	protected int sizeInBytes() {
		return 16;
	}

	protected void writeTo(WGPUWriter out) {
		out.pointer(nextInChain);
		out.write(type);
		out.padding(4);
	}

	protected SamplerBindingLayout readFrom(WGPUReader in) {
		nextInChain = ChainedStruct.from(in.read_pointer());
		type = SamplerBindingType.from(in.read_int());
		in.padding(4);
		return this;
	}

	public SamplerBindingLayout() {}

	public SamplerBindingLayout(MemorySegment from) {
		readFrom(new WGPUReader(from));
	}

}
