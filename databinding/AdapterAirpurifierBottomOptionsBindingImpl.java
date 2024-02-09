package com.livpure.safedrink.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.livpure.safedrink.model.AirPurifierBottomOption;
import com.livpure.safedrink.utils.BindingAdapterView;
/* loaded from: classes3.dex */
public class AdapterAirpurifierBottomOptionsBindingImpl extends AdapterAirpurifierBottomOptionsBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;
    private final ImageView mboundView1;
    private final TextView mboundView2;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    public AdapterAirpurifierBottomOptionsBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 3, sIncludes, sViewsWithIds));
    }

    private AdapterAirpurifierBottomOptionsBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (LinearLayout) bindings[0]);
        this.mDirtyFlags = -1L;
        this.lytValidityId.setTag(null);
        ImageView imageView = (ImageView) bindings[1];
        this.mboundView1 = imageView;
        imageView.setTag(null);
        TextView textView = (TextView) bindings[2];
        this.mboundView2 = textView;
        textView.setTag(null);
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
        if (8 == variableId) {
            setOption((AirPurifierBottomOption) variable);
            return true;
        }
        return false;
    }

    @Override // com.livpure.safedrink.databinding.AdapterAirpurifierBottomOptionsBinding
    public void setOption(AirPurifierBottomOption Option) {
        this.mOption = Option;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(8);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        int i = 0;
        AirPurifierBottomOption airPurifierBottomOption = this.mOption;
        String str2 = null;
        Integer num = null;
        int i2 = ((j & 3) > 0L ? 1 : ((j & 3) == 0L ? 0 : -1));
        if (i2 != 0) {
            if (airPurifierBottomOption != null) {
                str = airPurifierBottomOption.getTitle();
                num = airPurifierBottomOption.getIcon();
            } else {
                str = null;
            }
            i = ViewDataBinding.safeUnbox(num);
            str2 = str;
        }
        if (i2 != 0) {
            BindingAdapterView.setImageResource(this.mboundView1, i);
            TextViewBindingAdapter.setText(this.mboundView2, str2);
        }
    }
}
