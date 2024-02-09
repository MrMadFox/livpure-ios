package com.livpure.safedrink.app;

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
public class HomeFragmentDirections {
    private HomeFragmentDirections() {
    }

    public static ActionHomeFragmentToSelectPlanOrRechargeFragment actionHomeFragmentToSelectPlanOrRechargeFragment(DeviceList device) {
        return new ActionHomeFragmentToSelectPlanOrRechargeFragment(device);
    }

    public static ActionHomeFragmentToSelectPlanChargeFragment actionHomeFragmentToSelectPlanChargeFragment(DeviceList device) {
        return new ActionHomeFragmentToSelectPlanChargeFragment(device);
    }

    public static NavDirections actionHomeFragmentToReferAndEarnFragment() {
        return new ActionOnlyNavDirections(R.id.action_homeFragment_to_referAndEarnFragment);
    }

    public static ActionHomeFragmentToAddLitresFragment actionHomeFragmentToAddLitresFragment(DeviceList device) {
        return new ActionHomeFragmentToAddLitresFragment(device);
    }

    public static ActionHomeFragmentToUploadKYCFragment actionHomeFragmentToUploadKYCFragment(String paymentId) {
        return new ActionHomeFragmentToUploadKYCFragment(paymentId);
    }

    public static ActionHomeFragmentToContactUsFragment actionHomeFragmentToContactUsFragment(String serialNumber) {
        return new ActionHomeFragmentToContactUsFragment(serialNumber);
    }

    public static NavDirections actionHomeFragmentToKycUpload() {
        return new ActionOnlyNavDirections(R.id.action_homeFragment_to_kycUpload);
    }

    public static ActionHomeFragmentToBoltSettingsFragment actionHomeFragmentToBoltSettingsFragment(DeviceList device) {
        return new ActionHomeFragmentToBoltSettingsFragment(device);
    }

    public static ActionHomeFragmentToAirPurifier actionHomeFragmentToAirPurifier(DeviceList device) {
        return new ActionHomeFragmentToAirPurifier(device);
    }

    public static ActionHomeFragmentToDispenser actionHomeFragmentToDispenser(DeviceList device) {
        return new ActionHomeFragmentToDispenser(device);
    }

    public static ActionHomeFragmentToAirToWater actionHomeFragmentToAirToWater(DeviceList device) {
        return new ActionHomeFragmentToAirToWater(device);
    }

    public static ActionHomeFragmentToDispenserAtlantic actionHomeFragmentToDispenserAtlantic(DeviceList device) {
        return new ActionHomeFragmentToDispenserAtlantic(device);
    }

    public static ActionHomeFragmentToEnvyHome actionHomeFragmentToEnvyHome(DeviceList device) {
        return new ActionHomeFragmentToEnvyHome(device);
    }

    public static ActionHomeFragmentToUnlimiterWaterHomeFragment actionHomeFragmentToUnlimiterWaterHomeFragment(DeviceList device) {
        return new ActionHomeFragmentToUnlimiterWaterHomeFragment(device);
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
    public static class ActionHomeFragmentToSelectPlanOrRechargeFragment implements NavDirections {
        private final HashMap arguments;

        @Override // androidx.navigation.NavDirections
        public int getActionId() {
            return R.id.action_homeFragment_to_selectPlanOrRechargeFragment;
        }

        private ActionHomeFragmentToSelectPlanOrRechargeFragment(DeviceList device) {
            HashMap hashMap = new HashMap();
            this.arguments = hashMap;
            if (device == null) {
                throw new IllegalArgumentException("Argument \"device\" is marked as non-null but was passed a null value.");
            }
            hashMap.put(AndroidContextPlugin.DEVICE_KEY, device);
        }

        public ActionHomeFragmentToSelectPlanOrRechargeFragment setDevice(DeviceList device) {
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
            ActionHomeFragmentToSelectPlanOrRechargeFragment actionHomeFragmentToSelectPlanOrRechargeFragment = (ActionHomeFragmentToSelectPlanOrRechargeFragment) object;
            if (this.arguments.containsKey(AndroidContextPlugin.DEVICE_KEY) != actionHomeFragmentToSelectPlanOrRechargeFragment.arguments.containsKey(AndroidContextPlugin.DEVICE_KEY)) {
                return false;
            }
            if (getDevice() == null ? actionHomeFragmentToSelectPlanOrRechargeFragment.getDevice() == null : getDevice().equals(actionHomeFragmentToSelectPlanOrRechargeFragment.getDevice())) {
                return getActionId() == actionHomeFragmentToSelectPlanOrRechargeFragment.getActionId();
            }
            return false;
        }

        public int hashCode() {
            return (((getDevice() != null ? getDevice().hashCode() : 0) + 31) * 31) + getActionId();
        }

        public String toString() {
            return "ActionHomeFragmentToSelectPlanOrRechargeFragment(actionId=" + getActionId() + "){device=" + getDevice() + "}";
        }
    }

    /* loaded from: classes3.dex */
    public static class ActionHomeFragmentToSelectPlanChargeFragment implements NavDirections {
        private final HashMap arguments;

        @Override // androidx.navigation.NavDirections
        public int getActionId() {
            return R.id.action_homeFragment_to_selectPlanChargeFragment;
        }

        private ActionHomeFragmentToSelectPlanChargeFragment(DeviceList device) {
            HashMap hashMap = new HashMap();
            this.arguments = hashMap;
            if (device == null) {
                throw new IllegalArgumentException("Argument \"device\" is marked as non-null but was passed a null value.");
            }
            hashMap.put(AndroidContextPlugin.DEVICE_KEY, device);
        }

        public ActionHomeFragmentToSelectPlanChargeFragment setDevice(DeviceList device) {
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
            ActionHomeFragmentToSelectPlanChargeFragment actionHomeFragmentToSelectPlanChargeFragment = (ActionHomeFragmentToSelectPlanChargeFragment) object;
            if (this.arguments.containsKey(AndroidContextPlugin.DEVICE_KEY) != actionHomeFragmentToSelectPlanChargeFragment.arguments.containsKey(AndroidContextPlugin.DEVICE_KEY)) {
                return false;
            }
            if (getDevice() == null ? actionHomeFragmentToSelectPlanChargeFragment.getDevice() == null : getDevice().equals(actionHomeFragmentToSelectPlanChargeFragment.getDevice())) {
                return getActionId() == actionHomeFragmentToSelectPlanChargeFragment.getActionId();
            }
            return false;
        }

        public int hashCode() {
            return (((getDevice() != null ? getDevice().hashCode() : 0) + 31) * 31) + getActionId();
        }

        public String toString() {
            return "ActionHomeFragmentToSelectPlanChargeFragment(actionId=" + getActionId() + "){device=" + getDevice() + "}";
        }
    }

    /* loaded from: classes3.dex */
    public static class ActionHomeFragmentToAddLitresFragment implements NavDirections {
        private final HashMap arguments;

        @Override // androidx.navigation.NavDirections
        public int getActionId() {
            return R.id.action_homeFragment_to_addLitresFragment;
        }

        private ActionHomeFragmentToAddLitresFragment(DeviceList device) {
            HashMap hashMap = new HashMap();
            this.arguments = hashMap;
            if (device == null) {
                throw new IllegalArgumentException("Argument \"device\" is marked as non-null but was passed a null value.");
            }
            hashMap.put(AndroidContextPlugin.DEVICE_KEY, device);
        }

        public ActionHomeFragmentToAddLitresFragment setDevice(DeviceList device) {
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
            ActionHomeFragmentToAddLitresFragment actionHomeFragmentToAddLitresFragment = (ActionHomeFragmentToAddLitresFragment) object;
            if (this.arguments.containsKey(AndroidContextPlugin.DEVICE_KEY) != actionHomeFragmentToAddLitresFragment.arguments.containsKey(AndroidContextPlugin.DEVICE_KEY)) {
                return false;
            }
            if (getDevice() == null ? actionHomeFragmentToAddLitresFragment.getDevice() == null : getDevice().equals(actionHomeFragmentToAddLitresFragment.getDevice())) {
                return getActionId() == actionHomeFragmentToAddLitresFragment.getActionId();
            }
            return false;
        }

        public int hashCode() {
            return (((getDevice() != null ? getDevice().hashCode() : 0) + 31) * 31) + getActionId();
        }

        public String toString() {
            return "ActionHomeFragmentToAddLitresFragment(actionId=" + getActionId() + "){device=" + getDevice() + "}";
        }
    }

    /* loaded from: classes3.dex */
    public static class ActionHomeFragmentToUploadKYCFragment implements NavDirections {
        private final HashMap arguments;

        @Override // androidx.navigation.NavDirections
        public int getActionId() {
            return R.id.action_homeFragment_to_uploadKYCFragment;
        }

        private ActionHomeFragmentToUploadKYCFragment(String paymentId) {
            HashMap hashMap = new HashMap();
            this.arguments = hashMap;
            if (paymentId == null) {
                throw new IllegalArgumentException("Argument \"paymentId\" is marked as non-null but was passed a null value.");
            }
            hashMap.put("paymentId", paymentId);
        }

        public ActionHomeFragmentToUploadKYCFragment setPaymentId(String paymentId) {
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
            ActionHomeFragmentToUploadKYCFragment actionHomeFragmentToUploadKYCFragment = (ActionHomeFragmentToUploadKYCFragment) object;
            if (this.arguments.containsKey("paymentId") != actionHomeFragmentToUploadKYCFragment.arguments.containsKey("paymentId")) {
                return false;
            }
            if (getPaymentId() == null ? actionHomeFragmentToUploadKYCFragment.getPaymentId() == null : getPaymentId().equals(actionHomeFragmentToUploadKYCFragment.getPaymentId())) {
                return getActionId() == actionHomeFragmentToUploadKYCFragment.getActionId();
            }
            return false;
        }

        public int hashCode() {
            return (((getPaymentId() != null ? getPaymentId().hashCode() : 0) + 31) * 31) + getActionId();
        }

        public String toString() {
            return "ActionHomeFragmentToUploadKYCFragment(actionId=" + getActionId() + "){paymentId=" + getPaymentId() + "}";
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

    /* loaded from: classes3.dex */
    public static class ActionHomeFragmentToBoltSettingsFragment implements NavDirections {
        private final HashMap arguments;

        @Override // androidx.navigation.NavDirections
        public int getActionId() {
            return R.id.action_homeFragment_to_BoltSettingsFragment;
        }

        private ActionHomeFragmentToBoltSettingsFragment(DeviceList device) {
            HashMap hashMap = new HashMap();
            this.arguments = hashMap;
            if (device == null) {
                throw new IllegalArgumentException("Argument \"device\" is marked as non-null but was passed a null value.");
            }
            hashMap.put(AndroidContextPlugin.DEVICE_KEY, device);
        }

        public ActionHomeFragmentToBoltSettingsFragment setDevice(DeviceList device) {
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
            ActionHomeFragmentToBoltSettingsFragment actionHomeFragmentToBoltSettingsFragment = (ActionHomeFragmentToBoltSettingsFragment) object;
            if (this.arguments.containsKey(AndroidContextPlugin.DEVICE_KEY) != actionHomeFragmentToBoltSettingsFragment.arguments.containsKey(AndroidContextPlugin.DEVICE_KEY)) {
                return false;
            }
            if (getDevice() == null ? actionHomeFragmentToBoltSettingsFragment.getDevice() == null : getDevice().equals(actionHomeFragmentToBoltSettingsFragment.getDevice())) {
                return getActionId() == actionHomeFragmentToBoltSettingsFragment.getActionId();
            }
            return false;
        }

        public int hashCode() {
            return (((getDevice() != null ? getDevice().hashCode() : 0) + 31) * 31) + getActionId();
        }

        public String toString() {
            return "ActionHomeFragmentToBoltSettingsFragment(actionId=" + getActionId() + "){device=" + getDevice() + "}";
        }
    }

    /* loaded from: classes3.dex */
    public static class ActionHomeFragmentToAirPurifier implements NavDirections {
        private final HashMap arguments;

        @Override // androidx.navigation.NavDirections
        public int getActionId() {
            return R.id.action_homeFragment_to_AirPurifier;
        }

        private ActionHomeFragmentToAirPurifier(DeviceList device) {
            HashMap hashMap = new HashMap();
            this.arguments = hashMap;
            if (device == null) {
                throw new IllegalArgumentException("Argument \"device\" is marked as non-null but was passed a null value.");
            }
            hashMap.put(AndroidContextPlugin.DEVICE_KEY, device);
        }

        public ActionHomeFragmentToAirPurifier setDevice(DeviceList device) {
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
            ActionHomeFragmentToAirPurifier actionHomeFragmentToAirPurifier = (ActionHomeFragmentToAirPurifier) object;
            if (this.arguments.containsKey(AndroidContextPlugin.DEVICE_KEY) != actionHomeFragmentToAirPurifier.arguments.containsKey(AndroidContextPlugin.DEVICE_KEY)) {
                return false;
            }
            if (getDevice() == null ? actionHomeFragmentToAirPurifier.getDevice() == null : getDevice().equals(actionHomeFragmentToAirPurifier.getDevice())) {
                return getActionId() == actionHomeFragmentToAirPurifier.getActionId();
            }
            return false;
        }

        public int hashCode() {
            return (((getDevice() != null ? getDevice().hashCode() : 0) + 31) * 31) + getActionId();
        }

        public String toString() {
            return "ActionHomeFragmentToAirPurifier(actionId=" + getActionId() + "){device=" + getDevice() + "}";
        }
    }

    /* loaded from: classes3.dex */
    public static class ActionHomeFragmentToDispenser implements NavDirections {
        private final HashMap arguments;

        @Override // androidx.navigation.NavDirections
        public int getActionId() {
            return R.id.action_homeFragment_to_Dispenser;
        }

        private ActionHomeFragmentToDispenser(DeviceList device) {
            HashMap hashMap = new HashMap();
            this.arguments = hashMap;
            if (device == null) {
                throw new IllegalArgumentException("Argument \"device\" is marked as non-null but was passed a null value.");
            }
            hashMap.put(AndroidContextPlugin.DEVICE_KEY, device);
        }

        public ActionHomeFragmentToDispenser setDevice(DeviceList device) {
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
            ActionHomeFragmentToDispenser actionHomeFragmentToDispenser = (ActionHomeFragmentToDispenser) object;
            if (this.arguments.containsKey(AndroidContextPlugin.DEVICE_KEY) != actionHomeFragmentToDispenser.arguments.containsKey(AndroidContextPlugin.DEVICE_KEY)) {
                return false;
            }
            if (getDevice() == null ? actionHomeFragmentToDispenser.getDevice() == null : getDevice().equals(actionHomeFragmentToDispenser.getDevice())) {
                return getActionId() == actionHomeFragmentToDispenser.getActionId();
            }
            return false;
        }

        public int hashCode() {
            return (((getDevice() != null ? getDevice().hashCode() : 0) + 31) * 31) + getActionId();
        }

        public String toString() {
            return "ActionHomeFragmentToDispenser(actionId=" + getActionId() + "){device=" + getDevice() + "}";
        }
    }

    /* loaded from: classes3.dex */
    public static class ActionHomeFragmentToAirToWater implements NavDirections {
        private final HashMap arguments;

        @Override // androidx.navigation.NavDirections
        public int getActionId() {
            return R.id.action_homeFragment_to_Air_To_Water;
        }

        private ActionHomeFragmentToAirToWater(DeviceList device) {
            HashMap hashMap = new HashMap();
            this.arguments = hashMap;
            if (device == null) {
                throw new IllegalArgumentException("Argument \"device\" is marked as non-null but was passed a null value.");
            }
            hashMap.put(AndroidContextPlugin.DEVICE_KEY, device);
        }

        public ActionHomeFragmentToAirToWater setDevice(DeviceList device) {
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
            ActionHomeFragmentToAirToWater actionHomeFragmentToAirToWater = (ActionHomeFragmentToAirToWater) object;
            if (this.arguments.containsKey(AndroidContextPlugin.DEVICE_KEY) != actionHomeFragmentToAirToWater.arguments.containsKey(AndroidContextPlugin.DEVICE_KEY)) {
                return false;
            }
            if (getDevice() == null ? actionHomeFragmentToAirToWater.getDevice() == null : getDevice().equals(actionHomeFragmentToAirToWater.getDevice())) {
                return getActionId() == actionHomeFragmentToAirToWater.getActionId();
            }
            return false;
        }

        public int hashCode() {
            return (((getDevice() != null ? getDevice().hashCode() : 0) + 31) * 31) + getActionId();
        }

        public String toString() {
            return "ActionHomeFragmentToAirToWater(actionId=" + getActionId() + "){device=" + getDevice() + "}";
        }
    }

    /* loaded from: classes3.dex */
    public static class ActionHomeFragmentToDispenserAtlantic implements NavDirections {
        private final HashMap arguments;

        @Override // androidx.navigation.NavDirections
        public int getActionId() {
            return R.id.action_homeFragment_to_Dispenser_Atlantic;
        }

        private ActionHomeFragmentToDispenserAtlantic(DeviceList device) {
            HashMap hashMap = new HashMap();
            this.arguments = hashMap;
            if (device == null) {
                throw new IllegalArgumentException("Argument \"device\" is marked as non-null but was passed a null value.");
            }
            hashMap.put(AndroidContextPlugin.DEVICE_KEY, device);
        }

        public ActionHomeFragmentToDispenserAtlantic setDevice(DeviceList device) {
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
            ActionHomeFragmentToDispenserAtlantic actionHomeFragmentToDispenserAtlantic = (ActionHomeFragmentToDispenserAtlantic) object;
            if (this.arguments.containsKey(AndroidContextPlugin.DEVICE_KEY) != actionHomeFragmentToDispenserAtlantic.arguments.containsKey(AndroidContextPlugin.DEVICE_KEY)) {
                return false;
            }
            if (getDevice() == null ? actionHomeFragmentToDispenserAtlantic.getDevice() == null : getDevice().equals(actionHomeFragmentToDispenserAtlantic.getDevice())) {
                return getActionId() == actionHomeFragmentToDispenserAtlantic.getActionId();
            }
            return false;
        }

        public int hashCode() {
            return (((getDevice() != null ? getDevice().hashCode() : 0) + 31) * 31) + getActionId();
        }

        public String toString() {
            return "ActionHomeFragmentToDispenserAtlantic(actionId=" + getActionId() + "){device=" + getDevice() + "}";
        }
    }

    /* loaded from: classes3.dex */
    public static class ActionHomeFragmentToEnvyHome implements NavDirections {
        private final HashMap arguments;

        @Override // androidx.navigation.NavDirections
        public int getActionId() {
            return R.id.action_homeFragment_to_Envy_Home;
        }

        private ActionHomeFragmentToEnvyHome(DeviceList device) {
            HashMap hashMap = new HashMap();
            this.arguments = hashMap;
            if (device == null) {
                throw new IllegalArgumentException("Argument \"device\" is marked as non-null but was passed a null value.");
            }
            hashMap.put(AndroidContextPlugin.DEVICE_KEY, device);
        }

        public ActionHomeFragmentToEnvyHome setDevice(DeviceList device) {
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
            ActionHomeFragmentToEnvyHome actionHomeFragmentToEnvyHome = (ActionHomeFragmentToEnvyHome) object;
            if (this.arguments.containsKey(AndroidContextPlugin.DEVICE_KEY) != actionHomeFragmentToEnvyHome.arguments.containsKey(AndroidContextPlugin.DEVICE_KEY)) {
                return false;
            }
            if (getDevice() == null ? actionHomeFragmentToEnvyHome.getDevice() == null : getDevice().equals(actionHomeFragmentToEnvyHome.getDevice())) {
                return getActionId() == actionHomeFragmentToEnvyHome.getActionId();
            }
            return false;
        }

        public int hashCode() {
            return (((getDevice() != null ? getDevice().hashCode() : 0) + 31) * 31) + getActionId();
        }

        public String toString() {
            return "ActionHomeFragmentToEnvyHome(actionId=" + getActionId() + "){device=" + getDevice() + "}";
        }
    }

    /* loaded from: classes3.dex */
    public static class ActionHomeFragmentToUnlimiterWaterHomeFragment implements NavDirections {
        private final HashMap arguments;

        @Override // androidx.navigation.NavDirections
        public int getActionId() {
            return R.id.action_homeFragment_to_Unlimiter_Water_Home_Fragment;
        }

        private ActionHomeFragmentToUnlimiterWaterHomeFragment(DeviceList device) {
            HashMap hashMap = new HashMap();
            this.arguments = hashMap;
            if (device == null) {
                throw new IllegalArgumentException("Argument \"device\" is marked as non-null but was passed a null value.");
            }
            hashMap.put(AndroidContextPlugin.DEVICE_KEY, device);
        }

        public ActionHomeFragmentToUnlimiterWaterHomeFragment setDevice(DeviceList device) {
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
            ActionHomeFragmentToUnlimiterWaterHomeFragment actionHomeFragmentToUnlimiterWaterHomeFragment = (ActionHomeFragmentToUnlimiterWaterHomeFragment) object;
            if (this.arguments.containsKey(AndroidContextPlugin.DEVICE_KEY) != actionHomeFragmentToUnlimiterWaterHomeFragment.arguments.containsKey(AndroidContextPlugin.DEVICE_KEY)) {
                return false;
            }
            if (getDevice() == null ? actionHomeFragmentToUnlimiterWaterHomeFragment.getDevice() == null : getDevice().equals(actionHomeFragmentToUnlimiterWaterHomeFragment.getDevice())) {
                return getActionId() == actionHomeFragmentToUnlimiterWaterHomeFragment.getActionId();
            }
            return false;
        }

        public int hashCode() {
            return (((getDevice() != null ? getDevice().hashCode() : 0) + 31) * 31) + getActionId();
        }

        public String toString() {
            return "ActionHomeFragmentToUnlimiterWaterHomeFragment(actionId=" + getActionId() + "){device=" + getDevice() + "}";
        }
    }
}
