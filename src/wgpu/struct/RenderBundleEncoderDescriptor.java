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

public class RenderBundleEncoderDescriptor extends WGPUStruct {
	public ChainedStruct nextInChain;
	@Nullable
	public String label;
	// size_t colorFormatCount
	public TextureFormat[] colorFormats;
	public TextureFormat depthStencilFormat;
	public int sampleCount;
	public boolean depthReadOnly;
	public boolean stencilReadOnly;

	protected static final int byteSize = 48;
	protected int byteSize() {
		return byteSize;
	}

	protected long store(Stack stack, long address) {
		put_value(address+0, stack.alloc(nextInChain));
		put_value(address+8, stack.alloc(label));
		put_value(address+16, (long) (colorFormats == null ? 0 : colorFormats.length));
		put_value(address+24, stack.alloc(colorFormats));
		put_value(address+32, depthStencilFormat == null ? 0 : depthStencilFormat.bits );
		put_value(address+36, (int) sampleCount);
		put_value(address+40, (boolean) depthReadOnly);
		put_value(address+44, (boolean) stencilReadOnly);
		return address;
	}

	protected RenderBundleEncoderDescriptor load(long address) {
		nextInChain = ChainedStruct.from(get_long(address+0));
		label = get_string(get_long(address+8));
		var colorFormatCount = (int) get_long(address+16);
		var _colorFormats = get_long(address+24);
		depthStencilFormat = TextureFormat.from(get_int(address+32));
		sampleCount = get_int(address+36);
		depthReadOnly = get_boolean(address+40);
		stencilReadOnly = get_boolean(address+44);
		if(_colorFormats != 0L) {
			colorFormats = colorFormats != null && colorFormats.length == colorFormatCount ? colorFormats : new TextureFormat[colorFormatCount];
			for(int i=0; i<colorFormats.length; i++) {
				colorFormats[i] = TextureFormat.from(get_int(_colorFormats + i*4));
			}
		} else {
			colorFormats= null;
		}
		return this;
	}
	public RenderBundleEncoderDescriptor() {}
}
