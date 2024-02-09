package com.livpure.safedrink.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.livpure.safedrink.R;
import com.livpure.safedrink.subscription.plan.data.model.plan.PlansItem;
/* loaded from: classes3.dex */
public abstract class FragmentPlanBinding extends ViewDataBinding {
    public final ImageView imgRefundStatusId;
    public final RecyclerView listPlanPriceId;
    public final LinearLayout lytExtraInfoId;
    public final LinearLayout lytProceedToPayId;
    public final RelativeLayout lytRefundStatusId;
    @Bindable
    protected PlansItem mPlanItem;
    public final TextView tvBilledStatus;

    public abstract void setPlanItem(PlansItem planItem);

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentPlanBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageView imgRefundStatusId, RecyclerView listPlanPriceId, LinearLayout lytExtraInfoId, LinearLayout lytProceedToPayId, RelativeLayout lytRefundStatusId, TextView tvBilledStatus) {
        super(_bindingComponent, _root, _localFieldCount);
        this.imgRefundStatusId = imgRefundStatusId;
        this.listPlanPriceId = listPlanPriceId;
        this.lytExtraInfoId = lytExtraInfoId;
        this.lytProceedToPayId = lytProceedToPayId;
        this.lytRefundStatusId = lytRefundStatusId;
        this.tvBilledStatus = tvBilledStatus;
    }

    public PlansItem getPlanItem() {
        return this.mPlanItem;
    }

    public static FragmentPlanBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentPlanBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentPlanBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_plan, root, attachToRoot, component);
    }

    public static FragmentPlanBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentPlanBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentPlanBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_plan, null, false, component);
    }

    public static FragmentPlanBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentPlanBinding bind(View view, Object component) {
        return (FragmentPlanBinding) bind(component, view, R.layout.fragment_plan);
    }
}
