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

public interface BufferMapAsyncCallback extends WGPUCallback {
	/** Callback: void BufferMapAsyncCallback [BufferMapAsyncStatus status, size_t userdata] */
	void apply(BufferMapAsyncStatus status, long userdata);

	default void stub(final int status, final long userdata) {
		var _status = BufferMapAsyncStatus.from(status);
		var _userdata = userdata;
		apply(_status, _userdata);
	}

	public static FunctionDescriptor desc = functionDescriptor(null, JAVA_INT, JAVA_LONG);
	public static MethodHandle handle = findVirtual(BufferMapAsyncCallback.class, "stub", methodType(void.class, int.class, long.class));

}
