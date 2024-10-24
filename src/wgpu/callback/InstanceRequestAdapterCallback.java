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

public interface InstanceRequestAdapterCallback extends Callback {
	/** Callback: void InstanceRequestAdapterCallback [RequestAdapterStatus status, GPUAdapter * adapter, char const * message, size_t userdata] */
	void apply(RequestAdapterStatus status, GPUAdapter adapter, String message, long userdata);

	default void stub(final int status, final long adapter, final long message, final long userdata) {
		var _status = RequestAdapterStatus.from(status);
		var _adapter = new GPUAdapter(adapter);
		var _message = get_string(message);
		var _userdata = userdata;
		apply(_status, _adapter, _message, _userdata);
	}

	public static FunctionDescriptor desc = functionDescriptor(null, JAVA_INT, JAVA_LONG, JAVA_LONG, JAVA_LONG);
	public static MethodHandle handle = findVirtual(InstanceRequestAdapterCallback.class, "stub", void.class, int.class, long.class, long.class, long.class);

}
