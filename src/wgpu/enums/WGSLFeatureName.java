package wgpu.enums;

import wgpu.CEnum;
import java.util.*;

public class WGSLFeatureName extends CEnum {
	private static final Map<Integer, WGSLFeatureName> map = new HashMap<>();
	public static final WGSLFeatureName UNDEFINED = new WGSLFeatureName(0x00000000, "Undefined");
	public static final WGSLFeatureName READONLY_AND_READWRITE_STORAGE_TEXTURES = new WGSLFeatureName(0x00000001, "ReadonlyAndReadwriteStorageTextures");
	public static final WGSLFeatureName PACKED4X8_INTEGER_DOT_PRODUCT = new WGSLFeatureName(0x00000002, "Packed4x8IntegerDotProduct");
	public static final WGSLFeatureName UNRESTRICTED_POINTER_PARAMETERS = new WGSLFeatureName(0x00000003, "UnrestrictedPointerParameters");
	public static final WGSLFeatureName POINTER_COMPOSITE_ACCESS = new WGSLFeatureName(0x00000004, "PointerCompositeAccess");

	public static WGSLFeatureName from(int bits) {
		return map.get(bits);
	}

	private WGSLFeatureName(int bits, String name) {
		super(bits, name);
		map.put(bits, this);
	}
}
