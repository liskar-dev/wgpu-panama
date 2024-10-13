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

public class SurfaceDescriptorFromXcbWindow extends ChainedStruct {
	// ChainedStruct chain;
	public long connection;
	public int window;
	// padding 4

	protected int sizeInBytes() {
		return 32;
	}

	protected void writeTo(WGPUWriter out) {
		out.pointer(super.next);
		out.write(SType.SurfaceDescriptorFromXcbWindow);
		out.padding(4);
		out.write(connection);
		out.write(window);
		out.padding(4);
	}

	protected SurfaceDescriptorFromXcbWindow readFrom(WGPUReader in) {
		super.next = ChainedStruct.from(in.read_pointer());
		var sType = in.read_int();
		in.padding(4);
		connection = in.read_long();
		window = in.read_int();
		in.padding(4);
		return this;
	}

	public SurfaceDescriptorFromXcbWindow() {}

	public SurfaceDescriptorFromXcbWindow(MemorySegment from) {
		readFrom(new WGPUReader(from));
	}

}
