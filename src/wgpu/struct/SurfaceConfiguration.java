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

public class SurfaceConfiguration extends WGPUStruct {
	public ChainedStruct nextInChain;
	public WGPUDevice device;
	public TextureFormat format;
	/** @see TextureUsage */
	public int usage;
	// size_t viewFormatCount
	public TextureFormat[] viewFormats;
	public CompositeAlphaMode alphaMode;
	public int width;
	public int height;
	public PresentMode presentMode;

	protected static final int byteSize = 56;
	protected int byteSize() {
		return byteSize;
	}

	protected long store(Stack stack, long address) {
		put_value(address+0, stack.alloc(nextInChain));
		put_value(address+8, device == null ? 0L : device.handle );
		put_value(address+16, format == null ? 0 : format.bits );
		put_value(address+20, (int) usage);
		put_value(address+24, (long) (viewFormats == null ? 0 : viewFormats.length));
		put_value(address+32, stack.alloc(viewFormats));
		put_value(address+40, alphaMode == null ? 0 : alphaMode.bits );
		put_value(address+44, (int) width);
		put_value(address+48, (int) height);
		put_value(address+52, presentMode == null ? 0 : presentMode.bits );
		return address;
	}

	protected SurfaceConfiguration load(long address) {
		nextInChain = ChainedStruct.from(get_long(address+0));
		if(device != null) {
			device.handle = get_long(address+8);
		} else {
			device = new WGPUDevice(get_long(address+8));
		}
		format = TextureFormat.from(get_int(address+16));
		usage = get_int(address+20);
		var viewFormatCount = (int) get_long(address+24);
		var _viewFormats = get_long(address+32);
		alphaMode = CompositeAlphaMode.from(get_int(address+40));
		width = get_int(address+44);
		height = get_int(address+48);
		presentMode = PresentMode.from(get_int(address+52));
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
	public SurfaceConfiguration() {}
}
