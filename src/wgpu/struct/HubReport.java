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

	protected int sizeInBytes() {
		return 640;
	}

	protected void writeTo(WGPUWriter out) {
		out.write(adapters);
		out.write(devices);
		out.write(queues);
		out.write(pipelineLayouts);
		out.write(shaderModules);
		out.write(bindGroupLayouts);
		out.write(bindGroups);
		out.write(commandBuffers);
		out.write(renderBundles);
		out.write(renderPipelines);
		out.write(computePipelines);
		out.write(querySets);
		out.write(buffers);
		out.write(textures);
		out.write(textureViews);
		out.write(samplers);
	}

	protected HubReport readFrom(WGPUReader in) {
		adapters = new RegistryReport().readFrom(in);
		devices = new RegistryReport().readFrom(in);
		queues = new RegistryReport().readFrom(in);
		pipelineLayouts = new RegistryReport().readFrom(in);
		shaderModules = new RegistryReport().readFrom(in);
		bindGroupLayouts = new RegistryReport().readFrom(in);
		bindGroups = new RegistryReport().readFrom(in);
		commandBuffers = new RegistryReport().readFrom(in);
		renderBundles = new RegistryReport().readFrom(in);
		renderPipelines = new RegistryReport().readFrom(in);
		computePipelines = new RegistryReport().readFrom(in);
		querySets = new RegistryReport().readFrom(in);
		buffers = new RegistryReport().readFrom(in);
		textures = new RegistryReport().readFrom(in);
		textureViews = new RegistryReport().readFrom(in);
		samplers = new RegistryReport().readFrom(in);
		return this;
	}

	public HubReport() {}

	public HubReport(MemorySegment from) {
		readFrom(new WGPUReader(from));
	}

}
