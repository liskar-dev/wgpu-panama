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

public class RequestAdapterOptions extends WGPUStruct {
	public ChainedStruct nextInChain;
	@Nullable
	public WGPUSurface compatibleSurface;
	public PowerPreference powerPreference;
	public BackendType backendType;
	public boolean forceFallbackAdapter;
	// padding 4

	protected int sizeInBytes() {
		return 32;
	}

	protected void writeTo(WGPUWriter out) {
		out.pointer(nextInChain);
		out.pointer(compatibleSurface);
		out.write(powerPreference);
		out.write(backendType);
		out.write(forceFallbackAdapter);
		out.padding(4);
	}

	protected RequestAdapterOptions readFrom(WGPUReader in) {
		nextInChain = ChainedStruct.from(in.read_pointer());
		var _compatibleSurface = in.read_pointer();
		compatibleSurface = isNull(_compatibleSurface) ? null : new WGPUSurface(_compatibleSurface);
		powerPreference = PowerPreference.from(in.read_int());
		backendType = BackendType.from(in.read_int());
		forceFallbackAdapter = in.read_boolean();
		in.padding(4);
		return this;
	}

	public RequestAdapterOptions() {}

	public RequestAdapterOptions(MemorySegment from) {
		readFrom(new WGPUReader(from));
	}

}
