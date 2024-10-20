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

public class ProgrammableStageDescriptor extends WGPUStruct {
	public ChainedStruct nextInChain;
	public WGPUShaderModule module = new WGPUShaderModule(0);
	@Nullable
	public String entryPoint;
	// size_t constantCount
	public ConstantEntry[] constants;

	protected static final int byteSize = 40;
	protected int byteSize() {
		return byteSize;
	}

	protected long store(Stack stack, long address) {
		put_value(address+0, stack.alloc(nextInChain));
		put_value(address+8, module.handle );
		put_value(address+16, stack.alloc(entryPoint));
		put_value(address+24, (long) (constants == null ? 0 : constants.length));
		put_value(address+32, stack.alloc(constants));
		return address;
	}

	protected ProgrammableStageDescriptor load(long address) {
		nextInChain = ChainedStruct.from(get_long(address+0));
		module.handle = get_long(address+8);
		entryPoint = get_string(get_long(address+16));
		var constantCount = (int) get_long(address+24);
		var _constants = get_long(address+32);
		if(_constants != 0L) {
			constants = constants != null && constants.length == constantCount ? constants : new ConstantEntry[constantCount];
			for(int i=0; i<constants.length; i++) {
				constants[i] = new ConstantEntry().load(_constants + i*ConstantEntry.byteSize);
			}
		} else {
			constants= null;
		}
		return this;
	}
	public ProgrammableStageDescriptor() {}
}
