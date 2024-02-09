package com.livpure.safedrink.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.lifecycle.MutableLiveData;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.livpure.safedrink.R;
import com.livpure.safedrink.generated.callback.OnClickListener;
import com.livpure.safedrink.login.viewmodels.SignUpViewModel;
/* loaded from: classes3.dex */
public class FragmentSignUpBindingImpl extends FragmentSignUpBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private InverseBindingListener emailEditTextandroidTextAttrChanged;
    private final View.OnClickListener mCallback5;
    private long mDirtyFlags;
    private final NestedScrollView mboundView0;
    private InverseBindingListener nameEditTextandroidTextAttrChanged;
    private InverseBindingListener passwordEditTextandroidTextAttrChanged;
    private InverseBindingListener phoneEditTextandroidTextAttrChanged;
    private InverseBindingListener referralCodeEditTextandroidTextAttrChanged;
    private InverseBindingListener selectCityAutoCompleteTextViewandroidTextAttrChanged;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.phoneInputContainer, 15);
        sparseIntArray.put(R.id.termsText, 16);
    }

    public FragmentSignUpBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 17, sIncludes, sViewsWithIds));
    }

    private FragmentSignUpBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 14, (TextInputEditText) bindings[4], (TextInputLayout) bindings[3], (TextInputEditText) bindings[2], (TextInputLayout) bindings[1], (TextInputEditText) bindings[8], (TextInputLayout) bindings[7], (TextInputEditText) bindings[6], (LinearLayout) bindings[15], (TextInputLayout) bindings[5], (TextInputEditText) bindings[12], (TextInputLayout) bindings[11], (AutoCompleteTextView) bindings[10], (TextInputLayout) bindings[9], (Button) bindings[13], (ProgressBar) bindings[14], (TextView) bindings[16]);
        this.emailEditTextandroidTextAttrChanged = new InverseBindingListener() { // from class: com.livpure.safedrink.databinding.FragmentSignUpBindingImpl.1
            @Override // androidx.databinding.InverseBindingListener
            public void onChange() {
                String textString = TextViewBindingAdapter.getTextString(FragmentSignUpBindingImpl.this.emailEditText);
                SignUpViewModel signUpViewModel = FragmentSignUpBindingImpl.this.mViewModel;
                if (signUpViewModel != null) {
                    MutableLiveData<String> email = signUpViewModel.getEmail();
                    if (email != null) {
                        email.setValue(textString);
                    }
                }
            }
        };
        this.nameEditTextandroidTextAttrChanged = new InverseBindingListener() { // from class: com.livpure.safedrink.databinding.FragmentSignUpBindingImpl.2
            @Override // androidx.databinding.InverseBindingListener
            public void onChange() {
                String textString = TextViewBindingAdapter.getTextString(FragmentSignUpBindingImpl.this.nameEditText);
                SignUpViewModel signUpViewModel = FragmentSignUpBindingImpl.this.mViewModel;
                if (signUpViewModel != null) {
                    MutableLiveData<String> name = signUpViewModel.getName();
                    if (name != null) {
                        name.setValue(textString);
                    }
                }
            }
        };
        this.passwordEditTextandroidTextAttrChanged = new InverseBindingListener() { // from class: com.livpure.safedrink.databinding.FragmentSignUpBindingImpl.3
            @Override // androidx.databinding.InverseBindingListener
            public void onChange() {
                String textString = TextViewBindingAdapter.getTextString(FragmentSignUpBindingImpl.this.passwordEditText);
                SignUpViewModel signUpViewModel = FragmentSignUpBindingImpl.this.mViewModel;
                if (signUpViewModel != null) {
                    MutableLiveData<String> password = signUpViewModel.getPassword();
                    if (password != null) {
                        password.setValue(textString);
                    }
                }
            }
        };
        this.phoneEditTextandroidTextAttrChanged = new InverseBindingListener() { // from class: com.livpure.safedrink.databinding.FragmentSignUpBindingImpl.4
            @Override // androidx.databinding.InverseBindingListener
            public void onChange() {
                String textString = TextViewBindingAdapter.getTextString(FragmentSignUpBindingImpl.this.phoneEditText);
                SignUpViewModel signUpViewModel = FragmentSignUpBindingImpl.this.mViewModel;
                if (signUpViewModel != null) {
                    MutableLiveData<String> phone = signUpViewModel.getPhone();
                    if (phone != null) {
                        phone.setValue(textString);
                    }
                }
            }
        };
        this.referralCodeEditTextandroidTextAttrChanged = new InverseBindingListener() { // from class: com.livpure.safedrink.databinding.FragmentSignUpBindingImpl.5
            @Override // androidx.databinding.InverseBindingListener
            public void onChange() {
                String textString = TextViewBindingAdapter.getTextString(FragmentSignUpBindingImpl.this.referralCodeEditText);
                SignUpViewModel signUpViewModel = FragmentSignUpBindingImpl.this.mViewModel;
                if (signUpViewModel != null) {
                    MutableLiveData<String> referralCode = signUpViewModel.getReferralCode();
                    if (referralCode != null) {
                        referralCode.setValue(textString);
                    }
                }
            }
        };
        this.selectCityAutoCompleteTextViewandroidTextAttrChanged = new InverseBindingListener() { // from class: com.livpure.safedrink.databinding.FragmentSignUpBindingImpl.6
            @Override // androidx.databinding.InverseBindingListener
            public void onChange() {
                String textString = TextViewBindingAdapter.getTextString(FragmentSignUpBindingImpl.this.selectCityAutoCompleteTextView);
                SignUpViewModel signUpViewModel = FragmentSignUpBindingImpl.this.mViewModel;
                if (signUpViewModel != null) {
                    MutableLiveData<String> city = signUpViewModel.getCity();
                    if (city != null) {
                        city.setValue(textString);
                    }
                }
            }
        };
        this.mDirtyFlags = -1L;
        this.emailEditText.setTag(null);
        this.emailTextInputLayout.setTag(null);
        NestedScrollView nestedScrollView = (NestedScrollView) bindings[0];
        this.mboundView0 = nestedScrollView;
        nestedScrollView.setTag(null);
        this.nameEditText.setTag(null);
        this.nameTextInputLayout.setTag(null);
        this.passwordEditText.setTag(null);
        this.passwordTextInputLayout.setTag(null);
        this.phoneEditText.setTag(null);
        this.phoneTextInputLayout.setTag(null);
        this.referralCodeEditText.setTag(null);
        this.referralCodeTextInputLayout.setTag(null);
        this.selectCityAutoCompleteTextView.setTag(null);
        this.selectCityTextInputLayout.setTag(null);
        this.signUpButton.setTag(null);
        this.signUpProgressBar.setTag(null);
        setRootTag(root);
        this.mCallback5 = new OnClickListener(this, 1);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
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
            setViewModel((SignUpViewModel) variable);
            return true;
        }
        return false;
    }

    @Override // com.livpure.safedrink.databinding.FragmentSignUpBinding
    public void setViewModel(SignUpViewModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 16384;
        }
        notifyPropertyChanged(18);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0:
                return onChangeViewModelEmailError((MutableLiveData) object, fieldId);
            case 1:
                return onChangeViewModelNameError((MutableLiveData) object, fieldId);
            case 2:
                return onChangeViewModelEmail((MutableLiveData) object, fieldId);
            case 3:
                return onChangeViewModelCityError((MutableLiveData) object, fieldId);
            case 4:
                return onChangeViewModelPhone((MutableLiveData) object, fieldId);
            case 5:
                return onChangeViewModelReferralCode((MutableLiveData) object, fieldId);
            case 6:
                return onChangeViewModelPassword((MutableLiveData) object, fieldId);
            case 7:
                return onChangeViewModelLoading((MutableLiveData) object, fieldId);
            case 8:
                return onChangeViewModelIsReferralCodeValidated((MutableLiveData) object, fieldId);
            case 9:
                return onChangeViewModelPhoneError((MutableLiveData) object, fieldId);
            case 10:
                return onChangeViewModelCity((MutableLiveData) object, fieldId);
            case 11:
                return onChangeViewModelPasswordError((MutableLiveData) object, fieldId);
            case 12:
                return onChangeViewModelName((MutableLiveData) object, fieldId);
            case 13:
                return onChangeViewModelReferralCodeError((MutableLiveData) object, fieldId);
            default:
                return false;
        }
    }

    private boolean onChangeViewModelEmailError(MutableLiveData<String> ViewModelEmailError, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewModelNameError(MutableLiveData<String> ViewModelNameError, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewModelEmail(MutableLiveData<String> ViewModelEmail, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewModelCityError(MutableLiveData<String> ViewModelCityError, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewModelPhone(MutableLiveData<String> ViewModelPhone, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewModelReferralCode(MutableLiveData<String> ViewModelReferralCode, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewModelPassword(MutableLiveData<String> ViewModelPassword, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewModelLoading(MutableLiveData<Boolean> ViewModelLoading, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewModelIsReferralCodeValidated(MutableLiveData<Boolean> ViewModelIsReferralCodeValidated, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewModelPhoneError(MutableLiveData<String> ViewModelPhoneError, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewModelCity(MutableLiveData<String> ViewModelCity, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewModelPasswordError(MutableLiveData<String> ViewModelPasswordError, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewModelName(MutableLiveData<String> ViewModelName, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewModelReferralCodeError(MutableLiveData<String> ViewModelReferralCodeError, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0137  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 871
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.livpure.safedrink.databinding.FragmentSignUpBindingImpl.executeBindings():void");
    }

    @Override // com.livpure.safedrink.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        SignUpViewModel signUpViewModel = this.mViewModel;
        if (signUpViewModel != null) {
            signUpViewModel.onSignUpButtonClicked(callbackArg_0);
        }
    }
}
