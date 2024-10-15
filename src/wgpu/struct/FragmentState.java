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

public class FragmentState extends WGPUStruct {
	public ChainedStruct nextInChain;
	public WGPUShaderModule module;
	@Nullable
	public String entryPoint;
	// size_t constantCount
	public ConstantEntry[] constants;
	// size_t targetCount
	public ColorTargetState[] targets;

	protected static final int byteSize = 56;
	protected int byteSize() {
		return byteSize;
	}

	protected long store(Stack stack, long address) {
		put_value(address+0, stack.alloc(nextInChain));
		put_value(address+8, module == null ? 0L : module.handle );
		put_value(address+16, stack.alloc(entryPoint));
		put_value(address+24, (long) (constants == null ? 0 : constants.length));
		put_value(address+32, stack.alloc(constants));
		put_value(address+40, (long) (targets == null ? 0 : targets.length));
		put_value(address+48, stack.alloc(targets));
		return address;
	}

	protected FragmentState load(long address) {
		nextInChain = ChainedStruct.from(get_long(address+0));
		if(module != null) {
			module.handle = get_long(address+8);
		} else {
			module = new WGPUShaderModule(get_long(address+8));
		}
		entryPoint = get_string(get_long(address+16));
		var constantCount = (int) get_long(address+24);
		var _constants = get_long(address+32);
		var targetCount = (int) get_long(address+40);
		var _targets = get_long(address+48);
		if(_constants != 0L) {
			constants = constants != null && constants.length == constantCount ? constants : new ConstantEntry[constantCount];
			for(int i=0; i<constants.length; i++) {
				constants[i] = new ConstantEntry().load(_constants + i*ConstantEntry.byteSize);
			}
		} else {
			constants= null;
		}
		if(_targets != 0L) {
			targets = targets != null && targets.length == targetCount ? targets : new ColorTargetState[targetCount];
			for(int i=0; i<targets.length; i++) {
				targets[i] = new ColorTargetState().load(_targets + i*ColorTargetState.byteSize);
			}
		} else {
			targets= null;
		}
		return this;
	}
	public FragmentState() {}
}
