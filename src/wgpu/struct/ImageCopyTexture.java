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

public class ImageCopyTexture extends WGPUStruct {
	public ChainedStruct nextInChain;
	public WGPUTexture texture = new WGPUTexture(0);
	public int mipLevel;
	// padding 4
	public Origin3D origin;
	public TextureAspect aspect;
	// padding 4

	protected static final int byteSize = 48;
	protected int byteSize() {
		return byteSize;
	}

	protected long store(Stack stack, long address) {
		put_value(address+0, stack.alloc(nextInChain));
		put_value(address+8, texture.handle );
		put_value(address+16, (int) mipLevel);
		// padding 4
		origin.store(stack, address+24);
		put_value(address+40, aspect == null ? 0 : aspect.bits );
		// padding 4
		return address;
	}

	protected ImageCopyTexture load(long address) {
		nextInChain = ChainedStruct.from(get_long(address+0));
		texture.handle = get_long(address+8);
		mipLevel = get_int(address+16);
		// padding 4
		origin = (origin != null ? origin : new Origin3D()).load(address+24);
		aspect = TextureAspect.from(get_int(address+40));
		// padding 4
		// padding 4
		// padding 4
		return this;
	}
	public ImageCopyTexture() {}
}
