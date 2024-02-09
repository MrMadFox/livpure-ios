package com.livpure.safedrink.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.livpure.safedrink.R;
import com.livpure.safedrink.app.support.viewmodels.ServiceRequestViewModel;
/* loaded from: classes3.dex */
public abstract class FragmentServiceRequestBinding extends ViewDataBinding {
    @Bindable
    protected ServiceRequestViewModel mViewModel;
    public final EditText requestBox;
    public final TextView submitButton;

    public abstract void setViewModel(ServiceRequestViewModel viewModel);

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentServiceRequestBinding(Object _bindingComponent, View _root, int _localFieldCount, EditText requestBox, TextView submitButton) {
        super(_bindingComponent, _root, _localFieldCount);
        this.requestBox = requestBox;
        this.submitButton = submitButton;
    }

    public ServiceRequestViewModel getViewModel() {
        return this.mViewModel;
    }

    public static FragmentServiceRequestBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentServiceRequestBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentServiceRequestBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_service_request, root, attachToRoot, component);
    }

    public static FragmentServiceRequestBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentServiceRequestBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentServiceRequestBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_service_request, null, false, component);
    }

    public static FragmentServiceRequestBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentServiceRequestBinding bind(View view, Object component) {
        return (FragmentServiceRequestBinding) bind(component, view, R.layout.fragment_service_request);
    }
}
