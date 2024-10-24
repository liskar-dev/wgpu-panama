package wgpu;

import java.lang.foreign.Arena;
import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.Linker;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.util.WeakHashMap;

public interface Callback {
	static FunctionDescriptor functionDescriptor(MemoryLayout ret, MemoryLayout...args) {
		if(ret == null) {
			return FunctionDescriptor.ofVoid(args);
		} else {
			return FunctionDescriptor.of(ret, args);
		}
	}
	
	static MethodHandle findVirtual(Class<?> refc, String name, Class<?> ret, Class<?>...params) {
		try {
			return MethodHandles.lookup().findVirtual(refc, name, MethodType.methodType(ret, params));
		} catch (NoSuchMethodException | IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}
	
	static final WeakHashMap<Callback, MemorySegment> weakMap = new WeakHashMap<>();
	
	static MemorySegment createStub(Callback callback, MethodHandle handle, FunctionDescriptor desc) {
		MemorySegment stub = weakMap.get(callback);
		
		if(stub == null) {
			var bound = handle.bindTo(callback);
			stub = Linker.nativeLinker().upcallStub(bound, desc, Arena.ofAuto());
			weakMap.put(callback, stub);
		}
		
		return stub;
	}
	
	static String get_string(long address) {
		return CStruct.get_string(address);
	}

	static <T extends CStruct> T loadStruct(T struct, long address) {
		struct.load(address);
		return struct;
	}

}
