package wgpu.callback;

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

import java.lang.invoke.MethodHandle;

public interface AdapterRequestDeviceCallback extends WGPUCallback {
	/** Callback: void AdapterRequestDeviceCallback [RequestDeviceStatus status, WGPUDevice * device, char const * message, size_t userdata] */
	void apply(RequestDeviceStatus status, WGPUDevice device, String message, long userdata);

	default void stub(final int status, final long device, final long message, final long userdata) {
		var _status = RequestDeviceStatus.from(status);
		var _device = new WGPUDevice(device);
		var _message = get_string(message);
		var _userdata = userdata;
		apply(_status, _device, _message, _userdata);
	}

	public static FunctionDescriptor desc = functionDescriptor(null, JAVA_INT, JAVA_LONG, JAVA_LONG, JAVA_LONG);
	public static MethodHandle handle = findVirtual(AdapterRequestDeviceCallback.class, "stub", methodType(void.class, int.class, long.class, long.class, long.class));

}
