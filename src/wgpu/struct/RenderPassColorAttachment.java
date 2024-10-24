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

public class RenderPassColorAttachment extends WGPUStruct {
	public ChainedStruct nextInChain;
	public WGPUTextureView view = new WGPUTextureView(0);
	public int depthSlice;
	// padding 4
	public WGPUTextureView resolveTarget = new WGPUTextureView(0);
	public LoadOp loadOp;
	public StoreOp storeOp;
	public Color clearValue = new Color();

	protected static final int byteSize = 72;
	protected int byteSize() {
		return byteSize;
	}

	protected long store(Stack stack, long address) {
		put_value(address+0, stack.alloc(nextInChain));
		put_value(address+8, view.handle );
		put_value(address+16, (int) depthSlice);
		// padding 4
		put_value(address+24, resolveTarget.handle );
		put_value(address+32, loadOp == null ? 0 : loadOp.bits );
		put_value(address+36, storeOp == null ? 0 : storeOp.bits );
		clearValue.store(stack, address+40);
		return address;
	}

	protected RenderPassColorAttachment load(long address) {
		nextInChain = ChainedStruct.from(get_long(address+0));
		view.handle = get_long(address+8);
		depthSlice = get_int(address+16);
		// padding 4
		resolveTarget.handle = get_long(address+24);
		loadOp = LoadOp.from(get_int(address+32));
		storeOp = StoreOp.from(get_int(address+36));
		clearValue = clearValue.load(address+40);
		// padding 4
		return this;
	}
	public RenderPassColorAttachment() {}
}
