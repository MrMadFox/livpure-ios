package com.livpure.safedrink.serviceRequest.data.model;

import com.google.gson.annotations.SerializedName;
import com.livpure.safedrink.login.api.models.response.BaseV1Response;
import com.moengage.pushbase.MoEPushConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: GetReferralResponse.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/livpure/safedrink/serviceRequest/data/model/GetReferralResponse;", "Lcom/livpure/safedrink/login/api/models/response/BaseV1Response;", "message", "", "getReferralList", "", "Lcom/livpure/safedrink/serviceRequest/data/model/GetReferralList;", "(Ljava/lang/String;Ljava/util/List;)V", "getGetReferralList", "()Ljava/util/List;", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "component1", "component2", MoEPushConstants.ACTION_COPY, "equals", "", "other", "", "hashCode", "", "toString", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class GetReferralResponse extends BaseV1Response {
    @SerializedName("referrals")
    private final List<GetReferralList> getReferralList;
    @SerializedName("error")
    private String message;

    public GetReferralResponse() {
        this(null, null, 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GetReferralResponse copy$default(GetReferralResponse getReferralResponse, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = getReferralResponse.getMessage();
        }
        if ((i & 2) != 0) {
            list = getReferralResponse.getReferralList;
        }
        return getReferralResponse.copy(str, list);
    }

    public final String component1() {
        return getMessage();
    }

    public final List<GetReferralList> component2() {
        return this.getReferralList;
    }

    public final GetReferralResponse copy(String str, List<GetReferralList> list) {
        return new GetReferralResponse(str, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof GetReferralResponse) {
            GetReferralResponse getReferralResponse = (GetReferralResponse) obj;
            return Intrinsics.areEqual(getMessage(), getReferralResponse.getMessage()) && Intrinsics.areEqual(this.getReferralList, getReferralResponse.getReferralList);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = (getMessage() == null ? 0 : getMessage().hashCode()) * 31;
        List<GetReferralList> list = this.getReferralList;
        return hashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "GetReferralResponse(message=" + getMessage() + ", getReferralList=" + this.getReferralList + ')';
    }

    public /* synthetic */ GetReferralResponse(String str, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : list);
    }

    @Override // com.livpure.safedrink.login.api.models.response.BaseV1Response
    public String getMessage() {
        return this.message;
    }

    @Override // com.livpure.safedrink.login.api.models.response.BaseV1Response
    public void setMessage(String str) {
        this.message = str;
    }

    public final List<GetReferralList> getGetReferralList() {
        return this.getReferralList;
    }

    public GetReferralResponse(String str, List<GetReferralList> list) {
        super(null, null, null, null, 15, null);
        this.message = str;
        this.getReferralList = list;
    }
}
