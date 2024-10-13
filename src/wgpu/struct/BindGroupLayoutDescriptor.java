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

public class BindGroupLayoutDescriptor extends WGPUStruct {
	public ChainedStruct nextInChain;
	@Nullable
	public String label;
	// [entryCount]
	public BindGroupLayoutEntry[] entries;

	protected int sizeInBytes() {
		return 32;
	}

	protected void writeTo(WGPUWriter out) {
		out.pointer(nextInChain);
		out.pointer(label);
		out.write((long) entries.length);
		out.pointer(entries);
	}

	protected BindGroupLayoutDescriptor readFrom(WGPUReader in) {
		nextInChain = ChainedStruct.from(in.read_pointer());
		label = in.read_string();
		var entryCount = (int) in.read_long();
		var _entries = in.read_pointer();
		if(!isNull(_entries)) {
			entries = new BindGroupLayoutEntry[entryCount];
			var rin = new WGPUReader(_entries);
			for(int i=0; i<entries.length; i++) {
				entries[i] = new BindGroupLayoutEntry().readFrom(rin);
			}
		}
		return this;
	}

	public BindGroupLayoutDescriptor() {}

	public BindGroupLayoutDescriptor(MemorySegment from) {
		readFrom(new WGPUReader(from));
	}

}
