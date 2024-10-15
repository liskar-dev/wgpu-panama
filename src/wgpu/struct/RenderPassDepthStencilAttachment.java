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

	protected static final int byteSize = 40;
	protected int byteSize() {
		return byteSize;
	}

	protected long store(Stack stack, long address) {
		put_value(address+0, view == null ? 0L : view.handle );
		put_value(address+8, depthLoadOp == null ? 0 : depthLoadOp.bits );
		put_value(address+12, depthStoreOp == null ? 0 : depthStoreOp.bits );
		put_value(address+16, (float) depthClearValue);
		put_value(address+20, (boolean) depthReadOnly);
		put_value(address+24, stencilLoadOp == null ? 0 : stencilLoadOp.bits );
		put_value(address+28, stencilStoreOp == null ? 0 : stencilStoreOp.bits );
		put_value(address+32, (int) stencilClearValue);
		put_value(address+36, (boolean) stencilReadOnly);
		return address;
	}

	protected RenderPassDepthStencilAttachment load(long address) {
		if(view != null) {
			view.handle = get_long(address+0);
		} else {
			view = new WGPUTextureView(get_long(address+0));
		}
		depthLoadOp = LoadOp.from(get_int(address+8));
		depthStoreOp = StoreOp.from(get_int(address+12));
		depthClearValue = get_float(address+16);
		depthReadOnly = get_boolean(address+20);
		stencilLoadOp = LoadOp.from(get_int(address+24));
		stencilStoreOp = StoreOp.from(get_int(address+28));
		stencilClearValue = get_int(address+32);
		stencilReadOnly = get_boolean(address+36);
		return this;
	}
	public RenderPassDepthStencilAttachment() {}
}
