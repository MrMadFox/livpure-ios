package com.livpure.safedrink.subscription.address.data;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import com.livpure.safedrink.api.APIUtilKt;
import com.livpure.safedrink.subscription.address.api.ServiceableAreaAPIService;
import com.livpure.safedrink.subscription.address.data.model.ServiceableAreaItem;
import com.livpure.safedrink.subscription.address.data.model.ServiceableAreaRequest;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: CRMRepository.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\t\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b0\n2\u0006\u0010\r\u001a\u00020\u000eR\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/livpure/safedrink/subscription/address/data/CRMRepository;", "", "()V", "apiService", "Lcom/livpure/safedrink/subscription/address/api/ServiceableAreaAPIService;", "getApiService", "()Lcom/livpure/safedrink/subscription/address/api/ServiceableAreaAPIService;", "apiService$delegate", "Lkotlin/Lazy;", "getMappedAreas", "Landroidx/lifecycle/LiveData;", "", "Lcom/livpure/safedrink/subscription/address/data/model/ServiceableAreaItem;", "pincode", "", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CRMRepository {
    private final Lazy apiService$delegate = LazyKt.lazy(new Function0<ServiceableAreaAPIService>() { // from class: com.livpure.safedrink.subscription.address.data.CRMRepository$apiService$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ServiceableAreaAPIService invoke() {
            return ServiceableAreaAPIService.Factory.getAreaAPIService();
        }
    });

    private final ServiceableAreaAPIService getApiService() {
        return (ServiceableAreaAPIService) this.apiService$delegate.getValue();
    }

    public final LiveData<List<ServiceableAreaItem>> getMappedAreas(String pincode) {
        Intrinsics.checkNotNullParameter(pincode, "pincode");
        LiveData<List<ServiceableAreaItem>> fromPublisher = LiveDataReactiveStreams.fromPublisher(APIUtilKt.checkForExceptionsAndObserve(ServiceableAreaAPIService.DefaultImpls.getMappedAreas$default(getApiService(), new ServiceableAreaRequest(pincode, null, 2, null), null, null, 6, null)));
        Intrinsics.checkNotNullExpressionValue(fromPublisher, "fromPublisher(\n         …ndObserve()\n            )");
        return fromPublisher;
    }
}
