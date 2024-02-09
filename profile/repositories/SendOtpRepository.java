package com.livpure.safedrink.profile.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import com.livpure.safedrink.api.APIUtilKt;
import com.livpure.safedrink.login.api.UserAPIService;
import com.livpure.safedrink.profile.api.models.request.SendProfileUpdateOtpRequest;
import com.livpure.safedrink.profile.api.models.request.VerifyProfileOtpRequest;
import com.livpure.safedrink.profile.api.models.response.UpdateProfileResponse;
import com.livpure.safedrink.profile.api.models.response.VerifyProfileResponse;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SendOtpRepository.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rJ,\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rR\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/livpure/safedrink/profile/repositories/SendOtpRepository;", "", "()V", "userAPIService", "Lcom/livpure/safedrink/login/api/UserAPIService;", "getUserAPIService", "()Lcom/livpure/safedrink/login/api/UserAPIService;", "userAPIService$delegate", "Lkotlin/Lazy;", "sendProfileOtp", "Landroidx/lifecycle/LiveData;", "Lcom/livpure/safedrink/profile/api/models/response/UpdateProfileResponse;", "emailId", "", "mobileNo", "deviceAppUID", "verifyProfileOtp", "Lcom/livpure/safedrink/profile/api/models/response/VerifyProfileResponse;", "otp", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SendOtpRepository {
    private final Lazy userAPIService$delegate = LazyKt.lazy(new Function0<UserAPIService>() { // from class: com.livpure.safedrink.profile.repositories.SendOtpRepository$userAPIService$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final UserAPIService invoke() {
            return UserAPIService.Factory.getAuthAPIInterface();
        }
    });

    private final UserAPIService getUserAPIService() {
        return (UserAPIService) this.userAPIService$delegate.getValue();
    }

    public final LiveData<UpdateProfileResponse> sendProfileOtp(String emailId, String mobileNo, String deviceAppUID) {
        Intrinsics.checkNotNullParameter(emailId, "emailId");
        Intrinsics.checkNotNullParameter(mobileNo, "mobileNo");
        Intrinsics.checkNotNullParameter(deviceAppUID, "deviceAppUID");
        LiveData<UpdateProfileResponse> fromPublisher = LiveDataReactiveStreams.fromPublisher(APIUtilKt.observe(getUserAPIService().sendProfileOtp(new SendProfileUpdateOtpRequest(mobileNo, emailId, deviceAppUID)), new Function0<UpdateProfileResponse>() { // from class: com.livpure.safedrink.profile.repositories.SendOtpRepository$sendProfileOtp$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final UpdateProfileResponse invoke() {
                return new UpdateProfileResponse(null, 1, null);
            }
        }));
        Intrinsics.checkNotNullExpressionValue(fromPublisher, "fromPublisher(\n         …ileResponse() }\n        )");
        return fromPublisher;
    }

    public final LiveData<VerifyProfileResponse> verifyProfileOtp(String emailId, String mobileNo, String otp, String deviceAppUID) {
        Intrinsics.checkNotNullParameter(emailId, "emailId");
        Intrinsics.checkNotNullParameter(mobileNo, "mobileNo");
        Intrinsics.checkNotNullParameter(otp, "otp");
        Intrinsics.checkNotNullParameter(deviceAppUID, "deviceAppUID");
        LiveData<VerifyProfileResponse> fromPublisher = LiveDataReactiveStreams.fromPublisher(APIUtilKt.observe(getUserAPIService().verifyProfileOtp(new VerifyProfileOtpRequest(mobileNo, emailId, otp, deviceAppUID)), new Function0<VerifyProfileResponse>() { // from class: com.livpure.safedrink.profile.repositories.SendOtpRepository$verifyProfileOtp$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final VerifyProfileResponse invoke() {
                return new VerifyProfileResponse(null, 1, null);
            }
        }));
        Intrinsics.checkNotNullExpressionValue(fromPublisher, "fromPublisher(\n         …ileResponse() }\n        )");
        return fromPublisher;
    }
}
