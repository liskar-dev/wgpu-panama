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

public class ShaderModuleDescriptor extends WGPUStruct {
	public ChainedStruct nextInChain;
	@Nullable
	public String label;
	// [hintCount]
	public ShaderModuleCompilationHint[] hints;

	protected int sizeInBytes() {
		return 32;
	}

	protected void writeTo(WGPUWriter out) {
		out.pointer(nextInChain);
		out.pointer(label);
		out.write((long) (hints == null ? 0 : hints.length));
		out.pointer(hints);
	}

	protected ShaderModuleDescriptor readFrom(WGPUReader in) {
		nextInChain = ChainedStruct.from(in.read_pointer());
		label = in.read_string();
		var hintCount = (int) in.read_long();
		var _hints = in.read_pointer();
		if(!isNull(_hints)) {
			hints = new ShaderModuleCompilationHint[hintCount];
			var rin = new WGPUReader(_hints);
			for(int i=0; i<hints.length; i++) {
				hints[i] = new ShaderModuleCompilationHint().readFrom(rin);
			}
		}
		return this;
	}

	public ShaderModuleDescriptor() {}

	public ShaderModuleDescriptor(MemorySegment from) {
		readFrom(new WGPUReader(from));
	}

}
