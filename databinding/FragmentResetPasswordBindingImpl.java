package com.livpure.safedrink.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.lifecycle.MutableLiveData;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.livpure.safedrink.R;
import com.livpure.safedrink.login.viewmodels.ResetPasswordViewModel;
/* loaded from: classes3.dex */
public class FragmentResetPasswordBindingImpl extends FragmentResetPasswordBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private InverseBindingListener confirmEditTextandroidTextAttrChanged;
    private long mDirtyFlags;
    private final NestedScrollView mboundView0;
    private InverseBindingListener otpEditTextandroidTextAttrChanged;
    private InverseBindingListener passwordEditTextandroidTextAttrChanged;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.resetPasswordContainer, 8);
        sparseIntArray.put(R.id.textView, 9);
        sparseIntArray.put(R.id.otpLabel, 10);
        sparseIntArray.put(R.id.guideline7, 11);
    }

    public FragmentResetPasswordBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 12, sIncludes, sViewsWithIds));
    }

    private FragmentResetPasswordBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 6, (TextInputEditText) bindings[5], (TextInputLayout) bindings[4], (Guideline) bindings[11], (EditText) bindings[1], (TextView) bindings[10], (TextInputEditText) bindings[3], (TextInputLayout) bindings[2], (Button) bindings[6], (ConstraintLayout) bindings[8], (ProgressBar) bindings[7], (TextView) bindings[9]);
        this.confirmEditTextandroidTextAttrChanged = new InverseBindingListener() { // from class: com.livpure.safedrink.databinding.FragmentResetPasswordBindingImpl.1
            @Override // androidx.databinding.InverseBindingListener
            public void onChange() {
                String textString = TextViewBindingAdapter.getTextString(FragmentResetPasswordBindingImpl.this.confirmEditText);
                ResetPasswordViewModel resetPasswordViewModel = FragmentResetPasswordBindingImpl.this.mViewModel;
                if (resetPasswordViewModel != null) {
                    MutableLiveData<String> confirmPassword = resetPasswordViewModel.getConfirmPassword();
                    if (confirmPassword != null) {
                        confirmPassword.setValue(textString);
                    }
                }
            }
        };
        this.otpEditTextandroidTextAttrChanged = new InverseBindingListener() { // from class: com.livpure.safedrink.databinding.FragmentResetPasswordBindingImpl.2
            @Override // androidx.databinding.InverseBindingListener
            public void onChange() {
                String textString = TextViewBindingAdapter.getTextString(FragmentResetPasswordBindingImpl.this.otpEditText);
                ResetPasswordViewModel resetPasswordViewModel = FragmentResetPasswordBindingImpl.this.mViewModel;
                if (resetPasswordViewModel != null) {
                    MutableLiveData<String> otp = resetPasswordViewModel.getOtp();
                    if (otp != null) {
                        otp.setValue(textString);
                    }
                }
            }
        };
        this.passwordEditTextandroidTextAttrChanged = new InverseBindingListener() { // from class: com.livpure.safedrink.databinding.FragmentResetPasswordBindingImpl.3
            @Override // androidx.databinding.InverseBindingListener
            public void onChange() {
                String textString = TextViewBindingAdapter.getTextString(FragmentResetPasswordBindingImpl.this.passwordEditText);
                ResetPasswordViewModel resetPasswordViewModel = FragmentResetPasswordBindingImpl.this.mViewModel;
                if (resetPasswordViewModel != null) {
                    MutableLiveData<String> password = resetPasswordViewModel.getPassword();
                    if (password != null) {
                        password.setValue(textString);
                    }
                }
            }
        };
        this.mDirtyFlags = -1L;
        this.confirmEditText.setTag(null);
        this.confirmTextInputLayout.setTag(null);
        NestedScrollView nestedScrollView = (NestedScrollView) bindings[0];
        this.mboundView0 = nestedScrollView;
        nestedScrollView.setTag(null);
        this.otpEditText.setTag(null);
        this.passwordEditText.setTag(null);
        this.passwordTextInputLayout.setTag(null);
        this.resetPasswordButton.setTag(null);
        this.resetPasswordProgress.setTag(null);
        setRootTag(root);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 128L;
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
            setViewModel((ResetPasswordViewModel) variable);
            return true;
        }
        return false;
    }

    @Override // com.livpure.safedrink.databinding.FragmentResetPasswordBinding
    public void setViewModel(ResetPasswordViewModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        notifyPropertyChanged(18);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId != 0) {
            if (localFieldId != 1) {
                if (localFieldId != 2) {
                    if (localFieldId != 3) {
                        if (localFieldId != 4) {
                            if (localFieldId != 5) {
                                return false;
                            }
                            return onChangeViewModelPassword((MutableLiveData) object, fieldId);
                        }
                        return onChangeViewModelOtp((MutableLiveData) object, fieldId);
                    }
                    return onChangeViewModelPasswordError((MutableLiveData) object, fieldId);
                }
                return onChangeViewModelConfirmPasswordError((MutableLiveData) object, fieldId);
            }
            return onChangeViewModelConfirmPassword((MutableLiveData) object, fieldId);
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

    private boolean onChangeViewModelConfirmPassword(MutableLiveData<String> ViewModelConfirmPassword, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewModelConfirmPasswordError(MutableLiveData<String> ViewModelConfirmPasswordError, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewModelPasswordError(MutableLiveData<String> ViewModelPasswordError, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewModelOtp(MutableLiveData<String> ViewModelOtp, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewModelPassword(MutableLiveData<String> ViewModelPassword, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00fa  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 487
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.livpure.safedrink.databinding.FragmentResetPasswordBindingImpl.executeBindings():void");
    }
}
