package com.livpure.safedrink.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.livpure.safedrink.R;
import com.livpure.safedrink.model.AirPurifierBottomOption;
/* loaded from: classes3.dex */
public abstract class AdapterAirpurifierBottomOptionsBinding extends ViewDataBinding {
    public final LinearLayout lytValidityId;
    @Bindable
    protected AirPurifierBottomOption mOption;

    public abstract void setOption(AirPurifierBottomOption option);

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterAirpurifierBottomOptionsBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout lytValidityId) {
        super(_bindingComponent, _root, _localFieldCount);
        this.lytValidityId = lytValidityId;
    }

    public AirPurifierBottomOption getOption() {
        return this.mOption;
    }

    public static AdapterAirpurifierBottomOptionsBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterAirpurifierBottomOptionsBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (AdapterAirpurifierBottomOptionsBinding) ViewDataBinding.inflateInternal(inflater, R.layout.adapter_airpurifier_bottom_options, root, attachToRoot, component);
    }

    public static AdapterAirpurifierBottomOptionsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterAirpurifierBottomOptionsBinding inflate(LayoutInflater inflater, Object component) {
        return (AdapterAirpurifierBottomOptionsBinding) ViewDataBinding.inflateInternal(inflater, R.layout.adapter_airpurifier_bottom_options, null, false, component);
    }

    public static AdapterAirpurifierBottomOptionsBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterAirpurifierBottomOptionsBinding bind(View view, Object component) {
        return (AdapterAirpurifierBottomOptionsBinding) bind(component, view, R.layout.adapter_airpurifier_bottom_options);
    }
}
