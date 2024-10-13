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

public class Extent3D extends WGPUStruct {
	public int width;
	public int height;
	public int depthOrArrayLayers;
	// padding 4

	protected int sizeInBytes() {
		return 16;
	}

	protected void writeTo(WGPUWriter out) {
		out.write(width);
		out.write(height);
		out.write(depthOrArrayLayers);
		out.padding(4);
	}

	protected Extent3D readFrom(WGPUReader in) {
		width = in.read_int();
		height = in.read_int();
		depthOrArrayLayers = in.read_int();
		in.padding(4);
		return this;
	}

	public Extent3D() {}

	public Extent3D(MemorySegment from) {
		readFrom(new WGPUReader(from));
	}

}
