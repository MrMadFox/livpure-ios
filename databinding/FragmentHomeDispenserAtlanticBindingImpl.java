package com.livpure.safedrink.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.github.mikephil.charting.charts.BarChart;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.livpure.safedrink.R;
import com.livpure.safedrink.dispenser.model.HomeDispenserAtlanticModel;
/* loaded from: classes3.dex */
public class FragmentHomeDispenserAtlanticBindingImpl extends FragmentHomeDispenserAtlanticBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final TextView mboundView1;
    private final TextView mboundView2;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.lytParentScrollView, 4);
        sparseIntArray.put(R.id.boltSettingsLL, 5);
        sparseIntArray.put(R.id.lastSynchronized, 6);
        sparseIntArray.put(R.id.wifiInfoIV, 7);
        sparseIntArray.put(R.id.bleInfoIV, 8);
        sparseIntArray.put(R.id.settingsIV, 9);
        sparseIntArray.put(R.id.hotColdInfo, 10);
        sparseIntArray.put(R.id.llHotWaterClick, 11);
        sparseIntArray.put(R.id.hotWaterImage, 12);
        sparseIntArray.put(R.id.llColdWaterClick, 13);
        sparseIntArray.put(R.id.coldWaterImage, 14);
        sparseIntArray.put(R.id.readingSection, 15);
        sparseIntArray.put(R.id.waterDispenseUsageImage, 16);
        sparseIntArray.put(R.id.remainingWaterLabel, 17);
        sparseIntArray.put(R.id.waterremainLL, 18);
        sparseIntArray.put(R.id.waterRemainingHundredThousands, 19);
        sparseIntArray.put(R.id.waterRemainingTenThousands, 20);
        sparseIntArray.put(R.id.waterRemainingThousands, 21);
        sparseIntArray.put(R.id.waterRemainingHundreds, 22);
        sparseIntArray.put(R.id.waterRemainingTens, 23);
        sparseIntArray.put(R.id.waterRemainingOnes, 24);
        sparseIntArray.put(R.id.renewPlan, 25);
        sparseIntArray.put(R.id.addLitres, 26);
        sparseIntArray.put(R.id.serviceRequest, 27);
        sparseIntArray.put(R.id.llRaiseAserviceComplaint, 28);
        sparseIntArray.put(R.id.center, 29);
        sparseIntArray.put(R.id.planDetailsContainer, 30);
        sparseIntArray.put(R.id.planDetailsLabel, 31);
        sparseIntArray.put(R.id.planDetails, 32);
        sparseIntArray.put(R.id.partitionView1, 33);
        sparseIntArray.put(R.id.filterLifeContainer, 34);
        sparseIntArray.put(R.id.filterLifeLabel, 35);
        sparseIntArray.put(R.id.filterLifeImage, 36);
        sparseIntArray.put(R.id.partitionView2, 37);
        sparseIntArray.put(R.id.tdsBandContainer, 38);
        sparseIntArray.put(R.id.tdsBandLabel, 39);
        sparseIntArray.put(R.id.tdsBandImage, 40);
        sparseIntArray.put(R.id.graph, 41);
        sparseIntArray.put(R.id.dailyConsumption, 42);
        sparseIntArray.put(R.id.barChart, 43);
        sparseIntArray.put(R.id.averageWaterConsumption, 44);
        sparseIntArray.put(R.id.warning, 45);
        sparseIntArray.put(R.id.listBottomOptionDisId, 46);
        sparseIntArray.put(R.id.bottom_navigation_id, 47);
    }

    public FragmentHomeDispenserAtlanticBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 48, sIncludes, sViewsWithIds));
    }

    private FragmentHomeDispenserAtlanticBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 3, (TextView) bindings[26], (TextView) bindings[44], (BarChart) bindings[43], (ImageView) bindings[8], (LinearLayout) bindings[5], (BottomNavigationView) bindings[47], (LinearLayout) bindings[29], (ImageView) bindings[14], (TextView) bindings[42], (LinearLayout) bindings[34], (ImageView) bindings[36], (TextView) bindings[35], (LinearLayout) bindings[41], (LinearLayout) bindings[10], (ImageView) bindings[12], (TextView) bindings[6], (RecyclerView) bindings[46], (LinearLayout) bindings[13], (LinearLayout) bindings[11], (LinearLayout) bindings[28], (ScrollView) bindings[4], (View) bindings[33], (View) bindings[37], (TextView) bindings[32], (LinearLayout) bindings[30], (TextView) bindings[31], (ConstraintLayout) bindings[15], (TextView) bindings[17], (TextView) bindings[25], (ConstraintLayout) bindings[27], (ImageView) bindings[9], (SwipeRefreshLayout) bindings[0], (LinearLayout) bindings[38], (ImageView) bindings[40], (TextView) bindings[39], (LinearLayout) bindings[45], (TextView) bindings[3], (ImageView) bindings[16], (TextView) bindings[19], (TextView) bindings[22], (TextView) bindings[24], (TextView) bindings[20], (TextView) bindings[23], (TextView) bindings[21], (LinearLayout) bindings[18], (ImageView) bindings[7]);
        this.mDirtyFlags = -1L;
        TextView textView = (TextView) bindings[1];
        this.mboundView1 = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) bindings[2];
        this.mboundView2 = textView2;
        textView2.setTag(null);
        this.swipeToRefresh.setTag(null);
        this.warningMessage.setTag(null);
        setRootTag(root);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 16L;
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
            setViewModel((HomeDispenserAtlanticModel) variable);
            return true;
        }
        return false;
    }

    @Override // com.livpure.safedrink.databinding.FragmentHomeDispenserAtlanticBinding
    public void setViewModel(HomeDispenserAtlanticModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(18);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId != 0) {
            if (localFieldId != 1) {
                if (localFieldId != 2) {
                    return false;
                }
                return onChangeViewModelColdWaterStatus((MutableLiveData) object, fieldId);
            }
            return onChangeViewModelFaultDescription((MutableLiveData) object, fieldId);
        }
        return onChangeViewModelHotWaterStatus((MutableLiveData) object, fieldId);
    }

    private boolean onChangeViewModelHotWaterStatus(MutableLiveData<String> ViewModelHotWaterStatus, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewModelFaultDescription(MutableLiveData<String> ViewModelFaultDescription, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewModelColdWaterStatus(MutableLiveData<String> ViewModelColdWaterStatus, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0058  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void executeBindings() {
        /*
            r18 = this;
            r1 = r18
            monitor-enter(r18)
            long r2 = r1.mDirtyFlags     // Catch: java.lang.Throwable -> L91
            r4 = 0
            r1.mDirtyFlags = r4     // Catch: java.lang.Throwable -> L91
            monitor-exit(r18)     // Catch: java.lang.Throwable -> L91
            com.livpure.safedrink.dispenser.model.HomeDispenserAtlanticModel r0 = r1.mViewModel
            r6 = 31
            long r6 = r6 & r2
            r8 = 26
            r10 = 28
            r12 = 25
            r14 = 0
            int r15 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r15 == 0) goto L70
            long r6 = r2 & r12
            int r15 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r15 == 0) goto L35
            if (r0 == 0) goto L27
            androidx.lifecycle.MutableLiveData r6 = r0.getHotWaterStatus()
            goto L28
        L27:
            r6 = r14
        L28:
            r7 = 0
            r1.updateLiveDataRegistration(r7, r6)
            if (r6 == 0) goto L35
            java.lang.Object r6 = r6.getValue()
            java.lang.String r6 = (java.lang.String) r6
            goto L36
        L35:
            r6 = r14
        L36:
            long r15 = r2 & r8
            int r7 = (r15 > r4 ? 1 : (r15 == r4 ? 0 : -1))
            if (r7 == 0) goto L51
            if (r0 == 0) goto L43
            androidx.lifecycle.MutableLiveData r7 = r0.getFaultDescription()
            goto L44
        L43:
            r7 = r14
        L44:
            r15 = 1
            r1.updateLiveDataRegistration(r15, r7)
            if (r7 == 0) goto L51
            java.lang.Object r7 = r7.getValue()
            java.lang.String r7 = (java.lang.String) r7
            goto L52
        L51:
            r7 = r14
        L52:
            long r15 = r2 & r10
            int r17 = (r15 > r4 ? 1 : (r15 == r4 ? 0 : -1))
            if (r17 == 0) goto L6d
            if (r0 == 0) goto L5f
            androidx.lifecycle.MutableLiveData r0 = r0.getColdWaterStatus()
            goto L60
        L5f:
            r0 = r14
        L60:
            r15 = 2
            r1.updateLiveDataRegistration(r15, r0)
            if (r0 == 0) goto L6d
            java.lang.Object r0 = r0.getValue()
            r14 = r0
            java.lang.String r14 = (java.lang.String) r14
        L6d:
            r0 = r14
            r14 = r6
            goto L72
        L70:
            r0 = r14
            r7 = r0
        L72:
            long r12 = r12 & r2
            int r6 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r6 == 0) goto L7c
            android.widget.TextView r6 = r1.mboundView1
            androidx.databinding.adapters.TextViewBindingAdapter.setText(r6, r14)
        L7c:
            long r10 = r10 & r2
            int r6 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r6 == 0) goto L86
            android.widget.TextView r6 = r1.mboundView2
            androidx.databinding.adapters.TextViewBindingAdapter.setText(r6, r0)
        L86:
            long r2 = r2 & r8
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L90
            android.widget.TextView r0 = r1.warningMessage
            androidx.databinding.adapters.TextViewBindingAdapter.setText(r0, r7)
        L90:
            return
        L91:
            r0 = move-exception
            monitor-exit(r18)     // Catch: java.lang.Throwable -> L91
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.livpure.safedrink.databinding.FragmentHomeDispenserAtlanticBindingImpl.executeBindings():void");
    }
}
