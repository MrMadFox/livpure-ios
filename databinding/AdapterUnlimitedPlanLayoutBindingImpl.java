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
import com.livpure.safedrink.subscription.payment.adapter.UnlimitedPlanAdapter;
import com.livpure.safedrink.subscription.plan.data.model.plan.PlansItem;
/* loaded from: classes3.dex */
public class AdapterUnlimitedPlanLayoutBindingImpl extends AdapterUnlimitedPlanLayoutBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback6;
    private long mDirtyFlags;
    private final AppCompatTextView mboundView2;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.radioPlanId, 3);
        sparseIntArray.put(R.id.lytItemExpandable, 4);
        sparseIntArray.put(R.id.listPlanValidityId, 5);
        sparseIntArray.put(R.id.additionalUsage, 6);
        sparseIntArray.put(R.id.btnRenewPlanId, 7);
    }

    public AdapterUnlimitedPlanLayoutBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 8, sIncludes, sViewsWithIds));
    }

    private AdapterUnlimitedPlanLayoutBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (TextView) bindings[6], (MaterialButton) bindings[7], (RecyclerView) bindings[5], (LinearLayout) bindings[4], (LinearLayout) bindings[1], (LinearLayout) bindings[0], (ImageView) bindings[3]);
        this.mDirtyFlags = -1L;
        this.lytSimpleItem.setTag(null);
        this.lytValidityId.setTag(null);
        AppCompatTextView appCompatTextView = (AppCompatTextView) bindings[2];
        this.mboundView2 = appCompatTextView;
        appCompatTextView.setTag(null);
        setRootTag(root);
        this.mCallback6 = new OnClickListener(this, 1);
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
            setCallBack((UnlimitedPlanAdapter) variable);
        }
        return true;
    }

    @Override // com.livpure.safedrink.databinding.AdapterUnlimitedPlanLayoutBinding
    public void setPosition(Integer Position) {
        this.mPosition = Position;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(13);
        super.requestRebind();
    }

    @Override // com.livpure.safedrink.databinding.AdapterUnlimitedPlanLayoutBinding
    public void setPlan(PlansItem Plan) {
        this.mPlan = Plan;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // com.livpure.safedrink.databinding.AdapterUnlimitedPlanLayoutBinding
    public void setCallBack(UnlimitedPlanAdapter CallBack) {
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
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        String str = null;
        Integer num = this.mPosition;
        PlansItem plansItem = this.mPlan;
        UnlimitedPlanAdapter unlimitedPlanAdapter = this.mCallBack;
        int i = ((10 & j) > 0L ? 1 : ((10 & j) == 0L ? 0 : -1));
        if (i != 0 && plansItem != null) {
            str = plansItem.getPricePerMonth();
        }
        if ((j & 8) != 0) {
            this.lytSimpleItem.setOnClickListener(this.mCallback6);
        }
        if (i != 0) {
            TextViewBindingAdapter.setText(this.mboundView2, str);
        }
    }

    @Override // com.livpure.safedrink.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        Integer num = this.mPosition;
        UnlimitedPlanAdapter unlimitedPlanAdapter = this.mCallBack;
        if (unlimitedPlanAdapter != null) {
            unlimitedPlanAdapter.onParentItemClick(callbackArg_0, num.intValue());
        }
    }
}
