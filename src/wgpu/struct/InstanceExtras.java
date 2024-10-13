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

public class InstanceExtras extends ChainedStruct {
	// ChainedStruct chain;
	/** @see InstanceBackend */
	public int backends;
	/** @see InstanceFlag */
	public int flags;
	public Dx12Compiler dx12ShaderCompiler;
	public Gles3MinorVersion gles3MinorVersion;
	public String dxilPath;
	public String dxcPath;

	protected int sizeInBytes() {
		return 48;
	}

	protected void writeTo(WGPUWriter out) {
		out.pointer(super.next);
		out.write(SType.InstanceExtras);
		out.padding(4);
		out.write(backends);
		out.write(flags);
		out.write(dx12ShaderCompiler);
		out.write(gles3MinorVersion);
		out.pointer(dxilPath);
		out.pointer(dxcPath);
	}

	protected InstanceExtras readFrom(WGPUReader in) {
		super.next = ChainedStruct.from(in.read_pointer());
		var sType = in.read_int();
		in.padding(4);
		backends = in.read_int();
		flags = in.read_int();
		dx12ShaderCompiler = Dx12Compiler.from(in.read_int());
		gles3MinorVersion = Gles3MinorVersion.from(in.read_int());
		dxilPath = in.read_string();
		dxcPath = in.read_string();
		return this;
	}

	public InstanceExtras() {}

	public InstanceExtras(MemorySegment from) {
		readFrom(new WGPUReader(from));
	}

}
