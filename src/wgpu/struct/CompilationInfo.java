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

public class CompilationInfo extends WGPUStruct {
	public ChainedStruct nextInChain;
	// [messageCount]
	public CompilationMessage[] messages;

	protected int sizeInBytes() {
		return 24;
	}

	protected void writeTo(WGPUWriter out) {
		out.pointer(nextInChain);
		out.write((long) messages.length);
		out.pointer(messages);
	}

	protected CompilationInfo readFrom(WGPUReader in) {
		nextInChain = ChainedStruct.from(in.read_pointer());
		var messageCount = (int) in.read_long();
		var _messages = in.read_pointer();
		if(!isNull(_messages)) {
			messages = new CompilationMessage[messageCount];
			var rin = new WGPUReader(_messages);
			for(int i=0; i<messages.length; i++) {
				messages[i] = new CompilationMessage().readFrom(rin);
			}
		}
		return this;
	}

	public CompilationInfo() {}

	public CompilationInfo(MemorySegment from) {
		readFrom(new WGPUReader(from));
	}

}
