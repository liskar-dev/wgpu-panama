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

public class Extent3D extends CStruct {
	public int width;
	public int height;
	public int depthOrArrayLayers;

	protected static final int byteSize = 12;
	protected int byteSize() {
		return byteSize;
	}

	protected long store(Stack stack, long address) {
		put_value(address+0, (int) width);
		put_value(address+4, (int) height);
		put_value(address+8, (int) depthOrArrayLayers);
		return address;
	}

	protected Extent3D load(long address) {
		width = get_int(address+0);
		height = get_int(address+4);
		depthOrArrayLayers = get_int(address+8);
		return this;
	}
	public Extent3D() {}
}
