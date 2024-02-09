package com.livpure.safedrink.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.android.material.textfield.MaterialAutoCompleteTextView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.livpure.safedrink.R;
import com.livpure.safedrink.bolt.model.WiFiSettingsModel;
/* loaded from: classes3.dex */
public abstract class FragmentWifiSettingsBinding extends ViewDataBinding {
    public final MaterialAutoCompleteTextView autoWifiNameId;
    public final TextInputEditText edtPasswordId;
    public final TextInputEditText edtWifiNameId;
    public final ImageView imgRefreshId;
    public final TextView lastConnectedWifi;
    public final LinearLayout linearLayout;
    @Bindable
    protected Boolean mIsWifiRouter;
    @Bindable
    protected WiFiSettingsModel mViewModel;
    public final ProgressBar progressBar;
    public final RadioButton rBtnHotspotId;
    public final RadioButton rBtnWifiId;
    public final Button resetWiFi;
    public final RadioGroup rgBtnWifiTypeId;
    public final SwipeRefreshLayout swipeRefreshLayoutComments;
    public final TextInputLayout textAutoInputWifiNameId;
    public final TextInputLayout textInputAddressLineId;
    public final TextInputLayout textInputPasswordId;
    public final Button update;

    public abstract void setIsWifiRouter(Boolean isWifiRouter);

    public abstract void setViewModel(WiFiSettingsModel viewModel);

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentWifiSettingsBinding(Object _bindingComponent, View _root, int _localFieldCount, MaterialAutoCompleteTextView autoWifiNameId, TextInputEditText edtPasswordId, TextInputEditText edtWifiNameId, ImageView imgRefreshId, TextView lastConnectedWifi, LinearLayout linearLayout, ProgressBar progressBar, RadioButton rBtnHotspotId, RadioButton rBtnWifiId, Button resetWiFi, RadioGroup rgBtnWifiTypeId, SwipeRefreshLayout swipeRefreshLayoutComments, TextInputLayout textAutoInputWifiNameId, TextInputLayout textInputAddressLineId, TextInputLayout textInputPasswordId, Button update) {
        super(_bindingComponent, _root, _localFieldCount);
        this.autoWifiNameId = autoWifiNameId;
        this.edtPasswordId = edtPasswordId;
        this.edtWifiNameId = edtWifiNameId;
        this.imgRefreshId = imgRefreshId;
        this.lastConnectedWifi = lastConnectedWifi;
        this.linearLayout = linearLayout;
        this.progressBar = progressBar;
        this.rBtnHotspotId = rBtnHotspotId;
        this.rBtnWifiId = rBtnWifiId;
        this.resetWiFi = resetWiFi;
        this.rgBtnWifiTypeId = rgBtnWifiTypeId;
        this.swipeRefreshLayoutComments = swipeRefreshLayoutComments;
        this.textAutoInputWifiNameId = textAutoInputWifiNameId;
        this.textInputAddressLineId = textInputAddressLineId;
        this.textInputPasswordId = textInputPasswordId;
        this.update = update;
    }

    public WiFiSettingsModel getViewModel() {
        return this.mViewModel;
    }

    public Boolean getIsWifiRouter() {
        return this.mIsWifiRouter;
    }

    public static FragmentWifiSettingsBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentWifiSettingsBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentWifiSettingsBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_wifi_settings, root, attachToRoot, component);
    }

    public static FragmentWifiSettingsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentWifiSettingsBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentWifiSettingsBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_wifi_settings, null, false, component);
    }

    public static FragmentWifiSettingsBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentWifiSettingsBinding bind(View view, Object component) {
        return (FragmentWifiSettingsBinding) bind(component, view, R.layout.fragment_wifi_settings);
    }
}
