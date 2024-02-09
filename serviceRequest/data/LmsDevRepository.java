package com.livpure.safedrink.serviceRequest.data;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import com.livpure.safedrink.api.APIException;
import com.livpure.safedrink.api.APIUtilKt;
import com.livpure.safedrink.serviceRequest.api.LmsdevRequestAPIService;
import com.livpure.safedrink.serviceRequest.data.model.GetReferralRequest;
import com.livpure.safedrink.serviceRequest.data.model.GetReferralResponse;
import com.livpure.safedrink.serviceRequest.data.model.ResendVoucherRequest;
import com.livpure.safedrink.serviceRequest.data.model.ResendVoucherResponse;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: LmsDevRepository.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n2\u0006\u0010\f\u001a\u00020\rJ\u0016\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\n2\u0006\u0010\u0010\u001a\u00020\u0011R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/livpure/safedrink/serviceRequest/data/LmsDevRepository;", "", "()V", "apiService", "Lcom/livpure/safedrink/serviceRequest/api/LmsdevRequestAPIService;", "getApiService", "()Lcom/livpure/safedrink/serviceRequest/api/LmsdevRequestAPIService;", "apiService$delegate", "Lkotlin/Lazy;", "getReferralData", "Landroidx/lifecycle/LiveData;", "Lcom/livpure/safedrink/serviceRequest/data/model/GetReferralResponse;", "getReferralRequest", "Lcom/livpure/safedrink/serviceRequest/data/model/GetReferralRequest;", "resendVoucher", "Lcom/livpure/safedrink/serviceRequest/data/model/ResendVoucherResponse;", "resendVoucherRequest", "Lcom/livpure/safedrink/serviceRequest/data/model/ResendVoucherRequest;", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class LmsDevRepository {
    private final Lazy apiService$delegate = LazyKt.lazy(new Function0<LmsdevRequestAPIService>() { // from class: com.livpure.safedrink.serviceRequest.data.LmsDevRepository$apiService$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final LmsdevRequestAPIService invoke() {
            return LmsdevRequestAPIService.Factory.getServicerequestLmsdevAPIService();
        }
    });

    private final LmsdevRequestAPIService getApiService() {
        return (LmsdevRequestAPIService) this.apiService$delegate.getValue();
    }

    public final LiveData<GetReferralResponse> getReferralData(GetReferralRequest getReferralRequest) throws APIException {
        Intrinsics.checkNotNullParameter(getReferralRequest, "getReferralRequest");
        LiveData<GetReferralResponse> fromPublisher = LiveDataReactiveStreams.fromPublisher(APIUtilKt.observe(getApiService().getReferrals(getReferralRequest), new Function0<GetReferralResponse>() { // from class: com.livpure.safedrink.serviceRequest.data.LmsDevRepository$getReferralData$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final GetReferralResponse invoke() {
                return new GetReferralResponse(null, null, 1, null);
            }
        }));
        Intrinsics.checkNotNullExpressionValue(fromPublisher, "fromPublisher(\n         …lList = null) }\n        )");
        return fromPublisher;
    }

    public final LiveData<ResendVoucherResponse> resendVoucher(ResendVoucherRequest resendVoucherRequest) throws APIException {
        Intrinsics.checkNotNullParameter(resendVoucherRequest, "resendVoucherRequest");
        LiveData<ResendVoucherResponse> fromPublisher = LiveDataReactiveStreams.fromPublisher(APIUtilKt.observe(getApiService().getResendVoucher(resendVoucherRequest), new Function0<ResendVoucherResponse>() { // from class: com.livpure.safedrink.serviceRequest.data.LmsDevRepository$resendVoucher$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ResendVoucherResponse invoke() {
                return new ResendVoucherResponse(null, null, 3, null);
            }
        }));
        Intrinsics.checkNotNullExpressionValue(fromPublisher, "fromPublisher(\n         …herResponse() }\n        )");
        return fromPublisher;
    }
}
