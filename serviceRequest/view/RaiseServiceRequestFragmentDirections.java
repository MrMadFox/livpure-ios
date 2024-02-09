package com.livpure.safedrink.serviceRequest.view;

import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.livpure.safedrink.NavGraphDirections;
import com.livpure.safedrink.R;
import com.livpure.safedrink.subscription.plan.data.model.deviceList.DeviceList;
/* loaded from: classes3.dex */
public class RaiseServiceRequestFragmentDirections {
    private RaiseServiceRequestFragmentDirections() {
    }

    public static NavDirections actionContactUsFragmentToRaiseServiceRequestHistoryFragment() {
        return new ActionOnlyNavDirections(R.id.action_contactUsFragment_to_raiseServiceRequestHistoryFragment);
    }

    public static NavDirections actionRaiseServiceRequestToReferralData() {
        return new ActionOnlyNavDirections(R.id.action_raiseServiceRequest_to_referralData);
    }

    public static NavDirections actionRaiseServiceRequestToRechargeHistoryFragment() {
        return new ActionOnlyNavDirections(R.id.action_raiseServiceRequest_to_rechargeHistoryFragment);
    }

    public static NavDirections actionGlobalHomeFurlencoFragment() {
        return NavGraphDirections.actionGlobalHomeFurlencoFragment();
    }

    public static NavGraphDirections.ActionGlobalOnBoardingWebViewFragment actionGlobalOnBoardingWebViewFragment(int url) {
        return NavGraphDirections.actionGlobalOnBoardingWebViewFragment(url);
    }

    public static NavDirections actionGlobalLogout() {
        return NavGraphDirections.actionGlobalLogout();
    }

    public static NavGraphDirections.ActionGlobalAuthentication actionGlobalAuthentication() {
        return NavGraphDirections.actionGlobalAuthentication();
    }

    public static NavGraphDirections.ActionGlobalWebViewFragment actionGlobalWebViewFragment(int url) {
        return NavGraphDirections.actionGlobalWebViewFragment(url);
    }

    public static NavDirections actionGlobalSplashFragment() {
        return NavGraphDirections.actionGlobalSplashFragment();
    }

    public static NavGraphDirections.ActionGlobalHomeFragment actionGlobalHomeFragment(String serialNumber) {
        return NavGraphDirections.actionGlobalHomeFragment(serialNumber);
    }

    public static NavGraphDirections.ActionGlobalRoHomeFragment actionGlobalRoHomeFragment(DeviceList device) {
        return NavGraphDirections.actionGlobalRoHomeFragment(device);
    }

    public static NavDirections actionGlobalNoNetworkFragment() {
        return NavGraphDirections.actionGlobalNoNetworkFragment();
    }

    public static NavDirections actionGlobalReferAndEarnFragment() {
        return NavGraphDirections.actionGlobalReferAndEarnFragment();
    }
}
