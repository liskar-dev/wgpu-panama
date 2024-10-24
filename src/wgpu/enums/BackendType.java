package wgpu.enums;

import wgpu.CEnum;
import java.util.*;

public class BackendType extends CEnum {
	private static final Map<Integer, BackendType> map = new HashMap<>();
	public static final BackendType UNDEFINED = new BackendType(0x00000000, "Undefined");
	public static final BackendType NULL = new BackendType(0x00000001, "Null");
	public static final BackendType WEB_GPU = new BackendType(0x00000002, "WebGPU");
	public static final BackendType D3D11 = new BackendType(0x00000003, "D3D11");
	public static final BackendType D3D12 = new BackendType(0x00000004, "D3D12");
	public static final BackendType METAL = new BackendType(0x00000005, "Metal");
	public static final BackendType VULKAN = new BackendType(0x00000006, "Vulkan");
	public static final BackendType OPEN_GL = new BackendType(0x00000007, "OpenGL");
	public static final BackendType OPEN_GLES = new BackendType(0x00000008, "OpenGLES");

	public static BackendType from(int bits) {
		return map.get(bits);
	}

	private BackendType(int bits, String name) {
		super(bits, name);
		map.put(bits, this);
	}
}
