package com.livpure.safedrink.airpurifier.data.models;

import com.moengage.pushbase.MoEPushConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: AirPurifierPlanDetails.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/livpure/safedrink/airpurifier/data/models/AirPurifierPlanDetails;", "", "planName", "", "amount", "validity", "discountAmount", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAmount", "()Ljava/lang/String;", "setAmount", "(Ljava/lang/String;)V", "getDiscountAmount", "setDiscountAmount", "getPlanName", "setPlanName", "getValidity", "setValidity", "component1", "component2", "component3", "component4", MoEPushConstants.ACTION_COPY, "equals", "", "other", "hashCode", "", "toString", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AirPurifierPlanDetails {
    private String amount;
    private String discountAmount;
    private String planName;
    private String validity;

    public static /* synthetic */ AirPurifierPlanDetails copy$default(AirPurifierPlanDetails airPurifierPlanDetails, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = airPurifierPlanDetails.planName;
        }
        if ((i & 2) != 0) {
            str2 = airPurifierPlanDetails.amount;
        }
        if ((i & 4) != 0) {
            str3 = airPurifierPlanDetails.validity;
        }
        if ((i & 8) != 0) {
            str4 = airPurifierPlanDetails.discountAmount;
        }
        return airPurifierPlanDetails.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.planName;
    }

    public final String component2() {
        return this.amount;
    }

    public final String component3() {
        return this.validity;
    }

    public final String component4() {
        return this.discountAmount;
    }

    public final AirPurifierPlanDetails copy(String planName, String amount, String validity, String discountAmount) {
        Intrinsics.checkNotNullParameter(planName, "planName");
        Intrinsics.checkNotNullParameter(amount, "amount");
        Intrinsics.checkNotNullParameter(validity, "validity");
        Intrinsics.checkNotNullParameter(discountAmount, "discountAmount");
        return new AirPurifierPlanDetails(planName, amount, validity, discountAmount);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AirPurifierPlanDetails) {
            AirPurifierPlanDetails airPurifierPlanDetails = (AirPurifierPlanDetails) obj;
            return Intrinsics.areEqual(this.planName, airPurifierPlanDetails.planName) && Intrinsics.areEqual(this.amount, airPurifierPlanDetails.amount) && Intrinsics.areEqual(this.validity, airPurifierPlanDetails.validity) && Intrinsics.areEqual(this.discountAmount, airPurifierPlanDetails.discountAmount);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.planName.hashCode() * 31) + this.amount.hashCode()) * 31) + this.validity.hashCode()) * 31) + this.discountAmount.hashCode();
    }

    public String toString() {
        return "AirPurifierPlanDetails(planName=" + this.planName + ", amount=" + this.amount + ", validity=" + this.validity + ", discountAmount=" + this.discountAmount + ')';
    }

    public AirPurifierPlanDetails(String planName, String amount, String validity, String discountAmount) {
        Intrinsics.checkNotNullParameter(planName, "planName");
        Intrinsics.checkNotNullParameter(amount, "amount");
        Intrinsics.checkNotNullParameter(validity, "validity");
        Intrinsics.checkNotNullParameter(discountAmount, "discountAmount");
        this.planName = planName;
        this.amount = amount;
        this.validity = validity;
        this.discountAmount = discountAmount;
    }

    public final String getPlanName() {
        return this.planName;
    }

    public final void setPlanName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.planName = str;
    }

    public final String getAmount() {
        return this.amount;
    }

    public final void setAmount(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.amount = str;
    }

    public final String getValidity() {
        return this.validity;
    }

    public final void setValidity(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.validity = str;
    }

    public final String getDiscountAmount() {
        return this.discountAmount;
    }

    public final void setDiscountAmount(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.discountAmount = str;
    }
}
