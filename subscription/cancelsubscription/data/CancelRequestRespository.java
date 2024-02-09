package com.livpure.safedrink.subscription.cancelsubscription.data;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import com.livpure.safedrink.api.APIUtilKt;
import com.livpure.safedrink.api.BaseDataHolder;
import com.livpure.safedrink.app.LSApplication;
import com.livpure.safedrink.login.data.models.User;
import com.livpure.safedrink.subscription.cancelsubscription.api.CancelAPIService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: CancelRequestRespository.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\t\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000b0\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rR\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/livpure/safedrink/subscription/cancelsubscription/data/CancelRequestRespository;", "", "()V", "apiService", "Lcom/livpure/safedrink/subscription/cancelsubscription/api/CancelAPIService;", "getApiService", "()Lcom/livpure/safedrink/subscription/cancelsubscription/api/CancelAPIService;", "apiService$delegate", "Lkotlin/Lazy;", "cancelService", "Landroidx/lifecycle/LiveData;", "Lcom/livpure/safedrink/api/BaseDataHolder;", "cancellationReason", "", "otherreason", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CancelRequestRespository {
    private final Lazy apiService$delegate = LazyKt.lazy(new Function0<CancelAPIService>() { // from class: com.livpure.safedrink.subscription.cancelsubscription.data.CancelRequestRespository$apiService$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final CancelAPIService invoke() {
            return CancelAPIService.Factory.getCancelServiceAPIService();
        }
    });

    private final CancelAPIService getApiService() {
        return (CancelAPIService) this.apiService$delegate.getValue();
    }

    public final LiveData<BaseDataHolder<Object>> cancelService(String cancellationReason, String otherreason) {
        Intrinsics.checkNotNullParameter(cancellationReason, "cancellationReason");
        Intrinsics.checkNotNullParameter(otherreason, "otherreason");
        CancelAPIService apiService = getApiService();
        User user = LSApplication.Companion.getUser();
        Intrinsics.checkNotNull(user);
        String id = user.getId();
        User user2 = LSApplication.Companion.getUser();
        String email = user2 != null ? user2.getEmail() : null;
        Intrinsics.checkNotNull(email);
        User user3 = LSApplication.Companion.getUser();
        String mobile = user3 != null ? user3.getMobile() : null;
        Intrinsics.checkNotNull(mobile);
        User user4 = LSApplication.Companion.getUser();
        String name = user4 != null ? user4.getName() : null;
        Intrinsics.checkNotNull(name);
        LiveData<BaseDataHolder<Object>> fromPublisher = LiveDataReactiveStreams.fromPublisher(APIUtilKt.validateAndObserve(apiService.cancelService(new CancelRequest(id, email, mobile, name, cancellationReason, otherreason))));
        Intrinsics.checkNotNullExpressionValue(fromPublisher, "fromPublisher(\n         …ateAndObserve()\n        )");
        return fromPublisher;
    }
}
