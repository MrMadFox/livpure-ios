package com.livpure.safedrink.app.support.data;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import com.facebook.share.internal.ShareConstants;
import com.livpure.safedrink.api.APIUtilKt;
import com.livpure.safedrink.api.BaseDataHolder;
import com.livpure.safedrink.app.support.api.ServiceRequestAPIService;
import com.livpure.safedrink.app.support.data.models.SRRequest;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ServiceRequestRepository.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\t\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000b0\n2\u0006\u0010\f\u001a\u00020\rR\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/livpure/safedrink/app/support/data/ServiceRequestRepository;", "", "()V", "apiService", "Lcom/livpure/safedrink/app/support/api/ServiceRequestAPIService;", "getApiService", "()Lcom/livpure/safedrink/app/support/api/ServiceRequestAPIService;", "apiService$delegate", "Lkotlin/Lazy;", "sendSupportRequest", "Landroidx/lifecycle/LiveData;", "Lcom/livpure/safedrink/api/BaseDataHolder;", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ServiceRequestRepository {
    private final Lazy apiService$delegate = LazyKt.lazy(new Function0<ServiceRequestAPIService>() { // from class: com.livpure.safedrink.app.support.data.ServiceRequestRepository$apiService$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ServiceRequestAPIService invoke() {
            return ServiceRequestAPIService.Factory.getAPIService();
        }
    });

    private final ServiceRequestAPIService getApiService() {
        return (ServiceRequestAPIService) this.apiService$delegate.getValue();
    }

    public final LiveData<BaseDataHolder<Object>> sendSupportRequest(String request) {
        Intrinsics.checkNotNullParameter(request, "request");
        LiveData<BaseDataHolder<Object>> fromPublisher = LiveDataReactiveStreams.fromPublisher(APIUtilKt.validateAndObserve(getApiService().sendServiceRequest(new SRRequest(null, request, 1, null))));
        Intrinsics.checkNotNullExpressionValue(fromPublisher, "fromPublisher(\n         …ateAndObserve()\n        )");
        return fromPublisher;
    }
}
