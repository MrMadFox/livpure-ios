package com.livpure.safedrink.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.livpure.safedrink.model.DispenserBottomOption;
import com.livpure.safedrink.utils.BindingAdapterView;
/* loaded from: classes3.dex */
public class AdapterDispenserBottomOptionsBindingImpl extends AdapterDispenserBottomOptionsBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;
    private final ImageView mboundView1;
    private final TextView mboundView2;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    public AdapterDispenserBottomOptionsBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 3, sIncludes, sViewsWithIds));
    }

    private AdapterDispenserBottomOptionsBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
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
            this.mDirtyFlags = 4L;
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
        if (7 == variableId) {
            setMargin((Integer) variable);
        } else if (8 != variableId) {
            return false;
        } else {
            setOption((DispenserBottomOption) variable);
        }
        return true;
    }

    @Override // com.livpure.safedrink.databinding.AdapterDispenserBottomOptionsBinding
    public void setMargin(Integer Margin) {
        this.mMargin = Margin;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(7);
        super.requestRebind();
    }

    @Override // com.livpure.safedrink.databinding.AdapterDispenserBottomOptionsBinding
    public void setOption(DispenserBottomOption Option) {
        this.mOption = Option;
        synchronized (this) {
            this.mDirtyFlags |= 2;
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
        Integer num = this.mMargin;
        DispenserBottomOption dispenserBottomOption = this.mOption;
        int i = 0;
        int i2 = ((5 & j) > 0L ? 1 : ((5 & j) == 0L ? 0 : -1));
        int safeUnbox = i2 != 0 ? ViewDataBinding.safeUnbox(num) : 0;
        String str2 = null;
        Integer num2 = null;
        int i3 = ((j & 6) > 0L ? 1 : ((j & 6) == 0L ? 0 : -1));
        if (i3 != 0) {
            if (dispenserBottomOption != null) {
                String title = dispenserBottomOption.getTitle();
                num2 = dispenserBottomOption.getIcon();
                str = title;
            } else {
                str = null;
            }
            i = ViewDataBinding.safeUnbox(num2);
            str2 = str;
        }
        if (i2 != 0) {
            BindingAdapterView.setMargin(this.lytValidityId, safeUnbox);
        }
        if (i3 != 0) {
            BindingAdapterView.setImageResource(this.mboundView1, i);
            TextViewBindingAdapter.setText(this.mboundView2, str2);
        }
    }
}
