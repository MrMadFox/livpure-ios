package com.livpure.safedrink.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.livpure.safedrink.R;
import com.livpure.safedrink.serviceRequest.data.model.ServiceHistoryResponse;
import com.livpure.safedrink.serviceRequest.view.adapter.RaiseServiceHistoryAdapter;
/* loaded from: classes3.dex */
public abstract class RowItemSupportHistoryBinding extends ViewDataBinding {
    public final LinearLayout llContactPerson;
    public final LinearLayout llResolvedOn;
    @Bindable
    protected RaiseServiceHistoryAdapter mCallBack;
    @Bindable
    protected ServiceHistoryResponse mHistoryList;
    @Bindable
    protected Integer mPosition;
    public final TextView tvContactPerson;
    public final TextView tvContactPersonMobile;
    public final TextView tvRequestDate;
    public final TextView tvRequestId;
    public final TextView tvResolvedOn;
    public final TextView tvServiceReason;
    public final TextView tvStatus;

    public abstract void setCallBack(RaiseServiceHistoryAdapter callBack);

    public abstract void setHistoryList(ServiceHistoryResponse historyList);

    public abstract void setPosition(Integer position);

    /* JADX INFO: Access modifiers changed from: protected */
    public RowItemSupportHistoryBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout llContactPerson, LinearLayout llResolvedOn, TextView tvContactPerson, TextView tvContactPersonMobile, TextView tvRequestDate, TextView tvRequestId, TextView tvResolvedOn, TextView tvServiceReason, TextView tvStatus) {
        super(_bindingComponent, _root, _localFieldCount);
        this.llContactPerson = llContactPerson;
        this.llResolvedOn = llResolvedOn;
        this.tvContactPerson = tvContactPerson;
        this.tvContactPersonMobile = tvContactPersonMobile;
        this.tvRequestDate = tvRequestDate;
        this.tvRequestId = tvRequestId;
        this.tvResolvedOn = tvResolvedOn;
        this.tvServiceReason = tvServiceReason;
        this.tvStatus = tvStatus;
    }

    public Integer getPosition() {
        return this.mPosition;
    }

    public RaiseServiceHistoryAdapter getCallBack() {
        return this.mCallBack;
    }

    public ServiceHistoryResponse getHistoryList() {
        return this.mHistoryList;
    }

    public static RowItemSupportHistoryBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RowItemSupportHistoryBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (RowItemSupportHistoryBinding) ViewDataBinding.inflateInternal(inflater, R.layout.row_item_support_history, root, attachToRoot, component);
    }

    public static RowItemSupportHistoryBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RowItemSupportHistoryBinding inflate(LayoutInflater inflater, Object component) {
        return (RowItemSupportHistoryBinding) ViewDataBinding.inflateInternal(inflater, R.layout.row_item_support_history, null, false, component);
    }

    public static RowItemSupportHistoryBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RowItemSupportHistoryBinding bind(View view, Object component) {
        return (RowItemSupportHistoryBinding) bind(component, view, R.layout.row_item_support_history);
    }
}
