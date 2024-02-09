package com.livpure.safedrink.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.livpure.safedrink.R;
import com.livpure.safedrink.serviceRequest.model.ServiceRequestHistoryModel;
/* loaded from: classes3.dex */
public class FragmentServiceRequestHistoryBindingImpl extends FragmentServiceRequestHistoryBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final FrameLayout mboundView0;
    private final ProgressBar mboundView1;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.jobSheet, 2);
        sparseIntArray.put(R.id.assign_to, 3);
        sparseIntArray.put(R.id.job_status, 4);
        sparseIntArray.put(R.id.listHistory, 5);
    }

    public FragmentServiceRequestHistoryBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 6, sIncludes, sViewsWithIds));
    }

    private FragmentServiceRequestHistoryBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1, (TextView) bindings[3], (TextView) bindings[2], (TextView) bindings[4], (RecyclerView) bindings[5]);
        this.mDirtyFlags = -1L;
        FrameLayout frameLayout = (FrameLayout) bindings[0];
        this.mboundView0 = frameLayout;
        frameLayout.setTag(null);
        ProgressBar progressBar = (ProgressBar) bindings[1];
        this.mboundView1 = progressBar;
        progressBar.setTag(null);
        setRootTag(root);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 4L;
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
            setViewModel((ServiceRequestHistoryModel) variable);
            return true;
        }
        return false;
    }

    @Override // com.livpure.safedrink.databinding.FragmentServiceRequestHistoryBinding
    public void setViewModel(ServiceRequestHistoryModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(18);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId != 0) {
            return false;
        }
        return onChangeViewModelLoading((MutableLiveData) object, fieldId);
    }

    private boolean onChangeViewModelLoading(MutableLiveData<Boolean> ViewModelLoading, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        }
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        ServiceRequestHistoryModel serviceRequestHistoryModel = this.mViewModel;
        int i = 0;
        int i2 = ((j & 7) > 0L ? 1 : ((j & 7) == 0L ? 0 : -1));
        if (i2 != 0) {
            MutableLiveData<Boolean> loading = serviceRequestHistoryModel != null ? serviceRequestHistoryModel.getLoading() : null;
            updateLiveDataRegistration(0, loading);
            boolean safeUnbox = ViewDataBinding.safeUnbox(loading != null ? loading.getValue() : null);
            if (i2 != 0) {
                j |= safeUnbox ? 16L : 8L;
            }
            if (!safeUnbox) {
                i = 8;
            }
        }
        if ((j & 7) != 0) {
            this.mboundView1.setVisibility(i);
        }
    }
}
