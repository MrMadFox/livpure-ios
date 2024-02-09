package com.livpure.safedrink.profile;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.provider.Settings;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.FragmentKt;
import com.amplitude.api.Constants;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.livpure.safedrink.R;
import com.livpure.safedrink.app.LSApplication;
import com.livpure.safedrink.common.UiUtilKt;
import com.livpure.safedrink.common.arc.ui.views.DataBindingFragment;
import com.livpure.safedrink.databinding.FragmentEmailMobileVerifyBinding;
import com.livpure.safedrink.login.data.models.User;
import com.livpure.safedrink.profile.api.models.response.UpdateProfileResponse;
import com.livpure.safedrink.profile.api.models.response.VerifyProfileResponse;
import com.livpure.safedrink.profile.viewmodel.EmailMobileVerifyViewModel;
import com.livpure.safedrink.utils.StringUtilsKt;
import com.moengage.core.internal.CoreConstants;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
/* compiled from: EmailMobileVerifyFragment.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00012B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0002H\u0016J\b\u0010!\u001a\u00020\u001fH\u0002J\u0010\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\u0005H\u0002J\b\u0010$\u001a\u00020%H\u0014J\b\u0010&\u001a\u00020\rH\u0014J\u001a\u0010'\u001a\u00020\u00132\b\u0010(\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0002J\b\u0010)\u001a\u00020\u0013H\u0002J\u0006\u0010*\u001a\u00020\u001fJ\b\u0010+\u001a\u00020\u001fH\u0016J\u001a\u0010,\u001a\u00020\u001f2\u0006\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\b\u00101\u001a\u00020\u001fH\u0002R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u00063"}, d2 = {"Lcom/livpure/safedrink/profile/EmailMobileVerifyFragment;", "Lcom/livpure/safedrink/common/arc/ui/views/DataBindingFragment;", "Lcom/livpure/safedrink/databinding/FragmentEmailMobileVerifyBinding;", "()V", "deviceAppUID", "", "getDeviceAppUID", "()Ljava/lang/String;", "setDeviceAppUID", "(Ljava/lang/String;)V", "email", "emailMobile", "emailMobileVerifyViewModel", "Lcom/livpure/safedrink/profile/viewmodel/EmailMobileVerifyViewModel;", "getEmailMobileVerifyViewModel", "()Lcom/livpure/safedrink/profile/viewmodel/EmailMobileVerifyViewModel;", "emailMobileVerifyViewModel$delegate", "Lkotlin/Lazy;", "isRunning", "", "()Z", "setRunning", "(Z)V", "mobile", "myTimer", "Landroid/os/CountDownTimer;", "getMyTimer", "()Landroid/os/CountDownTimer;", "setMyTimer", "(Landroid/os/CountDownTimer;)V", "bindVariablesToView", "", "dataBinding", "callSendOtpApi", "callVerifyOtp", "otp", "getLayoutId", "", "getViewModel", "isFormValid", "username", "isOtpValid", "listeners", "onStop", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "setTimer", "EmojiExcludeFilter", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class EmailMobileVerifyFragment extends DataBindingFragment<FragmentEmailMobileVerifyBinding> {
    private boolean isRunning;
    private CountDownTimer myTimer;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private final Lazy emailMobileVerifyViewModel$delegate = LazyKt.lazy(new Function0<EmailMobileVerifyViewModel>() { // from class: com.livpure.safedrink.profile.EmailMobileVerifyFragment$emailMobileVerifyViewModel$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final EmailMobileVerifyViewModel invoke() {
            return (EmailMobileVerifyViewModel) new ViewModelProvider(EmailMobileVerifyFragment.this).get(EmailMobileVerifyViewModel.class);
        }
    });
    private String emailMobile = "";
    private String email = "";
    private String mobile = "";
    private String deviceAppUID = "";

    @Override // com.livpure.safedrink.common.arc.ui.views.DataBindingFragment, com.livpure.safedrink.common.arc.ui.views.BaseFragment
    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.DataBindingFragment, com.livpure.safedrink.common.arc.ui.views.BaseFragment
    public View _$_findCachedViewById(int i) {
        View findViewById;
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View view2 = getView();
            if (view2 == null || (findViewById = view2.findViewById(i)) == null) {
                return null;
            }
            map.put(Integer.valueOf(i), findViewById);
            return findViewById;
        }
        return view;
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.DataBindingFragment
    public void bindVariablesToView(FragmentEmailMobileVerifyBinding dataBinding) {
        Intrinsics.checkNotNullParameter(dataBinding, "dataBinding");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment
    public int getLayoutId() {
        return R.layout.fragment_email_mobile_verify;
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.DataBindingFragment, com.livpure.safedrink.common.arc.ui.views.BaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    private final EmailMobileVerifyViewModel getEmailMobileVerifyViewModel() {
        return (EmailMobileVerifyViewModel) this.emailMobileVerifyViewModel$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment
    public EmailMobileVerifyViewModel getViewModel() {
        return getEmailMobileVerifyViewModel();
    }

    public final String getDeviceAppUID() {
        return this.deviceAppUID;
    }

    public final void setDeviceAppUID(String str) {
        this.deviceAppUID = str;
    }

    public final CountDownTimer getMyTimer() {
        return this.myTimer;
    }

    public final void setMyTimer(CountDownTimer countDownTimer) {
        this.myTimer = countDownTimer;
    }

    public final boolean isRunning() {
        return this.isRunning;
    }

    public final void setRunning(boolean z) {
        this.isRunning = z;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        CountDownTimer countDownTimer = this.myTimer;
        if (countDownTimer == null || countDownTimer == null) {
            return;
        }
        countDownTimer.cancel();
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        this.emailMobile = String.valueOf(arguments != null ? arguments.getString("EmailMobile") : null);
        try {
            Context context = getContext();
            this.deviceAppUID = Settings.Secure.getString(context != null ? context.getContentResolver() : null, CoreConstants.GENERIC_PARAM_V2_KEY_ANDROID_ID);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        if (Intrinsics.areEqual(this.emailMobile, "Email")) {
            ((TextView) _$_findCachedViewById(R.id.textEmailMobile)).setText(getString(R.string.label_email));
            ((EditText) _$_findCachedViewById(R.id.editEmailMobile)).setHint(getString(R.string.hint_email_id));
            ((EditText) _$_findCachedViewById(R.id.editEmailMobile)).setInputType(33);
            ((EditText) _$_findCachedViewById(R.id.editEmailMobile)).setFilters(new InputFilter[]{new InputFilter.LengthFilter(100)});
        } else {
            ((TextView) _$_findCachedViewById(R.id.textEmailMobile)).setText(getString(R.string.label_mobile));
            ((EditText) _$_findCachedViewById(R.id.editEmailMobile)).setHint(getString(R.string.hint_mobile_number));
            ((EditText) _$_findCachedViewById(R.id.editEmailMobile)).setInputType(2);
            ((EditText) _$_findCachedViewById(R.id.editEmailMobile)).setFilters(new InputFilter[]{new InputFilter.LengthFilter(10)});
        }
        ((EditText) _$_findCachedViewById(R.id.editTextNumber)).addTextChangedListener(new TextWatcher() { // from class: com.livpure.safedrink.profile.EmailMobileVerifyFragment$onViewCreated$1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (i2 == 1) {
                    ((EditText) EmailMobileVerifyFragment.this._$_findCachedViewById(R.id.editTextNumber2)).requestFocus();
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int i, int i2, int i3) {
                Intrinsics.checkNotNullParameter(s, "s");
                if (i3 == 1) {
                    ((EditText) EmailMobileVerifyFragment.this._$_findCachedViewById(R.id.editTextNumber2)).requestFocus();
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (((EditText) EmailMobileVerifyFragment.this._$_findCachedViewById(R.id.editTextNumber)).getText().length() == 1) {
                    ((EditText) EmailMobileVerifyFragment.this._$_findCachedViewById(R.id.editTextNumber2)).requestFocus();
                }
            }
        });
        ((EditText) _$_findCachedViewById(R.id.editTextNumber2)).addTextChangedListener(new TextWatcher() { // from class: com.livpure.safedrink.profile.EmailMobileVerifyFragment$onViewCreated$2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (i2 == 1) {
                    ((EditText) EmailMobileVerifyFragment.this._$_findCachedViewById(R.id.editTextNumber3)).requestFocus();
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int i, int i2, int i3) {
                Intrinsics.checkNotNullParameter(s, "s");
                if (i3 == 1) {
                    ((EditText) EmailMobileVerifyFragment.this._$_findCachedViewById(R.id.editTextNumber3)).requestFocus();
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (((EditText) EmailMobileVerifyFragment.this._$_findCachedViewById(R.id.editTextNumber2)).getText().length() == 1) {
                    ((EditText) EmailMobileVerifyFragment.this._$_findCachedViewById(R.id.editTextNumber3)).requestFocus();
                }
            }
        });
        ((EditText) _$_findCachedViewById(R.id.editTextNumber3)).addTextChangedListener(new TextWatcher() { // from class: com.livpure.safedrink.profile.EmailMobileVerifyFragment$onViewCreated$3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (i2 == 1) {
                    ((EditText) EmailMobileVerifyFragment.this._$_findCachedViewById(R.id.editTextNumber4)).requestFocus();
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int i, int i2, int i3) {
                Intrinsics.checkNotNullParameter(s, "s");
                if (i3 == 1) {
                    ((EditText) EmailMobileVerifyFragment.this._$_findCachedViewById(R.id.editTextNumber4)).requestFocus();
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (((EditText) EmailMobileVerifyFragment.this._$_findCachedViewById(R.id.editTextNumber3)).getText().length() == 1) {
                    ((EditText) EmailMobileVerifyFragment.this._$_findCachedViewById(R.id.editTextNumber4)).requestFocus();
                }
            }
        });
        ((EditText) _$_findCachedViewById(R.id.editTextNumber4)).addTextChangedListener(new TextWatcher() { // from class: com.livpure.safedrink.profile.EmailMobileVerifyFragment$onViewCreated$4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (i2 == 1) {
                    ((TextView) EmailMobileVerifyFragment.this._$_findCachedViewById(R.id.btnVerify)).requestFocus();
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int i, int i2, int i3) {
                Intrinsics.checkNotNullParameter(s, "s");
                if (i3 == 1) {
                    ((TextView) EmailMobileVerifyFragment.this._$_findCachedViewById(R.id.btnVerify)).requestFocus();
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (((EditText) EmailMobileVerifyFragment.this._$_findCachedViewById(R.id.editTextNumber4)).getText().length() == 1) {
                    ((TextView) EmailMobileVerifyFragment.this._$_findCachedViewById(R.id.btnVerify)).requestFocus();
                }
            }
        });
        listeners();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.livpure.safedrink.profile.EmailMobileVerifyFragment$setTimer$1] */
    private final void setTimer() {
        this.myTimer = new CountDownTimer() { // from class: com.livpure.safedrink.profile.EmailMobileVerifyFragment$setTimer$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(Constants.EVENT_UPLOAD_PERIOD_MILLIS, 1000L);
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                if (EmailMobileVerifyFragment.this.getMyTimer() != null) {
                    ((TextView) EmailMobileVerifyFragment.this._$_findCachedViewById(R.id.textTimer)).setText("seconds remaining: " + (j / 1000));
                }
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                EmailMobileVerifyFragment.this.setRunning(false);
                ((TextView) EmailMobileVerifyFragment.this._$_findCachedViewById(R.id.btnResend)).setBackgroundResource(R.drawable.border_popular);
            }
        }.start();
    }

    public final void listeners() {
        ((TextView) _$_findCachedViewById(R.id.btnVerify)).setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.profile.EmailMobileVerifyFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EmailMobileVerifyFragment.m1115listeners$lambda0(EmailMobileVerifyFragment.this, view);
            }
        });
        ((TextView) _$_findCachedViewById(R.id.btnResend)).setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.profile.EmailMobileVerifyFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EmailMobileVerifyFragment.m1116listeners$lambda1(EmailMobileVerifyFragment.this, view);
            }
        });
        ((TextView) _$_findCachedViewById(R.id.btnSubmit)).setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.profile.EmailMobileVerifyFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EmailMobileVerifyFragment.m1117listeners$lambda2(EmailMobileVerifyFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: listeners$lambda-0  reason: not valid java name */
    public static final void m1115listeners$lambda0(EmailMobileVerifyFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.isFormValid(StringsKt.replace$default(((EditText) this$0._$_findCachedViewById(R.id.editEmailMobile)).getText().toString(), " ", "", false, 4, (Object) null), this$0.emailMobile)) {
            if (this$0.isAdded()) {
                UiUtilKt.hideKeyboard(this$0.requireActivity());
            }
            if (LSApplication.Companion.isNetworkAvailable()) {
                this$0.callSendOtpApi();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: listeners$lambda-1  reason: not valid java name */
    public static final void m1116listeners$lambda1(EmailMobileVerifyFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.isRunning) {
            return;
        }
        ((EditText) this$0._$_findCachedViewById(R.id.editTextNumber)).setText("");
        ((EditText) this$0._$_findCachedViewById(R.id.editTextNumber2)).setText("");
        ((EditText) this$0._$_findCachedViewById(R.id.editTextNumber3)).setText("");
        ((EditText) this$0._$_findCachedViewById(R.id.editTextNumber4)).setText("");
        ((EditText) this$0._$_findCachedViewById(R.id.editTextNumber)).setBackgroundResource(R.drawable.border);
        ((EditText) this$0._$_findCachedViewById(R.id.editTextNumber2)).setBackgroundResource(R.drawable.border);
        ((EditText) this$0._$_findCachedViewById(R.id.editTextNumber3)).setBackgroundResource(R.drawable.border);
        ((EditText) this$0._$_findCachedViewById(R.id.editTextNumber4)).setBackgroundResource(R.drawable.border);
        ((TextView) this$0._$_findCachedViewById(R.id.btnResend)).setBackgroundResource(R.drawable.border_disable);
        ((EditText) this$0._$_findCachedViewById(R.id.editTextNumber)).requestFocus();
        ((TextView) this$0._$_findCachedViewById(R.id.btnVerify)).performClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: listeners$lambda-2  reason: not valid java name */
    public static final void m1117listeners$lambda2(EmailMobileVerifyFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.isOtpValid()) {
            this$0.isRunning = false;
            ((TextView) this$0._$_findCachedViewById(R.id.btnResend)).setBackgroundResource(R.drawable.border_popular);
            CountDownTimer countDownTimer = this$0.myTimer;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            this$0.myTimer = null;
            ((TextView) this$0._$_findCachedViewById(R.id.textTimer)).setText("seconds remaining: 0");
            if (this$0.isAdded()) {
                UiUtilKt.hideKeyboard(this$0.requireActivity());
            }
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("%s%s%s%s", Arrays.copyOf(new Object[]{((EditText) this$0._$_findCachedViewById(R.id.editTextNumber)).getText(), ((EditText) this$0._$_findCachedViewById(R.id.editTextNumber2)).getText(), ((EditText) this$0._$_findCachedViewById(R.id.editTextNumber3)).getText(), ((EditText) this$0._$_findCachedViewById(R.id.editTextNumber4)).getText()}, 4));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            if (LSApplication.Companion.isNetworkAvailable()) {
                this$0.callVerifyOtp(format);
            }
        }
    }

    private final void callVerifyOtp(String str) {
        EmailMobileVerifyViewModel emailMobileVerifyViewModel = getEmailMobileVerifyViewModel();
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        emailMobileVerifyViewModel.onOtpVerify(requireActivity, this.email, this.mobile, str).observe(getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.profile.EmailMobileVerifyFragment$$ExternalSyntheticLambda4
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EmailMobileVerifyFragment.m1114callVerifyOtp$lambda3(EmailMobileVerifyFragment.this, (VerifyProfileResponse) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: callVerifyOtp$lambda-3  reason: not valid java name */
    public static final void m1114callVerifyOtp$lambda3(EmailMobileVerifyFragment this$0, VerifyProfileResponse verifyProfileResponse) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!verifyProfileResponse.equals("timeout")) {
            if (Intrinsics.areEqual((Object) verifyProfileResponse.getStatus(), (Object) true)) {
                if (Intrinsics.areEqual(this$0.emailMobile, "Email")) {
                    User user = LSApplication.Companion.getUser();
                    if (user != null) {
                        user.setEmail(((EditText) this$0._$_findCachedViewById(R.id.editEmailMobile)).getText().toString());
                    }
                } else {
                    User user2 = LSApplication.Companion.getUser();
                    if (user2 != null) {
                        user2.setMobile(((EditText) this$0._$_findCachedViewById(R.id.editEmailMobile)).getText().toString());
                    }
                }
                CountDownTimer countDownTimer = this$0.myTimer;
                if (countDownTimer != null && countDownTimer != null) {
                    countDownTimer.cancel();
                }
                FragmentKt.findNavController(this$0).popBackStack();
                return;
            }
            ((EditText) this$0._$_findCachedViewById(R.id.editTextNumber)).setText("");
            ((EditText) this$0._$_findCachedViewById(R.id.editTextNumber2)).setText("");
            ((EditText) this$0._$_findCachedViewById(R.id.editTextNumber3)).setText("");
            ((EditText) this$0._$_findCachedViewById(R.id.editTextNumber4)).setText("");
            ((EditText) this$0._$_findCachedViewById(R.id.editTextNumber)).requestFocus();
            return;
        }
        Toast.makeText(this$0.getActivity(), "Something went wrong, please try again", 0).show();
    }

    private final void callSendOtpApi() {
        EmailMobileVerifyViewModel emailMobileVerifyViewModel = getEmailMobileVerifyViewModel();
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        emailMobileVerifyViewModel.onSendOtp(requireActivity, this.email, this.mobile).observe(getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.profile.EmailMobileVerifyFragment$$ExternalSyntheticLambda3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EmailMobileVerifyFragment.m1113callSendOtpApi$lambda4(EmailMobileVerifyFragment.this, (UpdateProfileResponse) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: callSendOtpApi$lambda-4  reason: not valid java name */
    public static final void m1113callSendOtpApi$lambda4(EmailMobileVerifyFragment this$0, UpdateProfileResponse updateProfileResponse) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!updateProfileResponse.equals("timeout")) {
            if (Intrinsics.areEqual((Object) updateProfileResponse.getStatus(), (Object) true)) {
                ((TextView) this$0._$_findCachedViewById(R.id.btnVerify)).setVisibility(8);
                ((LinearLayout) this$0._$_findCachedViewById(R.id.layoutVerify)).setVisibility(0);
                this$0.isRunning = true;
                CountDownTimer countDownTimer = this$0.myTimer;
                if (countDownTimer == null) {
                    this$0.setTimer();
                    return;
                } else if (countDownTimer != null) {
                    countDownTimer.start();
                    return;
                } else {
                    return;
                }
            }
            return;
        }
        Toast.makeText(this$0.getActivity(), "Something went wrong, please try again", 0).show();
    }

    private final boolean isFormValid(String str, String str2) {
        if (Intrinsics.areEqual(str2, "Email")) {
            if (!StringUtilsKt.isValidEmail(str)) {
                ((EditText) _$_findCachedViewById(R.id.editEmailMobile)).setHint("Please enter a valid email ID");
                ((EditText) _$_findCachedViewById(R.id.editEmailMobile)).setBackgroundResource(R.drawable.edit_text_border_error);
                ((EditText) _$_findCachedViewById(R.id.editEmailMobile)).setHintTextColor(ContextCompat.getColor(requireContext(), R.color.colorRed));
                Toast.makeText(getActivity(), "Please enter a valid email ID", 0).show();
            } else {
                this.email = ((EditText) _$_findCachedViewById(R.id.editEmailMobile)).getText().toString();
                ((EditText) _$_findCachedViewById(R.id.editEmailMobile)).setHint((CharSequence) null);
                ((EditText) _$_findCachedViewById(R.id.editEmailMobile)).setBackgroundResource(R.drawable.edittextbox);
                ((EditText) _$_findCachedViewById(R.id.editEmailMobile)).setHintTextColor(ContextCompat.getColor(requireContext(), R.color.livpure_purple_dark));
                return true;
            }
        } else if (!StringUtilsKt.isValidPhoneNumber(str)) {
            ((EditText) _$_findCachedViewById(R.id.editEmailMobile)).setHint("Please enter a valid 10-digit mobile number");
            ((EditText) _$_findCachedViewById(R.id.editEmailMobile)).setBackgroundResource(R.drawable.edit_text_border_error);
            ((EditText) _$_findCachedViewById(R.id.editEmailMobile)).setHintTextColor(ContextCompat.getColor(requireContext(), R.color.colorRed));
            Toast.makeText(getActivity(), "Please enter a valid 10-digit mobile number", 0).show();
        } else {
            this.mobile = ((EditText) _$_findCachedViewById(R.id.editEmailMobile)).getText().toString();
            ((EditText) _$_findCachedViewById(R.id.editEmailMobile)).setHint((CharSequence) null);
            ((EditText) _$_findCachedViewById(R.id.editEmailMobile)).setBackgroundResource(R.drawable.edittextbox);
            ((EditText) _$_findCachedViewById(R.id.editEmailMobile)).setHintTextColor(ContextCompat.getColor(requireContext(), R.color.livpure_purple_dark));
            return true;
        }
        return false;
    }

    private final boolean isOtpValid() {
        if (!Intrinsics.areEqual(((EditText) _$_findCachedViewById(R.id.editTextNumber)).getText().toString(), "") && !Intrinsics.areEqual(((EditText) _$_findCachedViewById(R.id.editTextNumber2)).getText().toString(), "") && !Intrinsics.areEqual(((EditText) _$_findCachedViewById(R.id.editTextNumber3)).getText().toString(), "") && !Intrinsics.areEqual(((EditText) _$_findCachedViewById(R.id.editTextNumber4)).getText().toString(), "")) {
            ((EditText) _$_findCachedViewById(R.id.editTextNumber)).setBackgroundResource(R.drawable.border);
            ((EditText) _$_findCachedViewById(R.id.editTextNumber2)).setBackgroundResource(R.drawable.border);
            ((EditText) _$_findCachedViewById(R.id.editTextNumber3)).setBackgroundResource(R.drawable.border);
            ((EditText) _$_findCachedViewById(R.id.editTextNumber4)).setBackgroundResource(R.drawable.border);
            return true;
        }
        ((EditText) _$_findCachedViewById(R.id.editTextNumber)).setBackgroundResource(R.drawable.edit_text_border_error);
        ((EditText) _$_findCachedViewById(R.id.editTextNumber2)).setBackgroundResource(R.drawable.edit_text_border_error);
        ((EditText) _$_findCachedViewById(R.id.editTextNumber3)).setBackgroundResource(R.drawable.edit_text_border_error);
        ((EditText) _$_findCachedViewById(R.id.editTextNumber4)).setBackgroundResource(R.drawable.edit_text_border_error);
        Toast.makeText(getActivity(), "Please enter the OTP", 0).show();
        return false;
    }

    /* compiled from: EmailMobileVerifyFragment.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J:\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007H\u0016¨\u0006\r"}, d2 = {"Lcom/livpure/safedrink/profile/EmailMobileVerifyFragment$EmojiExcludeFilter;", "Landroid/text/InputFilter$LengthFilter;", "()V", "filter", "", "source", "start", "", "end", "dest", "Landroid/text/Spanned;", "dstart", "dend", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class EmojiExcludeFilter extends InputFilter.LengthFilter {
        public EmojiExcludeFilter() {
            super(10);
        }

        @Override // android.text.InputFilter.LengthFilter, android.text.InputFilter
        public CharSequence filter(CharSequence source, int i, int i2, Spanned dest, int i3, int i4) {
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(dest, "dest");
            while (i < i2) {
                int type = Character.getType(source.charAt(i));
                if (type == 19 || type == 28) {
                    return "";
                }
                i++;
            }
            return null;
        }
    }
}
