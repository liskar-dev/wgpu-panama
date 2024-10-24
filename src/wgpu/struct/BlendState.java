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

public class BlendState extends WGPUStruct {
	public BlendComponent color = new BlendComponent();
	public BlendComponent alpha = new BlendComponent();

	protected static final int byteSize = 24;
	protected int byteSize() {
		return byteSize;
	}

	protected long store(Stack stack, long address) {
		color.store(stack, address+0);
		alpha.store(stack, address+12);
		return address;
	}

	protected BlendState load(long address) {
		color = color.load(address+0);
		alpha = alpha.load(address+12);
		return this;
	}
	public BlendState() {}
}
