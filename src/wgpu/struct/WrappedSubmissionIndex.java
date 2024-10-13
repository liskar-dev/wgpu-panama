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

public class WrappedSubmissionIndex extends WGPUStruct {
	public WGPUQueue queue;
	public long submissionIndex;

	protected int sizeInBytes() {
		return 16;
	}

	protected void writeTo(WGPUWriter out) {
		out.pointer(queue);
		out.write(submissionIndex);
	}

	protected WrappedSubmissionIndex readFrom(WGPUReader in) {
		var _queue = in.read_pointer();
		queue = isNull(_queue) ? null : new WGPUQueue(_queue);
		submissionIndex = in.read_long();
		return this;
	}

	public WrappedSubmissionIndex() {}

	public WrappedSubmissionIndex(MemorySegment from) {
		readFrom(new WGPUReader(from));
	}

}
