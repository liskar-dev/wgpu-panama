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

public class BindGroupEntryExtras extends ChainedStruct {
	// ChainedStruct chain;
	public WGPUBuffer[] buffers;
	// size_t bufferCount
	public WGPUSampler[] samplers;
	// size_t samplerCount
	public WGPUTextureView[] textureViews;
	// size_t textureViewCount

	protected static final int byteSize = 64;
	protected int byteSize() {
		return byteSize;
	}

	protected long store(Stack stack, long address) {
		put_value(address + 0, stack.alloc(next));
		put_value(address + 8, (int) SType.BindGroupEntryExtras);
		// padding 4
		put_value(address+16, stack.alloc(buffers));
		put_value(address+24, (long) (buffers == null ? 0 : buffers.length));
		put_value(address+32, stack.alloc(samplers));
		put_value(address+40, (long) (samplers == null ? 0 : samplers.length));
		put_value(address+48, stack.alloc(textureViews));
		put_value(address+56, (long) (textureViews == null ? 0 : textureViews.length));
		return address;
	}

	protected BindGroupEntryExtras load(long address) {
		var _next = get_long(address + 0);
		// unit32_t sType
		// padding 4
		var _buffers = get_long(address+16);
		var bufferCount = (int) get_long(address+24);
		var _samplers = get_long(address+32);
		var samplerCount = (int) get_long(address+40);
		var _textureViews = get_long(address+48);
		var textureViewCount = (int) get_long(address+56);
		super.next = ChainedStruct.from(_next);
		if(_buffers != 0L) {
			buffers = buffers != null && buffers.length == bufferCount ? buffers : new WGPUBuffer[bufferCount];
			for(int i=0; i<buffers.length; i++) {
				buffers[i] = new WGPUBuffer(get_int(_buffers + i*8));
			}
		} else {
			buffers= null;
		}
		if(_samplers != 0L) {
			samplers = samplers != null && samplers.length == samplerCount ? samplers : new WGPUSampler[samplerCount];
			for(int i=0; i<samplers.length; i++) {
				samplers[i] = new WGPUSampler(get_int(_samplers + i*8));
			}
		} else {
			samplers= null;
		}
		if(_textureViews != 0L) {
			textureViews = textureViews != null && textureViews.length == textureViewCount ? textureViews : new WGPUTextureView[textureViewCount];
			for(int i=0; i<textureViews.length; i++) {
				textureViews[i] = new WGPUTextureView(get_int(_textureViews + i*8));
			}
		} else {
			textureViews= null;
		}
		return this;
	}
	public BindGroupEntryExtras() {}
}
