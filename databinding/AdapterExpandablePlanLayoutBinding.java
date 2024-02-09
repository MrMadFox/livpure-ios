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
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import com.livpure.safedrink.R;
import com.livpure.safedrink.subscription.payment.adapter.ExpandablePlanAdapter;
import com.livpure.safedrink.subscription.plan.data.model.plan.PlansItem;
/* loaded from: classes3.dex */
public abstract class AdapterExpandablePlanLayoutBinding extends ViewDataBinding {
    public final TextView additionalUsage;
    public final MaterialButton btnRenewPlanId;
    public final RecyclerView listPlanValidityId;
    public final LinearLayout lytItemExpandable;
    public final LinearLayout lytSimpleItem;
    public final LinearLayout lytValidityId;
    @Bindable
    protected ExpandablePlanAdapter mCallBack;
    @Bindable
    protected PlansItem mPlan;
    @Bindable
    protected Integer mPosition;
    public final ImageView radioPlanId;
    public final AppCompatTextView textAmount;
    public final AppCompatTextView textLitre;
    public final AppCompatTextView textLitreMonth;
    public final AppCompatTextView textPlanName;
    public final TextView textPopular;

    public abstract void setCallBack(ExpandablePlanAdapter callBack);

    public abstract void setPlan(PlansItem plan);

    public abstract void setPosition(Integer position);

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterExpandablePlanLayoutBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView additionalUsage, MaterialButton btnRenewPlanId, RecyclerView listPlanValidityId, LinearLayout lytItemExpandable, LinearLayout lytSimpleItem, LinearLayout lytValidityId, ImageView radioPlanId, AppCompatTextView textAmount, AppCompatTextView textLitre, AppCompatTextView textLitreMonth, AppCompatTextView textPlanName, TextView textPopular) {
        super(_bindingComponent, _root, _localFieldCount);
        this.additionalUsage = additionalUsage;
        this.btnRenewPlanId = btnRenewPlanId;
        this.listPlanValidityId = listPlanValidityId;
        this.lytItemExpandable = lytItemExpandable;
        this.lytSimpleItem = lytSimpleItem;
        this.lytValidityId = lytValidityId;
        this.radioPlanId = radioPlanId;
        this.textAmount = textAmount;
        this.textLitre = textLitre;
        this.textLitreMonth = textLitreMonth;
        this.textPlanName = textPlanName;
        this.textPopular = textPopular;
    }

    public Integer getPosition() {
        return this.mPosition;
    }

    public PlansItem getPlan() {
        return this.mPlan;
    }

    public ExpandablePlanAdapter getCallBack() {
        return this.mCallBack;
    }

    public static AdapterExpandablePlanLayoutBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterExpandablePlanLayoutBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (AdapterExpandablePlanLayoutBinding) ViewDataBinding.inflateInternal(inflater, R.layout.adapter_expandable_plan_layout, root, attachToRoot, component);
    }

    public static AdapterExpandablePlanLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterExpandablePlanLayoutBinding inflate(LayoutInflater inflater, Object component) {
        return (AdapterExpandablePlanLayoutBinding) ViewDataBinding.inflateInternal(inflater, R.layout.adapter_expandable_plan_layout, null, false, component);
    }

    public static AdapterExpandablePlanLayoutBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterExpandablePlanLayoutBinding bind(View view, Object component) {
        return (AdapterExpandablePlanLayoutBinding) bind(component, view, R.layout.adapter_expandable_plan_layout);
    }
}
