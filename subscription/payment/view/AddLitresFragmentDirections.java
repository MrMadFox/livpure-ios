package com.livpure.safedrink.subscription.payment.view;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.navigation.NavDirections;
import com.livpure.safedrink.NavGraphDirections;
import com.livpure.safedrink.R;
import com.livpure.safedrink.subscription.plan.data.model.deviceList.DeviceList;
import com.livpure.safedrink.subscription.plan.data.model.plan.PlansItem;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import java.io.Serializable;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class AddLitresFragmentDirections {
    private AddLitresFragmentDirections() {
    }

    public static ActionAddLitresToSelectPlanChargeFragment actionAddLitresToSelectPlanChargeFragment(DeviceList device) {
        return new ActionAddLitresToSelectPlanChargeFragment(device);
    }

    public static ActionAddLitresToPlanDurationFragment actionAddLitresToPlanDurationFragment(PlansItem plan, DeviceList device) {
        return new ActionAddLitresToPlanDurationFragment(plan, device);
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
    public static class ActionAddLitresToSelectPlanChargeFragment implements NavDirections {
        private final HashMap arguments;

        @Override // androidx.navigation.NavDirections
        public int getActionId() {
            return R.id.action_addLitres_to_selectPlanChargeFragment;
        }

        private ActionAddLitresToSelectPlanChargeFragment(DeviceList device) {
            HashMap hashMap = new HashMap();
            this.arguments = hashMap;
            if (device == null) {
                throw new IllegalArgumentException("Argument \"device\" is marked as non-null but was passed a null value.");
            }
            hashMap.put(AndroidContextPlugin.DEVICE_KEY, device);
        }

        public ActionAddLitresToSelectPlanChargeFragment setDevice(DeviceList device) {
            if (device == null) {
                throw new IllegalArgumentException("Argument \"device\" is marked as non-null but was passed a null value.");
            }
            this.arguments.put(AndroidContextPlugin.DEVICE_KEY, device);
            return this;
        }

        @Override // androidx.navigation.NavDirections
        public Bundle getArguments() {
            Bundle bundle = new Bundle();
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
            return bundle;
        }

        public DeviceList getDevice() {
            return (DeviceList) this.arguments.get(AndroidContextPlugin.DEVICE_KEY);
        }

        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (object == null || getClass() != object.getClass()) {
                return false;
            }
            ActionAddLitresToSelectPlanChargeFragment actionAddLitresToSelectPlanChargeFragment = (ActionAddLitresToSelectPlanChargeFragment) object;
            if (this.arguments.containsKey(AndroidContextPlugin.DEVICE_KEY) != actionAddLitresToSelectPlanChargeFragment.arguments.containsKey(AndroidContextPlugin.DEVICE_KEY)) {
                return false;
            }
            if (getDevice() == null ? actionAddLitresToSelectPlanChargeFragment.getDevice() == null : getDevice().equals(actionAddLitresToSelectPlanChargeFragment.getDevice())) {
                return getActionId() == actionAddLitresToSelectPlanChargeFragment.getActionId();
            }
            return false;
        }

        public int hashCode() {
            return (((getDevice() != null ? getDevice().hashCode() : 0) + 31) * 31) + getActionId();
        }

        public String toString() {
            return "ActionAddLitresToSelectPlanChargeFragment(actionId=" + getActionId() + "){device=" + getDevice() + "}";
        }
    }

    /* loaded from: classes3.dex */
    public static class ActionAddLitresToPlanDurationFragment implements NavDirections {
        private final HashMap arguments;

        @Override // androidx.navigation.NavDirections
        public int getActionId() {
            return R.id.action_addLitres_to_planDurationFragment;
        }

        private ActionAddLitresToPlanDurationFragment(PlansItem plan, DeviceList device) {
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
        }

        public ActionAddLitresToPlanDurationFragment setPlan(PlansItem plan) {
            if (plan == null) {
                throw new IllegalArgumentException("Argument \"plan\" is marked as non-null but was passed a null value.");
            }
            this.arguments.put("plan", plan);
            return this;
        }

        public ActionAddLitresToPlanDurationFragment setDevice(DeviceList device) {
            if (device == null) {
                throw new IllegalArgumentException("Argument \"device\" is marked as non-null but was passed a null value.");
            }
            this.arguments.put(AndroidContextPlugin.DEVICE_KEY, device);
            return this;
        }

        @Override // androidx.navigation.NavDirections
        public Bundle getArguments() {
            Bundle bundle = new Bundle();
            if (this.arguments.containsKey("plan")) {
                PlansItem plansItem = (PlansItem) this.arguments.get("plan");
                if (Parcelable.class.isAssignableFrom(PlansItem.class) || plansItem == null) {
                    bundle.putParcelable("plan", (Parcelable) Parcelable.class.cast(plansItem));
                } else if (Serializable.class.isAssignableFrom(PlansItem.class)) {
                    bundle.putSerializable("plan", (Serializable) Serializable.class.cast(plansItem));
                } else {
                    throw new UnsupportedOperationException(PlansItem.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
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
            return bundle;
        }

        public PlansItem getPlan() {
            return (PlansItem) this.arguments.get("plan");
        }

        public DeviceList getDevice() {
            return (DeviceList) this.arguments.get(AndroidContextPlugin.DEVICE_KEY);
        }

        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (object == null || getClass() != object.getClass()) {
                return false;
            }
            ActionAddLitresToPlanDurationFragment actionAddLitresToPlanDurationFragment = (ActionAddLitresToPlanDurationFragment) object;
            if (this.arguments.containsKey("plan") != actionAddLitresToPlanDurationFragment.arguments.containsKey("plan")) {
                return false;
            }
            if (getPlan() == null ? actionAddLitresToPlanDurationFragment.getPlan() == null : getPlan().equals(actionAddLitresToPlanDurationFragment.getPlan())) {
                if (this.arguments.containsKey(AndroidContextPlugin.DEVICE_KEY) != actionAddLitresToPlanDurationFragment.arguments.containsKey(AndroidContextPlugin.DEVICE_KEY)) {
                    return false;
                }
                if (getDevice() == null ? actionAddLitresToPlanDurationFragment.getDevice() == null : getDevice().equals(actionAddLitresToPlanDurationFragment.getDevice())) {
                    return getActionId() == actionAddLitresToPlanDurationFragment.getActionId();
                }
                return false;
            }
            return false;
        }

        public int hashCode() {
            return (((((getPlan() != null ? getPlan().hashCode() : 0) + 31) * 31) + (getDevice() != null ? getDevice().hashCode() : 0)) * 31) + getActionId();
        }

        public String toString() {
            return "ActionAddLitresToPlanDurationFragment(actionId=" + getActionId() + "){plan=" + getPlan() + ", device=" + getDevice() + "}";
        }
    }
}
