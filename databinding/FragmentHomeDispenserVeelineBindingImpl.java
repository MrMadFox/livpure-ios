package com.livpure.safedrink.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.github.mikephil.charting.charts.BarChart;
import com.livpure.safedrink.R;
/* loaded from: classes3.dex */
public class FragmentHomeDispenserVeelineBindingImpl extends FragmentHomeDispenserVeelineBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int variableId, Object variable) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.swipe_refresh_layout_comments, 1);
        sparseIntArray.put(R.id.homeContainer, 2);
        sparseIntArray.put(R.id.consumptionDashboard, 3);
        sparseIntArray.put(R.id.boltSettingsLL, 4);
        sparseIntArray.put(R.id.lastSynchronized, 5);
        sparseIntArray.put(R.id.wifiInfoIV, 6);
        sparseIntArray.put(R.id.bleInfoIV, 7);
        sparseIntArray.put(R.id.settingsIV, 8);
        sparseIntArray.put(R.id.readingSection, 9);
        sparseIntArray.put(R.id.waterUsageImage, 10);
        sparseIntArray.put(R.id.remainingWaterLabel, 11);
        sparseIntArray.put(R.id.waterremainLL, 12);
        sparseIntArray.put(R.id.waterRemainingHundredThousands, 13);
        sparseIntArray.put(R.id.waterRemainingTenThousands, 14);
        sparseIntArray.put(R.id.waterRemainingThousands, 15);
        sparseIntArray.put(R.id.waterRemainingHundreds, 16);
        sparseIntArray.put(R.id.waterRemainingTens, 17);
        sparseIntArray.put(R.id.waterRemainingOnes, 18);
        sparseIntArray.put(R.id.center, 19);
        sparseIntArray.put(R.id.planDetailsContainer, 20);
        sparseIntArray.put(R.id.planDetailsLabel, 21);
        sparseIntArray.put(R.id.planDetails, 22);
        sparseIntArray.put(R.id.partitionView1, 23);
        sparseIntArray.put(R.id.filterLifeContainer, 24);
        sparseIntArray.put(R.id.filterLifeLabel, 25);
        sparseIntArray.put(R.id.filterLifeImage, 26);
        sparseIntArray.put(R.id.partitionView2, 27);
        sparseIntArray.put(R.id.tdsBandContainer, 28);
        sparseIntArray.put(R.id.tdsBandLabel, 29);
        sparseIntArray.put(R.id.tdsBandImage, 30);
        sparseIntArray.put(R.id.graph, 31);
        sparseIntArray.put(R.id.dailyConsumption, 32);
        sparseIntArray.put(R.id.chart_layout, 33);
        sparseIntArray.put(R.id.click_for_more, 34);
        sparseIntArray.put(R.id.barchart, 35);
        sparseIntArray.put(R.id.warning, 36);
        sparseIntArray.put(R.id.warningMessage, 37);
        sparseIntArray.put(R.id.listBottomOptionId, 38);
    }

    public FragmentHomeDispenserVeelineBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 39, sIncludes, sViewsWithIds));
    }

    private FragmentHomeDispenserVeelineBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (BarChart) bindings[35], (ImageView) bindings[7], (LinearLayout) bindings[4], (LinearLayout) bindings[19], (FrameLayout) bindings[33], (TextView) bindings[34], (ConstraintLayout) bindings[3], (TextView) bindings[32], (LinearLayout) bindings[24], (ImageView) bindings[26], (TextView) bindings[25], (LinearLayout) bindings[31], (ConstraintLayout) bindings[2], (TextView) bindings[5], (RecyclerView) bindings[38], (View) bindings[23], (View) bindings[27], (TextView) bindings[22], (LinearLayout) bindings[20], (TextView) bindings[21], (ConstraintLayout) bindings[9], (TextView) bindings[11], (ImageView) bindings[8], (SwipeRefreshLayout) bindings[1], (LinearLayout) bindings[28], (ImageView) bindings[30], (TextView) bindings[29], (LinearLayout) bindings[36], (TextView) bindings[37], (TextView) bindings[13], (TextView) bindings[16], (TextView) bindings[18], (TextView) bindings[14], (TextView) bindings[17], (TextView) bindings[15], (ImageView) bindings[10], (LinearLayout) bindings[12], (ImageView) bindings[6]);
        this.mDirtyFlags = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) bindings[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(root);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 1L;
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
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}
