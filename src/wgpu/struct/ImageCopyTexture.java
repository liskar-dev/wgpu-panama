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

public class ImageCopyTexture extends WGPUStruct {
	public ChainedStruct nextInChain;
	public WGPUTexture texture;
	public int mipLevel;
	// padding 4
	public Origin3D origin;
	public TextureAspect aspect;
	// padding 4

	protected int sizeInBytes() {
		return 48;
	}

	protected void writeTo(WGPUWriter out) {
		out.pointer(nextInChain);
		out.pointer(texture);
		out.write(mipLevel);
		out.padding(4);
		out.write(origin);
		out.write(aspect);
		out.padding(4);
	}

	protected ImageCopyTexture readFrom(WGPUReader in) {
		nextInChain = ChainedStruct.from(in.read_pointer());
		var _texture = in.read_pointer();
		texture = isNull(_texture) ? null : new WGPUTexture(_texture);
		mipLevel = in.read_int();
		in.padding(4);
		origin = new Origin3D().readFrom(in);
		aspect = TextureAspect.from(in.read_int());
		in.padding(4);
		return this;
	}

	public ImageCopyTexture() {}

	public ImageCopyTexture(MemorySegment from) {
		readFrom(new WGPUReader(from));
	}

}
