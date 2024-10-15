package wgpu;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import static wgpu.StaticHelpers.*;

public class Stack implements AutoCloseable {
	final Arena arena;
	final MemorySegment mem;
	final long address;
	final int capacity;
	int offset;
	
	// hopefully will never go deeper
	int[] stack = new int[8];
	int depth = 0;
	
	public Stack(Arena arena, int size) {
		this.arena = arena;
		mem = arena.allocate(size, 8);
		address = mem.address();
		capacity = size;
	}
	
	public Stack(Arena arena) {
		this(arena, 1024);
	}
	
	public Stack() {
		this(Arena.ofConfined());
	}
	
	public Stack(int size) {
		this(Arena.ofConfined(), size);
	}
	
	public MemorySegment allocate(int size) {
		return MemorySegment.ofAddress(calloc(size)).reinterpret(size);
	}

	public long calloc(int size) {
		if(offset + size > capacity)
			throw new StackOverflowError();
		long segment = offset + address;
		offset += size;
		if((offset&7) != 0) {
			offset += 8-(offset&7);
		}
		return segment;
	}

	public long alloc(int size) {
		if(offset + size > capacity)
			throw new StackOverflowError();
		long segment = offset + address;
		offset += size;
		if((offset&7) != 0) {
			offset += 8-(offset&7);
		}
		MemorySegment.ofAddress(segment).reinterpret(size).fill((byte) 0);
		return segment;
	}

	public long alloc(WGPUStruct struct) {
		return struct == null ? 0L : struct.store(this, calloc(struct.byteSize()));
	}

	public long alloc(WGPUStruct[] array) {
		if(array == null || array.length == 0) return 0L;
		var first = array[0];
		var size = first.byteSize();
		var address = calloc(size * array.length);
		for(int i=0; i<array.length; i++) {
			array[i].store(this, address + i * size);
		}
		return address;
	}

	public long alloc(WGPUImpl[] array) {
		if(array == null || array.length == 0) return 0L;
		var address = calloc(8 * array.length);
		for(int i=0; i<array.length; i++) {
			put_value(address + i * 8, array[i].handle);
		}
		return address;
	}

	public long alloc(WGPUEnum[] array) {
		if(array == null || array.length == 0) return 0L;
		var address = calloc(4 * array.length);
		for(int i=0; i<array.length; i++) {
			put_value(address + i * 4, array[i].bits);
		}
		return address;
	}

	public long prealloc(WGPUStruct struct) {
		return struct == null ? 0L : alloc(struct.byteSize());
	}

	public long prealloc(WGPUEnum[] array) {
		if(array == null || array.length == 0) return 0L;
		return alloc(4 * array.length);
	}

	public long prealloc(WGPUImpl[] array) {
		if(array == null || array.length == 0) return 0L;
		return alloc(8 * array.length);
	}

	public long alloc(int[] array) {
		if(array == null || array.length == 0) return 0L;
		var address = calloc(4 * array.length);
		for(int i=0; i<array.length; i++) {
			put_value(address + i * 4, array[i]);
		}
		return address;
	}
	
	public long alloc(String string) {
		if(string == null) return 0L;
		long address = calloc(string.length()+1);
		for(int i=0; i<string.length(); i++) {
			put_value(address+i, (byte) string.charAt(i));
		}
		put_value(address + string.length(), (byte) 0);
		return address;
	}
	
	private Stack push() {
		stack[depth++] = offset;
		return this;
	}
	
	private void pop() {
		offset = stack[--depth];
	}

	/** It's just pop() for try with resources */
	public void close() {
		pop();
	}

	static final ThreadLocal<Stack> threadLocal = new ThreadLocal<>(); 
	
	public static Stack get() {
		Stack local = threadLocal.get();
		if(local == null) {
			local = new Stack();
			threadLocal.set(local);
		}
		local.push();
		return local;
	}
	
	public static Stack current() {
		return threadLocal.get();
	}
	
	public void closeArena() {
		arena.close();
	}
}
