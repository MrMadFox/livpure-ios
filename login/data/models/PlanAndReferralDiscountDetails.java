package com.livpure.safedrink.login.data.models;

import com.moengage.pushbase.MoEPushConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: PlanAndReferralDiscountDetails.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0006J\u001a\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/livpure/safedrink/login/data/models/PlanAndReferralDiscountDetails;", "", "discountAmount", "", "(Ljava/lang/Long;)V", "getDiscountAmount", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", MoEPushConstants.ACTION_COPY, "(Ljava/lang/Long;)Lcom/livpure/safedrink/login/data/models/PlanAndReferralDiscountDetails;", "equals", "", "other", "hashCode", "", "toString", "", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PlanAndReferralDiscountDetails {
    private final Long discountAmount;

    public static /* synthetic */ PlanAndReferralDiscountDetails copy$default(PlanAndReferralDiscountDetails planAndReferralDiscountDetails, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            l = planAndReferralDiscountDetails.discountAmount;
        }
        return planAndReferralDiscountDetails.copy(l);
    }

    public final Long component1() {
        return this.discountAmount;
    }

    public final PlanAndReferralDiscountDetails copy(Long l) {
        return new PlanAndReferralDiscountDetails(l);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PlanAndReferralDiscountDetails) && Intrinsics.areEqual(this.discountAmount, ((PlanAndReferralDiscountDetails) obj).discountAmount);
    }

    public int hashCode() {
        Long l = this.discountAmount;
        if (l == null) {
            return 0;
        }
        return l.hashCode();
    }

    public String toString() {
        return "PlanAndReferralDiscountDetails(discountAmount=" + this.discountAmount + ')';
    }

    public PlanAndReferralDiscountDetails(Long l) {
        this.discountAmount = l;
    }

    public final Long getDiscountAmount() {
        return this.discountAmount;
    }
}
