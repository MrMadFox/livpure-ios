package com.livpure.safedrink.bolt.data;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import com.livpure.safedrink.api.APIUtilKt;
import com.livpure.safedrink.api.BaseDataHolder;
import com.livpure.safedrink.bolt.api.BoltRequestAPIService;
import com.livpure.safedrink.bolt.data.models.BoltBleCommands;
import com.livpure.safedrink.bolt.data.models.BoltCommandsResponse;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: BoltBleCommandsRespository.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n2\u0006\u0010\r\u001a\u00020\u000eR\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/livpure/safedrink/bolt/data/BoltBleCommandsRespository;", "", "()V", "apiService", "Lcom/livpure/safedrink/bolt/api/BoltRequestAPIService;", "getApiService", "()Lcom/livpure/safedrink/bolt/api/BoltRequestAPIService;", "apiService$delegate", "Lkotlin/Lazy;", "getBoltBleCommands", "Landroidx/lifecycle/LiveData;", "Lcom/livpure/safedrink/api/BaseDataHolder;", "Lcom/livpure/safedrink/bolt/data/models/BoltCommandsResponse;", "serialNo", "", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BoltBleCommandsRespository {
    private final Lazy apiService$delegate = LazyKt.lazy(new Function0<BoltRequestAPIService>() { // from class: com.livpure.safedrink.bolt.data.BoltBleCommandsRespository$apiService$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final BoltRequestAPIService invoke() {
            return BoltRequestAPIService.Factory.getAPIService();
        }
    });

    private final BoltRequestAPIService getApiService() {
        return (BoltRequestAPIService) this.apiService$delegate.getValue();
    }

    public final LiveData<BaseDataHolder<BoltCommandsResponse>> getBoltBleCommands(String serialNo) {
        Intrinsics.checkNotNullParameter(serialNo, "serialNo");
        LiveData<BaseDataHolder<BoltCommandsResponse>> fromPublisher = LiveDataReactiveStreams.fromPublisher(APIUtilKt.validateAndObserve(getApiService().getBlueToothCommands(new BoltBleCommands(serialNo))));
        Intrinsics.checkNotNullExpressionValue(fromPublisher, "fromPublisher(\n         …ateAndObserve()\n        )");
        return fromPublisher;
    }
}
