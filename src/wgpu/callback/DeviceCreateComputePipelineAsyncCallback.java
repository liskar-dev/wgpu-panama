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

public interface DeviceCreateComputePipelineAsyncCallback extends WGPUCallback {
	/** Callback: void DeviceCreateComputePipelineAsyncCallback [CreatePipelineAsyncStatus status, WGPUComputePipeline * pipeline, char const * message, size_t userdata] */
	void apply(CreatePipelineAsyncStatus status, WGPUComputePipeline pipeline, String message, long userdata);

	default void stub(final int status, final long pipeline, final long message, final long userdata) {
		var _status = CreatePipelineAsyncStatus.from(status);
		var _pipeline = new WGPUComputePipeline(pipeline);
		var _message = get_string(message);
		var _userdata = userdata;
		apply(_status, _pipeline, _message, _userdata);
	}

	public static FunctionDescriptor desc = functionDescriptor(null, JAVA_INT, JAVA_LONG, JAVA_LONG, JAVA_LONG);
	public static MethodHandle handle = findVirtual(DeviceCreateComputePipelineAsyncCallback.class, "stub", methodType(void.class, int.class, long.class, long.class, long.class));

}
