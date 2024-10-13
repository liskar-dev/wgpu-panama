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

public class RegistryReport extends WGPUStruct {
	public long numAllocated;
	public long numKeptFromUser;
	public long numReleasedFromUser;
	public long numError;
	public long elementSize;

	protected int sizeInBytes() {
		return 40;
	}

	protected void writeTo(WGPUWriter out) {
		out.write(numAllocated);
		out.write(numKeptFromUser);
		out.write(numReleasedFromUser);
		out.write(numError);
		out.write(elementSize);
	}

	protected RegistryReport readFrom(WGPUReader in) {
		numAllocated = in.read_long();
		numKeptFromUser = in.read_long();
		numReleasedFromUser = in.read_long();
		numError = in.read_long();
		elementSize = in.read_long();
		return this;
	}

	public RegistryReport() {}

	public RegistryReport(MemorySegment from) {
		readFrom(new WGPUReader(from));
	}

}
