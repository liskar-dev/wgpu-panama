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

public class SurfaceConfigurationExtras extends ChainedStruct {
	// ChainedStruct chain;
	public int desiredMaximumFrameLatency;
	// padding 4

	protected int sizeInBytes() {
		return 24;
	}

	protected void writeTo(WGPUWriter out) {
		out.pointer(super.next);
		out.write(SType.SurfaceConfigurationExtras);
		out.padding(4);
		out.write(desiredMaximumFrameLatency);
		out.padding(4);
	}

	protected SurfaceConfigurationExtras readFrom(WGPUReader in) {
		super.next = ChainedStruct.from(in.read_pointer());
		var sType = in.read_int();
		in.padding(4);
		desiredMaximumFrameLatency = in.read_int();
		in.padding(4);
		return this;
	}

	public SurfaceConfigurationExtras() {}

	public SurfaceConfigurationExtras(MemorySegment from) {
		readFrom(new WGPUReader(from));
	}

}
