package com.livpure.safedrink.subscription.payment.view;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.navigation.NavDirections;
import com.livpure.safedrink.NavGraphDirections;
import com.livpure.safedrink.R;
import com.livpure.safedrink.subscription.plan.data.model.deviceList.DeviceList;
import com.livpure.safedrink.subscription.plan.data.model.plan.PriceItem;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import java.io.Serializable;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class PlanDurationFragmentDirections {
    private PlanDurationFragmentDirections() {
    }

    public static ActionSelectPlanDurationFragmentToReviewOrderFragment actionSelectPlanDurationFragmentToReviewOrderFragment(PriceItem plan, DeviceList device, String planName, String planNumber) {
        return new ActionSelectPlanDurationFragmentToReviewOrderFragment(plan, device, planName, planNumber);
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
    public static class ActionSelectPlanDurationFragmentToReviewOrderFragment implements NavDirections {
        private final HashMap arguments;

        @Override // androidx.navigation.NavDirections
        public int getActionId() {
            return R.id.action_selectPlanDurationFragment_to_reviewOrderFragment;
        }

        private ActionSelectPlanDurationFragmentToReviewOrderFragment(PriceItem plan, DeviceList device, String planName, String planNumber) {
            HashMap hashMap = new HashMap();
            this.arguments = hashMap;
            if (plan == null) {
                throw new IllegalArgumentException("Argument \"plan\" is marked as non-null but was passed a null value.");
            }
            hashMap.put("plan", plan);
            if (device == null) {
                throw new IllegalArgumentException("Argument \"device\" is marked as non-null but was passed a null value.");
            }
            hashMap.put(AndroidContextPlugin.DEVICE_KEY, device);
            if (planName == null) {
                throw new IllegalArgumentException("Argument \"planName\" is marked as non-null but was passed a null value.");
            }
            hashMap.put("planName", planName);
            if (planNumber == null) {
                throw new IllegalArgumentException("Argument \"planNumber\" is marked as non-null but was passed a null value.");
            }
            hashMap.put("planNumber", planNumber);
        }

        public ActionSelectPlanDurationFragmentToReviewOrderFragment setPlan(PriceItem plan) {
            if (plan == null) {
                throw new IllegalArgumentException("Argument \"plan\" is marked as non-null but was passed a null value.");
            }
            this.arguments.put("plan", plan);
            return this;
        }

        public ActionSelectPlanDurationFragmentToReviewOrderFragment setDevice(DeviceList device) {
            if (device == null) {
                throw new IllegalArgumentException("Argument \"device\" is marked as non-null but was passed a null value.");
            }
            this.arguments.put(AndroidContextPlugin.DEVICE_KEY, device);
            return this;
        }

        public ActionSelectPlanDurationFragmentToReviewOrderFragment setPlanName(String planName) {
            if (planName == null) {
                throw new IllegalArgumentException("Argument \"planName\" is marked as non-null but was passed a null value.");
            }
            this.arguments.put("planName", planName);
            return this;
        }

        public ActionSelectPlanDurationFragmentToReviewOrderFragment setPlanNumber(String planNumber) {
            if (planNumber == null) {
                throw new IllegalArgumentException("Argument \"planNumber\" is marked as non-null but was passed a null value.");
            }
            this.arguments.put("planNumber", planNumber);
            return this;
        }

        @Override // androidx.navigation.NavDirections
        public Bundle getArguments() {
            Bundle bundle = new Bundle();
            if (this.arguments.containsKey("plan")) {
                PriceItem priceItem = (PriceItem) this.arguments.get("plan");
                if (Parcelable.class.isAssignableFrom(PriceItem.class) || priceItem == null) {
                    bundle.putParcelable("plan", (Parcelable) Parcelable.class.cast(priceItem));
                } else if (Serializable.class.isAssignableFrom(PriceItem.class)) {
                    bundle.putSerializable("plan", (Serializable) Serializable.class.cast(priceItem));
                } else {
                    throw new UnsupportedOperationException(PriceItem.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
                }
            }
            if (this.arguments.containsKey(AndroidContextPlugin.DEVICE_KEY)) {
                DeviceList deviceList = (DeviceList) this.arguments.get(AndroidContextPlugin.DEVICE_KEY);
                if (Parcelable.class.isAssignableFrom(DeviceList.class) || deviceList == null) {
                    bundle.putParcelable(AndroidContextPlugin.DEVICE_KEY, (Parcelable) Parcelable.class.cast(deviceList));
                } else if (Serializable.class.isAssignableFrom(DeviceList.class)) {
                    bundle.putSerializable(AndroidContextPlugin.DEVICE_KEY, (Serializable) Serializable.class.cast(deviceList));
                } else {
                    throw new UnsupportedOperationException(DeviceList.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
                }
            }
            if (this.arguments.containsKey("planName")) {
                bundle.putString("planName", (String) this.arguments.get("planName"));
            }
            if (this.arguments.containsKey("planNumber")) {
                bundle.putString("planNumber", (String) this.arguments.get("planNumber"));
            }
            return bundle;
        }

        public PriceItem getPlan() {
            return (PriceItem) this.arguments.get("plan");
        }

        public DeviceList getDevice() {
            return (DeviceList) this.arguments.get(AndroidContextPlugin.DEVICE_KEY);
        }

        public String getPlanName() {
            return (String) this.arguments.get("planName");
        }

        public String getPlanNumber() {
            return (String) this.arguments.get("planNumber");
        }

        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (object == null || getClass() != object.getClass()) {
                return false;
            }
            ActionSelectPlanDurationFragmentToReviewOrderFragment actionSelectPlanDurationFragmentToReviewOrderFragment = (ActionSelectPlanDurationFragmentToReviewOrderFragment) object;
            if (this.arguments.containsKey("plan") != actionSelectPlanDurationFragmentToReviewOrderFragment.arguments.containsKey("plan")) {
                return false;
            }
            if (getPlan() == null ? actionSelectPlanDurationFragmentToReviewOrderFragment.getPlan() == null : getPlan().equals(actionSelectPlanDurationFragmentToReviewOrderFragment.getPlan())) {
                if (this.arguments.containsKey(AndroidContextPlugin.DEVICE_KEY) != actionSelectPlanDurationFragmentToReviewOrderFragment.arguments.containsKey(AndroidContextPlugin.DEVICE_KEY)) {
                    return false;
                }
                if (getDevice() == null ? actionSelectPlanDurationFragmentToReviewOrderFragment.getDevice() == null : getDevice().equals(actionSelectPlanDurationFragmentToReviewOrderFragment.getDevice())) {
                    if (this.arguments.containsKey("planName") != actionSelectPlanDurationFragmentToReviewOrderFragment.arguments.containsKey("planName")) {
                        return false;
                    }
                    if (getPlanName() == null ? actionSelectPlanDurationFragmentToReviewOrderFragment.getPlanName() == null : getPlanName().equals(actionSelectPlanDurationFragmentToReviewOrderFragment.getPlanName())) {
                        if (this.arguments.containsKey("planNumber") != actionSelectPlanDurationFragmentToReviewOrderFragment.arguments.containsKey("planNumber")) {
                            return false;
                        }
                        if (getPlanNumber() == null ? actionSelectPlanDurationFragmentToReviewOrderFragment.getPlanNumber() == null : getPlanNumber().equals(actionSelectPlanDurationFragmentToReviewOrderFragment.getPlanNumber())) {
                            return getActionId() == actionSelectPlanDurationFragmentToReviewOrderFragment.getActionId();
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }

        public int hashCode() {
            return (((((((((getPlan() != null ? getPlan().hashCode() : 0) + 31) * 31) + (getDevice() != null ? getDevice().hashCode() : 0)) * 31) + (getPlanName() != null ? getPlanName().hashCode() : 0)) * 31) + (getPlanNumber() != null ? getPlanNumber().hashCode() : 0)) * 31) + getActionId();
        }

        public String toString() {
            return "ActionSelectPlanDurationFragmentToReviewOrderFragment(actionId=" + getActionId() + "){plan=" + getPlan() + ", device=" + getDevice() + ", planName=" + getPlanName() + ", planNumber=" + getPlanNumber() + "}";
        }
    }
}
