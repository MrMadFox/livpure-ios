package com.livpure.safedrink.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.MutableLiveData;
import com.livpure.safedrink.R;
import com.livpure.safedrink.serviceRequest.model.RaiseServiceRequestModel;
/* loaded from: classes3.dex */
public class FragmentRaiseServiceRequestBindingImpl extends FragmentRaiseServiceRequestBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final FrameLayout mboundView0;
    private final ProgressBar mboundView2;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.tvHeddingText, 3);
        sparseIntArray.put(R.id.llCustomerVoice, 4);
        sparseIntArray.put(R.id.spinner_cust_voice, 5);
        sparseIntArray.put(R.id.ll_customer_cancel_voice, 6);
        sparseIntArray.put(R.id.spinner_cust_cancel_voice, 7);
        sparseIntArray.put(R.id.ll_customer_sub_voice, 8);
        sparseIntArray.put(R.id.spinner_cust_sub_voice, 9);
        sparseIntArray.put(R.id.uploadLayout, 10);
        sparseIntArray.put(R.id.attachButton, 11);
        sparseIntArray.put(R.id.requestBox, 12);
        sparseIntArray.put(R.id.referralText, 13);
        sparseIntArray.put(R.id.submitButton, 14);
    }

    public FragmentRaiseServiceRequestBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 15, sIncludes, sViewsWithIds));
    }

    private FragmentRaiseServiceRequestBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2, (EditText) bindings[1], (TextView) bindings[11], (LinearLayout) bindings[6], (LinearLayout) bindings[8], (LinearLayout) bindings[4], (TextView) bindings[13], (EditText) bindings[12], (Spinner) bindings[7], (Spinner) bindings[9], (Spinner) bindings[5], (TextView) bindings[14], (TextView) bindings[3], (RelativeLayout) bindings[10]);
        this.mDirtyFlags = -1L;
        this.appointmentDate.setTag(null);
        FrameLayout frameLayout = (FrameLayout) bindings[0];
        this.mboundView0 = frameLayout;
        frameLayout.setTag(null);
        ProgressBar progressBar = (ProgressBar) bindings[2];
        this.mboundView2 = progressBar;
        progressBar.setTag(null);
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
        if (18 == variableId) {
            setViewModel((RaiseServiceRequestModel) variable);
            return true;
        }
        return false;
    }

    @Override // com.livpure.safedrink.databinding.FragmentRaiseServiceRequestBinding
    public void setViewModel(RaiseServiceRequestModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(18);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId != 0) {
            if (localFieldId != 1) {
                return false;
            }
            return onChangeViewModelDateTimeError((MutableLiveData) object, fieldId);
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

    private boolean onChangeViewModelDateTimeError(MutableLiveData<String> ViewModelDateTimeError, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
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
        RaiseServiceRequestModel raiseServiceRequestModel = this.mViewModel;
        int i = 0;
        String str = null;
        if ((15 & j) != 0) {
            int i2 = ((j & 13) > 0L ? 1 : ((j & 13) == 0L ? 0 : -1));
            if (i2 != 0) {
                MutableLiveData<Boolean> loading = raiseServiceRequestModel != null ? raiseServiceRequestModel.getLoading() : null;
                updateLiveDataRegistration(0, loading);
                boolean safeUnbox = ViewDataBinding.safeUnbox(loading != null ? loading.getValue() : null);
                if (i2 != 0) {
                    j |= safeUnbox ? 32L : 16L;
                }
                if (!safeUnbox) {
                    i = 8;
                }
            }
            if ((j & 14) != 0) {
                MutableLiveData<String> dateTimeError = raiseServiceRequestModel != null ? raiseServiceRequestModel.getDateTimeError() : null;
                updateLiveDataRegistration(1, dateTimeError);
                if (dateTimeError != null) {
                    str = dateTimeError.getValue();
                }
            }
        }
        if ((j & 14) != 0) {
            this.appointmentDate.setError(str);
        }
        if ((j & 13) != 0) {
            this.mboundView2.setVisibility(i);
        }
    }
}
