package com.livpure.safedrink.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.livpure.safedrink.R;
import com.livpure.safedrink.login.data.models.User;
import com.livpure.safedrink.subscription.payment.viewmodel.ReviewOrderViewModel;
/* loaded from: classes3.dex */
public abstract class FragmentReviewOrderBinding extends ViewDataBinding {
    public final Button btnCouponApply;
    public final TextView duration;
    public final TextView durationLabel;
    public final EditText edtCoupon;
    public final EditText edtCouponApplied;
    public final Guideline endGuideline;
    public final ImageView imageView4;
    public final ImageView imageView5;
    public final ImageView ivCloseIcon;
    public final ImageView ivRemoveCoupon;
    public final ConstraintLayout llCouponAppliedLayout;
    public final ConstraintLayout llCouponLayout;
    public final LinearLayout llCouponMainLayout;
    @Bindable
    protected User mUser;
    @Bindable
    protected ReviewOrderViewModel mViewModel;
    public final TextView payableAmountLabel;
    public final Button paymentButton;
    public final TextView planName;
    public final TextView planNameLabel;
    public final TextView referralDiscount;
    public final TextView referralDiscountLabel;
    public final TextView reviewAndPayLabel;
    public final RelativeLayout rlCouponLayout;
    public final Guideline startGuideline;
    public final TextView textView10;
    public final TextView textView4;
    public final TextView textView44;
    public final TextView textView6;
    public final TextView textView7;
    public final TextView textView8;
    public final TextView textView9;
    public final TextView tvCouponAmount;
    public final TextView tvTotalPayableAmount;
    public final TextView tvgst;

    public abstract void setUser(User user);

    public abstract void setViewModel(ReviewOrderViewModel viewModel);

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentReviewOrderBinding(Object _bindingComponent, View _root, int _localFieldCount, Button btnCouponApply, TextView duration, TextView durationLabel, EditText edtCoupon, EditText edtCouponApplied, Guideline endGuideline, ImageView imageView4, ImageView imageView5, ImageView ivCloseIcon, ImageView ivRemoveCoupon, ConstraintLayout llCouponAppliedLayout, ConstraintLayout llCouponLayout, LinearLayout llCouponMainLayout, TextView payableAmountLabel, Button paymentButton, TextView planName, TextView planNameLabel, TextView referralDiscount, TextView referralDiscountLabel, TextView reviewAndPayLabel, RelativeLayout rlCouponLayout, Guideline startGuideline, TextView textView10, TextView textView4, TextView textView44, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView tvCouponAmount, TextView tvTotalPayableAmount, TextView tvgst) {
        super(_bindingComponent, _root, _localFieldCount);
        this.btnCouponApply = btnCouponApply;
        this.duration = duration;
        this.durationLabel = durationLabel;
        this.edtCoupon = edtCoupon;
        this.edtCouponApplied = edtCouponApplied;
        this.endGuideline = endGuideline;
        this.imageView4 = imageView4;
        this.imageView5 = imageView5;
        this.ivCloseIcon = ivCloseIcon;
        this.ivRemoveCoupon = ivRemoveCoupon;
        this.llCouponAppliedLayout = llCouponAppliedLayout;
        this.llCouponLayout = llCouponLayout;
        this.llCouponMainLayout = llCouponMainLayout;
        this.payableAmountLabel = payableAmountLabel;
        this.paymentButton = paymentButton;
        this.planName = planName;
        this.planNameLabel = planNameLabel;
        this.referralDiscount = referralDiscount;
        this.referralDiscountLabel = referralDiscountLabel;
        this.reviewAndPayLabel = reviewAndPayLabel;
        this.rlCouponLayout = rlCouponLayout;
        this.startGuideline = startGuideline;
        this.textView10 = textView10;
        this.textView4 = textView4;
        this.textView44 = textView44;
        this.textView6 = textView6;
        this.textView7 = textView7;
        this.textView8 = textView8;
        this.textView9 = textView9;
        this.tvCouponAmount = tvCouponAmount;
        this.tvTotalPayableAmount = tvTotalPayableAmount;
        this.tvgst = tvgst;
    }

    public User getUser() {
        return this.mUser;
    }

    public ReviewOrderViewModel getViewModel() {
        return this.mViewModel;
    }

    public static FragmentReviewOrderBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentReviewOrderBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentReviewOrderBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_review_order, root, attachToRoot, component);
    }

    public static FragmentReviewOrderBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentReviewOrderBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentReviewOrderBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_review_order, null, false, component);
    }

    public static FragmentReviewOrderBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentReviewOrderBinding bind(View view, Object component) {
        return (FragmentReviewOrderBinding) bind(component, view, R.layout.fragment_review_order);
    }
}
