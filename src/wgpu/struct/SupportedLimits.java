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

public class SupportedLimits extends CStruct {
	public ChainedStructOut nextInChain;
	public Limits limits = new Limits();

	protected static final int byteSize = 152;
	protected int byteSize() {
		return byteSize;
	}

	protected long store(Stack stack, long address) {
		put_value(address+0, stack.alloc(nextInChain));
		limits.store(stack, address+8);
		return address;
	}

	protected SupportedLimits load(long address) {
		nextInChain = ChainedStructOut.from(get_long(address+0));
		limits = limits.load(address+8);
		return this;
	}
	public SupportedLimits() {}
}
