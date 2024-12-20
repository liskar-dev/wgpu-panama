package wgpu.impl;

import wgpu.*;
import wgpu.impl.*;
import wgpu.struct.*;
import wgpu.enums.*;
import wgpu.callback.*;

import java.lang.foreign.*;
import org.jspecify.annotations.*;

import static java.lang.foreign.ValueLayout.*;
import static java.lang.foreign.MemoryLayout.*;

import static wgpu.WGPU.*;

public class GPUTexture extends GPUObject {

	public GPUTexture(long handle) {
		super(handle);
	}

	public GPUTexture() {
		super();
	}

	public GPUTextureView createView(@Nullable final TextureViewDescriptor descriptor) {
		return new GPUTextureView(wgpuTextureCreateView(this.handle, descriptor));
	}

	public long createView0(@Nullable final TextureViewDescriptor descriptor) {
		return wgpuTextureCreateView(this.handle, descriptor);
	}

	public void destroy() {
		wgpuTextureDestroy(this.handle);
	}

	public int getDepthOrArrayLayers() {
		return wgpuTextureGetDepthOrArrayLayers(this.handle);
	}

	public TextureDimension getDimension() {
		return wgpuTextureGetDimension(this.handle);
	}

	public TextureFormat getFormat() {
		return wgpuTextureGetFormat(this.handle);
	}

	public int getHeight() {
		return wgpuTextureGetHeight(this.handle);
	}

	public int getMipLevelCount() {
		return wgpuTextureGetMipLevelCount(this.handle);
	}

	public int getSampleCount() {
		return wgpuTextureGetSampleCount(this.handle);
	}

	public int getUsage() {
		return wgpuTextureGetUsage(this.handle);
	}

	public int getWidth() {
		return wgpuTextureGetWidth(this.handle);
	}

	public void setLabel(final String label) {
		wgpuTextureSetLabel(this.handle, label);
	}

	public void release() {
		wgpuTextureRelease(this.handle);
		this.handle = 0;
	}
}
