package com.livpure.safedrink.app.recharge.data.api;

import com.facebook.share.internal.ShareConstants;
import com.livpure.safedrink.api.APIService;
import com.livpure.safedrink.app.recharge.model.HistoryResponse;
import com.livpure.safedrink.subscription.plan.data.model.SubscriptionRequest;
import io.reactivex.Flowable;
import kotlin.Metadata;
import retrofit2.http.Body;
import retrofit2.http.POST;
/* compiled from: HistoryAPIService.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007J\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H'¨\u0006\b"}, d2 = {"Lcom/livpure/safedrink/app/recharge/data/api/HistoryAPIService;", "", "getRechargeHistory", "Lio/reactivex/Flowable;", "Lcom/livpure/safedrink/app/recharge/model/HistoryResponse;", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/livpure/safedrink/subscription/plan/data/model/SubscriptionRequest;", "Factory", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface HistoryAPIService {
    public static final Factory Factory = Factory.$$INSTANCE;

    @POST("getRechargeHistory")
    Flowable<HistoryResponse> getRechargeHistory(@Body SubscriptionRequest subscriptionRequest);

    /* compiled from: HistoryAPIService.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/livpure/safedrink/app/recharge/data/api/HistoryAPIService$Factory;", "Lcom/livpure/safedrink/api/APIService;", "()V", "getAPIService", "Lcom/livpure/safedrink/app/recharge/data/api/HistoryAPIService;", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Factory extends APIService {
        static final /* synthetic */ Factory $$INSTANCE = new Factory();

        private Factory() {
            super(null, 1, null);
        }

        public final HistoryAPIService getAPIService() {
            return (HistoryAPIService) new APIService.APIInterfaceFactory(this, HistoryAPIService.class).getAPIInterface();
        }
    }
}
