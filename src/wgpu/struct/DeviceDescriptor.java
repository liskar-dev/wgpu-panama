package wgpu.struct;

import wgpu.*;
import wgpu.impl.*;
import wgpu.struct.*;
import wgpu.enums.*;
import wgpu.callback.*;

import java.lang.foreign.*;
import org.jspecify.annotations.*;

import static java.lang.foreign.ValueLayout.*;
import static java.lang.foreign.MemoryLayout.*;

public class DeviceDescriptor extends CStruct {
	public ChainedStruct nextInChain;
	@Nullable
	public String label;
	// size_t requiredFeatureCount
	public FeatureName[] requiredFeatures;
	@Nullable
	public RequiredLimits requiredLimits;
	public QueueDescriptor defaultQueue = new QueueDescriptor();
	public DeviceLostCallback deviceLostCallback;
	public long deviceLostUserdata;
	public UncapturedErrorCallbackInfo uncapturedErrorCallbackInfo = new UncapturedErrorCallbackInfo();

	protected static final int byteSize = 96;
	protected int byteSize() {
		return byteSize;
	}

	protected long store(Stack stack, long address) {
		put_value(address+0, stack.alloc(nextInChain));
		put_value(address+8, stack.alloc(label));
		put_value(address+16, (long) (requiredFeatures == null ? 0 : requiredFeatures.length));
		put_value(address+24, stack.alloc(requiredFeatures));
		put_value(address+32, stack.alloc(requiredLimits));
		defaultQueue.store(stack, address+40);
		put_pointer(address+56, Callback.createStub(deviceLostCallback, deviceLostCallback.handle, deviceLostCallback.desc));
		put_value(address+64, (long) deviceLostUserdata);
		uncapturedErrorCallbackInfo.store(stack, address+72);
		return address;
	}

	protected DeviceDescriptor load(long address) {
		nextInChain = ChainedStruct.from(get_long(address+0));
		label = get_string(get_long(address+8));
		var requiredFeatureCount = (int) get_long(address+16);
		var _requiredFeatures = get_long(address+24);
		var _requiredLimits = get_long(address+32);
		requiredLimits = _requiredLimits == 0 ? null : (requiredLimits != null ? requiredLimits : new RequiredLimits()).load(_requiredLimits);
		defaultQueue = defaultQueue.load(address+40);
		// unsupported DeviceLostCallback * deviceLostCallback
		deviceLostUserdata = get_long(address+64);
		uncapturedErrorCallbackInfo = uncapturedErrorCallbackInfo.load(address+72);
		if(_requiredFeatures != 0L) {
			requiredFeatures = requiredFeatures != null && requiredFeatures.length == requiredFeatureCount ? requiredFeatures : new FeatureName[requiredFeatureCount];
			for(int i=0; i<requiredFeatures.length; i++) {
				requiredFeatures[i] = FeatureName.from(get_int(_requiredFeatures + i*4));
			}
		} else {
			requiredFeatures= null;
		}
		requiredLimits = _requiredLimits == 0 ? null : (requiredLimits != null ? requiredLimits : new RequiredLimits()).load(_requiredLimits);
		return this;
	}
	public DeviceDescriptor() {}
}
