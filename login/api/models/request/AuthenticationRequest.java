package com.livpure.safedrink.login.api.models.request;

import com.moengage.pushbase.MoEPushConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: AuthenticationRequest.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/livpure/safedrink/login/api/models/request/AuthenticationRequest;", "", "username", "", "password", "deviceAppUID", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDeviceAppUID", "()Ljava/lang/String;", "getPassword", "getUsername", "component1", "component2", "component3", MoEPushConstants.ACTION_COPY, "equals", "", "other", "hashCode", "", "toString", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AuthenticationRequest {
    private final String deviceAppUID;
    private final String password;
    private final String username;

    public static /* synthetic */ AuthenticationRequest copy$default(AuthenticationRequest authenticationRequest, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = authenticationRequest.username;
        }
        if ((i & 2) != 0) {
            str2 = authenticationRequest.password;
        }
        if ((i & 4) != 0) {
            str3 = authenticationRequest.deviceAppUID;
        }
        return authenticationRequest.copy(str, str2, str3);
    }

    public final String component1() {
        return this.username;
    }

    public final String component2() {
        return this.password;
    }

    public final String component3() {
        return this.deviceAppUID;
    }

    public final AuthenticationRequest copy(String username, String password, String deviceAppUID) {
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(password, "password");
        Intrinsics.checkNotNullParameter(deviceAppUID, "deviceAppUID");
        return new AuthenticationRequest(username, password, deviceAppUID);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AuthenticationRequest) {
            AuthenticationRequest authenticationRequest = (AuthenticationRequest) obj;
            return Intrinsics.areEqual(this.username, authenticationRequest.username) && Intrinsics.areEqual(this.password, authenticationRequest.password) && Intrinsics.areEqual(this.deviceAppUID, authenticationRequest.deviceAppUID);
        }
        return false;
    }

    public int hashCode() {
        return (((this.username.hashCode() * 31) + this.password.hashCode()) * 31) + this.deviceAppUID.hashCode();
    }

    public String toString() {
        return "AuthenticationRequest(username=" + this.username + ", password=" + this.password + ", deviceAppUID=" + this.deviceAppUID + ')';
    }

    public AuthenticationRequest(String username, String password, String deviceAppUID) {
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(password, "password");
        Intrinsics.checkNotNullParameter(deviceAppUID, "deviceAppUID");
        this.username = username;
        this.password = password;
        this.deviceAppUID = deviceAppUID;
    }

    public final String getUsername() {
        return this.username;
    }

    public final String getPassword() {
        return this.password;
    }

    public final String getDeviceAppUID() {
        return this.deviceAppUID;
    }
}
