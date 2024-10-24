package wgpu.enums;

import wgpu.CEnum;
import java.util.*;

public class StorageTextureAccess extends CEnum {
	private static final Map<Integer, StorageTextureAccess> map = new HashMap<>();
	public static final StorageTextureAccess UNDEFINED = new StorageTextureAccess(0x00000000, "Undefined");
	public static final StorageTextureAccess WRITE_ONLY = new StorageTextureAccess(0x00000001, "WriteOnly");
	public static final StorageTextureAccess READ_ONLY = new StorageTextureAccess(0x00000002, "ReadOnly");
	public static final StorageTextureAccess READ_WRITE = new StorageTextureAccess(0x00000003, "ReadWrite");

	public static StorageTextureAccess from(int bits) {
		return map.get(bits);
	}

	private StorageTextureAccess(int bits, String name) {
		super(bits, name);
		map.put(bits, this);
	}
}
