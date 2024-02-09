package com.livpure.safedrink.app.recharge.model;

import com.google.gson.annotations.SerializedName;
import com.moengage.pushbase.MoEPushConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: RechargeDetailsItem.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/livpure/safedrink/app/recharge/model/RechargeDetailsItem;", "", "rechargeDate", "", "paymentId", "rechargeAmount", "rechargeStatus", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getPaymentId", "()Ljava/lang/String;", "getRechargeAmount", "getRechargeDate", "getRechargeStatus", "component1", "component2", "component3", "component4", MoEPushConstants.ACTION_COPY, "equals", "", "other", "hashCode", "", "toString", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class RechargeDetailsItem {
    @SerializedName("PaymentId")
    private final String paymentId;
    @SerializedName("RechargeAmount")
    private final String rechargeAmount;
    @SerializedName("RechargeDate")
    private final String rechargeDate;
    @SerializedName("RechargeStatus")
    private final String rechargeStatus;

    public RechargeDetailsItem() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ RechargeDetailsItem copy$default(RechargeDetailsItem rechargeDetailsItem, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = rechargeDetailsItem.rechargeDate;
        }
        if ((i & 2) != 0) {
            str2 = rechargeDetailsItem.paymentId;
        }
        if ((i & 4) != 0) {
            str3 = rechargeDetailsItem.rechargeAmount;
        }
        if ((i & 8) != 0) {
            str4 = rechargeDetailsItem.rechargeStatus;
        }
        return rechargeDetailsItem.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.rechargeDate;
    }

    public final String component2() {
        return this.paymentId;
    }

    public final String component3() {
        return this.rechargeAmount;
    }

    public final String component4() {
        return this.rechargeStatus;
    }

    public final RechargeDetailsItem copy(String str, String str2, String str3, String str4) {
        return new RechargeDetailsItem(str, str2, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RechargeDetailsItem) {
            RechargeDetailsItem rechargeDetailsItem = (RechargeDetailsItem) obj;
            return Intrinsics.areEqual(this.rechargeDate, rechargeDetailsItem.rechargeDate) && Intrinsics.areEqual(this.paymentId, rechargeDetailsItem.paymentId) && Intrinsics.areEqual(this.rechargeAmount, rechargeDetailsItem.rechargeAmount) && Intrinsics.areEqual(this.rechargeStatus, rechargeDetailsItem.rechargeStatus);
        }
        return false;
    }

    public int hashCode() {
        String str = this.rechargeDate;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.paymentId;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.rechargeAmount;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.rechargeStatus;
        return hashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "RechargeDetailsItem(rechargeDate=" + this.rechargeDate + ", paymentId=" + this.paymentId + ", rechargeAmount=" + this.rechargeAmount + ", rechargeStatus=" + this.rechargeStatus + ')';
    }

    public RechargeDetailsItem(String str, String str2, String str3, String str4) {
        this.rechargeDate = str;
        this.paymentId = str2;
        this.rechargeAmount = str3;
        this.rechargeStatus = str4;
    }

    public /* synthetic */ RechargeDetailsItem(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4);
    }

    public final String getRechargeDate() {
        return this.rechargeDate;
    }

    public final String getPaymentId() {
        return this.paymentId;
    }

    public final String getRechargeAmount() {
        return this.rechargeAmount;
    }

    public final String getRechargeStatus() {
        return this.rechargeStatus;
    }
}
