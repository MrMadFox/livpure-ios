package com.livpure.safedrink.subscription.payment.model;

import com.google.gson.annotations.SerializedName;
import com.moengage.pushbase.MoEPushConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ValidateCouponModel.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/livpure/safedrink/subscription/payment/model/CouponPlanItem;", "", "couponType", "", "(Ljava/lang/String;)V", "getCouponType", "()Ljava/lang/String;", "component1", MoEPushConstants.ACTION_COPY, "equals", "", "other", "hashCode", "", "toString", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CouponPlanItem {
    @SerializedName("couponType")
    private final String couponType;

    public static /* synthetic */ CouponPlanItem copy$default(CouponPlanItem couponPlanItem, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = couponPlanItem.couponType;
        }
        return couponPlanItem.copy(str);
    }

    public final String component1() {
        return this.couponType;
    }

    public final CouponPlanItem copy(String couponType) {
        Intrinsics.checkNotNullParameter(couponType, "couponType");
        return new CouponPlanItem(couponType);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof CouponPlanItem) && Intrinsics.areEqual(this.couponType, ((CouponPlanItem) obj).couponType);
    }

    public int hashCode() {
        return this.couponType.hashCode();
    }

    public String toString() {
        return "CouponPlanItem(couponType=" + this.couponType + ')';
    }

    public CouponPlanItem(String couponType) {
        Intrinsics.checkNotNullParameter(couponType, "couponType");
        this.couponType = couponType;
    }

    public final String getCouponType() {
        return this.couponType;
    }
}
