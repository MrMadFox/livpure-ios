package com.livpure.safedrink.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.MutableLiveData;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.github.mikephil.charting.charts.BarChart;
import com.livpure.safedrink.R;
import com.livpure.safedrink.dispenser.model.HomeAirToWaterModel;
import pl.droidsonroids.gif.GifImageView;
/* loaded from: classes3.dex */
public class FragmentAirtowaterBindingImpl extends FragmentAirtowaterBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final CoordinatorLayout mboundView0;
    private final TextView mboundView4;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.swipeToRefresh, 6);
        sparseIntArray.put(R.id.lytParentScrollView, 7);
        sparseIntArray.put(R.id.boltSettingsLL, 8);
        sparseIntArray.put(R.id.lastSynchronized, 9);
        sparseIntArray.put(R.id.wifiInfoIV, 10);
        sparseIntArray.put(R.id.bleInfoIV, 11);
        sparseIntArray.put(R.id.settingsIV, 12);
        sparseIntArray.put(R.id.tvTemprature, 13);
        sparseIntArray.put(R.id.ivTankStatus, 14);
        sparseIntArray.put(R.id.tvHumidity, 15);
        sparseIntArray.put(R.id.readingSection, 16);
        sparseIntArray.put(R.id.uvStatusImage, 17);
        sparseIntArray.put(R.id.remainingWaterLabel, 18);
        sparseIntArray.put(R.id.waterremainLL, 19);
        sparseIntArray.put(R.id.waterRemainingHundredThousands, 20);
        sparseIntArray.put(R.id.waterRemainingTenThousands, 21);
        sparseIntArray.put(R.id.waterRemainingThousands, 22);
        sparseIntArray.put(R.id.waterRemainingHundreds, 23);
        sparseIntArray.put(R.id.waterRemainingTens, 24);
        sparseIntArray.put(R.id.waterRemainingOnes, 25);
        sparseIntArray.put(R.id.renewPlan, 26);
        sparseIntArray.put(R.id.addLitres, 27);
        sparseIntArray.put(R.id.inTankll, 28);
        sparseIntArray.put(R.id.coldTankImage, 29);
        sparseIntArray.put(R.id.collectionTankImage, 30);
        sparseIntArray.put(R.id.center, 31);
        sparseIntArray.put(R.id.planDetailsContainer, 32);
        sparseIntArray.put(R.id.planDetailsLabel, 33);
        sparseIntArray.put(R.id.planDetails, 34);
        sparseIntArray.put(R.id.partitionView1, 35);
        sparseIntArray.put(R.id.filterLifeContainer, 36);
        sparseIntArray.put(R.id.filterLifeLabel, 37);
        sparseIntArray.put(R.id.filterLifeImage, 38);
        sparseIntArray.put(R.id.tdsBandContainer, 39);
        sparseIntArray.put(R.id.tdsBandLabel, 40);
        sparseIntArray.put(R.id.tdsBandImage, 41);
        sparseIntArray.put(R.id.graph, 42);
        sparseIntArray.put(R.id.dailyConsumption, 43);
        sparseIntArray.put(R.id.barChart, 44);
        sparseIntArray.put(R.id.averageWaterConsumption, 45);
        sparseIntArray.put(R.id.warning, 46);
        sparseIntArray.put(R.id.lytHotWaterId, 47);
        sparseIntArray.put(R.id.ivHotWaterImage, 48);
        sparseIntArray.put(R.id.lytWaterGenerationId, 49);
        sparseIntArray.put(R.id.ivWaterGenerationImage, 50);
        sparseIntArray.put(R.id.lytQuietModeId, 51);
        sparseIntArray.put(R.id.ivQuietModeImage, 52);
    }

    public FragmentAirtowaterBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 53, sIncludes, sViewsWithIds));
    }

    private FragmentAirtowaterBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 4, (TextView) bindings[27], (TextView) bindings[45], (BarChart) bindings[44], (ImageView) bindings[11], (LinearLayout) bindings[8], (LinearLayout) bindings[31], (ImageView) bindings[29], (ImageView) bindings[30], (TextView) bindings[43], (LinearLayout) bindings[36], (ImageView) bindings[38], (TextView) bindings[37], (GifImageView) bindings[2], (LinearLayout) bindings[42], (LinearLayout) bindings[28], (ImageView) bindings[48], (ImageView) bindings[52], (ImageView) bindings[14], (ImageView) bindings[50], (TextView) bindings[9], (LinearLayout) bindings[47], (ScrollView) bindings[7], (LinearLayout) bindings[51], (LinearLayout) bindings[49], (View) bindings[35], (TextView) bindings[34], (LinearLayout) bindings[32], (TextView) bindings[33], (ConstraintLayout) bindings[16], (TextView) bindings[18], (TextView) bindings[26], (ImageView) bindings[12], (SwipeRefreshLayout) bindings[6], (LinearLayout) bindings[39], (ImageView) bindings[41], (TextView) bindings[40], (TextView) bindings[3], (TextView) bindings[15], (TextView) bindings[13], (ImageView) bindings[17], (LinearLayout) bindings[46], (TextView) bindings[5], (ImageView) bindings[1], (TextView) bindings[20], (TextView) bindings[23], (TextView) bindings[25], (TextView) bindings[21], (TextView) bindings[24], (TextView) bindings[22], (LinearLayout) bindings[19], (ImageView) bindings[10]);
        this.mDirtyFlags = -1L;
        this.gifTankStatus.setTag(null);
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) bindings[0];
        this.mboundView0 = coordinatorLayout;
        coordinatorLayout.setTag(null);
        TextView textView = (TextView) bindings[4];
        this.mboundView4 = textView;
        textView.setTag(null);
        this.tvColdTankStatus.setTag(null);
        this.warningMessage.setTag(null);
        this.waterDispenseUsageImage.setTag(null);
        setRootTag(root);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 32L;
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
            setViewModel((HomeAirToWaterModel) variable);
            return true;
        }
        return false;
    }

    @Override // com.livpure.safedrink.databinding.FragmentAirtowaterBinding
    public void setViewModel(HomeAirToWaterModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 16;
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
                        return false;
                    }
                    return onChangeViewModelWaterPurificationStatus((MutableLiveData) object, fieldId);
                }
                return onChangeViewModelColdTankStatus((MutableLiveData) object, fieldId);
            }
            return onChangeViewModelWaterGenerationStatus((MutableLiveData) object, fieldId);
        }
        return onChangeViewModelFaultDescription((MutableLiveData) object, fieldId);
    }

    private boolean onChangeViewModelFaultDescription(MutableLiveData<String> ViewModelFaultDescription, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewModelWaterGenerationStatus(MutableLiveData<String> ViewModelWaterGenerationStatus, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewModelColdTankStatus(MutableLiveData<String> ViewModelColdTankStatus, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewModelWaterPurificationStatus(MutableLiveData<Boolean> ViewModelWaterPurificationStatus, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00b7  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 249
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.livpure.safedrink.databinding.FragmentAirtowaterBindingImpl.executeBindings():void");
    }
}
