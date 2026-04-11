package selfgemma.talk.data.roleplay.interop.stcardpng;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\u0005J\u0014\u0010\n\u001a\u00020\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\u0016\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eJ\u001c\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\bJ\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0005H\u0002J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\u0010\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0017H\u0002J\u0018\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2 = {"Lselfgemma/talk/data/roleplay/interop/stcardpng/PngTextChunkCodec;", "", "<init>", "()V", "pngSignature", "", "decodeChunks", "", "Lselfgemma/talk/data/roleplay/interop/stcardpng/PngChunk;", "pngBytes", "encodeChunks", "chunks", "encodeTextChunk", "keyword", "", "text", "decodeTextChunk", "Lkotlin/Pair;", "chunk", "hasValidSignature", "", "bytes", "readInt", "", "offset", "intToBytes", "value", "crcBytes", "typeBytes", "data", "app_debug"})
public final class PngTextChunkCodec {
    @org.jetbrains.annotations.NotNull()
    private static final byte[] pngSignature = {(byte)-119, (byte)80, (byte)78, (byte)71, (byte)13, (byte)10, (byte)26, (byte)10};
    @org.jetbrains.annotations.NotNull()
    public static final selfgemma.talk.data.roleplay.interop.stcardpng.PngTextChunkCodec INSTANCE = null;
    
    private PngTextChunkCodec() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<selfgemma.talk.data.roleplay.interop.stcardpng.PngChunk> decodeChunks(@org.jetbrains.annotations.NotNull()
    byte[] pngBytes) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final byte[] encodeChunks(@org.jetbrains.annotations.NotNull()
    java.util.List<selfgemma.talk.data.roleplay.interop.stcardpng.PngChunk> chunks) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.data.roleplay.interop.stcardpng.PngChunk encodeTextChunk(@org.jetbrains.annotations.NotNull()
    java.lang.String keyword, @org.jetbrains.annotations.NotNull()
    java.lang.String text) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final kotlin.Pair<java.lang.String, java.lang.String> decodeTextChunk(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.roleplay.interop.stcardpng.PngChunk chunk) {
        return null;
    }
    
    private final boolean hasValidSignature(byte[] bytes) {
        return false;
    }
    
    private final int readInt(byte[] bytes, int offset) {
        return 0;
    }
    
    private final byte[] intToBytes(int value) {
        return null;
    }
    
    private final byte[] crcBytes(byte[] typeBytes, byte[] data) {
        return null;
    }
}