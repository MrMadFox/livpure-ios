package com.livpure.safedrink.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.github.mikephil.charting.charts.BarChart;
import com.livpure.safedrink.R;
/* loaded from: classes3.dex */
public abstract class FragmentHomeDispenserVeelineBinding extends ViewDataBinding {
    public final BarChart barchart;
    public final ImageView bleInfoIV;
    public final LinearLayout boltSettingsLL;
    public final LinearLayout center;
    public final FrameLayout chartLayout;
    public final TextView clickForMore;
    public final ConstraintLayout consumptionDashboard;
    public final TextView dailyConsumption;
    public final LinearLayout filterLifeContainer;
    public final ImageView filterLifeImage;
    public final TextView filterLifeLabel;
    public final LinearLayout graph;
    public final ConstraintLayout homeContainer;
    public final TextView lastSynchronized;
    public final RecyclerView listBottomOptionId;
    public final View partitionView1;
    public final View partitionView2;
    public final TextView planDetails;
    public final LinearLayout planDetailsContainer;
    public final TextView planDetailsLabel;
    public final ConstraintLayout readingSection;
    public final TextView remainingWaterLabel;
    public final ImageView settingsIV;
    public final SwipeRefreshLayout swipeRefreshLayoutComments;
    public final LinearLayout tdsBandContainer;
    public final ImageView tdsBandImage;
    public final TextView tdsBandLabel;
    public final LinearLayout warning;
    public final TextView warningMessage;
    public final TextView waterRemainingHundredThousands;
    public final TextView waterRemainingHundreds;
    public final TextView waterRemainingOnes;
    public final TextView waterRemainingTenThousands;
    public final TextView waterRemainingTens;
    public final TextView waterRemainingThousands;
    public final ImageView waterUsageImage;
    public final LinearLayout waterremainLL;
    public final ImageView wifiInfoIV;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentHomeDispenserVeelineBinding(Object _bindingComponent, View _root, int _localFieldCount, BarChart barchart, ImageView bleInfoIV, LinearLayout boltSettingsLL, LinearLayout center, FrameLayout chartLayout, TextView clickForMore, ConstraintLayout consumptionDashboard, TextView dailyConsumption, LinearLayout filterLifeContainer, ImageView filterLifeImage, TextView filterLifeLabel, LinearLayout graph, ConstraintLayout homeContainer, TextView lastSynchronized, RecyclerView listBottomOptionId, View partitionView1, View partitionView2, TextView planDetails, LinearLayout planDetailsContainer, TextView planDetailsLabel, ConstraintLayout readingSection, TextView remainingWaterLabel, ImageView settingsIV, SwipeRefreshLayout swipeRefreshLayoutComments, LinearLayout tdsBandContainer, ImageView tdsBandImage, TextView tdsBandLabel, LinearLayout warning, TextView warningMessage, TextView waterRemainingHundredThousands, TextView waterRemainingHundreds, TextView waterRemainingOnes, TextView waterRemainingTenThousands, TextView waterRemainingTens, TextView waterRemainingThousands, ImageView waterUsageImage, LinearLayout waterremainLL, ImageView wifiInfoIV) {
        super(_bindingComponent, _root, _localFieldCount);
        this.barchart = barchart;
        this.bleInfoIV = bleInfoIV;
        this.boltSettingsLL = boltSettingsLL;
        this.center = center;
        this.chartLayout = chartLayout;
        this.clickForMore = clickForMore;
        this.consumptionDashboard = consumptionDashboard;
        this.dailyConsumption = dailyConsumption;
        this.filterLifeContainer = filterLifeContainer;
        this.filterLifeImage = filterLifeImage;
        this.filterLifeLabel = filterLifeLabel;
        this.graph = graph;
        this.homeContainer = homeContainer;
        this.lastSynchronized = lastSynchronized;
        this.listBottomOptionId = listBottomOptionId;
        this.partitionView1 = partitionView1;
        this.partitionView2 = partitionView2;
        this.planDetails = planDetails;
        this.planDetailsContainer = planDetailsContainer;
        this.planDetailsLabel = planDetailsLabel;
        this.readingSection = readingSection;
        this.remainingWaterLabel = remainingWaterLabel;
        this.settingsIV = settingsIV;
        this.swipeRefreshLayoutComments = swipeRefreshLayoutComments;
        this.tdsBandContainer = tdsBandContainer;
        this.tdsBandImage = tdsBandImage;
        this.tdsBandLabel = tdsBandLabel;
        this.warning = warning;
        this.warningMessage = warningMessage;
        this.waterRemainingHundredThousands = waterRemainingHundredThousands;
        this.waterRemainingHundreds = waterRemainingHundreds;
        this.waterRemainingOnes = waterRemainingOnes;
        this.waterRemainingTenThousands = waterRemainingTenThousands;
        this.waterRemainingTens = waterRemainingTens;
        this.waterRemainingThousands = waterRemainingThousands;
        this.waterUsageImage = waterUsageImage;
        this.waterremainLL = waterremainLL;
        this.wifiInfoIV = wifiInfoIV;
    }

    public static FragmentHomeDispenserVeelineBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentHomeDispenserVeelineBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentHomeDispenserVeelineBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_home_dispenser_veeline, root, attachToRoot, component);
    }

    public static FragmentHomeDispenserVeelineBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentHomeDispenserVeelineBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentHomeDispenserVeelineBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_home_dispenser_veeline, null, false, component);
    }

    public static FragmentHomeDispenserVeelineBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentHomeDispenserVeelineBinding bind(View view, Object component) {
        return (FragmentHomeDispenserVeelineBinding) bind(component, view, R.layout.fragment_home_dispenser_veeline);
    }
}
