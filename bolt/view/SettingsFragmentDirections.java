package com.livpure.safedrink.bolt.view;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.navigation.NavDirections;
import com.livpure.safedrink.NavGraphDirections;
import com.livpure.safedrink.R;
import com.livpure.safedrink.subscription.plan.data.model.deviceList.DeviceList;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import java.io.Serializable;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class SettingsFragmentDirections {
    private SettingsFragmentDirections() {
    }

    public static ActionBoltSettingsToWifiConfiguraton actionBoltSettingsToWifiConfiguraton(DeviceList device) {
        return new ActionBoltSettingsToWifiConfiguraton(device);
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
    public static class ActionBoltSettingsToWifiConfiguraton implements NavDirections {
        private final HashMap arguments;

        @Override // androidx.navigation.NavDirections
        public int getActionId() {
            return R.id.action_boltSettings_to_wifi_configuraton;
        }

        private ActionBoltSettingsToWifiConfiguraton(DeviceList device) {
            HashMap hashMap = new HashMap();
            this.arguments = hashMap;
            if (device == null) {
                throw new IllegalArgumentException("Argument \"device\" is marked as non-null but was passed a null value.");
            }
            hashMap.put(AndroidContextPlugin.DEVICE_KEY, device);
        }

        public ActionBoltSettingsToWifiConfiguraton setDevice(DeviceList device) {
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
            ActionBoltSettingsToWifiConfiguraton actionBoltSettingsToWifiConfiguraton = (ActionBoltSettingsToWifiConfiguraton) object;
            if (this.arguments.containsKey(AndroidContextPlugin.DEVICE_KEY) != actionBoltSettingsToWifiConfiguraton.arguments.containsKey(AndroidContextPlugin.DEVICE_KEY)) {
                return false;
            }
            if (getDevice() == null ? actionBoltSettingsToWifiConfiguraton.getDevice() == null : getDevice().equals(actionBoltSettingsToWifiConfiguraton.getDevice())) {
                return getActionId() == actionBoltSettingsToWifiConfiguraton.getActionId();
            }
            return false;
        }

        public int hashCode() {
            return (((getDevice() != null ? getDevice().hashCode() : 0) + 31) * 31) + getActionId();
        }

        public String toString() {
            return "ActionBoltSettingsToWifiConfiguraton(actionId=" + getActionId() + "){device=" + getDevice() + "}";
        }
    }
}
