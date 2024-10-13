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

public class SamplerDescriptor extends WGPUStruct {
	public ChainedStruct nextInChain;
	@Nullable
	public String label;
	public AddressMode addressModeU;
	public AddressMode addressModeV;
	public AddressMode addressModeW;
	public FilterMode magFilter;
	public FilterMode minFilter;
	public MipmapFilterMode mipmapFilter;
	public float lodMinClamp;
	public float lodMaxClamp;
	public CompareFunction compare;
	public short maxAnisotropy;
	// padding 2

	protected int sizeInBytes() {
		return 56;
	}

	protected void writeTo(WGPUWriter out) {
		out.pointer(nextInChain);
		out.pointer(label);
		out.write(addressModeU);
		out.write(addressModeV);
		out.write(addressModeW);
		out.write(magFilter);
		out.write(minFilter);
		out.write(mipmapFilter);
		out.write(lodMinClamp);
		out.write(lodMaxClamp);
		out.write(compare);
		out.write(maxAnisotropy);
		out.padding(2);
	}

	protected SamplerDescriptor readFrom(WGPUReader in) {
		nextInChain = ChainedStruct.from(in.read_pointer());
		label = in.read_string();
		addressModeU = AddressMode.from(in.read_int());
		addressModeV = AddressMode.from(in.read_int());
		addressModeW = AddressMode.from(in.read_int());
		magFilter = FilterMode.from(in.read_int());
		minFilter = FilterMode.from(in.read_int());
		mipmapFilter = MipmapFilterMode.from(in.read_int());
		lodMinClamp = in.read_float();
		lodMaxClamp = in.read_float();
		compare = CompareFunction.from(in.read_int());
		maxAnisotropy = in.read_short();
		in.padding(2);
		return this;
	}

	public SamplerDescriptor() {}

	public SamplerDescriptor(MemorySegment from) {
		readFrom(new WGPUReader(from));
	}

}
