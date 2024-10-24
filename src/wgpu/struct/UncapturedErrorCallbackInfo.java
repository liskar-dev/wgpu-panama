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

public class UncapturedErrorCallbackInfo extends WGPUStruct {
	public ChainedStruct nextInChain;
	public ErrorCallback callback;
	public long userdata;

	protected static final int byteSize = 24;
	protected int byteSize() {
		return byteSize;
	}

	protected long store(Stack stack, long address) {
		put_value(address+0, stack.alloc(nextInChain));
		put_pointer(address+8, WGPUCallback.createStub(callback, callback.handle, callback.desc));
		put_value(address+16, (long) userdata);
		return address;
	}

	protected UncapturedErrorCallbackInfo load(long address) {
		nextInChain = ChainedStruct.from(get_long(address+0));
		// unsupported ErrorCallback * callback
		userdata = get_long(address+16);
		return this;
	}
	public UncapturedErrorCallbackInfo() {}
}
