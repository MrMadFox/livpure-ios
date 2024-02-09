package com.livpure.safedrink.subscription.address.data.model;

import com.google.gson.annotations.SerializedName;
import com.livpure.safedrink.login.api.models.response.BaseV1Response;
import com.moengage.pushbase.MoEPushConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: CitiesResponse.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0011\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\t\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/livpure/safedrink/subscription/address/data/model/CitiesResponse;", "Lcom/livpure/safedrink/login/api/models/response/BaseV1Response;", "cityDetailsList", "", "Lcom/livpure/safedrink/subscription/address/data/model/CityDetailsItem;", "(Ljava/util/List;)V", "getCityDetailsList", "()Ljava/util/List;", "component1", MoEPushConstants.ACTION_COPY, "equals", "", "other", "", "hashCode", "", "toString", "", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CitiesResponse extends BaseV1Response {
    @SerializedName("locationDetails")
    private final List<CityDetailsItem> cityDetailsList;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CitiesResponse copy$default(CitiesResponse citiesResponse, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = citiesResponse.cityDetailsList;
        }
        return citiesResponse.copy(list);
    }

    public final List<CityDetailsItem> component1() {
        return this.cityDetailsList;
    }

    public final CitiesResponse copy(List<CityDetailsItem> list) {
        return new CitiesResponse(list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof CitiesResponse) && Intrinsics.areEqual(this.cityDetailsList, ((CitiesResponse) obj).cityDetailsList);
    }

    public int hashCode() {
        List<CityDetailsItem> list = this.cityDetailsList;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    public String toString() {
        return "CitiesResponse(cityDetailsList=" + this.cityDetailsList + ')';
    }

    public final List<CityDetailsItem> getCityDetailsList() {
        return this.cityDetailsList;
    }

    public CitiesResponse(List<CityDetailsItem> list) {
        super(null, null, null, null, 15, null);
        this.cityDetailsList = list;
    }
}
