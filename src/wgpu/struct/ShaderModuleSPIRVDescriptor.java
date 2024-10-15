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

public class ShaderModuleSPIRVDescriptor extends ChainedStruct {
	// ChainedStruct chain;
	// *uint32_t codeSize
	// padding 4
	public MemorySegment code;

	protected static final int byteSize = 32;
	protected int byteSize() {
		return byteSize;
	}

	protected long store(Stack stack, long address) {
		put_value(address + 0, stack.alloc(next));
		put_value(address + 8, (int) SType.ShaderModuleSPIRVDescriptor);
		// padding 4
		put_value(address+16, (int) (null == null ? 0 : code.byteSize()));
		// padding 4
		put_pointer(address+24, code);
		return address;
	}

	protected ShaderModuleSPIRVDescriptor load(long address) {
		var _next = get_long(address + 0);
		// unit32_t sType
		// padding 4
		var codeSize = get_int(address+16);
		// padding 4
		var _code = get_long(address+24);
		super.next = ChainedStruct.from(_next);
		// padding 4
		code = MemorySegment.ofAddress(_code).reinterpret(codeSize);
		return this;
	}
	public ShaderModuleSPIRVDescriptor() {}
}
