package com.livpure.safedrink.referNearn.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.livpure.safedrink.R;
import com.livpure.safedrink.common.arc.ui.views.DataBindingFragment;
import com.livpure.safedrink.databinding.FragmentReferralLeaderBoardBinding;
import com.livpure.safedrink.referNearn.view.adapter.ReferralSuperUserAdapter;
import com.livpure.safedrink.referNearn.viewmodels.ReferAndEarnViewModel;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ReferralLeaderBoardFragment.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0002H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0014J\b\u0010\u0010\u001a\u00020\u0006H\u0014J\b\u0010\u0011\u001a\u00020\u0012H\u0014J\u001a\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0017R\u000e\u0010\u0004\u001a\u00020\u0002X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u0018"}, d2 = {"Lcom/livpure/safedrink/referNearn/view/fragment/ReferralLeaderBoardFragment;", "Lcom/livpure/safedrink/common/arc/ui/views/DataBindingFragment;", "Lcom/livpure/safedrink/databinding/FragmentReferralLeaderBoardBinding;", "()V", "fragmentReferralLeaderBoardBinding", "referAndEarnModel", "Lcom/livpure/safedrink/referNearn/viewmodels/ReferAndEarnViewModel;", "getReferAndEarnModel", "()Lcom/livpure/safedrink/referNearn/viewmodels/ReferAndEarnViewModel;", "referAndEarnModel$delegate", "Lkotlin/Lazy;", "bindVariablesToView", "", "dataBinding", "getLayoutId", "", "getViewModel", "isToolbarVisible", "", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ReferralLeaderBoardFragment extends DataBindingFragment<FragmentReferralLeaderBoardBinding> {
    private FragmentReferralLeaderBoardBinding fragmentReferralLeaderBoardBinding;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private final Lazy referAndEarnModel$delegate = LazyKt.lazy(new Function0<ReferAndEarnViewModel>() { // from class: com.livpure.safedrink.referNearn.view.fragment.ReferralLeaderBoardFragment$referAndEarnModel$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ReferAndEarnViewModel invoke() {
            return (ReferAndEarnViewModel) new ViewModelProvider(ReferralLeaderBoardFragment.this).get(ReferAndEarnViewModel.class);
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
        return R.layout.fragment_referral_leader_board;
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment
    protected boolean isToolbarVisible() {
        return true;
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.DataBindingFragment, com.livpure.safedrink.common.arc.ui.views.BaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    private final ReferAndEarnViewModel getReferAndEarnModel() {
        return (ReferAndEarnViewModel) this.referAndEarnModel$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment
    public ReferAndEarnViewModel getViewModel() {
        return getReferAndEarnModel();
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.DataBindingFragment
    public void bindVariablesToView(FragmentReferralLeaderBoardBinding dataBinding) {
        Intrinsics.checkNotNullParameter(dataBinding, "dataBinding");
        this.fragmentReferralLeaderBoardBinding = dataBinding;
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        getReferAndEarnModel().getReferralHistory();
        getReferAndEarnModel().getLeadershipBoard();
        FragmentReferralLeaderBoardBinding fragmentReferralLeaderBoardBinding = this.fragmentReferralLeaderBoardBinding;
        if (fragmentReferralLeaderBoardBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fragmentReferralLeaderBoardBinding");
            fragmentReferralLeaderBoardBinding = null;
        }
        fragmentReferralLeaderBoardBinding.setUserData(getReferAndEarnModel());
        getReferAndEarnModel().getLaderShipArrayList().observe(this, new Observer() { // from class: com.livpure.safedrink.referNearn.view.fragment.ReferralLeaderBoardFragment$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ReferralLeaderBoardFragment.m1133onViewCreated$lambda1(ReferralLeaderBoardFragment.this, (List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-1  reason: not valid java name */
    public static final void m1133onViewCreated$lambda1(ReferralLeaderBoardFragment this$0, List history) {
        ReferralSuperUserAdapter referralSuperUserAdapter;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((RecyclerView) this$0._$_findCachedViewById(R.id.listSuperUserId)).setLayoutManager(new LinearLayoutManager(this$0.getContext()));
        Context context = this$0.getContext();
        if (context != null) {
            Intrinsics.checkNotNullExpressionValue(history, "history");
            referralSuperUserAdapter = new ReferralSuperUserAdapter(context, history);
        } else {
            referralSuperUserAdapter = null;
        }
        ((RecyclerView) this$0._$_findCachedViewById(R.id.listSuperUserId)).setAdapter(referralSuperUserAdapter);
    }
}
