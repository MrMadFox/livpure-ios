package com.livpure.safedrink.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.livpure.safedrink.R;
import com.livpure.safedrink.subscription.plan.data.model.payment.PlanItem;
/* loaded from: classes3.dex */
public abstract class ViewPlanBinding extends ViewDataBinding {
    public final TextView additionalUsage;
    public final Chip chip12Months;
    public final Chip chip1Month;
    public final Chip chip6Months;
    public final ChipGroup durationGroup;
    public final TextView durationLabel;
    public final ImageView imageView;
    public final MaterialCardView innerCard;
    public final TextView litresPerMonth;
    public final TextView litresPerMonthLabel;
    @Bindable
    protected PlanItem mPlan;
    public final MaterialCardView planCard;
    public final TextView price;
    public final Button subscribeButton;

    public abstract void setPlan(PlanItem plan);

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewPlanBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView additionalUsage, Chip chip12Months, Chip chip1Month, Chip chip6Months, ChipGroup durationGroup, TextView durationLabel, ImageView imageView, MaterialCardView innerCard, TextView litresPerMonth, TextView litresPerMonthLabel, MaterialCardView planCard, TextView price, Button subscribeButton) {
        super(_bindingComponent, _root, _localFieldCount);
        this.additionalUsage = additionalUsage;
        this.chip12Months = chip12Months;
        this.chip1Month = chip1Month;
        this.chip6Months = chip6Months;
        this.durationGroup = durationGroup;
        this.durationLabel = durationLabel;
        this.imageView = imageView;
        this.innerCard = innerCard;
        this.litresPerMonth = litresPerMonth;
        this.litresPerMonthLabel = litresPerMonthLabel;
        this.planCard = planCard;
        this.price = price;
        this.subscribeButton = subscribeButton;
    }

    public PlanItem getPlan() {
        return this.mPlan;
    }

    public static ViewPlanBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewPlanBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (ViewPlanBinding) ViewDataBinding.inflateInternal(inflater, R.layout.view_plan, root, attachToRoot, component);
    }

    public static ViewPlanBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewPlanBinding inflate(LayoutInflater inflater, Object component) {
        return (ViewPlanBinding) ViewDataBinding.inflateInternal(inflater, R.layout.view_plan, null, false, component);
    }

    public static ViewPlanBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewPlanBinding bind(View view, Object component) {
        return (ViewPlanBinding) bind(component, view, R.layout.view_plan);
    }
}
