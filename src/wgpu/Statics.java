package wgpu;

import static java.lang.foreign.ValueLayout.JAVA_BYTE;

import java.lang.foreign.AddressLayout;
import java.lang.foreign.Arena;
import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

public class Statics {
	public static final AddressLayout POINTER = ValueLayout.ADDRESS.withTargetLayout(MemoryLayout.sequenceLayout(Long.MAX_VALUE, JAVA_BYTE));
	
	public static MemoryLayout STRUCT(int byteSize) {
		return MemoryLayout.structLayout(MemoryLayout.sequenceLayout(byteSize, JAVA_BYTE));
	}

	public static MemorySegment pointer(Arena arena, MemorySegment value) {
		return value == null ? MemorySegment.NULL : value;
	}
	
	public static MemorySegment pointer(Arena arena, WGPUImpl value) {
		return value == null ? MemorySegment.NULL : value.handle;
	}
	
	public static MemorySegment pointer(Arena arena, String str) {
		return str == null ? MemorySegment.NULL : arena.allocateFrom(str);
	}
	
	public static MemorySegment pointer(Arena arena, WGPUStruct value) {
		if(value == null) {
			return MemorySegment.NULL;
		}
		
		WGPUWriter writer = new WGPUWriter(arena, value.sizeInBytes() * 4);
		value.writeTo(writer);
		
		return writer.mem;
	}

	public static MemorySegment empty(Arena arena, WGPUStruct value) {
		return value == null ? MemorySegment.NULL : value.allocEmpty(arena);
	}
	
	public static MemorySegment empty(Arena arena, WGPUEnum[] values) {
		return values == null ? MemorySegment.NULL : arena.allocate(values.length * 4, 4);
	}
	
	public static MemorySegment empty(Arena arena, WGPUImpl[] values) {
		return values == null ? MemorySegment.NULL : arena.allocate(values.length * 8, 8);
	}

	public static MemorySegment pointer(Arena arena, WGPUStruct[] values) {
		if(values == null || values.length == 0) {
			return MemorySegment.NULL;
		}

		var first = values[0];
		WGPUWriter writer = new WGPUWriter(arena, values.length * first.sizeInBytes());
		
		for(var value : values) {
			writer.write(value);
		}
		
		return writer.mem;
	}
	
	public static MemorySegment pointer(Arena arena, WGPUImpl[] values) {
		if(values == null || values.length == 0) {
			return MemorySegment.NULL;
		}
		
		WGPUWriter writer = new WGPUWriter(arena, values.length * 8);
		
		for(var value : values) {
			writer.pointer(value);
		}
		
		return writer.mem;
	}
	
	public static MemorySegment pointer(Arena arena, WGPUEnum[] values) {
		if(values == null || values.length == 0) {
			return MemorySegment.NULL;
		}
		
		WGPUWriter writer = new WGPUWriter(arena, values.length * 4);
		
		for(var value : values) {
			writer.write(value);
		}
		
		return writer.mem;
	}
	
	public static MemorySegment pointer(Arena arena, int[] v) {
		return v == null ? MemorySegment.NULL : MemorySegment.ofArray(v);
	}

	public static MemorySegment value(Arena arena, WGPUStruct value) {
		WGPUWriter writer = new WGPUWriter(arena, value.sizeInBytes() * 4);
		value.writeTo(writer);
		return writer.mem;
	}
	
	public static long value(Arena arena, long v) {
		return v;
	}
	
	public static int value(Arena arena, int v) {
		return v;
	}
	
	public static float value(Arena arena, float v) {
		return v;
	}
	
	public static double value(Arena arena, double v) {
		return v;
	}
	
	public static short value(Arena arena, short v) {
		return v;
	}
	
	public static int value(Arena arena, boolean v) {
		return v ? 1 : 0;
	}
	
	public static int value(Arena arena, WGPUEnum enuum) {
		return enuum == null ? 0 : enuum.bits;
	}
	
	public static boolean isNull(MemorySegment mem) {
		return mem == null || mem.equals(MemorySegment.NULL);
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
}
