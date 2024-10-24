package wgpu;

public class GPUObject {
	public long handle;
	
	protected GPUObject(long handle) {
		this.handle = handle;
	}
	
	protected GPUObject() {
		
	}
	
	public void set(long handle) {
		this.handle = handle;
	}
}
