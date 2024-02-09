package com.livpure.safedrink.subscription.plan.data.model.payment;

import com.moengage.pushbase.MoEPushConstants;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: RechargeDetailsRequest.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b*\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bu\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003¢\u0006\u0002\u0010\u0010J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\u008b\u0001\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u0003HÆ\u0001J\u0013\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00100\u001a\u000201HÖ\u0001J\t\u00102\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0012¨\u00063"}, d2 = {"Lcom/livpure/safedrink/subscription/plan/data/model/payment/RechargeDetailsRequest;", "", AnalyticsAttribute.USER_ID_ATTRIBUTE, "", "rechargeAmount", "rechargeStatus", "paymentId", "planId", "rechargeType", "oldPlanId", "serial_no", "newPlanId", "planChanged", "deposit_amount", "coupon_name", "coupon_amount", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCoupon_amount", "()Ljava/lang/String;", "getCoupon_name", "getDeposit_amount", "getNewPlanId", "getOldPlanId", "getPaymentId", "getPlanChanged", "getPlanId", "getRechargeAmount", "getRechargeStatus", "getRechargeType", "getSerial_no", "getUserId", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", MoEPushConstants.ACTION_COPY, "equals", "", "other", "hashCode", "", "toString", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class RechargeDetailsRequest {
    private final String coupon_amount;
    private final String coupon_name;
    private final String deposit_amount;
    private final String newPlanId;
    private final String oldPlanId;
    private final String paymentId;
    private final String planChanged;
    private final String planId;
    private final String rechargeAmount;
    private final String rechargeStatus;
    private final String rechargeType;
    private final String serial_no;
    private final String userId;

    public final String component1() {
        return this.userId;
    }

    public final String component10() {
        return this.planChanged;
    }

    public final String component11() {
        return this.deposit_amount;
    }

    public final String component12() {
        return this.coupon_name;
    }

    public final String component13() {
        return this.coupon_amount;
    }

    public final String component2() {
        return this.rechargeAmount;
    }

    public final String component3() {
        return this.rechargeStatus;
    }

    public final String component4() {
        return this.paymentId;
    }

    public final String component5() {
        return this.planId;
    }

    public final String component6() {
        return this.rechargeType;
    }

    public final String component7() {
        return this.oldPlanId;
    }

    public final String component8() {
        return this.serial_no;
    }

    public final String component9() {
        return this.newPlanId;
    }

    public final RechargeDetailsRequest copy(String userId, String rechargeAmount, String rechargeStatus, String paymentId, String planId, String rechargeType, String oldPlanId, String serial_no, String newPlanId, String planChanged, String deposit_amount, String coupon_name, String coupon_amount) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(rechargeAmount, "rechargeAmount");
        Intrinsics.checkNotNullParameter(rechargeStatus, "rechargeStatus");
        Intrinsics.checkNotNullParameter(paymentId, "paymentId");
        Intrinsics.checkNotNullParameter(planId, "planId");
        Intrinsics.checkNotNullParameter(rechargeType, "rechargeType");
        Intrinsics.checkNotNullParameter(oldPlanId, "oldPlanId");
        Intrinsics.checkNotNullParameter(serial_no, "serial_no");
        Intrinsics.checkNotNullParameter(newPlanId, "newPlanId");
        Intrinsics.checkNotNullParameter(planChanged, "planChanged");
        Intrinsics.checkNotNullParameter(deposit_amount, "deposit_amount");
        Intrinsics.checkNotNullParameter(coupon_name, "coupon_name");
        Intrinsics.checkNotNullParameter(coupon_amount, "coupon_amount");
        return new RechargeDetailsRequest(userId, rechargeAmount, rechargeStatus, paymentId, planId, rechargeType, oldPlanId, serial_no, newPlanId, planChanged, deposit_amount, coupon_name, coupon_amount);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RechargeDetailsRequest) {
            RechargeDetailsRequest rechargeDetailsRequest = (RechargeDetailsRequest) obj;
            return Intrinsics.areEqual(this.userId, rechargeDetailsRequest.userId) && Intrinsics.areEqual(this.rechargeAmount, rechargeDetailsRequest.rechargeAmount) && Intrinsics.areEqual(this.rechargeStatus, rechargeDetailsRequest.rechargeStatus) && Intrinsics.areEqual(this.paymentId, rechargeDetailsRequest.paymentId) && Intrinsics.areEqual(this.planId, rechargeDetailsRequest.planId) && Intrinsics.areEqual(this.rechargeType, rechargeDetailsRequest.rechargeType) && Intrinsics.areEqual(this.oldPlanId, rechargeDetailsRequest.oldPlanId) && Intrinsics.areEqual(this.serial_no, rechargeDetailsRequest.serial_no) && Intrinsics.areEqual(this.newPlanId, rechargeDetailsRequest.newPlanId) && Intrinsics.areEqual(this.planChanged, rechargeDetailsRequest.planChanged) && Intrinsics.areEqual(this.deposit_amount, rechargeDetailsRequest.deposit_amount) && Intrinsics.areEqual(this.coupon_name, rechargeDetailsRequest.coupon_name) && Intrinsics.areEqual(this.coupon_amount, rechargeDetailsRequest.coupon_amount);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((((((((this.userId.hashCode() * 31) + this.rechargeAmount.hashCode()) * 31) + this.rechargeStatus.hashCode()) * 31) + this.paymentId.hashCode()) * 31) + this.planId.hashCode()) * 31) + this.rechargeType.hashCode()) * 31) + this.oldPlanId.hashCode()) * 31) + this.serial_no.hashCode()) * 31) + this.newPlanId.hashCode()) * 31) + this.planChanged.hashCode()) * 31) + this.deposit_amount.hashCode()) * 31) + this.coupon_name.hashCode()) * 31) + this.coupon_amount.hashCode();
    }

    public String toString() {
        return "RechargeDetailsRequest(userId=" + this.userId + ", rechargeAmount=" + this.rechargeAmount + ", rechargeStatus=" + this.rechargeStatus + ", paymentId=" + this.paymentId + ", planId=" + this.planId + ", rechargeType=" + this.rechargeType + ", oldPlanId=" + this.oldPlanId + ", serial_no=" + this.serial_no + ", newPlanId=" + this.newPlanId + ", planChanged=" + this.planChanged + ", deposit_amount=" + this.deposit_amount + ", coupon_name=" + this.coupon_name + ", coupon_amount=" + this.coupon_amount + ')';
    }

    public RechargeDetailsRequest(String userId, String rechargeAmount, String rechargeStatus, String paymentId, String planId, String rechargeType, String oldPlanId, String serial_no, String newPlanId, String planChanged, String deposit_amount, String coupon_name, String coupon_amount) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(rechargeAmount, "rechargeAmount");
        Intrinsics.checkNotNullParameter(rechargeStatus, "rechargeStatus");
        Intrinsics.checkNotNullParameter(paymentId, "paymentId");
        Intrinsics.checkNotNullParameter(planId, "planId");
        Intrinsics.checkNotNullParameter(rechargeType, "rechargeType");
        Intrinsics.checkNotNullParameter(oldPlanId, "oldPlanId");
        Intrinsics.checkNotNullParameter(serial_no, "serial_no");
        Intrinsics.checkNotNullParameter(newPlanId, "newPlanId");
        Intrinsics.checkNotNullParameter(planChanged, "planChanged");
        Intrinsics.checkNotNullParameter(deposit_amount, "deposit_amount");
        Intrinsics.checkNotNullParameter(coupon_name, "coupon_name");
        Intrinsics.checkNotNullParameter(coupon_amount, "coupon_amount");
        this.userId = userId;
        this.rechargeAmount = rechargeAmount;
        this.rechargeStatus = rechargeStatus;
        this.paymentId = paymentId;
        this.planId = planId;
        this.rechargeType = rechargeType;
        this.oldPlanId = oldPlanId;
        this.serial_no = serial_no;
        this.newPlanId = newPlanId;
        this.planChanged = planChanged;
        this.deposit_amount = deposit_amount;
        this.coupon_name = coupon_name;
        this.coupon_amount = coupon_amount;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ RechargeDetailsRequest(java.lang.String r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, java.lang.String r27, int r28, kotlin.jvm.internal.DefaultConstructorMarker r29) {
        /*
            r14 = this;
            r7 = r21
            r0 = r28
            r1 = r0 & 1
            if (r1 == 0) goto L16
            com.livpure.safedrink.app.LSApplication$Companion r1 = com.livpure.safedrink.app.LSApplication.Companion
            com.livpure.safedrink.login.data.models.User r1 = r1.getUser()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            java.lang.String r1 = r1.getId()
            goto L17
        L16:
            r1 = r15
        L17:
            r2 = r0 & 4
            if (r2 == 0) goto L1f
            java.lang.String r2 = "success"
            r3 = r2
            goto L21
        L1f:
            r3 = r17
        L21:
            r2 = r0 & 256(0x100, float:3.59E-43)
            if (r2 == 0) goto L28
            r9 = r19
            goto L2a
        L28:
            r9 = r23
        L2a:
            r0 = r0 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L45
            r0 = r7
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = kotlin.text.StringsKt.isBlank(r0)
            if (r0 != 0) goto L41
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r7, r9)
            if (r0 == 0) goto L3e
            goto L41
        L3e:
            java.lang.String r0 = "Y"
            goto L43
        L41:
            java.lang.String r0 = "N"
        L43:
            r10 = r0
            goto L47
        L45:
            r10 = r24
        L47:
            r0 = r14
            r2 = r16
            r4 = r18
            r5 = r19
            r6 = r20
            r7 = r21
            r8 = r22
            r11 = r25
            r12 = r26
            r13 = r27
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.livpure.safedrink.subscription.plan.data.model.payment.RechargeDetailsRequest.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getRechargeAmount() {
        return this.rechargeAmount;
    }

    public final String getRechargeStatus() {
        return this.rechargeStatus;
    }

    public final String getPaymentId() {
        return this.paymentId;
    }

    public final String getPlanId() {
        return this.planId;
    }

    public final String getRechargeType() {
        return this.rechargeType;
    }

    public final String getOldPlanId() {
        return this.oldPlanId;
    }

    public final String getSerial_no() {
        return this.serial_no;
    }

    public final String getNewPlanId() {
        return this.newPlanId;
    }

    public final String getPlanChanged() {
        return this.planChanged;
    }

    public final String getDeposit_amount() {
        return this.deposit_amount;
    }

    public final String getCoupon_name() {
        return this.coupon_name;
    }

    public final String getCoupon_amount() {
        return this.coupon_amount;
    }
}
