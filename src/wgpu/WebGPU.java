package wgpu;

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

import static wgpu.Natives.*;
import java.lang.invoke.MethodHandle;

public class WebGPU {
	private static final MethodHandle wgpuCreateInstance = lookup(POINTER, "wgpuCreateInstance", POINTER);
	public static WGPUInstance wgpuCreateInstance(@Nullable final InstanceDescriptor descriptor) {
		try(var arena = Arena.ofConfined()) {
			var _descriptor = pointer(arena, descriptor);
			var ret = (MemorySegment) wgpuCreateInstance.invoke(_descriptor);
			return ret == null ? null : new WGPUInstance(ret);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuGetProcAddress = lookup(POINTER, "wgpuGetProcAddress", POINTER, POINTER);
	public static MemorySegment wgpuGetProcAddress(final WGPUDevice device, final String procName) {
		try(var arena = Arena.ofConfined()) {
			var _device = pointer(arena, device);
			var _procName = pointer(arena, procName);
			var ret = (MemorySegment) wgpuGetProcAddress.invoke(_device, _procName);
			return ret;
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuAdapterEnumerateFeatures = lookup(JAVA_LONG, "wgpuAdapterEnumerateFeatures", POINTER, POINTER);
	public static long wgpuAdapterEnumerateFeatures(final WGPUAdapter adapter, FeatureName[] features) {
		try(var arena = Arena.ofConfined()) {
			var _adapter = pointer(arena, adapter);
			var _features = pointer(arena, features);
			var ret = (long) wgpuAdapterEnumerateFeatures.invoke(_adapter, _features);
			if(features != null) {
				var in = new WGPUReader(_features);
				for(int i=0; i<features.length; i++) {
					features[i] = FeatureName.from(in.read_int());
				}
			}
			return ret;
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuAdapterGetInfo = lookup(null, "wgpuAdapterGetInfo", POINTER, POINTER);
	public static void wgpuAdapterGetInfo(final WGPUAdapter adapter, AdapterInfo info) {
		try(var arena = Arena.ofConfined()) {
			var _adapter = pointer(arena, adapter);
			var _info = pointer(arena, info);
			wgpuAdapterGetInfo.invoke(_adapter, _info);
			info.readFrom(_info);
			wgpuAdapterInfoFreeMembers.invoke(_info);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuAdapterGetLimits = lookup(JAVA_INT, "wgpuAdapterGetLimits", POINTER, POINTER);
	public static boolean wgpuAdapterGetLimits(final WGPUAdapter adapter, SupportedLimits limits) {
		try(var arena = Arena.ofConfined()) {
			var _adapter = pointer(arena, adapter);
			var _limits = pointer(arena, limits);
			var ret = (int) wgpuAdapterGetLimits.invoke(_adapter, _limits);
			limits.readFrom(_limits);
			return ret != 0;
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuAdapterHasFeature = lookup(JAVA_INT, "wgpuAdapterHasFeature", POINTER, JAVA_INT);
	public static boolean wgpuAdapterHasFeature(final WGPUAdapter adapter, final FeatureName feature) {
		try(var arena = Arena.ofConfined()) {
			var _adapter = pointer(arena, adapter);
			var _feature = value(arena, feature);
			var ret = (int) wgpuAdapterHasFeature.invoke(_adapter, _feature);
			return ret != 0;
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuAdapterRequestDevice = lookup(null, "wgpuAdapterRequestDevice", POINTER, POINTER, POINTER, JAVA_LONG);
	public static void wgpuAdapterRequestDevice(final WGPUAdapter adapter, @Nullable final DeviceDescriptor descriptor, final AdapterRequestDeviceCallback callback, final long userdata) {
		try(var arena = Arena.ofConfined()) {
			var _adapter = pointer(arena, adapter);
			var _descriptor = pointer(arena, descriptor);
			var _callback = pointer(arena, WGPUCallback.createStub(callback, callback.handle, callback.desc));
			var _userdata = value(arena, userdata);
			wgpuAdapterRequestDevice.invoke(_adapter, _descriptor, _callback, _userdata);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuAdapterReference = lookup(null, "wgpuAdapterReference", POINTER);
	public static void wgpuAdapterReference(final WGPUAdapter adapter) {
		try(var arena = Arena.ofConfined()) {
			var _adapter = pointer(arena, adapter);
			wgpuAdapterReference.invoke(_adapter);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuAdapterRelease = lookup(null, "wgpuAdapterRelease", POINTER);
	public static void wgpuAdapterRelease(final WGPUAdapter adapter) {
		try(var arena = Arena.ofConfined()) {
			var _adapter = pointer(arena, adapter);
			wgpuAdapterRelease.invoke(_adapter);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuAdapterInfoFreeMembers = lookup(null, "wgpuAdapterInfoFreeMembers", STRUCT(56));

	private static final MethodHandle wgpuBindGroupSetLabel = lookup(null, "wgpuBindGroupSetLabel", POINTER, POINTER);
	public static void wgpuBindGroupSetLabel(final WGPUBindGroup bindGroup, final String label) {
		try(var arena = Arena.ofConfined()) {
			var _bindGroup = pointer(arena, bindGroup);
			var _label = pointer(arena, label);
			wgpuBindGroupSetLabel.invoke(_bindGroup, _label);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuBindGroupReference = lookup(null, "wgpuBindGroupReference", POINTER);
	public static void wgpuBindGroupReference(final WGPUBindGroup bindGroup) {
		try(var arena = Arena.ofConfined()) {
			var _bindGroup = pointer(arena, bindGroup);
			wgpuBindGroupReference.invoke(_bindGroup);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuBindGroupRelease = lookup(null, "wgpuBindGroupRelease", POINTER);
	public static void wgpuBindGroupRelease(final WGPUBindGroup bindGroup) {
		try(var arena = Arena.ofConfined()) {
			var _bindGroup = pointer(arena, bindGroup);
			wgpuBindGroupRelease.invoke(_bindGroup);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuBindGroupLayoutSetLabel = lookup(null, "wgpuBindGroupLayoutSetLabel", POINTER, POINTER);
	public static void wgpuBindGroupLayoutSetLabel(final WGPUBindGroupLayout bindGroupLayout, final String label) {
		try(var arena = Arena.ofConfined()) {
			var _bindGroupLayout = pointer(arena, bindGroupLayout);
			var _label = pointer(arena, label);
			wgpuBindGroupLayoutSetLabel.invoke(_bindGroupLayout, _label);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuBindGroupLayoutReference = lookup(null, "wgpuBindGroupLayoutReference", POINTER);
	public static void wgpuBindGroupLayoutReference(final WGPUBindGroupLayout bindGroupLayout) {
		try(var arena = Arena.ofConfined()) {
			var _bindGroupLayout = pointer(arena, bindGroupLayout);
			wgpuBindGroupLayoutReference.invoke(_bindGroupLayout);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuBindGroupLayoutRelease = lookup(null, "wgpuBindGroupLayoutRelease", POINTER);
	public static void wgpuBindGroupLayoutRelease(final WGPUBindGroupLayout bindGroupLayout) {
		try(var arena = Arena.ofConfined()) {
			var _bindGroupLayout = pointer(arena, bindGroupLayout);
			wgpuBindGroupLayoutRelease.invoke(_bindGroupLayout);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuBufferDestroy = lookup(null, "wgpuBufferDestroy", POINTER);
	public static void wgpuBufferDestroy(final WGPUBuffer buffer) {
		try(var arena = Arena.ofConfined()) {
			var _buffer = pointer(arena, buffer);
			wgpuBufferDestroy.invoke(_buffer);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuBufferGetConstMappedRange = lookup(POINTER, "wgpuBufferGetConstMappedRange", POINTER, JAVA_LONG, JAVA_LONG);
	public static void wgpuBufferGetConstMappedRange(final WGPUBuffer buffer, final long offset, final long size) {
		try(var arena = Arena.ofConfined()) {
			var _buffer = pointer(arena, buffer);
			var _offset = value(arena, offset);
			var _size = value(arena, size);
			var ret = (MemorySegment) wgpuBufferGetConstMappedRange.invoke(_buffer, _offset, _size);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuBufferGetMapState = lookup(JAVA_INT, "wgpuBufferGetMapState", POINTER);
	public static BufferMapState wgpuBufferGetMapState(final WGPUBuffer buffer) {
		try(var arena = Arena.ofConfined()) {
			var _buffer = pointer(arena, buffer);
			var ret = (int) wgpuBufferGetMapState.invoke(_buffer);
			return BufferMapState.from(ret);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuBufferGetMappedRange = lookup(POINTER, "wgpuBufferGetMappedRange", POINTER, JAVA_LONG, JAVA_LONG);
	public static void wgpuBufferGetMappedRange(final WGPUBuffer buffer, final long offset, final long size) {
		try(var arena = Arena.ofConfined()) {
			var _buffer = pointer(arena, buffer);
			var _offset = value(arena, offset);
			var _size = value(arena, size);
			var ret = (MemorySegment) wgpuBufferGetMappedRange.invoke(_buffer, _offset, _size);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuBufferGetSize = lookup(JAVA_LONG, "wgpuBufferGetSize", POINTER);
	public static long wgpuBufferGetSize(final WGPUBuffer buffer) {
		try(var arena = Arena.ofConfined()) {
			var _buffer = pointer(arena, buffer);
			var ret = (long) wgpuBufferGetSize.invoke(_buffer);
			return ret;
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuBufferGetUsage = lookup(JAVA_INT, "wgpuBufferGetUsage", POINTER);
	public static int wgpuBufferGetUsage(final WGPUBuffer buffer) {
		try(var arena = Arena.ofConfined()) {
			var _buffer = pointer(arena, buffer);
			var ret = (int) wgpuBufferGetUsage.invoke(_buffer);
			return ret;
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuBufferMapAsync = lookup(null, "wgpuBufferMapAsync", POINTER, JAVA_INT, JAVA_LONG, JAVA_LONG, POINTER, JAVA_LONG);
	public static void wgpuBufferMapAsync(final WGPUBuffer buffer, final int mode, final long offset, final long size, final BufferMapAsyncCallback callback, final long userdata) {
		try(var arena = Arena.ofConfined()) {
			var _buffer = pointer(arena, buffer);
			var _mode = value(arena, mode);
			var _offset = value(arena, offset);
			var _size = value(arena, size);
			var _callback = pointer(arena, WGPUCallback.createStub(callback, callback.handle, callback.desc));
			var _userdata = value(arena, userdata);
			wgpuBufferMapAsync.invoke(_buffer, _mode, _offset, _size, _callback, _userdata);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuBufferSetLabel = lookup(null, "wgpuBufferSetLabel", POINTER, POINTER);
	public static void wgpuBufferSetLabel(final WGPUBuffer buffer, final String label) {
		try(var arena = Arena.ofConfined()) {
			var _buffer = pointer(arena, buffer);
			var _label = pointer(arena, label);
			wgpuBufferSetLabel.invoke(_buffer, _label);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuBufferUnmap = lookup(null, "wgpuBufferUnmap", POINTER);
	public static void wgpuBufferUnmap(final WGPUBuffer buffer) {
		try(var arena = Arena.ofConfined()) {
			var _buffer = pointer(arena, buffer);
			wgpuBufferUnmap.invoke(_buffer);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuBufferReference = lookup(null, "wgpuBufferReference", POINTER);
	public static void wgpuBufferReference(final WGPUBuffer buffer) {
		try(var arena = Arena.ofConfined()) {
			var _buffer = pointer(arena, buffer);
			wgpuBufferReference.invoke(_buffer);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuBufferRelease = lookup(null, "wgpuBufferRelease", POINTER);
	public static void wgpuBufferRelease(final WGPUBuffer buffer) {
		try(var arena = Arena.ofConfined()) {
			var _buffer = pointer(arena, buffer);
			wgpuBufferRelease.invoke(_buffer);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuCommandBufferSetLabel = lookup(null, "wgpuCommandBufferSetLabel", POINTER, POINTER);
	public static void wgpuCommandBufferSetLabel(final WGPUCommandBuffer commandBuffer, final String label) {
		try(var arena = Arena.ofConfined()) {
			var _commandBuffer = pointer(arena, commandBuffer);
			var _label = pointer(arena, label);
			wgpuCommandBufferSetLabel.invoke(_commandBuffer, _label);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuCommandBufferReference = lookup(null, "wgpuCommandBufferReference", POINTER);
	public static void wgpuCommandBufferReference(final WGPUCommandBuffer commandBuffer) {
		try(var arena = Arena.ofConfined()) {
			var _commandBuffer = pointer(arena, commandBuffer);
			wgpuCommandBufferReference.invoke(_commandBuffer);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuCommandBufferRelease = lookup(null, "wgpuCommandBufferRelease", POINTER);
	public static void wgpuCommandBufferRelease(final WGPUCommandBuffer commandBuffer) {
		try(var arena = Arena.ofConfined()) {
			var _commandBuffer = pointer(arena, commandBuffer);
			wgpuCommandBufferRelease.invoke(_commandBuffer);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuCommandEncoderBeginComputePass = lookup(POINTER, "wgpuCommandEncoderBeginComputePass", POINTER, POINTER);
	public static WGPUComputePassEncoder wgpuCommandEncoderBeginComputePass(final WGPUCommandEncoder commandEncoder, @Nullable final ComputePassDescriptor descriptor) {
		try(var arena = Arena.ofConfined()) {
			var _commandEncoder = pointer(arena, commandEncoder);
			var _descriptor = pointer(arena, descriptor);
			var ret = (MemorySegment) wgpuCommandEncoderBeginComputePass.invoke(_commandEncoder, _descriptor);
			return ret == null ? null : new WGPUComputePassEncoder(ret);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuCommandEncoderBeginRenderPass = lookup(POINTER, "wgpuCommandEncoderBeginRenderPass", POINTER, POINTER);
	public static WGPURenderPassEncoder wgpuCommandEncoderBeginRenderPass(final WGPUCommandEncoder commandEncoder, final RenderPassDescriptor descriptor) {
		try(var arena = Arena.ofConfined()) {
			var _commandEncoder = pointer(arena, commandEncoder);
			var _descriptor = pointer(arena, descriptor);
			var ret = (MemorySegment) wgpuCommandEncoderBeginRenderPass.invoke(_commandEncoder, _descriptor);
			return ret == null ? null : new WGPURenderPassEncoder(ret);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuCommandEncoderClearBuffer = lookup(null, "wgpuCommandEncoderClearBuffer", POINTER, POINTER, JAVA_LONG, JAVA_LONG);
	public static void wgpuCommandEncoderClearBuffer(final WGPUCommandEncoder commandEncoder, final WGPUBuffer buffer, final long offset, final long size) {
		try(var arena = Arena.ofConfined()) {
			var _commandEncoder = pointer(arena, commandEncoder);
			var _buffer = pointer(arena, buffer);
			var _offset = value(arena, offset);
			var _size = value(arena, size);
			wgpuCommandEncoderClearBuffer.invoke(_commandEncoder, _buffer, _offset, _size);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuCommandEncoderCopyBufferToBuffer = lookup(null, "wgpuCommandEncoderCopyBufferToBuffer", POINTER, POINTER, JAVA_LONG, POINTER, JAVA_LONG, JAVA_LONG);
	public static void wgpuCommandEncoderCopyBufferToBuffer(final WGPUCommandEncoder commandEncoder, final WGPUBuffer source, final long sourceOffset, final WGPUBuffer destination, final long destinationOffset, final long size) {
		try(var arena = Arena.ofConfined()) {
			var _commandEncoder = pointer(arena, commandEncoder);
			var _source = pointer(arena, source);
			var _sourceOffset = value(arena, sourceOffset);
			var _destination = pointer(arena, destination);
			var _destinationOffset = value(arena, destinationOffset);
			var _size = value(arena, size);
			wgpuCommandEncoderCopyBufferToBuffer.invoke(_commandEncoder, _source, _sourceOffset, _destination, _destinationOffset, _size);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuCommandEncoderCopyBufferToTexture = lookup(null, "wgpuCommandEncoderCopyBufferToTexture", POINTER, POINTER, POINTER, POINTER);
	public static void wgpuCommandEncoderCopyBufferToTexture(final WGPUCommandEncoder commandEncoder, final ImageCopyBuffer source, final ImageCopyTexture destination, final Extent3D copySize) {
		try(var arena = Arena.ofConfined()) {
			var _commandEncoder = pointer(arena, commandEncoder);
			var _source = pointer(arena, source);
			var _destination = pointer(arena, destination);
			var _copySize = pointer(arena, copySize);
			wgpuCommandEncoderCopyBufferToTexture.invoke(_commandEncoder, _source, _destination, _copySize);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuCommandEncoderCopyTextureToBuffer = lookup(null, "wgpuCommandEncoderCopyTextureToBuffer", POINTER, POINTER, POINTER, POINTER);
	public static void wgpuCommandEncoderCopyTextureToBuffer(final WGPUCommandEncoder commandEncoder, final ImageCopyTexture source, final ImageCopyBuffer destination, final Extent3D copySize) {
		try(var arena = Arena.ofConfined()) {
			var _commandEncoder = pointer(arena, commandEncoder);
			var _source = pointer(arena, source);
			var _destination = pointer(arena, destination);
			var _copySize = pointer(arena, copySize);
			wgpuCommandEncoderCopyTextureToBuffer.invoke(_commandEncoder, _source, _destination, _copySize);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuCommandEncoderCopyTextureToTexture = lookup(null, "wgpuCommandEncoderCopyTextureToTexture", POINTER, POINTER, POINTER, POINTER);
	public static void wgpuCommandEncoderCopyTextureToTexture(final WGPUCommandEncoder commandEncoder, final ImageCopyTexture source, final ImageCopyTexture destination, final Extent3D copySize) {
		try(var arena = Arena.ofConfined()) {
			var _commandEncoder = pointer(arena, commandEncoder);
			var _source = pointer(arena, source);
			var _destination = pointer(arena, destination);
			var _copySize = pointer(arena, copySize);
			wgpuCommandEncoderCopyTextureToTexture.invoke(_commandEncoder, _source, _destination, _copySize);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuCommandEncoderFinish = lookup(POINTER, "wgpuCommandEncoderFinish", POINTER, POINTER);
	public static WGPUCommandBuffer wgpuCommandEncoderFinish(final WGPUCommandEncoder commandEncoder, @Nullable final CommandBufferDescriptor descriptor) {
		try(var arena = Arena.ofConfined()) {
			var _commandEncoder = pointer(arena, commandEncoder);
			var _descriptor = pointer(arena, descriptor);
			var ret = (MemorySegment) wgpuCommandEncoderFinish.invoke(_commandEncoder, _descriptor);
			return ret == null ? null : new WGPUCommandBuffer(ret);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuCommandEncoderInsertDebugMarker = lookup(null, "wgpuCommandEncoderInsertDebugMarker", POINTER, POINTER);
	public static void wgpuCommandEncoderInsertDebugMarker(final WGPUCommandEncoder commandEncoder, final String markerLabel) {
		try(var arena = Arena.ofConfined()) {
			var _commandEncoder = pointer(arena, commandEncoder);
			var _markerLabel = pointer(arena, markerLabel);
			wgpuCommandEncoderInsertDebugMarker.invoke(_commandEncoder, _markerLabel);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuCommandEncoderPopDebugGroup = lookup(null, "wgpuCommandEncoderPopDebugGroup", POINTER);
	public static void wgpuCommandEncoderPopDebugGroup(final WGPUCommandEncoder commandEncoder) {
		try(var arena = Arena.ofConfined()) {
			var _commandEncoder = pointer(arena, commandEncoder);
			wgpuCommandEncoderPopDebugGroup.invoke(_commandEncoder);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuCommandEncoderPushDebugGroup = lookup(null, "wgpuCommandEncoderPushDebugGroup", POINTER, POINTER);
	public static void wgpuCommandEncoderPushDebugGroup(final WGPUCommandEncoder commandEncoder, final String groupLabel) {
		try(var arena = Arena.ofConfined()) {
			var _commandEncoder = pointer(arena, commandEncoder);
			var _groupLabel = pointer(arena, groupLabel);
			wgpuCommandEncoderPushDebugGroup.invoke(_commandEncoder, _groupLabel);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuCommandEncoderResolveQuerySet = lookup(null, "wgpuCommandEncoderResolveQuerySet", POINTER, POINTER, JAVA_INT, JAVA_INT, POINTER, JAVA_LONG);
	public static void wgpuCommandEncoderResolveQuerySet(final WGPUCommandEncoder commandEncoder, final WGPUQuerySet querySet, final int firstQuery, final int queryCount, final WGPUBuffer destination, final long destinationOffset) {
		try(var arena = Arena.ofConfined()) {
			var _commandEncoder = pointer(arena, commandEncoder);
			var _querySet = pointer(arena, querySet);
			var _firstQuery = value(arena, firstQuery);
			var _queryCount = value(arena, queryCount);
			var _destination = pointer(arena, destination);
			var _destinationOffset = value(arena, destinationOffset);
			wgpuCommandEncoderResolveQuerySet.invoke(_commandEncoder, _querySet, _firstQuery, _queryCount, _destination, _destinationOffset);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuCommandEncoderSetLabel = lookup(null, "wgpuCommandEncoderSetLabel", POINTER, POINTER);
	public static void wgpuCommandEncoderSetLabel(final WGPUCommandEncoder commandEncoder, final String label) {
		try(var arena = Arena.ofConfined()) {
			var _commandEncoder = pointer(arena, commandEncoder);
			var _label = pointer(arena, label);
			wgpuCommandEncoderSetLabel.invoke(_commandEncoder, _label);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuCommandEncoderWriteTimestamp = lookup(null, "wgpuCommandEncoderWriteTimestamp", POINTER, POINTER, JAVA_INT);
	public static void wgpuCommandEncoderWriteTimestamp(final WGPUCommandEncoder commandEncoder, final WGPUQuerySet querySet, final int queryIndex) {
		try(var arena = Arena.ofConfined()) {
			var _commandEncoder = pointer(arena, commandEncoder);
			var _querySet = pointer(arena, querySet);
			var _queryIndex = value(arena, queryIndex);
			wgpuCommandEncoderWriteTimestamp.invoke(_commandEncoder, _querySet, _queryIndex);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuCommandEncoderReference = lookup(null, "wgpuCommandEncoderReference", POINTER);
	public static void wgpuCommandEncoderReference(final WGPUCommandEncoder commandEncoder) {
		try(var arena = Arena.ofConfined()) {
			var _commandEncoder = pointer(arena, commandEncoder);
			wgpuCommandEncoderReference.invoke(_commandEncoder);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuCommandEncoderRelease = lookup(null, "wgpuCommandEncoderRelease", POINTER);
	public static void wgpuCommandEncoderRelease(final WGPUCommandEncoder commandEncoder) {
		try(var arena = Arena.ofConfined()) {
			var _commandEncoder = pointer(arena, commandEncoder);
			wgpuCommandEncoderRelease.invoke(_commandEncoder);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuComputePassEncoderDispatchWorkgroups = lookup(null, "wgpuComputePassEncoderDispatchWorkgroups", POINTER, JAVA_INT, JAVA_INT, JAVA_INT);
	public static void wgpuComputePassEncoderDispatchWorkgroups(final WGPUComputePassEncoder computePassEncoder, final int workgroupCountX, final int workgroupCountY, final int workgroupCountZ) {
		try(var arena = Arena.ofConfined()) {
			var _computePassEncoder = pointer(arena, computePassEncoder);
			var _workgroupCountX = value(arena, workgroupCountX);
			var _workgroupCountY = value(arena, workgroupCountY);
			var _workgroupCountZ = value(arena, workgroupCountZ);
			wgpuComputePassEncoderDispatchWorkgroups.invoke(_computePassEncoder, _workgroupCountX, _workgroupCountY, _workgroupCountZ);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuComputePassEncoderDispatchWorkgroupsIndirect = lookup(null, "wgpuComputePassEncoderDispatchWorkgroupsIndirect", POINTER, POINTER, JAVA_LONG);
	public static void wgpuComputePassEncoderDispatchWorkgroupsIndirect(final WGPUComputePassEncoder computePassEncoder, final WGPUBuffer indirectBuffer, final long indirectOffset) {
		try(var arena = Arena.ofConfined()) {
			var _computePassEncoder = pointer(arena, computePassEncoder);
			var _indirectBuffer = pointer(arena, indirectBuffer);
			var _indirectOffset = value(arena, indirectOffset);
			wgpuComputePassEncoderDispatchWorkgroupsIndirect.invoke(_computePassEncoder, _indirectBuffer, _indirectOffset);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuComputePassEncoderEnd = lookup(null, "wgpuComputePassEncoderEnd", POINTER);
	public static void wgpuComputePassEncoderEnd(final WGPUComputePassEncoder computePassEncoder) {
		try(var arena = Arena.ofConfined()) {
			var _computePassEncoder = pointer(arena, computePassEncoder);
			wgpuComputePassEncoderEnd.invoke(_computePassEncoder);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuComputePassEncoderInsertDebugMarker = lookup(null, "wgpuComputePassEncoderInsertDebugMarker", POINTER, POINTER);
	public static void wgpuComputePassEncoderInsertDebugMarker(final WGPUComputePassEncoder computePassEncoder, final String markerLabel) {
		try(var arena = Arena.ofConfined()) {
			var _computePassEncoder = pointer(arena, computePassEncoder);
			var _markerLabel = pointer(arena, markerLabel);
			wgpuComputePassEncoderInsertDebugMarker.invoke(_computePassEncoder, _markerLabel);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuComputePassEncoderPopDebugGroup = lookup(null, "wgpuComputePassEncoderPopDebugGroup", POINTER);
	public static void wgpuComputePassEncoderPopDebugGroup(final WGPUComputePassEncoder computePassEncoder) {
		try(var arena = Arena.ofConfined()) {
			var _computePassEncoder = pointer(arena, computePassEncoder);
			wgpuComputePassEncoderPopDebugGroup.invoke(_computePassEncoder);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuComputePassEncoderPushDebugGroup = lookup(null, "wgpuComputePassEncoderPushDebugGroup", POINTER, POINTER);
	public static void wgpuComputePassEncoderPushDebugGroup(final WGPUComputePassEncoder computePassEncoder, final String groupLabel) {
		try(var arena = Arena.ofConfined()) {
			var _computePassEncoder = pointer(arena, computePassEncoder);
			var _groupLabel = pointer(arena, groupLabel);
			wgpuComputePassEncoderPushDebugGroup.invoke(_computePassEncoder, _groupLabel);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuComputePassEncoderSetBindGroup = lookup(null, "wgpuComputePassEncoderSetBindGroup", POINTER, JAVA_INT, POINTER, JAVA_LONG, POINTER);
	public static void wgpuComputePassEncoderSetBindGroup(final WGPUComputePassEncoder computePassEncoder, final int groupIndex, @Nullable final WGPUBindGroup group, final long dynamicOffsetCount, final int[] dynamicOffsets) {
		try(var arena = Arena.ofConfined()) {
			var _computePassEncoder = pointer(arena, computePassEncoder);
			var _groupIndex = value(arena, groupIndex);
			var _group = pointer(arena, group);
			var _dynamicOffsetCount = value(arena, dynamicOffsetCount);
			var _dynamicOffsets = pointer(arena, dynamicOffsets);
			wgpuComputePassEncoderSetBindGroup.invoke(_computePassEncoder, _groupIndex, _group, _dynamicOffsetCount, _dynamicOffsets);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuComputePassEncoderSetLabel = lookup(null, "wgpuComputePassEncoderSetLabel", POINTER, POINTER);
	public static void wgpuComputePassEncoderSetLabel(final WGPUComputePassEncoder computePassEncoder, final String label) {
		try(var arena = Arena.ofConfined()) {
			var _computePassEncoder = pointer(arena, computePassEncoder);
			var _label = pointer(arena, label);
			wgpuComputePassEncoderSetLabel.invoke(_computePassEncoder, _label);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuComputePassEncoderSetPipeline = lookup(null, "wgpuComputePassEncoderSetPipeline", POINTER, POINTER);
	public static void wgpuComputePassEncoderSetPipeline(final WGPUComputePassEncoder computePassEncoder, final WGPUComputePipeline pipeline) {
		try(var arena = Arena.ofConfined()) {
			var _computePassEncoder = pointer(arena, computePassEncoder);
			var _pipeline = pointer(arena, pipeline);
			wgpuComputePassEncoderSetPipeline.invoke(_computePassEncoder, _pipeline);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuComputePassEncoderReference = lookup(null, "wgpuComputePassEncoderReference", POINTER);
	public static void wgpuComputePassEncoderReference(final WGPUComputePassEncoder computePassEncoder) {
		try(var arena = Arena.ofConfined()) {
			var _computePassEncoder = pointer(arena, computePassEncoder);
			wgpuComputePassEncoderReference.invoke(_computePassEncoder);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuComputePassEncoderRelease = lookup(null, "wgpuComputePassEncoderRelease", POINTER);
	public static void wgpuComputePassEncoderRelease(final WGPUComputePassEncoder computePassEncoder) {
		try(var arena = Arena.ofConfined()) {
			var _computePassEncoder = pointer(arena, computePassEncoder);
			wgpuComputePassEncoderRelease.invoke(_computePassEncoder);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuComputePipelineGetBindGroupLayout = lookup(POINTER, "wgpuComputePipelineGetBindGroupLayout", POINTER, JAVA_INT);
	public static WGPUBindGroupLayout wgpuComputePipelineGetBindGroupLayout(final WGPUComputePipeline computePipeline, final int groupIndex) {
		try(var arena = Arena.ofConfined()) {
			var _computePipeline = pointer(arena, computePipeline);
			var _groupIndex = value(arena, groupIndex);
			var ret = (MemorySegment) wgpuComputePipelineGetBindGroupLayout.invoke(_computePipeline, _groupIndex);
			return ret == null ? null : new WGPUBindGroupLayout(ret);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuComputePipelineSetLabel = lookup(null, "wgpuComputePipelineSetLabel", POINTER, POINTER);
	public static void wgpuComputePipelineSetLabel(final WGPUComputePipeline computePipeline, final String label) {
		try(var arena = Arena.ofConfined()) {
			var _computePipeline = pointer(arena, computePipeline);
			var _label = pointer(arena, label);
			wgpuComputePipelineSetLabel.invoke(_computePipeline, _label);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuComputePipelineReference = lookup(null, "wgpuComputePipelineReference", POINTER);
	public static void wgpuComputePipelineReference(final WGPUComputePipeline computePipeline) {
		try(var arena = Arena.ofConfined()) {
			var _computePipeline = pointer(arena, computePipeline);
			wgpuComputePipelineReference.invoke(_computePipeline);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuComputePipelineRelease = lookup(null, "wgpuComputePipelineRelease", POINTER);
	public static void wgpuComputePipelineRelease(final WGPUComputePipeline computePipeline) {
		try(var arena = Arena.ofConfined()) {
			var _computePipeline = pointer(arena, computePipeline);
			wgpuComputePipelineRelease.invoke(_computePipeline);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuDeviceCreateBindGroup = lookup(POINTER, "wgpuDeviceCreateBindGroup", POINTER, POINTER);
	public static WGPUBindGroup wgpuDeviceCreateBindGroup(final WGPUDevice device, final BindGroupDescriptor descriptor) {
		try(var arena = Arena.ofConfined()) {
			var _device = pointer(arena, device);
			var _descriptor = pointer(arena, descriptor);
			var ret = (MemorySegment) wgpuDeviceCreateBindGroup.invoke(_device, _descriptor);
			return ret == null ? null : new WGPUBindGroup(ret);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuDeviceCreateBindGroupLayout = lookup(POINTER, "wgpuDeviceCreateBindGroupLayout", POINTER, POINTER);
	public static WGPUBindGroupLayout wgpuDeviceCreateBindGroupLayout(final WGPUDevice device, final BindGroupLayoutDescriptor descriptor) {
		try(var arena = Arena.ofConfined()) {
			var _device = pointer(arena, device);
			var _descriptor = pointer(arena, descriptor);
			var ret = (MemorySegment) wgpuDeviceCreateBindGroupLayout.invoke(_device, _descriptor);
			return ret == null ? null : new WGPUBindGroupLayout(ret);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuDeviceCreateBuffer = lookup(POINTER, "wgpuDeviceCreateBuffer", POINTER, POINTER);
	public static WGPUBuffer wgpuDeviceCreateBuffer(final WGPUDevice device, final BufferDescriptor descriptor) {
		try(var arena = Arena.ofConfined()) {
			var _device = pointer(arena, device);
			var _descriptor = pointer(arena, descriptor);
			var ret = (MemorySegment) wgpuDeviceCreateBuffer.invoke(_device, _descriptor);
			return ret == null ? null : new WGPUBuffer(ret);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuDeviceCreateCommandEncoder = lookup(POINTER, "wgpuDeviceCreateCommandEncoder", POINTER, POINTER);
	public static WGPUCommandEncoder wgpuDeviceCreateCommandEncoder(final WGPUDevice device, @Nullable final CommandEncoderDescriptor descriptor) {
		try(var arena = Arena.ofConfined()) {
			var _device = pointer(arena, device);
			var _descriptor = pointer(arena, descriptor);
			var ret = (MemorySegment) wgpuDeviceCreateCommandEncoder.invoke(_device, _descriptor);
			return ret == null ? null : new WGPUCommandEncoder(ret);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuDeviceCreateComputePipeline = lookup(POINTER, "wgpuDeviceCreateComputePipeline", POINTER, POINTER);
	public static WGPUComputePipeline wgpuDeviceCreateComputePipeline(final WGPUDevice device, final ComputePipelineDescriptor descriptor) {
		try(var arena = Arena.ofConfined()) {
			var _device = pointer(arena, device);
			var _descriptor = pointer(arena, descriptor);
			var ret = (MemorySegment) wgpuDeviceCreateComputePipeline.invoke(_device, _descriptor);
			return ret == null ? null : new WGPUComputePipeline(ret);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuDeviceCreateComputePipelineAsync = lookup(null, "wgpuDeviceCreateComputePipelineAsync", POINTER, POINTER, POINTER, JAVA_LONG);
	public static void wgpuDeviceCreateComputePipelineAsync(final WGPUDevice device, final ComputePipelineDescriptor descriptor, final DeviceCreateComputePipelineAsyncCallback callback, final long userdata) {
		try(var arena = Arena.ofConfined()) {
			var _device = pointer(arena, device);
			var _descriptor = pointer(arena, descriptor);
			var _callback = pointer(arena, WGPUCallback.createStub(callback, callback.handle, callback.desc));
			var _userdata = value(arena, userdata);
			wgpuDeviceCreateComputePipelineAsync.invoke(_device, _descriptor, _callback, _userdata);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuDeviceCreatePipelineLayout = lookup(POINTER, "wgpuDeviceCreatePipelineLayout", POINTER, POINTER);
	public static WGPUPipelineLayout wgpuDeviceCreatePipelineLayout(final WGPUDevice device, final PipelineLayoutDescriptor descriptor) {
		try(var arena = Arena.ofConfined()) {
			var _device = pointer(arena, device);
			var _descriptor = pointer(arena, descriptor);
			var ret = (MemorySegment) wgpuDeviceCreatePipelineLayout.invoke(_device, _descriptor);
			return ret == null ? null : new WGPUPipelineLayout(ret);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuDeviceCreateQuerySet = lookup(POINTER, "wgpuDeviceCreateQuerySet", POINTER, POINTER);
	public static WGPUQuerySet wgpuDeviceCreateQuerySet(final WGPUDevice device, final QuerySetDescriptor descriptor) {
		try(var arena = Arena.ofConfined()) {
			var _device = pointer(arena, device);
			var _descriptor = pointer(arena, descriptor);
			var ret = (MemorySegment) wgpuDeviceCreateQuerySet.invoke(_device, _descriptor);
			return ret == null ? null : new WGPUQuerySet(ret);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuDeviceCreateRenderBundleEncoder = lookup(POINTER, "wgpuDeviceCreateRenderBundleEncoder", POINTER, POINTER);
	public static WGPURenderBundleEncoder wgpuDeviceCreateRenderBundleEncoder(final WGPUDevice device, final RenderBundleEncoderDescriptor descriptor) {
		try(var arena = Arena.ofConfined()) {
			var _device = pointer(arena, device);
			var _descriptor = pointer(arena, descriptor);
			var ret = (MemorySegment) wgpuDeviceCreateRenderBundleEncoder.invoke(_device, _descriptor);
			return ret == null ? null : new WGPURenderBundleEncoder(ret);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuDeviceCreateRenderPipeline = lookup(POINTER, "wgpuDeviceCreateRenderPipeline", POINTER, POINTER);
	public static WGPURenderPipeline wgpuDeviceCreateRenderPipeline(final WGPUDevice device, final RenderPipelineDescriptor descriptor) {
		try(var arena = Arena.ofConfined()) {
			var _device = pointer(arena, device);
			var _descriptor = pointer(arena, descriptor);
			var ret = (MemorySegment) wgpuDeviceCreateRenderPipeline.invoke(_device, _descriptor);
			return ret == null ? null : new WGPURenderPipeline(ret);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuDeviceCreateRenderPipelineAsync = lookup(null, "wgpuDeviceCreateRenderPipelineAsync", POINTER, POINTER, POINTER, JAVA_LONG);
	public static void wgpuDeviceCreateRenderPipelineAsync(final WGPUDevice device, final RenderPipelineDescriptor descriptor, final DeviceCreateRenderPipelineAsyncCallback callback, final long userdata) {
		try(var arena = Arena.ofConfined()) {
			var _device = pointer(arena, device);
			var _descriptor = pointer(arena, descriptor);
			var _callback = pointer(arena, WGPUCallback.createStub(callback, callback.handle, callback.desc));
			var _userdata = value(arena, userdata);
			wgpuDeviceCreateRenderPipelineAsync.invoke(_device, _descriptor, _callback, _userdata);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuDeviceCreateSampler = lookup(POINTER, "wgpuDeviceCreateSampler", POINTER, POINTER);
	public static WGPUSampler wgpuDeviceCreateSampler(final WGPUDevice device, @Nullable final SamplerDescriptor descriptor) {
		try(var arena = Arena.ofConfined()) {
			var _device = pointer(arena, device);
			var _descriptor = pointer(arena, descriptor);
			var ret = (MemorySegment) wgpuDeviceCreateSampler.invoke(_device, _descriptor);
			return ret == null ? null : new WGPUSampler(ret);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuDeviceCreateShaderModule = lookup(POINTER, "wgpuDeviceCreateShaderModule", POINTER, POINTER);
	public static WGPUShaderModule wgpuDeviceCreateShaderModule(final WGPUDevice device, final ShaderModuleDescriptor descriptor) {
		try(var arena = Arena.ofConfined()) {
			var _device = pointer(arena, device);
			var _descriptor = pointer(arena, descriptor);
			var ret = (MemorySegment) wgpuDeviceCreateShaderModule.invoke(_device, _descriptor);
			return ret == null ? null : new WGPUShaderModule(ret);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuDeviceCreateTexture = lookup(POINTER, "wgpuDeviceCreateTexture", POINTER, POINTER);
	public static WGPUTexture wgpuDeviceCreateTexture(final WGPUDevice device, final TextureDescriptor descriptor) {
		try(var arena = Arena.ofConfined()) {
			var _device = pointer(arena, device);
			var _descriptor = pointer(arena, descriptor);
			var ret = (MemorySegment) wgpuDeviceCreateTexture.invoke(_device, _descriptor);
			return ret == null ? null : new WGPUTexture(ret);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuDeviceDestroy = lookup(null, "wgpuDeviceDestroy", POINTER);
	public static void wgpuDeviceDestroy(final WGPUDevice device) {
		try(var arena = Arena.ofConfined()) {
			var _device = pointer(arena, device);
			wgpuDeviceDestroy.invoke(_device);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuDeviceEnumerateFeatures = lookup(JAVA_LONG, "wgpuDeviceEnumerateFeatures", POINTER, POINTER);
	public static long wgpuDeviceEnumerateFeatures(final WGPUDevice device, FeatureName[] features) {
		try(var arena = Arena.ofConfined()) {
			var _device = pointer(arena, device);
			var _features = pointer(arena, features);
			var ret = (long) wgpuDeviceEnumerateFeatures.invoke(_device, _features);
			if(features != null) {
				var in = new WGPUReader(_features);
				for(int i=0; i<features.length; i++) {
					features[i] = FeatureName.from(in.read_int());
				}
			}
			return ret;
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuDeviceGetLimits = lookup(JAVA_INT, "wgpuDeviceGetLimits", POINTER, POINTER);
	public static boolean wgpuDeviceGetLimits(final WGPUDevice device, SupportedLimits limits) {
		try(var arena = Arena.ofConfined()) {
			var _device = pointer(arena, device);
			var _limits = pointer(arena, limits);
			var ret = (int) wgpuDeviceGetLimits.invoke(_device, _limits);
			limits.readFrom(_limits);
			return ret != 0;
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuDeviceGetQueue = lookup(POINTER, "wgpuDeviceGetQueue", POINTER);
	public static WGPUQueue wgpuDeviceGetQueue(final WGPUDevice device) {
		try(var arena = Arena.ofConfined()) {
			var _device = pointer(arena, device);
			var ret = (MemorySegment) wgpuDeviceGetQueue.invoke(_device);
			return ret == null ? null : new WGPUQueue(ret);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuDeviceHasFeature = lookup(JAVA_INT, "wgpuDeviceHasFeature", POINTER, JAVA_INT);
	public static boolean wgpuDeviceHasFeature(final WGPUDevice device, final FeatureName feature) {
		try(var arena = Arena.ofConfined()) {
			var _device = pointer(arena, device);
			var _feature = value(arena, feature);
			var ret = (int) wgpuDeviceHasFeature.invoke(_device, _feature);
			return ret != 0;
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuDevicePopErrorScope = lookup(null, "wgpuDevicePopErrorScope", POINTER, POINTER, JAVA_LONG);
	public static void wgpuDevicePopErrorScope(final WGPUDevice device, final ErrorCallback callback, final long userdata) {
		try(var arena = Arena.ofConfined()) {
			var _device = pointer(arena, device);
			var _callback = pointer(arena, WGPUCallback.createStub(callback, callback.handle, callback.desc));
			var _userdata = value(arena, userdata);
			wgpuDevicePopErrorScope.invoke(_device, _callback, _userdata);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuDevicePushErrorScope = lookup(null, "wgpuDevicePushErrorScope", POINTER, JAVA_INT);
	public static void wgpuDevicePushErrorScope(final WGPUDevice device, final ErrorFilter filter) {
		try(var arena = Arena.ofConfined()) {
			var _device = pointer(arena, device);
			var _filter = value(arena, filter);
			wgpuDevicePushErrorScope.invoke(_device, _filter);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuDeviceSetLabel = lookup(null, "wgpuDeviceSetLabel", POINTER, POINTER);
	public static void wgpuDeviceSetLabel(final WGPUDevice device, final String label) {
		try(var arena = Arena.ofConfined()) {
			var _device = pointer(arena, device);
			var _label = pointer(arena, label);
			wgpuDeviceSetLabel.invoke(_device, _label);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuDeviceReference = lookup(null, "wgpuDeviceReference", POINTER);
	public static void wgpuDeviceReference(final WGPUDevice device) {
		try(var arena = Arena.ofConfined()) {
			var _device = pointer(arena, device);
			wgpuDeviceReference.invoke(_device);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuDeviceRelease = lookup(null, "wgpuDeviceRelease", POINTER);
	public static void wgpuDeviceRelease(final WGPUDevice device) {
		try(var arena = Arena.ofConfined()) {
			var _device = pointer(arena, device);
			wgpuDeviceRelease.invoke(_device);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuInstanceCreateSurface = lookup(POINTER, "wgpuInstanceCreateSurface", POINTER, POINTER);
	public static WGPUSurface wgpuInstanceCreateSurface(final WGPUInstance instance, final SurfaceDescriptor descriptor) {
		try(var arena = Arena.ofConfined()) {
			var _instance = pointer(arena, instance);
			var _descriptor = pointer(arena, descriptor);
			var ret = (MemorySegment) wgpuInstanceCreateSurface.invoke(_instance, _descriptor);
			return ret == null ? null : new WGPUSurface(ret);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuInstanceHasWGSLLanguageFeature = lookup(JAVA_INT, "wgpuInstanceHasWGSLLanguageFeature", POINTER, JAVA_INT);
	public static boolean wgpuInstanceHasWGSLLanguageFeature(final WGPUInstance instance, final WGSLFeatureName feature) {
		try(var arena = Arena.ofConfined()) {
			var _instance = pointer(arena, instance);
			var _feature = value(arena, feature);
			var ret = (int) wgpuInstanceHasWGSLLanguageFeature.invoke(_instance, _feature);
			return ret != 0;
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuInstanceProcessEvents = lookup(null, "wgpuInstanceProcessEvents", POINTER);
	public static void wgpuInstanceProcessEvents(final WGPUInstance instance) {
		try(var arena = Arena.ofConfined()) {
			var _instance = pointer(arena, instance);
			wgpuInstanceProcessEvents.invoke(_instance);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuInstanceRequestAdapter = lookup(null, "wgpuInstanceRequestAdapter", POINTER, POINTER, POINTER, JAVA_LONG);
	public static void wgpuInstanceRequestAdapter(final WGPUInstance instance, @Nullable final RequestAdapterOptions options, final InstanceRequestAdapterCallback callback, final long userdata) {
		try(var arena = Arena.ofConfined()) {
			var _instance = pointer(arena, instance);
			var _options = pointer(arena, options);
			var _callback = pointer(arena, WGPUCallback.createStub(callback, callback.handle, callback.desc));
			var _userdata = value(arena, userdata);
			wgpuInstanceRequestAdapter.invoke(_instance, _options, _callback, _userdata);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuInstanceReference = lookup(null, "wgpuInstanceReference", POINTER);
	public static void wgpuInstanceReference(final WGPUInstance instance) {
		try(var arena = Arena.ofConfined()) {
			var _instance = pointer(arena, instance);
			wgpuInstanceReference.invoke(_instance);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuInstanceRelease = lookup(null, "wgpuInstanceRelease", POINTER);
	public static void wgpuInstanceRelease(final WGPUInstance instance) {
		try(var arena = Arena.ofConfined()) {
			var _instance = pointer(arena, instance);
			wgpuInstanceRelease.invoke(_instance);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuPipelineLayoutSetLabel = lookup(null, "wgpuPipelineLayoutSetLabel", POINTER, POINTER);
	public static void wgpuPipelineLayoutSetLabel(final WGPUPipelineLayout pipelineLayout, final String label) {
		try(var arena = Arena.ofConfined()) {
			var _pipelineLayout = pointer(arena, pipelineLayout);
			var _label = pointer(arena, label);
			wgpuPipelineLayoutSetLabel.invoke(_pipelineLayout, _label);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuPipelineLayoutReference = lookup(null, "wgpuPipelineLayoutReference", POINTER);
	public static void wgpuPipelineLayoutReference(final WGPUPipelineLayout pipelineLayout) {
		try(var arena = Arena.ofConfined()) {
			var _pipelineLayout = pointer(arena, pipelineLayout);
			wgpuPipelineLayoutReference.invoke(_pipelineLayout);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuPipelineLayoutRelease = lookup(null, "wgpuPipelineLayoutRelease", POINTER);
	public static void wgpuPipelineLayoutRelease(final WGPUPipelineLayout pipelineLayout) {
		try(var arena = Arena.ofConfined()) {
			var _pipelineLayout = pointer(arena, pipelineLayout);
			wgpuPipelineLayoutRelease.invoke(_pipelineLayout);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuQuerySetDestroy = lookup(null, "wgpuQuerySetDestroy", POINTER);
	public static void wgpuQuerySetDestroy(final WGPUQuerySet querySet) {
		try(var arena = Arena.ofConfined()) {
			var _querySet = pointer(arena, querySet);
			wgpuQuerySetDestroy.invoke(_querySet);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuQuerySetGetCount = lookup(JAVA_INT, "wgpuQuerySetGetCount", POINTER);
	public static int wgpuQuerySetGetCount(final WGPUQuerySet querySet) {
		try(var arena = Arena.ofConfined()) {
			var _querySet = pointer(arena, querySet);
			var ret = (int) wgpuQuerySetGetCount.invoke(_querySet);
			return ret;
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuQuerySetGetType = lookup(JAVA_INT, "wgpuQuerySetGetType", POINTER);
	public static QueryType wgpuQuerySetGetType(final WGPUQuerySet querySet) {
		try(var arena = Arena.ofConfined()) {
			var _querySet = pointer(arena, querySet);
			var ret = (int) wgpuQuerySetGetType.invoke(_querySet);
			return QueryType.from(ret);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuQuerySetSetLabel = lookup(null, "wgpuQuerySetSetLabel", POINTER, POINTER);
	public static void wgpuQuerySetSetLabel(final WGPUQuerySet querySet, final String label) {
		try(var arena = Arena.ofConfined()) {
			var _querySet = pointer(arena, querySet);
			var _label = pointer(arena, label);
			wgpuQuerySetSetLabel.invoke(_querySet, _label);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuQuerySetReference = lookup(null, "wgpuQuerySetReference", POINTER);
	public static void wgpuQuerySetReference(final WGPUQuerySet querySet) {
		try(var arena = Arena.ofConfined()) {
			var _querySet = pointer(arena, querySet);
			wgpuQuerySetReference.invoke(_querySet);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuQuerySetRelease = lookup(null, "wgpuQuerySetRelease", POINTER);
	public static void wgpuQuerySetRelease(final WGPUQuerySet querySet) {
		try(var arena = Arena.ofConfined()) {
			var _querySet = pointer(arena, querySet);
			wgpuQuerySetRelease.invoke(_querySet);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuQueueOnSubmittedWorkDone = lookup(null, "wgpuQueueOnSubmittedWorkDone", POINTER, POINTER, JAVA_LONG);
	public static void wgpuQueueOnSubmittedWorkDone(final WGPUQueue queue, final QueueOnSubmittedWorkDoneCallback callback, final long userdata) {
		try(var arena = Arena.ofConfined()) {
			var _queue = pointer(arena, queue);
			var _callback = pointer(arena, WGPUCallback.createStub(callback, callback.handle, callback.desc));
			var _userdata = value(arena, userdata);
			wgpuQueueOnSubmittedWorkDone.invoke(_queue, _callback, _userdata);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuQueueSetLabel = lookup(null, "wgpuQueueSetLabel", POINTER, POINTER);
	public static void wgpuQueueSetLabel(final WGPUQueue queue, final String label) {
		try(var arena = Arena.ofConfined()) {
			var _queue = pointer(arena, queue);
			var _label = pointer(arena, label);
			wgpuQueueSetLabel.invoke(_queue, _label);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuQueueSubmit = lookup(null, "wgpuQueueSubmit", POINTER, JAVA_LONG, POINTER);
	public static void wgpuQueueSubmit(final WGPUQueue queue, final long commandCount, final WGPUCommandBuffer[] commands) {
		try(var arena = Arena.ofConfined()) {
			var _queue = pointer(arena, queue);
			var _commandCount = value(arena, commandCount);
			var _commands = pointer(arena, commands);
			wgpuQueueSubmit.invoke(_queue, _commandCount, _commands);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuQueueWriteBuffer = lookup(null, "wgpuQueueWriteBuffer", POINTER, POINTER, JAVA_LONG, POINTER, JAVA_LONG);
	public static void wgpuQueueWriteBuffer(final WGPUQueue queue, final WGPUBuffer buffer, final long bufferOffset, final MemorySegment data, final long size) {
		try(var arena = Arena.ofConfined()) {
			var _queue = pointer(arena, queue);
			var _buffer = pointer(arena, buffer);
			var _bufferOffset = value(arena, bufferOffset);
			var _data = pointer(arena, data);
			var _size = value(arena, size);
			wgpuQueueWriteBuffer.invoke(_queue, _buffer, _bufferOffset, _data, _size);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuQueueWriteTexture = lookup(null, "wgpuQueueWriteTexture", POINTER, POINTER, POINTER, JAVA_LONG, POINTER, POINTER);
	public static void wgpuQueueWriteTexture(final WGPUQueue queue, final ImageCopyTexture destination, final MemorySegment data, final long dataSize, final TextureDataLayout dataLayout, final Extent3D writeSize) {
		try(var arena = Arena.ofConfined()) {
			var _queue = pointer(arena, queue);
			var _destination = pointer(arena, destination);
			var _data = pointer(arena, data);
			var _dataSize = value(arena, dataSize);
			var _dataLayout = pointer(arena, dataLayout);
			var _writeSize = pointer(arena, writeSize);
			wgpuQueueWriteTexture.invoke(_queue, _destination, _data, _dataSize, _dataLayout, _writeSize);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuQueueReference = lookup(null, "wgpuQueueReference", POINTER);
	public static void wgpuQueueReference(final WGPUQueue queue) {
		try(var arena = Arena.ofConfined()) {
			var _queue = pointer(arena, queue);
			wgpuQueueReference.invoke(_queue);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuQueueRelease = lookup(null, "wgpuQueueRelease", POINTER);
	public static void wgpuQueueRelease(final WGPUQueue queue) {
		try(var arena = Arena.ofConfined()) {
			var _queue = pointer(arena, queue);
			wgpuQueueRelease.invoke(_queue);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderBundleSetLabel = lookup(null, "wgpuRenderBundleSetLabel", POINTER, POINTER);
	public static void wgpuRenderBundleSetLabel(final WGPURenderBundle renderBundle, final String label) {
		try(var arena = Arena.ofConfined()) {
			var _renderBundle = pointer(arena, renderBundle);
			var _label = pointer(arena, label);
			wgpuRenderBundleSetLabel.invoke(_renderBundle, _label);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderBundleReference = lookup(null, "wgpuRenderBundleReference", POINTER);
	public static void wgpuRenderBundleReference(final WGPURenderBundle renderBundle) {
		try(var arena = Arena.ofConfined()) {
			var _renderBundle = pointer(arena, renderBundle);
			wgpuRenderBundleReference.invoke(_renderBundle);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderBundleRelease = lookup(null, "wgpuRenderBundleRelease", POINTER);
	public static void wgpuRenderBundleRelease(final WGPURenderBundle renderBundle) {
		try(var arena = Arena.ofConfined()) {
			var _renderBundle = pointer(arena, renderBundle);
			wgpuRenderBundleRelease.invoke(_renderBundle);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderBundleEncoderDraw = lookup(null, "wgpuRenderBundleEncoderDraw", POINTER, JAVA_INT, JAVA_INT, JAVA_INT, JAVA_INT);
	public static void wgpuRenderBundleEncoderDraw(final WGPURenderBundleEncoder renderBundleEncoder, final int vertexCount, final int instanceCount, final int firstVertex, final int firstInstance) {
		try(var arena = Arena.ofConfined()) {
			var _renderBundleEncoder = pointer(arena, renderBundleEncoder);
			var _vertexCount = value(arena, vertexCount);
			var _instanceCount = value(arena, instanceCount);
			var _firstVertex = value(arena, firstVertex);
			var _firstInstance = value(arena, firstInstance);
			wgpuRenderBundleEncoderDraw.invoke(_renderBundleEncoder, _vertexCount, _instanceCount, _firstVertex, _firstInstance);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderBundleEncoderDrawIndexed = lookup(null, "wgpuRenderBundleEncoderDrawIndexed", POINTER, JAVA_INT, JAVA_INT, JAVA_INT, JAVA_INT, JAVA_INT);
	public static void wgpuRenderBundleEncoderDrawIndexed(final WGPURenderBundleEncoder renderBundleEncoder, final int indexCount, final int instanceCount, final int firstIndex, final int baseVertex, final int firstInstance) {
		try(var arena = Arena.ofConfined()) {
			var _renderBundleEncoder = pointer(arena, renderBundleEncoder);
			var _indexCount = value(arena, indexCount);
			var _instanceCount = value(arena, instanceCount);
			var _firstIndex = value(arena, firstIndex);
			var _baseVertex = value(arena, baseVertex);
			var _firstInstance = value(arena, firstInstance);
			wgpuRenderBundleEncoderDrawIndexed.invoke(_renderBundleEncoder, _indexCount, _instanceCount, _firstIndex, _baseVertex, _firstInstance);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderBundleEncoderDrawIndexedIndirect = lookup(null, "wgpuRenderBundleEncoderDrawIndexedIndirect", POINTER, POINTER, JAVA_LONG);
	public static void wgpuRenderBundleEncoderDrawIndexedIndirect(final WGPURenderBundleEncoder renderBundleEncoder, final WGPUBuffer indirectBuffer, final long indirectOffset) {
		try(var arena = Arena.ofConfined()) {
			var _renderBundleEncoder = pointer(arena, renderBundleEncoder);
			var _indirectBuffer = pointer(arena, indirectBuffer);
			var _indirectOffset = value(arena, indirectOffset);
			wgpuRenderBundleEncoderDrawIndexedIndirect.invoke(_renderBundleEncoder, _indirectBuffer, _indirectOffset);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderBundleEncoderDrawIndirect = lookup(null, "wgpuRenderBundleEncoderDrawIndirect", POINTER, POINTER, JAVA_LONG);
	public static void wgpuRenderBundleEncoderDrawIndirect(final WGPURenderBundleEncoder renderBundleEncoder, final WGPUBuffer indirectBuffer, final long indirectOffset) {
		try(var arena = Arena.ofConfined()) {
			var _renderBundleEncoder = pointer(arena, renderBundleEncoder);
			var _indirectBuffer = pointer(arena, indirectBuffer);
			var _indirectOffset = value(arena, indirectOffset);
			wgpuRenderBundleEncoderDrawIndirect.invoke(_renderBundleEncoder, _indirectBuffer, _indirectOffset);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderBundleEncoderFinish = lookup(POINTER, "wgpuRenderBundleEncoderFinish", POINTER, POINTER);
	public static WGPURenderBundle wgpuRenderBundleEncoderFinish(final WGPURenderBundleEncoder renderBundleEncoder, @Nullable final RenderBundleDescriptor descriptor) {
		try(var arena = Arena.ofConfined()) {
			var _renderBundleEncoder = pointer(arena, renderBundleEncoder);
			var _descriptor = pointer(arena, descriptor);
			var ret = (MemorySegment) wgpuRenderBundleEncoderFinish.invoke(_renderBundleEncoder, _descriptor);
			return ret == null ? null : new WGPURenderBundle(ret);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderBundleEncoderInsertDebugMarker = lookup(null, "wgpuRenderBundleEncoderInsertDebugMarker", POINTER, POINTER);
	public static void wgpuRenderBundleEncoderInsertDebugMarker(final WGPURenderBundleEncoder renderBundleEncoder, final String markerLabel) {
		try(var arena = Arena.ofConfined()) {
			var _renderBundleEncoder = pointer(arena, renderBundleEncoder);
			var _markerLabel = pointer(arena, markerLabel);
			wgpuRenderBundleEncoderInsertDebugMarker.invoke(_renderBundleEncoder, _markerLabel);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderBundleEncoderPopDebugGroup = lookup(null, "wgpuRenderBundleEncoderPopDebugGroup", POINTER);
	public static void wgpuRenderBundleEncoderPopDebugGroup(final WGPURenderBundleEncoder renderBundleEncoder) {
		try(var arena = Arena.ofConfined()) {
			var _renderBundleEncoder = pointer(arena, renderBundleEncoder);
			wgpuRenderBundleEncoderPopDebugGroup.invoke(_renderBundleEncoder);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderBundleEncoderPushDebugGroup = lookup(null, "wgpuRenderBundleEncoderPushDebugGroup", POINTER, POINTER);
	public static void wgpuRenderBundleEncoderPushDebugGroup(final WGPURenderBundleEncoder renderBundleEncoder, final String groupLabel) {
		try(var arena = Arena.ofConfined()) {
			var _renderBundleEncoder = pointer(arena, renderBundleEncoder);
			var _groupLabel = pointer(arena, groupLabel);
			wgpuRenderBundleEncoderPushDebugGroup.invoke(_renderBundleEncoder, _groupLabel);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderBundleEncoderSetBindGroup = lookup(null, "wgpuRenderBundleEncoderSetBindGroup", POINTER, JAVA_INT, POINTER, JAVA_LONG, POINTER);
	public static void wgpuRenderBundleEncoderSetBindGroup(final WGPURenderBundleEncoder renderBundleEncoder, final int groupIndex, @Nullable final WGPUBindGroup group, final long dynamicOffsetCount, final int[] dynamicOffsets) {
		try(var arena = Arena.ofConfined()) {
			var _renderBundleEncoder = pointer(arena, renderBundleEncoder);
			var _groupIndex = value(arena, groupIndex);
			var _group = pointer(arena, group);
			var _dynamicOffsetCount = value(arena, dynamicOffsetCount);
			var _dynamicOffsets = pointer(arena, dynamicOffsets);
			wgpuRenderBundleEncoderSetBindGroup.invoke(_renderBundleEncoder, _groupIndex, _group, _dynamicOffsetCount, _dynamicOffsets);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderBundleEncoderSetIndexBuffer = lookup(null, "wgpuRenderBundleEncoderSetIndexBuffer", POINTER, POINTER, JAVA_INT, JAVA_LONG, JAVA_LONG);
	public static void wgpuRenderBundleEncoderSetIndexBuffer(final WGPURenderBundleEncoder renderBundleEncoder, final WGPUBuffer buffer, final IndexFormat format, final long offset, final long size) {
		try(var arena = Arena.ofConfined()) {
			var _renderBundleEncoder = pointer(arena, renderBundleEncoder);
			var _buffer = pointer(arena, buffer);
			var _format = value(arena, format);
			var _offset = value(arena, offset);
			var _size = value(arena, size);
			wgpuRenderBundleEncoderSetIndexBuffer.invoke(_renderBundleEncoder, _buffer, _format, _offset, _size);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderBundleEncoderSetLabel = lookup(null, "wgpuRenderBundleEncoderSetLabel", POINTER, POINTER);
	public static void wgpuRenderBundleEncoderSetLabel(final WGPURenderBundleEncoder renderBundleEncoder, final String label) {
		try(var arena = Arena.ofConfined()) {
			var _renderBundleEncoder = pointer(arena, renderBundleEncoder);
			var _label = pointer(arena, label);
			wgpuRenderBundleEncoderSetLabel.invoke(_renderBundleEncoder, _label);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderBundleEncoderSetPipeline = lookup(null, "wgpuRenderBundleEncoderSetPipeline", POINTER, POINTER);
	public static void wgpuRenderBundleEncoderSetPipeline(final WGPURenderBundleEncoder renderBundleEncoder, final WGPURenderPipeline pipeline) {
		try(var arena = Arena.ofConfined()) {
			var _renderBundleEncoder = pointer(arena, renderBundleEncoder);
			var _pipeline = pointer(arena, pipeline);
			wgpuRenderBundleEncoderSetPipeline.invoke(_renderBundleEncoder, _pipeline);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderBundleEncoderSetVertexBuffer = lookup(null, "wgpuRenderBundleEncoderSetVertexBuffer", POINTER, JAVA_INT, POINTER, JAVA_LONG, JAVA_LONG);
	public static void wgpuRenderBundleEncoderSetVertexBuffer(final WGPURenderBundleEncoder renderBundleEncoder, final int slot, @Nullable final WGPUBuffer buffer, final long offset, final long size) {
		try(var arena = Arena.ofConfined()) {
			var _renderBundleEncoder = pointer(arena, renderBundleEncoder);
			var _slot = value(arena, slot);
			var _buffer = pointer(arena, buffer);
			var _offset = value(arena, offset);
			var _size = value(arena, size);
			wgpuRenderBundleEncoderSetVertexBuffer.invoke(_renderBundleEncoder, _slot, _buffer, _offset, _size);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderBundleEncoderReference = lookup(null, "wgpuRenderBundleEncoderReference", POINTER);
	public static void wgpuRenderBundleEncoderReference(final WGPURenderBundleEncoder renderBundleEncoder) {
		try(var arena = Arena.ofConfined()) {
			var _renderBundleEncoder = pointer(arena, renderBundleEncoder);
			wgpuRenderBundleEncoderReference.invoke(_renderBundleEncoder);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderBundleEncoderRelease = lookup(null, "wgpuRenderBundleEncoderRelease", POINTER);
	public static void wgpuRenderBundleEncoderRelease(final WGPURenderBundleEncoder renderBundleEncoder) {
		try(var arena = Arena.ofConfined()) {
			var _renderBundleEncoder = pointer(arena, renderBundleEncoder);
			wgpuRenderBundleEncoderRelease.invoke(_renderBundleEncoder);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderPassEncoderBeginOcclusionQuery = lookup(null, "wgpuRenderPassEncoderBeginOcclusionQuery", POINTER, JAVA_INT);
	public static void wgpuRenderPassEncoderBeginOcclusionQuery(final WGPURenderPassEncoder renderPassEncoder, final int queryIndex) {
		try(var arena = Arena.ofConfined()) {
			var _renderPassEncoder = pointer(arena, renderPassEncoder);
			var _queryIndex = value(arena, queryIndex);
			wgpuRenderPassEncoderBeginOcclusionQuery.invoke(_renderPassEncoder, _queryIndex);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderPassEncoderDraw = lookup(null, "wgpuRenderPassEncoderDraw", POINTER, JAVA_INT, JAVA_INT, JAVA_INT, JAVA_INT);
	public static void wgpuRenderPassEncoderDraw(final WGPURenderPassEncoder renderPassEncoder, final int vertexCount, final int instanceCount, final int firstVertex, final int firstInstance) {
		try(var arena = Arena.ofConfined()) {
			var _renderPassEncoder = pointer(arena, renderPassEncoder);
			var _vertexCount = value(arena, vertexCount);
			var _instanceCount = value(arena, instanceCount);
			var _firstVertex = value(arena, firstVertex);
			var _firstInstance = value(arena, firstInstance);
			wgpuRenderPassEncoderDraw.invoke(_renderPassEncoder, _vertexCount, _instanceCount, _firstVertex, _firstInstance);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderPassEncoderDrawIndexed = lookup(null, "wgpuRenderPassEncoderDrawIndexed", POINTER, JAVA_INT, JAVA_INT, JAVA_INT, JAVA_INT, JAVA_INT);
	public static void wgpuRenderPassEncoderDrawIndexed(final WGPURenderPassEncoder renderPassEncoder, final int indexCount, final int instanceCount, final int firstIndex, final int baseVertex, final int firstInstance) {
		try(var arena = Arena.ofConfined()) {
			var _renderPassEncoder = pointer(arena, renderPassEncoder);
			var _indexCount = value(arena, indexCount);
			var _instanceCount = value(arena, instanceCount);
			var _firstIndex = value(arena, firstIndex);
			var _baseVertex = value(arena, baseVertex);
			var _firstInstance = value(arena, firstInstance);
			wgpuRenderPassEncoderDrawIndexed.invoke(_renderPassEncoder, _indexCount, _instanceCount, _firstIndex, _baseVertex, _firstInstance);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderPassEncoderDrawIndexedIndirect = lookup(null, "wgpuRenderPassEncoderDrawIndexedIndirect", POINTER, POINTER, JAVA_LONG);
	public static void wgpuRenderPassEncoderDrawIndexedIndirect(final WGPURenderPassEncoder renderPassEncoder, final WGPUBuffer indirectBuffer, final long indirectOffset) {
		try(var arena = Arena.ofConfined()) {
			var _renderPassEncoder = pointer(arena, renderPassEncoder);
			var _indirectBuffer = pointer(arena, indirectBuffer);
			var _indirectOffset = value(arena, indirectOffset);
			wgpuRenderPassEncoderDrawIndexedIndirect.invoke(_renderPassEncoder, _indirectBuffer, _indirectOffset);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderPassEncoderDrawIndirect = lookup(null, "wgpuRenderPassEncoderDrawIndirect", POINTER, POINTER, JAVA_LONG);
	public static void wgpuRenderPassEncoderDrawIndirect(final WGPURenderPassEncoder renderPassEncoder, final WGPUBuffer indirectBuffer, final long indirectOffset) {
		try(var arena = Arena.ofConfined()) {
			var _renderPassEncoder = pointer(arena, renderPassEncoder);
			var _indirectBuffer = pointer(arena, indirectBuffer);
			var _indirectOffset = value(arena, indirectOffset);
			wgpuRenderPassEncoderDrawIndirect.invoke(_renderPassEncoder, _indirectBuffer, _indirectOffset);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderPassEncoderEnd = lookup(null, "wgpuRenderPassEncoderEnd", POINTER);
	public static void wgpuRenderPassEncoderEnd(final WGPURenderPassEncoder renderPassEncoder) {
		try(var arena = Arena.ofConfined()) {
			var _renderPassEncoder = pointer(arena, renderPassEncoder);
			wgpuRenderPassEncoderEnd.invoke(_renderPassEncoder);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderPassEncoderEndOcclusionQuery = lookup(null, "wgpuRenderPassEncoderEndOcclusionQuery", POINTER);
	public static void wgpuRenderPassEncoderEndOcclusionQuery(final WGPURenderPassEncoder renderPassEncoder) {
		try(var arena = Arena.ofConfined()) {
			var _renderPassEncoder = pointer(arena, renderPassEncoder);
			wgpuRenderPassEncoderEndOcclusionQuery.invoke(_renderPassEncoder);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderPassEncoderExecuteBundles = lookup(null, "wgpuRenderPassEncoderExecuteBundles", POINTER, JAVA_LONG, POINTER);
	public static void wgpuRenderPassEncoderExecuteBundles(final WGPURenderPassEncoder renderPassEncoder, final long bundleCount, final WGPURenderBundle[] bundles) {
		try(var arena = Arena.ofConfined()) {
			var _renderPassEncoder = pointer(arena, renderPassEncoder);
			var _bundleCount = value(arena, bundleCount);
			var _bundles = pointer(arena, bundles);
			wgpuRenderPassEncoderExecuteBundles.invoke(_renderPassEncoder, _bundleCount, _bundles);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderPassEncoderInsertDebugMarker = lookup(null, "wgpuRenderPassEncoderInsertDebugMarker", POINTER, POINTER);
	public static void wgpuRenderPassEncoderInsertDebugMarker(final WGPURenderPassEncoder renderPassEncoder, final String markerLabel) {
		try(var arena = Arena.ofConfined()) {
			var _renderPassEncoder = pointer(arena, renderPassEncoder);
			var _markerLabel = pointer(arena, markerLabel);
			wgpuRenderPassEncoderInsertDebugMarker.invoke(_renderPassEncoder, _markerLabel);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderPassEncoderPopDebugGroup = lookup(null, "wgpuRenderPassEncoderPopDebugGroup", POINTER);
	public static void wgpuRenderPassEncoderPopDebugGroup(final WGPURenderPassEncoder renderPassEncoder) {
		try(var arena = Arena.ofConfined()) {
			var _renderPassEncoder = pointer(arena, renderPassEncoder);
			wgpuRenderPassEncoderPopDebugGroup.invoke(_renderPassEncoder);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderPassEncoderPushDebugGroup = lookup(null, "wgpuRenderPassEncoderPushDebugGroup", POINTER, POINTER);
	public static void wgpuRenderPassEncoderPushDebugGroup(final WGPURenderPassEncoder renderPassEncoder, final String groupLabel) {
		try(var arena = Arena.ofConfined()) {
			var _renderPassEncoder = pointer(arena, renderPassEncoder);
			var _groupLabel = pointer(arena, groupLabel);
			wgpuRenderPassEncoderPushDebugGroup.invoke(_renderPassEncoder, _groupLabel);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderPassEncoderSetBindGroup = lookup(null, "wgpuRenderPassEncoderSetBindGroup", POINTER, JAVA_INT, POINTER, JAVA_LONG, POINTER);
	public static void wgpuRenderPassEncoderSetBindGroup(final WGPURenderPassEncoder renderPassEncoder, final int groupIndex, @Nullable final WGPUBindGroup group, final long dynamicOffsetCount, final int[] dynamicOffsets) {
		try(var arena = Arena.ofConfined()) {
			var _renderPassEncoder = pointer(arena, renderPassEncoder);
			var _groupIndex = value(arena, groupIndex);
			var _group = pointer(arena, group);
			var _dynamicOffsetCount = value(arena, dynamicOffsetCount);
			var _dynamicOffsets = pointer(arena, dynamicOffsets);
			wgpuRenderPassEncoderSetBindGroup.invoke(_renderPassEncoder, _groupIndex, _group, _dynamicOffsetCount, _dynamicOffsets);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderPassEncoderSetBlendConstant = lookup(null, "wgpuRenderPassEncoderSetBlendConstant", POINTER, POINTER);
	public static void wgpuRenderPassEncoderSetBlendConstant(final WGPURenderPassEncoder renderPassEncoder, final Color color) {
		try(var arena = Arena.ofConfined()) {
			var _renderPassEncoder = pointer(arena, renderPassEncoder);
			var _color = pointer(arena, color);
			wgpuRenderPassEncoderSetBlendConstant.invoke(_renderPassEncoder, _color);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderPassEncoderSetIndexBuffer = lookup(null, "wgpuRenderPassEncoderSetIndexBuffer", POINTER, POINTER, JAVA_INT, JAVA_LONG, JAVA_LONG);
	public static void wgpuRenderPassEncoderSetIndexBuffer(final WGPURenderPassEncoder renderPassEncoder, final WGPUBuffer buffer, final IndexFormat format, final long offset, final long size) {
		try(var arena = Arena.ofConfined()) {
			var _renderPassEncoder = pointer(arena, renderPassEncoder);
			var _buffer = pointer(arena, buffer);
			var _format = value(arena, format);
			var _offset = value(arena, offset);
			var _size = value(arena, size);
			wgpuRenderPassEncoderSetIndexBuffer.invoke(_renderPassEncoder, _buffer, _format, _offset, _size);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderPassEncoderSetLabel = lookup(null, "wgpuRenderPassEncoderSetLabel", POINTER, POINTER);
	public static void wgpuRenderPassEncoderSetLabel(final WGPURenderPassEncoder renderPassEncoder, final String label) {
		try(var arena = Arena.ofConfined()) {
			var _renderPassEncoder = pointer(arena, renderPassEncoder);
			var _label = pointer(arena, label);
			wgpuRenderPassEncoderSetLabel.invoke(_renderPassEncoder, _label);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderPassEncoderSetPipeline = lookup(null, "wgpuRenderPassEncoderSetPipeline", POINTER, POINTER);
	public static void wgpuRenderPassEncoderSetPipeline(final WGPURenderPassEncoder renderPassEncoder, final WGPURenderPipeline pipeline) {
		try(var arena = Arena.ofConfined()) {
			var _renderPassEncoder = pointer(arena, renderPassEncoder);
			var _pipeline = pointer(arena, pipeline);
			wgpuRenderPassEncoderSetPipeline.invoke(_renderPassEncoder, _pipeline);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderPassEncoderSetScissorRect = lookup(null, "wgpuRenderPassEncoderSetScissorRect", POINTER, JAVA_INT, JAVA_INT, JAVA_INT, JAVA_INT);
	public static void wgpuRenderPassEncoderSetScissorRect(final WGPURenderPassEncoder renderPassEncoder, final int x, final int y, final int width, final int height) {
		try(var arena = Arena.ofConfined()) {
			var _renderPassEncoder = pointer(arena, renderPassEncoder);
			var _x = value(arena, x);
			var _y = value(arena, y);
			var _width = value(arena, width);
			var _height = value(arena, height);
			wgpuRenderPassEncoderSetScissorRect.invoke(_renderPassEncoder, _x, _y, _width, _height);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderPassEncoderSetStencilReference = lookup(null, "wgpuRenderPassEncoderSetStencilReference", POINTER, JAVA_INT);
	public static void wgpuRenderPassEncoderSetStencilReference(final WGPURenderPassEncoder renderPassEncoder, final int reference) {
		try(var arena = Arena.ofConfined()) {
			var _renderPassEncoder = pointer(arena, renderPassEncoder);
			var _reference = value(arena, reference);
			wgpuRenderPassEncoderSetStencilReference.invoke(_renderPassEncoder, _reference);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderPassEncoderSetVertexBuffer = lookup(null, "wgpuRenderPassEncoderSetVertexBuffer", POINTER, JAVA_INT, POINTER, JAVA_LONG, JAVA_LONG);
	public static void wgpuRenderPassEncoderSetVertexBuffer(final WGPURenderPassEncoder renderPassEncoder, final int slot, @Nullable final WGPUBuffer buffer, final long offset, final long size) {
		try(var arena = Arena.ofConfined()) {
			var _renderPassEncoder = pointer(arena, renderPassEncoder);
			var _slot = value(arena, slot);
			var _buffer = pointer(arena, buffer);
			var _offset = value(arena, offset);
			var _size = value(arena, size);
			wgpuRenderPassEncoderSetVertexBuffer.invoke(_renderPassEncoder, _slot, _buffer, _offset, _size);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderPassEncoderSetViewport = lookup(null, "wgpuRenderPassEncoderSetViewport", POINTER, JAVA_FLOAT, JAVA_FLOAT, JAVA_FLOAT, JAVA_FLOAT, JAVA_FLOAT, JAVA_FLOAT);
	public static void wgpuRenderPassEncoderSetViewport(final WGPURenderPassEncoder renderPassEncoder, final float x, final float y, final float width, final float height, final float minDepth, final float maxDepth) {
		try(var arena = Arena.ofConfined()) {
			var _renderPassEncoder = pointer(arena, renderPassEncoder);
			var _x = value(arena, x);
			var _y = value(arena, y);
			var _width = value(arena, width);
			var _height = value(arena, height);
			var _minDepth = value(arena, minDepth);
			var _maxDepth = value(arena, maxDepth);
			wgpuRenderPassEncoderSetViewport.invoke(_renderPassEncoder, _x, _y, _width, _height, _minDepth, _maxDepth);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderPassEncoderReference = lookup(null, "wgpuRenderPassEncoderReference", POINTER);
	public static void wgpuRenderPassEncoderReference(final WGPURenderPassEncoder renderPassEncoder) {
		try(var arena = Arena.ofConfined()) {
			var _renderPassEncoder = pointer(arena, renderPassEncoder);
			wgpuRenderPassEncoderReference.invoke(_renderPassEncoder);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderPassEncoderRelease = lookup(null, "wgpuRenderPassEncoderRelease", POINTER);
	public static void wgpuRenderPassEncoderRelease(final WGPURenderPassEncoder renderPassEncoder) {
		try(var arena = Arena.ofConfined()) {
			var _renderPassEncoder = pointer(arena, renderPassEncoder);
			wgpuRenderPassEncoderRelease.invoke(_renderPassEncoder);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderPipelineGetBindGroupLayout = lookup(POINTER, "wgpuRenderPipelineGetBindGroupLayout", POINTER, JAVA_INT);
	public static WGPUBindGroupLayout wgpuRenderPipelineGetBindGroupLayout(final WGPURenderPipeline renderPipeline, final int groupIndex) {
		try(var arena = Arena.ofConfined()) {
			var _renderPipeline = pointer(arena, renderPipeline);
			var _groupIndex = value(arena, groupIndex);
			var ret = (MemorySegment) wgpuRenderPipelineGetBindGroupLayout.invoke(_renderPipeline, _groupIndex);
			return ret == null ? null : new WGPUBindGroupLayout(ret);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderPipelineSetLabel = lookup(null, "wgpuRenderPipelineSetLabel", POINTER, POINTER);
	public static void wgpuRenderPipelineSetLabel(final WGPURenderPipeline renderPipeline, final String label) {
		try(var arena = Arena.ofConfined()) {
			var _renderPipeline = pointer(arena, renderPipeline);
			var _label = pointer(arena, label);
			wgpuRenderPipelineSetLabel.invoke(_renderPipeline, _label);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderPipelineReference = lookup(null, "wgpuRenderPipelineReference", POINTER);
	public static void wgpuRenderPipelineReference(final WGPURenderPipeline renderPipeline) {
		try(var arena = Arena.ofConfined()) {
			var _renderPipeline = pointer(arena, renderPipeline);
			wgpuRenderPipelineReference.invoke(_renderPipeline);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderPipelineRelease = lookup(null, "wgpuRenderPipelineRelease", POINTER);
	public static void wgpuRenderPipelineRelease(final WGPURenderPipeline renderPipeline) {
		try(var arena = Arena.ofConfined()) {
			var _renderPipeline = pointer(arena, renderPipeline);
			wgpuRenderPipelineRelease.invoke(_renderPipeline);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuSamplerSetLabel = lookup(null, "wgpuSamplerSetLabel", POINTER, POINTER);
	public static void wgpuSamplerSetLabel(final WGPUSampler sampler, final String label) {
		try(var arena = Arena.ofConfined()) {
			var _sampler = pointer(arena, sampler);
			var _label = pointer(arena, label);
			wgpuSamplerSetLabel.invoke(_sampler, _label);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuSamplerReference = lookup(null, "wgpuSamplerReference", POINTER);
	public static void wgpuSamplerReference(final WGPUSampler sampler) {
		try(var arena = Arena.ofConfined()) {
			var _sampler = pointer(arena, sampler);
			wgpuSamplerReference.invoke(_sampler);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuSamplerRelease = lookup(null, "wgpuSamplerRelease", POINTER);
	public static void wgpuSamplerRelease(final WGPUSampler sampler) {
		try(var arena = Arena.ofConfined()) {
			var _sampler = pointer(arena, sampler);
			wgpuSamplerRelease.invoke(_sampler);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuShaderModuleGetCompilationInfo = lookup(null, "wgpuShaderModuleGetCompilationInfo", POINTER, POINTER, JAVA_LONG);
	public static void wgpuShaderModuleGetCompilationInfo(final WGPUShaderModule shaderModule, final ShaderModuleGetCompilationInfoCallback callback, final long userdata) {
		try(var arena = Arena.ofConfined()) {
			var _shaderModule = pointer(arena, shaderModule);
			var _callback = pointer(arena, WGPUCallback.createStub(callback, callback.handle, callback.desc));
			var _userdata = value(arena, userdata);
			wgpuShaderModuleGetCompilationInfo.invoke(_shaderModule, _callback, _userdata);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuShaderModuleSetLabel = lookup(null, "wgpuShaderModuleSetLabel", POINTER, POINTER);
	public static void wgpuShaderModuleSetLabel(final WGPUShaderModule shaderModule, final String label) {
		try(var arena = Arena.ofConfined()) {
			var _shaderModule = pointer(arena, shaderModule);
			var _label = pointer(arena, label);
			wgpuShaderModuleSetLabel.invoke(_shaderModule, _label);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuShaderModuleReference = lookup(null, "wgpuShaderModuleReference", POINTER);
	public static void wgpuShaderModuleReference(final WGPUShaderModule shaderModule) {
		try(var arena = Arena.ofConfined()) {
			var _shaderModule = pointer(arena, shaderModule);
			wgpuShaderModuleReference.invoke(_shaderModule);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuShaderModuleRelease = lookup(null, "wgpuShaderModuleRelease", POINTER);
	public static void wgpuShaderModuleRelease(final WGPUShaderModule shaderModule) {
		try(var arena = Arena.ofConfined()) {
			var _shaderModule = pointer(arena, shaderModule);
			wgpuShaderModuleRelease.invoke(_shaderModule);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuSurfaceConfigure = lookup(null, "wgpuSurfaceConfigure", POINTER, POINTER);
	public static void wgpuSurfaceConfigure(final WGPUSurface surface, final SurfaceConfiguration config) {
		try(var arena = Arena.ofConfined()) {
			var _surface = pointer(arena, surface);
			var _config = pointer(arena, config);
			wgpuSurfaceConfigure.invoke(_surface, _config);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuSurfaceGetCapabilities = lookup(null, "wgpuSurfaceGetCapabilities", POINTER, POINTER, POINTER);
	public static void wgpuSurfaceGetCapabilities(final WGPUSurface surface, final WGPUAdapter adapter, SurfaceCapabilities capabilities) {
		try(var arena = Arena.ofConfined()) {
			var _surface = pointer(arena, surface);
			var _adapter = pointer(arena, adapter);
			var _capabilities = pointer(arena, capabilities);
			wgpuSurfaceGetCapabilities.invoke(_surface, _adapter, _capabilities);
			capabilities.readFrom(_capabilities);
			wgpuSurfaceCapabilitiesFreeMembers.invoke(_capabilities);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuSurfaceGetCurrentTexture = lookup(null, "wgpuSurfaceGetCurrentTexture", POINTER, POINTER);
	public static void wgpuSurfaceGetCurrentTexture(final WGPUSurface surface, SurfaceTexture surfaceTexture) {
		try(var arena = Arena.ofConfined()) {
			var _surface = pointer(arena, surface);
			var _surfaceTexture = pointer(arena, surfaceTexture);
			wgpuSurfaceGetCurrentTexture.invoke(_surface, _surfaceTexture);
			surfaceTexture.readFrom(_surfaceTexture);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuSurfacePresent = lookup(null, "wgpuSurfacePresent", POINTER);
	public static void wgpuSurfacePresent(final WGPUSurface surface) {
		try(var arena = Arena.ofConfined()) {
			var _surface = pointer(arena, surface);
			wgpuSurfacePresent.invoke(_surface);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuSurfaceSetLabel = lookup(null, "wgpuSurfaceSetLabel", POINTER, POINTER);
	public static void wgpuSurfaceSetLabel(final WGPUSurface surface, final String label) {
		try(var arena = Arena.ofConfined()) {
			var _surface = pointer(arena, surface);
			var _label = pointer(arena, label);
			wgpuSurfaceSetLabel.invoke(_surface, _label);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuSurfaceUnconfigure = lookup(null, "wgpuSurfaceUnconfigure", POINTER);
	public static void wgpuSurfaceUnconfigure(final WGPUSurface surface) {
		try(var arena = Arena.ofConfined()) {
			var _surface = pointer(arena, surface);
			wgpuSurfaceUnconfigure.invoke(_surface);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuSurfaceReference = lookup(null, "wgpuSurfaceReference", POINTER);
	public static void wgpuSurfaceReference(final WGPUSurface surface) {
		try(var arena = Arena.ofConfined()) {
			var _surface = pointer(arena, surface);
			wgpuSurfaceReference.invoke(_surface);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuSurfaceRelease = lookup(null, "wgpuSurfaceRelease", POINTER);
	public static void wgpuSurfaceRelease(final WGPUSurface surface) {
		try(var arena = Arena.ofConfined()) {
			var _surface = pointer(arena, surface);
			wgpuSurfaceRelease.invoke(_surface);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuSurfaceCapabilitiesFreeMembers = lookup(null, "wgpuSurfaceCapabilitiesFreeMembers", STRUCT(64));

	private static final MethodHandle wgpuTextureCreateView = lookup(POINTER, "wgpuTextureCreateView", POINTER, POINTER);
	public static WGPUTextureView wgpuTextureCreateView(final WGPUTexture texture, @Nullable final TextureViewDescriptor descriptor) {
		try(var arena = Arena.ofConfined()) {
			var _texture = pointer(arena, texture);
			var _descriptor = pointer(arena, descriptor);
			var ret = (MemorySegment) wgpuTextureCreateView.invoke(_texture, _descriptor);
			return ret == null ? null : new WGPUTextureView(ret);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuTextureDestroy = lookup(null, "wgpuTextureDestroy", POINTER);
	public static void wgpuTextureDestroy(final WGPUTexture texture) {
		try(var arena = Arena.ofConfined()) {
			var _texture = pointer(arena, texture);
			wgpuTextureDestroy.invoke(_texture);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuTextureGetDepthOrArrayLayers = lookup(JAVA_INT, "wgpuTextureGetDepthOrArrayLayers", POINTER);
	public static int wgpuTextureGetDepthOrArrayLayers(final WGPUTexture texture) {
		try(var arena = Arena.ofConfined()) {
			var _texture = pointer(arena, texture);
			var ret = (int) wgpuTextureGetDepthOrArrayLayers.invoke(_texture);
			return ret;
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuTextureGetDimension = lookup(JAVA_INT, "wgpuTextureGetDimension", POINTER);
	public static TextureDimension wgpuTextureGetDimension(final WGPUTexture texture) {
		try(var arena = Arena.ofConfined()) {
			var _texture = pointer(arena, texture);
			var ret = (int) wgpuTextureGetDimension.invoke(_texture);
			return TextureDimension.from(ret);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuTextureGetFormat = lookup(JAVA_INT, "wgpuTextureGetFormat", POINTER);
	public static TextureFormat wgpuTextureGetFormat(final WGPUTexture texture) {
		try(var arena = Arena.ofConfined()) {
			var _texture = pointer(arena, texture);
			var ret = (int) wgpuTextureGetFormat.invoke(_texture);
			return TextureFormat.from(ret);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuTextureGetHeight = lookup(JAVA_INT, "wgpuTextureGetHeight", POINTER);
	public static int wgpuTextureGetHeight(final WGPUTexture texture) {
		try(var arena = Arena.ofConfined()) {
			var _texture = pointer(arena, texture);
			var ret = (int) wgpuTextureGetHeight.invoke(_texture);
			return ret;
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuTextureGetMipLevelCount = lookup(JAVA_INT, "wgpuTextureGetMipLevelCount", POINTER);
	public static int wgpuTextureGetMipLevelCount(final WGPUTexture texture) {
		try(var arena = Arena.ofConfined()) {
			var _texture = pointer(arena, texture);
			var ret = (int) wgpuTextureGetMipLevelCount.invoke(_texture);
			return ret;
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuTextureGetSampleCount = lookup(JAVA_INT, "wgpuTextureGetSampleCount", POINTER);
	public static int wgpuTextureGetSampleCount(final WGPUTexture texture) {
		try(var arena = Arena.ofConfined()) {
			var _texture = pointer(arena, texture);
			var ret = (int) wgpuTextureGetSampleCount.invoke(_texture);
			return ret;
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuTextureGetUsage = lookup(JAVA_INT, "wgpuTextureGetUsage", POINTER);
	public static int wgpuTextureGetUsage(final WGPUTexture texture) {
		try(var arena = Arena.ofConfined()) {
			var _texture = pointer(arena, texture);
			var ret = (int) wgpuTextureGetUsage.invoke(_texture);
			return ret;
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuTextureGetWidth = lookup(JAVA_INT, "wgpuTextureGetWidth", POINTER);
	public static int wgpuTextureGetWidth(final WGPUTexture texture) {
		try(var arena = Arena.ofConfined()) {
			var _texture = pointer(arena, texture);
			var ret = (int) wgpuTextureGetWidth.invoke(_texture);
			return ret;
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuTextureSetLabel = lookup(null, "wgpuTextureSetLabel", POINTER, POINTER);
	public static void wgpuTextureSetLabel(final WGPUTexture texture, final String label) {
		try(var arena = Arena.ofConfined()) {
			var _texture = pointer(arena, texture);
			var _label = pointer(arena, label);
			wgpuTextureSetLabel.invoke(_texture, _label);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuTextureReference = lookup(null, "wgpuTextureReference", POINTER);
	public static void wgpuTextureReference(final WGPUTexture texture) {
		try(var arena = Arena.ofConfined()) {
			var _texture = pointer(arena, texture);
			wgpuTextureReference.invoke(_texture);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuTextureRelease = lookup(null, "wgpuTextureRelease", POINTER);
	public static void wgpuTextureRelease(final WGPUTexture texture) {
		try(var arena = Arena.ofConfined()) {
			var _texture = pointer(arena, texture);
			wgpuTextureRelease.invoke(_texture);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuTextureViewSetLabel = lookup(null, "wgpuTextureViewSetLabel", POINTER, POINTER);
	public static void wgpuTextureViewSetLabel(final WGPUTextureView textureView, final String label) {
		try(var arena = Arena.ofConfined()) {
			var _textureView = pointer(arena, textureView);
			var _label = pointer(arena, label);
			wgpuTextureViewSetLabel.invoke(_textureView, _label);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuTextureViewReference = lookup(null, "wgpuTextureViewReference", POINTER);
	public static void wgpuTextureViewReference(final WGPUTextureView textureView) {
		try(var arena = Arena.ofConfined()) {
			var _textureView = pointer(arena, textureView);
			wgpuTextureViewReference.invoke(_textureView);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuTextureViewRelease = lookup(null, "wgpuTextureViewRelease", POINTER);
	public static void wgpuTextureViewRelease(final WGPUTextureView textureView) {
		try(var arena = Arena.ofConfined()) {
			var _textureView = pointer(arena, textureView);
			wgpuTextureViewRelease.invoke(_textureView);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuGenerateReport = lookup(null, "wgpuGenerateReport", POINTER, POINTER);
	public static void wgpuGenerateReport(final WGPUInstance instance, GlobalReport report) {
		try(var arena = Arena.ofConfined()) {
			var _instance = pointer(arena, instance);
			var _report = pointer(arena, report);
			wgpuGenerateReport.invoke(_instance, _report);
			report.readFrom(_report);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuInstanceEnumerateAdapters = lookup(JAVA_LONG, "wgpuInstanceEnumerateAdapters", POINTER, POINTER, POINTER);
	public static long wgpuInstanceEnumerateAdapters(final WGPUInstance instance, @Nullable final InstanceEnumerateAdapterOptions options, WGPUAdapter[] adapters) {
		try(var arena = Arena.ofConfined()) {
			var _instance = pointer(arena, instance);
			var _options = pointer(arena, options);
			var _adapters = pointer(arena, adapters);
			var ret = (long) wgpuInstanceEnumerateAdapters.invoke(_instance, _options, _adapters);
			if(adapters != null) {
				var in = new WGPUReader(_adapters);
				for(int i=0; i<adapters.length; i++) {
					adapters[i] = new WGPUAdapter(in.read_pointer());
				}
			}
			return ret;
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuQueueSubmitForIndex = lookup(JAVA_LONG, "wgpuQueueSubmitForIndex", POINTER, JAVA_LONG, POINTER);
	public static long wgpuQueueSubmitForIndex(final WGPUQueue queue, final long commandCount, final WGPUCommandBuffer[] commands) {
		try(var arena = Arena.ofConfined()) {
			var _queue = pointer(arena, queue);
			var _commandCount = value(arena, commandCount);
			var _commands = pointer(arena, commands);
			var ret = (long) wgpuQueueSubmitForIndex.invoke(_queue, _commandCount, _commands);
			return ret;
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuDevicePoll = lookup(JAVA_INT, "wgpuDevicePoll", POINTER, JAVA_INT, POINTER);
	public static boolean wgpuDevicePoll(final WGPUDevice device, final boolean wait, @Nullable final WrappedSubmissionIndex wrappedSubmissionIndex) {
		try(var arena = Arena.ofConfined()) {
			var _device = pointer(arena, device);
			var _wait = value(arena, wait);
			var _wrappedSubmissionIndex = pointer(arena, wrappedSubmissionIndex);
			var ret = (int) wgpuDevicePoll.invoke(_device, _wait, _wrappedSubmissionIndex);
			return ret != 0;
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuSetLogCallback = lookup(null, "wgpuSetLogCallback", POINTER, JAVA_LONG);
	public static void wgpuSetLogCallback(final LogCallback callback, final long userdata) {
		try(var arena = Arena.ofConfined()) {
			var _callback = pointer(arena, WGPUCallback.createStub(callback, callback.handle, callback.desc));
			var _userdata = value(arena, userdata);
			wgpuSetLogCallback.invoke(_callback, _userdata);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuSetLogLevel = lookup(null, "wgpuSetLogLevel", JAVA_INT);
	public static void wgpuSetLogLevel(final LogLevel level) {
		try(var arena = Arena.ofConfined()) {
			var _level = value(arena, level);
			wgpuSetLogLevel.invoke(_level);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuGetVersion = lookup(JAVA_INT, "wgpuGetVersion");
	public static int wgpuGetVersion() {
		try(var arena = Arena.ofConfined()) {
			var ret = (int) wgpuGetVersion.invoke();
			return ret;
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderPassEncoderSetPushConstants = lookup(null, "wgpuRenderPassEncoderSetPushConstants", POINTER, JAVA_INT, JAVA_INT, JAVA_INT, POINTER);
	public static void wgpuRenderPassEncoderSetPushConstants(final WGPURenderPassEncoder encoder, final int stages, final int offset, final int sizeBytes, final MemorySegment data) {
		try(var arena = Arena.ofConfined()) {
			var _encoder = pointer(arena, encoder);
			var _stages = value(arena, stages);
			var _offset = value(arena, offset);
			var _sizeBytes = value(arena, sizeBytes);
			var _data = pointer(arena, data);
			wgpuRenderPassEncoderSetPushConstants.invoke(_encoder, _stages, _offset, _sizeBytes, _data);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderPassEncoderMultiDrawIndirect = lookup(null, "wgpuRenderPassEncoderMultiDrawIndirect", POINTER, POINTER, JAVA_LONG, JAVA_INT);
	public static void wgpuRenderPassEncoderMultiDrawIndirect(final WGPURenderPassEncoder encoder, final WGPUBuffer buffer, final long offset, final int count) {
		try(var arena = Arena.ofConfined()) {
			var _encoder = pointer(arena, encoder);
			var _buffer = pointer(arena, buffer);
			var _offset = value(arena, offset);
			var _count = value(arena, count);
			wgpuRenderPassEncoderMultiDrawIndirect.invoke(_encoder, _buffer, _offset, _count);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderPassEncoderMultiDrawIndexedIndirect = lookup(null, "wgpuRenderPassEncoderMultiDrawIndexedIndirect", POINTER, POINTER, JAVA_LONG, JAVA_INT);
	public static void wgpuRenderPassEncoderMultiDrawIndexedIndirect(final WGPURenderPassEncoder encoder, final WGPUBuffer buffer, final long offset, final int count) {
		try(var arena = Arena.ofConfined()) {
			var _encoder = pointer(arena, encoder);
			var _buffer = pointer(arena, buffer);
			var _offset = value(arena, offset);
			var _count = value(arena, count);
			wgpuRenderPassEncoderMultiDrawIndexedIndirect.invoke(_encoder, _buffer, _offset, _count);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderPassEncoderMultiDrawIndirectCount = lookup(null, "wgpuRenderPassEncoderMultiDrawIndirectCount", POINTER, POINTER, JAVA_LONG, POINTER, JAVA_LONG, JAVA_INT);
	public static void wgpuRenderPassEncoderMultiDrawIndirectCount(final WGPURenderPassEncoder encoder, final WGPUBuffer buffer, final long offset, final WGPUBuffer count_buffer, final long count_buffer_offset, final int max_count) {
		try(var arena = Arena.ofConfined()) {
			var _encoder = pointer(arena, encoder);
			var _buffer = pointer(arena, buffer);
			var _offset = value(arena, offset);
			var _count_buffer = pointer(arena, count_buffer);
			var _count_buffer_offset = value(arena, count_buffer_offset);
			var _max_count = value(arena, max_count);
			wgpuRenderPassEncoderMultiDrawIndirectCount.invoke(_encoder, _buffer, _offset, _count_buffer, _count_buffer_offset, _max_count);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderPassEncoderMultiDrawIndexedIndirectCount = lookup(null, "wgpuRenderPassEncoderMultiDrawIndexedIndirectCount", POINTER, POINTER, JAVA_LONG, POINTER, JAVA_LONG, JAVA_INT);
	public static void wgpuRenderPassEncoderMultiDrawIndexedIndirectCount(final WGPURenderPassEncoder encoder, final WGPUBuffer buffer, final long offset, final WGPUBuffer count_buffer, final long count_buffer_offset, final int max_count) {
		try(var arena = Arena.ofConfined()) {
			var _encoder = pointer(arena, encoder);
			var _buffer = pointer(arena, buffer);
			var _offset = value(arena, offset);
			var _count_buffer = pointer(arena, count_buffer);
			var _count_buffer_offset = value(arena, count_buffer_offset);
			var _max_count = value(arena, max_count);
			wgpuRenderPassEncoderMultiDrawIndexedIndirectCount.invoke(_encoder, _buffer, _offset, _count_buffer, _count_buffer_offset, _max_count);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuComputePassEncoderBeginPipelineStatisticsQuery = lookup(null, "wgpuComputePassEncoderBeginPipelineStatisticsQuery", POINTER, POINTER, JAVA_INT);
	public static void wgpuComputePassEncoderBeginPipelineStatisticsQuery(final WGPUComputePassEncoder computePassEncoder, final WGPUQuerySet querySet, final int queryIndex) {
		try(var arena = Arena.ofConfined()) {
			var _computePassEncoder = pointer(arena, computePassEncoder);
			var _querySet = pointer(arena, querySet);
			var _queryIndex = value(arena, queryIndex);
			wgpuComputePassEncoderBeginPipelineStatisticsQuery.invoke(_computePassEncoder, _querySet, _queryIndex);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuComputePassEncoderEndPipelineStatisticsQuery = lookup(null, "wgpuComputePassEncoderEndPipelineStatisticsQuery", POINTER);
	public static void wgpuComputePassEncoderEndPipelineStatisticsQuery(final WGPUComputePassEncoder computePassEncoder) {
		try(var arena = Arena.ofConfined()) {
			var _computePassEncoder = pointer(arena, computePassEncoder);
			wgpuComputePassEncoderEndPipelineStatisticsQuery.invoke(_computePassEncoder);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderPassEncoderBeginPipelineStatisticsQuery = lookup(null, "wgpuRenderPassEncoderBeginPipelineStatisticsQuery", POINTER, POINTER, JAVA_INT);
	public static void wgpuRenderPassEncoderBeginPipelineStatisticsQuery(final WGPURenderPassEncoder renderPassEncoder, final WGPUQuerySet querySet, final int queryIndex) {
		try(var arena = Arena.ofConfined()) {
			var _renderPassEncoder = pointer(arena, renderPassEncoder);
			var _querySet = pointer(arena, querySet);
			var _queryIndex = value(arena, queryIndex);
			wgpuRenderPassEncoderBeginPipelineStatisticsQuery.invoke(_renderPassEncoder, _querySet, _queryIndex);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final MethodHandle wgpuRenderPassEncoderEndPipelineStatisticsQuery = lookup(null, "wgpuRenderPassEncoderEndPipelineStatisticsQuery", POINTER);
	public static void wgpuRenderPassEncoderEndPipelineStatisticsQuery(final WGPURenderPassEncoder renderPassEncoder) {
		try(var arena = Arena.ofConfined()) {
			var _renderPassEncoder = pointer(arena, renderPassEncoder);
			wgpuRenderPassEncoderEndPipelineStatisticsQuery.invoke(_renderPassEncoder);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

}
