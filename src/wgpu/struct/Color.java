package wgpu.struct;

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

public class Color extends WGPUStruct {
	public double r;
	public double g;
	public double b;
	public double a;

	protected static final int byteSize = 32;
	protected int byteSize() {
		return byteSize;
	}

	protected long store(Stack stack, long address) {
		put_value(address+0, (double) r);
		put_value(address+8, (double) g);
		put_value(address+16, (double) b);
		put_value(address+24, (double) a);
		return address;
	}

	protected Color load(long address) {
		r = get_double(address+0);
		g = get_double(address+8);
		b = get_double(address+16);
		a = get_double(address+24);
		return this;
	}
	public Color(double r, double g, double b, double a) {
		this.r = r;
		this.g = g;
		this.b = b;
		this.a = a;
	}

	public Color() {}
}
