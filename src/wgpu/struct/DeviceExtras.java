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

public class DeviceExtras extends ChainedStruct {
	// ChainedStruct chain;
	public String tracePath;

	protected int sizeInBytes() {
		return 24;
	}

	protected void writeTo(WGPUWriter out) {
		out.pointer(super.next);
		out.write(SType.DeviceExtras);
		out.padding(4);
		out.pointer(tracePath);
	}

	protected DeviceExtras readFrom(WGPUReader in) {
		super.next = ChainedStruct.from(in.read_pointer());
		var sType = in.read_int();
		in.padding(4);
		tracePath = in.read_string();
		return this;
	}

	public DeviceExtras() {}

	public DeviceExtras(MemorySegment from) {
		readFrom(new WGPUReader(from));
	}

}
