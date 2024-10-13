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

public class SurfaceConfiguration extends WGPUStruct {
	public ChainedStruct nextInChain;
	public WGPUDevice device;
	public TextureFormat format;
	/** @see TextureUsage */
	public int usage;
	// [viewFormatCount]
	public TextureFormat[] viewFormats;
	public CompositeAlphaMode alphaMode;
	public int width;
	public int height;
	public PresentMode presentMode;

	protected int sizeInBytes() {
		return 56;
	}

	protected void writeTo(WGPUWriter out) {
		out.pointer(nextInChain);
		out.pointer(device);
		out.write(format);
		out.write(usage);
		out.write((long) viewFormats.length);
		out.pointer(viewFormats);
		out.write(alphaMode);
		out.write(width);
		out.write(height);
		out.write(presentMode);
	}

	protected SurfaceConfiguration readFrom(WGPUReader in) {
		nextInChain = ChainedStruct.from(in.read_pointer());
		var _device = in.read_pointer();
		device = isNull(_device) ? null : new WGPUDevice(_device);
		format = TextureFormat.from(in.read_int());
		usage = in.read_int();
		var viewFormatCount = (int) in.read_long();
		var _viewFormats = in.read_pointer();
		alphaMode = CompositeAlphaMode.from(in.read_int());
		width = in.read_int();
		height = in.read_int();
		presentMode = PresentMode.from(in.read_int());
		if(!isNull(_viewFormats)) {
			viewFormats = new TextureFormat[viewFormatCount];
			var rin = new WGPUReader(_viewFormats);
			for(int i=0; i<viewFormats.length; i++) {
				viewFormats[i] = TextureFormat.from(rin.read_int());
			}
		}
		return this;
	}

	public SurfaceConfiguration() {}

	public SurfaceConfiguration(MemorySegment from) {
		readFrom(new WGPUReader(from));
	}

}
