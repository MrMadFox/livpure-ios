package com.livpure.safedrink.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.lifecycle.MutableLiveData;
import com.google.android.material.textfield.TextInputLayout;
import com.livpure.safedrink.R;
import com.livpure.safedrink.login.data.models.User;
import com.livpure.safedrink.serviceRequest.model.RelocationModel;
/* loaded from: classes3.dex */
public class FragmentRelocationAddressBindingImpl extends FragmentRelocationAddressBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private InverseBindingListener areaAutoCompleteTextViewRelocationandroidTextAttrChanged;
    private InverseBindingListener etCityandroidTextAttrChanged;
    private InverseBindingListener etFlatandroidTextAttrChanged;
    private InverseBindingListener etPinandroidTextAttrChanged;
    private InverseBindingListener etStreetandroidTextAttrChanged;
    private long mDirtyFlags;
    private final ScrollView mboundView0;
    private InverseBindingListener pickupAutoCompleteTextViewandroidTextAttrChanged;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.areaTextInputLayout, 8);
        sparseIntArray.put(R.id.pickupTextInputLayout, 9);
    }

    public FragmentRelocationAddressBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 10, sIncludes, sViewsWithIds));
    }

    private FragmentRelocationAddressBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 7, (AutoCompleteTextView) bindings[5], (TextInputLayout) bindings[8], (Button) bindings[7], (EditText) bindings[4], (EditText) bindings[1], (EditText) bindings[3], (EditText) bindings[2], (AutoCompleteTextView) bindings[6], (TextInputLayout) bindings[9]);
        this.areaAutoCompleteTextViewRelocationandroidTextAttrChanged = new InverseBindingListener() { // from class: com.livpure.safedrink.databinding.FragmentRelocationAddressBindingImpl.1
            @Override // androidx.databinding.InverseBindingListener
            public void onChange() {
                String textString = TextViewBindingAdapter.getTextString(FragmentRelocationAddressBindingImpl.this.areaAutoCompleteTextViewRelocation);
                RelocationModel relocationModel = FragmentRelocationAddressBindingImpl.this.mViewModel;
                if (relocationModel != null) {
                    MutableLiveData<String> area = relocationModel.getArea();
                    if (area != null) {
                        area.setValue(textString);
                    }
                }
            }
        };
        this.etCityandroidTextAttrChanged = new InverseBindingListener() { // from class: com.livpure.safedrink.databinding.FragmentRelocationAddressBindingImpl.2
            @Override // androidx.databinding.InverseBindingListener
            public void onChange() {
                String textString = TextViewBindingAdapter.getTextString(FragmentRelocationAddressBindingImpl.this.etCity);
                RelocationModel relocationModel = FragmentRelocationAddressBindingImpl.this.mViewModel;
                if (relocationModel != null) {
                    MutableLiveData<String> city = relocationModel.getCity();
                    if (city != null) {
                        city.setValue(textString);
                    }
                }
            }
        };
        this.etFlatandroidTextAttrChanged = new InverseBindingListener() { // from class: com.livpure.safedrink.databinding.FragmentRelocationAddressBindingImpl.3
            @Override // androidx.databinding.InverseBindingListener
            public void onChange() {
                String textString = TextViewBindingAdapter.getTextString(FragmentRelocationAddressBindingImpl.this.etFlat);
                RelocationModel relocationModel = FragmentRelocationAddressBindingImpl.this.mViewModel;
                if (relocationModel != null) {
                    MutableLiveData<String> addressLine1 = relocationModel.getAddressLine1();
                    if (addressLine1 != null) {
                        addressLine1.setValue(textString);
                    }
                }
            }
        };
        this.etPinandroidTextAttrChanged = new InverseBindingListener() { // from class: com.livpure.safedrink.databinding.FragmentRelocationAddressBindingImpl.4
            @Override // androidx.databinding.InverseBindingListener
            public void onChange() {
                String textString = TextViewBindingAdapter.getTextString(FragmentRelocationAddressBindingImpl.this.etPin);
                RelocationModel relocationModel = FragmentRelocationAddressBindingImpl.this.mViewModel;
                if (relocationModel != null) {
                    MutableLiveData<String> pinCode = relocationModel.getPinCode();
                    if (pinCode != null) {
                        pinCode.setValue(textString);
                    }
                }
            }
        };
        this.etStreetandroidTextAttrChanged = new InverseBindingListener() { // from class: com.livpure.safedrink.databinding.FragmentRelocationAddressBindingImpl.5
            @Override // androidx.databinding.InverseBindingListener
            public void onChange() {
                String textString = TextViewBindingAdapter.getTextString(FragmentRelocationAddressBindingImpl.this.etStreet);
                RelocationModel relocationModel = FragmentRelocationAddressBindingImpl.this.mViewModel;
                if (relocationModel != null) {
                    MutableLiveData<String> addressLine2 = relocationModel.getAddressLine2();
                    if (addressLine2 != null) {
                        addressLine2.setValue(textString);
                    }
                }
            }
        };
        this.pickupAutoCompleteTextViewandroidTextAttrChanged = new InverseBindingListener() { // from class: com.livpure.safedrink.databinding.FragmentRelocationAddressBindingImpl.6
            @Override // androidx.databinding.InverseBindingListener
            public void onChange() {
                String textString = TextViewBindingAdapter.getTextString(FragmentRelocationAddressBindingImpl.this.pickupAutoCompleteTextView);
                RelocationModel relocationModel = FragmentRelocationAddressBindingImpl.this.mViewModel;
                if (relocationModel != null) {
                    MutableLiveData<String> pickupType = relocationModel.getPickupType();
                    if (pickupType != null) {
                        pickupType.setValue(textString);
                    }
                }
            }
        };
        this.mDirtyFlags = -1L;
        this.areaAutoCompleteTextViewRelocation.setTag(null);
        this.btnSubmit.setTag(null);
        this.etCity.setTag(null);
        this.etFlat.setTag(null);
        this.etPin.setTag(null);
        this.etStreet.setTag(null);
        ScrollView scrollView = (ScrollView) bindings[0];
        this.mboundView0 = scrollView;
        scrollView.setTag(null);
        this.pickupAutoCompleteTextView.setTag(null);
        setRootTag(root);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 512L;
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
            setViewModel((RelocationModel) variable);
        }
        return true;
    }

    @Override // com.livpure.safedrink.databinding.FragmentRelocationAddressBinding
    public void setUser(User User) {
        this.mUser = User;
    }

    @Override // com.livpure.safedrink.databinding.FragmentRelocationAddressBinding
    public void setViewModel(RelocationModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 256;
        }
        notifyPropertyChanged(18);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0:
                return onChangeViewModelIsFormComplete((MutableLiveData) object, fieldId);
            case 1:
                return onChangeViewModelAddressLine1((MutableLiveData) object, fieldId);
            case 2:
                return onChangeViewModelAddressLine2((MutableLiveData) object, fieldId);
            case 3:
                return onChangeViewModelPickupType((MutableLiveData) object, fieldId);
            case 4:
                return onChangeViewModelPinCode((MutableLiveData) object, fieldId);
            case 5:
                return onChangeViewModelCity((MutableLiveData) object, fieldId);
            case 6:
                return onChangeViewModelArea((MutableLiveData) object, fieldId);
            default:
                return false;
        }
    }

    private boolean onChangeViewModelIsFormComplete(MutableLiveData<Boolean> ViewModelIsFormComplete, int fieldId) {
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

    private boolean onChangeViewModelAddressLine2(MutableLiveData<String> ViewModelAddressLine2, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewModelPickupType(MutableLiveData<String> ViewModelPickupType, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewModelPinCode(MutableLiveData<String> ViewModelPinCode, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewModelCity(MutableLiveData<String> ViewModelCity, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewModelArea(MutableLiveData<String> ViewModelArea, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00f1  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 425
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.livpure.safedrink.databinding.FragmentRelocationAddressBindingImpl.executeBindings():void");
    }
}
