package com.livpure.safedrink.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.lifecycle.MutableLiveData;
import com.livpure.safedrink.R;
import com.livpure.safedrink.login.data.models.User;
import com.livpure.safedrink.subscription.payment.viewmodel.ReviewOrderViewModel;
/* loaded from: classes3.dex */
public class FragmentReviewOrderBindingImpl extends FragmentReviewOrderBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.reviewAndPayLabel, 5);
        sparseIntArray.put(R.id.startGuideline, 6);
        sparseIntArray.put(R.id.endGuideline, 7);
        sparseIntArray.put(R.id.planNameLabel, 8);
        sparseIntArray.put(R.id.durationLabel, 9);
        sparseIntArray.put(R.id.referralDiscountLabel, 10);
        sparseIntArray.put(R.id.payableAmountLabel, 11);
        sparseIntArray.put(R.id.duration, 12);
        sparseIntArray.put(R.id.referralDiscount, 13);
        sparseIntArray.put(R.id.tvgst, 14);
        sparseIntArray.put(R.id.rlCouponLayout, 15);
        sparseIntArray.put(R.id.tv_coupon_amount, 16);
        sparseIntArray.put(R.id.textView7, 17);
        sparseIntArray.put(R.id.textView10, 18);
        sparseIntArray.put(R.id.llCouponMainLayout, 19);
        sparseIntArray.put(R.id.ll_coupon_layout, 20);
        sparseIntArray.put(R.id.edt_coupon, 21);
        sparseIntArray.put(R.id.btn_coupon_apply, 22);
        sparseIntArray.put(R.id.ll_coupon_applied_layout, 23);
        sparseIntArray.put(R.id.edtCouponApplied, 24);
        sparseIntArray.put(R.id.textView44, 25);
        sparseIntArray.put(R.id.iv_remove_coupon, 26);
        sparseIntArray.put(R.id.ivCloseIcon, 27);
        sparseIntArray.put(R.id.paymentButton, 28);
        sparseIntArray.put(R.id.imageView4, 29);
        sparseIntArray.put(R.id.textView8, 30);
        sparseIntArray.put(R.id.textView9, 31);
        sparseIntArray.put(R.id.imageView5, 32);
    }

    public FragmentReviewOrderBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 33, sIncludes, sViewsWithIds));
    }

    private FragmentReviewOrderBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1, (Button) bindings[22], (TextView) bindings[12], (TextView) bindings[9], (EditText) bindings[21], (EditText) bindings[24], (Guideline) bindings[7], (ImageView) bindings[29], (ImageView) bindings[32], (ImageView) bindings[27], (ImageView) bindings[26], (ConstraintLayout) bindings[23], (ConstraintLayout) bindings[20], (LinearLayout) bindings[19], (TextView) bindings[11], (Button) bindings[28], (TextView) bindings[1], (TextView) bindings[8], (TextView) bindings[13], (TextView) bindings[10], (TextView) bindings[5], (RelativeLayout) bindings[15], (Guideline) bindings[6], (TextView) bindings[18], (TextView) bindings[2], (TextView) bindings[25], (TextView) bindings[3], (TextView) bindings[17], (TextView) bindings[30], (TextView) bindings[31], (TextView) bindings[16], (TextView) bindings[4], (TextView) bindings[14]);
        this.mDirtyFlags = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) bindings[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.planName.setTag(null);
        this.textView4.setTag(null);
        this.textView6.setTag(null);
        this.tvTotalPayableAmount.setTag(null);
        setRootTag(root);
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
        if (16 == variableId) {
            setUser((User) variable);
        } else if (18 != variableId) {
            return false;
        } else {
            setViewModel((ReviewOrderViewModel) variable);
        }
        return true;
    }

    @Override // com.livpure.safedrink.databinding.FragmentReviewOrderBinding
    public void setUser(User User) {
        this.mUser = User;
    }

    @Override // com.livpure.safedrink.databinding.FragmentReviewOrderBinding
    public void setViewModel(ReviewOrderViewModel ViewModel) {
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
            return false;
        }
        return onChangeViewModelSelectedPlanName((MutableLiveData) object, fieldId);
    }

    private boolean onChangeViewModelSelectedPlanName(MutableLiveData<String> ViewModelSelectedPlanName, int fieldId) {
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
        String str;
        String str2;
        String str3;
        long j2;
        String str4;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        ReviewOrderViewModel reviewOrderViewModel = this.mViewModel;
        String str5 = null;
        int i = ((13 & j) > 0L ? 1 : ((13 & j) == 0L ? 0 : -1));
        if (i != 0) {
            if ((j & 12) != 0) {
                if (reviewOrderViewModel != null) {
                    str4 = reviewOrderViewModel.getPricePerMonth();
                    j2 = reviewOrderViewModel.getPayableAmount();
                } else {
                    j2 = 0;
                    str4 = null;
                }
                str = this.textView4.getResources().getString(R.string.Rs) + str4;
                String valueOf = String.valueOf(j2);
                str3 = this.textView6.getResources().getString(R.string.Rs) + valueOf;
                str2 = this.tvTotalPayableAmount.getResources().getString(R.string.Rs) + valueOf;
            } else {
                str = null;
                str2 = null;
                str3 = null;
            }
            MutableLiveData<String> mutableLiveData = reviewOrderViewModel != null ? reviewOrderViewModel.get_selectedPlanName() : null;
            updateLiveDataRegistration(0, mutableLiveData);
            if (mutableLiveData != null) {
                str5 = mutableLiveData.getValue();
            }
        } else {
            str = null;
            str2 = null;
            str3 = null;
        }
        if (i != 0) {
            TextViewBindingAdapter.setText(this.planName, str5);
        }
        if ((j & 12) != 0) {
            TextViewBindingAdapter.setText(this.textView4, str);
            TextViewBindingAdapter.setText(this.textView6, str3);
            TextViewBindingAdapter.setText(this.tvTotalPayableAmount, str2);
        }
    }
}
