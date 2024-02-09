package com.livpure.safedrink.utils;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: PermissionsRequest.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0011\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0010X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/livpure/safedrink/utils/PermissionsRequest;", "", "()V", "callPermission", "", "getCallPermission", "()Ljava/lang/String;", "setCallPermission", "(Ljava/lang/String;)V", "contactPermission", "getContactPermission", "setContactPermission", "locationPermission", "getLocationPermission", "setLocationPermission", "permissions", "", "getPermissions", "()[Ljava/lang/String;", "setPermissions", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PermissionsRequest {
    public static final PermissionsRequest INSTANCE = new PermissionsRequest();
    private static String[] permissions = {"android.permission.CALL_PHONE", "android.permission.CAMERA", "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.ACCESS_FINE_LOCATION"};
    private static String contactPermission = "android.permission.READ_CONTACTS";
    private static String locationPermission = "android.permission.ACCESS_FINE_LOCATION";
    private static String callPermission = "android.permission.CALL_PHONE";

    private PermissionsRequest() {
    }

    public final String[] getPermissions() {
        return permissions;
    }

    public final void setPermissions(String[] strArr) {
        Intrinsics.checkNotNullParameter(strArr, "<set-?>");
        permissions = strArr;
    }

    public final String getContactPermission() {
        return contactPermission;
    }

    public final void setContactPermission(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        contactPermission = str;
    }

    public final String getLocationPermission() {
        return locationPermission;
    }

    public final void setLocationPermission(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        locationPermission = str;
    }

    public final String getCallPermission() {
        return callPermission;
    }

    public final void setCallPermission(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        callPermission = str;
    }
}
