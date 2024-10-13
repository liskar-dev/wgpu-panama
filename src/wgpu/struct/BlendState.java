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

public class BlendState extends WGPUStruct {
	public BlendComponent color;
	public BlendComponent alpha;

	protected int sizeInBytes() {
		return 32;
	}

	protected void writeTo(WGPUWriter out) {
		out.write(color);
		out.write(alpha);
	}

	protected BlendState readFrom(WGPUReader in) {
		color = new BlendComponent().readFrom(in);
		alpha = new BlendComponent().readFrom(in);
		return this;
	}

	public BlendState() {}

	public BlendState(MemorySegment from) {
		readFrom(new WGPUReader(from));
	}

}
