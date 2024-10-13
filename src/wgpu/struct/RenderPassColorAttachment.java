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

public class RenderPassColorAttachment extends WGPUStruct {
	public ChainedStruct nextInChain;
	@Nullable
	public WGPUTextureView view;
	public int depthSlice;
	// padding 4
	@Nullable
	public WGPUTextureView resolveTarget;
	public LoadOp loadOp;
	public StoreOp storeOp;
	public Color clearValue;

	protected int sizeInBytes() {
		return 72;
	}

	protected void writeTo(WGPUWriter out) {
		out.pointer(nextInChain);
		out.pointer(view);
		out.write(depthSlice);
		out.padding(4);
		out.pointer(resolveTarget);
		out.write(loadOp);
		out.write(storeOp);
		out.write(clearValue);
	}

	protected RenderPassColorAttachment readFrom(WGPUReader in) {
		nextInChain = ChainedStruct.from(in.read_pointer());
		var _view = in.read_pointer();
		view = isNull(_view) ? null : new WGPUTextureView(_view);
		depthSlice = in.read_int();
		in.padding(4);
		var _resolveTarget = in.read_pointer();
		resolveTarget = isNull(_resolveTarget) ? null : new WGPUTextureView(_resolveTarget);
		loadOp = LoadOp.from(in.read_int());
		storeOp = StoreOp.from(in.read_int());
		clearValue = new Color().readFrom(in);
		return this;
	}

	public RenderPassColorAttachment() {}

	public RenderPassColorAttachment(MemorySegment from) {
		readFrom(new WGPUReader(from));
	}

}
