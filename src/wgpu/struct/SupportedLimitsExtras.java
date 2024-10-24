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

public class SupportedLimitsExtras extends ChainedStructOut {
	// ChainedStructOut chain;
	public NativeLimits limits = new NativeLimits();

	protected static final int byteSize = 24;
	protected int byteSize() {
		return byteSize;
	}

	protected long store(Stack stack, long address) {
		put_value(address + 0, stack.alloc(next));
		put_value(address + 8, (int) SType.SupportedLimitsExtras);
		// padding 4
		limits.store(stack, address+16);
		return address;
	}

	protected SupportedLimitsExtras load(long address) {
		var _next = get_long(address + 0);
		// unit32_t sType
		// padding 4
		limits = limits.load(address+16);
		super.next = ChainedStructOut.from(_next);
		return this;
	}
	public SupportedLimitsExtras() {}
}
