package com.livpure.safedrink.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import com.livpure.safedrink.R;
import com.livpure.safedrink.generated.callback.OnClickListener;
import com.livpure.safedrink.subscription.payment.adapter.ExpandablePlanAdapter;
import com.livpure.safedrink.subscription.plan.data.model.plan.PlansItem;
/* loaded from: classes3.dex */
public class AdapterExpandablePlanLayoutBindingImpl extends AdapterExpandablePlanLayoutBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback4;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.lytValidityId, 6);
        sparseIntArray.put(R.id.radioPlanId, 7);
        sparseIntArray.put(R.id.textLitreMonth, 8);
        sparseIntArray.put(R.id.lytItemExpandable, 9);
        sparseIntArray.put(R.id.listPlanValidityId, 10);
        sparseIntArray.put(R.id.additionalUsage, 11);
        sparseIntArray.put(R.id.btnRenewPlanId, 12);
    }

    public AdapterExpandablePlanLayoutBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 13, sIncludes, sViewsWithIds));
    }

    private AdapterExpandablePlanLayoutBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (TextView) bindings[11], (MaterialButton) bindings[12], (RecyclerView) bindings[10], (LinearLayout) bindings[9], (LinearLayout) bindings[1], (LinearLayout) bindings[6], (ImageView) bindings[7], (AppCompatTextView) bindings[5], (AppCompatTextView) bindings[3], (AppCompatTextView) bindings[8], (AppCompatTextView) bindings[2], (TextView) bindings[4]);
        this.mDirtyFlags = -1L;
        this.lytSimpleItem.setTag(null);
        LinearLayout linearLayout = (LinearLayout) bindings[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
        this.textAmount.setTag(null);
        this.textLitre.setTag(null);
        this.textPlanName.setTag(null);
        this.textPopular.setTag(null);
        setRootTag(root);
        this.mCallback4 = new OnClickListener(this, 1);
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
            setPlan((PlansItem) variable);
        } else if (2 != variableId) {
            return false;
        } else {
            setCallBack((ExpandablePlanAdapter) variable);
        }
        return true;
    }

    @Override // com.livpure.safedrink.databinding.AdapterExpandablePlanLayoutBinding
    public void setPosition(Integer Position) {
        this.mPosition = Position;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(13);
        super.requestRebind();
    }

    @Override // com.livpure.safedrink.databinding.AdapterExpandablePlanLayoutBinding
    public void setPlan(PlansItem Plan) {
        this.mPlan = Plan;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // com.livpure.safedrink.databinding.AdapterExpandablePlanLayoutBinding
    public void setCallBack(ExpandablePlanAdapter CallBack) {
        this.mCallBack = CallBack;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        String str2;
        Boolean bool;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        Integer num = this.mPosition;
        PlansItem plansItem = this.mPlan;
        ExpandablePlanAdapter expandablePlanAdapter = this.mCallBack;
        int i = 0;
        String str3 = null;
        int i2 = ((j & 10) > 0L ? 1 : ((j & 10) == 0L ? 0 : -1));
        if (i2 != 0) {
            if (plansItem != null) {
                str3 = plansItem.getPricePerMonth();
                bool = plansItem.getPopular();
                str2 = plansItem.getLiters();
                str = plansItem.getPlanName();
            } else {
                str = null;
                bool = null;
                str2 = null;
            }
            str3 = this.textAmount.getResources().getString(R.string.rupee_symbol) + str3;
            boolean safeUnbox = ViewDataBinding.safeUnbox(bool);
            if (i2 != 0) {
                j |= safeUnbox ? 32L : 16L;
            }
            if (!safeUnbox) {
                i = 8;
            }
        } else {
            str = null;
            str2 = null;
        }
        if ((8 & j) != 0) {
            this.lytSimpleItem.setOnClickListener(this.mCallback4);
        }
        if ((j & 10) != 0) {
            TextViewBindingAdapter.setText(this.textAmount, str3);
            TextViewBindingAdapter.setText(this.textLitre, str2);
            TextViewBindingAdapter.setText(this.textPlanName, str);
            this.textPopular.setVisibility(i);
        }
    }

    @Override // com.livpure.safedrink.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        Integer num = this.mPosition;
        ExpandablePlanAdapter expandablePlanAdapter = this.mCallBack;
        if (expandablePlanAdapter != null) {
            expandablePlanAdapter.onParentItemClick(num.intValue());
        }
    }
}
