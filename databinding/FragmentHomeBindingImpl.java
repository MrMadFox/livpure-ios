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
import com.livpure.safedrink.app.HomeViewModel;
import com.livpure.safedrink.generated.callback.OnClickListener;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
/* loaded from: classes3.dex */
public class FragmentHomeBindingImpl extends FragmentHomeBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback10;
    private final View.OnClickListener mCallback11;
    private final View.OnClickListener mCallback12;
    private final View.OnClickListener mCallback13;
    private final View.OnClickListener mCallback14;
    private final View.OnClickListener mCallback9;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.homeContainer, 13);
        sparseIntArray.put(R.id.boltSettingsLL, 14);
        sparseIntArray.put(R.id.lastSynchronized, 15);
        sparseIntArray.put(R.id.bleInfoIV, 16);
        sparseIntArray.put(R.id.wifiInfoIV, 17);
        sparseIntArray.put(R.id.readingSection, 18);
        sparseIntArray.put(R.id.waterUsageImage, 19);
        sparseIntArray.put(R.id.remainingWaterLabel, 20);
        sparseIntArray.put(R.id.waterremainLL, 21);
        sparseIntArray.put(R.id.waterRemainingTenThousand, 22);
        sparseIntArray.put(R.id.waterRemainingThousands, 23);
        sparseIntArray.put(R.id.waterRemainingHundreds, 24);
        sparseIntArray.put(R.id.waterRemainingTens, 25);
        sparseIntArray.put(R.id.waterRemainingOnes, 26);
        sparseIntArray.put(R.id.makePaymentDiabled, 27);
        sparseIntArray.put(R.id.makePayment, 28);
        sparseIntArray.put(R.id.horizontalMiddleGuidline, 29);
        sparseIntArray.put(R.id.planDetailsLabel, 30);
        sparseIntArray.put(R.id.filterLifeLabel, 31);
        sparseIntArray.put(R.id.planDetails, 32);
        sparseIntArray.put(R.id.filterLifeImage, 33);
        sparseIntArray.put(R.id.partitionView, 34);
        sparseIntArray.put(R.id.refereFriendLL, 35);
        sparseIntArray.put(R.id.refereFriendImage, 36);
        sparseIntArray.put(R.id.dailyConsumptionLabe, 37);
        sparseIntArray.put(R.id.barChart, 38);
        sparseIntArray.put(R.id.averageWaterConsumption, 39);
        sparseIntArray.put(R.id.startGuide, 40);
        sparseIntArray.put(R.id.endGuide, 41);
        sparseIntArray.put(R.id.middleVerticalGuide, 42);
    }

    public FragmentHomeBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 43, sIncludes, sViewsWithIds));
    }

    private FragmentHomeBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 6, (Button) bindings[9], (ConstraintLayout) bindings[7], (TextView) bindings[8], (Button) bindings[4], (TextView) bindings[39], (BarChart) bindings[38], (ImageView) bindings[16], (LinearLayout) bindings[14], (ConstraintLayout) bindings[1], (TextView) bindings[37], (Guideline) bindings[41], (ImageView) bindings[33], (TextView) bindings[31], (TextView) bindings[11], (ImageView) bindings[10], (ConstraintLayout) bindings[13], (Guideline) bindings[29], (LinearLayout) bindings[5], (TextView) bindings[15], (ProgressBar) bindings[12], (Button) bindings[28], (Button) bindings[27], (Guideline) bindings[42], (View) bindings[34], (TextView) bindings[32], (TextView) bindings[30], (ConstraintLayout) bindings[18], (ImageView) bindings[36], (LinearLayout) bindings[35], (TextView) bindings[20], (Button) bindings[3], (ImageView) bindings[2], (ImageView) bindings[6], (Guideline) bindings[40], (SwipeRefreshLayout) bindings[0], (TextView) bindings[24], (TextView) bindings[26], (TextView) bindings[22], (TextView) bindings[25], (TextView) bindings[23], (ImageView) bindings[19], (LinearLayout) bindings[21], (ImageView) bindings[17]);
        this.mDirtyFlags = -1L;
        this.actionButton.setTag(null);
        this.actionContainer.setTag(null);
        this.actionLabel.setTag(null);
        this.addLitresButton.setTag(null);
        this.consumptionDashboard.setTag(null);
        this.hintHeader.setTag(null);
        this.hintImage.setTag(null);
        this.knowMoreLL.setTag(null);
        this.loader.setTag(null);
        this.renewSubscriptionButton.setTag(null);
        this.settingsIV.setTag(null);
        this.shareMore.setTag(null);
        this.swipeRefreshLayoutComments.setTag(null);
        setRootTag(root);
        this.mCallback11 = new OnClickListener(this, 3);
        this.mCallback12 = new OnClickListener(this, 4);
        this.mCallback9 = new OnClickListener(this, 1);
        this.mCallback13 = new OnClickListener(this, 5);
        this.mCallback14 = new OnClickListener(this, 6);
        this.mCallback10 = new OnClickListener(this, 2);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 128L;
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
            setViewModel((HomeViewModel) variable);
            return true;
        }
        return false;
    }

    @Override // com.livpure.safedrink.databinding.FragmentHomeBinding
    public void setViewModel(HomeViewModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 64;
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
                        if (localFieldId != 4) {
                            if (localFieldId != 5) {
                                return false;
                            }
                            return onChangeViewModelLoading((MutableLiveData) object, fieldId);
                        }
                        return onChangeViewModelHintButtonText((MutableLiveData) object, fieldId);
                    }
                    return onChangeViewModelHintImageResId((MutableLiveData) object, fieldId);
                }
                return onChangeViewModelHintVisibility((MutableLiveData) object, fieldId);
            }
            return onChangeViewModelHintHeaderText((MutableLiveData) object, fieldId);
        }
        return onChangeViewModelHintLabel((MutableLiveData) object, fieldId);
    }

    private boolean onChangeViewModelHintLabel(MutableLiveData<String> ViewModelHintLabel, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewModelHintHeaderText(MutableLiveData<String> ViewModelHintHeaderText, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewModelHintVisibility(MutableLiveData<Boolean> ViewModelHintVisibility, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewModelHintImageResId(MutableLiveData<Integer> ViewModelHintImageResId, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewModelHintButtonText(MutableLiveData<String> ViewModelHintButtonText, int fieldId) {
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

    /* JADX WARN: Removed duplicated region for block: B:19:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x012f  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 446
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.livpure.safedrink.databinding.FragmentHomeBindingImpl.executeBindings():void");
    }

    @Override // com.livpure.safedrink.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        switch (sourceId) {
            case 1:
                HomeViewModel homeViewModel = this.mViewModel;
                if (homeViewModel != null) {
                    homeViewModel.onBoltSettingsClicked();
                    return;
                }
                return;
            case 2:
                HomeViewModel homeViewModel2 = this.mViewModel;
                if (homeViewModel2 != null) {
                    homeViewModel2.onRenewChangePlanClicked();
                    return;
                }
                return;
            case 3:
                HomeViewModel homeViewModel3 = this.mViewModel;
                if (homeViewModel3 != null) {
                    homeViewModel3.onAddLitresClicked();
                    return;
                }
                return;
            case 4:
                HomeViewModel homeViewModel4 = this.mViewModel;
                if (homeViewModel4 != null) {
                    homeViewModel4.onReferFriendsAndEarnClicked();
                    return;
                }
                return;
            case 5:
                HomeViewModel homeViewModel5 = this.mViewModel;
                if (homeViewModel5 != null) {
                    homeViewModel5.onReferShareClicked();
                    return;
                }
                return;
            case 6:
                HomeViewModel homeViewModel6 = this.mViewModel;
                if (homeViewModel6 != null) {
                    Function0<Unit> onHintButtonClick = homeViewModel6.getOnHintButtonClick();
                    if (onHintButtonClick != null) {
                        onHintButtonClick.invoke();
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }
}
