package com.livpure.safedrink.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.lifecycle.MutableLiveData;
import com.livpure.safedrink.R;
import com.livpure.safedrink.app.support.viewmodels.ServiceRequestViewModel;
/* loaded from: classes3.dex */
public class FragmentServiceRequestBindingImpl extends FragmentServiceRequestBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final FrameLayout mboundView0;
    private final ProgressBar mboundView2;
    private InverseBindingListener requestBoxandroidTextAttrChanged;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.submitButton, 3);
    }

    public FragmentServiceRequestBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 4, sIncludes, sViewsWithIds));
    }

    private FragmentServiceRequestBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2, (EditText) bindings[1], (TextView) bindings[3]);
        this.requestBoxandroidTextAttrChanged = new InverseBindingListener() { // from class: com.livpure.safedrink.databinding.FragmentServiceRequestBindingImpl.1
            @Override // androidx.databinding.InverseBindingListener
            public void onChange() {
                String textString = TextViewBindingAdapter.getTextString(FragmentServiceRequestBindingImpl.this.requestBox);
                ServiceRequestViewModel serviceRequestViewModel = FragmentServiceRequestBindingImpl.this.mViewModel;
                if (serviceRequestViewModel != null) {
                    MutableLiveData<String> serviceRequestMessage = serviceRequestViewModel.getServiceRequestMessage();
                    if (serviceRequestMessage != null) {
                        serviceRequestMessage.setValue(textString);
                    }
                }
            }
        };
        this.mDirtyFlags = -1L;
        FrameLayout frameLayout = (FrameLayout) bindings[0];
        this.mboundView0 = frameLayout;
        frameLayout.setTag(null);
        ProgressBar progressBar = (ProgressBar) bindings[2];
        this.mboundView2 = progressBar;
        progressBar.setTag(null);
        this.requestBox.setTag(null);
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
            setViewModel((ServiceRequestViewModel) variable);
            return true;
        }
        return false;
    }

    @Override // com.livpure.safedrink.databinding.FragmentServiceRequestBinding
    public void setViewModel(ServiceRequestViewModel ViewModel) {
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
            return onChangeViewModelServiceRequestMessage((MutableLiveData) object, fieldId);
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

    private boolean onChangeViewModelServiceRequestMessage(MutableLiveData<String> ViewModelServiceRequestMessage, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void executeBindings() {
        /*
            r15 = this;
            monitor-enter(r15)
            long r0 = r15.mDirtyFlags     // Catch: java.lang.Throwable -> L8e
            r2 = 0
            r15.mDirtyFlags = r2     // Catch: java.lang.Throwable -> L8e
            monitor-exit(r15)     // Catch: java.lang.Throwable -> L8e
            com.livpure.safedrink.app.support.viewmodels.ServiceRequestViewModel r4 = r15.mViewModel
            r5 = 15
            long r5 = r5 & r0
            r7 = 14
            r9 = 13
            r11 = 0
            r12 = 0
            int r13 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r13 == 0) goto L60
            long r5 = r0 & r9
            int r13 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r13 == 0) goto L45
            if (r4 == 0) goto L24
            androidx.lifecycle.MutableLiveData r5 = r4.getLoading()
            goto L25
        L24:
            r5 = r12
        L25:
            r15.updateLiveDataRegistration(r11, r5)
            if (r5 == 0) goto L31
            java.lang.Object r5 = r5.getValue()
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            goto L32
        L31:
            r5 = r12
        L32:
            boolean r5 = androidx.databinding.ViewDataBinding.safeUnbox(r5)
            if (r13 == 0) goto L40
            if (r5 == 0) goto L3d
            r13 = 32
            goto L3f
        L3d:
            r13 = 16
        L3f:
            long r0 = r0 | r13
        L40:
            if (r5 == 0) goto L43
            goto L45
        L43:
            r11 = 8
        L45:
            long r5 = r0 & r7
            int r13 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r13 == 0) goto L60
            if (r4 == 0) goto L52
            androidx.lifecycle.MutableLiveData r4 = r4.getServiceRequestMessage()
            goto L53
        L52:
            r4 = r12
        L53:
            r5 = 1
            r15.updateLiveDataRegistration(r5, r4)
            if (r4 == 0) goto L60
            java.lang.Object r4 = r4.getValue()
            java.lang.String r4 = (java.lang.String) r4
            goto L61
        L60:
            r4 = r12
        L61:
            long r5 = r0 & r9
            int r9 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r9 == 0) goto L6c
            android.widget.ProgressBar r5 = r15.mboundView2
            r5.setVisibility(r11)
        L6c:
            long r5 = r0 & r7
            int r7 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r7 == 0) goto L77
            android.widget.EditText r5 = r15.requestBox
            androidx.databinding.adapters.TextViewBindingAdapter.setText(r5, r4)
        L77:
            r4 = 8
            long r0 = r0 & r4
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L8d
            android.widget.EditText r0 = r15.requestBox
            r1 = r12
            androidx.databinding.adapters.TextViewBindingAdapter$BeforeTextChanged r1 = (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged) r1
            r2 = r12
            androidx.databinding.adapters.TextViewBindingAdapter$OnTextChanged r2 = (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged) r2
            androidx.databinding.adapters.TextViewBindingAdapter$AfterTextChanged r12 = (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged) r12
            androidx.databinding.InverseBindingListener r3 = r15.requestBoxandroidTextAttrChanged
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(r0, r1, r2, r12, r3)
        L8d:
            return
        L8e:
            r0 = move-exception
            monitor-exit(r15)     // Catch: java.lang.Throwable -> L8e
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.livpure.safedrink.databinding.FragmentServiceRequestBindingImpl.executeBindings():void");
    }
}
