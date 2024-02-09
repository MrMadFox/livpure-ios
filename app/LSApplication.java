package com.livpure.safedrink.app;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import androidx.exifinterface.media.ExifInterface;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.facebook.FacebookSdk;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.AppEventsLogger;
import com.livpure.safedrink.LSHConfig;
import com.livpure.safedrink.MyBarDataSet;
import com.livpure.safedrink.R;
import com.livpure.safedrink.adapter.RechargeHistoryAdapter;
import com.livpure.safedrink.airpurifier.data.AirPurifierCommandsRespository;
import com.livpure.safedrink.airpurifier.data.models.AirPurifierBLEStatus;
import com.livpure.safedrink.airpurifier.data.models.AirPurifierCommand;
import com.livpure.safedrink.airpurifier.data.models.AirPurifierDashboardDetails;
import com.livpure.safedrink.airpurifier.data.models.AirPurifierDashboardDetailsResponse;
import com.livpure.safedrink.airpurifier.data.models.AirPurifierData;
import com.livpure.safedrink.airpurifier.data.models.AirPurifierDevice;
import com.livpure.safedrink.airpurifier.data.models.AirPurifierDeviceStatus;
import com.livpure.safedrink.airpurifier.data.models.AirPurifierPlanDetails;
import com.livpure.safedrink.airpurifier.data.models.AirPurifierPublishCommand;
import com.livpure.safedrink.airpurifier.data.models.AirPurifierResponseImplementation;
import com.livpure.safedrink.airpurifier.data.models.AirPurifierStatus;
import com.livpure.safedrink.airpurifier.data.models.AirPurifierWifiStatus;
import com.livpure.safedrink.airpurifier.data.models.ImageStatus;
import com.livpure.safedrink.airpurifier.model.HomePurifierModel;
import com.livpure.safedrink.airpurifier.view.HomeAirPurifierFragment;
import com.livpure.safedrink.airpurifier.view.adapter.AirPurifierBottomOptionAdapter;
import com.livpure.safedrink.api.APIAirPurifierService;
import com.livpure.safedrink.api.APIException;
import com.livpure.safedrink.api.APIHumsarService;
import com.livpure.safedrink.api.APILmsdevService;
import com.livpure.safedrink.api.APIOTAService;
import com.livpure.safedrink.api.APIService;
import com.livpure.safedrink.api.AirPurifierResponseValidationResult;
import com.livpure.safedrink.api.BaseDTO;
import com.livpure.safedrink.api.BaseDataHolder;
import com.livpure.safedrink.api.ConnectionStateMonitor;
import com.livpure.safedrink.api.DispenserResponseValidationResult;
import com.livpure.safedrink.api.DisposableManager;
import com.livpure.safedrink.api.PostDeviceInfo;
import com.livpure.safedrink.api.V1ResponseValidationResult;
import com.livpure.safedrink.app.recharge.view.fragment.RechargeHistoryFragment;
import com.livpure.safedrink.app.support.data.ServiceRequestRepository;
import com.livpure.safedrink.app.support.data.models.SRRequest;
import com.livpure.safedrink.app.support.viewmodels.ServiceRequestViewModel;
import com.livpure.safedrink.app.support.views.ContactUsFragment;
import com.livpure.safedrink.app.support.views.ServiceRequestFragment;
import com.livpure.safedrink.bolt.data.BoltBleCommandsRespository;
import com.livpure.safedrink.bolt.data.BoltConfigurationRepository;
import com.livpure.safedrink.bolt.data.BoltDataUpdateRepository;
import com.livpure.safedrink.bolt.data.models.BoldBleData;
import com.livpure.safedrink.bolt.data.models.BoltBLEUpdate;
import com.livpure.safedrink.bolt.data.models.BoltBleCommands;
import com.livpure.safedrink.bolt.data.models.BoltCommandsResponse;
import com.livpure.safedrink.bolt.data.models.BoltRequest;
import com.livpure.safedrink.bolt.data.models.RechargeData;
import com.livpure.safedrink.bolt.data.models.RechargeResponse;
import com.livpure.safedrink.bolt.model.DispenserWiFiSettingsModel;
import com.livpure.safedrink.bolt.model.SettingModel;
import com.livpure.safedrink.bolt.model.WiFiSettingsModel;
import com.livpure.safedrink.bolt.service.Base64Hex;
import com.livpure.safedrink.bolt.service.Encrypt;
import com.livpure.safedrink.bolt.service.GeneralService;
import com.livpure.safedrink.bolt.service.Rijndael;
import com.livpure.safedrink.bolt.view.SettingsFragment;
import com.livpure.safedrink.bolt.view.WiFiSettingsFragment;
import com.livpure.safedrink.bolt.wifi.Client;
import com.livpure.safedrink.common.arc.SingletonHolder;
import com.livpure.safedrink.common.arc.ui.HorizontalMarginItemDecoration;
import com.livpure.safedrink.common.arc.ui.viewmodels.AnalyticsViewModel;
import com.livpure.safedrink.common.arc.ui.viewmodels.BaseViewModel;
import com.livpure.safedrink.common.arc.ui.views.BaseActivity;
import com.livpure.safedrink.common.arc.ui.views.BaseFragment;
import com.livpure.safedrink.common.arc.ui.views.BaseUIActivity;
import com.livpure.safedrink.common.arc.ui.views.DataBindingFragment;
import com.livpure.safedrink.common.arc.ui.views.NoFilterArrayAdapter;
import com.livpure.safedrink.common.arc.ui.views.SpinnerWithHintAdapter;
import com.livpure.safedrink.dispenser.data.DispenserCommandsRepository;
import com.livpure.safedrink.dispenser.data.models.DispenserBLEStatus;
import com.livpure.safedrink.dispenser.data.models.DispenserCommands;
import com.livpure.safedrink.dispenser.data.models.DispenserDashboardDetails;
import com.livpure.safedrink.dispenser.data.models.DispenserDashboardDetailsResponse;
import com.livpure.safedrink.dispenser.data.models.DispenserData;
import com.livpure.safedrink.dispenser.data.models.DispenserDevice;
import com.livpure.safedrink.dispenser.data.models.DispenserDeviceStatus;
import com.livpure.safedrink.dispenser.data.models.DispenserImageStatus;
import com.livpure.safedrink.dispenser.data.models.DispenserPlanDetails;
import com.livpure.safedrink.dispenser.data.models.DispenserPublishCommand;
import com.livpure.safedrink.dispenser.data.models.DispenserResponseImplementation;
import com.livpure.safedrink.dispenser.data.models.DispenserStatus;
import com.livpure.safedrink.dispenser.data.models.DispenserWifiStatus;
import com.livpure.safedrink.dispenser.model.HomeDispenserModel;
import com.livpure.safedrink.dispenser.view.HomeDispenserFragment;
import com.livpure.safedrink.dispenser.view.adapter.DispenserBottomOptionAdapter;
import com.livpure.safedrink.furlenco.model.HomeFurlencoModel;
import com.livpure.safedrink.furlenco.view.HomeFurlencoFragment;
import com.livpure.safedrink.login.AuthPagerFragment;
import com.livpure.safedrink.login.ForgotPasswordFragment;
import com.livpure.safedrink.login.LogoutFragment;
import com.livpure.safedrink.login.OnboardingFragment;
import com.livpure.safedrink.login.ResetPasswordFragment;
import com.livpure.safedrink.login.SignInFragment;
import com.livpure.safedrink.login.SignUpFragment;
import com.livpure.safedrink.login.SplashFragment;
import com.livpure.safedrink.login.adapters.AuthPagerAdapter;
import com.livpure.safedrink.login.api.models.request.AuthenticationRequest;
import com.livpure.safedrink.login.api.models.request.ForgotPasswordRequest;
import com.livpure.safedrink.login.api.models.request.ReferralCodeRequest;
import com.livpure.safedrink.login.api.models.request.RegistrationRequest;
import com.livpure.safedrink.login.api.models.request.ResetPasswordRequest;
import com.livpure.safedrink.login.api.models.request.UserDetailsRequest;
import com.livpure.safedrink.login.api.models.response.BaseV1Response;
import com.livpure.safedrink.login.api.models.response.BaseV1ResponseImplementation;
import com.livpure.safedrink.login.api.models.response.UserDetailsResponse;
import com.livpure.safedrink.login.data.models.AddressDetails;
import com.livpure.safedrink.login.data.models.PlanAndReferralDiscountDetails;
import com.livpure.safedrink.login.data.models.User;
import com.livpure.safedrink.login.data.models.UserDetailsV1;
import com.livpure.safedrink.login.repositories.UserRepository;
import com.livpure.safedrink.login.viewmodels.ForgotPasswordViewModel;
import com.livpure.safedrink.login.viewmodels.ResetPasswordViewModel;
import com.livpure.safedrink.login.viewmodels.SignInViewModel;
import com.livpure.safedrink.login.viewmodels.SignUpViewModel;
import com.livpure.safedrink.model.AirPurifierBottomOption;
import com.livpure.safedrink.model.DataModel;
import com.livpure.safedrink.model.DispenserBottomOption;
import com.livpure.safedrink.ota.data.OTARepository;
import com.livpure.safedrink.ota.data.model.CommandDetails;
import com.livpure.safedrink.ota.data.model.MessageDetails;
import com.livpure.safedrink.ota.data.model.MessageDetailsResponse;
import com.livpure.safedrink.ota.data.model.OTARequest;
import com.livpure.safedrink.ota.data.model.OTAUpdateDetailsResponse;
import com.livpure.safedrink.ota.data.model.firmwareRequest;
import com.livpure.safedrink.ota.data.model.response.BaseOTAResponse;
import com.livpure.safedrink.referNearn.model.LaderShipArrayResponse;
import com.livpure.safedrink.referNearn.model.MyRankResponse;
import com.livpure.safedrink.referNearn.model.ReferralHistoryResponse;
import com.livpure.safedrink.referNearn.model.ReferralRequest;
import com.livpure.safedrink.referNearn.model.Response;
import com.livpure.safedrink.referNearn.model.Result;
import com.livpure.safedrink.referNearn.model.TopThreeRankResponse;
import com.livpure.safedrink.referNearn.model.leadershipBoard;
import com.livpure.safedrink.referNearn.model.referralHistory;
import com.livpure.safedrink.referNearn.pager.ReferralPagerAdapter;
import com.livpure.safedrink.referNearn.repository.ReferralRepository;
import com.livpure.safedrink.referNearn.view.adapter.ReferralHistoryAdapter;
import com.livpure.safedrink.referNearn.view.adapter.ReferralSuperUserAdapter;
import com.livpure.safedrink.referNearn.view.fragment.ReferEarnFragment;
import com.livpure.safedrink.referNearn.view.fragment.ReferralHistoryFragment;
import com.livpure.safedrink.referNearn.view.fragment.ReferralInvitesFragment;
import com.livpure.safedrink.referNearn.view.fragment.ReferralLeaderBoardFragment;
import com.livpure.safedrink.referNearn.viewmodels.ReferAndEarnViewModel;
import com.livpure.safedrink.segment.SegmentIdentityManager;
import com.livpure.safedrink.segment.SegmentLogger;
import com.livpure.safedrink.servicebluetooth.BluetoothLeService;
import com.livpure.safedrink.servicefirebase.MyFirebaseMessagingService;
import com.livpure.safedrink.subscription.address.data.AddressRepository;
import com.livpure.safedrink.subscription.address.data.CRMRepository;
import com.livpure.safedrink.subscription.address.data.CitiesRepository;
import com.livpure.safedrink.subscription.address.data.model.Address;
import com.livpure.safedrink.subscription.address.data.model.CitiesResponse;
import com.livpure.safedrink.subscription.address.data.model.CityDetailsItem;
import com.livpure.safedrink.subscription.address.data.model.SaveAddressRequest;
import com.livpure.safedrink.subscription.address.data.model.SavedAddressItem;
import com.livpure.safedrink.subscription.address.data.model.ServiceableAreaItem;
import com.livpure.safedrink.subscription.address.data.model.ServiceableAreaRequest;
import com.livpure.safedrink.subscription.address.data.model.ServiceableAreaResponse;
import com.livpure.safedrink.subscription.address.view.InstallationAddressFragment;
import com.livpure.safedrink.subscription.address.viewmodel.InstallationAddressViewModel;
import com.livpure.safedrink.subscription.cancelsubscription.data.CancelRequest;
import com.livpure.safedrink.subscription.cancelsubscription.data.CancelRequestRespository;
import com.livpure.safedrink.subscription.cancelsubscription.view.CancelSubsciptionConfirmationFragment;
import com.livpure.safedrink.subscription.cancelsubscription.view.CancelSubsciptionFragment;
import com.livpure.safedrink.subscription.cancelsubscription.viewmodel.CancelSubsciptionConfirmationModel;
import com.livpure.safedrink.subscription.cancelsubscription.viewmodel.CancelSubsciptionModel;
import com.livpure.safedrink.subscription.kyc.data.ConfigRepository;
import com.livpure.safedrink.subscription.kyc.data.KYCRepository;
import com.livpure.safedrink.subscription.kyc.data.model.DropDownResponse;
import com.livpure.safedrink.subscription.kyc.data.model.KYCUploadRequest;
import com.livpure.safedrink.subscription.kyc.data.model.ProofType;
import com.livpure.safedrink.subscription.kyc.data.model.S3Credentials;
import com.livpure.safedrink.subscription.kyc.data.model.S3CredentialsRequest;
import com.livpure.safedrink.subscription.kyc.data.model.S3CredentialsResponse;
import com.livpure.safedrink.subscription.kyc.view.UploadKycFragment;
import com.livpure.safedrink.subscription.kyc.viewmodel.UploadKYCViewModel;
import com.livpure.safedrink.subscription.payment.adapter.PlanDurationAdapter;
import com.livpure.safedrink.subscription.payment.adapter.PlanDurationsAdapter;
import com.livpure.safedrink.subscription.payment.adapter.PlanTitleAdapter;
import com.livpure.safedrink.subscription.payment.adapter.RecommendedPlanAdapter;
import com.livpure.safedrink.subscription.payment.pager.ViewPagerAdapter;
import com.livpure.safedrink.subscription.payment.view.AddLitresFragment;
import com.livpure.safedrink.subscription.payment.view.PlanDurationFragment;
import com.livpure.safedrink.subscription.payment.view.PlanFragment;
import com.livpure.safedrink.subscription.payment.view.PlanPagerAdapter;
import com.livpure.safedrink.subscription.payment.view.ReviewOrderFragment;
import com.livpure.safedrink.subscription.payment.view.SelectPlanChangeFragment;
import com.livpure.safedrink.subscription.payment.view.SelectPlanFragment;
import com.livpure.safedrink.subscription.payment.viewmodel.AddLitresViewModel;
import com.livpure.safedrink.subscription.payment.viewmodel.PlanDurationModel;
import com.livpure.safedrink.subscription.payment.viewmodel.ReferAndEarnModel;
import com.livpure.safedrink.subscription.payment.viewmodel.ReviewOrderViewModel;
import com.livpure.safedrink.subscription.payment.viewmodel.SelectPlanChangeModel;
import com.livpure.safedrink.subscription.payment.viewmodel.SelectPlanViewModel;
import com.livpure.safedrink.subscription.plan.data.model.dashboard.BalanceInfo;
import com.livpure.safedrink.subscription.plan.data.model.dashboard.DailyConsumptionItem;
import com.livpure.safedrink.subscription.plan.data.model.dashboard.DashboardDetails;
import com.livpure.safedrink.subscription.plan.data.model.dashboard.ProductStats;
import com.livpure.safedrink.subscription.plan.data.model.dashboard.UsageStats;
import com.livpure.safedrink.subscription.plan.data.model.deviceList.DeviceData;
import com.livpure.safedrink.subscription.plan.data.model.deviceList.DeviceList;
import com.livpure.safedrink.subscription.plan.data.model.payment.PaymentPayload;
import com.livpure.safedrink.subscription.plan.data.model.payment.PlanData;
import com.livpure.safedrink.subscription.plan.data.model.payment.PlanItem;
import com.livpure.safedrink.utils.GPSTracker;
import com.livpure.safedrink.utils.IntentHelper;
import com.livpure.safedrink.utils.LruBitmapCache;
import com.livpure.safedrink.utils.MyVolleySingleton;
import com.livpure.safedrink.utils.UpdateChecker;
import com.livpure.safedrink.utils.UriToIntentMapper;
import com.moengage.core.MoEngage;
import com.moengage.core.analytics.MoEAnalyticsHelper;
import com.moengage.core.config.FcmConfig;
import com.moengage.core.config.InAppConfig;
import com.moengage.core.config.LogConfig;
import com.moengage.core.config.NotificationConfig;
import com.moengage.core.model.AppStatus;
import com.segment.analytics.Analytics;
import com.segment.analytics.android.integrations.amplitude.AmplitudeIntegration;
import com.segment.analytics.android.integrations.firebase.FirebaseIntegration;
import com.segment.analytics.android.integrations.moengage.MoEngageIntegration;
import io.branch.referral.Branch;
import io.reactivex.exceptions.UndeliverableException;
import io.reactivex.functions.Consumer;
import io.reactivex.plugins.RxJavaPlugins;
import java.io.IOException;
import java.net.SocketException;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;
/* compiled from: LSApplication.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\b\u001a\u00020\t\"\u0004\b\u0000\u0010\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\fJ\u0006\u0010\r\u001a\u00020\tJ\b\u0010\u000e\u001a\u00020\tH\u0002J\u0006\u0010\u000f\u001a\u00020\tJ\b\u0010\u0010\u001a\u00020\tH\u0016J\b\u0010\u0011\u001a\u00020\tH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/livpure/safedrink/app/LSApplication;", "Landroid/app/Application;", "()V", "mRequestQueue", "Lcom/android/volley/RequestQueue;", "requestQueue", "getRequestQueue", "()Lcom/android/volley/RequestQueue;", "addToRequestQueue", "", ExifInterface.GPS_DIRECTION_TRUE, "req", "Lcom/android/volley/Request;", "initializeAnalytics", "initializeBranch", "initializeMoEngage", "onCreate", "trackInstallOrUpdate", "Companion", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class LSApplication extends Application {
    private static boolean hasSplashBeenShown;
    private static LSApplication instance;
    private static boolean isNeedAnalytics;
    private static String planName;
    private static String referralLink;
    private static User user;
    private RequestQueue mRequestQueue;
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "LSApplication";
    private static boolean isNetworkAvailable = true;

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        instance = this;
        Branch.getAutoInstance(this);
        if (UserRepository.Companion.getInstance(this).isUserLoggedIn()) {
            user = UserRepository.Companion.getInstance(this).getUser();
        } else {
            user = null;
        }
        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp((Application) this);
        FacebookSdk.setIsDebugEnabled(true);
        FacebookSdk.addLoggingBehavior(LoggingBehavior.APP_EVENTS);
        initializeAnalytics();
        RxJavaPlugins.setErrorHandler(new Consumer() { // from class: com.livpure.safedrink.app.LSApplication$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                LSApplication.m436onCreate$lambda0((Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onCreate$lambda-0  reason: not valid java name */
    public static final void m436onCreate$lambda0(Throwable e) {
        Intrinsics.checkNotNullParameter(e, "e");
        if (e instanceof UndeliverableException) {
            e = e.getCause();
            Intrinsics.checkNotNull(e);
        }
        if ((e instanceof IOException) || (e instanceof SocketException) || (e instanceof InterruptedException)) {
            return;
        }
        if ((e instanceof NullPointerException) || (e instanceof IllegalArgumentException)) {
            Thread.currentThread().getUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), e);
        } else if (e instanceof IllegalStateException) {
            Thread.currentThread().getUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), e);
        } else {
            Timber.tag("Undeliverable exception").e(e);
        }
    }

    public final RequestQueue getRequestQueue() {
        if (this.mRequestQueue == null) {
            this.mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        }
        return this.mRequestQueue;
    }

    public final void initializeAnalytics() {
        Analytics.setSingletonInstance(new Analytics.Builder(getApplicationContext(), LSHConfig.SEGMENT_WRITE_KEY).use(AmplitudeIntegration.FACTORY).use(FirebaseIntegration.FACTORY).use(MoEngageIntegration.FACTORY).trackAttributionInformation().trackApplicationLifecycleEvents().build());
        initializeBranch();
        initializeMoEngage();
        trackInstallOrUpdate();
    }

    private final void trackInstallOrUpdate() {
        SharedPreferences sharedPreferences = getSharedPreferences("demoapp", 0);
        AppStatus appStatus = AppStatus.INSTALL;
        if (sharedPreferences.getBoolean("has_sent_install", false)) {
            if (sharedPreferences.getBoolean("existing", false)) {
                appStatus = AppStatus.UPDATE;
            }
            MoEAnalyticsHelper moEAnalyticsHelper = MoEAnalyticsHelper.INSTANCE;
            Context applicationContext = getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "applicationContext");
            moEAnalyticsHelper.setAppStatus(applicationContext, appStatus);
            sharedPreferences.edit().putBoolean("has_sent_install", true).apply();
            sharedPreferences.edit().putBoolean("existing", true).apply();
        }
    }

    private final void initializeBranch() {
        LSApplication lSApplication = this;
        Branch.getAutoInstance(lSApplication);
        Branch.getInstance().setRequestMetadata("$segment_anonymous_id", Analytics.with(lSApplication).getAnalyticsContext().traits().anonymousId());
    }

    public final void initializeMoEngage() {
        HashSet hashSet = new HashSet();
        hashSet.add(RechargeHistoryAdapter.class);
        hashSet.add(AirPurifierBLEStatus.class);
        hashSet.add(AirPurifierCommand.class);
        hashSet.add(AirPurifierDashboardDetails.class);
        hashSet.add(AirPurifierDashboardDetailsResponse.class);
        hashSet.add(AirPurifierData.class);
        hashSet.add(AirPurifierDevice.class);
        hashSet.add(AirPurifierDeviceStatus.class);
        hashSet.add(AirPurifierPlanDetails.class);
        hashSet.add(AirPurifierPublishCommand.class);
        hashSet.add(AirPurifierResponseImplementation.class);
        hashSet.add(AirPurifierStatus.class);
        hashSet.add(AirPurifierWifiStatus.class);
        hashSet.add(ImageStatus.class);
        hashSet.add(AirPurifierCommandsRespository.class);
        hashSet.add(HomePurifierModel.class);
        hashSet.add(AirPurifierBottomOptionAdapter.class);
        hashSet.add(HomeAirPurifierFragment.class);
        hashSet.add(AirPurifierResponseValidationResult.class);
        hashSet.add(APIAirPurifierService.class);
        hashSet.add(APIException.class);
        hashSet.add(APIOTAService.class);
        hashSet.add(APIService.class);
        hashSet.add(APIHumsarService.class);
        hashSet.add(APILmsdevService.class);
        hashSet.add(BaseDataHolder.class);
        hashSet.add(BaseDTO.class);
        hashSet.add(ConnectionStateMonitor.class);
        hashSet.add(DispenserResponseValidationResult.class);
        hashSet.add(DisposableManager.class);
        hashSet.add(PostDeviceInfo.class);
        hashSet.add(V1ResponseValidationResult.class);
        hashSet.add(SRRequest.class);
        hashSet.add(ServiceRequestRepository.class);
        hashSet.add(ServiceRequestViewModel.class);
        hashSet.add(ContactUsFragment.class);
        hashSet.add(ServiceRequestFragment.class);
        hashSet.add(AppLifeCycleManager.class);
        hashSet.add(DeviceHomeFragment.class);
        hashSet.add(DeviceHomeViewModel.class);
        hashSet.add(DevicePagerAdapter.class);
        hashSet.add(LSApplication.class);
        hashSet.add(MainViewModel.class);
        hashSet.add(NoNetworkFragment.class);
        hashSet.add(ProfileFragment.class);
        hashSet.add(ProfileViewModel.class);
        hashSet.add(RechargeHistoryFragment.class);
        hashSet.add(StaticWebViewFragment.class);
        hashSet.add(BoldBleData.class);
        hashSet.add(BoltBleCommands.class);
        hashSet.add(BoltBLEUpdate.class);
        hashSet.add(BoltCommandsResponse.class);
        hashSet.add(BoltRequest.class);
        hashSet.add(RechargeData.class);
        hashSet.add(RechargeResponse.class);
        hashSet.add(BoltBleCommandsRespository.class);
        hashSet.add(BoltConfigurationRepository.class);
        hashSet.add(BoltDataUpdateRepository.class);
        hashSet.add(DispenserWiFiSettingsModel.class);
        hashSet.add(SettingModel.class);
        hashSet.add(WiFiSettingsModel.class);
        hashSet.add(Base64Hex.class);
        hashSet.add(Encrypt.class);
        hashSet.add(GeneralService.class);
        hashSet.add(Rijndael.class);
        hashSet.add(SettingsFragment.class);
        hashSet.add(WiFiSettingsFragment.class);
        hashSet.add(Client.class);
        hashSet.add(AnalyticsViewModel.class);
        hashSet.add(BaseViewModel.class);
        hashSet.add(BaseViewModel.class);
        hashSet.add(BaseActivity.class);
        hashSet.add(BaseFragment.class);
        hashSet.add(BaseUIActivity.class);
        hashSet.add(DataBindingFragment.class);
        hashSet.add(NoFilterArrayAdapter.class);
        hashSet.add(SpinnerWithHintAdapter.class);
        hashSet.add(HorizontalMarginItemDecoration.class);
        hashSet.add(SingletonHolder.class);
        hashSet.add(DispenserBLEStatus.class);
        hashSet.add(DispenserCommands.class);
        hashSet.add(DispenserDashboardDetails.class);
        hashSet.add(DispenserDashboardDetailsResponse.class);
        hashSet.add(DispenserData.class);
        hashSet.add(DispenserDevice.class);
        hashSet.add(DispenserDeviceStatus.class);
        hashSet.add(DispenserImageStatus.class);
        hashSet.add(DispenserPlanDetails.class);
        hashSet.add(DispenserPublishCommand.class);
        hashSet.add(DispenserResponseImplementation.class);
        hashSet.add(DispenserStatus.class);
        hashSet.add(DispenserWifiStatus.class);
        hashSet.add(DispenserCommandsRepository.class);
        hashSet.add(HomeDispenserModel.class);
        hashSet.add(DispenserBottomOptionAdapter.class);
        hashSet.add(HomeDispenserFragment.class);
        hashSet.add(HomeFurlencoModel.class);
        hashSet.add(HomeFurlencoFragment.class);
        hashSet.add(AuthPagerAdapter.class);
        hashSet.add(AuthenticationRequest.class);
        hashSet.add(ForgotPasswordRequest.class);
        hashSet.add(ReferralCodeRequest.class);
        hashSet.add(RegistrationRequest.class);
        hashSet.add(ResetPasswordRequest.class);
        hashSet.add(UserDetailsRequest.class);
        hashSet.add(BaseV1Response.class);
        hashSet.add(BaseV1ResponseImplementation.class);
        hashSet.add(UserDetailsResponse.class);
        hashSet.add(AddressDetails.class);
        hashSet.add(PlanAndReferralDiscountDetails.class);
        hashSet.add(User.class);
        hashSet.add(UserDetailsV1.class);
        hashSet.add(UserRepository.class);
        hashSet.add(ForgotPasswordViewModel.class);
        hashSet.add(ResetPasswordViewModel.class);
        hashSet.add(SignInViewModel.class);
        hashSet.add(SignUpViewModel.class);
        hashSet.add(AuthPagerFragment.class);
        hashSet.add(ForgotPasswordFragment.class);
        hashSet.add(LogoutFragment.class);
        hashSet.add(OnboardingFragment.class);
        hashSet.add(ResetPasswordFragment.class);
        hashSet.add(SignInFragment.class);
        hashSet.add(SignUpFragment.class);
        hashSet.add(SplashFragment.class);
        hashSet.add(AirPurifierBottomOption.class);
        hashSet.add(DataModel.class);
        hashSet.add(DispenserBottomOption.class);
        hashSet.add(BaseOTAResponse.class);
        hashSet.add(CommandDetails.class);
        hashSet.add(firmwareRequest.class);
        hashSet.add(MessageDetails.class);
        hashSet.add(MessageDetailsResponse.class);
        hashSet.add(OTARequest.class);
        hashSet.add(OTAUpdateDetailsResponse.class);
        hashSet.add(OTARepository.class);
        hashSet.add(LaderShipArrayResponse.class);
        hashSet.add(leadershipBoard.class);
        hashSet.add(MyRankResponse.class);
        hashSet.add(referralHistory.class);
        hashSet.add(ReferralHistoryResponse.class);
        hashSet.add(ReferralRequest.class);
        hashSet.add(Response.class);
        hashSet.add(Result.class);
        hashSet.add(TopThreeRankResponse.class);
        hashSet.add(ReferralPagerAdapter.class);
        hashSet.add(ReferralRepository.class);
        hashSet.add(ReferralHistoryAdapter.class);
        hashSet.add(ReferralSuperUserAdapter.class);
        hashSet.add(ReferEarnFragment.class);
        hashSet.add(ReferralHistoryFragment.class);
        hashSet.add(ReferralInvitesFragment.class);
        hashSet.add(ReferralLeaderBoardFragment.class);
        hashSet.add(ReferAndEarnViewModel.class);
        hashSet.add(SegmentIdentityManager.class);
        hashSet.add(SegmentLogger.class);
        hashSet.add(BluetoothLeService.class);
        hashSet.add(MyFirebaseMessagingService.class);
        hashSet.add(Address.class);
        hashSet.add(CitiesResponse.class);
        hashSet.add(CityDetailsItem.class);
        hashSet.add(SaveAddressRequest.class);
        hashSet.add(SavedAddressItem.class);
        hashSet.add(ServiceableAreaItem.class);
        hashSet.add(ServiceableAreaRequest.class);
        hashSet.add(ServiceableAreaResponse.class);
        hashSet.add(AddressRepository.class);
        hashSet.add(CitiesRepository.class);
        hashSet.add(CRMRepository.class);
        hashSet.add(InstallationAddressFragment.class);
        hashSet.add(InstallationAddressViewModel.class);
        hashSet.add(CancelRequest.class);
        hashSet.add(CancelRequestRespository.class);
        hashSet.add(CancelSubsciptionConfirmationFragment.class);
        hashSet.add(CancelSubsciptionFragment.class);
        hashSet.add(CancelSubsciptionConfirmationModel.class);
        hashSet.add(CancelSubsciptionModel.class);
        hashSet.add(DropDownResponse.class);
        hashSet.add(KYCUploadRequest.class);
        hashSet.add(ProofType.class);
        hashSet.add(S3Credentials.class);
        hashSet.add(S3CredentialsRequest.class);
        hashSet.add(S3CredentialsResponse.class);
        hashSet.add(ConfigRepository.class);
        hashSet.add(KYCRepository.class);
        hashSet.add(UploadKycFragment.class);
        hashSet.add(UploadKYCViewModel.class);
        hashSet.add(PlanDurationAdapter.class);
        hashSet.add(PlanDurationsAdapter.class);
        hashSet.add(PlanTitleAdapter.class);
        hashSet.add(RecommendedPlanAdapter.class);
        hashSet.add(ViewPagerAdapter.class);
        hashSet.add(AddLitresFragment.class);
        hashSet.add(PlanDurationFragment.class);
        hashSet.add(PlanFragment.class);
        hashSet.add(PlanPagerAdapter.class);
        hashSet.add(ReviewOrderFragment.class);
        hashSet.add(SelectPlanChangeFragment.class);
        hashSet.add(SelectPlanFragment.class);
        hashSet.add(AddLitresViewModel.class);
        hashSet.add(PlanDurationModel.class);
        hashSet.add(ReferAndEarnModel.class);
        hashSet.add(ReviewOrderViewModel.class);
        hashSet.add(SelectPlanChangeModel.class);
        hashSet.add(SelectPlanViewModel.class);
        hashSet.add(BalanceInfo.class);
        hashSet.add(DailyConsumptionItem.class);
        hashSet.add(DashboardDetails.class);
        hashSet.add(ProductStats.class);
        hashSet.add(UsageStats.class);
        hashSet.add(DeviceData.class);
        hashSet.add(DeviceList.class);
        hashSet.add(PaymentPayload.class);
        hashSet.add(PlanData.class);
        hashSet.add(PlanItem.class);
        hashSet.add(GPSTracker.class);
        hashSet.add(IntentHelper.class);
        hashSet.add(LruBitmapCache.class);
        hashSet.add(MyVolleySingleton.class);
        hashSet.add(UpdateChecker.class);
        hashSet.add(UriToIntentMapper.class);
        hashSet.add(MyBarDataSet.class);
        hashSet.add(LSHConfig.class);
        MoEngage.Companion.initialiseDefaultInstance(new MoEngage.Builder(this, LSHConfig.MOENGAGE_KEY).configureInApps(new InAppConfig(hashSet)).configureLogs(new LogConfig(5, false)).configureNotificationMetaData(new NotificationConfig(R.drawable.ic_notification, R.drawable.ic_notification, R.color.livpure_orange, true, false, true)).configureFcm(new FcmConfig(false)).build());
    }

    public final <T> void addToRequestQueue(Request<T> req) {
        Intrinsics.checkNotNullParameter(req, "req");
        req.setTag(TAG);
        RequestQueue requestQueue = getRequestQueue();
        Intrinsics.checkNotNull(requestQueue);
        requestQueue.add(req);
    }

    /* compiled from: LSApplication.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f8F@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000b\"\u0004\b\u0014\u0010\rR\u001a\u0010\u0015\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000b\"\u0004\b\u0016\u0010\rR\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0007\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0007\"\u0004\b\u001d\u0010\u001aR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Lcom/livpure/safedrink/app/LSApplication$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "getTAG", "()Ljava/lang/String;", "hasSplashBeenShown", "", "getHasSplashBeenShown", "()Z", "setHasSplashBeenShown", "(Z)V", "<set-?>", "Lcom/livpure/safedrink/app/LSApplication;", "instance", "getInstance", "()Lcom/livpure/safedrink/app/LSApplication;", "isNeedAnalytics", "setNeedAnalytics", "isNetworkAvailable", "setNetworkAvailable", "planName", "getPlanName", "setPlanName", "(Ljava/lang/String;)V", "referralLink", "getReferralLink", "setReferralLink", "user", "Lcom/livpure/safedrink/login/data/models/User;", "getUser", "()Lcom/livpure/safedrink/login/data/models/User;", "setUser", "(Lcom/livpure/safedrink/login/data/models/User;)V", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getTAG() {
            return LSApplication.TAG;
        }

        public final User getUser() {
            return LSApplication.user;
        }

        public final void setUser(User user) {
            LSApplication.user = user;
        }

        public final synchronized LSApplication getInstance() {
            return LSApplication.instance;
        }

        public final boolean getHasSplashBeenShown() {
            return LSApplication.hasSplashBeenShown;
        }

        public final void setHasSplashBeenShown(boolean z) {
            LSApplication.hasSplashBeenShown = z;
        }

        public final boolean isNetworkAvailable() {
            return LSApplication.isNetworkAvailable;
        }

        public final void setNetworkAvailable(boolean z) {
            LSApplication.isNetworkAvailable = z;
        }

        public final boolean isNeedAnalytics() {
            return LSApplication.isNeedAnalytics;
        }

        public final void setNeedAnalytics(boolean z) {
            LSApplication.isNeedAnalytics = z;
        }

        public final String getReferralLink() {
            return LSApplication.referralLink;
        }

        public final void setReferralLink(String str) {
            LSApplication.referralLink = str;
        }

        public final String getPlanName() {
            return LSApplication.planName;
        }

        public final void setPlanName(String str) {
            LSApplication.planName = str;
        }
    }
}
