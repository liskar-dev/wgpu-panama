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

public class ImageCopyBuffer extends WGPUStruct {
	public ChainedStruct nextInChain;
	public TextureDataLayout layout;
	public WGPUBuffer buffer;

	protected static final int byteSize = 40;
	protected int byteSize() {
		return byteSize;
	}

	protected long store(Stack stack, long address) {
		put_value(address+0, stack.alloc(nextInChain));
		layout.store(stack, address+8);
		put_value(address+32, buffer == null ? 0L : buffer.handle );
		return address;
	}

	protected ImageCopyBuffer load(long address) {
		nextInChain = ChainedStruct.from(get_long(address+0));
		layout = (layout != null ? layout : new TextureDataLayout()).load(address+8);
		if(buffer != null) {
			buffer.handle = get_long(address+32);
		} else {
			buffer = new WGPUBuffer(get_long(address+32));
		}
		return this;
	}
	public ImageCopyBuffer() {}
}
