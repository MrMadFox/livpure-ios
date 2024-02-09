package com.livpure.safedrink.profile.api.models.request;

import com.moengage.pushbase.MoEPushConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SendProfileUpdateOtpRequest.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/livpure/safedrink/profile/api/models/request/SendProfileUpdateOtpRequest;", "", "mobile", "", "email", "deviceAppUID", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDeviceAppUID", "()Ljava/lang/String;", "getEmail", "getMobile", "component1", "component2", "component3", MoEPushConstants.ACTION_COPY, "equals", "", "other", "hashCode", "", "toString", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SendProfileUpdateOtpRequest {
    private final String deviceAppUID;
    private final String email;
    private final String mobile;

    public static /* synthetic */ SendProfileUpdateOtpRequest copy$default(SendProfileUpdateOtpRequest sendProfileUpdateOtpRequest, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = sendProfileUpdateOtpRequest.mobile;
        }
        if ((i & 2) != 0) {
            str2 = sendProfileUpdateOtpRequest.email;
        }
        if ((i & 4) != 0) {
            str3 = sendProfileUpdateOtpRequest.deviceAppUID;
        }
        return sendProfileUpdateOtpRequest.copy(str, str2, str3);
    }

    public final String component1() {
        return this.mobile;
    }

    public final String component2() {
        return this.email;
    }

    public final String component3() {
        return this.deviceAppUID;
    }

    public final SendProfileUpdateOtpRequest copy(String mobile, String email, String deviceAppUID) {
        Intrinsics.checkNotNullParameter(mobile, "mobile");
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(deviceAppUID, "deviceAppUID");
        return new SendProfileUpdateOtpRequest(mobile, email, deviceAppUID);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SendProfileUpdateOtpRequest) {
            SendProfileUpdateOtpRequest sendProfileUpdateOtpRequest = (SendProfileUpdateOtpRequest) obj;
            return Intrinsics.areEqual(this.mobile, sendProfileUpdateOtpRequest.mobile) && Intrinsics.areEqual(this.email, sendProfileUpdateOtpRequest.email) && Intrinsics.areEqual(this.deviceAppUID, sendProfileUpdateOtpRequest.deviceAppUID);
        }
        return false;
    }

    public int hashCode() {
        return (((this.mobile.hashCode() * 31) + this.email.hashCode()) * 31) + this.deviceAppUID.hashCode();
    }

    public String toString() {
        return "SendProfileUpdateOtpRequest(mobile=" + this.mobile + ", email=" + this.email + ", deviceAppUID=" + this.deviceAppUID + ')';
    }

    public SendProfileUpdateOtpRequest(String mobile, String email, String deviceAppUID) {
        Intrinsics.checkNotNullParameter(mobile, "mobile");
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(deviceAppUID, "deviceAppUID");
        this.mobile = mobile;
        this.email = email;
        this.deviceAppUID = deviceAppUID;
    }

    public final String getMobile() {
        return this.mobile;
    }

    public final String getEmail() {
        return this.email;
    }

    public final String getDeviceAppUID() {
        return this.deviceAppUID;
    }
}
