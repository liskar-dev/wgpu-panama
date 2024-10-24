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

public class ShaderDefine extends WGPUStruct {
	public String name;
	public String value;

	protected static final int byteSize = 16;
	protected int byteSize() {
		return byteSize;
	}

	protected long store(Stack stack, long address) {
		put_value(address+0, stack.alloc(name));
		put_value(address+8, stack.alloc(value));
		return address;
	}

	protected ShaderDefine load(long address) {
		name = get_string(get_long(address+0));
		value = get_string(get_long(address+8));
		return this;
	}
	public ShaderDefine() {}
}
