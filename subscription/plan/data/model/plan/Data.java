package com.livpure.safedrink.subscription.plan.data.model.plan;

import com.google.gson.annotations.SerializedName;
import com.moengage.pushbase.MoEPushConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Data.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\tJ\u0011\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0004HÆ\u0003JE\u0010\u0015\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u001d"}, d2 = {"Lcom/livpure/safedrink/subscription/plan/data/model/plan/Data;", "", "plans", "", "Lcom/livpure/safedrink/subscription/plan/data/model/plan/PlansItem;", "currentplans", "Lcom/livpure/safedrink/subscription/plan/data/model/plan/Currentplans;", "unlimitedPlan", "holidayPlan", "(Ljava/util/List;Lcom/livpure/safedrink/subscription/plan/data/model/plan/Currentplans;Ljava/util/List;Lcom/livpure/safedrink/subscription/plan/data/model/plan/PlansItem;)V", "getCurrentplans", "()Lcom/livpure/safedrink/subscription/plan/data/model/plan/Currentplans;", "getHolidayPlan", "()Lcom/livpure/safedrink/subscription/plan/data/model/plan/PlansItem;", "getPlans", "()Ljava/util/List;", "getUnlimitedPlan", "component1", "component2", "component3", "component4", MoEPushConstants.ACTION_COPY, "equals", "", "other", "hashCode", "", "toString", "", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class Data {
    @SerializedName("currentplans")
    private final Currentplans currentplans;
    @SerializedName("holidayPlan")
    private final PlansItem holidayPlan;
    @SerializedName("plans")
    private final List<PlansItem> plans;
    @SerializedName("platinum")
    private final List<PlansItem> unlimitedPlan;

    public Data() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Data copy$default(Data data, List list, Currentplans currentplans, List list2, PlansItem plansItem, int i, Object obj) {
        if ((i & 1) != 0) {
            list = data.plans;
        }
        if ((i & 2) != 0) {
            currentplans = data.currentplans;
        }
        if ((i & 4) != 0) {
            list2 = data.unlimitedPlan;
        }
        if ((i & 8) != 0) {
            plansItem = data.holidayPlan;
        }
        return data.copy(list, currentplans, list2, plansItem);
    }

    public final List<PlansItem> component1() {
        return this.plans;
    }

    public final Currentplans component2() {
        return this.currentplans;
    }

    public final List<PlansItem> component3() {
        return this.unlimitedPlan;
    }

    public final PlansItem component4() {
        return this.holidayPlan;
    }

    public final Data copy(List<PlansItem> list, Currentplans currentplans, List<PlansItem> list2, PlansItem plansItem) {
        return new Data(list, currentplans, list2, plansItem);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Data) {
            Data data = (Data) obj;
            return Intrinsics.areEqual(this.plans, data.plans) && Intrinsics.areEqual(this.currentplans, data.currentplans) && Intrinsics.areEqual(this.unlimitedPlan, data.unlimitedPlan) && Intrinsics.areEqual(this.holidayPlan, data.holidayPlan);
        }
        return false;
    }

    public int hashCode() {
        List<PlansItem> list = this.plans;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        Currentplans currentplans = this.currentplans;
        int hashCode2 = (hashCode + (currentplans == null ? 0 : currentplans.hashCode())) * 31;
        List<PlansItem> list2 = this.unlimitedPlan;
        int hashCode3 = (hashCode2 + (list2 == null ? 0 : list2.hashCode())) * 31;
        PlansItem plansItem = this.holidayPlan;
        return hashCode3 + (plansItem != null ? plansItem.hashCode() : 0);
    }

    public String toString() {
        return "Data(plans=" + this.plans + ", currentplans=" + this.currentplans + ", unlimitedPlan=" + this.unlimitedPlan + ", holidayPlan=" + this.holidayPlan + ')';
    }

    public Data(List<PlansItem> list, Currentplans currentplans, List<PlansItem> list2, PlansItem plansItem) {
        this.plans = list;
        this.currentplans = currentplans;
        this.unlimitedPlan = list2;
        this.holidayPlan = plansItem;
    }

    public /* synthetic */ Data(List list, Currentplans currentplans, List list2, PlansItem plansItem, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : currentplans, (i & 4) != 0 ? null : list2, (i & 8) != 0 ? null : plansItem);
    }

    public final List<PlansItem> getPlans() {
        return this.plans;
    }

    public final Currentplans getCurrentplans() {
        return this.currentplans;
    }

    public final List<PlansItem> getUnlimitedPlan() {
        return this.unlimitedPlan;
    }

    public final PlansItem getHolidayPlan() {
        return this.holidayPlan;
    }
}
