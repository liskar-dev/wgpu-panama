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

public class AdapterInfo extends WGPUStruct {
	public ChainedStructOut nextInChain;
	public String vendor;
	public String architecture;
	public String device;
	public String description;
	public BackendType backendType;
	public AdapterType adapterType;
	public int vendorID;
	public int deviceID;

	protected int sizeInBytes() {
		return 56;
	}

	protected void writeTo(WGPUWriter out) {
		out.pointer(nextInChain);
		out.pointer(vendor);
		out.pointer(architecture);
		out.pointer(device);
		out.pointer(description);
		out.write(backendType);
		out.write(adapterType);
		out.write(vendorID);
		out.write(deviceID);
	}

	protected AdapterInfo readFrom(WGPUReader in) {
		nextInChain = ChainedStructOut.from(in.read_pointer());
		vendor = in.read_string();
		architecture = in.read_string();
		device = in.read_string();
		description = in.read_string();
		backendType = BackendType.from(in.read_int());
		adapterType = AdapterType.from(in.read_int());
		vendorID = in.read_int();
		deviceID = in.read_int();
		return this;
	}

	public AdapterInfo() {}

	public AdapterInfo(MemorySegment from) {
		readFrom(new WGPUReader(from));
	}

}
