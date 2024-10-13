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

public class SurfaceTexture extends WGPUStruct {
	public WGPUTexture texture;
	public boolean suboptimal;
	public SurfaceGetCurrentTextureStatus status;

	protected int sizeInBytes() {
		return 16;
	}

	protected void writeTo(WGPUWriter out) {
		out.pointer(texture);
		out.write(suboptimal);
		out.write(status);
	}

	protected SurfaceTexture readFrom(WGPUReader in) {
		var _texture = in.read_pointer();
		texture = isNull(_texture) ? null : new WGPUTexture(_texture);
		suboptimal = in.read_boolean();
		status = SurfaceGetCurrentTextureStatus.from(in.read_int());
		return this;
	}

	public SurfaceTexture() {}

	public SurfaceTexture(MemorySegment from) {
		readFrom(new WGPUReader(from));
	}

}
