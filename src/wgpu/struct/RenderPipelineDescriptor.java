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

public class RenderPipelineDescriptor extends WGPUStruct {
	public ChainedStruct nextInChain;
	@Nullable
	public String label;
	@Nullable
	public WGPUPipelineLayout layout;
	public VertexState vertex;
	public PrimitiveState primitive;
	@Nullable
	public DepthStencilState depthStencil;
	public MultisampleState multisample;
	@Nullable
	public FragmentState fragment;

	protected static final int byteSize = 144;
	protected int byteSize() {
		return byteSize;
	}

	protected long store(Stack stack, long address) {
		put_value(address+0, stack.alloc(nextInChain));
		put_value(address+8, stack.alloc(label));
		put_value(address+16, layout == null ? 0L : layout.handle );
		vertex.store(stack, address+24);
		primitive.store(stack, address+80);
		put_value(address+104, stack.alloc(depthStencil));
		multisample.store(stack, address+112);
		put_value(address+136, stack.alloc(fragment));
		return address;
	}

	protected RenderPipelineDescriptor load(long address) {
		nextInChain = ChainedStruct.from(get_long(address+0));
		label = get_string(get_long(address+8));
		if(layout != null) {
			layout.handle = get_long(address+16);
		} else {
			layout = new WGPUPipelineLayout(get_long(address+16));
		}
		vertex = (vertex != null ? vertex : new VertexState()).load(address+24);
		primitive = (primitive != null ? primitive : new PrimitiveState()).load(address+80);
		var _depthStencil = get_long(address+104);
		depthStencil = _depthStencil == 0 ? null : (depthStencil != null ? depthStencil : new DepthStencilState()).load(_depthStencil);
		multisample = (multisample != null ? multisample : new MultisampleState()).load(address+112);
		var _fragment = get_long(address+136);
		fragment = _fragment == 0 ? null : (fragment != null ? fragment : new FragmentState()).load(_fragment);
		depthStencil = _depthStencil == 0 ? null : (depthStencil != null ? depthStencil : new DepthStencilState()).load(_depthStencil);
		fragment = _fragment == 0 ? null : (fragment != null ? fragment : new FragmentState()).load(_fragment);
		return this;
	}
	public RenderPipelineDescriptor() {}
}
