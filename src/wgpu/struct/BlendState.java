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
	public BlendComponent color = new BlendComponent();
	public BlendComponent alpha = new BlendComponent();

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
		color = color.load(address+0);
		alpha = alpha.load(address+16);
		return this;
	}
	public BlendState() {}
}
