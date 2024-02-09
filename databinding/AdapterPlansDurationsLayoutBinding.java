package com.livpure.safedrink.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.livpure.safedrink.R;
import com.livpure.safedrink.subscription.payment.adapter.PlansDurationsAdapter;
import com.livpure.safedrink.subscription.payment.viewmodel.PlanDurationModel;
import com.livpure.safedrink.subscription.plan.data.model.plan.PriceItem;
/* loaded from: classes3.dex */
public abstract class AdapterPlansDurationsLayoutBinding extends ViewDataBinding {
    public final LinearLayout layoutMonth;
    public final LinearLayout lytSimpleItem;
    public final RelativeLayout lytValidityId;
    @Bindable
    protected PlansDurationsAdapter mCallBack;
    @Bindable
    protected PriceItem mDuration;
    @Bindable
    protected Integer mPosition;
    @Bindable
    protected PlanDurationModel mViewModel;
    public final ImageView radioPlanId;
    public final AppCompatTextView textAmountRs;
    public final AppCompatTextView textDiscount;
    public final AppCompatTextView textMonth;
    public final TextView textPopular;
    public final AppCompatTextView textRsPlan;
    public final AppCompatTextView textSaveAmount;
    public final AppCompatTextView textTotalAmount;
    public final AppCompatTextView textTotalMonth;
    public final AppCompatTextView textValidity;
    public final View viewDivide;
    public final View viewPlan;

    public abstract void setCallBack(PlansDurationsAdapter callBack);

    public abstract void setDuration(PriceItem duration);

    public abstract void setPosition(Integer position);

    public abstract void setViewModel(PlanDurationModel viewModel);

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterPlansDurationsLayoutBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout layoutMonth, LinearLayout lytSimpleItem, RelativeLayout lytValidityId, ImageView radioPlanId, AppCompatTextView textAmountRs, AppCompatTextView textDiscount, AppCompatTextView textMonth, TextView textPopular, AppCompatTextView textRsPlan, AppCompatTextView textSaveAmount, AppCompatTextView textTotalAmount, AppCompatTextView textTotalMonth, AppCompatTextView textValidity, View viewDivide, View viewPlan) {
        super(_bindingComponent, _root, _localFieldCount);
        this.layoutMonth = layoutMonth;
        this.lytSimpleItem = lytSimpleItem;
        this.lytValidityId = lytValidityId;
        this.radioPlanId = radioPlanId;
        this.textAmountRs = textAmountRs;
        this.textDiscount = textDiscount;
        this.textMonth = textMonth;
        this.textPopular = textPopular;
        this.textRsPlan = textRsPlan;
        this.textSaveAmount = textSaveAmount;
        this.textTotalAmount = textTotalAmount;
        this.textTotalMonth = textTotalMonth;
        this.textValidity = textValidity;
        this.viewDivide = viewDivide;
        this.viewPlan = viewPlan;
    }

    public Integer getPosition() {
        return this.mPosition;
    }

    public PlansDurationsAdapter getCallBack() {
        return this.mCallBack;
    }

    public PriceItem getDuration() {
        return this.mDuration;
    }

    public PlanDurationModel getViewModel() {
        return this.mViewModel;
    }

    public static AdapterPlansDurationsLayoutBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterPlansDurationsLayoutBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (AdapterPlansDurationsLayoutBinding) ViewDataBinding.inflateInternal(inflater, R.layout.adapter_plans_durations_layout, root, attachToRoot, component);
    }

    public static AdapterPlansDurationsLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterPlansDurationsLayoutBinding inflate(LayoutInflater inflater, Object component) {
        return (AdapterPlansDurationsLayoutBinding) ViewDataBinding.inflateInternal(inflater, R.layout.adapter_plans_durations_layout, null, false, component);
    }

    public static AdapterPlansDurationsLayoutBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterPlansDurationsLayoutBinding bind(View view, Object component) {
        return (AdapterPlansDurationsLayoutBinding) bind(component, view, R.layout.adapter_plans_durations_layout);
    }
}
