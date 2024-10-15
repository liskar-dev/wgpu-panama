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

public class SurfaceDescriptor extends WGPUStruct {
	public ChainedStruct nextInChain;
	@Nullable
	public String label;

	protected static final int byteSize = 16;
	protected int byteSize() {
		return byteSize;
	}

	protected long store(Stack stack, long address) {
		put_value(address+0, stack.alloc(nextInChain));
		put_value(address+8, stack.alloc(label));
		return address;
	}

	protected SurfaceDescriptor load(long address) {
		nextInChain = ChainedStruct.from(get_long(address+0));
		label = get_string(get_long(address+8));
		return this;
	}
	public SurfaceDescriptor() {}
}
