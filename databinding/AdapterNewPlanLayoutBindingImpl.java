package com.livpure.safedrink.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.livpure.safedrink.R;
import com.livpure.safedrink.serviceRequest.data.model.NewPlanList;
import com.livpure.safedrink.serviceRequest.model.RelocationModel;
/* loaded from: classes3.dex */
public class AdapterNewPlanLayoutBindingImpl extends AdapterNewPlanLayoutBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final RelativeLayout mboundView0;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.lytValidityId, 1);
        sparseIntArray.put(R.id.textTotalMonth, 2);
        sparseIntArray.put(R.id.layout_month, 3);
        sparseIntArray.put(R.id.textRsPlan, 4);
        sparseIntArray.put(R.id.textMonth, 5);
        sparseIntArray.put(R.id.text_popular, 6);
    }

    public AdapterNewPlanLayoutBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 7, sIncludes, sViewsWithIds));
    }

    private AdapterNewPlanLayoutBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (LinearLayout) bindings[3], (RelativeLayout) bindings[1], (AppCompatTextView) bindings[5], (TextView) bindings[6], (AppCompatTextView) bindings[4], (AppCompatTextView) bindings[2]);
        this.mDirtyFlags = -1L;
        RelativeLayout relativeLayout = (RelativeLayout) bindings[0];
        this.mboundView0 = relativeLayout;
        relativeLayout.setTag(null);
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
        } else if (18 == variableId) {
            setViewModel((RelocationModel) variable);
        } else if (4 != variableId) {
            return false;
        } else {
            setDuration((NewPlanList) variable);
        }
        return true;
    }

    @Override // com.livpure.safedrink.databinding.AdapterNewPlanLayoutBinding
    public void setPosition(Integer Position) {
        this.mPosition = Position;
    }

    @Override // com.livpure.safedrink.databinding.AdapterNewPlanLayoutBinding
    public void setViewModel(RelocationModel ViewModel) {
        this.mViewModel = ViewModel;
    }

    @Override // com.livpure.safedrink.databinding.AdapterNewPlanLayoutBinding
    public void setDuration(NewPlanList Duration) {
        this.mDuration = Duration;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}
