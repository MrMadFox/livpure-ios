package com.livpure.safedrink.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.livpure.safedrink.R;
/* loaded from: classes3.dex */
public abstract class DialogWifiListLayoutBinding extends ViewDataBinding {
    public final ListView listWifiId;
    public final TextView textNoWifiId;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogWifiListLayoutBinding(Object _bindingComponent, View _root, int _localFieldCount, ListView listWifiId, TextView textNoWifiId) {
        super(_bindingComponent, _root, _localFieldCount);
        this.listWifiId = listWifiId;
        this.textNoWifiId = textNoWifiId;
    }

    public static DialogWifiListLayoutBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogWifiListLayoutBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (DialogWifiListLayoutBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_wifi_list_layout, root, attachToRoot, component);
    }

    public static DialogWifiListLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogWifiListLayoutBinding inflate(LayoutInflater inflater, Object component) {
        return (DialogWifiListLayoutBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_wifi_list_layout, null, false, component);
    }

    public static DialogWifiListLayoutBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogWifiListLayoutBinding bind(View view, Object component) {
        return (DialogWifiListLayoutBinding) bind(component, view, R.layout.dialog_wifi_list_layout);
    }
}
