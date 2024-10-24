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

public class AdapterInfo extends CStruct {
	public ChainedStructOut nextInChain;
	public String vendor;
	public String architecture;
	public String device;
	public String description;
	public BackendType backendType;
	public AdapterType adapterType;
	public int vendorID;
	public int deviceID;

	protected static final int byteSize = 56;
	protected int byteSize() {
		return byteSize;
	}

	protected long store(Stack stack, long address) {
		put_value(address+0, stack.alloc(nextInChain));
		put_value(address+8, stack.alloc(vendor));
		put_value(address+16, stack.alloc(architecture));
		put_value(address+24, stack.alloc(device));
		put_value(address+32, stack.alloc(description));
		put_value(address+40, backendType == null ? 0 : backendType.bits );
		put_value(address+44, adapterType == null ? 0 : adapterType.bits );
		put_value(address+48, (int) vendorID);
		put_value(address+52, (int) deviceID);
		return address;
	}

	protected AdapterInfo load(long address) {
		nextInChain = ChainedStructOut.from(get_long(address+0));
		vendor = get_string(get_long(address+8));
		architecture = get_string(get_long(address+16));
		device = get_string(get_long(address+24));
		description = get_string(get_long(address+32));
		backendType = BackendType.from(get_int(address+40));
		adapterType = AdapterType.from(get_int(address+44));
		vendorID = get_int(address+48);
		deviceID = get_int(address+52);
		return this;
	}
	public AdapterInfo() {}
}
