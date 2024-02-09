package com.livpure.safedrink.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.appbar.MaterialToolbar;
import com.livpure.safedrink.R;
import com.livpure.safedrink.utils.AdvancedWebView;
/* loaded from: classes3.dex */
public abstract class FragmentOnboardingWebviewBinding extends ViewDataBinding {
    public final ProgressBar progressBarId;
    public final MaterialToolbar staticToolBar;
    public final TextView tvLogIn;
    public final AdvancedWebView webview;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentOnboardingWebviewBinding(Object _bindingComponent, View _root, int _localFieldCount, ProgressBar progressBarId, MaterialToolbar staticToolBar, TextView tvLogIn, AdvancedWebView webview) {
        super(_bindingComponent, _root, _localFieldCount);
        this.progressBarId = progressBarId;
        this.staticToolBar = staticToolBar;
        this.tvLogIn = tvLogIn;
        this.webview = webview;
    }

    public static FragmentOnboardingWebviewBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentOnboardingWebviewBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentOnboardingWebviewBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_onboarding_webview, root, attachToRoot, component);
    }

    public static FragmentOnboardingWebviewBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentOnboardingWebviewBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentOnboardingWebviewBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_onboarding_webview, null, false, component);
    }

    public static FragmentOnboardingWebviewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentOnboardingWebviewBinding bind(View view, Object component) {
        return (FragmentOnboardingWebviewBinding) bind(component, view, R.layout.fragment_onboarding_webview);
    }
}
