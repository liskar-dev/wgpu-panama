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

public class Origin3D extends WGPUStruct {
	public int x;
	public int y;
	public int z;
	// padding 4

	protected static final int byteSize = 16;
	protected int byteSize() {
		return byteSize;
	}

	protected long store(Stack stack, long address) {
		put_value(address+0, (int) x);
		put_value(address+4, (int) y);
		put_value(address+8, (int) z);
		// padding 4
		return address;
	}

	protected Origin3D load(long address) {
		x = get_int(address+0);
		y = get_int(address+4);
		z = get_int(address+8);
		// padding 4
		// padding 4
		return this;
	}
	public Origin3D() {}
}
