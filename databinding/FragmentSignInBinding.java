package com.livpure.safedrink.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.livpure.safedrink.R;
import com.livpure.safedrink.login.viewmodels.SignInViewModel;
/* loaded from: classes3.dex */
public abstract class FragmentSignInBinding extends ViewDataBinding {
    public final TextView createAccountText;
    public final TextInputEditText emailOrPhoneEditText;
    public final TextInputLayout emailOrPhoneTextInputLayout;
    public final TextView forgotPasswordText;
    public final Guideline guideline;
    public final ProgressBar loader;
    @Bindable
    protected SignInViewModel mViewModel;
    public final TextInputEditText passwordEditText;
    public final TextInputLayout passwordTextInputLayout;
    public final Button signInButton;
    public final MaterialToolbar staticToolBar;
    public final TextView termsText;

    public abstract void setViewModel(SignInViewModel viewModel);

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentSignInBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView createAccountText, TextInputEditText emailOrPhoneEditText, TextInputLayout emailOrPhoneTextInputLayout, TextView forgotPasswordText, Guideline guideline, ProgressBar loader, TextInputEditText passwordEditText, TextInputLayout passwordTextInputLayout, Button signInButton, MaterialToolbar staticToolBar, TextView termsText) {
        super(_bindingComponent, _root, _localFieldCount);
        this.createAccountText = createAccountText;
        this.emailOrPhoneEditText = emailOrPhoneEditText;
        this.emailOrPhoneTextInputLayout = emailOrPhoneTextInputLayout;
        this.forgotPasswordText = forgotPasswordText;
        this.guideline = guideline;
        this.loader = loader;
        this.passwordEditText = passwordEditText;
        this.passwordTextInputLayout = passwordTextInputLayout;
        this.signInButton = signInButton;
        this.staticToolBar = staticToolBar;
        this.termsText = termsText;
    }

    public SignInViewModel getViewModel() {
        return this.mViewModel;
    }

    public static FragmentSignInBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentSignInBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentSignInBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_sign_in, root, attachToRoot, component);
    }

    public static FragmentSignInBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentSignInBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentSignInBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_sign_in, null, false, component);
    }

    public static FragmentSignInBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentSignInBinding bind(View view, Object component) {
        return (FragmentSignInBinding) bind(component, view, R.layout.fragment_sign_in);
    }
}
