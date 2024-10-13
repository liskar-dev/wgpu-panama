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

public class InstanceEnumerateAdapterOptions extends WGPUStruct {
	public ChainedStruct nextInChain;
	/** @see InstanceBackend */
	public int backends;
	// padding 4

	protected int sizeInBytes() {
		return 16;
	}

	protected void writeTo(WGPUWriter out) {
		out.pointer(nextInChain);
		out.write(backends);
		out.padding(4);
	}

	protected InstanceEnumerateAdapterOptions readFrom(WGPUReader in) {
		nextInChain = ChainedStruct.from(in.read_pointer());
		backends = in.read_int();
		in.padding(4);
		return this;
	}

	public InstanceEnumerateAdapterOptions() {}

	public InstanceEnumerateAdapterOptions(MemorySegment from) {
		readFrom(new WGPUReader(from));
	}

}
