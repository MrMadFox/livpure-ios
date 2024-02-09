package com.livpure.safedrink.subscription.address.data;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import com.livpure.safedrink.api.APIException;
import com.livpure.safedrink.api.APIUtilKt;
import com.livpure.safedrink.subscription.address.api.CitiesAPIService;
import com.livpure.safedrink.subscription.address.data.model.CitiesResponse;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: CitiesRepository.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nR\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"Lcom/livpure/safedrink/subscription/address/data/CitiesRepository;", "", "()V", "citiesAPIService", "Lcom/livpure/safedrink/subscription/address/api/CitiesAPIService;", "getCitiesAPIService", "()Lcom/livpure/safedrink/subscription/address/api/CitiesAPIService;", "citiesAPIService$delegate", "Lkotlin/Lazy;", "getCities", "Landroidx/lifecycle/LiveData;", "Lcom/livpure/safedrink/subscription/address/data/model/CitiesResponse;", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CitiesRepository {
    private final Lazy citiesAPIService$delegate = LazyKt.lazy(new Function0<CitiesAPIService>() { // from class: com.livpure.safedrink.subscription.address.data.CitiesRepository$citiesAPIService$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final CitiesAPIService invoke() {
            return CitiesAPIService.Factory.getCitiesAPIService();
        }
    });

    private final CitiesAPIService getCitiesAPIService() {
        return (CitiesAPIService) this.citiesAPIService$delegate.getValue();
    }

    public final LiveData<CitiesResponse> getCities() throws APIException {
        LiveData<CitiesResponse> fromPublisher = LiveDataReactiveStreams.fromPublisher(APIUtilKt.observe(getCitiesAPIService().fetchCities(), new Function0<CitiesResponse>() { // from class: com.livpure.safedrink.subscription.address.data.CitiesRepository$getCities$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CitiesResponse invoke() {
                return new CitiesResponse(null);
            }
        }));
        Intrinsics.checkNotNullExpressionValue(fromPublisher, "fromPublisher(\n         …Response(null)}\n        )");
        return fromPublisher;
    }
}
