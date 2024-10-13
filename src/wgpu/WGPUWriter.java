package wgpu;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import static java.lang.foreign.ValueLayout.*;
import static wgpu.Statics.*;

public class WGPUWriter {
	final Arena arena;
	final MemorySegment mem;
	int offset;
	
	public WGPUWriter(Arena arena, MemorySegment mem) {
		this.arena = arena;
		this.mem = mem;
	}

	public WGPUWriter(Arena arena, int byteSize) {
		this.arena = arena;
		this.mem = arena.allocate(byteSize);
	}
	
	public void padding(int bytes) {
		offset += bytes;
	}

	public void write(boolean value) {
		mem.set(JAVA_INT, offset, value ? 1 : 0);
		offset += 4;
	}
	
	public void write(short value) {
		mem.set(JAVA_SHORT, offset, value);
		offset += 2;
	}
	
	public void write(int value) {
		mem.set(JAVA_INT, offset, value);
		offset += 4;
	}
	
	public void write(long value) {
		mem.set(JAVA_LONG, offset, value);
		offset += 8;
	}
	
	public void write(float value) {
		mem.set(JAVA_FLOAT, offset, value);
		offset += 4;
	}
	
	public void write(double value) {
		mem.set(JAVA_DOUBLE, offset, value);
		offset += 8;
	}

	public void pointer(MemorySegment value) {
		mem.set(ADDRESS, offset, value == null ? MemorySegment.NULL : value);
		offset += 8;
	}
	
	public void write(WGPUStruct value) {
		value.writeTo(this);
	}
	
	public void write(WGPUEnum value) {
		write(value == null ? 0 : value.bits);
	}

	public void pointer(WGPUImpl value) {
		pointer(value == null ? MemorySegment.NULL : value.handle);
	}

	public void pointer(String str) {
		pointer(str == null ? MemorySegment.NULL : arena.allocateFrom(str));
	}
	
	public void pointer(WGPUStruct value) {
		this.pointer(Statics.pointer(arena, value));
	}
	
	public void pointer(WGPUStruct[] values) {
		this.pointer(Statics.pointer(arena, values));
	}

	public void pointer(WGPUImpl[] values) {
		this.pointer(Statics.pointer(arena, values));
	}

	public void pointer(WGPUEnum[] values) {
		this.pointer(Statics.pointer(arena, values));
	}


	

}
