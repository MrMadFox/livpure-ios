package com.livpure.safedrink.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.livpure.safedrink.referNearn.model.LaderShipArrayResponse;
/* loaded from: classes3.dex */
public class AdapterReferrralSuperUserBindingImpl extends AdapterReferrralSuperUserBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;
    private final TextView mboundView1;
    private final TextView mboundView3;
    private final TextView mboundView4;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    public AdapterReferrralSuperUserBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 5, sIncludes, sViewsWithIds));
    }

    private AdapterReferrralSuperUserBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (TextView) bindings[2]);
        this.mDirtyFlags = -1L;
        LinearLayout linearLayout = (LinearLayout) bindings[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
        TextView textView = (TextView) bindings[1];
        this.mboundView1 = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) bindings[3];
        this.mboundView3 = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) bindings[4];
        this.mboundView4 = textView3;
        textView3.setTag(null);
        this.txtShortNameId.setTag(null);
        setRootTag(root);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 2L;
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
        if (15 == variableId) {
            setSuperUser((LaderShipArrayResponse) variable);
            return true;
        }
        return false;
    }

    @Override // com.livpure.safedrink.databinding.AdapterReferrralSuperUserBinding
    public void setSuperUser(LaderShipArrayResponse SuperUser) {
        this.mSuperUser = SuperUser;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(15);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        String str2;
        String str3;
        int i;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        LaderShipArrayResponse laderShipArrayResponse = this.mSuperUser;
        String str4 = null;
        int i2 = ((j & 3) > 0L ? 1 : ((j & 3) == 0L ? 0 : -1));
        if (i2 != 0) {
            int i3 = 0;
            if (laderShipArrayResponse != null) {
                i3 = laderShipArrayResponse.getReferRank();
                String referName = laderShipArrayResponse.getReferName();
                str3 = laderShipArrayResponse.getReferAlliasName();
                i = laderShipArrayResponse.getReferCount();
                str4 = referName;
            } else {
                str3 = null;
                i = 0;
            }
            String valueOf = String.valueOf(i3);
            str2 = String.valueOf(i);
            String str5 = str4;
            str4 = valueOf;
            str = str5;
        } else {
            str = null;
            str2 = null;
            str3 = null;
        }
        if (i2 != 0) {
            TextViewBindingAdapter.setText(this.mboundView1, str4);
            TextViewBindingAdapter.setText(this.mboundView3, str);
            TextViewBindingAdapter.setText(this.mboundView4, str2);
            TextViewBindingAdapter.setText(this.txtShortNameId, str3);
        }
    }
}
