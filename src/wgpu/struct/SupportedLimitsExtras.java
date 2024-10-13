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

public class SupportedLimitsExtras extends ChainedStructOut {
	// ChainedStructOut chain;
	public NativeLimits limits;

	protected int sizeInBytes() {
		return 24;
	}

	protected void writeTo(WGPUWriter out) {
		out.pointer(super.next);
		out.write(SType.SupportedLimitsExtras);
		out.padding(4);
		out.write(limits);
	}

	protected SupportedLimitsExtras readFrom(WGPUReader in) {
		super.next = ChainedStructOut.from(in.read_pointer());
		var sType = in.read_int();
		in.padding(4);
		limits = new NativeLimits().readFrom(in);
		return this;
	}

	public SupportedLimitsExtras() {}

	public SupportedLimitsExtras(MemorySegment from) {
		readFrom(new WGPUReader(from));
	}

}
