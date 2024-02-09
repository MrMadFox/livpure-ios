package com.livpure.safedrink.subscription.address.api;

import com.livpure.safedrink.api.APIService;
import com.livpure.safedrink.subscription.address.data.model.CitiesResponse;
import io.reactivex.Flowable;
import kotlin.Metadata;
import retrofit2.http.POST;
/* compiled from: CitiesAPIService.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H'¨\u0006\u0006"}, d2 = {"Lcom/livpure/safedrink/subscription/address/api/CitiesAPIService;", "", "fetchCities", "Lio/reactivex/Flowable;", "Lcom/livpure/safedrink/subscription/address/data/model/CitiesResponse;", "Factory", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface CitiesAPIService {
    public static final Factory Factory = Factory.$$INSTANCE;

    @POST("/getAvailableCities")
    Flowable<CitiesResponse> fetchCities();

    /* compiled from: CitiesAPIService.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/livpure/safedrink/subscription/address/api/CitiesAPIService$Factory;", "Lcom/livpure/safedrink/api/APIService;", "()V", "getCitiesAPIService", "Lcom/livpure/safedrink/subscription/address/api/CitiesAPIService;", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Factory extends APIService {
        static final /* synthetic */ Factory $$INSTANCE = new Factory();

        private Factory() {
            super(null, 1, null);
        }

        public final CitiesAPIService getCitiesAPIService() {
            return (CitiesAPIService) new APIService.APIInterfaceFactory(this, CitiesAPIService.class).getAPIInterface();
        }
    }
}
