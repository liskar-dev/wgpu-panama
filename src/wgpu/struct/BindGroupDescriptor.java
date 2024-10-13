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

public class BindGroupDescriptor extends WGPUStruct {
	public ChainedStruct nextInChain;
	@Nullable
	public String label;
	public WGPUBindGroupLayout layout;
	// [entryCount]
	public BindGroupEntry[] entries;

	protected int sizeInBytes() {
		return 40;
	}

	protected void writeTo(WGPUWriter out) {
		out.pointer(nextInChain);
		out.pointer(label);
		out.pointer(layout);
		out.write((long) (entries == null ? 0 : entries.length));
		out.pointer(entries);
	}

	protected BindGroupDescriptor readFrom(WGPUReader in) {
		nextInChain = ChainedStruct.from(in.read_pointer());
		label = in.read_string();
		var _layout = in.read_pointer();
		layout = isNull(_layout) ? null : new WGPUBindGroupLayout(_layout);
		var entryCount = (int) in.read_long();
		var _entries = in.read_pointer();
		if(!isNull(_entries)) {
			entries = new BindGroupEntry[entryCount];
			var rin = new WGPUReader(_entries);
			for(int i=0; i<entries.length; i++) {
				entries[i] = new BindGroupEntry().readFrom(rin);
			}
		}
		return this;
	}

	public BindGroupDescriptor() {}

	public BindGroupDescriptor(MemorySegment from) {
		readFrom(new WGPUReader(from));
	}

}
