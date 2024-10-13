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

	protected int sizeInBytes() {
		return 144;
	}

	protected void writeTo(WGPUWriter out) {
		out.pointer(nextInChain);
		out.pointer(label);
		out.pointer(layout);
		out.write(vertex);
		out.write(primitive);
		out.pointer(depthStencil);
		out.write(multisample);
		out.pointer(fragment);
	}

	protected RenderPipelineDescriptor readFrom(WGPUReader in) {
		nextInChain = ChainedStruct.from(in.read_pointer());
		label = in.read_string();
		var _layout = in.read_pointer();
		layout = isNull(_layout) ? null : new WGPUPipelineLayout(_layout);
		vertex = new VertexState().readFrom(in);
		primitive = new PrimitiveState().readFrom(in);
		var _depthStencil = in.read_pointer();
		depthStencil = isNull(_depthStencil) ? null : new DepthStencilState().readFrom(new WGPUReader(_depthStencil));
		multisample = new MultisampleState().readFrom(in);
		var _fragment = in.read_pointer();
		fragment = isNull(_fragment) ? null : new FragmentState().readFrom(new WGPUReader(_fragment));
		return this;
	}

	public RenderPipelineDescriptor() {}

	public RenderPipelineDescriptor(MemorySegment from) {
		readFrom(new WGPUReader(from));
	}

}
