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

public class CompilationInfo extends WGPUStruct {
	public ChainedStruct nextInChain;
	// size_t messageCount
	public CompilationMessage[] messages;

	protected static final int byteSize = 24;
	protected int byteSize() {
		return byteSize;
	}

	protected long store(Stack stack, long address) {
		put_value(address+0, stack.alloc(nextInChain));
		put_value(address+8, (long) (messages == null ? 0 : messages.length));
		put_value(address+16, stack.alloc(messages));
		return address;
	}

	protected CompilationInfo load(long address) {
		nextInChain = ChainedStruct.from(get_long(address+0));
		var messageCount = (int) get_long(address+8);
		var _messages = get_long(address+16);
		if(_messages != 0L) {
			messages = messages != null && messages.length == messageCount ? messages : new CompilationMessage[messageCount];
			for(int i=0; i<messages.length; i++) {
				messages[i] = new CompilationMessage().load(_messages + i*CompilationMessage.byteSize);
			}
		} else {
			messages= null;
		}
		return this;
	}
	public CompilationInfo() {}
}
