package com.livpure.safedrink.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.livpure.safedrink.R;
import com.livpure.safedrink.subscription.payment.adapter.PlanDurationsAdapter;
import com.livpure.safedrink.subscription.plan.data.model.plan.PriceItem;
/* loaded from: classes3.dex */
public class AdapterPlanDurationsLayoutBindingImpl extends AdapterPlanDurationsLayoutBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final FrameLayout mboundView0;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.lytValidityId, 4);
        sparseIntArray.put(R.id.imgPlanId, 5);
        sparseIntArray.put(R.id.txtPlanMonthId, 6);
        sparseIntArray.put(R.id.txtBestValueId, 7);
    }

    public AdapterPlanDurationsLayoutBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 8, sIncludes, sViewsWithIds));
    }

    private AdapterPlanDurationsLayoutBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (ImageView) bindings[5], (LinearLayout) bindings[4], (TextView) bindings[7], (AppCompatTextView) bindings[3], (AppCompatTextView) bindings[1], (AppCompatTextView) bindings[6], (AppCompatTextView) bindings[2]);
        this.mDirtyFlags = -1L;
        FrameLayout frameLayout = (FrameLayout) bindings[0];
        this.mboundView0 = frameLayout;
        frameLayout.setTag(null);
        this.txtPlanAmountId.setTag(null);
        this.txtPlanDurationId.setTag(null);
        this.txtSaving.setTag(null);
        setRootTag(root);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 8L;
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
        } else if (2 != variableId) {
            return false;
        } else {
            setCallBack((PlanDurationsAdapter) variable);
        }
        return true;
    }

    @Override // com.livpure.safedrink.databinding.AdapterPlanDurationsLayoutBinding
    public void setPosition(Integer Position) {
        this.mPosition = Position;
    }

    @Override // com.livpure.safedrink.databinding.AdapterPlanDurationsLayoutBinding
    public void setDuration(PriceItem Duration) {
        this.mDuration = Duration;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(4);
        super.requestRebind();
    }

    @Override // com.livpure.safedrink.databinding.AdapterPlanDurationsLayoutBinding
    public void setCallBack(PlanDurationsAdapter CallBack) {
        this.mCallBack = CallBack;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        String str2;
        String str3;
        String str4;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        PriceItem priceItem = this.mDuration;
        String str5 = null;
        int i = ((j & 10) > 0L ? 1 : ((j & 10) == 0L ? 0 : -1));
        if (i != 0) {
            if (priceItem != null) {
                str5 = priceItem.getSaveMessage();
                str4 = priceItem.getDuration();
                str3 = priceItem.getPricePerMonth();
            } else {
                str3 = null;
                str4 = null;
            }
            boolean z = str5 != null;
            str2 = str4 + " month";
            String str6 = this.txtPlanAmountId.getResources().getString(R.string.rupee_symbol) + " " + str3;
            if (i != 0) {
                j |= z ? 32L : 16L;
            }
            r10 = z ? 0 : 4;
            String str7 = str5;
            str5 = str6;
            str = str7;
        } else {
            str = null;
            str2 = null;
        }
        if ((j & 10) != 0) {
            TextViewBindingAdapter.setText(this.txtPlanAmountId, str5);
            TextViewBindingAdapter.setText(this.txtPlanDurationId, str2);
            TextViewBindingAdapter.setText(this.txtSaving, str);
            this.txtSaving.setVisibility(r10);
        }
    }
}
