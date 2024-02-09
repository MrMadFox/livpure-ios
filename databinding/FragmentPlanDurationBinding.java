package com.livpure.safedrink.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.livpure.safedrink.R;
import com.livpure.safedrink.subscription.payment.viewmodel.PlanDurationModel;
/* loaded from: classes3.dex */
public abstract class FragmentPlanDurationBinding extends ViewDataBinding {
    public final LinearLayout btnRenewPlanId;
    public final RecyclerView listPlanDurationId;
    public final LinearLayout lytParentViewId;
    @Bindable
    protected Integer mPosition;
    @Bindable
    protected PlanDurationModel mViewModel;
    public final TextView tvBilledStatus;

    public abstract void setPosition(Integer position);

    public abstract void setViewModel(PlanDurationModel viewModel);

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentPlanDurationBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout btnRenewPlanId, RecyclerView listPlanDurationId, LinearLayout lytParentViewId, TextView tvBilledStatus) {
        super(_bindingComponent, _root, _localFieldCount);
        this.btnRenewPlanId = btnRenewPlanId;
        this.listPlanDurationId = listPlanDurationId;
        this.lytParentViewId = lytParentViewId;
        this.tvBilledStatus = tvBilledStatus;
    }

    public Integer getPosition() {
        return this.mPosition;
    }

    public PlanDurationModel getViewModel() {
        return this.mViewModel;
    }

    public static FragmentPlanDurationBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentPlanDurationBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentPlanDurationBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_plan_duration, root, attachToRoot, component);
    }

    public static FragmentPlanDurationBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentPlanDurationBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentPlanDurationBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_plan_duration, null, false, component);
    }

    public static FragmentPlanDurationBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentPlanDurationBinding bind(View view, Object component) {
        return (FragmentPlanDurationBinding) bind(component, view, R.layout.fragment_plan_duration);
    }
}
