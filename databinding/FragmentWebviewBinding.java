package com.livpure.safedrink.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.livpure.safedrink.R;
import com.livpure.safedrink.utils.AdvancedWebView;
/* loaded from: classes3.dex */
public abstract class FragmentWebviewBinding extends ViewDataBinding {
    public final ProgressBar progressBarId;
    public final AdvancedWebView webview;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentWebviewBinding(Object _bindingComponent, View _root, int _localFieldCount, ProgressBar progressBarId, AdvancedWebView webview) {
        super(_bindingComponent, _root, _localFieldCount);
        this.progressBarId = progressBarId;
        this.webview = webview;
    }

    public static FragmentWebviewBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentWebviewBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentWebviewBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_webview, root, attachToRoot, component);
    }

    public static FragmentWebviewBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentWebviewBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentWebviewBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_webview, null, false, component);
    }

    public static FragmentWebviewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentWebviewBinding bind(View view, Object component) {
        return (FragmentWebviewBinding) bind(component, view, R.layout.fragment_webview);
    }
}
