package com.livpure.safedrink.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.livpure.safedrink.R;
import com.livpure.safedrink.referNearn.model.ReferralHistoryResponse;
import com.livpure.safedrink.referNearn.view.adapter.ReferralHistoryAdapter;
/* loaded from: classes3.dex */
public abstract class AdapterReferrralHistoryBinding extends ViewDataBinding {
    public final ImageView imgCallId;
    public final ImageView imgWhatsappId;
    @Bindable
    protected ReferralHistoryAdapter mCallBack;
    @Bindable
    protected Integer mPosition;
    @Bindable
    protected ReferralHistoryResponse mReferral;

    public abstract void setCallBack(ReferralHistoryAdapter callBack);

    public abstract void setPosition(Integer position);

    public abstract void setReferral(ReferralHistoryResponse referral);

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterReferrralHistoryBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageView imgCallId, ImageView imgWhatsappId) {
        super(_bindingComponent, _root, _localFieldCount);
        this.imgCallId = imgCallId;
        this.imgWhatsappId = imgWhatsappId;
    }

    public ReferralHistoryResponse getReferral() {
        return this.mReferral;
    }

    public ReferralHistoryAdapter getCallBack() {
        return this.mCallBack;
    }

    public Integer getPosition() {
        return this.mPosition;
    }

    public static AdapterReferrralHistoryBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterReferrralHistoryBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (AdapterReferrralHistoryBinding) ViewDataBinding.inflateInternal(inflater, R.layout.adapter_referrral_history, root, attachToRoot, component);
    }

    public static AdapterReferrralHistoryBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterReferrralHistoryBinding inflate(LayoutInflater inflater, Object component) {
        return (AdapterReferrralHistoryBinding) ViewDataBinding.inflateInternal(inflater, R.layout.adapter_referrral_history, null, false, component);
    }

    public static AdapterReferrralHistoryBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterReferrralHistoryBinding bind(View view, Object component) {
        return (AdapterReferrralHistoryBinding) bind(component, view, R.layout.adapter_referrral_history);
    }
}
