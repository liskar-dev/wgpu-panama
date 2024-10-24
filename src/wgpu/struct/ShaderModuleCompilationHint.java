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

public class ShaderModuleCompilationHint extends CStruct {
	public ChainedStruct nextInChain;
	public String entryPoint;
	public GPUPipelineLayout layout = new GPUPipelineLayout(0);

	protected static final int byteSize = 24;
	protected int byteSize() {
		return byteSize;
	}

	protected long store(Stack stack, long address) {
		put_value(address+0, stack.alloc(nextInChain));
		put_value(address+8, stack.alloc(entryPoint));
		put_value(address+16, layout.handle );
		return address;
	}

	protected ShaderModuleCompilationHint load(long address) {
		nextInChain = ChainedStruct.from(get_long(address+0));
		entryPoint = get_string(get_long(address+8));
		layout.handle = get_long(address+16);
		return this;
	}
	public ShaderModuleCompilationHint() {}
}
