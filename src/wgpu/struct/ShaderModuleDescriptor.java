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

public class ShaderModuleDescriptor extends WGPUStruct {
	public ChainedStruct nextInChain;
	@Nullable
	public String label;
	// size_t hintCount
	public ShaderModuleCompilationHint[] hints;

	protected static final int byteSize = 32;
	protected int byteSize() {
		return byteSize;
	}

	protected long store(Stack stack, long address) {
		put_value(address+0, stack.alloc(nextInChain));
		put_value(address+8, stack.alloc(label));
		put_value(address+16, (long) (hints == null ? 0 : hints.length));
		put_value(address+24, stack.alloc(hints));
		return address;
	}

	protected ShaderModuleDescriptor load(long address) {
		nextInChain = ChainedStruct.from(get_long(address+0));
		label = get_string(get_long(address+8));
		var hintCount = (int) get_long(address+16);
		var _hints = get_long(address+24);
		if(_hints != 0L) {
			hints = hints != null && hints.length == hintCount ? hints : new ShaderModuleCompilationHint[hintCount];
			for(int i=0; i<hints.length; i++) {
				hints[i] = new ShaderModuleCompilationHint().load(_hints + i*ShaderModuleCompilationHint.byteSize);
			}
		} else {
			hints= null;
		}
		return this;
	}
	public ShaderModuleDescriptor() {}
}
