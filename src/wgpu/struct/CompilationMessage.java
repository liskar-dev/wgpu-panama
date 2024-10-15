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

public class CompilationMessage extends WGPUStruct {
	public ChainedStruct nextInChain;
	@Nullable
	public String message;
	public CompilationMessageType type;
	// padding 4
	public long lineNum;
	public long linePos;
	public long offset;
	public long length;
	public long utf16LinePos;
	public long utf16Offset;
	public long utf16Length;

	protected static final int byteSize = 80;
	protected int byteSize() {
		return byteSize;
	}

	protected long store(Stack stack, long address) {
		put_value(address+0, stack.alloc(nextInChain));
		put_value(address+8, stack.alloc(message));
		put_value(address+16, type == null ? 0 : type.bits );
		// padding 4
		put_value(address+24, (long) lineNum);
		put_value(address+32, (long) linePos);
		put_value(address+40, (long) offset);
		put_value(address+48, (long) length);
		put_value(address+56, (long) utf16LinePos);
		put_value(address+64, (long) utf16Offset);
		put_value(address+72, (long) utf16Length);
		return address;
	}

	protected CompilationMessage load(long address) {
		nextInChain = ChainedStruct.from(get_long(address+0));
		message = get_string(get_long(address+8));
		type = CompilationMessageType.from(get_int(address+16));
		// padding 4
		lineNum = get_long(address+24);
		linePos = get_long(address+32);
		offset = get_long(address+40);
		length = get_long(address+48);
		utf16LinePos = get_long(address+56);
		utf16Offset = get_long(address+64);
		utf16Length = get_long(address+72);
		// padding 4
		return this;
	}
	public CompilationMessage() {}
}
