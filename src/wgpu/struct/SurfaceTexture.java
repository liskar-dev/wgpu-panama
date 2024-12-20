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

public class SurfaceTexture extends CStruct {
	public GPUTexture texture = new GPUTexture(0);
	public boolean suboptimal;
	public SurfaceGetCurrentTextureStatus status;

	protected static final int byteSize = 16;
	protected int byteSize() {
		return byteSize;
	}

	protected long store(Stack stack, long address) {
		put_value(address+0, texture.handle );
		put_value(address+8, (boolean) suboptimal);
		put_value(address+12, status == null ? 0 : status.bits );
		return address;
	}

	protected SurfaceTexture load(long address) {
		texture.handle = get_long(address+0);
		suboptimal = get_boolean(address+8);
		status = SurfaceGetCurrentTextureStatus.from(get_int(address+12));
		return this;
	}
	public SurfaceTexture() {}
}
