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

public class RegistryReport extends CStruct {
	public long numAllocated;
	public long numKeptFromUser;
	public long numReleasedFromUser;
	public long numError;
	public long elementSize;

	protected static final int byteSize = 40;
	protected int byteSize() {
		return byteSize;
	}

	protected long store(Stack stack, long address) {
		put_value(address+0, (long) numAllocated);
		put_value(address+8, (long) numKeptFromUser);
		put_value(address+16, (long) numReleasedFromUser);
		put_value(address+24, (long) numError);
		put_value(address+32, (long) elementSize);
		return address;
	}

	protected RegistryReport load(long address) {
		numAllocated = get_long(address+0);
		numKeptFromUser = get_long(address+8);
		numReleasedFromUser = get_long(address+16);
		numError = get_long(address+24);
		elementSize = get_long(address+32);
		return this;
	}
	public RegistryReport() {}
}
