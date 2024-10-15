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

public class SurfaceDescriptorFromMetalLayer extends ChainedStruct {
	// ChainedStruct chain;
	public long layer;

	protected static final int byteSize = 24;
	protected int byteSize() {
		return byteSize;
	}

	protected long store(Stack stack, long address) {
		put_value(address + 0, stack.alloc(next));
		put_value(address + 8, (int) SType.SurfaceDescriptorFromMetalLayer);
		// padding 4
		put_value(address+16, (long) layer);
		return address;
	}

	protected SurfaceDescriptorFromMetalLayer load(long address) {
		var _next = get_long(address + 0);
		// unit32_t sType
		// padding 4
		layer = get_long(address+16);
		super.next = ChainedStruct.from(_next);
		return this;
	}
	public SurfaceDescriptorFromMetalLayer() {}
}
