package com.livpure.safedrink.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;
import com.livpure.safedrink.R;
import com.livpure.safedrink.app.MainViewModel;
/* loaded from: classes3.dex */
public abstract class ActivitySingleMainBinding extends ViewDataBinding {
    public final Button btnUpdate;
    public final DrawerLayout drawerLayout;
    @Bindable
    protected MainViewModel mViewModel;
    public final MaterialToolbar mainToolbar;
    public final NavigationView navDrawerView;
    public final TextView tvStatus;

    public abstract void setViewModel(MainViewModel viewModel);

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivitySingleMainBinding(Object _bindingComponent, View _root, int _localFieldCount, Button btnUpdate, DrawerLayout drawerLayout, MaterialToolbar mainToolbar, NavigationView navDrawerView, TextView tvStatus) {
        super(_bindingComponent, _root, _localFieldCount);
        this.btnUpdate = btnUpdate;
        this.drawerLayout = drawerLayout;
        this.mainToolbar = mainToolbar;
        this.navDrawerView = navDrawerView;
        this.tvStatus = tvStatus;
    }

    public MainViewModel getViewModel() {
        return this.mViewModel;
    }

    public static ActivitySingleMainBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivitySingleMainBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (ActivitySingleMainBinding) ViewDataBinding.inflateInternal(inflater, R.layout.activity_single_main, root, attachToRoot, component);
    }

    public static ActivitySingleMainBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivitySingleMainBinding inflate(LayoutInflater inflater, Object component) {
        return (ActivitySingleMainBinding) ViewDataBinding.inflateInternal(inflater, R.layout.activity_single_main, null, false, component);
    }

    public static ActivitySingleMainBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivitySingleMainBinding bind(View view, Object component) {
        return (ActivitySingleMainBinding) bind(component, view, R.layout.activity_single_main);
    }
}
