package com.livpure.safedrink.subscription.payment.view;

import android.os.Bundle;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.livpure.safedrink.NavGraphDirections;
import com.livpure.safedrink.R;
import com.livpure.safedrink.subscription.plan.data.model.deviceList.DeviceList;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class ReviewOrderFragmentDirections {
    private ReviewOrderFragmentDirections() {
    }

    public static NavDirections actionReviewOrderFragmentToInstallationAddressFragment() {
        return new ActionOnlyNavDirections(R.id.action_reviewOrderFragment_to_installationAddressFragment);
    }

    public static ActionReviewOrderFragmentToUploadKYCFragment actionReviewOrderFragmentToUploadKYCFragment(String paymentId) {
        return new ActionReviewOrderFragmentToUploadKYCFragment(paymentId);
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
    public static class ActionReviewOrderFragmentToUploadKYCFragment implements NavDirections {
        private final HashMap arguments;

        @Override // androidx.navigation.NavDirections
        public int getActionId() {
            return R.id.action_reviewOrderFragment_to_uploadKYCFragment;
        }

        private ActionReviewOrderFragmentToUploadKYCFragment(String paymentId) {
            HashMap hashMap = new HashMap();
            this.arguments = hashMap;
            if (paymentId == null) {
                throw new IllegalArgumentException("Argument \"paymentId\" is marked as non-null but was passed a null value.");
            }
            hashMap.put("paymentId", paymentId);
        }

        public ActionReviewOrderFragmentToUploadKYCFragment setPaymentId(String paymentId) {
            if (paymentId == null) {
                throw new IllegalArgumentException("Argument \"paymentId\" is marked as non-null but was passed a null value.");
            }
            this.arguments.put("paymentId", paymentId);
            return this;
        }

        @Override // androidx.navigation.NavDirections
        public Bundle getArguments() {
            Bundle bundle = new Bundle();
            if (this.arguments.containsKey("paymentId")) {
                bundle.putString("paymentId", (String) this.arguments.get("paymentId"));
            }
            return bundle;
        }

        public String getPaymentId() {
            return (String) this.arguments.get("paymentId");
        }

        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (object == null || getClass() != object.getClass()) {
                return false;
            }
            ActionReviewOrderFragmentToUploadKYCFragment actionReviewOrderFragmentToUploadKYCFragment = (ActionReviewOrderFragmentToUploadKYCFragment) object;
            if (this.arguments.containsKey("paymentId") != actionReviewOrderFragmentToUploadKYCFragment.arguments.containsKey("paymentId")) {
                return false;
            }
            if (getPaymentId() == null ? actionReviewOrderFragmentToUploadKYCFragment.getPaymentId() == null : getPaymentId().equals(actionReviewOrderFragmentToUploadKYCFragment.getPaymentId())) {
                return getActionId() == actionReviewOrderFragmentToUploadKYCFragment.getActionId();
            }
            return false;
        }

        public int hashCode() {
            return (((getPaymentId() != null ? getPaymentId().hashCode() : 0) + 31) * 31) + getActionId();
        }

        public String toString() {
            return "ActionReviewOrderFragmentToUploadKYCFragment(actionId=" + getActionId() + "){paymentId=" + getPaymentId() + "}";
        }
    }
}
