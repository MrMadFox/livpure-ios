package com.livpure.safedrink.app.support.views;

import android.os.Bundle;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.livpure.safedrink.NavGraphDirections;
import com.livpure.safedrink.R;
import com.livpure.safedrink.subscription.plan.data.model.deviceList.DeviceList;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class ContactUsFragmentDirections {
    private ContactUsFragmentDirections() {
    }

    public static NavDirections actionContactUsFragmentToServiceRequestFragment() {
        return new ActionOnlyNavDirections(R.id.action_contactUsFragment_to_serviceRequestFragment);
    }

    public static ActionContactUsFragmentToRaiseServiceRequestFragment actionContactUsFragmentToRaiseServiceRequestFragment(String serialNumber, String cancelSubscription) {
        return new ActionContactUsFragmentToRaiseServiceRequestFragment(serialNumber, cancelSubscription);
    }

    public static NavDirections actionContactUsFragmentToRaiseServiceRequestHistoryFragment() {
        return new ActionOnlyNavDirections(R.id.action_contactUsFragment_to_raiseServiceRequestHistoryFragment);
    }

    public static NavDirections actionContactUsFragmentToRelocationFragment() {
        return new ActionOnlyNavDirections(R.id.action_contactUsFragment_to_relocationFragment);
    }

    public static NavDirections actionContactUsFragmentToTrackRelocation() {
        return new ActionOnlyNavDirections(R.id.action_contactUsFragment_to_trackRelocation);
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
    public static class ActionContactUsFragmentToRaiseServiceRequestFragment implements NavDirections {
        private final HashMap arguments;

        @Override // androidx.navigation.NavDirections
        public int getActionId() {
            return R.id.action_contactUsFragment_to_raiseServiceRequestFragment;
        }

        private ActionContactUsFragmentToRaiseServiceRequestFragment(String serialNumber, String cancelSubscription) {
            HashMap hashMap = new HashMap();
            this.arguments = hashMap;
            if (serialNumber == null) {
                throw new IllegalArgumentException("Argument \"serialNumber\" is marked as non-null but was passed a null value.");
            }
            hashMap.put("serialNumber", serialNumber);
            if (cancelSubscription == null) {
                throw new IllegalArgumentException("Argument \"cancelSubscription\" is marked as non-null but was passed a null value.");
            }
            hashMap.put("cancelSubscription", cancelSubscription);
        }

        public ActionContactUsFragmentToRaiseServiceRequestFragment setSerialNumber(String serialNumber) {
            if (serialNumber == null) {
                throw new IllegalArgumentException("Argument \"serialNumber\" is marked as non-null but was passed a null value.");
            }
            this.arguments.put("serialNumber", serialNumber);
            return this;
        }

        public ActionContactUsFragmentToRaiseServiceRequestFragment setCancelSubscription(String cancelSubscription) {
            if (cancelSubscription == null) {
                throw new IllegalArgumentException("Argument \"cancelSubscription\" is marked as non-null but was passed a null value.");
            }
            this.arguments.put("cancelSubscription", cancelSubscription);
            return this;
        }

        @Override // androidx.navigation.NavDirections
        public Bundle getArguments() {
            Bundle bundle = new Bundle();
            if (this.arguments.containsKey("serialNumber")) {
                bundle.putString("serialNumber", (String) this.arguments.get("serialNumber"));
            }
            if (this.arguments.containsKey("cancelSubscription")) {
                bundle.putString("cancelSubscription", (String) this.arguments.get("cancelSubscription"));
            }
            return bundle;
        }

        public String getSerialNumber() {
            return (String) this.arguments.get("serialNumber");
        }

        public String getCancelSubscription() {
            return (String) this.arguments.get("cancelSubscription");
        }

        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (object == null || getClass() != object.getClass()) {
                return false;
            }
            ActionContactUsFragmentToRaiseServiceRequestFragment actionContactUsFragmentToRaiseServiceRequestFragment = (ActionContactUsFragmentToRaiseServiceRequestFragment) object;
            if (this.arguments.containsKey("serialNumber") != actionContactUsFragmentToRaiseServiceRequestFragment.arguments.containsKey("serialNumber")) {
                return false;
            }
            if (getSerialNumber() == null ? actionContactUsFragmentToRaiseServiceRequestFragment.getSerialNumber() == null : getSerialNumber().equals(actionContactUsFragmentToRaiseServiceRequestFragment.getSerialNumber())) {
                if (this.arguments.containsKey("cancelSubscription") != actionContactUsFragmentToRaiseServiceRequestFragment.arguments.containsKey("cancelSubscription")) {
                    return false;
                }
                if (getCancelSubscription() == null ? actionContactUsFragmentToRaiseServiceRequestFragment.getCancelSubscription() == null : getCancelSubscription().equals(actionContactUsFragmentToRaiseServiceRequestFragment.getCancelSubscription())) {
                    return getActionId() == actionContactUsFragmentToRaiseServiceRequestFragment.getActionId();
                }
                return false;
            }
            return false;
        }

        public int hashCode() {
            return (((((getSerialNumber() != null ? getSerialNumber().hashCode() : 0) + 31) * 31) + (getCancelSubscription() != null ? getCancelSubscription().hashCode() : 0)) * 31) + getActionId();
        }

        public String toString() {
            return "ActionContactUsFragmentToRaiseServiceRequestFragment(actionId=" + getActionId() + "){serialNumber=" + getSerialNumber() + ", cancelSubscription=" + getCancelSubscription() + "}";
        }
    }
}
