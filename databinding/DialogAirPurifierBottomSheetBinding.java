package com.livpure.safedrink.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.github.mikephil.charting.charts.LineChart;
import com.livpure.safedrink.R;
/* loaded from: classes3.dex */
public abstract class DialogAirPurifierBottomSheetBinding extends ViewDataBinding {
    public final LineChart airPurifierLineChart;
    public final ConstraintLayout bottomSheet;
    public final ImageView imgStatusId;
    public final LinearLayout llDaily;
    public final LinearLayout llMonthly;
    public final LinearLayout llWeekly;
    public final TextView tvDaily;
    public final TextView tvMonthly;
    public final TextView tvSelectionType;
    public final TextView tvWeekly;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogAirPurifierBottomSheetBinding(Object _bindingComponent, View _root, int _localFieldCount, LineChart airPurifierLineChart, ConstraintLayout bottomSheet, ImageView imgStatusId, LinearLayout llDaily, LinearLayout llMonthly, LinearLayout llWeekly, TextView tvDaily, TextView tvMonthly, TextView tvSelectionType, TextView tvWeekly) {
        super(_bindingComponent, _root, _localFieldCount);
        this.airPurifierLineChart = airPurifierLineChart;
        this.bottomSheet = bottomSheet;
        this.imgStatusId = imgStatusId;
        this.llDaily = llDaily;
        this.llMonthly = llMonthly;
        this.llWeekly = llWeekly;
        this.tvDaily = tvDaily;
        this.tvMonthly = tvMonthly;
        this.tvSelectionType = tvSelectionType;
        this.tvWeekly = tvWeekly;
    }

    public static DialogAirPurifierBottomSheetBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogAirPurifierBottomSheetBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (DialogAirPurifierBottomSheetBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_air_purifier_bottom_sheet, root, attachToRoot, component);
    }

    public static DialogAirPurifierBottomSheetBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogAirPurifierBottomSheetBinding inflate(LayoutInflater inflater, Object component) {
        return (DialogAirPurifierBottomSheetBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_air_purifier_bottom_sheet, null, false, component);
    }

    public static DialogAirPurifierBottomSheetBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogAirPurifierBottomSheetBinding bind(View view, Object component) {
        return (DialogAirPurifierBottomSheetBinding) bind(component, view, R.layout.dialog_air_purifier_bottom_sheet);
    }
}
