package com.livpure.safedrink.referNearn.view.fragment;

import android.os.Bundle;
import androidx.navigation.NavDirections;
import com.livpure.safedrink.NavGraphDirections;
import com.livpure.safedrink.R;
import com.livpure.safedrink.subscription.plan.data.model.deviceList.DeviceList;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class ReferEarnFragmentDirections {
    private ReferEarnFragmentDirections() {
    }

    public static ActionSelectReferAndEarnToTermsAndCondition actionSelectReferAndEarnToTermsAndCondition(int url) {
        return new ActionSelectReferAndEarnToTermsAndCondition(url);
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

    /* loaded from: classes3.dex */
    public static class ActionSelectReferAndEarnToTermsAndCondition implements NavDirections {
        private final HashMap arguments;

        @Override // androidx.navigation.NavDirections
        public int getActionId() {
            return R.id.action_selectReferAndEarn_to_termsAndCondition;
        }

        private ActionSelectReferAndEarnToTermsAndCondition(int url) {
            HashMap hashMap = new HashMap();
            this.arguments = hashMap;
            hashMap.put("url", Integer.valueOf(url));
        }

        public ActionSelectReferAndEarnToTermsAndCondition setUrl(int url) {
            this.arguments.put("url", Integer.valueOf(url));
            return this;
        }

        @Override // androidx.navigation.NavDirections
        public Bundle getArguments() {
            Bundle bundle = new Bundle();
            if (this.arguments.containsKey("url")) {
                bundle.putInt("url", ((Integer) this.arguments.get("url")).intValue());
            }
            return bundle;
        }

        public int getUrl() {
            return ((Integer) this.arguments.get("url")).intValue();
        }

        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (object == null || getClass() != object.getClass()) {
                return false;
            }
            ActionSelectReferAndEarnToTermsAndCondition actionSelectReferAndEarnToTermsAndCondition = (ActionSelectReferAndEarnToTermsAndCondition) object;
            return this.arguments.containsKey("url") == actionSelectReferAndEarnToTermsAndCondition.arguments.containsKey("url") && getUrl() == actionSelectReferAndEarnToTermsAndCondition.getUrl() && getActionId() == actionSelectReferAndEarnToTermsAndCondition.getActionId();
        }

        public int hashCode() {
            return ((getUrl() + 31) * 31) + getActionId();
        }

        public String toString() {
            return "ActionSelectReferAndEarnToTermsAndCondition(actionId=" + getActionId() + "){url=" + getUrl() + "}";
        }
    }
}
