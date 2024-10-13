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

public class BufferDescriptor extends WGPUStruct {
	public ChainedStruct nextInChain;
	@Nullable
	public String label;
	/** @see BufferUsage */
	public int usage;
	// padding 4
	public long size;
	public boolean mappedAtCreation;
	// padding 4

	protected int sizeInBytes() {
		return 40;
	}

	protected void writeTo(WGPUWriter out) {
		out.pointer(nextInChain);
		out.pointer(label);
		out.write(usage);
		out.padding(4);
		out.write(size);
		out.write(mappedAtCreation);
		out.padding(4);
	}

	protected BufferDescriptor readFrom(WGPUReader in) {
		nextInChain = ChainedStruct.from(in.read_pointer());
		label = in.read_string();
		usage = in.read_int();
		in.padding(4);
		size = in.read_long();
		mappedAtCreation = in.read_boolean();
		in.padding(4);
		return this;
	}

	public BufferDescriptor() {}

	public BufferDescriptor(MemorySegment from) {
		readFrom(new WGPUReader(from));
	}

}
