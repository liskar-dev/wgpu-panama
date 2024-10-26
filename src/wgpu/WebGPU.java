package wgpu;

import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.Linker;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SymbolLookup;
import java.lang.foreign.ValueLayout;
import java.lang.invoke.MethodHandle;

import wgpu.callback.LogCallback;
import wgpu.enums.LogLevel;
import wgpu.impl.GPUInstance;
import wgpu.struct.InstanceDescriptor;

public class WebGPU {
	
	public static GPUInstance createInstance(InstanceDescriptor descriptor) {
		long handle = WGPU.wgpuCreateInstance(descriptor);
		if(handle == 0)
			throw new RuntimeException("Unable to create instance");
		return new GPUInstance(handle);
	}
	
	public static void setLogCallback(LogCallback callback) {
		WGPU.wgpuSetLogCallback(callback, 0L);
	}

	public static void setLogLevel(LogLevel level) {
		WGPU.wgpuSetLogLevel(level);
	}

	public static int getVersion() {
		return WGPU.wgpuGetVersion();
	}
	
	static Linker linker;
	static SymbolLookup lookup;
	
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
	
	static MemoryLayout STRUCT(int byteSize) {
		return MemoryLayout.structLayout(MemoryLayout.sequenceLayout(byteSize, ValueLayout.JAVA_BYTE));
	}
	
	static MemorySegment wrap(long address, int size) {
		return MemorySegment.ofAddress(address).reinterpret(size);
	}
}
