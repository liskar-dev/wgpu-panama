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

public class ColorTargetState extends WGPUStruct {
	public ChainedStruct nextInChain;
	public TextureFormat format;
	// padding 4
	@Nullable
	public BlendState blend;
	/** @see ColorWriteMask */
	public int writeMask;
	// padding 4

	protected int sizeInBytes() {
		return 32;
	}

	protected void writeTo(WGPUWriter out) {
		out.pointer(nextInChain);
		out.write(format);
		out.padding(4);
		out.pointer(blend);
		out.write(writeMask);
		out.padding(4);
	}

	protected ColorTargetState readFrom(WGPUReader in) {
		nextInChain = ChainedStruct.from(in.read_pointer());
		format = TextureFormat.from(in.read_int());
		in.padding(4);
		var _blend = in.read_pointer();
		blend = isNull(_blend) ? null : new BlendState().readFrom(new WGPUReader(_blend));
		writeMask = in.read_int();
		in.padding(4);
		return this;
	}

	public ColorTargetState() {}

	public ColorTargetState(MemorySegment from) {
		readFrom(new WGPUReader(from));
	}

}
