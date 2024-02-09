package com.livpure.safedrink.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.livpure.safedrink.R;
import com.livpure.safedrink.serviceRequest.model.ServiceRequestHistoryModel;
/* loaded from: classes3.dex */
public abstract class FragmentServiceRequestHistoryBinding extends ViewDataBinding {
    public final TextView assignTo;
    public final TextView jobSheet;
    public final TextView jobStatus;
    public final RecyclerView listHistory;
    @Bindable
    protected ServiceRequestHistoryModel mViewModel;

    public abstract void setViewModel(ServiceRequestHistoryModel viewModel);

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentServiceRequestHistoryBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView assignTo, TextView jobSheet, TextView jobStatus, RecyclerView listHistory) {
        super(_bindingComponent, _root, _localFieldCount);
        this.assignTo = assignTo;
        this.jobSheet = jobSheet;
        this.jobStatus = jobStatus;
        this.listHistory = listHistory;
    }

    public ServiceRequestHistoryModel getViewModel() {
        return this.mViewModel;
    }

    public static FragmentServiceRequestHistoryBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentServiceRequestHistoryBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentServiceRequestHistoryBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_service_request_history, root, attachToRoot, component);
    }

    public static FragmentServiceRequestHistoryBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentServiceRequestHistoryBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentServiceRequestHistoryBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_service_request_history, null, false, component);
    }

    public static FragmentServiceRequestHistoryBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentServiceRequestHistoryBinding bind(View view, Object component) {
        return (FragmentServiceRequestHistoryBinding) bind(component, view, R.layout.fragment_service_request_history);
    }
}
