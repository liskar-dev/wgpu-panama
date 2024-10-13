package wgpu;

import java.lang.foreign.MemorySegment;

public class WGPUImpl {
	protected MemorySegment handle;
	protected WGPUImpl(MemorySegment handle) {
		this.handle = handle;
	}
}
