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

public class BindGroupDescriptor extends CStruct {
	public ChainedStruct nextInChain;
	@Nullable
	public String label;
	public GPUBindGroupLayout layout = new GPUBindGroupLayout(0);
	// size_t entryCount
	public BindGroupEntry[] entries;

	protected static final int byteSize = 40;
	protected int byteSize() {
		return byteSize;
	}

	protected long store(Stack stack, long address) {
		put_value(address+0, stack.alloc(nextInChain));
		put_value(address+8, stack.alloc(label));
		put_value(address+16, layout.handle );
		put_value(address+24, (long) (entries == null ? 0 : entries.length));
		put_value(address+32, stack.alloc(entries));
		return address;
	}

	protected BindGroupDescriptor load(long address) {
		nextInChain = ChainedStruct.from(get_long(address+0));
		label = get_string(get_long(address+8));
		layout.handle = get_long(address+16);
		var entryCount = (int) get_long(address+24);
		var _entries = get_long(address+32);
		if(_entries != 0L) {
			entries = entries != null && entries.length == entryCount ? entries : new BindGroupEntry[entryCount];
			for(int i=0; i<entries.length; i++) {
				entries[i] = new BindGroupEntry().load(_entries + i*BindGroupEntry.byteSize);
			}
		} else {
			entries= null;
		}
		return this;
	}
	public BindGroupDescriptor() {}
}
