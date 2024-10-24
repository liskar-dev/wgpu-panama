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

public class SurfaceDescriptorFromXcbWindow extends ChainedStruct {
	// ChainedStruct chain;
	public long connection;
	public int window;
	// padding 4

	protected static final int byteSize = 32;
	protected int byteSize() {
		return byteSize;
	}

	protected long store(Stack stack, long address) {
		put_value(address + 0, stack.alloc(next));
		put_value(address + 8, (int) SType.SurfaceDescriptorFromXcbWindow);
		// padding 4
		put_value(address+16, (long) connection);
		put_value(address+24, (int) window);
		// padding 4
		return address;
	}

	protected SurfaceDescriptorFromXcbWindow load(long address) {
		var _next = get_long(address + 0);
		// unit32_t sType
		// padding 4
		connection = get_long(address+16);
		window = get_int(address+24);
		// padding 4
		super.next = ChainedStruct.from(_next);
		// padding 4
		return this;
	}
	public SurfaceDescriptorFromXcbWindow() {}
}
