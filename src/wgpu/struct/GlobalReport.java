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

public class GlobalReport extends WGPUStruct {
	public RegistryReport surfaces;
	public BackendType backendType;
	// padding 4
	public HubReport vulkan;
	public HubReport metal;
	public HubReport dx12;
	public HubReport gl;

	protected int sizeInBytes() {
		return 2608;
	}

	protected void writeTo(WGPUWriter out) {
		out.write(surfaces);
		out.write(backendType);
		out.padding(4);
		out.write(vulkan);
		out.write(metal);
		out.write(dx12);
		out.write(gl);
	}

	protected GlobalReport readFrom(WGPUReader in) {
		surfaces = new RegistryReport().readFrom(in);
		backendType = BackendType.from(in.read_int());
		in.padding(4);
		vulkan = new HubReport().readFrom(in);
		metal = new HubReport().readFrom(in);
		dx12 = new HubReport().readFrom(in);
		gl = new HubReport().readFrom(in);
		return this;
	}

	public GlobalReport() {}

	public GlobalReport(MemorySegment from) {
		readFrom(new WGPUReader(from));
	}

}
