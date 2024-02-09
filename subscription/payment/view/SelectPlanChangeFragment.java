package com.livpure.safedrink.subscription.payment.view;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavArgsLazy;
import androidx.navigation.fragment.FragmentKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.button.MaterialButton;
import com.livpure.safedrink.R;
import com.livpure.safedrink.common.arc.ui.views.DataBindingFragment;
import com.livpure.safedrink.databinding.FragmentPlanChangeBinding;
import com.livpure.safedrink.interfaces.ItemClickListener;
import com.livpure.safedrink.interfaces.MultiItemClickListener;
import com.livpure.safedrink.interfaces.RefreshPlanListListener;
import com.livpure.safedrink.login.MainActivity;
import com.livpure.safedrink.subscription.payment.adapter.ExpandablePlanAdapter;
import com.livpure.safedrink.subscription.payment.adapter.HolidayPlanAdapter;
import com.livpure.safedrink.subscription.payment.adapter.PlanValidityAdapter;
import com.livpure.safedrink.subscription.payment.adapter.PlansDurationsAdapter;
import com.livpure.safedrink.subscription.payment.adapter.UnlimitedPlanAdapter;
import com.livpure.safedrink.subscription.payment.view.SelectPlanChangeFragmentDirections;
import com.livpure.safedrink.subscription.payment.viewmodel.SelectPlanChangeModel;
import com.livpure.safedrink.subscription.plan.data.model.deviceList.DeviceList;
import com.livpure.safedrink.subscription.plan.data.model.plan.Currentplans;
import com.livpure.safedrink.subscription.plan.data.model.plan.PlansItem;
import com.livpure.safedrink.subscription.plan.data.model.plan.PriceItem;
import com.livpure.safedrink.subscription.plan.data.model.plan.Response;
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
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
/* compiled from: SelectPlanChangeFrament.kt */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u0005B\u0005¢\u0006\u0002\u0010\u0006J\u0010\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u0002H\u0016J\b\u00109\u001a\u00020\rH\u0014J\b\u0010:\u001a\u00020*H\u0014J\u0012\u0010;\u001a\u0002072\b\u0010<\u001a\u0004\u0018\u00010=H\u0016J2\u0010>\u001a\u0002072\b\u0010?\u001a\u0004\u0018\u00010@2\u0006\u0010A\u001a\u00020\r2\u0006\u0010B\u001a\u00020\r2\u0006\u0010C\u001a\u00020\u001f2\u0006\u0010D\u001a\u00020\u001fH\u0016J \u0010E\u001a\u0002072\u0006\u0010C\u001a\u00020\u001f2\u0006\u0010D\u001a\u00020\u001f2\u0006\u0010F\u001a\u00020\u001fH\u0017J\u0012\u0010G\u001a\u0002072\b\u0010<\u001a\u0004\u0018\u00010=H\u0016J\u001a\u0010H\u001a\u0002072\b\u0010?\u001a\u0004\u0018\u00010@2\u0006\u0010I\u001a\u00020\rH\u0016J\b\u0010J\u001a\u000207H\u0016J\u001a\u0010K\u001a\u0002072\u0006\u0010?\u001a\u00020@2\b\u0010<\u001a\u0004\u0018\u00010=H\u0016J \u0010L\u001a\u0002072\u0006\u0010(\u001a\u00020'2\u0006\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020NH\u0002J2\u0010P\u001a\u0002072\b\u0010?\u001a\u0004\u0018\u00010@2\u0006\u0010A\u001a\u00020\r2\u0006\u0010B\u001a\u00020\r2\u0006\u0010C\u001a\u00020\u001f2\u0006\u0010D\u001a\u00020\u001fH\u0016J\u0016\u0010Q\u001a\u0002072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002J\u0016\u0010R\u001a\u0002072\f\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\nH\u0002J \u0010S\u001a\u0002072\f\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J\u0010\u0010T\u001a\u0002072\u0006\u0010U\u001a\u00020\u000bH\u0002J\b\u0010V\u001a\u000207H\u0002J(\u0010W\u001a\u0002072\u0006\u0010X\u001a\u00020\u000b2\u0006\u0010A\u001a\u00020\r2\u0006\u0010C\u001a\u00020\u001f2\u0006\u0010D\u001a\u00020\u001fH\u0002J\u0016\u0010Y\u001a\u0002072\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002J\b\u0010Z\u001a\u000207H\u0002R\u000e\u0010\u0007\u001a\u00020\u0002X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0002X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010 \u001a\u00020!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b\"\u0010#R\u0014\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\nX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010)\u001a\u00020*8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b+\u0010,R\u001c\u0010/\u001a\u0004\u0018\u000100X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u0014\u00105\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082.¢\u0006\u0002\n\u0000¨\u0006["}, d2 = {"Lcom/livpure/safedrink/subscription/payment/view/SelectPlanChangeFragment;", "Lcom/livpure/safedrink/common/arc/ui/views/DataBindingFragment;", "Lcom/livpure/safedrink/databinding/FragmentPlanChangeBinding;", "Lcom/livpure/safedrink/interfaces/ItemClickListener;", "Lcom/livpure/safedrink/interfaces/MultiItemClickListener;", "Lcom/livpure/safedrink/interfaces/RefreshPlanListListener;", "()V", "binding", "bindingPlan", "changePlanList", "", "Lcom/livpure/safedrink/subscription/plan/data/model/plan/PlansItem;", "childPositionMaster", "", "currentPlans", "Lcom/livpure/safedrink/subscription/plan/data/model/plan/Currentplans;", "expandableAdapter", "Lcom/livpure/safedrink/subscription/payment/adapter/ExpandablePlanAdapter;", "getExpandableAdapter", "()Lcom/livpure/safedrink/subscription/payment/adapter/ExpandablePlanAdapter;", "setExpandableAdapter", "(Lcom/livpure/safedrink/subscription/payment/adapter/ExpandablePlanAdapter;)V", "holidayAdapter", "Lcom/livpure/safedrink/subscription/payment/adapter/HolidayPlanAdapter;", "getHolidayAdapter", "()Lcom/livpure/safedrink/subscription/payment/adapter/HolidayPlanAdapter;", "setHolidayAdapter", "(Lcom/livpure/safedrink/subscription/payment/adapter/HolidayPlanAdapter;)V", "holidayPlanList", "isSelectedPlanId", "isUpdate", "", "navArgs", "Lcom/livpure/safedrink/subscription/payment/view/SelectPlanChangeFragmentArgs;", "getNavArgs", "()Lcom/livpure/safedrink/subscription/payment/view/SelectPlanChangeFragmentArgs;", "navArgs$delegate", "Landroidx/navigation/NavArgsLazy;", "planDurationList", "Lcom/livpure/safedrink/subscription/plan/data/model/plan/PriceItem;", "priceItem", "selectPlanChangeModel", "Lcom/livpure/safedrink/subscription/payment/viewmodel/SelectPlanChangeModel;", "getSelectPlanChangeModel", "()Lcom/livpure/safedrink/subscription/payment/viewmodel/SelectPlanChangeModel;", "selectPlanChangeModel$delegate", "Lkotlin/Lazy;", "unlimitedPlanAdapter", "Lcom/livpure/safedrink/subscription/payment/adapter/UnlimitedPlanAdapter;", "getUnlimitedPlanAdapter", "()Lcom/livpure/safedrink/subscription/payment/adapter/UnlimitedPlanAdapter;", "setUnlimitedPlanAdapter", "(Lcom/livpure/safedrink/subscription/payment/adapter/UnlimitedPlanAdapter;)V", "unlimitedPlanList", "bindVariablesToView", "", "dataBinding", "getLayoutId", "getViewModel", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onChildItemClick", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "parentPosition", "childPosition", "isHoliday", "isUnlimited", "onClick", "isChangePlan", "onCreate", "onItemClick", "position", "onResume", "onViewCreated", "proceedToReviewOrder", "planNumber", "", "planName", "selectedPlanClickEvent", "showChangePlanDetails", "showCurrentPlanDetails", "showCurrentPlanDialog", "showHolidayPlanDetails", "holidayPlan", "showPlanDetails", "showPlanDialog", "changePlan", "showUnlimitedPlanDetails", "updateSelectedPlan", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SelectPlanChangeFragment extends DataBindingFragment<FragmentPlanChangeBinding> implements ItemClickListener, MultiItemClickListener, RefreshPlanListListener {
    private FragmentPlanChangeBinding binding;
    private FragmentPlanChangeBinding bindingPlan;
    private List<PlansItem> changePlanList;
    private int childPositionMaster;
    private Currentplans currentPlans;
    private ExpandablePlanAdapter expandableAdapter;
    private HolidayPlanAdapter holidayAdapter;
    private PlansItem holidayPlanList;
    private int isSelectedPlanId;
    private boolean isUpdate;
    private final NavArgsLazy navArgs$delegate;
    private List<PriceItem> planDurationList;
    private PriceItem priceItem;
    private UnlimitedPlanAdapter unlimitedPlanAdapter;
    private List<PlansItem> unlimitedPlanList;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private final Lazy selectPlanChangeModel$delegate = LazyKt.lazy(new Function0<SelectPlanChangeModel>() { // from class: com.livpure.safedrink.subscription.payment.view.SelectPlanChangeFragment$selectPlanChangeModel$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final SelectPlanChangeModel invoke() {
            SelectPlanChangeFragmentArgs navArgs;
            SelectPlanChangeModel selectPlanChangeModel = (SelectPlanChangeModel) new ViewModelProvider(SelectPlanChangeFragment.this).get(SelectPlanChangeModel.class);
            navArgs = SelectPlanChangeFragment.this.getNavArgs();
            selectPlanChangeModel.setDevice(navArgs.getDevice());
            return selectPlanChangeModel;
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
        return R.layout.fragment_plan_change;
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.DataBindingFragment, com.livpure.safedrink.common.arc.ui.views.BaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public SelectPlanChangeFragment() {
        final SelectPlanChangeFragment selectPlanChangeFragment = this;
        this.navArgs$delegate = new NavArgsLazy(Reflection.getOrCreateKotlinClass(SelectPlanChangeFragmentArgs.class), new Function0<Bundle>() { // from class: com.livpure.safedrink.subscription.payment.view.SelectPlanChangeFragment$special$$inlined$navArgs$1
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

    public final ExpandablePlanAdapter getExpandableAdapter() {
        return this.expandableAdapter;
    }

    public final void setExpandableAdapter(ExpandablePlanAdapter expandablePlanAdapter) {
        this.expandableAdapter = expandablePlanAdapter;
    }

    public final HolidayPlanAdapter getHolidayAdapter() {
        return this.holidayAdapter;
    }

    public final void setHolidayAdapter(HolidayPlanAdapter holidayPlanAdapter) {
        this.holidayAdapter = holidayPlanAdapter;
    }

    public final UnlimitedPlanAdapter getUnlimitedPlanAdapter() {
        return this.unlimitedPlanAdapter;
    }

    public final void setUnlimitedPlanAdapter(UnlimitedPlanAdapter unlimitedPlanAdapter) {
        this.unlimitedPlanAdapter = unlimitedPlanAdapter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SelectPlanChangeFragmentArgs getNavArgs() {
        return (SelectPlanChangeFragmentArgs) this.navArgs$delegate.getValue();
    }

    private final SelectPlanChangeModel getSelectPlanChangeModel() {
        return (SelectPlanChangeModel) this.selectPlanChangeModel$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment
    public SelectPlanChangeModel getViewModel() {
        return getSelectPlanChangeModel();
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        showPlanDetails();
    }

    private final void showPlanDetails() {
        getSelectPlanChangeModel().getPlanDetails().observe(requireActivity(), new Observer() { // from class: com.livpure.safedrink.subscription.payment.view.SelectPlanChangeFragment$$ExternalSyntheticLambda5
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SelectPlanChangeFragment.m1366showPlanDetails$lambda0(SelectPlanChangeFragment.this, (Response) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showPlanDetails$lambda-0  reason: not valid java name */
    public static final void m1366showPlanDetails$lambda0(SelectPlanChangeFragment this$0, Response response) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (response.getData() == null || !this$0.isAdded()) {
            return;
        }
        this$0.isUpdate = true;
        if (response.getData().getCurrentplans() != null) {
            this$0.currentPlans = response.getData().getCurrentplans();
        }
        Currentplans currentplans = this$0.currentPlans;
        Intrinsics.checkNotNull(currentplans);
        List<PriceItem> price = currentplans.getPrice();
        Intrinsics.checkNotNull(price);
        this$0.planDurationList = price;
        List<PlansItem> plans = response.getData().getPlans();
        Intrinsics.checkNotNull(plans);
        this$0.changePlanList = plans;
        PlansItem holidayPlan = response.getData().getHolidayPlan();
        Intrinsics.checkNotNull(holidayPlan);
        this$0.holidayPlanList = holidayPlan;
        PlansItem plansItem = null;
        if (response.getData().getUnlimitedPlan() != null) {
            List<PlansItem> unlimitedPlan = response.getData().getUnlimitedPlan();
            this$0.unlimitedPlanList = unlimitedPlan;
            if (unlimitedPlan == null) {
                Intrinsics.throwUninitializedPropertyAccessException("unlimitedPlanList");
                unlimitedPlan = null;
            }
            this$0.showUnlimitedPlanDetails(unlimitedPlan);
        }
        Currentplans currentplans2 = this$0.currentPlans;
        Intrinsics.checkNotNull(currentplans2);
        if (StringsKt.equals$default(currentplans2.getActive(), "yes", false, 2, null)) {
            FragmentPlanChangeBinding fragmentPlanChangeBinding = this$0.binding;
            if (fragmentPlanChangeBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentPlanChangeBinding = null;
            }
            fragmentPlanChangeBinding.btnRenewPlanId.setVisibility(0);
            FragmentPlanChangeBinding fragmentPlanChangeBinding2 = this$0.binding;
            if (fragmentPlanChangeBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentPlanChangeBinding2 = null;
            }
            fragmentPlanChangeBinding2.additionalUsage.setVisibility(0);
        } else {
            FragmentPlanChangeBinding fragmentPlanChangeBinding3 = this$0.binding;
            if (fragmentPlanChangeBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentPlanChangeBinding3 = null;
            }
            fragmentPlanChangeBinding3.btnRenewPlanId.setVisibility(8);
            FragmentPlanChangeBinding fragmentPlanChangeBinding4 = this$0.binding;
            if (fragmentPlanChangeBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentPlanChangeBinding4 = null;
            }
            fragmentPlanChangeBinding4.additionalUsage.setVisibility(8);
        }
        if (this$0.isSelectedPlanId == 0) {
            List<PriceItem> list = this$0.planDurationList;
            if (list == null) {
                Intrinsics.throwUninitializedPropertyAccessException("planDurationList");
                list = null;
            }
            this$0.showCurrentPlanDetails(list);
        }
        List<PlansItem> unlimitedPlan2 = response.getData().getUnlimitedPlan();
        if (unlimitedPlan2 != null && (unlimitedPlan2.isEmpty() ^ true)) {
            ((RelativeLayout) this$0._$_findCachedViewById(R.id.lytUnlimitedPlan)).setVisibility(0);
        }
        List<PlansItem> list2 = this$0.changePlanList;
        if (list2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("changePlanList");
            list2 = null;
        }
        this$0.showChangePlanDetails(list2);
        if (true ^ response.getData().getPlans().isEmpty()) {
            ((LinearLayout) this$0._$_findCachedViewById(R.id.lytChangePlan)).setVisibility(0);
            Currentplans currentplans3 = this$0.currentPlans;
            Intrinsics.checkNotNull(currentplans3);
            String planName = currentplans3.getPlanName();
            Intrinsics.checkNotNull(planName);
            if (StringsKt.contains$default((CharSequence) planName, (CharSequence) "Zinger", false, 2, (Object) null)) {
                FragmentPlanChangeBinding fragmentPlanChangeBinding5 = this$0.binding;
                if (fragmentPlanChangeBinding5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    fragmentPlanChangeBinding5 = null;
                }
                fragmentPlanChangeBinding5.txtPlan.setText(this$0.getString(R.string.renew_plan));
            } else {
                FragmentPlanChangeBinding fragmentPlanChangeBinding6 = this$0.binding;
                if (fragmentPlanChangeBinding6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    fragmentPlanChangeBinding6 = null;
                }
                fragmentPlanChangeBinding6.txtPlan.setText(this$0.getString(R.string.change_plan_to));
            }
        }
        if (response.getData().getHolidayPlan().getPrice() != null) {
            ((LinearLayout) this$0._$_findCachedViewById(R.id.lytHolidayPlan)).setVisibility(0);
        }
        PlansItem plansItem2 = this$0.holidayPlanList;
        if (plansItem2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("holidayPlanList");
        } else {
            plansItem = plansItem2;
        }
        this$0.showHolidayPlanDetails(plansItem);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.isSelectedPlanId = 0;
    }

    private final void showUnlimitedPlanDetails(List<PlansItem> list) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getMContext());
        FragmentPlanChangeBinding fragmentPlanChangeBinding = this.binding;
        FragmentPlanChangeBinding fragmentPlanChangeBinding2 = null;
        if (fragmentPlanChangeBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentPlanChangeBinding = null;
        }
        fragmentPlanChangeBinding.listUnlimitedPlanId.setLayoutManager(linearLayoutManager);
        FragmentActivity mContext = getMContext();
        Intrinsics.checkNotNullExpressionValue(mContext, "mContext");
        this.unlimitedPlanAdapter = new UnlimitedPlanAdapter(mContext, list, this);
        FragmentPlanChangeBinding fragmentPlanChangeBinding3 = this.binding;
        if (fragmentPlanChangeBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentPlanChangeBinding2 = fragmentPlanChangeBinding3;
        }
        fragmentPlanChangeBinding2.listUnlimitedPlanId.setAdapter(this.unlimitedPlanAdapter);
        UnlimitedPlanAdapter unlimitedPlanAdapter = this.unlimitedPlanAdapter;
        if (unlimitedPlanAdapter != null) {
            unlimitedPlanAdapter.setOnItemClickListener(this);
        }
    }

    private final void showCurrentPlanDetails(List<PriceItem> list) {
        String str;
        this.isSelectedPlanId = 1;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getMContext(), 0, false);
        FragmentPlanChangeBinding fragmentPlanChangeBinding = this.binding;
        FragmentPlanChangeBinding fragmentPlanChangeBinding2 = null;
        if (fragmentPlanChangeBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentPlanChangeBinding = null;
        }
        fragmentPlanChangeBinding.listPlanValidityId.setLayoutManager(linearLayoutManager);
        Currentplans currentplans = this.currentPlans;
        if ((currentplans != null ? currentplans.getAmount() : null) != null) {
            Currentplans currentplans2 = this.currentPlans;
            str = currentplans2 != null ? currentplans2.getAmount() : null;
            Intrinsics.checkNotNull(str);
        } else {
            str = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        }
        FragmentActivity mContext = getMContext();
        Intrinsics.checkNotNullExpressionValue(mContext, "mContext");
        List<PriceItem> list2 = list;
        PlansDurationsAdapter plansDurationsAdapter = new PlansDurationsAdapter(mContext, CollectionsKt.sortedWith(list2, new Comparator() { // from class: com.livpure.safedrink.subscription.payment.view.SelectPlanChangeFragment$showCurrentPlanDetails$$inlined$sortedByDescending$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                String duration = ((PriceItem) t2).getDuration();
                Integer valueOf = duration != null ? Integer.valueOf(Integer.parseInt(duration)) : null;
                String duration2 = ((PriceItem) t).getDuration();
                return ComparisonsKt.compareValues(valueOf, duration2 != null ? Integer.valueOf(Integer.parseInt(duration2)) : null);
            }
        }), Integer.parseInt(str));
        FragmentPlanChangeBinding fragmentPlanChangeBinding3 = this.binding;
        if (fragmentPlanChangeBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentPlanChangeBinding2 = fragmentPlanChangeBinding3;
        }
        fragmentPlanChangeBinding2.listPlanValidityId.setAdapter(plansDurationsAdapter);
        plansDurationsAdapter.setOnItemClickListener(this);
        if (this.priceItem == null) {
            this.priceItem = (PriceItem) CollectionsKt.sortedWith(list2, new Comparator() { // from class: com.livpure.safedrink.subscription.payment.view.SelectPlanChangeFragment$showCurrentPlanDetails$$inlined$sortedByDescending$2
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    String duration = ((PriceItem) t2).getDuration();
                    Integer valueOf = duration != null ? Integer.valueOf(Integer.parseInt(duration)) : null;
                    String duration2 = ((PriceItem) t).getDuration();
                    return ComparisonsKt.compareValues(valueOf, duration2 != null ? Integer.valueOf(Integer.parseInt(duration2)) : null);
                }
            }).get(0);
        }
    }

    private final void showChangePlanDetails(List<PlansItem> list) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getMContext());
        FragmentPlanChangeBinding fragmentPlanChangeBinding = this.binding;
        FragmentPlanChangeBinding fragmentPlanChangeBinding2 = null;
        if (fragmentPlanChangeBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentPlanChangeBinding = null;
        }
        fragmentPlanChangeBinding.listChangePlanId.setLayoutManager(linearLayoutManager);
        FragmentActivity mContext = getMContext();
        Intrinsics.checkNotNullExpressionValue(mContext, "mContext");
        this.expandableAdapter = new ExpandablePlanAdapter(mContext, list, this);
        FragmentPlanChangeBinding fragmentPlanChangeBinding3 = this.binding;
        if (fragmentPlanChangeBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentPlanChangeBinding2 = fragmentPlanChangeBinding3;
        }
        fragmentPlanChangeBinding2.listChangePlanId.setAdapter(this.expandableAdapter);
        ExpandablePlanAdapter expandablePlanAdapter = this.expandableAdapter;
        if (expandablePlanAdapter != null) {
            expandablePlanAdapter.setOnItemClickListener(this);
        }
    }

    private final void showHolidayPlanDetails(PlansItem plansItem) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getMContext());
        FragmentPlanChangeBinding fragmentPlanChangeBinding = this.binding;
        FragmentPlanChangeBinding fragmentPlanChangeBinding2 = null;
        if (fragmentPlanChangeBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentPlanChangeBinding = null;
        }
        fragmentPlanChangeBinding.listHolidayPlanId.setLayoutManager(linearLayoutManager);
        FragmentActivity mContext = getMContext();
        Intrinsics.checkNotNullExpressionValue(mContext, "mContext");
        this.holidayAdapter = new HolidayPlanAdapter(mContext, plansItem, this);
        FragmentPlanChangeBinding fragmentPlanChangeBinding3 = this.binding;
        if (fragmentPlanChangeBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentPlanChangeBinding2 = fragmentPlanChangeBinding3;
        }
        fragmentPlanChangeBinding2.listHolidayPlanId.setAdapter(this.holidayAdapter);
        HolidayPlanAdapter holidayPlanAdapter = this.holidayAdapter;
        if (holidayPlanAdapter != null) {
            holidayPlanAdapter.setOnItemClickListener(this);
        }
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        showPlanDetails();
        ((MaterialButton) _$_findCachedViewById(R.id.btnRenewPlanId)).setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.subscription.payment.view.SelectPlanChangeFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SelectPlanChangeFragment.m1363onViewCreated$lambda3(SelectPlanChangeFragment.this, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-3  reason: not valid java name */
    public static final void m1363onViewCreated$lambda3(SelectPlanChangeFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ExpandablePlanAdapter expandablePlanAdapter = this$0.expandableAdapter;
        if (expandablePlanAdapter != null) {
            expandablePlanAdapter.setRowIndex(-1);
        }
        ExpandablePlanAdapter expandablePlanAdapter2 = this$0.expandableAdapter;
        if (expandablePlanAdapter2 != null) {
            expandablePlanAdapter2.notifyDataSetChanged();
        }
        HolidayPlanAdapter holidayPlanAdapter = this$0.holidayAdapter;
        if (holidayPlanAdapter != null) {
            holidayPlanAdapter.setRowIndex(-1);
        }
        HolidayPlanAdapter holidayPlanAdapter2 = this$0.holidayAdapter;
        if (holidayPlanAdapter2 != null) {
            holidayPlanAdapter2.notifyDataSetChanged();
        }
        UnlimitedPlanAdapter unlimitedPlanAdapter = this$0.unlimitedPlanAdapter;
        if (unlimitedPlanAdapter != null) {
            unlimitedPlanAdapter.setRowIndex(-1);
        }
        UnlimitedPlanAdapter unlimitedPlanAdapter2 = this$0.unlimitedPlanAdapter;
        if (unlimitedPlanAdapter2 != null) {
            unlimitedPlanAdapter2.notifyDataSetChanged();
        }
        if (this$0.currentPlans != null) {
            List<PriceItem> list = this$0.planDurationList;
            if (list == null) {
                Intrinsics.throwUninitializedPropertyAccessException("planDurationList");
                list = null;
            }
            this$0.showCurrentPlanDialog(list, this$0.currentPlans);
            return;
        }
        String string = this$0.getString(R.string.data_load);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.data_load)");
        this$0.showToast(string);
    }

    private final void updateSelectedPlan() {
        PriceItem priceItem = this.priceItem;
        if (priceItem == null) {
            String string = getString(R.string.try_again);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.try_again)");
            showToast(string);
            return;
        }
        Intrinsics.checkNotNull(priceItem);
        Currentplans currentplans = this.currentPlans;
        Intrinsics.checkNotNull(currentplans);
        String planId = currentplans.getPlanId();
        Intrinsics.checkNotNull(planId);
        Currentplans currentplans2 = this.currentPlans;
        Intrinsics.checkNotNull(currentplans2);
        String planName = currentplans2.getPlanName();
        Intrinsics.checkNotNull(planName);
        proceedToReviewOrder(priceItem, planId, planName);
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        ((MainActivity) requireActivity()).setupDefaultUpButtonNavigation();
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.DataBindingFragment
    public void bindVariablesToView(FragmentPlanChangeBinding dataBinding) {
        Intrinsics.checkNotNullParameter(dataBinding, "dataBinding");
        this.binding = dataBinding;
        this.bindingPlan = dataBinding;
        dataBinding.setViewModel(getSelectPlanChangeModel());
    }

    private final void proceedToReviewOrder(PriceItem priceItem, String str, String str2) {
        DeviceList deviceList = getSelectPlanChangeModel().get_device();
        Intrinsics.checkNotNull(deviceList);
        SelectPlanChangeFragmentDirections.ActionSelectPlanOrRechargeFragmentToReviewOrderFragment actionSelectPlanOrRechargeFragmentToReviewOrderFragment = SelectPlanChangeFragmentDirections.actionSelectPlanOrRechargeFragmentToReviewOrderFragment(priceItem, deviceList, str2, str);
        Intrinsics.checkNotNullExpressionValue(actionSelectPlanOrRechargeFragmentToReviewOrderFragment, "actionSelectPlanOrRechar… planNumber\n            )");
        FragmentKt.findNavController(this).navigate(actionSelectPlanOrRechargeFragmentToReviewOrderFragment);
    }

    @Override // com.livpure.safedrink.interfaces.ItemClickListener
    public void onItemClick(View view, int i) {
        List<PriceItem> list = this.planDurationList;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("planDurationList");
            list = null;
        }
        this.priceItem = (PriceItem) CollectionsKt.sortedWith(list, new Comparator() { // from class: com.livpure.safedrink.subscription.payment.view.SelectPlanChangeFragment$onItemClick$$inlined$sortedByDescending$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                String duration = ((PriceItem) t2).getDuration();
                Integer valueOf = duration != null ? Integer.valueOf(Integer.parseInt(duration)) : null;
                String duration2 = ((PriceItem) t).getDuration();
                return ComparisonsKt.compareValues(valueOf, duration2 != null ? Integer.valueOf(Integer.parseInt(duration2)) : null);
            }
        }).get(i);
    }

    @Override // com.livpure.safedrink.interfaces.MultiItemClickListener
    public void onChildItemClick(View view, int i, int i2, boolean z, boolean z2) {
        List<PlansItem> list = null;
        PlansItem plansItem = null;
        List<PlansItem> list2 = null;
        if (z) {
            PlansItem plansItem2 = this.holidayPlanList;
            if (plansItem2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("holidayPlanList");
            } else {
                plansItem = plansItem2;
            }
            showPlanDialog(plansItem, i, z, z2);
        } else if (z2) {
            List<PlansItem> list3 = this.unlimitedPlanList;
            if (list3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("unlimitedPlanList");
            } else {
                list2 = list3;
            }
            showPlanDialog(list2.get(i), i, z, z2);
        } else {
            List<PlansItem> list4 = this.changePlanList;
            if (list4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("changePlanList");
            } else {
                list = list4;
            }
            showPlanDialog(list.get(i), i, z, z2);
        }
    }

    @Override // com.livpure.safedrink.interfaces.MultiItemClickListener
    public void selectedPlanClickEvent(View view, int i, int i2, boolean z, boolean z2) {
        this.childPositionMaster = i2;
    }

    private final void showPlanDialog(PlansItem plansItem, final int i, final boolean z, final boolean z2) {
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(requireContext());
        View inflate = getLayoutInflater().inflate(R.layout.layout_model_bottom_sheet, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "layoutInflater.inflate(R…model_bottom_sheet, null)");
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.listPlanValidityBottom);
        View findViewById = inflate.findViewById(R.id.cancel_btn);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.cancel_btn)");
        View findViewById2 = inflate.findViewById(R.id.txtPayment);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.txtPayment)");
        ((TextView) findViewById).setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.subscription.payment.view.SelectPlanChangeFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SelectPlanChangeFragment.m1367showPlanDialog$lambda5(BottomSheetDialog.this, view);
            }
        });
        ((TextView) findViewById2).setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.subscription.payment.view.SelectPlanChangeFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SelectPlanChangeFragment.m1368showPlanDialog$lambda9(z, this, z2, i, bottomSheetDialog, view);
            }
        });
        if (recyclerView != null) {
            try {
                recyclerView.setLayoutManager(new LinearLayoutManager(getMContext(), 1, false));
            } catch (Exception e) {
                Log.e("Recycler Exception", e.toString());
            }
        }
        FragmentActivity mContext = getMContext();
        Intrinsics.checkNotNullExpressionValue(mContext, "mContext");
        FragmentActivity fragmentActivity = mContext;
        List<PriceItem> price = plansItem.getPrice();
        Intrinsics.checkNotNull(price);
        PlanValidityAdapter planValidityAdapter = new PlanValidityAdapter(fragmentActivity, CollectionsKt.sortedWith(price, new Comparator() { // from class: com.livpure.safedrink.subscription.payment.view.SelectPlanChangeFragment$showPlanDialog$$inlined$sortedByDescending$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                String duration;
                String duration2;
                PriceItem priceItem = (PriceItem) t2;
                Integer num = null;
                Integer valueOf = (priceItem == null || (duration2 = priceItem.getDuration()) == null) ? null : Integer.valueOf(Integer.parseInt(duration2));
                PriceItem priceItem2 = (PriceItem) t;
                if (priceItem2 != null && (duration = priceItem2.getDuration()) != null) {
                    num = Integer.valueOf(Integer.parseInt(duration));
                }
                return ComparisonsKt.compareValues(valueOf, num);
            }
        }), i, z, Integer.parseInt(String.valueOf(plansItem.getAmount())));
        if (recyclerView != null) {
            recyclerView.setAdapter(planValidityAdapter);
        }
        planValidityAdapter.setOnItemClickListener(this);
        bottomSheetDialog.setContentView(inflate);
        bottomSheetDialog.setCancelable(false);
        bottomSheetDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showPlanDialog$lambda-5  reason: not valid java name */
    public static final void m1367showPlanDialog$lambda5(BottomSheetDialog dialogLog, View view) {
        Intrinsics.checkNotNullParameter(dialogLog, "$dialogLog");
        dialogLog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showPlanDialog$lambda-9  reason: not valid java name */
    public static final void m1368showPlanDialog$lambda9(boolean z, SelectPlanChangeFragment this$0, boolean z2, int i, BottomSheetDialog dialogLog, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dialogLog, "$dialogLog");
        List<PlansItem> list = null;
        PlansItem plansItem = null;
        List<PlansItem> list2 = null;
        if (z) {
            PlansItem plansItem2 = this$0.holidayPlanList;
            if (plansItem2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("holidayPlanList");
            } else {
                plansItem = plansItem2;
            }
            List<PriceItem> price = plansItem.getPrice();
            Intrinsics.checkNotNull(price);
            PriceItem priceItem = (PriceItem) CollectionsKt.sortedWith(price, new Comparator() { // from class: com.livpure.safedrink.subscription.payment.view.SelectPlanChangeFragment$showPlanDialog$lambda-9$$inlined$sortedByDescending$1
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    String duration;
                    String duration2;
                    PriceItem priceItem2 = (PriceItem) t2;
                    Integer num = null;
                    Integer valueOf = (priceItem2 == null || (duration2 = priceItem2.getDuration()) == null) ? null : Integer.valueOf(Integer.parseInt(duration2));
                    PriceItem priceItem3 = (PriceItem) t;
                    if (priceItem3 != null && (duration = priceItem3.getDuration()) != null) {
                        num = Integer.valueOf(Integer.parseInt(duration));
                    }
                    return ComparisonsKt.compareValues(valueOf, num);
                }
            }).get(this$0.childPositionMaster);
            if (priceItem != null) {
                String planId = plansItem.getPlanId();
                Intrinsics.checkNotNull(planId);
                this$0.proceedToReviewOrder(priceItem, planId, "Holiday");
            }
        } else if (z2) {
            List<PlansItem> list3 = this$0.unlimitedPlanList;
            if (list3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("unlimitedPlanList");
            } else {
                list2 = list3;
            }
            PlansItem plansItem3 = list2.get(i);
            List<PriceItem> price2 = plansItem3.getPrice();
            Intrinsics.checkNotNull(price2);
            PriceItem priceItem2 = (PriceItem) CollectionsKt.sortedWith(price2, new Comparator() { // from class: com.livpure.safedrink.subscription.payment.view.SelectPlanChangeFragment$showPlanDialog$lambda-9$$inlined$sortedByDescending$2
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    String duration;
                    String duration2;
                    PriceItem priceItem3 = (PriceItem) t2;
                    Integer num = null;
                    Integer valueOf = (priceItem3 == null || (duration2 = priceItem3.getDuration()) == null) ? null : Integer.valueOf(Integer.parseInt(duration2));
                    PriceItem priceItem4 = (PriceItem) t;
                    if (priceItem4 != null && (duration = priceItem4.getDuration()) != null) {
                        num = Integer.valueOf(Integer.parseInt(duration));
                    }
                    return ComparisonsKt.compareValues(valueOf, num);
                }
            }).get(this$0.childPositionMaster);
            if (priceItem2 != null) {
                String planId2 = plansItem3.getPlanId();
                Intrinsics.checkNotNull(planId2);
                this$0.proceedToReviewOrder(priceItem2, planId2, "Unlimited");
            }
        } else {
            List<PlansItem> list4 = this$0.changePlanList;
            if (list4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("changePlanList");
            } else {
                list = list4;
            }
            PlansItem plansItem4 = list.get(i);
            String planName = plansItem4.getPlanName();
            Intrinsics.checkNotNull(planName);
            List<PriceItem> price3 = plansItem4.getPrice();
            Intrinsics.checkNotNull(price3);
            PriceItem priceItem3 = (PriceItem) CollectionsKt.sortedWith(price3, new Comparator() { // from class: com.livpure.safedrink.subscription.payment.view.SelectPlanChangeFragment$showPlanDialog$lambda-9$$inlined$sortedByDescending$3
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    String duration;
                    String duration2;
                    PriceItem priceItem4 = (PriceItem) t2;
                    Integer num = null;
                    Integer valueOf = (priceItem4 == null || (duration2 = priceItem4.getDuration()) == null) ? null : Integer.valueOf(Integer.parseInt(duration2));
                    PriceItem priceItem5 = (PriceItem) t;
                    if (priceItem5 != null && (duration = priceItem5.getDuration()) != null) {
                        num = Integer.valueOf(Integer.parseInt(duration));
                    }
                    return ComparisonsKt.compareValues(valueOf, num);
                }
            }).get(this$0.childPositionMaster);
            if (priceItem3 != null) {
                String planId3 = plansItem4.getPlanId();
                Intrinsics.checkNotNull(planId3);
                this$0.proceedToReviewOrder(priceItem3, planId3, planName);
            }
        }
        dialogLog.dismiss();
    }

    private final void showCurrentPlanDialog(List<PriceItem> list, Currentplans currentplans) {
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(requireContext());
        View inflate = getLayoutInflater().inflate(R.layout.layout_model_bottom_sheet, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "layoutInflater.inflate(R…model_bottom_sheet, null)");
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.listPlanValidityBottom);
        View findViewById = inflate.findViewById(R.id.cancel_btn);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.cancel_btn)");
        View findViewById2 = inflate.findViewById(R.id.txtPayment);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.txtPayment)");
        ((TextView) findViewById).setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.subscription.payment.view.SelectPlanChangeFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SelectPlanChangeFragment.m1364showCurrentPlanDialog$lambda11(BottomSheetDialog.this, view);
            }
        });
        ((TextView) findViewById2).setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.subscription.payment.view.SelectPlanChangeFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SelectPlanChangeFragment.m1365showCurrentPlanDialog$lambda12(SelectPlanChangeFragment.this, bottomSheetDialog, view);
            }
        });
        try {
            this.isSelectedPlanId = 1;
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getMContext(), 1, false);
            if (recyclerView != null) {
                recyclerView.setLayoutManager(linearLayoutManager);
            }
            FragmentActivity mContext = getMContext();
            Intrinsics.checkNotNullExpressionValue(mContext, "mContext");
            PlansDurationsAdapter plansDurationsAdapter = new PlansDurationsAdapter(mContext, CollectionsKt.sortedWith(list, new Comparator() { // from class: com.livpure.safedrink.subscription.payment.view.SelectPlanChangeFragment$showCurrentPlanDialog$$inlined$sortedByDescending$1
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    String duration = ((PriceItem) t2).getDuration();
                    Integer valueOf = duration != null ? Integer.valueOf(Integer.parseInt(duration)) : null;
                    String duration2 = ((PriceItem) t).getDuration();
                    return ComparisonsKt.compareValues(valueOf, duration2 != null ? Integer.valueOf(Integer.parseInt(duration2)) : null);
                }
            }), Integer.parseInt(String.valueOf(currentplans != null ? currentplans.getAmount() : null)));
            if (recyclerView != null) {
                recyclerView.setAdapter(plansDurationsAdapter);
            }
            plansDurationsAdapter.setOnItemClickListener(this);
            if (this.priceItem == null) {
                this.priceItem = (PriceItem) CollectionsKt.sortedWith(list, new Comparator() { // from class: com.livpure.safedrink.subscription.payment.view.SelectPlanChangeFragment$showCurrentPlanDialog$$inlined$sortedByDescending$2
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        String duration = ((PriceItem) t2).getDuration();
                        Integer valueOf = duration != null ? Integer.valueOf(Integer.parseInt(duration)) : null;
                        String duration2 = ((PriceItem) t).getDuration();
                        return ComparisonsKt.compareValues(valueOf, duration2 != null ? Integer.valueOf(Integer.parseInt(duration2)) : null);
                    }
                }).get(0);
            }
        } catch (Exception e) {
            Log.e("Recycler Exception", e.toString());
        }
        bottomSheetDialog.setContentView(inflate);
        bottomSheetDialog.setCancelable(false);
        bottomSheetDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showCurrentPlanDialog$lambda-11  reason: not valid java name */
    public static final void m1364showCurrentPlanDialog$lambda11(BottomSheetDialog dialogLog, View view) {
        Intrinsics.checkNotNullParameter(dialogLog, "$dialogLog");
        dialogLog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showCurrentPlanDialog$lambda-12  reason: not valid java name */
    public static final void m1365showCurrentPlanDialog$lambda12(SelectPlanChangeFragment this$0, BottomSheetDialog dialogLog, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dialogLog, "$dialogLog");
        this$0.updateSelectedPlan();
        dialogLog.dismiss();
    }

    @Override // com.livpure.safedrink.interfaces.RefreshPlanListListener
    public void onClick(boolean z, boolean z2, boolean z3) {
        this.childPositionMaster = 0;
        if (z) {
            ExpandablePlanAdapter expandablePlanAdapter = this.expandableAdapter;
            if (expandablePlanAdapter != null) {
                expandablePlanAdapter.setRowIndex(-1);
            }
            UnlimitedPlanAdapter unlimitedPlanAdapter = this.unlimitedPlanAdapter;
            if (unlimitedPlanAdapter != null) {
                unlimitedPlanAdapter.setRowIndex(-1);
            }
            ExpandablePlanAdapter expandablePlanAdapter2 = this.expandableAdapter;
            if (expandablePlanAdapter2 != null) {
                expandablePlanAdapter2.notifyDataSetChanged();
            }
            UnlimitedPlanAdapter unlimitedPlanAdapter2 = this.unlimitedPlanAdapter;
            if (unlimitedPlanAdapter2 != null) {
                unlimitedPlanAdapter2.notifyDataSetChanged();
            }
        } else if (z2) {
            ExpandablePlanAdapter expandablePlanAdapter3 = this.expandableAdapter;
            if (expandablePlanAdapter3 != null) {
                expandablePlanAdapter3.setRowIndex(-1);
            }
            HolidayPlanAdapter holidayPlanAdapter = this.holidayAdapter;
            if (holidayPlanAdapter != null) {
                holidayPlanAdapter.setRowIndex(-1);
            }
            ExpandablePlanAdapter expandablePlanAdapter4 = this.expandableAdapter;
            if (expandablePlanAdapter4 != null) {
                expandablePlanAdapter4.notifyDataSetChanged();
            }
            HolidayPlanAdapter holidayPlanAdapter2 = this.holidayAdapter;
            if (holidayPlanAdapter2 != null) {
                holidayPlanAdapter2.notifyDataSetChanged();
            }
        } else {
            HolidayPlanAdapter holidayPlanAdapter3 = this.holidayAdapter;
            if (holidayPlanAdapter3 != null) {
                holidayPlanAdapter3.setRowIndex(-1);
            }
            UnlimitedPlanAdapter unlimitedPlanAdapter3 = this.unlimitedPlanAdapter;
            if (unlimitedPlanAdapter3 != null) {
                unlimitedPlanAdapter3.setRowIndex(-1);
            }
            HolidayPlanAdapter holidayPlanAdapter4 = this.holidayAdapter;
            if (holidayPlanAdapter4 != null) {
                holidayPlanAdapter4.notifyDataSetChanged();
            }
            UnlimitedPlanAdapter unlimitedPlanAdapter4 = this.unlimitedPlanAdapter;
            if (unlimitedPlanAdapter4 != null) {
                unlimitedPlanAdapter4.notifyDataSetChanged();
            }
        }
    }
}
