package com.livpure.safedrink.login.repositories;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import androidx.lifecycle.MutableLiveData;
import com.amplitude.api.Constants;
import com.livpure.safedrink.api.APIException;
import com.livpure.safedrink.api.APIUtilKt;
import com.livpure.safedrink.api.BaseDataHolder;
import com.livpure.safedrink.app.LSApplication;
import com.livpure.safedrink.common.arc.SingletonHolder;
import com.livpure.safedrink.login.api.UserAPIService;
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
import com.livpure.safedrink.segment.SegmentIdentityManager;
import com.livpure.safedrink.segment.SegmentProperties;
import com.moengage.core.internal.storage.database.contract.DeprecatedContractsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* compiled from: UserRepository.kt */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 82\u00020\u0001:\u000278B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J*\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00190\u00182\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001bJ\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00070\u0018J\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u00182\u0006\u0010!\u001a\u00020\u001bJ\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u00182\u0006\u0010$\u001a\u00020\u001bJ\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u00182\u0006\u0010!\u001a\u00020\u001bJ\u0006\u0010'\u001a\u00020(J\u0006\u0010)\u001a\u00020*JJ\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00190\u00182\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010.\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001b2\u0006\u0010/\u001a\u00020\u001bJ$\u00100\u001a\b\u0012\u0004\u0012\u00020 0\u00182\u0006\u0010!\u001a\u00020\u001b2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u001bJ$\u00104\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00190\u00182\u0006\u0010$\u001a\u00020\u001b2\u0006\u00105\u001a\u00020\u001bJ\u0014\u00106\u001a\b\u0012\u0004\u0012\u00020 0\u00182\u0006\u0010.\u001a\u00020\u001bR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014¨\u00069"}, d2 = {"Lcom/livpure/safedrink/login/repositories/UserRepository;", "", DeprecatedContractsKt.INAPP_V2_MSG_CONTEXT, "Landroid/content/Context;", "(Landroid/content/Context;)V", "authenticationState", "Landroidx/lifecycle/MutableLiveData;", "Lcom/livpure/safedrink/login/repositories/UserRepository$AuthenticationState;", "prefs", "Landroid/content/SharedPreferences;", "value", "Lcom/livpure/safedrink/login/data/models/User;", "user", "getUser", "()Lcom/livpure/safedrink/login/data/models/User;", "setUser", "(Lcom/livpure/safedrink/login/data/models/User;)V", "userAPIService", "Lcom/livpure/safedrink/login/api/UserAPIService;", "getUserAPIService", "()Lcom/livpure/safedrink/login/api/UserAPIService;", "userAPIService$delegate", "Lkotlin/Lazy;", "authenticate", "Landroidx/lifecycle/LiveData;", "Lcom/livpure/safedrink/api/BaseDataHolder;", "userName", "", "password", "deviceAppUID", "checkAuthentication", "forgotPassword", "Lcom/livpure/safedrink/login/api/models/response/BaseV1ResponseImplementation;", "username", "getReferralLink", "Lcom/livpure/safedrink/login/api/models/response/ReferralLinkResponse;", SegmentProperties.USER_ID, "getUserDetails", "Lcom/livpure/safedrink/login/api/models/response/UserDetailsResponse;", "isUserLoggedIn", "", "logout", "", "register", "email", "phone", "referralCode", "city", "resetPassword", "otp", "", "newPassword", "uploadDeviceID", "deviceId", "validateReferralCode", "AuthenticationState", "Companion", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class UserRepository {
    public static final Companion Companion = new Companion(null);
    private static final String KEY_ADDRESS = "address";
    private static final String KEY_APPLICABLE_DISCOUNT = "applicable_discount";
    private static final String KEY_AREA = "area";
    private static final String KEY_AUTH_TOKEN = "auth_token";
    private static final String KEY_CANCELLED_DATE = "cancelled_date";
    private static final String KEY_CITY = "city";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_HUB_CODE = "hub_code";
    private static final String KEY_IS_CANCELLED = "is_cancelled";
    private static final String KEY_KYC_STATUS = "kyc_status";
    private static final String KEY_NAME = "name";
    private static final String KEY_PAYMENT_STATUS = "payment_status";
    private static final String KEY_PHONE = "phone";
    private static final String KEY_PIN_CODE = "pin_code";
    private static final String KEY_PLAN_ID = "plan_id";
    private static final String KEY_PLAN_NAME = "plan_name";
    private static final String KEY_REFERRAL_CODE = "referral_code";
    private static final String KEY_STATE = "state";
    private static final String KEY_USER_ID = "user_id";
    private static final String KEY_USER_LOGGED_IN = "is_logged_in";
    private final MutableLiveData<AuthenticationState> authenticationState;
    private final Context context;
    private final SharedPreferences prefs;
    private final Lazy userAPIService$delegate;

    /* compiled from: UserRepository.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/livpure/safedrink/login/repositories/UserRepository$AuthenticationState;", "", "(Ljava/lang/String;I)V", "USER_AUTHENTICATED", "USER_NOT_AUTHENTICATED", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public enum AuthenticationState {
        USER_AUTHENTICATED,
        USER_NOT_AUTHENTICATED
    }

    public /* synthetic */ UserRepository(Context context, DefaultConstructorMarker defaultConstructorMarker) {
        this(context);
    }

    private UserRepository(Context context) {
        this.context = context;
        this.userAPIService$delegate = LazyKt.lazy(new Function0<UserAPIService>() { // from class: com.livpure.safedrink.login.repositories.UserRepository$userAPIService$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final UserAPIService invoke() {
                return UserAPIService.Factory.getAuthAPIInterface();
            }
        });
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences("AndroidLivpureSmart", 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.applicationConte…t\", Context.MODE_PRIVATE)");
        this.prefs = sharedPreferences;
        MutableLiveData<AuthenticationState> mutableLiveData = new MutableLiveData<>();
        this.authenticationState = mutableLiveData;
        mutableLiveData.setValue(getUser() != null ? AuthenticationState.USER_AUTHENTICATED : AuthenticationState.USER_NOT_AUTHENTICATED);
    }

    private final UserAPIService getUserAPIService() {
        return (UserAPIService) this.userAPIService$delegate.getValue();
    }

    public final LiveData<AuthenticationState> checkAuthentication() {
        return this.authenticationState;
    }

    public final LiveData<BaseDataHolder<User>> authenticate(String userName, String password, String deviceAppUID) {
        Intrinsics.checkNotNullParameter(userName, "userName");
        Intrinsics.checkNotNullParameter(password, "password");
        Intrinsics.checkNotNullParameter(deviceAppUID, "deviceAppUID");
        LiveData<BaseDataHolder<User>> fromPublisher = LiveDataReactiveStreams.fromPublisher(APIUtilKt.validateAndObserve(getUserAPIService().authenticate(new AuthenticationRequest(userName, password, deviceAppUID))));
        Intrinsics.checkNotNullExpressionValue(fromPublisher, "fromPublisher(\n         …ateAndObserve()\n        )");
        return fromPublisher;
    }

    public final LiveData<BaseDataHolder<Object>> uploadDeviceID(String userID, String deviceId) {
        Intrinsics.checkNotNullParameter(userID, "userID");
        Intrinsics.checkNotNullParameter(deviceId, "deviceId");
        LiveData<BaseDataHolder<Object>> fromPublisher = LiveDataReactiveStreams.fromPublisher(APIUtilKt.validateAndObserve(getUserAPIService().updateDeviceId(new DeviceDetailsRequest(userID, deviceId))));
        Intrinsics.checkNotNullExpressionValue(fromPublisher, "fromPublisher(\n         …ateAndObserve()\n        )");
        return fromPublisher;
    }

    public final LiveData<BaseV1ResponseImplementation> forgotPassword(String username) throws APIException {
        Intrinsics.checkNotNullParameter(username, "username");
        LiveData<BaseV1ResponseImplementation> fromPublisher = LiveDataReactiveStreams.fromPublisher(APIUtilKt.observe(getUserAPIService().forgotPassword(new ForgotPasswordRequest(username)), new Function0<BaseV1ResponseImplementation>() { // from class: com.livpure.safedrink.login.repositories.UserRepository$forgotPassword$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final BaseV1ResponseImplementation invoke() {
                return new BaseV1ResponseImplementation(null);
            }
        }));
        Intrinsics.checkNotNullExpressionValue(fromPublisher, "fromPublisher(\n         …(data = null) }\n        )");
        return fromPublisher;
    }

    public final LiveData<BaseV1ResponseImplementation> resetPassword(String username, int i, String newPassword) throws APIException {
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(newPassword, "newPassword");
        LiveData<BaseV1ResponseImplementation> fromPublisher = LiveDataReactiveStreams.fromPublisher(APIUtilKt.observe(getUserAPIService().resetPassword(new ResetPasswordRequest(username, i, newPassword)), new Function0<BaseV1ResponseImplementation>() { // from class: com.livpure.safedrink.login.repositories.UserRepository$resetPassword$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final BaseV1ResponseImplementation invoke() {
                return new BaseV1ResponseImplementation(null);
            }
        }));
        Intrinsics.checkNotNullExpressionValue(fromPublisher, "fromPublisher(\n         …n(data = null)}\n        )");
        return fromPublisher;
    }

    public final LiveData<BaseV1ResponseImplementation> validateReferralCode(String referralCode) throws APIException {
        Intrinsics.checkNotNullParameter(referralCode, "referralCode");
        LiveData<BaseV1ResponseImplementation> fromPublisher = LiveDataReactiveStreams.fromPublisher(APIUtilKt.observe(getUserAPIService().validateReferralCode(new ReferralCodeRequest(referralCode)), new Function0<BaseV1ResponseImplementation>() { // from class: com.livpure.safedrink.login.repositories.UserRepository$validateReferralCode$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final BaseV1ResponseImplementation invoke() {
                return new BaseV1ResponseImplementation(null);
            }
        }));
        Intrinsics.checkNotNullExpressionValue(fromPublisher, "fromPublisher (\n        …n(data = null)}\n        )");
        return fromPublisher;
    }

    public final LiveData<UserDetailsResponse> getUserDetails(String username) throws APIException {
        Intrinsics.checkNotNullParameter(username, "username");
        LiveData<UserDetailsResponse> fromPublisher = LiveDataReactiveStreams.fromPublisher(APIUtilKt.observe(getUserAPIService().getUserDetails(new UserDetailsRequest(username)), new Function0<UserDetailsResponse>() { // from class: com.livpure.safedrink.login.repositories.UserRepository$getUserDetails$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final UserDetailsResponse invoke() {
                return new UserDetailsResponse(null);
            }
        }));
        Intrinsics.checkNotNullExpressionValue(fromPublisher, "fromPublisher(\n         …lsList = null)}\n        )");
        return fromPublisher;
    }

    public final LiveData<ReferralLinkResponse> getReferralLink(String userID) throws APIException {
        Intrinsics.checkNotNullParameter(userID, "userID");
        LiveData<ReferralLinkResponse> fromPublisher = LiveDataReactiveStreams.fromPublisher(APIUtilKt.observe(getUserAPIService().getReferralLink(new UserReferralRequest(userID)), new Function0<ReferralLinkResponse>() { // from class: com.livpure.safedrink.login.repositories.UserRepository$getReferralLink$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ReferralLinkResponse invoke() {
                return new ReferralLinkResponse(null, null, 2, null);
            }
        }));
        Intrinsics.checkNotNullExpressionValue(fromPublisher, "fromPublisher(\n         …e(data = null)}\n        )");
        return fromPublisher;
    }

    public final LiveData<BaseDataHolder<User>> register(String userName, String email, String phone, String password, String referralCode, String deviceAppUID, String city) {
        Intrinsics.checkNotNullParameter(userName, "userName");
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(phone, "phone");
        Intrinsics.checkNotNullParameter(password, "password");
        Intrinsics.checkNotNullParameter(referralCode, "referralCode");
        Intrinsics.checkNotNullParameter(deviceAppUID, "deviceAppUID");
        Intrinsics.checkNotNullParameter(city, "city");
        LiveData<BaseDataHolder<User>> fromPublisher = LiveDataReactiveStreams.fromPublisher(APIUtilKt.validateAndObserve(getUserAPIService().registerUser(new RegistrationRequest(userName, email, phone, password, referralCode, deviceAppUID, Constants.PLATFORM, city))));
        Intrinsics.checkNotNullExpressionValue(fromPublisher, "fromPublisher(\n         …ateAndObserve()\n        )");
        return fromPublisher;
    }

    public final User getUser() {
        String string = this.prefs.getString("user_id", "");
        String string2 = this.prefs.getString(KEY_AUTH_TOKEN, "");
        String str = string;
        boolean z = true;
        if (!(str == null || StringsKt.isBlank(str))) {
            String str2 = string2;
            if (str2 != null && !StringsKt.isBlank(str2)) {
                z = false;
            }
            if (!z) {
                String string3 = this.prefs.getString("name", "");
                String str3 = string3 == null ? "" : string3;
                String string4 = this.prefs.getString("phone", "");
                String string5 = this.prefs.getString("email", "");
                String string6 = this.prefs.getString("plan_id", "");
                String string7 = this.prefs.getString(KEY_ADDRESS, "");
                String string8 = this.prefs.getString("city", "");
                boolean z2 = this.prefs.getBoolean(KEY_KYC_STATUS, false);
                boolean z3 = this.prefs.getBoolean(KEY_PAYMENT_STATUS, false);
                String string9 = this.prefs.getString(KEY_PIN_CODE, "");
                String string10 = this.prefs.getString("referral_code", "");
                String string11 = this.prefs.getString("state", "");
                boolean z4 = this.prefs.getBoolean(KEY_USER_LOGGED_IN, false);
                String string12 = this.prefs.getString(KEY_HUB_CODE, "");
                return new User(str3, string4, string5, string, string2, string6, z2, z3, string10, string7, string8, this.prefs.getString(KEY_AREA, ""), string11, string12, string9, Boolean.valueOf(z4), Long.valueOf(this.prefs.getLong(KEY_APPLICABLE_DISCOUNT, 0L)), null, this.prefs.getString(KEY_PLAN_NAME, ""), null, this.prefs.getBoolean(KEY_IS_CANCELLED, false), this.prefs.getString(KEY_CANCELLED_DATE, ""), null, null, 13238272, null);
            }
        }
        return null;
    }

    public final void setUser(User user) {
        SharedPreferences.Editor edit = this.prefs.edit();
        LSApplication.Companion.setUser(user);
        if (user == null) {
            edit.clear();
            edit.apply();
            this.authenticationState.setValue(AuthenticationState.USER_NOT_AUTHENTICATED);
            return;
        }
        edit.putBoolean(KEY_USER_LOGGED_IN, true);
        edit.putString("name", user.getName());
        edit.putString("email", user.getEmail());
        edit.putString(KEY_AUTH_TOKEN, user.getToken());
        edit.putString("user_id", user.getId());
        edit.putString("plan_id", user.getPlanId());
        edit.putString("phone", user.getMobile());
        edit.putBoolean(KEY_KYC_STATUS, user.getKycCompleted());
        edit.putString(KEY_ADDRESS, user.getAddress());
        edit.putString("city", user.getCity());
        edit.putBoolean(KEY_PAYMENT_STATUS, user.getPaymentCompleted());
        edit.putString(KEY_PIN_CODE, user.getPinCode());
        edit.putString("state", user.getState());
        edit.putString("referral_code", user.getReferralCode());
        edit.putBoolean(KEY_IS_CANCELLED, user.getCancelService());
        edit.putString(KEY_CANCELLED_DATE, user.getCancellationRequestedDate());
        edit.putString(KEY_PLAN_NAME, user.getPlanName());
        edit.apply();
        SegmentIdentityManager.Companion.with(this.context).refreshUserDetails();
        if (this.authenticationState.getValue() != AuthenticationState.USER_AUTHENTICATED) {
            this.authenticationState.setValue(AuthenticationState.USER_AUTHENTICATED);
        }
    }

    /* compiled from: UserRepository.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0014\b\u0086\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/livpure/safedrink/login/repositories/UserRepository$Companion;", "Lcom/livpure/safedrink/common/arc/SingletonHolder;", "Lcom/livpure/safedrink/login/repositories/UserRepository;", "Landroid/content/Context;", "()V", "KEY_ADDRESS", "", "KEY_APPLICABLE_DISCOUNT", "KEY_AREA", "KEY_AUTH_TOKEN", "KEY_CANCELLED_DATE", "KEY_CITY", "KEY_EMAIL", "KEY_HUB_CODE", "KEY_IS_CANCELLED", "KEY_KYC_STATUS", "KEY_NAME", "KEY_PAYMENT_STATUS", "KEY_PHONE", "KEY_PIN_CODE", "KEY_PLAN_ID", "KEY_PLAN_NAME", "KEY_REFERRAL_CODE", "KEY_STATE", "KEY_USER_ID", "KEY_USER_LOGGED_IN", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion extends SingletonHolder<UserRepository, Context> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* compiled from: UserRepository.kt */
        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* renamed from: com.livpure.safedrink.login.repositories.UserRepository$Companion$1  reason: invalid class name */
        /* loaded from: classes3.dex */
        /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Context, UserRepository> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            AnonymousClass1() {
                super(1, UserRepository.class, "<init>", "<init>(Landroid/content/Context;)V", 0);
            }

            @Override // kotlin.jvm.functions.Function1
            public final UserRepository invoke(Context p0) {
                Intrinsics.checkNotNullParameter(p0, "p0");
                return new UserRepository(p0, null);
            }
        }

        private Companion() {
            super(AnonymousClass1.INSTANCE);
        }
    }

    public final void logout() {
        setUser(null);
        LSApplication.Companion.setReferralLink(null);
    }

    public final boolean isUserLoggedIn() {
        return getUser() != null;
    }
}
