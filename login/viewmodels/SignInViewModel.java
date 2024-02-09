package com.livpure.safedrink.login.viewmodels;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.provider.Settings;
import android.view.View;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.amplitude.api.Constants;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.livpure.safedrink.BuildConfig;
import com.livpure.safedrink.api.BaseDataHolder;
import com.livpure.safedrink.app.LSApplication;
import com.livpure.safedrink.common.arc.Event;
import com.livpure.safedrink.common.arc.ui.viewmodels.BaseViewModel;
import com.livpure.safedrink.common.arc.ui.viewmodels.MediatorViewModel;
import com.livpure.safedrink.login.data.models.User;
import com.livpure.safedrink.login.repositories.UserRepository;
import com.livpure.safedrink.segment.SegmentEventNames;
import com.livpure.safedrink.segment.SegmentLogger;
import com.livpure.safedrink.segment.SegmentProperties;
import com.livpure.safedrink.utils.StringUtilsKt;
import com.moengage.core.Properties;
import com.moengage.core.analytics.MoEAnalyticsHelper;
import com.moengage.core.internal.CoreConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* compiled from: SignInViewModel.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0002J\u0012\u0010\u0011\u001a\u00020\u000f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0005H\u0002J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018H\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007¨\u0006\u0019"}, d2 = {"Lcom/livpure/safedrink/login/viewmodels/SignInViewModel;", "Lcom/livpure/safedrink/common/arc/ui/viewmodels/MediatorViewModel;", "()V", "emailOrPhoneNumber", "Landroidx/lifecycle/MutableLiveData;", "", "getEmailOrPhoneNumber", "()Landroidx/lifecycle/MutableLiveData;", "password", "getPassword", "passwordError", "getPasswordError", "usernameError", "getUsernameError", "isFormValid", "", "username", "isValidEmailOrPhoneNumber", "onSignInButtonClicked", "", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "sendFirstLoginEvent", "user", "Lcom/livpure/safedrink/login/data/models/User;", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SignInViewModel extends MediatorViewModel {
    private final MutableLiveData<String> emailOrPhoneNumber = new MutableLiveData<>();
    private final MutableLiveData<String> password = new MutableLiveData<>();
    private final MutableLiveData<String> usernameError = new MutableLiveData<>();
    private final MutableLiveData<String> passwordError = new MutableLiveData<>();

    public final MutableLiveData<String> getEmailOrPhoneNumber() {
        return this.emailOrPhoneNumber;
    }

    public final MutableLiveData<String> getPassword() {
        return this.password;
    }

    public final MutableLiveData<String> getUsernameError() {
        return this.usernameError;
    }

    public final MutableLiveData<String> getPasswordError() {
        return this.passwordError;
    }

    public final void onSignInButtonClicked(View view) {
        String str;
        Intrinsics.checkNotNullParameter(view, "view");
        final Context context = view.getContext();
        try {
            str = Settings.Secure.getString(context.getContentResolver(), CoreConstants.GENERIC_PARAM_V2_KEY_ANDROID_ID);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            str = "";
        }
        String value = this.emailOrPhoneNumber.getValue();
        if (isFormValid(value != null ? StringsKt.replace$default(value, " ", "", false, 4, (Object) null) : null, this.password.getValue())) {
            if (LSApplication.Companion.isNetworkAvailable()) {
                getLoading().setValue(true);
                UserRepository.Companion companion = UserRepository.Companion;
                Intrinsics.checkNotNullExpressionValue(context, "context");
                UserRepository companion2 = companion.getInstance(context);
                String value2 = this.emailOrPhoneNumber.getValue();
                String replace$default = value2 != null ? StringsKt.replace$default(value2, " ", "", false, 4, (Object) null) : null;
                Intrinsics.checkNotNull(replace$default);
                String value3 = this.password.getValue();
                Intrinsics.checkNotNull(value3);
                Intrinsics.checkNotNull(str);
                observeAndTrack(companion2.authenticate(replace$default, value3, str), new Observer() { // from class: com.livpure.safedrink.login.viewmodels.SignInViewModel$$ExternalSyntheticLambda0
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        SignInViewModel.m1109onSignInButtonClicked$lambda0(SignInViewModel.this, context, (BaseDataHolder) obj);
                    }
                });
                return;
            }
            getNetworkState().setValue(BaseViewModel.NetworkState.OFFLINE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onSignInButtonClicked$lambda-0  reason: not valid java name */
    public static final void m1109onSignInButtonClicked$lambda0(SignInViewModel this$0, Context context, BaseDataHolder baseDataHolder) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!StringsKt.equals$default(baseDataHolder.getMessage(), "SSL handshake timed out", false, 2, null)) {
            User user = (User) baseDataHolder.getData();
            this$0.getLoading().setValue(false);
            if (user != null) {
                UserRepository.Companion companion = UserRepository.Companion;
                Intrinsics.checkNotNullExpressionValue(context, "context");
                companion.getInstance(context).setUser(user);
                this$0.sendFirstLoginEvent(user);
                SegmentLogger with = SegmentLogger.Companion.with(context);
                String value = this$0.emailOrPhoneNumber.getValue();
                Intrinsics.checkNotNull(value);
                with.sendSignedInEvent(StringsKt.contains$default((CharSequence) value, (CharSequence) "@", false, 2, (Object) null) ? "email" : "phone", user.getEmail(), user.getPlanName(), user.getPlanId(), user.getName(), user.getMobile());
                return;
            }
            MutableLiveData<Event<String>> toastMessageLiveData = this$0.getToastMessageLiveData();
            String message = baseDataHolder.getMessage();
            toastMessageLiveData.setValue(new Event<>(message != null ? message : "Oops! Something went wrong. Please try again."));
            return;
        }
        this$0.getToastMessageLiveData().setValue(new Event<>("Oops! Something went wrong. Please try again."));
    }

    private final void sendFirstLoginEvent(User user) {
        SharedPreferences.Editor edit;
        SharedPreferences.Editor putBoolean;
        if (user != null) {
            LSApplication companion = LSApplication.Companion.getInstance();
            SharedPreferences sharedPreferences = companion != null ? companion.getSharedPreferences(BuildConfig.APPLICATION_ID, 0) : null;
            if (sharedPreferences != null && sharedPreferences.getBoolean("firstLogin", true)) {
                LSApplication companion2 = LSApplication.Companion.getInstance();
                Properties addAttribute = new Properties().addAttribute("mobile", user.getMobile()).addAttribute("email", user.getEmail()).addAttribute("city", user.getCity()).addAttribute("state", user.getState()).addAttribute("username", user.getName()).addAttribute(SegmentProperties.USER_ID, user.getId()).addAttribute("pincode", user.getPinCode()).addAttribute("source", Constants.PLATFORM).addAttribute(SegmentProperties.DEVICE_ID, Settings.Secure.getString(companion2 != null ? companion2.getContentResolver() : null, CoreConstants.GENERIC_PARAM_V2_KEY_ANDROID_ID)).addAttribute(SegmentProperties.VERSION_CODE, 1).addAttribute(SegmentProperties.VERSION_NAME, com.crashlytics.android.BuildConfig.VERSION_NAME).addAttribute(SegmentProperties.DEVICE_VERSION, Build.VERSION.RELEASE).addAttribute(SegmentProperties.SDK_VERSION, Integer.valueOf(Build.VERSION.SDK_INT)).addAttribute("deviceModel", Build.MODEL).addAttribute(SegmentProperties.BRAND, Build.BRAND);
                MoEAnalyticsHelper moEAnalyticsHelper = MoEAnalyticsHelper.INSTANCE;
                LSApplication companion3 = LSApplication.Companion.getInstance();
                Intrinsics.checkNotNull(companion3);
                moEAnalyticsHelper.trackEvent(companion3, SegmentEventNames.FIRST_LOGIN, addAttribute);
                if (sharedPreferences == null || (edit = sharedPreferences.edit()) == null || (putBoolean = edit.putBoolean("firstLogin", false)) == null) {
                    return;
                }
                putBoolean.apply();
            }
        }
    }

    private final boolean isFormValid(String str, String str2) {
        boolean z;
        boolean z2 = true;
        if (!isValidEmailOrPhoneNumber(str)) {
            this.usernameError.setValue("Please enter your valid email ID or 10-digit mobile number");
            z = false;
        } else {
            this.usernameError.setValue(null);
            z = true;
        }
        String str3 = str2;
        if (str3 != null && !StringsKt.isBlank(str3)) {
            z2 = false;
        }
        if (z2) {
            this.passwordError.setValue("Password cannot be left empty.");
            return false;
        }
        this.passwordError.setValue(null);
        return z;
    }

    private final boolean isValidEmailOrPhoneNumber(String str) {
        return (str != null && str.length() == 10) || StringUtilsKt.isValidEmail(str);
    }
}
