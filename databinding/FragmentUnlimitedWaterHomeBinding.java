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
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.github.mikephil.charting.charts.BarChart;
import com.livpure.safedrink.R;
import com.livpure.safedrink.dispenser.model.UnlimitedWaterHomeModel;
/* loaded from: classes3.dex */
public abstract class FragmentUnlimitedWaterHomeBinding extends ViewDataBinding {
    public final TextView averageWaterConsumption;
    public final BarChart barChart;
    public final ImageView bleInfoIV;
    public final ImageView bleSyncIV;
    public final LinearLayout boltSettingsLL;
    public final ConstraintLayout consumptionDashboard;
    public final TextView dailyConsumptionLabe;
    public final ImageView filterLifeImage;
    public final TextView filterLifeLabel;
    public final ConstraintLayout homeContainer;
    public final Guideline horizontalMiddleGuidline;
    public final ImageView inviteFriend;
    public final LinearLayout knowMoreLL;
    public final TextView lastSynchronized;
    public final LinearLayout llRaiseAserviceComplaint;
    public final ProgressBar loader;
    @Bindable
    protected UnlimitedWaterHomeModel mViewModel;
    public final Button makePayment;
    public final Button makePaymentDiabled;
    public final Guideline middleVerticalGuide;
    public final View partitionView;
    public final TextView planDetails;
    public final TextView planDetailsLabel;
    public final ConstraintLayout readingSection;
    public final ImageView refereFriendImage;
    public final LinearLayout refereFriendLL;
    public final TextView remainingWaterLabel;
    public final Button renewPlan;
    public final ConstraintLayout serviceRequest;
    public final ImageView settingsIV;
    public final SwipeRefreshLayout swipeToRefresh;
    public final TextView waterRemainingHundreds;
    public final TextView waterRemainingOnes;
    public final TextView waterRemainingTenThousand;
    public final TextView waterRemainingTens;
    public final TextView waterRemainingThousands;
    public final ImageView waterUsageImage;
    public final LinearLayout waterremainLL;
    public final ImageView wifiInfoIV;

    public abstract void setViewModel(UnlimitedWaterHomeModel viewModel);

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentUnlimitedWaterHomeBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView averageWaterConsumption, BarChart barChart, ImageView bleInfoIV, ImageView bleSyncIV, LinearLayout boltSettingsLL, ConstraintLayout consumptionDashboard, TextView dailyConsumptionLabe, ImageView filterLifeImage, TextView filterLifeLabel, ConstraintLayout homeContainer, Guideline horizontalMiddleGuidline, ImageView inviteFriend, LinearLayout knowMoreLL, TextView lastSynchronized, LinearLayout llRaiseAserviceComplaint, ProgressBar loader, Button makePayment, Button makePaymentDiabled, Guideline middleVerticalGuide, View partitionView, TextView planDetails, TextView planDetailsLabel, ConstraintLayout readingSection, ImageView refereFriendImage, LinearLayout refereFriendLL, TextView remainingWaterLabel, Button renewPlan, ConstraintLayout serviceRequest, ImageView settingsIV, SwipeRefreshLayout swipeToRefresh, TextView waterRemainingHundreds, TextView waterRemainingOnes, TextView waterRemainingTenThousand, TextView waterRemainingTens, TextView waterRemainingThousands, ImageView waterUsageImage, LinearLayout waterremainLL, ImageView wifiInfoIV) {
        super(_bindingComponent, _root, _localFieldCount);
        this.averageWaterConsumption = averageWaterConsumption;
        this.barChart = barChart;
        this.bleInfoIV = bleInfoIV;
        this.bleSyncIV = bleSyncIV;
        this.boltSettingsLL = boltSettingsLL;
        this.consumptionDashboard = consumptionDashboard;
        this.dailyConsumptionLabe = dailyConsumptionLabe;
        this.filterLifeImage = filterLifeImage;
        this.filterLifeLabel = filterLifeLabel;
        this.homeContainer = homeContainer;
        this.horizontalMiddleGuidline = horizontalMiddleGuidline;
        this.inviteFriend = inviteFriend;
        this.knowMoreLL = knowMoreLL;
        this.lastSynchronized = lastSynchronized;
        this.llRaiseAserviceComplaint = llRaiseAserviceComplaint;
        this.loader = loader;
        this.makePayment = makePayment;
        this.makePaymentDiabled = makePaymentDiabled;
        this.middleVerticalGuide = middleVerticalGuide;
        this.partitionView = partitionView;
        this.planDetails = planDetails;
        this.planDetailsLabel = planDetailsLabel;
        this.readingSection = readingSection;
        this.refereFriendImage = refereFriendImage;
        this.refereFriendLL = refereFriendLL;
        this.remainingWaterLabel = remainingWaterLabel;
        this.renewPlan = renewPlan;
        this.serviceRequest = serviceRequest;
        this.settingsIV = settingsIV;
        this.swipeToRefresh = swipeToRefresh;
        this.waterRemainingHundreds = waterRemainingHundreds;
        this.waterRemainingOnes = waterRemainingOnes;
        this.waterRemainingTenThousand = waterRemainingTenThousand;
        this.waterRemainingTens = waterRemainingTens;
        this.waterRemainingThousands = waterRemainingThousands;
        this.waterUsageImage = waterUsageImage;
        this.waterremainLL = waterremainLL;
        this.wifiInfoIV = wifiInfoIV;
    }

    public UnlimitedWaterHomeModel getViewModel() {
        return this.mViewModel;
    }

    public static FragmentUnlimitedWaterHomeBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentUnlimitedWaterHomeBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentUnlimitedWaterHomeBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_unlimited_water_home, root, attachToRoot, component);
    }

    public static FragmentUnlimitedWaterHomeBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentUnlimitedWaterHomeBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentUnlimitedWaterHomeBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_unlimited_water_home, null, false, component);
    }

    public static FragmentUnlimitedWaterHomeBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentUnlimitedWaterHomeBinding bind(View view, Object component) {
        return (FragmentUnlimitedWaterHomeBinding) bind(component, view, R.layout.fragment_unlimited_water_home);
    }
}
