package com.livpure.safedrink.subscription.plan.data.model.dashboard;

import com.google.gson.annotations.SerializedName;
import com.livpure.safedrink.segment.SegmentProperties;
import com.moengage.pushbase.MoEPushConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DailyConsumptionItem.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/livpure/safedrink/subscription/plan/data/model/dashboard/DailyConsumptionItem;", "", SegmentProperties.LITRES, "", "dateString", "(Ljava/lang/String;Ljava/lang/String;)V", "getDateString", "()Ljava/lang/String;", "getLitres", "component1", "component2", MoEPushConstants.ACTION_COPY, "equals", "", "other", "hashCode", "", "toString", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DailyConsumptionItem {
    @SerializedName("Time")
    private final String dateString;
    @SerializedName("TL")
    private final String litres;

    public static /* synthetic */ DailyConsumptionItem copy$default(DailyConsumptionItem dailyConsumptionItem, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = dailyConsumptionItem.litres;
        }
        if ((i & 2) != 0) {
            str2 = dailyConsumptionItem.dateString;
        }
        return dailyConsumptionItem.copy(str, str2);
    }

    public final String component1() {
        return this.litres;
    }

    public final String component2() {
        return this.dateString;
    }

    public final DailyConsumptionItem copy(String litres, String dateString) {
        Intrinsics.checkNotNullParameter(litres, "litres");
        Intrinsics.checkNotNullParameter(dateString, "dateString");
        return new DailyConsumptionItem(litres, dateString);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DailyConsumptionItem) {
            DailyConsumptionItem dailyConsumptionItem = (DailyConsumptionItem) obj;
            return Intrinsics.areEqual(this.litres, dailyConsumptionItem.litres) && Intrinsics.areEqual(this.dateString, dailyConsumptionItem.dateString);
        }
        return false;
    }

    public int hashCode() {
        return (this.litres.hashCode() * 31) + this.dateString.hashCode();
    }

    public String toString() {
        return "DailyConsumptionItem(litres=" + this.litres + ", dateString=" + this.dateString + ')';
    }

    public DailyConsumptionItem(String litres, String dateString) {
        Intrinsics.checkNotNullParameter(litres, "litres");
        Intrinsics.checkNotNullParameter(dateString, "dateString");
        this.litres = litres;
        this.dateString = dateString;
    }

    public final String getLitres() {
        return this.litres;
    }

    public final String getDateString() {
        return this.dateString;
    }
}
