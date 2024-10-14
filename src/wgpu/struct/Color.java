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

public class Color extends WGPUStruct {
	public double r;
	public double g;
	public double b;
	public double a;

	protected int sizeInBytes() {
		return 32;
	}

	protected void writeTo(WGPUWriter out) {
		out.write(r);
		out.write(g);
		out.write(b);
		out.write(a);
	}

	protected Color readFrom(WGPUReader in) {
		r = in.read_double();
		g = in.read_double();
		b = in.read_double();
		a = in.read_double();
		return this;
	}

	public Color(double r, double g, double b, double a) {
		this.r = r;
		this.g = g;
		this.b = b;
		this.a = a;
	}

	public Color() {}

	public Color(MemorySegment from) {
		readFrom(new WGPUReader(from));
	}

}
