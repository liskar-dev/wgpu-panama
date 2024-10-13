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

public class PrimitiveDepthClipControl extends ChainedStruct {
	// ChainedStruct chain;
	public boolean unclippedDepth;
	// padding 4

	protected int sizeInBytes() {
		return 24;
	}

	protected void writeTo(WGPUWriter out) {
		out.pointer(super.next);
		out.write(SType.PrimitiveDepthClipControl);
		out.padding(4);
		out.write(unclippedDepth);
		out.padding(4);
	}

	protected PrimitiveDepthClipControl readFrom(WGPUReader in) {
		super.next = ChainedStruct.from(in.read_pointer());
		var sType = in.read_int();
		in.padding(4);
		unclippedDepth = in.read_boolean();
		in.padding(4);
		return this;
	}

	public PrimitiveDepthClipControl() {}

	public PrimitiveDepthClipControl(MemorySegment from) {
		readFrom(new WGPUReader(from));
	}

}
