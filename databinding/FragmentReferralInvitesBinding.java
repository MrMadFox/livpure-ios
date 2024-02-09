package com.livpure.safedrink.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.textview.MaterialTextView;
import com.livpure.safedrink.R;
import com.livpure.safedrink.referNearn.viewmodels.ReferAndEarnViewModel;
/* loaded from: classes3.dex */
public abstract class FragmentReferralInvitesBinding extends ViewDataBinding {
    public final LinearLayout lytParentViewId;
    @Bindable
    protected ReferAndEarnViewModel mUserData;
    public final TextView onShareReferralCode;
    public final MaterialTextView onShareReferralCodeWhatsAPPLink;
    public final TextView termsAndConditionsLabel;
    public final TextView txtCopyId;
    public final TextView txtHowWorksId;

    public abstract void setUserData(ReferAndEarnViewModel userData);

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentReferralInvitesBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout lytParentViewId, TextView onShareReferralCode, MaterialTextView onShareReferralCodeWhatsAPPLink, TextView termsAndConditionsLabel, TextView txtCopyId, TextView txtHowWorksId) {
        super(_bindingComponent, _root, _localFieldCount);
        this.lytParentViewId = lytParentViewId;
        this.onShareReferralCode = onShareReferralCode;
        this.onShareReferralCodeWhatsAPPLink = onShareReferralCodeWhatsAPPLink;
        this.termsAndConditionsLabel = termsAndConditionsLabel;
        this.txtCopyId = txtCopyId;
        this.txtHowWorksId = txtHowWorksId;
    }

    public ReferAndEarnViewModel getUserData() {
        return this.mUserData;
    }

    public static FragmentReferralInvitesBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentReferralInvitesBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentReferralInvitesBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_referral_invites, root, attachToRoot, component);
    }

    public static FragmentReferralInvitesBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentReferralInvitesBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentReferralInvitesBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_referral_invites, null, false, component);
    }

    public static FragmentReferralInvitesBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentReferralInvitesBinding bind(View view, Object component) {
        return (FragmentReferralInvitesBinding) bind(component, view, R.layout.fragment_referral_invites);
    }
}
