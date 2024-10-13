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

public class ConstantEntry extends WGPUStruct {
	public ChainedStruct nextInChain;
	public String key;
	public double value;

	protected int sizeInBytes() {
		return 24;
	}

	protected void writeTo(WGPUWriter out) {
		out.pointer(nextInChain);
		out.pointer(key);
		out.write(value);
	}

	protected ConstantEntry readFrom(WGPUReader in) {
		nextInChain = ChainedStruct.from(in.read_pointer());
		key = in.read_string();
		value = in.read_double();
		return this;
	}

	public ConstantEntry() {}

	public ConstantEntry(MemorySegment from) {
		readFrom(new WGPUReader(from));
	}

}
