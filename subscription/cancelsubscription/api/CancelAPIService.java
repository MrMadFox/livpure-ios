package com.livpure.safedrink.subscription.cancelsubscription.api;

import com.facebook.share.internal.ShareConstants;
import com.livpure.safedrink.api.APIService;
import com.livpure.safedrink.api.BaseDataHolder;
import com.livpure.safedrink.subscription.cancelsubscription.data.CancelRequest;
import io.reactivex.Flowable;
import kotlin.Metadata;
import retrofit2.http.Body;
import retrofit2.http.POST;
/* compiled from: CancelAPIService.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007J \u0010\u0002\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H'¨\u0006\b"}, d2 = {"Lcom/livpure/safedrink/subscription/cancelsubscription/api/CancelAPIService;", "", "cancelService", "Lio/reactivex/Flowable;", "Lcom/livpure/safedrink/api/BaseDataHolder;", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/livpure/safedrink/subscription/cancelsubscription/data/CancelRequest;", "Factory", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface CancelAPIService {
    public static final Factory Factory = Factory.$$INSTANCE;

    @POST("/payment/intimateToAdminTeam")
    Flowable<BaseDataHolder<Object>> cancelService(@Body CancelRequest cancelRequest);

    /* compiled from: CancelAPIService.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/livpure/safedrink/subscription/cancelsubscription/api/CancelAPIService$Factory;", "Lcom/livpure/safedrink/api/APIService;", "()V", "getCancelServiceAPIService", "Lcom/livpure/safedrink/subscription/cancelsubscription/api/CancelAPIService;", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Factory extends APIService {
        static final /* synthetic */ Factory $$INSTANCE = new Factory();

        private Factory() {
            super(null, 1, null);
        }

        public final CancelAPIService getCancelServiceAPIService() {
            return (CancelAPIService) new APIService.APIInterfaceFactory(this, CancelAPIService.class).getAPIInterface();
        }
    }
}
