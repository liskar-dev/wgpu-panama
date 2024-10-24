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

public interface AdapterRequestDeviceCallback extends Callback {
	/** Callback: void AdapterRequestDeviceCallback [RequestDeviceStatus status, GPUDevice * device, char const * message, size_t userdata] */
	void apply(RequestDeviceStatus status, GPUDevice device, String message, long userdata);

	default void stub(final int status, final long device, final long message, final long userdata) {
		var _status = RequestDeviceStatus.from(status);
		var _device = new GPUDevice(device);
		var _message = get_string(message);
		var _userdata = userdata;
		apply(_status, _device, _message, _userdata);
	}

	public static FunctionDescriptor desc = functionDescriptor(null, JAVA_INT, JAVA_LONG, JAVA_LONG, JAVA_LONG);
	public static MethodHandle handle = findVirtual(AdapterRequestDeviceCallback.class, "stub", void.class, int.class, long.class, long.class, long.class);

}
