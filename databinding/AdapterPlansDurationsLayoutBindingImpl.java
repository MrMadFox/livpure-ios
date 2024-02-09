package com.livpure.safedrink.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.livpure.safedrink.R;
import com.livpure.safedrink.subscription.payment.adapter.PlansDurationsAdapter;
import com.livpure.safedrink.subscription.payment.viewmodel.PlanDurationModel;
import com.livpure.safedrink.subscription.plan.data.model.plan.PriceItem;
/* loaded from: classes3.dex */
public class AdapterPlansDurationsLayoutBindingImpl extends AdapterPlansDurationsLayoutBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.radioPlanId, 2);
        sparseIntArray.put(R.id.layout_month, 3);
        sparseIntArray.put(R.id.textRsPlan, 4);
        sparseIntArray.put(R.id.textMonth, 5);
        sparseIntArray.put(R.id.view_plan, 6);
        sparseIntArray.put(R.id.lytSimpleItem, 7);
        sparseIntArray.put(R.id.text_validity, 8);
        sparseIntArray.put(R.id.textTotalMonth, 9);
        sparseIntArray.put(R.id.viewDivide, 10);
        sparseIntArray.put(R.id.textTotalAmount, 11);
        sparseIntArray.put(R.id.textAmountRs, 12);
        sparseIntArray.put(R.id.textDiscount, 13);
        sparseIntArray.put(R.id.textSaveAmount, 14);
    }

    public AdapterPlansDurationsLayoutBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 15, sIncludes, sViewsWithIds));
    }

    private AdapterPlansDurationsLayoutBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (LinearLayout) bindings[3], (LinearLayout) bindings[7], (RelativeLayout) bindings[0], (ImageView) bindings[2], (AppCompatTextView) bindings[12], (AppCompatTextView) bindings[13], (AppCompatTextView) bindings[5], (TextView) bindings[1], (AppCompatTextView) bindings[4], (AppCompatTextView) bindings[14], (AppCompatTextView) bindings[11], (AppCompatTextView) bindings[9], (AppCompatTextView) bindings[8], (View) bindings[10], (View) bindings[6]);
        this.mDirtyFlags = -1L;
        this.lytValidityId.setTag(null);
        this.textPopular.setTag(null);
        setRootTag(root);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 16L;
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
        if (13 == variableId) {
            setPosition((Integer) variable);
        } else if (4 == variableId) {
            setDuration((PriceItem) variable);
        } else if (18 == variableId) {
            setViewModel((PlanDurationModel) variable);
        } else if (2 != variableId) {
            return false;
        } else {
            setCallBack((PlansDurationsAdapter) variable);
        }
        return true;
    }

    @Override // com.livpure.safedrink.databinding.AdapterPlansDurationsLayoutBinding
    public void setPosition(Integer Position) {
        this.mPosition = Position;
    }

    @Override // com.livpure.safedrink.databinding.AdapterPlansDurationsLayoutBinding
    public void setDuration(PriceItem Duration) {
        this.mDuration = Duration;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(4);
        super.requestRebind();
    }

    @Override // com.livpure.safedrink.databinding.AdapterPlansDurationsLayoutBinding
    public void setViewModel(PlanDurationModel ViewModel) {
        this.mViewModel = ViewModel;
    }

    @Override // com.livpure.safedrink.databinding.AdapterPlansDurationsLayoutBinding
    public void setCallBack(PlansDurationsAdapter CallBack) {
        this.mCallBack = CallBack;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        PriceItem priceItem = this.mDuration;
        int i = 0;
        int i2 = ((j & 18) > 0L ? 1 : ((j & 18) == 0L ? 0 : -1));
        if (i2 != 0) {
            boolean safeUnbox = ViewDataBinding.safeUnbox(priceItem != null ? priceItem.getBestValue() : null);
            if (i2 != 0) {
                j |= safeUnbox ? 64L : 32L;
            }
            if (!safeUnbox) {
                i = 8;
            }
        }
        if ((j & 18) != 0) {
            this.textPopular.setVisibility(i);
        }
    }
}
