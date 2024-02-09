package com.livpure.safedrink.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.livpure.safedrink.R;
/* loaded from: classes3.dex */
public abstract class FrgmentHomeAirToWaterBinding extends ViewDataBinding {
    /* JADX INFO: Access modifiers changed from: protected */
    public FrgmentHomeAirToWaterBinding(Object _bindingComponent, View _root, int _localFieldCount) {
        super(_bindingComponent, _root, _localFieldCount);
    }

    public static FrgmentHomeAirToWaterBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FrgmentHomeAirToWaterBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FrgmentHomeAirToWaterBinding) ViewDataBinding.inflateInternal(inflater, R.layout.frgment_home_air_to_water, root, attachToRoot, component);
    }

    public static FrgmentHomeAirToWaterBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FrgmentHomeAirToWaterBinding inflate(LayoutInflater inflater, Object component) {
        return (FrgmentHomeAirToWaterBinding) ViewDataBinding.inflateInternal(inflater, R.layout.frgment_home_air_to_water, null, false, component);
    }

    public static FrgmentHomeAirToWaterBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FrgmentHomeAirToWaterBinding bind(View view, Object component) {
        return (FrgmentHomeAirToWaterBinding) bind(component, view, R.layout.frgment_home_air_to_water);
    }
}
