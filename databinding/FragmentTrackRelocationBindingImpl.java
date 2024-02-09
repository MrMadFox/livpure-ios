package com.livpure.safedrink.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.livpure.safedrink.R;
import com.livpure.safedrink.serviceRequest.model.TrackRelocationModel;
/* loaded from: classes3.dex */
public class FragmentTrackRelocationBindingImpl extends FragmentTrackRelocationBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final RelativeLayout mboundView0;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.tv_title, 1);
        sparseIntArray.put(R.id.ll_main_layout, 2);
        sparseIntArray.put(R.id.tv_request_id, 3);
        sparseIntArray.put(R.id.ly_request_reg, 4);
        sparseIntArray.put(R.id.image_request_registered_time, 5);
        sparseIntArray.put(R.id.view_request_registered_time, 6);
        sparseIntArray.put(R.id.tv_request_registered, 7);
        sparseIntArray.put(R.id.tv_request_registered_time, 8);
        sparseIntArray.put(R.id.ly_ro_pick, 9);
        sparseIntArray.put(R.id.image_ro_pickup_time, 10);
        sparseIntArray.put(R.id.view_ro_pickup_time, 11);
        sparseIntArray.put(R.id.tv_ro_pickup, 12);
        sparseIntArray.put(R.id.tv_ro_pickup_time, 13);
        sparseIntArray.put(R.id.ly_address_kyc, 14);
        sparseIntArray.put(R.id.image_address_kyc_time, 15);
        sparseIntArray.put(R.id.view_address_kyc_time, 16);
        sparseIntArray.put(R.id.tv_address_kyc, 17);
        sparseIntArray.put(R.id.tv_address_kyc_time, 18);
        sparseIntArray.put(R.id.ly_ro_delivered_installation, 19);
        sparseIntArray.put(R.id.image_installation_registered_time, 20);
        sparseIntArray.put(R.id.view_installation_registered_time, 21);
        sparseIntArray.put(R.id.tv_installation_registered, 22);
        sparseIntArray.put(R.id.tv_installation_registered_time, 23);
        sparseIntArray.put(R.id.installation_complet, 24);
        sparseIntArray.put(R.id.image_installation_completed_time, 25);
        sparseIntArray.put(R.id.view_installation_completed_time, 26);
        sparseIntArray.put(R.id.tv_installation_completed, 27);
        sparseIntArray.put(R.id.tv_installation_completed_time, 28);
        sparseIntArray.put(R.id.ly_need_help, 29);
    }

    public FragmentTrackRelocationBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 30, sIncludes, sViewsWithIds));
    }

    private FragmentTrackRelocationBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (ImageView) bindings[15], (ImageView) bindings[25], (ImageView) bindings[20], (ImageView) bindings[5], (ImageView) bindings[10], (LinearLayout) bindings[24], (LinearLayout) bindings[2], (LinearLayout) bindings[14], (LinearLayout) bindings[29], (LinearLayout) bindings[4], (LinearLayout) bindings[19], (LinearLayout) bindings[9], (TextView) bindings[17], (TextView) bindings[18], (TextView) bindings[27], (TextView) bindings[28], (TextView) bindings[22], (TextView) bindings[23], (TextView) bindings[3], (TextView) bindings[7], (TextView) bindings[8], (TextView) bindings[12], (TextView) bindings[13], (TextView) bindings[1], (View) bindings[16], (View) bindings[26], (View) bindings[21], (View) bindings[6], (View) bindings[11]);
        this.mDirtyFlags = -1L;
        RelativeLayout relativeLayout = (RelativeLayout) bindings[0];
        this.mboundView0 = relativeLayout;
        relativeLayout.setTag(null);
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
        if (18 == variableId) {
            setViewModel((TrackRelocationModel) variable);
            return true;
        }
        return false;
    }

    @Override // com.livpure.safedrink.databinding.FragmentTrackRelocationBinding
    public void setViewModel(TrackRelocationModel ViewModel) {
        this.mViewModel = ViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}
