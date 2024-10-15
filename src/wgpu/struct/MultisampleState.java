package wgpu.struct;

import wgpu.*;
import wgpu.impl.*;
import wgpu.struct.*;
import wgpu.enums.*;
import wgpu.callback.*;
import static wgpu.StaticHelpers.*;

import java.lang.foreign.*;
import org.jspecify.annotations.*;

import static java.lang.foreign.ValueLayout.*;
import static java.lang.foreign.MemoryLayout.*;

public class MultisampleState extends WGPUStruct {
	public ChainedStruct nextInChain;
	public int count;
	public int mask;
	public boolean alphaToCoverageEnabled;
	// padding 4

	protected static final int byteSize = 24;
	protected int byteSize() {
		return byteSize;
	}

	protected long store(Stack stack, long address) {
		put_value(address+0, stack.alloc(nextInChain));
		put_value(address+8, (int) count);
		put_value(address+12, (int) mask);
		put_value(address+16, (boolean) alphaToCoverageEnabled);
		// padding 4
		return address;
	}

	protected MultisampleState load(long address) {
		nextInChain = ChainedStruct.from(get_long(address+0));
		count = get_int(address+8);
		mask = get_int(address+12);
		alphaToCoverageEnabled = get_boolean(address+16);
		// padding 4
		// padding 4
		return this;
	}
	public MultisampleState() {}
}
