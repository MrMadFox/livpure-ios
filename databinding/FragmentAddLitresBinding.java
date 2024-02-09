package com.livpure.safedrink.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.textfield.TextInputEditText;
import com.livpure.safedrink.R;
import com.livpure.safedrink.subscription.payment.viewmodel.AddLitresViewModel;
/* loaded from: classes3.dex */
public abstract class FragmentAddLitresBinding extends ViewDataBinding {
    public final ConstraintLayout homeContainer;
    public final TextInputEditText litresEditText;
    public final TextView litresLabel;
    public final LinearLayout llRecommendation;
    public final LinearLayout llUpgradePlan;
    public final ProgressBar loader;
    @Bindable
    protected AddLitresViewModel mViewModel;
    public final TextView message;
    public final Button paymentButton;
    public final TextView rateLabel;
    public final LinearLayout removeWater;
    public final LinearLayout seeAllPlans;
    public final TextView tvPlanLitres;
    public final TextView tvPlanName;
    public final TextView tvplanAmount;
    public final Button upgradeNowButton;
    public final LinearLayout waterAdd;

    public abstract void setViewModel(AddLitresViewModel viewModel);

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentAddLitresBinding(Object _bindingComponent, View _root, int _localFieldCount, ConstraintLayout homeContainer, TextInputEditText litresEditText, TextView litresLabel, LinearLayout llRecommendation, LinearLayout llUpgradePlan, ProgressBar loader, TextView message, Button paymentButton, TextView rateLabel, LinearLayout removeWater, LinearLayout seeAllPlans, TextView tvPlanLitres, TextView tvPlanName, TextView tvplanAmount, Button upgradeNowButton, LinearLayout waterAdd) {
        super(_bindingComponent, _root, _localFieldCount);
        this.homeContainer = homeContainer;
        this.litresEditText = litresEditText;
        this.litresLabel = litresLabel;
        this.llRecommendation = llRecommendation;
        this.llUpgradePlan = llUpgradePlan;
        this.loader = loader;
        this.message = message;
        this.paymentButton = paymentButton;
        this.rateLabel = rateLabel;
        this.removeWater = removeWater;
        this.seeAllPlans = seeAllPlans;
        this.tvPlanLitres = tvPlanLitres;
        this.tvPlanName = tvPlanName;
        this.tvplanAmount = tvplanAmount;
        this.upgradeNowButton = upgradeNowButton;
        this.waterAdd = waterAdd;
    }

    public AddLitresViewModel getViewModel() {
        return this.mViewModel;
    }

    public static FragmentAddLitresBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentAddLitresBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentAddLitresBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_add_litres, root, attachToRoot, component);
    }

    public static FragmentAddLitresBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentAddLitresBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentAddLitresBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_add_litres, null, false, component);
    }

    public static FragmentAddLitresBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentAddLitresBinding bind(View view, Object component) {
        return (FragmentAddLitresBinding) bind(component, view, R.layout.fragment_add_litres);
    }
}
