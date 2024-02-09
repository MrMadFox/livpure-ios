package com.livpure.safedrink.serviceRequest.api;

import com.facebook.share.internal.ShareConstants;
import com.livpure.safedrink.api.APILmsdevService;
import com.livpure.safedrink.serviceRequest.data.model.GetReferralRequest;
import com.livpure.safedrink.serviceRequest.data.model.GetReferralResponse;
import com.livpure.safedrink.serviceRequest.data.model.ResendVoucherRequest;
import com.livpure.safedrink.serviceRequest.data.model.ResendVoucherResponse;
import io.reactivex.Flowable;
import kotlin.Metadata;
import retrofit2.http.Body;
import retrofit2.http.POST;
/* compiled from: LmsdevRequestAPIService.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \n2\u00020\u0001:\u0001\nJ\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H'J\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\tH'¨\u0006\u000b"}, d2 = {"Lcom/livpure/safedrink/serviceRequest/api/LmsdevRequestAPIService;", "", "getReferrals", "Lio/reactivex/Flowable;", "Lcom/livpure/safedrink/serviceRequest/data/model/GetReferralResponse;", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/livpure/safedrink/serviceRequest/data/model/GetReferralRequest;", "getResendVoucher", "Lcom/livpure/safedrink/serviceRequest/data/model/ResendVoucherResponse;", "Lcom/livpure/safedrink/serviceRequest/data/model/ResendVoucherRequest;", "Factory", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface LmsdevRequestAPIService {
    public static final Factory Factory = Factory.$$INSTANCE;

    @POST("index.php?func=getreferrals")
    Flowable<GetReferralResponse> getReferrals(@Body GetReferralRequest getReferralRequest);

    @POST("index.php?func=resendvoucher")
    Flowable<ResendVoucherResponse> getResendVoucher(@Body ResendVoucherRequest resendVoucherRequest);

    /* compiled from: LmsdevRequestAPIService.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/livpure/safedrink/serviceRequest/api/LmsdevRequestAPIService$Factory;", "Lcom/livpure/safedrink/api/APILmsdevService;", "()V", "getServicerequestLmsdevAPIService", "Lcom/livpure/safedrink/serviceRequest/api/LmsdevRequestAPIService;", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Factory extends APILmsdevService {
        static final /* synthetic */ Factory $$INSTANCE = new Factory();

        private Factory() {
            super(null, 1, null);
        }

        public final LmsdevRequestAPIService getServicerequestLmsdevAPIService() {
            return (LmsdevRequestAPIService) new APILmsdevService.APIInterfaceFactory(this, LmsdevRequestAPIService.class).getAPIInterface();
        }
    }
}
