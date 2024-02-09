package com.livpure.safedrink.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.livpure.safedrink.R;
import com.livpure.safedrink.app.MainViewModel;
import com.livpure.safedrink.login.data.models.User;
import com.livpure.safedrink.subscription.kyc.viewmodel.UploadKYCViewModel;
/* loaded from: classes3.dex */
public abstract class FragmentUploadKycBinding extends ViewDataBinding {
    public final Spinner addressProofSpinner;
    public final Button addressProofUploadButton;
    public final TextView fileFormatMessage;
    public final Spinner idProofSpinner;
    public final Button idProofUploadButton;
    public final ProgressBar loader;
    @Bindable
    protected MainViewModel mActivityViewModel;
    @Bindable
    protected String mPaymentId;
    @Bindable
    protected User mUser;
    @Bindable
    protected UploadKYCViewModel mViewModel;
    public final TextView name;
    public final Spinner salutationSpinner;
    public final Button submitButton;
    public final TextView textView3;
    public final LinearLayout thankYouContainer;

    public abstract void setActivityViewModel(MainViewModel activityViewModel);

    public abstract void setPaymentId(String paymentId);

    public abstract void setUser(User user);

    public abstract void setViewModel(UploadKYCViewModel viewModel);

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentUploadKycBinding(Object _bindingComponent, View _root, int _localFieldCount, Spinner addressProofSpinner, Button addressProofUploadButton, TextView fileFormatMessage, Spinner idProofSpinner, Button idProofUploadButton, ProgressBar loader, TextView name, Spinner salutationSpinner, Button submitButton, TextView textView3, LinearLayout thankYouContainer) {
        super(_bindingComponent, _root, _localFieldCount);
        this.addressProofSpinner = addressProofSpinner;
        this.addressProofUploadButton = addressProofUploadButton;
        this.fileFormatMessage = fileFormatMessage;
        this.idProofSpinner = idProofSpinner;
        this.idProofUploadButton = idProofUploadButton;
        this.loader = loader;
        this.name = name;
        this.salutationSpinner = salutationSpinner;
        this.submitButton = submitButton;
        this.textView3 = textView3;
        this.thankYouContainer = thankYouContainer;
    }

    public User getUser() {
        return this.mUser;
    }

    public String getPaymentId() {
        return this.mPaymentId;
    }

    public UploadKYCViewModel getViewModel() {
        return this.mViewModel;
    }

    public MainViewModel getActivityViewModel() {
        return this.mActivityViewModel;
    }

    public static FragmentUploadKycBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentUploadKycBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentUploadKycBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_upload_kyc, root, attachToRoot, component);
    }

    public static FragmentUploadKycBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentUploadKycBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentUploadKycBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_upload_kyc, null, false, component);
    }

    public static FragmentUploadKycBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentUploadKycBinding bind(View view, Object component) {
        return (FragmentUploadKycBinding) bind(component, view, R.layout.fragment_upload_kyc);
    }
}
