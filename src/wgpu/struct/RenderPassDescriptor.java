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

public class RenderPassDescriptor extends WGPUStruct {
	public ChainedStruct nextInChain;
	@Nullable
	public String label;
	// size_t colorAttachmentCount
	public RenderPassColorAttachment[] colorAttachments;
	@Nullable
	public RenderPassDepthStencilAttachment depthStencilAttachment;
	@Nullable
	public WGPUQuerySet occlusionQuerySet;
	@Nullable
	public RenderPassTimestampWrites timestampWrites;

	protected static final int byteSize = 56;
	protected int byteSize() {
		return byteSize;
	}

	protected long store(Stack stack, long address) {
		put_value(address+0, stack.alloc(nextInChain));
		put_value(address+8, stack.alloc(label));
		put_value(address+16, (long) (colorAttachments == null ? 0 : colorAttachments.length));
		put_value(address+24, stack.alloc(colorAttachments));
		put_value(address+32, stack.alloc(depthStencilAttachment));
		put_value(address+40, occlusionQuerySet == null ? 0L : occlusionQuerySet.handle );
		put_value(address+48, stack.alloc(timestampWrites));
		return address;
	}

	protected RenderPassDescriptor load(long address) {
		nextInChain = ChainedStruct.from(get_long(address+0));
		label = get_string(get_long(address+8));
		var colorAttachmentCount = (int) get_long(address+16);
		var _colorAttachments = get_long(address+24);
		var _depthStencilAttachment = get_long(address+32);
		depthStencilAttachment = _depthStencilAttachment == 0 ? null : (depthStencilAttachment != null ? depthStencilAttachment : new RenderPassDepthStencilAttachment()).load(_depthStencilAttachment);
		if(occlusionQuerySet != null) {
			occlusionQuerySet.handle = get_long(address+40);
		} else {
			occlusionQuerySet = new WGPUQuerySet(get_long(address+40));
		}
		var _timestampWrites = get_long(address+48);
		timestampWrites = _timestampWrites == 0 ? null : (timestampWrites != null ? timestampWrites : new RenderPassTimestampWrites()).load(_timestampWrites);
		if(_colorAttachments != 0L) {
			colorAttachments = colorAttachments != null && colorAttachments.length == colorAttachmentCount ? colorAttachments : new RenderPassColorAttachment[colorAttachmentCount];
			for(int i=0; i<colorAttachments.length; i++) {
				colorAttachments[i] = new RenderPassColorAttachment().load(_colorAttachments + i*RenderPassColorAttachment.byteSize);
			}
		} else {
			colorAttachments= null;
		}
		depthStencilAttachment = _depthStencilAttachment == 0 ? null : (depthStencilAttachment != null ? depthStencilAttachment : new RenderPassDepthStencilAttachment()).load(_depthStencilAttachment);
		timestampWrites = _timestampWrites == 0 ? null : (timestampWrites != null ? timestampWrites : new RenderPassTimestampWrites()).load(_timestampWrites);
		return this;
	}
	public RenderPassDescriptor() {}
}
