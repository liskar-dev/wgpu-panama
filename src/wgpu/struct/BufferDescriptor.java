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

public class BufferDescriptor extends WGPUStruct {
	public ChainedStruct nextInChain;
	@Nullable
	public String label;
	/** @see BufferUsage */
	public int usage;
	// padding 4
	public long size;
	public boolean mappedAtCreation;
	// padding 4

	protected static final int byteSize = 40;
	protected int byteSize() {
		return byteSize;
	}

	protected long store(Stack stack, long address) {
		put_value(address+0, stack.alloc(nextInChain));
		put_value(address+8, stack.alloc(label));
		put_value(address+16, (int) usage);
		// padding 4
		put_value(address+24, (long) size);
		put_value(address+32, (boolean) mappedAtCreation);
		// padding 4
		return address;
	}

	protected BufferDescriptor load(long address) {
		nextInChain = ChainedStruct.from(get_long(address+0));
		label = get_string(get_long(address+8));
		usage = get_int(address+16);
		// padding 4
		size = get_long(address+24);
		mappedAtCreation = get_boolean(address+32);
		// padding 4
		// padding 4
		// padding 4
		return this;
	}
	public BufferDescriptor() {}
}
