package com.livpure.safedrink.subscription.payment.model;

import com.google.gson.annotations.SerializedName;
import com.moengage.pushbase.MoEPushConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ValidateCouponModel.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/livpure/safedrink/subscription/payment/model/CityItem;", "", "cityName", "", "(Ljava/lang/String;)V", "getCityName", "()Ljava/lang/String;", "component1", MoEPushConstants.ACTION_COPY, "equals", "", "other", "hashCode", "", "toString", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CityItem {
    @SerializedName("cityName")
    private final String cityName;

    public static /* synthetic */ CityItem copy$default(CityItem cityItem, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = cityItem.cityName;
        }
        return cityItem.copy(str);
    }

    public final String component1() {
        return this.cityName;
    }

    public final CityItem copy(String cityName) {
        Intrinsics.checkNotNullParameter(cityName, "cityName");
        return new CityItem(cityName);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof CityItem) && Intrinsics.areEqual(this.cityName, ((CityItem) obj).cityName);
    }

    public int hashCode() {
        return this.cityName.hashCode();
    }

    public String toString() {
        return "CityItem(cityName=" + this.cityName + ')';
    }

    public CityItem(String cityName) {
        Intrinsics.checkNotNullParameter(cityName, "cityName");
        this.cityName = cityName;
    }

    public final String getCityName() {
        return this.cityName;
    }
}
