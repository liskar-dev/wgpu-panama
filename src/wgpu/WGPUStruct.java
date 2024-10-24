package wgpu;

import static java.lang.foreign.ValueLayout.ADDRESS;
import static java.lang.foreign.ValueLayout.JAVA_BYTE;
import static java.lang.foreign.ValueLayout.JAVA_DOUBLE;
import static java.lang.foreign.ValueLayout.JAVA_FLOAT;
import static java.lang.foreign.ValueLayout.JAVA_INT;
import static java.lang.foreign.ValueLayout.JAVA_LONG;
import static java.lang.foreign.ValueLayout.JAVA_SHORT;

import static wgpu.Helper.*;

import java.lang.foreign.MemorySegment;

public abstract class WGPUStruct {
	protected abstract int byteSize();

	protected long calloc(Stack stack) {
		return stack.calloc(byteSize());
	}
	
	protected long store(Stack stack, long address) {
		return address;
	}
	
	protected WGPUStruct load(long address) {
		return this;
	}

	
	public static void put_value(long address, long value) {
		memory.set(JAVA_LONG, address, value);
	}

	public static void put_value(long address, int value) {
		memory.set(JAVA_INT, address, value);
	}

	public static void put_value(long address, short value) {
		memory.set(JAVA_SHORT, address, value);
	}

	public static void put_value(long address, byte value) {
		memory.set(JAVA_BYTE, address, value);
	}

	public static void put_value(long address, double value) {
		memory.set(JAVA_DOUBLE, address, value);
	}
	
	public static void put_value(long address, float value) {
		memory.set(JAVA_FLOAT, address, value);
	}
	
	public static void put_value(long address, boolean value) {
		memory.set(JAVA_INT, address, value? 1 : 0);
	}
	
	public static void put_pointer(long address, WGPUImpl impl) {
		memory.set(JAVA_LONG, address, impl == null ? 0L : impl.handle);
	}
	
	public static void put_pointer(long address, MemorySegment segment) {
		memory.set(ADDRESS, address, segment == null ? MemorySegment.NULL : segment);
	}
	
	public static byte get_byte(long address) {
		return memory.get(JAVA_BYTE, address);
	}
	
	public static short get_short(long address) {
		return memory.get(JAVA_SHORT, address);
	}
	
	public static int get_int(long address) {
		return memory.get(JAVA_INT, address);
	}
	
	public static long get_long(long address) {
		return memory.get(JAVA_LONG, address);
	}
	
	public static double get_double(long address) {
		return memory.get(JAVA_DOUBLE, address);
	}
	
	public static float get_float(long address) {
		return memory.get(JAVA_FLOAT, address);
	}
	
	public static boolean get_boolean(long address) {
		return memory.get(JAVA_INT, address) != 0;
	}
	
	public static String get_string(long address) {
		return address == 0L ? null : memory.getString(address);
	}

	public static MemorySegment get_segment(long address) {
		long addr = memory.get(JAVA_LONG, address);
		return MemorySegment.ofAddress(addr).reinterpret(Long.MAX_VALUE);
	}
}
