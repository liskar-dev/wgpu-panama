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
	public static WGPUInstance wgpuCreateInstance(@Nullable final InstanceDescriptor descriptor) {
		try(var stack = Stack.get()) {
			var _descriptor = stack.alloc(descriptor);
			var ret = (long) wgpuCreateInstance.invoke(_descriptor);
			return ret == 0L ? null : new WGPUInstance(ret);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuGetProcAddress = lookup(ADDRESS, "wgpuGetProcAddress", JAVA_LONG, JAVA_LONG);
	public static long wgpuGetProcAddress(final WGPUDevice device, final String procName) {
		try(var stack = Stack.get()) {
			var _device = device == null ? 0L : device.handle;
			var _procName = stack.alloc(procName);
			var ret = (long) wgpuGetProcAddress.invoke(_device, _procName);
			return ret;
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuAdapterEnumerateFeatures = lookup(JAVA_LONG, "wgpuAdapterEnumerateFeatures", JAVA_LONG, JAVA_LONG);
	public static long wgpuAdapterEnumerateFeatures(final WGPUAdapter adapter, FeatureName[] features) {
		try(var stack = Stack.get()) {
			var _adapter = adapter == null ? 0L : adapter.handle;
			var _features = stack.prealloc(features);
			var ret = (long) wgpuAdapterEnumerateFeatures.invoke(_adapter, _features);
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
	public static void wgpuAdapterGetInfo(final WGPUAdapter adapter, AdapterInfo info) {
		try(var stack = Stack.get()) {
			var _adapter = adapter == null ? 0L : adapter.handle;
			var _info = stack.prealloc(info);
			wgpuAdapterGetInfo.invoke(_adapter, _info);
			((WGPUStruct)info).load(_info);
			wgpuAdapterInfoFreeMembers.invoke(wrap(_info, 56));
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuAdapterGetLimits = lookup(JAVA_INT, "wgpuAdapterGetLimits", JAVA_LONG, JAVA_LONG);
	public static boolean wgpuAdapterGetLimits(final WGPUAdapter adapter, SupportedLimits limits) {
		try(var stack = Stack.get()) {
			var _adapter = adapter == null ? 0L : adapter.handle;
			var _limits = stack.prealloc(limits);
			var ret = (int) wgpuAdapterGetLimits.invoke(_adapter, _limits);
			((WGPUStruct)limits).load(_limits);
			return ret != 0;
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuAdapterHasFeature = lookup(JAVA_INT, "wgpuAdapterHasFeature", JAVA_LONG, JAVA_INT);
	public static boolean wgpuAdapterHasFeature(final WGPUAdapter adapter, final FeatureName feature) {
		try(var stack = Stack.get()) {
			var _adapter = adapter == null ? 0L : adapter.handle;
			var _feature = feature == null ? 0 : feature.bits;
			var ret = (int) wgpuAdapterHasFeature.invoke(_adapter, _feature);
			return ret != 0;
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuAdapterRequestDevice = lookup(null, "wgpuAdapterRequestDevice", JAVA_LONG, JAVA_LONG, ADDRESS, JAVA_LONG);
	public static void wgpuAdapterRequestDevice(final WGPUAdapter adapter, @Nullable final DeviceDescriptor descriptor, final AdapterRequestDeviceCallback callback, final long userdata) {
		try(var stack = Stack.get()) {
			var _adapter = adapter == null ? 0L : adapter.handle;
			var _descriptor = stack.alloc(descriptor);
			var _callback = WGPUCallback.createStub(callback, callback.handle, callback.desc);
			var _userdata = (long) userdata;
			wgpuAdapterRequestDevice.invoke(_adapter, _descriptor, _callback, _userdata);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuAdapterReference = lookup(null, "wgpuAdapterReference", JAVA_LONG);
	public static void wgpuAdapterReference(final WGPUAdapter adapter) {
		try(var stack = Stack.get()) {
			var _adapter = adapter == null ? 0L : adapter.handle;
			wgpuAdapterReference.invoke(_adapter);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuAdapterRelease = lookup(null, "wgpuAdapterRelease", JAVA_LONG);
	public static void wgpuAdapterRelease(final WGPUAdapter adapter) {
		try(var stack = Stack.get()) {
			var _adapter = adapter == null ? 0L : adapter.handle;
			wgpuAdapterRelease.invoke(_adapter);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuAdapterInfoFreeMembers = lookup(null, "wgpuAdapterInfoFreeMembers", STRUCT(56));

	private static final MethodHandle wgpuBindGroupSetLabel = lookup(null, "wgpuBindGroupSetLabel", JAVA_LONG, JAVA_LONG);
	public static void wgpuBindGroupSetLabel(final WGPUBindGroup bindGroup, final String label) {
		try(var stack = Stack.get()) {
			var _bindGroup = bindGroup == null ? 0L : bindGroup.handle;
			var _label = stack.alloc(label);
			wgpuBindGroupSetLabel.invoke(_bindGroup, _label);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuBindGroupReference = lookup(null, "wgpuBindGroupReference", JAVA_LONG);
	public static void wgpuBindGroupReference(final WGPUBindGroup bindGroup) {
		try(var stack = Stack.get()) {
			var _bindGroup = bindGroup == null ? 0L : bindGroup.handle;
			wgpuBindGroupReference.invoke(_bindGroup);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuBindGroupRelease = lookup(null, "wgpuBindGroupRelease", JAVA_LONG);
	public static void wgpuBindGroupRelease(final WGPUBindGroup bindGroup) {
		try(var stack = Stack.get()) {
			var _bindGroup = bindGroup == null ? 0L : bindGroup.handle;
			wgpuBindGroupRelease.invoke(_bindGroup);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuBindGroupLayoutSetLabel = lookup(null, "wgpuBindGroupLayoutSetLabel", JAVA_LONG, JAVA_LONG);
	public static void wgpuBindGroupLayoutSetLabel(final WGPUBindGroupLayout bindGroupLayout, final String label) {
		try(var stack = Stack.get()) {
			var _bindGroupLayout = bindGroupLayout == null ? 0L : bindGroupLayout.handle;
			var _label = stack.alloc(label);
			wgpuBindGroupLayoutSetLabel.invoke(_bindGroupLayout, _label);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuBindGroupLayoutReference = lookup(null, "wgpuBindGroupLayoutReference", JAVA_LONG);
	public static void wgpuBindGroupLayoutReference(final WGPUBindGroupLayout bindGroupLayout) {
		try(var stack = Stack.get()) {
			var _bindGroupLayout = bindGroupLayout == null ? 0L : bindGroupLayout.handle;
			wgpuBindGroupLayoutReference.invoke(_bindGroupLayout);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuBindGroupLayoutRelease = lookup(null, "wgpuBindGroupLayoutRelease", JAVA_LONG);
	public static void wgpuBindGroupLayoutRelease(final WGPUBindGroupLayout bindGroupLayout) {
		try(var stack = Stack.get()) {
			var _bindGroupLayout = bindGroupLayout == null ? 0L : bindGroupLayout.handle;
			wgpuBindGroupLayoutRelease.invoke(_bindGroupLayout);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuBufferDestroy = lookup(null, "wgpuBufferDestroy", JAVA_LONG);
	public static void wgpuBufferDestroy(final WGPUBuffer buffer) {
		try(var stack = Stack.get()) {
			var _buffer = buffer == null ? 0L : buffer.handle;
			wgpuBufferDestroy.invoke(_buffer);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuBufferGetConstMappedRange = lookup(POINTER, "wgpuBufferGetConstMappedRange", JAVA_LONG, JAVA_LONG, JAVA_LONG);
	public static void wgpuBufferGetConstMappedRange(final WGPUBuffer buffer, final long offset, final long size) {
		try(var stack = Stack.get()) {
			var _buffer = buffer == null ? 0L : buffer.handle;
			var _offset = (long) offset;
			var _size = (long) size;
			var ret = (long) wgpuBufferGetConstMappedRange.invoke(_buffer, _offset, _size);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuBufferGetMapState = lookup(JAVA_INT, "wgpuBufferGetMapState", JAVA_LONG);
	public static BufferMapState wgpuBufferGetMapState(final WGPUBuffer buffer) {
		try(var stack = Stack.get()) {
			var _buffer = buffer == null ? 0L : buffer.handle;
			var ret = (int) wgpuBufferGetMapState.invoke(_buffer);
			return BufferMapState.from(ret);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuBufferGetMappedRange = lookup(POINTER, "wgpuBufferGetMappedRange", JAVA_LONG, JAVA_LONG, JAVA_LONG);
	public static void wgpuBufferGetMappedRange(final WGPUBuffer buffer, final long offset, final long size) {
		try(var stack = Stack.get()) {
			var _buffer = buffer == null ? 0L : buffer.handle;
			var _offset = (long) offset;
			var _size = (long) size;
			var ret = (long) wgpuBufferGetMappedRange.invoke(_buffer, _offset, _size);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuBufferGetSize = lookup(JAVA_LONG, "wgpuBufferGetSize", JAVA_LONG);
	public static long wgpuBufferGetSize(final WGPUBuffer buffer) {
		try(var stack = Stack.get()) {
			var _buffer = buffer == null ? 0L : buffer.handle;
			var ret = (long) wgpuBufferGetSize.invoke(_buffer);
			return ret;
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuBufferGetUsage = lookup(JAVA_INT, "wgpuBufferGetUsage", JAVA_LONG);
	public static int wgpuBufferGetUsage(final WGPUBuffer buffer) {
		try(var stack = Stack.get()) {
			var _buffer = buffer == null ? 0L : buffer.handle;
			var ret = (int) wgpuBufferGetUsage.invoke(_buffer);
			return ret;
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuBufferMapAsync = lookup(null, "wgpuBufferMapAsync", JAVA_LONG, JAVA_INT, JAVA_LONG, JAVA_LONG, ADDRESS, JAVA_LONG);
	public static void wgpuBufferMapAsync(final WGPUBuffer buffer, final int mode, final long offset, final long size, final BufferMapAsyncCallback callback, final long userdata) {
		try(var stack = Stack.get()) {
			var _buffer = buffer == null ? 0L : buffer.handle;
			var _mode = (int) mode;
			var _offset = (long) offset;
			var _size = (long) size;
			var _callback = WGPUCallback.createStub(callback, callback.handle, callback.desc);
			var _userdata = (long) userdata;
			wgpuBufferMapAsync.invoke(_buffer, _mode, _offset, _size, _callback, _userdata);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuBufferSetLabel = lookup(null, "wgpuBufferSetLabel", JAVA_LONG, JAVA_LONG);
	public static void wgpuBufferSetLabel(final WGPUBuffer buffer, final String label) {
		try(var stack = Stack.get()) {
			var _buffer = buffer == null ? 0L : buffer.handle;
			var _label = stack.alloc(label);
			wgpuBufferSetLabel.invoke(_buffer, _label);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuBufferUnmap = lookup(null, "wgpuBufferUnmap", JAVA_LONG);
	public static void wgpuBufferUnmap(final WGPUBuffer buffer) {
		try(var stack = Stack.get()) {
			var _buffer = buffer == null ? 0L : buffer.handle;
			wgpuBufferUnmap.invoke(_buffer);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuBufferReference = lookup(null, "wgpuBufferReference", JAVA_LONG);
	public static void wgpuBufferReference(final WGPUBuffer buffer) {
		try(var stack = Stack.get()) {
			var _buffer = buffer == null ? 0L : buffer.handle;
			wgpuBufferReference.invoke(_buffer);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuBufferRelease = lookup(null, "wgpuBufferRelease", JAVA_LONG);
	public static void wgpuBufferRelease(final WGPUBuffer buffer) {
		try(var stack = Stack.get()) {
			var _buffer = buffer == null ? 0L : buffer.handle;
			wgpuBufferRelease.invoke(_buffer);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuCommandBufferSetLabel = lookup(null, "wgpuCommandBufferSetLabel", JAVA_LONG, JAVA_LONG);
	public static void wgpuCommandBufferSetLabel(final WGPUCommandBuffer commandBuffer, final String label) {
		try(var stack = Stack.get()) {
			var _commandBuffer = commandBuffer == null ? 0L : commandBuffer.handle;
			var _label = stack.alloc(label);
			wgpuCommandBufferSetLabel.invoke(_commandBuffer, _label);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuCommandBufferReference = lookup(null, "wgpuCommandBufferReference", JAVA_LONG);
	public static void wgpuCommandBufferReference(final WGPUCommandBuffer commandBuffer) {
		try(var stack = Stack.get()) {
			var _commandBuffer = commandBuffer == null ? 0L : commandBuffer.handle;
			wgpuCommandBufferReference.invoke(_commandBuffer);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuCommandBufferRelease = lookup(null, "wgpuCommandBufferRelease", JAVA_LONG);
	public static void wgpuCommandBufferRelease(final WGPUCommandBuffer commandBuffer) {
		try(var stack = Stack.get()) {
			var _commandBuffer = commandBuffer == null ? 0L : commandBuffer.handle;
			wgpuCommandBufferRelease.invoke(_commandBuffer);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuCommandEncoderBeginComputePass = lookup(JAVA_LONG, "wgpuCommandEncoderBeginComputePass", JAVA_LONG, JAVA_LONG);
	public static WGPUComputePassEncoder wgpuCommandEncoderBeginComputePass(final WGPUCommandEncoder commandEncoder, @Nullable final ComputePassDescriptor descriptor) {
		try(var stack = Stack.get()) {
			var _commandEncoder = commandEncoder == null ? 0L : commandEncoder.handle;
			var _descriptor = stack.alloc(descriptor);
			var ret = (long) wgpuCommandEncoderBeginComputePass.invoke(_commandEncoder, _descriptor);
			return ret == 0L ? null : new WGPUComputePassEncoder(ret);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuCommandEncoderBeginRenderPass = lookup(JAVA_LONG, "wgpuCommandEncoderBeginRenderPass", JAVA_LONG, JAVA_LONG);
	public static WGPURenderPassEncoder wgpuCommandEncoderBeginRenderPass(final WGPUCommandEncoder commandEncoder, final RenderPassDescriptor descriptor) {
		try(var stack = Stack.get()) {
			var _commandEncoder = commandEncoder == null ? 0L : commandEncoder.handle;
			var _descriptor = stack.alloc(descriptor);
			var ret = (long) wgpuCommandEncoderBeginRenderPass.invoke(_commandEncoder, _descriptor);
			return ret == 0L ? null : new WGPURenderPassEncoder(ret);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuCommandEncoderClearBuffer = lookup(null, "wgpuCommandEncoderClearBuffer", JAVA_LONG, JAVA_LONG, JAVA_LONG, JAVA_LONG);
	public static void wgpuCommandEncoderClearBuffer(final WGPUCommandEncoder commandEncoder, final WGPUBuffer buffer, final long offset, final long size) {
		try(var stack = Stack.get()) {
			var _commandEncoder = commandEncoder == null ? 0L : commandEncoder.handle;
			var _buffer = buffer == null ? 0L : buffer.handle;
			var _offset = (long) offset;
			var _size = (long) size;
			wgpuCommandEncoderClearBuffer.invoke(_commandEncoder, _buffer, _offset, _size);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuCommandEncoderCopyBufferToBuffer = lookup(null, "wgpuCommandEncoderCopyBufferToBuffer", JAVA_LONG, JAVA_LONG, JAVA_LONG, JAVA_LONG, JAVA_LONG, JAVA_LONG);
	public static void wgpuCommandEncoderCopyBufferToBuffer(final WGPUCommandEncoder commandEncoder, final WGPUBuffer source, final long sourceOffset, final WGPUBuffer destination, final long destinationOffset, final long size) {
		try(var stack = Stack.get()) {
			var _commandEncoder = commandEncoder == null ? 0L : commandEncoder.handle;
			var _source = source == null ? 0L : source.handle;
			var _sourceOffset = (long) sourceOffset;
			var _destination = destination == null ? 0L : destination.handle;
			var _destinationOffset = (long) destinationOffset;
			var _size = (long) size;
			wgpuCommandEncoderCopyBufferToBuffer.invoke(_commandEncoder, _source, _sourceOffset, _destination, _destinationOffset, _size);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuCommandEncoderCopyBufferToTexture = lookup(null, "wgpuCommandEncoderCopyBufferToTexture", JAVA_LONG, JAVA_LONG, JAVA_LONG, JAVA_LONG);
	public static void wgpuCommandEncoderCopyBufferToTexture(final WGPUCommandEncoder commandEncoder, final ImageCopyBuffer source, final ImageCopyTexture destination, final Extent3D copySize) {
		try(var stack = Stack.get()) {
			var _commandEncoder = commandEncoder == null ? 0L : commandEncoder.handle;
			var _source = stack.alloc(source);
			var _destination = stack.alloc(destination);
			var _copySize = stack.alloc(copySize);
			wgpuCommandEncoderCopyBufferToTexture.invoke(_commandEncoder, _source, _destination, _copySize);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuCommandEncoderCopyTextureToBuffer = lookup(null, "wgpuCommandEncoderCopyTextureToBuffer", JAVA_LONG, JAVA_LONG, JAVA_LONG, JAVA_LONG);
	public static void wgpuCommandEncoderCopyTextureToBuffer(final WGPUCommandEncoder commandEncoder, final ImageCopyTexture source, final ImageCopyBuffer destination, final Extent3D copySize) {
		try(var stack = Stack.get()) {
			var _commandEncoder = commandEncoder == null ? 0L : commandEncoder.handle;
			var _source = stack.alloc(source);
			var _destination = stack.alloc(destination);
			var _copySize = stack.alloc(copySize);
			wgpuCommandEncoderCopyTextureToBuffer.invoke(_commandEncoder, _source, _destination, _copySize);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuCommandEncoderCopyTextureToTexture = lookup(null, "wgpuCommandEncoderCopyTextureToTexture", JAVA_LONG, JAVA_LONG, JAVA_LONG, JAVA_LONG);
	public static void wgpuCommandEncoderCopyTextureToTexture(final WGPUCommandEncoder commandEncoder, final ImageCopyTexture source, final ImageCopyTexture destination, final Extent3D copySize) {
		try(var stack = Stack.get()) {
			var _commandEncoder = commandEncoder == null ? 0L : commandEncoder.handle;
			var _source = stack.alloc(source);
			var _destination = stack.alloc(destination);
			var _copySize = stack.alloc(copySize);
			wgpuCommandEncoderCopyTextureToTexture.invoke(_commandEncoder, _source, _destination, _copySize);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuCommandEncoderFinish = lookup(JAVA_LONG, "wgpuCommandEncoderFinish", JAVA_LONG, JAVA_LONG);
	public static WGPUCommandBuffer wgpuCommandEncoderFinish(final WGPUCommandEncoder commandEncoder, @Nullable final CommandBufferDescriptor descriptor) {
		try(var stack = Stack.get()) {
			var _commandEncoder = commandEncoder == null ? 0L : commandEncoder.handle;
			var _descriptor = stack.alloc(descriptor);
			var ret = (long) wgpuCommandEncoderFinish.invoke(_commandEncoder, _descriptor);
			return ret == 0L ? null : new WGPUCommandBuffer(ret);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuCommandEncoderInsertDebugMarker = lookup(null, "wgpuCommandEncoderInsertDebugMarker", JAVA_LONG, JAVA_LONG);
	public static void wgpuCommandEncoderInsertDebugMarker(final WGPUCommandEncoder commandEncoder, final String markerLabel) {
		try(var stack = Stack.get()) {
			var _commandEncoder = commandEncoder == null ? 0L : commandEncoder.handle;
			var _markerLabel = stack.alloc(markerLabel);
			wgpuCommandEncoderInsertDebugMarker.invoke(_commandEncoder, _markerLabel);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuCommandEncoderPopDebugGroup = lookup(null, "wgpuCommandEncoderPopDebugGroup", JAVA_LONG);
	public static void wgpuCommandEncoderPopDebugGroup(final WGPUCommandEncoder commandEncoder) {
		try(var stack = Stack.get()) {
			var _commandEncoder = commandEncoder == null ? 0L : commandEncoder.handle;
			wgpuCommandEncoderPopDebugGroup.invoke(_commandEncoder);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuCommandEncoderPushDebugGroup = lookup(null, "wgpuCommandEncoderPushDebugGroup", JAVA_LONG, JAVA_LONG);
	public static void wgpuCommandEncoderPushDebugGroup(final WGPUCommandEncoder commandEncoder, final String groupLabel) {
		try(var stack = Stack.get()) {
			var _commandEncoder = commandEncoder == null ? 0L : commandEncoder.handle;
			var _groupLabel = stack.alloc(groupLabel);
			wgpuCommandEncoderPushDebugGroup.invoke(_commandEncoder, _groupLabel);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuCommandEncoderResolveQuerySet = lookup(null, "wgpuCommandEncoderResolveQuerySet", JAVA_LONG, JAVA_LONG, JAVA_INT, JAVA_INT, JAVA_LONG, JAVA_LONG);
	public static void wgpuCommandEncoderResolveQuerySet(final WGPUCommandEncoder commandEncoder, final WGPUQuerySet querySet, final int firstQuery, final int queryCount, final WGPUBuffer destination, final long destinationOffset) {
		try(var stack = Stack.get()) {
			var _commandEncoder = commandEncoder == null ? 0L : commandEncoder.handle;
			var _querySet = querySet == null ? 0L : querySet.handle;
			var _firstQuery = (int) firstQuery;
			var _queryCount = (int) queryCount;
			var _destination = destination == null ? 0L : destination.handle;
			var _destinationOffset = (long) destinationOffset;
			wgpuCommandEncoderResolveQuerySet.invoke(_commandEncoder, _querySet, _firstQuery, _queryCount, _destination, _destinationOffset);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuCommandEncoderSetLabel = lookup(null, "wgpuCommandEncoderSetLabel", JAVA_LONG, JAVA_LONG);
	public static void wgpuCommandEncoderSetLabel(final WGPUCommandEncoder commandEncoder, final String label) {
		try(var stack = Stack.get()) {
			var _commandEncoder = commandEncoder == null ? 0L : commandEncoder.handle;
			var _label = stack.alloc(label);
			wgpuCommandEncoderSetLabel.invoke(_commandEncoder, _label);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuCommandEncoderWriteTimestamp = lookup(null, "wgpuCommandEncoderWriteTimestamp", JAVA_LONG, JAVA_LONG, JAVA_INT);
	public static void wgpuCommandEncoderWriteTimestamp(final WGPUCommandEncoder commandEncoder, final WGPUQuerySet querySet, final int queryIndex) {
		try(var stack = Stack.get()) {
			var _commandEncoder = commandEncoder == null ? 0L : commandEncoder.handle;
			var _querySet = querySet == null ? 0L : querySet.handle;
			var _queryIndex = (int) queryIndex;
			wgpuCommandEncoderWriteTimestamp.invoke(_commandEncoder, _querySet, _queryIndex);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuCommandEncoderReference = lookup(null, "wgpuCommandEncoderReference", JAVA_LONG);
	public static void wgpuCommandEncoderReference(final WGPUCommandEncoder commandEncoder) {
		try(var stack = Stack.get()) {
			var _commandEncoder = commandEncoder == null ? 0L : commandEncoder.handle;
			wgpuCommandEncoderReference.invoke(_commandEncoder);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuCommandEncoderRelease = lookup(null, "wgpuCommandEncoderRelease", JAVA_LONG);
	public static void wgpuCommandEncoderRelease(final WGPUCommandEncoder commandEncoder) {
		try(var stack = Stack.get()) {
			var _commandEncoder = commandEncoder == null ? 0L : commandEncoder.handle;
			wgpuCommandEncoderRelease.invoke(_commandEncoder);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuComputePassEncoderDispatchWorkgroups = lookup(null, "wgpuComputePassEncoderDispatchWorkgroups", JAVA_LONG, JAVA_INT, JAVA_INT, JAVA_INT);
	public static void wgpuComputePassEncoderDispatchWorkgroups(final WGPUComputePassEncoder computePassEncoder, final int workgroupCountX, final int workgroupCountY, final int workgroupCountZ) {
		try(var stack = Stack.get()) {
			var _computePassEncoder = computePassEncoder == null ? 0L : computePassEncoder.handle;
			var _workgroupCountX = (int) workgroupCountX;
			var _workgroupCountY = (int) workgroupCountY;
			var _workgroupCountZ = (int) workgroupCountZ;
			wgpuComputePassEncoderDispatchWorkgroups.invoke(_computePassEncoder, _workgroupCountX, _workgroupCountY, _workgroupCountZ);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuComputePassEncoderDispatchWorkgroupsIndirect = lookup(null, "wgpuComputePassEncoderDispatchWorkgroupsIndirect", JAVA_LONG, JAVA_LONG, JAVA_LONG);
	public static void wgpuComputePassEncoderDispatchWorkgroupsIndirect(final WGPUComputePassEncoder computePassEncoder, final WGPUBuffer indirectBuffer, final long indirectOffset) {
		try(var stack = Stack.get()) {
			var _computePassEncoder = computePassEncoder == null ? 0L : computePassEncoder.handle;
			var _indirectBuffer = indirectBuffer == null ? 0L : indirectBuffer.handle;
			var _indirectOffset = (long) indirectOffset;
			wgpuComputePassEncoderDispatchWorkgroupsIndirect.invoke(_computePassEncoder, _indirectBuffer, _indirectOffset);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuComputePassEncoderEnd = lookup(null, "wgpuComputePassEncoderEnd", JAVA_LONG);
	public static void wgpuComputePassEncoderEnd(final WGPUComputePassEncoder computePassEncoder) {
		try(var stack = Stack.get()) {
			var _computePassEncoder = computePassEncoder == null ? 0L : computePassEncoder.handle;
			wgpuComputePassEncoderEnd.invoke(_computePassEncoder);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuComputePassEncoderInsertDebugMarker = lookup(null, "wgpuComputePassEncoderInsertDebugMarker", JAVA_LONG, JAVA_LONG);
	public static void wgpuComputePassEncoderInsertDebugMarker(final WGPUComputePassEncoder computePassEncoder, final String markerLabel) {
		try(var stack = Stack.get()) {
			var _computePassEncoder = computePassEncoder == null ? 0L : computePassEncoder.handle;
			var _markerLabel = stack.alloc(markerLabel);
			wgpuComputePassEncoderInsertDebugMarker.invoke(_computePassEncoder, _markerLabel);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuComputePassEncoderPopDebugGroup = lookup(null, "wgpuComputePassEncoderPopDebugGroup", JAVA_LONG);
	public static void wgpuComputePassEncoderPopDebugGroup(final WGPUComputePassEncoder computePassEncoder) {
		try(var stack = Stack.get()) {
			var _computePassEncoder = computePassEncoder == null ? 0L : computePassEncoder.handle;
			wgpuComputePassEncoderPopDebugGroup.invoke(_computePassEncoder);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuComputePassEncoderPushDebugGroup = lookup(null, "wgpuComputePassEncoderPushDebugGroup", JAVA_LONG, JAVA_LONG);
	public static void wgpuComputePassEncoderPushDebugGroup(final WGPUComputePassEncoder computePassEncoder, final String groupLabel) {
		try(var stack = Stack.get()) {
			var _computePassEncoder = computePassEncoder == null ? 0L : computePassEncoder.handle;
			var _groupLabel = stack.alloc(groupLabel);
			wgpuComputePassEncoderPushDebugGroup.invoke(_computePassEncoder, _groupLabel);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuComputePassEncoderSetBindGroup = lookup(null, "wgpuComputePassEncoderSetBindGroup", JAVA_LONG, JAVA_INT, JAVA_LONG, JAVA_LONG, JAVA_LONG);
	public static void wgpuComputePassEncoderSetBindGroup(final WGPUComputePassEncoder computePassEncoder, final int groupIndex, @Nullable final WGPUBindGroup group, final int[] dynamicOffsets) {
		try(var stack = Stack.get()) {
			var _computePassEncoder = computePassEncoder == null ? 0L : computePassEncoder.handle;
			var _groupIndex = (int) groupIndex;
			var _group = group == null ? 0L : group.handle;
			var _dynamicOffsetCount = (long) (dynamicOffsets == null ? 0 : dynamicOffsets.length);
			var _dynamicOffsets = stack.alloc(dynamicOffsets);
			wgpuComputePassEncoderSetBindGroup.invoke(_computePassEncoder, _groupIndex, _group, _dynamicOffsetCount, _dynamicOffsets);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuComputePassEncoderSetLabel = lookup(null, "wgpuComputePassEncoderSetLabel", JAVA_LONG, JAVA_LONG);
	public static void wgpuComputePassEncoderSetLabel(final WGPUComputePassEncoder computePassEncoder, final String label) {
		try(var stack = Stack.get()) {
			var _computePassEncoder = computePassEncoder == null ? 0L : computePassEncoder.handle;
			var _label = stack.alloc(label);
			wgpuComputePassEncoderSetLabel.invoke(_computePassEncoder, _label);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuComputePassEncoderSetPipeline = lookup(null, "wgpuComputePassEncoderSetPipeline", JAVA_LONG, JAVA_LONG);
	public static void wgpuComputePassEncoderSetPipeline(final WGPUComputePassEncoder computePassEncoder, final WGPUComputePipeline pipeline) {
		try(var stack = Stack.get()) {
			var _computePassEncoder = computePassEncoder == null ? 0L : computePassEncoder.handle;
			var _pipeline = pipeline == null ? 0L : pipeline.handle;
			wgpuComputePassEncoderSetPipeline.invoke(_computePassEncoder, _pipeline);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuComputePassEncoderReference = lookup(null, "wgpuComputePassEncoderReference", JAVA_LONG);
	public static void wgpuComputePassEncoderReference(final WGPUComputePassEncoder computePassEncoder) {
		try(var stack = Stack.get()) {
			var _computePassEncoder = computePassEncoder == null ? 0L : computePassEncoder.handle;
			wgpuComputePassEncoderReference.invoke(_computePassEncoder);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuComputePassEncoderRelease = lookup(null, "wgpuComputePassEncoderRelease", JAVA_LONG);
	public static void wgpuComputePassEncoderRelease(final WGPUComputePassEncoder computePassEncoder) {
		try(var stack = Stack.get()) {
			var _computePassEncoder = computePassEncoder == null ? 0L : computePassEncoder.handle;
			wgpuComputePassEncoderRelease.invoke(_computePassEncoder);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuComputePipelineGetBindGroupLayout = lookup(JAVA_LONG, "wgpuComputePipelineGetBindGroupLayout", JAVA_LONG, JAVA_INT);
	public static WGPUBindGroupLayout wgpuComputePipelineGetBindGroupLayout(final WGPUComputePipeline computePipeline, final int groupIndex) {
		try(var stack = Stack.get()) {
			var _computePipeline = computePipeline == null ? 0L : computePipeline.handle;
			var _groupIndex = (int) groupIndex;
			var ret = (long) wgpuComputePipelineGetBindGroupLayout.invoke(_computePipeline, _groupIndex);
			return ret == 0L ? null : new WGPUBindGroupLayout(ret);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuComputePipelineSetLabel = lookup(null, "wgpuComputePipelineSetLabel", JAVA_LONG, JAVA_LONG);
	public static void wgpuComputePipelineSetLabel(final WGPUComputePipeline computePipeline, final String label) {
		try(var stack = Stack.get()) {
			var _computePipeline = computePipeline == null ? 0L : computePipeline.handle;
			var _label = stack.alloc(label);
			wgpuComputePipelineSetLabel.invoke(_computePipeline, _label);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuComputePipelineReference = lookup(null, "wgpuComputePipelineReference", JAVA_LONG);
	public static void wgpuComputePipelineReference(final WGPUComputePipeline computePipeline) {
		try(var stack = Stack.get()) {
			var _computePipeline = computePipeline == null ? 0L : computePipeline.handle;
			wgpuComputePipelineReference.invoke(_computePipeline);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuComputePipelineRelease = lookup(null, "wgpuComputePipelineRelease", JAVA_LONG);
	public static void wgpuComputePipelineRelease(final WGPUComputePipeline computePipeline) {
		try(var stack = Stack.get()) {
			var _computePipeline = computePipeline == null ? 0L : computePipeline.handle;
			wgpuComputePipelineRelease.invoke(_computePipeline);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuDeviceCreateBindGroup = lookup(JAVA_LONG, "wgpuDeviceCreateBindGroup", JAVA_LONG, JAVA_LONG);
	public static WGPUBindGroup wgpuDeviceCreateBindGroup(final WGPUDevice device, final BindGroupDescriptor descriptor) {
		try(var stack = Stack.get()) {
			var _device = device == null ? 0L : device.handle;
			var _descriptor = stack.alloc(descriptor);
			var ret = (long) wgpuDeviceCreateBindGroup.invoke(_device, _descriptor);
			return ret == 0L ? null : new WGPUBindGroup(ret);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuDeviceCreateBindGroupLayout = lookup(JAVA_LONG, "wgpuDeviceCreateBindGroupLayout", JAVA_LONG, JAVA_LONG);
	public static WGPUBindGroupLayout wgpuDeviceCreateBindGroupLayout(final WGPUDevice device, final BindGroupLayoutDescriptor descriptor) {
		try(var stack = Stack.get()) {
			var _device = device == null ? 0L : device.handle;
			var _descriptor = stack.alloc(descriptor);
			var ret = (long) wgpuDeviceCreateBindGroupLayout.invoke(_device, _descriptor);
			return ret == 0L ? null : new WGPUBindGroupLayout(ret);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuDeviceCreateBuffer = lookup(JAVA_LONG, "wgpuDeviceCreateBuffer", JAVA_LONG, JAVA_LONG);
	public static WGPUBuffer wgpuDeviceCreateBuffer(final WGPUDevice device, final BufferDescriptor descriptor) {
		try(var stack = Stack.get()) {
			var _device = device == null ? 0L : device.handle;
			var _descriptor = stack.alloc(descriptor);
			var ret = (long) wgpuDeviceCreateBuffer.invoke(_device, _descriptor);
			return ret == 0L ? null : new WGPUBuffer(ret);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuDeviceCreateCommandEncoder = lookup(JAVA_LONG, "wgpuDeviceCreateCommandEncoder", JAVA_LONG, JAVA_LONG);
	public static WGPUCommandEncoder wgpuDeviceCreateCommandEncoder(final WGPUDevice device, @Nullable final CommandEncoderDescriptor descriptor) {
		try(var stack = Stack.get()) {
			var _device = device == null ? 0L : device.handle;
			var _descriptor = stack.alloc(descriptor);
			var ret = (long) wgpuDeviceCreateCommandEncoder.invoke(_device, _descriptor);
			return ret == 0L ? null : new WGPUCommandEncoder(ret);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuDeviceCreateComputePipeline = lookup(JAVA_LONG, "wgpuDeviceCreateComputePipeline", JAVA_LONG, JAVA_LONG);
	public static WGPUComputePipeline wgpuDeviceCreateComputePipeline(final WGPUDevice device, final ComputePipelineDescriptor descriptor) {
		try(var stack = Stack.get()) {
			var _device = device == null ? 0L : device.handle;
			var _descriptor = stack.alloc(descriptor);
			var ret = (long) wgpuDeviceCreateComputePipeline.invoke(_device, _descriptor);
			return ret == 0L ? null : new WGPUComputePipeline(ret);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuDeviceCreateComputePipelineAsync = lookup(null, "wgpuDeviceCreateComputePipelineAsync", JAVA_LONG, JAVA_LONG, ADDRESS, JAVA_LONG);
	public static void wgpuDeviceCreateComputePipelineAsync(final WGPUDevice device, final ComputePipelineDescriptor descriptor, final DeviceCreateComputePipelineAsyncCallback callback, final long userdata) {
		try(var stack = Stack.get()) {
			var _device = device == null ? 0L : device.handle;
			var _descriptor = stack.alloc(descriptor);
			var _callback = WGPUCallback.createStub(callback, callback.handle, callback.desc);
			var _userdata = (long) userdata;
			wgpuDeviceCreateComputePipelineAsync.invoke(_device, _descriptor, _callback, _userdata);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuDeviceCreatePipelineLayout = lookup(JAVA_LONG, "wgpuDeviceCreatePipelineLayout", JAVA_LONG, JAVA_LONG);
	public static WGPUPipelineLayout wgpuDeviceCreatePipelineLayout(final WGPUDevice device, final PipelineLayoutDescriptor descriptor) {
		try(var stack = Stack.get()) {
			var _device = device == null ? 0L : device.handle;
			var _descriptor = stack.alloc(descriptor);
			var ret = (long) wgpuDeviceCreatePipelineLayout.invoke(_device, _descriptor);
			return ret == 0L ? null : new WGPUPipelineLayout(ret);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuDeviceCreateQuerySet = lookup(JAVA_LONG, "wgpuDeviceCreateQuerySet", JAVA_LONG, JAVA_LONG);
	public static WGPUQuerySet wgpuDeviceCreateQuerySet(final WGPUDevice device, final QuerySetDescriptor descriptor) {
		try(var stack = Stack.get()) {
			var _device = device == null ? 0L : device.handle;
			var _descriptor = stack.alloc(descriptor);
			var ret = (long) wgpuDeviceCreateQuerySet.invoke(_device, _descriptor);
			return ret == 0L ? null : new WGPUQuerySet(ret);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuDeviceCreateRenderBundleEncoder = lookup(JAVA_LONG, "wgpuDeviceCreateRenderBundleEncoder", JAVA_LONG, JAVA_LONG);
	public static WGPURenderBundleEncoder wgpuDeviceCreateRenderBundleEncoder(final WGPUDevice device, final RenderBundleEncoderDescriptor descriptor) {
		try(var stack = Stack.get()) {
			var _device = device == null ? 0L : device.handle;
			var _descriptor = stack.alloc(descriptor);
			var ret = (long) wgpuDeviceCreateRenderBundleEncoder.invoke(_device, _descriptor);
			return ret == 0L ? null : new WGPURenderBundleEncoder(ret);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuDeviceCreateRenderPipeline = lookup(JAVA_LONG, "wgpuDeviceCreateRenderPipeline", JAVA_LONG, JAVA_LONG);
	public static WGPURenderPipeline wgpuDeviceCreateRenderPipeline(final WGPUDevice device, final RenderPipelineDescriptor descriptor) {
		try(var stack = Stack.get()) {
			var _device = device == null ? 0L : device.handle;
			var _descriptor = stack.alloc(descriptor);
			var ret = (long) wgpuDeviceCreateRenderPipeline.invoke(_device, _descriptor);
			return ret == 0L ? null : new WGPURenderPipeline(ret);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuDeviceCreateRenderPipelineAsync = lookup(null, "wgpuDeviceCreateRenderPipelineAsync", JAVA_LONG, JAVA_LONG, ADDRESS, JAVA_LONG);
	public static void wgpuDeviceCreateRenderPipelineAsync(final WGPUDevice device, final RenderPipelineDescriptor descriptor, final DeviceCreateRenderPipelineAsyncCallback callback, final long userdata) {
		try(var stack = Stack.get()) {
			var _device = device == null ? 0L : device.handle;
			var _descriptor = stack.alloc(descriptor);
			var _callback = WGPUCallback.createStub(callback, callback.handle, callback.desc);
			var _userdata = (long) userdata;
			wgpuDeviceCreateRenderPipelineAsync.invoke(_device, _descriptor, _callback, _userdata);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuDeviceCreateSampler = lookup(JAVA_LONG, "wgpuDeviceCreateSampler", JAVA_LONG, JAVA_LONG);
	public static WGPUSampler wgpuDeviceCreateSampler(final WGPUDevice device, @Nullable final SamplerDescriptor descriptor) {
		try(var stack = Stack.get()) {
			var _device = device == null ? 0L : device.handle;
			var _descriptor = stack.alloc(descriptor);
			var ret = (long) wgpuDeviceCreateSampler.invoke(_device, _descriptor);
			return ret == 0L ? null : new WGPUSampler(ret);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuDeviceCreateShaderModule = lookup(JAVA_LONG, "wgpuDeviceCreateShaderModule", JAVA_LONG, JAVA_LONG);
	public static WGPUShaderModule wgpuDeviceCreateShaderModule(final WGPUDevice device, final ShaderModuleDescriptor descriptor) {
		try(var stack = Stack.get()) {
			var _device = device == null ? 0L : device.handle;
			var _descriptor = stack.alloc(descriptor);
			var ret = (long) wgpuDeviceCreateShaderModule.invoke(_device, _descriptor);
			return ret == 0L ? null : new WGPUShaderModule(ret);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuDeviceCreateTexture = lookup(JAVA_LONG, "wgpuDeviceCreateTexture", JAVA_LONG, JAVA_LONG);
	public static WGPUTexture wgpuDeviceCreateTexture(final WGPUDevice device, final TextureDescriptor descriptor) {
		try(var stack = Stack.get()) {
			var _device = device == null ? 0L : device.handle;
			var _descriptor = stack.alloc(descriptor);
			var ret = (long) wgpuDeviceCreateTexture.invoke(_device, _descriptor);
			return ret == 0L ? null : new WGPUTexture(ret);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuDeviceDestroy = lookup(null, "wgpuDeviceDestroy", JAVA_LONG);
	public static void wgpuDeviceDestroy(final WGPUDevice device) {
		try(var stack = Stack.get()) {
			var _device = device == null ? 0L : device.handle;
			wgpuDeviceDestroy.invoke(_device);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuDeviceEnumerateFeatures = lookup(JAVA_LONG, "wgpuDeviceEnumerateFeatures", JAVA_LONG, JAVA_LONG);
	public static long wgpuDeviceEnumerateFeatures(final WGPUDevice device, FeatureName[] features) {
		try(var stack = Stack.get()) {
			var _device = device == null ? 0L : device.handle;
			var _features = stack.prealloc(features);
			var ret = (long) wgpuDeviceEnumerateFeatures.invoke(_device, _features);
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
	public static boolean wgpuDeviceGetLimits(final WGPUDevice device, SupportedLimits limits) {
		try(var stack = Stack.get()) {
			var _device = device == null ? 0L : device.handle;
			var _limits = stack.prealloc(limits);
			var ret = (int) wgpuDeviceGetLimits.invoke(_device, _limits);
			((WGPUStruct)limits).load(_limits);
			return ret != 0;
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuDeviceGetQueue = lookup(JAVA_LONG, "wgpuDeviceGetQueue", JAVA_LONG);
	public static WGPUQueue wgpuDeviceGetQueue(final WGPUDevice device) {
		try(var stack = Stack.get()) {
			var _device = device == null ? 0L : device.handle;
			var ret = (long) wgpuDeviceGetQueue.invoke(_device);
			return ret == 0L ? null : new WGPUQueue(ret);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuDeviceHasFeature = lookup(JAVA_INT, "wgpuDeviceHasFeature", JAVA_LONG, JAVA_INT);
	public static boolean wgpuDeviceHasFeature(final WGPUDevice device, final FeatureName feature) {
		try(var stack = Stack.get()) {
			var _device = device == null ? 0L : device.handle;
			var _feature = feature == null ? 0 : feature.bits;
			var ret = (int) wgpuDeviceHasFeature.invoke(_device, _feature);
			return ret != 0;
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuDevicePopErrorScope = lookup(null, "wgpuDevicePopErrorScope", JAVA_LONG, ADDRESS, JAVA_LONG);
	public static void wgpuDevicePopErrorScope(final WGPUDevice device, final ErrorCallback callback, final long userdata) {
		try(var stack = Stack.get()) {
			var _device = device == null ? 0L : device.handle;
			var _callback = WGPUCallback.createStub(callback, callback.handle, callback.desc);
			var _userdata = (long) userdata;
			wgpuDevicePopErrorScope.invoke(_device, _callback, _userdata);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuDevicePushErrorScope = lookup(null, "wgpuDevicePushErrorScope", JAVA_LONG, JAVA_INT);
	public static void wgpuDevicePushErrorScope(final WGPUDevice device, final ErrorFilter filter) {
		try(var stack = Stack.get()) {
			var _device = device == null ? 0L : device.handle;
			var _filter = filter == null ? 0 : filter.bits;
			wgpuDevicePushErrorScope.invoke(_device, _filter);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuDeviceSetLabel = lookup(null, "wgpuDeviceSetLabel", JAVA_LONG, JAVA_LONG);
	public static void wgpuDeviceSetLabel(final WGPUDevice device, final String label) {
		try(var stack = Stack.get()) {
			var _device = device == null ? 0L : device.handle;
			var _label = stack.alloc(label);
			wgpuDeviceSetLabel.invoke(_device, _label);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuDeviceReference = lookup(null, "wgpuDeviceReference", JAVA_LONG);
	public static void wgpuDeviceReference(final WGPUDevice device) {
		try(var stack = Stack.get()) {
			var _device = device == null ? 0L : device.handle;
			wgpuDeviceReference.invoke(_device);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuDeviceRelease = lookup(null, "wgpuDeviceRelease", JAVA_LONG);
	public static void wgpuDeviceRelease(final WGPUDevice device) {
		try(var stack = Stack.get()) {
			var _device = device == null ? 0L : device.handle;
			wgpuDeviceRelease.invoke(_device);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuInstanceCreateSurface = lookup(JAVA_LONG, "wgpuInstanceCreateSurface", JAVA_LONG, JAVA_LONG);
	public static WGPUSurface wgpuInstanceCreateSurface(final WGPUInstance instance, final SurfaceDescriptor descriptor) {
		try(var stack = Stack.get()) {
			var _instance = instance == null ? 0L : instance.handle;
			var _descriptor = stack.alloc(descriptor);
			var ret = (long) wgpuInstanceCreateSurface.invoke(_instance, _descriptor);
			return ret == 0L ? null : new WGPUSurface(ret);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuInstanceHasWGSLLanguageFeature = lookup(JAVA_INT, "wgpuInstanceHasWGSLLanguageFeature", JAVA_LONG, JAVA_INT);
	public static boolean wgpuInstanceHasWGSLLanguageFeature(final WGPUInstance instance, final WGSLFeatureName feature) {
		try(var stack = Stack.get()) {
			var _instance = instance == null ? 0L : instance.handle;
			var _feature = feature == null ? 0 : feature.bits;
			var ret = (int) wgpuInstanceHasWGSLLanguageFeature.invoke(_instance, _feature);
			return ret != 0;
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuInstanceProcessEvents = lookup(null, "wgpuInstanceProcessEvents", JAVA_LONG);
	public static void wgpuInstanceProcessEvents(final WGPUInstance instance) {
		try(var stack = Stack.get()) {
			var _instance = instance == null ? 0L : instance.handle;
			wgpuInstanceProcessEvents.invoke(_instance);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuInstanceRequestAdapter = lookup(null, "wgpuInstanceRequestAdapter", JAVA_LONG, JAVA_LONG, ADDRESS, JAVA_LONG);
	public static void wgpuInstanceRequestAdapter(final WGPUInstance instance, @Nullable final RequestAdapterOptions options, final InstanceRequestAdapterCallback callback, final long userdata) {
		try(var stack = Stack.get()) {
			var _instance = instance == null ? 0L : instance.handle;
			var _options = stack.alloc(options);
			var _callback = WGPUCallback.createStub(callback, callback.handle, callback.desc);
			var _userdata = (long) userdata;
			wgpuInstanceRequestAdapter.invoke(_instance, _options, _callback, _userdata);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuInstanceReference = lookup(null, "wgpuInstanceReference", JAVA_LONG);
	public static void wgpuInstanceReference(final WGPUInstance instance) {
		try(var stack = Stack.get()) {
			var _instance = instance == null ? 0L : instance.handle;
			wgpuInstanceReference.invoke(_instance);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuInstanceRelease = lookup(null, "wgpuInstanceRelease", JAVA_LONG);
	public static void wgpuInstanceRelease(final WGPUInstance instance) {
		try(var stack = Stack.get()) {
			var _instance = instance == null ? 0L : instance.handle;
			wgpuInstanceRelease.invoke(_instance);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuPipelineLayoutSetLabel = lookup(null, "wgpuPipelineLayoutSetLabel", JAVA_LONG, JAVA_LONG);
	public static void wgpuPipelineLayoutSetLabel(final WGPUPipelineLayout pipelineLayout, final String label) {
		try(var stack = Stack.get()) {
			var _pipelineLayout = pipelineLayout == null ? 0L : pipelineLayout.handle;
			var _label = stack.alloc(label);
			wgpuPipelineLayoutSetLabel.invoke(_pipelineLayout, _label);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuPipelineLayoutReference = lookup(null, "wgpuPipelineLayoutReference", JAVA_LONG);
	public static void wgpuPipelineLayoutReference(final WGPUPipelineLayout pipelineLayout) {
		try(var stack = Stack.get()) {
			var _pipelineLayout = pipelineLayout == null ? 0L : pipelineLayout.handle;
			wgpuPipelineLayoutReference.invoke(_pipelineLayout);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuPipelineLayoutRelease = lookup(null, "wgpuPipelineLayoutRelease", JAVA_LONG);
	public static void wgpuPipelineLayoutRelease(final WGPUPipelineLayout pipelineLayout) {
		try(var stack = Stack.get()) {
			var _pipelineLayout = pipelineLayout == null ? 0L : pipelineLayout.handle;
			wgpuPipelineLayoutRelease.invoke(_pipelineLayout);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuQuerySetDestroy = lookup(null, "wgpuQuerySetDestroy", JAVA_LONG);
	public static void wgpuQuerySetDestroy(final WGPUQuerySet querySet) {
		try(var stack = Stack.get()) {
			var _querySet = querySet == null ? 0L : querySet.handle;
			wgpuQuerySetDestroy.invoke(_querySet);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuQuerySetGetCount = lookup(JAVA_INT, "wgpuQuerySetGetCount", JAVA_LONG);
	public static int wgpuQuerySetGetCount(final WGPUQuerySet querySet) {
		try(var stack = Stack.get()) {
			var _querySet = querySet == null ? 0L : querySet.handle;
			var ret = (int) wgpuQuerySetGetCount.invoke(_querySet);
			return ret;
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuQuerySetGetType = lookup(JAVA_INT, "wgpuQuerySetGetType", JAVA_LONG);
	public static QueryType wgpuQuerySetGetType(final WGPUQuerySet querySet) {
		try(var stack = Stack.get()) {
			var _querySet = querySet == null ? 0L : querySet.handle;
			var ret = (int) wgpuQuerySetGetType.invoke(_querySet);
			return QueryType.from(ret);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuQuerySetSetLabel = lookup(null, "wgpuQuerySetSetLabel", JAVA_LONG, JAVA_LONG);
	public static void wgpuQuerySetSetLabel(final WGPUQuerySet querySet, final String label) {
		try(var stack = Stack.get()) {
			var _querySet = querySet == null ? 0L : querySet.handle;
			var _label = stack.alloc(label);
			wgpuQuerySetSetLabel.invoke(_querySet, _label);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuQuerySetReference = lookup(null, "wgpuQuerySetReference", JAVA_LONG);
	public static void wgpuQuerySetReference(final WGPUQuerySet querySet) {
		try(var stack = Stack.get()) {
			var _querySet = querySet == null ? 0L : querySet.handle;
			wgpuQuerySetReference.invoke(_querySet);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuQuerySetRelease = lookup(null, "wgpuQuerySetRelease", JAVA_LONG);
	public static void wgpuQuerySetRelease(final WGPUQuerySet querySet) {
		try(var stack = Stack.get()) {
			var _querySet = querySet == null ? 0L : querySet.handle;
			wgpuQuerySetRelease.invoke(_querySet);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuQueueOnSubmittedWorkDone = lookup(null, "wgpuQueueOnSubmittedWorkDone", JAVA_LONG, ADDRESS, JAVA_LONG);
	public static void wgpuQueueOnSubmittedWorkDone(final WGPUQueue queue, final QueueOnSubmittedWorkDoneCallback callback, final long userdata) {
		try(var stack = Stack.get()) {
			var _queue = queue == null ? 0L : queue.handle;
			var _callback = WGPUCallback.createStub(callback, callback.handle, callback.desc);
			var _userdata = (long) userdata;
			wgpuQueueOnSubmittedWorkDone.invoke(_queue, _callback, _userdata);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuQueueSetLabel = lookup(null, "wgpuQueueSetLabel", JAVA_LONG, JAVA_LONG);
	public static void wgpuQueueSetLabel(final WGPUQueue queue, final String label) {
		try(var stack = Stack.get()) {
			var _queue = queue == null ? 0L : queue.handle;
			var _label = stack.alloc(label);
			wgpuQueueSetLabel.invoke(_queue, _label);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuQueueSubmit = lookup(null, "wgpuQueueSubmit", JAVA_LONG, JAVA_LONG, JAVA_LONG);
	public static void wgpuQueueSubmit(final WGPUQueue queue, final WGPUCommandBuffer[] commands) {
		try(var stack = Stack.get()) {
			var _queue = queue == null ? 0L : queue.handle;
			var _commandCount = (long) (commands == null ? 0 : commands.length);
			var _commands = stack.alloc(commands);
			wgpuQueueSubmit.invoke(_queue, _commandCount, _commands);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuQueueWriteBuffer = lookup(null, "wgpuQueueWriteBuffer", JAVA_LONG, JAVA_LONG, JAVA_LONG, JAVA_LONG, JAVA_LONG);
	public static void wgpuQueueWriteBuffer(final WGPUQueue queue, final WGPUBuffer buffer, final long bufferOffset, final MemorySegment data, final long size) {
		try(var stack = Stack.get()) {
			var _queue = queue == null ? 0L : queue.handle;
			var _buffer = buffer == null ? 0L : buffer.handle;
			var _bufferOffset = (long) bufferOffset;
			var _data = data;
			var _size = (long) size;
			wgpuQueueWriteBuffer.invoke(_queue, _buffer, _bufferOffset, _data, _size);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuQueueWriteTexture = lookup(null, "wgpuQueueWriteTexture", JAVA_LONG, JAVA_LONG, JAVA_LONG, JAVA_LONG, JAVA_LONG, JAVA_LONG);
	public static void wgpuQueueWriteTexture(final WGPUQueue queue, final ImageCopyTexture destination, final MemorySegment data, final TextureDataLayout dataLayout, final Extent3D writeSize) {
		try(var stack = Stack.get()) {
			var _queue = queue == null ? 0L : queue.handle;
			var _destination = stack.alloc(destination);
			var _data = data;
			var _dataSize = (long) (null == null ? 0 : data.byteSize());
			var _dataLayout = stack.alloc(dataLayout);
			var _writeSize = stack.alloc(writeSize);
			wgpuQueueWriteTexture.invoke(_queue, _destination, _data, _dataSize, _dataLayout, _writeSize);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuQueueReference = lookup(null, "wgpuQueueReference", JAVA_LONG);
	public static void wgpuQueueReference(final WGPUQueue queue) {
		try(var stack = Stack.get()) {
			var _queue = queue == null ? 0L : queue.handle;
			wgpuQueueReference.invoke(_queue);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuQueueRelease = lookup(null, "wgpuQueueRelease", JAVA_LONG);
	public static void wgpuQueueRelease(final WGPUQueue queue) {
		try(var stack = Stack.get()) {
			var _queue = queue == null ? 0L : queue.handle;
			wgpuQueueRelease.invoke(_queue);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderBundleSetLabel = lookup(null, "wgpuRenderBundleSetLabel", JAVA_LONG, JAVA_LONG);
	public static void wgpuRenderBundleSetLabel(final WGPURenderBundle renderBundle, final String label) {
		try(var stack = Stack.get()) {
			var _renderBundle = renderBundle == null ? 0L : renderBundle.handle;
			var _label = stack.alloc(label);
			wgpuRenderBundleSetLabel.invoke(_renderBundle, _label);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderBundleReference = lookup(null, "wgpuRenderBundleReference", JAVA_LONG);
	public static void wgpuRenderBundleReference(final WGPURenderBundle renderBundle) {
		try(var stack = Stack.get()) {
			var _renderBundle = renderBundle == null ? 0L : renderBundle.handle;
			wgpuRenderBundleReference.invoke(_renderBundle);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderBundleRelease = lookup(null, "wgpuRenderBundleRelease", JAVA_LONG);
	public static void wgpuRenderBundleRelease(final WGPURenderBundle renderBundle) {
		try(var stack = Stack.get()) {
			var _renderBundle = renderBundle == null ? 0L : renderBundle.handle;
			wgpuRenderBundleRelease.invoke(_renderBundle);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderBundleEncoderDraw = lookup(null, "wgpuRenderBundleEncoderDraw", JAVA_LONG, JAVA_INT, JAVA_INT, JAVA_INT, JAVA_INT);
	public static void wgpuRenderBundleEncoderDraw(final WGPURenderBundleEncoder renderBundleEncoder, final int vertexCount, final int instanceCount, final int firstVertex, final int firstInstance) {
		try(var stack = Stack.get()) {
			var _renderBundleEncoder = renderBundleEncoder == null ? 0L : renderBundleEncoder.handle;
			var _vertexCount = (int) vertexCount;
			var _instanceCount = (int) instanceCount;
			var _firstVertex = (int) firstVertex;
			var _firstInstance = (int) firstInstance;
			wgpuRenderBundleEncoderDraw.invoke(_renderBundleEncoder, _vertexCount, _instanceCount, _firstVertex, _firstInstance);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderBundleEncoderDrawIndexed = lookup(null, "wgpuRenderBundleEncoderDrawIndexed", JAVA_LONG, JAVA_INT, JAVA_INT, JAVA_INT, JAVA_INT, JAVA_INT);
	public static void wgpuRenderBundleEncoderDrawIndexed(final WGPURenderBundleEncoder renderBundleEncoder, final int indexCount, final int instanceCount, final int firstIndex, final int baseVertex, final int firstInstance) {
		try(var stack = Stack.get()) {
			var _renderBundleEncoder = renderBundleEncoder == null ? 0L : renderBundleEncoder.handle;
			var _indexCount = (int) indexCount;
			var _instanceCount = (int) instanceCount;
			var _firstIndex = (int) firstIndex;
			var _baseVertex = (int) baseVertex;
			var _firstInstance = (int) firstInstance;
			wgpuRenderBundleEncoderDrawIndexed.invoke(_renderBundleEncoder, _indexCount, _instanceCount, _firstIndex, _baseVertex, _firstInstance);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderBundleEncoderDrawIndexedIndirect = lookup(null, "wgpuRenderBundleEncoderDrawIndexedIndirect", JAVA_LONG, JAVA_LONG, JAVA_LONG);
	public static void wgpuRenderBundleEncoderDrawIndexedIndirect(final WGPURenderBundleEncoder renderBundleEncoder, final WGPUBuffer indirectBuffer, final long indirectOffset) {
		try(var stack = Stack.get()) {
			var _renderBundleEncoder = renderBundleEncoder == null ? 0L : renderBundleEncoder.handle;
			var _indirectBuffer = indirectBuffer == null ? 0L : indirectBuffer.handle;
			var _indirectOffset = (long) indirectOffset;
			wgpuRenderBundleEncoderDrawIndexedIndirect.invoke(_renderBundleEncoder, _indirectBuffer, _indirectOffset);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderBundleEncoderDrawIndirect = lookup(null, "wgpuRenderBundleEncoderDrawIndirect", JAVA_LONG, JAVA_LONG, JAVA_LONG);
	public static void wgpuRenderBundleEncoderDrawIndirect(final WGPURenderBundleEncoder renderBundleEncoder, final WGPUBuffer indirectBuffer, final long indirectOffset) {
		try(var stack = Stack.get()) {
			var _renderBundleEncoder = renderBundleEncoder == null ? 0L : renderBundleEncoder.handle;
			var _indirectBuffer = indirectBuffer == null ? 0L : indirectBuffer.handle;
			var _indirectOffset = (long) indirectOffset;
			wgpuRenderBundleEncoderDrawIndirect.invoke(_renderBundleEncoder, _indirectBuffer, _indirectOffset);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderBundleEncoderFinish = lookup(JAVA_LONG, "wgpuRenderBundleEncoderFinish", JAVA_LONG, JAVA_LONG);
	public static WGPURenderBundle wgpuRenderBundleEncoderFinish(final WGPURenderBundleEncoder renderBundleEncoder, @Nullable final RenderBundleDescriptor descriptor) {
		try(var stack = Stack.get()) {
			var _renderBundleEncoder = renderBundleEncoder == null ? 0L : renderBundleEncoder.handle;
			var _descriptor = stack.alloc(descriptor);
			var ret = (long) wgpuRenderBundleEncoderFinish.invoke(_renderBundleEncoder, _descriptor);
			return ret == 0L ? null : new WGPURenderBundle(ret);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderBundleEncoderInsertDebugMarker = lookup(null, "wgpuRenderBundleEncoderInsertDebugMarker", JAVA_LONG, JAVA_LONG);
	public static void wgpuRenderBundleEncoderInsertDebugMarker(final WGPURenderBundleEncoder renderBundleEncoder, final String markerLabel) {
		try(var stack = Stack.get()) {
			var _renderBundleEncoder = renderBundleEncoder == null ? 0L : renderBundleEncoder.handle;
			var _markerLabel = stack.alloc(markerLabel);
			wgpuRenderBundleEncoderInsertDebugMarker.invoke(_renderBundleEncoder, _markerLabel);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderBundleEncoderPopDebugGroup = lookup(null, "wgpuRenderBundleEncoderPopDebugGroup", JAVA_LONG);
	public static void wgpuRenderBundleEncoderPopDebugGroup(final WGPURenderBundleEncoder renderBundleEncoder) {
		try(var stack = Stack.get()) {
			var _renderBundleEncoder = renderBundleEncoder == null ? 0L : renderBundleEncoder.handle;
			wgpuRenderBundleEncoderPopDebugGroup.invoke(_renderBundleEncoder);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderBundleEncoderPushDebugGroup = lookup(null, "wgpuRenderBundleEncoderPushDebugGroup", JAVA_LONG, JAVA_LONG);
	public static void wgpuRenderBundleEncoderPushDebugGroup(final WGPURenderBundleEncoder renderBundleEncoder, final String groupLabel) {
		try(var stack = Stack.get()) {
			var _renderBundleEncoder = renderBundleEncoder == null ? 0L : renderBundleEncoder.handle;
			var _groupLabel = stack.alloc(groupLabel);
			wgpuRenderBundleEncoderPushDebugGroup.invoke(_renderBundleEncoder, _groupLabel);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderBundleEncoderSetBindGroup = lookup(null, "wgpuRenderBundleEncoderSetBindGroup", JAVA_LONG, JAVA_INT, JAVA_LONG, JAVA_LONG, JAVA_LONG);
	public static void wgpuRenderBundleEncoderSetBindGroup(final WGPURenderBundleEncoder renderBundleEncoder, final int groupIndex, @Nullable final WGPUBindGroup group, final int[] dynamicOffsets) {
		try(var stack = Stack.get()) {
			var _renderBundleEncoder = renderBundleEncoder == null ? 0L : renderBundleEncoder.handle;
			var _groupIndex = (int) groupIndex;
			var _group = group == null ? 0L : group.handle;
			var _dynamicOffsetCount = (long) (dynamicOffsets == null ? 0 : dynamicOffsets.length);
			var _dynamicOffsets = stack.alloc(dynamicOffsets);
			wgpuRenderBundleEncoderSetBindGroup.invoke(_renderBundleEncoder, _groupIndex, _group, _dynamicOffsetCount, _dynamicOffsets);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderBundleEncoderSetIndexBuffer = lookup(null, "wgpuRenderBundleEncoderSetIndexBuffer", JAVA_LONG, JAVA_LONG, JAVA_INT, JAVA_LONG, JAVA_LONG);
	public static void wgpuRenderBundleEncoderSetIndexBuffer(final WGPURenderBundleEncoder renderBundleEncoder, final WGPUBuffer buffer, final IndexFormat format, final long offset, final long size) {
		try(var stack = Stack.get()) {
			var _renderBundleEncoder = renderBundleEncoder == null ? 0L : renderBundleEncoder.handle;
			var _buffer = buffer == null ? 0L : buffer.handle;
			var _format = format == null ? 0 : format.bits;
			var _offset = (long) offset;
			var _size = (long) size;
			wgpuRenderBundleEncoderSetIndexBuffer.invoke(_renderBundleEncoder, _buffer, _format, _offset, _size);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderBundleEncoderSetLabel = lookup(null, "wgpuRenderBundleEncoderSetLabel", JAVA_LONG, JAVA_LONG);
	public static void wgpuRenderBundleEncoderSetLabel(final WGPURenderBundleEncoder renderBundleEncoder, final String label) {
		try(var stack = Stack.get()) {
			var _renderBundleEncoder = renderBundleEncoder == null ? 0L : renderBundleEncoder.handle;
			var _label = stack.alloc(label);
			wgpuRenderBundleEncoderSetLabel.invoke(_renderBundleEncoder, _label);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderBundleEncoderSetPipeline = lookup(null, "wgpuRenderBundleEncoderSetPipeline", JAVA_LONG, JAVA_LONG);
	public static void wgpuRenderBundleEncoderSetPipeline(final WGPURenderBundleEncoder renderBundleEncoder, final WGPURenderPipeline pipeline) {
		try(var stack = Stack.get()) {
			var _renderBundleEncoder = renderBundleEncoder == null ? 0L : renderBundleEncoder.handle;
			var _pipeline = pipeline == null ? 0L : pipeline.handle;
			wgpuRenderBundleEncoderSetPipeline.invoke(_renderBundleEncoder, _pipeline);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderBundleEncoderSetVertexBuffer = lookup(null, "wgpuRenderBundleEncoderSetVertexBuffer", JAVA_LONG, JAVA_INT, JAVA_LONG, JAVA_LONG, JAVA_LONG);
	public static void wgpuRenderBundleEncoderSetVertexBuffer(final WGPURenderBundleEncoder renderBundleEncoder, final int slot, @Nullable final WGPUBuffer buffer, final long offset, final long size) {
		try(var stack = Stack.get()) {
			var _renderBundleEncoder = renderBundleEncoder == null ? 0L : renderBundleEncoder.handle;
			var _slot = (int) slot;
			var _buffer = buffer == null ? 0L : buffer.handle;
			var _offset = (long) offset;
			var _size = (long) size;
			wgpuRenderBundleEncoderSetVertexBuffer.invoke(_renderBundleEncoder, _slot, _buffer, _offset, _size);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderBundleEncoderReference = lookup(null, "wgpuRenderBundleEncoderReference", JAVA_LONG);
	public static void wgpuRenderBundleEncoderReference(final WGPURenderBundleEncoder renderBundleEncoder) {
		try(var stack = Stack.get()) {
			var _renderBundleEncoder = renderBundleEncoder == null ? 0L : renderBundleEncoder.handle;
			wgpuRenderBundleEncoderReference.invoke(_renderBundleEncoder);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderBundleEncoderRelease = lookup(null, "wgpuRenderBundleEncoderRelease", JAVA_LONG);
	public static void wgpuRenderBundleEncoderRelease(final WGPURenderBundleEncoder renderBundleEncoder) {
		try(var stack = Stack.get()) {
			var _renderBundleEncoder = renderBundleEncoder == null ? 0L : renderBundleEncoder.handle;
			wgpuRenderBundleEncoderRelease.invoke(_renderBundleEncoder);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderPassEncoderBeginOcclusionQuery = lookup(null, "wgpuRenderPassEncoderBeginOcclusionQuery", JAVA_LONG, JAVA_INT);
	public static void wgpuRenderPassEncoderBeginOcclusionQuery(final WGPURenderPassEncoder renderPassEncoder, final int queryIndex) {
		try(var stack = Stack.get()) {
			var _renderPassEncoder = renderPassEncoder == null ? 0L : renderPassEncoder.handle;
			var _queryIndex = (int) queryIndex;
			wgpuRenderPassEncoderBeginOcclusionQuery.invoke(_renderPassEncoder, _queryIndex);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderPassEncoderDraw = lookup(null, "wgpuRenderPassEncoderDraw", JAVA_LONG, JAVA_INT, JAVA_INT, JAVA_INT, JAVA_INT);
	public static void wgpuRenderPassEncoderDraw(final WGPURenderPassEncoder renderPassEncoder, final int vertexCount, final int instanceCount, final int firstVertex, final int firstInstance) {
		try(var stack = Stack.get()) {
			var _renderPassEncoder = renderPassEncoder == null ? 0L : renderPassEncoder.handle;
			var _vertexCount = (int) vertexCount;
			var _instanceCount = (int) instanceCount;
			var _firstVertex = (int) firstVertex;
			var _firstInstance = (int) firstInstance;
			wgpuRenderPassEncoderDraw.invoke(_renderPassEncoder, _vertexCount, _instanceCount, _firstVertex, _firstInstance);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderPassEncoderDrawIndexed = lookup(null, "wgpuRenderPassEncoderDrawIndexed", JAVA_LONG, JAVA_INT, JAVA_INT, JAVA_INT, JAVA_INT, JAVA_INT);
	public static void wgpuRenderPassEncoderDrawIndexed(final WGPURenderPassEncoder renderPassEncoder, final int indexCount, final int instanceCount, final int firstIndex, final int baseVertex, final int firstInstance) {
		try(var stack = Stack.get()) {
			var _renderPassEncoder = renderPassEncoder == null ? 0L : renderPassEncoder.handle;
			var _indexCount = (int) indexCount;
			var _instanceCount = (int) instanceCount;
			var _firstIndex = (int) firstIndex;
			var _baseVertex = (int) baseVertex;
			var _firstInstance = (int) firstInstance;
			wgpuRenderPassEncoderDrawIndexed.invoke(_renderPassEncoder, _indexCount, _instanceCount, _firstIndex, _baseVertex, _firstInstance);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderPassEncoderDrawIndexedIndirect = lookup(null, "wgpuRenderPassEncoderDrawIndexedIndirect", JAVA_LONG, JAVA_LONG, JAVA_LONG);
	public static void wgpuRenderPassEncoderDrawIndexedIndirect(final WGPURenderPassEncoder renderPassEncoder, final WGPUBuffer indirectBuffer, final long indirectOffset) {
		try(var stack = Stack.get()) {
			var _renderPassEncoder = renderPassEncoder == null ? 0L : renderPassEncoder.handle;
			var _indirectBuffer = indirectBuffer == null ? 0L : indirectBuffer.handle;
			var _indirectOffset = (long) indirectOffset;
			wgpuRenderPassEncoderDrawIndexedIndirect.invoke(_renderPassEncoder, _indirectBuffer, _indirectOffset);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderPassEncoderDrawIndirect = lookup(null, "wgpuRenderPassEncoderDrawIndirect", JAVA_LONG, JAVA_LONG, JAVA_LONG);
	public static void wgpuRenderPassEncoderDrawIndirect(final WGPURenderPassEncoder renderPassEncoder, final WGPUBuffer indirectBuffer, final long indirectOffset) {
		try(var stack = Stack.get()) {
			var _renderPassEncoder = renderPassEncoder == null ? 0L : renderPassEncoder.handle;
			var _indirectBuffer = indirectBuffer == null ? 0L : indirectBuffer.handle;
			var _indirectOffset = (long) indirectOffset;
			wgpuRenderPassEncoderDrawIndirect.invoke(_renderPassEncoder, _indirectBuffer, _indirectOffset);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderPassEncoderEnd = lookup(null, "wgpuRenderPassEncoderEnd", JAVA_LONG);
	public static void wgpuRenderPassEncoderEnd(final WGPURenderPassEncoder renderPassEncoder) {
		try(var stack = Stack.get()) {
			var _renderPassEncoder = renderPassEncoder == null ? 0L : renderPassEncoder.handle;
			wgpuRenderPassEncoderEnd.invoke(_renderPassEncoder);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderPassEncoderEndOcclusionQuery = lookup(null, "wgpuRenderPassEncoderEndOcclusionQuery", JAVA_LONG);
	public static void wgpuRenderPassEncoderEndOcclusionQuery(final WGPURenderPassEncoder renderPassEncoder) {
		try(var stack = Stack.get()) {
			var _renderPassEncoder = renderPassEncoder == null ? 0L : renderPassEncoder.handle;
			wgpuRenderPassEncoderEndOcclusionQuery.invoke(_renderPassEncoder);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderPassEncoderExecuteBundles = lookup(null, "wgpuRenderPassEncoderExecuteBundles", JAVA_LONG, JAVA_LONG, JAVA_LONG);
	public static void wgpuRenderPassEncoderExecuteBundles(final WGPURenderPassEncoder renderPassEncoder, final WGPURenderBundle[] bundles) {
		try(var stack = Stack.get()) {
			var _renderPassEncoder = renderPassEncoder == null ? 0L : renderPassEncoder.handle;
			var _bundleCount = (long) (bundles == null ? 0 : bundles.length);
			var _bundles = stack.alloc(bundles);
			wgpuRenderPassEncoderExecuteBundles.invoke(_renderPassEncoder, _bundleCount, _bundles);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderPassEncoderInsertDebugMarker = lookup(null, "wgpuRenderPassEncoderInsertDebugMarker", JAVA_LONG, JAVA_LONG);
	public static void wgpuRenderPassEncoderInsertDebugMarker(final WGPURenderPassEncoder renderPassEncoder, final String markerLabel) {
		try(var stack = Stack.get()) {
			var _renderPassEncoder = renderPassEncoder == null ? 0L : renderPassEncoder.handle;
			var _markerLabel = stack.alloc(markerLabel);
			wgpuRenderPassEncoderInsertDebugMarker.invoke(_renderPassEncoder, _markerLabel);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderPassEncoderPopDebugGroup = lookup(null, "wgpuRenderPassEncoderPopDebugGroup", JAVA_LONG);
	public static void wgpuRenderPassEncoderPopDebugGroup(final WGPURenderPassEncoder renderPassEncoder) {
		try(var stack = Stack.get()) {
			var _renderPassEncoder = renderPassEncoder == null ? 0L : renderPassEncoder.handle;
			wgpuRenderPassEncoderPopDebugGroup.invoke(_renderPassEncoder);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderPassEncoderPushDebugGroup = lookup(null, "wgpuRenderPassEncoderPushDebugGroup", JAVA_LONG, JAVA_LONG);
	public static void wgpuRenderPassEncoderPushDebugGroup(final WGPURenderPassEncoder renderPassEncoder, final String groupLabel) {
		try(var stack = Stack.get()) {
			var _renderPassEncoder = renderPassEncoder == null ? 0L : renderPassEncoder.handle;
			var _groupLabel = stack.alloc(groupLabel);
			wgpuRenderPassEncoderPushDebugGroup.invoke(_renderPassEncoder, _groupLabel);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderPassEncoderSetBindGroup = lookup(null, "wgpuRenderPassEncoderSetBindGroup", JAVA_LONG, JAVA_INT, JAVA_LONG, JAVA_LONG, JAVA_LONG);
	public static void wgpuRenderPassEncoderSetBindGroup(final WGPURenderPassEncoder renderPassEncoder, final int groupIndex, @Nullable final WGPUBindGroup group, final int[] dynamicOffsets) {
		try(var stack = Stack.get()) {
			var _renderPassEncoder = renderPassEncoder == null ? 0L : renderPassEncoder.handle;
			var _groupIndex = (int) groupIndex;
			var _group = group == null ? 0L : group.handle;
			var _dynamicOffsetCount = (long) (dynamicOffsets == null ? 0 : dynamicOffsets.length);
			var _dynamicOffsets = stack.alloc(dynamicOffsets);
			wgpuRenderPassEncoderSetBindGroup.invoke(_renderPassEncoder, _groupIndex, _group, _dynamicOffsetCount, _dynamicOffsets);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderPassEncoderSetBlendConstant = lookup(null, "wgpuRenderPassEncoderSetBlendConstant", JAVA_LONG, JAVA_LONG);
	public static void wgpuRenderPassEncoderSetBlendConstant(final WGPURenderPassEncoder renderPassEncoder, final Color color) {
		try(var stack = Stack.get()) {
			var _renderPassEncoder = renderPassEncoder == null ? 0L : renderPassEncoder.handle;
			var _color = stack.alloc(color);
			wgpuRenderPassEncoderSetBlendConstant.invoke(_renderPassEncoder, _color);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderPassEncoderSetIndexBuffer = lookup(null, "wgpuRenderPassEncoderSetIndexBuffer", JAVA_LONG, JAVA_LONG, JAVA_INT, JAVA_LONG, JAVA_LONG);
	public static void wgpuRenderPassEncoderSetIndexBuffer(final WGPURenderPassEncoder renderPassEncoder, final WGPUBuffer buffer, final IndexFormat format, final long offset, final long size) {
		try(var stack = Stack.get()) {
			var _renderPassEncoder = renderPassEncoder == null ? 0L : renderPassEncoder.handle;
			var _buffer = buffer == null ? 0L : buffer.handle;
			var _format = format == null ? 0 : format.bits;
			var _offset = (long) offset;
			var _size = (long) size;
			wgpuRenderPassEncoderSetIndexBuffer.invoke(_renderPassEncoder, _buffer, _format, _offset, _size);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderPassEncoderSetLabel = lookup(null, "wgpuRenderPassEncoderSetLabel", JAVA_LONG, JAVA_LONG);
	public static void wgpuRenderPassEncoderSetLabel(final WGPURenderPassEncoder renderPassEncoder, final String label) {
		try(var stack = Stack.get()) {
			var _renderPassEncoder = renderPassEncoder == null ? 0L : renderPassEncoder.handle;
			var _label = stack.alloc(label);
			wgpuRenderPassEncoderSetLabel.invoke(_renderPassEncoder, _label);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderPassEncoderSetPipeline = lookup(null, "wgpuRenderPassEncoderSetPipeline", JAVA_LONG, JAVA_LONG);
	public static void wgpuRenderPassEncoderSetPipeline(final WGPURenderPassEncoder renderPassEncoder, final WGPURenderPipeline pipeline) {
		try(var stack = Stack.get()) {
			var _renderPassEncoder = renderPassEncoder == null ? 0L : renderPassEncoder.handle;
			var _pipeline = pipeline == null ? 0L : pipeline.handle;
			wgpuRenderPassEncoderSetPipeline.invoke(_renderPassEncoder, _pipeline);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderPassEncoderSetScissorRect = lookup(null, "wgpuRenderPassEncoderSetScissorRect", JAVA_LONG, JAVA_INT, JAVA_INT, JAVA_INT, JAVA_INT);
	public static void wgpuRenderPassEncoderSetScissorRect(final WGPURenderPassEncoder renderPassEncoder, final int x, final int y, final int width, final int height) {
		try(var stack = Stack.get()) {
			var _renderPassEncoder = renderPassEncoder == null ? 0L : renderPassEncoder.handle;
			var _x = (int) x;
			var _y = (int) y;
			var _width = (int) width;
			var _height = (int) height;
			wgpuRenderPassEncoderSetScissorRect.invoke(_renderPassEncoder, _x, _y, _width, _height);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderPassEncoderSetStencilReference = lookup(null, "wgpuRenderPassEncoderSetStencilReference", JAVA_LONG, JAVA_INT);
	public static void wgpuRenderPassEncoderSetStencilReference(final WGPURenderPassEncoder renderPassEncoder, final int reference) {
		try(var stack = Stack.get()) {
			var _renderPassEncoder = renderPassEncoder == null ? 0L : renderPassEncoder.handle;
			var _reference = (int) reference;
			wgpuRenderPassEncoderSetStencilReference.invoke(_renderPassEncoder, _reference);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderPassEncoderSetVertexBuffer = lookup(null, "wgpuRenderPassEncoderSetVertexBuffer", JAVA_LONG, JAVA_INT, JAVA_LONG, JAVA_LONG, JAVA_LONG);
	public static void wgpuRenderPassEncoderSetVertexBuffer(final WGPURenderPassEncoder renderPassEncoder, final int slot, @Nullable final WGPUBuffer buffer, final long offset, final long size) {
		try(var stack = Stack.get()) {
			var _renderPassEncoder = renderPassEncoder == null ? 0L : renderPassEncoder.handle;
			var _slot = (int) slot;
			var _buffer = buffer == null ? 0L : buffer.handle;
			var _offset = (long) offset;
			var _size = (long) size;
			wgpuRenderPassEncoderSetVertexBuffer.invoke(_renderPassEncoder, _slot, _buffer, _offset, _size);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderPassEncoderSetViewport = lookup(null, "wgpuRenderPassEncoderSetViewport", JAVA_LONG, JAVA_FLOAT, JAVA_FLOAT, JAVA_FLOAT, JAVA_FLOAT, JAVA_FLOAT, JAVA_FLOAT);
	public static void wgpuRenderPassEncoderSetViewport(final WGPURenderPassEncoder renderPassEncoder, final float x, final float y, final float width, final float height, final float minDepth, final float maxDepth) {
		try(var stack = Stack.get()) {
			var _renderPassEncoder = renderPassEncoder == null ? 0L : renderPassEncoder.handle;
			var _x = (float) x;
			var _y = (float) y;
			var _width = (float) width;
			var _height = (float) height;
			var _minDepth = (float) minDepth;
			var _maxDepth = (float) maxDepth;
			wgpuRenderPassEncoderSetViewport.invoke(_renderPassEncoder, _x, _y, _width, _height, _minDepth, _maxDepth);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderPassEncoderReference = lookup(null, "wgpuRenderPassEncoderReference", JAVA_LONG);
	public static void wgpuRenderPassEncoderReference(final WGPURenderPassEncoder renderPassEncoder) {
		try(var stack = Stack.get()) {
			var _renderPassEncoder = renderPassEncoder == null ? 0L : renderPassEncoder.handle;
			wgpuRenderPassEncoderReference.invoke(_renderPassEncoder);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderPassEncoderRelease = lookup(null, "wgpuRenderPassEncoderRelease", JAVA_LONG);
	public static void wgpuRenderPassEncoderRelease(final WGPURenderPassEncoder renderPassEncoder) {
		try(var stack = Stack.get()) {
			var _renderPassEncoder = renderPassEncoder == null ? 0L : renderPassEncoder.handle;
			wgpuRenderPassEncoderRelease.invoke(_renderPassEncoder);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderPipelineGetBindGroupLayout = lookup(JAVA_LONG, "wgpuRenderPipelineGetBindGroupLayout", JAVA_LONG, JAVA_INT);
	public static WGPUBindGroupLayout wgpuRenderPipelineGetBindGroupLayout(final WGPURenderPipeline renderPipeline, final int groupIndex) {
		try(var stack = Stack.get()) {
			var _renderPipeline = renderPipeline == null ? 0L : renderPipeline.handle;
			var _groupIndex = (int) groupIndex;
			var ret = (long) wgpuRenderPipelineGetBindGroupLayout.invoke(_renderPipeline, _groupIndex);
			return ret == 0L ? null : new WGPUBindGroupLayout(ret);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderPipelineSetLabel = lookup(null, "wgpuRenderPipelineSetLabel", JAVA_LONG, JAVA_LONG);
	public static void wgpuRenderPipelineSetLabel(final WGPURenderPipeline renderPipeline, final String label) {
		try(var stack = Stack.get()) {
			var _renderPipeline = renderPipeline == null ? 0L : renderPipeline.handle;
			var _label = stack.alloc(label);
			wgpuRenderPipelineSetLabel.invoke(_renderPipeline, _label);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderPipelineReference = lookup(null, "wgpuRenderPipelineReference", JAVA_LONG);
	public static void wgpuRenderPipelineReference(final WGPURenderPipeline renderPipeline) {
		try(var stack = Stack.get()) {
			var _renderPipeline = renderPipeline == null ? 0L : renderPipeline.handle;
			wgpuRenderPipelineReference.invoke(_renderPipeline);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderPipelineRelease = lookup(null, "wgpuRenderPipelineRelease", JAVA_LONG);
	public static void wgpuRenderPipelineRelease(final WGPURenderPipeline renderPipeline) {
		try(var stack = Stack.get()) {
			var _renderPipeline = renderPipeline == null ? 0L : renderPipeline.handle;
			wgpuRenderPipelineRelease.invoke(_renderPipeline);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuSamplerSetLabel = lookup(null, "wgpuSamplerSetLabel", JAVA_LONG, JAVA_LONG);
	public static void wgpuSamplerSetLabel(final WGPUSampler sampler, final String label) {
		try(var stack = Stack.get()) {
			var _sampler = sampler == null ? 0L : sampler.handle;
			var _label = stack.alloc(label);
			wgpuSamplerSetLabel.invoke(_sampler, _label);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuSamplerReference = lookup(null, "wgpuSamplerReference", JAVA_LONG);
	public static void wgpuSamplerReference(final WGPUSampler sampler) {
		try(var stack = Stack.get()) {
			var _sampler = sampler == null ? 0L : sampler.handle;
			wgpuSamplerReference.invoke(_sampler);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuSamplerRelease = lookup(null, "wgpuSamplerRelease", JAVA_LONG);
	public static void wgpuSamplerRelease(final WGPUSampler sampler) {
		try(var stack = Stack.get()) {
			var _sampler = sampler == null ? 0L : sampler.handle;
			wgpuSamplerRelease.invoke(_sampler);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuShaderModuleGetCompilationInfo = lookup(null, "wgpuShaderModuleGetCompilationInfo", JAVA_LONG, ADDRESS, JAVA_LONG);
	public static void wgpuShaderModuleGetCompilationInfo(final WGPUShaderModule shaderModule, final ShaderModuleGetCompilationInfoCallback callback, final long userdata) {
		try(var stack = Stack.get()) {
			var _shaderModule = shaderModule == null ? 0L : shaderModule.handle;
			var _callback = WGPUCallback.createStub(callback, callback.handle, callback.desc);
			var _userdata = (long) userdata;
			wgpuShaderModuleGetCompilationInfo.invoke(_shaderModule, _callback, _userdata);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuShaderModuleSetLabel = lookup(null, "wgpuShaderModuleSetLabel", JAVA_LONG, JAVA_LONG);
	public static void wgpuShaderModuleSetLabel(final WGPUShaderModule shaderModule, final String label) {
		try(var stack = Stack.get()) {
			var _shaderModule = shaderModule == null ? 0L : shaderModule.handle;
			var _label = stack.alloc(label);
			wgpuShaderModuleSetLabel.invoke(_shaderModule, _label);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuShaderModuleReference = lookup(null, "wgpuShaderModuleReference", JAVA_LONG);
	public static void wgpuShaderModuleReference(final WGPUShaderModule shaderModule) {
		try(var stack = Stack.get()) {
			var _shaderModule = shaderModule == null ? 0L : shaderModule.handle;
			wgpuShaderModuleReference.invoke(_shaderModule);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuShaderModuleRelease = lookup(null, "wgpuShaderModuleRelease", JAVA_LONG);
	public static void wgpuShaderModuleRelease(final WGPUShaderModule shaderModule) {
		try(var stack = Stack.get()) {
			var _shaderModule = shaderModule == null ? 0L : shaderModule.handle;
			wgpuShaderModuleRelease.invoke(_shaderModule);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuSurfaceConfigure = lookup(null, "wgpuSurfaceConfigure", JAVA_LONG, JAVA_LONG);
	public static void wgpuSurfaceConfigure(final WGPUSurface surface, final SurfaceConfiguration config) {
		try(var stack = Stack.get()) {
			var _surface = surface == null ? 0L : surface.handle;
			var _config = stack.alloc(config);
			wgpuSurfaceConfigure.invoke(_surface, _config);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuSurfaceGetCapabilities = lookup(null, "wgpuSurfaceGetCapabilities", JAVA_LONG, JAVA_LONG, JAVA_LONG);
	public static void wgpuSurfaceGetCapabilities(final WGPUSurface surface, final WGPUAdapter adapter, SurfaceCapabilities capabilities) {
		try(var stack = Stack.get()) {
			var _surface = surface == null ? 0L : surface.handle;
			var _adapter = adapter == null ? 0L : adapter.handle;
			var _capabilities = stack.prealloc(capabilities);
			wgpuSurfaceGetCapabilities.invoke(_surface, _adapter, _capabilities);
			((WGPUStruct)capabilities).load(_capabilities);
			wgpuSurfaceCapabilitiesFreeMembers.invoke(wrap(_capabilities, 64));
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuSurfaceGetCurrentTexture = lookup(null, "wgpuSurfaceGetCurrentTexture", JAVA_LONG, JAVA_LONG);
	public static void wgpuSurfaceGetCurrentTexture(final WGPUSurface surface, SurfaceTexture surfaceTexture) {
		try(var stack = Stack.get()) {
			var _surface = surface == null ? 0L : surface.handle;
			var _surfaceTexture = stack.prealloc(surfaceTexture);
			wgpuSurfaceGetCurrentTexture.invoke(_surface, _surfaceTexture);
			((WGPUStruct)surfaceTexture).load(_surfaceTexture);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuSurfacePresent = lookup(null, "wgpuSurfacePresent", JAVA_LONG);
	public static void wgpuSurfacePresent(final WGPUSurface surface) {
		try(var stack = Stack.get()) {
			var _surface = surface == null ? 0L : surface.handle;
			wgpuSurfacePresent.invoke(_surface);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuSurfaceSetLabel = lookup(null, "wgpuSurfaceSetLabel", JAVA_LONG, JAVA_LONG);
	public static void wgpuSurfaceSetLabel(final WGPUSurface surface, final String label) {
		try(var stack = Stack.get()) {
			var _surface = surface == null ? 0L : surface.handle;
			var _label = stack.alloc(label);
			wgpuSurfaceSetLabel.invoke(_surface, _label);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuSurfaceUnconfigure = lookup(null, "wgpuSurfaceUnconfigure", JAVA_LONG);
	public static void wgpuSurfaceUnconfigure(final WGPUSurface surface) {
		try(var stack = Stack.get()) {
			var _surface = surface == null ? 0L : surface.handle;
			wgpuSurfaceUnconfigure.invoke(_surface);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuSurfaceReference = lookup(null, "wgpuSurfaceReference", JAVA_LONG);
	public static void wgpuSurfaceReference(final WGPUSurface surface) {
		try(var stack = Stack.get()) {
			var _surface = surface == null ? 0L : surface.handle;
			wgpuSurfaceReference.invoke(_surface);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuSurfaceRelease = lookup(null, "wgpuSurfaceRelease", JAVA_LONG);
	public static void wgpuSurfaceRelease(final WGPUSurface surface) {
		try(var stack = Stack.get()) {
			var _surface = surface == null ? 0L : surface.handle;
			wgpuSurfaceRelease.invoke(_surface);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuSurfaceCapabilitiesFreeMembers = lookup(null, "wgpuSurfaceCapabilitiesFreeMembers", STRUCT(64));

	private static final MethodHandle wgpuTextureCreateView = lookup(JAVA_LONG, "wgpuTextureCreateView", JAVA_LONG, JAVA_LONG);
	public static WGPUTextureView wgpuTextureCreateView(final WGPUTexture texture, @Nullable final TextureViewDescriptor descriptor) {
		try(var stack = Stack.get()) {
			var _texture = texture == null ? 0L : texture.handle;
			var _descriptor = stack.alloc(descriptor);
			var ret = (long) wgpuTextureCreateView.invoke(_texture, _descriptor);
			return ret == 0L ? null : new WGPUTextureView(ret);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuTextureDestroy = lookup(null, "wgpuTextureDestroy", JAVA_LONG);
	public static void wgpuTextureDestroy(final WGPUTexture texture) {
		try(var stack = Stack.get()) {
			var _texture = texture == null ? 0L : texture.handle;
			wgpuTextureDestroy.invoke(_texture);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuTextureGetDepthOrArrayLayers = lookup(JAVA_INT, "wgpuTextureGetDepthOrArrayLayers", JAVA_LONG);
	public static int wgpuTextureGetDepthOrArrayLayers(final WGPUTexture texture) {
		try(var stack = Stack.get()) {
			var _texture = texture == null ? 0L : texture.handle;
			var ret = (int) wgpuTextureGetDepthOrArrayLayers.invoke(_texture);
			return ret;
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuTextureGetDimension = lookup(JAVA_INT, "wgpuTextureGetDimension", JAVA_LONG);
	public static TextureDimension wgpuTextureGetDimension(final WGPUTexture texture) {
		try(var stack = Stack.get()) {
			var _texture = texture == null ? 0L : texture.handle;
			var ret = (int) wgpuTextureGetDimension.invoke(_texture);
			return TextureDimension.from(ret);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuTextureGetFormat = lookup(JAVA_INT, "wgpuTextureGetFormat", JAVA_LONG);
	public static TextureFormat wgpuTextureGetFormat(final WGPUTexture texture) {
		try(var stack = Stack.get()) {
			var _texture = texture == null ? 0L : texture.handle;
			var ret = (int) wgpuTextureGetFormat.invoke(_texture);
			return TextureFormat.from(ret);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuTextureGetHeight = lookup(JAVA_INT, "wgpuTextureGetHeight", JAVA_LONG);
	public static int wgpuTextureGetHeight(final WGPUTexture texture) {
		try(var stack = Stack.get()) {
			var _texture = texture == null ? 0L : texture.handle;
			var ret = (int) wgpuTextureGetHeight.invoke(_texture);
			return ret;
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuTextureGetMipLevelCount = lookup(JAVA_INT, "wgpuTextureGetMipLevelCount", JAVA_LONG);
	public static int wgpuTextureGetMipLevelCount(final WGPUTexture texture) {
		try(var stack = Stack.get()) {
			var _texture = texture == null ? 0L : texture.handle;
			var ret = (int) wgpuTextureGetMipLevelCount.invoke(_texture);
			return ret;
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuTextureGetSampleCount = lookup(JAVA_INT, "wgpuTextureGetSampleCount", JAVA_LONG);
	public static int wgpuTextureGetSampleCount(final WGPUTexture texture) {
		try(var stack = Stack.get()) {
			var _texture = texture == null ? 0L : texture.handle;
			var ret = (int) wgpuTextureGetSampleCount.invoke(_texture);
			return ret;
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuTextureGetUsage = lookup(JAVA_INT, "wgpuTextureGetUsage", JAVA_LONG);
	public static int wgpuTextureGetUsage(final WGPUTexture texture) {
		try(var stack = Stack.get()) {
			var _texture = texture == null ? 0L : texture.handle;
			var ret = (int) wgpuTextureGetUsage.invoke(_texture);
			return ret;
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuTextureGetWidth = lookup(JAVA_INT, "wgpuTextureGetWidth", JAVA_LONG);
	public static int wgpuTextureGetWidth(final WGPUTexture texture) {
		try(var stack = Stack.get()) {
			var _texture = texture == null ? 0L : texture.handle;
			var ret = (int) wgpuTextureGetWidth.invoke(_texture);
			return ret;
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuTextureSetLabel = lookup(null, "wgpuTextureSetLabel", JAVA_LONG, JAVA_LONG);
	public static void wgpuTextureSetLabel(final WGPUTexture texture, final String label) {
		try(var stack = Stack.get()) {
			var _texture = texture == null ? 0L : texture.handle;
			var _label = stack.alloc(label);
			wgpuTextureSetLabel.invoke(_texture, _label);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuTextureReference = lookup(null, "wgpuTextureReference", JAVA_LONG);
	public static void wgpuTextureReference(final WGPUTexture texture) {
		try(var stack = Stack.get()) {
			var _texture = texture == null ? 0L : texture.handle;
			wgpuTextureReference.invoke(_texture);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuTextureRelease = lookup(null, "wgpuTextureRelease", JAVA_LONG);
	public static void wgpuTextureRelease(final WGPUTexture texture) {
		try(var stack = Stack.get()) {
			var _texture = texture == null ? 0L : texture.handle;
			wgpuTextureRelease.invoke(_texture);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuTextureViewSetLabel = lookup(null, "wgpuTextureViewSetLabel", JAVA_LONG, JAVA_LONG);
	public static void wgpuTextureViewSetLabel(final WGPUTextureView textureView, final String label) {
		try(var stack = Stack.get()) {
			var _textureView = textureView == null ? 0L : textureView.handle;
			var _label = stack.alloc(label);
			wgpuTextureViewSetLabel.invoke(_textureView, _label);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuTextureViewReference = lookup(null, "wgpuTextureViewReference", JAVA_LONG);
	public static void wgpuTextureViewReference(final WGPUTextureView textureView) {
		try(var stack = Stack.get()) {
			var _textureView = textureView == null ? 0L : textureView.handle;
			wgpuTextureViewReference.invoke(_textureView);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuTextureViewRelease = lookup(null, "wgpuTextureViewRelease", JAVA_LONG);
	public static void wgpuTextureViewRelease(final WGPUTextureView textureView) {
		try(var stack = Stack.get()) {
			var _textureView = textureView == null ? 0L : textureView.handle;
			wgpuTextureViewRelease.invoke(_textureView);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuGenerateReport = lookup(null, "wgpuGenerateReport", JAVA_LONG, JAVA_LONG);
	public static void wgpuGenerateReport(final WGPUInstance instance, GlobalReport report) {
		try(var stack = Stack.get()) {
			var _instance = instance == null ? 0L : instance.handle;
			var _report = stack.prealloc(report);
			wgpuGenerateReport.invoke(_instance, _report);
			((WGPUStruct)report).load(_report);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuInstanceEnumerateAdapters = lookup(JAVA_LONG, "wgpuInstanceEnumerateAdapters", JAVA_LONG, JAVA_LONG, JAVA_LONG);
	public static long wgpuInstanceEnumerateAdapters(final WGPUInstance instance, @Nullable final InstanceEnumerateAdapterOptions options, WGPUAdapter[] adapters) {
		try(var stack = Stack.get()) {
			var _instance = instance == null ? 0L : instance.handle;
			var _options = stack.alloc(options);
			var _adapters = stack.prealloc(adapters);
			var ret = (long) wgpuInstanceEnumerateAdapters.invoke(_instance, _options, _adapters);
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
	public static long wgpuQueueSubmitForIndex(final WGPUQueue queue, final WGPUCommandBuffer[] commands) {
		try(var stack = Stack.get()) {
			var _queue = queue == null ? 0L : queue.handle;
			var _commandCount = (long) (commands == null ? 0 : commands.length);
			var _commands = stack.alloc(commands);
			var ret = (long) wgpuQueueSubmitForIndex.invoke(_queue, _commandCount, _commands);
			return ret;
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuDevicePoll = lookup(JAVA_INT, "wgpuDevicePoll", JAVA_LONG, JAVA_INT, JAVA_LONG);
	public static boolean wgpuDevicePoll(final WGPUDevice device, final boolean wait, @Nullable final WrappedSubmissionIndex wrappedSubmissionIndex) {
		try(var stack = Stack.get()) {
			var _device = device == null ? 0L : device.handle;
			var _wait = (int) (wait ? 1 : 0);
			var _wrappedSubmissionIndex = stack.alloc(wrappedSubmissionIndex);
			var ret = (int) wgpuDevicePoll.invoke(_device, _wait, _wrappedSubmissionIndex);
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
			wgpuSetLogCallback.invoke(_callback, _userdata);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuSetLogLevel = lookup(null, "wgpuSetLogLevel", JAVA_INT);
	public static void wgpuSetLogLevel(final LogLevel level) {
		try(var stack = Stack.get()) {
			var _level = level == null ? 0 : level.bits;
			wgpuSetLogLevel.invoke(_level);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuGetVersion = lookup(JAVA_INT, "wgpuGetVersion");
	public static int wgpuGetVersion() {
		try(var stack = Stack.get()) {
			var ret = (int) wgpuGetVersion.invoke();
			return ret;
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderPassEncoderSetPushConstants = lookup(null, "wgpuRenderPassEncoderSetPushConstants", JAVA_LONG, JAVA_INT, JAVA_INT, JAVA_INT, JAVA_LONG);
	public static void wgpuRenderPassEncoderSetPushConstants(final WGPURenderPassEncoder encoder, final int stages, final int offset, final int sizeBytes, final MemorySegment data) {
		try(var stack = Stack.get()) {
			var _encoder = encoder == null ? 0L : encoder.handle;
			var _stages = (int) stages;
			var _offset = (int) offset;
			var _sizeBytes = (int) sizeBytes;
			var _data = data;
			wgpuRenderPassEncoderSetPushConstants.invoke(_encoder, _stages, _offset, _sizeBytes, _data);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderPassEncoderMultiDrawIndirect = lookup(null, "wgpuRenderPassEncoderMultiDrawIndirect", JAVA_LONG, JAVA_LONG, JAVA_LONG, JAVA_INT);
	public static void wgpuRenderPassEncoderMultiDrawIndirect(final WGPURenderPassEncoder encoder, final WGPUBuffer buffer, final long offset, final int count) {
		try(var stack = Stack.get()) {
			var _encoder = encoder == null ? 0L : encoder.handle;
			var _buffer = buffer == null ? 0L : buffer.handle;
			var _offset = (long) offset;
			var _count = (int) count;
			wgpuRenderPassEncoderMultiDrawIndirect.invoke(_encoder, _buffer, _offset, _count);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderPassEncoderMultiDrawIndexedIndirect = lookup(null, "wgpuRenderPassEncoderMultiDrawIndexedIndirect", JAVA_LONG, JAVA_LONG, JAVA_LONG, JAVA_INT);
	public static void wgpuRenderPassEncoderMultiDrawIndexedIndirect(final WGPURenderPassEncoder encoder, final WGPUBuffer buffer, final long offset, final int count) {
		try(var stack = Stack.get()) {
			var _encoder = encoder == null ? 0L : encoder.handle;
			var _buffer = buffer == null ? 0L : buffer.handle;
			var _offset = (long) offset;
			var _count = (int) count;
			wgpuRenderPassEncoderMultiDrawIndexedIndirect.invoke(_encoder, _buffer, _offset, _count);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderPassEncoderMultiDrawIndirectCount = lookup(null, "wgpuRenderPassEncoderMultiDrawIndirectCount", JAVA_LONG, JAVA_LONG, JAVA_LONG, JAVA_LONG, JAVA_LONG, JAVA_INT);
	public static void wgpuRenderPassEncoderMultiDrawIndirectCount(final WGPURenderPassEncoder encoder, final WGPUBuffer buffer, final long offset, final WGPUBuffer count_buffer, final long count_buffer_offset, final int max_count) {
		try(var stack = Stack.get()) {
			var _encoder = encoder == null ? 0L : encoder.handle;
			var _buffer = buffer == null ? 0L : buffer.handle;
			var _offset = (long) offset;
			var _count_buffer = count_buffer == null ? 0L : count_buffer.handle;
			var _count_buffer_offset = (long) count_buffer_offset;
			var _max_count = (int) max_count;
			wgpuRenderPassEncoderMultiDrawIndirectCount.invoke(_encoder, _buffer, _offset, _count_buffer, _count_buffer_offset, _max_count);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderPassEncoderMultiDrawIndexedIndirectCount = lookup(null, "wgpuRenderPassEncoderMultiDrawIndexedIndirectCount", JAVA_LONG, JAVA_LONG, JAVA_LONG, JAVA_LONG, JAVA_LONG, JAVA_INT);
	public static void wgpuRenderPassEncoderMultiDrawIndexedIndirectCount(final WGPURenderPassEncoder encoder, final WGPUBuffer buffer, final long offset, final WGPUBuffer count_buffer, final long count_buffer_offset, final int max_count) {
		try(var stack = Stack.get()) {
			var _encoder = encoder == null ? 0L : encoder.handle;
			var _buffer = buffer == null ? 0L : buffer.handle;
			var _offset = (long) offset;
			var _count_buffer = count_buffer == null ? 0L : count_buffer.handle;
			var _count_buffer_offset = (long) count_buffer_offset;
			var _max_count = (int) max_count;
			wgpuRenderPassEncoderMultiDrawIndexedIndirectCount.invoke(_encoder, _buffer, _offset, _count_buffer, _count_buffer_offset, _max_count);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuComputePassEncoderBeginPipelineStatisticsQuery = lookup(null, "wgpuComputePassEncoderBeginPipelineStatisticsQuery", JAVA_LONG, JAVA_LONG, JAVA_INT);
	public static void wgpuComputePassEncoderBeginPipelineStatisticsQuery(final WGPUComputePassEncoder computePassEncoder, final WGPUQuerySet querySet, final int queryIndex) {
		try(var stack = Stack.get()) {
			var _computePassEncoder = computePassEncoder == null ? 0L : computePassEncoder.handle;
			var _querySet = querySet == null ? 0L : querySet.handle;
			var _queryIndex = (int) queryIndex;
			wgpuComputePassEncoderBeginPipelineStatisticsQuery.invoke(_computePassEncoder, _querySet, _queryIndex);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuComputePassEncoderEndPipelineStatisticsQuery = lookup(null, "wgpuComputePassEncoderEndPipelineStatisticsQuery", JAVA_LONG);
	public static void wgpuComputePassEncoderEndPipelineStatisticsQuery(final WGPUComputePassEncoder computePassEncoder) {
		try(var stack = Stack.get()) {
			var _computePassEncoder = computePassEncoder == null ? 0L : computePassEncoder.handle;
			wgpuComputePassEncoderEndPipelineStatisticsQuery.invoke(_computePassEncoder);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderPassEncoderBeginPipelineStatisticsQuery = lookup(null, "wgpuRenderPassEncoderBeginPipelineStatisticsQuery", JAVA_LONG, JAVA_LONG, JAVA_INT);
	public static void wgpuRenderPassEncoderBeginPipelineStatisticsQuery(final WGPURenderPassEncoder renderPassEncoder, final WGPUQuerySet querySet, final int queryIndex) {
		try(var stack = Stack.get()) {
			var _renderPassEncoder = renderPassEncoder == null ? 0L : renderPassEncoder.handle;
			var _querySet = querySet == null ? 0L : querySet.handle;
			var _queryIndex = (int) queryIndex;
			wgpuRenderPassEncoderBeginPipelineStatisticsQuery.invoke(_renderPassEncoder, _querySet, _queryIndex);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderPassEncoderEndPipelineStatisticsQuery = lookup(null, "wgpuRenderPassEncoderEndPipelineStatisticsQuery", JAVA_LONG);
	public static void wgpuRenderPassEncoderEndPipelineStatisticsQuery(final WGPURenderPassEncoder renderPassEncoder) {
		try(var stack = Stack.get()) {
			var _renderPassEncoder = renderPassEncoder == null ? 0L : renderPassEncoder.handle;
			wgpuRenderPassEncoderEndPipelineStatisticsQuery.invoke(_renderPassEncoder);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

}
