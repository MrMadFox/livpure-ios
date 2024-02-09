package com.livpure.safedrink.profile.api.models.request;

import com.moengage.pushbase.MoEPushConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: VerifyProfileOtpRequest.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/livpure/safedrink/profile/api/models/request/VerifyProfileOtpRequest;", "", "mobile", "", "email", "otp", "deviceAppUID", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDeviceAppUID", "()Ljava/lang/String;", "getEmail", "getMobile", "getOtp", "component1", "component2", "component3", "component4", MoEPushConstants.ACTION_COPY, "equals", "", "other", "hashCode", "", "toString", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class VerifyProfileOtpRequest {
    private final String deviceAppUID;
    private final String email;
    private final String mobile;
    private final String otp;

    public static /* synthetic */ VerifyProfileOtpRequest copy$default(VerifyProfileOtpRequest verifyProfileOtpRequest, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = verifyProfileOtpRequest.mobile;
        }
        if ((i & 2) != 0) {
            str2 = verifyProfileOtpRequest.email;
        }
        if ((i & 4) != 0) {
            str3 = verifyProfileOtpRequest.otp;
        }
        if ((i & 8) != 0) {
            str4 = verifyProfileOtpRequest.deviceAppUID;
        }
        return verifyProfileOtpRequest.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.mobile;
    }

    public final String component2() {
        return this.email;
    }

    public final String component3() {
        return this.otp;
    }

    public final String component4() {
        return this.deviceAppUID;
    }

    public final VerifyProfileOtpRequest copy(String mobile, String email, String otp, String deviceAppUID) {
        Intrinsics.checkNotNullParameter(mobile, "mobile");
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(otp, "otp");
        Intrinsics.checkNotNullParameter(deviceAppUID, "deviceAppUID");
        return new VerifyProfileOtpRequest(mobile, email, otp, deviceAppUID);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof VerifyProfileOtpRequest) {
            VerifyProfileOtpRequest verifyProfileOtpRequest = (VerifyProfileOtpRequest) obj;
            return Intrinsics.areEqual(this.mobile, verifyProfileOtpRequest.mobile) && Intrinsics.areEqual(this.email, verifyProfileOtpRequest.email) && Intrinsics.areEqual(this.otp, verifyProfileOtpRequest.otp) && Intrinsics.areEqual(this.deviceAppUID, verifyProfileOtpRequest.deviceAppUID);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.mobile.hashCode() * 31) + this.email.hashCode()) * 31) + this.otp.hashCode()) * 31) + this.deviceAppUID.hashCode();
    }

    public String toString() {
        return "VerifyProfileOtpRequest(mobile=" + this.mobile + ", email=" + this.email + ", otp=" + this.otp + ", deviceAppUID=" + this.deviceAppUID + ')';
    }

    public VerifyProfileOtpRequest(String mobile, String email, String otp, String deviceAppUID) {
        Intrinsics.checkNotNullParameter(mobile, "mobile");
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(otp, "otp");
        Intrinsics.checkNotNullParameter(deviceAppUID, "deviceAppUID");
        this.mobile = mobile;
        this.email = email;
        this.otp = otp;
        this.deviceAppUID = deviceAppUID;
    }

    public final String getMobile() {
        return this.mobile;
    }

    public final String getEmail() {
        return this.email;
    }

    public final String getOtp() {
        return this.otp;
    }

    public final String getDeviceAppUID() {
        return this.deviceAppUID;
    }
}
