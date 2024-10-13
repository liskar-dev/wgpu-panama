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

public class StorageTextureBindingLayout extends WGPUStruct {
	public ChainedStruct nextInChain;
	public StorageTextureAccess access;
	public TextureFormat format;
	public TextureViewDimension viewDimension;
	// padding 4

	protected int sizeInBytes() {
		return 24;
	}

	protected void writeTo(WGPUWriter out) {
		out.pointer(nextInChain);
		out.write(access);
		out.write(format);
		out.write(viewDimension);
		out.padding(4);
	}

	protected StorageTextureBindingLayout readFrom(WGPUReader in) {
		nextInChain = ChainedStruct.from(in.read_pointer());
		access = StorageTextureAccess.from(in.read_int());
		format = TextureFormat.from(in.read_int());
		viewDimension = TextureViewDimension.from(in.read_int());
		in.padding(4);
		return this;
	}

	public StorageTextureBindingLayout() {}

	public StorageTextureBindingLayout(MemorySegment from) {
		readFrom(new WGPUReader(from));
	}

}
