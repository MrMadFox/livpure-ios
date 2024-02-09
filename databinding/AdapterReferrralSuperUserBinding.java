package com.livpure.safedrink.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.livpure.safedrink.R;
import com.livpure.safedrink.referNearn.model.LaderShipArrayResponse;
/* loaded from: classes3.dex */
public abstract class AdapterReferrralSuperUserBinding extends ViewDataBinding {
    @Bindable
    protected LaderShipArrayResponse mSuperUser;
    public final TextView txtShortNameId;

    public abstract void setSuperUser(LaderShipArrayResponse superUser);

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterReferrralSuperUserBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView txtShortNameId) {
        super(_bindingComponent, _root, _localFieldCount);
        this.txtShortNameId = txtShortNameId;
    }

    public LaderShipArrayResponse getSuperUser() {
        return this.mSuperUser;
    }

    public static AdapterReferrralSuperUserBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterReferrralSuperUserBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (AdapterReferrralSuperUserBinding) ViewDataBinding.inflateInternal(inflater, R.layout.adapter_referrral_super_user, root, attachToRoot, component);
    }

    public static AdapterReferrralSuperUserBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterReferrralSuperUserBinding inflate(LayoutInflater inflater, Object component) {
        return (AdapterReferrralSuperUserBinding) ViewDataBinding.inflateInternal(inflater, R.layout.adapter_referrral_super_user, null, false, component);
    }

    public static AdapterReferrralSuperUserBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterReferrralSuperUserBinding bind(View view, Object component) {
        return (AdapterReferrralSuperUserBinding) bind(component, view, R.layout.adapter_referrral_super_user);
    }
}
