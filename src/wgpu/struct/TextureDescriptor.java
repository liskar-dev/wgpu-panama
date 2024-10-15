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

public class TextureDescriptor extends WGPUStruct {
	public ChainedStruct nextInChain;
	@Nullable
	public String label;
	/** @see TextureUsage */
	public int usage;
	public TextureDimension dimension;
	public Extent3D size;
	public TextureFormat format;
	public int mipLevelCount;
	public int sampleCount;
	// padding 4
	// size_t viewFormatCount
	public TextureFormat[] viewFormats;

	protected static final int byteSize = 72;
	protected int byteSize() {
		return byteSize;
	}

	protected long store(Stack stack, long address) {
		put_value(address+0, stack.alloc(nextInChain));
		put_value(address+8, stack.alloc(label));
		put_value(address+16, (int) usage);
		put_value(address+20, dimension == null ? 0 : dimension.bits );
		size.store(stack, address+24);
		put_value(address+40, format == null ? 0 : format.bits );
		put_value(address+44, (int) mipLevelCount);
		put_value(address+48, (int) sampleCount);
		// padding 4
		put_value(address+56, (long) (viewFormats == null ? 0 : viewFormats.length));
		put_value(address+64, stack.alloc(viewFormats));
		return address;
	}

	protected TextureDescriptor load(long address) {
		nextInChain = ChainedStruct.from(get_long(address+0));
		label = get_string(get_long(address+8));
		usage = get_int(address+16);
		dimension = TextureDimension.from(get_int(address+20));
		size = (size != null ? size : new Extent3D()).load(address+24);
		format = TextureFormat.from(get_int(address+40));
		mipLevelCount = get_int(address+44);
		sampleCount = get_int(address+48);
		// padding 4
		var viewFormatCount = (int) get_long(address+56);
		var _viewFormats = get_long(address+64);
		// padding 4
		if(_viewFormats != 0L) {
			viewFormats = viewFormats != null && viewFormats.length == viewFormatCount ? viewFormats : new TextureFormat[viewFormatCount];
			for(int i=0; i<viewFormats.length; i++) {
				viewFormats[i] = TextureFormat.from(get_int(_viewFormats + i*4));
			}
		} else {
			viewFormats= null;
		}
		return this;
	}
	public TextureDescriptor() {}
}
