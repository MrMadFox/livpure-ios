package com.livpure.safedrink.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.livpure.safedrink.R;
import com.livpure.safedrink.subscription.payment.viewmodel.SelectPlanViewModel;
/* loaded from: classes3.dex */
public abstract class FragmentSelectRechargePlanBinding extends ViewDataBinding {
    public final RecyclerView listPlanTitleId;
    @Bindable
    protected SelectPlanViewModel mViewModel;
    public final ViewPager2 planViewPager;
    public final TextView selectPlanLabel;

    public abstract void setViewModel(SelectPlanViewModel viewModel);

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentSelectRechargePlanBinding(Object _bindingComponent, View _root, int _localFieldCount, RecyclerView listPlanTitleId, ViewPager2 planViewPager, TextView selectPlanLabel) {
        super(_bindingComponent, _root, _localFieldCount);
        this.listPlanTitleId = listPlanTitleId;
        this.planViewPager = planViewPager;
        this.selectPlanLabel = selectPlanLabel;
    }

    public SelectPlanViewModel getViewModel() {
        return this.mViewModel;
    }

    public static FragmentSelectRechargePlanBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentSelectRechargePlanBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentSelectRechargePlanBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_select_recharge_plan, root, attachToRoot, component);
    }

    public static FragmentSelectRechargePlanBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentSelectRechargePlanBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentSelectRechargePlanBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_select_recharge_plan, null, false, component);
    }

    public static FragmentSelectRechargePlanBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentSelectRechargePlanBinding bind(View view, Object component) {
        return (FragmentSelectRechargePlanBinding) bind(component, view, R.layout.fragment_select_recharge_plan);
    }
}
