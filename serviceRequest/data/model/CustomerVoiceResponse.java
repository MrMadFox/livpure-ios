package com.livpure.safedrink.serviceRequest.data.model;

import com.google.gson.annotations.SerializedName;
import com.livpure.safedrink.login.api.models.response.BaseV1Response;
import com.moengage.pushbase.MoEPushConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: CustomerVoiceResponse.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0011\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J8\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R&\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\""}, d2 = {"Lcom/livpure/safedrink/serviceRequest/data/model/CustomerVoiceResponse;", "Lcom/livpure/safedrink/login/api/models/response/BaseV1Response;", "message", "", "status", "", "waasReasonResList", "", "Lcom/livpure/safedrink/serviceRequest/data/model/WAASReasonResList;", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;)V", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "getStatus", "()Ljava/lang/Boolean;", "setStatus", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getWaasReasonResList", "()Ljava/util/List;", "setWaasReasonResList", "(Ljava/util/List;)V", "component1", "component2", "component3", MoEPushConstants.ACTION_COPY, "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;)Lcom/livpure/safedrink/serviceRequest/data/model/CustomerVoiceResponse;", "equals", "other", "", "hashCode", "", "toString", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CustomerVoiceResponse extends BaseV1Response {
    @SerializedName("Message")
    private String message;
    @SerializedName("Status")
    private Boolean status;
    @SerializedName("WAASReasonResList")
    private List<WAASReasonResList> waasReasonResList;

    public CustomerVoiceResponse() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CustomerVoiceResponse copy$default(CustomerVoiceResponse customerVoiceResponse, String str, Boolean bool, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = customerVoiceResponse.getMessage();
        }
        if ((i & 2) != 0) {
            bool = customerVoiceResponse.getStatus();
        }
        if ((i & 4) != 0) {
            list = customerVoiceResponse.waasReasonResList;
        }
        return customerVoiceResponse.copy(str, bool, list);
    }

    public final String component1() {
        return getMessage();
    }

    public final Boolean component2() {
        return getStatus();
    }

    public final List<WAASReasonResList> component3() {
        return this.waasReasonResList;
    }

    public final CustomerVoiceResponse copy(String str, Boolean bool, List<WAASReasonResList> list) {
        return new CustomerVoiceResponse(str, bool, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CustomerVoiceResponse) {
            CustomerVoiceResponse customerVoiceResponse = (CustomerVoiceResponse) obj;
            return Intrinsics.areEqual(getMessage(), customerVoiceResponse.getMessage()) && Intrinsics.areEqual(getStatus(), customerVoiceResponse.getStatus()) && Intrinsics.areEqual(this.waasReasonResList, customerVoiceResponse.waasReasonResList);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = (((getMessage() == null ? 0 : getMessage().hashCode()) * 31) + (getStatus() == null ? 0 : getStatus().hashCode())) * 31;
        List<WAASReasonResList> list = this.waasReasonResList;
        return hashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "CustomerVoiceResponse(message=" + getMessage() + ", status=" + getStatus() + ", waasReasonResList=" + this.waasReasonResList + ')';
    }

    public /* synthetic */ CustomerVoiceResponse(String str, Boolean bool, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : bool, (i & 4) != 0 ? null : list);
    }

    @Override // com.livpure.safedrink.login.api.models.response.BaseV1Response
    public String getMessage() {
        return this.message;
    }

    @Override // com.livpure.safedrink.login.api.models.response.BaseV1Response
    public void setMessage(String str) {
        this.message = str;
    }

    @Override // com.livpure.safedrink.login.api.models.response.BaseV1Response
    public Boolean getStatus() {
        return this.status;
    }

    @Override // com.livpure.safedrink.login.api.models.response.BaseV1Response
    public void setStatus(Boolean bool) {
        this.status = bool;
    }

    public final List<WAASReasonResList> getWaasReasonResList() {
        return this.waasReasonResList;
    }

    public final void setWaasReasonResList(List<WAASReasonResList> list) {
        this.waasReasonResList = list;
    }

    public CustomerVoiceResponse(String str, Boolean bool, List<WAASReasonResList> list) {
        super(null, null, null, null, 15, null);
        this.message = str;
        this.status = bool;
        this.waasReasonResList = list;
    }
}
