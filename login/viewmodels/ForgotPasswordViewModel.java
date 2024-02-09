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
import com.livpure.safedrink.login.viewmodels.ForgotPasswordViewModel;
import com.moengage.core.internal.storage.database.contract.DeprecatedContractsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ForgotPasswordViewModel.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0002J\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0011"}, d2 = {"Lcom/livpure/safedrink/login/viewmodels/ForgotPasswordViewModel;", "Lcom/livpure/safedrink/common/arc/ui/viewmodels/MediatorViewModel;", "()V", "navigationState", "Landroidx/lifecycle/MutableLiveData;", "Lcom/livpure/safedrink/login/viewmodels/ForgotPasswordViewModel$ForgotPasswordDestinations;", "username", "", "getUsername", "()Landroidx/lifecycle/MutableLiveData;", "getNavigationState", "Landroidx/lifecycle/LiveData;", "onResetPasswordClicked", "", DeprecatedContractsKt.INAPP_V2_MSG_CONTEXT, "Landroid/content/Context;", "ForgotPasswordDestinations", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ForgotPasswordViewModel extends MediatorViewModel {
    private final MutableLiveData<ForgotPasswordDestinations> navigationState = new MutableLiveData<>();
    private final MutableLiveData<String> username = new MutableLiveData<>();

    /* compiled from: ForgotPasswordViewModel.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/livpure/safedrink/login/viewmodels/ForgotPasswordViewModel$ForgotPasswordDestinations;", "", "(Ljava/lang/String;I)V", "OTP", "FORGOT_PASSWORD", "FURLENCO", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public enum ForgotPasswordDestinations {
        OTP,
        FORGOT_PASSWORD,
        FURLENCO
    }

    public final MutableLiveData<String> getUsername() {
        return this.username;
    }

    public final LiveData<ForgotPasswordDestinations> getNavigationState() {
        return this.navigationState;
    }

    public final void onResetPasswordClicked(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (LSApplication.Companion.isNetworkAvailable()) {
            getLoading().setValue(true);
            try {
                UserRepository companion = UserRepository.Companion.getInstance(context);
                String value = this.username.getValue();
                if (value == null) {
                    value = "";
                }
                observeAndTrack(companion.forgotPassword(value), new Observer() { // from class: com.livpure.safedrink.login.viewmodels.ForgotPasswordViewModel$$ExternalSyntheticLambda0
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        ForgotPasswordViewModel.m1107onResetPasswordClicked$lambda0(ForgotPasswordViewModel.this, (BaseV1ResponseImplementation) obj);
                    }
                });
                return;
            } catch (APIException unused) {
                getLoading().setValue(false);
                getToastMessageLiveData().setValue(new Event<>("Oops! There was an issue contacting our servers."));
                return;
            }
        }
        getNetworkState().setValue(BaseViewModel.NetworkState.OFFLINE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onResetPasswordClicked$lambda-0  reason: not valid java name */
    public static final void m1107onResetPasswordClicked$lambda0(final ForgotPasswordViewModel this$0, BaseV1ResponseImplementation baseV1ResponseImplementation) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getLoading().setValue(false);
        this$0.processResponse(baseV1ResponseImplementation, new Function1<BaseV1ResponseImplementation, Unit>() { // from class: com.livpure.safedrink.login.viewmodels.ForgotPasswordViewModel$onResetPasswordClicked$1$1
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
                MutableLiveData mutableLiveData2;
                MutableLiveData mutableLiveData3;
                Intrinsics.checkNotNullParameter(it, "it");
                if (it.isFurlencoUser() == null) {
                    mutableLiveData = ForgotPasswordViewModel.this.navigationState;
                    mutableLiveData.setValue(ForgotPasswordViewModel.ForgotPasswordDestinations.OTP);
                    return;
                }
                Boolean isFurlencoUser = it.isFurlencoUser();
                Intrinsics.checkNotNull(isFurlencoUser);
                if (isFurlencoUser.booleanValue()) {
                    mutableLiveData3 = ForgotPasswordViewModel.this.navigationState;
                    mutableLiveData3.setValue(ForgotPasswordViewModel.ForgotPasswordDestinations.FURLENCO);
                    return;
                }
                mutableLiveData2 = ForgotPasswordViewModel.this.navigationState;
                mutableLiveData2.setValue(ForgotPasswordViewModel.ForgotPasswordDestinations.OTP);
            }
        }, new Function1<BaseV1ResponseImplementation, Unit>() { // from class: com.livpure.safedrink.login.viewmodels.ForgotPasswordViewModel$onResetPasswordClicked$1$2
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
                MutableLiveData mutableLiveData;
                MutableLiveData toastMessageLiveData;
                Intrinsics.checkNotNullParameter(failedResponse, "failedResponse");
                mutableLiveData = ForgotPasswordViewModel.this.navigationState;
                mutableLiveData.setValue(ForgotPasswordViewModel.ForgotPasswordDestinations.FORGOT_PASSWORD);
                toastMessageLiveData = ForgotPasswordViewModel.this.getToastMessageLiveData();
                String message = failedResponse.getMessage();
                if (message == null) {
                    message = "Please enter your valid email ID or phone number to get an OTP";
                }
                toastMessageLiveData.setValue(new Event(message));
            }
        });
    }
}
