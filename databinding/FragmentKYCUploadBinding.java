package com.livpure.safedrink.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.textfield.TextInputLayout;
import com.livpure.safedrink.R;
import com.livpure.safedrink.serviceRequest.model.KycUploadModel;
/* loaded from: classes3.dex */
public abstract class FragmentKYCUploadBinding extends ViewDataBinding {
    public final AutoCompleteTextView addressProofCompleteTextView;
    public final TextInputLayout addressProofLayout;
    public final TextView backName;
    public final Button btnUploadDocument;
    public final CheckBox checkInstall;
    public final TextView frontName;
    public final ImageView imageViewBack;
    public final ImageView imageViewFront;
    @Bindable
    protected KycUploadModel mViewModel;
    public final LinearLayout uploadBackPhoto;
    public final LinearLayout uploadFrontPhoto;

    public abstract void setViewModel(KycUploadModel viewModel);

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentKYCUploadBinding(Object _bindingComponent, View _root, int _localFieldCount, AutoCompleteTextView addressProofCompleteTextView, TextInputLayout addressProofLayout, TextView backName, Button btnUploadDocument, CheckBox checkInstall, TextView frontName, ImageView imageViewBack, ImageView imageViewFront, LinearLayout uploadBackPhoto, LinearLayout uploadFrontPhoto) {
        super(_bindingComponent, _root, _localFieldCount);
        this.addressProofCompleteTextView = addressProofCompleteTextView;
        this.addressProofLayout = addressProofLayout;
        this.backName = backName;
        this.btnUploadDocument = btnUploadDocument;
        this.checkInstall = checkInstall;
        this.frontName = frontName;
        this.imageViewBack = imageViewBack;
        this.imageViewFront = imageViewFront;
        this.uploadBackPhoto = uploadBackPhoto;
        this.uploadFrontPhoto = uploadFrontPhoto;
    }

    public KycUploadModel getViewModel() {
        return this.mViewModel;
    }

    public static FragmentKYCUploadBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentKYCUploadBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentKYCUploadBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_k_y_c__upload, root, attachToRoot, component);
    }

    public static FragmentKYCUploadBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentKYCUploadBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentKYCUploadBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_k_y_c__upload, null, false, component);
    }

    public static FragmentKYCUploadBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentKYCUploadBinding bind(View view, Object component) {
        return (FragmentKYCUploadBinding) bind(component, view, R.layout.fragment_k_y_c__upload);
    }
}
