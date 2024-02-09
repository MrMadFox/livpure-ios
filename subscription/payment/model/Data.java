package com.livpure.safedrink.subscription.payment.model;

import com.google.gson.annotations.SerializedName;
import com.moengage.pushbase.MoEPushConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ValidateCouponModel.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/livpure/safedrink/subscription/payment/model/Data;", "", "couponnDetails", "", "Lcom/livpure/safedrink/subscription/payment/model/CouponnDetailsItem;", "(Ljava/util/List;)V", "getCouponnDetails", "()Ljava/util/List;", "component1", MoEPushConstants.ACTION_COPY, "equals", "", "other", "hashCode", "", "toString", "", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class Data {
    @SerializedName("couponnDetails")
    private final List<CouponnDetailsItem> couponnDetails;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Data copy$default(Data data, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = data.couponnDetails;
        }
        return data.copy(list);
    }

    public final List<CouponnDetailsItem> component1() {
        return this.couponnDetails;
    }

    public final Data copy(List<CouponnDetailsItem> couponnDetails) {
        Intrinsics.checkNotNullParameter(couponnDetails, "couponnDetails");
        return new Data(couponnDetails);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Data) && Intrinsics.areEqual(this.couponnDetails, ((Data) obj).couponnDetails);
    }

    public int hashCode() {
        return this.couponnDetails.hashCode();
    }

    public String toString() {
        return "Data(couponnDetails=" + this.couponnDetails + ')';
    }

    public Data(List<CouponnDetailsItem> couponnDetails) {
        Intrinsics.checkNotNullParameter(couponnDetails, "couponnDetails");
        this.couponnDetails = couponnDetails;
    }

    public final List<CouponnDetailsItem> getCouponnDetails() {
        return this.couponnDetails;
    }
}
