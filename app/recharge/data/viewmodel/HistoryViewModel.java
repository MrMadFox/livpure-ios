package com.livpure.safedrink.app.recharge.data.viewmodel;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;
import com.livpure.safedrink.api.APIException;
import com.livpure.safedrink.app.LSApplication;
import com.livpure.safedrink.app.recharge.data.repository.HistoryRepository;
import com.livpure.safedrink.app.recharge.model.HistoryResponse;
import com.livpure.safedrink.app.recharge.model.RechargeDetailsItem;
import com.livpure.safedrink.common.arc.Event;
import com.livpure.safedrink.common.arc.ui.viewmodels.BaseViewModel;
import com.livpure.safedrink.common.arc.ui.viewmodels.MediatorViewModel;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: HistoryViewModel.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0006\u001a\u00020\u0019R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R(\u0010\u0012\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u00140\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Lcom/livpure/safedrink/app/recharge/data/viewmodel/HistoryViewModel;", "Lcom/livpure/safedrink/common/arc/ui/viewmodels/MediatorViewModel;", "()V", "historyData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/livpure/safedrink/app/recharge/model/HistoryResponse;", "historyRepository", "Lcom/livpure/safedrink/app/recharge/data/repository/HistoryRepository;", "getHistoryRepository", "()Lcom/livpure/safedrink/app/recharge/data/repository/HistoryRepository;", "historyRepository$delegate", "Lkotlin/Lazy;", "rechargeDetailsItem", "Lcom/livpure/safedrink/app/recharge/model/RechargeDetailsItem;", "getRechargeDetailsItem", "()Lcom/livpure/safedrink/app/recharge/model/RechargeDetailsItem;", "setRechargeDetailsItem", "(Lcom/livpure/safedrink/app/recharge/model/RechargeDetailsItem;)V", "rechargeDetailsList", "Landroidx/lifecycle/LiveData;", "", "getRechargeDetailsList", "()Landroidx/lifecycle/LiveData;", "setRechargeDetailsList", "(Landroidx/lifecycle/LiveData;)V", "", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class HistoryViewModel extends MediatorViewModel {
    private final MutableLiveData<HistoryResponse> historyData;
    private final Lazy historyRepository$delegate = LazyKt.lazy(new Function0<HistoryRepository>() { // from class: com.livpure.safedrink.app.recharge.data.viewmodel.HistoryViewModel$historyRepository$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final HistoryRepository invoke() {
            return new HistoryRepository();
        }
    });
    private RechargeDetailsItem rechargeDetailsItem;
    private LiveData<List<RechargeDetailsItem>> rechargeDetailsList;

    public HistoryViewModel() {
        MutableLiveData<HistoryResponse> mutableLiveData = new MutableLiveData<>();
        this.historyData = mutableLiveData;
        this.rechargeDetailsItem = new RechargeDetailsItem(null, null, null, null, 15, null);
        LiveData<List<RechargeDetailsItem>> map = Transformations.map(mutableLiveData, new Function() { // from class: com.livpure.safedrink.app.recharge.data.viewmodel.HistoryViewModel$$ExternalSyntheticLambda0
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                List rechargeDetails;
                rechargeDetails = ((HistoryResponse) obj).getRechargeDetails();
                return rechargeDetails;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "map(historyData) {\n     … it.rechargeDetails\n    }");
        this.rechargeDetailsList = map;
    }

    private final HistoryRepository getHistoryRepository() {
        return (HistoryRepository) this.historyRepository$delegate.getValue();
    }

    public final RechargeDetailsItem getRechargeDetailsItem() {
        return this.rechargeDetailsItem;
    }

    public final void setRechargeDetailsItem(RechargeDetailsItem rechargeDetailsItem) {
        Intrinsics.checkNotNullParameter(rechargeDetailsItem, "<set-?>");
        this.rechargeDetailsItem = rechargeDetailsItem;
    }

    public final LiveData<List<RechargeDetailsItem>> getRechargeDetailsList() {
        return this.rechargeDetailsList;
    }

    public final void setRechargeDetailsList(LiveData<List<RechargeDetailsItem>> liveData) {
        Intrinsics.checkNotNullParameter(liveData, "<set-?>");
        this.rechargeDetailsList = liveData;
    }

    public final void historyRepository() {
        if (LSApplication.Companion.isNetworkAvailable()) {
            getLoading().setValue(true);
            try {
                observeAndTrack(getHistoryRepository().getRechargeHistory(), new Observer() { // from class: com.livpure.safedrink.app.recharge.data.viewmodel.HistoryViewModel$$ExternalSyntheticLambda1
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        HistoryViewModel.m452historyRepository$lambda1(HistoryViewModel.this, (HistoryResponse) obj);
                    }
                });
                return;
            } catch (APIException unused) {
                getLoading().setValue(false);
                getToastMessageLiveData().setValue(new Event<>("Oops! We faced an issue while fetching your dashboard details at this time."));
                return;
            }
        }
        getNetworkState().setValue(BaseViewModel.NetworkState.OFFLINE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: historyRepository$lambda-1  reason: not valid java name */
    public static final void m452historyRepository$lambda1(final HistoryViewModel this$0, HistoryResponse historyResponse) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getLoading().setValue(false);
        this$0.processResponse(historyResponse, new Function1<HistoryResponse, Unit>() { // from class: com.livpure.safedrink.app.recharge.data.viewmodel.HistoryViewModel$historyRepository$4$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(HistoryResponse historyResponse2) {
                invoke2(historyResponse2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(HistoryResponse successfulResponse) {
                MutableLiveData mutableLiveData;
                Intrinsics.checkNotNullParameter(successfulResponse, "successfulResponse");
                mutableLiveData = HistoryViewModel.this.historyData;
                mutableLiveData.setValue(successfulResponse);
            }
        }, new Function1<HistoryResponse, Unit>() { // from class: com.livpure.safedrink.app.recharge.data.viewmodel.HistoryViewModel$historyRepository$4$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(HistoryResponse historyResponse2) {
                invoke2(historyResponse2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(HistoryResponse it) {
                MutableLiveData toastMessageLiveData;
                Intrinsics.checkNotNullParameter(it, "it");
                toastMessageLiveData = HistoryViewModel.this.getToastMessageLiveData();
                toastMessageLiveData.setValue(new Event(String.valueOf(it.getMessage())));
            }
        });
    }
}
