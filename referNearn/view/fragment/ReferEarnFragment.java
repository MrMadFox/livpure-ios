package com.livpure.safedrink.referNearn.view.fragment;

import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.livpure.safedrink.R;
import com.livpure.safedrink.common.arc.ui.views.DataBindingFragment;
import com.livpure.safedrink.databinding.FragmentReferEarnBinding;
import com.livpure.safedrink.referNearn.pager.ReferralPagerAdapter;
import com.livpure.safedrink.referNearn.viewmodels.ReferAndEarnViewModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ReferEarnFragment.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0014J\b\u0010\u0013\u001a\u00020\u0006H\u0014J\b\u0010\u0014\u001a\u00020\u0010H\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0014J\u001a\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/livpure/safedrink/referNearn/view/fragment/ReferEarnFragment;", "Lcom/livpure/safedrink/common/arc/ui/views/DataBindingFragment;", "Lcom/livpure/safedrink/databinding/FragmentReferEarnBinding;", "()V", "dataBinding", "referAndEarnViewModel", "Lcom/livpure/safedrink/referNearn/viewmodels/ReferAndEarnViewModel;", "getReferAndEarnViewModel", "()Lcom/livpure/safedrink/referNearn/viewmodels/ReferAndEarnViewModel;", "referAndEarnViewModel$delegate", "Lkotlin/Lazy;", "tabTitles", "", "", "[Ljava/lang/String;", "bindVariablesToView", "", "getLayoutId", "", "getViewModel", "initViewContext", "isToolbarVisible", "", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ReferEarnFragment extends DataBindingFragment<FragmentReferEarnBinding> {
    private FragmentReferEarnBinding dataBinding;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private final Lazy referAndEarnViewModel$delegate = LazyKt.lazy(new Function0<ReferAndEarnViewModel>() { // from class: com.livpure.safedrink.referNearn.view.fragment.ReferEarnFragment$referAndEarnViewModel$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ReferAndEarnViewModel invoke() {
            return (ReferAndEarnViewModel) new ViewModelProvider(ReferEarnFragment.this).get(ReferAndEarnViewModel.class);
        }
    });
    private final String[] tabTitles = {"Invite", "Referral History", "Leader Board"};

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
        return R.layout.fragment_refer_earn;
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

    private final ReferAndEarnViewModel getReferAndEarnViewModel() {
        return (ReferAndEarnViewModel) this.referAndEarnViewModel$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment
    public ReferAndEarnViewModel getViewModel() {
        return getReferAndEarnViewModel();
    }

    private final void initViewContext() {
        ViewPager2 viewPager2 = (ViewPager2) _$_findCachedViewById(R.id.referralViewPagerId);
        if ((viewPager2 != null ? viewPager2.getAdapter() : null) == null) {
            ViewPager2 viewPager22 = (ViewPager2) _$_findCachedViewById(R.id.referralViewPagerId);
            if (viewPager22 != null) {
                viewPager22.setAdapter(new ReferralPagerAdapter(this));
            }
            new TabLayoutMediator((TabLayout) _$_findCachedViewById(R.id.referralTabViewId), (ViewPager2) _$_findCachedViewById(R.id.referralViewPagerId), new TabLayoutMediator.TabConfigurationStrategy() { // from class: com.livpure.safedrink.referNearn.view.fragment.ReferEarnFragment$$ExternalSyntheticLambda0
                @Override // com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy
                public final void onConfigureTab(TabLayout.Tab tab, int i) {
                    ReferEarnFragment.m1121initViewContext$lambda0(ReferEarnFragment.this, tab, i);
                }
            }).attach();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initViewContext$lambda-0  reason: not valid java name */
    public static final void m1121initViewContext$lambda0(ReferEarnFragment this$0, TabLayout.Tab tab, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(tab, "tab");
        tab.setText(this$0.tabTitles[i]);
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        initViewContext();
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.DataBindingFragment
    public void bindVariablesToView(FragmentReferEarnBinding dataBinding) {
        Intrinsics.checkNotNullParameter(dataBinding, "dataBinding");
        this.dataBinding = dataBinding;
    }
}
