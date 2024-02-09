package com.livpure.safedrink.login.api.models.request;

import com.google.gson.annotations.SerializedName;
import com.moengage.pushbase.MoEPushConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ForgotPasswordRequest.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/livpure/safedrink/login/api/models/request/ForgotPasswordRequest;", "", "username", "", "(Ljava/lang/String;)V", "getUsername", "()Ljava/lang/String;", "component1", MoEPushConstants.ACTION_COPY, "equals", "", "other", "hashCode", "", "toString", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ForgotPasswordRequest {
    @SerializedName("email")
    private final String username;

    public static /* synthetic */ ForgotPasswordRequest copy$default(ForgotPasswordRequest forgotPasswordRequest, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = forgotPasswordRequest.username;
        }
        return forgotPasswordRequest.copy(str);
    }

    public final String component1() {
        return this.username;
    }

    public final ForgotPasswordRequest copy(String username) {
        Intrinsics.checkNotNullParameter(username, "username");
        return new ForgotPasswordRequest(username);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ForgotPasswordRequest) && Intrinsics.areEqual(this.username, ((ForgotPasswordRequest) obj).username);
    }

    public int hashCode() {
        return this.username.hashCode();
    }

    public String toString() {
        return "ForgotPasswordRequest(username=" + this.username + ')';
    }

    public ForgotPasswordRequest(String username) {
        Intrinsics.checkNotNullParameter(username, "username");
        this.username = username;
    }

    public final String getUsername() {
        return this.username;
    }
}
