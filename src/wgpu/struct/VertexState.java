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

public class VertexState extends WGPUStruct {
	public ChainedStruct nextInChain;
	public WGPUShaderModule module = new WGPUShaderModule(0);
	@Nullable
	public String entryPoint;
	// size_t constantCount
	public ConstantEntry[] constants;
	// size_t bufferCount
	public VertexBufferLayout[] buffers;

	protected static final int byteSize = 56;
	protected int byteSize() {
		return byteSize;
	}

	protected long store(Stack stack, long address) {
		put_value(address+0, stack.alloc(nextInChain));
		put_value(address+8, module.handle );
		put_value(address+16, stack.alloc(entryPoint));
		put_value(address+24, (long) (constants == null ? 0 : constants.length));
		put_value(address+32, stack.alloc(constants));
		put_value(address+40, (long) (buffers == null ? 0 : buffers.length));
		put_value(address+48, stack.alloc(buffers));
		return address;
	}

	protected VertexState load(long address) {
		nextInChain = ChainedStruct.from(get_long(address+0));
		module.handle = get_long(address+8);
		entryPoint = get_string(get_long(address+16));
		var constantCount = (int) get_long(address+24);
		var _constants = get_long(address+32);
		var bufferCount = (int) get_long(address+40);
		var _buffers = get_long(address+48);
		if(_constants != 0L) {
			constants = constants != null && constants.length == constantCount ? constants : new ConstantEntry[constantCount];
			for(int i=0; i<constants.length; i++) {
				constants[i] = new ConstantEntry().load(_constants + i*ConstantEntry.byteSize);
			}
		} else {
			constants= null;
		}
		if(_buffers != 0L) {
			buffers = buffers != null && buffers.length == bufferCount ? buffers : new VertexBufferLayout[bufferCount];
			for(int i=0; i<buffers.length; i++) {
				buffers[i] = new VertexBufferLayout().load(_buffers + i*VertexBufferLayout.byteSize);
			}
		} else {
			buffers= null;
		}
		return this;
	}
	public VertexState() {}
}
