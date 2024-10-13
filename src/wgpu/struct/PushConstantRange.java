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

public class PushConstantRange extends WGPUStruct {
	/** @see ShaderStage */
	public int stages;
	public int start;
	public int end;
	// padding 4

	protected int sizeInBytes() {
		return 16;
	}

	protected void writeTo(WGPUWriter out) {
		out.write(stages);
		out.write(start);
		out.write(end);
		out.padding(4);
	}

	protected PushConstantRange readFrom(WGPUReader in) {
		stages = in.read_int();
		start = in.read_int();
		end = in.read_int();
		in.padding(4);
		return this;
	}

	public PushConstantRange() {}

	public PushConstantRange(MemorySegment from) {
		readFrom(new WGPUReader(from));
	}

}
