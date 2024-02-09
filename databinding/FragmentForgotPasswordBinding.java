package com.livpure.safedrink.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.livpure.safedrink.R;
import com.livpure.safedrink.login.viewmodels.ForgotPasswordViewModel;
/* loaded from: classes3.dex */
public abstract class FragmentForgotPasswordBinding extends ViewDataBinding {
    public final TextInputEditText enterEmailEditText;
    public final TextInputLayout enterUsernameTextInputLayout;
    public final TextView forgotPasswordHint;
    public final TextView forgotPasswordLabel;
    public final Guideline guideline5;
    @Bindable
    protected ForgotPasswordViewModel mViewModel;
    public final ProgressBar progressBar3;
    public final Button resetPasswordButton;
    public final ImageView secureImage;

    public abstract void setViewModel(ForgotPasswordViewModel viewModel);

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentForgotPasswordBinding(Object _bindingComponent, View _root, int _localFieldCount, TextInputEditText enterEmailEditText, TextInputLayout enterUsernameTextInputLayout, TextView forgotPasswordHint, TextView forgotPasswordLabel, Guideline guideline5, ProgressBar progressBar3, Button resetPasswordButton, ImageView secureImage) {
        super(_bindingComponent, _root, _localFieldCount);
        this.enterEmailEditText = enterEmailEditText;
        this.enterUsernameTextInputLayout = enterUsernameTextInputLayout;
        this.forgotPasswordHint = forgotPasswordHint;
        this.forgotPasswordLabel = forgotPasswordLabel;
        this.guideline5 = guideline5;
        this.progressBar3 = progressBar3;
        this.resetPasswordButton = resetPasswordButton;
        this.secureImage = secureImage;
    }

    public ForgotPasswordViewModel getViewModel() {
        return this.mViewModel;
    }

    public static FragmentForgotPasswordBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentForgotPasswordBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentForgotPasswordBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_forgot_password, root, attachToRoot, component);
    }

    public static FragmentForgotPasswordBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentForgotPasswordBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentForgotPasswordBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_forgot_password, null, false, component);
    }

    public static FragmentForgotPasswordBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentForgotPasswordBinding bind(View view, Object component) {
        return (FragmentForgotPasswordBinding) bind(component, view, R.layout.fragment_forgot_password);
    }
}
