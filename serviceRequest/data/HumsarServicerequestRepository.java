package com.livpure.safedrink.serviceRequest.data;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import com.livpure.safedrink.api.APIException;
import com.livpure.safedrink.api.APIUtilKt;
import com.livpure.safedrink.api.BaseDataHolder;
import com.livpure.safedrink.serviceRequest.api.HumsarServiceReguestAPIService;
import com.livpure.safedrink.serviceRequest.data.model.CustomerVoiceRequest;
import com.livpure.safedrink.serviceRequest.data.model.CustomerVoiceResponse;
import com.livpure.safedrink.serviceRequest.data.model.HumsarServiceRequest;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: HumsarServicerequestRepository.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\rJ\u001c\u0010\u000e\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000f0\n2\u0006\u0010\u0010\u001a\u00020\u0011R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/livpure/safedrink/serviceRequest/data/HumsarServicerequestRepository;", "", "()V", "apiService", "Lcom/livpure/safedrink/serviceRequest/api/HumsarServiceReguestAPIService;", "getApiService", "()Lcom/livpure/safedrink/serviceRequest/api/HumsarServiceReguestAPIService;", "apiService$delegate", "Lkotlin/Lazy;", "getCustomerVoice", "Landroidx/lifecycle/LiveData;", "Lcom/livpure/safedrink/serviceRequest/data/model/CustomerVoiceResponse;", "customerVoiceRequest", "Lcom/livpure/safedrink/serviceRequest/data/model/CustomerVoiceRequest;", "getServiceRequest", "Lcom/livpure/safedrink/api/BaseDataHolder;", "humsarServiceRequest", "Lcom/livpure/safedrink/serviceRequest/data/model/HumsarServiceRequest;", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class HumsarServicerequestRepository {
    private final Lazy apiService$delegate = LazyKt.lazy(new Function0<HumsarServiceReguestAPIService>() { // from class: com.livpure.safedrink.serviceRequest.data.HumsarServicerequestRepository$apiService$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final HumsarServiceReguestAPIService invoke() {
            return HumsarServiceReguestAPIService.Factory.getAPIService();
        }
    });

    private final HumsarServiceReguestAPIService getApiService() {
        return (HumsarServiceReguestAPIService) this.apiService$delegate.getValue();
    }

    public final LiveData<BaseDataHolder<Object>> getServiceRequest(HumsarServiceRequest humsarServiceRequest) {
        Intrinsics.checkNotNullParameter(humsarServiceRequest, "humsarServiceRequest");
        LiveData<BaseDataHolder<Object>> fromPublisher = LiveDataReactiveStreams.fromPublisher(getApiService().getWAAS_GetReason(humsarServiceRequest));
        Intrinsics.checkNotNullExpressionValue(fromPublisher, "fromPublisher(\n         …ServiceRequest)\n        )");
        return fromPublisher;
    }

    public final LiveData<CustomerVoiceResponse> getCustomerVoice(CustomerVoiceRequest customerVoiceRequest) throws APIException {
        Intrinsics.checkNotNullParameter(customerVoiceRequest, "customerVoiceRequest");
        LiveData<CustomerVoiceResponse> fromPublisher = LiveDataReactiveStreams.fromPublisher(APIUtilKt.observe(getApiService().getWAAS_GetCustomerVoice(customerVoiceRequest), new Function0<CustomerVoiceResponse>() { // from class: com.livpure.safedrink.serviceRequest.data.HumsarServicerequestRepository$getCustomerVoice$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CustomerVoiceResponse invoke() {
                return new CustomerVoiceResponse(null, null, null, 3, null);
            }
        }));
        Intrinsics.checkNotNullExpressionValue(fromPublisher, "fromPublisher(\n         …ResList =null)}\n        )");
        return fromPublisher;
    }
}
