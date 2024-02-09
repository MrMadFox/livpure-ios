package com.livpure.safedrink.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.livpure.safedrink.R;
import com.livpure.safedrink.subscription.payment.adapter.PlanDurationAdapter;
import com.livpure.safedrink.subscription.payment.viewmodel.PlanDurationModel;
import com.livpure.safedrink.subscription.plan.data.model.plan.PriceItem;
/* loaded from: classes3.dex */
public abstract class AdapterPlanDurationLayoutBinding extends ViewDataBinding {
    public final LinearLayout lytValidityId;
    @Bindable
    protected PlanDurationAdapter mCallBack;
    @Bindable
    protected PriceItem mDuration;
    @Bindable
    protected Integer mPosition;
    @Bindable
    protected PlanDurationModel mViewModel;
    public final RadioButton radioPlanId;

    public abstract void setCallBack(PlanDurationAdapter callBack);

    public abstract void setDuration(PriceItem duration);

    public abstract void setPosition(Integer position);

    public abstract void setViewModel(PlanDurationModel viewModel);

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterPlanDurationLayoutBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout lytValidityId, RadioButton radioPlanId) {
        super(_bindingComponent, _root, _localFieldCount);
        this.lytValidityId = lytValidityId;
        this.radioPlanId = radioPlanId;
    }

    public Integer getPosition() {
        return this.mPosition;
    }

    public PlanDurationAdapter getCallBack() {
        return this.mCallBack;
    }

    public PriceItem getDuration() {
        return this.mDuration;
    }

    public PlanDurationModel getViewModel() {
        return this.mViewModel;
    }

    public static AdapterPlanDurationLayoutBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterPlanDurationLayoutBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (AdapterPlanDurationLayoutBinding) ViewDataBinding.inflateInternal(inflater, R.layout.adapter_plan_duration_layout, root, attachToRoot, component);
    }

    public static AdapterPlanDurationLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterPlanDurationLayoutBinding inflate(LayoutInflater inflater, Object component) {
        return (AdapterPlanDurationLayoutBinding) ViewDataBinding.inflateInternal(inflater, R.layout.adapter_plan_duration_layout, null, false, component);
    }

    public static AdapterPlanDurationLayoutBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterPlanDurationLayoutBinding bind(View view, Object component) {
        return (AdapterPlanDurationLayoutBinding) bind(component, view, R.layout.adapter_plan_duration_layout);
    }
}
