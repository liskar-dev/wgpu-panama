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
import static wgpu.WGPUCallback.*;

public interface ErrorCallback extends WGPUCallback {
	/** Callback: void ErrorCallback [ErrorType type, char const * message, size_t userdata] */
	void apply(ErrorType type, String message, long userdata);

	default void stub(final int type, final long message, final long userdata) {
		var _type = ErrorType.from(type);
		var _message = get_string(message);
		var _userdata = userdata;
		apply(_type, _message, _userdata);
	}

	public static FunctionDescriptor desc = functionDescriptor(null, JAVA_INT, JAVA_LONG, JAVA_LONG);
	public static MethodHandle handle = findVirtual(ErrorCallback.class, "stub", void.class, int.class, long.class, long.class);

}
