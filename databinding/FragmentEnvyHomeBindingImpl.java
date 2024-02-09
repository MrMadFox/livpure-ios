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
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.MutableLiveData;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.github.mikephil.charting.charts.BarChart;
import com.livpure.safedrink.R;
import com.livpure.safedrink.dispenser.model.EnvyHomeViewModel;
/* loaded from: classes3.dex */
public class FragmentEnvyHomeBindingImpl extends FragmentEnvyHomeBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.homeContainer, 2);
        sparseIntArray.put(R.id.consumptionDashboard, 3);
        sparseIntArray.put(R.id.boltSettingsLL, 4);
        sparseIntArray.put(R.id.lastSynchronized, 5);
        sparseIntArray.put(R.id.bleSyncIV, 6);
        sparseIntArray.put(R.id.bleInfoIV, 7);
        sparseIntArray.put(R.id.wifiInfoIV, 8);
        sparseIntArray.put(R.id.settingsIV, 9);
        sparseIntArray.put(R.id.readingSection, 10);
        sparseIntArray.put(R.id.waterUsageImage, 11);
        sparseIntArray.put(R.id.remainingWaterLabel, 12);
        sparseIntArray.put(R.id.waterremainLL, 13);
        sparseIntArray.put(R.id.waterRemainingTenThousand, 14);
        sparseIntArray.put(R.id.waterRemainingThousands, 15);
        sparseIntArray.put(R.id.waterRemainingHundreds, 16);
        sparseIntArray.put(R.id.waterRemainingTens, 17);
        sparseIntArray.put(R.id.waterRemainingOnes, 18);
        sparseIntArray.put(R.id.makePaymentDiabled, 19);
        sparseIntArray.put(R.id.makePayment, 20);
        sparseIntArray.put(R.id.horizontalMiddleGuidline, 21);
        sparseIntArray.put(R.id.renewPlan, 22);
        sparseIntArray.put(R.id.addLitres, 23);
        sparseIntArray.put(R.id.serviceRequest, 24);
        sparseIntArray.put(R.id.llRaiseAserviceComplaint, 25);
        sparseIntArray.put(R.id.center, 26);
        sparseIntArray.put(R.id.planDetailsContainer, 27);
        sparseIntArray.put(R.id.planDetailsLabel, 28);
        sparseIntArray.put(R.id.planDetails, 29);
        sparseIntArray.put(R.id.partitionView1, 30);
        sparseIntArray.put(R.id.filterLifeContainer, 31);
        sparseIntArray.put(R.id.filterLifeLabel, 32);
        sparseIntArray.put(R.id.filterLifeImage, 33);
        sparseIntArray.put(R.id.refereFriendLL, 34);
        sparseIntArray.put(R.id.refereFriendImage, 35);
        sparseIntArray.put(R.id.knowMoreLL, 36);
        sparseIntArray.put(R.id.inviteFriend, 37);
        sparseIntArray.put(R.id.dailyConsumptionLabe, 38);
        sparseIntArray.put(R.id.barChart, 39);
        sparseIntArray.put(R.id.averageWaterConsumption, 40);
        sparseIntArray.put(R.id.middleVerticalGuide, 41);
    }

    public FragmentEnvyHomeBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 42, sIncludes, sViewsWithIds));
    }

    private FragmentEnvyHomeBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1, (Button) bindings[23], (TextView) bindings[40], (BarChart) bindings[39], (ImageView) bindings[7], (ImageView) bindings[6], (LinearLayout) bindings[4], (LinearLayout) bindings[26], (ConstraintLayout) bindings[3], (TextView) bindings[38], (LinearLayout) bindings[31], (ImageView) bindings[33], (TextView) bindings[32], (ConstraintLayout) bindings[2], (Guideline) bindings[21], (ImageView) bindings[37], (LinearLayout) bindings[36], (TextView) bindings[5], (LinearLayout) bindings[25], (ProgressBar) bindings[1], (Button) bindings[20], (Button) bindings[19], (Guideline) bindings[41], (View) bindings[30], (TextView) bindings[29], (LinearLayout) bindings[27], (TextView) bindings[28], (ConstraintLayout) bindings[10], (ImageView) bindings[35], (LinearLayout) bindings[34], (TextView) bindings[12], (Button) bindings[22], (ConstraintLayout) bindings[24], (ImageView) bindings[9], (SwipeRefreshLayout) bindings[0], (TextView) bindings[16], (TextView) bindings[18], (TextView) bindings[14], (TextView) bindings[17], (TextView) bindings[15], (ImageView) bindings[11], (LinearLayout) bindings[13], (ImageView) bindings[8]);
        this.mDirtyFlags = -1L;
        this.loader.setTag(null);
        this.swipeToRefresh.setTag(null);
        setRootTag(root);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 4L;
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
            setViewModel((EnvyHomeViewModel) variable);
            return true;
        }
        return false;
    }

    @Override // com.livpure.safedrink.databinding.FragmentEnvyHomeBinding
    public void setViewModel(EnvyHomeViewModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(18);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId != 0) {
            return false;
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

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        EnvyHomeViewModel envyHomeViewModel = this.mViewModel;
        int i = 0;
        int i2 = ((j & 7) > 0L ? 1 : ((j & 7) == 0L ? 0 : -1));
        if (i2 != 0) {
            MutableLiveData<Boolean> loading = envyHomeViewModel != null ? envyHomeViewModel.getLoading() : null;
            updateLiveDataRegistration(0, loading);
            boolean safeUnbox = ViewDataBinding.safeUnbox(loading != null ? loading.getValue() : null);
            if (i2 != 0) {
                j |= safeUnbox ? 16L : 8L;
            }
            if (!safeUnbox) {
                i = 8;
            }
        }
        if ((j & 7) != 0) {
            this.loader.setVisibility(i);
        }
    }
}
