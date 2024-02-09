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
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.github.mikephil.charting.charts.BarChart;
import com.livpure.safedrink.R;
import com.livpure.safedrink.dispenser.model.HomeAirToWaterModel;
import pl.droidsonroids.gif.GifImageView;
/* loaded from: classes3.dex */
public abstract class FragmentAirtowaterBinding extends ViewDataBinding {
    public final TextView addLitres;
    public final TextView averageWaterConsumption;
    public final BarChart barChart;
    public final ImageView bleInfoIV;
    public final LinearLayout boltSettingsLL;
    public final LinearLayout center;
    public final ImageView coldTankImage;
    public final ImageView collectionTankImage;
    public final TextView dailyConsumption;
    public final LinearLayout filterLifeContainer;
    public final ImageView filterLifeImage;
    public final TextView filterLifeLabel;
    public final GifImageView gifTankStatus;
    public final LinearLayout graph;
    public final LinearLayout inTankll;
    public final ImageView ivHotWaterImage;
    public final ImageView ivQuietModeImage;
    public final ImageView ivTankStatus;
    public final ImageView ivWaterGenerationImage;
    public final TextView lastSynchronized;
    public final LinearLayout lytHotWaterId;
    public final ScrollView lytParentScrollView;
    public final LinearLayout lytQuietModeId;
    public final LinearLayout lytWaterGenerationId;
    @Bindable
    protected HomeAirToWaterModel mViewModel;
    public final View partitionView1;
    public final TextView planDetails;
    public final LinearLayout planDetailsContainer;
    public final TextView planDetailsLabel;
    public final ConstraintLayout readingSection;
    public final TextView remainingWaterLabel;
    public final TextView renewPlan;
    public final ImageView settingsIV;
    public final SwipeRefreshLayout swipeToRefresh;
    public final LinearLayout tdsBandContainer;
    public final ImageView tdsBandImage;
    public final TextView tdsBandLabel;
    public final TextView tvColdTankStatus;
    public final TextView tvHumidity;
    public final TextView tvTemprature;
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

    public abstract void setViewModel(HomeAirToWaterModel viewModel);

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentAirtowaterBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView addLitres, TextView averageWaterConsumption, BarChart barChart, ImageView bleInfoIV, LinearLayout boltSettingsLL, LinearLayout center, ImageView coldTankImage, ImageView collectionTankImage, TextView dailyConsumption, LinearLayout filterLifeContainer, ImageView filterLifeImage, TextView filterLifeLabel, GifImageView gifTankStatus, LinearLayout graph, LinearLayout inTankll, ImageView ivHotWaterImage, ImageView ivQuietModeImage, ImageView ivTankStatus, ImageView ivWaterGenerationImage, TextView lastSynchronized, LinearLayout lytHotWaterId, ScrollView lytParentScrollView, LinearLayout lytQuietModeId, LinearLayout lytWaterGenerationId, View partitionView1, TextView planDetails, LinearLayout planDetailsContainer, TextView planDetailsLabel, ConstraintLayout readingSection, TextView remainingWaterLabel, TextView renewPlan, ImageView settingsIV, SwipeRefreshLayout swipeToRefresh, LinearLayout tdsBandContainer, ImageView tdsBandImage, TextView tdsBandLabel, TextView tvColdTankStatus, TextView tvHumidity, TextView tvTemprature, ImageView uvStatusImage, LinearLayout warning, TextView warningMessage, ImageView waterDispenseUsageImage, TextView waterRemainingHundredThousands, TextView waterRemainingHundreds, TextView waterRemainingOnes, TextView waterRemainingTenThousands, TextView waterRemainingTens, TextView waterRemainingThousands, LinearLayout waterremainLL, ImageView wifiInfoIV) {
        super(_bindingComponent, _root, _localFieldCount);
        this.addLitres = addLitres;
        this.averageWaterConsumption = averageWaterConsumption;
        this.barChart = barChart;
        this.bleInfoIV = bleInfoIV;
        this.boltSettingsLL = boltSettingsLL;
        this.center = center;
        this.coldTankImage = coldTankImage;
        this.collectionTankImage = collectionTankImage;
        this.dailyConsumption = dailyConsumption;
        this.filterLifeContainer = filterLifeContainer;
        this.filterLifeImage = filterLifeImage;
        this.filterLifeLabel = filterLifeLabel;
        this.gifTankStatus = gifTankStatus;
        this.graph = graph;
        this.inTankll = inTankll;
        this.ivHotWaterImage = ivHotWaterImage;
        this.ivQuietModeImage = ivQuietModeImage;
        this.ivTankStatus = ivTankStatus;
        this.ivWaterGenerationImage = ivWaterGenerationImage;
        this.lastSynchronized = lastSynchronized;
        this.lytHotWaterId = lytHotWaterId;
        this.lytParentScrollView = lytParentScrollView;
        this.lytQuietModeId = lytQuietModeId;
        this.lytWaterGenerationId = lytWaterGenerationId;
        this.partitionView1 = partitionView1;
        this.planDetails = planDetails;
        this.planDetailsContainer = planDetailsContainer;
        this.planDetailsLabel = planDetailsLabel;
        this.readingSection = readingSection;
        this.remainingWaterLabel = remainingWaterLabel;
        this.renewPlan = renewPlan;
        this.settingsIV = settingsIV;
        this.swipeToRefresh = swipeToRefresh;
        this.tdsBandContainer = tdsBandContainer;
        this.tdsBandImage = tdsBandImage;
        this.tdsBandLabel = tdsBandLabel;
        this.tvColdTankStatus = tvColdTankStatus;
        this.tvHumidity = tvHumidity;
        this.tvTemprature = tvTemprature;
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

    public HomeAirToWaterModel getViewModel() {
        return this.mViewModel;
    }

    public static FragmentAirtowaterBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentAirtowaterBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentAirtowaterBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_airtowater, root, attachToRoot, component);
    }

    public static FragmentAirtowaterBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentAirtowaterBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentAirtowaterBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_airtowater, null, false, component);
    }

    public static FragmentAirtowaterBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentAirtowaterBinding bind(View view, Object component) {
        return (FragmentAirtowaterBinding) bind(component, view, R.layout.fragment_airtowater);
    }
}
