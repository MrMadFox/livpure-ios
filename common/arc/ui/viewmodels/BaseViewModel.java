package com.livpure.safedrink.common.arc.ui.viewmodels;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.livpure.safedrink.airpurifier.data.models.AirPurifierDashboardDetailsResponse;
import com.livpure.safedrink.api.APIUtilKt;
import com.livpure.safedrink.common.arc.Event;
import com.livpure.safedrink.common.arc.ui.viewmodels.BaseViewModel;
import com.livpure.safedrink.dispenser.data.models.DispenserDashboardDetailsResponse;
import com.livpure.safedrink.login.api.models.response.BaseV1Response;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: BaseViewModel.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001:\u0001%B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\u0012J\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u0012J\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0012Ja\u0010\u0014\u001a\u00020\u0015\"\b\b\u0000\u0010\u0016*\u00020\u0017*\u0004\u0018\u0001H\u00162!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u0011H\u0016¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00150\u00192!\u0010\u001d\u001a\u001d\u0012\u0013\u0012\u0011H\u0016¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00150\u0019¢\u0006\u0002\u0010\u001eJa\u0010\u001f\u001a\u00020\u0015\"\b\b\u0000\u0010\u0016*\u00020 *\u0004\u0018\u0001H\u00162!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u0011H\u0016¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00150\u00192!\u0010\u001d\u001a\u001d\u0012\u0013\u0012\u0011H\u0016¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00150\u0019¢\u0006\u0002\u0010!Ja\u0010\"\u001a\u00020\u0015\"\b\b\u0000\u0010\u0016*\u00020#*\u0004\u0018\u0001H\u00162!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u0011H\u0016¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00150\u00192!\u0010\u001d\u001a\u001d\u0012\u0013\u0012\u0011H\u0016¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00150\u0019¢\u0006\u0002\u0010$R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0007R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0007R \u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\u0004X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0007¨\u0006&"}, d2 = {"Lcom/livpure/safedrink/common/arc/ui/viewmodels/BaseViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "loading", "Landroidx/lifecycle/MutableLiveData;", "", "getLoading", "()Landroidx/lifecycle/MutableLiveData;", "networkState", "Lcom/livpure/safedrink/common/arc/ui/viewmodels/BaseViewModel$NetworkState;", "getNetworkState", "screenTrackingState", "getScreenTrackingState", "toastMessageLiveData", "Lcom/livpure/safedrink/common/arc/Event;", "", "getToastMessageLiveData", "checkForMessages", "Landroidx/lifecycle/LiveData;", "checkScreenTrackingState", "processResponse", "", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/livpure/safedrink/login/api/models/response/BaseV1Response;", "onSuccess", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "response", "onFailure", "(Lcom/livpure/safedrink/login/api/models/response/BaseV1Response;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "processResponseAir", "Lcom/livpure/safedrink/airpurifier/data/models/AirPurifierDashboardDetailsResponse;", "(Lcom/livpure/safedrink/airpurifier/data/models/AirPurifierDashboardDetailsResponse;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "processResponseDispense", "Lcom/livpure/safedrink/dispenser/data/models/DispenserDashboardDetailsResponse;", "(Lcom/livpure/safedrink/dispenser/data/models/DispenserDashboardDetailsResponse;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "NetworkState", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public class BaseViewModel extends ViewModel {
    private final MutableLiveData<Boolean> loading;
    private final MutableLiveData<NetworkState> networkState = new MutableLiveData<>();
    private final MutableLiveData<Boolean> screenTrackingState;
    private final MutableLiveData<Event<String>> toastMessageLiveData;

    /* compiled from: BaseViewModel.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/livpure/safedrink/common/arc/ui/viewmodels/BaseViewModel$NetworkState;", "", "(Ljava/lang/String;I)V", "ONLINE", "OFFLINE", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public enum NetworkState {
        ONLINE,
        OFFLINE
    }

    public BaseViewModel() {
        MutableLiveData<Boolean> mutableLiveData = new MutableLiveData<>();
        mutableLiveData.setValue(false);
        this.loading = mutableLiveData;
        MutableLiveData<Boolean> mutableLiveData2 = new MutableLiveData<>();
        mutableLiveData2.setValue(false);
        this.screenTrackingState = mutableLiveData2;
        this.toastMessageLiveData = new MutableLiveData<>();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: getNetworkState  reason: collision with other method in class */
    public final MutableLiveData<NetworkState> m539getNetworkState() {
        return this.networkState;
    }

    public final MutableLiveData<Boolean> getLoading() {
        return this.loading;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final MutableLiveData<Boolean> getScreenTrackingState() {
        return this.screenTrackingState;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final MutableLiveData<Event<String>> getToastMessageLiveData() {
        return this.toastMessageLiveData;
    }

    public final LiveData<Event<String>> checkForMessages() {
        return this.toastMessageLiveData;
    }

    public final LiveData<Boolean> checkScreenTrackingState() {
        return this.screenTrackingState;
    }

    public final LiveData<NetworkState> getNetworkState() {
        return this.networkState;
    }

    public final <T extends BaseV1Response> void processResponse(T t, Function1<? super T, Unit> onSuccess, Function1<? super T, Unit> onFailure) {
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onFailure, "onFailure");
        APIUtilKt.processResponseWithAPIException(t, onSuccess, onFailure, new Function0<Unit>() { // from class: com.livpure.safedrink.common.arc.ui.viewmodels.BaseViewModel$processResponse$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                BaseViewModel.this.m539getNetworkState().setValue(BaseViewModel.NetworkState.OFFLINE);
            }
        });
    }

    public final <T extends AirPurifierDashboardDetailsResponse> void processResponseAir(T t, Function1<? super T, Unit> onSuccess, Function1<? super T, Unit> onFailure) {
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onFailure, "onFailure");
        APIUtilKt.processResponseWithAPIExceptionForAir(t, onSuccess, onFailure, new Function0<Unit>() { // from class: com.livpure.safedrink.common.arc.ui.viewmodels.BaseViewModel$processResponseAir$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                BaseViewModel.this.m539getNetworkState().setValue(BaseViewModel.NetworkState.OFFLINE);
            }
        });
    }

    public final <T extends DispenserDashboardDetailsResponse> void processResponseDispense(T t, Function1<? super T, Unit> onSuccess, Function1<? super T, Unit> onFailure) {
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onFailure, "onFailure");
        Intrinsics.checkNotNull(t);
        t.processResponseWithAPIExceptionForDispense(onSuccess, onFailure, new Function0<Unit>() { // from class: com.livpure.safedrink.common.arc.ui.viewmodels.BaseViewModel$processResponseDispense$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                BaseViewModel.this.m539getNetworkState().setValue(BaseViewModel.NetworkState.OFFLINE);
            }
        });
    }
}
