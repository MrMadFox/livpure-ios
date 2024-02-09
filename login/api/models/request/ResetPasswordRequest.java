package com.livpure.safedrink.login.api.models.request;

import com.google.gson.annotations.SerializedName;
import com.moengage.pushbase.MoEPushConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ResetPasswordRequest.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/livpure/safedrink/login/api/models/request/ResetPasswordRequest;", "", "username", "", "otp", "", "newPassword", "(Ljava/lang/String;ILjava/lang/String;)V", "getNewPassword", "()Ljava/lang/String;", "getOtp", "()I", "getUsername", "component1", "component2", "component3", MoEPushConstants.ACTION_COPY, "equals", "", "other", "hashCode", "toString", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ResetPasswordRequest {
    @SerializedName("newpassword")
    private final String newPassword;
    private final int otp;
    @SerializedName("email")
    private final String username;

    public static /* synthetic */ ResetPasswordRequest copy$default(ResetPasswordRequest resetPasswordRequest, String str, int i, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = resetPasswordRequest.username;
        }
        if ((i2 & 2) != 0) {
            i = resetPasswordRequest.otp;
        }
        if ((i2 & 4) != 0) {
            str2 = resetPasswordRequest.newPassword;
        }
        return resetPasswordRequest.copy(str, i, str2);
    }

    public final String component1() {
        return this.username;
    }

    public final int component2() {
        return this.otp;
    }

    public final String component3() {
        return this.newPassword;
    }

    public final ResetPasswordRequest copy(String username, int i, String newPassword) {
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(newPassword, "newPassword");
        return new ResetPasswordRequest(username, i, newPassword);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ResetPasswordRequest) {
            ResetPasswordRequest resetPasswordRequest = (ResetPasswordRequest) obj;
            return Intrinsics.areEqual(this.username, resetPasswordRequest.username) && this.otp == resetPasswordRequest.otp && Intrinsics.areEqual(this.newPassword, resetPasswordRequest.newPassword);
        }
        return false;
    }

    public int hashCode() {
        return (((this.username.hashCode() * 31) + this.otp) * 31) + this.newPassword.hashCode();
    }

    public String toString() {
        return "ResetPasswordRequest(username=" + this.username + ", otp=" + this.otp + ", newPassword=" + this.newPassword + ')';
    }

    public ResetPasswordRequest(String username, int i, String newPassword) {
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(newPassword, "newPassword");
        this.username = username;
        this.otp = i;
        this.newPassword = newPassword;
    }

    public final String getUsername() {
        return this.username;
    }

    public final int getOtp() {
        return this.otp;
    }

    public final String getNewPassword() {
        return this.newPassword;
    }
}
