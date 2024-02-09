package com.livpure.safedrink.login.viewmodels;

import android.content.Context;
import android.content.pm.PackageManager;
import android.provider.Settings;
import android.view.View;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.livpure.safedrink.api.APIException;
import com.livpure.safedrink.api.BaseDataHolder;
import com.livpure.safedrink.app.LSApplication;
import com.livpure.safedrink.common.arc.Event;
import com.livpure.safedrink.common.arc.ui.viewmodels.BaseViewModel;
import com.livpure.safedrink.common.arc.ui.viewmodels.MediatorViewModel;
import com.livpure.safedrink.login.api.models.response.BaseV1ResponseImplementation;
import com.livpure.safedrink.login.data.models.User;
import com.livpure.safedrink.login.repositories.UserRepository;
import com.livpure.safedrink.segment.SegmentLogger;
import com.livpure.safedrink.utils.StringUtilsKt;
import com.moengage.core.internal.CoreConstants;
import com.moengage.core.internal.storage.database.contract.DeprecatedContractsKt;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* compiled from: SignUpViewModel.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\b\u0014\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J<\u0010$\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00052\b\u0010 \u001a\u0004\u0018\u00010\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u0005H\u0002J\u000e\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(J\u0006\u0010)\u001a\u00020&J\u000e\u0010*\u001a\u00020&2\u0006\u0010+\u001a\u00020,R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0007R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0007R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0007R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0007R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0007R\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0007R\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0007R\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0007R\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0007¨\u0006-"}, d2 = {"Lcom/livpure/safedrink/login/viewmodels/SignUpViewModel;", "Lcom/livpure/safedrink/common/arc/ui/viewmodels/MediatorViewModel;", "()V", "city", "Landroidx/lifecycle/MutableLiveData;", "", "getCity", "()Landroidx/lifecycle/MutableLiveData;", "cityError", "getCityError", "email", "getEmail", "emailError", "getEmailError", "isReferralCodeValidated", "", "listOfCities", "", "getListOfCities", "()Ljava/util/List;", "name", "getName", "nameError", "getNameError", "password", "getPassword", "passwordError", "getPasswordError", "phone", "getPhone", "phoneError", "getPhoneError", "referralCode", "getReferralCode", "referralCodeError", "getReferralCodeError", "isFormValid", "onReferralCodeEntered", "", DeprecatedContractsKt.INAPP_V2_MSG_CONTEXT, "Landroid/content/Context;", "onReferralCodeNotEntered", "onSignUpButtonClicked", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SignUpViewModel extends MediatorViewModel {
    private final List<String> listOfCities = CollectionsKt.mutableListOf("Delhi NCR", "Bengaluru", "Hyderabad", "Mumbai", "Kolkata", "Pune", "Chennai", "Lucknow", "Secundarabad");
    private final MutableLiveData<String> name = new MutableLiveData<>();
    private final MutableLiveData<String> email = new MutableLiveData<>();
    private final MutableLiveData<String> phone = new MutableLiveData<>();
    private final MutableLiveData<String> password = new MutableLiveData<>();
    private final MutableLiveData<String> city = new MutableLiveData<>();
    private final MutableLiveData<Boolean> isReferralCodeValidated = new MutableLiveData<>();
    private final MutableLiveData<String> referralCode = new MutableLiveData<>();
    private final MutableLiveData<String> nameError = new MutableLiveData<>();
    private final MutableLiveData<String> emailError = new MutableLiveData<>();
    private final MutableLiveData<String> phoneError = new MutableLiveData<>();
    private final MutableLiveData<String> passwordError = new MutableLiveData<>();
    private final MutableLiveData<String> referralCodeError = new MutableLiveData<>();
    private final MutableLiveData<String> cityError = new MutableLiveData<>();

    public final List<String> getListOfCities() {
        return this.listOfCities;
    }

    public final MutableLiveData<String> getName() {
        return this.name;
    }

    public final MutableLiveData<String> getEmail() {
        return this.email;
    }

    public final MutableLiveData<String> getPhone() {
        return this.phone;
    }

    public final MutableLiveData<String> getPassword() {
        return this.password;
    }

    public final MutableLiveData<String> getCity() {
        return this.city;
    }

    public final MutableLiveData<Boolean> isReferralCodeValidated() {
        return this.isReferralCodeValidated;
    }

    public final MutableLiveData<String> getReferralCode() {
        return this.referralCode;
    }

    public final MutableLiveData<String> getNameError() {
        return this.nameError;
    }

    public final MutableLiveData<String> getEmailError() {
        return this.emailError;
    }

    public final MutableLiveData<String> getPhoneError() {
        return this.phoneError;
    }

    public final MutableLiveData<String> getPasswordError() {
        return this.passwordError;
    }

    public final MutableLiveData<String> getReferralCodeError() {
        return this.referralCodeError;
    }

    public final MutableLiveData<String> getCityError() {
        return this.cityError;
    }

    public final void onSignUpButtonClicked(View view) {
        String str;
        Intrinsics.checkNotNullParameter(view, "view");
        final Context context = view.getContext();
        try {
            str = Settings.Secure.getString(context.getContentResolver(), CoreConstants.GENERIC_PARAM_V2_KEY_ANDROID_ID);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            str = "";
        }
        String value = this.name.getValue();
        String str2 = value == null ? "" : value;
        String value2 = this.email.getValue();
        String str3 = value2 == null ? "" : value2;
        String value3 = this.phone.getValue();
        String str4 = value3 == null ? "" : value3;
        String value4 = this.password.getValue();
        String str5 = value4 == null ? "" : value4;
        String value5 = this.referralCode.getValue();
        if (isFormValid(str2, str3, str4, str5, value5 == null ? "" : value5, this.city.getValue())) {
            if (LSApplication.Companion.isNetworkAvailable()) {
                getLoading().setValue(true);
                UserRepository.Companion companion = UserRepository.Companion;
                Intrinsics.checkNotNullExpressionValue(context, "context");
                UserRepository companion2 = companion.getInstance(context);
                String value6 = this.name.getValue();
                Intrinsics.checkNotNull(value6);
                String str6 = value6;
                String value7 = this.email.getValue();
                Intrinsics.checkNotNull(value7);
                String str7 = value7;
                String value8 = this.phone.getValue();
                Intrinsics.checkNotNull(value8);
                String str8 = value8;
                String value9 = this.password.getValue();
                Intrinsics.checkNotNull(value9);
                String str9 = value9;
                String value10 = this.referralCode.getValue();
                String str10 = value10 == null ? "" : value10;
                Intrinsics.checkNotNull(str);
                String value11 = this.city.getValue();
                Intrinsics.checkNotNull(value11);
                observeAndTrack(companion2.register(str6, str7, str8, str9, str10, str, value11), new Observer() { // from class: com.livpure.safedrink.login.viewmodels.SignUpViewModel$$ExternalSyntheticLambda1
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        SignUpViewModel.m1111onSignUpButtonClicked$lambda0(SignUpViewModel.this, context, (BaseDataHolder) obj);
                    }
                });
                return;
            }
            getNetworkState().setValue(BaseViewModel.NetworkState.OFFLINE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onSignUpButtonClicked$lambda-0  reason: not valid java name */
    public static final void m1111onSignUpButtonClicked$lambda0(SignUpViewModel this$0, Context context, BaseDataHolder baseDataHolder) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        User user = (User) baseDataHolder.getData();
        this$0.getLoading().setValue(false);
        if (user != null) {
            UserRepository.Companion companion = UserRepository.Companion;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            companion.getInstance(context).setUser(user);
            SegmentLogger with = SegmentLogger.Companion.with(context);
            String name = user.getName();
            String email = user.getEmail();
            String mobile = user.getMobile();
            String value = this$0.city.getValue();
            String value2 = this$0.referralCode.getValue();
            if (value2 == null) {
                value2 = "";
            }
            with.sendSignedUpEvent(name, email, mobile, value, value2);
            return;
        }
        this$0.getToastMessageLiveData().setValue(new Event<>(String.valueOf(baseDataHolder.getMessage())));
    }

    private final boolean isFormValid(String str, String str2, String str3, String str4, String str5, String str6) {
        boolean z;
        boolean z2 = true;
        if (!StringUtilsKt.isValidName(str)) {
            this.nameError.setValue(StringsKt.isBlank(str) ? "Please enter a valid name" : "Numbers and special characters like @,# etc. are not allowed");
            z = false;
        } else {
            this.nameError.setValue(null);
            z = true;
        }
        if (!StringUtilsKt.isValidEmail(str2)) {
            this.emailError.setValue("Please enter a valid email ID");
            z = false;
        } else {
            this.emailError.setValue(null);
        }
        if (!StringUtilsKt.isValidPhoneNumber(str3)) {
            this.phoneError.setValue("Please enter a valid 10-digit mobile number");
            z = false;
        } else {
            this.phoneError.setValue(null);
        }
        if (StringsKt.isBlank(str4) || str4.length() < 5) {
            this.passwordError.setValue("Please enter a valid password (min. 5 characters)");
            z = false;
        } else {
            this.passwordError.setValue(null);
        }
        String str7 = str5;
        if (!(str7 == null || StringsKt.isBlank(str7)) && (Intrinsics.areEqual((Object) this.isReferralCodeValidated.getValue(), (Object) false) || this.isReferralCodeValidated.getValue() == null)) {
            this.referralCodeError.setValue("Invalid referral code");
            z = false;
        } else {
            this.referralCodeError.setValue(null);
        }
        String str8 = str6;
        if (str8 != null && !StringsKt.isBlank(str8)) {
            z2 = false;
        }
        if (z2) {
            this.cityError.setValue("Please select a city");
            return false;
        }
        this.cityError.setValue(null);
        return z;
    }

    public final void onReferralCodeEntered(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (LSApplication.Companion.isNetworkAvailable()) {
            getLoading().setValue(true);
            try {
                String value = this.referralCode.getValue();
                Intrinsics.checkNotNull(value);
                Locale ENGLISH = Locale.ENGLISH;
                Intrinsics.checkNotNullExpressionValue(ENGLISH, "ENGLISH");
                String upperCase = value.toUpperCase(ENGLISH);
                Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(locale)");
                observeAndTrack(UserRepository.Companion.getInstance(context).validateReferralCode(upperCase), new Observer() { // from class: com.livpure.safedrink.login.viewmodels.SignUpViewModel$$ExternalSyntheticLambda0
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        SignUpViewModel.m1110onReferralCodeEntered$lambda1(SignUpViewModel.this, (BaseV1ResponseImplementation) obj);
                    }
                });
                return;
            } catch (APIException unused) {
                getLoading().setValue(false);
                getToastMessageLiveData().setValue(new Event<>("Oops! We faced an issue while validating the referral code."));
                return;
            }
        }
        getNetworkState().setValue(BaseViewModel.NetworkState.OFFLINE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onReferralCodeEntered$lambda-1  reason: not valid java name */
    public static final void m1110onReferralCodeEntered$lambda1(final SignUpViewModel this$0, BaseV1ResponseImplementation baseV1ResponseImplementation) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getLoading().setValue(false);
        Function1<BaseV1ResponseImplementation, Unit> function1 = new Function1<BaseV1ResponseImplementation, Unit>() { // from class: com.livpure.safedrink.login.viewmodels.SignUpViewModel$onReferralCodeEntered$1$onProcessed$1
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
            public final void invoke2(BaseV1ResponseImplementation response) {
                Intrinsics.checkNotNullParameter(response, "response");
                SignUpViewModel.this.getReferralCodeError().setValue(response.getMessage());
                SignUpViewModel.this.isReferralCodeValidated().setValue(response.getStatus());
            }
        };
        this$0.processResponse(baseV1ResponseImplementation, function1, function1);
    }

    public final void onReferralCodeNotEntered() {
        this.referralCodeError.setValue(null);
    }
}
