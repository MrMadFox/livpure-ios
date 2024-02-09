package com.livpure.safedrink.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.lifecycle.MutableLiveData;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.livpure.safedrink.R;
import com.livpure.safedrink.login.viewmodels.ForgotPasswordViewModel;
/* loaded from: classes3.dex */
public class FragmentForgotPasswordBindingImpl extends FragmentForgotPasswordBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private InverseBindingListener enterEmailEditTextandroidTextAttrChanged;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.secureImage, 4);
        sparseIntArray.put(R.id.forgotPasswordLabel, 5);
        sparseIntArray.put(R.id.forgotPasswordHint, 6);
        sparseIntArray.put(R.id.enterUsernameTextInputLayout, 7);
        sparseIntArray.put(R.id.guideline5, 8);
    }

    public FragmentForgotPasswordBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 9, sIncludes, sViewsWithIds));
    }

    private FragmentForgotPasswordBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2, (TextInputEditText) bindings[1], (TextInputLayout) bindings[7], (TextView) bindings[6], (TextView) bindings[5], (Guideline) bindings[8], (ProgressBar) bindings[3], (Button) bindings[2], (ImageView) bindings[4]);
        this.enterEmailEditTextandroidTextAttrChanged = new InverseBindingListener() { // from class: com.livpure.safedrink.databinding.FragmentForgotPasswordBindingImpl.1
            @Override // androidx.databinding.InverseBindingListener
            public void onChange() {
                String textString = TextViewBindingAdapter.getTextString(FragmentForgotPasswordBindingImpl.this.enterEmailEditText);
                ForgotPasswordViewModel forgotPasswordViewModel = FragmentForgotPasswordBindingImpl.this.mViewModel;
                if (forgotPasswordViewModel != null) {
                    MutableLiveData<String> username = forgotPasswordViewModel.getUsername();
                    if (username != null) {
                        username.setValue(textString);
                    }
                }
            }
        };
        this.mDirtyFlags = -1L;
        this.enterEmailEditText.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) bindings[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.progressBar3.setTag(null);
        this.resetPasswordButton.setTag(null);
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
            setViewModel((ForgotPasswordViewModel) variable);
            return true;
        }
        return false;
    }

    @Override // com.livpure.safedrink.databinding.FragmentForgotPasswordBinding
    public void setViewModel(ForgotPasswordViewModel ViewModel) {
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
            return onChangeViewModelUsername((MutableLiveData) object, fieldId);
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

    private boolean onChangeViewModelUsername(MutableLiveData<String> ViewModelUsername, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0069  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void executeBindings() {
        /*
            r15 = this;
            monitor-enter(r15)
            long r0 = r15.mDirtyFlags     // Catch: java.lang.Throwable -> L9d
            r2 = 0
            r15.mDirtyFlags = r2     // Catch: java.lang.Throwable -> L9d
            monitor-exit(r15)     // Catch: java.lang.Throwable -> L9d
            com.livpure.safedrink.login.viewmodels.ForgotPasswordViewModel r4 = r15.mViewModel
            r5 = 15
            long r5 = r5 & r0
            r7 = 13
            r9 = 14
            r11 = 0
            r12 = 0
            int r13 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r13 == 0) goto L6b
            long r5 = r0 & r7
            int r13 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r13 == 0) goto L46
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
            goto L46
        L43:
            r5 = 8
            goto L47
        L46:
            r5 = 0
        L47:
            long r13 = r0 & r9
            int r6 = (r13 > r2 ? 1 : (r13 == r2 ? 0 : -1))
            if (r6 == 0) goto L69
            if (r4 == 0) goto L54
            androidx.lifecycle.MutableLiveData r4 = r4.getUsername()
            goto L55
        L54:
            r4 = r12
        L55:
            r6 = 1
            r15.updateLiveDataRegistration(r6, r4)
            if (r4 == 0) goto L62
            java.lang.Object r4 = r4.getValue()
            java.lang.String r4 = (java.lang.String) r4
            goto L63
        L62:
            r4 = r12
        L63:
            boolean r11 = android.text.TextUtils.isEmpty(r4)
            r11 = r11 ^ r6
            goto L6d
        L69:
            r4 = r12
            goto L6d
        L6b:
            r4 = r12
            r5 = 0
        L6d:
            long r9 = r9 & r0
            int r6 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
            if (r6 == 0) goto L7c
            com.google.android.material.textfield.TextInputEditText r6 = r15.enterEmailEditText
            androidx.databinding.adapters.TextViewBindingAdapter.setText(r6, r4)
            android.widget.Button r4 = r15.resetPasswordButton
            r4.setEnabled(r11)
        L7c:
            r9 = 8
            long r9 = r9 & r0
            int r4 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
            if (r4 == 0) goto L92
            com.google.android.material.textfield.TextInputEditText r4 = r15.enterEmailEditText
            r6 = r12
            androidx.databinding.adapters.TextViewBindingAdapter$BeforeTextChanged r6 = (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged) r6
            r9 = r12
            androidx.databinding.adapters.TextViewBindingAdapter$OnTextChanged r9 = (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged) r9
            androidx.databinding.adapters.TextViewBindingAdapter$AfterTextChanged r12 = (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged) r12
            androidx.databinding.InverseBindingListener r10 = r15.enterEmailEditTextandroidTextAttrChanged
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(r4, r6, r9, r12, r10)
        L92:
            long r0 = r0 & r7
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L9c
            android.widget.ProgressBar r0 = r15.progressBar3
            r0.setVisibility(r5)
        L9c:
            return
        L9d:
            r0 = move-exception
            monitor-exit(r15)     // Catch: java.lang.Throwable -> L9d
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.livpure.safedrink.databinding.FragmentForgotPasswordBindingImpl.executeBindings():void");
    }
}
