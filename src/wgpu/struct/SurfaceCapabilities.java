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

public class SurfaceCapabilities extends CStruct {
	public ChainedStructOut nextInChain;
	/** @see TextureUsage */
	public int usages;
	// padding 4
	// size_t formatCount
	public TextureFormat[] formats;
	// size_t presentModeCount
	public PresentMode[] presentModes;
	// size_t alphaModeCount
	public CompositeAlphaMode[] alphaModes;

	protected static final int byteSize = 64;
	protected int byteSize() {
		return byteSize;
	}

	protected long store(Stack stack, long address) {
		put_value(address+0, stack.alloc(nextInChain));
		put_value(address+8, (int) usages);
		// padding 4
		put_value(address+16, (long) (formats == null ? 0 : formats.length));
		put_value(address+24, stack.alloc(formats));
		put_value(address+32, (long) (presentModes == null ? 0 : presentModes.length));
		put_value(address+40, stack.alloc(presentModes));
		put_value(address+48, (long) (alphaModes == null ? 0 : alphaModes.length));
		put_value(address+56, stack.alloc(alphaModes));
		return address;
	}

	protected SurfaceCapabilities load(long address) {
		nextInChain = ChainedStructOut.from(get_long(address+0));
		usages = get_int(address+8);
		// padding 4
		var formatCount = (int) get_long(address+16);
		var _formats = get_long(address+24);
		var presentModeCount = (int) get_long(address+32);
		var _presentModes = get_long(address+40);
		var alphaModeCount = (int) get_long(address+48);
		var _alphaModes = get_long(address+56);
		// padding 4
		if(_formats != 0L) {
			formats = formats != null && formats.length == formatCount ? formats : new TextureFormat[formatCount];
			for(int i=0; i<formats.length; i++) {
				formats[i] = TextureFormat.from(get_int(_formats + i*4));
			}
		} else {
			formats= null;
		}
		if(_presentModes != 0L) {
			presentModes = presentModes != null && presentModes.length == presentModeCount ? presentModes : new PresentMode[presentModeCount];
			for(int i=0; i<presentModes.length; i++) {
				presentModes[i] = PresentMode.from(get_int(_presentModes + i*4));
			}
		} else {
			presentModes= null;
		}
		if(_alphaModes != 0L) {
			alphaModes = alphaModes != null && alphaModes.length == alphaModeCount ? alphaModes : new CompositeAlphaMode[alphaModeCount];
			for(int i=0; i<alphaModes.length; i++) {
				alphaModes[i] = CompositeAlphaMode.from(get_int(_alphaModes + i*4));
			}
		} else {
			alphaModes= null;
		}
		return this;
	}
	public SurfaceCapabilities() {}
}
