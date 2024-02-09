package com.livpure.safedrink.login.api.models.response;

import com.google.gson.annotations.SerializedName;
import com.moengage.pushbase.MoEPushConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ReferralLinkResponse.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ&\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/livpure/safedrink/login/api/models/response/ReferralLinkResponse;", "Lcom/livpure/safedrink/login/api/models/response/BaseV1Response;", "data", "Lcom/livpure/safedrink/login/api/models/response/ReferralData;", "status", "", "(Lcom/livpure/safedrink/login/api/models/response/ReferralData;Ljava/lang/Boolean;)V", "getData", "()Lcom/livpure/safedrink/login/api/models/response/ReferralData;", "setData", "(Lcom/livpure/safedrink/login/api/models/response/ReferralData;)V", "getStatus", "()Ljava/lang/Boolean;", "setStatus", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "component1", "component2", MoEPushConstants.ACTION_COPY, "(Lcom/livpure/safedrink/login/api/models/response/ReferralData;Ljava/lang/Boolean;)Lcom/livpure/safedrink/login/api/models/response/ReferralLinkResponse;", "equals", "other", "", "hashCode", "", "toString", "", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ReferralLinkResponse extends BaseV1Response {
    @SerializedName("data")
    private ReferralData data;
    @SerializedName("sucess")
    private Boolean status;

    public ReferralLinkResponse() {
        this(null, null, 3, null);
    }

    public static /* synthetic */ ReferralLinkResponse copy$default(ReferralLinkResponse referralLinkResponse, ReferralData referralData, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            referralData = referralLinkResponse.data;
        }
        if ((i & 2) != 0) {
            bool = referralLinkResponse.getStatus();
        }
        return referralLinkResponse.copy(referralData, bool);
    }

    public final ReferralData component1() {
        return this.data;
    }

    public final Boolean component2() {
        return getStatus();
    }

    public final ReferralLinkResponse copy(ReferralData referralData, Boolean bool) {
        return new ReferralLinkResponse(referralData, bool);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ReferralLinkResponse) {
            ReferralLinkResponse referralLinkResponse = (ReferralLinkResponse) obj;
            return Intrinsics.areEqual(this.data, referralLinkResponse.data) && Intrinsics.areEqual(getStatus(), referralLinkResponse.getStatus());
        }
        return false;
    }

    public int hashCode() {
        ReferralData referralData = this.data;
        return ((referralData == null ? 0 : referralData.hashCode()) * 31) + (getStatus() != null ? getStatus().hashCode() : 0);
    }

    public String toString() {
        return "ReferralLinkResponse(data=" + this.data + ", status=" + getStatus() + ')';
    }

    public /* synthetic */ ReferralLinkResponse(ReferralData referralData, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new ReferralData(null, 1, null) : referralData, (i & 2) != 0 ? null : bool);
    }

    public final ReferralData getData() {
        return this.data;
    }

    public final void setData(ReferralData referralData) {
        this.data = referralData;
    }

    @Override // com.livpure.safedrink.login.api.models.response.BaseV1Response
    public Boolean getStatus() {
        return this.status;
    }

    @Override // com.livpure.safedrink.login.api.models.response.BaseV1Response
    public void setStatus(Boolean bool) {
        this.status = bool;
    }

    public ReferralLinkResponse(ReferralData referralData, Boolean bool) {
        super(null, null, null, null, 15, null);
        this.data = referralData;
        this.status = bool;
    }
}
