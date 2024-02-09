package com.livpure.safedrink.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.livpure.safedrink.R;
/* loaded from: classes3.dex */
public abstract class DialogServiceRequestErrorBinding extends ViewDataBinding {
    public final ImageView imageProfile;
    public final TextView jobDescription;
    public final TextView okButton;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogServiceRequestErrorBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageView imageProfile, TextView jobDescription, TextView okButton) {
        super(_bindingComponent, _root, _localFieldCount);
        this.imageProfile = imageProfile;
        this.jobDescription = jobDescription;
        this.okButton = okButton;
    }

    public static DialogServiceRequestErrorBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogServiceRequestErrorBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (DialogServiceRequestErrorBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_service_request_error, root, attachToRoot, component);
    }

    public static DialogServiceRequestErrorBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogServiceRequestErrorBinding inflate(LayoutInflater inflater, Object component) {
        return (DialogServiceRequestErrorBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_service_request_error, null, false, component);
    }

    public static DialogServiceRequestErrorBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogServiceRequestErrorBinding bind(View view, Object component) {
        return (DialogServiceRequestErrorBinding) bind(component, view, R.layout.dialog_service_request_error);
    }
}
