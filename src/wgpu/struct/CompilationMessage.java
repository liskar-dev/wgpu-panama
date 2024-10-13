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

	protected int sizeInBytes() {
		return 80;
	}

	protected void writeTo(WGPUWriter out) {
		out.pointer(nextInChain);
		out.pointer(message);
		out.write(type);
		out.padding(4);
		out.write(lineNum);
		out.write(linePos);
		out.write(offset);
		out.write(length);
		out.write(utf16LinePos);
		out.write(utf16Offset);
		out.write(utf16Length);
	}

	protected CompilationMessage readFrom(WGPUReader in) {
		nextInChain = ChainedStruct.from(in.read_pointer());
		message = in.read_string();
		type = CompilationMessageType.from(in.read_int());
		in.padding(4);
		lineNum = in.read_long();
		linePos = in.read_long();
		offset = in.read_long();
		length = in.read_long();
		utf16LinePos = in.read_long();
		utf16Offset = in.read_long();
		utf16Length = in.read_long();
		return this;
	}

	public CompilationMessage() {}

	public CompilationMessage(MemorySegment from) {
		readFrom(new WGPUReader(from));
	}

}
