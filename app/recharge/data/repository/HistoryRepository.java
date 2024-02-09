package com.livpure.safedrink.app.recharge.data.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import com.livpure.safedrink.api.APIException;
import com.livpure.safedrink.api.APIUtilKt;
import com.livpure.safedrink.app.LSApplication;
import com.livpure.safedrink.app.recharge.data.api.HistoryAPIService;
import com.livpure.safedrink.app.recharge.model.HistoryResponse;
import com.livpure.safedrink.login.data.models.User;
import com.livpure.safedrink.subscription.plan.data.model.SubscriptionRequest;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: HistoryRepository.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nR\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"Lcom/livpure/safedrink/app/recharge/data/repository/HistoryRepository;", "", "()V", "historyAPIService", "Lcom/livpure/safedrink/app/recharge/data/api/HistoryAPIService;", "getHistoryAPIService", "()Lcom/livpure/safedrink/app/recharge/data/api/HistoryAPIService;", "historyAPIService$delegate", "Lkotlin/Lazy;", "getRechargeHistory", "Landroidx/lifecycle/LiveData;", "Lcom/livpure/safedrink/app/recharge/model/HistoryResponse;", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class HistoryRepository {
    private final Lazy historyAPIService$delegate = LazyKt.lazy(new Function0<HistoryAPIService>() { // from class: com.livpure.safedrink.app.recharge.data.repository.HistoryRepository$historyAPIService$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final HistoryAPIService invoke() {
            return HistoryAPIService.Factory.getAPIService();
        }
    });

    private final HistoryAPIService getHistoryAPIService() {
        return (HistoryAPIService) this.historyAPIService$delegate.getValue();
    }

    public final LiveData<HistoryResponse> getRechargeHistory() throws APIException {
        String str;
        if (LSApplication.Companion.getUser() != null) {
            User user = LSApplication.Companion.getUser();
            Intrinsics.checkNotNull(user);
            str = user.getId();
        } else {
            str = "";
        }
        LiveData<HistoryResponse> fromPublisher = LiveDataReactiveStreams.fromPublisher(APIUtilKt.observe(getHistoryAPIService().getRechargeHistory(new SubscriptionRequest(str, "")), new Function0<HistoryResponse>() { // from class: com.livpure.safedrink.app.recharge.data.repository.HistoryRepository$getRechargeHistory$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final HistoryResponse invoke() {
                return new HistoryResponse(null);
            }
        }));
        Intrinsics.checkNotNullExpressionValue(fromPublisher, "fromPublisher(\n         …esponse(null) }\n        )");
        return fromPublisher;
    }
}
