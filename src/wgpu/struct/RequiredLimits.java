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

public class RequiredLimits extends WGPUStruct {
	public ChainedStruct nextInChain;
	public Limits limits;

	protected int sizeInBytes() {
		return 152;
	}

	protected void writeTo(WGPUWriter out) {
		out.pointer(nextInChain);
		out.write(limits);
	}

	protected RequiredLimits readFrom(WGPUReader in) {
		nextInChain = ChainedStruct.from(in.read_pointer());
		limits = new Limits().readFrom(in);
		return this;
	}

	public RequiredLimits() {}

	public RequiredLimits(MemorySegment from) {
		readFrom(new WGPUReader(from));
	}

}
