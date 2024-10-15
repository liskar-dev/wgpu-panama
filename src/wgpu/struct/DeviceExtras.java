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

public class DeviceExtras extends ChainedStruct {
	// ChainedStruct chain;
	public String tracePath;

	protected static final int byteSize = 24;
	protected int byteSize() {
		return byteSize;
	}

	protected long store(Stack stack, long address) {
		put_value(address + 0, stack.alloc(next));
		put_value(address + 8, (int) SType.DeviceExtras);
		// padding 4
		put_value(address+16, stack.alloc(tracePath));
		return address;
	}

	protected DeviceExtras load(long address) {
		var _next = get_long(address + 0);
		// unit32_t sType
		// padding 4
		tracePath = get_string(get_long(address+16));
		super.next = ChainedStruct.from(_next);
		return this;
	}
	public DeviceExtras() {}
}
