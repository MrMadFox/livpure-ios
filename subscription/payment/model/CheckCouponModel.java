package com.livpure.safedrink.subscription.payment.model;

import com.google.gson.annotations.SerializedName;
import com.moengage.pushbase.MoEPushConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: CheckCouponModel.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/livpure/safedrink/subscription/payment/model/CheckCouponModel;", "", "message", "", "status", "", "(Ljava/lang/String;Z)V", "getMessage", "()Ljava/lang/String;", "getStatus", "()Z", "component1", "component2", MoEPushConstants.ACTION_COPY, "equals", "other", "hashCode", "", "toString", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CheckCouponModel {
    @SerializedName("message")
    private final String message;
    @SerializedName("status")
    private final boolean status;

    public static /* synthetic */ CheckCouponModel copy$default(CheckCouponModel checkCouponModel, String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = checkCouponModel.message;
        }
        if ((i & 2) != 0) {
            z = checkCouponModel.status;
        }
        return checkCouponModel.copy(str, z);
    }

    public final String component1() {
        return this.message;
    }

    public final boolean component2() {
        return this.status;
    }

    public final CheckCouponModel copy(String message, boolean z) {
        Intrinsics.checkNotNullParameter(message, "message");
        return new CheckCouponModel(message, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CheckCouponModel) {
            CheckCouponModel checkCouponModel = (CheckCouponModel) obj;
            return Intrinsics.areEqual(this.message, checkCouponModel.message) && this.status == checkCouponModel.status;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.message.hashCode() * 31;
        boolean z = this.status;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return hashCode + i;
    }

    public String toString() {
        return "CheckCouponModel(message=" + this.message + ", status=" + this.status + ')';
    }

    public CheckCouponModel(String message, boolean z) {
        Intrinsics.checkNotNullParameter(message, "message");
        this.message = message;
        this.status = z;
    }

    public final String getMessage() {
        return this.message;
    }

    public final boolean getStatus() {
        return this.status;
    }
}
