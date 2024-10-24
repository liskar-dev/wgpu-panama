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

public class ImageCopyBuffer extends WGPUStruct {
	public ChainedStruct nextInChain;
	public TextureDataLayout layout = new TextureDataLayout();
	public WGPUBuffer buffer = new WGPUBuffer(0);

	protected static final int byteSize = 40;
	protected int byteSize() {
		return byteSize;
	}

	protected long store(Stack stack, long address) {
		put_value(address+0, stack.alloc(nextInChain));
		layout.store(stack, address+8);
		put_value(address+32, buffer.handle );
		return address;
	}

	protected ImageCopyBuffer load(long address) {
		nextInChain = ChainedStruct.from(get_long(address+0));
		layout = layout.load(address+8);
		buffer.handle = get_long(address+32);
		return this;
	}
	public ImageCopyBuffer() {}
}
