package com.livpure.safedrink.login;

import android.os.Bundle;
import androidx.navigation.NavDirections;
import com.livpure.safedrink.AuthenticationDirections;
import com.livpure.safedrink.NavGraphDirections;
import com.livpure.safedrink.R;
import com.livpure.safedrink.subscription.plan.data.model.deviceList.DeviceList;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class ForgotPasswordFragmentDirections {
    private ForgotPasswordFragmentDirections() {
    }

    public static ActionForgotPasswordFragmentToResetPasswordFragment actionForgotPasswordFragmentToResetPasswordFragment(String username) {
        return new ActionForgotPasswordFragmentToResetPasswordFragment(username);
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
    public static class ActionForgotPasswordFragmentToResetPasswordFragment implements NavDirections {
        private final HashMap arguments;

        @Override // androidx.navigation.NavDirections
        public int getActionId() {
            return R.id.action_forgotPasswordFragment_to_resetPasswordFragment;
        }

        private ActionForgotPasswordFragmentToResetPasswordFragment(String username) {
            HashMap hashMap = new HashMap();
            this.arguments = hashMap;
            if (username == null) {
                throw new IllegalArgumentException("Argument \"username\" is marked as non-null but was passed a null value.");
            }
            hashMap.put("username", username);
        }

        public ActionForgotPasswordFragmentToResetPasswordFragment setUsername(String username) {
            if (username == null) {
                throw new IllegalArgumentException("Argument \"username\" is marked as non-null but was passed a null value.");
            }
            this.arguments.put("username", username);
            return this;
        }

        @Override // androidx.navigation.NavDirections
        public Bundle getArguments() {
            Bundle bundle = new Bundle();
            if (this.arguments.containsKey("username")) {
                bundle.putString("username", (String) this.arguments.get("username"));
            }
            return bundle;
        }

        public String getUsername() {
            return (String) this.arguments.get("username");
        }

        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (object == null || getClass() != object.getClass()) {
                return false;
            }
            ActionForgotPasswordFragmentToResetPasswordFragment actionForgotPasswordFragmentToResetPasswordFragment = (ActionForgotPasswordFragmentToResetPasswordFragment) object;
            if (this.arguments.containsKey("username") != actionForgotPasswordFragmentToResetPasswordFragment.arguments.containsKey("username")) {
                return false;
            }
            if (getUsername() == null ? actionForgotPasswordFragmentToResetPasswordFragment.getUsername() == null : getUsername().equals(actionForgotPasswordFragmentToResetPasswordFragment.getUsername())) {
                return getActionId() == actionForgotPasswordFragmentToResetPasswordFragment.getActionId();
            }
            return false;
        }

        public int hashCode() {
            return (((getUsername() != null ? getUsername().hashCode() : 0) + 31) * 31) + getActionId();
        }

        public String toString() {
            return "ActionForgotPasswordFragmentToResetPasswordFragment(actionId=" + getActionId() + "){username=" + getUsername() + "}";
        }
    }
}
