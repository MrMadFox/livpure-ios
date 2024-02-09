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
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.github.mikephil.charting.charts.BarChart;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.livpure.safedrink.R;
import com.livpure.safedrink.dispenser.model.HomeDispenserModel;
/* loaded from: classes3.dex */
public class FragmentHomeDispenserMagnaBindingImpl extends FragmentHomeDispenserMagnaBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.lytParentScrollView, 2);
        sparseIntArray.put(R.id.boltSettingsLL, 3);
        sparseIntArray.put(R.id.lastSynchronized, 4);
        sparseIntArray.put(R.id.wifiInfoIV, 5);
        sparseIntArray.put(R.id.bleInfoIV, 6);
        sparseIntArray.put(R.id.settingsIV, 7);
        sparseIntArray.put(R.id.readingSection, 8);
        sparseIntArray.put(R.id.waterDispenseUsageImage, 9);
        sparseIntArray.put(R.id.uvStatusImage, 10);
        sparseIntArray.put(R.id.remainingWaterLabel, 11);
        sparseIntArray.put(R.id.waterremainLL, 12);
        sparseIntArray.put(R.id.waterRemainingHundredThousands, 13);
        sparseIntArray.put(R.id.waterRemainingTenThousands, 14);
        sparseIntArray.put(R.id.waterRemainingThousands, 15);
        sparseIntArray.put(R.id.waterRemainingHundreds, 16);
        sparseIntArray.put(R.id.waterRemainingTens, 17);
        sparseIntArray.put(R.id.waterRemainingOnes, 18);
        sparseIntArray.put(R.id.renewPlan, 19);
        sparseIntArray.put(R.id.addLitres, 20);
        sparseIntArray.put(R.id.serviceRequest, 21);
        sparseIntArray.put(R.id.llRaiseAserviceComplaint, 22);
        sparseIntArray.put(R.id.center, 23);
        sparseIntArray.put(R.id.planDetailsContainer, 24);
        sparseIntArray.put(R.id.planDetailsLabel, 25);
        sparseIntArray.put(R.id.planDetails, 26);
        sparseIntArray.put(R.id.partitionView1, 27);
        sparseIntArray.put(R.id.filterLifeContainer, 28);
        sparseIntArray.put(R.id.filterLifeLabel, 29);
        sparseIntArray.put(R.id.filterLifeImage, 30);
        sparseIntArray.put(R.id.partitionView2, 31);
        sparseIntArray.put(R.id.tdsBandContainer, 32);
        sparseIntArray.put(R.id.tdsBandLabel, 33);
        sparseIntArray.put(R.id.tdsBandImage, 34);
        sparseIntArray.put(R.id.graph, 35);
        sparseIntArray.put(R.id.dailyConsumption, 36);
        sparseIntArray.put(R.id.barChart, 37);
        sparseIntArray.put(R.id.averageWaterConsumption, 38);
        sparseIntArray.put(R.id.warning, 39);
        sparseIntArray.put(R.id.listBottomOptionDisId, 40);
        sparseIntArray.put(R.id.bottom_navigation_id, 41);
    }

    public FragmentHomeDispenserMagnaBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 42, sIncludes, sViewsWithIds));
    }

    private FragmentHomeDispenserMagnaBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1, (TextView) bindings[20], (TextView) bindings[38], (BarChart) bindings[37], (ImageView) bindings[6], (LinearLayout) bindings[3], (BottomNavigationView) bindings[41], (LinearLayout) bindings[23], (TextView) bindings[36], (LinearLayout) bindings[28], (ImageView) bindings[30], (TextView) bindings[29], (LinearLayout) bindings[35], (TextView) bindings[4], (RecyclerView) bindings[40], (LinearLayout) bindings[22], (ScrollView) bindings[2], (View) bindings[27], (View) bindings[31], (TextView) bindings[26], (LinearLayout) bindings[24], (TextView) bindings[25], (ConstraintLayout) bindings[8], (TextView) bindings[11], (TextView) bindings[19], (ConstraintLayout) bindings[21], (ImageView) bindings[7], (SwipeRefreshLayout) bindings[0], (LinearLayout) bindings[32], (ImageView) bindings[34], (TextView) bindings[33], (ImageView) bindings[10], (LinearLayout) bindings[39], (TextView) bindings[1], (ImageView) bindings[9], (TextView) bindings[13], (TextView) bindings[16], (TextView) bindings[18], (TextView) bindings[14], (TextView) bindings[17], (TextView) bindings[15], (LinearLayout) bindings[12], (ImageView) bindings[5]);
        this.mDirtyFlags = -1L;
        this.swipeToRefresh.setTag(null);
        this.warningMessage.setTag(null);
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
            setViewModel((HomeDispenserModel) variable);
            return true;
        }
        return false;
    }

    @Override // com.livpure.safedrink.databinding.FragmentHomeDispenserMagnaBinding
    public void setViewModel(HomeDispenserModel ViewModel) {
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

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        HomeDispenserModel homeDispenserModel = this.mViewModel;
        String str = null;
        int i = ((j & 7) > 0L ? 1 : ((j & 7) == 0L ? 0 : -1));
        if (i != 0) {
            MutableLiveData<String> faultDescription = homeDispenserModel != null ? homeDispenserModel.getFaultDescription() : null;
            updateLiveDataRegistration(0, faultDescription);
            if (faultDescription != null) {
                str = faultDescription.getValue();
            }
        }
        if (i != 0) {
            TextViewBindingAdapter.setText(this.warningMessage, str);
        }
    }
}
