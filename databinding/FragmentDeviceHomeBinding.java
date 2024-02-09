package com.livpure.safedrink.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.livpure.safedrink.R;
import com.livpure.safedrink.app.DeviceHomeViewModel;
/* loaded from: classes3.dex */
public abstract class FragmentDeviceHomeBinding extends ViewDataBinding {
    public final Button actionButton;
    public final ConstraintLayout actionContainer;
    public final TextView actionLabel;
    public final Button airPurifier;
    public final ConstraintLayout consumptionDashboard;
    public final ViewPager2 deviceAirPurifierViewPager;
    public final ViewPager2 deviceViewPager;
    public final Guideline endGuide;
    public final TextView hintHeader;
    public final ImageView hintImage;
    public final ConstraintLayout homeContainer;
    public final ImageView inviteFriend;
    public final LinearLayout knowMoreLL;
    public final ProgressBar loader;
    @Bindable
    protected DeviceHomeViewModel mViewModel;
    public final Guideline middleVerticalGuide;
    public final ImageView refereFriendImage;
    public final LinearLayout refereFriendLL;
    public final TextView selectPlanLabel;
    public final TextView selectPlanLabel1;
    public final Guideline startGuide;

    public abstract void setViewModel(DeviceHomeViewModel viewModel);

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentDeviceHomeBinding(Object _bindingComponent, View _root, int _localFieldCount, Button actionButton, ConstraintLayout actionContainer, TextView actionLabel, Button airPurifier, ConstraintLayout consumptionDashboard, ViewPager2 deviceAirPurifierViewPager, ViewPager2 deviceViewPager, Guideline endGuide, TextView hintHeader, ImageView hintImage, ConstraintLayout homeContainer, ImageView inviteFriend, LinearLayout knowMoreLL, ProgressBar loader, Guideline middleVerticalGuide, ImageView refereFriendImage, LinearLayout refereFriendLL, TextView selectPlanLabel, TextView selectPlanLabel1, Guideline startGuide) {
        super(_bindingComponent, _root, _localFieldCount);
        this.actionButton = actionButton;
        this.actionContainer = actionContainer;
        this.actionLabel = actionLabel;
        this.airPurifier = airPurifier;
        this.consumptionDashboard = consumptionDashboard;
        this.deviceAirPurifierViewPager = deviceAirPurifierViewPager;
        this.deviceViewPager = deviceViewPager;
        this.endGuide = endGuide;
        this.hintHeader = hintHeader;
        this.hintImage = hintImage;
        this.homeContainer = homeContainer;
        this.inviteFriend = inviteFriend;
        this.knowMoreLL = knowMoreLL;
        this.loader = loader;
        this.middleVerticalGuide = middleVerticalGuide;
        this.refereFriendImage = refereFriendImage;
        this.refereFriendLL = refereFriendLL;
        this.selectPlanLabel = selectPlanLabel;
        this.selectPlanLabel1 = selectPlanLabel1;
        this.startGuide = startGuide;
    }

    public DeviceHomeViewModel getViewModel() {
        return this.mViewModel;
    }

    public static FragmentDeviceHomeBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentDeviceHomeBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentDeviceHomeBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_device_home, root, attachToRoot, component);
    }

    public static FragmentDeviceHomeBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentDeviceHomeBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentDeviceHomeBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_device_home, null, false, component);
    }

    public static FragmentDeviceHomeBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentDeviceHomeBinding bind(View view, Object component) {
        return (FragmentDeviceHomeBinding) bind(component, view, R.layout.fragment_device_home);
    }
}
