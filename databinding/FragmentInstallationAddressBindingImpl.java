package com.livpure.safedrink.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
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
import com.livpure.safedrink.generated.callback.OnClickListener;
import com.livpure.safedrink.login.data.models.User;
import com.livpure.safedrink.subscription.address.viewmodel.InstallationAddressViewModel;
/* loaded from: classes3.dex */
public class FragmentInstallationAddressBindingImpl extends FragmentInstallationAddressBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private InverseBindingListener addressFirstLineEditTextandroidTextAttrChanged;
    private InverseBindingListener addressSecondLineEditTextandroidTextAttrChanged;
    private InverseBindingListener alternateNumberEditTextandroidTextAttrChanged;
    private InverseBindingListener areaAutoCompleteTextViewandroidTextAttrChanged;
    private InverseBindingListener cityAutoCompleteTextViewandroidTextAttrChanged;
    private final View.OnClickListener mCallback1;
    private long mDirtyFlags;
    private final NestedScrollView mboundView0;
    private InverseBindingListener pinCodeEditTextandroidTextAttrChanged;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.installationAddressLabel, 17);
        sparseIntArray.put(R.id.parentTopMargin, 18);
        sparseIntArray.put(R.id.parentStartMargin, 19);
        sparseIntArray.put(R.id.constraintLayout2, 20);
        sparseIntArray.put(R.id.guideline3, 21);
        sparseIntArray.put(R.id.userImage, 22);
        sparseIntArray.put(R.id.emailImage, 23);
        sparseIntArray.put(R.id.phoneImage, 24);
        sparseIntArray.put(R.id.editTextEndMargin, 25);
        sparseIntArray.put(R.id.editTextStartMargin, 26);
        sparseIntArray.put(R.id.alternateNumberInputLayout, 27);
    }

    public FragmentInstallationAddressBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 28, sIncludes, sViewsWithIds));
    }

    private FragmentInstallationAddressBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 12, (TextInputEditText) bindings[5], (TextInputLayout) bindings[4], (TextInputEditText) bindings[7], (TextInputLayout) bindings[6], (TextInputEditText) bindings[14], (TextInputLayout) bindings[27], (AutoCompleteTextView) bindings[11], (TextInputLayout) bindings[10], (AutoCompleteTextView) bindings[13], (TextInputLayout) bindings[12], (ConstraintLayout) bindings[20], (Button) bindings[15], (Guideline) bindings[25], (Guideline) bindings[26], (TextView) bindings[2], (ImageView) bindings[23], (Guideline) bindings[21], (TextView) bindings[17], (TextView) bindings[1], (Guideline) bindings[19], (Guideline) bindings[18], (TextView) bindings[3], (ImageView) bindings[24], (TextInputEditText) bindings[9], (TextInputLayout) bindings[8], (ProgressBar) bindings[16], (ImageView) bindings[22]);
        this.addressFirstLineEditTextandroidTextAttrChanged = new InverseBindingListener() { // from class: com.livpure.safedrink.databinding.FragmentInstallationAddressBindingImpl.1
            @Override // androidx.databinding.InverseBindingListener
            public void onChange() {
                String textString = TextViewBindingAdapter.getTextString(FragmentInstallationAddressBindingImpl.this.addressFirstLineEditText);
                InstallationAddressViewModel installationAddressViewModel = FragmentInstallationAddressBindingImpl.this.mViewModel;
                if (installationAddressViewModel != null) {
                    MutableLiveData<String> addressLine1 = installationAddressViewModel.getAddressLine1();
                    if (addressLine1 != null) {
                        addressLine1.setValue(textString);
                    }
                }
            }
        };
        this.addressSecondLineEditTextandroidTextAttrChanged = new InverseBindingListener() { // from class: com.livpure.safedrink.databinding.FragmentInstallationAddressBindingImpl.2
            @Override // androidx.databinding.InverseBindingListener
            public void onChange() {
                String textString = TextViewBindingAdapter.getTextString(FragmentInstallationAddressBindingImpl.this.addressSecondLineEditText);
                InstallationAddressViewModel installationAddressViewModel = FragmentInstallationAddressBindingImpl.this.mViewModel;
                if (installationAddressViewModel != null) {
                    MutableLiveData<String> addressLine2 = installationAddressViewModel.getAddressLine2();
                    if (addressLine2 != null) {
                        addressLine2.setValue(textString);
                    }
                }
            }
        };
        this.alternateNumberEditTextandroidTextAttrChanged = new InverseBindingListener() { // from class: com.livpure.safedrink.databinding.FragmentInstallationAddressBindingImpl.3
            @Override // androidx.databinding.InverseBindingListener
            public void onChange() {
                String textString = TextViewBindingAdapter.getTextString(FragmentInstallationAddressBindingImpl.this.alternateNumberEditText);
                InstallationAddressViewModel installationAddressViewModel = FragmentInstallationAddressBindingImpl.this.mViewModel;
                if (installationAddressViewModel != null) {
                    MutableLiveData<String> alternateMobileNumber = installationAddressViewModel.getAlternateMobileNumber();
                    if (alternateMobileNumber != null) {
                        alternateMobileNumber.setValue(textString);
                    }
                }
            }
        };
        this.areaAutoCompleteTextViewandroidTextAttrChanged = new InverseBindingListener() { // from class: com.livpure.safedrink.databinding.FragmentInstallationAddressBindingImpl.4
            @Override // androidx.databinding.InverseBindingListener
            public void onChange() {
                String textString = TextViewBindingAdapter.getTextString(FragmentInstallationAddressBindingImpl.this.areaAutoCompleteTextView);
                InstallationAddressViewModel installationAddressViewModel = FragmentInstallationAddressBindingImpl.this.mViewModel;
                if (installationAddressViewModel != null) {
                    MutableLiveData<String> area = installationAddressViewModel.getArea();
                    if (area != null) {
                        area.setValue(textString);
                    }
                }
            }
        };
        this.cityAutoCompleteTextViewandroidTextAttrChanged = new InverseBindingListener() { // from class: com.livpure.safedrink.databinding.FragmentInstallationAddressBindingImpl.5
            @Override // androidx.databinding.InverseBindingListener
            public void onChange() {
                String textString = TextViewBindingAdapter.getTextString(FragmentInstallationAddressBindingImpl.this.cityAutoCompleteTextView);
                InstallationAddressViewModel installationAddressViewModel = FragmentInstallationAddressBindingImpl.this.mViewModel;
                if (installationAddressViewModel != null) {
                    MutableLiveData<String> city = installationAddressViewModel.getCity();
                    if (city != null) {
                        city.setValue(textString);
                    }
                }
            }
        };
        this.pinCodeEditTextandroidTextAttrChanged = new InverseBindingListener() { // from class: com.livpure.safedrink.databinding.FragmentInstallationAddressBindingImpl.6
            @Override // androidx.databinding.InverseBindingListener
            public void onChange() {
                String textString = TextViewBindingAdapter.getTextString(FragmentInstallationAddressBindingImpl.this.pinCodeEditText);
                InstallationAddressViewModel installationAddressViewModel = FragmentInstallationAddressBindingImpl.this.mViewModel;
                if (installationAddressViewModel != null) {
                    MutableLiveData<String> pinCode = installationAddressViewModel.getPinCode();
                    if (pinCode != null) {
                        pinCode.setValue(textString);
                    }
                }
            }
        };
        this.mDirtyFlags = -1L;
        this.addressFirstLineEditText.setTag(null);
        this.addressFirstLineInputLayout.setTag(null);
        this.addressSecondLineEditText.setTag(null);
        this.addressSecondLineInputLayout.setTag(null);
        this.alternateNumberEditText.setTag(null);
        this.areaAutoCompleteTextView.setTag(null);
        this.areaTextInputLayout.setTag(null);
        this.cityAutoCompleteTextView.setTag(null);
        this.cityTextInputLayout.setTag(null);
        this.continueButton.setTag(null);
        this.email.setTag(null);
        NestedScrollView nestedScrollView = (NestedScrollView) bindings[0];
        this.mboundView0 = nestedScrollView;
        nestedScrollView.setTag(null);
        this.name.setTag(null);
        this.phone.setTag(null);
        this.pinCodeEditText.setTag(null);
        this.pinCodeInputLayout.setTag(null);
        this.progressBar4.setTag(null);
        setRootTag(root);
        this.mCallback1 = new OnClickListener(this, 1);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 16384L;
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
        if (16 == variableId) {
            setUser((User) variable);
        } else if (18 != variableId) {
            return false;
        } else {
            setViewModel((InstallationAddressViewModel) variable);
        }
        return true;
    }

    @Override // com.livpure.safedrink.databinding.FragmentInstallationAddressBinding
    public void setUser(User User) {
        this.mUser = User;
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
        }
        notifyPropertyChanged(16);
        super.requestRebind();
    }

    @Override // com.livpure.safedrink.databinding.FragmentInstallationAddressBinding
    public void setViewModel(InstallationAddressViewModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
        }
        notifyPropertyChanged(18);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0:
                return onChangeViewModelAreaError((MutableLiveData) object, fieldId);
            case 1:
                return onChangeViewModelAddressLine1((MutableLiveData) object, fieldId);
            case 2:
                return onChangeViewModelCityError((MutableLiveData) object, fieldId);
            case 3:
                return onChangeViewModelAddressLine1Error((MutableLiveData) object, fieldId);
            case 4:
                return onChangeViewModelArea((MutableLiveData) object, fieldId);
            case 5:
                return onChangeViewModelLoading((MutableLiveData) object, fieldId);
            case 6:
                return onChangeViewModelAddressLine2((MutableLiveData) object, fieldId);
            case 7:
                return onChangeViewModelPinCodeError((MutableLiveData) object, fieldId);
            case 8:
                return onChangeViewModelAlternateMobileNumber((MutableLiveData) object, fieldId);
            case 9:
                return onChangeViewModelPinCode((MutableLiveData) object, fieldId);
            case 10:
                return onChangeViewModelCity((MutableLiveData) object, fieldId);
            case 11:
                return onChangeViewModelAddressLine2Error((MutableLiveData) object, fieldId);
            default:
                return false;
        }
    }

    private boolean onChangeViewModelAreaError(MutableLiveData<String> ViewModelAreaError, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewModelAddressLine1(MutableLiveData<String> ViewModelAddressLine1, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewModelCityError(MutableLiveData<String> ViewModelCityError, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewModelAddressLine1Error(MutableLiveData<String> ViewModelAddressLine1Error, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewModelArea(MutableLiveData<String> ViewModelArea, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewModelLoading(MutableLiveData<Boolean> ViewModelLoading, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewModelAddressLine2(MutableLiveData<String> ViewModelAddressLine2, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewModelPinCodeError(MutableLiveData<String> ViewModelPinCodeError, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewModelAlternateMobileNumber(MutableLiveData<String> ViewModelAlternateMobileNumber, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewModelPinCode(MutableLiveData<String> ViewModelPinCode, int fieldId) {
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

    private boolean onChangeViewModelAddressLine2Error(MutableLiveData<String> ViewModelAddressLine2Error, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0146  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 751
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.livpure.safedrink.databinding.FragmentInstallationAddressBindingImpl.executeBindings():void");
    }

    @Override // com.livpure.safedrink.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        InstallationAddressViewModel installationAddressViewModel = this.mViewModel;
        if (installationAddressViewModel != null) {
            installationAddressViewModel.saveAddress(callbackArg_0);
        }
    }
}
