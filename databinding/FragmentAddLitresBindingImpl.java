package com.livpure.safedrink.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import com.google.android.material.textfield.TextInputEditText;
import com.livpure.safedrink.R;
import com.livpure.safedrink.subscription.payment.viewmodel.AddLitresViewModel;
/* loaded from: classes3.dex */
public class FragmentAddLitresBindingImpl extends FragmentAddLitresBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private InverseBindingListener litresEditTextandroidTextAttrChanged;
    private long mDirtyFlags;
    private final NestedScrollView mboundView0;
    private final TextView mboundView6;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.homeContainer, 12);
        sparseIntArray.put(R.id.removeWater, 13);
        sparseIntArray.put(R.id.waterAdd, 14);
        sparseIntArray.put(R.id.message, 15);
        sparseIntArray.put(R.id.upgradeNowButton, 16);
        sparseIntArray.put(R.id.seeAllPlans, 17);
    }

    public FragmentAddLitresBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 18, sIncludes, sViewsWithIds));
    }

    private FragmentAddLitresBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 10, (ConstraintLayout) bindings[12], (TextInputEditText) bindings[2], (TextView) bindings[1], (LinearLayout) bindings[8], (LinearLayout) bindings[5], (ProgressBar) bindings[7], (TextView) bindings[15], (Button) bindings[4], (TextView) bindings[3], (LinearLayout) bindings[13], (LinearLayout) bindings[17], (TextView) bindings[10], (TextView) bindings[9], (TextView) bindings[11], (Button) bindings[16], (LinearLayout) bindings[14]);
        this.litresEditTextandroidTextAttrChanged = new InverseBindingListener() { // from class: com.livpure.safedrink.databinding.FragmentAddLitresBindingImpl.1
            @Override // androidx.databinding.InverseBindingListener
            public void onChange() {
                String textString = TextViewBindingAdapter.getTextString(FragmentAddLitresBindingImpl.this.litresEditText);
                AddLitresViewModel addLitresViewModel = FragmentAddLitresBindingImpl.this.mViewModel;
                if (addLitresViewModel != null) {
                    MutableLiveData<String> additionalLitres = addLitresViewModel.getAdditionalLitres();
                    if (additionalLitres != null) {
                        additionalLitres.setValue(textString);
                    }
                }
            }
        };
        this.mDirtyFlags = -1L;
        this.litresEditText.setTag(null);
        this.litresLabel.setTag(null);
        this.llRecommendation.setTag(null);
        this.llUpgradePlan.setTag(null);
        this.loader.setTag(null);
        NestedScrollView nestedScrollView = (NestedScrollView) bindings[0];
        this.mboundView0 = nestedScrollView;
        nestedScrollView.setTag(null);
        TextView textView = (TextView) bindings[6];
        this.mboundView6 = textView;
        textView.setTag(null);
        this.paymentButton.setTag(null);
        this.rateLabel.setTag(null);
        this.tvPlanLitres.setTag(null);
        this.tvPlanName.setTag(null);
        this.tvplanAmount.setTag(null);
        setRootTag(root);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
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
            setViewModel((AddLitresViewModel) variable);
            return true;
        }
        return false;
    }

    @Override // com.livpure.safedrink.databinding.FragmentAddLitresBinding
    public void setViewModel(AddLitresViewModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
        }
        notifyPropertyChanged(18);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0:
                return onChangeViewModelUpgradePlanNameText((MediatorLiveData) object, fieldId);
            case 1:
                return onChangeViewModelLoading((MutableLiveData) object, fieldId);
            case 2:
                return onChangeViewModelPayButtonEnabled((LiveData) object, fieldId);
            case 3:
                return onChangeViewModelAdditionalLitres((MutableLiveData) object, fieldId);
            case 4:
                return onChangeViewModelRatePerLitreLabel((LiveData) object, fieldId);
            case 5:
                return onChangeViewModelUpgradePlanAmountText((MediatorLiveData) object, fieldId);
            case 6:
                return onChangeViewModelUpgradePlanLitresText((MediatorLiveData) object, fieldId);
            case 7:
                return onChangeViewModelUpgradePlanText((MediatorLiveData) object, fieldId);
            case 8:
                return onChangeViewModelUpgradePlanView((MutableLiveData) object, fieldId);
            case 9:
                return onChangeViewModelPayButtonText((MediatorLiveData) object, fieldId);
            default:
                return false;
        }
    }

    private boolean onChangeViewModelUpgradePlanNameText(MediatorLiveData<String> ViewModelUpgradePlanNameText, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewModelLoading(MutableLiveData<Boolean> ViewModelLoading, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewModelPayButtonEnabled(LiveData<Boolean> ViewModelPayButtonEnabled, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewModelAdditionalLitres(MutableLiveData<String> ViewModelAdditionalLitres, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewModelRatePerLitreLabel(LiveData<String> ViewModelRatePerLitreLabel, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewModelUpgradePlanAmountText(MediatorLiveData<String> ViewModelUpgradePlanAmountText, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewModelUpgradePlanLitresText(MediatorLiveData<String> ViewModelUpgradePlanLitresText, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewModelUpgradePlanText(MediatorLiveData<String> ViewModelUpgradePlanText, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewModelUpgradePlanView(MutableLiveData<Boolean> ViewModelUpgradePlanView, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewModelPayButtonText(MediatorLiveData<String> ViewModelPayButtonText, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0132  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 640
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.livpure.safedrink.databinding.FragmentAddLitresBindingImpl.executeBindings():void");
    }
}
