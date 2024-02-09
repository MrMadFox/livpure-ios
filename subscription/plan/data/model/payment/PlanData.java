package com.livpure.safedrink.subscription.plan.data.model.payment;

import com.moengage.pushbase.MoEPushConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: PlanData.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/livpure/safedrink/subscription/plan/data/model/payment/PlanData;", "", "plans", "", "Lcom/livpure/safedrink/subscription/plan/data/model/payment/PlanItem;", "(Ljava/util/List;)V", "getPlans", "()Ljava/util/List;", "component1", MoEPushConstants.ACTION_COPY, "equals", "", "other", "hashCode", "", "toString", "", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PlanData {
    private final List<PlanItem> plans;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PlanData copy$default(PlanData planData, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = planData.plans;
        }
        return planData.copy(list);
    }

    public final List<PlanItem> component1() {
        return this.plans;
    }

    public final PlanData copy(List<PlanItem> plans) {
        Intrinsics.checkNotNullParameter(plans, "plans");
        return new PlanData(plans);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PlanData) && Intrinsics.areEqual(this.plans, ((PlanData) obj).plans);
    }

    public int hashCode() {
        return this.plans.hashCode();
    }

    public String toString() {
        return "PlanData(plans=" + this.plans + ')';
    }

    public PlanData(List<PlanItem> plans) {
        Intrinsics.checkNotNullParameter(plans, "plans");
        this.plans = plans;
    }

    public final List<PlanItem> getPlans() {
        return this.plans;
    }
}
