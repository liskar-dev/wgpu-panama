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

public class VertexAttribute extends WGPUStruct {
	public VertexFormat format;
	// padding 4
	public long offset;
	public int shaderLocation;
	// padding 4

	protected int sizeInBytes() {
		return 24;
	}

	protected void writeTo(WGPUWriter out) {
		out.write(format);
		out.padding(4);
		out.write(offset);
		out.write(shaderLocation);
		out.padding(4);
	}

	protected VertexAttribute readFrom(WGPUReader in) {
		format = VertexFormat.from(in.read_int());
		in.padding(4);
		offset = in.read_long();
		shaderLocation = in.read_int();
		in.padding(4);
		return this;
	}

	public VertexAttribute() {}

	public VertexAttribute(MemorySegment from) {
		readFrom(new WGPUReader(from));
	}

}
