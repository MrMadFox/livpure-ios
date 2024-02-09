package com.livpure.safedrink.app.support.viewmodels;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import com.livpure.safedrink.api.BaseDataHolder;
import com.livpure.safedrink.app.LSApplication;
import com.livpure.safedrink.app.support.data.ServiceRequestRepository;
import com.livpure.safedrink.common.arc.Event;
import com.livpure.safedrink.common.arc.ui.viewmodels.AnalyticsViewModel;
import com.livpure.safedrink.common.arc.ui.viewmodels.BaseViewModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* compiled from: ServiceRequestViewModel.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fR\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/livpure/safedrink/app/support/viewmodels/ServiceRequestViewModel;", "Lcom/livpure/safedrink/common/arc/ui/viewmodels/AnalyticsViewModel;", "()V", "repository", "Lcom/livpure/safedrink/app/support/data/ServiceRequestRepository;", "getRepository", "()Lcom/livpure/safedrink/app/support/data/ServiceRequestRepository;", "repository$delegate", "Lkotlin/Lazy;", "serviceRequestMessage", "Landroidx/lifecycle/MutableLiveData;", "", "getServiceRequestMessage", "()Landroidx/lifecycle/MutableLiveData;", "getSubmissionStatus", "Landroidx/lifecycle/LiveData;", "", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ServiceRequestViewModel extends AnalyticsViewModel {
    private final Lazy repository$delegate = LazyKt.lazy(new Function0<ServiceRequestRepository>() { // from class: com.livpure.safedrink.app.support.viewmodels.ServiceRequestViewModel$repository$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ServiceRequestRepository invoke() {
            return new ServiceRequestRepository();
        }
    });
    private final MutableLiveData<String> serviceRequestMessage = new MutableLiveData<>();

    private final ServiceRequestRepository getRepository() {
        return (ServiceRequestRepository) this.repository$delegate.getValue();
    }

    public final MutableLiveData<String> getServiceRequestMessage() {
        return this.serviceRequestMessage;
    }

    public final LiveData<Boolean> getSubmissionStatus() {
        String value = this.serviceRequestMessage.getValue();
        if (!(value == null || StringsKt.isBlank(value)) && LSApplication.Companion.isNetworkAvailable()) {
            ServiceRequestRepository repository = getRepository();
            String value2 = this.serviceRequestMessage.getValue();
            Intrinsics.checkNotNull(value2);
            return Transformations.map(repository.sendSupportRequest(value2), new Function() { // from class: com.livpure.safedrink.app.support.viewmodels.ServiceRequestViewModel$$ExternalSyntheticLambda0
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    Boolean m456getSubmissionStatus$lambda0;
                    m456getSubmissionStatus$lambda0 = ServiceRequestViewModel.m456getSubmissionStatus$lambda0((BaseDataHolder) obj);
                    return m456getSubmissionStatus$lambda0;
                }
            });
        } else if (!LSApplication.Companion.isNetworkAvailable()) {
            getNetworkState().setValue(BaseViewModel.NetworkState.OFFLINE);
            return null;
        } else {
            getToastMessageLiveData().setValue(new Event<>("Please enter the message"));
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getSubmissionStatus$lambda-0  reason: not valid java name */
    public static final Boolean m456getSubmissionStatus$lambda0(BaseDataHolder baseDataHolder) {
        return Boolean.valueOf(baseDataHolder.getStatus());
    }
}
