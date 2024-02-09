package com.livpure.safedrink.subscription.kyc.data;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import com.livpure.safedrink.api.APIException;
import com.livpure.safedrink.api.APIUtilKt;
import com.livpure.safedrink.subscription.kyc.api.ConfigAPIService;
import com.livpure.safedrink.subscription.kyc.data.model.DropDownResponse;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ConfigRepository.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nR\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"Lcom/livpure/safedrink/subscription/kyc/data/ConfigRepository;", "", "()V", "apiService", "Lcom/livpure/safedrink/subscription/kyc/api/ConfigAPIService;", "getApiService", "()Lcom/livpure/safedrink/subscription/kyc/api/ConfigAPIService;", "apiService$delegate", "Lkotlin/Lazy;", "getDropDownListsForProofs", "Landroidx/lifecycle/LiveData;", "Lcom/livpure/safedrink/subscription/kyc/data/model/DropDownResponse;", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ConfigRepository {
    private final Lazy apiService$delegate = LazyKt.lazy(new Function0<ConfigAPIService>() { // from class: com.livpure.safedrink.subscription.kyc.data.ConfigRepository$apiService$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ConfigAPIService invoke() {
            return ConfigAPIService.Factory.getConfigAPIService();
        }
    });

    private final ConfigAPIService getApiService() {
        return (ConfigAPIService) this.apiService$delegate.getValue();
    }

    public final LiveData<DropDownResponse> getDropDownListsForProofs() throws APIException {
        LiveData<DropDownResponse> fromPublisher = LiveDataReactiveStreams.fromPublisher(APIUtilKt.observe(getApiService().getDropdownLists(), new Function0<DropDownResponse>() { // from class: com.livpure.safedrink.subscription.kyc.data.ConfigRepository$getDropDownListsForProofs$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final DropDownResponse invoke() {
                return new DropDownResponse(null);
            }
        }));
        Intrinsics.checkNotNullExpressionValue(fromPublisher, "fromPublisher(\n         …esponse(null) }\n        )");
        return fromPublisher;
    }
}
