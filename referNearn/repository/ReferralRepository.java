package com.livpure.safedrink.referNearn.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import com.livpure.safedrink.api.APIUtilKt;
import com.livpure.safedrink.api.BaseDataHolder;
import com.livpure.safedrink.referNearn.api.ReferralAPIService;
import com.livpure.safedrink.referNearn.model.ReferralRequest;
import com.livpure.safedrink.referNearn.model.leadershipBoard;
import com.livpure.safedrink.referNearn.model.referralHistory;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ReferralRepository.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\t\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b0\n2\u0006\u0010\r\u001a\u00020\u000eJ\u001c\u0010\u000f\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000b0\n2\u0006\u0010\r\u001a\u00020\u000eR\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/livpure/safedrink/referNearn/repository/ReferralRepository;", "", "()V", "apiService", "Lcom/livpure/safedrink/referNearn/api/ReferralAPIService;", "getApiService", "()Lcom/livpure/safedrink/referNearn/api/ReferralAPIService;", "apiService$delegate", "Lkotlin/Lazy;", "getLeadershipBoard", "Landroidx/lifecycle/LiveData;", "Lcom/livpure/safedrink/api/BaseDataHolder;", "Lcom/livpure/safedrink/referNearn/model/leadershipBoard;", "referralRequest", "Lcom/livpure/safedrink/referNearn/model/ReferralRequest;", "getReferralHistory", "Lcom/livpure/safedrink/referNearn/model/referralHistory;", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ReferralRepository {
    private final Lazy apiService$delegate = LazyKt.lazy(new Function0<ReferralAPIService>() { // from class: com.livpure.safedrink.referNearn.repository.ReferralRepository$apiService$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ReferralAPIService invoke() {
            return ReferralAPIService.Factory.getReferralAPIInterface();
        }
    });

    private final ReferralAPIService getApiService() {
        return (ReferralAPIService) this.apiService$delegate.getValue();
    }

    public final LiveData<BaseDataHolder<referralHistory>> getReferralHistory(ReferralRequest referralRequest) {
        Intrinsics.checkNotNullParameter(referralRequest, "referralRequest");
        LiveData<BaseDataHolder<referralHistory>> fromPublisher = LiveDataReactiveStreams.fromPublisher(APIUtilKt.validateAndObserve(getApiService().getReferralHistory(referralRequest)));
        Intrinsics.checkNotNullExpressionValue(fromPublisher, "fromPublisher(\n         …ateAndObserve()\n        )");
        return fromPublisher;
    }

    public final LiveData<BaseDataHolder<leadershipBoard>> getLeadershipBoard(ReferralRequest referralRequest) {
        Intrinsics.checkNotNullParameter(referralRequest, "referralRequest");
        LiveData<BaseDataHolder<leadershipBoard>> fromPublisher = LiveDataReactiveStreams.fromPublisher(APIUtilKt.validateAndObserve(getApiService().getLeadershipBoard(referralRequest)));
        Intrinsics.checkNotNullExpressionValue(fromPublisher, "fromPublisher(\n         …ateAndObserve()\n        )");
        return fromPublisher;
    }
}
