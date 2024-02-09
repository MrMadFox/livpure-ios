package com.livpure.safedrink;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.livpure.safedrink.subscription.plan.data.model.deviceList.DeviceList;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import java.io.Serializable;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class NavGraphDirections {
    private NavGraphDirections() {
    }

    public static NavDirections actionGlobalHomeFurlencoFragment() {
        return new ActionOnlyNavDirections(R.id.action_global_homeFurlencoFragment);
    }

    public static ActionGlobalOnBoardingWebViewFragment actionGlobalOnBoardingWebViewFragment(int url) {
        return new ActionGlobalOnBoardingWebViewFragment(url);
    }

    public static NavDirections actionGlobalLogout() {
        return new ActionOnlyNavDirections(R.id.action_global_logout);
    }

    public static ActionGlobalAuthentication actionGlobalAuthentication() {
        return new ActionGlobalAuthentication();
    }

    public static ActionGlobalWebViewFragment actionGlobalWebViewFragment(int url) {
        return new ActionGlobalWebViewFragment(url);
    }

    public static NavDirections actionGlobalSplashFragment() {
        return new ActionOnlyNavDirections(R.id.action_global_splashFragment);
    }

    public static ActionGlobalHomeFragment actionGlobalHomeFragment(String serialNumber) {
        return new ActionGlobalHomeFragment(serialNumber);
    }

    public static ActionGlobalRoHomeFragment actionGlobalRoHomeFragment(DeviceList device) {
        return new ActionGlobalRoHomeFragment(device);
    }

    public static NavDirections actionGlobalNoNetworkFragment() {
        return new ActionOnlyNavDirections(R.id.action_global_noNetworkFragment);
    }

    public static NavDirections actionGlobalReferAndEarnFragment() {
        return new ActionOnlyNavDirections(R.id.action_global_referAndEarnFragment);
    }

    /* loaded from: classes3.dex */
    public static class ActionGlobalOnBoardingWebViewFragment implements NavDirections {
        private final HashMap arguments;

        @Override // androidx.navigation.NavDirections
        public int getActionId() {
            return R.id.action_global_onBoardingWebViewFragment;
        }

        private ActionGlobalOnBoardingWebViewFragment(int url) {
            HashMap hashMap = new HashMap();
            this.arguments = hashMap;
            hashMap.put("url", Integer.valueOf(url));
        }

        public ActionGlobalOnBoardingWebViewFragment setUrl(int url) {
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
            ActionGlobalOnBoardingWebViewFragment actionGlobalOnBoardingWebViewFragment = (ActionGlobalOnBoardingWebViewFragment) object;
            return this.arguments.containsKey("url") == actionGlobalOnBoardingWebViewFragment.arguments.containsKey("url") && getUrl() == actionGlobalOnBoardingWebViewFragment.getUrl() && getActionId() == actionGlobalOnBoardingWebViewFragment.getActionId();
        }

        public int hashCode() {
            return ((getUrl() + 31) * 31) + getActionId();
        }

        public String toString() {
            return "ActionGlobalOnBoardingWebViewFragment(actionId=" + getActionId() + "){url=" + getUrl() + "}";
        }
    }

    /* loaded from: classes3.dex */
    public static class ActionGlobalAuthentication implements NavDirections {
        private final HashMap arguments;

        @Override // androidx.navigation.NavDirections
        public int getActionId() {
            return R.id.action_global_authentication;
        }

        private ActionGlobalAuthentication() {
            this.arguments = new HashMap();
        }

        public ActionGlobalAuthentication setAuthType(int authType) {
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
            ActionGlobalAuthentication actionGlobalAuthentication = (ActionGlobalAuthentication) object;
            return this.arguments.containsKey("authType") == actionGlobalAuthentication.arguments.containsKey("authType") && getAuthType() == actionGlobalAuthentication.getAuthType() && getActionId() == actionGlobalAuthentication.getActionId();
        }

        public int hashCode() {
            return ((getAuthType() + 31) * 31) + getActionId();
        }

        public String toString() {
            return "ActionGlobalAuthentication(actionId=" + getActionId() + "){authType=" + getAuthType() + "}";
        }
    }

    /* loaded from: classes3.dex */
    public static class ActionGlobalWebViewFragment implements NavDirections {
        private final HashMap arguments;

        @Override // androidx.navigation.NavDirections
        public int getActionId() {
            return R.id.action_global_webViewFragment;
        }

        private ActionGlobalWebViewFragment(int url) {
            HashMap hashMap = new HashMap();
            this.arguments = hashMap;
            hashMap.put("url", Integer.valueOf(url));
        }

        public ActionGlobalWebViewFragment setUrl(int url) {
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
            ActionGlobalWebViewFragment actionGlobalWebViewFragment = (ActionGlobalWebViewFragment) object;
            return this.arguments.containsKey("url") == actionGlobalWebViewFragment.arguments.containsKey("url") && getUrl() == actionGlobalWebViewFragment.getUrl() && getActionId() == actionGlobalWebViewFragment.getActionId();
        }

        public int hashCode() {
            return ((getUrl() + 31) * 31) + getActionId();
        }

        public String toString() {
            return "ActionGlobalWebViewFragment(actionId=" + getActionId() + "){url=" + getUrl() + "}";
        }
    }

    /* loaded from: classes3.dex */
    public static class ActionGlobalHomeFragment implements NavDirections {
        private final HashMap arguments;

        @Override // androidx.navigation.NavDirections
        public int getActionId() {
            return R.id.action_global_homeFragment;
        }

        private ActionGlobalHomeFragment(String serialNumber) {
            HashMap hashMap = new HashMap();
            this.arguments = hashMap;
            if (serialNumber == null) {
                throw new IllegalArgumentException("Argument \"serialNumber\" is marked as non-null but was passed a null value.");
            }
            hashMap.put("serialNumber", serialNumber);
        }

        public ActionGlobalHomeFragment setSerialNumber(String serialNumber) {
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
            ActionGlobalHomeFragment actionGlobalHomeFragment = (ActionGlobalHomeFragment) object;
            if (this.arguments.containsKey("serialNumber") != actionGlobalHomeFragment.arguments.containsKey("serialNumber")) {
                return false;
            }
            if (getSerialNumber() == null ? actionGlobalHomeFragment.getSerialNumber() == null : getSerialNumber().equals(actionGlobalHomeFragment.getSerialNumber())) {
                return getActionId() == actionGlobalHomeFragment.getActionId();
            }
            return false;
        }

        public int hashCode() {
            return (((getSerialNumber() != null ? getSerialNumber().hashCode() : 0) + 31) * 31) + getActionId();
        }

        public String toString() {
            return "ActionGlobalHomeFragment(actionId=" + getActionId() + "){serialNumber=" + getSerialNumber() + "}";
        }
    }

    /* loaded from: classes3.dex */
    public static class ActionGlobalRoHomeFragment implements NavDirections {
        private final HashMap arguments;

        @Override // androidx.navigation.NavDirections
        public int getActionId() {
            return R.id.action_global_roHomeFragment;
        }

        private ActionGlobalRoHomeFragment(DeviceList device) {
            HashMap hashMap = new HashMap();
            this.arguments = hashMap;
            if (device == null) {
                throw new IllegalArgumentException("Argument \"device\" is marked as non-null but was passed a null value.");
            }
            hashMap.put(AndroidContextPlugin.DEVICE_KEY, device);
        }

        public ActionGlobalRoHomeFragment setDevice(DeviceList device) {
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
            ActionGlobalRoHomeFragment actionGlobalRoHomeFragment = (ActionGlobalRoHomeFragment) object;
            if (this.arguments.containsKey(AndroidContextPlugin.DEVICE_KEY) != actionGlobalRoHomeFragment.arguments.containsKey(AndroidContextPlugin.DEVICE_KEY)) {
                return false;
            }
            if (getDevice() == null ? actionGlobalRoHomeFragment.getDevice() == null : getDevice().equals(actionGlobalRoHomeFragment.getDevice())) {
                return getActionId() == actionGlobalRoHomeFragment.getActionId();
            }
            return false;
        }

        public int hashCode() {
            return (((getDevice() != null ? getDevice().hashCode() : 0) + 31) * 31) + getActionId();
        }

        public String toString() {
            return "ActionGlobalRoHomeFragment(actionId=" + getActionId() + "){device=" + getDevice() + "}";
        }
    }
}
