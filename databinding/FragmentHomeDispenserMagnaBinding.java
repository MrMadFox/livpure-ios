package com.livpure.safedrink.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.github.mikephil.charting.charts.BarChart;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.livpure.safedrink.R;
import com.livpure.safedrink.dispenser.model.HomeDispenserModel;
/* loaded from: classes3.dex */
public abstract class FragmentHomeDispenserMagnaBinding extends ViewDataBinding {
    public final TextView addLitres;
    public final TextView averageWaterConsumption;
    public final BarChart barChart;
    public final ImageView bleInfoIV;
    public final LinearLayout boltSettingsLL;
    public final BottomNavigationView bottomNavigationId;
    public final LinearLayout center;
    public final TextView dailyConsumption;
    public final LinearLayout filterLifeContainer;
    public final ImageView filterLifeImage;
    public final TextView filterLifeLabel;
    public final LinearLayout graph;
    public final TextView lastSynchronized;
    public final RecyclerView listBottomOptionDisId;
    public final LinearLayout llRaiseAserviceComplaint;
    public final ScrollView lytParentScrollView;
    @Bindable
    protected HomeDispenserModel mViewModel;
    public final View partitionView1;
    public final View partitionView2;
    public final TextView planDetails;
    public final LinearLayout planDetailsContainer;
    public final TextView planDetailsLabel;
    public final ConstraintLayout readingSection;
    public final TextView remainingWaterLabel;
    public final TextView renewPlan;
    public final ConstraintLayout serviceRequest;
    public final ImageView settingsIV;
    public final SwipeRefreshLayout swipeToRefresh;
    public final LinearLayout tdsBandContainer;
    public final ImageView tdsBandImage;
    public final TextView tdsBandLabel;
    public final ImageView uvStatusImage;
    public final LinearLayout warning;
    public final TextView warningMessage;
    public final ImageView waterDispenseUsageImage;
    public final TextView waterRemainingHundredThousands;
    public final TextView waterRemainingHundreds;
    public final TextView waterRemainingOnes;
    public final TextView waterRemainingTenThousands;
    public final TextView waterRemainingTens;
    public final TextView waterRemainingThousands;
    public final LinearLayout waterremainLL;
    public final ImageView wifiInfoIV;

    public abstract void setViewModel(HomeDispenserModel viewModel);

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentHomeDispenserMagnaBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView addLitres, TextView averageWaterConsumption, BarChart barChart, ImageView bleInfoIV, LinearLayout boltSettingsLL, BottomNavigationView bottomNavigationId, LinearLayout center, TextView dailyConsumption, LinearLayout filterLifeContainer, ImageView filterLifeImage, TextView filterLifeLabel, LinearLayout graph, TextView lastSynchronized, RecyclerView listBottomOptionDisId, LinearLayout llRaiseAserviceComplaint, ScrollView lytParentScrollView, View partitionView1, View partitionView2, TextView planDetails, LinearLayout planDetailsContainer, TextView planDetailsLabel, ConstraintLayout readingSection, TextView remainingWaterLabel, TextView renewPlan, ConstraintLayout serviceRequest, ImageView settingsIV, SwipeRefreshLayout swipeToRefresh, LinearLayout tdsBandContainer, ImageView tdsBandImage, TextView tdsBandLabel, ImageView uvStatusImage, LinearLayout warning, TextView warningMessage, ImageView waterDispenseUsageImage, TextView waterRemainingHundredThousands, TextView waterRemainingHundreds, TextView waterRemainingOnes, TextView waterRemainingTenThousands, TextView waterRemainingTens, TextView waterRemainingThousands, LinearLayout waterremainLL, ImageView wifiInfoIV) {
        super(_bindingComponent, _root, _localFieldCount);
        this.addLitres = addLitres;
        this.averageWaterConsumption = averageWaterConsumption;
        this.barChart = barChart;
        this.bleInfoIV = bleInfoIV;
        this.boltSettingsLL = boltSettingsLL;
        this.bottomNavigationId = bottomNavigationId;
        this.center = center;
        this.dailyConsumption = dailyConsumption;
        this.filterLifeContainer = filterLifeContainer;
        this.filterLifeImage = filterLifeImage;
        this.filterLifeLabel = filterLifeLabel;
        this.graph = graph;
        this.lastSynchronized = lastSynchronized;
        this.listBottomOptionDisId = listBottomOptionDisId;
        this.llRaiseAserviceComplaint = llRaiseAserviceComplaint;
        this.lytParentScrollView = lytParentScrollView;
        this.partitionView1 = partitionView1;
        this.partitionView2 = partitionView2;
        this.planDetails = planDetails;
        this.planDetailsContainer = planDetailsContainer;
        this.planDetailsLabel = planDetailsLabel;
        this.readingSection = readingSection;
        this.remainingWaterLabel = remainingWaterLabel;
        this.renewPlan = renewPlan;
        this.serviceRequest = serviceRequest;
        this.settingsIV = settingsIV;
        this.swipeToRefresh = swipeToRefresh;
        this.tdsBandContainer = tdsBandContainer;
        this.tdsBandImage = tdsBandImage;
        this.tdsBandLabel = tdsBandLabel;
        this.uvStatusImage = uvStatusImage;
        this.warning = warning;
        this.warningMessage = warningMessage;
        this.waterDispenseUsageImage = waterDispenseUsageImage;
        this.waterRemainingHundredThousands = waterRemainingHundredThousands;
        this.waterRemainingHundreds = waterRemainingHundreds;
        this.waterRemainingOnes = waterRemainingOnes;
        this.waterRemainingTenThousands = waterRemainingTenThousands;
        this.waterRemainingTens = waterRemainingTens;
        this.waterRemainingThousands = waterRemainingThousands;
        this.waterremainLL = waterremainLL;
        this.wifiInfoIV = wifiInfoIV;
    }

    public HomeDispenserModel getViewModel() {
        return this.mViewModel;
    }

    public static FragmentHomeDispenserMagnaBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentHomeDispenserMagnaBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentHomeDispenserMagnaBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_home_dispenser_magna, root, attachToRoot, component);
    }

    public static FragmentHomeDispenserMagnaBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentHomeDispenserMagnaBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentHomeDispenserMagnaBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_home_dispenser_magna, null, false, component);
    }

    public static FragmentHomeDispenserMagnaBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentHomeDispenserMagnaBinding bind(View view, Object component) {
        return (FragmentHomeDispenserMagnaBinding) bind(component, view, R.layout.fragment_home_dispenser_magna);
    }
}
