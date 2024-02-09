package com.livpure.safedrink.login;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.FragmentKt;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.livpure.safedrink.R;
import com.livpure.safedrink.common.arc.ui.views.DataBindingFragment;
import com.livpure.safedrink.databinding.FragmentForgotPasswordBinding;
import com.livpure.safedrink.login.ForgotPasswordFragmentDirections;
import com.livpure.safedrink.login.viewmodels.ForgotPasswordViewModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ForgotPasswordFragment.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0002H\u0016J\b\u0010\r\u001a\u00020\u000eH\u0014J\b\u0010\u000f\u001a\u00020\u0005H\u0014J\u0012\u0010\u0010\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u001a\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0016\u001a\u00020\u000bH\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/livpure/safedrink/login/ForgotPasswordFragment;", "Lcom/livpure/safedrink/common/arc/ui/views/DataBindingFragment;", "Lcom/livpure/safedrink/databinding/FragmentForgotPasswordBinding;", "()V", "forgotPasswordViewModel", "Lcom/livpure/safedrink/login/viewmodels/ForgotPasswordViewModel;", "getForgotPasswordViewModel", "()Lcom/livpure/safedrink/login/viewmodels/ForgotPasswordViewModel;", "forgotPasswordViewModel$delegate", "Lkotlin/Lazy;", "bindVariablesToView", "", "dataBinding", "getLayoutId", "", "getViewModel", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "showResetPasswordScreen", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ForgotPasswordFragment extends DataBindingFragment<FragmentForgotPasswordBinding> {
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private final Lazy forgotPasswordViewModel$delegate = LazyKt.lazy(new Function0<ForgotPasswordViewModel>() { // from class: com.livpure.safedrink.login.ForgotPasswordFragment$forgotPasswordViewModel$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ForgotPasswordViewModel invoke() {
            return (ForgotPasswordViewModel) new ViewModelProvider(ForgotPasswordFragment.this).get(ForgotPasswordViewModel.class);
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
        return R.layout.fragment_forgot_password;
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.DataBindingFragment, com.livpure.safedrink.common.arc.ui.views.BaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    private final ForgotPasswordViewModel getForgotPasswordViewModel() {
        return (ForgotPasswordViewModel) this.forgotPasswordViewModel$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment
    public ForgotPasswordViewModel getViewModel() {
        return getForgotPasswordViewModel();
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getForgotPasswordViewModel().getNavigationState().observe(this, new Observer() { // from class: com.livpure.safedrink.login.ForgotPasswordFragment$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ForgotPasswordFragment.m1059onCreate$lambda0(ForgotPasswordFragment.this, (ForgotPasswordViewModel.ForgotPasswordDestinations) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onCreate$lambda-0  reason: not valid java name */
    public static final void m1059onCreate$lambda0(ForgotPasswordFragment this$0, ForgotPasswordViewModel.ForgotPasswordDestinations forgotPasswordDestinations) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (forgotPasswordDestinations == ForgotPasswordViewModel.ForgotPasswordDestinations.OTP) {
            this$0.showResetPasswordScreen();
        } else if (forgotPasswordDestinations == ForgotPasswordViewModel.ForgotPasswordDestinations.FURLENCO) {
            Toast.makeText(this$0.getActivity(), "Your Password is : livpure ", 0).show();
        }
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.DataBindingFragment
    public void bindVariablesToView(FragmentForgotPasswordBinding dataBinding) {
        Intrinsics.checkNotNullParameter(dataBinding, "dataBinding");
        dataBinding.setViewModel(getForgotPasswordViewModel());
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        Button button = (Button) _$_findCachedViewById(R.id.resetPasswordButton);
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.login.ForgotPasswordFragment$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ForgotPasswordFragment.m1060onViewCreated$lambda1(ForgotPasswordFragment.this, view2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-1  reason: not valid java name */
    public static final void m1060onViewCreated$lambda1(ForgotPasswordFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ForgotPasswordViewModel forgotPasswordViewModel = this$0.getForgotPasswordViewModel();
        Context context = ((Button) this$0._$_findCachedViewById(R.id.resetPasswordButton)).getContext();
        Intrinsics.checkNotNullExpressionValue(context, "resetPasswordButton.context");
        forgotPasswordViewModel.onResetPasswordClicked(context);
    }

    private final void showResetPasswordScreen() {
        String value = getForgotPasswordViewModel().getUsername().getValue();
        Intrinsics.checkNotNull(value);
        ForgotPasswordFragmentDirections.ActionForgotPasswordFragmentToResetPasswordFragment actionForgotPasswordFragmentToResetPasswordFragment = ForgotPasswordFragmentDirections.actionForgotPasswordFragmentToResetPasswordFragment(value);
        Intrinsics.checkNotNullExpressionValue(actionForgotPasswordFragmentToResetPasswordFragment, "actionForgotPasswordFrag…ewModel.username.value!!)");
        FragmentKt.findNavController(this).navigate(actionForgotPasswordFragmentToResetPasswordFragment);
    }
}
