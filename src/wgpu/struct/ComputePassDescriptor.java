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

public class ComputePassDescriptor extends WGPUStruct {
	public ChainedStruct nextInChain;
	@Nullable
	public String label;
	@Nullable
	public ComputePassTimestampWrites timestampWrites;

	protected static final int byteSize = 24;
	protected int byteSize() {
		return byteSize;
	}

	protected long store(Stack stack, long address) {
		put_value(address+0, stack.alloc(nextInChain));
		put_value(address+8, stack.alloc(label));
		put_value(address+16, stack.alloc(timestampWrites));
		return address;
	}

	protected ComputePassDescriptor load(long address) {
		nextInChain = ChainedStruct.from(get_long(address+0));
		label = get_string(get_long(address+8));
		var _timestampWrites = get_long(address+16);
		timestampWrites = _timestampWrites == 0 ? null : (timestampWrites != null ? timestampWrites : new ComputePassTimestampWrites()).load(_timestampWrites);
		timestampWrites = _timestampWrites == 0 ? null : (timestampWrites != null ? timestampWrites : new ComputePassTimestampWrites()).load(_timestampWrites);
		return this;
	}
	public ComputePassDescriptor() {}
}
