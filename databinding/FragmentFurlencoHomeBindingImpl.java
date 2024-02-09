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
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.lifecycle.MutableLiveData;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.github.mikephil.charting.charts.BarChart;
import com.livpure.safedrink.R;
import com.livpure.safedrink.furlenco.model.HomeFurlencoModel;
import com.livpure.safedrink.generated.callback.OnClickListener;
/* loaded from: classes3.dex */
public class FragmentFurlencoHomeBindingImpl extends FragmentFurlencoHomeBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback7;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.homeContainer, 4);
        sparseIntArray.put(R.id.consumptionDashboard, 5);
        sparseIntArray.put(R.id.boltSettingsLL, 6);
        sparseIntArray.put(R.id.bleInfoIV, 7);
        sparseIntArray.put(R.id.wifiInfoIV, 8);
        sparseIntArray.put(R.id.readingSection, 9);
        sparseIntArray.put(R.id.waterUsageImage, 10);
        sparseIntArray.put(R.id.remainingWaterLabel, 11);
        sparseIntArray.put(R.id.waterremainLL, 12);
        sparseIntArray.put(R.id.waterRemainingTenThousand, 13);
        sparseIntArray.put(R.id.waterRemainingThousands, 14);
        sparseIntArray.put(R.id.waterRemainingHundreds, 15);
        sparseIntArray.put(R.id.waterRemainingTens, 16);
        sparseIntArray.put(R.id.waterRemainingOnes, 17);
        sparseIntArray.put(R.id.makePaymentDiabled, 18);
        sparseIntArray.put(R.id.makePayment, 19);
        sparseIntArray.put(R.id.horizontalMiddleGuidline, 20);
        sparseIntArray.put(R.id.planDetailsLabel, 21);
        sparseIntArray.put(R.id.filterLifeLabel, 22);
        sparseIntArray.put(R.id.planDetails, 23);
        sparseIntArray.put(R.id.filterLifeImage, 24);
        sparseIntArray.put(R.id.partitionView, 25);
        sparseIntArray.put(R.id.dailyConsumptionLabe, 26);
        sparseIntArray.put(R.id.barChart, 27);
        sparseIntArray.put(R.id.averageWaterConsumption, 28);
        sparseIntArray.put(R.id.middleVerticalGuide, 29);
    }

    public FragmentFurlencoHomeBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 30, sIncludes, sViewsWithIds));
    }

    private FragmentFurlencoHomeBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2, (TextView) bindings[28], (BarChart) bindings[27], (ImageView) bindings[7], (LinearLayout) bindings[6], (ConstraintLayout) bindings[5], (TextView) bindings[26], (ImageView) bindings[24], (TextView) bindings[22], (ConstraintLayout) bindings[4], (Guideline) bindings[20], (TextView) bindings[1], (ProgressBar) bindings[3], (Button) bindings[19], (Button) bindings[18], (Guideline) bindings[29], (View) bindings[25], (TextView) bindings[23], (TextView) bindings[21], (ConstraintLayout) bindings[9], (TextView) bindings[11], (ImageView) bindings[2], (SwipeRefreshLayout) bindings[0], (TextView) bindings[15], (TextView) bindings[17], (TextView) bindings[13], (TextView) bindings[16], (TextView) bindings[14], (ImageView) bindings[10], (LinearLayout) bindings[12], (ImageView) bindings[8]);
        this.mDirtyFlags = -1L;
        this.lastSynchronized.setTag(null);
        this.loader.setTag(null);
        this.settingsIV.setTag(null);
        this.swipeRefreshLayoutComments.setTag(null);
        setRootTag(root);
        this.mCallback7 = new OnClickListener(this, 1);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 8L;
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
            setViewModel((HomeFurlencoModel) variable);
            return true;
        }
        return false;
    }

    @Override // com.livpure.safedrink.databinding.FragmentFurlencoHomeBinding
    public void setViewModel(HomeFurlencoModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(18);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId != 0) {
            if (localFieldId != 1) {
                return false;
            }
            return onChangeViewModelLoading((MutableLiveData) object, fieldId);
        }
        return onChangeViewModelLastSynchronizedOn((MutableLiveData) object, fieldId);
    }

    private boolean onChangeViewModelLastSynchronizedOn(MutableLiveData<String> ViewModelLastSynchronizedOn, int fieldId) {
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

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        HomeFurlencoModel homeFurlencoModel = this.mViewModel;
        int i = 0;
        String str2 = null;
        if ((15 & j) != 0) {
            if ((j & 13) != 0) {
                MutableLiveData<String> last_synchronized_on = homeFurlencoModel != null ? homeFurlencoModel.getLast_synchronized_on() : null;
                updateLiveDataRegistration(0, last_synchronized_on);
                str = this.lastSynchronized.getResources().getString(R.string.last_synchronized_on) + "  " + (last_synchronized_on != null ? last_synchronized_on.getValue() : null);
            } else {
                str = null;
            }
            int i2 = ((j & 14) > 0L ? 1 : ((j & 14) == 0L ? 0 : -1));
            if (i2 != 0) {
                MutableLiveData<Boolean> loading = homeFurlencoModel != null ? homeFurlencoModel.getLoading() : null;
                updateLiveDataRegistration(1, loading);
                boolean safeUnbox = ViewDataBinding.safeUnbox(loading != null ? loading.getValue() : null);
                if (i2 != 0) {
                    j |= safeUnbox ? 32L : 16L;
                }
                if (!safeUnbox) {
                    i = 8;
                }
            }
            str2 = str;
        }
        if ((j & 13) != 0) {
            TextViewBindingAdapter.setText(this.lastSynchronized, str2);
        }
        if ((j & 14) != 0) {
            this.loader.setVisibility(i);
        }
        if ((j & 8) != 0) {
            this.settingsIV.setOnClickListener(this.mCallback7);
        }
    }

    @Override // com.livpure.safedrink.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        HomeFurlencoModel homeFurlencoModel = this.mViewModel;
        if (homeFurlencoModel != null) {
            homeFurlencoModel.onBoltSettingsClicked();
        }
    }
}
