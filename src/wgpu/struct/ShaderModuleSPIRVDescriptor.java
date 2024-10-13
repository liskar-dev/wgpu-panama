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

public class ShaderModuleSPIRVDescriptor extends ChainedStruct {
	// ChainedStruct chain;
	// *codeSize
	// padding 4
	public MemorySegment code;

	protected int sizeInBytes() {
		return 32;
	}

	protected void writeTo(WGPUWriter out) {
		out.pointer(super.next);
		out.write(SType.ShaderModuleSPIRVDescriptor);
		out.padding(4);
		out.write((int) code.byteSize());
		out.padding(4);
		out.pointer(code);
	}

	protected ShaderModuleSPIRVDescriptor readFrom(WGPUReader in) {
		super.next = ChainedStruct.from(in.read_pointer());
		var sType = in.read_int();
		in.padding(4);
		var codeSize = in.read_int();
		in.padding(4);
		var code = in.read_pointer(codeSize);
		return this;
	}

	public ShaderModuleSPIRVDescriptor() {}

	public ShaderModuleSPIRVDescriptor(MemorySegment from) {
		readFrom(new WGPUReader(from));
	}

}
