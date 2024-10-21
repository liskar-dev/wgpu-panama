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

public interface WGPUCallback {
	static FunctionDescriptor functionDescriptor(MemoryLayout ret, MemoryLayout...args) {
		if(ret == null) {
			return FunctionDescriptor.ofVoid(args);
		} else {
			return FunctionDescriptor.of(ret, args);
		}
	}
	
	static MethodType methodType(Class<?> ret, Class<?>...params) {
		return MethodType.methodType(ret, params);
	}
	
	static MethodHandle findVirtual(Class<?> refc, String name, MethodType type) {
		try {
			return MethodHandles.lookup().findVirtual(refc, name, type);
		} catch (NoSuchMethodException | IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}
	
	static final WeakHashMap<WGPUCallback, MemorySegment> weakMap = new WeakHashMap<>();
	
	public static MemorySegment createStub(WGPUCallback callback, MethodHandle handle, FunctionDescriptor desc) {
		MemorySegment stub = weakMap.get(callback);
		
		if(stub == null) {
			var bound = handle.bindTo(callback);
			stub = Linker.nativeLinker().upcallStub(bound, desc, Arena.ofAuto());
			weakMap.put(callback, stub);
		}
		
		return stub;
	}
	

}
