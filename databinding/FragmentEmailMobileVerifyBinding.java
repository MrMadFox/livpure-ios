package com.livpure.safedrink.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.livpure.safedrink.R;
/* loaded from: classes3.dex */
public abstract class FragmentEmailMobileVerifyBinding extends ViewDataBinding {
    public final TextView btnResend;
    public final TextView btnSubmit;
    public final TextView btnVerify;
    public final EditText editEmailMobile;
    public final EditText editTextNumber;
    public final EditText editTextNumber2;
    public final EditText editTextNumber3;
    public final EditText editTextNumber4;
    public final LinearLayout layoutVerify;
    public final TextView textEmailMobile;
    public final TextView textTimer;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentEmailMobileVerifyBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView btnResend, TextView btnSubmit, TextView btnVerify, EditText editEmailMobile, EditText editTextNumber, EditText editTextNumber2, EditText editTextNumber3, EditText editTextNumber4, LinearLayout layoutVerify, TextView textEmailMobile, TextView textTimer) {
        super(_bindingComponent, _root, _localFieldCount);
        this.btnResend = btnResend;
        this.btnSubmit = btnSubmit;
        this.btnVerify = btnVerify;
        this.editEmailMobile = editEmailMobile;
        this.editTextNumber = editTextNumber;
        this.editTextNumber2 = editTextNumber2;
        this.editTextNumber3 = editTextNumber3;
        this.editTextNumber4 = editTextNumber4;
        this.layoutVerify = layoutVerify;
        this.textEmailMobile = textEmailMobile;
        this.textTimer = textTimer;
    }

    public static FragmentEmailMobileVerifyBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentEmailMobileVerifyBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentEmailMobileVerifyBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_email_mobile_verify, root, attachToRoot, component);
    }

    public static FragmentEmailMobileVerifyBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentEmailMobileVerifyBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentEmailMobileVerifyBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_email_mobile_verify, null, false, component);
    }

    public static FragmentEmailMobileVerifyBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentEmailMobileVerifyBinding bind(View view, Object component) {
        return (FragmentEmailMobileVerifyBinding) bind(component, view, R.layout.fragment_email_mobile_verify);
    }
}
