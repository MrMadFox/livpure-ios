package com.livpure.safedrink.subscription.payment.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavArgsLazy;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.livpure.safedrink.R;
import com.livpure.safedrink.common.UiUtilKt;
import com.livpure.safedrink.common.arc.ui.views.DataBindingFragment;
import com.livpure.safedrink.databinding.FragmentSelectRechargePlanBinding;
import com.livpure.safedrink.interfaces.ItemClickListener;
import com.livpure.safedrink.login.MainActivity;
import com.livpure.safedrink.segment.SegmentLogger;
import com.livpure.safedrink.subscription.payment.adapter.PlanTitleAdapter;
import com.livpure.safedrink.subscription.payment.viewmodel.SelectPlanViewModel;
import com.livpure.safedrink.subscription.plan.data.model.deviceList.DeviceList;
import com.livpure.safedrink.subscription.plan.data.model.payment.PlanItem;
import com.livpure.safedrink.subscription.plan.data.model.plan.PlansItem;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
/* compiled from: SelectPlanFragment.kt */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u00011B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010!\u001a\u00020\"2\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010#\u001a\u00020$H\u0014J\b\u0010%\u001a\u00020\u001aH\u0014J\u0012\u0010&\u001a\u00020\"2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u0012\u0010)\u001a\u00020\"2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u001a\u0010*\u001a\u00020\"2\b\u0010+\u001a\u0004\u0018\u00010 2\u0006\u0010,\u001a\u00020$H\u0016J\u001a\u0010-\u001a\u00020\"2\u0006\u0010+\u001a\u00020 2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u0010\u0010.\u001a\u00020\"2\u0006\u0010/\u001a\u00020\u0018H\u0002J\b\u00100\u001a\u00020\"H\u0002R\u000e\u0010\u0005\u001a\u00020\u0002X\u0082.¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\u0007j\b\u0012\u0004\u0012\u00020\u000b`\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0014\u001a\u00060\u0015R\u00020\u0000X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001f\u001a\u00020 X\u0082.¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/livpure/safedrink/subscription/payment/view/SelectPlanFragment;", "Lcom/livpure/safedrink/common/arc/ui/views/DataBindingFragment;", "Lcom/livpure/safedrink/databinding/FragmentSelectRechargePlanBinding;", "Lcom/livpure/safedrink/interfaces/ItemClickListener;", "()V", "dataBinding", "mFragmentList", "Ljava/util/ArrayList;", "Landroidx/fragment/app/Fragment;", "Lkotlin/collections/ArrayList;", "mFragmentPlanList", "Lcom/livpure/safedrink/subscription/plan/data/model/payment/PlanItem;", "mLayoutInflater", "Landroid/view/LayoutInflater;", "navArgs", "Lcom/livpure/safedrink/subscription/payment/view/SelectPlanFragmentArgs;", "getNavArgs", "()Lcom/livpure/safedrink/subscription/payment/view/SelectPlanFragmentArgs;", "navArgs$delegate", "Landroidx/navigation/NavArgsLazy;", "pagerAdapter", "Lcom/livpure/safedrink/subscription/payment/view/SelectPlanFragment$ScreenSlidePagerAdapter;", "plansList", "", "Lcom/livpure/safedrink/subscription/plan/data/model/plan/PlansItem;", "selectPlanOrRechargeViewModel", "Lcom/livpure/safedrink/subscription/payment/viewmodel/SelectPlanViewModel;", "getSelectPlanOrRechargeViewModel", "()Lcom/livpure/safedrink/subscription/payment/viewmodel/SelectPlanViewModel;", "selectPlanOrRechargeViewModel$delegate", "Lkotlin/Lazy;", "tab", "Landroid/view/View;", "bindVariablesToView", "", "getLayoutId", "", "getViewModel", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onCreate", "onItemClick", ViewHierarchyConstants.VIEW_KEY, "position", "onViewCreated", "proceedToReviewOrder", "planItem", "setupViewPager", "ScreenSlidePagerAdapter", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SelectPlanFragment extends DataBindingFragment<FragmentSelectRechargePlanBinding> implements ItemClickListener {
    private FragmentSelectRechargePlanBinding dataBinding;
    private LayoutInflater mLayoutInflater;
    private final NavArgsLazy navArgs$delegate;
    private ScreenSlidePagerAdapter pagerAdapter;
    private List<PlansItem> plansList;
    private View tab;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private final Lazy selectPlanOrRechargeViewModel$delegate = LazyKt.lazy(new Function0<SelectPlanViewModel>() { // from class: com.livpure.safedrink.subscription.payment.view.SelectPlanFragment$selectPlanOrRechargeViewModel$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final SelectPlanViewModel invoke() {
            SelectPlanViewModel selectPlanViewModel = (SelectPlanViewModel) new ViewModelProvider(SelectPlanFragment.this).get(SelectPlanViewModel.class);
            selectPlanViewModel.setDevice(SelectPlanFragment.this.getNavArgs().getDevice());
            return selectPlanViewModel;
        }
    });
    private final ArrayList<Fragment> mFragmentList = new ArrayList<>();
    private final ArrayList<PlanItem> mFragmentPlanList = new ArrayList<>();

    private final void proceedToReviewOrder(PlansItem plansItem) {
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
        return R.layout.fragment_select_recharge_plan;
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.DataBindingFragment, com.livpure.safedrink.common.arc.ui.views.BaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public SelectPlanFragment() {
        final SelectPlanFragment selectPlanFragment = this;
        this.navArgs$delegate = new NavArgsLazy(Reflection.getOrCreateKotlinClass(SelectPlanFragmentArgs.class), new Function0<Bundle>() { // from class: com.livpure.safedrink.subscription.payment.view.SelectPlanFragment$special$$inlined$navArgs$1
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

    /* JADX INFO: Access modifiers changed from: private */
    public final SelectPlanFragmentArgs getNavArgs() {
        return (SelectPlanFragmentArgs) this.navArgs$delegate.getValue();
    }

    private final SelectPlanViewModel getSelectPlanOrRechargeViewModel() {
        return (SelectPlanViewModel) this.selectPlanOrRechargeViewModel$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment
    public SelectPlanViewModel getViewModel() {
        return getSelectPlanOrRechargeViewModel();
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        SelectPlanFragment selectPlanFragment = this;
        getSelectPlanOrRechargeViewModel().getAllPlanDetails().observe(selectPlanFragment, new Observer() { // from class: com.livpure.safedrink.subscription.payment.view.SelectPlanFragment$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SelectPlanFragment.m1371onCreate$lambda0(SelectPlanFragment.this, (List) obj);
            }
        });
        getSelectPlanOrRechargeViewModel().getSelectedPlan().observe(selectPlanFragment, new Observer() { // from class: com.livpure.safedrink.subscription.payment.view.SelectPlanFragment$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SelectPlanFragment.m1372onCreate$lambda1(SelectPlanFragment.this, (PlansItem) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onCreate$lambda-0  reason: not valid java name */
    public static final void m1371onCreate$lambda0(SelectPlanFragment this$0, List it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.isAdded()) {
            List list = it;
            if (list == null || list.isEmpty()) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(it, "it");
            this$0.plansList = it;
            this$0.setupViewPager();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onCreate$lambda-1  reason: not valid java name */
    public static final void m1372onCreate$lambda1(SelectPlanFragment this$0, PlansItem plan) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SegmentLogger.Companion companion = SegmentLogger.Companion;
        FragmentActivity requireActivity = this$0.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        companion.with(requireActivity).sendPlanSelectedEvent(plan.getPlanName(), plan.getId(), String.valueOf(plan.getSelectedDuration()));
        Intrinsics.checkNotNullExpressionValue(plan, "plan");
        this$0.proceedToReviewOrder(plan);
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        if (isAdded()) {
            UiUtilKt.hideKeyboard(requireActivity());
        }
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        ((MainActivity) requireActivity()).setupDefaultUpButtonNavigation();
    }

    private final void setupViewPager() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getMContext(), 0, false);
        FragmentSelectRechargePlanBinding fragmentSelectRechargePlanBinding = this.dataBinding;
        FragmentSelectRechargePlanBinding fragmentSelectRechargePlanBinding2 = null;
        if (fragmentSelectRechargePlanBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            fragmentSelectRechargePlanBinding = null;
        }
        fragmentSelectRechargePlanBinding.listPlanTitleId.setLayoutManager(linearLayoutManager);
        FragmentActivity mContext = getMContext();
        Intrinsics.checkNotNullExpressionValue(mContext, "mContext");
        FragmentActivity fragmentActivity = mContext;
        List<PlansItem> list = this.plansList;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("plansList");
            list = null;
        }
        final PlanTitleAdapter planTitleAdapter = new PlanTitleAdapter(fragmentActivity, list);
        FragmentSelectRechargePlanBinding fragmentSelectRechargePlanBinding3 = this.dataBinding;
        if (fragmentSelectRechargePlanBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            fragmentSelectRechargePlanBinding3 = null;
        }
        fragmentSelectRechargePlanBinding3.listPlanTitleId.setAdapter(planTitleAdapter);
        planTitleAdapter.onItemClickListeners(this);
        this.pagerAdapter = new ScreenSlidePagerAdapter(this, this);
        FragmentSelectRechargePlanBinding fragmentSelectRechargePlanBinding4 = this.dataBinding;
        if (fragmentSelectRechargePlanBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            fragmentSelectRechargePlanBinding4 = null;
        }
        ViewPager2 viewPager2 = fragmentSelectRechargePlanBinding4.planViewPager;
        ScreenSlidePagerAdapter screenSlidePagerAdapter = this.pagerAdapter;
        if (screenSlidePagerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
            screenSlidePagerAdapter = null;
        }
        viewPager2.setAdapter(screenSlidePagerAdapter);
        FragmentSelectRechargePlanBinding fragmentSelectRechargePlanBinding5 = this.dataBinding;
        if (fragmentSelectRechargePlanBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
        } else {
            fragmentSelectRechargePlanBinding2 = fragmentSelectRechargePlanBinding5;
        }
        fragmentSelectRechargePlanBinding2.planViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() { // from class: com.livpure.safedrink.subscription.payment.view.SelectPlanFragment$setupViewPager$1
            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageScrolled(int i, float f, int i2) {
                super.onPageScrolled(i, f, i2);
                PlanTitleAdapter.this.selectedItem(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SelectPlanFragment.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016¨\u0006\n"}, d2 = {"Lcom/livpure/safedrink/subscription/payment/view/SelectPlanFragment$ScreenSlidePagerAdapter;", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "fa", "Lcom/livpure/safedrink/subscription/payment/view/SelectPlanFragment;", "(Lcom/livpure/safedrink/subscription/payment/view/SelectPlanFragment;Lcom/livpure/safedrink/subscription/payment/view/SelectPlanFragment;)V", "createFragment", "Landroidx/fragment/app/Fragment;", "position", "", "getItemCount", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public final class ScreenSlidePagerAdapter extends FragmentStateAdapter {
        final /* synthetic */ SelectPlanFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ScreenSlidePagerAdapter(SelectPlanFragment selectPlanFragment, SelectPlanFragment fa) {
            super(fa);
            Intrinsics.checkNotNullParameter(fa, "fa");
            this.this$0 = selectPlanFragment;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            List list = this.this$0.plansList;
            if (list == null) {
                Intrinsics.throwUninitializedPropertyAccessException("plansList");
                list = null;
            }
            return list.size();
        }

        @Override // androidx.viewpager2.adapter.FragmentStateAdapter
        public Fragment createFragment(int i) {
            List list = this.this$0.plansList;
            if (list == null) {
                Intrinsics.throwUninitializedPropertyAccessException("plansList");
                list = null;
            }
            DeviceList device = this.this$0.getNavArgs().getDevice();
            Intrinsics.checkNotNullExpressionValue(device, "navArgs.device");
            return new PlanFragment((PlansItem) list.get(i), device);
        }
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.DataBindingFragment
    public void bindVariablesToView(FragmentSelectRechargePlanBinding dataBinding) {
        Intrinsics.checkNotNullParameter(dataBinding, "dataBinding");
        this.dataBinding = dataBinding;
        dataBinding.setViewModel(getSelectPlanOrRechargeViewModel());
    }

    @Override // com.livpure.safedrink.interfaces.ItemClickListener
    public void onItemClick(View view, int i) {
        FragmentSelectRechargePlanBinding fragmentSelectRechargePlanBinding = this.dataBinding;
        ScreenSlidePagerAdapter screenSlidePagerAdapter = null;
        if (fragmentSelectRechargePlanBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            fragmentSelectRechargePlanBinding = null;
        }
        fragmentSelectRechargePlanBinding.planViewPager.setCurrentItem(i);
        ScreenSlidePagerAdapter screenSlidePagerAdapter2 = this.pagerAdapter;
        if (screenSlidePagerAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
        } else {
            screenSlidePagerAdapter = screenSlidePagerAdapter2;
        }
        screenSlidePagerAdapter.notifyDataSetChanged();
    }
}
