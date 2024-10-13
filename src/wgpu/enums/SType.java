package wgpu.enums;

public interface SType {
	public static final int Invalid = 0x00000000;
	public static final int SurfaceDescriptorFromMetalLayer = 0x00000001;
	public static final int SurfaceDescriptorFromWindowsHWND = 0x00000002;
	public static final int SurfaceDescriptorFromXlibWindow = 0x00000003;
	public static final int SurfaceDescriptorFromCanvasHTMLSelector = 0x00000004;
	public static final int ShaderModuleSPIRVDescriptor = 0x00000005;
	public static final int ShaderModuleWGSLDescriptor = 0x00000006;
	public static final int PrimitiveDepthClipControl = 0x00000007;
	public static final int SurfaceDescriptorFromWaylandSurface = 0x00000008;
	public static final int SurfaceDescriptorFromAndroidNativeWindow = 0x00000009;
	public static final int SurfaceDescriptorFromXcbWindow = 0x0000000A;
	public static final int RenderPassDescriptorMaxDrawCount = 0x0000000F;
	public static final int DeviceExtras = 0x00030001;
	public static final int RequiredLimitsExtras = 0x00030002;
	public static final int PipelineLayoutExtras = 0x00030003;
	public static final int ShaderModuleGLSLDescriptor = 0x00030004;
	public static final int SupportedLimitsExtras = 0x00030005;
	public static final int InstanceExtras = 0x00030006;
	public static final int BindGroupEntryExtras = 0x00030007;
	public static final int BindGroupLayoutEntryExtras = 0x00030008;
	public static final int QuerySetDescriptorExtras = 0x00030009;
	public static final int SurfaceConfigurationExtras = 0x0003000A;
}
