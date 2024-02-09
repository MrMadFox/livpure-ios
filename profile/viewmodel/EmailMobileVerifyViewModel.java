package com.livpure.safedrink.profile.viewmodel;

import android.content.Context;
import android.content.pm.PackageManager;
import android.provider.Settings;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.livpure.safedrink.api.APIException;
import com.livpure.safedrink.app.LSApplication;
import com.livpure.safedrink.common.arc.Event;
import com.livpure.safedrink.common.arc.ui.viewmodels.BaseViewModel;
import com.livpure.safedrink.common.arc.ui.viewmodels.MediatorViewModel;
import com.livpure.safedrink.profile.api.models.response.UpdateProfileResponse;
import com.livpure.safedrink.profile.api.models.response.VerifyProfileResponse;
import com.livpure.safedrink.profile.repositories.SendOtpRepository;
import com.moengage.core.internal.CoreConstants;
import com.moengage.core.internal.storage.database.contract.DeprecatedContractsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* compiled from: EmailMobileVerifyViewModel.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J,\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013J$\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/livpure/safedrink/profile/viewmodel/EmailMobileVerifyViewModel;", "Lcom/livpure/safedrink/common/arc/ui/viewmodels/MediatorViewModel;", "()V", "sendOtpRepository", "Lcom/livpure/safedrink/profile/repositories/SendOtpRepository;", "getSendOtpRepository", "()Lcom/livpure/safedrink/profile/repositories/SendOtpRepository;", "sendOtpRepository$delegate", "Lkotlin/Lazy;", "updateProfileResponse", "Landroidx/lifecycle/MutableLiveData;", "Lcom/livpure/safedrink/profile/api/models/response/UpdateProfileResponse;", "verifyProfileResponse", "Lcom/livpure/safedrink/profile/api/models/response/VerifyProfileResponse;", "onOtpVerify", "Landroidx/lifecycle/LiveData;", DeprecatedContractsKt.INAPP_V2_MSG_CONTEXT, "Landroid/content/Context;", "email", "", "mobile", "otp", "onSendOtp", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class EmailMobileVerifyViewModel extends MediatorViewModel {
    private final Lazy sendOtpRepository$delegate = LazyKt.lazy(new Function0<SendOtpRepository>() { // from class: com.livpure.safedrink.profile.viewmodel.EmailMobileVerifyViewModel$sendOtpRepository$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final SendOtpRepository invoke() {
            return new SendOtpRepository();
        }
    });
    private final MutableLiveData<UpdateProfileResponse> updateProfileResponse = new MutableLiveData<>();
    private final MutableLiveData<VerifyProfileResponse> verifyProfileResponse = new MutableLiveData<>();

    private final SendOtpRepository getSendOtpRepository() {
        return (SendOtpRepository) this.sendOtpRepository$delegate.getValue();
    }

    public final LiveData<UpdateProfileResponse> onSendOtp(Context context, String email, String mobile) {
        String str;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(mobile, "mobile");
        try {
            str = Settings.Secure.getString(context.getContentResolver(), CoreConstants.GENERIC_PARAM_V2_KEY_ANDROID_ID);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            str = "";
        }
        if (LSApplication.Companion.isNetworkAvailable()) {
            getLoading().setValue(true);
            try {
                SendOtpRepository sendOtpRepository = getSendOtpRepository();
                String replace$default = StringsKt.replace$default(email, " ", "", false, 4, (Object) null);
                String replace$default2 = StringsKt.replace$default(mobile, " ", "", false, 4, (Object) null);
                Intrinsics.checkNotNull(str);
                observeAndTrack(sendOtpRepository.sendProfileOtp(replace$default, replace$default2, str), new Observer() { // from class: com.livpure.safedrink.profile.viewmodel.EmailMobileVerifyViewModel$$ExternalSyntheticLambda0
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        EmailMobileVerifyViewModel.m1120onSendOtp$lambda0(EmailMobileVerifyViewModel.this, (UpdateProfileResponse) obj);
                    }
                });
            } catch (APIException unused) {
                getLoading().setValue(false);
                getToastMessageLiveData().setValue(new Event<>("Oops! We faced an issue while sending the otp."));
            }
        } else {
            getNetworkState().setValue(BaseViewModel.NetworkState.OFFLINE);
        }
        return this.updateProfileResponse;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onSendOtp$lambda-0  reason: not valid java name */
    public static final void m1120onSendOtp$lambda0(final EmailMobileVerifyViewModel this$0, UpdateProfileResponse updateProfileResponse) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getLoading().setValue(false);
        this$0.processResponse(updateProfileResponse, new Function1<UpdateProfileResponse, Unit>() { // from class: com.livpure.safedrink.profile.viewmodel.EmailMobileVerifyViewModel$onSendOtp$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(UpdateProfileResponse updateProfileResponse2) {
                invoke2(updateProfileResponse2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(UpdateProfileResponse successfulResponse) {
                MutableLiveData mutableLiveData;
                Intrinsics.checkNotNullParameter(successfulResponse, "successfulResponse");
                mutableLiveData = EmailMobileVerifyViewModel.this.updateProfileResponse;
                mutableLiveData.setValue(successfulResponse);
            }
        }, new Function1<UpdateProfileResponse, Unit>() { // from class: com.livpure.safedrink.profile.viewmodel.EmailMobileVerifyViewModel$onSendOtp$1$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(UpdateProfileResponse updateProfileResponse2) {
                invoke2(updateProfileResponse2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(UpdateProfileResponse failedResponse) {
                MutableLiveData toastMessageLiveData;
                Intrinsics.checkNotNullParameter(failedResponse, "failedResponse");
                toastMessageLiveData = EmailMobileVerifyViewModel.this.getToastMessageLiveData();
                String message = failedResponse.getMessage();
                Intrinsics.checkNotNull(message);
                toastMessageLiveData.setValue(new Event(message));
            }
        });
    }

    public final LiveData<VerifyProfileResponse> onOtpVerify(Context context, String email, String mobile, String otp) {
        String str;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(mobile, "mobile");
        Intrinsics.checkNotNullParameter(otp, "otp");
        try {
            str = Settings.Secure.getString(context.getContentResolver(), CoreConstants.GENERIC_PARAM_V2_KEY_ANDROID_ID);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            str = "";
        }
        if (LSApplication.Companion.isNetworkAvailable()) {
            getLoading().setValue(true);
            try {
                SendOtpRepository sendOtpRepository = getSendOtpRepository();
                String replace$default = StringsKt.replace$default(email, " ", "", false, 4, (Object) null);
                String replace$default2 = StringsKt.replace$default(mobile, " ", "", false, 4, (Object) null);
                String replace$default3 = StringsKt.replace$default(otp, " ", "", false, 4, (Object) null);
                Intrinsics.checkNotNull(str);
                observeAndTrack(sendOtpRepository.verifyProfileOtp(replace$default, replace$default2, replace$default3, str), new Observer() { // from class: com.livpure.safedrink.profile.viewmodel.EmailMobileVerifyViewModel$$ExternalSyntheticLambda1
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        EmailMobileVerifyViewModel.m1119onOtpVerify$lambda1(EmailMobileVerifyViewModel.this, (VerifyProfileResponse) obj);
                    }
                });
            } catch (APIException unused) {
                getLoading().setValue(false);
                getToastMessageLiveData().setValue(new Event<>("Oops! We faced an issue while verify the otp."));
            }
        } else {
            getNetworkState().setValue(BaseViewModel.NetworkState.OFFLINE);
        }
        return this.verifyProfileResponse;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onOtpVerify$lambda-1  reason: not valid java name */
    public static final void m1119onOtpVerify$lambda1(final EmailMobileVerifyViewModel this$0, VerifyProfileResponse verifyProfileResponse) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getLoading().setValue(false);
        this$0.processResponse(verifyProfileResponse, new Function1<VerifyProfileResponse, Unit>() { // from class: com.livpure.safedrink.profile.viewmodel.EmailMobileVerifyViewModel$onOtpVerify$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(VerifyProfileResponse verifyProfileResponse2) {
                invoke2(verifyProfileResponse2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(VerifyProfileResponse successfulResponse) {
                MutableLiveData mutableLiveData;
                MutableLiveData toastMessageLiveData;
                Intrinsics.checkNotNullParameter(successfulResponse, "successfulResponse");
                mutableLiveData = EmailMobileVerifyViewModel.this.verifyProfileResponse;
                mutableLiveData.setValue(successfulResponse);
                toastMessageLiveData = EmailMobileVerifyViewModel.this.getToastMessageLiveData();
                String message = successfulResponse.getMessage();
                Intrinsics.checkNotNull(message);
                toastMessageLiveData.setValue(new Event(message));
            }
        }, new Function1<VerifyProfileResponse, Unit>() { // from class: com.livpure.safedrink.profile.viewmodel.EmailMobileVerifyViewModel$onOtpVerify$1$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(VerifyProfileResponse verifyProfileResponse2) {
                invoke2(verifyProfileResponse2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(VerifyProfileResponse failedResponse) {
                MutableLiveData mutableLiveData;
                MutableLiveData toastMessageLiveData;
                Intrinsics.checkNotNullParameter(failedResponse, "failedResponse");
                mutableLiveData = EmailMobileVerifyViewModel.this.verifyProfileResponse;
                mutableLiveData.setValue(failedResponse);
                toastMessageLiveData = EmailMobileVerifyViewModel.this.getToastMessageLiveData();
                String message = failedResponse.getMessage();
                Intrinsics.checkNotNull(message);
                toastMessageLiveData.setValue(new Event(message));
            }
        });
    }
}
