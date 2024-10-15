package wgpu.struct;

import wgpu.*;
import wgpu.impl.*;
import wgpu.struct.*;
import wgpu.enums.*;
import wgpu.callback.*;
import static wgpu.StaticHelpers.*;

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

	protected static final int byteSize = 2608;
	protected int byteSize() {
		return byteSize;
	}

	protected long store(Stack stack, long address) {
		surfaces.store(stack, address+0);
		put_value(address+40, backendType == null ? 0 : backendType.bits );
		// padding 4
		vulkan.store(stack, address+48);
		metal.store(stack, address+688);
		dx12.store(stack, address+1328);
		gl.store(stack, address+1968);
		return address;
	}

	protected GlobalReport load(long address) {
		surfaces = (surfaces != null ? surfaces : new RegistryReport()).load(address+0);
		backendType = BackendType.from(get_int(address+40));
		// padding 4
		vulkan = (vulkan != null ? vulkan : new HubReport()).load(address+48);
		metal = (metal != null ? metal : new HubReport()).load(address+688);
		dx12 = (dx12 != null ? dx12 : new HubReport()).load(address+1328);
		gl = (gl != null ? gl : new HubReport()).load(address+1968);
		// padding 4
		return this;
	}
	public GlobalReport() {}
}
