package com.livpure.safedrink.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.livpure.safedrink.R;
import com.livpure.safedrink.subscription.plan.data.model.payment.PlanItem;
/* loaded from: classes3.dex */
public class ViewPlanBindingImpl extends ViewPlanBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.planCard, 3);
        sparseIntArray.put(R.id.imageView, 4);
        sparseIntArray.put(R.id.innerCard, 5);
        sparseIntArray.put(R.id.litresPerMonthLabel, 6);
        sparseIntArray.put(R.id.durationLabel, 7);
        sparseIntArray.put(R.id.durationGroup, 8);
        sparseIntArray.put(R.id.chip_1_month, 9);
        sparseIntArray.put(R.id.chip_6_months, 10);
        sparseIntArray.put(R.id.chip_12_months, 11);
        sparseIntArray.put(R.id.price, 12);
        sparseIntArray.put(R.id.subscribeButton, 13);
    }

    public ViewPlanBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 14, sIncludes, sViewsWithIds));
    }

    private ViewPlanBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (TextView) bindings[2], (Chip) bindings[11], (Chip) bindings[9], (Chip) bindings[10], (ChipGroup) bindings[8], (TextView) bindings[7], (ImageView) bindings[4], (MaterialCardView) bindings[5], (TextView) bindings[1], (TextView) bindings[6], (MaterialCardView) bindings[3], (TextView) bindings[12], (Button) bindings[13]);
        this.mDirtyFlags = -1L;
        this.additionalUsage.setTag(null);
        this.litresPerMonth.setTag(null);
        LinearLayout linearLayout = (LinearLayout) bindings[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
        setRootTag(root);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.mDirtyFlags != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int variableId, Object variable) {
        if (10 == variableId) {
            setPlan((PlanItem) variable);
            return true;
        }
        return false;
    }

    @Override // com.livpure.safedrink.databinding.ViewPlanBinding
    public void setPlan(PlanItem Plan) {
        this.mPlan = Plan;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        int i;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        PlanItem planItem = this.mPlan;
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        String str2 = null;
        int i2 = ((j & 3) > 0L ? 1 : ((j & 3) == 0L ? 0 : -1));
        if (i2 != 0) {
            if (planItem != null) {
                i = planItem.getLitresPerMonth();
                d = planItem.getAdditionalUsagePerLitre();
            } else {
                i = 0;
            }
            String num = Integer.toString(i);
            str2 = String.format(this.additionalUsage.getResources().getString(R.string.additional_usage_label), Double.valueOf(d));
            str = num;
        } else {
            str = null;
        }
        if (i2 != 0) {
            TextViewBindingAdapter.setText(this.additionalUsage, str2);
            TextViewBindingAdapter.setText(this.litresPerMonth, str);
        }
    }
}
