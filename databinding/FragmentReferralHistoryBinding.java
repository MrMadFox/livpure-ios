package com.livpure.safedrink.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.livpure.safedrink.R;
import com.livpure.safedrink.referNearn.viewmodels.ReferAndEarnViewModel;
/* loaded from: classes3.dex */
public abstract class FragmentReferralHistoryBinding extends ViewDataBinding {
    public final Button inviteNowButton;
    public final RecyclerView listReferralHistoryId;
    public final LinearLayout llInviteNoow;
    public final LinearLayout lytParentViewId;
    @Bindable
    protected ReferAndEarnViewModel mUserData;

    public abstract void setUserData(ReferAndEarnViewModel userData);

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentReferralHistoryBinding(Object _bindingComponent, View _root, int _localFieldCount, Button inviteNowButton, RecyclerView listReferralHistoryId, LinearLayout llInviteNoow, LinearLayout lytParentViewId) {
        super(_bindingComponent, _root, _localFieldCount);
        this.inviteNowButton = inviteNowButton;
        this.listReferralHistoryId = listReferralHistoryId;
        this.llInviteNoow = llInviteNoow;
        this.lytParentViewId = lytParentViewId;
    }

    public ReferAndEarnViewModel getUserData() {
        return this.mUserData;
    }

    public static FragmentReferralHistoryBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentReferralHistoryBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentReferralHistoryBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_referral_history, root, attachToRoot, component);
    }

    public static FragmentReferralHistoryBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentReferralHistoryBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentReferralHistoryBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_referral_history, null, false, component);
    }

    public static FragmentReferralHistoryBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentReferralHistoryBinding bind(View view, Object component) {
        return (FragmentReferralHistoryBinding) bind(component, view, R.layout.fragment_referral_history);
    }
}
