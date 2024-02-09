package com.livpure.safedrink.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.livpure.safedrink.R;
/* loaded from: classes3.dex */
public abstract class AdapterAutoCompleteBinding extends ViewDataBinding {
    public final TextView txtAutoCompleteId;

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterAutoCompleteBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView txtAutoCompleteId) {
        super(_bindingComponent, _root, _localFieldCount);
        this.txtAutoCompleteId = txtAutoCompleteId;
    }

    public static AdapterAutoCompleteBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterAutoCompleteBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (AdapterAutoCompleteBinding) ViewDataBinding.inflateInternal(inflater, R.layout.adapter_auto_complete, root, attachToRoot, component);
    }

    public static AdapterAutoCompleteBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterAutoCompleteBinding inflate(LayoutInflater inflater, Object component) {
        return (AdapterAutoCompleteBinding) ViewDataBinding.inflateInternal(inflater, R.layout.adapter_auto_complete, null, false, component);
    }

    public static AdapterAutoCompleteBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterAutoCompleteBinding bind(View view, Object component) {
        return (AdapterAutoCompleteBinding) bind(component, view, R.layout.adapter_auto_complete);
    }
}
