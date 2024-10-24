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

public class BlendComponent extends CStruct {
	public BlendOperation operation;
	public BlendFactor srcFactor;
	public BlendFactor dstFactor;

	protected static final int byteSize = 12;
	protected int byteSize() {
		return byteSize;
	}

	protected long store(Stack stack, long address) {
		put_value(address+0, operation == null ? 0 : operation.bits );
		put_value(address+4, srcFactor == null ? 0 : srcFactor.bits );
		put_value(address+8, dstFactor == null ? 0 : dstFactor.bits );
		return address;
	}

	protected BlendComponent load(long address) {
		operation = BlendOperation.from(get_int(address+0));
		srcFactor = BlendFactor.from(get_int(address+4));
		dstFactor = BlendFactor.from(get_int(address+8));
		return this;
	}
	public BlendComponent() {}
}
