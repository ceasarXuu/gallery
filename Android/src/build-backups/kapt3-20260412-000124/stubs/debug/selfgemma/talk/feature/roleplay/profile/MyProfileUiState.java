package selfgemma.talk.feature.roleplay.profile;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b*\b\u0086\b\u0018\u00002\u00020\u0001B\u009d\u0001\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\r\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0016\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\t\u00100\u001a\u00020\tH\u00c6\u0003J\t\u00101\u001a\u00020\tH\u00c6\u0003J\t\u00102\u001a\u00020\tH\u00c6\u0003J\t\u00103\u001a\u00020\u0006H\u00c6\u0003J\t\u00104\u001a\u00020\u0006H\u00c6\u0003J\t\u00105\u001a\u00020\u0006H\u00c6\u0003J\t\u00106\u001a\u00020\u0010H\u00c6\u0003J\t\u00107\u001a\u00020\u0006H\u00c6\u0003J\t\u00108\u001a\u00020\u0013H\u00c6\u0003J\t\u00109\u001a\u00020\u0006H\u00c6\u0003J\t\u0010:\u001a\u00020\u0016H\u00c6\u0003J\u009f\u0001\u0010;\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00062\b\b\u0002\u0010\u0015\u001a\u00020\u0016H\u00c6\u0001J\u0013\u0010<\u001a\u00020\u00162\b\u0010=\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010>\u001a\u00020\u0013H\u00d6\u0001J\t\u0010?\u001a\u00020\u0006H\u00d6\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\n\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u001fR\u0011\u0010\u000b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001fR\u0011\u0010\f\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001cR\u0011\u0010\r\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001cR\u0011\u0010\u000e\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001cR\u0011\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\u0011\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010\u001cR\u0011\u0010\u0012\u001a\u00020\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010\u0014\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001cR\u0011\u0010\u0015\u001a\u00020\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010,\u00a8\u0006@"}, d2 = {"Lselfgemma/talk/feature/roleplay/profile/MyProfileUiState;", "", "personaCards", "", "Lselfgemma/talk/feature/roleplay/profile/PersonaSlotCardUiState;", "avatarUri", "", "avatarEditorSourceUri", "avatarCropZoom", "", "avatarCropOffsetX", "avatarCropOffsetY", "personaName", "personaTitle", "personaDescription", "personaPosition", "Lselfgemma/talk/domain/roleplay/model/StPersonaDescriptionPosition;", "personaDepth", "personaRole", "", "avatarSlotId", "dirty", "", "<init>", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;FFFLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lselfgemma/talk/domain/roleplay/model/StPersonaDescriptionPosition;Ljava/lang/String;ILjava/lang/String;Z)V", "getPersonaCards", "()Ljava/util/List;", "getAvatarUri", "()Ljava/lang/String;", "getAvatarEditorSourceUri", "getAvatarCropZoom", "()F", "getAvatarCropOffsetX", "getAvatarCropOffsetY", "getPersonaName", "getPersonaTitle", "getPersonaDescription", "getPersonaPosition", "()Lselfgemma/talk/domain/roleplay/model/StPersonaDescriptionPosition;", "getPersonaDepth", "getPersonaRole", "()I", "getAvatarSlotId", "getDirty", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "copy", "equals", "other", "hashCode", "toString", "app_debug"})
public final class MyProfileUiState {
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<selfgemma.talk.feature.roleplay.profile.PersonaSlotCardUiState> personaCards = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String avatarUri = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String avatarEditorSourceUri = null;
    private final float avatarCropZoom = 0.0F;
    private final float avatarCropOffsetX = 0.0F;
    private final float avatarCropOffsetY = 0.0F;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String personaName = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String personaTitle = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String personaDescription = null;
    @org.jetbrains.annotations.NotNull()
    private final selfgemma.talk.domain.roleplay.model.StPersonaDescriptionPosition personaPosition = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String personaDepth = null;
    private final int personaRole = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String avatarSlotId = null;
    private final boolean dirty = false;
    
    public MyProfileUiState(@org.jetbrains.annotations.NotNull()
    java.util.List<selfgemma.talk.feature.roleplay.profile.PersonaSlotCardUiState> personaCards, @org.jetbrains.annotations.Nullable()
    java.lang.String avatarUri, @org.jetbrains.annotations.Nullable()
    java.lang.String avatarEditorSourceUri, float avatarCropZoom, float avatarCropOffsetX, float avatarCropOffsetY, @org.jetbrains.annotations.NotNull()
    java.lang.String personaName, @org.jetbrains.annotations.NotNull()
    java.lang.String personaTitle, @org.jetbrains.annotations.NotNull()
    java.lang.String personaDescription, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.model.StPersonaDescriptionPosition personaPosition, @org.jetbrains.annotations.NotNull()
    java.lang.String personaDepth, int personaRole, @org.jetbrains.annotations.NotNull()
    java.lang.String avatarSlotId, boolean dirty) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<selfgemma.talk.feature.roleplay.profile.PersonaSlotCardUiState> getPersonaCards() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getAvatarUri() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getAvatarEditorSourceUri() {
        return null;
    }
    
    public final float getAvatarCropZoom() {
        return 0.0F;
    }
    
    public final float getAvatarCropOffsetX() {
        return 0.0F;
    }
    
    public final float getAvatarCropOffsetY() {
        return 0.0F;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPersonaName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPersonaTitle() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPersonaDescription() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.domain.roleplay.model.StPersonaDescriptionPosition getPersonaPosition() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPersonaDepth() {
        return null;
    }
    
    public final int getPersonaRole() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAvatarSlotId() {
        return null;
    }
    
    public final boolean getDirty() {
        return false;
    }
    
    public MyProfileUiState() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<selfgemma.talk.feature.roleplay.profile.PersonaSlotCardUiState> component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.domain.roleplay.model.StPersonaDescriptionPosition component10() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component11() {
        return null;
    }
    
    public final int component12() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component13() {
        return null;
    }
    
    public final boolean component14() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component3() {
        return null;
    }
    
    public final float component4() {
        return 0.0F;
    }
    
    public final float component5() {
        return 0.0F;
    }
    
    public final float component6() {
        return 0.0F;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.feature.roleplay.profile.MyProfileUiState copy(@org.jetbrains.annotations.NotNull()
    java.util.List<selfgemma.talk.feature.roleplay.profile.PersonaSlotCardUiState> personaCards, @org.jetbrains.annotations.Nullable()
    java.lang.String avatarUri, @org.jetbrains.annotations.Nullable()
    java.lang.String avatarEditorSourceUri, float avatarCropZoom, float avatarCropOffsetX, float avatarCropOffsetY, @org.jetbrains.annotations.NotNull()
    java.lang.String personaName, @org.jetbrains.annotations.NotNull()
    java.lang.String personaTitle, @org.jetbrains.annotations.NotNull()
    java.lang.String personaDescription, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.model.StPersonaDescriptionPosition personaPosition, @org.jetbrains.annotations.NotNull()
    java.lang.String personaDepth, int personaRole, @org.jetbrains.annotations.NotNull()
    java.lang.String avatarSlotId, boolean dirty) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
}