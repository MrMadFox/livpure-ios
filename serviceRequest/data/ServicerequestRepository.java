package com.livpure.safedrink.serviceRequest.data;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import com.livpure.safedrink.api.APIUtilKt;
import com.livpure.safedrink.api.BaseDataHolder;
import com.livpure.safedrink.serviceRequest.api.ServiceReguestAPIService;
import com.livpure.safedrink.serviceRequest.data.Models.ServiceLogs;
import com.livpure.safedrink.serviceRequest.data.Models.ServiceRequestData;
import com.livpure.safedrink.serviceRequest.data.Models.ServiceRequestHistory;
import com.livpure.safedrink.serviceRequest.data.Models.ServiceRequestResponse;
import com.livpure.safedrink.serviceRequest.data.model.FreshdeskHistory;
import com.livpure.safedrink.serviceRequest.data.model.OTPRequest;
import com.livpure.safedrink.serviceRequest.data.model.RefreshRechargeRequest;
import com.livpure.safedrink.serviceRequest.data.model.RefreshRechargeResponse;
import com.livpure.safedrink.serviceRequest.data.model.ServiceHistory;
import com.livpure.safedrink.serviceRequest.data.model.ServiceRequestOtherData;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ServicerequestRepository.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\t\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000b0\nJ\u0016\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\n2\u0006\u0010\u000e\u001a\u00020\u000fJ\u001c\u0010\u0010\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000b0\n2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0016\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\n2\u0006\u0010\u0013\u001a\u00020\u0014J\u001c\u0010\u0015\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000b0\n2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\n2\u0006\u0010\u0016\u001a\u00020\u0018J\u001c\u0010\u0019\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000b0\n2\u0006\u0010\u001a\u001a\u00020\u001bJ\u0016\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\n2\u0006\u0010\u001e\u001a\u00020\u001fJ\u001c\u0010 \u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000b0\n2\u0006\u0010!\u001a\u00020\"R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006#"}, d2 = {"Lcom/livpure/safedrink/serviceRequest/data/ServicerequestRepository;", "", "()V", "apiService", "Lcom/livpure/safedrink/serviceRequest/api/ServiceReguestAPIService;", "getApiService", "()Lcom/livpure/safedrink/serviceRequest/api/ServiceReguestAPIService;", "apiService$delegate", "Lkotlin/Lazy;", "getCancelOTP", "Landroidx/lifecycle/LiveData;", "Lcom/livpure/safedrink/api/BaseDataHolder;", "getFreshdeskServiceRequest", "Lcom/livpure/safedrink/serviceRequest/data/model/FreshdeskHistory;", "serviceLogs", "Lcom/livpure/safedrink/serviceRequest/data/Models/ServiceLogs;", "getFreshdeskServiceRequestTemp", "getServiceRequest", "Lcom/livpure/safedrink/serviceRequest/data/model/ServiceHistory;", "serviceRequestHistory", "Lcom/livpure/safedrink/serviceRequest/data/Models/ServiceRequestHistory;", "getserviceLogs", "refreshRecharge", "Lcom/livpure/safedrink/serviceRequest/data/model/RefreshRechargeResponse;", "Lcom/livpure/safedrink/serviceRequest/data/model/RefreshRechargeRequest;", "setServiceRequestOtherData", "serviceRequestOtherData", "Lcom/livpure/safedrink/serviceRequest/data/model/ServiceRequestOtherData;", "updateServiceRequest", "Lcom/livpure/safedrink/serviceRequest/data/Models/ServiceRequestResponse;", "serviceRequestData", "Lcom/livpure/safedrink/serviceRequest/data/Models/ServiceRequestData;", "verifyCancelOtp", "oTPRequest", "Lcom/livpure/safedrink/serviceRequest/data/model/OTPRequest;", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ServicerequestRepository {
    private final Lazy apiService$delegate = LazyKt.lazy(new Function0<ServiceReguestAPIService>() { // from class: com.livpure.safedrink.serviceRequest.data.ServicerequestRepository$apiService$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ServiceReguestAPIService invoke() {
            return ServiceReguestAPIService.Factory.getServicerequestAPIService();
        }
    });

    private final ServiceReguestAPIService getApiService() {
        return (ServiceReguestAPIService) this.apiService$delegate.getValue();
    }

    public final LiveData<ServiceRequestResponse> updateServiceRequest(ServiceRequestData serviceRequestData) {
        Intrinsics.checkNotNullParameter(serviceRequestData, "serviceRequestData");
        LiveData<ServiceRequestResponse> fromPublisher = LiveDataReactiveStreams.fromPublisher(APIUtilKt.checkForExceptionsAndObserveService(ServiceReguestAPIService.DefaultImpls.updateServiceRequest$default(getApiService(), serviceRequestData, null, null, 6, null)));
        Intrinsics.checkNotNullExpressionValue(fromPublisher, "fromPublisher(\n         …bserveService()\n        )");
        return fromPublisher;
    }

    public final LiveData<ServiceHistory> getServiceRequest(ServiceRequestHistory serviceRequestHistory) {
        Intrinsics.checkNotNullParameter(serviceRequestHistory, "serviceRequestHistory");
        LiveData<ServiceHistory> fromPublisher = LiveDataReactiveStreams.fromPublisher(APIUtilKt.checkForExceptionsAndObserveServiceHistory(ServiceReguestAPIService.DefaultImpls.getServiceRequestHistory$default(getApiService(), serviceRequestHistory, null, null, 6, null)));
        Intrinsics.checkNotNullExpressionValue(fromPublisher, "fromPublisher(\n         …erviceHistory()\n        )");
        return fromPublisher;
    }

    public final LiveData<BaseDataHolder<Object>> getserviceLogs(ServiceLogs serviceLogs) {
        Intrinsics.checkNotNullParameter(serviceLogs, "serviceLogs");
        LiveData<BaseDataHolder<Object>> fromPublisher = LiveDataReactiveStreams.fromPublisher(APIUtilKt.validateAndObserve(getApiService().getServiceLogs(serviceLogs)));
        Intrinsics.checkNotNullExpressionValue(fromPublisher, "fromPublisher(\n         …ateAndObserve()\n        )");
        return fromPublisher;
    }

    public final LiveData<RefreshRechargeResponse> refreshRecharge(RefreshRechargeRequest refreshRecharge) {
        Intrinsics.checkNotNullParameter(refreshRecharge, "refreshRecharge");
        LiveData<RefreshRechargeResponse> fromPublisher = LiveDataReactiveStreams.fromPublisher(APIUtilKt.observe(getApiService().refreshRechargeRequest(refreshRecharge), new Function0<RefreshRechargeResponse>() { // from class: com.livpure.safedrink.serviceRequest.data.ServicerequestRepository$refreshRecharge$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final RefreshRechargeResponse invoke() {
                return new RefreshRechargeResponse(null, 1, null);
            }
        }));
        Intrinsics.checkNotNullExpressionValue(fromPublisher, "fromPublisher(\n         …rgeResponse() }\n        )");
        return fromPublisher;
    }

    public final LiveData<BaseDataHolder<Object>> setServiceRequestOtherData(ServiceRequestOtherData serviceRequestOtherData) {
        Intrinsics.checkNotNullParameter(serviceRequestOtherData, "serviceRequestOtherData");
        LiveData<BaseDataHolder<Object>> fromPublisher = LiveDataReactiveStreams.fromPublisher(APIUtilKt.validateAndObserve(getApiService().getServiceRequest(serviceRequestOtherData)));
        Intrinsics.checkNotNullExpressionValue(fromPublisher, "fromPublisher(\n         …ateAndObserve()\n        )");
        return fromPublisher;
    }

    public final LiveData<BaseDataHolder<Object>> getCancelOTP() {
        LiveData<BaseDataHolder<Object>> fromPublisher = LiveDataReactiveStreams.fromPublisher(APIUtilKt.validateAndObserve(getApiService().sendCancelOtp()));
        Intrinsics.checkNotNullExpressionValue(fromPublisher, "fromPublisher(\n         …ateAndObserve()\n        )");
        return fromPublisher;
    }

    public final LiveData<BaseDataHolder<Object>> verifyCancelOtp(OTPRequest oTPRequest) {
        Intrinsics.checkNotNullParameter(oTPRequest, "oTPRequest");
        LiveData<BaseDataHolder<Object>> fromPublisher = LiveDataReactiveStreams.fromPublisher(APIUtilKt.validateAndObserve(getApiService().verifyCancelOtp(oTPRequest)));
        Intrinsics.checkNotNullExpressionValue(fromPublisher, "fromPublisher(\n         …ateAndObserve()\n        )");
        return fromPublisher;
    }

    public final LiveData<FreshdeskHistory> getFreshdeskServiceRequest(ServiceLogs serviceLogs) {
        Intrinsics.checkNotNullParameter(serviceLogs, "serviceLogs");
        LiveData<FreshdeskHistory> fromPublisher = LiveDataReactiveStreams.fromPublisher(APIUtilKt.validateFreshdesk(getApiService().getFreshdeskHistoryRequest(serviceLogs)));
        Intrinsics.checkNotNullExpressionValue(fromPublisher, "fromPublisher(\n         …dateFreshdesk()\n        )");
        return fromPublisher;
    }

    public final LiveData<BaseDataHolder<Object>> getFreshdeskServiceRequestTemp(ServiceLogs serviceLogs) {
        Intrinsics.checkNotNullParameter(serviceLogs, "serviceLogs");
        LiveData<BaseDataHolder<Object>> fromPublisher = LiveDataReactiveStreams.fromPublisher(APIUtilKt.validateAndObserve(getApiService().getServiceRequestTemp(serviceLogs)));
        Intrinsics.checkNotNullExpressionValue(fromPublisher, "fromPublisher(\n         …ateAndObserve()\n        )");
        return fromPublisher;
    }
}
