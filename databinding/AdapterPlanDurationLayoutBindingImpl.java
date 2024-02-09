package com.livpure.safedrink.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.MediatorLiveData;
import com.livpure.safedrink.R;
import com.livpure.safedrink.subscription.payment.adapter.PlanDurationAdapter;
import com.livpure.safedrink.subscription.payment.viewmodel.PlanDurationModel;
import com.livpure.safedrink.subscription.plan.data.model.plan.PriceItem;
/* loaded from: classes3.dex */
public class AdapterPlanDurationLayoutBindingImpl extends AdapterPlanDurationLayoutBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final FrameLayout mboundView0;
    private final AppCompatTextView mboundView1;
    private final AppCompatTextView mboundView2;
    private final AppCompatTextView mboundView3;
    private final AppCompatTextView mboundView4;
    private final AppCompatTextView mboundView5;
    private final TextView mboundView6;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.lytValidityId, 7);
        sparseIntArray.put(R.id.radioPlanId, 8);
    }

    public AdapterPlanDurationLayoutBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 9, sIncludes, sViewsWithIds));
    }

    private AdapterPlanDurationLayoutBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1, (LinearLayout) bindings[7], (RadioButton) bindings[8]);
        this.mDirtyFlags = -1L;
        FrameLayout frameLayout = (FrameLayout) bindings[0];
        this.mboundView0 = frameLayout;
        frameLayout.setTag(null);
        AppCompatTextView appCompatTextView = (AppCompatTextView) bindings[1];
        this.mboundView1 = appCompatTextView;
        appCompatTextView.setTag(null);
        AppCompatTextView appCompatTextView2 = (AppCompatTextView) bindings[2];
        this.mboundView2 = appCompatTextView2;
        appCompatTextView2.setTag(null);
        AppCompatTextView appCompatTextView3 = (AppCompatTextView) bindings[3];
        this.mboundView3 = appCompatTextView3;
        appCompatTextView3.setTag(null);
        AppCompatTextView appCompatTextView4 = (AppCompatTextView) bindings[4];
        this.mboundView4 = appCompatTextView4;
        appCompatTextView4.setTag(null);
        AppCompatTextView appCompatTextView5 = (AppCompatTextView) bindings[5];
        this.mboundView5 = appCompatTextView5;
        appCompatTextView5.setTag(null);
        TextView textView = (TextView) bindings[6];
        this.mboundView6 = textView;
        textView.setTag(null);
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
        if (13 == variableId) {
            setPosition((Integer) variable);
        } else if (4 == variableId) {
            setDuration((PriceItem) variable);
        } else if (18 == variableId) {
            setViewModel((PlanDurationModel) variable);
        } else if (2 != variableId) {
            return false;
        } else {
            setCallBack((PlanDurationAdapter) variable);
        }
        return true;
    }

    @Override // com.livpure.safedrink.databinding.AdapterPlanDurationLayoutBinding
    public void setPosition(Integer Position) {
        this.mPosition = Position;
    }

    @Override // com.livpure.safedrink.databinding.AdapterPlanDurationLayoutBinding
    public void setDuration(PriceItem Duration) {
        this.mDuration = Duration;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(4);
        super.requestRebind();
    }

    @Override // com.livpure.safedrink.databinding.AdapterPlanDurationLayoutBinding
    public void setViewModel(PlanDurationModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(18);
        super.requestRebind();
    }

    @Override // com.livpure.safedrink.databinding.AdapterPlanDurationLayoutBinding
    public void setCallBack(PlanDurationAdapter CallBack) {
        this.mCallBack = CallBack;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId != 0) {
            return false;
        }
        return onChangeViewModelPlanAmount((MediatorLiveData) object, fieldId);
    }

    private boolean onChangeViewModelPlanAmount(MediatorLiveData<String> ViewModelPlanAmount, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0078  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 401
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.livpure.safedrink.databinding.AdapterPlanDurationLayoutBindingImpl.executeBindings():void");
    }
}
