package com.livpure.safedrink.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.viewpager2.widget.ViewPager2;
import com.livpure.safedrink.R;
import com.livpure.safedrink.app.DeviceHomeViewModel;
import com.livpure.safedrink.generated.callback.OnClickListener;
import com.livpure.safedrink.subscription.plan.data.model.deviceList.DeviceList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
/* loaded from: classes3.dex */
public class FragmentDeviceHomeBindingImpl extends FragmentDeviceHomeBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback18;
    private long mDirtyFlags;
    private final NestedScrollView mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.homeContainer, 12);
        sparseIntArray.put(R.id.airPurifier, 13);
        sparseIntArray.put(R.id.refereFriendLL, 14);
        sparseIntArray.put(R.id.refereFriendImage, 15);
        sparseIntArray.put(R.id.knowMoreLL, 16);
        sparseIntArray.put(R.id.inviteFriend, 17);
        sparseIntArray.put(R.id.startGuide, 18);
        sparseIntArray.put(R.id.endGuide, 19);
        sparseIntArray.put(R.id.middleVerticalGuide, 20);
    }

    public FragmentDeviceHomeBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 21, sIncludes, sViewsWithIds));
    }

    private FragmentDeviceHomeBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 8, (Button) bindings[8], (ConstraintLayout) bindings[6], (TextView) bindings[7], (Button) bindings[13], (ConstraintLayout) bindings[1], (ViewPager2) bindings[5], (ViewPager2) bindings[3], (Guideline) bindings[19], (TextView) bindings[10], (ImageView) bindings[9], (ConstraintLayout) bindings[12], (ImageView) bindings[17], (LinearLayout) bindings[16], (ProgressBar) bindings[11], (Guideline) bindings[20], (ImageView) bindings[15], (LinearLayout) bindings[14], (TextView) bindings[2], (TextView) bindings[4], (Guideline) bindings[18]);
        this.mDirtyFlags = -1L;
        this.actionButton.setTag(null);
        this.actionContainer.setTag(null);
        this.actionLabel.setTag(null);
        this.consumptionDashboard.setTag(null);
        this.deviceAirPurifierViewPager.setTag(null);
        this.deviceViewPager.setTag(null);
        this.hintHeader.setTag(null);
        this.hintImage.setTag(null);
        this.loader.setTag(null);
        NestedScrollView nestedScrollView = (NestedScrollView) bindings[0];
        this.mboundView0 = nestedScrollView;
        nestedScrollView.setTag(null);
        this.selectPlanLabel.setTag(null);
        this.selectPlanLabel1.setTag(null);
        setRootTag(root);
        this.mCallback18 = new OnClickListener(this, 1);
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
        if (18 == variableId) {
            setViewModel((DeviceHomeViewModel) variable);
            return true;
        }
        return false;
    }

    @Override // com.livpure.safedrink.databinding.FragmentDeviceHomeBinding
    public void setViewModel(DeviceHomeViewModel ViewModel) {
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
                return onChangeViewModelDevice((MediatorLiveData) object, fieldId);
            case 1:
                return onChangeViewModelHintLabel((MutableLiveData) object, fieldId);
            case 2:
                return onChangeViewModelAirPurifierDevices((MediatorLiveData) object, fieldId);
            case 3:
                return onChangeViewModelHintHeaderText((MutableLiveData) object, fieldId);
            case 4:
                return onChangeViewModelHintVisibility((MutableLiveData) object, fieldId);
            case 5:
                return onChangeViewModelHintImageResId((MutableLiveData) object, fieldId);
            case 6:
                return onChangeViewModelHintButtonText((MutableLiveData) object, fieldId);
            case 7:
                return onChangeViewModelLoading((MutableLiveData) object, fieldId);
            default:
                return false;
        }
    }

    private boolean onChangeViewModelDevice(MediatorLiveData<List<DeviceList>> ViewModelDevice, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewModelHintLabel(MutableLiveData<String> ViewModelHintLabel, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewModelAirPurifierDevices(MediatorLiveData<List<DeviceList>> ViewModelAirPurifierDevices, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewModelHintHeaderText(MutableLiveData<String> ViewModelHintHeaderText, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewModelHintVisibility(MutableLiveData<Boolean> ViewModelHintVisibility, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewModelHintImageResId(MutableLiveData<Integer> ViewModelHintImageResId, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewModelHintButtonText(MutableLiveData<String> ViewModelHintButtonText, int fieldId) {
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

    /* JADX WARN: Removed duplicated region for block: B:105:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0100  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 604
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.livpure.safedrink.databinding.FragmentDeviceHomeBindingImpl.executeBindings():void");
    }

    @Override // com.livpure.safedrink.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        DeviceHomeViewModel deviceHomeViewModel = this.mViewModel;
        if (deviceHomeViewModel != null) {
            Function0<Unit> onHintButtonClick = deviceHomeViewModel.getOnHintButtonClick();
            if (onHintButtonClick != null) {
                onHintButtonClick.invoke();
            }
        }
    }
}
