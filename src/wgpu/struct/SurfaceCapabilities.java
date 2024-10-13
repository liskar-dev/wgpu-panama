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

public class SurfaceCapabilities extends WGPUStruct {
	public ChainedStructOut nextInChain;
	/** @see TextureUsage */
	public int usages;
	// padding 4
	// [formatCount]
	public TextureFormat[] formats;
	// [presentModeCount]
	public PresentMode[] presentModes;
	// [alphaModeCount]
	public CompositeAlphaMode[] alphaModes;

	protected int sizeInBytes() {
		return 64;
	}

	protected void writeTo(WGPUWriter out) {
		out.pointer(nextInChain);
		out.write(usages);
		out.padding(4);
		out.write((long) (formats == null ? 0 : formats.length));
		out.pointer(formats);
		out.write((long) (presentModes == null ? 0 : presentModes.length));
		out.pointer(presentModes);
		out.write((long) (alphaModes == null ? 0 : alphaModes.length));
		out.pointer(alphaModes);
	}

	protected SurfaceCapabilities readFrom(WGPUReader in) {
		nextInChain = ChainedStructOut.from(in.read_pointer());
		usages = in.read_int();
		in.padding(4);
		var formatCount = (int) in.read_long();
		var _formats = in.read_pointer();
		var presentModeCount = (int) in.read_long();
		var _presentModes = in.read_pointer();
		var alphaModeCount = (int) in.read_long();
		var _alphaModes = in.read_pointer();
		if(!isNull(_formats)) {
			formats = new TextureFormat[formatCount];
			var rin = new WGPUReader(_formats);
			for(int i=0; i<formats.length; i++) {
				formats[i] = TextureFormat.from(rin.read_int());
			}
		}
		if(!isNull(_presentModes)) {
			presentModes = new PresentMode[presentModeCount];
			var rin = new WGPUReader(_presentModes);
			for(int i=0; i<presentModes.length; i++) {
				presentModes[i] = PresentMode.from(rin.read_int());
			}
		}
		if(!isNull(_alphaModes)) {
			alphaModes = new CompositeAlphaMode[alphaModeCount];
			var rin = new WGPUReader(_alphaModes);
			for(int i=0; i<alphaModes.length; i++) {
				alphaModes[i] = CompositeAlphaMode.from(rin.read_int());
			}
		}
		return this;
	}

	public SurfaceCapabilities() {}

	public SurfaceCapabilities(MemorySegment from) {
		readFrom(new WGPUReader(from));
	}

}
