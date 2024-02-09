package com.livpure.safedrink.app.recharge.model;

import com.livpure.safedrink.login.api.models.response.BaseV1Response;
import com.moengage.pushbase.MoEPushConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Response.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0010\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0013\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u001d\u0010\t\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u001b\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/livpure/safedrink/app/recharge/model/HistoryResponse;", "Lcom/livpure/safedrink/login/api/models/response/BaseV1Response;", "rechargeDetails", "", "Lcom/livpure/safedrink/app/recharge/model/RechargeDetailsItem;", "(Ljava/util/List;)V", "getRechargeDetails", "()Ljava/util/List;", "component1", MoEPushConstants.ACTION_COPY, "equals", "", "other", "", "hashCode", "", "toString", "", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class HistoryResponse extends BaseV1Response {
    private final List<RechargeDetailsItem> rechargeDetails;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HistoryResponse copy$default(HistoryResponse historyResponse, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = historyResponse.rechargeDetails;
        }
        return historyResponse.copy(list);
    }

    public final List<RechargeDetailsItem> component1() {
        return this.rechargeDetails;
    }

    public final HistoryResponse copy(List<RechargeDetailsItem> list) {
        return new HistoryResponse(list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof HistoryResponse) && Intrinsics.areEqual(this.rechargeDetails, ((HistoryResponse) obj).rechargeDetails);
    }

    public int hashCode() {
        List<RechargeDetailsItem> list = this.rechargeDetails;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    public String toString() {
        return "HistoryResponse(rechargeDetails=" + this.rechargeDetails + ')';
    }

    public final List<RechargeDetailsItem> getRechargeDetails() {
        return this.rechargeDetails;
    }

    public HistoryResponse(List<RechargeDetailsItem> list) {
        super(null, null, null, null, 15, null);
        this.rechargeDetails = list;
    }
}
