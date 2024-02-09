package com.livpure.safedrink.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.livpure.safedrink.R;
import com.livpure.safedrink.serviceRequest.data.model.NewPlanList;
import com.livpure.safedrink.serviceRequest.model.RelocationModel;
/* loaded from: classes3.dex */
public abstract class AdapterNewPlanLayoutBinding extends ViewDataBinding {
    public final LinearLayout layoutMonth;
    public final RelativeLayout lytValidityId;
    @Bindable
    protected NewPlanList mDuration;
    @Bindable
    protected Integer mPosition;
    @Bindable
    protected RelocationModel mViewModel;
    public final AppCompatTextView textMonth;
    public final TextView textPopular;
    public final AppCompatTextView textRsPlan;
    public final AppCompatTextView textTotalMonth;

    public abstract void setDuration(NewPlanList duration);

    public abstract void setPosition(Integer position);

    public abstract void setViewModel(RelocationModel viewModel);

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterNewPlanLayoutBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout layoutMonth, RelativeLayout lytValidityId, AppCompatTextView textMonth, TextView textPopular, AppCompatTextView textRsPlan, AppCompatTextView textTotalMonth) {
        super(_bindingComponent, _root, _localFieldCount);
        this.layoutMonth = layoutMonth;
        this.lytValidityId = lytValidityId;
        this.textMonth = textMonth;
        this.textPopular = textPopular;
        this.textRsPlan = textRsPlan;
        this.textTotalMonth = textTotalMonth;
    }

    public Integer getPosition() {
        return this.mPosition;
    }

    public NewPlanList getDuration() {
        return this.mDuration;
    }

    public RelocationModel getViewModel() {
        return this.mViewModel;
    }

    public static AdapterNewPlanLayoutBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterNewPlanLayoutBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (AdapterNewPlanLayoutBinding) ViewDataBinding.inflateInternal(inflater, R.layout.adapter_new_plan_layout, root, attachToRoot, component);
    }

    public static AdapterNewPlanLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterNewPlanLayoutBinding inflate(LayoutInflater inflater, Object component) {
        return (AdapterNewPlanLayoutBinding) ViewDataBinding.inflateInternal(inflater, R.layout.adapter_new_plan_layout, null, false, component);
    }

    public static AdapterNewPlanLayoutBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterNewPlanLayoutBinding bind(View view, Object component) {
        return (AdapterNewPlanLayoutBinding) bind(component, view, R.layout.adapter_new_plan_layout);
    }
}
