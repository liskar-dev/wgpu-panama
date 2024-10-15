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

public class TextureViewDescriptor extends WGPUStruct {
	public ChainedStruct nextInChain;
	@Nullable
	public String label;
	public TextureFormat format;
	public TextureViewDimension dimension;
	public int baseMipLevel;
	public int mipLevelCount;
	public int baseArrayLayer;
	public int arrayLayerCount;
	public TextureAspect aspect;
	// padding 4

	protected static final int byteSize = 48;
	protected int byteSize() {
		return byteSize;
	}

	protected long store(Stack stack, long address) {
		put_value(address+0, stack.alloc(nextInChain));
		put_value(address+8, stack.alloc(label));
		put_value(address+16, format == null ? 0 : format.bits );
		put_value(address+20, dimension == null ? 0 : dimension.bits );
		put_value(address+24, (int) baseMipLevel);
		put_value(address+28, (int) mipLevelCount);
		put_value(address+32, (int) baseArrayLayer);
		put_value(address+36, (int) arrayLayerCount);
		put_value(address+40, aspect == null ? 0 : aspect.bits );
		// padding 4
		return address;
	}

	protected TextureViewDescriptor load(long address) {
		nextInChain = ChainedStruct.from(get_long(address+0));
		label = get_string(get_long(address+8));
		format = TextureFormat.from(get_int(address+16));
		dimension = TextureViewDimension.from(get_int(address+20));
		baseMipLevel = get_int(address+24);
		mipLevelCount = get_int(address+28);
		baseArrayLayer = get_int(address+32);
		arrayLayerCount = get_int(address+36);
		aspect = TextureAspect.from(get_int(address+40));
		// padding 4
		// padding 4
		return this;
	}
	public TextureViewDescriptor() {}
}
