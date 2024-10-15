package wgpu.struct;

import wgpu.*;
import wgpu.impl.*;
import wgpu.struct.*;
import wgpu.enums.*;
import wgpu.callback.*;
import static wgpu.StaticHelpers.*;

import java.lang.foreign.*;
import org.jspecify.annotations.*;

import static java.lang.foreign.ValueLayout.*;
import static java.lang.foreign.MemoryLayout.*;

public class NativeLimits extends WGPUStruct {
	public int maxPushConstantSize;
	public int maxNonSamplerBindings;

	protected static final int byteSize = 8;
	protected int byteSize() {
		return byteSize;
	}

	protected long store(Stack stack, long address) {
		put_value(address+0, (int) maxPushConstantSize);
		put_value(address+4, (int) maxNonSamplerBindings);
		return address;
	}

	protected NativeLimits load(long address) {
		maxPushConstantSize = get_int(address+0);
		maxNonSamplerBindings = get_int(address+4);
		return this;
	}
	public NativeLimits() {}
}
