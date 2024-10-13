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

public class PipelineLayoutDescriptor extends WGPUStruct {
	public ChainedStruct nextInChain;
	@Nullable
	public String label;
	// [bindGroupLayoutCount]
	public WGPUBindGroupLayout[] bindGroupLayouts;

	protected int sizeInBytes() {
		return 32;
	}

	protected void writeTo(WGPUWriter out) {
		out.pointer(nextInChain);
		out.pointer(label);
		out.write((long) bindGroupLayouts.length);
		out.pointer(bindGroupLayouts);
	}

	protected PipelineLayoutDescriptor readFrom(WGPUReader in) {
		nextInChain = ChainedStruct.from(in.read_pointer());
		label = in.read_string();
		var bindGroupLayoutCount = (int) in.read_long();
		var _bindGroupLayouts = in.read_pointer();
		if(!isNull(_bindGroupLayouts)) {
			bindGroupLayouts = new WGPUBindGroupLayout[bindGroupLayoutCount];
			var rin = new WGPUReader(_bindGroupLayouts);
			for(int i=0; i<bindGroupLayouts.length; i++) {
				bindGroupLayouts[i] = new WGPUBindGroupLayout(rin.read_pointer());
			}
		}
		return this;
	}

	public PipelineLayoutDescriptor() {}

	public PipelineLayoutDescriptor(MemorySegment from) {
		readFrom(new WGPUReader(from));
	}

}
