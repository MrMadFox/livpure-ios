package com.livpure.safedrink.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.livpure.safedrink.R;
import com.livpure.safedrink.login.viewmodels.ResetPasswordViewModel;
/* loaded from: classes3.dex */
public abstract class FragmentResetPasswordBinding extends ViewDataBinding {
    public final TextInputEditText confirmEditText;
    public final TextInputLayout confirmTextInputLayout;
    public final Guideline guideline7;
    @Bindable
    protected ResetPasswordViewModel mViewModel;
    public final EditText otpEditText;
    public final TextView otpLabel;
    public final TextInputEditText passwordEditText;
    public final TextInputLayout passwordTextInputLayout;
    public final Button resetPasswordButton;
    public final ConstraintLayout resetPasswordContainer;
    public final ProgressBar resetPasswordProgress;
    public final TextView textView;

    public abstract void setViewModel(ResetPasswordViewModel viewModel);

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentResetPasswordBinding(Object _bindingComponent, View _root, int _localFieldCount, TextInputEditText confirmEditText, TextInputLayout confirmTextInputLayout, Guideline guideline7, EditText otpEditText, TextView otpLabel, TextInputEditText passwordEditText, TextInputLayout passwordTextInputLayout, Button resetPasswordButton, ConstraintLayout resetPasswordContainer, ProgressBar resetPasswordProgress, TextView textView) {
        super(_bindingComponent, _root, _localFieldCount);
        this.confirmEditText = confirmEditText;
        this.confirmTextInputLayout = confirmTextInputLayout;
        this.guideline7 = guideline7;
        this.otpEditText = otpEditText;
        this.otpLabel = otpLabel;
        this.passwordEditText = passwordEditText;
        this.passwordTextInputLayout = passwordTextInputLayout;
        this.resetPasswordButton = resetPasswordButton;
        this.resetPasswordContainer = resetPasswordContainer;
        this.resetPasswordProgress = resetPasswordProgress;
        this.textView = textView;
    }

    public ResetPasswordViewModel getViewModel() {
        return this.mViewModel;
    }

    public static FragmentResetPasswordBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentResetPasswordBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentResetPasswordBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_reset_password, root, attachToRoot, component);
    }

    public static FragmentResetPasswordBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentResetPasswordBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentResetPasswordBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_reset_password, null, false, component);
    }

    public static FragmentResetPasswordBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentResetPasswordBinding bind(View view, Object component) {
        return (FragmentResetPasswordBinding) bind(component, view, R.layout.fragment_reset_password);
    }
}
