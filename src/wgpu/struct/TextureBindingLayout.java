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

public class TextureBindingLayout extends WGPUStruct {
	public ChainedStruct nextInChain;
	public TextureSampleType sampleType;
	public TextureViewDimension viewDimension;
	public boolean multisampled;
	// padding 4

	protected int sizeInBytes() {
		return 24;
	}

	protected void writeTo(WGPUWriter out) {
		out.pointer(nextInChain);
		out.write(sampleType);
		out.write(viewDimension);
		out.write(multisampled);
		out.padding(4);
	}

	protected TextureBindingLayout readFrom(WGPUReader in) {
		nextInChain = ChainedStruct.from(in.read_pointer());
		sampleType = TextureSampleType.from(in.read_int());
		viewDimension = TextureViewDimension.from(in.read_int());
		multisampled = in.read_boolean();
		in.padding(4);
		return this;
	}

	public TextureBindingLayout() {}

	public TextureBindingLayout(MemorySegment from) {
		readFrom(new WGPUReader(from));
	}

}
