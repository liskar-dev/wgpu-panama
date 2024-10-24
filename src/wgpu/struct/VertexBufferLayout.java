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

public class VertexBufferLayout extends WGPUStruct {
	public long arrayStride;
	public VertexStepMode stepMode;
	// padding 4
	// size_t attributeCount
	public VertexAttribute[] attributes;

	protected static final int byteSize = 32;
	protected int byteSize() {
		return byteSize;
	}

	protected long store(Stack stack, long address) {
		put_value(address+0, (long) arrayStride);
		put_value(address+8, stepMode == null ? 0 : stepMode.bits );
		// padding 4
		put_value(address+16, (long) (attributes == null ? 0 : attributes.length));
		put_value(address+24, stack.alloc(attributes));
		return address;
	}

	protected VertexBufferLayout load(long address) {
		arrayStride = get_long(address+0);
		stepMode = VertexStepMode.from(get_int(address+8));
		// padding 4
		var attributeCount = (int) get_long(address+16);
		var _attributes = get_long(address+24);
		// padding 4
		if(_attributes != 0L) {
			attributes = attributes != null && attributes.length == attributeCount ? attributes : new VertexAttribute[attributeCount];
			for(int i=0; i<attributes.length; i++) {
				attributes[i] = new VertexAttribute().load(_attributes + i*VertexAttribute.byteSize);
			}
		} else {
			attributes= null;
		}
		return this;
	}
	public VertexBufferLayout() {}
}
