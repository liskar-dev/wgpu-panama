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

public class BlendComponent extends WGPUStruct {
	public BlendOperation operation;
	public BlendFactor srcFactor;
	public BlendFactor dstFactor;
	// padding 4

	protected int sizeInBytes() {
		return 16;
	}

	protected void writeTo(WGPUWriter out) {
		out.write(operation);
		out.write(srcFactor);
		out.write(dstFactor);
		out.padding(4);
	}

	protected BlendComponent readFrom(WGPUReader in) {
		operation = BlendOperation.from(in.read_int());
		srcFactor = BlendFactor.from(in.read_int());
		dstFactor = BlendFactor.from(in.read_int());
		in.padding(4);
		return this;
	}

	public BlendComponent() {}

	public BlendComponent(MemorySegment from) {
		readFrom(new WGPUReader(from));
	}

}
