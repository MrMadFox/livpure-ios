package com.livpure.safedrink.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.livpure.safedrink.R;
import com.livpure.safedrink.airpurifier.model.HomePurifierModel;
/* loaded from: classes3.dex */
public abstract class FragmentHomeAirpurifierBinding extends ViewDataBinding {
    public final TextView addAir;
    public final ImageView bleInfoIV;
    public final LinearLayout closeOutdoor;
    public final DialogAirPurifierBottomSheetBinding includeBottomSheetId;
    public final ImageView ivFanImage;
    public final ImageView ivIonsImage;
    public final ImageView ivLockImage;
    public final ImageView ivModeImage;
    public final ImageView ivPowerOnImage;
    public final ImageView ivTimerImage;
    public final RecyclerView listBottomOptionId;
    public final LinearLayout lytFanId;
    public final LinearLayout lytIonsId;
    public final LinearLayout lytLockId;
    public final LinearLayout lytModeId;
    public final LinearLayout lytOnId;
    public final ScrollView lytParentScrollView;
    public final LinearLayout lytTimerId;
    @Bindable
    protected HomePurifierModel mViewModel;
    public final LinearLayout openOutdoor;
    public final TextView renewPlan;
    public final ImageView settingsIV;
    public final SwipeRefreshLayout swipeRefreshLayoutComments;
    public final ImageView waterUsageImage;
    public final ImageView wifiInfoIV;

    public abstract void setViewModel(HomePurifierModel viewModel);

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentHomeAirpurifierBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView addAir, ImageView bleInfoIV, LinearLayout closeOutdoor, DialogAirPurifierBottomSheetBinding includeBottomSheetId, ImageView ivFanImage, ImageView ivIonsImage, ImageView ivLockImage, ImageView ivModeImage, ImageView ivPowerOnImage, ImageView ivTimerImage, RecyclerView listBottomOptionId, LinearLayout lytFanId, LinearLayout lytIonsId, LinearLayout lytLockId, LinearLayout lytModeId, LinearLayout lytOnId, ScrollView lytParentScrollView, LinearLayout lytTimerId, LinearLayout openOutdoor, TextView renewPlan, ImageView settingsIV, SwipeRefreshLayout swipeRefreshLayoutComments, ImageView waterUsageImage, ImageView wifiInfoIV) {
        super(_bindingComponent, _root, _localFieldCount);
        this.addAir = addAir;
        this.bleInfoIV = bleInfoIV;
        this.closeOutdoor = closeOutdoor;
        this.includeBottomSheetId = includeBottomSheetId;
        this.ivFanImage = ivFanImage;
        this.ivIonsImage = ivIonsImage;
        this.ivLockImage = ivLockImage;
        this.ivModeImage = ivModeImage;
        this.ivPowerOnImage = ivPowerOnImage;
        this.ivTimerImage = ivTimerImage;
        this.listBottomOptionId = listBottomOptionId;
        this.lytFanId = lytFanId;
        this.lytIonsId = lytIonsId;
        this.lytLockId = lytLockId;
        this.lytModeId = lytModeId;
        this.lytOnId = lytOnId;
        this.lytParentScrollView = lytParentScrollView;
        this.lytTimerId = lytTimerId;
        this.openOutdoor = openOutdoor;
        this.renewPlan = renewPlan;
        this.settingsIV = settingsIV;
        this.swipeRefreshLayoutComments = swipeRefreshLayoutComments;
        this.waterUsageImage = waterUsageImage;
        this.wifiInfoIV = wifiInfoIV;
    }

    public HomePurifierModel getViewModel() {
        return this.mViewModel;
    }

    public static FragmentHomeAirpurifierBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentHomeAirpurifierBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentHomeAirpurifierBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_home_airpurifier, root, attachToRoot, component);
    }

    public static FragmentHomeAirpurifierBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentHomeAirpurifierBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentHomeAirpurifierBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_home_airpurifier, null, false, component);
    }

    public static FragmentHomeAirpurifierBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentHomeAirpurifierBinding bind(View view, Object component) {
        return (FragmentHomeAirpurifierBinding) bind(component, view, R.layout.fragment_home_airpurifier);
    }
}
