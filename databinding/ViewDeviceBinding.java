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
import com.livpure.safedrink.subscription.plan.data.model.deviceList.DeviceList;
/* loaded from: classes3.dex */
public abstract class ViewDeviceBinding extends ViewDataBinding {
    public final TextView imeiNoTv;
    public final LinearLayout llDeviceList;
    @Bindable
    protected DeviceList mDevice;
    public final TextView serialNoTV;

    public abstract void setDevice(DeviceList device);

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewDeviceBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView imeiNoTv, LinearLayout llDeviceList, TextView serialNoTV) {
        super(_bindingComponent, _root, _localFieldCount);
        this.imeiNoTv = imeiNoTv;
        this.llDeviceList = llDeviceList;
        this.serialNoTV = serialNoTV;
    }

    public DeviceList getDevice() {
        return this.mDevice;
    }

    public static ViewDeviceBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewDeviceBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (ViewDeviceBinding) ViewDataBinding.inflateInternal(inflater, R.layout.view_device, root, attachToRoot, component);
    }

    public static ViewDeviceBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewDeviceBinding inflate(LayoutInflater inflater, Object component) {
        return (ViewDeviceBinding) ViewDataBinding.inflateInternal(inflater, R.layout.view_device, null, false, component);
    }

    public static ViewDeviceBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewDeviceBinding bind(View view, Object component) {
        return (ViewDeviceBinding) bind(component, view, R.layout.view_device);
    }
}
