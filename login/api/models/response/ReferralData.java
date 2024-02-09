package com.livpure.safedrink.login.api.models.response;

import com.google.gson.annotations.SerializedName;
import com.moengage.pushbase.MoEPushConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ReferralData.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0010"}, d2 = {"Lcom/livpure/safedrink/login/api/models/response/ReferralData;", "", "refShortLink", "", "(Ljava/lang/String;)V", "getRefShortLink", "()Ljava/lang/String;", "setRefShortLink", "component1", MoEPushConstants.ACTION_COPY, "equals", "", "other", "hashCode", "", "toString", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ReferralData {
    @SerializedName("refShortLink")
    private String refShortLink;

    public ReferralData() {
        this(null, 1, null);
    }

    public static /* synthetic */ ReferralData copy$default(ReferralData referralData, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = referralData.refShortLink;
        }
        return referralData.copy(str);
    }

    public final String component1() {
        return this.refShortLink;
    }

    public final ReferralData copy(String str) {
        return new ReferralData(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ReferralData) && Intrinsics.areEqual(this.refShortLink, ((ReferralData) obj).refShortLink);
    }

    public int hashCode() {
        String str = this.refShortLink;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public String toString() {
        return "ReferralData(refShortLink=" + this.refShortLink + ')';
    }

    public ReferralData(String str) {
        this.refShortLink = str;
    }

    public /* synthetic */ ReferralData(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str);
    }

    public final String getRefShortLink() {
        return this.refShortLink;
    }

    public final void setRefShortLink(String str) {
        this.refShortLink = str;
    }
}
