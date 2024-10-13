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

public class PipelineLayoutExtras extends ChainedStruct {
	// ChainedStruct chain;
	// [pushConstantRangeCount]
	public PushConstantRange[] pushConstantRanges;

	protected int sizeInBytes() {
		return 32;
	}

	protected void writeTo(WGPUWriter out) {
		out.pointer(super.next);
		out.write(SType.PipelineLayoutExtras);
		out.padding(4);
		out.write((long) pushConstantRanges.length);
		out.pointer(pushConstantRanges);
	}

	protected PipelineLayoutExtras readFrom(WGPUReader in) {
		super.next = ChainedStruct.from(in.read_pointer());
		var sType = in.read_int();
		in.padding(4);
		var pushConstantRangeCount = (int) in.read_long();
		var _pushConstantRanges = in.read_pointer();
		if(!isNull(_pushConstantRanges)) {
			pushConstantRanges = new PushConstantRange[pushConstantRangeCount];
			var rin = new WGPUReader(_pushConstantRanges);
			for(int i=0; i<pushConstantRanges.length; i++) {
				pushConstantRanges[i] = new PushConstantRange().readFrom(rin);
			}
		}
		return this;
	}

	public PipelineLayoutExtras() {}

	public PipelineLayoutExtras(MemorySegment from) {
		readFrom(new WGPUReader(from));
	}

}
