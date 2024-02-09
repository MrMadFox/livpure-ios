package com.livpure.safedrink.login;

import android.os.Bundle;
import androidx.navigation.NavDirections;
import com.livpure.safedrink.AuthenticationDirections;
import com.livpure.safedrink.NavGraphDirections;
import com.livpure.safedrink.R;
import com.livpure.safedrink.subscription.plan.data.model.deviceList.DeviceList;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class ResetPasswordFragmentDirections {
    private ResetPasswordFragmentDirections() {
    }

    public static ActionResetPasswordFragmentToAuthPagerFragment actionResetPasswordFragmentToAuthPagerFragment() {
        return new ActionResetPasswordFragmentToAuthPagerFragment();
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

    /* loaded from: classes3.dex */
    public static class ActionResetPasswordFragmentToAuthPagerFragment implements NavDirections {
        private final HashMap arguments;

        @Override // androidx.navigation.NavDirections
        public int getActionId() {
            return R.id.action_resetPasswordFragment_to_authPagerFragment;
        }

        private ActionResetPasswordFragmentToAuthPagerFragment() {
            this.arguments = new HashMap();
        }

        public ActionResetPasswordFragmentToAuthPagerFragment setAuthType(int authType) {
            this.arguments.put("authType", Integer.valueOf(authType));
            return this;
        }

        @Override // androidx.navigation.NavDirections
        public Bundle getArguments() {
            Bundle bundle = new Bundle();
            if (this.arguments.containsKey("authType")) {
                bundle.putInt("authType", ((Integer) this.arguments.get("authType")).intValue());
            } else {
                bundle.putInt("authType", 1);
            }
            return bundle;
        }

        public int getAuthType() {
            return ((Integer) this.arguments.get("authType")).intValue();
        }

        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (object == null || getClass() != object.getClass()) {
                return false;
            }
            ActionResetPasswordFragmentToAuthPagerFragment actionResetPasswordFragmentToAuthPagerFragment = (ActionResetPasswordFragmentToAuthPagerFragment) object;
            return this.arguments.containsKey("authType") == actionResetPasswordFragmentToAuthPagerFragment.arguments.containsKey("authType") && getAuthType() == actionResetPasswordFragmentToAuthPagerFragment.getAuthType() && getActionId() == actionResetPasswordFragmentToAuthPagerFragment.getActionId();
        }

        public int hashCode() {
            return ((getAuthType() + 31) * 31) + getActionId();
        }

        public String toString() {
            return "ActionResetPasswordFragmentToAuthPagerFragment(actionId=" + getActionId() + "){authType=" + getAuthType() + "}";
        }
    }
}
