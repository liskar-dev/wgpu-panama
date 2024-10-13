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

public class TextureDescriptor extends WGPUStruct {
	public ChainedStruct nextInChain;
	@Nullable
	public String label;
	/** @see TextureUsage */
	public int usage;
	public TextureDimension dimension;
	public Extent3D size;
	public TextureFormat format;
	public int mipLevelCount;
	public int sampleCount;
	// padding 4
	// [viewFormatCount]
	public TextureFormat[] viewFormats;

	protected int sizeInBytes() {
		return 72;
	}

	protected void writeTo(WGPUWriter out) {
		out.pointer(nextInChain);
		out.pointer(label);
		out.write(usage);
		out.write(dimension);
		out.write(size);
		out.write(format);
		out.write(mipLevelCount);
		out.write(sampleCount);
		out.padding(4);
		out.write((long) (viewFormats == null ? 0 : viewFormats.length));
		out.pointer(viewFormats);
	}

	protected TextureDescriptor readFrom(WGPUReader in) {
		nextInChain = ChainedStruct.from(in.read_pointer());
		label = in.read_string();
		usage = in.read_int();
		dimension = TextureDimension.from(in.read_int());
		size = new Extent3D().readFrom(in);
		format = TextureFormat.from(in.read_int());
		mipLevelCount = in.read_int();
		sampleCount = in.read_int();
		in.padding(4);
		var viewFormatCount = (int) in.read_long();
		var _viewFormats = in.read_pointer();
		if(!isNull(_viewFormats)) {
			viewFormats = new TextureFormat[viewFormatCount];
			var rin = new WGPUReader(_viewFormats);
			for(int i=0; i<viewFormats.length; i++) {
				viewFormats[i] = TextureFormat.from(rin.read_int());
			}
		}
		return this;
	}

	public TextureDescriptor() {}

	public TextureDescriptor(MemorySegment from) {
		readFrom(new WGPUReader(from));
	}

}
