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

public class BlendState extends WGPUStruct {
	public BlendComponent color;
	public BlendComponent alpha;

	protected static final int byteSize = 32;
	protected int byteSize() {
		return byteSize;
	}

	protected long store(Stack stack, long address) {
		color.store(stack, address+0);
		alpha.store(stack, address+16);
		return address;
	}

	protected BlendState load(long address) {
		color = (color != null ? color : new BlendComponent()).load(address+0);
		alpha = (alpha != null ? alpha : new BlendComponent()).load(address+16);
		return this;
	}
	public BlendState() {}
}
