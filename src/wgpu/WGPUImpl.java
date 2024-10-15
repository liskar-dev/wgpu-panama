package wgpu;

public class WGPUImpl {
	public long handle;
	protected WGPUImpl(long handle) {
		this.handle = handle;
	}
	
	public void set(long handle) {
		this.handle = handle;
	}
}
