package com.livpure.safedrink.serviceRequest.data.model;

import com.moengage.pushbase.MoEPushConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: NewPlanResponse.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u0011\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J/\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/livpure/safedrink/serviceRequest/data/model/NewPlanResponse;", "", "status", "", "message", "", "plan", "", "Lcom/livpure/safedrink/serviceRequest/data/model/NewPlanList;", "(ILjava/lang/String;Ljava/util/List;)V", "getMessage", "()Ljava/lang/String;", "getPlan", "()Ljava/util/List;", "getStatus", "()I", "component1", "component2", "component3", MoEPushConstants.ACTION_COPY, "equals", "", "other", "hashCode", "toString", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class NewPlanResponse {
    private final String message;
    private final List<NewPlanList> plan;
    private final int status;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ NewPlanResponse copy$default(NewPlanResponse newPlanResponse, int i, String str, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = newPlanResponse.status;
        }
        if ((i2 & 2) != 0) {
            str = newPlanResponse.message;
        }
        if ((i2 & 4) != 0) {
            list = newPlanResponse.plan;
        }
        return newPlanResponse.copy(i, str, list);
    }

    public final int component1() {
        return this.status;
    }

    public final String component2() {
        return this.message;
    }

    public final List<NewPlanList> component3() {
        return this.plan;
    }

    public final NewPlanResponse copy(int i, String message, List<NewPlanList> list) {
        Intrinsics.checkNotNullParameter(message, "message");
        return new NewPlanResponse(i, message, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof NewPlanResponse) {
            NewPlanResponse newPlanResponse = (NewPlanResponse) obj;
            return this.status == newPlanResponse.status && Intrinsics.areEqual(this.message, newPlanResponse.message) && Intrinsics.areEqual(this.plan, newPlanResponse.plan);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((this.status * 31) + this.message.hashCode()) * 31;
        List<NewPlanList> list = this.plan;
        return hashCode + (list == null ? 0 : list.hashCode());
    }

    public String toString() {
        return "NewPlanResponse(status=" + this.status + ", message=" + this.message + ", plan=" + this.plan + ')';
    }

    public NewPlanResponse(int i, String message, List<NewPlanList> list) {
        Intrinsics.checkNotNullParameter(message, "message");
        this.status = i;
        this.message = message;
        this.plan = list;
    }

    public final int getStatus() {
        return this.status;
    }

    public final String getMessage() {
        return this.message;
    }

    public final List<NewPlanList> getPlan() {
        return this.plan;
    }
}
