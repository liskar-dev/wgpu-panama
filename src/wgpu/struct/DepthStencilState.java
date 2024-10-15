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

public class DepthStencilState extends WGPUStruct {
	public ChainedStruct nextInChain;
	public TextureFormat format;
	public boolean depthWriteEnabled;
	public CompareFunction depthCompare;
	// padding 4
	public StencilFaceState stencilFront;
	public StencilFaceState stencilBack;
	public int stencilReadMask;
	public int stencilWriteMask;
	public int depthBias;
	public float depthBiasSlopeScale;
	public float depthBiasClamp;
	// padding 4

	protected static final int byteSize = 80;
	protected int byteSize() {
		return byteSize;
	}

	protected long store(Stack stack, long address) {
		put_value(address+0, stack.alloc(nextInChain));
		put_value(address+8, format == null ? 0 : format.bits );
		put_value(address+12, (boolean) depthWriteEnabled);
		put_value(address+16, depthCompare == null ? 0 : depthCompare.bits );
		// padding 4
		stencilFront.store(stack, address+24);
		stencilBack.store(stack, address+40);
		put_value(address+56, (int) stencilReadMask);
		put_value(address+60, (int) stencilWriteMask);
		put_value(address+64, (int) depthBias);
		put_value(address+68, (float) depthBiasSlopeScale);
		put_value(address+72, (float) depthBiasClamp);
		// padding 4
		return address;
	}

	protected DepthStencilState load(long address) {
		nextInChain = ChainedStruct.from(get_long(address+0));
		format = TextureFormat.from(get_int(address+8));
		depthWriteEnabled = get_boolean(address+12);
		depthCompare = CompareFunction.from(get_int(address+16));
		// padding 4
		stencilFront = (stencilFront != null ? stencilFront : new StencilFaceState()).load(address+24);
		stencilBack = (stencilBack != null ? stencilBack : new StencilFaceState()).load(address+40);
		stencilReadMask = get_int(address+56);
		stencilWriteMask = get_int(address+60);
		depthBias = get_int(address+64);
		depthBiasSlopeScale = get_float(address+68);
		depthBiasClamp = get_float(address+72);
		// padding 4
		// padding 4
		// padding 4
		return this;
	}
	public DepthStencilState() {}
}
