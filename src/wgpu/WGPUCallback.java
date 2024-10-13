package wgpu;

import java.lang.foreign.Arena;
import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.Linker;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

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
	
	public static MemorySegment createStub(WGPUCallback callback, MethodHandle handle, FunctionDescriptor desc) {
		var bound = handle.bindTo(callback);
		return Linker.nativeLinker().upcallStub(bound, desc, Arena.ofAuto());
	}
}
