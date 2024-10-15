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

public class StencilFaceState extends WGPUStruct {
	public CompareFunction compare;
	public StencilOperation failOp;
	public StencilOperation depthFailOp;
	public StencilOperation passOp;

	protected static final int byteSize = 16;
	protected int byteSize() {
		return byteSize;
	}

	protected long store(Stack stack, long address) {
		put_value(address+0, compare == null ? 0 : compare.bits );
		put_value(address+4, failOp == null ? 0 : failOp.bits );
		put_value(address+8, depthFailOp == null ? 0 : depthFailOp.bits );
		put_value(address+12, passOp == null ? 0 : passOp.bits );
		return address;
	}

	protected StencilFaceState load(long address) {
		compare = CompareFunction.from(get_int(address+0));
		failOp = StencilOperation.from(get_int(address+4));
		depthFailOp = StencilOperation.from(get_int(address+8));
		passOp = StencilOperation.from(get_int(address+12));
		return this;
	}
	public StencilFaceState() {}
}
