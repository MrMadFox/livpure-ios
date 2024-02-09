package com.livpure.safedrink.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.livpure.safedrink.R;
/* loaded from: classes3.dex */
public abstract class AdapterReferrelDataLayoutBinding extends ViewDataBinding {
    public final TextView textEmail;
    public final TextView textName;
    public final TextView textPhone;
    public final TextView tvResend;

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterReferrelDataLayoutBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView textEmail, TextView textName, TextView textPhone, TextView tvResend) {
        super(_bindingComponent, _root, _localFieldCount);
        this.textEmail = textEmail;
        this.textName = textName;
        this.textPhone = textPhone;
        this.tvResend = tvResend;
    }

    public static AdapterReferrelDataLayoutBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterReferrelDataLayoutBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (AdapterReferrelDataLayoutBinding) ViewDataBinding.inflateInternal(inflater, R.layout.adapter_referrel_data_layout, root, attachToRoot, component);
    }

    public static AdapterReferrelDataLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterReferrelDataLayoutBinding inflate(LayoutInflater inflater, Object component) {
        return (AdapterReferrelDataLayoutBinding) ViewDataBinding.inflateInternal(inflater, R.layout.adapter_referrel_data_layout, null, false, component);
    }

    public static AdapterReferrelDataLayoutBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterReferrelDataLayoutBinding bind(View view, Object component) {
        return (AdapterReferrelDataLayoutBinding) bind(component, view, R.layout.adapter_referrel_data_layout);
    }
}
