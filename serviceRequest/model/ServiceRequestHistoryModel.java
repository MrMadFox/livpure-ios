package com.livpure.safedrink.serviceRequest.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.livpure.safedrink.app.LSApplication;
import com.livpure.safedrink.common.arc.ui.viewmodels.BaseViewModel;
import com.livpure.safedrink.common.arc.ui.viewmodels.MediatorViewModel;
import com.livpure.safedrink.login.data.models.User;
import com.livpure.safedrink.serviceRequest.data.Models.ServiceLogs;
import com.livpure.safedrink.serviceRequest.data.Models.ServiceRequestHistory;
import com.livpure.safedrink.serviceRequest.data.ServicerequestRepository;
import com.livpure.safedrink.serviceRequest.data.model.FreshdeskHistory;
import com.livpure.safedrink.serviceRequest.data.model.FreshdeskHistoryData;
import com.livpure.safedrink.serviceRequest.data.model.ServiceHistory;
import com.livpure.safedrink.serviceRequest.data.model.ServiceHistoryBaseClass;
import com.livpure.safedrink.serviceRequest.data.model.ServiceHistoryResponse;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ServiceRequestHistoryModel.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013J\u0014\u0010\u0015\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u0005\u0018\u00010\u0013R\u001d\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\bR\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0016"}, d2 = {"Lcom/livpure/safedrink/serviceRequest/model/ServiceRequestHistoryModel;", "Lcom/livpure/safedrink/common/arc/ui/viewmodels/MediatorViewModel;", "()V", "freshdeskHistoryData", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/livpure/safedrink/serviceRequest/data/model/FreshdeskHistoryData;", "getFreshdeskHistoryData", "()Landroidx/lifecycle/MutableLiveData;", "serviceHistoryResponse", "Lcom/livpure/safedrink/serviceRequest/data/model/ServiceHistoryResponse;", "getServiceHistoryResponse", "servicerequestRepository", "Lcom/livpure/safedrink/serviceRequest/data/ServicerequestRepository;", "getServicerequestRepository", "()Lcom/livpure/safedrink/serviceRequest/data/ServicerequestRepository;", "servicerequestRepository$delegate", "Lkotlin/Lazy;", "freshdeskHistoryResponse", "Landroidx/lifecycle/LiveData;", "Lcom/livpure/safedrink/serviceRequest/data/model/FreshdeskHistory;", "updateServicerequesteee", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ServiceRequestHistoryModel extends MediatorViewModel {
    private final MutableLiveData<List<FreshdeskHistoryData>> freshdeskHistoryData;
    private final MutableLiveData<List<ServiceHistoryResponse>> serviceHistoryResponse;
    private final Lazy servicerequestRepository$delegate = LazyKt.lazy(new Function0<ServicerequestRepository>() { // from class: com.livpure.safedrink.serviceRequest.model.ServiceRequestHistoryModel$servicerequestRepository$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ServicerequestRepository invoke() {
            return new ServicerequestRepository();
        }
    });

    public ServiceRequestHistoryModel() {
        MutableLiveData<List<ServiceHistoryResponse>> mutableLiveData = new MutableLiveData<>();
        mutableLiveData.setValue(null);
        this.serviceHistoryResponse = mutableLiveData;
        MutableLiveData<List<FreshdeskHistoryData>> mutableLiveData2 = new MutableLiveData<>();
        mutableLiveData2.setValue(null);
        this.freshdeskHistoryData = mutableLiveData2;
    }

    private final ServicerequestRepository getServicerequestRepository() {
        return (ServicerequestRepository) this.servicerequestRepository$delegate.getValue();
    }

    public final MutableLiveData<List<ServiceHistoryResponse>> getServiceHistoryResponse() {
        return this.serviceHistoryResponse;
    }

    public final MutableLiveData<List<FreshdeskHistoryData>> getFreshdeskHistoryData() {
        return this.freshdeskHistoryData;
    }

    public final LiveData<List<ServiceHistoryResponse>> updateServicerequesteee() {
        User user = LSApplication.Companion.getUser();
        ServiceRequestHistory serviceRequestHistory = new ServiceRequestHistory("SZRs6Qivzc", "get_alljob_status", String.valueOf(user != null ? user.getMobile() : null));
        if (LSApplication.Companion.isNetworkAvailable()) {
            getLoading().setValue(true);
            observeAndTrack(getServicerequestRepository().getServiceRequest(serviceRequestHistory), new Observer() { // from class: com.livpure.safedrink.serviceRequest.model.ServiceRequestHistoryModel$$ExternalSyntheticLambda1
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    ServiceRequestHistoryModel.m1174updateServicerequesteee$lambda2(ServiceRequestHistoryModel.this, (ServiceHistory) obj);
                }
            });
            return (LiveData) null;
        }
        getNetworkState().setValue(BaseViewModel.NetworkState.OFFLINE);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: updateServicerequesteee$lambda-2  reason: not valid java name */
    public static final void m1174updateServicerequesteee$lambda2(ServiceRequestHistoryModel this$0, ServiceHistory serviceHistory) {
        ServiceHistoryBaseClass data;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getLoading().setValue(false);
        this$0.serviceHistoryResponse.setValue((serviceHistory == null || (data = serviceHistory.getData()) == null) ? null : data.getCases());
    }

    public final LiveData<FreshdeskHistory> freshdeskHistoryResponse() {
        User user = LSApplication.Companion.getUser();
        ServiceLogs serviceLogs = new ServiceLogs(String.valueOf(user != null ? user.getId() : null), "");
        if (LSApplication.Companion.isNetworkAvailable()) {
            getLoading().setValue(true);
            observeAndTrack(getServicerequestRepository().getFreshdeskServiceRequest(serviceLogs), new Observer() { // from class: com.livpure.safedrink.serviceRequest.model.ServiceRequestHistoryModel$$ExternalSyntheticLambda0
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    ServiceRequestHistoryModel.m1173freshdeskHistoryResponse$lambda3(ServiceRequestHistoryModel.this, (FreshdeskHistory) obj);
                }
            });
            return (LiveData) null;
        }
        getNetworkState().setValue(BaseViewModel.NetworkState.OFFLINE);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: freshdeskHistoryResponse$lambda-3  reason: not valid java name */
    public static final void m1173freshdeskHistoryResponse$lambda3(ServiceRequestHistoryModel this$0, FreshdeskHistory freshdeskHistory) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getLoading().setValue(false);
        this$0.freshdeskHistoryData.setValue(freshdeskHistory != null ? freshdeskHistory.getCases() : null);
    }
}
