package com.livpure.safedrink.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.AdapterViewBindingAdapter;
import androidx.lifecycle.MutableLiveData;
import com.livpure.safedrink.R;
import com.livpure.safedrink.subscription.cancelsubscription.viewmodel.CancelSubsciptionConfirmationModel;
/* loaded from: classes3.dex */
public class FragmentConfirmCancelSubscriptionBindingImpl extends FragmentConfirmCancelSubscriptionBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private InverseBindingListener cancelReasonandroidSelectedItemPositionAttrChanged;
    private long mDirtyFlags;
    private final ScrollView mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.submitButton, 2);
    }

    public FragmentConfirmCancelSubscriptionBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 3, sIncludes, sViewsWithIds));
    }

    private FragmentConfirmCancelSubscriptionBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1, (Spinner) bindings[1], (LinearLayout) bindings[2]);
        this.cancelReasonandroidSelectedItemPositionAttrChanged = new InverseBindingListener() { // from class: com.livpure.safedrink.databinding.FragmentConfirmCancelSubscriptionBindingImpl.1
            @Override // androidx.databinding.InverseBindingListener
            public void onChange() {
                int selectedItemPosition = FragmentConfirmCancelSubscriptionBindingImpl.this.cancelReason.getSelectedItemPosition();
                CancelSubsciptionConfirmationModel cancelSubsciptionConfirmationModel = FragmentConfirmCancelSubscriptionBindingImpl.this.mViewModel;
                if (cancelSubsciptionConfirmationModel != null) {
                    MutableLiveData<Integer> cancelReason = cancelSubsciptionConfirmationModel.getCancelReason();
                    if (cancelReason != null) {
                        cancelReason.setValue(Integer.valueOf(selectedItemPosition));
                    }
                }
            }
        };
        this.mDirtyFlags = -1L;
        this.cancelReason.setTag(null);
        ScrollView scrollView = (ScrollView) bindings[0];
        this.mboundView0 = scrollView;
        scrollView.setTag(null);
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
            setViewModel((CancelSubsciptionConfirmationModel) variable);
            return true;
        }
        return false;
    }

    @Override // com.livpure.safedrink.databinding.FragmentConfirmCancelSubscriptionBinding
    public void setViewModel(CancelSubsciptionConfirmationModel ViewModel) {
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
        return onChangeViewModelCancelReason((MutableLiveData) object, fieldId);
    }

    private boolean onChangeViewModelCancelReason(MutableLiveData<Integer> ViewModelCancelReason, int fieldId) {
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
        CancelSubsciptionConfirmationModel cancelSubsciptionConfirmationModel = this.mViewModel;
        int i = 0;
        int i2 = ((7 & j) > 0L ? 1 : ((7 & j) == 0L ? 0 : -1));
        if (i2 != 0) {
            MutableLiveData<Integer> cancelReason = cancelSubsciptionConfirmationModel != null ? cancelSubsciptionConfirmationModel.getCancelReason() : null;
            updateLiveDataRegistration(0, cancelReason);
            i = ViewDataBinding.safeUnbox(cancelReason != null ? cancelReason.getValue() : null);
        }
        if (i2 != 0) {
            AdapterViewBindingAdapter.setSelectedItemPosition(this.cancelReason, i);
        }
        if ((j & 4) != 0) {
            AdapterViewBindingAdapter.setOnItemSelectedListener(this.cancelReason, null, null, this.cancelReasonandroidSelectedItemPositionAttrChanged);
        }
    }
}
