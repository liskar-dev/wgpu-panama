package wgpu;

import static java.lang.foreign.ValueLayout.ADDRESS;
import static java.lang.foreign.ValueLayout.JAVA_BYTE;
import static java.lang.foreign.ValueLayout.JAVA_DOUBLE;
import static java.lang.foreign.ValueLayout.JAVA_FLOAT;
import static java.lang.foreign.ValueLayout.JAVA_INT;
import static java.lang.foreign.ValueLayout.JAVA_LONG;
import static java.lang.foreign.ValueLayout.JAVA_SHORT;

import java.lang.foreign.MemorySegment;

public abstract class CStruct {
	static final MemorySegment memory = MemorySegment.ofAddress(0L).reinterpret(Long.MAX_VALUE);
	
	protected abstract int byteSize();

	protected long calloc(Stack stack) {
		return stack.calloc(byteSize());
	}
	
	protected long store(Stack stack, long address) {
		return address;
	}
	
	protected CStruct load(long address) {
		return this;
	}
	
	protected static void put_value(long address, long value) {
		memory.set(JAVA_LONG, address, value);
	}

	protected static void put_value(long address, int value) {
		memory.set(JAVA_INT, address, value);
	}

	protected static void put_value(long address, short value) {
		memory.set(JAVA_SHORT, address, value);
	}

	protected static void put_value(long address, byte value) {
		memory.set(JAVA_BYTE, address, value);
	}

	protected static void put_value(long address, double value) {
		memory.set(JAVA_DOUBLE, address, value);
	}
	
	protected static void put_value(long address, float value) {
		memory.set(JAVA_FLOAT, address, value);
	}
	
	protected static void put_value(long address, boolean value) {
		memory.set(JAVA_INT, address, value? 1 : 0);
	}
	
	protected static void put_pointer(long address, GPUObject impl) {
		memory.set(JAVA_LONG, address, impl == null ? 0L : impl.handle);
	}
	
	protected static void put_pointer(long address, MemorySegment segment) {
		memory.set(ADDRESS, address, segment == null ? MemorySegment.NULL : segment);
	}
	
	protected static byte get_byte(long address) {
		return memory.get(JAVA_BYTE, address);
	}
	
	protected static short get_short(long address) {
		return memory.get(JAVA_SHORT, address);
	}
	
	protected static int get_int(long address) {
		return memory.get(JAVA_INT, address);
	}
	
	protected static long get_long(long address) {
		return memory.get(JAVA_LONG, address);
	}
	
	protected static double get_double(long address) {
		return memory.get(JAVA_DOUBLE, address);
	}
	
	protected static float get_float(long address) {
		return memory.get(JAVA_FLOAT, address);
	}
	
	protected static boolean get_boolean(long address) {
		return memory.get(JAVA_INT, address) != 0;
	}
	
	protected static String get_string(long address) {
		return address == 0L ? null : memory.getString(address);
	}

	protected static MemorySegment get_segment(long address) {
		long addr = memory.get(JAVA_LONG, address);
		return MemorySegment.ofAddress(addr).reinterpret(Long.MAX_VALUE);
	}
}
