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

public class BindGroupEntry extends WGPUStruct {
	public ChainedStruct nextInChain;
	public int binding;
	// padding 4
	public WGPUBuffer buffer = new WGPUBuffer(0);
	public long offset;
	public long size;
	public WGPUSampler sampler = new WGPUSampler(0);
	public WGPUTextureView textureView = new WGPUTextureView(0);

	protected static final int byteSize = 56;
	protected int byteSize() {
		return byteSize;
	}

	protected long store(Stack stack, long address) {
		put_value(address+0, stack.alloc(nextInChain));
		put_value(address+8, (int) binding);
		// padding 4
		put_value(address+16, buffer.handle );
		put_value(address+24, (long) offset);
		put_value(address+32, (long) size);
		put_value(address+40, sampler.handle );
		put_value(address+48, textureView.handle );
		return address;
	}

	protected BindGroupEntry load(long address) {
		nextInChain = ChainedStruct.from(get_long(address+0));
		binding = get_int(address+8);
		// padding 4
		buffer.handle = get_long(address+16);
		offset = get_long(address+24);
		size = get_long(address+32);
		sampler.handle = get_long(address+40);
		textureView.handle = get_long(address+48);
		// padding 4
		return this;
	}
	public BindGroupEntry() {}
}
