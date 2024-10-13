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

public class RenderPassDepthStencilAttachment extends WGPUStruct {
	public WGPUTextureView view;
	public LoadOp depthLoadOp;
	public StoreOp depthStoreOp;
	public float depthClearValue;
	public boolean depthReadOnly;
	public LoadOp stencilLoadOp;
	public StoreOp stencilStoreOp;
	public int stencilClearValue;
	public boolean stencilReadOnly;

	protected int sizeInBytes() {
		return 40;
	}

	protected void writeTo(WGPUWriter out) {
		out.pointer(view);
		out.write(depthLoadOp);
		out.write(depthStoreOp);
		out.write(depthClearValue);
		out.write(depthReadOnly);
		out.write(stencilLoadOp);
		out.write(stencilStoreOp);
		out.write(stencilClearValue);
		out.write(stencilReadOnly);
	}

	protected RenderPassDepthStencilAttachment readFrom(WGPUReader in) {
		var _view = in.read_pointer();
		view = isNull(_view) ? null : new WGPUTextureView(_view);
		depthLoadOp = LoadOp.from(in.read_int());
		depthStoreOp = StoreOp.from(in.read_int());
		depthClearValue = in.read_float();
		depthReadOnly = in.read_boolean();
		stencilLoadOp = LoadOp.from(in.read_int());
		stencilStoreOp = StoreOp.from(in.read_int());
		stencilClearValue = in.read_int();
		stencilReadOnly = in.read_boolean();
		return this;
	}

	public RenderPassDepthStencilAttachment() {}

	public RenderPassDepthStencilAttachment(MemorySegment from) {
		readFrom(new WGPUReader(from));
	}

}
