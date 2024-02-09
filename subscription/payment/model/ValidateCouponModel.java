package com.livpure.safedrink.subscription.payment.model;

import com.google.gson.annotations.SerializedName;
import com.moengage.pushbase.MoEPushConstants;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ValidateCouponModel.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\bHÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\bHÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/livpure/safedrink/subscription/payment/model/ValidateCouponModel;", "", "data", "Lcom/livpure/safedrink/subscription/payment/model/Data;", "message", "", "status", AnalyticsAttribute.STATUS_CODE_ATTRIBUTE, "", "(Lcom/livpure/safedrink/subscription/payment/model/Data;Ljava/lang/String;Ljava/lang/String;I)V", "getData", "()Lcom/livpure/safedrink/subscription/payment/model/Data;", "getMessage", "()Ljava/lang/String;", "getStatus", "getStatusCode", "()I", "component1", "component2", "component3", "component4", MoEPushConstants.ACTION_COPY, "equals", "", "other", "hashCode", "toString", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ValidateCouponModel {
    @SerializedName("data")
    private final Data data;
    @SerializedName("message")
    private final String message;
    @SerializedName("status")
    private final String status;
    @SerializedName(AnalyticsAttribute.STATUS_CODE_ATTRIBUTE)
    private final int statusCode;

    public static /* synthetic */ ValidateCouponModel copy$default(ValidateCouponModel validateCouponModel, Data data, String str, String str2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            data = validateCouponModel.data;
        }
        if ((i2 & 2) != 0) {
            str = validateCouponModel.message;
        }
        if ((i2 & 4) != 0) {
            str2 = validateCouponModel.status;
        }
        if ((i2 & 8) != 0) {
            i = validateCouponModel.statusCode;
        }
        return validateCouponModel.copy(data, str, str2, i);
    }

    public final Data component1() {
        return this.data;
    }

    public final String component2() {
        return this.message;
    }

    public final String component3() {
        return this.status;
    }

    public final int component4() {
        return this.statusCode;
    }

    public final ValidateCouponModel copy(Data data, String message, String status, int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(status, "status");
        return new ValidateCouponModel(data, message, status, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ValidateCouponModel) {
            ValidateCouponModel validateCouponModel = (ValidateCouponModel) obj;
            return Intrinsics.areEqual(this.data, validateCouponModel.data) && Intrinsics.areEqual(this.message, validateCouponModel.message) && Intrinsics.areEqual(this.status, validateCouponModel.status) && this.statusCode == validateCouponModel.statusCode;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.data.hashCode() * 31) + this.message.hashCode()) * 31) + this.status.hashCode()) * 31) + this.statusCode;
    }

    public String toString() {
        return "ValidateCouponModel(data=" + this.data + ", message=" + this.message + ", status=" + this.status + ", statusCode=" + this.statusCode + ')';
    }

    public ValidateCouponModel(Data data, String message, String status, int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(status, "status");
        this.data = data;
        this.message = message;
        this.status = status;
        this.statusCode = i;
    }

    public final Data getData() {
        return this.data;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getStatus() {
        return this.status;
    }

    public final int getStatusCode() {
        return this.statusCode;
    }
}
