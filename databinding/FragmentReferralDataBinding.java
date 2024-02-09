package com.livpure.safedrink.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.livpure.safedrink.R;
import com.livpure.safedrink.serviceRequest.model.ReferralDataModel;
/* loaded from: classes3.dex */
public abstract class FragmentReferralDataBinding extends ViewDataBinding {
    @Bindable
    protected ReferralDataModel mViewModel;
    public final RecyclerView referralData;

    public abstract void setViewModel(ReferralDataModel viewModel);

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentReferralDataBinding(Object _bindingComponent, View _root, int _localFieldCount, RecyclerView referralData) {
        super(_bindingComponent, _root, _localFieldCount);
        this.referralData = referralData;
    }

    public ReferralDataModel getViewModel() {
        return this.mViewModel;
    }

    public static FragmentReferralDataBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentReferralDataBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentReferralDataBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_referral_data, root, attachToRoot, component);
    }

    public static FragmentReferralDataBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentReferralDataBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentReferralDataBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_referral_data, null, false, component);
    }

    public static FragmentReferralDataBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentReferralDataBinding bind(View view, Object component) {
        return (FragmentReferralDataBinding) bind(component, view, R.layout.fragment_referral_data);
    }
}
