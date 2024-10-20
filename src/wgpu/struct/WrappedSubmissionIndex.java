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

public class WrappedSubmissionIndex extends WGPUStruct {
	public WGPUQueue queue = new WGPUQueue(0);
	public long submissionIndex;

	protected static final int byteSize = 16;
	protected int byteSize() {
		return byteSize;
	}

	protected long store(Stack stack, long address) {
		put_value(address+0, queue.handle );
		put_value(address+8, (long) submissionIndex);
		return address;
	}

	protected WrappedSubmissionIndex load(long address) {
		queue.handle = get_long(address+0);
		submissionIndex = get_long(address+8);
		return this;
	}
	public WrappedSubmissionIndex() {}
}
