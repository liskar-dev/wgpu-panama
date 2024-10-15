package wgpu;


public abstract class WGPUStruct {
	protected abstract int byteSize();

	protected long calloc(Stack stack) {
		return stack.calloc(byteSize());
	}
	
	protected long store(Stack stack, long address) {
		return address;
	}
	
	protected WGPUStruct load(long address) {
		return this;
	}

	
}
