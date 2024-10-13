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

public class ShaderModuleCompilationHint extends WGPUStruct {
	public ChainedStruct nextInChain;
	public String entryPoint;
	public WGPUPipelineLayout layout;

	protected int sizeInBytes() {
		return 24;
	}

	protected void writeTo(WGPUWriter out) {
		out.pointer(nextInChain);
		out.pointer(entryPoint);
		out.pointer(layout);
	}

	protected ShaderModuleCompilationHint readFrom(WGPUReader in) {
		nextInChain = ChainedStruct.from(in.read_pointer());
		entryPoint = in.read_string();
		var _layout = in.read_pointer();
		layout = isNull(_layout) ? null : new WGPUPipelineLayout(_layout);
		return this;
	}

	public ShaderModuleCompilationHint() {}

	public ShaderModuleCompilationHint(MemorySegment from) {
		readFrom(new WGPUReader(from));
	}

}
