package com.livpure.safedrink.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.livpure.safedrink.R;
import com.livpure.safedrink.subscription.payment.adapter.RecommendedPlanAdapter;
import com.livpure.safedrink.subscription.plan.data.model.payment.PlanItem;
import com.livpure.safedrink.subscription.plan.data.model.payment.PriceMappingItem;
import java.util.List;
/* loaded from: classes3.dex */
public class AdapterRecommendedPlanLayoutBindingImpl extends AdapterRecommendedPlanLayoutBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final AppCompatTextView mboundView1;
    private final AppCompatTextView mboundView2;
    private final AppCompatTextView mboundView3;
    private final AppCompatTextView mboundView4;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.radioPlanId, 5);
    }

    public AdapterRecommendedPlanLayoutBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 6, sIncludes, sViewsWithIds));
    }

    private AdapterRecommendedPlanLayoutBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (LinearLayout) bindings[0], (RadioButton) bindings[5]);
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
        AppCompatTextView appCompatTextView4 = (AppCompatTextView) bindings[4];
        this.mboundView4 = appCompatTextView4;
        appCompatTextView4.setTag(null);
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
            setCallBack((RecommendedPlanAdapter) variable);
        }
        return true;
    }

    @Override // com.livpure.safedrink.databinding.AdapterRecommendedPlanLayoutBinding
    public void setPosition(Integer Position) {
        this.mPosition = Position;
    }

    @Override // com.livpure.safedrink.databinding.AdapterRecommendedPlanLayoutBinding
    public void setPlan(PlanItem Plan) {
        this.mPlan = Plan;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // com.livpure.safedrink.databinding.AdapterRecommendedPlanLayoutBinding
    public void setCallBack(RecommendedPlanAdapter CallBack) {
        this.mCallBack = CallBack;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        String str2;
        String str3;
        List<PriceMappingItem> list;
        String str4;
        int i;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        PlanItem planItem = this.mPlan;
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        int i2 = ((j & 10) > 0L ? 1 : ((j & 10) == 0L ? 0 : -1));
        if (i2 != 0) {
            if (planItem != null) {
                list = planItem.getPriceMapping();
                str4 = planItem.getName();
                d = planItem.getAdditionalUsagePerLitre();
                i = planItem.getLitresPerMonth();
            } else {
                list = null;
                str4 = null;
                i = 0;
            }
            PriceMappingItem priceMappingItem = list != null ? list.get(0) : null;
            String str5 = str4 + " Plan";
            String str6 = "Additional usage @ " + d;
            str3 = i + " ";
            r7 = priceMappingItem != null ? priceMappingItem.getPrice() : null;
            str2 = str6 + "/Litre";
            str = this.mboundView3.getResources().getString(R.string.rupee_symbol) + " " + r7;
            r7 = str5;
        } else {
            str = null;
            str2 = null;
            str3 = null;
        }
        if (i2 != 0) {
            TextViewBindingAdapter.setText(this.mboundView1, r7);
            TextViewBindingAdapter.setText(this.mboundView2, str3);
            TextViewBindingAdapter.setText(this.mboundView3, str);
            TextViewBindingAdapter.setText(this.mboundView4, str2);
        }
    }
}
