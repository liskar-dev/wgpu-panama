package wgpu.struct;

import wgpu.*;
import wgpu.impl.*;
import wgpu.struct.*;
import wgpu.enums.*;
import wgpu.callback.*;

import java.lang.foreign.*;
import org.jspecify.annotations.*;

import static java.lang.foreign.ValueLayout.*;
import static java.lang.foreign.MemoryLayout.*;

public class QuerySetDescriptorExtras extends ChainedStruct {
	// ChainedStruct chain;
	public PipelineStatisticName[] pipelineStatistics;
	// size_t pipelineStatisticCount

	protected static final int byteSize = 32;
	protected int byteSize() {
		return byteSize;
	}

	protected long store(Stack stack, long address) {
		put_value(address + 0, stack.alloc(next));
		put_value(address + 8, (int) SType.QuerySetDescriptorExtras);
		// padding 4
		put_value(address+16, stack.alloc(pipelineStatistics));
		put_value(address+24, (long) (pipelineStatistics == null ? 0 : pipelineStatistics.length));
		return address;
	}

	protected QuerySetDescriptorExtras load(long address) {
		var _next = get_long(address + 0);
		// unit32_t sType
		// padding 4
		var _pipelineStatistics = get_long(address+16);
		var pipelineStatisticCount = (int) get_long(address+24);
		super.next = ChainedStruct.from(_next);
		if(_pipelineStatistics != 0L) {
			pipelineStatistics = pipelineStatistics != null && pipelineStatistics.length == pipelineStatisticCount ? pipelineStatistics : new PipelineStatisticName[pipelineStatisticCount];
			for(int i=0; i<pipelineStatistics.length; i++) {
				pipelineStatistics[i] = PipelineStatisticName.from(get_int(_pipelineStatistics + i*4));
			}
		} else {
			pipelineStatistics= null;
		}
		return this;
	}
	public QuerySetDescriptorExtras() {}
}
