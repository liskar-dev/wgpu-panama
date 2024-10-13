package wgpu.struct;

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

public class DeviceDescriptor extends WGPUStruct {
	public ChainedStruct nextInChain;
	@Nullable
	public String label;
	// [requiredFeatureCount]
	public FeatureName[] requiredFeatures;
	@Nullable
	public RequiredLimits requiredLimits;
	public QueueDescriptor defaultQueue;
	public DeviceLostCallback deviceLostCallback;
	public long deviceLostUserdata;
	public UncapturedErrorCallbackInfo uncapturedErrorCallbackInfo;

	protected int sizeInBytes() {
		return 96;
	}

	protected void writeTo(WGPUWriter out) {
		out.pointer(nextInChain);
		out.pointer(label);
		out.write((long) (requiredFeatures == null ? 0 : requiredFeatures.length));
		out.pointer(requiredFeatures);
		out.pointer(requiredLimits);
		out.write(defaultQueue);
		out.pointer(WGPUCallback.createStub(deviceLostCallback, deviceLostCallback.handle, deviceLostCallback.desc));
		out.write(deviceLostUserdata);
		out.write(uncapturedErrorCallbackInfo);
	}

	protected DeviceDescriptor readFrom(WGPUReader in) {
		nextInChain = ChainedStruct.from(in.read_pointer());
		label = in.read_string();
		var requiredFeatureCount = (int) in.read_long();
		var _requiredFeatures = in.read_pointer();
		var _requiredLimits = in.read_pointer();
		requiredLimits = isNull(_requiredLimits) ? null : new RequiredLimits().readFrom(new WGPUReader(_requiredLimits));
		defaultQueue = new QueueDescriptor().readFrom(in);
		 in.read_pointer(); // TODO UNSOPPORTED:deviceLostCallback = new Callback();
		deviceLostUserdata = in.read_long();
		uncapturedErrorCallbackInfo = new UncapturedErrorCallbackInfo().readFrom(in);
		if(!isNull(_requiredFeatures)) {
			requiredFeatures = new FeatureName[requiredFeatureCount];
			var rin = new WGPUReader(_requiredFeatures);
			for(int i=0; i<requiredFeatures.length; i++) {
				requiredFeatures[i] = FeatureName.from(rin.read_int());
			}
		}
		return this;
	}

	public DeviceDescriptor() {}

	public DeviceDescriptor(MemorySegment from) {
		readFrom(new WGPUReader(from));
	}

}
