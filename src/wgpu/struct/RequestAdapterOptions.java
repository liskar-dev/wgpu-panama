package wgpu.struct;

import wgpu.*;
import wgpu.impl.*;
import wgpu.struct.*;
import wgpu.enums.*;
import wgpu.callback.*;

import java.lang.foreign.*;
import org.jspecify.annotations.*;

import static java.lang.foreign.ValueLayout.*;
import static java.lang.foreign.MemoryLayout.*;

public class RequestAdapterOptions extends CStruct {
	public ChainedStruct nextInChain;
	public GPUSurface compatibleSurface = new GPUSurface(0);
	public PowerPreference powerPreference;
	public BackendType backendType;
	public boolean forceFallbackAdapter;
	// padding 4

	protected static final int byteSize = 32;
	protected int byteSize() {
		return byteSize;
	}

	protected long store(Stack stack, long address) {
		put_value(address+0, stack.alloc(nextInChain));
		put_value(address+8, compatibleSurface.handle );
		put_value(address+16, powerPreference == null ? 0 : powerPreference.bits );
		put_value(address+20, backendType == null ? 0 : backendType.bits );
		put_value(address+24, (boolean) forceFallbackAdapter);
		// padding 4
		return address;
	}

	protected RequestAdapterOptions load(long address) {
		nextInChain = ChainedStruct.from(get_long(address+0));
		compatibleSurface.handle = get_long(address+8);
		powerPreference = PowerPreference.from(get_int(address+16));
		backendType = BackendType.from(get_int(address+20));
		forceFallbackAdapter = get_boolean(address+24);
		// padding 4
		// padding 4
		return this;
	}
	public RequestAdapterOptions() {}
}
