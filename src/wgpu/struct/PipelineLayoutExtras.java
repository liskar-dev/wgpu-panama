package wgpu.struct;

import wgpu.*;
import wgpu.impl.*;
import wgpu.struct.*;
import wgpu.enums.*;
import wgpu.callback.*;
import static wgpu.StaticHelpers.*;

import java.lang.foreign.*;
import org.jspecify.annotations.*;

import static java.lang.foreign.ValueLayout.*;
import static java.lang.foreign.MemoryLayout.*;

public class PipelineLayoutExtras extends ChainedStruct {
	// ChainedStruct chain;
	// size_t pushConstantRangeCount
	public PushConstantRange[] pushConstantRanges;

	protected static final int byteSize = 32;
	protected int byteSize() {
		return byteSize;
	}

	protected long store(Stack stack, long address) {
		put_value(address + 0, stack.alloc(next));
		put_value(address + 8, (int) SType.PipelineLayoutExtras);
		// padding 4
		put_value(address+16, (long) (pushConstantRanges == null ? 0 : pushConstantRanges.length));
		put_value(address+24, stack.alloc(pushConstantRanges));
		return address;
	}

	protected PipelineLayoutExtras load(long address) {
		var _next = get_long(address + 0);
		// unit32_t sType
		// padding 4
		var pushConstantRangeCount = (int) get_long(address+16);
		var _pushConstantRanges = get_long(address+24);
		super.next = ChainedStruct.from(_next);
		if(_pushConstantRanges != 0L) {
			pushConstantRanges = pushConstantRanges != null && pushConstantRanges.length == pushConstantRangeCount ? pushConstantRanges : new PushConstantRange[pushConstantRangeCount];
			for(int i=0; i<pushConstantRanges.length; i++) {
				pushConstantRanges[i] = new PushConstantRange().load(_pushConstantRanges + i*PushConstantRange.byteSize);
			}
		} else {
			pushConstantRanges= null;
		}
		return this;
	}
	public PipelineLayoutExtras() {}
}
