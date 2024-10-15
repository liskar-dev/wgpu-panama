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
	public RegistryReport adapters;
	public RegistryReport devices;
	public RegistryReport queues;
	public RegistryReport pipelineLayouts;
	public RegistryReport shaderModules;
	public RegistryReport bindGroupLayouts;
	public RegistryReport bindGroups;
	public RegistryReport commandBuffers;
	public RegistryReport renderBundles;
	public RegistryReport renderPipelines;
	public RegistryReport computePipelines;
	public RegistryReport querySets;
	public RegistryReport buffers;
	public RegistryReport textures;
	public RegistryReport textureViews;
	public RegistryReport samplers;

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
		adapters = (adapters != null ? adapters : new RegistryReport()).load(address+0);
		devices = (devices != null ? devices : new RegistryReport()).load(address+40);
		queues = (queues != null ? queues : new RegistryReport()).load(address+80);
		pipelineLayouts = (pipelineLayouts != null ? pipelineLayouts : new RegistryReport()).load(address+120);
		shaderModules = (shaderModules != null ? shaderModules : new RegistryReport()).load(address+160);
		bindGroupLayouts = (bindGroupLayouts != null ? bindGroupLayouts : new RegistryReport()).load(address+200);
		bindGroups = (bindGroups != null ? bindGroups : new RegistryReport()).load(address+240);
		commandBuffers = (commandBuffers != null ? commandBuffers : new RegistryReport()).load(address+280);
		renderBundles = (renderBundles != null ? renderBundles : new RegistryReport()).load(address+320);
		renderPipelines = (renderPipelines != null ? renderPipelines : new RegistryReport()).load(address+360);
		computePipelines = (computePipelines != null ? computePipelines : new RegistryReport()).load(address+400);
		querySets = (querySets != null ? querySets : new RegistryReport()).load(address+440);
		buffers = (buffers != null ? buffers : new RegistryReport()).load(address+480);
		textures = (textures != null ? textures : new RegistryReport()).load(address+520);
		textureViews = (textureViews != null ? textureViews : new RegistryReport()).load(address+560);
		samplers = (samplers != null ? samplers : new RegistryReport()).load(address+600);
		return this;
	}
	public HubReport() {}
}
