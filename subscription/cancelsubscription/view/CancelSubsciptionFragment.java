package com.livpure.safedrink.subscription.cancelsubscription.view;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.FragmentKt;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.livpure.safedrink.R;
import com.livpure.safedrink.common.arc.ui.viewmodels.AnalyticsViewModel;
import com.livpure.safedrink.common.arc.ui.views.DataBindingFragment;
import com.livpure.safedrink.databinding.FragmentCancelSubscriptionBinding;
import com.livpure.safedrink.subscription.cancelsubscription.viewmodel.CancelSubsciptionModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: CancelSubsciptionFragment.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0002H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0014J\b\u0010\u0010\u001a\u00020\u0011H\u0014J\b\u0010\u0012\u001a\u00020\fH\u0002J\u0006\u0010\u0013\u001a\u00020\fJ\u0006\u0010\u0014\u001a\u00020\fJ\u001a\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0017R\u000e\u0010\u0004\u001a\u00020\u0002X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u001a"}, d2 = {"Lcom/livpure/safedrink/subscription/cancelsubscription/view/CancelSubsciptionFragment;", "Lcom/livpure/safedrink/common/arc/ui/views/DataBindingFragment;", "Lcom/livpure/safedrink/databinding/FragmentCancelSubscriptionBinding;", "()V", "binding", "cancelSubsciptionModel", "Lcom/livpure/safedrink/subscription/cancelsubscription/viewmodel/CancelSubsciptionModel;", "getCancelSubsciptionModel", "()Lcom/livpure/safedrink/subscription/cancelsubscription/viewmodel/CancelSubsciptionModel;", "cancelSubsciptionModel$delegate", "Lkotlin/Lazy;", "bindVariablesToView", "", "dataBinding", "getLayoutId", "", "getViewModel", "Lcom/livpure/safedrink/common/arc/ui/viewmodels/AnalyticsViewModel;", "goBack", "onChangePlanButtonClick", "onFineshSubscriptionButtonClick", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CancelSubsciptionFragment extends DataBindingFragment<FragmentCancelSubscriptionBinding> {
    private FragmentCancelSubscriptionBinding binding;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private final Lazy cancelSubsciptionModel$delegate = LazyKt.lazy(new Function0<CancelSubsciptionModel>() { // from class: com.livpure.safedrink.subscription.cancelsubscription.view.CancelSubsciptionFragment$cancelSubsciptionModel$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final CancelSubsciptionModel invoke() {
            return (CancelSubsciptionModel) new ViewModelProvider(CancelSubsciptionFragment.this).get(CancelSubsciptionModel.class);
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
        return R.layout.fragment_cancel_subscription;
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.DataBindingFragment, com.livpure.safedrink.common.arc.ui.views.BaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment
    public AnalyticsViewModel getViewModel() {
        return (AnalyticsViewModel) new ViewModelProvider(this).get(AnalyticsViewModel.class);
    }

    private final CancelSubsciptionModel getCancelSubsciptionModel() {
        return (CancelSubsciptionModel) this.cancelSubsciptionModel$delegate.getValue();
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        getCancelSubsciptionModel().getDashboardDetails();
        ((LinearLayout) _$_findCachedViewById(R.id.changePlanButton)).setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.subscription.cancelsubscription.view.CancelSubsciptionFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CancelSubsciptionFragment.m1286onViewCreated$lambda0(CancelSubsciptionFragment.this, view2);
            }
        });
        ((LinearLayout) _$_findCachedViewById(R.id.finishSubscriptionButton)).setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.subscription.cancelsubscription.view.CancelSubsciptionFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CancelSubsciptionFragment.m1287onViewCreated$lambda1(CancelSubsciptionFragment.this, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-0  reason: not valid java name */
    public static final void m1286onViewCreated$lambda0(CancelSubsciptionFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onChangePlanButtonClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-1  reason: not valid java name */
    public static final void m1287onViewCreated$lambda1(CancelSubsciptionFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onFineshSubscriptionButtonClick();
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.DataBindingFragment
    public void bindVariablesToView(FragmentCancelSubscriptionBinding dataBinding) {
        Intrinsics.checkNotNullParameter(dataBinding, "dataBinding");
        this.binding = dataBinding;
        dataBinding.setViewModel(getCancelSubsciptionModel());
    }

    private final void goBack() {
        FragmentKt.findNavController(this).popBackStack();
    }

    public final void onChangePlanButtonClick() {
        try {
            FragmentKt.findNavController(this).popBackStack(R.id.homeFragment, false);
        } catch (Exception unused) {
        }
    }

    public final void onFineshSubscriptionButtonClick() {
        try {
            NavDirections cancelSubscriptionConfirm = CancelSubsciptionFragmentDirections.cancelSubscriptionConfirm();
            Intrinsics.checkNotNullExpressionValue(cancelSubscriptionConfirm, "cancelSubscriptionConfirm()");
            FragmentKt.findNavController(this).navigate(cancelSubscriptionConfirm);
        } catch (Exception unused) {
        }
    }
}
