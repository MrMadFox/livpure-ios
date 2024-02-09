package com.livpure.safedrink.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.livpure.safedrink.R;
import com.livpure.safedrink.subscription.plan.data.model.plan.PlansItem;
/* loaded from: classes3.dex */
public class FragmentPlanBindingImpl extends FragmentPlanBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final NestedScrollView mboundView0;
    private final TextView mboundView1;
    private final TextView mboundView2;
    private final TextView mboundView3;
    private final TextView mboundView4;
    private final TextView mboundView5;
    private final TextView mboundView6;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.listPlanPriceId, 7);
        sparseIntArray.put(R.id.lytRefundStatusId, 8);
        sparseIntArray.put(R.id.imgRefundStatusId, 9);
        sparseIntArray.put(R.id.lytExtraInfoId, 10);
        sparseIntArray.put(R.id.lytProceedToPayId, 11);
        sparseIntArray.put(R.id.tvBilledStatus, 12);
    }

    public FragmentPlanBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 13, sIncludes, sViewsWithIds));
    }

    private FragmentPlanBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (ImageView) bindings[9], (RecyclerView) bindings[7], (LinearLayout) bindings[10], (LinearLayout) bindings[11], (RelativeLayout) bindings[8], (TextView) bindings[12]);
        this.mDirtyFlags = -1L;
        NestedScrollView nestedScrollView = (NestedScrollView) bindings[0];
        this.mboundView0 = nestedScrollView;
        nestedScrollView.setTag(null);
        TextView textView = (TextView) bindings[1];
        this.mboundView1 = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) bindings[2];
        this.mboundView2 = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) bindings[3];
        this.mboundView3 = textView3;
        textView3.setTag(null);
        TextView textView4 = (TextView) bindings[4];
        this.mboundView4 = textView4;
        textView4.setTag(null);
        TextView textView5 = (TextView) bindings[5];
        this.mboundView5 = textView5;
        textView5.setTag(null);
        TextView textView6 = (TextView) bindings[6];
        this.mboundView6 = textView6;
        textView6.setTag(null);
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
        if (11 == variableId) {
            setPlanItem((PlansItem) variable);
            return true;
        }
        return false;
    }

    @Override // com.livpure.safedrink.databinding.FragmentPlanBinding
    public void setPlanItem(PlansItem PlanItem) {
        this.mPlanItem = PlanItem;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(11);
        super.requestRebind();
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
        PlansItem plansItem = this.mPlanItem;
        String str5 = null;
        int i = ((3 & j) > 0L ? 1 : ((3 & j) == 0L ? 0 : -1));
        if (i != 0) {
            if (plansItem != null) {
                str5 = plansItem.getRateperliter();
                str4 = plansItem.getDepositAmount();
                str3 = plansItem.getLiters();
            } else {
                str3 = null;
                str4 = null;
            }
            String valueOf = String.valueOf(str5);
            String valueOf2 = String.valueOf(str4);
            str2 = ("Additional usage @ " + this.mboundView2.getResources().getString(R.string.rupee_symbol) + valueOf) + " / Litre";
            str5 = String.valueOf(str3);
            str = valueOf2;
        } else {
            str = null;
            str2 = null;
        }
        if (i != 0) {
            TextViewBindingAdapter.setText(this.mboundView1, str5);
            TextViewBindingAdapter.setText(this.mboundView2, str2);
            TextViewBindingAdapter.setText(this.mboundView3, str);
        }
        if ((j & 2) != 0) {
            TextViewBindingAdapter.setText(this.mboundView4, this.mboundView4.getResources().getString(R.string.rupee_symbol) + " 0");
            TextViewBindingAdapter.setText(this.mboundView5, this.mboundView5.getResources().getString(R.string.rupee_symbol) + " 0");
            TextViewBindingAdapter.setText(this.mboundView6, this.mboundView6.getResources().getString(R.string.rupee_symbol) + " 0");
        }
    }
}
