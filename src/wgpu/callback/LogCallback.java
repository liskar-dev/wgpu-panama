package wgpu.callback;

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

import java.lang.invoke.MethodHandle;

public interface LogCallback extends WGPUCallback {
	/** Callback: void LogCallback [LogLevel level, char const * message, size_t userdata] */
	void apply(LogLevel level, String message, long userdata);

	default void stub(final int level, final MemorySegment message, final long userdata) {
		var _level = LogLevel.from(level);
		var _message = isNull(message) ? null : message.getString(0);
		var _userdata = userdata;
		apply(_level, _message, _userdata);
	}

	public static FunctionDescriptor desc = functionDescriptor(null, JAVA_INT, POINTER, JAVA_LONG);
	public static MethodHandle handle = findVirtual(LogCallback.class, "stub", methodType(void.class, int.class, MemorySegment.class, long.class));

}
