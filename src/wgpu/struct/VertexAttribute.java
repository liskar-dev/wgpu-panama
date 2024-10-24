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

public class VertexAttribute extends CStruct {
	public VertexFormat format;
	// padding 4
	public long offset;
	public int shaderLocation;
	// padding 4

	protected static final int byteSize = 24;
	protected int byteSize() {
		return byteSize;
	}

	protected long store(Stack stack, long address) {
		put_value(address+0, format == null ? 0 : format.bits );
		// padding 4
		put_value(address+8, (long) offset);
		put_value(address+16, (int) shaderLocation);
		// padding 4
		return address;
	}

	protected VertexAttribute load(long address) {
		format = VertexFormat.from(get_int(address+0));
		// padding 4
		offset = get_long(address+8);
		shaderLocation = get_int(address+16);
		// padding 4
		// padding 4
		// padding 4
		return this;
	}
	public VertexAttribute() {}
}
