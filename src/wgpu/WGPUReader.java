package wgpu;

import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;

import static java.lang.foreign.ValueLayout.*;
import static wgpu.Statics.POINTER;

import java.lang.foreign.MemoryLayout;

public class WGPUReader {
	private final MemorySegment mem;
	private int offset;
	
	public WGPUReader(MemorySegment mem) {
		this.mem = mem;
	}
	
	private int increment(int increment) {
		int off = offset;
		offset += increment;
		return off;
	}

	public void padding(int bytes) {
		offset += bytes;
	}
	
	public boolean read_boolean() {
		return mem.get(JAVA_INT, increment(4)) != 0;
	}
	
	public short read_short() {
		return mem.get(JAVA_SHORT, increment(2));
	}
	
	public int read_int() {
		return mem.get(JAVA_INT, increment(4));
	}
	
	public long read_long() {
		return mem.get(JAVA_LONG, increment(8));
	}
	
	public float read_float() {
		return mem.get(JAVA_FLOAT, increment(4));
	}
	
	public double read_double() {
		return mem.get(JAVA_DOUBLE, increment(8));
	}
	
	public MemorySegment read_pointer() {
		var pointer = mem.get(POINTER, increment(8));
		if(MemorySegment.NULL.equals(pointer))
			return null;
		return pointer;
	}
	
	public MemorySegment read_pointer(long length) {
		var pointer = mem.get(ADDRESS.withTargetLayout(MemoryLayout.sequenceLayout(length, ValueLayout.JAVA_BYTE)), increment(8));
		if(MemorySegment.NULL.equals(pointer))
			return null;
		return pointer;
	}
	
	public String read_string() {
		var pointer = read_pointer();
		if(pointer == null || MemorySegment.NULL.equals(pointer)) {
			return null;
		}
		return pointer.getString(0);
	}
	
}
