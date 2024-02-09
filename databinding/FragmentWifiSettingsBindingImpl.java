package com.livpure.safedrink.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.android.material.textfield.MaterialAutoCompleteTextView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.livpure.safedrink.R;
import com.livpure.safedrink.bolt.model.WiFiSettingsModel;
/* loaded from: classes3.dex */
public class FragmentWifiSettingsBindingImpl extends FragmentWifiSettingsBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;
    private final RelativeLayout mboundView2;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.swipe_refresh_layout_comments, 3);
        sparseIntArray.put(R.id.linear_layout, 4);
        sparseIntArray.put(R.id.rgBtnWifiTypeId, 5);
        sparseIntArray.put(R.id.rBtnWifiId, 6);
        sparseIntArray.put(R.id.rBtnHotspotId, 7);
        sparseIntArray.put(R.id.edtWifiNameId, 8);
        sparseIntArray.put(R.id.textAutoInputWifiNameId, 9);
        sparseIntArray.put(R.id.autoWifiNameId, 10);
        sparseIntArray.put(R.id.imgRefreshId, 11);
        sparseIntArray.put(R.id.textInputPasswordId, 12);
        sparseIntArray.put(R.id.edtPasswordId, 13);
        sparseIntArray.put(R.id.resetWiFi, 14);
        sparseIntArray.put(R.id.update, 15);
        sparseIntArray.put(R.id.last_connected_wifi, 16);
        sparseIntArray.put(R.id.progressBar, 17);
    }

    public FragmentWifiSettingsBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 18, sIncludes, sViewsWithIds));
    }

    private FragmentWifiSettingsBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (MaterialAutoCompleteTextView) bindings[10], (TextInputEditText) bindings[13], (TextInputEditText) bindings[8], (ImageView) bindings[11], (TextView) bindings[16], (LinearLayout) bindings[4], (ProgressBar) bindings[17], (RadioButton) bindings[7], (RadioButton) bindings[6], (Button) bindings[14], (RadioGroup) bindings[5], (SwipeRefreshLayout) bindings[3], (TextInputLayout) bindings[9], (TextInputLayout) bindings[1], (TextInputLayout) bindings[12], (Button) bindings[15]);
        this.mDirtyFlags = -1L;
        LinearLayout linearLayout = (LinearLayout) bindings[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
        RelativeLayout relativeLayout = (RelativeLayout) bindings[2];
        this.mboundView2 = relativeLayout;
        relativeLayout.setTag(null);
        this.textInputAddressLineId.setTag(null);
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
        if (6 == variableId) {
            setIsWifiRouter((Boolean) variable);
        } else if (18 != variableId) {
            return false;
        } else {
            setViewModel((WiFiSettingsModel) variable);
        }
        return true;
    }

    @Override // com.livpure.safedrink.databinding.FragmentWifiSettingsBinding
    public void setIsWifiRouter(Boolean IsWifiRouter) {
        this.mIsWifiRouter = IsWifiRouter;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(6);
        super.requestRebind();
    }

    @Override // com.livpure.safedrink.databinding.FragmentWifiSettingsBinding
    public void setViewModel(WiFiSettingsModel ViewModel) {
        this.mViewModel = ViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        int i;
        long j2;
        long j3;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        Boolean bool = this.mIsWifiRouter;
        int i2 = ((j & 5) > 0L ? 1 : ((j & 5) == 0L ? 0 : -1));
        if (i2 != 0) {
            boolean safeUnbox = ViewDataBinding.safeUnbox(bool);
            if (i2 != 0) {
                if (safeUnbox) {
                    j2 = j | 16;
                    j3 = 64;
                } else {
                    j2 = j | 8;
                    j3 = 32;
                }
                j = j2 | j3;
            }
            int i3 = safeUnbox ? 0 : 8;
            i = safeUnbox ? 8 : 0;
            r9 = i3;
        } else {
            i = 0;
        }
        if ((j & 5) != 0) {
            this.mboundView2.setVisibility(r9);
            this.textInputAddressLineId.setVisibility(i);
        }
    }
}
