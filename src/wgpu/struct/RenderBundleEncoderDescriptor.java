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

public class RenderBundleEncoderDescriptor extends WGPUStruct {
	public ChainedStruct nextInChain;
	@Nullable
	public String label;
	// [colorFormatCount]
	public TextureFormat[] colorFormats;
	public TextureFormat depthStencilFormat;
	public int sampleCount;
	public boolean depthReadOnly;
	public boolean stencilReadOnly;

	protected int sizeInBytes() {
		return 48;
	}

	protected void writeTo(WGPUWriter out) {
		out.pointer(nextInChain);
		out.pointer(label);
		out.write((long) colorFormats.length);
		out.pointer(colorFormats);
		out.write(depthStencilFormat);
		out.write(sampleCount);
		out.write(depthReadOnly);
		out.write(stencilReadOnly);
	}

	protected RenderBundleEncoderDescriptor readFrom(WGPUReader in) {
		nextInChain = ChainedStruct.from(in.read_pointer());
		label = in.read_string();
		var colorFormatCount = (int) in.read_long();
		var _colorFormats = in.read_pointer();
		depthStencilFormat = TextureFormat.from(in.read_int());
		sampleCount = in.read_int();
		depthReadOnly = in.read_boolean();
		stencilReadOnly = in.read_boolean();
		if(!isNull(_colorFormats)) {
			colorFormats = new TextureFormat[colorFormatCount];
			var rin = new WGPUReader(_colorFormats);
			for(int i=0; i<colorFormats.length; i++) {
				colorFormats[i] = TextureFormat.from(rin.read_int());
			}
		}
		return this;
	}

	public RenderBundleEncoderDescriptor() {}

	public RenderBundleEncoderDescriptor(MemorySegment from) {
		readFrom(new WGPUReader(from));
	}

}
