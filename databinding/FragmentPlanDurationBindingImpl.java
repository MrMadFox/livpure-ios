package com.livpure.safedrink.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.lifecycle.MediatorLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.livpure.safedrink.R;
import com.livpure.safedrink.subscription.payment.viewmodel.PlanDurationModel;
/* loaded from: classes3.dex */
public class FragmentPlanDurationBindingImpl extends FragmentPlanDurationBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final RelativeLayout mboundView0;
    private final AppCompatTextView mboundView1;
    private final AppCompatTextView mboundView2;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.lytParentViewId, 3);
        sparseIntArray.put(R.id.listPlanDurationId, 4);
        sparseIntArray.put(R.id.btnRenewPlanId, 5);
        sparseIntArray.put(R.id.tvBilledStatus, 6);
    }

    public FragmentPlanDurationBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 7, sIncludes, sViewsWithIds));
    }

    private FragmentPlanDurationBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2, (LinearLayout) bindings[5], (RecyclerView) bindings[4], (LinearLayout) bindings[3], (TextView) bindings[6]);
        this.mDirtyFlags = -1L;
        RelativeLayout relativeLayout = (RelativeLayout) bindings[0];
        this.mboundView0 = relativeLayout;
        relativeLayout.setTag(null);
        AppCompatTextView appCompatTextView = (AppCompatTextView) bindings[1];
        this.mboundView1 = appCompatTextView;
        appCompatTextView.setTag(null);
        AppCompatTextView appCompatTextView2 = (AppCompatTextView) bindings[2];
        this.mboundView2 = appCompatTextView2;
        appCompatTextView2.setTag(null);
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
        if (13 == variableId) {
            setPosition((Integer) variable);
        } else if (18 != variableId) {
            return false;
        } else {
            setViewModel((PlanDurationModel) variable);
        }
        return true;
    }

    @Override // com.livpure.safedrink.databinding.FragmentPlanDurationBinding
    public void setPosition(Integer Position) {
        this.mPosition = Position;
    }

    @Override // com.livpure.safedrink.databinding.FragmentPlanDurationBinding
    public void setViewModel(PlanDurationModel ViewModel) {
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
                return false;
            }
            return onChangeViewModelPlanLitres((MediatorLiveData) object, fieldId);
        }
        return onChangeViewModelPlanName((MediatorLiveData) object, fieldId);
    }

    private boolean onChangeViewModelPlanName(MediatorLiveData<String> ViewModelPlanName, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewModelPlanLitres(MediatorLiveData<String> ViewModelPlanLitres, int fieldId) {
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
        String str2;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        PlanDurationModel planDurationModel = this.mViewModel;
        if ((27 & j) != 0) {
            if ((j & 25) != 0) {
                MediatorLiveData<String> planName = planDurationModel != null ? planDurationModel.getPlanName() : null;
                updateLiveDataRegistration(0, planName);
                str2 = (planName != null ? planName.getValue() : null) + " Plan";
            } else {
                str2 = null;
            }
            if ((j & 26) != 0) {
                MediatorLiveData<String> planLitres = planDurationModel != null ? planDurationModel.getPlanLitres() : null;
                updateLiveDataRegistration(1, planLitres);
                r11 = (planLitres != null ? planLitres.getValue() : null) + " ";
            }
            str = r11;
            r11 = str2;
        } else {
            str = null;
        }
        if ((j & 25) != 0) {
            TextViewBindingAdapter.setText(this.mboundView1, r11);
        }
        if ((j & 26) != 0) {
            TextViewBindingAdapter.setText(this.mboundView2, str);
        }
    }
}
