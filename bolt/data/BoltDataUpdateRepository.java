package com.livpure.safedrink.bolt.data;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import com.livpure.safedrink.api.APIUtilKt;
import com.livpure.safedrink.api.BaseDataHolder;
import com.livpure.safedrink.bolt.api.BoltRequestAPIService;
import com.livpure.safedrink.bolt.data.models.BoltBLEUpdate;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: BoltDataUpdateRepository.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J,\u0010\t\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000b0\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/livpure/safedrink/bolt/data/BoltDataUpdateRepository;", "", "()V", "apiService", "Lcom/livpure/safedrink/bolt/api/BoltRequestAPIService;", "getApiService", "()Lcom/livpure/safedrink/bolt/api/BoltRequestAPIService;", "apiService$delegate", "Lkotlin/Lazy;", "sendBoltConfigtRequest", "Landroidx/lifecycle/LiveData;", "Lcom/livpure/safedrink/api/BaseDataHolder;", "serialNo", "", "roData", "isOffline", "", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BoltDataUpdateRepository {
    private final Lazy apiService$delegate = LazyKt.lazy(new Function0<BoltRequestAPIService>() { // from class: com.livpure.safedrink.bolt.data.BoltDataUpdateRepository$apiService$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final BoltRequestAPIService invoke() {
            return BoltRequestAPIService.Factory.getAPIService();
        }
    });

    private final BoltRequestAPIService getApiService() {
        return (BoltRequestAPIService) this.apiService$delegate.getValue();
    }

    public final LiveData<BaseDataHolder<Object>> sendBoltConfigtRequest(String serialNo, String roData, boolean z) {
        Intrinsics.checkNotNullParameter(serialNo, "serialNo");
        Intrinsics.checkNotNullParameter(roData, "roData");
        LiveData<BaseDataHolder<Object>> fromPublisher = LiveDataReactiveStreams.fromPublisher(APIUtilKt.validateAndObserve(getApiService().sendUpdateRoStatusRequest(new BoltBLEUpdate(serialNo, roData, z))));
        Intrinsics.checkNotNullExpressionValue(fromPublisher, "fromPublisher(\n         …ateAndObserve()\n        )");
        return fromPublisher;
    }
}
