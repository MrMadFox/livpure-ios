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
import com.livpure.safedrink.app.HomeViewModel;
/* loaded from: classes3.dex */
public abstract class FragmentHomeBinding extends ViewDataBinding {
    public final Button actionButton;
    public final ConstraintLayout actionContainer;
    public final TextView actionLabel;
    public final Button addLitresButton;
    public final TextView averageWaterConsumption;
    public final BarChart barChart;
    public final ImageView bleInfoIV;
    public final LinearLayout boltSettingsLL;
    public final ConstraintLayout consumptionDashboard;
    public final TextView dailyConsumptionLabe;
    public final Guideline endGuide;
    public final ImageView filterLifeImage;
    public final TextView filterLifeLabel;
    public final TextView hintHeader;
    public final ImageView hintImage;
    public final ConstraintLayout homeContainer;
    public final Guideline horizontalMiddleGuidline;
    public final LinearLayout knowMoreLL;
    public final TextView lastSynchronized;
    public final ProgressBar loader;
    @Bindable
    protected HomeViewModel mViewModel;
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
    public final Button renewSubscriptionButton;
    public final ImageView settingsIV;
    public final ImageView shareMore;
    public final Guideline startGuide;
    public final SwipeRefreshLayout swipeRefreshLayoutComments;
    public final TextView waterRemainingHundreds;
    public final TextView waterRemainingOnes;
    public final TextView waterRemainingTenThousand;
    public final TextView waterRemainingTens;
    public final TextView waterRemainingThousands;
    public final ImageView waterUsageImage;
    public final LinearLayout waterremainLL;
    public final ImageView wifiInfoIV;

    public abstract void setViewModel(HomeViewModel viewModel);

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentHomeBinding(Object _bindingComponent, View _root, int _localFieldCount, Button actionButton, ConstraintLayout actionContainer, TextView actionLabel, Button addLitresButton, TextView averageWaterConsumption, BarChart barChart, ImageView bleInfoIV, LinearLayout boltSettingsLL, ConstraintLayout consumptionDashboard, TextView dailyConsumptionLabe, Guideline endGuide, ImageView filterLifeImage, TextView filterLifeLabel, TextView hintHeader, ImageView hintImage, ConstraintLayout homeContainer, Guideline horizontalMiddleGuidline, LinearLayout knowMoreLL, TextView lastSynchronized, ProgressBar loader, Button makePayment, Button makePaymentDiabled, Guideline middleVerticalGuide, View partitionView, TextView planDetails, TextView planDetailsLabel, ConstraintLayout readingSection, ImageView refereFriendImage, LinearLayout refereFriendLL, TextView remainingWaterLabel, Button renewSubscriptionButton, ImageView settingsIV, ImageView shareMore, Guideline startGuide, SwipeRefreshLayout swipeRefreshLayoutComments, TextView waterRemainingHundreds, TextView waterRemainingOnes, TextView waterRemainingTenThousand, TextView waterRemainingTens, TextView waterRemainingThousands, ImageView waterUsageImage, LinearLayout waterremainLL, ImageView wifiInfoIV) {
        super(_bindingComponent, _root, _localFieldCount);
        this.actionButton = actionButton;
        this.actionContainer = actionContainer;
        this.actionLabel = actionLabel;
        this.addLitresButton = addLitresButton;
        this.averageWaterConsumption = averageWaterConsumption;
        this.barChart = barChart;
        this.bleInfoIV = bleInfoIV;
        this.boltSettingsLL = boltSettingsLL;
        this.consumptionDashboard = consumptionDashboard;
        this.dailyConsumptionLabe = dailyConsumptionLabe;
        this.endGuide = endGuide;
        this.filterLifeImage = filterLifeImage;
        this.filterLifeLabel = filterLifeLabel;
        this.hintHeader = hintHeader;
        this.hintImage = hintImage;
        this.homeContainer = homeContainer;
        this.horizontalMiddleGuidline = horizontalMiddleGuidline;
        this.knowMoreLL = knowMoreLL;
        this.lastSynchronized = lastSynchronized;
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
        this.renewSubscriptionButton = renewSubscriptionButton;
        this.settingsIV = settingsIV;
        this.shareMore = shareMore;
        this.startGuide = startGuide;
        this.swipeRefreshLayoutComments = swipeRefreshLayoutComments;
        this.waterRemainingHundreds = waterRemainingHundreds;
        this.waterRemainingOnes = waterRemainingOnes;
        this.waterRemainingTenThousand = waterRemainingTenThousand;
        this.waterRemainingTens = waterRemainingTens;
        this.waterRemainingThousands = waterRemainingThousands;
        this.waterUsageImage = waterUsageImage;
        this.waterremainLL = waterremainLL;
        this.wifiInfoIV = wifiInfoIV;
    }

    public HomeViewModel getViewModel() {
        return this.mViewModel;
    }

    public static FragmentHomeBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentHomeBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentHomeBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_home, root, attachToRoot, component);
    }

    public static FragmentHomeBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentHomeBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentHomeBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_home, null, false, component);
    }

    public static FragmentHomeBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentHomeBinding bind(View view, Object component) {
        return (FragmentHomeBinding) bind(component, view, R.layout.fragment_home);
    }
}
