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

public class PrimitiveState extends WGPUStruct {
	public ChainedStruct nextInChain;
	public PrimitiveTopology topology;
	public IndexFormat stripIndexFormat;
	public FrontFace frontFace;
	public CullMode cullMode;

	protected static final int byteSize = 24;
	protected int byteSize() {
		return byteSize;
	}

	protected long store(Stack stack, long address) {
		put_value(address+0, stack.alloc(nextInChain));
		put_value(address+8, topology == null ? 0 : topology.bits );
		put_value(address+12, stripIndexFormat == null ? 0 : stripIndexFormat.bits );
		put_value(address+16, frontFace == null ? 0 : frontFace.bits );
		put_value(address+20, cullMode == null ? 0 : cullMode.bits );
		return address;
	}

	protected PrimitiveState load(long address) {
		nextInChain = ChainedStruct.from(get_long(address+0));
		topology = PrimitiveTopology.from(get_int(address+8));
		stripIndexFormat = IndexFormat.from(get_int(address+12));
		frontFace = FrontFace.from(get_int(address+16));
		cullMode = CullMode.from(get_int(address+20));
		return this;
	}
	public PrimitiveState() {}
}
