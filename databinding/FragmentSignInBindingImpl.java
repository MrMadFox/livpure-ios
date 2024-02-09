package com.livpure.safedrink.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.lifecycle.MutableLiveData;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.livpure.safedrink.R;
import com.livpure.safedrink.generated.callback.OnClickListener;
import com.livpure.safedrink.login.viewmodels.SignInViewModel;
/* loaded from: classes3.dex */
public class FragmentSignInBindingImpl extends FragmentSignInBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private InverseBindingListener emailOrPhoneEditTextandroidTextAttrChanged;
    private final View.OnClickListener mCallback15;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;
    private InverseBindingListener passwordEditTextandroidTextAttrChanged;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.staticToolBar, 7);
        sparseIntArray.put(R.id.forgotPasswordText, 8);
        sparseIntArray.put(R.id.createAccountText, 9);
        sparseIntArray.put(R.id.termsText, 10);
        sparseIntArray.put(R.id.guideline, 11);
    }

    public FragmentSignInBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 12, sIncludes, sViewsWithIds));
    }

    private FragmentSignInBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 5, (TextView) bindings[9], (TextInputEditText) bindings[2], (TextInputLayout) bindings[1], (TextView) bindings[8], (Guideline) bindings[11], (ProgressBar) bindings[6], (TextInputEditText) bindings[4], (TextInputLayout) bindings[3], (Button) bindings[5], (MaterialToolbar) bindings[7], (TextView) bindings[10]);
        this.emailOrPhoneEditTextandroidTextAttrChanged = new InverseBindingListener() { // from class: com.livpure.safedrink.databinding.FragmentSignInBindingImpl.1
            @Override // androidx.databinding.InverseBindingListener
            public void onChange() {
                String textString = TextViewBindingAdapter.getTextString(FragmentSignInBindingImpl.this.emailOrPhoneEditText);
                SignInViewModel signInViewModel = FragmentSignInBindingImpl.this.mViewModel;
                if (signInViewModel != null) {
                    MutableLiveData<String> emailOrPhoneNumber = signInViewModel.getEmailOrPhoneNumber();
                    if (emailOrPhoneNumber != null) {
                        emailOrPhoneNumber.setValue(textString);
                    }
                }
            }
        };
        this.passwordEditTextandroidTextAttrChanged = new InverseBindingListener() { // from class: com.livpure.safedrink.databinding.FragmentSignInBindingImpl.2
            @Override // androidx.databinding.InverseBindingListener
            public void onChange() {
                String textString = TextViewBindingAdapter.getTextString(FragmentSignInBindingImpl.this.passwordEditText);
                SignInViewModel signInViewModel = FragmentSignInBindingImpl.this.mViewModel;
                if (signInViewModel != null) {
                    MutableLiveData<String> password = signInViewModel.getPassword();
                    if (password != null) {
                        password.setValue(textString);
                    }
                }
            }
        };
        this.mDirtyFlags = -1L;
        this.emailOrPhoneEditText.setTag(null);
        this.emailOrPhoneTextInputLayout.setTag(null);
        this.loader.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) bindings[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.passwordEditText.setTag(null);
        this.passwordTextInputLayout.setTag(null);
        this.signInButton.setTag(null);
        setRootTag(root);
        this.mCallback15 = new OnClickListener(this, 1);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 64L;
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
            setViewModel((SignInViewModel) variable);
            return true;
        }
        return false;
    }

    @Override // com.livpure.safedrink.databinding.FragmentSignInBinding
    public void setViewModel(SignInViewModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 32;
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
                            return false;
                        }
                        return onChangeViewModelPassword((MutableLiveData) object, fieldId);
                    }
                    return onChangeViewModelPasswordError((MutableLiveData) object, fieldId);
                }
                return onChangeViewModelEmailOrPhoneNumber((MutableLiveData) object, fieldId);
            }
            return onChangeViewModelUsernameError((MutableLiveData) object, fieldId);
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

    private boolean onChangeViewModelUsernameError(MutableLiveData<String> ViewModelUsernameError, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewModelEmailOrPhoneNumber(MutableLiveData<String> ViewModelEmailOrPhoneNumber, int fieldId) {
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

    private boolean onChangeViewModelPassword(MutableLiveData<String> ViewModelPassword, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00aa  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 295
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.livpure.safedrink.databinding.FragmentSignInBindingImpl.executeBindings():void");
    }

    @Override // com.livpure.safedrink.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        SignInViewModel signInViewModel = this.mViewModel;
        if (signInViewModel != null) {
            signInViewModel.onSignInButtonClicked(callbackArg_0);
        }
    }
}
