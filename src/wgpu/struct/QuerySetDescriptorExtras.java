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

public class QuerySetDescriptorExtras extends ChainedStruct {
	// ChainedStruct chain;
	public PipelineStatisticName[] pipelineStatistics;
	// [pipelineStatisticCount]

	protected int sizeInBytes() {
		return 32;
	}

	protected void writeTo(WGPUWriter out) {
		out.pointer(super.next);
		out.write(SType.QuerySetDescriptorExtras);
		out.padding(4);
		out.pointer(pipelineStatistics);
		out.write((long) pipelineStatistics.length);
	}

	protected QuerySetDescriptorExtras readFrom(WGPUReader in) {
		super.next = ChainedStruct.from(in.read_pointer());
		var sType = in.read_int();
		in.padding(4);
		var _pipelineStatistics = in.read_pointer();
		var pipelineStatisticCount = (int) in.read_long();
		if(!isNull(_pipelineStatistics)) {
			pipelineStatistics = new PipelineStatisticName[pipelineStatisticCount];
			var rin = new WGPUReader(_pipelineStatistics);
			for(int i=0; i<pipelineStatistics.length; i++) {
				pipelineStatistics[i] = PipelineStatisticName.from(rin.read_int());
			}
		}
		return this;
	}

	public QuerySetDescriptorExtras() {}

	public QuerySetDescriptorExtras(MemorySegment from) {
		readFrom(new WGPUReader(from));
	}

}
