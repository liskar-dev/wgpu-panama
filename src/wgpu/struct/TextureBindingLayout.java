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

public class TextureBindingLayout extends WGPUStruct {
	public ChainedStruct nextInChain;
	public TextureSampleType sampleType;
	public TextureViewDimension viewDimension;
	public boolean multisampled;
	// padding 4

	protected static final int byteSize = 24;
	protected int byteSize() {
		return byteSize;
	}

	protected long store(Stack stack, long address) {
		put_value(address+0, stack.alloc(nextInChain));
		put_value(address+8, sampleType == null ? 0 : sampleType.bits );
		put_value(address+12, viewDimension == null ? 0 : viewDimension.bits );
		put_value(address+16, (boolean) multisampled);
		// padding 4
		return address;
	}

	protected TextureBindingLayout load(long address) {
		nextInChain = ChainedStruct.from(get_long(address+0));
		sampleType = TextureSampleType.from(get_int(address+8));
		viewDimension = TextureViewDimension.from(get_int(address+12));
		multisampled = get_boolean(address+16);
		// padding 4
		// padding 4
		return this;
	}
	public TextureBindingLayout() {}
}
