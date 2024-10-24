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

public class InstanceExtras extends ChainedStruct {
	// ChainedStruct chain;
	/** @see InstanceBackend */
	public int backends;
	/** @see InstanceFlag */
	public int flags;
	public Dx12Compiler dx12ShaderCompiler;
	public Gles3MinorVersion gles3MinorVersion;
	public String dxilPath;
	public String dxcPath;

	protected static final int byteSize = 48;
	protected int byteSize() {
		return byteSize;
	}

	protected long store(Stack stack, long address) {
		put_value(address + 0, stack.alloc(next));
		put_value(address + 8, (int) SType.InstanceExtras);
		// padding 4
		put_value(address+16, (int) backends);
		put_value(address+20, (int) flags);
		put_value(address+24, dx12ShaderCompiler == null ? 0 : dx12ShaderCompiler.bits );
		put_value(address+28, gles3MinorVersion == null ? 0 : gles3MinorVersion.bits );
		put_value(address+32, stack.alloc(dxilPath));
		put_value(address+40, stack.alloc(dxcPath));
		return address;
	}

	protected InstanceExtras load(long address) {
		var _next = get_long(address + 0);
		// unit32_t sType
		// padding 4
		backends = get_int(address+16);
		flags = get_int(address+20);
		dx12ShaderCompiler = Dx12Compiler.from(get_int(address+24));
		gles3MinorVersion = Gles3MinorVersion.from(get_int(address+28));
		dxilPath = get_string(get_long(address+32));
		dxcPath = get_string(get_long(address+40));
		super.next = ChainedStruct.from(_next);
		return this;
	}
	public InstanceExtras() {}
}
