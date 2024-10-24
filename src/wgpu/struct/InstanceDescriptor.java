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

public class InstanceDescriptor extends WGPUStruct {
	public ChainedStruct nextInChain;

	protected static final int byteSize = 8;
	protected int byteSize() {
		return byteSize;
	}

	protected long store(Stack stack, long address) {
		put_value(address+0, stack.alloc(nextInChain));
		return address;
	}

	protected InstanceDescriptor load(long address) {
		nextInChain = ChainedStruct.from(get_long(address+0));
		return this;
	}
	public InstanceDescriptor() {}
}
