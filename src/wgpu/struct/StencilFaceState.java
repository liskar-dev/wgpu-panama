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

public class StencilFaceState extends WGPUStruct {
	public CompareFunction compare;
	public StencilOperation failOp;
	public StencilOperation depthFailOp;
	public StencilOperation passOp;

	protected int sizeInBytes() {
		return 16;
	}

	protected void writeTo(WGPUWriter out) {
		out.write(compare);
		out.write(failOp);
		out.write(depthFailOp);
		out.write(passOp);
	}

	protected StencilFaceState readFrom(WGPUReader in) {
		compare = CompareFunction.from(in.read_int());
		failOp = StencilOperation.from(in.read_int());
		depthFailOp = StencilOperation.from(in.read_int());
		passOp = StencilOperation.from(in.read_int());
		return this;
	}

	public StencilFaceState() {}

	public StencilFaceState(MemorySegment from) {
		readFrom(new WGPUReader(from));
	}

}
