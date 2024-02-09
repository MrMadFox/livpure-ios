package com.livpure.safedrink.referNearn.api;

import com.facebook.share.internal.ShareConstants;
import com.livpure.safedrink.api.APIService;
import com.livpure.safedrink.api.BaseDataHolder;
import com.livpure.safedrink.referNearn.model.ReferralRequest;
import com.livpure.safedrink.referNearn.model.leadershipBoard;
import com.livpure.safedrink.referNearn.model.referralHistory;
import io.reactivex.Flowable;
import kotlin.Metadata;
import retrofit2.http.Body;
import retrofit2.http.POST;
/* compiled from: ReferralAPIService.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \n2\u00020\u0001:\u0001\nJ \u0010\u0002\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0007H'J \u0010\b\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0007H'¨\u0006\u000b"}, d2 = {"Lcom/livpure/safedrink/referNearn/api/ReferralAPIService;", "", "getLeadershipBoard", "Lio/reactivex/Flowable;", "Lcom/livpure/safedrink/api/BaseDataHolder;", "Lcom/livpure/safedrink/referNearn/model/leadershipBoard;", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/livpure/safedrink/referNearn/model/ReferralRequest;", "getReferralHistory", "Lcom/livpure/safedrink/referNearn/model/referralHistory;", "Factory", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface ReferralAPIService {
    public static final Factory Factory = Factory.$$INSTANCE;

    @POST("/v3/leadershipBoard")
    Flowable<BaseDataHolder<leadershipBoard>> getLeadershipBoard(@Body ReferralRequest referralRequest);

    @POST("/v3/referralHistory")
    Flowable<BaseDataHolder<referralHistory>> getReferralHistory(@Body ReferralRequest referralRequest);

    /* compiled from: ReferralAPIService.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/livpure/safedrink/referNearn/api/ReferralAPIService$Factory;", "Lcom/livpure/safedrink/api/APIService;", "()V", "getReferralAPIInterface", "Lcom/livpure/safedrink/referNearn/api/ReferralAPIService;", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Factory extends APIService {
        static final /* synthetic */ Factory $$INSTANCE = new Factory();

        private Factory() {
            super(null, 1, null);
        }

        public final ReferralAPIService getReferralAPIInterface() {
            return (ReferralAPIService) new APIService.APIInterfaceFactory(this, ReferralAPIService.class).getAPIInterface();
        }
    }
}
