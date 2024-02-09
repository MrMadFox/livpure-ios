package com.livpure.safedrink.dispenser.data;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import com.livpure.safedrink.api.APIUtilKt;
import com.livpure.safedrink.api.BaseDataHolder;
import com.livpure.safedrink.bolt.data.models.BoltCommandsResponse;
import com.livpure.safedrink.dispenser.api.DispenserRequestAPIService;
import com.livpure.safedrink.dispenser.data.models.DispenserBLEStatus;
import com.livpure.safedrink.dispenser.data.models.DispenserCommands;
import com.livpure.safedrink.dispenser.data.models.DispenserDashboardDetails;
import com.livpure.safedrink.dispenser.data.models.DispenserStatus;
import com.livpure.safedrink.dispenser.data.models.DispenserWifiStatus;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DispenserCommandsRepository.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\t\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b0\n2\u0006\u0010\r\u001a\u00020\u000eJ\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\n2\u0006\u0010\u0011\u001a\u00020\u0012J\u001c\u0010\u0013\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000b0\n2\u0006\u0010\u0014\u001a\u00020\u0015J\u001c\u0010\u0016\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000b0\n2\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\r\u001a\u00020\u0001R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u001b"}, d2 = {"Lcom/livpure/safedrink/dispenser/data/DispenserCommandsRepository;", "", "()V", "apiService", "Lcom/livpure/safedrink/dispenser/api/DispenserRequestAPIService;", "getApiService", "()Lcom/livpure/safedrink/dispenser/api/DispenserRequestAPIService;", "apiService$delegate", "Lkotlin/Lazy;", "getBlueToothCommand", "Landroidx/lifecycle/LiveData;", "Lcom/livpure/safedrink/api/BaseDataHolder;", "Lcom/livpure/safedrink/bolt/data/models/BoltCommandsResponse;", "dispenserBLEStatus", "Lcom/livpure/safedrink/dispenser/data/models/DispenserBLEStatus;", "getDashboardDetails", "Lcom/livpure/safedrink/dispenser/data/models/DispenserDashboardDetails;", "serialNo", "", "sendDispenserCommand", "dispenserCommand", "Lcom/livpure/safedrink/dispenser/data/models/DispenserCommands;", "setConnectivityStatus", "dispenserWifiStatus", "Lcom/livpure/safedrink/dispenser/data/models/DispenserWifiStatus;", "setSaveStatus", "", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DispenserCommandsRepository {
    private final Lazy apiService$delegate = LazyKt.lazy(new Function0<DispenserRequestAPIService>() { // from class: com.livpure.safedrink.dispenser.data.DispenserCommandsRepository$apiService$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final DispenserRequestAPIService invoke() {
            return DispenserRequestAPIService.Factory.getAPIService();
        }
    });

    public final void setSaveStatus(Object dispenserBLEStatus) {
        Intrinsics.checkNotNullParameter(dispenserBLEStatus, "dispenserBLEStatus");
    }

    private final DispenserRequestAPIService getApiService() {
        return (DispenserRequestAPIService) this.apiService$delegate.getValue();
    }

    public final LiveData<BaseDataHolder<Object>> sendDispenserCommand(DispenserCommands dispenserCommand) {
        Intrinsics.checkNotNullParameter(dispenserCommand, "dispenserCommand");
        LiveData<BaseDataHolder<Object>> fromPublisher = LiveDataReactiveStreams.fromPublisher(APIUtilKt.validateAndObserve(getApiService().sendDispenserCommand(dispenserCommand)));
        Intrinsics.checkNotNullExpressionValue(fromPublisher, "fromPublisher(\n         …ateAndObserve()\n        )");
        return fromPublisher;
    }

    public final LiveData<BaseDataHolder<Object>> setConnectivityStatus(DispenserWifiStatus dispenserWifiStatus) {
        Intrinsics.checkNotNullParameter(dispenserWifiStatus, "dispenserWifiStatus");
        LiveData<BaseDataHolder<Object>> fromPublisher = LiveDataReactiveStreams.fromPublisher(APIUtilKt.validateAndObserve(getApiService().setConnectivityStatus(dispenserWifiStatus)));
        Intrinsics.checkNotNullExpressionValue(fromPublisher, "fromPublisher(\n         …ateAndObserve()\n        )");
        return fromPublisher;
    }

    public final LiveData<BaseDataHolder<BoltCommandsResponse>> getBlueToothCommand(DispenserBLEStatus dispenserBLEStatus) {
        Intrinsics.checkNotNullParameter(dispenserBLEStatus, "dispenserBLEStatus");
        LiveData<BaseDataHolder<BoltCommandsResponse>> fromPublisher = LiveDataReactiveStreams.fromPublisher(APIUtilKt.validateAndObserve(getApiService().getBlueToothCommand(dispenserBLEStatus)));
        Intrinsics.checkNotNullExpressionValue(fromPublisher, "fromPublisher(\n         …ateAndObserve()\n        )");
        return fromPublisher;
    }

    public final LiveData<DispenserDashboardDetails> getDashboardDetails(String serialNo) {
        Intrinsics.checkNotNullParameter(serialNo, "serialNo");
        LiveData<DispenserDashboardDetails> fromPublisher = LiveDataReactiveStreams.fromPublisher(APIUtilKt.observeDispenser(getApiService().getDashboard(new DispenserStatus("9844945843", serialNo)), new Function0<DispenserDashboardDetails>() { // from class: com.livpure.safedrink.dispenser.data.DispenserCommandsRepository$getDashboardDetails$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final DispenserDashboardDetails invoke() {
                return new DispenserDashboardDetails(null);
            }
        }));
        Intrinsics.checkNotNullExpressionValue(fromPublisher, "fromPublisher(\n         …Details(null) }\n        )");
        return fromPublisher;
    }
}
