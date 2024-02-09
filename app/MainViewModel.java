package com.livpure.safedrink.app;

import android.content.Context;
import android.net.Uri;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferListener;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferState;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferUtility;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3Client;
import com.facebook.share.internal.ShareConstants;
import com.livpure.safedrink.api.APIException;
import com.livpure.safedrink.api.BaseDataHolder;
import com.livpure.safedrink.app.AppLifeCycleManager;
import com.livpure.safedrink.app.MainViewModel;
import com.livpure.safedrink.common.FileUtilKt;
import com.livpure.safedrink.common.arc.Event;
import com.livpure.safedrink.common.arc.ui.viewmodels.BaseViewModel;
import com.livpure.safedrink.common.arc.ui.viewmodels.MediatorViewModel;
import com.livpure.safedrink.login.data.models.User;
import com.livpure.safedrink.login.repositories.UserRepository;
import com.livpure.safedrink.subscription.kyc.data.KYCRepository;
import com.livpure.safedrink.subscription.kyc.data.model.S3CredentialsResponse;
import com.livpure.safedrink.subscription.plan.data.model.payment.PaymentPayload;
import com.moengage.core.internal.storage.database.contract.DeprecatedContractsKt;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: MainViewModel.kt */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0003JKLB\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'J\u0014\u0010(\u001a\b\u0012\u0004\u0012\u00020\u000b0)2\u0006\u0010*\u001a\u00020+J\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\r0)J\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00160)J\u0006\u0010.\u001a\u00020%J\u0006\u0010/\u001a\u00020%J\u0006\u00100\u001a\u00020%J\u0018\u00101\u001a\u00020%2\b\u00102\u001a\u0004\u0018\u00010\t2\u0006\u00103\u001a\u00020\u0005J\u0018\u00104\u001a\u00020%2\b\u00102\u001a\u0004\u0018\u00010\t2\u0006\u00103\u001a\u00020\u0005J\u000e\u00105\u001a\u00020%2\u0006\u00106\u001a\u000207J\u000e\u00108\u001a\u00020%2\u0006\u00109\u001a\u00020\u0016J\u0006\u0010:\u001a\u00020%J\u0014\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00180)2\u0006\u00106\u001a\u000207J\u001e\u0010<\u001a\u00020%2\u0006\u00106\u001a\u0002072\u0006\u0010=\u001a\u00020\u00052\u0006\u0010>\u001a\u00020\u0005JJ\u0010?\u001a\u00020%2\u0006\u00106\u001a\u0002072\u0006\u00103\u001a\u00020\u00052\b\u0010@\u001a\u0004\u0018\u00010\t2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020\u00052\u0006\u0010F\u001a\u00020\u00052\u0006\u0010G\u001a\u00020HH\u0002J\u0010\u0010I\u001a\u00020%2\u0006\u00106\u001a\u000207H\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0007R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0004X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001cR*\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00050 2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00050 @BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#¨\u0006M"}, d2 = {"Lcom/livpure/safedrink/app/MainViewModel;", "Lcom/livpure/safedrink/common/arc/ui/viewmodels/MediatorViewModel;", "()V", "addressProofFile", "Landroidx/lifecycle/MutableLiveData;", "", "getAddressProofFile", "()Landroidx/lifecycle/MutableLiveData;", "addressProofUri", "Landroid/net/Uri;", "authNavigationState", "Lcom/livpure/safedrink/app/MainViewModel$AuthNavigationStates;", "globalNavigationState", "Lcom/livpure/safedrink/app/MainViewModel$GlobalNavigationStates;", "idProofFile", "getIdProofFile", "idProofUri", "getIdProofUri", "()Landroid/net/Uri;", "setIdProofUri", "(Landroid/net/Uri;)V", "paymentPayload", "Lcom/livpure/safedrink/subscription/plan/data/model/payment/PaymentPayload;", "proofUploadStatus", "Lcom/livpure/safedrink/app/MainViewModel$ProofUploadStatus;", "s3CredentialsRepository", "Lcom/livpure/safedrink/subscription/kyc/data/KYCRepository;", "getS3CredentialsRepository", "()Lcom/livpure/safedrink/subscription/kyc/data/KYCRepository;", "s3CredentialsRepository$delegate", "Lkotlin/Lazy;", "<set-?>", "", "uploadedFileList", "getUploadedFileList", "()Ljava/util/List;", "checkAuthentication", "", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "getAuthNavigationState", "Landroidx/lifecycle/LiveData;", "fragment", "Landroidx/fragment/app/Fragment;", "getGlobalNavigationStates", "getPaymentState", "onForgotPasswordClick", "onTermsAndConditionsClick", "resetProofs", "setAddressProof", ShareConstants.MEDIA_URI, "fileName", "setIDProofFileName", "setOnBoardingShown", DeprecatedContractsKt.INAPP_V2_MSG_CONTEXT, "Landroid/content/Context;", "setPaymentPayload", "payload", "setSplashShown", "startUploadingKYC", "updateDeviceId", AnalyticsAttribute.USER_ID_ATTRIBUTE, "deviceId", "uploadFileToS3", "fileUri", "maxMBLimit", "", "transferUtility", "Lcom/amazonaws/mobileconnectors/s3/transferutility/TransferUtility;", "bucketName", "uploadFileName", "transferListener", "Lcom/amazonaws/mobileconnectors/s3/transferutility/TransferListener;", "uploadProofsToS3", "AuthNavigationStates", "GlobalNavigationStates", "ProofUploadStatus", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class MainViewModel extends MediatorViewModel {
    private final MutableLiveData<String> addressProofFile;
    private Uri addressProofUri;
    private final MutableLiveData<String> idProofFile;
    private Uri idProofUri;
    private MutableLiveData<PaymentPayload> paymentPayload;
    private final MutableLiveData<ProofUploadStatus> proofUploadStatus;
    private List<String> uploadedFileList;
    private final Lazy s3CredentialsRepository$delegate = LazyKt.lazy(new Function0<KYCRepository>() { // from class: com.livpure.safedrink.app.MainViewModel$s3CredentialsRepository$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final KYCRepository invoke() {
            return new KYCRepository();
        }
    });
    private final MutableLiveData<AuthNavigationStates> authNavigationState = new MutableLiveData<>();
    private final MutableLiveData<GlobalNavigationStates> globalNavigationState = new MutableLiveData<>();

    /* compiled from: MainViewModel.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/livpure/safedrink/app/MainViewModel$AuthNavigationStates;", "", "(Ljava/lang/String;I)V", "ONBOARDING", "AUTH_PAGER", "TERMS_AND_CONDITIONS", "FORGOT_PASSWORD", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public enum AuthNavigationStates {
        ONBOARDING,
        AUTH_PAGER,
        TERMS_AND_CONDITIONS,
        FORGOT_PASSWORD
    }

    /* compiled from: MainViewModel.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/livpure/safedrink/app/MainViewModel$GlobalNavigationStates;", "", "(Ljava/lang/String;I)V", "SPLASH", "CHECK_AUTHENTICATION", "HOME", "AUTHENTICATE", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public enum GlobalNavigationStates {
        SPLASH,
        CHECK_AUTHENTICATION,
        HOME,
        AUTHENTICATE
    }

    /* compiled from: MainViewModel.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/livpure/safedrink/app/MainViewModel$ProofUploadStatus;", "", "(Ljava/lang/String;I)V", "SUCCESS", "FAILURE", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public enum ProofUploadStatus {
        SUCCESS,
        FAILURE
    }

    public MainViewModel() {
        MutableLiveData<String> mutableLiveData = new MutableLiveData<>();
        mutableLiveData.setValue("");
        this.addressProofFile = mutableLiveData;
        MutableLiveData<String> mutableLiveData2 = new MutableLiveData<>();
        mutableLiveData2.setValue("");
        this.idProofFile = mutableLiveData2;
        this.proofUploadStatus = new MutableLiveData<>();
        this.uploadedFileList = new ArrayList();
    }

    private final KYCRepository getS3CredentialsRepository() {
        return (KYCRepository) this.s3CredentialsRepository$delegate.getValue();
    }

    public final Uri getIdProofUri() {
        return this.idProofUri;
    }

    public final void setIdProofUri(Uri uri) {
        this.idProofUri = uri;
    }

    public final MutableLiveData<String> getAddressProofFile() {
        return this.addressProofFile;
    }

    public final MutableLiveData<String> getIdProofFile() {
        return this.idProofFile;
    }

    public final LiveData<PaymentPayload> getPaymentState() {
        MutableLiveData<PaymentPayload> mutableLiveData = new MutableLiveData<>();
        this.paymentPayload = mutableLiveData;
        return mutableLiveData;
    }

    public final void setPaymentPayload(PaymentPayload payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        MutableLiveData<PaymentPayload> mutableLiveData = this.paymentPayload;
        if (mutableLiveData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paymentPayload");
            mutableLiveData = null;
        }
        mutableLiveData.setValue(payload);
    }

    public final void setOnBoardingShown(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        AppLifeCycleManager.Companion.getInstance(context).setHasOnBoardingBeenShown(true);
    }

    public final void onTermsAndConditionsClick() {
        this.authNavigationState.setValue(AuthNavigationStates.TERMS_AND_CONDITIONS);
    }

    public final void onForgotPasswordClick() {
        this.authNavigationState.setValue(AuthNavigationStates.FORGOT_PASSWORD);
    }

    public final LiveData<GlobalNavigationStates> getGlobalNavigationStates() {
        if (!LSApplication.Companion.getHasSplashBeenShown()) {
            this.globalNavigationState.setValue(GlobalNavigationStates.SPLASH);
        } else {
            this.globalNavigationState.setValue(GlobalNavigationStates.CHECK_AUTHENTICATION);
        }
        return this.globalNavigationState;
    }

    public final void setSplashShown() {
        LSApplication.Companion.setHasSplashBeenShown(true);
        this.globalNavigationState.setValue(GlobalNavigationStates.CHECK_AUTHENTICATION);
    }

    public final void checkAuthentication(AppCompatActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        UserRepository.Companion.getInstance(activity).checkAuthentication().observe(activity, new Observer() { // from class: com.livpure.safedrink.app.MainViewModel$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MainViewModel.m438checkAuthentication$lambda2(MainViewModel.this, (UserRepository.AuthenticationState) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: checkAuthentication$lambda-2  reason: not valid java name */
    public static final void m438checkAuthentication$lambda2(MainViewModel this$0, UserRepository.AuthenticationState authenticationState) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (authenticationState == UserRepository.AuthenticationState.USER_AUTHENTICATED) {
            this$0.globalNavigationState.setValue(GlobalNavigationStates.HOME);
        } else {
            this$0.globalNavigationState.setValue(GlobalNavigationStates.AUTHENTICATE);
        }
    }

    public final LiveData<AuthNavigationStates> getAuthNavigationState(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        if (fragment.getActivity() != null) {
            AppLifeCycleManager.Companion companion = AppLifeCycleManager.Companion;
            FragmentActivity requireActivity = fragment.requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "fragment.requireActivity()");
            if (!companion.getInstance(requireActivity).getHasOnBoardingBeenShown()) {
                this.authNavigationState.setValue(AuthNavigationStates.ONBOARDING);
            } else {
                this.authNavigationState.setValue(AuthNavigationStates.AUTH_PAGER);
            }
        }
        return this.authNavigationState;
    }

    public final void setAddressProof(Uri uri, String fileName) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        this.addressProofUri = uri;
        this.addressProofFile.setValue(fileName);
    }

    public final void setIDProofFileName(Uri uri, String fileName) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        this.idProofUri = uri;
        this.idProofFile.setValue(fileName);
    }

    public final void resetProofs() {
        this.addressProofUri = null;
        this.addressProofFile.setValue("");
        this.idProofUri = null;
        this.idProofFile.setValue("");
    }

    public final LiveData<ProofUploadStatus> startUploadingKYC(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        getLoading().setValue(true);
        uploadProofsToS3(context);
        return this.proofUploadStatus;
    }

    public final List<String> getUploadedFileList() {
        return this.uploadedFileList;
    }

    public final void updateDeviceId(Context context, String userId, String deviceId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(deviceId, "deviceId");
        if (LSApplication.Companion.isNetworkAvailable()) {
            getLoading().setValue(true);
            observeAndTrack(UserRepository.Companion.getInstance(context).uploadDeviceID(userId, deviceId), new Observer() { // from class: com.livpure.safedrink.app.MainViewModel$$ExternalSyntheticLambda2
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    ((BaseDataHolder) obj).getStatus();
                }
            });
        }
    }

    private final void uploadProofsToS3(final Context context) {
        if (LSApplication.Companion.isNetworkAvailable()) {
            try {
                observeAndTrack(KYCRepository.getS3Credentials$default(getS3CredentialsRepository(), null, 1, null), new Observer() { // from class: com.livpure.safedrink.app.MainViewModel$$ExternalSyntheticLambda1
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        MainViewModel.m440uploadProofsToS3$lambda4(MainViewModel.this, context, (S3CredentialsResponse) obj);
                    }
                });
                return;
            } catch (APIException unused) {
                getLoading().setValue(false);
                getToastMessageLiveData().setValue(new Event<>("Sorry! We are unable to upload documents at this moment."));
                return;
            }
        }
        getNetworkState().setValue(BaseViewModel.NetworkState.OFFLINE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: uploadProofsToS3$lambda-4  reason: not valid java name */
    public static final void m440uploadProofsToS3$lambda4(final MainViewModel this$0, final Context context, S3CredentialsResponse s3CredentialsResponse) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        this$0.processResponse(s3CredentialsResponse, new Function1<S3CredentialsResponse, Unit>() { // from class: com.livpure.safedrink.app.MainViewModel$uploadProofsToS3$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(S3CredentialsResponse s3CredentialsResponse2) {
                invoke2(s3CredentialsResponse2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(final S3CredentialsResponse successfulResponse) {
                MutableLiveData toastMessageLiveData;
                MutableLiveData mutableLiveData;
                Uri uri;
                Intrinsics.checkNotNullParameter(successfulResponse, "successfulResponse");
                if (successfulResponse.getCredentials() != null) {
                    AmazonS3Client amazonS3Client = new AmazonS3Client(new BasicAWSCredentials(successfulResponse.getCredentials().getKey(), successfulResponse.getCredentials().getSecret()));
                    amazonS3Client.setRegion(Region.getRegion(Regions.AP_SOUTH_1));
                    final TransferUtility transferUtility = new TransferUtility(amazonS3Client, context);
                    this$0.uploadedFileList = new ArrayList();
                    StringBuilder sb = new StringBuilder();
                    User user = LSApplication.Companion.getUser();
                    sb.append(user != null ? user.getId() : null);
                    sb.append('_');
                    sb.append(System.currentTimeMillis());
                    sb.append("_ANDROID_address_proof_1_");
                    String value = this$0.getAddressProofFile().getValue();
                    if (value == null) {
                        value = "";
                    }
                    sb.append(value);
                    final String sb2 = sb.toString();
                    MainViewModel mainViewModel = this$0;
                    Context context2 = context;
                    String value2 = mainViewModel.getAddressProofFile().getValue();
                    Intrinsics.checkNotNull(value2);
                    String str = value2;
                    uri = this$0.addressProofUri;
                    String bucketName = successfulResponse.getCredentials().getBucketName();
                    if (bucketName == null) {
                        bucketName = "lsh-waas-upload/aadhaar";
                    }
                    final MainViewModel mainViewModel2 = this$0;
                    final Context context3 = context;
                    mainViewModel.uploadFileToS3(context2, str, uri, 25, transferUtility, bucketName, sb2, new TransferListener() { // from class: com.livpure.safedrink.app.MainViewModel$uploadProofsToS3$1$1.1
                        @Override // com.amazonaws.mobileconnectors.s3.transferutility.TransferListener
                        public void onProgressChanged(int i, long j, long j2) {
                        }

                        @Override // com.amazonaws.mobileconnectors.s3.transferutility.TransferListener
                        public void onStateChanged(int i, TransferState transferState) {
                            if (TransferState.COMPLETED == transferState) {
                                MainViewModel.this.getUploadedFileList().add(sb2);
                                StringBuilder sb3 = new StringBuilder();
                                User user2 = LSApplication.Companion.getUser();
                                sb3.append(user2 != null ? user2.getId() : null);
                                sb3.append('_');
                                sb3.append(System.currentTimeMillis());
                                sb3.append("_ANDROID_id_proof_1_");
                                String value3 = MainViewModel.this.getIdProofFile().getValue();
                                if (value3 == null) {
                                    value3 = "";
                                }
                                sb3.append(value3);
                                final String sb4 = sb3.toString();
                                MainViewModel mainViewModel3 = MainViewModel.this;
                                Context context4 = context3;
                                String value4 = mainViewModel3.getIdProofFile().getValue();
                                Intrinsics.checkNotNull(value4);
                                String str2 = value4;
                                Uri idProofUri = MainViewModel.this.getIdProofUri();
                                int i2 = r4;
                                TransferUtility transferUtility2 = transferUtility;
                                String bucketName2 = successfulResponse.getCredentials().getBucketName();
                                if (bucketName2 == null) {
                                    bucketName2 = "lsh-waas-upload/aadhaar";
                                }
                                final MainViewModel mainViewModel4 = MainViewModel.this;
                                mainViewModel3.uploadFileToS3(context4, str2, idProofUri, i2, transferUtility2, bucketName2, sb4, new TransferListener() { // from class: com.livpure.safedrink.app.MainViewModel$uploadProofsToS3$1$1$1$onStateChanged$1
                                    @Override // com.amazonaws.mobileconnectors.s3.transferutility.TransferListener
                                    public void onProgressChanged(int i3, long j, long j2) {
                                    }

                                    @Override // com.amazonaws.mobileconnectors.s3.transferutility.TransferListener
                                    public void onStateChanged(int i3, TransferState transferState2) {
                                        MutableLiveData mutableLiveData2;
                                        if (TransferState.COMPLETED == transferState2) {
                                            MainViewModel.this.getUploadedFileList().add(sb4);
                                            mutableLiveData2 = MainViewModel.this.proofUploadStatus;
                                            mutableLiveData2.setValue(MainViewModel.ProofUploadStatus.SUCCESS);
                                            MainViewModel.this.getLoading().setValue(false);
                                        }
                                    }

                                    @Override // com.amazonaws.mobileconnectors.s3.transferutility.TransferListener
                                    public void onError(int i3, Exception exc) {
                                        MutableLiveData toastMessageLiveData2;
                                        MutableLiveData mutableLiveData2;
                                        MainViewModel.this.getLoading().setValue(false);
                                        toastMessageLiveData2 = MainViewModel.this.getToastMessageLiveData();
                                        toastMessageLiveData2.setValue(new Event("Sorry! We are unable to upload documents at this moment."));
                                        mutableLiveData2 = MainViewModel.this.proofUploadStatus;
                                        mutableLiveData2.setValue(MainViewModel.ProofUploadStatus.FAILURE);
                                    }
                                });
                            }
                        }

                        @Override // com.amazonaws.mobileconnectors.s3.transferutility.TransferListener
                        public void onError(int i, Exception exc) {
                            MutableLiveData toastMessageLiveData2;
                            MutableLiveData mutableLiveData2;
                            MainViewModel.this.getLoading().setValue(false);
                            toastMessageLiveData2 = MainViewModel.this.getToastMessageLiveData();
                            toastMessageLiveData2.setValue(new Event("Sorry! We are unable to upload documents at this moment."));
                            mutableLiveData2 = MainViewModel.this.proofUploadStatus;
                            mutableLiveData2.setValue(MainViewModel.ProofUploadStatus.FAILURE);
                        }
                    });
                    return;
                }
                this$0.getLoading().setValue(false);
                toastMessageLiveData = this$0.getToastMessageLiveData();
                toastMessageLiveData.setValue(new Event("Sorry! We are unable to upload documents at this moment."));
                mutableLiveData = this$0.proofUploadStatus;
                mutableLiveData.setValue(MainViewModel.ProofUploadStatus.FAILURE);
            }
        }, new Function1<S3CredentialsResponse, Unit>() { // from class: com.livpure.safedrink.app.MainViewModel$uploadProofsToS3$1$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(S3CredentialsResponse s3CredentialsResponse2) {
                invoke2(s3CredentialsResponse2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(S3CredentialsResponse it) {
                MutableLiveData toastMessageLiveData;
                MutableLiveData mutableLiveData;
                Intrinsics.checkNotNullParameter(it, "it");
                MainViewModel.this.getLoading().setValue(false);
                toastMessageLiveData = MainViewModel.this.getToastMessageLiveData();
                toastMessageLiveData.setValue(new Event("Sorry! We are unable to upload documents at this moment."));
                mutableLiveData = MainViewModel.this.proofUploadStatus;
                mutableLiveData.setValue(MainViewModel.ProofUploadStatus.FAILURE);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void uploadFileToS3(Context context, String str, Uri uri, int i, TransferUtility transferUtility, String str2, String str3, TransferListener transferListener) {
        getLoading().setValue(true);
        String str4 = context.getFilesDir().getAbsolutePath() + File.separator + str;
        if (uri != null) {
            File file = FileUtilKt.getFile(uri, context, str4);
            if (file != null && file.exists()) {
                if (file.length() / 1048576 <= i) {
                    transferUtility.upload(str2, str3, file).setTransferListener(transferListener);
                    return;
                }
                getLoading().setValue(false);
                getToastMessageLiveData().setValue(new Event<>("Upload Failed. File size should be less than " + i + " MB"));
                this.proofUploadStatus.setValue(ProofUploadStatus.FAILURE);
                return;
            }
            getLoading().setValue(false);
            getToastMessageLiveData().setValue(new Event<>("File not found!"));
            this.proofUploadStatus.setValue(ProofUploadStatus.FAILURE);
            return;
        }
        getLoading().setValue(false);
        getToastMessageLiveData().setValue(new Event<>("Failed to upload proof files due to an internal error. Please try again."));
        this.proofUploadStatus.setValue(ProofUploadStatus.FAILURE);
    }
}
