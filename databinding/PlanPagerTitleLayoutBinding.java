package com.livpure.safedrink.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.textview.MaterialTextView;
import com.livpure.safedrink.R;
/* loaded from: classes3.dex */
public abstract class PlanPagerTitleLayoutBinding extends ViewDataBinding {
    public final MaterialCardView cardTitleId;
    public final ImageView imgTriangleId;
    @Bindable
    protected String mPlanTitle;
    public final MaterialTextView txtPlanTitleId;

    public abstract void setPlanTitle(String planTitle);

    /* JADX INFO: Access modifiers changed from: protected */
    public PlanPagerTitleLayoutBinding(Object _bindingComponent, View _root, int _localFieldCount, MaterialCardView cardTitleId, ImageView imgTriangleId, MaterialTextView txtPlanTitleId) {
        super(_bindingComponent, _root, _localFieldCount);
        this.cardTitleId = cardTitleId;
        this.imgTriangleId = imgTriangleId;
        this.txtPlanTitleId = txtPlanTitleId;
    }

    public String getPlanTitle() {
        return this.mPlanTitle;
    }

    public static PlanPagerTitleLayoutBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PlanPagerTitleLayoutBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (PlanPagerTitleLayoutBinding) ViewDataBinding.inflateInternal(inflater, R.layout.plan_pager_title_layout, root, attachToRoot, component);
    }

    public static PlanPagerTitleLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PlanPagerTitleLayoutBinding inflate(LayoutInflater inflater, Object component) {
        return (PlanPagerTitleLayoutBinding) ViewDataBinding.inflateInternal(inflater, R.layout.plan_pager_title_layout, null, false, component);
    }

    public static PlanPagerTitleLayoutBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PlanPagerTitleLayoutBinding bind(View view, Object component) {
        return (PlanPagerTitleLayoutBinding) bind(component, view, R.layout.plan_pager_title_layout);
    }
}
