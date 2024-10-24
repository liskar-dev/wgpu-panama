package wgpu.struct;

import wgpu.*;
import wgpu.impl.*;
import wgpu.struct.*;
import wgpu.enums.*;
import wgpu.callback.*;

import java.lang.foreign.*;
import org.jspecify.annotations.*;

import static java.lang.foreign.ValueLayout.*;
import static java.lang.foreign.MemoryLayout.*;

public class DepthStencilState extends CStruct {
	public ChainedStruct nextInChain;
	public TextureFormat format;
	public boolean depthWriteEnabled;
	public CompareFunction depthCompare;
	public StencilFaceState stencilFront = new StencilFaceState();
	public StencilFaceState stencilBack = new StencilFaceState();
	public int stencilReadMask;
	public int stencilWriteMask;
	public int depthBias;
	public float depthBiasSlopeScale;
	public float depthBiasClamp;

	protected static final int byteSize = 72;
	protected int byteSize() {
		return byteSize;
	}

	protected long store(Stack stack, long address) {
		put_value(address+0, stack.alloc(nextInChain));
		put_value(address+8, format == null ? 0 : format.bits );
		put_value(address+12, (boolean) depthWriteEnabled);
		put_value(address+16, depthCompare == null ? 0 : depthCompare.bits );
		stencilFront.store(stack, address+20);
		stencilBack.store(stack, address+36);
		put_value(address+52, (int) stencilReadMask);
		put_value(address+56, (int) stencilWriteMask);
		put_value(address+60, (int) depthBias);
		put_value(address+64, (float) depthBiasSlopeScale);
		put_value(address+68, (float) depthBiasClamp);
		return address;
	}

	protected DepthStencilState load(long address) {
		nextInChain = ChainedStruct.from(get_long(address+0));
		format = TextureFormat.from(get_int(address+8));
		depthWriteEnabled = get_boolean(address+12);
		depthCompare = CompareFunction.from(get_int(address+16));
		stencilFront = stencilFront.load(address+20);
		stencilBack = stencilBack.load(address+36);
		stencilReadMask = get_int(address+52);
		stencilWriteMask = get_int(address+56);
		depthBias = get_int(address+60);
		depthBiasSlopeScale = get_float(address+64);
		depthBiasClamp = get_float(address+68);
		return this;
	}
	public DepthStencilState() {}
}
