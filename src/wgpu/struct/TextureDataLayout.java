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

public class TextureDataLayout extends WGPUStruct {
	public ChainedStruct nextInChain;
	public long offset;
	public int bytesPerRow;
	public int rowsPerImage;

	protected static final int byteSize = 24;
	protected int byteSize() {
		return byteSize;
	}

	protected long store(Stack stack, long address) {
		put_value(address+0, stack.alloc(nextInChain));
		put_value(address+8, (long) offset);
		put_value(address+16, (int) bytesPerRow);
		put_value(address+20, (int) rowsPerImage);
		return address;
	}

	protected TextureDataLayout load(long address) {
		nextInChain = ChainedStruct.from(get_long(address+0));
		offset = get_long(address+8);
		bytesPerRow = get_int(address+16);
		rowsPerImage = get_int(address+20);
		return this;
	}
	public TextureDataLayout() {}
}
