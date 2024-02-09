package com.livpure.safedrink.dispenser.view;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.livpure.safedrink.NavGraphDirections;
import com.livpure.safedrink.R;
import com.livpure.safedrink.subscription.plan.data.model.deviceList.DeviceList;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import java.io.Serializable;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class HomeDispenserAtlanticFragmentDirections {
    private HomeDispenserAtlanticFragmentDirections() {
    }

    public static ActionHomeDispenserFragmentBoltSettingsFragment actionHomeDispenserFragmentBoltSettingsFragment(DeviceList device) {
        return new ActionHomeDispenserFragmentBoltSettingsFragment(device);
    }

    public static NavDirections actionHomeDispenserFragmentToDeviceFragment() {
        return new ActionOnlyNavDirections(R.id.action_homeDispenserFragment_to_deviceFragment);
    }

    public static ActionDispenserFragmentToSelectPlanChargeFragment actionDispenserFragmentToSelectPlanChargeFragment(DeviceList device) {
        return new ActionDispenserFragmentToSelectPlanChargeFragment(device);
    }

    public static ActionDispenserFragmentToAddLitresFagment actionDispenserFragmentToAddLitresFagment(DeviceList device) {
        return new ActionDispenserFragmentToAddLitresFagment(device);
    }

    public static ActionHomeFragmentToContactUsFragment actionHomeFragmentToContactUsFragment(String serialNumber) {
        return new ActionHomeFragmentToContactUsFragment(serialNumber);
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
    public static class ActionHomeDispenserFragmentBoltSettingsFragment implements NavDirections {
        private final HashMap arguments;

        @Override // androidx.navigation.NavDirections
        public int getActionId() {
            return R.id.action_homeDispenserFragment_BoltSettingsFragment;
        }

        private ActionHomeDispenserFragmentBoltSettingsFragment(DeviceList device) {
            HashMap hashMap = new HashMap();
            this.arguments = hashMap;
            if (device == null) {
                throw new IllegalArgumentException("Argument \"device\" is marked as non-null but was passed a null value.");
            }
            hashMap.put(AndroidContextPlugin.DEVICE_KEY, device);
        }

        public ActionHomeDispenserFragmentBoltSettingsFragment setDevice(DeviceList device) {
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
            ActionHomeDispenserFragmentBoltSettingsFragment actionHomeDispenserFragmentBoltSettingsFragment = (ActionHomeDispenserFragmentBoltSettingsFragment) object;
            if (this.arguments.containsKey(AndroidContextPlugin.DEVICE_KEY) != actionHomeDispenserFragmentBoltSettingsFragment.arguments.containsKey(AndroidContextPlugin.DEVICE_KEY)) {
                return false;
            }
            if (getDevice() == null ? actionHomeDispenserFragmentBoltSettingsFragment.getDevice() == null : getDevice().equals(actionHomeDispenserFragmentBoltSettingsFragment.getDevice())) {
                return getActionId() == actionHomeDispenserFragmentBoltSettingsFragment.getActionId();
            }
            return false;
        }

        public int hashCode() {
            return (((getDevice() != null ? getDevice().hashCode() : 0) + 31) * 31) + getActionId();
        }

        public String toString() {
            return "ActionHomeDispenserFragmentBoltSettingsFragment(actionId=" + getActionId() + "){device=" + getDevice() + "}";
        }
    }

    /* loaded from: classes3.dex */
    public static class ActionDispenserFragmentToSelectPlanChargeFragment implements NavDirections {
        private final HashMap arguments;

        @Override // androidx.navigation.NavDirections
        public int getActionId() {
            return R.id.action_dispenserFragment_to_selectPlanChargeFragment;
        }

        private ActionDispenserFragmentToSelectPlanChargeFragment(DeviceList device) {
            HashMap hashMap = new HashMap();
            this.arguments = hashMap;
            if (device == null) {
                throw new IllegalArgumentException("Argument \"device\" is marked as non-null but was passed a null value.");
            }
            hashMap.put(AndroidContextPlugin.DEVICE_KEY, device);
        }

        public ActionDispenserFragmentToSelectPlanChargeFragment setDevice(DeviceList device) {
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
            ActionDispenserFragmentToSelectPlanChargeFragment actionDispenserFragmentToSelectPlanChargeFragment = (ActionDispenserFragmentToSelectPlanChargeFragment) object;
            if (this.arguments.containsKey(AndroidContextPlugin.DEVICE_KEY) != actionDispenserFragmentToSelectPlanChargeFragment.arguments.containsKey(AndroidContextPlugin.DEVICE_KEY)) {
                return false;
            }
            if (getDevice() == null ? actionDispenserFragmentToSelectPlanChargeFragment.getDevice() == null : getDevice().equals(actionDispenserFragmentToSelectPlanChargeFragment.getDevice())) {
                return getActionId() == actionDispenserFragmentToSelectPlanChargeFragment.getActionId();
            }
            return false;
        }

        public int hashCode() {
            return (((getDevice() != null ? getDevice().hashCode() : 0) + 31) * 31) + getActionId();
        }

        public String toString() {
            return "ActionDispenserFragmentToSelectPlanChargeFragment(actionId=" + getActionId() + "){device=" + getDevice() + "}";
        }
    }

    /* loaded from: classes3.dex */
    public static class ActionDispenserFragmentToAddLitresFagment implements NavDirections {
        private final HashMap arguments;

        @Override // androidx.navigation.NavDirections
        public int getActionId() {
            return R.id.action_dispenserFragment_to_addLitresFagment;
        }

        private ActionDispenserFragmentToAddLitresFagment(DeviceList device) {
            HashMap hashMap = new HashMap();
            this.arguments = hashMap;
            if (device == null) {
                throw new IllegalArgumentException("Argument \"device\" is marked as non-null but was passed a null value.");
            }
            hashMap.put(AndroidContextPlugin.DEVICE_KEY, device);
        }

        public ActionDispenserFragmentToAddLitresFagment setDevice(DeviceList device) {
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
            ActionDispenserFragmentToAddLitresFagment actionDispenserFragmentToAddLitresFagment = (ActionDispenserFragmentToAddLitresFagment) object;
            if (this.arguments.containsKey(AndroidContextPlugin.DEVICE_KEY) != actionDispenserFragmentToAddLitresFagment.arguments.containsKey(AndroidContextPlugin.DEVICE_KEY)) {
                return false;
            }
            if (getDevice() == null ? actionDispenserFragmentToAddLitresFagment.getDevice() == null : getDevice().equals(actionDispenserFragmentToAddLitresFagment.getDevice())) {
                return getActionId() == actionDispenserFragmentToAddLitresFagment.getActionId();
            }
            return false;
        }

        public int hashCode() {
            return (((getDevice() != null ? getDevice().hashCode() : 0) + 31) * 31) + getActionId();
        }

        public String toString() {
            return "ActionDispenserFragmentToAddLitresFagment(actionId=" + getActionId() + "){device=" + getDevice() + "}";
        }
    }

    /* loaded from: classes3.dex */
    public static class ActionHomeFragmentToContactUsFragment implements NavDirections {
        private final HashMap arguments;

        @Override // androidx.navigation.NavDirections
        public int getActionId() {
            return R.id.action_homeFragment_to_contactUsFragment;
        }

        private ActionHomeFragmentToContactUsFragment(String serialNumber) {
            HashMap hashMap = new HashMap();
            this.arguments = hashMap;
            if (serialNumber == null) {
                throw new IllegalArgumentException("Argument \"serialNumber\" is marked as non-null but was passed a null value.");
            }
            hashMap.put("serialNumber", serialNumber);
        }

        public ActionHomeFragmentToContactUsFragment setSerialNumber(String serialNumber) {
            if (serialNumber == null) {
                throw new IllegalArgumentException("Argument \"serialNumber\" is marked as non-null but was passed a null value.");
            }
            this.arguments.put("serialNumber", serialNumber);
            return this;
        }

        @Override // androidx.navigation.NavDirections
        public Bundle getArguments() {
            Bundle bundle = new Bundle();
            if (this.arguments.containsKey("serialNumber")) {
                bundle.putString("serialNumber", (String) this.arguments.get("serialNumber"));
            }
            return bundle;
        }

        public String getSerialNumber() {
            return (String) this.arguments.get("serialNumber");
        }

        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (object == null || getClass() != object.getClass()) {
                return false;
            }
            ActionHomeFragmentToContactUsFragment actionHomeFragmentToContactUsFragment = (ActionHomeFragmentToContactUsFragment) object;
            if (this.arguments.containsKey("serialNumber") != actionHomeFragmentToContactUsFragment.arguments.containsKey("serialNumber")) {
                return false;
            }
            if (getSerialNumber() == null ? actionHomeFragmentToContactUsFragment.getSerialNumber() == null : getSerialNumber().equals(actionHomeFragmentToContactUsFragment.getSerialNumber())) {
                return getActionId() == actionHomeFragmentToContactUsFragment.getActionId();
            }
            return false;
        }

        public int hashCode() {
            return (((getSerialNumber() != null ? getSerialNumber().hashCode() : 0) + 31) * 31) + getActionId();
        }

        public String toString() {
            return "ActionHomeFragmentToContactUsFragment(actionId=" + getActionId() + "){serialNumber=" + getSerialNumber() + "}";
        }
    }
}
