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

public class ImageCopyTexture extends WGPUStruct {
	public ChainedStruct nextInChain;
	public WGPUTexture texture = new WGPUTexture(0);
	public int mipLevel;
	public Origin3D origin = new Origin3D();
	public TextureAspect aspect;
	// padding 4

	protected static final int byteSize = 40;
	protected int byteSize() {
		return byteSize;
	}

	protected long store(Stack stack, long address) {
		put_value(address+0, stack.alloc(nextInChain));
		put_value(address+8, texture.handle );
		put_value(address+16, (int) mipLevel);
		origin.store(stack, address+20);
		put_value(address+32, aspect == null ? 0 : aspect.bits );
		// padding 4
		return address;
	}

	protected ImageCopyTexture load(long address) {
		nextInChain = ChainedStruct.from(get_long(address+0));
		texture.handle = get_long(address+8);
		mipLevel = get_int(address+16);
		origin = origin.load(address+20);
		aspect = TextureAspect.from(get_int(address+32));
		// padding 4
		// padding 4
		return this;
	}
	public ImageCopyTexture() {}
}
