package wgpu.struct;

import wgpu.*;
import wgpu.impl.*;
import wgpu.struct.*;
import wgpu.enums.*;
import wgpu.callback.*;
import static wgpu.Statics.*;

import java.lang.foreign.*;
import org.jspecify.annotations.*;

import static java.lang.foreign.ValueLayout.*;
import static java.lang.foreign.MemoryLayout.*;

public class BindGroupEntryExtras extends ChainedStruct {
	// ChainedStruct chain;
	public WGPUBuffer[] buffers;
	// [bufferCount]
	public WGPUSampler[] samplers;
	// [samplerCount]
	public WGPUTextureView[] textureViews;
	// [textureViewCount]

	protected int sizeInBytes() {
		return 64;
	}

	protected void writeTo(WGPUWriter out) {
		out.pointer(super.next);
		out.write(SType.BindGroupEntryExtras);
		out.padding(4);
		out.pointer(buffers);
		out.write((long) buffers.length);
		out.pointer(samplers);
		out.write((long) samplers.length);
		out.pointer(textureViews);
		out.write((long) textureViews.length);
	}

	protected BindGroupEntryExtras readFrom(WGPUReader in) {
		super.next = ChainedStruct.from(in.read_pointer());
		var sType = in.read_int();
		in.padding(4);
		var _buffers = in.read_pointer();
		var bufferCount = (int) in.read_long();
		var _samplers = in.read_pointer();
		var samplerCount = (int) in.read_long();
		var _textureViews = in.read_pointer();
		var textureViewCount = (int) in.read_long();
		if(!isNull(_buffers)) {
			buffers = new WGPUBuffer[bufferCount];
			var rin = new WGPUReader(_buffers);
			for(int i=0; i<buffers.length; i++) {
				buffers[i] = new WGPUBuffer(rin.read_pointer());
			}
		}
		if(!isNull(_samplers)) {
			samplers = new WGPUSampler[samplerCount];
			var rin = new WGPUReader(_samplers);
			for(int i=0; i<samplers.length; i++) {
				samplers[i] = new WGPUSampler(rin.read_pointer());
			}
		}
		if(!isNull(_textureViews)) {
			textureViews = new WGPUTextureView[textureViewCount];
			var rin = new WGPUReader(_textureViews);
			for(int i=0; i<textureViews.length; i++) {
				textureViews[i] = new WGPUTextureView(rin.read_pointer());
			}
		}
		return this;
	}

	public BindGroupEntryExtras() {}

	public BindGroupEntryExtras(MemorySegment from) {
		readFrom(new WGPUReader(from));
	}

}
