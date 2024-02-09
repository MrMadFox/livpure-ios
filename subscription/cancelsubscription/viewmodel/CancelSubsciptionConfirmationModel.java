package com.livpure.safedrink.subscription.cancelsubscription.viewmodel;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;
import com.livpure.safedrink.api.BaseDataHolder;
import com.livpure.safedrink.app.LSApplication;
import com.livpure.safedrink.common.arc.ui.viewmodels.BaseViewModel;
import com.livpure.safedrink.common.arc.ui.viewmodels.MediatorViewModel;
import com.livpure.safedrink.subscription.cancelsubscription.data.CancelRequestRespository;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: CancelSubsciptionConfirmationModel.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00142\u0006\u0010\u0016\u001a\u00020\nR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0017"}, d2 = {"Lcom/livpure/safedrink/subscription/cancelsubscription/viewmodel/CancelSubsciptionConfirmationModel;", "Lcom/livpure/safedrink/common/arc/ui/viewmodels/MediatorViewModel;", "()V", "cancelReason", "Landroidx/lifecycle/MutableLiveData;", "", "getCancelReason", "()Landroidx/lifecycle/MutableLiveData;", "listOfCancelReason", "", "", "getListOfCancelReason", "()Ljava/util/List;", "repository", "Lcom/livpure/safedrink/subscription/cancelsubscription/data/CancelRequestRespository;", "getRepository", "()Lcom/livpure/safedrink/subscription/cancelsubscription/data/CancelRequestRespository;", "repository$delegate", "Lkotlin/Lazy;", "updateCancellationStatus", "Landroidx/lifecycle/LiveData;", "", "cancelReasonDetail", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CancelSubsciptionConfirmationModel extends MediatorViewModel {
    private final MutableLiveData<Integer> cancelReason;
    private final List<String> listOfCancelReason = CollectionsKt.mutableListOf("Select Reason", "Shifting Location", "Duplicate Order", "Pricing is high", "Do not want to provide eKYC document", "Other reason for Cancellation");
    private final Lazy repository$delegate = LazyKt.lazy(new Function0<CancelRequestRespository>() { // from class: com.livpure.safedrink.subscription.cancelsubscription.viewmodel.CancelSubsciptionConfirmationModel$repository$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final CancelRequestRespository invoke() {
            return new CancelRequestRespository();
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: cancelReason$lambda-1$lambda-0  reason: not valid java name */
    public static final void m1289cancelReason$lambda1$lambda0(Integer num) {
    }

    public CancelSubsciptionConfirmationModel() {
        MutableLiveData<Integer> mutableLiveData = new MutableLiveData<>();
        observeAndTrack(mutableLiveData, new Observer() { // from class: com.livpure.safedrink.subscription.cancelsubscription.viewmodel.CancelSubsciptionConfirmationModel$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CancelSubsciptionConfirmationModel.m1289cancelReason$lambda1$lambda0((Integer) obj);
            }
        });
        this.cancelReason = mutableLiveData;
    }

    public final List<String> getListOfCancelReason() {
        return this.listOfCancelReason;
    }

    private final CancelRequestRespository getRepository() {
        return (CancelRequestRespository) this.repository$delegate.getValue();
    }

    public final MutableLiveData<Integer> getCancelReason() {
        return this.cancelReason;
    }

    public final LiveData<Boolean> updateCancellationStatus(String cancelReasonDetail) {
        Intrinsics.checkNotNullParameter(cancelReasonDetail, "cancelReasonDetail");
        if (LSApplication.Companion.isNetworkAvailable()) {
            return Transformations.map(getRepository().cancelService(cancelReasonDetail, ""), new Function() { // from class: com.livpure.safedrink.subscription.cancelsubscription.viewmodel.CancelSubsciptionConfirmationModel$$ExternalSyntheticLambda0
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    Boolean m1290updateCancellationStatus$lambda2;
                    m1290updateCancellationStatus$lambda2 = CancelSubsciptionConfirmationModel.m1290updateCancellationStatus$lambda2((BaseDataHolder) obj);
                    return m1290updateCancellationStatus$lambda2;
                }
            });
        }
        getNetworkState().setValue(BaseViewModel.NetworkState.OFFLINE);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: updateCancellationStatus$lambda-2  reason: not valid java name */
    public static final Boolean m1290updateCancellationStatus$lambda2(BaseDataHolder baseDataHolder) {
        return Boolean.valueOf(baseDataHolder.getStatus());
    }
}
