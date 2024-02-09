package com.livpure.safedrink.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.livpure.safedrink.R;
import com.livpure.safedrink.referNearn.viewmodels.ReferAndEarnViewModel;
/* loaded from: classes3.dex */
public abstract class FragmentReferralLeaderBoardBinding extends ViewDataBinding {
    public final FrameLayout frameHedder;
    public final RecyclerView listSuperUserId;
    public final LinearLayout lytParentViewId;
    public final FrameLayout lytRankId;
    @Bindable
    protected ReferAndEarnViewModel mUserData;
    public final TextView txtSuperuserMessageId;

    public abstract void setUserData(ReferAndEarnViewModel userData);

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentReferralLeaderBoardBinding(Object _bindingComponent, View _root, int _localFieldCount, FrameLayout frameHedder, RecyclerView listSuperUserId, LinearLayout lytParentViewId, FrameLayout lytRankId, TextView txtSuperuserMessageId) {
        super(_bindingComponent, _root, _localFieldCount);
        this.frameHedder = frameHedder;
        this.listSuperUserId = listSuperUserId;
        this.lytParentViewId = lytParentViewId;
        this.lytRankId = lytRankId;
        this.txtSuperuserMessageId = txtSuperuserMessageId;
    }

    public ReferAndEarnViewModel getUserData() {
        return this.mUserData;
    }

    public static FragmentReferralLeaderBoardBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentReferralLeaderBoardBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentReferralLeaderBoardBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_referral_leader_board, root, attachToRoot, component);
    }

    public static FragmentReferralLeaderBoardBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentReferralLeaderBoardBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentReferralLeaderBoardBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_referral_leader_board, null, false, component);
    }

    public static FragmentReferralLeaderBoardBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentReferralLeaderBoardBinding bind(View view, Object component) {
        return (FragmentReferralLeaderBoardBinding) bind(component, view, R.layout.fragment_referral_leader_board);
    }
}
