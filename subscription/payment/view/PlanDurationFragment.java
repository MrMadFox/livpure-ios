package com.livpure.safedrink.subscription.payment.view;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavArgsLazy;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.livpure.safedrink.R;
import com.livpure.safedrink.common.UiUtilKt;
import com.livpure.safedrink.common.arc.ui.views.DataBindingFragment;
import com.livpure.safedrink.databinding.FragmentPlanDurationBinding;
import com.livpure.safedrink.interfaces.ItemClickListener;
import com.livpure.safedrink.login.MainActivity;
import com.livpure.safedrink.subscription.payment.adapter.PlanDurationAdapter;
import com.livpure.safedrink.subscription.payment.viewmodel.PlanDurationModel;
import com.livpure.safedrink.subscription.plan.data.model.payment.PriceMappingItem;
import com.livpure.safedrink.subscription.plan.data.model.plan.PlansItem;
import com.livpure.safedrink.subscription.plan.data.model.plan.PriceItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
/* compiled from: PlanDurationFragment.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0002H\u0016J\b\u0010\u001c\u001a\u00020\u0018H\u0014J\b\u0010\u001d\u001a\u00020\rH\u0014J\u0012\u0010\u001e\u001a\u00020\u001a2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u001a\u0010!\u001a\u00020\u001a2\b\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010$\u001a\u00020\u0018H\u0016J\u001a\u0010%\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020#2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010&\u001a\u00020\u001aH\u0002J\b\u0010'\u001a\u00020\u001aH\u0002R\u000e\u0010\u0005\u001a\u00020\u0002X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0013X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/livpure/safedrink/subscription/payment/view/PlanDurationFragment;", "Lcom/livpure/safedrink/common/arc/ui/views/DataBindingFragment;", "Lcom/livpure/safedrink/databinding/FragmentPlanDurationBinding;", "Lcom/livpure/safedrink/interfaces/ItemClickListener;", "()V", "binding", "navArgs", "Lcom/livpure/safedrink/subscription/payment/view/PlanDurationFragmentArgs;", "getNavArgs", "()Lcom/livpure/safedrink/subscription/payment/view/PlanDurationFragmentArgs;", "navArgs$delegate", "Landroidx/navigation/NavArgsLazy;", "planDurationModel", "Lcom/livpure/safedrink/subscription/payment/viewmodel/PlanDurationModel;", "getPlanDurationModel", "()Lcom/livpure/safedrink/subscription/payment/viewmodel/PlanDurationModel;", "planDurationModel$delegate", "Lkotlin/Lazy;", "priceList", "", "Lcom/livpure/safedrink/subscription/plan/data/model/plan/PriceItem;", "priceListReverse", "Lcom/livpure/safedrink/subscription/plan/data/model/payment/PriceMappingItem;", "selectedIndex", "", "bindVariablesToView", "", "dataBinding", "getLayoutId", "getViewModel", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onItemClick", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "position", "onViewCreated", "proceedToReviewOrder", "setPlanList", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PlanDurationFragment extends DataBindingFragment<FragmentPlanDurationBinding> implements ItemClickListener {
    private FragmentPlanDurationBinding binding;
    private final NavArgsLazy navArgs$delegate;
    private List<PriceItem> priceList;
    private List<PriceMappingItem> priceListReverse;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private final Lazy planDurationModel$delegate = LazyKt.lazy(new Function0<PlanDurationModel>() { // from class: com.livpure.safedrink.subscription.payment.view.PlanDurationFragment$planDurationModel$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final PlanDurationModel invoke() {
            PlanDurationFragmentArgs navArgs;
            PlanDurationFragmentArgs navArgs2;
            PlanDurationModel planDurationModel = (PlanDurationModel) new ViewModelProvider(PlanDurationFragment.this).get(PlanDurationModel.class);
            navArgs = PlanDurationFragment.this.getNavArgs();
            planDurationModel.setPlan(navArgs.getPlan());
            navArgs2 = PlanDurationFragment.this.getNavArgs();
            planDurationModel.setDevice(navArgs2.getDevice());
            return planDurationModel;
        }
    });
    private int selectedIndex = -1;

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
        return R.layout.fragment_plan_duration;
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.DataBindingFragment, com.livpure.safedrink.common.arc.ui.views.BaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public PlanDurationFragment() {
        final PlanDurationFragment planDurationFragment = this;
        this.navArgs$delegate = new NavArgsLazy(Reflection.getOrCreateKotlinClass(PlanDurationFragmentArgs.class), new Function0<Bundle>() { // from class: com.livpure.safedrink.subscription.payment.view.PlanDurationFragment$special$$inlined$navArgs$1
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
    public final PlanDurationFragmentArgs getNavArgs() {
        return (PlanDurationFragmentArgs) this.navArgs$delegate.getValue();
    }

    private final PlanDurationModel getPlanDurationModel() {
        return (PlanDurationModel) this.planDurationModel$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment
    public PlanDurationModel getViewModel() {
        return getPlanDurationModel();
    }

    private final void setPlanList() {
        List<PriceItem> list = this.priceList;
        FragmentPlanDurationBinding fragmentPlanDurationBinding = null;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("priceList");
            list = null;
        }
        Iterator<PriceItem> it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            i++;
            PriceItem next = it.next();
            if (next != null ? Intrinsics.areEqual((Object) next.getBestValue(), (Object) true) : false) {
                List<PriceItem> list2 = this.priceList;
                if (list2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("priceList");
                    list2 = null;
                }
                this.selectedIndex = list2.size() - i;
            }
        }
        if (this.selectedIndex == -1) {
            this.selectedIndex = 2;
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getMContext(), 1, false);
        FragmentPlanDurationBinding fragmentPlanDurationBinding2 = this.binding;
        if (fragmentPlanDurationBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentPlanDurationBinding2 = null;
        }
        fragmentPlanDurationBinding2.listPlanDurationId.setLayoutManager(linearLayoutManager);
        FragmentActivity mContext = getMContext();
        Intrinsics.checkNotNullExpressionValue(mContext, "mContext");
        FragmentActivity fragmentActivity = mContext;
        List<PriceItem> list3 = this.priceList;
        if (list3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("priceList");
            list3 = null;
        }
        PlanDurationAdapter planDurationAdapter = new PlanDurationAdapter(fragmentActivity, list3, this.selectedIndex, getPlanDurationModel());
        FragmentPlanDurationBinding fragmentPlanDurationBinding3 = this.binding;
        if (fragmentPlanDurationBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentPlanDurationBinding = fragmentPlanDurationBinding3;
        }
        fragmentPlanDurationBinding.listPlanDurationId.setAdapter(planDurationAdapter);
        planDurationAdapter.setOnItemClickListener(this);
        this.selectedIndex = 1;
        ((TextView) _$_findCachedViewById(R.id.tvBilledStatus)).setText("(Billed Monthly)");
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        if (isAdded()) {
            UiUtilKt.hideKeyboard(requireActivity());
        }
        List<PriceItem> selectedPlan = getPlanDurationModel().getSelectedPlan();
        Intrinsics.checkNotNull(selectedPlan);
        ArrayList arrayList = new ArrayList();
        for (Object obj : selectedPlan) {
            PriceItem priceItem = (PriceItem) obj;
            if (!Intrinsics.areEqual(priceItem != null ? priceItem.getDuration() : null, ExifInterface.GPS_MEASUREMENT_3D)) {
                arrayList.add(obj);
            }
        }
        this.priceList = arrayList;
        setPlanList();
        ((LinearLayout) _$_findCachedViewById(R.id.btnRenewPlanId)).setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.subscription.payment.view.PlanDurationFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PlanDurationFragment.m1340onViewCreated$lambda1(PlanDurationFragment.this, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-1  reason: not valid java name */
    public static final void m1340onViewCreated$lambda1(PlanDurationFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.proceedToReviewOrder();
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        ((MainActivity) requireActivity()).setupDefaultUpButtonNavigation();
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.DataBindingFragment
    public void bindVariablesToView(FragmentPlanDurationBinding dataBinding) {
        Intrinsics.checkNotNullParameter(dataBinding, "dataBinding");
        this.binding = dataBinding;
        dataBinding.setViewModel(getPlanDurationModel());
    }

    private final void proceedToReviewOrder() {
        int i = this.selectedIndex;
        int i2 = i == 0 ? 2 : i - 1;
        PlansItem plan = getPlanDurationModel().getPlan();
        if (plan != null) {
            List<PriceItem> list = this.priceList;
            if (list == null) {
                Intrinsics.throwUninitializedPropertyAccessException("priceList");
                list = null;
            }
            PriceItem priceItem = list.get(i2);
            String duration = priceItem != null ? priceItem.getDuration() : null;
            Intrinsics.checkNotNull(duration);
            plan.setSelectedDuration(Integer.valueOf(Integer.parseInt(duration)));
        }
        PlansItem plan2 = getPlanDurationModel().getPlan();
        if (plan2 == null) {
            return;
        }
        List<PriceItem> list2 = this.priceList;
        if (list2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("priceList");
            list2 = null;
        }
        PriceItem priceItem2 = list2.get(i2);
        String price = priceItem2 != null ? priceItem2.getPrice() : null;
        Intrinsics.checkNotNull(price);
        plan2.setSelectedDurationPrice(Long.valueOf(Long.parseLong(price)));
    }

    @Override // com.livpure.safedrink.interfaces.ItemClickListener
    public void onItemClick(View view, int i) {
        List<PriceItem> list = this.priceList;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("priceList");
            list = null;
        }
        int size = list.size() - i;
        this.selectedIndex = size;
        if (size == 3) {
            ((TextView) _$_findCachedViewById(R.id.tvBilledStatus)).setText("(Billed Annually)");
        } else if (size == 2) {
            ((TextView) _$_findCachedViewById(R.id.tvBilledStatus)).setText("(Billed Semi Annually)");
        } else if (size == 1) {
            ((TextView) _$_findCachedViewById(R.id.tvBilledStatus)).setText("(Billed Monthly)");
        }
    }
}
