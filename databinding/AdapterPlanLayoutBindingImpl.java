package com.livpure.safedrink.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.livpure.safedrink.R;
import com.livpure.safedrink.subscription.payment.adapter.PlanAdapter;
import com.livpure.safedrink.subscription.plan.data.model.payment.PlanItem;
import com.livpure.safedrink.subscription.plan.data.model.payment.PriceMappingItem;
import java.util.List;
/* loaded from: classes3.dex */
public class AdapterPlanLayoutBindingImpl extends AdapterPlanLayoutBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final AppCompatTextView mboundView1;
    private final AppCompatTextView mboundView2;
    private final AppCompatTextView mboundView3;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.radioPlanId, 4);
    }

    public AdapterPlanLayoutBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 5, sIncludes, sViewsWithIds));
    }

    private AdapterPlanLayoutBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (LinearLayout) bindings[0], (RadioButton) bindings[4]);
        this.mDirtyFlags = -1L;
        this.lytValidityId.setTag(null);
        AppCompatTextView appCompatTextView = (AppCompatTextView) bindings[1];
        this.mboundView1 = appCompatTextView;
        appCompatTextView.setTag(null);
        AppCompatTextView appCompatTextView2 = (AppCompatTextView) bindings[2];
        this.mboundView2 = appCompatTextView2;
        appCompatTextView2.setTag(null);
        AppCompatTextView appCompatTextView3 = (AppCompatTextView) bindings[3];
        this.mboundView3 = appCompatTextView3;
        appCompatTextView3.setTag(null);
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
        } else if (10 == variableId) {
            setPlan((PlanItem) variable);
        } else if (2 != variableId) {
            return false;
        } else {
            setCallBack((PlanAdapter) variable);
        }
        return true;
    }

    @Override // com.livpure.safedrink.databinding.AdapterPlanLayoutBinding
    public void setPosition(Integer Position) {
        this.mPosition = Position;
    }

    @Override // com.livpure.safedrink.databinding.AdapterPlanLayoutBinding
    public void setPlan(PlanItem Plan) {
        this.mPlan = Plan;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // com.livpure.safedrink.databinding.AdapterPlanLayoutBinding
    public void setCallBack(PlanAdapter CallBack) {
        this.mCallBack = CallBack;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        String str2;
        List<PriceMappingItem> list;
        String str3;
        int i;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        PlanItem planItem = this.mPlan;
        int i2 = ((j & 10) > 0L ? 1 : ((j & 10) == 0L ? 0 : -1));
        if (i2 != 0) {
            if (planItem != null) {
                list = planItem.getPriceMapping();
                i = planItem.getLitresPerMonth();
                str3 = planItem.getName();
            } else {
                list = null;
                str3 = null;
                i = 0;
            }
            PriceMappingItem priceMappingItem = list != null ? list.get(0) : null;
            str2 = String.valueOf(i);
            String str4 = str3 + " Plan";
            str = this.mboundView2.getResources().getString(R.string.rupee_symbol) + " " + (priceMappingItem != null ? priceMappingItem.getPrice() : null);
            r5 = str4;
        } else {
            str = null;
            str2 = null;
        }
        if (i2 != 0) {
            TextViewBindingAdapter.setText(this.mboundView1, r5);
            TextViewBindingAdapter.setText(this.mboundView2, str);
            TextViewBindingAdapter.setText(this.mboundView3, str2);
        }
    }
}
