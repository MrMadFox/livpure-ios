package com.livpure.safedrink.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import com.livpure.safedrink.R;
import com.livpure.safedrink.subscription.payment.viewmodel.SelectPlanChangeModel;
import com.livpure.safedrink.subscription.plan.data.model.payment.PlanItem;
/* loaded from: classes3.dex */
public abstract class FragmentPlanChangeBinding extends ViewDataBinding {
    public final TextView additionalUsage;
    public final MaterialButton btnRenewPlanId;
    public final TextView capacity;
    public final RecyclerView listChangePlanId;
    public final RecyclerView listHolidayPlanId;
    public final RecyclerView listPlanValidityId;
    public final RecyclerView listUnlimitedPlanId;
    public final CardView lytActivityPlanId;
    public final LinearLayout lytChangePlan;
    public final LinearLayout lytHolidayPlan;
    public final CardView lytHolidayPlanId;
    public final LinearLayout lytParentViewId;
    public final LinearLayout lytPopular;
    public final LinearLayout lytUnlimitedLabel;
    public final RelativeLayout lytUnlimitedPlan;
    @Bindable
    protected PlanItem mPlan;
    @Bindable
    protected Integer mPosition;
    @Bindable
    protected SelectPlanChangeModel mViewModel;
    public final ImageView planIcon;
    public final LinearLayout planInfo;
    public final TextView txtCapacity;
    public final TextView txtPlan;

    public abstract void setPlan(PlanItem plan);

    public abstract void setPosition(Integer position);

    public abstract void setViewModel(SelectPlanChangeModel viewModel);

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentPlanChangeBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView additionalUsage, MaterialButton btnRenewPlanId, TextView capacity, RecyclerView listChangePlanId, RecyclerView listHolidayPlanId, RecyclerView listPlanValidityId, RecyclerView listUnlimitedPlanId, CardView lytActivityPlanId, LinearLayout lytChangePlan, LinearLayout lytHolidayPlan, CardView lytHolidayPlanId, LinearLayout lytParentViewId, LinearLayout lytPopular, LinearLayout lytUnlimitedLabel, RelativeLayout lytUnlimitedPlan, ImageView planIcon, LinearLayout planInfo, TextView txtCapacity, TextView txtPlan) {
        super(_bindingComponent, _root, _localFieldCount);
        this.additionalUsage = additionalUsage;
        this.btnRenewPlanId = btnRenewPlanId;
        this.capacity = capacity;
        this.listChangePlanId = listChangePlanId;
        this.listHolidayPlanId = listHolidayPlanId;
        this.listPlanValidityId = listPlanValidityId;
        this.listUnlimitedPlanId = listUnlimitedPlanId;
        this.lytActivityPlanId = lytActivityPlanId;
        this.lytChangePlan = lytChangePlan;
        this.lytHolidayPlan = lytHolidayPlan;
        this.lytHolidayPlanId = lytHolidayPlanId;
        this.lytParentViewId = lytParentViewId;
        this.lytPopular = lytPopular;
        this.lytUnlimitedLabel = lytUnlimitedLabel;
        this.lytUnlimitedPlan = lytUnlimitedPlan;
        this.planIcon = planIcon;
        this.planInfo = planInfo;
        this.txtCapacity = txtCapacity;
        this.txtPlan = txtPlan;
    }

    public Integer getPosition() {
        return this.mPosition;
    }

    public PlanItem getPlan() {
        return this.mPlan;
    }

    public SelectPlanChangeModel getViewModel() {
        return this.mViewModel;
    }

    public static FragmentPlanChangeBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentPlanChangeBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentPlanChangeBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_plan_change, root, attachToRoot, component);
    }

    public static FragmentPlanChangeBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentPlanChangeBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentPlanChangeBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_plan_change, null, false, component);
    }

    public static FragmentPlanChangeBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentPlanChangeBinding bind(View view, Object component) {
        return (FragmentPlanChangeBinding) bind(component, view, R.layout.fragment_plan_change);
    }
}
