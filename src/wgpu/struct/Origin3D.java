package wgpu.struct;

import wgpu.*;
import wgpu.impl.*;
import wgpu.struct.*;
import wgpu.enums.*;
import wgpu.callback.*;
import static wgpu.Statics.*;

import java.lang.foreign.*;
import org.jspecify.annotations.*;

import static java.lang.foreign.ValueLayout.*;
import static java.lang.foreign.MemoryLayout.*;

public class Origin3D extends WGPUStruct {
	public int x;
	public int y;
	public int z;
	// padding 4

	protected int sizeInBytes() {
		return 16;
	}

	protected void writeTo(WGPUWriter out) {
		out.write(x);
		out.write(y);
		out.write(z);
		out.padding(4);
	}

	protected Origin3D readFrom(WGPUReader in) {
		x = in.read_int();
		y = in.read_int();
		z = in.read_int();
		in.padding(4);
		return this;
	}

	public Origin3D() {}

	public Origin3D(MemorySegment from) {
		readFrom(new WGPUReader(from));
	}

}
