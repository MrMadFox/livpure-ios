package com.livpure.safedrink.login.viewmodels;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.livpure.safedrink.api.APIException;
import com.livpure.safedrink.app.LSApplication;
import com.livpure.safedrink.common.arc.Event;
import com.livpure.safedrink.common.arc.ui.viewmodels.BaseViewModel;
import com.livpure.safedrink.common.arc.ui.viewmodels.MediatorViewModel;
import com.livpure.safedrink.login.api.models.response.BaseV1ResponseImplementation;
import com.livpure.safedrink.login.repositories.UserRepository;
import com.livpure.safedrink.login.viewmodels.ResetPasswordViewModel;
import com.moengage.core.internal.storage.database.contract.DeprecatedContractsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* compiled from: ResetPasswordViewModel.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u001cB\u0005¢\u0006\u0002\u0010\u0002J\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0013J&\u0010\u0014\u001a\u00020\u00152\b\u0010\f\u001a\u0004\u0018\u00010\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0005H\u0002J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0005R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0007R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0007¨\u0006\u001d"}, d2 = {"Lcom/livpure/safedrink/login/viewmodels/ResetPasswordViewModel;", "Lcom/livpure/safedrink/common/arc/ui/viewmodels/MediatorViewModel;", "()V", "confirmPassword", "Landroidx/lifecycle/MutableLiveData;", "", "getConfirmPassword", "()Landroidx/lifecycle/MutableLiveData;", "confirmPasswordError", "getConfirmPasswordError", "navigationState", "Lcom/livpure/safedrink/login/viewmodels/ResetPasswordViewModel$ResetPasswordDestinations;", "otp", "getOtp", "password", "getPassword", "passwordError", "getPasswordError", "getNavigationState", "Landroidx/lifecycle/LiveData;", "isFormValid", "", "confirmedPassword", "onResetPasswordClicked", "", DeprecatedContractsKt.INAPP_V2_MSG_CONTEXT, "Landroid/content/Context;", "username", "ResetPasswordDestinations", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ResetPasswordViewModel extends MediatorViewModel {
    private final MutableLiveData<String> otp = new MutableLiveData<>();
    private final MutableLiveData<String> password = new MutableLiveData<>();
    private final MutableLiveData<String> confirmPassword = new MutableLiveData<>();
    private final MutableLiveData<String> passwordError = new MutableLiveData<>();
    private final MutableLiveData<String> confirmPasswordError = new MutableLiveData<>();
    private final MutableLiveData<ResetPasswordDestinations> navigationState = new MutableLiveData<>();

    /* compiled from: ResetPasswordViewModel.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/livpure/safedrink/login/viewmodels/ResetPasswordViewModel$ResetPasswordDestinations;", "", "(Ljava/lang/String;I)V", "SIGN_IN", "RESET_PASSWORD", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public enum ResetPasswordDestinations {
        SIGN_IN,
        RESET_PASSWORD
    }

    public final MutableLiveData<String> getOtp() {
        return this.otp;
    }

    public final MutableLiveData<String> getPassword() {
        return this.password;
    }

    public final MutableLiveData<String> getConfirmPassword() {
        return this.confirmPassword;
    }

    public final MutableLiveData<String> getPasswordError() {
        return this.passwordError;
    }

    public final MutableLiveData<String> getConfirmPasswordError() {
        return this.confirmPasswordError;
    }

    public final LiveData<ResetPasswordDestinations> getNavigationState() {
        return this.navigationState;
    }

    public final void onResetPasswordClicked(Context context, String username) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(username, "username");
        if (isFormValid(this.otp.getValue(), this.password.getValue(), this.confirmPassword.getValue())) {
            if (LSApplication.Companion.isNetworkAvailable()) {
                getLoading().setValue(true);
                try {
                    String value = this.otp.getValue();
                    Intrinsics.checkNotNull(value);
                    int parseInt = Integer.parseInt(value);
                    String value2 = this.password.getValue();
                    Intrinsics.checkNotNull(value2);
                    observeAndTrack(UserRepository.Companion.getInstance(context).resetPassword(username, parseInt, value2), new Observer() { // from class: com.livpure.safedrink.login.viewmodels.ResetPasswordViewModel$$ExternalSyntheticLambda0
                        @Override // androidx.lifecycle.Observer
                        public final void onChanged(Object obj) {
                            ResetPasswordViewModel.m1108onResetPasswordClicked$lambda0(ResetPasswordViewModel.this, (BaseV1ResponseImplementation) obj);
                        }
                    });
                    return;
                } catch (APIException unused) {
                    getLoading().setValue(false);
                    getToastMessageLiveData().setValue(new Event<>("Oops! We faced an issue contacting out servers. Please try again."));
                    return;
                }
            }
            getNetworkState().setValue(BaseViewModel.NetworkState.OFFLINE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onResetPasswordClicked$lambda-0  reason: not valid java name */
    public static final void m1108onResetPasswordClicked$lambda0(final ResetPasswordViewModel this$0, BaseV1ResponseImplementation baseV1ResponseImplementation) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getLoading().setValue(false);
        this$0.processResponse(baseV1ResponseImplementation, new Function1<BaseV1ResponseImplementation, Unit>() { // from class: com.livpure.safedrink.login.viewmodels.ResetPasswordViewModel$onResetPasswordClicked$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(BaseV1ResponseImplementation baseV1ResponseImplementation2) {
                invoke2(baseV1ResponseImplementation2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(BaseV1ResponseImplementation it) {
                MutableLiveData mutableLiveData;
                Intrinsics.checkNotNullParameter(it, "it");
                mutableLiveData = ResetPasswordViewModel.this.navigationState;
                mutableLiveData.setValue(ResetPasswordViewModel.ResetPasswordDestinations.SIGN_IN);
            }
        }, new Function1<BaseV1ResponseImplementation, Unit>() { // from class: com.livpure.safedrink.login.viewmodels.ResetPasswordViewModel$onResetPasswordClicked$1$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(BaseV1ResponseImplementation baseV1ResponseImplementation2) {
                invoke2(baseV1ResponseImplementation2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(BaseV1ResponseImplementation failedResponse) {
                MutableLiveData toastMessageLiveData;
                MutableLiveData mutableLiveData;
                Intrinsics.checkNotNullParameter(failedResponse, "failedResponse");
                toastMessageLiveData = ResetPasswordViewModel.this.getToastMessageLiveData();
                String message = failedResponse.getMessage();
                if (message == null) {
                    message = "Oops! something went wrong. Please try again";
                }
                toastMessageLiveData.setValue(new Event(message));
                mutableLiveData = ResetPasswordViewModel.this.navigationState;
                mutableLiveData.setValue(ResetPasswordViewModel.ResetPasswordDestinations.RESET_PASSWORD);
            }
        });
    }

    private final boolean isFormValid(String str, String str2, String str3) {
        boolean z;
        String str4 = str;
        boolean z2 = true;
        if (str4 == null || StringsKt.isBlank(str4)) {
            getToastMessageLiveData().setValue(new Event<>("Please enter the OTP you received on your phone or email ID"));
            z = false;
        } else {
            z = true;
        }
        String str5 = str2;
        if ((str5 == null || StringsKt.isBlank(str5)) || str2.length() < 5) {
            this.passwordError.setValue("Please enter a valid new password (minimum 5 characters)");
            return false;
        }
        this.passwordError.setValue(null);
        String str6 = str3;
        if (str6 != null && !StringsKt.isBlank(str6)) {
            z2 = false;
        }
        if (z2) {
            this.confirmPasswordError.setValue("Please enter your password again to confirm it");
            return false;
        }
        this.confirmPasswordError.setValue(null);
        if (!Intrinsics.areEqual(str2, str3)) {
            this.confirmPasswordError.setValue("Password and password confirmation do not match.\n Please try again.");
            this.passwordError.setValue(this.confirmPasswordError.getValue());
            return false;
        }
        this.confirmPasswordError.setValue(null);
        this.passwordError.setValue(null);
        return z;
    }
}
