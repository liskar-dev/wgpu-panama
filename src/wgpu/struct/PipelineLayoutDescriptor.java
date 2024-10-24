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

public class PipelineLayoutDescriptor extends CStruct {
	public ChainedStruct nextInChain;
	@Nullable
	public String label;
	// size_t bindGroupLayoutCount
	public GPUBindGroupLayout[] bindGroupLayouts;

	protected static final int byteSize = 32;
	protected int byteSize() {
		return byteSize;
	}

	protected long store(Stack stack, long address) {
		put_value(address+0, stack.alloc(nextInChain));
		put_value(address+8, stack.alloc(label));
		put_value(address+16, (long) (bindGroupLayouts == null ? 0 : bindGroupLayouts.length));
		put_value(address+24, stack.alloc(bindGroupLayouts));
		return address;
	}

	protected PipelineLayoutDescriptor load(long address) {
		nextInChain = ChainedStruct.from(get_long(address+0));
		label = get_string(get_long(address+8));
		var bindGroupLayoutCount = (int) get_long(address+16);
		var _bindGroupLayouts = get_long(address+24);
		if(_bindGroupLayouts != 0L) {
			bindGroupLayouts = bindGroupLayouts != null && bindGroupLayouts.length == bindGroupLayoutCount ? bindGroupLayouts : new GPUBindGroupLayout[bindGroupLayoutCount];
			for(int i=0; i<bindGroupLayouts.length; i++) {
				bindGroupLayouts[i] = new GPUBindGroupLayout(get_int(_bindGroupLayouts + i*8));
			}
		} else {
			bindGroupLayouts= null;
		}
		return this;
	}
	public PipelineLayoutDescriptor() {}
}
