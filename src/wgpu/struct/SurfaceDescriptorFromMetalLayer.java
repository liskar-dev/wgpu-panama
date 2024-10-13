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

public class SurfaceDescriptorFromMetalLayer extends ChainedStruct {
	// ChainedStruct chain;
	public long layer;

	protected int sizeInBytes() {
		return 24;
	}

	protected void writeTo(WGPUWriter out) {
		out.pointer(super.next);
		out.write(SType.SurfaceDescriptorFromMetalLayer);
		out.padding(4);
		out.write(layer);
	}

	protected SurfaceDescriptorFromMetalLayer readFrom(WGPUReader in) {
		super.next = ChainedStruct.from(in.read_pointer());
		var sType = in.read_int();
		in.padding(4);
		layer = in.read_long();
		return this;
	}

	public SurfaceDescriptorFromMetalLayer() {}

	public SurfaceDescriptorFromMetalLayer(MemorySegment from) {
		readFrom(new WGPUReader(from));
	}

}
