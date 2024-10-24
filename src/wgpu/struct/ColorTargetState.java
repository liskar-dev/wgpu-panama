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

public class ColorTargetState extends WGPUStruct {
	public ChainedStruct nextInChain;
	public TextureFormat format;
	// padding 4
	@Nullable
	public BlendState blend;
	/** @see ColorWriteMask */
	public int writeMask;
	// padding 4

	protected static final int byteSize = 32;
	protected int byteSize() {
		return byteSize;
	}

	protected long store(Stack stack, long address) {
		put_value(address+0, stack.alloc(nextInChain));
		put_value(address+8, format == null ? 0 : format.bits );
		// padding 4
		put_value(address+16, stack.alloc(blend));
		put_value(address+24, (int) writeMask);
		// padding 4
		return address;
	}

	protected ColorTargetState load(long address) {
		nextInChain = ChainedStruct.from(get_long(address+0));
		format = TextureFormat.from(get_int(address+8));
		// padding 4
		var _blend = get_long(address+16);
		blend = _blend == 0 ? null : (blend != null ? blend : new BlendState()).load(_blend);
		writeMask = get_int(address+24);
		// padding 4
		// padding 4
		blend = _blend == 0 ? null : (blend != null ? blend : new BlendState()).load(_blend);
		// padding 4
		return this;
	}
	public ColorTargetState() {}
}
