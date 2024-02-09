package com.livpure.safedrink.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
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
import com.livpure.safedrink.login.data.models.User;
import com.livpure.safedrink.subscription.address.viewmodel.InstallationAddressViewModel;
/* loaded from: classes3.dex */
public abstract class FragmentInstallationAddressBinding extends ViewDataBinding {
    public final TextInputEditText addressFirstLineEditText;
    public final TextInputLayout addressFirstLineInputLayout;
    public final TextInputEditText addressSecondLineEditText;
    public final TextInputLayout addressSecondLineInputLayout;
    public final TextInputEditText alternateNumberEditText;
    public final TextInputLayout alternateNumberInputLayout;
    public final AutoCompleteTextView areaAutoCompleteTextView;
    public final TextInputLayout areaTextInputLayout;
    public final AutoCompleteTextView cityAutoCompleteTextView;
    public final TextInputLayout cityTextInputLayout;
    public final ConstraintLayout constraintLayout2;
    public final Button continueButton;
    public final Guideline editTextEndMargin;
    public final Guideline editTextStartMargin;
    public final TextView email;
    public final ImageView emailImage;
    public final Guideline guideline3;
    public final TextView installationAddressLabel;
    @Bindable
    protected User mUser;
    @Bindable
    protected InstallationAddressViewModel mViewModel;
    public final TextView name;
    public final Guideline parentStartMargin;
    public final Guideline parentTopMargin;
    public final TextView phone;
    public final ImageView phoneImage;
    public final TextInputEditText pinCodeEditText;
    public final TextInputLayout pinCodeInputLayout;
    public final ProgressBar progressBar4;
    public final ImageView userImage;

    public abstract void setUser(User user);

    public abstract void setViewModel(InstallationAddressViewModel viewModel);

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentInstallationAddressBinding(Object _bindingComponent, View _root, int _localFieldCount, TextInputEditText addressFirstLineEditText, TextInputLayout addressFirstLineInputLayout, TextInputEditText addressSecondLineEditText, TextInputLayout addressSecondLineInputLayout, TextInputEditText alternateNumberEditText, TextInputLayout alternateNumberInputLayout, AutoCompleteTextView areaAutoCompleteTextView, TextInputLayout areaTextInputLayout, AutoCompleteTextView cityAutoCompleteTextView, TextInputLayout cityTextInputLayout, ConstraintLayout constraintLayout2, Button continueButton, Guideline editTextEndMargin, Guideline editTextStartMargin, TextView email, ImageView emailImage, Guideline guideline3, TextView installationAddressLabel, TextView name, Guideline parentStartMargin, Guideline parentTopMargin, TextView phone, ImageView phoneImage, TextInputEditText pinCodeEditText, TextInputLayout pinCodeInputLayout, ProgressBar progressBar4, ImageView userImage) {
        super(_bindingComponent, _root, _localFieldCount);
        this.addressFirstLineEditText = addressFirstLineEditText;
        this.addressFirstLineInputLayout = addressFirstLineInputLayout;
        this.addressSecondLineEditText = addressSecondLineEditText;
        this.addressSecondLineInputLayout = addressSecondLineInputLayout;
        this.alternateNumberEditText = alternateNumberEditText;
        this.alternateNumberInputLayout = alternateNumberInputLayout;
        this.areaAutoCompleteTextView = areaAutoCompleteTextView;
        this.areaTextInputLayout = areaTextInputLayout;
        this.cityAutoCompleteTextView = cityAutoCompleteTextView;
        this.cityTextInputLayout = cityTextInputLayout;
        this.constraintLayout2 = constraintLayout2;
        this.continueButton = continueButton;
        this.editTextEndMargin = editTextEndMargin;
        this.editTextStartMargin = editTextStartMargin;
        this.email = email;
        this.emailImage = emailImage;
        this.guideline3 = guideline3;
        this.installationAddressLabel = installationAddressLabel;
        this.name = name;
        this.parentStartMargin = parentStartMargin;
        this.parentTopMargin = parentTopMargin;
        this.phone = phone;
        this.phoneImage = phoneImage;
        this.pinCodeEditText = pinCodeEditText;
        this.pinCodeInputLayout = pinCodeInputLayout;
        this.progressBar4 = progressBar4;
        this.userImage = userImage;
    }

    public User getUser() {
        return this.mUser;
    }

    public InstallationAddressViewModel getViewModel() {
        return this.mViewModel;
    }

    public static FragmentInstallationAddressBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentInstallationAddressBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentInstallationAddressBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_installation_address, root, attachToRoot, component);
    }

    public static FragmentInstallationAddressBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentInstallationAddressBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentInstallationAddressBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_installation_address, null, false, component);
    }

    public static FragmentInstallationAddressBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentInstallationAddressBinding bind(View view, Object component) {
        return (FragmentInstallationAddressBinding) bind(component, view, R.layout.fragment_installation_address);
    }
}
