[![Experimental Build](https://github.com/liskar-dev/wgpu-panama/actions/workflows/main.yml/badge.svg)](https://github.com/liskar-dev/wgpu-panama/actions/workflows/main.yml)

# wgpu-panama

Java bindings for [wgpu-native](https://github.com/gfx-rs/wgpu-native) using [Panama FFI](https://openjdk.org/jeps/424) with some experimental approach. The goal is to make the API similar to what it looks like in JavaScript.

Requires JDK 23 and wgpu-native v22.1.0.5

## Usage

In general wgpu API can be used "raw" with static methods located under `wgpu.WGPU.*`. These use raw `long` for WGPU object references and `MemorySegment` for data. The other way is to use object wrappers, such as `GPUInstance`, etc.

All callback stubs are allocated with `Arena.ofAuto()` and cached by a weak map. You can safely inline short lasting callbacks, but for "long lasting" callbacks (such as device lost callback) you should keep their instance around to avoid GC cleaning the stub up.


## Examples

There's a triangle rendering example (without geometry) here: [TriangleExample.java](examples/TriangleExample.java)

## Work in progress 🚧

At current stage it's a bit messy and is mostly untested. The code is generated with custom script (not in the repo yet).

If you want to test it, you can download artifacts from the experimental CI build. You will also need wgpu-native binaries in your library path.