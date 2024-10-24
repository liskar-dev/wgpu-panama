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

public class TextureDescriptor extends CStruct {
	public ChainedStruct nextInChain;
	@Nullable
	public String label;
	/** @see TextureUsage */
	public int usage;
	public TextureDimension dimension;
	public Extent3D size = new Extent3D();
	public TextureFormat format;
	public int mipLevelCount;
	public int sampleCount;
	// size_t viewFormatCount
	public TextureFormat[] viewFormats;

	protected static final int byteSize = 64;
	protected int byteSize() {
		return byteSize;
	}

	protected long store(Stack stack, long address) {
		put_value(address+0, stack.alloc(nextInChain));
		put_value(address+8, stack.alloc(label));
		put_value(address+16, (int) usage);
		put_value(address+20, dimension == null ? 0 : dimension.bits );
		size.store(stack, address+24);
		put_value(address+36, format == null ? 0 : format.bits );
		put_value(address+40, (int) mipLevelCount);
		put_value(address+44, (int) sampleCount);
		put_value(address+48, (long) (viewFormats == null ? 0 : viewFormats.length));
		put_value(address+56, stack.alloc(viewFormats));
		return address;
	}

	protected TextureDescriptor load(long address) {
		nextInChain = ChainedStruct.from(get_long(address+0));
		label = get_string(get_long(address+8));
		usage = get_int(address+16);
		dimension = TextureDimension.from(get_int(address+20));
		size = size.load(address+24);
		format = TextureFormat.from(get_int(address+36));
		mipLevelCount = get_int(address+40);
		sampleCount = get_int(address+44);
		var viewFormatCount = (int) get_long(address+48);
		var _viewFormats = get_long(address+56);
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
