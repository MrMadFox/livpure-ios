package com.livpure.safedrink.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.textfield.TextInputLayout;
import com.livpure.safedrink.R;
import com.livpure.safedrink.serviceRequest.model.KycUploadModel;
/* loaded from: classes3.dex */
public class FragmentKYCUploadBindingImpl extends FragmentKYCUploadBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final NestedScrollView mboundView0;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.addressProofLayout, 1);
        sparseIntArray.put(R.id.addressProofCompleteTextView, 2);
        sparseIntArray.put(R.id.checkInstall, 3);
        sparseIntArray.put(R.id.uploadFrontPhoto, 4);
        sparseIntArray.put(R.id.imageViewFront, 5);
        sparseIntArray.put(R.id.frontName, 6);
        sparseIntArray.put(R.id.uploadBackPhoto, 7);
        sparseIntArray.put(R.id.imageViewBack, 8);
        sparseIntArray.put(R.id.backName, 9);
        sparseIntArray.put(R.id.btnUploadDocument, 10);
    }

    public FragmentKYCUploadBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 11, sIncludes, sViewsWithIds));
    }

    private FragmentKYCUploadBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (AutoCompleteTextView) bindings[2], (TextInputLayout) bindings[1], (TextView) bindings[9], (Button) bindings[10], (CheckBox) bindings[3], (TextView) bindings[6], (ImageView) bindings[8], (ImageView) bindings[5], (LinearLayout) bindings[7], (LinearLayout) bindings[4]);
        this.mDirtyFlags = -1L;
        NestedScrollView nestedScrollView = (NestedScrollView) bindings[0];
        this.mboundView0 = nestedScrollView;
        nestedScrollView.setTag(null);
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
        if (18 == variableId) {
            setViewModel((KycUploadModel) variable);
            return true;
        }
        return false;
    }

    @Override // com.livpure.safedrink.databinding.FragmentKYCUploadBinding
    public void setViewModel(KycUploadModel ViewModel) {
        this.mViewModel = ViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}
