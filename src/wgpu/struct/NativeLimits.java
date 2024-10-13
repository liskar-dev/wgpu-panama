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

public class NativeLimits extends WGPUStruct {
	public int maxPushConstantSize;
	public int maxNonSamplerBindings;

	protected int sizeInBytes() {
		return 8;
	}

	protected void writeTo(WGPUWriter out) {
		out.write(maxPushConstantSize);
		out.write(maxNonSamplerBindings);
	}

	protected NativeLimits readFrom(WGPUReader in) {
		maxPushConstantSize = in.read_int();
		maxNonSamplerBindings = in.read_int();
		return this;
	}

	public NativeLimits() {}

	public NativeLimits(MemorySegment from) {
		readFrom(new WGPUReader(from));
	}

}
