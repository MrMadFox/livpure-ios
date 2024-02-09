package com.livpure.safedrink.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.MediatorLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import com.livpure.safedrink.R;
import com.livpure.safedrink.subscription.payment.viewmodel.SelectPlanChangeModel;
import com.livpure.safedrink.subscription.plan.data.model.payment.PlanItem;
/* loaded from: classes3.dex */
public class FragmentPlanChangeBindingImpl extends FragmentPlanChangeBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final NestedScrollView mboundView0;
    private final TextView mboundView1;
    private final TextView mboundView2;
    private final TextView mboundView4;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.lytParentViewId, 6);
        sparseIntArray.put(R.id.lytActivityPlanId, 7);
        sparseIntArray.put(R.id.planInfo, 8);
        sparseIntArray.put(R.id.planIcon, 9);
        sparseIntArray.put(R.id.txt_capacity, 10);
        sparseIntArray.put(R.id.listPlanValidityId, 11);
        sparseIntArray.put(R.id.btnRenewPlanId, 12);
        sparseIntArray.put(R.id.lytChangePlan, 13);
        sparseIntArray.put(R.id.txt_plan, 14);
        sparseIntArray.put(R.id.listChangePlanId, 15);
        sparseIntArray.put(R.id.lytUnlimitedPlan, 16);
        sparseIntArray.put(R.id.lytUnlimitedLabel, 17);
        sparseIntArray.put(R.id.listUnlimitedPlanId, 18);
        sparseIntArray.put(R.id.lytPopular, 19);
        sparseIntArray.put(R.id.lytHolidayPlan, 20);
        sparseIntArray.put(R.id.lytHolidayPlanId, 21);
        sparseIntArray.put(R.id.listHolidayPlanId, 22);
    }

    public FragmentPlanChangeBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 23, sIncludes, sViewsWithIds));
    }

    private FragmentPlanChangeBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 6, (TextView) bindings[5], (MaterialButton) bindings[12], (TextView) bindings[3], (RecyclerView) bindings[15], (RecyclerView) bindings[22], (RecyclerView) bindings[11], (RecyclerView) bindings[18], (CardView) bindings[7], (LinearLayout) bindings[13], (LinearLayout) bindings[20], (CardView) bindings[21], (LinearLayout) bindings[6], (LinearLayout) bindings[19], (LinearLayout) bindings[17], (RelativeLayout) bindings[16], (ImageView) bindings[9], (LinearLayout) bindings[8], (TextView) bindings[10], (TextView) bindings[14]);
        this.mDirtyFlags = -1L;
        this.additionalUsage.setTag(null);
        this.capacity.setTag(null);
        NestedScrollView nestedScrollView = (NestedScrollView) bindings[0];
        this.mboundView0 = nestedScrollView;
        nestedScrollView.setTag(null);
        TextView textView = (TextView) bindings[1];
        this.mboundView1 = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) bindings[2];
        this.mboundView2 = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) bindings[4];
        this.mboundView4 = textView3;
        textView3.setTag(null);
        setRootTag(root);
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
        if (13 == variableId) {
            setPosition((Integer) variable);
        } else if (10 == variableId) {
            setPlan((PlanItem) variable);
        } else if (18 != variableId) {
            return false;
        } else {
            setViewModel((SelectPlanChangeModel) variable);
        }
        return true;
    }

    @Override // com.livpure.safedrink.databinding.FragmentPlanChangeBinding
    public void setPosition(Integer Position) {
        this.mPosition = Position;
    }

    @Override // com.livpure.safedrink.databinding.FragmentPlanChangeBinding
    public void setPlan(PlanItem Plan) {
        this.mPlan = Plan;
    }

    @Override // com.livpure.safedrink.databinding.FragmentPlanChangeBinding
    public void setViewModel(SelectPlanChangeModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 256;
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
                            return onChangeViewModelCurrentPlanLitres((MediatorLiveData) object, fieldId);
                        }
                        return onChangeViewModelCurrentPlanAmount((MediatorLiveData) object, fieldId);
                    }
                    return onChangeViewModelCurrentEMIPlanAmount((MediatorLiveData) object, fieldId);
                }
                return onChangeViewModelCurrentPlanName((MediatorLiveData) object, fieldId);
            }
            return onChangeViewModelCurrentPlanEndDate((MediatorLiveData) object, fieldId);
        }
        return onChangeViewModelCurrentPlanPerLitres((MediatorLiveData) object, fieldId);
    }

    private boolean onChangeViewModelCurrentPlanPerLitres(MediatorLiveData<String> ViewModelCurrentPlanPerLitres, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewModelCurrentPlanEndDate(MediatorLiveData<String> ViewModelCurrentPlanEndDate, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewModelCurrentPlanName(MediatorLiveData<String> ViewModelCurrentPlanName, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewModelCurrentEMIPlanAmount(MediatorLiveData<String> ViewModelCurrentEMIPlanAmount, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewModelCurrentPlanAmount(MediatorLiveData<String> ViewModelCurrentPlanAmount, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewModelCurrentPlanLitres(MediatorLiveData<String> ViewModelCurrentPlanLitres, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:76:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x015d  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 686
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.livpure.safedrink.databinding.FragmentPlanChangeBindingImpl.executeBindings():void");
    }
}
