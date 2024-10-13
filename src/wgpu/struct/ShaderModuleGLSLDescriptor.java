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

public class ShaderModuleGLSLDescriptor extends ChainedStruct {
	// ChainedStruct chain;
	/** @see ShaderStage */
	public int stage;
	// padding 4
	public String code;
	// [defineCount]
	// padding 4
	public ShaderDefine[] defines;

	protected int sizeInBytes() {
		return 48;
	}

	protected void writeTo(WGPUWriter out) {
		out.pointer(super.next);
		out.write(SType.ShaderModuleGLSLDescriptor);
		out.padding(4);
		out.write(stage);
		out.padding(4);
		out.pointer(code);
		out.write((int) defines.length);
		out.padding(4);
		out.pointer(defines);
	}

	protected ShaderModuleGLSLDescriptor readFrom(WGPUReader in) {
		super.next = ChainedStruct.from(in.read_pointer());
		var sType = in.read_int();
		in.padding(4);
		stage = in.read_int();
		in.padding(4);
		code = in.read_string();
		var defineCount = (int) in.read_int();
		in.padding(4);
		var _defines = in.read_pointer();
		if(!isNull(_defines)) {
			defines = new ShaderDefine[defineCount];
			var rin = new WGPUReader(_defines);
			for(int i=0; i<defines.length; i++) {
				defines[i] = new ShaderDefine().readFrom(rin);
			}
		}
		return this;
	}

	public ShaderModuleGLSLDescriptor() {}

	public ShaderModuleGLSLDescriptor(MemorySegment from) {
		readFrom(new WGPUReader(from));
	}

}
