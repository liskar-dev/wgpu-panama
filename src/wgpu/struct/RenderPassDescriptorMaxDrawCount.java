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

public class RenderPassDescriptorMaxDrawCount extends ChainedStruct {
	// ChainedStruct chain;
	public long maxDrawCount;

	protected static final int byteSize = 24;
	protected int byteSize() {
		return byteSize;
	}

	protected long store(Stack stack, long address) {
		put_value(address + 0, stack.alloc(next));
		put_value(address + 8, (int) SType.RenderPassDescriptorMaxDrawCount);
		// padding 4
		put_value(address+16, (long) maxDrawCount);
		return address;
	}

	protected RenderPassDescriptorMaxDrawCount load(long address) {
		var _next = get_long(address + 0);
		// unit32_t sType
		// padding 4
		maxDrawCount = get_long(address+16);
		super.next = ChainedStruct.from(_next);
		return this;
	}
	public RenderPassDescriptorMaxDrawCount() {}
}
