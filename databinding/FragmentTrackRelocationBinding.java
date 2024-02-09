package com.livpure.safedrink.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.livpure.safedrink.R;
import com.livpure.safedrink.serviceRequest.model.TrackRelocationModel;
/* loaded from: classes3.dex */
public abstract class FragmentTrackRelocationBinding extends ViewDataBinding {
    public final ImageView imageAddressKycTime;
    public final ImageView imageInstallationCompletedTime;
    public final ImageView imageInstallationRegisteredTime;
    public final ImageView imageRequestRegisteredTime;
    public final ImageView imageRoPickupTime;
    public final LinearLayout installationComplet;
    public final LinearLayout llMainLayout;
    public final LinearLayout lyAddressKyc;
    public final LinearLayout lyNeedHelp;
    public final LinearLayout lyRequestReg;
    public final LinearLayout lyRoDeliveredInstallation;
    public final LinearLayout lyRoPick;
    @Bindable
    protected TrackRelocationModel mViewModel;
    public final TextView tvAddressKyc;
    public final TextView tvAddressKycTime;
    public final TextView tvInstallationCompleted;
    public final TextView tvInstallationCompletedTime;
    public final TextView tvInstallationRegistered;
    public final TextView tvInstallationRegisteredTime;
    public final TextView tvRequestId;
    public final TextView tvRequestRegistered;
    public final TextView tvRequestRegisteredTime;
    public final TextView tvRoPickup;
    public final TextView tvRoPickupTime;
    public final TextView tvTitle;
    public final View viewAddressKycTime;
    public final View viewInstallationCompletedTime;
    public final View viewInstallationRegisteredTime;
    public final View viewRequestRegisteredTime;
    public final View viewRoPickupTime;

    public abstract void setViewModel(TrackRelocationModel viewModel);

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentTrackRelocationBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageView imageAddressKycTime, ImageView imageInstallationCompletedTime, ImageView imageInstallationRegisteredTime, ImageView imageRequestRegisteredTime, ImageView imageRoPickupTime, LinearLayout installationComplet, LinearLayout llMainLayout, LinearLayout lyAddressKyc, LinearLayout lyNeedHelp, LinearLayout lyRequestReg, LinearLayout lyRoDeliveredInstallation, LinearLayout lyRoPick, TextView tvAddressKyc, TextView tvAddressKycTime, TextView tvInstallationCompleted, TextView tvInstallationCompletedTime, TextView tvInstallationRegistered, TextView tvInstallationRegisteredTime, TextView tvRequestId, TextView tvRequestRegistered, TextView tvRequestRegisteredTime, TextView tvRoPickup, TextView tvRoPickupTime, TextView tvTitle, View viewAddressKycTime, View viewInstallationCompletedTime, View viewInstallationRegisteredTime, View viewRequestRegisteredTime, View viewRoPickupTime) {
        super(_bindingComponent, _root, _localFieldCount);
        this.imageAddressKycTime = imageAddressKycTime;
        this.imageInstallationCompletedTime = imageInstallationCompletedTime;
        this.imageInstallationRegisteredTime = imageInstallationRegisteredTime;
        this.imageRequestRegisteredTime = imageRequestRegisteredTime;
        this.imageRoPickupTime = imageRoPickupTime;
        this.installationComplet = installationComplet;
        this.llMainLayout = llMainLayout;
        this.lyAddressKyc = lyAddressKyc;
        this.lyNeedHelp = lyNeedHelp;
        this.lyRequestReg = lyRequestReg;
        this.lyRoDeliveredInstallation = lyRoDeliveredInstallation;
        this.lyRoPick = lyRoPick;
        this.tvAddressKyc = tvAddressKyc;
        this.tvAddressKycTime = tvAddressKycTime;
        this.tvInstallationCompleted = tvInstallationCompleted;
        this.tvInstallationCompletedTime = tvInstallationCompletedTime;
        this.tvInstallationRegistered = tvInstallationRegistered;
        this.tvInstallationRegisteredTime = tvInstallationRegisteredTime;
        this.tvRequestId = tvRequestId;
        this.tvRequestRegistered = tvRequestRegistered;
        this.tvRequestRegisteredTime = tvRequestRegisteredTime;
        this.tvRoPickup = tvRoPickup;
        this.tvRoPickupTime = tvRoPickupTime;
        this.tvTitle = tvTitle;
        this.viewAddressKycTime = viewAddressKycTime;
        this.viewInstallationCompletedTime = viewInstallationCompletedTime;
        this.viewInstallationRegisteredTime = viewInstallationRegisteredTime;
        this.viewRequestRegisteredTime = viewRequestRegisteredTime;
        this.viewRoPickupTime = viewRoPickupTime;
    }

    public TrackRelocationModel getViewModel() {
        return this.mViewModel;
    }

    public static FragmentTrackRelocationBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentTrackRelocationBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentTrackRelocationBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_track_relocation, root, attachToRoot, component);
    }

    public static FragmentTrackRelocationBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentTrackRelocationBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentTrackRelocationBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_track_relocation, null, false, component);
    }

    public static FragmentTrackRelocationBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentTrackRelocationBinding bind(View view, Object component) {
        return (FragmentTrackRelocationBinding) bind(component, view, R.layout.fragment_track_relocation);
    }
}
