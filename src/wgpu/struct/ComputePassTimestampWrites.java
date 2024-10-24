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

public class ComputePassTimestampWrites extends WGPUStruct {
	public WGPUQuerySet querySet = new WGPUQuerySet(0);
	public int beginningOfPassWriteIndex;
	public int endOfPassWriteIndex;

	protected static final int byteSize = 16;
	protected int byteSize() {
		return byteSize;
	}

	protected long store(Stack stack, long address) {
		put_value(address+0, querySet.handle );
		put_value(address+8, (int) beginningOfPassWriteIndex);
		put_value(address+12, (int) endOfPassWriteIndex);
		return address;
	}

	protected ComputePassTimestampWrites load(long address) {
		querySet.handle = get_long(address+0);
		beginningOfPassWriteIndex = get_int(address+8);
		endOfPassWriteIndex = get_int(address+12);
		return this;
	}
	public ComputePassTimestampWrites() {}
}
