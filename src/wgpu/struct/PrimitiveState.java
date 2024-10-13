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

public class PrimitiveState extends WGPUStruct {
	public ChainedStruct nextInChain;
	public PrimitiveTopology topology;
	public IndexFormat stripIndexFormat;
	public FrontFace frontFace;
	public CullMode cullMode;

	protected int sizeInBytes() {
		return 24;
	}

	protected void writeTo(WGPUWriter out) {
		out.pointer(nextInChain);
		out.write(topology);
		out.write(stripIndexFormat);
		out.write(frontFace);
		out.write(cullMode);
	}

	protected PrimitiveState readFrom(WGPUReader in) {
		nextInChain = ChainedStruct.from(in.read_pointer());
		topology = PrimitiveTopology.from(in.read_int());
		stripIndexFormat = IndexFormat.from(in.read_int());
		frontFace = FrontFace.from(in.read_int());
		cullMode = CullMode.from(in.read_int());
		return this;
	}

	public PrimitiveState() {}

	public PrimitiveState(MemorySegment from) {
		readFrom(new WGPUReader(from));
	}

}
