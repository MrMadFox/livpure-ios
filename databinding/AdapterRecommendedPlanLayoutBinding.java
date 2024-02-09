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
import com.livpure.safedrink.subscription.payment.adapter.RecommendedPlanAdapter;
import com.livpure.safedrink.subscription.plan.data.model.payment.PlanItem;
/* loaded from: classes3.dex */
public abstract class AdapterRecommendedPlanLayoutBinding extends ViewDataBinding {
    public final LinearLayout lytValidityId;
    @Bindable
    protected RecommendedPlanAdapter mCallBack;
    @Bindable
    protected PlanItem mPlan;
    @Bindable
    protected Integer mPosition;
    public final RadioButton radioPlanId;

    public abstract void setCallBack(RecommendedPlanAdapter callBack);

    public abstract void setPlan(PlanItem plan);

    public abstract void setPosition(Integer position);

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterRecommendedPlanLayoutBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout lytValidityId, RadioButton radioPlanId) {
        super(_bindingComponent, _root, _localFieldCount);
        this.lytValidityId = lytValidityId;
        this.radioPlanId = radioPlanId;
    }

    public Integer getPosition() {
        return this.mPosition;
    }

    public PlanItem getPlan() {
        return this.mPlan;
    }

    public RecommendedPlanAdapter getCallBack() {
        return this.mCallBack;
    }

    public static AdapterRecommendedPlanLayoutBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterRecommendedPlanLayoutBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (AdapterRecommendedPlanLayoutBinding) ViewDataBinding.inflateInternal(inflater, R.layout.adapter_recommended_plan_layout, root, attachToRoot, component);
    }

    public static AdapterRecommendedPlanLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterRecommendedPlanLayoutBinding inflate(LayoutInflater inflater, Object component) {
        return (AdapterRecommendedPlanLayoutBinding) ViewDataBinding.inflateInternal(inflater, R.layout.adapter_recommended_plan_layout, null, false, component);
    }

    public static AdapterRecommendedPlanLayoutBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterRecommendedPlanLayoutBinding bind(View view, Object component) {
        return (AdapterRecommendedPlanLayoutBinding) bind(component, view, R.layout.adapter_recommended_plan_layout);
    }
}
