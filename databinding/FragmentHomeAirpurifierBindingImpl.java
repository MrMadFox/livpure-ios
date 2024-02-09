package com.livpure.safedrink.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.livpure.safedrink.R;
import com.livpure.safedrink.airpurifier.model.HomePurifierModel;
/* loaded from: classes3.dex */
public class FragmentHomeAirpurifierBindingImpl extends FragmentHomeAirpurifierBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final CoordinatorLayout mboundView0;
    private final TextView mboundView1;
    private final TextView mboundView10;
    private final TextView mboundView11;
    private final TextView mboundView12;
    private final TextView mboundView13;
    private final TextView mboundView14;
    private final TextView mboundView2;
    private final TextView mboundView3;
    private final TextView mboundView4;
    private final TextView mboundView5;
    private final TextView mboundView6;
    private final TextView mboundView7;
    private final TextView mboundView8;
    private final TextView mboundView9;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(39);
        sIncludes = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"dialog_air_purifier_bottom_sheet"}, new int[]{15}, new int[]{R.layout.dialog_air_purifier_bottom_sheet});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.swipe_refresh_layout_comments, 16);
        sparseIntArray.put(R.id.lytParentScrollView, 17);
        sparseIntArray.put(R.id.bleInfoIV, 18);
        sparseIntArray.put(R.id.wifiInfoIV, 19);
        sparseIntArray.put(R.id.settingsIV, 20);
        sparseIntArray.put(R.id.waterUsageImage, 21);
        sparseIntArray.put(R.id.renewPlan, 22);
        sparseIntArray.put(R.id.addAir, 23);
        sparseIntArray.put(R.id.openOutdoor, 24);
        sparseIntArray.put(R.id.closeOutdoor, 25);
        sparseIntArray.put(R.id.listBottomOptionId, 26);
        sparseIntArray.put(R.id.lytOnId, 27);
        sparseIntArray.put(R.id.ivPowerOnImage, 28);
        sparseIntArray.put(R.id.lytModeId, 29);
        sparseIntArray.put(R.id.ivModeImage, 30);
        sparseIntArray.put(R.id.lytFanId, 31);
        sparseIntArray.put(R.id.ivFanImage, 32);
        sparseIntArray.put(R.id.lytIonsId, 33);
        sparseIntArray.put(R.id.ivIonsImage, 34);
        sparseIntArray.put(R.id.lytLockId, 35);
        sparseIntArray.put(R.id.ivLockImage, 36);
        sparseIntArray.put(R.id.lytTimerId, 37);
        sparseIntArray.put(R.id.ivTimerImage, 38);
    }

    public FragmentHomeAirpurifierBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 39, sIncludes, sViewsWithIds));
    }

    private FragmentHomeAirpurifierBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 15, (TextView) bindings[23], (ImageView) bindings[18], (LinearLayout) bindings[25], (DialogAirPurifierBottomSheetBinding) bindings[15], (ImageView) bindings[32], (ImageView) bindings[34], (ImageView) bindings[36], (ImageView) bindings[30], (ImageView) bindings[28], (ImageView) bindings[38], (RecyclerView) bindings[26], (LinearLayout) bindings[31], (LinearLayout) bindings[33], (LinearLayout) bindings[35], (LinearLayout) bindings[29], (LinearLayout) bindings[27], (ScrollView) bindings[17], (LinearLayout) bindings[37], (LinearLayout) bindings[24], (TextView) bindings[22], (ImageView) bindings[20], (SwipeRefreshLayout) bindings[16], (ImageView) bindings[21], (ImageView) bindings[19]);
        this.mDirtyFlags = -1L;
        setContainedBinding(this.includeBottomSheetId);
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) bindings[0];
        this.mboundView0 = coordinatorLayout;
        coordinatorLayout.setTag(null);
        TextView textView = (TextView) bindings[1];
        this.mboundView1 = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) bindings[10];
        this.mboundView10 = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) bindings[11];
        this.mboundView11 = textView3;
        textView3.setTag(null);
        TextView textView4 = (TextView) bindings[12];
        this.mboundView12 = textView4;
        textView4.setTag(null);
        TextView textView5 = (TextView) bindings[13];
        this.mboundView13 = textView5;
        textView5.setTag(null);
        TextView textView6 = (TextView) bindings[14];
        this.mboundView14 = textView6;
        textView6.setTag(null);
        TextView textView7 = (TextView) bindings[2];
        this.mboundView2 = textView7;
        textView7.setTag(null);
        TextView textView8 = (TextView) bindings[3];
        this.mboundView3 = textView8;
        textView8.setTag(null);
        TextView textView9 = (TextView) bindings[4];
        this.mboundView4 = textView9;
        textView9.setTag(null);
        TextView textView10 = (TextView) bindings[5];
        this.mboundView5 = textView10;
        textView10.setTag(null);
        TextView textView11 = (TextView) bindings[6];
        this.mboundView6 = textView11;
        textView11.setTag(null);
        TextView textView12 = (TextView) bindings[7];
        this.mboundView7 = textView12;
        textView12.setTag(null);
        TextView textView13 = (TextView) bindings[8];
        this.mboundView8 = textView13;
        textView13.setTag(null);
        TextView textView14 = (TextView) bindings[9];
        this.mboundView9 = textView14;
        textView14.setTag(null);
        setRootTag(root);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 65536L;
        }
        this.includeBottomSheetId.invalidateAll();
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.mDirtyFlags != 0) {
                return true;
            }
            return this.includeBottomSheetId.hasPendingBindings();
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int variableId, Object variable) {
        if (18 == variableId) {
            setViewModel((HomePurifierModel) variable);
            return true;
        }
        return false;
    }

    @Override // com.livpure.safedrink.databinding.FragmentHomeAirpurifierBinding
    public void setViewModel(HomePurifierModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
        }
        notifyPropertyChanged(18);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.includeBottomSheetId.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0:
                return onChangeViewModelTemperatureText((MutableLiveData) object, fieldId);
            case 1:
                return onChangeViewModelOutdoorTemperature((MutableLiveData) object, fieldId);
            case 2:
                return onChangeViewModelValidityDateText((MutableLiveData) object, fieldId);
            case 3:
                return onChangeViewModelTvocText((MutableLiveData) object, fieldId);
            case 4:
                return onChangeViewModelLastSyncText((MutableLiveData) object, fieldId);
            case 5:
                return onChangeViewModelOutdoorHumidity((MutableLiveData) object, fieldId);
            case 6:
                return onChangeViewModelCountDownRem((MutableLiveData) object, fieldId);
            case 7:
                return onChangeViewModelRunningTime((MutableLiveData) object, fieldId);
            case 8:
                return onChangeIncludeBottomSheetId((DialogAirPurifierBottomSheetBinding) object, fieldId);
            case 9:
                return onChangeViewModelHumidityTest((MutableLiveData) object, fieldId);
            case 10:
                return onChangeViewModelPlanName((MutableLiveData) object, fieldId);
            case 11:
                return onChangeViewModelOutdoorPm25Text((MutableLiveData) object, fieldId);
            case 12:
                return onChangeViewModelFilterLife((MutableLiveData) object, fieldId);
            case 13:
                return onChangeViewModelPm25Text((MutableLiveData) object, fieldId);
            case 14:
                return onChangeViewModelBalanceAmount((MutableLiveData) object, fieldId);
            default:
                return false;
        }
    }

    private boolean onChangeViewModelTemperatureText(MutableLiveData<String> ViewModelTemperatureText, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewModelOutdoorTemperature(MutableLiveData<String> ViewModelOutdoorTemperature, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewModelValidityDateText(MutableLiveData<String> ViewModelValidityDateText, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewModelTvocText(MutableLiveData<String> ViewModelTvocText, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewModelLastSyncText(MutableLiveData<String> ViewModelLastSyncText, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewModelOutdoorHumidity(MutableLiveData<String> ViewModelOutdoorHumidity, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewModelCountDownRem(MutableLiveData<String> ViewModelCountDownRem, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewModelRunningTime(MutableLiveData<String> ViewModelRunningTime, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeIncludeBottomSheetId(DialogAirPurifierBottomSheetBinding IncludeBottomSheetId, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewModelHumidityTest(MutableLiveData<String> ViewModelHumidityTest, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewModelPlanName(MutableLiveData<String> ViewModelPlanName, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewModelOutdoorPm25Text(MutableLiveData<String> ViewModelOutdoorPm25Text, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewModelFilterLife(MutableLiveData<String> ViewModelFilterLife, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewModelPm25Text(MutableLiveData<String> ViewModelPm25Text, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewModelBalanceAmount(MutableLiveData<String> ViewModelBalanceAmount, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 16384;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0241  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01aa  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 846
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.livpure.safedrink.databinding.FragmentHomeAirpurifierBindingImpl.executeBindings():void");
    }
}
