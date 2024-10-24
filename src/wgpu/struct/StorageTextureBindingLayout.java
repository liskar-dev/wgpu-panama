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

public class StorageTextureBindingLayout extends WGPUStruct {
	public ChainedStruct nextInChain;
	public StorageTextureAccess access;
	public TextureFormat format;
	public TextureViewDimension viewDimension;
	// padding 4

	protected static final int byteSize = 24;
	protected int byteSize() {
		return byteSize;
	}

	protected long store(Stack stack, long address) {
		put_value(address+0, stack.alloc(nextInChain));
		put_value(address+8, access == null ? 0 : access.bits );
		put_value(address+12, format == null ? 0 : format.bits );
		put_value(address+16, viewDimension == null ? 0 : viewDimension.bits );
		// padding 4
		return address;
	}

	protected StorageTextureBindingLayout load(long address) {
		nextInChain = ChainedStruct.from(get_long(address+0));
		access = StorageTextureAccess.from(get_int(address+8));
		format = TextureFormat.from(get_int(address+12));
		viewDimension = TextureViewDimension.from(get_int(address+16));
		// padding 4
		// padding 4
		return this;
	}
	public StorageTextureBindingLayout() {}
}
