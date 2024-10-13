package wgpu;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

public abstract class WGPUStruct {
	
	protected MemorySegment alloc(Arena arena) {
		MemorySegment mem = arena.allocate(sizeInBytes(), 8);
		WGPUWriter out = new WGPUWriter(arena, mem);
		this.writeTo(out);
		return mem;
	}

	protected MemorySegment allocEmpty(Arena arena) {
		return arena.allocate(sizeInBytes(), 8);
	}
	
	protected abstract int sizeInBytes();
	protected abstract void writeTo(WGPUWriter out);
	protected abstract WGPUStruct readFrom(WGPUReader in);
	protected final void readFrom(MemorySegment mem) {
		this.readFrom(new WGPUReader(mem));
	}
	
}
