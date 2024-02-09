package com.livpure.safedrink.subscription.plan.data.model.payment;

import com.moengage.pushbase.MoEPushConstants;
import com.razorpay.PaymentData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: PaymentPayload.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001:\u0001%BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u000eJT\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u000bHÖ\u0001J\t\u0010$\u001a\u00020\u0005HÖ\u0001R\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013¨\u0006&"}, d2 = {"Lcom/livpure/safedrink/subscription/plan/data/model/payment/PaymentPayload;", "", "paymentState", "Lcom/livpure/safedrink/subscription/plan/data/model/payment/PaymentPayload$PaymentState;", "paymentId", "", "paymentData", "Lcom/razorpay/PaymentData;", "response", "serialNo", "errorId", "", "(Lcom/livpure/safedrink/subscription/plan/data/model/payment/PaymentPayload$PaymentState;Ljava/lang/String;Lcom/razorpay/PaymentData;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getErrorId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPaymentData", "()Lcom/razorpay/PaymentData;", "getPaymentId", "()Ljava/lang/String;", "getPaymentState", "()Lcom/livpure/safedrink/subscription/plan/data/model/payment/PaymentPayload$PaymentState;", "getResponse", "getSerialNo", "component1", "component2", "component3", "component4", "component5", "component6", MoEPushConstants.ACTION_COPY, "(Lcom/livpure/safedrink/subscription/plan/data/model/payment/PaymentPayload$PaymentState;Ljava/lang/String;Lcom/razorpay/PaymentData;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/livpure/safedrink/subscription/plan/data/model/payment/PaymentPayload;", "equals", "", "other", "hashCode", "toString", "PaymentState", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PaymentPayload {
    private final Integer errorId;
    private final PaymentData paymentData;
    private final String paymentId;
    private final PaymentState paymentState;
    private final String response;
    private final String serialNo;

    /* compiled from: PaymentPayload.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/livpure/safedrink/subscription/plan/data/model/payment/PaymentPayload$PaymentState;", "", "(Ljava/lang/String;I)V", "PAYMENT_SUCCESS", "PAYMENT_FAILED", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public enum PaymentState {
        PAYMENT_SUCCESS,
        PAYMENT_FAILED
    }

    public static /* synthetic */ PaymentPayload copy$default(PaymentPayload paymentPayload, PaymentState paymentState, String str, PaymentData paymentData, String str2, String str3, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            paymentState = paymentPayload.paymentState;
        }
        if ((i & 2) != 0) {
            str = paymentPayload.paymentId;
        }
        String str4 = str;
        if ((i & 4) != 0) {
            paymentData = paymentPayload.paymentData;
        }
        PaymentData paymentData2 = paymentData;
        if ((i & 8) != 0) {
            str2 = paymentPayload.response;
        }
        String str5 = str2;
        if ((i & 16) != 0) {
            str3 = paymentPayload.serialNo;
        }
        String str6 = str3;
        if ((i & 32) != 0) {
            num = paymentPayload.errorId;
        }
        return paymentPayload.copy(paymentState, str4, paymentData2, str5, str6, num);
    }

    public final PaymentState component1() {
        return this.paymentState;
    }

    public final String component2() {
        return this.paymentId;
    }

    public final PaymentData component3() {
        return this.paymentData;
    }

    public final String component4() {
        return this.response;
    }

    public final String component5() {
        return this.serialNo;
    }

    public final Integer component6() {
        return this.errorId;
    }

    public final PaymentPayload copy(PaymentState paymentState, String str, PaymentData paymentData, String str2, String str3, Integer num) {
        Intrinsics.checkNotNullParameter(paymentState, "paymentState");
        return new PaymentPayload(paymentState, str, paymentData, str2, str3, num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PaymentPayload) {
            PaymentPayload paymentPayload = (PaymentPayload) obj;
            return this.paymentState == paymentPayload.paymentState && Intrinsics.areEqual(this.paymentId, paymentPayload.paymentId) && Intrinsics.areEqual(this.paymentData, paymentPayload.paymentData) && Intrinsics.areEqual(this.response, paymentPayload.response) && Intrinsics.areEqual(this.serialNo, paymentPayload.serialNo) && Intrinsics.areEqual(this.errorId, paymentPayload.errorId);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.paymentState.hashCode() * 31;
        String str = this.paymentId;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        PaymentData paymentData = this.paymentData;
        int hashCode3 = (hashCode2 + (paymentData == null ? 0 : paymentData.hashCode())) * 31;
        String str2 = this.response;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.serialNo;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num = this.errorId;
        return hashCode5 + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        return "PaymentPayload(paymentState=" + this.paymentState + ", paymentId=" + this.paymentId + ", paymentData=" + this.paymentData + ", response=" + this.response + ", serialNo=" + this.serialNo + ", errorId=" + this.errorId + ')';
    }

    public PaymentPayload(PaymentState paymentState, String str, PaymentData paymentData, String str2, String str3, Integer num) {
        Intrinsics.checkNotNullParameter(paymentState, "paymentState");
        this.paymentState = paymentState;
        this.paymentId = str;
        this.paymentData = paymentData;
        this.response = str2;
        this.serialNo = str3;
        this.errorId = num;
    }

    public /* synthetic */ PaymentPayload(PaymentState paymentState, String str, PaymentData paymentData, String str2, String str3, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(paymentState, str, paymentData, str2, str3, (i & 32) != 0 ? null : num);
    }

    public final PaymentState getPaymentState() {
        return this.paymentState;
    }

    public final String getPaymentId() {
        return this.paymentId;
    }

    public final PaymentData getPaymentData() {
        return this.paymentData;
    }

    public final String getResponse() {
        return this.response;
    }

    public final String getSerialNo() {
        return this.serialNo;
    }

    public final Integer getErrorId() {
        return this.errorId;
    }
}
