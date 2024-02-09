package com.livpure.safedrink.login;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavArgsLazy;
import androidx.navigation.fragment.FragmentKt;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.livpure.safedrink.R;
import com.livpure.safedrink.common.UiUtilKt;
import com.livpure.safedrink.common.arc.ui.views.DataBindingFragment;
import com.livpure.safedrink.databinding.FragmentResetPasswordBinding;
import com.livpure.safedrink.login.ResetPasswordFragmentDirections;
import com.livpure.safedrink.login.viewmodels.ResetPasswordViewModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
/* compiled from: ResetPasswordFragment.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0002H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0014J\b\u0010\u0015\u001a\u00020\u000bH\u0014J\b\u0010\u0016\u001a\u00020\u0011H\u0002J\u0012\u0010\u0017\u001a\u00020\u00112\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u001a\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\r¨\u0006\u001d"}, d2 = {"Lcom/livpure/safedrink/login/ResetPasswordFragment;", "Lcom/livpure/safedrink/common/arc/ui/views/DataBindingFragment;", "Lcom/livpure/safedrink/databinding/FragmentResetPasswordBinding;", "()V", "args", "Lcom/livpure/safedrink/login/ResetPasswordFragmentArgs;", "getArgs", "()Lcom/livpure/safedrink/login/ResetPasswordFragmentArgs;", "args$delegate", "Landroidx/navigation/NavArgsLazy;", "resetPasswordViewModel", "Lcom/livpure/safedrink/login/viewmodels/ResetPasswordViewModel;", "getResetPasswordViewModel", "()Lcom/livpure/safedrink/login/viewmodels/ResetPasswordViewModel;", "resetPasswordViewModel$delegate", "Lkotlin/Lazy;", "bindVariablesToView", "", "dataBinding", "getLayoutId", "", "getViewModel", "navigateBackToSignIn", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ResetPasswordFragment extends DataBindingFragment<FragmentResetPasswordBinding> {
    private final NavArgsLazy args$delegate;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private final Lazy resetPasswordViewModel$delegate = LazyKt.lazy(new Function0<ResetPasswordViewModel>() { // from class: com.livpure.safedrink.login.ResetPasswordFragment$resetPasswordViewModel$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ResetPasswordViewModel invoke() {
            return (ResetPasswordViewModel) new ViewModelProvider(ResetPasswordFragment.this).get(ResetPasswordViewModel.class);
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
        return R.layout.fragment_reset_password;
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.DataBindingFragment, com.livpure.safedrink.common.arc.ui.views.BaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public ResetPasswordFragment() {
        final ResetPasswordFragment resetPasswordFragment = this;
        this.args$delegate = new NavArgsLazy(Reflection.getOrCreateKotlinClass(ResetPasswordFragmentArgs.class), new Function0<Bundle>() { // from class: com.livpure.safedrink.login.ResetPasswordFragment$special$$inlined$navArgs$1
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

    private final ResetPasswordViewModel getResetPasswordViewModel() {
        return (ResetPasswordViewModel) this.resetPasswordViewModel$delegate.getValue();
    }

    private final ResetPasswordFragmentArgs getArgs() {
        return (ResetPasswordFragmentArgs) this.args$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment
    public ResetPasswordViewModel getViewModel() {
        return getResetPasswordViewModel();
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getResetPasswordViewModel().getNavigationState().observe(this, new Observer() { // from class: com.livpure.safedrink.login.ResetPasswordFragment$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ResetPasswordFragment.m1092onCreate$lambda0(ResetPasswordFragment.this, (ResetPasswordViewModel.ResetPasswordDestinations) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onCreate$lambda-0  reason: not valid java name */
    public static final void m1092onCreate$lambda0(final ResetPasswordFragment this$0, ResetPasswordViewModel.ResetPasswordDestinations resetPasswordDestinations) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (resetPasswordDestinations == ResetPasswordViewModel.ResetPasswordDestinations.SIGN_IN) {
            UiUtilKt.getCustomDialogWithHeaderAndMsg(this$0.requireActivity(), (ConstraintLayout) this$0._$_findCachedViewById(R.id.resetPasswordContainer), "Password Reset", "Please sign in using your new password", new Function0<Unit>() { // from class: com.livpure.safedrink.login.ResetPasswordFragment$onCreate$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    ResetPasswordFragment.this.navigateBackToSignIn();
                }
            });
        }
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.DataBindingFragment
    public void bindVariablesToView(FragmentResetPasswordBinding dataBinding) {
        Intrinsics.checkNotNullParameter(dataBinding, "dataBinding");
        dataBinding.setViewModel(getResetPasswordViewModel());
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        ((Button) _$_findCachedViewById(R.id.resetPasswordButton)).setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.login.ResetPasswordFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ResetPasswordFragment.m1093onViewCreated$lambda1(ResetPasswordFragment.this, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-1  reason: not valid java name */
    public static final void m1093onViewCreated$lambda1(ResetPasswordFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ResetPasswordViewModel resetPasswordViewModel = this$0.getResetPasswordViewModel();
        FragmentActivity requireActivity = this$0.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        String username = this$0.getArgs().getUsername();
        Intrinsics.checkNotNullExpressionValue(username, "args.username");
        resetPasswordViewModel.onResetPasswordClicked(requireActivity, username);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void navigateBackToSignIn() {
        ResetPasswordFragmentDirections.ActionResetPasswordFragmentToAuthPagerFragment actionResetPasswordFragmentToAuthPagerFragment = ResetPasswordFragmentDirections.actionResetPasswordFragmentToAuthPagerFragment();
        Intrinsics.checkNotNullExpressionValue(actionResetPasswordFragmentToAuthPagerFragment, "actionResetPasswordFragmentToAuthPagerFragment()");
        FragmentKt.findNavController(this).navigate(actionResetPasswordFragmentToAuthPagerFragment);
    }
}
