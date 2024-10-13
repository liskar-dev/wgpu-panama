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

public class MultisampleState extends WGPUStruct {
	public ChainedStruct nextInChain;
	public int count;
	public int mask;
	public boolean alphaToCoverageEnabled;
	// padding 4

	protected int sizeInBytes() {
		return 24;
	}

	protected void writeTo(WGPUWriter out) {
		out.pointer(nextInChain);
		out.write(count);
		out.write(mask);
		out.write(alphaToCoverageEnabled);
		out.padding(4);
	}

	protected MultisampleState readFrom(WGPUReader in) {
		nextInChain = ChainedStruct.from(in.read_pointer());
		count = in.read_int();
		mask = in.read_int();
		alphaToCoverageEnabled = in.read_boolean();
		in.padding(4);
		return this;
	}

	public MultisampleState() {}

	public MultisampleState(MemorySegment from) {
		readFrom(new WGPUReader(from));
	}

}
