package wgpu.struct;

import wgpu.*;
import wgpu.impl.*;
import wgpu.struct.*;
import wgpu.enums.*;
import wgpu.callback.*;
import static wgpu.StaticHelpers.*;

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

	protected static final int byteSize = 56;
	protected int byteSize() {
		return byteSize;
	}

	protected long store(Stack stack, long address) {
		put_value(address+0, stack.alloc(nextInChain));
		put_value(address+8, stack.alloc(label));
		put_value(address+16, addressModeU == null ? 0 : addressModeU.bits );
		put_value(address+20, addressModeV == null ? 0 : addressModeV.bits );
		put_value(address+24, addressModeW == null ? 0 : addressModeW.bits );
		put_value(address+28, magFilter == null ? 0 : magFilter.bits );
		put_value(address+32, minFilter == null ? 0 : minFilter.bits );
		put_value(address+36, mipmapFilter == null ? 0 : mipmapFilter.bits );
		put_value(address+40, (float) lodMinClamp);
		put_value(address+44, (float) lodMaxClamp);
		put_value(address+48, compare == null ? 0 : compare.bits );
		put_value(address+52, (short) maxAnisotropy);
		// padding 2
		return address;
	}

	protected SamplerDescriptor load(long address) {
		nextInChain = ChainedStruct.from(get_long(address+0));
		label = get_string(get_long(address+8));
		addressModeU = AddressMode.from(get_int(address+16));
		addressModeV = AddressMode.from(get_int(address+20));
		addressModeW = AddressMode.from(get_int(address+24));
		magFilter = FilterMode.from(get_int(address+28));
		minFilter = FilterMode.from(get_int(address+32));
		mipmapFilter = MipmapFilterMode.from(get_int(address+36));
		lodMinClamp = get_float(address+40);
		lodMaxClamp = get_float(address+44);
		compare = CompareFunction.from(get_int(address+48));
		maxAnisotropy = get_short(address+52);
		// padding 2
		// padding 2
		return this;
	}
	public SamplerDescriptor() {}
}
