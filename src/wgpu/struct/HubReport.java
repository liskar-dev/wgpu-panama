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

public class HubReport extends WGPUStruct {
	public RegistryReport adapters = new RegistryReport();
	public RegistryReport devices = new RegistryReport();
	public RegistryReport queues = new RegistryReport();
	public RegistryReport pipelineLayouts = new RegistryReport();
	public RegistryReport shaderModules = new RegistryReport();
	public RegistryReport bindGroupLayouts = new RegistryReport();
	public RegistryReport bindGroups = new RegistryReport();
	public RegistryReport commandBuffers = new RegistryReport();
	public RegistryReport renderBundles = new RegistryReport();
	public RegistryReport renderPipelines = new RegistryReport();
	public RegistryReport computePipelines = new RegistryReport();
	public RegistryReport querySets = new RegistryReport();
	public RegistryReport buffers = new RegistryReport();
	public RegistryReport textures = new RegistryReport();
	public RegistryReport textureViews = new RegistryReport();
	public RegistryReport samplers = new RegistryReport();

	protected static final int byteSize = 640;
	protected int byteSize() {
		return byteSize;
	}

	protected long store(Stack stack, long address) {
		adapters.store(stack, address+0);
		devices.store(stack, address+40);
		queues.store(stack, address+80);
		pipelineLayouts.store(stack, address+120);
		shaderModules.store(stack, address+160);
		bindGroupLayouts.store(stack, address+200);
		bindGroups.store(stack, address+240);
		commandBuffers.store(stack, address+280);
		renderBundles.store(stack, address+320);
		renderPipelines.store(stack, address+360);
		computePipelines.store(stack, address+400);
		querySets.store(stack, address+440);
		buffers.store(stack, address+480);
		textures.store(stack, address+520);
		textureViews.store(stack, address+560);
		samplers.store(stack, address+600);
		return address;
	}

	protected HubReport load(long address) {
		adapters = adapters.load(address+0);
		devices = devices.load(address+40);
		queues = queues.load(address+80);
		pipelineLayouts = pipelineLayouts.load(address+120);
		shaderModules = shaderModules.load(address+160);
		bindGroupLayouts = bindGroupLayouts.load(address+200);
		bindGroups = bindGroups.load(address+240);
		commandBuffers = commandBuffers.load(address+280);
		renderBundles = renderBundles.load(address+320);
		renderPipelines = renderPipelines.load(address+360);
		computePipelines = computePipelines.load(address+400);
		querySets = querySets.load(address+440);
		buffers = buffers.load(address+480);
		textures = textures.load(address+520);
		textureViews = textureViews.load(address+560);
		samplers = samplers.load(address+600);
		return this;
	}
	public HubReport() {}
}
