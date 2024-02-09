package com.livpure.safedrink.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.livpure.safedrink.R;
import com.livpure.safedrink.subscription.cancelsubscription.viewmodel.CancelSubsciptionModel;
/* loaded from: classes3.dex */
public abstract class FragmentCancelSubscriptionBinding extends ViewDataBinding {
    public final LinearLayout changePlanButton;
    public final LinearLayout finishSubscriptionButton;
    @Bindable
    protected CancelSubsciptionModel mViewModel;

    public abstract void setViewModel(CancelSubsciptionModel viewModel);

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentCancelSubscriptionBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout changePlanButton, LinearLayout finishSubscriptionButton) {
        super(_bindingComponent, _root, _localFieldCount);
        this.changePlanButton = changePlanButton;
        this.finishSubscriptionButton = finishSubscriptionButton;
    }

    public CancelSubsciptionModel getViewModel() {
        return this.mViewModel;
    }

    public static FragmentCancelSubscriptionBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentCancelSubscriptionBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentCancelSubscriptionBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_cancel_subscription, root, attachToRoot, component);
    }

    public static FragmentCancelSubscriptionBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentCancelSubscriptionBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentCancelSubscriptionBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_cancel_subscription, null, false, component);
    }

    public static FragmentCancelSubscriptionBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentCancelSubscriptionBinding bind(View view, Object component) {
        return (FragmentCancelSubscriptionBinding) bind(component, view, R.layout.fragment_cancel_subscription);
    }
}
