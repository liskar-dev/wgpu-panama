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

public class SamplerBindingLayout extends WGPUStruct {
	public ChainedStruct nextInChain;
	public SamplerBindingType type;
	// padding 4

	protected static final int byteSize = 16;
	protected int byteSize() {
		return byteSize;
	}

	protected long store(Stack stack, long address) {
		put_value(address+0, stack.alloc(nextInChain));
		put_value(address+8, type == null ? 0 : type.bits );
		// padding 4
		return address;
	}

	protected SamplerBindingLayout load(long address) {
		nextInChain = ChainedStruct.from(get_long(address+0));
		type = SamplerBindingType.from(get_int(address+8));
		// padding 4
		// padding 4
		return this;
	}
	public SamplerBindingLayout() {}
}
