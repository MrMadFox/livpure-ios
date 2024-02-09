package com.livpure.safedrink.subscription.payment.view;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.FragmentKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.livpure.safedrink.R;
import com.livpure.safedrink.common.arc.ui.viewmodels.BaseViewModel;
import com.livpure.safedrink.common.arc.ui.views.DataBindingFragment;
import com.livpure.safedrink.databinding.FragmentPlanBinding;
import com.livpure.safedrink.interfaces.ItemClickListener;
import com.livpure.safedrink.subscription.payment.adapter.PlanDurationsAdapter;
import com.livpure.safedrink.subscription.payment.viewmodel.SelectPlanViewModel;
import com.livpure.safedrink.subscription.plan.data.model.deviceList.DeviceList;
import com.livpure.safedrink.subscription.plan.data.model.payment.PriceMappingItem;
import com.livpure.safedrink.subscription.plan.data.model.plan.PlansItem;
import com.livpure.safedrink.subscription.plan.data.model.plan.PriceItem;
import com.livpure.safedrink.view.fragment.CommonItemSpaceDecoration;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: PlanFragment.kt */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004B\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0002H\u0016J\b\u0010*\u001a\u00020&H\u0014J\b\u0010+\u001a\u00020,H\u0014J\u0010\u0010-\u001a\u00020(2\u0006\u0010.\u001a\u00020/H\u0002J\b\u00100\u001a\u00020(H\u0002J\u0010\u00101\u001a\u00020(2\u0006\u00102\u001a\u00020/H\u0016J\u001a\u00103\u001a\u00020(2\b\u0010.\u001a\u0004\u0018\u00010/2\u0006\u00104\u001a\u00020&H\u0016J\u001a\u00105\u001a\u00020(2\u0006\u0010.\u001a\u00020/2\b\u00106\u001a\u0004\u0018\u000107H\u0016J\b\u00108\u001a\u00020(H\u0002R*\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0002X\u0082.¢\u0006\u0002\n\u0000R\u0018\u0010\u0015\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001f\u001a\u00020 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b!\u0010\"R\u000e\u0010%\u001a\u00020&X\u0082D¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/livpure/safedrink/subscription/payment/view/PlanFragment;", "Lcom/livpure/safedrink/common/arc/ui/views/DataBindingFragment;", "Lcom/livpure/safedrink/databinding/FragmentPlanBinding;", "Lcom/livpure/safedrink/interfaces/ItemClickListener;", "Landroid/view/View$OnClickListener;", "planItem", "Lcom/livpure/safedrink/subscription/plan/data/model/plan/PlansItem;", AndroidContextPlugin.DEVICE_KEY, "Lcom/livpure/safedrink/subscription/plan/data/model/deviceList/DeviceList;", "(Lcom/livpure/safedrink/subscription/plan/data/model/plan/PlansItem;Lcom/livpure/safedrink/subscription/plan/data/model/deviceList/DeviceList;)V", "compareByFirstName", "Ljava/util/Comparator;", "Lcom/livpure/safedrink/subscription/plan/data/model/payment/PriceMappingItem;", "Lkotlin/Comparator;", "getCompareByFirstName", "()Ljava/util/Comparator;", "setCompareByFirstName", "(Ljava/util/Comparator;)V", "getDevice", "()Lcom/livpure/safedrink/subscription/plan/data/model/deviceList/DeviceList;", "fragmentPlanBinding", "listPriceMappingItem", "", "Lcom/livpure/safedrink/subscription/plan/data/model/plan/PriceItem;", "navController", "Landroidx/navigation/NavController;", "getPlanItem", "()Lcom/livpure/safedrink/subscription/plan/data/model/plan/PlansItem;", "priceMappingItem", "refundStatus", "", "selectPlanOrRechargeViewModel", "Lcom/livpure/safedrink/subscription/payment/viewmodel/SelectPlanViewModel;", "getSelectPlanOrRechargeViewModel", "()Lcom/livpure/safedrink/subscription/payment/viewmodel/SelectPlanViewModel;", "selectPlanOrRechargeViewModel$delegate", "Lkotlin/Lazy;", "selectedIndex", "", "bindVariablesToView", "", "dataBinding", "getLayoutId", "getViewModel", "Lcom/livpure/safedrink/common/arc/ui/viewmodels/BaseViewModel;", "initViewContext", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "listeners", "onClick", "v", "onItemClick", "position", "onViewCreated", "savedInstanceState", "Landroid/os/Bundle;", "showPlanDetails", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PlanFragment extends DataBindingFragment<FragmentPlanBinding> implements ItemClickListener, View.OnClickListener {
    public Map<Integer, View> _$_findViewCache;
    private Comparator<PriceMappingItem> compareByFirstName;
    private final DeviceList device;
    private FragmentPlanBinding fragmentPlanBinding;
    private List<PriceItem> listPriceMappingItem;
    private NavController navController;
    private final PlansItem planItem;
    private PriceItem priceMappingItem;
    private boolean refundStatus;
    private final Lazy selectPlanOrRechargeViewModel$delegate;
    private final int selectedIndex;

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
        return R.layout.fragment_plan;
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.DataBindingFragment, com.livpure.safedrink.common.arc.ui.views.BaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public PlanFragment(PlansItem planItem, DeviceList device) {
        Intrinsics.checkNotNullParameter(planItem, "planItem");
        Intrinsics.checkNotNullParameter(device, "device");
        this._$_findViewCache = new LinkedHashMap();
        this.planItem = planItem;
        this.device = device;
        this.selectedIndex = 2;
        this.selectPlanOrRechargeViewModel$delegate = LazyKt.lazy(new Function0<SelectPlanViewModel>() { // from class: com.livpure.safedrink.subscription.payment.view.PlanFragment$selectPlanOrRechargeViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SelectPlanViewModel invoke() {
                return (SelectPlanViewModel) new ViewModelProvider(PlanFragment.this).get(SelectPlanViewModel.class);
            }
        });
        this.compareByFirstName = new Comparator() { // from class: com.livpure.safedrink.subscription.payment.view.PlanFragment$$ExternalSyntheticLambda0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int m1342compareByFirstName$lambda4;
                m1342compareByFirstName$lambda4 = PlanFragment.m1342compareByFirstName$lambda4((PriceMappingItem) obj, (PriceMappingItem) obj2);
                return m1342compareByFirstName$lambda4;
            }
        };
    }

    public final DeviceList getDevice() {
        return this.device;
    }

    public final PlansItem getPlanItem() {
        return this.planItem;
    }

    private final SelectPlanViewModel getSelectPlanOrRechargeViewModel() {
        return (SelectPlanViewModel) this.selectPlanOrRechargeViewModel$delegate.getValue();
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment
    protected BaseViewModel getViewModel() {
        return getSelectPlanOrRechargeViewModel();
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        initViewContext(view);
        listeners();
        showPlanDetails();
    }

    private final void initViewContext(View view) {
        this.navController = FragmentKt.findNavController(this);
    }

    private final void listeners() {
        FragmentPlanBinding fragmentPlanBinding = this.fragmentPlanBinding;
        FragmentPlanBinding fragmentPlanBinding2 = null;
        if (fragmentPlanBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fragmentPlanBinding");
            fragmentPlanBinding = null;
        }
        PlanFragment planFragment = this;
        fragmentPlanBinding.imgRefundStatusId.setOnClickListener(planFragment);
        FragmentPlanBinding fragmentPlanBinding3 = this.fragmentPlanBinding;
        if (fragmentPlanBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fragmentPlanBinding");
        } else {
            fragmentPlanBinding2 = fragmentPlanBinding3;
        }
        fragmentPlanBinding2.lytProceedToPayId.setOnClickListener(planFragment);
    }

    private final void showPlanDetails() {
        ArrayList arrayList;
        String duration;
        List sortedWith;
        List reversed;
        FragmentPlanBinding fragmentPlanBinding = this.fragmentPlanBinding;
        if (fragmentPlanBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fragmentPlanBinding");
            fragmentPlanBinding = null;
        }
        fragmentPlanBinding.setPlanItem(this.planItem);
        FragmentPlanBinding fragmentPlanBinding2 = this.fragmentPlanBinding;
        if (fragmentPlanBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fragmentPlanBinding");
            fragmentPlanBinding2 = null;
        }
        fragmentPlanBinding2.setPlanItem(this.planItem);
        List<PriceItem> price = this.planItem.getPrice();
        if (price == null || (sortedWith = CollectionsKt.sortedWith(price, new Comparator() { // from class: com.livpure.safedrink.subscription.payment.view.PlanFragment$showPlanDetails$$inlined$compareBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                PriceItem priceItem = (PriceItem) t;
                String duration2 = priceItem != null ? priceItem.getDuration() : null;
                Intrinsics.checkNotNull(duration2);
                Integer valueOf = Integer.valueOf(Integer.parseInt(duration2));
                PriceItem priceItem2 = (PriceItem) t2;
                String duration3 = priceItem2 != null ? priceItem2.getDuration() : null;
                Intrinsics.checkNotNull(duration3);
                return ComparisonsKt.compareValues(valueOf, Integer.valueOf(Integer.parseInt(duration3)));
            }
        })) == null || (reversed = CollectionsKt.reversed(sortedWith)) == null) {
            arrayList = null;
        } else {
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : reversed) {
                PriceItem priceItem = (PriceItem) obj;
                if ((priceItem != null ? priceItem.getPricePerMonth() : null) != null) {
                    arrayList2.add(obj);
                }
            }
            arrayList = arrayList2;
        }
        this.listPriceMappingItem = arrayList;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getMContext(), 1, false);
        FragmentPlanBinding fragmentPlanBinding3 = this.fragmentPlanBinding;
        if (fragmentPlanBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fragmentPlanBinding");
            fragmentPlanBinding3 = null;
        }
        fragmentPlanBinding3.listPlanPriceId.setLayoutManager(linearLayoutManager);
        FragmentActivity mContext = getMContext();
        Intrinsics.checkNotNullExpressionValue(mContext, "mContext");
        List<PriceItem> list = this.listPriceMappingItem;
        Intrinsics.checkNotNull(list);
        PlanDurationsAdapter planDurationsAdapter = new PlanDurationsAdapter(mContext, list, this.selectedIndex);
        FragmentPlanBinding fragmentPlanBinding4 = this.fragmentPlanBinding;
        if (fragmentPlanBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fragmentPlanBinding");
            fragmentPlanBinding4 = null;
        }
        fragmentPlanBinding4.listPlanPriceId.setAdapter(planDurationsAdapter);
        FragmentPlanBinding fragmentPlanBinding5 = this.fragmentPlanBinding;
        if (fragmentPlanBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fragmentPlanBinding");
            fragmentPlanBinding5 = null;
        }
        fragmentPlanBinding5.listPlanPriceId.addItemDecoration(new CommonItemSpaceDecoration(4));
        planDurationsAdapter.setOnItemClickListener(this);
        PlansItem plansItem = this.planItem;
        List<PriceItem> list2 = this.listPriceMappingItem;
        Intrinsics.checkNotNull(list2);
        PriceItem priceItem2 = list2.get(2);
        plansItem.setSelectedDuration((priceItem2 == null || (duration = priceItem2.getDuration()) == null) ? null : Integer.valueOf(Integer.parseInt(duration)));
        List<PriceItem> list3 = this.listPriceMappingItem;
        Intrinsics.checkNotNull(list3);
        PriceItem priceItem3 = list3.get(2);
        String price2 = priceItem3 != null ? priceItem3.getPrice() : null;
        Intrinsics.checkNotNull(price2);
        long parseLong = Long.parseLong(price2);
        String depositAmount = this.planItem.getDepositAmount();
        Intrinsics.checkNotNull(depositAmount);
        plansItem.setSelectedDurationPrice(Long.valueOf(parseLong + Long.parseLong(depositAmount)));
        List<PriceItem> list4 = this.listPriceMappingItem;
        Intrinsics.checkNotNull(list4);
        this.priceMappingItem = list4.get(2);
    }

    @Override // com.livpure.safedrink.interfaces.ItemClickListener
    public void onItemClick(View view, int i) {
        String str;
        PriceItem priceItem;
        String price;
        String price2;
        String duration;
        List<PriceItem> list = this.listPriceMappingItem;
        Intrinsics.checkNotNull(list);
        this.priceMappingItem = list.get(i);
        FragmentPlanBinding fragmentPlanBinding = this.fragmentPlanBinding;
        Long l = null;
        if (fragmentPlanBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fragmentPlanBinding");
            fragmentPlanBinding = null;
        }
        TextView textView = fragmentPlanBinding.tvBilledStatus;
        PriceItem priceItem2 = this.priceMappingItem;
        String duration2 = priceItem2 != null ? priceItem2.getDuration() : null;
        if (duration2 != null) {
            int hashCode = duration2.hashCode();
            if (hashCode != 49) {
                if (hashCode != 54) {
                    if (hashCode == 1569 && duration2.equals("12")) {
                        FragmentPlanBinding fragmentPlanBinding2 = this.fragmentPlanBinding;
                        if (fragmentPlanBinding2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("fragmentPlanBinding");
                            fragmentPlanBinding2 = null;
                        }
                        fragmentPlanBinding2.lytRefundStatusId.setVisibility(0);
                    }
                } else if (duration2.equals("6")) {
                    FragmentPlanBinding fragmentPlanBinding3 = this.fragmentPlanBinding;
                    if (fragmentPlanBinding3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("fragmentPlanBinding");
                        fragmentPlanBinding3 = null;
                    }
                    fragmentPlanBinding3.lytRefundStatusId.setVisibility(0);
                }
            } else if (duration2.equals("1")) {
                FragmentPlanBinding fragmentPlanBinding4 = this.fragmentPlanBinding;
                if (fragmentPlanBinding4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("fragmentPlanBinding");
                    fragmentPlanBinding4 = null;
                }
                fragmentPlanBinding4.lytRefundStatusId.setVisibility(0);
            }
            textView.setText(str);
            PlansItem plansItem = this.planItem;
            PriceItem priceItem3 = this.priceMappingItem;
            plansItem.setSelectedDuration((priceItem3 != null || (duration = priceItem3.getDuration()) == null) ? null : Integer.valueOf(Integer.parseInt(duration)));
            PriceItem priceItem4 = this.priceMappingItem;
            plansItem.setSelectedDurationPrice((priceItem4 != null || (price2 = priceItem4.getPrice()) == null) ? null : Long.valueOf(Long.parseLong(price2)));
            priceItem = this.priceMappingItem;
            if (priceItem != null && (price = priceItem.getPrice()) != null) {
                long parseLong = Long.parseLong(price);
                String depositAmount = this.planItem.getDepositAmount();
                Intrinsics.checkNotNull(depositAmount);
                l = Long.valueOf(parseLong + Long.parseLong(depositAmount));
            }
            plansItem.setSelectedDurationPrice(l);
        }
        FragmentPlanBinding fragmentPlanBinding5 = this.fragmentPlanBinding;
        if (fragmentPlanBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fragmentPlanBinding");
            fragmentPlanBinding5 = null;
        }
        fragmentPlanBinding5.lytRefundStatusId.setVisibility(0);
        textView.setText(str);
        PlansItem plansItem2 = this.planItem;
        PriceItem priceItem32 = this.priceMappingItem;
        plansItem2.setSelectedDuration((priceItem32 != null || (duration = priceItem32.getDuration()) == null) ? null : Integer.valueOf(Integer.parseInt(duration)));
        PriceItem priceItem42 = this.priceMappingItem;
        plansItem2.setSelectedDurationPrice((priceItem42 != null || (price2 = priceItem42.getPrice()) == null) ? null : Long.valueOf(Long.parseLong(price2)));
        priceItem = this.priceMappingItem;
        if (priceItem != null) {
            long parseLong2 = Long.parseLong(price);
            String depositAmount2 = this.planItem.getDepositAmount();
            Intrinsics.checkNotNull(depositAmount2);
            l = Long.valueOf(parseLong2 + Long.parseLong(depositAmount2));
        }
        plansItem2.setSelectedDurationPrice(l);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        if (v.getId() == R.id.imgRefundStatusId) {
            FragmentPlanBinding fragmentPlanBinding = null;
            if (!this.refundStatus) {
                this.refundStatus = true;
                FragmentPlanBinding fragmentPlanBinding2 = this.fragmentPlanBinding;
                if (fragmentPlanBinding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("fragmentPlanBinding");
                    fragmentPlanBinding2 = null;
                }
                fragmentPlanBinding2.lytExtraInfoId.setVisibility(0);
                FragmentPlanBinding fragmentPlanBinding3 = this.fragmentPlanBinding;
                if (fragmentPlanBinding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("fragmentPlanBinding");
                } else {
                    fragmentPlanBinding = fragmentPlanBinding3;
                }
                fragmentPlanBinding.imgRefundStatusId.setImageResource(R.drawable.chevron_up);
                return;
            }
            this.refundStatus = false;
            FragmentPlanBinding fragmentPlanBinding4 = this.fragmentPlanBinding;
            if (fragmentPlanBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fragmentPlanBinding");
                fragmentPlanBinding4 = null;
            }
            fragmentPlanBinding4.lytExtraInfoId.setVisibility(8);
            FragmentPlanBinding fragmentPlanBinding5 = this.fragmentPlanBinding;
            if (fragmentPlanBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fragmentPlanBinding");
            } else {
                fragmentPlanBinding = fragmentPlanBinding5;
            }
            fragmentPlanBinding.imgRefundStatusId.setImageResource(R.drawable.chevron_down);
        }
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.DataBindingFragment
    public void bindVariablesToView(FragmentPlanBinding dataBinding) {
        Intrinsics.checkNotNullParameter(dataBinding, "dataBinding");
        this.fragmentPlanBinding = dataBinding;
    }

    public final Comparator<PriceMappingItem> getCompareByFirstName() {
        return this.compareByFirstName;
    }

    public final void setCompareByFirstName(Comparator<PriceMappingItem> comparator) {
        Intrinsics.checkNotNullParameter(comparator, "<set-?>");
        this.compareByFirstName = comparator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: compareByFirstName$lambda-4  reason: not valid java name */
    public static final int m1342compareByFirstName$lambda4(PriceMappingItem o1, PriceMappingItem o2) {
        Intrinsics.checkNotNullParameter(o1, "o1");
        Intrinsics.checkNotNullParameter(o2, "o2");
        return o1.getDuration().compareTo(o2.getDuration());
    }
}
