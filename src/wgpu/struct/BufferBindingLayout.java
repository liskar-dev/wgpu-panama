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

public class BufferBindingLayout extends WGPUStruct {
	public ChainedStruct nextInChain;
	public BufferBindingType type;
	public boolean hasDynamicOffset;
	public long minBindingSize;

	protected static final int byteSize = 24;
	protected int byteSize() {
		return byteSize;
	}

	protected long store(Stack stack, long address) {
		put_value(address+0, stack.alloc(nextInChain));
		put_value(address+8, type == null ? 0 : type.bits );
		put_value(address+12, (boolean) hasDynamicOffset);
		put_value(address+16, (long) minBindingSize);
		return address;
	}

	protected BufferBindingLayout load(long address) {
		nextInChain = ChainedStruct.from(get_long(address+0));
		type = BufferBindingType.from(get_int(address+8));
		hasDynamicOffset = get_boolean(address+12);
		minBindingSize = get_long(address+16);
		return this;
	}
	public BufferBindingLayout() {}
}
