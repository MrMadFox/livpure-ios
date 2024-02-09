package com.livpure.safedrink.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.livpure.safedrink.R;
import com.livpure.safedrink.login.viewmodels.SignUpViewModel;
/* loaded from: classes3.dex */
public abstract class FragmentSignUpBinding extends ViewDataBinding {
    public final TextInputEditText emailEditText;
    public final TextInputLayout emailTextInputLayout;
    @Bindable
    protected SignUpViewModel mViewModel;
    public final TextInputEditText nameEditText;
    public final TextInputLayout nameTextInputLayout;
    public final TextInputEditText passwordEditText;
    public final TextInputLayout passwordTextInputLayout;
    public final TextInputEditText phoneEditText;
    public final LinearLayout phoneInputContainer;
    public final TextInputLayout phoneTextInputLayout;
    public final TextInputEditText referralCodeEditText;
    public final TextInputLayout referralCodeTextInputLayout;
    public final AutoCompleteTextView selectCityAutoCompleteTextView;
    public final TextInputLayout selectCityTextInputLayout;
    public final Button signUpButton;
    public final ProgressBar signUpProgressBar;
    public final TextView termsText;

    public abstract void setViewModel(SignUpViewModel viewModel);

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentSignUpBinding(Object _bindingComponent, View _root, int _localFieldCount, TextInputEditText emailEditText, TextInputLayout emailTextInputLayout, TextInputEditText nameEditText, TextInputLayout nameTextInputLayout, TextInputEditText passwordEditText, TextInputLayout passwordTextInputLayout, TextInputEditText phoneEditText, LinearLayout phoneInputContainer, TextInputLayout phoneTextInputLayout, TextInputEditText referralCodeEditText, TextInputLayout referralCodeTextInputLayout, AutoCompleteTextView selectCityAutoCompleteTextView, TextInputLayout selectCityTextInputLayout, Button signUpButton, ProgressBar signUpProgressBar, TextView termsText) {
        super(_bindingComponent, _root, _localFieldCount);
        this.emailEditText = emailEditText;
        this.emailTextInputLayout = emailTextInputLayout;
        this.nameEditText = nameEditText;
        this.nameTextInputLayout = nameTextInputLayout;
        this.passwordEditText = passwordEditText;
        this.passwordTextInputLayout = passwordTextInputLayout;
        this.phoneEditText = phoneEditText;
        this.phoneInputContainer = phoneInputContainer;
        this.phoneTextInputLayout = phoneTextInputLayout;
        this.referralCodeEditText = referralCodeEditText;
        this.referralCodeTextInputLayout = referralCodeTextInputLayout;
        this.selectCityAutoCompleteTextView = selectCityAutoCompleteTextView;
        this.selectCityTextInputLayout = selectCityTextInputLayout;
        this.signUpButton = signUpButton;
        this.signUpProgressBar = signUpProgressBar;
        this.termsText = termsText;
    }

    public SignUpViewModel getViewModel() {
        return this.mViewModel;
    }

    public static FragmentSignUpBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentSignUpBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentSignUpBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_sign_up, root, attachToRoot, component);
    }

    public static FragmentSignUpBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentSignUpBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentSignUpBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_sign_up, null, false, component);
    }

    public static FragmentSignUpBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentSignUpBinding bind(View view, Object component) {
        return (FragmentSignUpBinding) bind(component, view, R.layout.fragment_sign_up);
    }
}
