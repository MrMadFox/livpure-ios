package com.livpure.safedrink.serviceRequest.data.model;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.moengage.pushbase.MoEPushConstants;
import com.moengage.richnotification.internal.RichPushConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: NewPlanList.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/livpure/safedrink/serviceRequest/data/model/NewPlanList;", "", RichPushConstantsKt.PROPERTY_DURATION_KEY, "", FirebaseAnalytics.Param.PRICE, "(Ljava/lang/String;Ljava/lang/String;)V", "getDuration", "()Ljava/lang/String;", "getPrice", "component1", "component2", MoEPushConstants.ACTION_COPY, "equals", "", "other", "hashCode", "", "toString", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class NewPlanList {
    private final String duration;
    private final String price;

    public static /* synthetic */ NewPlanList copy$default(NewPlanList newPlanList, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = newPlanList.duration;
        }
        if ((i & 2) != 0) {
            str2 = newPlanList.price;
        }
        return newPlanList.copy(str, str2);
    }

    public final String component1() {
        return this.duration;
    }

    public final String component2() {
        return this.price;
    }

    public final NewPlanList copy(String duration, String price) {
        Intrinsics.checkNotNullParameter(duration, "duration");
        Intrinsics.checkNotNullParameter(price, "price");
        return new NewPlanList(duration, price);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof NewPlanList) {
            NewPlanList newPlanList = (NewPlanList) obj;
            return Intrinsics.areEqual(this.duration, newPlanList.duration) && Intrinsics.areEqual(this.price, newPlanList.price);
        }
        return false;
    }

    public int hashCode() {
        return (this.duration.hashCode() * 31) + this.price.hashCode();
    }

    public String toString() {
        return "NewPlanList(duration=" + this.duration + ", price=" + this.price + ')';
    }

    public NewPlanList(String duration, String price) {
        Intrinsics.checkNotNullParameter(duration, "duration");
        Intrinsics.checkNotNullParameter(price, "price");
        this.duration = duration;
        this.price = price;
    }

    public final String getDuration() {
        return this.duration;
    }

    public final String getPrice() {
        return this.price;
    }
}
