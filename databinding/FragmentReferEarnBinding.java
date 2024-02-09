package com.livpure.safedrink.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.livpure.safedrink.R;
/* loaded from: classes3.dex */
public abstract class FragmentReferEarnBinding extends ViewDataBinding {
    public final LinearLayout lytParentViewId;
    public final TabLayout referralTabViewId;
    public final ViewPager2 referralViewPagerId;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentReferEarnBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout lytParentViewId, TabLayout referralTabViewId, ViewPager2 referralViewPagerId) {
        super(_bindingComponent, _root, _localFieldCount);
        this.lytParentViewId = lytParentViewId;
        this.referralTabViewId = referralTabViewId;
        this.referralViewPagerId = referralViewPagerId;
    }

    public static FragmentReferEarnBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentReferEarnBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentReferEarnBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_refer_earn, root, attachToRoot, component);
    }

    public static FragmentReferEarnBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentReferEarnBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentReferEarnBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_refer_earn, null, false, component);
    }

    public static FragmentReferEarnBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentReferEarnBinding bind(View view, Object component) {
        return (FragmentReferEarnBinding) bind(component, view, R.layout.fragment_refer_earn);
    }
}
