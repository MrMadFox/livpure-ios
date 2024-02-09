package com.livpure.safedrink.login.api;

import com.facebook.share.internal.ShareConstants;
import com.livpure.safedrink.api.APIService;
import com.livpure.safedrink.api.BaseDataHolder;
import com.livpure.safedrink.login.api.models.request.AuthenticationRequest;
import com.livpure.safedrink.login.api.models.request.DeviceDetailsRequest;
import com.livpure.safedrink.login.api.models.request.ForgotPasswordRequest;
import com.livpure.safedrink.login.api.models.request.ReferralCodeRequest;
import com.livpure.safedrink.login.api.models.request.RegistrationRequest;
import com.livpure.safedrink.login.api.models.request.ResetPasswordRequest;
import com.livpure.safedrink.login.api.models.request.UserDetailsRequest;
import com.livpure.safedrink.login.api.models.request.UserReferralRequest;
import com.livpure.safedrink.login.api.models.response.BaseV1ResponseImplementation;
import com.livpure.safedrink.login.api.models.response.ReferralLinkResponse;
import com.livpure.safedrink.login.api.models.response.UserDetailsResponse;
import com.livpure.safedrink.login.data.models.User;
import com.livpure.safedrink.profile.api.models.request.SendProfileUpdateOtpRequest;
import com.livpure.safedrink.profile.api.models.request.VerifyProfileOtpRequest;
import com.livpure.safedrink.profile.api.models.response.UpdateProfileResponse;
import com.livpure.safedrink.profile.api.models.response.VerifyProfileResponse;
import io.reactivex.Flowable;
import kotlin.Metadata;
import retrofit2.http.Body;
import retrofit2.http.POST;
/* compiled from: UserAPIService.kt */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fJ\u001e\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0007H'J\u0018\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\b\b\u0001\u0010\u0006\u001a\u00020\nH'J\u0018\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00032\b\b\u0001\u0010\u0006\u001a\u00020\rH'J\u0018\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0010H'J\u001e\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0012H'J\u0018\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0014H'J\u0018\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0017H'J \u0010\u0018\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0019H'J\u0018\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u001bH'J\u0018\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u001eH'¨\u0006 "}, d2 = {"Lcom/livpure/safedrink/login/api/UserAPIService;", "", "authenticate", "Lio/reactivex/Flowable;", "Lcom/livpure/safedrink/api/BaseDataHolder;", "Lcom/livpure/safedrink/login/data/models/User;", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/livpure/safedrink/login/api/models/request/AuthenticationRequest;", "forgotPassword", "Lcom/livpure/safedrink/login/api/models/response/BaseV1ResponseImplementation;", "Lcom/livpure/safedrink/login/api/models/request/ForgotPasswordRequest;", "getReferralLink", "Lcom/livpure/safedrink/login/api/models/response/ReferralLinkResponse;", "Lcom/livpure/safedrink/login/api/models/request/UserReferralRequest;", "getUserDetails", "Lcom/livpure/safedrink/login/api/models/response/UserDetailsResponse;", "Lcom/livpure/safedrink/login/api/models/request/UserDetailsRequest;", "registerUser", "Lcom/livpure/safedrink/login/api/models/request/RegistrationRequest;", "resetPassword", "Lcom/livpure/safedrink/login/api/models/request/ResetPasswordRequest;", "sendProfileOtp", "Lcom/livpure/safedrink/profile/api/models/response/UpdateProfileResponse;", "Lcom/livpure/safedrink/profile/api/models/request/SendProfileUpdateOtpRequest;", "updateDeviceId", "Lcom/livpure/safedrink/login/api/models/request/DeviceDetailsRequest;", "validateReferralCode", "Lcom/livpure/safedrink/login/api/models/request/ReferralCodeRequest;", "verifyProfileOtp", "Lcom/livpure/safedrink/profile/api/models/response/VerifyProfileResponse;", "Lcom/livpure/safedrink/profile/api/models/request/VerifyProfileOtpRequest;", "Factory", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface UserAPIService {
    public static final Factory Factory = Factory.$$INSTANCE;

    @POST("/v2/authenticate")
    Flowable<BaseDataHolder<User>> authenticate(@Body AuthenticationRequest authenticationRequest);

    @POST("/forgotPassword")
    Flowable<BaseV1ResponseImplementation> forgotPassword(@Body ForgotPasswordRequest forgotPasswordRequest);

    @POST("/v3/getReferralShortLink")
    Flowable<ReferralLinkResponse> getReferralLink(@Body UserReferralRequest userReferralRequest);

    @POST("/getUserDetailsWeb")
    Flowable<UserDetailsResponse> getUserDetails(@Body UserDetailsRequest userDetailsRequest);

    @POST("/v2/register")
    Flowable<BaseDataHolder<User>> registerUser(@Body RegistrationRequest registrationRequest);

    @POST("/getOtpVerify")
    Flowable<BaseV1ResponseImplementation> resetPassword(@Body ResetPasswordRequest resetPasswordRequest);

    @POST("/v4/sendProfileUpdateOtp")
    Flowable<UpdateProfileResponse> sendProfileOtp(@Body SendProfileUpdateOtpRequest sendProfileUpdateOtpRequest);

    @POST("/v2/updateDeviceId")
    Flowable<BaseDataHolder<Object>> updateDeviceId(@Body DeviceDetailsRequest deviceDetailsRequest);

    @POST("/validateReferralCode")
    Flowable<BaseV1ResponseImplementation> validateReferralCode(@Body ReferralCodeRequest referralCodeRequest);

    @POST("/v4/verifyProfileUpdateOtp")
    Flowable<VerifyProfileResponse> verifyProfileOtp(@Body VerifyProfileOtpRequest verifyProfileOtpRequest);

    /* compiled from: UserAPIService.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/livpure/safedrink/login/api/UserAPIService$Factory;", "Lcom/livpure/safedrink/api/APIService;", "()V", "getAuthAPIInterface", "Lcom/livpure/safedrink/login/api/UserAPIService;", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Factory extends APIService {
        static final /* synthetic */ Factory $$INSTANCE = new Factory();

        private Factory() {
            super(null, 1, null);
        }

        public final UserAPIService getAuthAPIInterface() {
            return (UserAPIService) new APIService.APIInterfaceFactory(this, UserAPIService.class).getAPIInterface();
        }
    }
}
