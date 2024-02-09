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
import com.livpure.safedrink.furlenco.model.HomeFurlencoModel;
/* loaded from: classes3.dex */
public abstract class FragmentFurlencoHomeBinding extends ViewDataBinding {
    public final TextView averageWaterConsumption;
    public final BarChart barChart;
    public final ImageView bleInfoIV;
    public final LinearLayout boltSettingsLL;
    public final ConstraintLayout consumptionDashboard;
    public final TextView dailyConsumptionLabe;
    public final ImageView filterLifeImage;
    public final TextView filterLifeLabel;
    public final ConstraintLayout homeContainer;
    public final Guideline horizontalMiddleGuidline;
    public final TextView lastSynchronized;
    public final ProgressBar loader;
    @Bindable
    protected HomeFurlencoModel mViewModel;
    public final Button makePayment;
    public final Button makePaymentDiabled;
    public final Guideline middleVerticalGuide;
    public final View partitionView;
    public final TextView planDetails;
    public final TextView planDetailsLabel;
    public final ConstraintLayout readingSection;
    public final TextView remainingWaterLabel;
    public final ImageView settingsIV;
    public final SwipeRefreshLayout swipeRefreshLayoutComments;
    public final TextView waterRemainingHundreds;
    public final TextView waterRemainingOnes;
    public final TextView waterRemainingTenThousand;
    public final TextView waterRemainingTens;
    public final TextView waterRemainingThousands;
    public final ImageView waterUsageImage;
    public final LinearLayout waterremainLL;
    public final ImageView wifiInfoIV;

    public abstract void setViewModel(HomeFurlencoModel viewModel);

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentFurlencoHomeBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView averageWaterConsumption, BarChart barChart, ImageView bleInfoIV, LinearLayout boltSettingsLL, ConstraintLayout consumptionDashboard, TextView dailyConsumptionLabe, ImageView filterLifeImage, TextView filterLifeLabel, ConstraintLayout homeContainer, Guideline horizontalMiddleGuidline, TextView lastSynchronized, ProgressBar loader, Button makePayment, Button makePaymentDiabled, Guideline middleVerticalGuide, View partitionView, TextView planDetails, TextView planDetailsLabel, ConstraintLayout readingSection, TextView remainingWaterLabel, ImageView settingsIV, SwipeRefreshLayout swipeRefreshLayoutComments, TextView waterRemainingHundreds, TextView waterRemainingOnes, TextView waterRemainingTenThousand, TextView waterRemainingTens, TextView waterRemainingThousands, ImageView waterUsageImage, LinearLayout waterremainLL, ImageView wifiInfoIV) {
        super(_bindingComponent, _root, _localFieldCount);
        this.averageWaterConsumption = averageWaterConsumption;
        this.barChart = barChart;
        this.bleInfoIV = bleInfoIV;
        this.boltSettingsLL = boltSettingsLL;
        this.consumptionDashboard = consumptionDashboard;
        this.dailyConsumptionLabe = dailyConsumptionLabe;
        this.filterLifeImage = filterLifeImage;
        this.filterLifeLabel = filterLifeLabel;
        this.homeContainer = homeContainer;
        this.horizontalMiddleGuidline = horizontalMiddleGuidline;
        this.lastSynchronized = lastSynchronized;
        this.loader = loader;
        this.makePayment = makePayment;
        this.makePaymentDiabled = makePaymentDiabled;
        this.middleVerticalGuide = middleVerticalGuide;
        this.partitionView = partitionView;
        this.planDetails = planDetails;
        this.planDetailsLabel = planDetailsLabel;
        this.readingSection = readingSection;
        this.remainingWaterLabel = remainingWaterLabel;
        this.settingsIV = settingsIV;
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

    public HomeFurlencoModel getViewModel() {
        return this.mViewModel;
    }

    public static FragmentFurlencoHomeBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentFurlencoHomeBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentFurlencoHomeBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_furlenco_home, root, attachToRoot, component);
    }

    public static FragmentFurlencoHomeBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentFurlencoHomeBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentFurlencoHomeBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_furlenco_home, null, false, component);
    }

    public static FragmentFurlencoHomeBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentFurlencoHomeBinding bind(View view, Object component) {
        return (FragmentFurlencoHomeBinding) bind(component, view, R.layout.fragment_furlenco_home);
    }
}
