# wgpu-panama

This is my attempt at creating Java binding/wrapper for wgpu-native using Panama FFI with very EXPERIMENTAL approach: All structs have Java wrappers that do not hold a reference to native memory. Instead, they are allocated in a confined Arena and their content copied for the purpose of a wgpu function call.

## About

Requires JDK 23 with Panama and wgpu-native v22.1.0.5 in library path

## Work in progress 🚧

Warning: at current stage it's a mess and is mostly untested.

## Usage

Create instance:

    var instanceDescriptor = new InstanceDescriptor();
    var instance = wgpuCreateInstance(instanceDescriptor);

Request adapter with callback:

    InstanceRequestAdapterCallback callback = (status, adapter, message, userdata) -> {
        System.out.println("Got a callback from adapter ");
        System.out.println("Status: " + status);
        System.out.println("Adapter: " + adapter);
        System.out.println("Message: " + message);
        System.out.println("UserData: " + userdata);
    };
    wgpuInstanceRequestAdapter(instance, null, callback, 0);


Enumerate all adapters and print their info:

    int numAdapters = (int) wgpuInstanceEnumerateAdapters(instance, null, null);
    var adapters = new WGPUAdapter[numAdapters];
    wgpuInstanceEnumerateAdapters(instance, null, adapters);

    for(var adapter : adapters) {
        AdapterInfo info = new AdapterInfo();
        wgpuAdapterGetInfo(adapter, info);
        
        System.out.println("adapter: " + info.adapterType);
        System.out.println("backend: " + info.backendType);
        System.out.println("vendor: " + info.vendor);
        System.out.println("device: " + info.device);
        System.out.println("description: " + info.description);
        System.out.println();
    }

All WebGPU.wgpu* method parameters that are effectively const in original headers are marked final. This changes nothing for the code itself, but serves as an information for the user, describing which params are output.

Generator code that was used to generate the bindings is not in this repo as of yet. (it's a total mess with lots out printlns)
