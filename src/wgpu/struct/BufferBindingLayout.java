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

public class BufferBindingLayout extends WGPUStruct {
	public ChainedStruct nextInChain;
	public BufferBindingType type;
	public boolean hasDynamicOffset;
	public long minBindingSize;

	protected int sizeInBytes() {
		return 24;
	}

	protected void writeTo(WGPUWriter out) {
		out.pointer(nextInChain);
		out.write(type);
		out.write(hasDynamicOffset);
		out.write(minBindingSize);
	}

	protected BufferBindingLayout readFrom(WGPUReader in) {
		nextInChain = ChainedStruct.from(in.read_pointer());
		type = BufferBindingType.from(in.read_int());
		hasDynamicOffset = in.read_boolean();
		minBindingSize = in.read_long();
		return this;
	}

	public BufferBindingLayout() {}

	public BufferBindingLayout(MemorySegment from) {
		readFrom(new WGPUReader(from));
	}

}
