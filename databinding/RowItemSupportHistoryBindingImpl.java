package com.livpure.safedrink.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.livpure.safedrink.R;
import com.livpure.safedrink.serviceRequest.data.model.ServiceHistoryResponse;
import com.livpure.safedrink.serviceRequest.view.adapter.RaiseServiceHistoryAdapter;
/* loaded from: classes3.dex */
public class RowItemSupportHistoryBindingImpl extends RowItemSupportHistoryBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.tv_request_id, 2);
        sparseIntArray.put(R.id.tv_service_reason, 3);
        sparseIntArray.put(R.id.tv_status, 4);
        sparseIntArray.put(R.id.ll_contact_person, 5);
        sparseIntArray.put(R.id.tv_contact_person, 6);
        sparseIntArray.put(R.id.tv_contact_person_mobile, 7);
        sparseIntArray.put(R.id.ll_resolved_on, 8);
        sparseIntArray.put(R.id.tv_resolved_on, 9);
    }

    public RowItemSupportHistoryBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 10, sIncludes, sViewsWithIds));
    }

    private RowItemSupportHistoryBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (LinearLayout) bindings[5], (LinearLayout) bindings[8], (TextView) bindings[6], (TextView) bindings[7], (TextView) bindings[1], (TextView) bindings[2], (TextView) bindings[9], (TextView) bindings[3], (TextView) bindings[4]);
        this.mDirtyFlags = -1L;
        LinearLayout linearLayout = (LinearLayout) bindings[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
        this.tvRequestDate.setTag(null);
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
        } else if (5 == variableId) {
            setHistoryList((ServiceHistoryResponse) variable);
        } else if (2 != variableId) {
            return false;
        } else {
            setCallBack((RaiseServiceHistoryAdapter) variable);
        }
        return true;
    }

    @Override // com.livpure.safedrink.databinding.RowItemSupportHistoryBinding
    public void setPosition(Integer Position) {
        this.mPosition = Position;
    }

    @Override // com.livpure.safedrink.databinding.RowItemSupportHistoryBinding
    public void setHistoryList(ServiceHistoryResponse HistoryList) {
        this.mHistoryList = HistoryList;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(5);
        super.requestRebind();
    }

    @Override // com.livpure.safedrink.databinding.RowItemSupportHistoryBinding
    public void setCallBack(RaiseServiceHistoryAdapter CallBack) {
        this.mCallBack = CallBack;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        ServiceHistoryResponse serviceHistoryResponse = this.mHistoryList;
        String str = null;
        int i = ((j & 10) > 0L ? 1 : ((j & 10) == 0L ? 0 : -1));
        if (i != 0 && serviceHistoryResponse != null) {
            str = serviceHistoryResponse.getRequest_date();
        }
        if (i != 0) {
            TextViewBindingAdapter.setText(this.tvRequestDate, str);
        }
    }
}
