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
import com.livpure.safedrink.subscription.payment.adapter.HolidayPlanAdapter;
import com.livpure.safedrink.subscription.plan.data.model.plan.PlansItem;
/* loaded from: classes3.dex */
public abstract class AdapterHolidayPlanLayoutBinding extends ViewDataBinding {
    public final TextView additionalUsage;
    public final MaterialButton btnRenewPlanId;
    public final RecyclerView listPlanValidityId;
    public final LinearLayout lytItemExpandable;
    public final LinearLayout lytSimpleItem;
    public final LinearLayout lytValidityId;
    @Bindable
    protected HolidayPlanAdapter mCallBack;
    @Bindable
    protected PlansItem mPlan;
    @Bindable
    protected Integer mPosition;
    public final ImageView radioPlanId;

    public abstract void setCallBack(HolidayPlanAdapter callBack);

    public abstract void setPlan(PlansItem plan);

    public abstract void setPosition(Integer position);

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterHolidayPlanLayoutBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView additionalUsage, MaterialButton btnRenewPlanId, RecyclerView listPlanValidityId, LinearLayout lytItemExpandable, LinearLayout lytSimpleItem, LinearLayout lytValidityId, ImageView radioPlanId) {
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

    public HolidayPlanAdapter getCallBack() {
        return this.mCallBack;
    }

    public static AdapterHolidayPlanLayoutBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterHolidayPlanLayoutBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (AdapterHolidayPlanLayoutBinding) ViewDataBinding.inflateInternal(inflater, R.layout.adapter_holiday_plan_layout, root, attachToRoot, component);
    }

    public static AdapterHolidayPlanLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterHolidayPlanLayoutBinding inflate(LayoutInflater inflater, Object component) {
        return (AdapterHolidayPlanLayoutBinding) ViewDataBinding.inflateInternal(inflater, R.layout.adapter_holiday_plan_layout, null, false, component);
    }

    public static AdapterHolidayPlanLayoutBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterHolidayPlanLayoutBinding bind(View view, Object component) {
        return (AdapterHolidayPlanLayoutBinding) bind(component, view, R.layout.adapter_holiday_plan_layout);
    }
}
