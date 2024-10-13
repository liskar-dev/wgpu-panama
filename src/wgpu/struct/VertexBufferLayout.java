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

public class VertexBufferLayout extends WGPUStruct {
	public long arrayStride;
	public VertexStepMode stepMode;
	// padding 4
	// [attributeCount]
	public VertexAttribute[] attributes;

	protected int sizeInBytes() {
		return 32;
	}

	protected void writeTo(WGPUWriter out) {
		out.write(arrayStride);
		out.write(stepMode);
		out.padding(4);
		out.write((long) attributes.length);
		out.pointer(attributes);
	}

	protected VertexBufferLayout readFrom(WGPUReader in) {
		arrayStride = in.read_long();
		stepMode = VertexStepMode.from(in.read_int());
		in.padding(4);
		var attributeCount = (int) in.read_long();
		var _attributes = in.read_pointer();
		if(!isNull(_attributes)) {
			attributes = new VertexAttribute[attributeCount];
			var rin = new WGPUReader(_attributes);
			for(int i=0; i<attributes.length; i++) {
				attributes[i] = new VertexAttribute().readFrom(rin);
			}
		}
		return this;
	}

	public VertexBufferLayout() {}

	public VertexBufferLayout(MemorySegment from) {
		readFrom(new WGPUReader(from));
	}

}
