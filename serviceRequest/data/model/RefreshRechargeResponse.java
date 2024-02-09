package com.livpure.safedrink.serviceRequest.data.model;

import com.google.gson.annotations.SerializedName;
import com.livpure.safedrink.login.api.models.response.BaseV1Response;
import com.moengage.pushbase.MoEPushConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: RefreshRechargeResponse.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0006J\u001a\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u000bJ\u0013\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0010\n\u0002\u0010\b\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0013"}, d2 = {"Lcom/livpure/safedrink/serviceRequest/data/model/RefreshRechargeResponse;", "Lcom/livpure/safedrink/login/api/models/response/BaseV1Response;", "status", "", "(Ljava/lang/Boolean;)V", "getStatus", "()Ljava/lang/Boolean;", "setStatus", "Ljava/lang/Boolean;", "component1", MoEPushConstants.ACTION_COPY, "(Ljava/lang/Boolean;)Lcom/livpure/safedrink/serviceRequest/data/model/RefreshRechargeResponse;", "equals", "other", "", "hashCode", "", "toString", "", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class RefreshRechargeResponse extends BaseV1Response {
    @SerializedName("status")
    private Boolean status;

    public RefreshRechargeResponse() {
        this(null, 1, null);
    }

    public static /* synthetic */ RefreshRechargeResponse copy$default(RefreshRechargeResponse refreshRechargeResponse, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = refreshRechargeResponse.getStatus();
        }
        return refreshRechargeResponse.copy(bool);
    }

    public final Boolean component1() {
        return getStatus();
    }

    public final RefreshRechargeResponse copy(Boolean bool) {
        return new RefreshRechargeResponse(bool);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof RefreshRechargeResponse) && Intrinsics.areEqual(getStatus(), ((RefreshRechargeResponse) obj).getStatus());
    }

    public int hashCode() {
        if (getStatus() == null) {
            return 0;
        }
        return getStatus().hashCode();
    }

    public String toString() {
        return "RefreshRechargeResponse(status=" + getStatus() + ')';
    }

    public /* synthetic */ RefreshRechargeResponse(Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bool);
    }

    @Override // com.livpure.safedrink.login.api.models.response.BaseV1Response
    public Boolean getStatus() {
        return this.status;
    }

    @Override // com.livpure.safedrink.login.api.models.response.BaseV1Response
    public void setStatus(Boolean bool) {
        this.status = bool;
    }

    public RefreshRechargeResponse(Boolean bool) {
        super(null, null, null, null, 15, null);
        this.status = bool;
    }
}
