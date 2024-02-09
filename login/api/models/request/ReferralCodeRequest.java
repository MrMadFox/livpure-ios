package com.livpure.safedrink.login.api.models.request;

import com.moengage.pushbase.MoEPushConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ReferralCodeRequest.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/livpure/safedrink/login/api/models/request/ReferralCodeRequest;", "", "referralCode", "", "(Ljava/lang/String;)V", "getReferralCode", "()Ljava/lang/String;", "component1", MoEPushConstants.ACTION_COPY, "equals", "", "other", "hashCode", "", "toString", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ReferralCodeRequest {
    private final String referralCode;

    public static /* synthetic */ ReferralCodeRequest copy$default(ReferralCodeRequest referralCodeRequest, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = referralCodeRequest.referralCode;
        }
        return referralCodeRequest.copy(str);
    }

    public final String component1() {
        return this.referralCode;
    }

    public final ReferralCodeRequest copy(String referralCode) {
        Intrinsics.checkNotNullParameter(referralCode, "referralCode");
        return new ReferralCodeRequest(referralCode);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ReferralCodeRequest) && Intrinsics.areEqual(this.referralCode, ((ReferralCodeRequest) obj).referralCode);
    }

    public int hashCode() {
        return this.referralCode.hashCode();
    }

    public String toString() {
        return "ReferralCodeRequest(referralCode=" + this.referralCode + ')';
    }

    public ReferralCodeRequest(String referralCode) {
        Intrinsics.checkNotNullParameter(referralCode, "referralCode");
        this.referralCode = referralCode;
    }

    public final String getReferralCode() {
        return this.referralCode;
    }
}
