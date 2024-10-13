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

public interface InstanceRequestAdapterCallback extends WGPUCallback {
	/** Callback: void InstanceRequestAdapterCallback [RequestAdapterStatus status, WGPUAdapter * adapter, char const * message, size_t userdata] */
	void apply(RequestAdapterStatus status, WGPUAdapter adapter, String message, long userdata);

	default void stub(final int status, final MemorySegment adapter, final MemorySegment message, final long userdata) {
		var _status = RequestAdapterStatus.from(status);
		var _adapter = isNull(adapter) ? null : new WGPUAdapter(adapter);
		var _message = isNull(message) ? null : message.getString(0);
		var _userdata = userdata;
		apply(_status, _adapter, _message, _userdata);
	}

	public static FunctionDescriptor desc = functionDescriptor(null, JAVA_INT, POINTER, POINTER, JAVA_LONG);
	public static MethodHandle handle = findVirtual(InstanceRequestAdapterCallback.class, "stub", methodType(void.class, int.class, MemorySegment.class, MemorySegment.class, long.class));

}
