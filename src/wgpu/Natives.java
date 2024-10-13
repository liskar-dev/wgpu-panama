package wgpu;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.Linker;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.SymbolLookup;
import java.lang.invoke.MethodHandle;

class Natives {
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
	
	
}
