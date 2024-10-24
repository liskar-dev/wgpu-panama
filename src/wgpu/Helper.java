package wgpu;

import static java.lang.foreign.ValueLayout.JAVA_BYTE;

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
class Helper {
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
	
	static final AddressLayout POINTER = ValueLayout.ADDRESS.withTargetLayout(MemoryLayout.sequenceLayout(Long.MAX_VALUE, JAVA_BYTE));
	static final MemorySegment memory = MemorySegment.ofAddress(0L).reinterpret(Long.MAX_VALUE);
	
	public static MemoryLayout STRUCT(int byteSize) {
		return MemoryLayout.structLayout(MemoryLayout.sequenceLayout(byteSize, JAVA_BYTE));
	}
	
	protected static MemorySegment wrap(long address, int size) {
		return MemorySegment.ofAddress(address).reinterpret(size);
	}
}
