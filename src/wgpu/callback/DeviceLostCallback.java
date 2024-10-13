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

public interface DeviceLostCallback extends WGPUCallback {
	/** Callback: void DeviceLostCallback [DeviceLostReason reason, char const * message, size_t userdata] */
	void apply(DeviceLostReason reason, String message, long userdata);

	default void stub(final int reason, final MemorySegment message, final long userdata) {
		var _reason = DeviceLostReason.from(reason);
		var _message = isNull(message) ? null : message.getString(0);
		var _userdata = userdata;
		apply(_reason, _message, _userdata);
	}

	public static FunctionDescriptor desc = functionDescriptor(null, JAVA_INT, POINTER, JAVA_LONG);
	public static MethodHandle handle = findVirtual(DeviceLostCallback.class, "stub", methodType(void.class, int.class, MemorySegment.class, long.class));

}
