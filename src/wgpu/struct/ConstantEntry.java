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

public class ConstantEntry extends WGPUStruct {
	public ChainedStruct nextInChain;
	public String key;
	public double value;

	protected static final int byteSize = 24;
	protected int byteSize() {
		return byteSize;
	}

	protected long store(Stack stack, long address) {
		put_value(address+0, stack.alloc(nextInChain));
		put_value(address+8, stack.alloc(key));
		put_value(address+16, (double) value);
		return address;
	}

	protected ConstantEntry load(long address) {
		nextInChain = ChainedStruct.from(get_long(address+0));
		key = get_string(get_long(address+8));
		value = get_double(address+16);
		return this;
	}
	public ConstantEntry() {}
}
