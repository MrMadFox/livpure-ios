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
public abstract class DialogRequestSuccessfullyBinding extends ViewDataBinding {
    public final ImageView imageProfile;
    public final TextView jobDescription;
    public final TextView okButton;
    public final TextView tvIcon;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogRequestSuccessfullyBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageView imageProfile, TextView jobDescription, TextView okButton, TextView tvIcon) {
        super(_bindingComponent, _root, _localFieldCount);
        this.imageProfile = imageProfile;
        this.jobDescription = jobDescription;
        this.okButton = okButton;
        this.tvIcon = tvIcon;
    }

    public static DialogRequestSuccessfullyBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogRequestSuccessfullyBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (DialogRequestSuccessfullyBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_request_successfully, root, attachToRoot, component);
    }

    public static DialogRequestSuccessfullyBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogRequestSuccessfullyBinding inflate(LayoutInflater inflater, Object component) {
        return (DialogRequestSuccessfullyBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_request_successfully, null, false, component);
    }

    public static DialogRequestSuccessfullyBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogRequestSuccessfullyBinding bind(View view, Object component) {
        return (DialogRequestSuccessfullyBinding) bind(component, view, R.layout.dialog_request_successfully);
    }
}
