package com.livpure.safedrink.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Spinner;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.livpure.safedrink.R;
import com.livpure.safedrink.subscription.cancelsubscription.viewmodel.CancelSubsciptionConfirmationModel;
/* loaded from: classes3.dex */
public abstract class FragmentConfirmCancelSubscriptionBinding extends ViewDataBinding {
    public final Spinner cancelReason;
    @Bindable
    protected CancelSubsciptionConfirmationModel mViewModel;
    public final LinearLayout submitButton;

    public abstract void setViewModel(CancelSubsciptionConfirmationModel viewModel);

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentConfirmCancelSubscriptionBinding(Object _bindingComponent, View _root, int _localFieldCount, Spinner cancelReason, LinearLayout submitButton) {
        super(_bindingComponent, _root, _localFieldCount);
        this.cancelReason = cancelReason;
        this.submitButton = submitButton;
    }

    public CancelSubsciptionConfirmationModel getViewModel() {
        return this.mViewModel;
    }

    public static FragmentConfirmCancelSubscriptionBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentConfirmCancelSubscriptionBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentConfirmCancelSubscriptionBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_confirm_cancel_subscription, root, attachToRoot, component);
    }

    public static FragmentConfirmCancelSubscriptionBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentConfirmCancelSubscriptionBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentConfirmCancelSubscriptionBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_confirm_cancel_subscription, null, false, component);
    }

    public static FragmentConfirmCancelSubscriptionBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentConfirmCancelSubscriptionBinding bind(View view, Object component) {
        return (FragmentConfirmCancelSubscriptionBinding) bind(component, view, R.layout.fragment_confirm_cancel_subscription);
    }
}
