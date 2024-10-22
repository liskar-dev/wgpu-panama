package wgpu;

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

public class WebGPU {
	private static final MethodHandle wgpuCreateInstance = lookup(JAVA_LONG, "wgpuCreateInstance", JAVA_LONG);
	public static long wgpuCreateInstance(@Nullable final InstanceDescriptor descriptor) {
		try(var stack = Stack.get()) {
			var _descriptor = stack.alloc(descriptor);
			var ret = (long) wgpuCreateInstance.invokeExact(_descriptor);
			return ret;
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuGetProcAddress = lookup(ADDRESS, "wgpuGetProcAddress", JAVA_LONG, JAVA_LONG);
	public static long wgpuGetProcAddress(final long device, final String procName) {
		try(var stack = Stack.get()) {
			var _device = device;
			var _procName = stack.alloc(procName);
			var ret = (long) wgpuGetProcAddress.invokeExact(_device, _procName);
			return ret;
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuAdapterEnumerateFeatures = lookup(JAVA_LONG, "wgpuAdapterEnumerateFeatures", JAVA_LONG, JAVA_LONG);
	public static long wgpuAdapterEnumerateFeatures(final long adapter, FeatureName[] features) {
		try(var stack = Stack.get()) {
			var _adapter = adapter;
			var _features = stack.prealloc(features);
			var ret = (long) wgpuAdapterEnumerateFeatures.invokeExact(_adapter, _features);
			if(features != null) {
				for(int i=0; i<features.length; i++) {
					features[i] = FeatureName.from(get_int(_features + i*4));
				}
			}
			return ret;
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuAdapterGetInfo = lookup(null, "wgpuAdapterGetInfo", JAVA_LONG, JAVA_LONG);
	public static void wgpuAdapterGetInfo(final long adapter, AdapterInfo info) {
		try(var stack = Stack.get()) {
			var _adapter = adapter;
			var _info = stack.prealloc(info);
			wgpuAdapterGetInfo.invokeExact(_adapter, _info);
			((WGPUStruct)info).load(_info);
			wgpuAdapterInfoFreeMembers.invoke(wrap(_info, 56));
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuAdapterGetLimits = lookup(JAVA_INT, "wgpuAdapterGetLimits", JAVA_LONG, JAVA_LONG);
	public static boolean wgpuAdapterGetLimits(final long adapter, SupportedLimits limits) {
		try(var stack = Stack.get()) {
			var _adapter = adapter;
			var _limits = stack.prealloc(limits);
			var ret = (int) wgpuAdapterGetLimits.invokeExact(_adapter, _limits);
			((WGPUStruct)limits).load(_limits);
			return ret != 0;
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuAdapterHasFeature = lookup(JAVA_INT, "wgpuAdapterHasFeature", JAVA_LONG, JAVA_INT);
	public static boolean wgpuAdapterHasFeature(final long adapter, final FeatureName feature) {
		try(var stack = Stack.get()) {
			var _adapter = adapter;
			var _feature = feature == null ? 0 : feature.bits;
			var ret = (int) wgpuAdapterHasFeature.invokeExact(_adapter, _feature);
			return ret != 0;
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuAdapterRequestDevice = lookup(null, "wgpuAdapterRequestDevice", JAVA_LONG, JAVA_LONG, ADDRESS, JAVA_LONG);
	public static void wgpuAdapterRequestDevice(final long adapter, @Nullable final DeviceDescriptor descriptor, final AdapterRequestDeviceCallback callback, final long userdata) {
		try(var stack = Stack.get()) {
			var _adapter = adapter;
			var _descriptor = stack.alloc(descriptor);
			var _callback = WGPUCallback.createStub(callback, callback.handle, callback.desc);
			var _userdata = (long) userdata;
			wgpuAdapterRequestDevice.invokeExact(_adapter, _descriptor, _callback, _userdata);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuAdapterReference = lookup(null, "wgpuAdapterReference", JAVA_LONG);
	public static void wgpuAdapterReference(final long adapter) {
		try(var stack = Stack.get()) {
			var _adapter = adapter;
			wgpuAdapterReference.invokeExact(_adapter);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuAdapterRelease = lookup(null, "wgpuAdapterRelease", JAVA_LONG);
	public static void wgpuAdapterRelease(final long adapter) {
		try(var stack = Stack.get()) {
			var _adapter = adapter;
			wgpuAdapterRelease.invokeExact(_adapter);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuAdapterInfoFreeMembers = lookup(null, "wgpuAdapterInfoFreeMembers", STRUCT(56));

	private static final MethodHandle wgpuBindGroupSetLabel = lookup(null, "wgpuBindGroupSetLabel", JAVA_LONG, JAVA_LONG);
	public static void wgpuBindGroupSetLabel(final long bindGroup, final String label) {
		try(var stack = Stack.get()) {
			var _bindGroup = bindGroup;
			var _label = stack.alloc(label);
			wgpuBindGroupSetLabel.invokeExact(_bindGroup, _label);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuBindGroupReference = lookup(null, "wgpuBindGroupReference", JAVA_LONG);
	public static void wgpuBindGroupReference(final long bindGroup) {
		try(var stack = Stack.get()) {
			var _bindGroup = bindGroup;
			wgpuBindGroupReference.invokeExact(_bindGroup);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuBindGroupRelease = lookup(null, "wgpuBindGroupRelease", JAVA_LONG);
	public static void wgpuBindGroupRelease(final long bindGroup) {
		try(var stack = Stack.get()) {
			var _bindGroup = bindGroup;
			wgpuBindGroupRelease.invokeExact(_bindGroup);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuBindGroupLayoutSetLabel = lookup(null, "wgpuBindGroupLayoutSetLabel", JAVA_LONG, JAVA_LONG);
	public static void wgpuBindGroupLayoutSetLabel(final long bindGroupLayout, final String label) {
		try(var stack = Stack.get()) {
			var _bindGroupLayout = bindGroupLayout;
			var _label = stack.alloc(label);
			wgpuBindGroupLayoutSetLabel.invokeExact(_bindGroupLayout, _label);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuBindGroupLayoutReference = lookup(null, "wgpuBindGroupLayoutReference", JAVA_LONG);
	public static void wgpuBindGroupLayoutReference(final long bindGroupLayout) {
		try(var stack = Stack.get()) {
			var _bindGroupLayout = bindGroupLayout;
			wgpuBindGroupLayoutReference.invokeExact(_bindGroupLayout);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuBindGroupLayoutRelease = lookup(null, "wgpuBindGroupLayoutRelease", JAVA_LONG);
	public static void wgpuBindGroupLayoutRelease(final long bindGroupLayout) {
		try(var stack = Stack.get()) {
			var _bindGroupLayout = bindGroupLayout;
			wgpuBindGroupLayoutRelease.invokeExact(_bindGroupLayout);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuBufferDestroy = lookup(null, "wgpuBufferDestroy", JAVA_LONG);
	public static void wgpuBufferDestroy(final long buffer) {
		try(var stack = Stack.get()) {
			var _buffer = buffer;
			wgpuBufferDestroy.invokeExact(_buffer);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuBufferGetConstMappedRange = lookup(JAVA_LONG, "wgpuBufferGetConstMappedRange", JAVA_LONG, JAVA_LONG, JAVA_LONG);
	public static long wgpuBufferGetConstMappedRange(final long buffer, final long offset, final long size) {
		try(var stack = Stack.get()) {
			var _buffer = buffer;
			var _offset = (long) offset;
			var _size = (long) size;
			var ret = (long) wgpuBufferGetConstMappedRange.invokeExact(_buffer, _offset, _size);
			return ret;
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuBufferGetMapState = lookup(JAVA_INT, "wgpuBufferGetMapState", JAVA_LONG);
	public static BufferMapState wgpuBufferGetMapState(final long buffer) {
		try(var stack = Stack.get()) {
			var _buffer = buffer;
			var ret = (int) wgpuBufferGetMapState.invokeExact(_buffer);
			return BufferMapState.from(ret);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuBufferGetMappedRange = lookup(JAVA_LONG, "wgpuBufferGetMappedRange", JAVA_LONG, JAVA_LONG, JAVA_LONG);
	public static long wgpuBufferGetMappedRange(final long buffer, final long offset, final long size) {
		try(var stack = Stack.get()) {
			var _buffer = buffer;
			var _offset = (long) offset;
			var _size = (long) size;
			var ret = (long) wgpuBufferGetMappedRange.invokeExact(_buffer, _offset, _size);
			return ret;
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuBufferGetSize = lookup(JAVA_LONG, "wgpuBufferGetSize", JAVA_LONG);
	public static long wgpuBufferGetSize(final long buffer) {
		try(var stack = Stack.get()) {
			var _buffer = buffer;
			var ret = (long) wgpuBufferGetSize.invokeExact(_buffer);
			return ret;
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuBufferGetUsage = lookup(JAVA_INT, "wgpuBufferGetUsage", JAVA_LONG);
	public static int wgpuBufferGetUsage(final long buffer) {
		try(var stack = Stack.get()) {
			var _buffer = buffer;
			var ret = (int) wgpuBufferGetUsage.invokeExact(_buffer);
			return ret;
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuBufferMapAsync = lookup(null, "wgpuBufferMapAsync", JAVA_LONG, JAVA_INT, JAVA_LONG, JAVA_LONG, ADDRESS, JAVA_LONG);
	public static void wgpuBufferMapAsync(final long buffer, final int mode, final long offset, final long size, final BufferMapAsyncCallback callback, final long userdata) {
		try(var stack = Stack.get()) {
			var _buffer = buffer;
			var _mode = (int) mode;
			var _offset = (long) offset;
			var _size = (long) size;
			var _callback = WGPUCallback.createStub(callback, callback.handle, callback.desc);
			var _userdata = (long) userdata;
			wgpuBufferMapAsync.invokeExact(_buffer, _mode, _offset, _size, _callback, _userdata);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuBufferSetLabel = lookup(null, "wgpuBufferSetLabel", JAVA_LONG, JAVA_LONG);
	public static void wgpuBufferSetLabel(final long buffer, final String label) {
		try(var stack = Stack.get()) {
			var _buffer = buffer;
			var _label = stack.alloc(label);
			wgpuBufferSetLabel.invokeExact(_buffer, _label);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuBufferUnmap = lookup(null, "wgpuBufferUnmap", JAVA_LONG);
	public static void wgpuBufferUnmap(final long buffer) {
		try(var stack = Stack.get()) {
			var _buffer = buffer;
			wgpuBufferUnmap.invokeExact(_buffer);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuBufferReference = lookup(null, "wgpuBufferReference", JAVA_LONG);
	public static void wgpuBufferReference(final long buffer) {
		try(var stack = Stack.get()) {
			var _buffer = buffer;
			wgpuBufferReference.invokeExact(_buffer);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuBufferRelease = lookup(null, "wgpuBufferRelease", JAVA_LONG);
	public static void wgpuBufferRelease(final long buffer) {
		try(var stack = Stack.get()) {
			var _buffer = buffer;
			wgpuBufferRelease.invokeExact(_buffer);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuCommandBufferSetLabel = lookup(null, "wgpuCommandBufferSetLabel", JAVA_LONG, JAVA_LONG);
	public static void wgpuCommandBufferSetLabel(final long commandBuffer, final String label) {
		try(var stack = Stack.get()) {
			var _commandBuffer = commandBuffer;
			var _label = stack.alloc(label);
			wgpuCommandBufferSetLabel.invokeExact(_commandBuffer, _label);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuCommandBufferReference = lookup(null, "wgpuCommandBufferReference", JAVA_LONG);
	public static void wgpuCommandBufferReference(final long commandBuffer) {
		try(var stack = Stack.get()) {
			var _commandBuffer = commandBuffer;
			wgpuCommandBufferReference.invokeExact(_commandBuffer);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuCommandBufferRelease = lookup(null, "wgpuCommandBufferRelease", JAVA_LONG);
	public static void wgpuCommandBufferRelease(final long commandBuffer) {
		try(var stack = Stack.get()) {
			var _commandBuffer = commandBuffer;
			wgpuCommandBufferRelease.invokeExact(_commandBuffer);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuCommandEncoderBeginComputePass = lookup(JAVA_LONG, "wgpuCommandEncoderBeginComputePass", JAVA_LONG, JAVA_LONG);
	public static long wgpuCommandEncoderBeginComputePass(final long commandEncoder, @Nullable final ComputePassDescriptor descriptor) {
		try(var stack = Stack.get()) {
			var _commandEncoder = commandEncoder;
			var _descriptor = stack.alloc(descriptor);
			var ret = (long) wgpuCommandEncoderBeginComputePass.invokeExact(_commandEncoder, _descriptor);
			return ret;
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuCommandEncoderBeginRenderPass = lookup(JAVA_LONG, "wgpuCommandEncoderBeginRenderPass", JAVA_LONG, JAVA_LONG);
	public static long wgpuCommandEncoderBeginRenderPass(final long commandEncoder, final RenderPassDescriptor descriptor) {
		try(var stack = Stack.get()) {
			var _commandEncoder = commandEncoder;
			var _descriptor = stack.alloc(descriptor);
			var ret = (long) wgpuCommandEncoderBeginRenderPass.invokeExact(_commandEncoder, _descriptor);
			return ret;
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuCommandEncoderClearBuffer = lookup(null, "wgpuCommandEncoderClearBuffer", JAVA_LONG, JAVA_LONG, JAVA_LONG, JAVA_LONG);
	public static void wgpuCommandEncoderClearBuffer(final long commandEncoder, final long buffer, final long offset, final long size) {
		try(var stack = Stack.get()) {
			var _commandEncoder = commandEncoder;
			var _buffer = buffer;
			var _offset = (long) offset;
			var _size = (long) size;
			wgpuCommandEncoderClearBuffer.invokeExact(_commandEncoder, _buffer, _offset, _size);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuCommandEncoderCopyBufferToBuffer = lookup(null, "wgpuCommandEncoderCopyBufferToBuffer", JAVA_LONG, JAVA_LONG, JAVA_LONG, JAVA_LONG, JAVA_LONG, JAVA_LONG);
	public static void wgpuCommandEncoderCopyBufferToBuffer(final long commandEncoder, final long source, final long sourceOffset, final long destination, final long destinationOffset, final long size) {
		try(var stack = Stack.get()) {
			var _commandEncoder = commandEncoder;
			var _source = source;
			var _sourceOffset = (long) sourceOffset;
			var _destination = destination;
			var _destinationOffset = (long) destinationOffset;
			var _size = (long) size;
			wgpuCommandEncoderCopyBufferToBuffer.invokeExact(_commandEncoder, _source, _sourceOffset, _destination, _destinationOffset, _size);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuCommandEncoderCopyBufferToTexture = lookup(null, "wgpuCommandEncoderCopyBufferToTexture", JAVA_LONG, JAVA_LONG, JAVA_LONG, JAVA_LONG);
	public static void wgpuCommandEncoderCopyBufferToTexture(final long commandEncoder, final ImageCopyBuffer source, final ImageCopyTexture destination, final Extent3D copySize) {
		try(var stack = Stack.get()) {
			var _commandEncoder = commandEncoder;
			var _source = stack.alloc(source);
			var _destination = stack.alloc(destination);
			var _copySize = stack.alloc(copySize);
			wgpuCommandEncoderCopyBufferToTexture.invokeExact(_commandEncoder, _source, _destination, _copySize);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuCommandEncoderCopyTextureToBuffer = lookup(null, "wgpuCommandEncoderCopyTextureToBuffer", JAVA_LONG, JAVA_LONG, JAVA_LONG, JAVA_LONG);
	public static void wgpuCommandEncoderCopyTextureToBuffer(final long commandEncoder, final ImageCopyTexture source, final ImageCopyBuffer destination, final Extent3D copySize) {
		try(var stack = Stack.get()) {
			var _commandEncoder = commandEncoder;
			var _source = stack.alloc(source);
			var _destination = stack.alloc(destination);
			var _copySize = stack.alloc(copySize);
			wgpuCommandEncoderCopyTextureToBuffer.invokeExact(_commandEncoder, _source, _destination, _copySize);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuCommandEncoderCopyTextureToTexture = lookup(null, "wgpuCommandEncoderCopyTextureToTexture", JAVA_LONG, JAVA_LONG, JAVA_LONG, JAVA_LONG);
	public static void wgpuCommandEncoderCopyTextureToTexture(final long commandEncoder, final ImageCopyTexture source, final ImageCopyTexture destination, final Extent3D copySize) {
		try(var stack = Stack.get()) {
			var _commandEncoder = commandEncoder;
			var _source = stack.alloc(source);
			var _destination = stack.alloc(destination);
			var _copySize = stack.alloc(copySize);
			wgpuCommandEncoderCopyTextureToTexture.invokeExact(_commandEncoder, _source, _destination, _copySize);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuCommandEncoderFinish = lookup(JAVA_LONG, "wgpuCommandEncoderFinish", JAVA_LONG, JAVA_LONG);
	public static long wgpuCommandEncoderFinish(final long commandEncoder, @Nullable final CommandBufferDescriptor descriptor) {
		try(var stack = Stack.get()) {
			var _commandEncoder = commandEncoder;
			var _descriptor = stack.alloc(descriptor);
			var ret = (long) wgpuCommandEncoderFinish.invokeExact(_commandEncoder, _descriptor);
			return ret;
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuCommandEncoderInsertDebugMarker = lookup(null, "wgpuCommandEncoderInsertDebugMarker", JAVA_LONG, JAVA_LONG);
	public static void wgpuCommandEncoderInsertDebugMarker(final long commandEncoder, final String markerLabel) {
		try(var stack = Stack.get()) {
			var _commandEncoder = commandEncoder;
			var _markerLabel = stack.alloc(markerLabel);
			wgpuCommandEncoderInsertDebugMarker.invokeExact(_commandEncoder, _markerLabel);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuCommandEncoderPopDebugGroup = lookup(null, "wgpuCommandEncoderPopDebugGroup", JAVA_LONG);
	public static void wgpuCommandEncoderPopDebugGroup(final long commandEncoder) {
		try(var stack = Stack.get()) {
			var _commandEncoder = commandEncoder;
			wgpuCommandEncoderPopDebugGroup.invokeExact(_commandEncoder);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuCommandEncoderPushDebugGroup = lookup(null, "wgpuCommandEncoderPushDebugGroup", JAVA_LONG, JAVA_LONG);
	public static void wgpuCommandEncoderPushDebugGroup(final long commandEncoder, final String groupLabel) {
		try(var stack = Stack.get()) {
			var _commandEncoder = commandEncoder;
			var _groupLabel = stack.alloc(groupLabel);
			wgpuCommandEncoderPushDebugGroup.invokeExact(_commandEncoder, _groupLabel);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuCommandEncoderResolveQuerySet = lookup(null, "wgpuCommandEncoderResolveQuerySet", JAVA_LONG, JAVA_LONG, JAVA_INT, JAVA_INT, JAVA_LONG, JAVA_LONG);
	public static void wgpuCommandEncoderResolveQuerySet(final long commandEncoder, final long querySet, final int firstQuery, final int queryCount, final long destination, final long destinationOffset) {
		try(var stack = Stack.get()) {
			var _commandEncoder = commandEncoder;
			var _querySet = querySet;
			var _firstQuery = (int) firstQuery;
			var _queryCount = (int) queryCount;
			var _destination = destination;
			var _destinationOffset = (long) destinationOffset;
			wgpuCommandEncoderResolveQuerySet.invokeExact(_commandEncoder, _querySet, _firstQuery, _queryCount, _destination, _destinationOffset);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuCommandEncoderSetLabel = lookup(null, "wgpuCommandEncoderSetLabel", JAVA_LONG, JAVA_LONG);
	public static void wgpuCommandEncoderSetLabel(final long commandEncoder, final String label) {
		try(var stack = Stack.get()) {
			var _commandEncoder = commandEncoder;
			var _label = stack.alloc(label);
			wgpuCommandEncoderSetLabel.invokeExact(_commandEncoder, _label);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuCommandEncoderWriteTimestamp = lookup(null, "wgpuCommandEncoderWriteTimestamp", JAVA_LONG, JAVA_LONG, JAVA_INT);
	public static void wgpuCommandEncoderWriteTimestamp(final long commandEncoder, final long querySet, final int queryIndex) {
		try(var stack = Stack.get()) {
			var _commandEncoder = commandEncoder;
			var _querySet = querySet;
			var _queryIndex = (int) queryIndex;
			wgpuCommandEncoderWriteTimestamp.invokeExact(_commandEncoder, _querySet, _queryIndex);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuCommandEncoderReference = lookup(null, "wgpuCommandEncoderReference", JAVA_LONG);
	public static void wgpuCommandEncoderReference(final long commandEncoder) {
		try(var stack = Stack.get()) {
			var _commandEncoder = commandEncoder;
			wgpuCommandEncoderReference.invokeExact(_commandEncoder);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuCommandEncoderRelease = lookup(null, "wgpuCommandEncoderRelease", JAVA_LONG);
	public static void wgpuCommandEncoderRelease(final long commandEncoder) {
		try(var stack = Stack.get()) {
			var _commandEncoder = commandEncoder;
			wgpuCommandEncoderRelease.invokeExact(_commandEncoder);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuComputePassEncoderDispatchWorkgroups = lookup(null, "wgpuComputePassEncoderDispatchWorkgroups", JAVA_LONG, JAVA_INT, JAVA_INT, JAVA_INT);
	public static void wgpuComputePassEncoderDispatchWorkgroups(final long computePassEncoder, final int workgroupCountX, final int workgroupCountY, final int workgroupCountZ) {
		try(var stack = Stack.get()) {
			var _computePassEncoder = computePassEncoder;
			var _workgroupCountX = (int) workgroupCountX;
			var _workgroupCountY = (int) workgroupCountY;
			var _workgroupCountZ = (int) workgroupCountZ;
			wgpuComputePassEncoderDispatchWorkgroups.invokeExact(_computePassEncoder, _workgroupCountX, _workgroupCountY, _workgroupCountZ);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuComputePassEncoderDispatchWorkgroupsIndirect = lookup(null, "wgpuComputePassEncoderDispatchWorkgroupsIndirect", JAVA_LONG, JAVA_LONG, JAVA_LONG);
	public static void wgpuComputePassEncoderDispatchWorkgroupsIndirect(final long computePassEncoder, final long indirectBuffer, final long indirectOffset) {
		try(var stack = Stack.get()) {
			var _computePassEncoder = computePassEncoder;
			var _indirectBuffer = indirectBuffer;
			var _indirectOffset = (long) indirectOffset;
			wgpuComputePassEncoderDispatchWorkgroupsIndirect.invokeExact(_computePassEncoder, _indirectBuffer, _indirectOffset);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuComputePassEncoderEnd = lookup(null, "wgpuComputePassEncoderEnd", JAVA_LONG);
	public static void wgpuComputePassEncoderEnd(final long computePassEncoder) {
		try(var stack = Stack.get()) {
			var _computePassEncoder = computePassEncoder;
			wgpuComputePassEncoderEnd.invokeExact(_computePassEncoder);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuComputePassEncoderInsertDebugMarker = lookup(null, "wgpuComputePassEncoderInsertDebugMarker", JAVA_LONG, JAVA_LONG);
	public static void wgpuComputePassEncoderInsertDebugMarker(final long computePassEncoder, final String markerLabel) {
		try(var stack = Stack.get()) {
			var _computePassEncoder = computePassEncoder;
			var _markerLabel = stack.alloc(markerLabel);
			wgpuComputePassEncoderInsertDebugMarker.invokeExact(_computePassEncoder, _markerLabel);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuComputePassEncoderPopDebugGroup = lookup(null, "wgpuComputePassEncoderPopDebugGroup", JAVA_LONG);
	public static void wgpuComputePassEncoderPopDebugGroup(final long computePassEncoder) {
		try(var stack = Stack.get()) {
			var _computePassEncoder = computePassEncoder;
			wgpuComputePassEncoderPopDebugGroup.invokeExact(_computePassEncoder);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuComputePassEncoderPushDebugGroup = lookup(null, "wgpuComputePassEncoderPushDebugGroup", JAVA_LONG, JAVA_LONG);
	public static void wgpuComputePassEncoderPushDebugGroup(final long computePassEncoder, final String groupLabel) {
		try(var stack = Stack.get()) {
			var _computePassEncoder = computePassEncoder;
			var _groupLabel = stack.alloc(groupLabel);
			wgpuComputePassEncoderPushDebugGroup.invokeExact(_computePassEncoder, _groupLabel);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuComputePassEncoderSetBindGroup = lookup(null, "wgpuComputePassEncoderSetBindGroup", JAVA_LONG, JAVA_INT, JAVA_LONG, JAVA_LONG, JAVA_LONG);
	public static void wgpuComputePassEncoderSetBindGroup(final long computePassEncoder, final int groupIndex, @Nullable final long group, final int[] dynamicOffsets) {
		try(var stack = Stack.get()) {
			var _computePassEncoder = computePassEncoder;
			var _groupIndex = (int) groupIndex;
			var _group = group;
			var _dynamicOffsetCount = (long) (dynamicOffsets == null ? 0 : dynamicOffsets.length);
			var _dynamicOffsets = stack.alloc(dynamicOffsets);
			wgpuComputePassEncoderSetBindGroup.invokeExact(_computePassEncoder, _groupIndex, _group, _dynamicOffsetCount, _dynamicOffsets);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuComputePassEncoderSetLabel = lookup(null, "wgpuComputePassEncoderSetLabel", JAVA_LONG, JAVA_LONG);
	public static void wgpuComputePassEncoderSetLabel(final long computePassEncoder, final String label) {
		try(var stack = Stack.get()) {
			var _computePassEncoder = computePassEncoder;
			var _label = stack.alloc(label);
			wgpuComputePassEncoderSetLabel.invokeExact(_computePassEncoder, _label);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuComputePassEncoderSetPipeline = lookup(null, "wgpuComputePassEncoderSetPipeline", JAVA_LONG, JAVA_LONG);
	public static void wgpuComputePassEncoderSetPipeline(final long computePassEncoder, final long pipeline) {
		try(var stack = Stack.get()) {
			var _computePassEncoder = computePassEncoder;
			var _pipeline = pipeline;
			wgpuComputePassEncoderSetPipeline.invokeExact(_computePassEncoder, _pipeline);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuComputePassEncoderReference = lookup(null, "wgpuComputePassEncoderReference", JAVA_LONG);
	public static void wgpuComputePassEncoderReference(final long computePassEncoder) {
		try(var stack = Stack.get()) {
			var _computePassEncoder = computePassEncoder;
			wgpuComputePassEncoderReference.invokeExact(_computePassEncoder);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuComputePassEncoderRelease = lookup(null, "wgpuComputePassEncoderRelease", JAVA_LONG);
	public static void wgpuComputePassEncoderRelease(final long computePassEncoder) {
		try(var stack = Stack.get()) {
			var _computePassEncoder = computePassEncoder;
			wgpuComputePassEncoderRelease.invokeExact(_computePassEncoder);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuComputePipelineGetBindGroupLayout = lookup(JAVA_LONG, "wgpuComputePipelineGetBindGroupLayout", JAVA_LONG, JAVA_INT);
	public static long wgpuComputePipelineGetBindGroupLayout(final long computePipeline, final int groupIndex) {
		try(var stack = Stack.get()) {
			var _computePipeline = computePipeline;
			var _groupIndex = (int) groupIndex;
			var ret = (long) wgpuComputePipelineGetBindGroupLayout.invokeExact(_computePipeline, _groupIndex);
			return ret;
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuComputePipelineSetLabel = lookup(null, "wgpuComputePipelineSetLabel", JAVA_LONG, JAVA_LONG);
	public static void wgpuComputePipelineSetLabel(final long computePipeline, final String label) {
		try(var stack = Stack.get()) {
			var _computePipeline = computePipeline;
			var _label = stack.alloc(label);
			wgpuComputePipelineSetLabel.invokeExact(_computePipeline, _label);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuComputePipelineReference = lookup(null, "wgpuComputePipelineReference", JAVA_LONG);
	public static void wgpuComputePipelineReference(final long computePipeline) {
		try(var stack = Stack.get()) {
			var _computePipeline = computePipeline;
			wgpuComputePipelineReference.invokeExact(_computePipeline);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuComputePipelineRelease = lookup(null, "wgpuComputePipelineRelease", JAVA_LONG);
	public static void wgpuComputePipelineRelease(final long computePipeline) {
		try(var stack = Stack.get()) {
			var _computePipeline = computePipeline;
			wgpuComputePipelineRelease.invokeExact(_computePipeline);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuDeviceCreateBindGroup = lookup(JAVA_LONG, "wgpuDeviceCreateBindGroup", JAVA_LONG, JAVA_LONG);
	public static long wgpuDeviceCreateBindGroup(final long device, final BindGroupDescriptor descriptor) {
		try(var stack = Stack.get()) {
			var _device = device;
			var _descriptor = stack.alloc(descriptor);
			var ret = (long) wgpuDeviceCreateBindGroup.invokeExact(_device, _descriptor);
			return ret;
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuDeviceCreateBindGroupLayout = lookup(JAVA_LONG, "wgpuDeviceCreateBindGroupLayout", JAVA_LONG, JAVA_LONG);
	public static long wgpuDeviceCreateBindGroupLayout(final long device, final BindGroupLayoutDescriptor descriptor) {
		try(var stack = Stack.get()) {
			var _device = device;
			var _descriptor = stack.alloc(descriptor);
			var ret = (long) wgpuDeviceCreateBindGroupLayout.invokeExact(_device, _descriptor);
			return ret;
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuDeviceCreateBuffer = lookup(JAVA_LONG, "wgpuDeviceCreateBuffer", JAVA_LONG, JAVA_LONG);
	public static long wgpuDeviceCreateBuffer(final long device, final BufferDescriptor descriptor) {
		try(var stack = Stack.get()) {
			var _device = device;
			var _descriptor = stack.alloc(descriptor);
			var ret = (long) wgpuDeviceCreateBuffer.invokeExact(_device, _descriptor);
			return ret;
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuDeviceCreateCommandEncoder = lookup(JAVA_LONG, "wgpuDeviceCreateCommandEncoder", JAVA_LONG, JAVA_LONG);
	public static long wgpuDeviceCreateCommandEncoder(final long device, @Nullable final CommandEncoderDescriptor descriptor) {
		try(var stack = Stack.get()) {
			var _device = device;
			var _descriptor = stack.alloc(descriptor);
			var ret = (long) wgpuDeviceCreateCommandEncoder.invokeExact(_device, _descriptor);
			return ret;
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuDeviceCreateComputePipeline = lookup(JAVA_LONG, "wgpuDeviceCreateComputePipeline", JAVA_LONG, JAVA_LONG);
	public static long wgpuDeviceCreateComputePipeline(final long device, final ComputePipelineDescriptor descriptor) {
		try(var stack = Stack.get()) {
			var _device = device;
			var _descriptor = stack.alloc(descriptor);
			var ret = (long) wgpuDeviceCreateComputePipeline.invokeExact(_device, _descriptor);
			return ret;
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuDeviceCreateComputePipelineAsync = lookup(null, "wgpuDeviceCreateComputePipelineAsync", JAVA_LONG, JAVA_LONG, ADDRESS, JAVA_LONG);
	public static void wgpuDeviceCreateComputePipelineAsync(final long device, final ComputePipelineDescriptor descriptor, final DeviceCreateComputePipelineAsyncCallback callback, final long userdata) {
		try(var stack = Stack.get()) {
			var _device = device;
			var _descriptor = stack.alloc(descriptor);
			var _callback = WGPUCallback.createStub(callback, callback.handle, callback.desc);
			var _userdata = (long) userdata;
			wgpuDeviceCreateComputePipelineAsync.invokeExact(_device, _descriptor, _callback, _userdata);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuDeviceCreatePipelineLayout = lookup(JAVA_LONG, "wgpuDeviceCreatePipelineLayout", JAVA_LONG, JAVA_LONG);
	public static long wgpuDeviceCreatePipelineLayout(final long device, final PipelineLayoutDescriptor descriptor) {
		try(var stack = Stack.get()) {
			var _device = device;
			var _descriptor = stack.alloc(descriptor);
			var ret = (long) wgpuDeviceCreatePipelineLayout.invokeExact(_device, _descriptor);
			return ret;
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuDeviceCreateQuerySet = lookup(JAVA_LONG, "wgpuDeviceCreateQuerySet", JAVA_LONG, JAVA_LONG);
	public static long wgpuDeviceCreateQuerySet(final long device, final QuerySetDescriptor descriptor) {
		try(var stack = Stack.get()) {
			var _device = device;
			var _descriptor = stack.alloc(descriptor);
			var ret = (long) wgpuDeviceCreateQuerySet.invokeExact(_device, _descriptor);
			return ret;
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuDeviceCreateRenderBundleEncoder = lookup(JAVA_LONG, "wgpuDeviceCreateRenderBundleEncoder", JAVA_LONG, JAVA_LONG);
	public static long wgpuDeviceCreateRenderBundleEncoder(final long device, final RenderBundleEncoderDescriptor descriptor) {
		try(var stack = Stack.get()) {
			var _device = device;
			var _descriptor = stack.alloc(descriptor);
			var ret = (long) wgpuDeviceCreateRenderBundleEncoder.invokeExact(_device, _descriptor);
			return ret;
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuDeviceCreateRenderPipeline = lookup(JAVA_LONG, "wgpuDeviceCreateRenderPipeline", JAVA_LONG, JAVA_LONG);
	public static long wgpuDeviceCreateRenderPipeline(final long device, final RenderPipelineDescriptor descriptor) {
		try(var stack = Stack.get()) {
			var _device = device;
			var _descriptor = stack.alloc(descriptor);
			var ret = (long) wgpuDeviceCreateRenderPipeline.invokeExact(_device, _descriptor);
			return ret;
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuDeviceCreateRenderPipelineAsync = lookup(null, "wgpuDeviceCreateRenderPipelineAsync", JAVA_LONG, JAVA_LONG, ADDRESS, JAVA_LONG);
	public static void wgpuDeviceCreateRenderPipelineAsync(final long device, final RenderPipelineDescriptor descriptor, final DeviceCreateRenderPipelineAsyncCallback callback, final long userdata) {
		try(var stack = Stack.get()) {
			var _device = device;
			var _descriptor = stack.alloc(descriptor);
			var _callback = WGPUCallback.createStub(callback, callback.handle, callback.desc);
			var _userdata = (long) userdata;
			wgpuDeviceCreateRenderPipelineAsync.invokeExact(_device, _descriptor, _callback, _userdata);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuDeviceCreateSampler = lookup(JAVA_LONG, "wgpuDeviceCreateSampler", JAVA_LONG, JAVA_LONG);
	public static long wgpuDeviceCreateSampler(final long device, @Nullable final SamplerDescriptor descriptor) {
		try(var stack = Stack.get()) {
			var _device = device;
			var _descriptor = stack.alloc(descriptor);
			var ret = (long) wgpuDeviceCreateSampler.invokeExact(_device, _descriptor);
			return ret;
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuDeviceCreateShaderModule = lookup(JAVA_LONG, "wgpuDeviceCreateShaderModule", JAVA_LONG, JAVA_LONG);
	public static long wgpuDeviceCreateShaderModule(final long device, final ShaderModuleDescriptor descriptor) {
		try(var stack = Stack.get()) {
			var _device = device;
			var _descriptor = stack.alloc(descriptor);
			var ret = (long) wgpuDeviceCreateShaderModule.invokeExact(_device, _descriptor);
			return ret;
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuDeviceCreateTexture = lookup(JAVA_LONG, "wgpuDeviceCreateTexture", JAVA_LONG, JAVA_LONG);
	public static long wgpuDeviceCreateTexture(final long device, final TextureDescriptor descriptor) {
		try(var stack = Stack.get()) {
			var _device = device;
			var _descriptor = stack.alloc(descriptor);
			var ret = (long) wgpuDeviceCreateTexture.invokeExact(_device, _descriptor);
			return ret;
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuDeviceDestroy = lookup(null, "wgpuDeviceDestroy", JAVA_LONG);
	public static void wgpuDeviceDestroy(final long device) {
		try(var stack = Stack.get()) {
			var _device = device;
			wgpuDeviceDestroy.invokeExact(_device);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuDeviceEnumerateFeatures = lookup(JAVA_LONG, "wgpuDeviceEnumerateFeatures", JAVA_LONG, JAVA_LONG);
	public static long wgpuDeviceEnumerateFeatures(final long device, FeatureName[] features) {
		try(var stack = Stack.get()) {
			var _device = device;
			var _features = stack.prealloc(features);
			var ret = (long) wgpuDeviceEnumerateFeatures.invokeExact(_device, _features);
			if(features != null) {
				for(int i=0; i<features.length; i++) {
					features[i] = FeatureName.from(get_int(_features + i*4));
				}
			}
			return ret;
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuDeviceGetLimits = lookup(JAVA_INT, "wgpuDeviceGetLimits", JAVA_LONG, JAVA_LONG);
	public static boolean wgpuDeviceGetLimits(final long device, SupportedLimits limits) {
		try(var stack = Stack.get()) {
			var _device = device;
			var _limits = stack.prealloc(limits);
			var ret = (int) wgpuDeviceGetLimits.invokeExact(_device, _limits);
			((WGPUStruct)limits).load(_limits);
			return ret != 0;
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuDeviceGetQueue = lookup(JAVA_LONG, "wgpuDeviceGetQueue", JAVA_LONG);
	public static long wgpuDeviceGetQueue(final long device) {
		try(var stack = Stack.get()) {
			var _device = device;
			var ret = (long) wgpuDeviceGetQueue.invokeExact(_device);
			return ret;
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuDeviceHasFeature = lookup(JAVA_INT, "wgpuDeviceHasFeature", JAVA_LONG, JAVA_INT);
	public static boolean wgpuDeviceHasFeature(final long device, final FeatureName feature) {
		try(var stack = Stack.get()) {
			var _device = device;
			var _feature = feature == null ? 0 : feature.bits;
			var ret = (int) wgpuDeviceHasFeature.invokeExact(_device, _feature);
			return ret != 0;
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuDevicePopErrorScope = lookup(null, "wgpuDevicePopErrorScope", JAVA_LONG, ADDRESS, JAVA_LONG);
	public static void wgpuDevicePopErrorScope(final long device, final ErrorCallback callback, final long userdata) {
		try(var stack = Stack.get()) {
			var _device = device;
			var _callback = WGPUCallback.createStub(callback, callback.handle, callback.desc);
			var _userdata = (long) userdata;
			wgpuDevicePopErrorScope.invokeExact(_device, _callback, _userdata);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuDevicePushErrorScope = lookup(null, "wgpuDevicePushErrorScope", JAVA_LONG, JAVA_INT);
	public static void wgpuDevicePushErrorScope(final long device, final ErrorFilter filter) {
		try(var stack = Stack.get()) {
			var _device = device;
			var _filter = filter == null ? 0 : filter.bits;
			wgpuDevicePushErrorScope.invokeExact(_device, _filter);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuDeviceSetLabel = lookup(null, "wgpuDeviceSetLabel", JAVA_LONG, JAVA_LONG);
	public static void wgpuDeviceSetLabel(final long device, final String label) {
		try(var stack = Stack.get()) {
			var _device = device;
			var _label = stack.alloc(label);
			wgpuDeviceSetLabel.invokeExact(_device, _label);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuDeviceReference = lookup(null, "wgpuDeviceReference", JAVA_LONG);
	public static void wgpuDeviceReference(final long device) {
		try(var stack = Stack.get()) {
			var _device = device;
			wgpuDeviceReference.invokeExact(_device);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuDeviceRelease = lookup(null, "wgpuDeviceRelease", JAVA_LONG);
	public static void wgpuDeviceRelease(final long device) {
		try(var stack = Stack.get()) {
			var _device = device;
			wgpuDeviceRelease.invokeExact(_device);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuInstanceCreateSurface = lookup(JAVA_LONG, "wgpuInstanceCreateSurface", JAVA_LONG, JAVA_LONG);
	public static long wgpuInstanceCreateSurface(final long instance, final SurfaceDescriptor descriptor) {
		try(var stack = Stack.get()) {
			var _instance = instance;
			var _descriptor = stack.alloc(descriptor);
			var ret = (long) wgpuInstanceCreateSurface.invokeExact(_instance, _descriptor);
			return ret;
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuInstanceHasWGSLLanguageFeature = lookup(JAVA_INT, "wgpuInstanceHasWGSLLanguageFeature", JAVA_LONG, JAVA_INT);
	public static boolean wgpuInstanceHasWGSLLanguageFeature(final long instance, final WGSLFeatureName feature) {
		try(var stack = Stack.get()) {
			var _instance = instance;
			var _feature = feature == null ? 0 : feature.bits;
			var ret = (int) wgpuInstanceHasWGSLLanguageFeature.invokeExact(_instance, _feature);
			return ret != 0;
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuInstanceProcessEvents = lookup(null, "wgpuInstanceProcessEvents", JAVA_LONG);
	public static void wgpuInstanceProcessEvents(final long instance) {
		try(var stack = Stack.get()) {
			var _instance = instance;
			wgpuInstanceProcessEvents.invokeExact(_instance);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuInstanceRequestAdapter = lookup(null, "wgpuInstanceRequestAdapter", JAVA_LONG, JAVA_LONG, ADDRESS, JAVA_LONG);
	public static void wgpuInstanceRequestAdapter(final long instance, @Nullable final RequestAdapterOptions options, final InstanceRequestAdapterCallback callback, final long userdata) {
		try(var stack = Stack.get()) {
			var _instance = instance;
			var _options = stack.alloc(options);
			var _callback = WGPUCallback.createStub(callback, callback.handle, callback.desc);
			var _userdata = (long) userdata;
			wgpuInstanceRequestAdapter.invokeExact(_instance, _options, _callback, _userdata);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuInstanceReference = lookup(null, "wgpuInstanceReference", JAVA_LONG);
	public static void wgpuInstanceReference(final long instance) {
		try(var stack = Stack.get()) {
			var _instance = instance;
			wgpuInstanceReference.invokeExact(_instance);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuInstanceRelease = lookup(null, "wgpuInstanceRelease", JAVA_LONG);
	public static void wgpuInstanceRelease(final long instance) {
		try(var stack = Stack.get()) {
			var _instance = instance;
			wgpuInstanceRelease.invokeExact(_instance);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuPipelineLayoutSetLabel = lookup(null, "wgpuPipelineLayoutSetLabel", JAVA_LONG, JAVA_LONG);
	public static void wgpuPipelineLayoutSetLabel(final long pipelineLayout, final String label) {
		try(var stack = Stack.get()) {
			var _pipelineLayout = pipelineLayout;
			var _label = stack.alloc(label);
			wgpuPipelineLayoutSetLabel.invokeExact(_pipelineLayout, _label);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuPipelineLayoutReference = lookup(null, "wgpuPipelineLayoutReference", JAVA_LONG);
	public static void wgpuPipelineLayoutReference(final long pipelineLayout) {
		try(var stack = Stack.get()) {
			var _pipelineLayout = pipelineLayout;
			wgpuPipelineLayoutReference.invokeExact(_pipelineLayout);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuPipelineLayoutRelease = lookup(null, "wgpuPipelineLayoutRelease", JAVA_LONG);
	public static void wgpuPipelineLayoutRelease(final long pipelineLayout) {
		try(var stack = Stack.get()) {
			var _pipelineLayout = pipelineLayout;
			wgpuPipelineLayoutRelease.invokeExact(_pipelineLayout);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuQuerySetDestroy = lookup(null, "wgpuQuerySetDestroy", JAVA_LONG);
	public static void wgpuQuerySetDestroy(final long querySet) {
		try(var stack = Stack.get()) {
			var _querySet = querySet;
			wgpuQuerySetDestroy.invokeExact(_querySet);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuQuerySetGetCount = lookup(JAVA_INT, "wgpuQuerySetGetCount", JAVA_LONG);
	public static int wgpuQuerySetGetCount(final long querySet) {
		try(var stack = Stack.get()) {
			var _querySet = querySet;
			var ret = (int) wgpuQuerySetGetCount.invokeExact(_querySet);
			return ret;
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuQuerySetGetType = lookup(JAVA_INT, "wgpuQuerySetGetType", JAVA_LONG);
	public static QueryType wgpuQuerySetGetType(final long querySet) {
		try(var stack = Stack.get()) {
			var _querySet = querySet;
			var ret = (int) wgpuQuerySetGetType.invokeExact(_querySet);
			return QueryType.from(ret);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuQuerySetSetLabel = lookup(null, "wgpuQuerySetSetLabel", JAVA_LONG, JAVA_LONG);
	public static void wgpuQuerySetSetLabel(final long querySet, final String label) {
		try(var stack = Stack.get()) {
			var _querySet = querySet;
			var _label = stack.alloc(label);
			wgpuQuerySetSetLabel.invokeExact(_querySet, _label);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuQuerySetReference = lookup(null, "wgpuQuerySetReference", JAVA_LONG);
	public static void wgpuQuerySetReference(final long querySet) {
		try(var stack = Stack.get()) {
			var _querySet = querySet;
			wgpuQuerySetReference.invokeExact(_querySet);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuQuerySetRelease = lookup(null, "wgpuQuerySetRelease", JAVA_LONG);
	public static void wgpuQuerySetRelease(final long querySet) {
		try(var stack = Stack.get()) {
			var _querySet = querySet;
			wgpuQuerySetRelease.invokeExact(_querySet);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuQueueOnSubmittedWorkDone = lookup(null, "wgpuQueueOnSubmittedWorkDone", JAVA_LONG, ADDRESS, JAVA_LONG);
	public static void wgpuQueueOnSubmittedWorkDone(final long queue, final QueueOnSubmittedWorkDoneCallback callback, final long userdata) {
		try(var stack = Stack.get()) {
			var _queue = queue;
			var _callback = WGPUCallback.createStub(callback, callback.handle, callback.desc);
			var _userdata = (long) userdata;
			wgpuQueueOnSubmittedWorkDone.invokeExact(_queue, _callback, _userdata);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuQueueSetLabel = lookup(null, "wgpuQueueSetLabel", JAVA_LONG, JAVA_LONG);
	public static void wgpuQueueSetLabel(final long queue, final String label) {
		try(var stack = Stack.get()) {
			var _queue = queue;
			var _label = stack.alloc(label);
			wgpuQueueSetLabel.invokeExact(_queue, _label);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuQueueSubmit = lookup(null, "wgpuQueueSubmit", JAVA_LONG, JAVA_LONG, JAVA_LONG);
	public static void wgpuQueueSubmit(final long queue, final WGPUCommandBuffer[] commands) {
		try(var stack = Stack.get()) {
			var _queue = queue;
			var _commandCount = (long) (commands == null ? 0 : commands.length);
			var _commands = stack.alloc(commands);
			wgpuQueueSubmit.invokeExact(_queue, _commandCount, _commands);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuQueueWriteBuffer = lookup(null, "wgpuQueueWriteBuffer", JAVA_LONG, JAVA_LONG, JAVA_LONG, ADDRESS, JAVA_LONG);
	public static void wgpuQueueWriteBuffer(final long queue, final long buffer, final long bufferOffset, final MemorySegment data) {
		try(var stack = Stack.get()) {
			var _queue = queue;
			var _buffer = buffer;
			var _bufferOffset = (long) bufferOffset;
			var _data = data;
			var _size = (long) (data == null ? 0 : data.byteSize());
			wgpuQueueWriteBuffer.invokeExact(_queue, _buffer, _bufferOffset, _data, _size);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuQueueWriteTexture = lookup(null, "wgpuQueueWriteTexture", JAVA_LONG, JAVA_LONG, ADDRESS, JAVA_LONG, JAVA_LONG, JAVA_LONG);
	public static void wgpuQueueWriteTexture(final long queue, final ImageCopyTexture destination, final MemorySegment data, final TextureDataLayout dataLayout, final Extent3D writeSize) {
		try(var stack = Stack.get()) {
			var _queue = queue;
			var _destination = stack.alloc(destination);
			var _data = data;
			var _dataSize = (long) (data == null ? 0 : data.byteSize());
			var _dataLayout = stack.alloc(dataLayout);
			var _writeSize = stack.alloc(writeSize);
			wgpuQueueWriteTexture.invokeExact(_queue, _destination, _data, _dataSize, _dataLayout, _writeSize);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuQueueReference = lookup(null, "wgpuQueueReference", JAVA_LONG);
	public static void wgpuQueueReference(final long queue) {
		try(var stack = Stack.get()) {
			var _queue = queue;
			wgpuQueueReference.invokeExact(_queue);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuQueueRelease = lookup(null, "wgpuQueueRelease", JAVA_LONG);
	public static void wgpuQueueRelease(final long queue) {
		try(var stack = Stack.get()) {
			var _queue = queue;
			wgpuQueueRelease.invokeExact(_queue);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderBundleSetLabel = lookup(null, "wgpuRenderBundleSetLabel", JAVA_LONG, JAVA_LONG);
	public static void wgpuRenderBundleSetLabel(final long renderBundle, final String label) {
		try(var stack = Stack.get()) {
			var _renderBundle = renderBundle;
			var _label = stack.alloc(label);
			wgpuRenderBundleSetLabel.invokeExact(_renderBundle, _label);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderBundleReference = lookup(null, "wgpuRenderBundleReference", JAVA_LONG);
	public static void wgpuRenderBundleReference(final long renderBundle) {
		try(var stack = Stack.get()) {
			var _renderBundle = renderBundle;
			wgpuRenderBundleReference.invokeExact(_renderBundle);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderBundleRelease = lookup(null, "wgpuRenderBundleRelease", JAVA_LONG);
	public static void wgpuRenderBundleRelease(final long renderBundle) {
		try(var stack = Stack.get()) {
			var _renderBundle = renderBundle;
			wgpuRenderBundleRelease.invokeExact(_renderBundle);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderBundleEncoderDraw = lookup(null, "wgpuRenderBundleEncoderDraw", JAVA_LONG, JAVA_INT, JAVA_INT, JAVA_INT, JAVA_INT);
	public static void wgpuRenderBundleEncoderDraw(final long renderBundleEncoder, final int vertexCount, final int instanceCount, final int firstVertex, final int firstInstance) {
		try(var stack = Stack.get()) {
			var _renderBundleEncoder = renderBundleEncoder;
			var _vertexCount = (int) vertexCount;
			var _instanceCount = (int) instanceCount;
			var _firstVertex = (int) firstVertex;
			var _firstInstance = (int) firstInstance;
			wgpuRenderBundleEncoderDraw.invokeExact(_renderBundleEncoder, _vertexCount, _instanceCount, _firstVertex, _firstInstance);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderBundleEncoderDrawIndexed = lookup(null, "wgpuRenderBundleEncoderDrawIndexed", JAVA_LONG, JAVA_INT, JAVA_INT, JAVA_INT, JAVA_INT, JAVA_INT);
	public static void wgpuRenderBundleEncoderDrawIndexed(final long renderBundleEncoder, final int indexCount, final int instanceCount, final int firstIndex, final int baseVertex, final int firstInstance) {
		try(var stack = Stack.get()) {
			var _renderBundleEncoder = renderBundleEncoder;
			var _indexCount = (int) indexCount;
			var _instanceCount = (int) instanceCount;
			var _firstIndex = (int) firstIndex;
			var _baseVertex = (int) baseVertex;
			var _firstInstance = (int) firstInstance;
			wgpuRenderBundleEncoderDrawIndexed.invokeExact(_renderBundleEncoder, _indexCount, _instanceCount, _firstIndex, _baseVertex, _firstInstance);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderBundleEncoderDrawIndexedIndirect = lookup(null, "wgpuRenderBundleEncoderDrawIndexedIndirect", JAVA_LONG, JAVA_LONG, JAVA_LONG);
	public static void wgpuRenderBundleEncoderDrawIndexedIndirect(final long renderBundleEncoder, final long indirectBuffer, final long indirectOffset) {
		try(var stack = Stack.get()) {
			var _renderBundleEncoder = renderBundleEncoder;
			var _indirectBuffer = indirectBuffer;
			var _indirectOffset = (long) indirectOffset;
			wgpuRenderBundleEncoderDrawIndexedIndirect.invokeExact(_renderBundleEncoder, _indirectBuffer, _indirectOffset);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderBundleEncoderDrawIndirect = lookup(null, "wgpuRenderBundleEncoderDrawIndirect", JAVA_LONG, JAVA_LONG, JAVA_LONG);
	public static void wgpuRenderBundleEncoderDrawIndirect(final long renderBundleEncoder, final long indirectBuffer, final long indirectOffset) {
		try(var stack = Stack.get()) {
			var _renderBundleEncoder = renderBundleEncoder;
			var _indirectBuffer = indirectBuffer;
			var _indirectOffset = (long) indirectOffset;
			wgpuRenderBundleEncoderDrawIndirect.invokeExact(_renderBundleEncoder, _indirectBuffer, _indirectOffset);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderBundleEncoderFinish = lookup(JAVA_LONG, "wgpuRenderBundleEncoderFinish", JAVA_LONG, JAVA_LONG);
	public static long wgpuRenderBundleEncoderFinish(final long renderBundleEncoder, @Nullable final RenderBundleDescriptor descriptor) {
		try(var stack = Stack.get()) {
			var _renderBundleEncoder = renderBundleEncoder;
			var _descriptor = stack.alloc(descriptor);
			var ret = (long) wgpuRenderBundleEncoderFinish.invokeExact(_renderBundleEncoder, _descriptor);
			return ret;
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderBundleEncoderInsertDebugMarker = lookup(null, "wgpuRenderBundleEncoderInsertDebugMarker", JAVA_LONG, JAVA_LONG);
	public static void wgpuRenderBundleEncoderInsertDebugMarker(final long renderBundleEncoder, final String markerLabel) {
		try(var stack = Stack.get()) {
			var _renderBundleEncoder = renderBundleEncoder;
			var _markerLabel = stack.alloc(markerLabel);
			wgpuRenderBundleEncoderInsertDebugMarker.invokeExact(_renderBundleEncoder, _markerLabel);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderBundleEncoderPopDebugGroup = lookup(null, "wgpuRenderBundleEncoderPopDebugGroup", JAVA_LONG);
	public static void wgpuRenderBundleEncoderPopDebugGroup(final long renderBundleEncoder) {
		try(var stack = Stack.get()) {
			var _renderBundleEncoder = renderBundleEncoder;
			wgpuRenderBundleEncoderPopDebugGroup.invokeExact(_renderBundleEncoder);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderBundleEncoderPushDebugGroup = lookup(null, "wgpuRenderBundleEncoderPushDebugGroup", JAVA_LONG, JAVA_LONG);
	public static void wgpuRenderBundleEncoderPushDebugGroup(final long renderBundleEncoder, final String groupLabel) {
		try(var stack = Stack.get()) {
			var _renderBundleEncoder = renderBundleEncoder;
			var _groupLabel = stack.alloc(groupLabel);
			wgpuRenderBundleEncoderPushDebugGroup.invokeExact(_renderBundleEncoder, _groupLabel);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderBundleEncoderSetBindGroup = lookup(null, "wgpuRenderBundleEncoderSetBindGroup", JAVA_LONG, JAVA_INT, JAVA_LONG, JAVA_LONG, JAVA_LONG);
	public static void wgpuRenderBundleEncoderSetBindGroup(final long renderBundleEncoder, final int groupIndex, @Nullable final long group, final int[] dynamicOffsets) {
		try(var stack = Stack.get()) {
			var _renderBundleEncoder = renderBundleEncoder;
			var _groupIndex = (int) groupIndex;
			var _group = group;
			var _dynamicOffsetCount = (long) (dynamicOffsets == null ? 0 : dynamicOffsets.length);
			var _dynamicOffsets = stack.alloc(dynamicOffsets);
			wgpuRenderBundleEncoderSetBindGroup.invokeExact(_renderBundleEncoder, _groupIndex, _group, _dynamicOffsetCount, _dynamicOffsets);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderBundleEncoderSetIndexBuffer = lookup(null, "wgpuRenderBundleEncoderSetIndexBuffer", JAVA_LONG, JAVA_LONG, JAVA_INT, JAVA_LONG, JAVA_LONG);
	public static void wgpuRenderBundleEncoderSetIndexBuffer(final long renderBundleEncoder, final long buffer, final IndexFormat format, final long offset, final long size) {
		try(var stack = Stack.get()) {
			var _renderBundleEncoder = renderBundleEncoder;
			var _buffer = buffer;
			var _format = format == null ? 0 : format.bits;
			var _offset = (long) offset;
			var _size = (long) size;
			wgpuRenderBundleEncoderSetIndexBuffer.invokeExact(_renderBundleEncoder, _buffer, _format, _offset, _size);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderBundleEncoderSetLabel = lookup(null, "wgpuRenderBundleEncoderSetLabel", JAVA_LONG, JAVA_LONG);
	public static void wgpuRenderBundleEncoderSetLabel(final long renderBundleEncoder, final String label) {
		try(var stack = Stack.get()) {
			var _renderBundleEncoder = renderBundleEncoder;
			var _label = stack.alloc(label);
			wgpuRenderBundleEncoderSetLabel.invokeExact(_renderBundleEncoder, _label);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderBundleEncoderSetPipeline = lookup(null, "wgpuRenderBundleEncoderSetPipeline", JAVA_LONG, JAVA_LONG);
	public static void wgpuRenderBundleEncoderSetPipeline(final long renderBundleEncoder, final long pipeline) {
		try(var stack = Stack.get()) {
			var _renderBundleEncoder = renderBundleEncoder;
			var _pipeline = pipeline;
			wgpuRenderBundleEncoderSetPipeline.invokeExact(_renderBundleEncoder, _pipeline);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderBundleEncoderSetVertexBuffer = lookup(null, "wgpuRenderBundleEncoderSetVertexBuffer", JAVA_LONG, JAVA_INT, JAVA_LONG, JAVA_LONG, JAVA_LONG);
	public static void wgpuRenderBundleEncoderSetVertexBuffer(final long renderBundleEncoder, final int slot, @Nullable final long buffer, final long offset, final long size) {
		try(var stack = Stack.get()) {
			var _renderBundleEncoder = renderBundleEncoder;
			var _slot = (int) slot;
			var _buffer = buffer;
			var _offset = (long) offset;
			var _size = (long) size;
			wgpuRenderBundleEncoderSetVertexBuffer.invokeExact(_renderBundleEncoder, _slot, _buffer, _offset, _size);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderBundleEncoderReference = lookup(null, "wgpuRenderBundleEncoderReference", JAVA_LONG);
	public static void wgpuRenderBundleEncoderReference(final long renderBundleEncoder) {
		try(var stack = Stack.get()) {
			var _renderBundleEncoder = renderBundleEncoder;
			wgpuRenderBundleEncoderReference.invokeExact(_renderBundleEncoder);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderBundleEncoderRelease = lookup(null, "wgpuRenderBundleEncoderRelease", JAVA_LONG);
	public static void wgpuRenderBundleEncoderRelease(final long renderBundleEncoder) {
		try(var stack = Stack.get()) {
			var _renderBundleEncoder = renderBundleEncoder;
			wgpuRenderBundleEncoderRelease.invokeExact(_renderBundleEncoder);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderPassEncoderBeginOcclusionQuery = lookup(null, "wgpuRenderPassEncoderBeginOcclusionQuery", JAVA_LONG, JAVA_INT);
	public static void wgpuRenderPassEncoderBeginOcclusionQuery(final long renderPassEncoder, final int queryIndex) {
		try(var stack = Stack.get()) {
			var _renderPassEncoder = renderPassEncoder;
			var _queryIndex = (int) queryIndex;
			wgpuRenderPassEncoderBeginOcclusionQuery.invokeExact(_renderPassEncoder, _queryIndex);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderPassEncoderDraw = lookup(null, "wgpuRenderPassEncoderDraw", JAVA_LONG, JAVA_INT, JAVA_INT, JAVA_INT, JAVA_INT);
	public static void wgpuRenderPassEncoderDraw(final long renderPassEncoder, final int vertexCount, final int instanceCount, final int firstVertex, final int firstInstance) {
		try(var stack = Stack.get()) {
			var _renderPassEncoder = renderPassEncoder;
			var _vertexCount = (int) vertexCount;
			var _instanceCount = (int) instanceCount;
			var _firstVertex = (int) firstVertex;
			var _firstInstance = (int) firstInstance;
			wgpuRenderPassEncoderDraw.invokeExact(_renderPassEncoder, _vertexCount, _instanceCount, _firstVertex, _firstInstance);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderPassEncoderDrawIndexed = lookup(null, "wgpuRenderPassEncoderDrawIndexed", JAVA_LONG, JAVA_INT, JAVA_INT, JAVA_INT, JAVA_INT, JAVA_INT);
	public static void wgpuRenderPassEncoderDrawIndexed(final long renderPassEncoder, final int indexCount, final int instanceCount, final int firstIndex, final int baseVertex, final int firstInstance) {
		try(var stack = Stack.get()) {
			var _renderPassEncoder = renderPassEncoder;
			var _indexCount = (int) indexCount;
			var _instanceCount = (int) instanceCount;
			var _firstIndex = (int) firstIndex;
			var _baseVertex = (int) baseVertex;
			var _firstInstance = (int) firstInstance;
			wgpuRenderPassEncoderDrawIndexed.invokeExact(_renderPassEncoder, _indexCount, _instanceCount, _firstIndex, _baseVertex, _firstInstance);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderPassEncoderDrawIndexedIndirect = lookup(null, "wgpuRenderPassEncoderDrawIndexedIndirect", JAVA_LONG, JAVA_LONG, JAVA_LONG);
	public static void wgpuRenderPassEncoderDrawIndexedIndirect(final long renderPassEncoder, final long indirectBuffer, final long indirectOffset) {
		try(var stack = Stack.get()) {
			var _renderPassEncoder = renderPassEncoder;
			var _indirectBuffer = indirectBuffer;
			var _indirectOffset = (long) indirectOffset;
			wgpuRenderPassEncoderDrawIndexedIndirect.invokeExact(_renderPassEncoder, _indirectBuffer, _indirectOffset);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderPassEncoderDrawIndirect = lookup(null, "wgpuRenderPassEncoderDrawIndirect", JAVA_LONG, JAVA_LONG, JAVA_LONG);
	public static void wgpuRenderPassEncoderDrawIndirect(final long renderPassEncoder, final long indirectBuffer, final long indirectOffset) {
		try(var stack = Stack.get()) {
			var _renderPassEncoder = renderPassEncoder;
			var _indirectBuffer = indirectBuffer;
			var _indirectOffset = (long) indirectOffset;
			wgpuRenderPassEncoderDrawIndirect.invokeExact(_renderPassEncoder, _indirectBuffer, _indirectOffset);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderPassEncoderEnd = lookup(null, "wgpuRenderPassEncoderEnd", JAVA_LONG);
	public static void wgpuRenderPassEncoderEnd(final long renderPassEncoder) {
		try(var stack = Stack.get()) {
			var _renderPassEncoder = renderPassEncoder;
			wgpuRenderPassEncoderEnd.invokeExact(_renderPassEncoder);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderPassEncoderEndOcclusionQuery = lookup(null, "wgpuRenderPassEncoderEndOcclusionQuery", JAVA_LONG);
	public static void wgpuRenderPassEncoderEndOcclusionQuery(final long renderPassEncoder) {
		try(var stack = Stack.get()) {
			var _renderPassEncoder = renderPassEncoder;
			wgpuRenderPassEncoderEndOcclusionQuery.invokeExact(_renderPassEncoder);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderPassEncoderExecuteBundles = lookup(null, "wgpuRenderPassEncoderExecuteBundles", JAVA_LONG, JAVA_LONG, JAVA_LONG);
	public static void wgpuRenderPassEncoderExecuteBundles(final long renderPassEncoder, final WGPURenderBundle[] bundles) {
		try(var stack = Stack.get()) {
			var _renderPassEncoder = renderPassEncoder;
			var _bundleCount = (long) (bundles == null ? 0 : bundles.length);
			var _bundles = stack.alloc(bundles);
			wgpuRenderPassEncoderExecuteBundles.invokeExact(_renderPassEncoder, _bundleCount, _bundles);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderPassEncoderInsertDebugMarker = lookup(null, "wgpuRenderPassEncoderInsertDebugMarker", JAVA_LONG, JAVA_LONG);
	public static void wgpuRenderPassEncoderInsertDebugMarker(final long renderPassEncoder, final String markerLabel) {
		try(var stack = Stack.get()) {
			var _renderPassEncoder = renderPassEncoder;
			var _markerLabel = stack.alloc(markerLabel);
			wgpuRenderPassEncoderInsertDebugMarker.invokeExact(_renderPassEncoder, _markerLabel);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderPassEncoderPopDebugGroup = lookup(null, "wgpuRenderPassEncoderPopDebugGroup", JAVA_LONG);
	public static void wgpuRenderPassEncoderPopDebugGroup(final long renderPassEncoder) {
		try(var stack = Stack.get()) {
			var _renderPassEncoder = renderPassEncoder;
			wgpuRenderPassEncoderPopDebugGroup.invokeExact(_renderPassEncoder);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderPassEncoderPushDebugGroup = lookup(null, "wgpuRenderPassEncoderPushDebugGroup", JAVA_LONG, JAVA_LONG);
	public static void wgpuRenderPassEncoderPushDebugGroup(final long renderPassEncoder, final String groupLabel) {
		try(var stack = Stack.get()) {
			var _renderPassEncoder = renderPassEncoder;
			var _groupLabel = stack.alloc(groupLabel);
			wgpuRenderPassEncoderPushDebugGroup.invokeExact(_renderPassEncoder, _groupLabel);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderPassEncoderSetBindGroup = lookup(null, "wgpuRenderPassEncoderSetBindGroup", JAVA_LONG, JAVA_INT, JAVA_LONG, JAVA_LONG, JAVA_LONG);
	public static void wgpuRenderPassEncoderSetBindGroup(final long renderPassEncoder, final int groupIndex, @Nullable final long group, final int[] dynamicOffsets) {
		try(var stack = Stack.get()) {
			var _renderPassEncoder = renderPassEncoder;
			var _groupIndex = (int) groupIndex;
			var _group = group;
			var _dynamicOffsetCount = (long) (dynamicOffsets == null ? 0 : dynamicOffsets.length);
			var _dynamicOffsets = stack.alloc(dynamicOffsets);
			wgpuRenderPassEncoderSetBindGroup.invokeExact(_renderPassEncoder, _groupIndex, _group, _dynamicOffsetCount, _dynamicOffsets);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderPassEncoderSetBlendConstant = lookup(null, "wgpuRenderPassEncoderSetBlendConstant", JAVA_LONG, JAVA_LONG);
	public static void wgpuRenderPassEncoderSetBlendConstant(final long renderPassEncoder, final Color color) {
		try(var stack = Stack.get()) {
			var _renderPassEncoder = renderPassEncoder;
			var _color = stack.alloc(color);
			wgpuRenderPassEncoderSetBlendConstant.invokeExact(_renderPassEncoder, _color);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderPassEncoderSetIndexBuffer = lookup(null, "wgpuRenderPassEncoderSetIndexBuffer", JAVA_LONG, JAVA_LONG, JAVA_INT, JAVA_LONG, JAVA_LONG);
	public static void wgpuRenderPassEncoderSetIndexBuffer(final long renderPassEncoder, final long buffer, final IndexFormat format, final long offset, final long size) {
		try(var stack = Stack.get()) {
			var _renderPassEncoder = renderPassEncoder;
			var _buffer = buffer;
			var _format = format == null ? 0 : format.bits;
			var _offset = (long) offset;
			var _size = (long) size;
			wgpuRenderPassEncoderSetIndexBuffer.invokeExact(_renderPassEncoder, _buffer, _format, _offset, _size);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderPassEncoderSetLabel = lookup(null, "wgpuRenderPassEncoderSetLabel", JAVA_LONG, JAVA_LONG);
	public static void wgpuRenderPassEncoderSetLabel(final long renderPassEncoder, final String label) {
		try(var stack = Stack.get()) {
			var _renderPassEncoder = renderPassEncoder;
			var _label = stack.alloc(label);
			wgpuRenderPassEncoderSetLabel.invokeExact(_renderPassEncoder, _label);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderPassEncoderSetPipeline = lookup(null, "wgpuRenderPassEncoderSetPipeline", JAVA_LONG, JAVA_LONG);
	public static void wgpuRenderPassEncoderSetPipeline(final long renderPassEncoder, final long pipeline) {
		try(var stack = Stack.get()) {
			var _renderPassEncoder = renderPassEncoder;
			var _pipeline = pipeline;
			wgpuRenderPassEncoderSetPipeline.invokeExact(_renderPassEncoder, _pipeline);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderPassEncoderSetScissorRect = lookup(null, "wgpuRenderPassEncoderSetScissorRect", JAVA_LONG, JAVA_INT, JAVA_INT, JAVA_INT, JAVA_INT);
	public static void wgpuRenderPassEncoderSetScissorRect(final long renderPassEncoder, final int x, final int y, final int width, final int height) {
		try(var stack = Stack.get()) {
			var _renderPassEncoder = renderPassEncoder;
			var _x = (int) x;
			var _y = (int) y;
			var _width = (int) width;
			var _height = (int) height;
			wgpuRenderPassEncoderSetScissorRect.invokeExact(_renderPassEncoder, _x, _y, _width, _height);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderPassEncoderSetStencilReference = lookup(null, "wgpuRenderPassEncoderSetStencilReference", JAVA_LONG, JAVA_INT);
	public static void wgpuRenderPassEncoderSetStencilReference(final long renderPassEncoder, final int reference) {
		try(var stack = Stack.get()) {
			var _renderPassEncoder = renderPassEncoder;
			var _reference = (int) reference;
			wgpuRenderPassEncoderSetStencilReference.invokeExact(_renderPassEncoder, _reference);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderPassEncoderSetVertexBuffer = lookup(null, "wgpuRenderPassEncoderSetVertexBuffer", JAVA_LONG, JAVA_INT, JAVA_LONG, JAVA_LONG, JAVA_LONG);
	public static void wgpuRenderPassEncoderSetVertexBuffer(final long renderPassEncoder, final int slot, @Nullable final long buffer, final long offset, final long size) {
		try(var stack = Stack.get()) {
			var _renderPassEncoder = renderPassEncoder;
			var _slot = (int) slot;
			var _buffer = buffer;
			var _offset = (long) offset;
			var _size = (long) size;
			wgpuRenderPassEncoderSetVertexBuffer.invokeExact(_renderPassEncoder, _slot, _buffer, _offset, _size);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderPassEncoderSetViewport = lookup(null, "wgpuRenderPassEncoderSetViewport", JAVA_LONG, JAVA_FLOAT, JAVA_FLOAT, JAVA_FLOAT, JAVA_FLOAT, JAVA_FLOAT, JAVA_FLOAT);
	public static void wgpuRenderPassEncoderSetViewport(final long renderPassEncoder, final float x, final float y, final float width, final float height, final float minDepth, final float maxDepth) {
		try(var stack = Stack.get()) {
			var _renderPassEncoder = renderPassEncoder;
			var _x = (float) x;
			var _y = (float) y;
			var _width = (float) width;
			var _height = (float) height;
			var _minDepth = (float) minDepth;
			var _maxDepth = (float) maxDepth;
			wgpuRenderPassEncoderSetViewport.invokeExact(_renderPassEncoder, _x, _y, _width, _height, _minDepth, _maxDepth);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderPassEncoderReference = lookup(null, "wgpuRenderPassEncoderReference", JAVA_LONG);
	public static void wgpuRenderPassEncoderReference(final long renderPassEncoder) {
		try(var stack = Stack.get()) {
			var _renderPassEncoder = renderPassEncoder;
			wgpuRenderPassEncoderReference.invokeExact(_renderPassEncoder);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderPassEncoderRelease = lookup(null, "wgpuRenderPassEncoderRelease", JAVA_LONG);
	public static void wgpuRenderPassEncoderRelease(final long renderPassEncoder) {
		try(var stack = Stack.get()) {
			var _renderPassEncoder = renderPassEncoder;
			wgpuRenderPassEncoderRelease.invokeExact(_renderPassEncoder);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderPipelineGetBindGroupLayout = lookup(JAVA_LONG, "wgpuRenderPipelineGetBindGroupLayout", JAVA_LONG, JAVA_INT);
	public static long wgpuRenderPipelineGetBindGroupLayout(final long renderPipeline, final int groupIndex) {
		try(var stack = Stack.get()) {
			var _renderPipeline = renderPipeline;
			var _groupIndex = (int) groupIndex;
			var ret = (long) wgpuRenderPipelineGetBindGroupLayout.invokeExact(_renderPipeline, _groupIndex);
			return ret;
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderPipelineSetLabel = lookup(null, "wgpuRenderPipelineSetLabel", JAVA_LONG, JAVA_LONG);
	public static void wgpuRenderPipelineSetLabel(final long renderPipeline, final String label) {
		try(var stack = Stack.get()) {
			var _renderPipeline = renderPipeline;
			var _label = stack.alloc(label);
			wgpuRenderPipelineSetLabel.invokeExact(_renderPipeline, _label);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderPipelineReference = lookup(null, "wgpuRenderPipelineReference", JAVA_LONG);
	public static void wgpuRenderPipelineReference(final long renderPipeline) {
		try(var stack = Stack.get()) {
			var _renderPipeline = renderPipeline;
			wgpuRenderPipelineReference.invokeExact(_renderPipeline);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderPipelineRelease = lookup(null, "wgpuRenderPipelineRelease", JAVA_LONG);
	public static void wgpuRenderPipelineRelease(final long renderPipeline) {
		try(var stack = Stack.get()) {
			var _renderPipeline = renderPipeline;
			wgpuRenderPipelineRelease.invokeExact(_renderPipeline);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuSamplerSetLabel = lookup(null, "wgpuSamplerSetLabel", JAVA_LONG, JAVA_LONG);
	public static void wgpuSamplerSetLabel(final long sampler, final String label) {
		try(var stack = Stack.get()) {
			var _sampler = sampler;
			var _label = stack.alloc(label);
			wgpuSamplerSetLabel.invokeExact(_sampler, _label);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuSamplerReference = lookup(null, "wgpuSamplerReference", JAVA_LONG);
	public static void wgpuSamplerReference(final long sampler) {
		try(var stack = Stack.get()) {
			var _sampler = sampler;
			wgpuSamplerReference.invokeExact(_sampler);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuSamplerRelease = lookup(null, "wgpuSamplerRelease", JAVA_LONG);
	public static void wgpuSamplerRelease(final long sampler) {
		try(var stack = Stack.get()) {
			var _sampler = sampler;
			wgpuSamplerRelease.invokeExact(_sampler);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuShaderModuleGetCompilationInfo = lookup(null, "wgpuShaderModuleGetCompilationInfo", JAVA_LONG, ADDRESS, JAVA_LONG);
	public static void wgpuShaderModuleGetCompilationInfo(final long shaderModule, final ShaderModuleGetCompilationInfoCallback callback, final long userdata) {
		try(var stack = Stack.get()) {
			var _shaderModule = shaderModule;
			var _callback = WGPUCallback.createStub(callback, callback.handle, callback.desc);
			var _userdata = (long) userdata;
			wgpuShaderModuleGetCompilationInfo.invokeExact(_shaderModule, _callback, _userdata);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuShaderModuleSetLabel = lookup(null, "wgpuShaderModuleSetLabel", JAVA_LONG, JAVA_LONG);
	public static void wgpuShaderModuleSetLabel(final long shaderModule, final String label) {
		try(var stack = Stack.get()) {
			var _shaderModule = shaderModule;
			var _label = stack.alloc(label);
			wgpuShaderModuleSetLabel.invokeExact(_shaderModule, _label);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuShaderModuleReference = lookup(null, "wgpuShaderModuleReference", JAVA_LONG);
	public static void wgpuShaderModuleReference(final long shaderModule) {
		try(var stack = Stack.get()) {
			var _shaderModule = shaderModule;
			wgpuShaderModuleReference.invokeExact(_shaderModule);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuShaderModuleRelease = lookup(null, "wgpuShaderModuleRelease", JAVA_LONG);
	public static void wgpuShaderModuleRelease(final long shaderModule) {
		try(var stack = Stack.get()) {
			var _shaderModule = shaderModule;
			wgpuShaderModuleRelease.invokeExact(_shaderModule);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuSurfaceConfigure = lookup(null, "wgpuSurfaceConfigure", JAVA_LONG, JAVA_LONG);
	public static void wgpuSurfaceConfigure(final long surface, final SurfaceConfiguration config) {
		try(var stack = Stack.get()) {
			var _surface = surface;
			var _config = stack.alloc(config);
			wgpuSurfaceConfigure.invokeExact(_surface, _config);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuSurfaceGetCapabilities = lookup(null, "wgpuSurfaceGetCapabilities", JAVA_LONG, JAVA_LONG, JAVA_LONG);
	public static void wgpuSurfaceGetCapabilities(final long surface, final long adapter, SurfaceCapabilities capabilities) {
		try(var stack = Stack.get()) {
			var _surface = surface;
			var _adapter = adapter;
			var _capabilities = stack.prealloc(capabilities);
			wgpuSurfaceGetCapabilities.invokeExact(_surface, _adapter, _capabilities);
			((WGPUStruct)capabilities).load(_capabilities);
			wgpuSurfaceCapabilitiesFreeMembers.invoke(wrap(_capabilities, 64));
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuSurfaceGetCurrentTexture = lookup(null, "wgpuSurfaceGetCurrentTexture", JAVA_LONG, JAVA_LONG);
	public static void wgpuSurfaceGetCurrentTexture(final long surface, SurfaceTexture surfaceTexture) {
		try(var stack = Stack.get()) {
			var _surface = surface;
			var _surfaceTexture = stack.prealloc(surfaceTexture);
			wgpuSurfaceGetCurrentTexture.invokeExact(_surface, _surfaceTexture);
			((WGPUStruct)surfaceTexture).load(_surfaceTexture);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuSurfacePresent = lookup(null, "wgpuSurfacePresent", JAVA_LONG);
	public static void wgpuSurfacePresent(final long surface) {
		try(var stack = Stack.get()) {
			var _surface = surface;
			wgpuSurfacePresent.invokeExact(_surface);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuSurfaceSetLabel = lookup(null, "wgpuSurfaceSetLabel", JAVA_LONG, JAVA_LONG);
	public static void wgpuSurfaceSetLabel(final long surface, final String label) {
		try(var stack = Stack.get()) {
			var _surface = surface;
			var _label = stack.alloc(label);
			wgpuSurfaceSetLabel.invokeExact(_surface, _label);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuSurfaceUnconfigure = lookup(null, "wgpuSurfaceUnconfigure", JAVA_LONG);
	public static void wgpuSurfaceUnconfigure(final long surface) {
		try(var stack = Stack.get()) {
			var _surface = surface;
			wgpuSurfaceUnconfigure.invokeExact(_surface);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuSurfaceReference = lookup(null, "wgpuSurfaceReference", JAVA_LONG);
	public static void wgpuSurfaceReference(final long surface) {
		try(var stack = Stack.get()) {
			var _surface = surface;
			wgpuSurfaceReference.invokeExact(_surface);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuSurfaceRelease = lookup(null, "wgpuSurfaceRelease", JAVA_LONG);
	public static void wgpuSurfaceRelease(final long surface) {
		try(var stack = Stack.get()) {
			var _surface = surface;
			wgpuSurfaceRelease.invokeExact(_surface);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuSurfaceCapabilitiesFreeMembers = lookup(null, "wgpuSurfaceCapabilitiesFreeMembers", STRUCT(64));

	private static final MethodHandle wgpuTextureCreateView = lookup(JAVA_LONG, "wgpuTextureCreateView", JAVA_LONG, JAVA_LONG);
	public static long wgpuTextureCreateView(final long texture, @Nullable final TextureViewDescriptor descriptor) {
		try(var stack = Stack.get()) {
			var _texture = texture;
			var _descriptor = stack.alloc(descriptor);
			var ret = (long) wgpuTextureCreateView.invokeExact(_texture, _descriptor);
			return ret;
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuTextureDestroy = lookup(null, "wgpuTextureDestroy", JAVA_LONG);
	public static void wgpuTextureDestroy(final long texture) {
		try(var stack = Stack.get()) {
			var _texture = texture;
			wgpuTextureDestroy.invokeExact(_texture);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuTextureGetDepthOrArrayLayers = lookup(JAVA_INT, "wgpuTextureGetDepthOrArrayLayers", JAVA_LONG);
	public static int wgpuTextureGetDepthOrArrayLayers(final long texture) {
		try(var stack = Stack.get()) {
			var _texture = texture;
			var ret = (int) wgpuTextureGetDepthOrArrayLayers.invokeExact(_texture);
			return ret;
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuTextureGetDimension = lookup(JAVA_INT, "wgpuTextureGetDimension", JAVA_LONG);
	public static TextureDimension wgpuTextureGetDimension(final long texture) {
		try(var stack = Stack.get()) {
			var _texture = texture;
			var ret = (int) wgpuTextureGetDimension.invokeExact(_texture);
			return TextureDimension.from(ret);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuTextureGetFormat = lookup(JAVA_INT, "wgpuTextureGetFormat", JAVA_LONG);
	public static TextureFormat wgpuTextureGetFormat(final long texture) {
		try(var stack = Stack.get()) {
			var _texture = texture;
			var ret = (int) wgpuTextureGetFormat.invokeExact(_texture);
			return TextureFormat.from(ret);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuTextureGetHeight = lookup(JAVA_INT, "wgpuTextureGetHeight", JAVA_LONG);
	public static int wgpuTextureGetHeight(final long texture) {
		try(var stack = Stack.get()) {
			var _texture = texture;
			var ret = (int) wgpuTextureGetHeight.invokeExact(_texture);
			return ret;
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuTextureGetMipLevelCount = lookup(JAVA_INT, "wgpuTextureGetMipLevelCount", JAVA_LONG);
	public static int wgpuTextureGetMipLevelCount(final long texture) {
		try(var stack = Stack.get()) {
			var _texture = texture;
			var ret = (int) wgpuTextureGetMipLevelCount.invokeExact(_texture);
			return ret;
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuTextureGetSampleCount = lookup(JAVA_INT, "wgpuTextureGetSampleCount", JAVA_LONG);
	public static int wgpuTextureGetSampleCount(final long texture) {
		try(var stack = Stack.get()) {
			var _texture = texture;
			var ret = (int) wgpuTextureGetSampleCount.invokeExact(_texture);
			return ret;
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuTextureGetUsage = lookup(JAVA_INT, "wgpuTextureGetUsage", JAVA_LONG);
	public static int wgpuTextureGetUsage(final long texture) {
		try(var stack = Stack.get()) {
			var _texture = texture;
			var ret = (int) wgpuTextureGetUsage.invokeExact(_texture);
			return ret;
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuTextureGetWidth = lookup(JAVA_INT, "wgpuTextureGetWidth", JAVA_LONG);
	public static int wgpuTextureGetWidth(final long texture) {
		try(var stack = Stack.get()) {
			var _texture = texture;
			var ret = (int) wgpuTextureGetWidth.invokeExact(_texture);
			return ret;
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuTextureSetLabel = lookup(null, "wgpuTextureSetLabel", JAVA_LONG, JAVA_LONG);
	public static void wgpuTextureSetLabel(final long texture, final String label) {
		try(var stack = Stack.get()) {
			var _texture = texture;
			var _label = stack.alloc(label);
			wgpuTextureSetLabel.invokeExact(_texture, _label);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuTextureReference = lookup(null, "wgpuTextureReference", JAVA_LONG);
	public static void wgpuTextureReference(final long texture) {
		try(var stack = Stack.get()) {
			var _texture = texture;
			wgpuTextureReference.invokeExact(_texture);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuTextureRelease = lookup(null, "wgpuTextureRelease", JAVA_LONG);
	public static void wgpuTextureRelease(final long texture) {
		try(var stack = Stack.get()) {
			var _texture = texture;
			wgpuTextureRelease.invokeExact(_texture);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuTextureViewSetLabel = lookup(null, "wgpuTextureViewSetLabel", JAVA_LONG, JAVA_LONG);
	public static void wgpuTextureViewSetLabel(final long textureView, final String label) {
		try(var stack = Stack.get()) {
			var _textureView = textureView;
			var _label = stack.alloc(label);
			wgpuTextureViewSetLabel.invokeExact(_textureView, _label);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuTextureViewReference = lookup(null, "wgpuTextureViewReference", JAVA_LONG);
	public static void wgpuTextureViewReference(final long textureView) {
		try(var stack = Stack.get()) {
			var _textureView = textureView;
			wgpuTextureViewReference.invokeExact(_textureView);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuTextureViewRelease = lookup(null, "wgpuTextureViewRelease", JAVA_LONG);
	public static void wgpuTextureViewRelease(final long textureView) {
		try(var stack = Stack.get()) {
			var _textureView = textureView;
			wgpuTextureViewRelease.invokeExact(_textureView);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuGenerateReport = lookup(null, "wgpuGenerateReport", JAVA_LONG, JAVA_LONG);
	public static void wgpuGenerateReport(final long instance, GlobalReport report) {
		try(var stack = Stack.get()) {
			var _instance = instance;
			var _report = stack.prealloc(report);
			wgpuGenerateReport.invokeExact(_instance, _report);
			((WGPUStruct)report).load(_report);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuInstanceEnumerateAdapters = lookup(JAVA_LONG, "wgpuInstanceEnumerateAdapters", JAVA_LONG, JAVA_LONG, JAVA_LONG);
	public static long wgpuInstanceEnumerateAdapters(final long instance, @Nullable final InstanceEnumerateAdapterOptions options, WGPUAdapter[] adapters) {
		try(var stack = Stack.get()) {
			var _instance = instance;
			var _options = stack.alloc(options);
			var _adapters = stack.prealloc(adapters);
			var ret = (long) wgpuInstanceEnumerateAdapters.invokeExact(_instance, _options, _adapters);
			if(adapters != null) {
				for(int i=0; i<adapters.length; i++) {
					adapters[i] = new WGPUAdapter(get_long(_adapters + i*8));
				}
			}
			return ret;
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuQueueSubmitForIndex = lookup(JAVA_LONG, "wgpuQueueSubmitForIndex", JAVA_LONG, JAVA_LONG, JAVA_LONG);
	public static long wgpuQueueSubmitForIndex(final long queue, final WGPUCommandBuffer[] commands) {
		try(var stack = Stack.get()) {
			var _queue = queue;
			var _commandCount = (long) (commands == null ? 0 : commands.length);
			var _commands = stack.alloc(commands);
			var ret = (long) wgpuQueueSubmitForIndex.invokeExact(_queue, _commandCount, _commands);
			return ret;
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuDevicePoll = lookup(JAVA_INT, "wgpuDevicePoll", JAVA_LONG, JAVA_INT, JAVA_LONG);
	public static boolean wgpuDevicePoll(final long device, final boolean wait, @Nullable final WrappedSubmissionIndex wrappedSubmissionIndex) {
		try(var stack = Stack.get()) {
			var _device = device;
			var _wait = (int) (wait ? 1 : 0);
			var _wrappedSubmissionIndex = stack.alloc(wrappedSubmissionIndex);
			var ret = (int) wgpuDevicePoll.invokeExact(_device, _wait, _wrappedSubmissionIndex);
			return ret != 0;
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuSetLogCallback = lookup(null, "wgpuSetLogCallback", ADDRESS, JAVA_LONG);
	public static void wgpuSetLogCallback(final LogCallback callback, final long userdata) {
		try(var stack = Stack.get()) {
			var _callback = WGPUCallback.createStub(callback, callback.handle, callback.desc);
			var _userdata = (long) userdata;
			wgpuSetLogCallback.invokeExact(_callback, _userdata);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuSetLogLevel = lookup(null, "wgpuSetLogLevel", JAVA_INT);
	public static void wgpuSetLogLevel(final LogLevel level) {
		try(var stack = Stack.get()) {
			var _level = level == null ? 0 : level.bits;
			wgpuSetLogLevel.invokeExact(_level);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuGetVersion = lookup(JAVA_INT, "wgpuGetVersion");
	public static int wgpuGetVersion() {
		try(var stack = Stack.get()) {
			var ret = (int) wgpuGetVersion.invokeExact();
			return ret;
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderPassEncoderSetPushConstants = lookup(null, "wgpuRenderPassEncoderSetPushConstants", JAVA_LONG, JAVA_INT, JAVA_INT, JAVA_INT, ADDRESS);
	public static void wgpuRenderPassEncoderSetPushConstants(final long encoder, final int stages, final int offset, final int sizeBytes, final MemorySegment data) {
		try(var stack = Stack.get()) {
			var _encoder = encoder;
			var _stages = (int) stages;
			var _offset = (int) offset;
			var _sizeBytes = (int) sizeBytes;
			var _data = data;
			wgpuRenderPassEncoderSetPushConstants.invokeExact(_encoder, _stages, _offset, _sizeBytes, _data);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderPassEncoderMultiDrawIndirect = lookup(null, "wgpuRenderPassEncoderMultiDrawIndirect", JAVA_LONG, JAVA_LONG, JAVA_LONG, JAVA_INT);
	public static void wgpuRenderPassEncoderMultiDrawIndirect(final long encoder, final long buffer, final long offset, final int count) {
		try(var stack = Stack.get()) {
			var _encoder = encoder;
			var _buffer = buffer;
			var _offset = (long) offset;
			var _count = (int) count;
			wgpuRenderPassEncoderMultiDrawIndirect.invokeExact(_encoder, _buffer, _offset, _count);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderPassEncoderMultiDrawIndexedIndirect = lookup(null, "wgpuRenderPassEncoderMultiDrawIndexedIndirect", JAVA_LONG, JAVA_LONG, JAVA_LONG, JAVA_INT);
	public static void wgpuRenderPassEncoderMultiDrawIndexedIndirect(final long encoder, final long buffer, final long offset, final int count) {
		try(var stack = Stack.get()) {
			var _encoder = encoder;
			var _buffer = buffer;
			var _offset = (long) offset;
			var _count = (int) count;
			wgpuRenderPassEncoderMultiDrawIndexedIndirect.invokeExact(_encoder, _buffer, _offset, _count);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderPassEncoderMultiDrawIndirectCount = lookup(null, "wgpuRenderPassEncoderMultiDrawIndirectCount", JAVA_LONG, JAVA_LONG, JAVA_LONG, JAVA_LONG, JAVA_LONG, JAVA_INT);
	public static void wgpuRenderPassEncoderMultiDrawIndirectCount(final long encoder, final long buffer, final long offset, final long count_buffer, final long count_buffer_offset, final int max_count) {
		try(var stack = Stack.get()) {
			var _encoder = encoder;
			var _buffer = buffer;
			var _offset = (long) offset;
			var _count_buffer = count_buffer;
			var _count_buffer_offset = (long) count_buffer_offset;
			var _max_count = (int) max_count;
			wgpuRenderPassEncoderMultiDrawIndirectCount.invokeExact(_encoder, _buffer, _offset, _count_buffer, _count_buffer_offset, _max_count);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderPassEncoderMultiDrawIndexedIndirectCount = lookup(null, "wgpuRenderPassEncoderMultiDrawIndexedIndirectCount", JAVA_LONG, JAVA_LONG, JAVA_LONG, JAVA_LONG, JAVA_LONG, JAVA_INT);
	public static void wgpuRenderPassEncoderMultiDrawIndexedIndirectCount(final long encoder, final long buffer, final long offset, final long count_buffer, final long count_buffer_offset, final int max_count) {
		try(var stack = Stack.get()) {
			var _encoder = encoder;
			var _buffer = buffer;
			var _offset = (long) offset;
			var _count_buffer = count_buffer;
			var _count_buffer_offset = (long) count_buffer_offset;
			var _max_count = (int) max_count;
			wgpuRenderPassEncoderMultiDrawIndexedIndirectCount.invokeExact(_encoder, _buffer, _offset, _count_buffer, _count_buffer_offset, _max_count);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuComputePassEncoderBeginPipelineStatisticsQuery = lookup(null, "wgpuComputePassEncoderBeginPipelineStatisticsQuery", JAVA_LONG, JAVA_LONG, JAVA_INT);
	public static void wgpuComputePassEncoderBeginPipelineStatisticsQuery(final long computePassEncoder, final long querySet, final int queryIndex) {
		try(var stack = Stack.get()) {
			var _computePassEncoder = computePassEncoder;
			var _querySet = querySet;
			var _queryIndex = (int) queryIndex;
			wgpuComputePassEncoderBeginPipelineStatisticsQuery.invokeExact(_computePassEncoder, _querySet, _queryIndex);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuComputePassEncoderEndPipelineStatisticsQuery = lookup(null, "wgpuComputePassEncoderEndPipelineStatisticsQuery", JAVA_LONG);
	public static void wgpuComputePassEncoderEndPipelineStatisticsQuery(final long computePassEncoder) {
		try(var stack = Stack.get()) {
			var _computePassEncoder = computePassEncoder;
			wgpuComputePassEncoderEndPipelineStatisticsQuery.invokeExact(_computePassEncoder);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderPassEncoderBeginPipelineStatisticsQuery = lookup(null, "wgpuRenderPassEncoderBeginPipelineStatisticsQuery", JAVA_LONG, JAVA_LONG, JAVA_INT);
	public static void wgpuRenderPassEncoderBeginPipelineStatisticsQuery(final long renderPassEncoder, final long querySet, final int queryIndex) {
		try(var stack = Stack.get()) {
			var _renderPassEncoder = renderPassEncoder;
			var _querySet = querySet;
			var _queryIndex = (int) queryIndex;
			wgpuRenderPassEncoderBeginPipelineStatisticsQuery.invokeExact(_renderPassEncoder, _querySet, _queryIndex);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderPassEncoderEndPipelineStatisticsQuery = lookup(null, "wgpuRenderPassEncoderEndPipelineStatisticsQuery", JAVA_LONG);
	public static void wgpuRenderPassEncoderEndPipelineStatisticsQuery(final long renderPassEncoder) {
		try(var stack = Stack.get()) {
			var _renderPassEncoder = renderPassEncoder;
			wgpuRenderPassEncoderEndPipelineStatisticsQuery.invokeExact(_renderPassEncoder);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

}
