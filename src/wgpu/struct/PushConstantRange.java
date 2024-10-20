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

public class PushConstantRange extends WGPUStruct {
	/** @see ShaderStage */
	public int stages;
	public int start;
	public int end;

	protected static final int byteSize = 12;
	protected int byteSize() {
		return byteSize;
	}

	protected long store(Stack stack, long address) {
		put_value(address+0, (int) stages);
		put_value(address+4, (int) start);
		put_value(address+8, (int) end);
		return address;
	}

	protected PushConstantRange load(long address) {
		stages = get_int(address+0);
		start = get_int(address+4);
		end = get_int(address+8);
		return this;
	}
	public PushConstantRange() {}
}
