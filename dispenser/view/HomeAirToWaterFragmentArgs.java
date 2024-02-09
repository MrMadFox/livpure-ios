package com.livpure.safedrink.dispenser.view;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.NavArgs;
import com.livpure.safedrink.subscription.plan.data.model.deviceList.DeviceList;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import java.io.Serializable;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class HomeAirToWaterFragmentArgs implements NavArgs {
    private final HashMap arguments;

    private HomeAirToWaterFragmentArgs() {
        this.arguments = new HashMap();
    }

    private HomeAirToWaterFragmentArgs(HashMap argumentsMap) {
        HashMap hashMap = new HashMap();
        this.arguments = hashMap;
        hashMap.putAll(argumentsMap);
    }

    public static HomeAirToWaterFragmentArgs fromBundle(Bundle bundle) {
        HomeAirToWaterFragmentArgs homeAirToWaterFragmentArgs = new HomeAirToWaterFragmentArgs();
        bundle.setClassLoader(HomeAirToWaterFragmentArgs.class.getClassLoader());
        if (bundle.containsKey(AndroidContextPlugin.DEVICE_KEY)) {
            if (Parcelable.class.isAssignableFrom(DeviceList.class) || Serializable.class.isAssignableFrom(DeviceList.class)) {
                DeviceList deviceList = (DeviceList) bundle.get(AndroidContextPlugin.DEVICE_KEY);
                if (deviceList == null) {
                    throw new IllegalArgumentException("Argument \"device\" is marked as non-null but was passed a null value.");
                }
                homeAirToWaterFragmentArgs.arguments.put(AndroidContextPlugin.DEVICE_KEY, deviceList);
                return homeAirToWaterFragmentArgs;
            }
            throw new UnsupportedOperationException(DeviceList.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
        }
        throw new IllegalArgumentException("Required argument \"device\" is missing and does not have an android:defaultValue");
    }

    public static HomeAirToWaterFragmentArgs fromSavedStateHandle(SavedStateHandle savedStateHandle) {
        HomeAirToWaterFragmentArgs homeAirToWaterFragmentArgs = new HomeAirToWaterFragmentArgs();
        if (savedStateHandle.contains(AndroidContextPlugin.DEVICE_KEY)) {
            DeviceList deviceList = (DeviceList) savedStateHandle.get(AndroidContextPlugin.DEVICE_KEY);
            if (deviceList == null) {
                throw new IllegalArgumentException("Argument \"device\" is marked as non-null but was passed a null value.");
            }
            homeAirToWaterFragmentArgs.arguments.put(AndroidContextPlugin.DEVICE_KEY, deviceList);
            return homeAirToWaterFragmentArgs;
        }
        throw new IllegalArgumentException("Required argument \"device\" is missing and does not have an android:defaultValue");
    }

    public DeviceList getDevice() {
        return (DeviceList) this.arguments.get(AndroidContextPlugin.DEVICE_KEY);
    }

    public Bundle toBundle() {
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

    public SavedStateHandle toSavedStateHandle() {
        SavedStateHandle savedStateHandle = new SavedStateHandle();
        if (this.arguments.containsKey(AndroidContextPlugin.DEVICE_KEY)) {
            DeviceList deviceList = (DeviceList) this.arguments.get(AndroidContextPlugin.DEVICE_KEY);
            if (Parcelable.class.isAssignableFrom(DeviceList.class) || deviceList == null) {
                savedStateHandle.set(AndroidContextPlugin.DEVICE_KEY, (Parcelable) Parcelable.class.cast(deviceList));
            } else if (Serializable.class.isAssignableFrom(DeviceList.class)) {
                savedStateHandle.set(AndroidContextPlugin.DEVICE_KEY, (Serializable) Serializable.class.cast(deviceList));
            } else {
                throw new UnsupportedOperationException(DeviceList.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
            }
        }
        return savedStateHandle;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        HomeAirToWaterFragmentArgs homeAirToWaterFragmentArgs = (HomeAirToWaterFragmentArgs) object;
        if (this.arguments.containsKey(AndroidContextPlugin.DEVICE_KEY) != homeAirToWaterFragmentArgs.arguments.containsKey(AndroidContextPlugin.DEVICE_KEY)) {
            return false;
        }
        return getDevice() == null ? homeAirToWaterFragmentArgs.getDevice() == null : getDevice().equals(homeAirToWaterFragmentArgs.getDevice());
    }

    public int hashCode() {
        return 31 + (getDevice() != null ? getDevice().hashCode() : 0);
    }

    public String toString() {
        return "HomeAirToWaterFragmentArgs{device=" + getDevice() + "}";
    }

    /* loaded from: classes3.dex */
    public static final class Builder {
        private final HashMap arguments;

        public Builder(HomeAirToWaterFragmentArgs original) {
            HashMap hashMap = new HashMap();
            this.arguments = hashMap;
            hashMap.putAll(original.arguments);
        }

        public Builder(DeviceList device) {
            HashMap hashMap = new HashMap();
            this.arguments = hashMap;
            if (device == null) {
                throw new IllegalArgumentException("Argument \"device\" is marked as non-null but was passed a null value.");
            }
            hashMap.put(AndroidContextPlugin.DEVICE_KEY, device);
        }

        public HomeAirToWaterFragmentArgs build() {
            return new HomeAirToWaterFragmentArgs(this.arguments);
        }

        public Builder setDevice(DeviceList device) {
            if (device == null) {
                throw new IllegalArgumentException("Argument \"device\" is marked as non-null but was passed a null value.");
            }
            this.arguments.put(AndroidContextPlugin.DEVICE_KEY, device);
            return this;
        }

        public DeviceList getDevice() {
            return (DeviceList) this.arguments.get(AndroidContextPlugin.DEVICE_KEY);
        }
    }
}