package wgpu.struct;

import wgpu.*;
import wgpu.impl.*;
import wgpu.struct.*;
import wgpu.enums.*;
import wgpu.callback.*;

import java.lang.foreign.*;
import org.jspecify.annotations.*;

import static java.lang.foreign.ValueLayout.*;
import static java.lang.foreign.MemoryLayout.*;

public class InstanceEnumerateAdapterOptions extends WGPUStruct {
	public ChainedStruct nextInChain;
	/** @see InstanceBackend */
	public int backends;
	// padding 4

	protected static final int byteSize = 16;
	protected int byteSize() {
		return byteSize;
	}

	protected long store(Stack stack, long address) {
		put_value(address+0, stack.alloc(nextInChain));
		put_value(address+8, (int) backends);
		// padding 4
		return address;
	}

	protected InstanceEnumerateAdapterOptions load(long address) {
		nextInChain = ChainedStruct.from(get_long(address+0));
		backends = get_int(address+8);
		// padding 4
		// padding 4
		return this;
	}
	public InstanceEnumerateAdapterOptions() {}
}
