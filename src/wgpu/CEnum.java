package wgpu;

public abstract class CEnum {
	public final int bits;
	public final String name;
	protected CEnum(int bits, String name) {
		this.bits = bits;
		this.name = name;
	}
	
	@Override
	public String toString() {
//		return String.format("0x%08x %s", bits, name);
		return name;
	}
	
	public String debugString() {
		return String.format("0x%08x %s", bits, name);
	}
}
