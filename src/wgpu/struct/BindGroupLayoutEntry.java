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

public class BindGroupLayoutEntry extends WGPUStruct {
	public ChainedStruct nextInChain;
	public int binding;
	/** @see ShaderStage */
	public int visibility;
	public BufferBindingLayout buffer;
	public SamplerBindingLayout sampler;
	public TextureBindingLayout texture;
	public StorageTextureBindingLayout storageTexture;

	protected static final int byteSize = 104;
	protected int byteSize() {
		return byteSize;
	}

	protected long store(Stack stack, long address) {
		put_value(address+0, stack.alloc(nextInChain));
		put_value(address+8, (int) binding);
		put_value(address+12, (int) visibility);
		buffer.store(stack, address+16);
		sampler.store(stack, address+40);
		texture.store(stack, address+56);
		storageTexture.store(stack, address+80);
		return address;
	}

	protected BindGroupLayoutEntry load(long address) {
		nextInChain = ChainedStruct.from(get_long(address+0));
		binding = get_int(address+8);
		visibility = get_int(address+12);
		buffer = (buffer != null ? buffer : new BufferBindingLayout()).load(address+16);
		sampler = (sampler != null ? sampler : new SamplerBindingLayout()).load(address+40);
		texture = (texture != null ? texture : new TextureBindingLayout()).load(address+56);
		storageTexture = (storageTexture != null ? storageTexture : new StorageTextureBindingLayout()).load(address+80);
		return this;
	}
	public BindGroupLayoutEntry() {}
}
