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

public class ShaderDefine extends WGPUStruct {
	public String name;
	public String value;

	protected int sizeInBytes() {
		return 16;
	}

	protected void writeTo(WGPUWriter out) {
		out.pointer(name);
		out.pointer(value);
	}

	protected ShaderDefine readFrom(WGPUReader in) {
		name = in.read_string();
		value = in.read_string();
		return this;
	}

	public ShaderDefine() {}

	public ShaderDefine(MemorySegment from) {
		readFrom(new WGPUReader(from));
	}

}
