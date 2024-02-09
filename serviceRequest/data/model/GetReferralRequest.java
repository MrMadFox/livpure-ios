package com.livpure.safedrink.serviceRequest.data.model;

import com.moengage.pushbase.MoEPushConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: GetReferralRequest.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/livpure/safedrink/serviceRequest/data/model/GetReferralRequest;", "", "phone_no", "", "(Ljava/lang/String;)V", "getPhone_no", "()Ljava/lang/String;", "component1", MoEPushConstants.ACTION_COPY, "equals", "", "other", "hashCode", "", "toString", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class GetReferralRequest {
    private final String phone_no;

    public static /* synthetic */ GetReferralRequest copy$default(GetReferralRequest getReferralRequest, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = getReferralRequest.phone_no;
        }
        return getReferralRequest.copy(str);
    }

    public final String component1() {
        return this.phone_no;
    }

    public final GetReferralRequest copy(String str) {
        return new GetReferralRequest(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof GetReferralRequest) && Intrinsics.areEqual(this.phone_no, ((GetReferralRequest) obj).phone_no);
    }

    public int hashCode() {
        String str = this.phone_no;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public String toString() {
        return "GetReferralRequest(phone_no=" + this.phone_no + ')';
    }

    public GetReferralRequest(String str) {
        this.phone_no = str;
    }

    public final String getPhone_no() {
        return this.phone_no;
    }
}
