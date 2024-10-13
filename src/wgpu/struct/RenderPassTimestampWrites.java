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

public class RenderPassTimestampWrites extends WGPUStruct {
	public WGPUQuerySet querySet;
	public int beginningOfPassWriteIndex;
	public int endOfPassWriteIndex;

	protected int sizeInBytes() {
		return 16;
	}

	protected void writeTo(WGPUWriter out) {
		out.pointer(querySet);
		out.write(beginningOfPassWriteIndex);
		out.write(endOfPassWriteIndex);
	}

	protected RenderPassTimestampWrites readFrom(WGPUReader in) {
		var _querySet = in.read_pointer();
		querySet = isNull(_querySet) ? null : new WGPUQuerySet(_querySet);
		beginningOfPassWriteIndex = in.read_int();
		endOfPassWriteIndex = in.read_int();
		return this;
	}

	public RenderPassTimestampWrites() {}

	public RenderPassTimestampWrites(MemorySegment from) {
		readFrom(new WGPUReader(from));
	}

}
