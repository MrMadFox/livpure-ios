package com.livpure.safedrink.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.livpure.safedrink.R;
import com.livpure.safedrink.subscription.payment.adapter.PlanDurationsAdapter;
import com.livpure.safedrink.subscription.plan.data.model.plan.PriceItem;
/* loaded from: classes3.dex */
public abstract class AdapterPlanDurationsLayoutBinding extends ViewDataBinding {
    public final ImageView imgPlanId;
    public final LinearLayout lytValidityId;
    @Bindable
    protected PlanDurationsAdapter mCallBack;
    @Bindable
    protected PriceItem mDuration;
    @Bindable
    protected Integer mPosition;
    public final TextView txtBestValueId;
    public final AppCompatTextView txtPlanAmountId;
    public final AppCompatTextView txtPlanDurationId;
    public final AppCompatTextView txtPlanMonthId;
    public final AppCompatTextView txtSaving;

    public abstract void setCallBack(PlanDurationsAdapter callBack);

    public abstract void setDuration(PriceItem duration);

    public abstract void setPosition(Integer position);

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterPlanDurationsLayoutBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageView imgPlanId, LinearLayout lytValidityId, TextView txtBestValueId, AppCompatTextView txtPlanAmountId, AppCompatTextView txtPlanDurationId, AppCompatTextView txtPlanMonthId, AppCompatTextView txtSaving) {
        super(_bindingComponent, _root, _localFieldCount);
        this.imgPlanId = imgPlanId;
        this.lytValidityId = lytValidityId;
        this.txtBestValueId = txtBestValueId;
        this.txtPlanAmountId = txtPlanAmountId;
        this.txtPlanDurationId = txtPlanDurationId;
        this.txtPlanMonthId = txtPlanMonthId;
        this.txtSaving = txtSaving;
    }

    public Integer getPosition() {
        return this.mPosition;
    }

    public PlanDurationsAdapter getCallBack() {
        return this.mCallBack;
    }

    public PriceItem getDuration() {
        return this.mDuration;
    }

    public static AdapterPlanDurationsLayoutBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterPlanDurationsLayoutBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (AdapterPlanDurationsLayoutBinding) ViewDataBinding.inflateInternal(inflater, R.layout.adapter_plan_durations_layout, root, attachToRoot, component);
    }

    public static AdapterPlanDurationsLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterPlanDurationsLayoutBinding inflate(LayoutInflater inflater, Object component) {
        return (AdapterPlanDurationsLayoutBinding) ViewDataBinding.inflateInternal(inflater, R.layout.adapter_plan_durations_layout, null, false, component);
    }

    public static AdapterPlanDurationsLayoutBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterPlanDurationsLayoutBinding bind(View view, Object component) {
        return (AdapterPlanDurationsLayoutBinding) bind(component, view, R.layout.adapter_plan_durations_layout);
    }
}
