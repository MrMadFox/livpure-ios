package com.livpure.safedrink.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.livpure.safedrink.R;
import com.livpure.safedrink.model.DispenserBottomOption;
/* loaded from: classes3.dex */
public abstract class AdapterDispenserBottomOptionsBinding extends ViewDataBinding {
    public final LinearLayout lytValidityId;
    @Bindable
    protected Integer mMargin;
    @Bindable
    protected DispenserBottomOption mOption;

    public abstract void setMargin(Integer margin);

    public abstract void setOption(DispenserBottomOption option);

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterDispenserBottomOptionsBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout lytValidityId) {
        super(_bindingComponent, _root, _localFieldCount);
        this.lytValidityId = lytValidityId;
    }

    public DispenserBottomOption getOption() {
        return this.mOption;
    }

    public Integer getMargin() {
        return this.mMargin;
    }

    public static AdapterDispenserBottomOptionsBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterDispenserBottomOptionsBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (AdapterDispenserBottomOptionsBinding) ViewDataBinding.inflateInternal(inflater, R.layout.adapter_dispenser_bottom_options, root, attachToRoot, component);
    }

    public static AdapterDispenserBottomOptionsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterDispenserBottomOptionsBinding inflate(LayoutInflater inflater, Object component) {
        return (AdapterDispenserBottomOptionsBinding) ViewDataBinding.inflateInternal(inflater, R.layout.adapter_dispenser_bottom_options, null, false, component);
    }

    public static AdapterDispenserBottomOptionsBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterDispenserBottomOptionsBinding bind(View view, Object component) {
        return (AdapterDispenserBottomOptionsBinding) bind(component, view, R.layout.adapter_dispenser_bottom_options);
    }
}
