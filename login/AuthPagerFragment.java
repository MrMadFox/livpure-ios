package com.livpure.safedrink.login;

import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.TextView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.NavArgsLazy;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.FragmentKt;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.livpure.safedrink.NavGraphDirections;
import com.livpure.safedrink.R;
import com.livpure.safedrink.app.LSApplication;
import com.livpure.safedrink.app.MainViewModel;
import com.livpure.safedrink.common.arc.ui.views.DataBindingFragment;
import com.livpure.safedrink.databinding.FragmentSignInBinding;
import com.livpure.safedrink.login.data.models.User;
import com.livpure.safedrink.login.viewmodels.SignInViewModel;
import com.livpure.safedrink.utils.Constant;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
/* compiled from: AuthPagerFragment.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0002H\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010 \u001a\u00020\u001fH\u0002J\b\u0010!\u001a\u00020\u0005H\u0014J\b\u0010\"\u001a\u00020\u0013H\u0014J\b\u0010#\u001a\u00020\u001fH\u0014J\u0012\u0010$\u001a\u00020\u001c2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u0006\u0010'\u001a\u00020\u001cJ\b\u0010(\u001a\u00020\u001cH\u0002J\u001a\u0010)\u001a\u00020\u001c2\u0006\u0010*\u001a\u00020+2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u0010,\u001a\u00020\u001cH\u0002J\b\u0010-\u001a\u00020\u001cH\u0002J\b\u0010.\u001a\u00020\u001cH\u0002J\b\u0010/\u001a\u00020\u001cH\u0002J\b\u00100\u001a\u00020\u001cH\u0002J\b\u00101\u001a\u00020\u001cH\u0002J\b\u00102\u001a\u00020\u001cH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001a¨\u00063"}, d2 = {"Lcom/livpure/safedrink/login/AuthPagerFragment;", "Lcom/livpure/safedrink/common/arc/ui/views/DataBindingFragment;", "Lcom/livpure/safedrink/databinding/FragmentSignInBinding;", "()V", "LOCATION_PERMISSION_CODE", "", "mainViewModel", "Lcom/livpure/safedrink/app/MainViewModel;", "getMainViewModel", "()Lcom/livpure/safedrink/app/MainViewModel;", "mainViewModel$delegate", "Lkotlin/Lazy;", "navArgs", "Lcom/livpure/safedrink/login/AuthPagerFragmentArgs;", "getNavArgs", "()Lcom/livpure/safedrink/login/AuthPagerFragmentArgs;", "navArgs$delegate", "Landroidx/navigation/NavArgsLazy;", "signInViewModel", "Lcom/livpure/safedrink/login/viewmodels/SignInViewModel;", "getSignInViewModel", "()Lcom/livpure/safedrink/login/viewmodels/SignInViewModel;", "signInViewModel$delegate", "tabTitles", "", "", "[Ljava/lang/String;", "bindVariablesToView", "", "dataBinding", "checkIfLocationPermissionGranted", "", "checkPermission", "getLayoutId", "getViewModel", "isToolbarVisible", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onRequestPermissionsResult", "onTermsAndConditionsClicked", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "requestPermission", "setTermConditionAndPolicy", "showForgotPasswordScreen", "showOnboardingScreen", "showPrivacyPolicy", "showSignUp", "showTermsAndConditions", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AuthPagerFragment extends DataBindingFragment<FragmentSignInBinding> {
    private final Lazy mainViewModel$delegate;
    private final NavArgsLazy navArgs$delegate;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private final Lazy signInViewModel$delegate = LazyKt.lazy(new Function0<SignInViewModel>() { // from class: com.livpure.safedrink.login.AuthPagerFragment$signInViewModel$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final SignInViewModel invoke() {
            return (SignInViewModel) new ViewModelProvider(AuthPagerFragment.this).get(SignInViewModel.class);
        }
    });
    private final String[] tabTitles = {Constant.SING_UP_LINK, "Sign In"};
    private final int LOCATION_PERMISSION_CODE = 2;

    /* compiled from: AuthPagerFragment.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MainViewModel.AuthNavigationStates.values().length];
            iArr[MainViewModel.AuthNavigationStates.ONBOARDING.ordinal()] = 1;
            iArr[MainViewModel.AuthNavigationStates.TERMS_AND_CONDITIONS.ordinal()] = 2;
            iArr[MainViewModel.AuthNavigationStates.FORGOT_PASSWORD.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment
    public int getLayoutId() {
        return R.layout.fragment_sign_in;
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment
    protected boolean isToolbarVisible() {
        return false;
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.DataBindingFragment, com.livpure.safedrink.common.arc.ui.views.BaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public AuthPagerFragment() {
        final AuthPagerFragment authPagerFragment = this;
        this.mainViewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(authPagerFragment, Reflection.getOrCreateKotlinClass(MainViewModel.class), new Function0<ViewModelStore>() { // from class: com.livpure.safedrink.login.AuthPagerFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = Fragment.this.requireActivity().getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "requireActivity().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<CreationExtras>() { // from class: com.livpure.safedrink.login.AuthPagerFragment$special$$inlined$activityViewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function0 = Function0.this;
                if (function0 == null || (creationExtras = (CreationExtras) function0.invoke()) == null) {
                    CreationExtras defaultViewModelCreationExtras = authPagerFragment.requireActivity().getDefaultViewModelCreationExtras();
                    Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "requireActivity().defaultViewModelCreationExtras");
                    return defaultViewModelCreationExtras;
                }
                return creationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.livpure.safedrink.login.AuthPagerFragment$special$$inlined$activityViewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                ViewModelProvider.Factory defaultViewModelProviderFactory = Fragment.this.requireActivity().getDefaultViewModelProviderFactory();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.navArgs$delegate = new NavArgsLazy(Reflection.getOrCreateKotlinClass(AuthPagerFragmentArgs.class), new Function0<Bundle>() { // from class: com.livpure.safedrink.login.AuthPagerFragment$special$$inlined$navArgs$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Bundle invoke() {
                Bundle arguments = Fragment.this.getArguments();
                if (arguments != null) {
                    return arguments;
                }
                throw new IllegalStateException("Fragment " + Fragment.this + " has null arguments");
            }
        });
    }

    private final SignInViewModel getSignInViewModel() {
        return (SignInViewModel) this.signInViewModel$delegate.getValue();
    }

    private final MainViewModel getMainViewModel() {
        return (MainViewModel) this.mainViewModel$delegate.getValue();
    }

    private final AuthPagerFragmentArgs getNavArgs() {
        return (AuthPagerFragmentArgs) this.navArgs$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment
    public SignInViewModel getViewModel() {
        return getSignInViewModel();
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getMainViewModel().getAuthNavigationState(this).observe(this, new Observer() { // from class: com.livpure.safedrink.login.AuthPagerFragment$$ExternalSyntheticLambda2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AuthPagerFragment.m1055onCreate$lambda0(AuthPagerFragment.this, (MainViewModel.AuthNavigationStates) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onCreate$lambda-0  reason: not valid java name */
    public static final void m1055onCreate$lambda0(AuthPagerFragment this$0, MainViewModel.AuthNavigationStates authNavigationStates) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = authNavigationStates == null ? -1 : WhenMappings.$EnumSwitchMapping$0[authNavigationStates.ordinal()];
        if (i == 1) {
            MainViewModel mainViewModel = this$0.getMainViewModel();
            FragmentActivity requireActivity = this$0.requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            mainViewModel.setOnBoardingShown(requireActivity);
            this$0.showOnboardingScreen();
        } else if (i == 2) {
            this$0.showTermsAndConditions();
        } else if (i == 3) {
            this$0.showForgotPasswordScreen();
        } else if (this$0.getNavArgs().getAuthType() == 0) {
            this$0.showSignUp();
        } else if (Build.VERSION.SDK_INT < 23 || this$0.checkPermission()) {
        } else {
            this$0.requestPermission();
        }
    }

    private final void onTermsAndConditionsClicked() {
        getMainViewModel().onTermsAndConditionsClick();
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        ((TextView) _$_findCachedViewById(R.id.forgotPasswordText)).setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.login.AuthPagerFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AuthPagerFragment.m1056onViewCreated$lambda1(AuthPagerFragment.this, view2);
            }
        });
        ((TextView) _$_findCachedViewById(R.id.createAccountText)).setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.login.AuthPagerFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AuthPagerFragment.m1057onViewCreated$lambda2(AuthPagerFragment.this, view2);
            }
        });
        setTermConditionAndPolicy();
        try {
            if (!checkIfLocationPermissionGranted()) {
                onRequestPermissionsResult();
            }
        } catch (Exception unused) {
        }
        try {
            if (checkPermission()) {
                return;
            }
            requestPermission();
        } catch (Exception unused2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-1  reason: not valid java name */
    public static final void m1056onViewCreated$lambda1(AuthPagerFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getMainViewModel().onForgotPasswordClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-2  reason: not valid java name */
    public static final void m1057onViewCreated$lambda2(AuthPagerFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.showSignUp();
    }

    private final void setTermConditionAndPolicy() {
        SpannableString spannableString = new SpannableString("By creating an account for Livpure Smart, you agree to our Terms of Use and Privacy Policy");
        spannableString.setSpan(new ClickableSpan() { // from class: com.livpure.safedrink.login.AuthPagerFragment$setTermConditionAndPolicy$teremsAndCondition$1
            @Override // android.text.style.ClickableSpan
            public void onClick(View textView) {
                Intrinsics.checkNotNullParameter(textView, "textView");
                AuthPagerFragment.this.showTermsAndConditions();
            }
        }, 59, 72, 0);
        spannableString.setSpan(new ClickableSpan() { // from class: com.livpure.safedrink.login.AuthPagerFragment$setTermConditionAndPolicy$privacy$1
            @Override // android.text.style.ClickableSpan
            public void onClick(View textView) {
                Intrinsics.checkNotNullParameter(textView, "textView");
                AuthPagerFragment.this.showPrivacyPolicy();
            }
        }, 76, 90, 0);
        spannableString.setSpan(new ForegroundColorSpan((int) ViewCompat.MEASURED_STATE_MASK), 59, 72, 0);
        spannableString.setSpan(new ForegroundColorSpan((int) ViewCompat.MEASURED_STATE_MASK), 76, 90, 0);
        spannableString.setSpan(new StyleSpan(1), 59, 72, 0);
        spannableString.setSpan(new StyleSpan(1), 76, 90, 0);
        spannableString.setSpan(new UnderlineSpan(), 59, 72, 0);
        spannableString.setSpan(new UnderlineSpan(), 76, 90, 0);
        ((TextView) _$_findCachedViewById(R.id.termsText)).setMovementMethod(LinkMovementMethod.getInstance());
        ((TextView) _$_findCachedViewById(R.id.termsText)).setText(spannableString, TextView.BufferType.SPANNABLE);
        ((TextView) _$_findCachedViewById(R.id.termsText)).setSelected(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showPrivacyPolicy() {
        NavGraphDirections.ActionGlobalWebViewFragment actionGlobalWebViewFragment = AuthPagerFragmentDirections.actionGlobalWebViewFragment(R.string.privacy_policy);
        Intrinsics.checkNotNullExpressionValue(actionGlobalWebViewFragment, "actionGlobalWebViewFragm…(R.string.privacy_policy)");
        FragmentKt.findNavController(this).navigate(actionGlobalWebViewFragment);
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.DataBindingFragment
    public void bindVariablesToView(FragmentSignInBinding dataBinding) {
        Intrinsics.checkNotNullParameter(dataBinding, "dataBinding");
        dataBinding.setViewModel(getSignInViewModel());
    }

    private final void showOnboardingScreen() {
        String str;
        String str2;
        String str3;
        String str4;
        String planName;
        String planName2;
        String planName3;
        String planName4;
        try {
            User user = LSApplication.Companion.getUser();
            if (user == null || (planName4 = user.getPlanName()) == null) {
                str = null;
            } else {
                Locale locale = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
                str = planName4.toLowerCase(locale);
                Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String).toLowerCase(locale)");
            }
            if (!StringsKt.equals$default(str, "furlenco", false, 2, null)) {
                User user2 = LSApplication.Companion.getUser();
                if (user2 == null || (planName3 = user2.getPlanName()) == null) {
                    str2 = null;
                } else {
                    Locale locale2 = Locale.getDefault();
                    Intrinsics.checkNotNullExpressionValue(locale2, "getDefault()");
                    str2 = planName3.toLowerCase(locale2);
                    Intrinsics.checkNotNullExpressionValue(str2, "this as java.lang.String).toLowerCase(locale)");
                }
                if (!StringsKt.equals$default(str2, "rentmojo", false, 2, null)) {
                    User user3 = LSApplication.Companion.getUser();
                    if (user3 == null || (planName2 = user3.getPlanName()) == null) {
                        str3 = null;
                    } else {
                        Locale locale3 = Locale.getDefault();
                        Intrinsics.checkNotNullExpressionValue(locale3, "getDefault()");
                        str3 = planName2.toLowerCase(locale3);
                        Intrinsics.checkNotNullExpressionValue(str3, "this as java.lang.String).toLowerCase(locale)");
                    }
                    if (!StringsKt.equals$default(str3, "rentomojo", false, 2, null)) {
                        User user4 = LSApplication.Companion.getUser();
                        if (user4 == null || (planName = user4.getPlanName()) == null) {
                            str4 = null;
                        } else {
                            Locale locale4 = Locale.getDefault();
                            Intrinsics.checkNotNullExpressionValue(locale4, "getDefault()");
                            str4 = planName.toLowerCase(locale4);
                            Intrinsics.checkNotNullExpressionValue(str4, "this as java.lang.String).toLowerCase(locale)");
                        }
                        if (!StringsKt.equals$default(str4, "b2b", false, 2, null)) {
                            NavDirections actionAuthPagerFragmentToOnboardingFragment = AuthPagerFragmentDirections.actionAuthPagerFragmentToOnboardingFragment();
                            Intrinsics.checkNotNullExpressionValue(actionAuthPagerFragmentToOnboardingFragment, "actionAuthPagerFragmentToOnboardingFragment()");
                            FragmentKt.findNavController(this).navigate(actionAuthPagerFragmentToOnboardingFragment);
                            return;
                        }
                    }
                }
            }
            NavDirections actionGlobalHomeFurlencoFragment = AuthPagerFragmentDirections.actionGlobalHomeFurlencoFragment();
            Intrinsics.checkNotNullExpressionValue(actionGlobalHomeFurlencoFragment, "actionGlobalHomeFurlencoFragment()");
            FragmentKt.findNavController(this).navigate(actionGlobalHomeFurlencoFragment);
        } catch (Exception unused) {
        }
    }

    private final void showSignUp() {
        NavGraphDirections.ActionGlobalOnBoardingWebViewFragment actionGlobalOnBoardingWebViewFragment = AuthPagerFragmentDirections.actionGlobalOnBoardingWebViewFragment(R.string.onboarding);
        Intrinsics.checkNotNullExpressionValue(actionGlobalOnBoardingWebViewFragment, "actionGlobalOnBoardingWe…ment(R.string.onboarding)");
        FragmentKt.findNavController(this).navigate(actionGlobalOnBoardingWebViewFragment);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showTermsAndConditions() {
        NavGraphDirections.ActionGlobalWebViewFragment actionGlobalWebViewFragment = AuthPagerFragmentDirections.actionGlobalWebViewFragment(R.string.terms_of_use);
        Intrinsics.checkNotNullExpressionValue(actionGlobalWebViewFragment, "actionGlobalWebViewFragment(R.string.terms_of_use)");
        FragmentKt.findNavController(this).navigate(actionGlobalWebViewFragment);
    }

    private final void showForgotPasswordScreen() {
        NavDirections actionAuthPagerFragmentToForgotPasswordFragment = AuthPagerFragmentDirections.actionAuthPagerFragmentToForgotPasswordFragment();
        Intrinsics.checkNotNullExpressionValue(actionAuthPagerFragmentToForgotPasswordFragment, "actionAuthPagerFragmentToForgotPasswordFragment()");
        FragmentKt.findNavController(this).navigate(actionAuthPagerFragmentToForgotPasswordFragment);
    }

    private final boolean checkIfLocationPermissionGranted() {
        FragmentActivity activity = getActivity();
        Integer valueOf = activity != null ? Integer.valueOf(ContextCompat.checkSelfPermission(activity, "android.permission.ACCESS_FINE_LOCATION")) : null;
        return valueOf != null && valueOf.intValue() == 0;
    }

    public final void onRequestPermissionsResult() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            ActivityCompat.requestPermissions(activity, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, this.LOCATION_PERMISSION_CODE);
        }
    }

    private final boolean checkPermission() {
        return ActivityCompat.checkSelfPermission(getMContext(), "android.permission.WRITE_EXTERNAL_STORAGE") == 0 && ActivityCompat.checkSelfPermission(getMContext(), "android.permission.READ_EXTERNAL_STORAGE") == 0 && ActivityCompat.checkSelfPermission(getMContext(), "android.permission.CAMERA") == 0;
    }

    private final void requestPermission() {
        if (Build.VERSION.SDK_INT >= 23) {
            requestPermissions(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE", "android.permission.CAMERA"}, 101);
        }
    }
}
