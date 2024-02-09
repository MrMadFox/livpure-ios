package com.livpure.safedrink.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.github.mikephil.charting.charts.LineChart;
import com.livpure.safedrink.R;
/* loaded from: classes3.dex */
public class DialogAirPurifierBottomSheetBindingImpl extends DialogAirPurifierBottomSheetBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int variableId, Object variable) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.imgStatusId, 1);
        sparseIntArray.put(R.id.llDaily, 2);
        sparseIntArray.put(R.id.tvDaily, 3);
        sparseIntArray.put(R.id.llWeekly, 4);
        sparseIntArray.put(R.id.tvWeekly, 5);
        sparseIntArray.put(R.id.llMonthly, 6);
        sparseIntArray.put(R.id.tvMonthly, 7);
        sparseIntArray.put(R.id.tvSelectionType, 8);
        sparseIntArray.put(R.id.airPurifierLineChart, 9);
    }

    public DialogAirPurifierBottomSheetBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 10, sIncludes, sViewsWithIds));
    }

    private DialogAirPurifierBottomSheetBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (LineChart) bindings[9], (ConstraintLayout) bindings[0], (ImageView) bindings[1], (LinearLayout) bindings[2], (LinearLayout) bindings[6], (LinearLayout) bindings[4], (TextView) bindings[3], (TextView) bindings[7], (TextView) bindings[8], (TextView) bindings[5]);
        this.mDirtyFlags = -1L;
        this.bottomSheet.setTag(null);
        setRootTag(root);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 1L;
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
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}
