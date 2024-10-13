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

public class BindGroupEntry extends WGPUStruct {
	public ChainedStruct nextInChain;
	public int binding;
	// padding 4
	@Nullable
	public WGPUBuffer buffer;
	public long offset;
	public long size;
	@Nullable
	public WGPUSampler sampler;
	@Nullable
	public WGPUTextureView textureView;

	protected int sizeInBytes() {
		return 56;
	}

	protected void writeTo(WGPUWriter out) {
		out.pointer(nextInChain);
		out.write(binding);
		out.padding(4);
		out.pointer(buffer);
		out.write(offset);
		out.write(size);
		out.pointer(sampler);
		out.pointer(textureView);
	}

	protected BindGroupEntry readFrom(WGPUReader in) {
		nextInChain = ChainedStruct.from(in.read_pointer());
		binding = in.read_int();
		in.padding(4);
		var _buffer = in.read_pointer();
		buffer = isNull(_buffer) ? null : new WGPUBuffer(_buffer);
		offset = in.read_long();
		size = in.read_long();
		var _sampler = in.read_pointer();
		sampler = isNull(_sampler) ? null : new WGPUSampler(_sampler);
		var _textureView = in.read_pointer();
		textureView = isNull(_textureView) ? null : new WGPUTextureView(_textureView);
		return this;
	}

	public BindGroupEntry() {}

	public BindGroupEntry(MemorySegment from) {
		readFrom(new WGPUReader(from));
	}

}
