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

public class BindGroupLayoutEntry extends WGPUStruct {
	public ChainedStruct nextInChain;
	public int binding;
	/** @see ShaderStage */
	public int visibility;
	public BufferBindingLayout buffer;
	public SamplerBindingLayout sampler;
	public TextureBindingLayout texture;
	public StorageTextureBindingLayout storageTexture;

	protected int sizeInBytes() {
		return 104;
	}

	protected void writeTo(WGPUWriter out) {
		out.pointer(nextInChain);
		out.write(binding);
		out.write(visibility);
		out.write(buffer);
		out.write(sampler);
		out.write(texture);
		out.write(storageTexture);
	}

	protected BindGroupLayoutEntry readFrom(WGPUReader in) {
		nextInChain = ChainedStruct.from(in.read_pointer());
		binding = in.read_int();
		visibility = in.read_int();
		buffer = new BufferBindingLayout().readFrom(in);
		sampler = new SamplerBindingLayout().readFrom(in);
		texture = new TextureBindingLayout().readFrom(in);
		storageTexture = new StorageTextureBindingLayout().readFrom(in);
		return this;
	}

	public BindGroupLayoutEntry() {}

	public BindGroupLayoutEntry(MemorySegment from) {
		readFrom(new WGPUReader(from));
	}

}
