package com.livpure.safedrink.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import com.livpure.safedrink.R;
import com.livpure.safedrink.subscription.payment.adapter.UnlimitedPlanAdapter;
import com.livpure.safedrink.subscription.plan.data.model.plan.PlansItem;
/* loaded from: classes3.dex */
public abstract class AdapterUnlimitedPlanLayoutBinding extends ViewDataBinding {
    public final TextView additionalUsage;
    public final MaterialButton btnRenewPlanId;
    public final RecyclerView listPlanValidityId;
    public final LinearLayout lytItemExpandable;
    public final LinearLayout lytSimpleItem;
    public final LinearLayout lytValidityId;
    @Bindable
    protected UnlimitedPlanAdapter mCallBack;
    @Bindable
    protected PlansItem mPlan;
    @Bindable
    protected Integer mPosition;
    public final ImageView radioPlanId;

    public abstract void setCallBack(UnlimitedPlanAdapter callBack);

    public abstract void setPlan(PlansItem plan);

    public abstract void setPosition(Integer position);

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterUnlimitedPlanLayoutBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView additionalUsage, MaterialButton btnRenewPlanId, RecyclerView listPlanValidityId, LinearLayout lytItemExpandable, LinearLayout lytSimpleItem, LinearLayout lytValidityId, ImageView radioPlanId) {
        super(_bindingComponent, _root, _localFieldCount);
        this.additionalUsage = additionalUsage;
        this.btnRenewPlanId = btnRenewPlanId;
        this.listPlanValidityId = listPlanValidityId;
        this.lytItemExpandable = lytItemExpandable;
        this.lytSimpleItem = lytSimpleItem;
        this.lytValidityId = lytValidityId;
        this.radioPlanId = radioPlanId;
    }

    public Integer getPosition() {
        return this.mPosition;
    }

    public PlansItem getPlan() {
        return this.mPlan;
    }

    public UnlimitedPlanAdapter getCallBack() {
        return this.mCallBack;
    }

    public static AdapterUnlimitedPlanLayoutBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterUnlimitedPlanLayoutBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (AdapterUnlimitedPlanLayoutBinding) ViewDataBinding.inflateInternal(inflater, R.layout.adapter_unlimited_plan_layout, root, attachToRoot, component);
    }

    public static AdapterUnlimitedPlanLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterUnlimitedPlanLayoutBinding inflate(LayoutInflater inflater, Object component) {
        return (AdapterUnlimitedPlanLayoutBinding) ViewDataBinding.inflateInternal(inflater, R.layout.adapter_unlimited_plan_layout, null, false, component);
    }

    public static AdapterUnlimitedPlanLayoutBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterUnlimitedPlanLayoutBinding bind(View view, Object component) {
        return (AdapterUnlimitedPlanLayoutBinding) bind(component, view, R.layout.adapter_unlimited_plan_layout);
    }
}
