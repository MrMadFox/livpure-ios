package com.livpure.safedrink.login;

import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.material.textfield.TextInputLayout;
import com.livpure.safedrink.R;
import com.livpure.safedrink.app.MainViewModel;
import com.livpure.safedrink.common.arc.ui.views.DataBindingFragment;
import com.livpure.safedrink.common.arc.ui.views.NoFilterArrayAdapter;
import com.livpure.safedrink.databinding.FragmentSignUpBinding;
import com.livpure.safedrink.login.viewmodels.SignUpViewModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
/* compiled from: SignUpFragment.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0014J\b\u0010\u0014\u001a\u00020\u000bH\u0014J\b\u0010\u0015\u001a\u00020\u0010H\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0014J\u0012\u0010\u0018\u001a\u00020\u00102\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0010H\u0002J\u001a\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\r¨\u0006\u001f"}, d2 = {"Lcom/livpure/safedrink/login/SignUpFragment;", "Lcom/livpure/safedrink/common/arc/ui/views/DataBindingFragment;", "Lcom/livpure/safedrink/databinding/FragmentSignUpBinding;", "()V", "mainViewModel", "Lcom/livpure/safedrink/app/MainViewModel;", "getMainViewModel", "()Lcom/livpure/safedrink/app/MainViewModel;", "mainViewModel$delegate", "Lkotlin/Lazy;", "signUpViewModel", "Lcom/livpure/safedrink/login/viewmodels/SignUpViewModel;", "getSignUpViewModel", "()Lcom/livpure/safedrink/login/viewmodels/SignUpViewModel;", "signUpViewModel$delegate", "bindVariablesToView", "", "dataBinding", "getLayoutId", "", "getViewModel", "initializeViews", "isToolbarVisible", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onTermsAndConditionsClicked", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SignUpFragment extends DataBindingFragment<FragmentSignUpBinding> {
    private final Lazy mainViewModel$delegate;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private final Lazy signUpViewModel$delegate = LazyKt.lazy(new Function0<SignUpViewModel>() { // from class: com.livpure.safedrink.login.SignUpFragment$signUpViewModel$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final SignUpViewModel invoke() {
            return (SignUpViewModel) new ViewModelProvider(SignUpFragment.this).get(SignUpViewModel.class);
        }
    });

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
        return R.layout.fragment_sign_up;
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

    public SignUpFragment() {
        final SignUpFragment signUpFragment = this;
        this.mainViewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(signUpFragment, Reflection.getOrCreateKotlinClass(MainViewModel.class), new Function0<ViewModelStore>() { // from class: com.livpure.safedrink.login.SignUpFragment$special$$inlined$activityViewModels$default$1
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
        }, new Function0<CreationExtras>() { // from class: com.livpure.safedrink.login.SignUpFragment$special$$inlined$activityViewModels$default$2
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
                    CreationExtras defaultViewModelCreationExtras = signUpFragment.requireActivity().getDefaultViewModelCreationExtras();
                    Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "requireActivity().defaultViewModelCreationExtras");
                    return defaultViewModelCreationExtras;
                }
                return creationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.livpure.safedrink.login.SignUpFragment$special$$inlined$activityViewModels$default$3
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
    }

    private final SignUpViewModel getSignUpViewModel() {
        return (SignUpViewModel) this.signUpViewModel$delegate.getValue();
    }

    private final MainViewModel getMainViewModel() {
        return (MainViewModel) this.mainViewModel$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment
    public SignUpViewModel getViewModel() {
        return getSignUpViewModel();
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getSignUpViewModel().getReferralCode().observe(this, new Observer() { // from class: com.livpure.safedrink.login.SignUpFragment$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SignUpFragment.m1096onCreate$lambda0(SignUpFragment.this, (String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onCreate$lambda-0  reason: not valid java name */
    public static final void m1096onCreate$lambda0(SignUpFragment this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (str.length() >= 6) {
            SignUpViewModel signUpViewModel = this$0.getSignUpViewModel();
            FragmentActivity requireActivity = this$0.requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            signUpViewModel.onReferralCodeEntered(requireActivity);
            return;
        }
        this$0.getSignUpViewModel().onReferralCodeNotEntered();
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.DataBindingFragment
    public void bindVariablesToView(FragmentSignUpBinding dataBinding) {
        Intrinsics.checkNotNullParameter(dataBinding, "dataBinding");
        dataBinding.setViewModel(getSignUpViewModel());
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        ((TextInputLayout) _$_findCachedViewById(R.id.referralCodeTextInputLayout)).setError("xyz");
        ((TextInputLayout) _$_findCachedViewById(R.id.referralCodeTextInputLayout)).setError(null);
        initializeViews();
    }

    private final void initializeViews() {
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) _$_findCachedViewById(R.id.selectCityAutoCompleteTextView);
        if (autoCompleteTextView != null) {
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            autoCompleteTextView.setAdapter(new NoFilterArrayAdapter(requireActivity, 17367043, getSignUpViewModel().getListOfCities()));
            autoCompleteTextView.setShowSoftInputOnFocus(false);
        }
        ((TextView) _$_findCachedViewById(R.id.termsText)).setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.login.SignUpFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SignUpFragment.m1095initializeViews$lambda3(SignUpFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initializeViews$lambda-3  reason: not valid java name */
    public static final void m1095initializeViews$lambda3(SignUpFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onTermsAndConditionsClicked();
    }

    private final void onTermsAndConditionsClicked() {
        getMainViewModel().onTermsAndConditionsClick();
    }
}
