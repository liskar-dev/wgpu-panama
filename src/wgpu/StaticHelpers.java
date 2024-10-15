package wgpu;

import static java.lang.foreign.ValueLayout.ADDRESS;
import static java.lang.foreign.ValueLayout.JAVA_BYTE;
import static java.lang.foreign.ValueLayout.JAVA_DOUBLE;
import static java.lang.foreign.ValueLayout.JAVA_FLOAT;
import static java.lang.foreign.ValueLayout.JAVA_INT;
import static java.lang.foreign.ValueLayout.JAVA_LONG;
import static java.lang.foreign.ValueLayout.JAVA_SHORT;

import java.lang.foreign.AddressLayout;
import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.Linker;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SymbolLookup;
import java.lang.foreign.ValueLayout;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/** Don't use this class, it's for crazy internals of wgpu wrapper */
public class StaticHelpers {
	private static Linker linker;
	private static SymbolLookup lookup;
	
	static {
		System.loadLibrary("wgpu_native");
		linker = Linker.nativeLinker();
		lookup = SymbolLookup.loaderLookup().or(linker.defaultLookup());
	}
	
	static MethodHandle lookup(MemoryLayout ret, String name, MemoryLayout...args) {
		var desc = ret == null ? FunctionDescriptor.ofVoid(args) : FunctionDescriptor.of(ret, args);
		var symbol = lookup.find(name).orElse(null);
		return linker.downcallHandle(symbol, desc);
	}
	
	public static final long NULL = 0L;
	public static final AddressLayout POINTER = ValueLayout.ADDRESS.withTargetLayout(MemoryLayout.sequenceLayout(Long.MAX_VALUE, JAVA_BYTE));
	private static final MemorySegment memory = MemorySegment.ofAddress(0L).reinterpret(Long.MAX_VALUE);
	
	public static MemoryLayout STRUCT(int byteSize) {
		return MemoryLayout.structLayout(MemoryLayout.sequenceLayout(byteSize, JAVA_BYTE));
	}
	
	public static FunctionDescriptor functionDescriptor(MemoryLayout ret, MemoryLayout...args) {
		if(ret == null) {
			return FunctionDescriptor.ofVoid(args);
		} else {
			return FunctionDescriptor.of(ret, args);
		}
	}
	
	public static MethodType methodType(Class<?> ret, Class<?>...params) {
		return MethodType.methodType(ret, params);
	}
	
	public static MethodHandle findVirtual(Class<?> refc, String name, MethodType type) {
		try {
			return MethodHandles.lookup().findVirtual(refc, name, type);
		} catch (NoSuchMethodException | IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static <T extends WGPUStruct> T loadStruct(T struct, long address) {
		struct.load(address);
		return struct;
	}
	
	protected static MemorySegment wrap(long address, int size) {
		return MemorySegment.ofAddress(address).reinterpret(size);
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
		//long pointer = get_long(address);
		return address == NULL ? null : memory.getString(address);
	}

	public static MemorySegment get_segment(long address) {
		long addr = memory.get(JAVA_LONG, address);
		return MemorySegment.ofAddress(addr).reinterpret(Long.MAX_VALUE);
	}
}
