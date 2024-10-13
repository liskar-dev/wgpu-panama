package wgpu;

import static java.lang.foreign.ValueLayout.ADDRESS;
import static java.lang.foreign.ValueLayout.JAVA_DOUBLE;
import static java.lang.foreign.ValueLayout.JAVA_FLOAT;
import static java.lang.foreign.ValueLayout.JAVA_INT;
import static java.lang.foreign.ValueLayout.JAVA_LONG;
import static java.lang.foreign.ValueLayout.JAVA_SHORT;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

public abstract class WGPUStruct {
	
	protected MemorySegment alloc(Arena arena) {
		MemorySegment mem = arena.allocate(sizeInBytes());
		WGPUWriter out = new WGPUWriter(arena, mem);
		this.writeTo(out);
		return mem;
	}
	
	protected abstract int sizeInBytes();
	protected abstract void writeTo(WGPUWriter out);
	protected abstract WGPUStruct readFrom(WGPUReader in);
	protected final void readFrom(MemorySegment mem) {
		this.readFrom(new WGPUReader(mem));
	}
	
}
