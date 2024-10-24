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

public abstract class ChainedStructOut extends WGPUStruct {
	public ChainedStructOut next;
	// SType sType;
	// padding 4

	private static ChainedStructOut from(int sType) {
		return switch(sType) {
			case SType.SupportedLimitsExtras -> new SupportedLimitsExtras();
			default -> null;
		};
	}

	protected static ChainedStructOut from(long address) {
		if(address == 0L) return null;
		var struct = from(get_int(address + 8));
		struct.load(address);
		return struct;
	}

}
