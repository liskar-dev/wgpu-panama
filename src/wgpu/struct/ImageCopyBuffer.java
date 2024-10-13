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

public class ImageCopyBuffer extends WGPUStruct {
	public ChainedStruct nextInChain;
	public TextureDataLayout layout;
	public WGPUBuffer buffer;

	protected int sizeInBytes() {
		return 40;
	}

	protected void writeTo(WGPUWriter out) {
		out.pointer(nextInChain);
		out.write(layout);
		out.pointer(buffer);
	}

	protected ImageCopyBuffer readFrom(WGPUReader in) {
		nextInChain = ChainedStruct.from(in.read_pointer());
		layout = new TextureDataLayout().readFrom(in);
		var _buffer = in.read_pointer();
		buffer = isNull(_buffer) ? null : new WGPUBuffer(_buffer);
		return this;
	}

	public ImageCopyBuffer() {}

	public ImageCopyBuffer(MemorySegment from) {
		readFrom(new WGPUReader(from));
	}

}
