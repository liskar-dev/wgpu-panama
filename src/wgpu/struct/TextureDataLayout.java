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

public class TextureDataLayout extends WGPUStruct {
	public ChainedStruct nextInChain;
	public long offset;
	public int bytesPerRow;
	public int rowsPerImage;

	protected int sizeInBytes() {
		return 24;
	}

	protected void writeTo(WGPUWriter out) {
		out.pointer(nextInChain);
		out.write(offset);
		out.write(bytesPerRow);
		out.write(rowsPerImage);
	}

	protected TextureDataLayout readFrom(WGPUReader in) {
		nextInChain = ChainedStruct.from(in.read_pointer());
		offset = in.read_long();
		bytesPerRow = in.read_int();
		rowsPerImage = in.read_int();
		return this;
	}

	public TextureDataLayout() {}

	public TextureDataLayout(MemorySegment from) {
		readFrom(new WGPUReader(from));
	}

}
