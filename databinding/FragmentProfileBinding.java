package com.livpure.safedrink.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.livpure.safedrink.R;
import com.livpure.safedrink.app.ProfileViewModel;
/* loaded from: classes3.dex */
public abstract class FragmentProfileBinding extends ViewDataBinding {
    public final LinearLayout cancelSubscriptionDetailsLinearLayout;
    public final LinearLayout cancelSubscriptionLinearLayout;
    public final TextView cancelSubscriptionTv;
    public final EditText editMobileNumber;
    public final EditText editTextAddress;
    public final EditText editTextMail;
    public final EditText editTextName;
    public final EditText editTextRefferralCode;
    public final ImageView imageProfile;
    public final ImageView imgEditMail;
    public final ImageView imgEditMobile;
    @Bindable
    protected ProfileViewModel mViewModel;

    public abstract void setViewModel(ProfileViewModel viewModel);

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentProfileBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout cancelSubscriptionDetailsLinearLayout, LinearLayout cancelSubscriptionLinearLayout, TextView cancelSubscriptionTv, EditText editMobileNumber, EditText editTextAddress, EditText editTextMail, EditText editTextName, EditText editTextRefferralCode, ImageView imageProfile, ImageView imgEditMail, ImageView imgEditMobile) {
        super(_bindingComponent, _root, _localFieldCount);
        this.cancelSubscriptionDetailsLinearLayout = cancelSubscriptionDetailsLinearLayout;
        this.cancelSubscriptionLinearLayout = cancelSubscriptionLinearLayout;
        this.cancelSubscriptionTv = cancelSubscriptionTv;
        this.editMobileNumber = editMobileNumber;
        this.editTextAddress = editTextAddress;
        this.editTextMail = editTextMail;
        this.editTextName = editTextName;
        this.editTextRefferralCode = editTextRefferralCode;
        this.imageProfile = imageProfile;
        this.imgEditMail = imgEditMail;
        this.imgEditMobile = imgEditMobile;
    }

    public ProfileViewModel getViewModel() {
        return this.mViewModel;
    }

    public static FragmentProfileBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentProfileBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentProfileBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_profile, root, attachToRoot, component);
    }

    public static FragmentProfileBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentProfileBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentProfileBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_profile, null, false, component);
    }

    public static FragmentProfileBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentProfileBinding bind(View view, Object component) {
        return (FragmentProfileBinding) bind(component, view, R.layout.fragment_profile);
    }
}
