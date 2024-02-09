package com.livpure.safedrink.login;

import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.livpure.safedrink.AuthenticationDirections;
import com.livpure.safedrink.NavGraphDirections;
import com.livpure.safedrink.R;
import com.livpure.safedrink.subscription.plan.data.model.deviceList.DeviceList;
/* loaded from: classes3.dex */
public class AuthPagerFragmentDirections {
    private AuthPagerFragmentDirections() {
    }

    public static NavDirections actionAuthPagerFragmentToOnboardingFragment() {
        return new ActionOnlyNavDirections(R.id.action_authPagerFragment_to_onboardingFragment);
    }

    public static NavDirections actionAuthPagerFragmentToForgotPasswordFragment() {
        return new ActionOnlyNavDirections(R.id.action_authPagerFragment_to_forgotPasswordFragment);
    }

    public static NavDirections actionGlobalHomeFurlencoFragment() {
        return AuthenticationDirections.actionGlobalHomeFurlencoFragment();
    }

    public static NavGraphDirections.ActionGlobalOnBoardingWebViewFragment actionGlobalOnBoardingWebViewFragment(int url) {
        return AuthenticationDirections.actionGlobalOnBoardingWebViewFragment(url);
    }

    public static NavDirections actionGlobalLogout() {
        return AuthenticationDirections.actionGlobalLogout();
    }

    public static NavGraphDirections.ActionGlobalAuthentication actionGlobalAuthentication() {
        return AuthenticationDirections.actionGlobalAuthentication();
    }

    public static NavGraphDirections.ActionGlobalWebViewFragment actionGlobalWebViewFragment(int url) {
        return AuthenticationDirections.actionGlobalWebViewFragment(url);
    }

    public static NavDirections actionGlobalSplashFragment() {
        return AuthenticationDirections.actionGlobalSplashFragment();
    }

    public static NavGraphDirections.ActionGlobalHomeFragment actionGlobalHomeFragment(String serialNumber) {
        return AuthenticationDirections.actionGlobalHomeFragment(serialNumber);
    }

    public static NavGraphDirections.ActionGlobalRoHomeFragment actionGlobalRoHomeFragment(DeviceList device) {
        return AuthenticationDirections.actionGlobalRoHomeFragment(device);
    }

    public static NavDirections actionGlobalNoNetworkFragment() {
        return AuthenticationDirections.actionGlobalNoNetworkFragment();
    }

    public static NavDirections actionGlobalReferAndEarnFragment() {
        return AuthenticationDirections.actionGlobalReferAndEarnFragment();
    }
}
