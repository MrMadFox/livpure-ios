package com.livpure.safedrink.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.livpure.safedrink.R;
/* loaded from: classes3.dex */
public class FragmentEmailMobileVerifyBindingImpl extends FragmentEmailMobileVerifyBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ScrollView mboundView0;

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
        sparseIntArray.put(R.id.textEmailMobile, 1);
        sparseIntArray.put(R.id.editEmailMobile, 2);
        sparseIntArray.put(R.id.layoutVerify, 3);
        sparseIntArray.put(R.id.editTextNumber, 4);
        sparseIntArray.put(R.id.editTextNumber2, 5);
        sparseIntArray.put(R.id.editTextNumber3, 6);
        sparseIntArray.put(R.id.editTextNumber4, 7);
        sparseIntArray.put(R.id.textTimer, 8);
        sparseIntArray.put(R.id.btnResend, 9);
        sparseIntArray.put(R.id.btnSubmit, 10);
        sparseIntArray.put(R.id.btnVerify, 11);
    }

    public FragmentEmailMobileVerifyBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 12, sIncludes, sViewsWithIds));
    }

    private FragmentEmailMobileVerifyBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (TextView) bindings[9], (TextView) bindings[10], (TextView) bindings[11], (EditText) bindings[2], (EditText) bindings[4], (EditText) bindings[5], (EditText) bindings[6], (EditText) bindings[7], (LinearLayout) bindings[3], (TextView) bindings[1], (TextView) bindings[8]);
        this.mDirtyFlags = -1L;
        ScrollView scrollView = (ScrollView) bindings[0];
        this.mboundView0 = scrollView;
        scrollView.setTag(null);
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
