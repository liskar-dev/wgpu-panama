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

public class ShaderModuleGLSLDescriptor extends ChainedStruct {
	// ChainedStruct chain;
	/** @see ShaderStage */
	public int stage;
	// padding 4
	public String code;
	// uint32_t defineCount
	// padding 4
	public ShaderDefine[] defines;

	protected static final int byteSize = 48;
	protected int byteSize() {
		return byteSize;
	}

	protected long store(Stack stack, long address) {
		put_value(address + 0, stack.alloc(next));
		put_value(address + 8, (int) SType.ShaderModuleGLSLDescriptor);
		// padding 4
		put_value(address+16, (int) stage);
		// padding 4
		put_value(address+24, stack.alloc(code));
		put_value(address+32, (int) (defines == null ? 0 : defines.length));
		// padding 4
		put_value(address+40, stack.alloc(defines));
		return address;
	}

	protected ShaderModuleGLSLDescriptor load(long address) {
		var _next = get_long(address + 0);
		// unit32_t sType
		// padding 4
		stage = get_int(address+16);
		// padding 4
		code = get_string(get_long(address+24));
		var defineCount = (int) get_int(address+32);
		// padding 4
		var _defines = get_long(address+40);
		super.next = ChainedStruct.from(_next);
		// padding 4
		// padding 4
		if(_defines != 0L) {
			defines = defines != null && defines.length == defineCount ? defines : new ShaderDefine[defineCount];
			for(int i=0; i<defines.length; i++) {
				defines[i] = new ShaderDefine().load(_defines + i*ShaderDefine.byteSize);
			}
		} else {
			defines= null;
		}
		return this;
	}
	public ShaderModuleGLSLDescriptor() {}
}
