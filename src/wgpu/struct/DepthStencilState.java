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

	protected int sizeInBytes() {
		return 80;
	}

	protected void writeTo(WGPUWriter out) {
		out.pointer(nextInChain);
		out.write(format);
		out.write(depthWriteEnabled);
		out.write(depthCompare);
		out.padding(4);
		out.write(stencilFront);
		out.write(stencilBack);
		out.write(stencilReadMask);
		out.write(stencilWriteMask);
		out.write(depthBias);
		out.write(depthBiasSlopeScale);
		out.write(depthBiasClamp);
		out.padding(4);
	}

	protected DepthStencilState readFrom(WGPUReader in) {
		nextInChain = ChainedStruct.from(in.read_pointer());
		format = TextureFormat.from(in.read_int());
		depthWriteEnabled = in.read_boolean();
		depthCompare = CompareFunction.from(in.read_int());
		in.padding(4);
		stencilFront = new StencilFaceState().readFrom(in);
		stencilBack = new StencilFaceState().readFrom(in);
		stencilReadMask = in.read_int();
		stencilWriteMask = in.read_int();
		depthBias = in.read_int();
		depthBiasSlopeScale = in.read_float();
		depthBiasClamp = in.read_float();
		in.padding(4);
		return this;
	}

	public DepthStencilState() {}

	public DepthStencilState(MemorySegment from) {
		readFrom(new WGPUReader(from));
	}

}
