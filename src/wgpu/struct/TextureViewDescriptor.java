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

public class TextureViewDescriptor extends WGPUStruct {
	public ChainedStruct nextInChain;
	@Nullable
	public String label;
	public TextureFormat format;
	public TextureViewDimension dimension;
	public int baseMipLevel;
	public int mipLevelCount;
	public int baseArrayLayer;
	public int arrayLayerCount;
	public TextureAspect aspect;
	// padding 4

	protected int sizeInBytes() {
		return 48;
	}

	protected void writeTo(WGPUWriter out) {
		out.pointer(nextInChain);
		out.pointer(label);
		out.write(format);
		out.write(dimension);
		out.write(baseMipLevel);
		out.write(mipLevelCount);
		out.write(baseArrayLayer);
		out.write(arrayLayerCount);
		out.write(aspect);
		out.padding(4);
	}

	protected TextureViewDescriptor readFrom(WGPUReader in) {
		nextInChain = ChainedStruct.from(in.read_pointer());
		label = in.read_string();
		format = TextureFormat.from(in.read_int());
		dimension = TextureViewDimension.from(in.read_int());
		baseMipLevel = in.read_int();
		mipLevelCount = in.read_int();
		baseArrayLayer = in.read_int();
		arrayLayerCount = in.read_int();
		aspect = TextureAspect.from(in.read_int());
		in.padding(4);
		return this;
	}

	public TextureViewDescriptor() {}

	public TextureViewDescriptor(MemorySegment from) {
		readFrom(new WGPUReader(from));
	}

}
