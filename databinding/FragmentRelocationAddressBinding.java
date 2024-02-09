package com.livpure.safedrink.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.textfield.TextInputLayout;
import com.livpure.safedrink.R;
import com.livpure.safedrink.login.data.models.User;
import com.livpure.safedrink.serviceRequest.model.RelocationModel;
/* loaded from: classes3.dex */
public abstract class FragmentRelocationAddressBinding extends ViewDataBinding {
    public final AutoCompleteTextView areaAutoCompleteTextViewRelocation;
    public final TextInputLayout areaTextInputLayout;
    public final Button btnSubmit;
    public final EditText etCity;
    public final EditText etFlat;
    public final EditText etPin;
    public final EditText etStreet;
    @Bindable
    protected User mUser;
    @Bindable
    protected RelocationModel mViewModel;
    public final AutoCompleteTextView pickupAutoCompleteTextView;
    public final TextInputLayout pickupTextInputLayout;

    public abstract void setUser(User user);

    public abstract void setViewModel(RelocationModel viewModel);

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentRelocationAddressBinding(Object _bindingComponent, View _root, int _localFieldCount, AutoCompleteTextView areaAutoCompleteTextViewRelocation, TextInputLayout areaTextInputLayout, Button btnSubmit, EditText etCity, EditText etFlat, EditText etPin, EditText etStreet, AutoCompleteTextView pickupAutoCompleteTextView, TextInputLayout pickupTextInputLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.areaAutoCompleteTextViewRelocation = areaAutoCompleteTextViewRelocation;
        this.areaTextInputLayout = areaTextInputLayout;
        this.btnSubmit = btnSubmit;
        this.etCity = etCity;
        this.etFlat = etFlat;
        this.etPin = etPin;
        this.etStreet = etStreet;
        this.pickupAutoCompleteTextView = pickupAutoCompleteTextView;
        this.pickupTextInputLayout = pickupTextInputLayout;
    }

    public User getUser() {
        return this.mUser;
    }

    public RelocationModel getViewModel() {
        return this.mViewModel;
    }

    public static FragmentRelocationAddressBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentRelocationAddressBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentRelocationAddressBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_relocation_address, root, attachToRoot, component);
    }

    public static FragmentRelocationAddressBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentRelocationAddressBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentRelocationAddressBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_relocation_address, null, false, component);
    }

    public static FragmentRelocationAddressBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentRelocationAddressBinding bind(View view, Object component) {
        return (FragmentRelocationAddressBinding) bind(component, view, R.layout.fragment_relocation_address);
    }
}
