package wgpu.callback;

import wgpu.*;
import wgpu.impl.*;
import wgpu.struct.*;
import wgpu.enums.*;
import wgpu.callback.*;

import java.lang.foreign.*;
import org.jspecify.annotations.*;

import static java.lang.foreign.ValueLayout.*;
import static java.lang.foreign.MemoryLayout.*;

import java.lang.invoke.MethodHandle;
import static wgpu.Callback.*;

public interface LogCallback extends Callback {
	/** Callback: void LogCallback [LogLevel level, char const * message, size_t userdata] */
	void apply(LogLevel level, String message, long userdata);

	default void stub(final int level, final long message, final long userdata) {
		var _level = LogLevel.from(level);
		var _message = get_string(message);
		var _userdata = userdata;
		apply(_level, _message, _userdata);
	}

	public static FunctionDescriptor desc = functionDescriptor(null, JAVA_INT, JAVA_LONG, JAVA_LONG);
	public static MethodHandle handle = findVirtual(LogCallback.class, "stub", void.class, int.class, long.class, long.class);

}
