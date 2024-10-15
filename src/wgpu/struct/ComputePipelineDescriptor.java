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

public class ComputePipelineDescriptor extends WGPUStruct {
	public ChainedStruct nextInChain;
	@Nullable
	public String label;
	@Nullable
	public WGPUPipelineLayout layout;
	public ProgrammableStageDescriptor compute;

	protected static final int byteSize = 64;
	protected int byteSize() {
		return byteSize;
	}

	protected long store(Stack stack, long address) {
		put_value(address+0, stack.alloc(nextInChain));
		put_value(address+8, stack.alloc(label));
		put_value(address+16, layout == null ? 0L : layout.handle );
		compute.store(stack, address+24);
		return address;
	}

	protected ComputePipelineDescriptor load(long address) {
		nextInChain = ChainedStruct.from(get_long(address+0));
		label = get_string(get_long(address+8));
		if(layout != null) {
			layout.handle = get_long(address+16);
		} else {
			layout = new WGPUPipelineLayout(get_long(address+16));
		}
		compute = (compute != null ? compute : new ProgrammableStageDescriptor()).load(address+24);
		return this;
	}
	public ComputePipelineDescriptor() {}
}
