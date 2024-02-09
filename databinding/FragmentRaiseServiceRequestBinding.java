package com.livpure.safedrink.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.livpure.safedrink.R;
import com.livpure.safedrink.serviceRequest.model.RaiseServiceRequestModel;
/* loaded from: classes3.dex */
public abstract class FragmentRaiseServiceRequestBinding extends ViewDataBinding {
    public final EditText appointmentDate;
    public final TextView attachButton;
    public final LinearLayout llCustomerCancelVoice;
    public final LinearLayout llCustomerSubVoice;
    public final LinearLayout llCustomerVoice;
    @Bindable
    protected RaiseServiceRequestModel mViewModel;
    public final TextView referralText;
    public final EditText requestBox;
    public final Spinner spinnerCustCancelVoice;
    public final Spinner spinnerCustSubVoice;
    public final Spinner spinnerCustVoice;
    public final TextView submitButton;
    public final TextView tvHeddingText;
    public final RelativeLayout uploadLayout;

    public abstract void setViewModel(RaiseServiceRequestModel viewModel);

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentRaiseServiceRequestBinding(Object _bindingComponent, View _root, int _localFieldCount, EditText appointmentDate, TextView attachButton, LinearLayout llCustomerCancelVoice, LinearLayout llCustomerSubVoice, LinearLayout llCustomerVoice, TextView referralText, EditText requestBox, Spinner spinnerCustCancelVoice, Spinner spinnerCustSubVoice, Spinner spinnerCustVoice, TextView submitButton, TextView tvHeddingText, RelativeLayout uploadLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.appointmentDate = appointmentDate;
        this.attachButton = attachButton;
        this.llCustomerCancelVoice = llCustomerCancelVoice;
        this.llCustomerSubVoice = llCustomerSubVoice;
        this.llCustomerVoice = llCustomerVoice;
        this.referralText = referralText;
        this.requestBox = requestBox;
        this.spinnerCustCancelVoice = spinnerCustCancelVoice;
        this.spinnerCustSubVoice = spinnerCustSubVoice;
        this.spinnerCustVoice = spinnerCustVoice;
        this.submitButton = submitButton;
        this.tvHeddingText = tvHeddingText;
        this.uploadLayout = uploadLayout;
    }

    public RaiseServiceRequestModel getViewModel() {
        return this.mViewModel;
    }

    public static FragmentRaiseServiceRequestBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentRaiseServiceRequestBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentRaiseServiceRequestBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_raise_service_request, root, attachToRoot, component);
    }

    public static FragmentRaiseServiceRequestBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentRaiseServiceRequestBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentRaiseServiceRequestBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_raise_service_request, null, false, component);
    }

    public static FragmentRaiseServiceRequestBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentRaiseServiceRequestBinding bind(View view, Object component) {
        return (FragmentRaiseServiceRequestBinding) bind(component, view, R.layout.fragment_raise_service_request);
    }
}
