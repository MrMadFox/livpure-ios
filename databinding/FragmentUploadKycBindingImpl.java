package com.livpure.safedrink.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.livpure.safedrink.R;
import com.livpure.safedrink.app.MainViewModel;
import com.livpure.safedrink.generated.callback.OnClickListener;
import com.livpure.safedrink.login.data.models.User;
import com.livpure.safedrink.subscription.kyc.viewmodel.UploadKYCViewModel;
/* loaded from: classes3.dex */
public class FragmentUploadKycBindingImpl extends FragmentUploadKycBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private InverseBindingListener addressProofSpinnerandroidSelectedItemPositionAttrChanged;
    private InverseBindingListener idProofSpinnerandroidSelectedItemPositionAttrChanged;
    private final View.OnClickListener mCallback2;
    private final View.OnClickListener mCallback3;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;
    private final TextView mboundView1;
    private InverseBindingListener salutationSpinnerandroidSelectedItemPositionAttrChanged;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.thankYouContainer, 10);
        sparseIntArray.put(R.id.textView3, 11);
        sparseIntArray.put(R.id.fileFormatMessage, 12);
    }

    public FragmentUploadKycBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 13, sIncludes, sViewsWithIds));
    }

    private FragmentUploadKycBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 9, (Spinner) bindings[4], (Button) bindings[5], (TextView) bindings[12], (Spinner) bindings[6], (Button) bindings[7], (ProgressBar) bindings[9], (TextView) bindings[3], (Spinner) bindings[2], (Button) bindings[8], (TextView) bindings[11], (LinearLayout) bindings[10]);
        this.addressProofSpinnerandroidSelectedItemPositionAttrChanged = new InverseBindingListener() { // from class: com.livpure.safedrink.databinding.FragmentUploadKycBindingImpl.1
            @Override // androidx.databinding.InverseBindingListener
            public void onChange() {
                int selectedItemPosition = FragmentUploadKycBindingImpl.this.addressProofSpinner.getSelectedItemPosition();
                UploadKYCViewModel uploadKYCViewModel = FragmentUploadKycBindingImpl.this.mViewModel;
                if (uploadKYCViewModel != null) {
                    MutableLiveData<Integer> selectedAddressProofPosition = uploadKYCViewModel.getSelectedAddressProofPosition();
                    if (selectedAddressProofPosition != null) {
                        selectedAddressProofPosition.setValue(Integer.valueOf(selectedItemPosition));
                    }
                }
            }
        };
        this.idProofSpinnerandroidSelectedItemPositionAttrChanged = new InverseBindingListener() { // from class: com.livpure.safedrink.databinding.FragmentUploadKycBindingImpl.2
            @Override // androidx.databinding.InverseBindingListener
            public void onChange() {
                int selectedItemPosition = FragmentUploadKycBindingImpl.this.idProofSpinner.getSelectedItemPosition();
                UploadKYCViewModel uploadKYCViewModel = FragmentUploadKycBindingImpl.this.mViewModel;
                if (uploadKYCViewModel != null) {
                    MutableLiveData<Integer> selectedIdProofPosition = uploadKYCViewModel.getSelectedIdProofPosition();
                    if (selectedIdProofPosition != null) {
                        selectedIdProofPosition.setValue(Integer.valueOf(selectedItemPosition));
                    }
                }
            }
        };
        this.salutationSpinnerandroidSelectedItemPositionAttrChanged = new InverseBindingListener() { // from class: com.livpure.safedrink.databinding.FragmentUploadKycBindingImpl.3
            @Override // androidx.databinding.InverseBindingListener
            public void onChange() {
                int selectedItemPosition = FragmentUploadKycBindingImpl.this.salutationSpinner.getSelectedItemPosition();
                UploadKYCViewModel uploadKYCViewModel = FragmentUploadKycBindingImpl.this.mViewModel;
                if (uploadKYCViewModel != null) {
                    MutableLiveData<Integer> selectedSalutationPosition = uploadKYCViewModel.getSelectedSalutationPosition();
                    if (selectedSalutationPosition != null) {
                        selectedSalutationPosition.setValue(Integer.valueOf(selectedItemPosition));
                    }
                }
            }
        };
        this.mDirtyFlags = -1L;
        this.addressProofSpinner.setTag(null);
        this.addressProofUploadButton.setTag(null);
        this.idProofSpinner.setTag(null);
        this.idProofUploadButton.setTag(null);
        this.loader.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) bindings[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) bindings[1];
        this.mboundView1 = textView;
        textView.setTag(null);
        this.name.setTag(null);
        this.salutationSpinner.setTag(null);
        this.submitButton.setTag(null);
        setRootTag(root);
        this.mCallback2 = new OnClickListener(this, 1);
        this.mCallback3 = new OnClickListener(this, 2);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = PlaybackStateCompat.ACTION_PLAY_FROM_URI;
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
        if (9 == variableId) {
            setPaymentId((String) variable);
            return true;
        } else if (16 == variableId) {
            setUser((User) variable);
            return true;
        } else if (1 == variableId) {
            setActivityViewModel((MainViewModel) variable);
            return true;
        } else if (18 == variableId) {
            setViewModel((UploadKYCViewModel) variable);
            return true;
        } else {
            return false;
        }
    }

    @Override // com.livpure.safedrink.databinding.FragmentUploadKycBinding
    public void setPaymentId(String PaymentId) {
        this.mPaymentId = PaymentId;
        synchronized (this) {
            this.mDirtyFlags |= 512;
        }
        notifyPropertyChanged(9);
        super.requestRebind();
    }

    @Override // com.livpure.safedrink.databinding.FragmentUploadKycBinding
    public void setUser(User User) {
        this.mUser = User;
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
        }
        notifyPropertyChanged(16);
        super.requestRebind();
    }

    @Override // com.livpure.safedrink.databinding.FragmentUploadKycBinding
    public void setActivityViewModel(MainViewModel ActivityViewModel) {
        this.mActivityViewModel = ActivityViewModel;
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
        }
        notifyPropertyChanged(1);
        super.requestRebind();
    }

    @Override // com.livpure.safedrink.databinding.FragmentUploadKycBinding
    public void setViewModel(UploadKYCViewModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
        }
        notifyPropertyChanged(18);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0:
                return onChangeActivityViewModelLoading((MutableLiveData) object, fieldId);
            case 1:
                return onChangeViewModelSelectedIdProofPosition((MutableLiveData) object, fieldId);
            case 2:
                return onChangeViewModelSelectedAddressProof((LiveData) object, fieldId);
            case 3:
                return onChangeViewModelSelectedAddressProofPosition((MutableLiveData) object, fieldId);
            case 4:
                return onChangeActivityViewModelAddressProofFile((MutableLiveData) object, fieldId);
            case 5:
                return onChangeViewModelLoading((MutableLiveData) object, fieldId);
            case 6:
                return onChangeViewModelSelectedIdProof((LiveData) object, fieldId);
            case 7:
                return onChangeViewModelSelectedSalutationPosition((MutableLiveData) object, fieldId);
            case 8:
                return onChangeActivityViewModelIdProofFile((MutableLiveData) object, fieldId);
            default:
                return false;
        }
    }

    private boolean onChangeActivityViewModelLoading(MutableLiveData<Boolean> ActivityViewModelLoading, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewModelSelectedIdProofPosition(MutableLiveData<Integer> ViewModelSelectedIdProofPosition, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewModelSelectedAddressProof(LiveData<String> ViewModelSelectedAddressProof, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewModelSelectedAddressProofPosition(MutableLiveData<Integer> ViewModelSelectedAddressProofPosition, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeActivityViewModelAddressProofFile(MutableLiveData<String> ActivityViewModelAddressProofFile, int fieldId) {
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

    private boolean onChangeViewModelSelectedIdProof(LiveData<String> ViewModelSelectedIdProof, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewModelSelectedSalutationPosition(MutableLiveData<Integer> ViewModelSelectedSalutationPosition, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeActivityViewModelIdProofFile(MutableLiveData<String> ActivityViewModelIdProofFile, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:158:0x028f  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x02a6  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0328  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x033f  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x034f  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0357  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x035f  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0367  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x0382  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x038d  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x039c  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x03a4  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x03b1  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x03e1  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x03ef  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x040c  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x0417  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x041e  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x043b  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x0446  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x0454  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x0469  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x0476  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x0483  */
    /* JADX WARN: Removed duplicated region for block: B:270:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x016b  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 1166
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.livpure.safedrink.databinding.FragmentUploadKycBindingImpl.executeBindings():void");
    }

    @Override // com.livpure.safedrink.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        if (sourceId == 1) {
            UploadKYCViewModel uploadKYCViewModel = this.mViewModel;
            if (uploadKYCViewModel != null) {
                uploadKYCViewModel.onUploadAddressProofClicked();
            }
        } else if (sourceId != 2) {
        } else {
            UploadKYCViewModel uploadKYCViewModel2 = this.mViewModel;
            if (uploadKYCViewModel2 != null) {
                uploadKYCViewModel2.onUploadIDProofClicked();
            }
        }
    }
}
