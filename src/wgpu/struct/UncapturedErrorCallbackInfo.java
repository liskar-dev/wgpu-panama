package wgpu.struct;

import wgpu.*;
import wgpu.impl.*;
import wgpu.struct.*;
import wgpu.enums.*;
import wgpu.callback.*;
import static wgpu.Statics.*;

import java.lang.foreign.*;
import org.jspecify.annotations.*;

import static java.lang.foreign.ValueLayout.*;
import static java.lang.foreign.MemoryLayout.*;

public class UncapturedErrorCallbackInfo extends WGPUStruct {
	public ChainedStruct nextInChain;
	public ErrorCallback callback;
	public long userdata;

	protected int sizeInBytes() {
		return 24;
	}

	protected void writeTo(WGPUWriter out) {
		out.pointer(nextInChain);
		out.pointer(WGPUCallback.createStub(callback, callback.handle, callback.desc));
		out.write(userdata);
	}

	protected UncapturedErrorCallbackInfo readFrom(WGPUReader in) {
		nextInChain = ChainedStruct.from(in.read_pointer());
		 in.read_pointer(); // TODO UNSOPPORTED:callback = new Callback();
		userdata = in.read_long();
		return this;
	}

	public UncapturedErrorCallbackInfo() {}

	public UncapturedErrorCallbackInfo(MemorySegment from) {
		readFrom(new WGPUReader(from));
	}

}
