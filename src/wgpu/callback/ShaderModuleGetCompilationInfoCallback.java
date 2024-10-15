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

public interface ShaderModuleGetCompilationInfoCallback extends WGPUCallback {
	/** Callback: void ShaderModuleGetCompilationInfoCallback [CompilationInfoRequestStatus status, CompilationInfo const * compilationInfo, size_t userdata] */
	void apply(CompilationInfoRequestStatus status, CompilationInfo compilationInfo, long userdata);

	default void stub(final int status, final long compilationInfo, final long userdata) {
		var _status = CompilationInfoRequestStatus.from(status);
		var _compilationInfo = loadStruct(new CompilationInfo(), compilationInfo);
		var _userdata = userdata;
		apply(_status, _compilationInfo, _userdata);
	}

	public static FunctionDescriptor desc = functionDescriptor(null, JAVA_INT, JAVA_LONG, JAVA_LONG);
	public static MethodHandle handle = findVirtual(ShaderModuleGetCompilationInfoCallback.class, "stub", methodType(void.class, int.class, long.class, long.class));

}
