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

	public static ChainedStructOut from(MemorySegment mem) {
		if(mem == null || mem.equals(MemorySegment.NULL))
			return null;
		var struct = from(mem.get(JAVA_INT, 8));
		struct.readFrom(new WGPUReader(mem));
		return struct;
	}

}
