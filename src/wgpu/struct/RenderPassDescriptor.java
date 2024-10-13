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

public class RenderPassDescriptor extends WGPUStruct {
	public ChainedStruct nextInChain;
	@Nullable
	public String label;
	// [colorAttachmentCount]
	public RenderPassColorAttachment[] colorAttachments;
	@Nullable
	public RenderPassDepthStencilAttachment depthStencilAttachment;
	@Nullable
	public WGPUQuerySet occlusionQuerySet;
	@Nullable
	public RenderPassTimestampWrites timestampWrites;

	protected int sizeInBytes() {
		return 56;
	}

	protected void writeTo(WGPUWriter out) {
		out.pointer(nextInChain);
		out.pointer(label);
		out.write((long) (colorAttachments == null ? 0 : colorAttachments.length));
		out.pointer(colorAttachments);
		out.pointer(depthStencilAttachment);
		out.pointer(occlusionQuerySet);
		out.pointer(timestampWrites);
	}

	protected RenderPassDescriptor readFrom(WGPUReader in) {
		nextInChain = ChainedStruct.from(in.read_pointer());
		label = in.read_string();
		var colorAttachmentCount = (int) in.read_long();
		var _colorAttachments = in.read_pointer();
		var _depthStencilAttachment = in.read_pointer();
		depthStencilAttachment = isNull(_depthStencilAttachment) ? null : new RenderPassDepthStencilAttachment().readFrom(new WGPUReader(_depthStencilAttachment));
		var _occlusionQuerySet = in.read_pointer();
		occlusionQuerySet = isNull(_occlusionQuerySet) ? null : new WGPUQuerySet(_occlusionQuerySet);
		var _timestampWrites = in.read_pointer();
		timestampWrites = isNull(_timestampWrites) ? null : new RenderPassTimestampWrites().readFrom(new WGPUReader(_timestampWrites));
		if(!isNull(_colorAttachments)) {
			colorAttachments = new RenderPassColorAttachment[colorAttachmentCount];
			var rin = new WGPUReader(_colorAttachments);
			for(int i=0; i<colorAttachments.length; i++) {
				colorAttachments[i] = new RenderPassColorAttachment().readFrom(rin);
			}
		}
		return this;
	}

	public RenderPassDescriptor() {}

	public RenderPassDescriptor(MemorySegment from) {
		readFrom(new WGPUReader(from));
	}

}
