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
public class HomeDispenserAtlanticFragmentArgs implements NavArgs {
    private final HashMap arguments;

    private HomeDispenserAtlanticFragmentArgs() {
        this.arguments = new HashMap();
    }

    private HomeDispenserAtlanticFragmentArgs(HashMap argumentsMap) {
        HashMap hashMap = new HashMap();
        this.arguments = hashMap;
        hashMap.putAll(argumentsMap);
    }

    public static HomeDispenserAtlanticFragmentArgs fromBundle(Bundle bundle) {
        HomeDispenserAtlanticFragmentArgs homeDispenserAtlanticFragmentArgs = new HomeDispenserAtlanticFragmentArgs();
        bundle.setClassLoader(HomeDispenserAtlanticFragmentArgs.class.getClassLoader());
        if (bundle.containsKey(AndroidContextPlugin.DEVICE_KEY)) {
            if (Parcelable.class.isAssignableFrom(DeviceList.class) || Serializable.class.isAssignableFrom(DeviceList.class)) {
                DeviceList deviceList = (DeviceList) bundle.get(AndroidContextPlugin.DEVICE_KEY);
                if (deviceList == null) {
                    throw new IllegalArgumentException("Argument \"device\" is marked as non-null but was passed a null value.");
                }
                homeDispenserAtlanticFragmentArgs.arguments.put(AndroidContextPlugin.DEVICE_KEY, deviceList);
                return homeDispenserAtlanticFragmentArgs;
            }
            throw new UnsupportedOperationException(DeviceList.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
        }
        throw new IllegalArgumentException("Required argument \"device\" is missing and does not have an android:defaultValue");
    }

    public static HomeDispenserAtlanticFragmentArgs fromSavedStateHandle(SavedStateHandle savedStateHandle) {
        HomeDispenserAtlanticFragmentArgs homeDispenserAtlanticFragmentArgs = new HomeDispenserAtlanticFragmentArgs();
        if (savedStateHandle.contains(AndroidContextPlugin.DEVICE_KEY)) {
            DeviceList deviceList = (DeviceList) savedStateHandle.get(AndroidContextPlugin.DEVICE_KEY);
            if (deviceList == null) {
                throw new IllegalArgumentException("Argument \"device\" is marked as non-null but was passed a null value.");
            }
            homeDispenserAtlanticFragmentArgs.arguments.put(AndroidContextPlugin.DEVICE_KEY, deviceList);
            return homeDispenserAtlanticFragmentArgs;
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
        HomeDispenserAtlanticFragmentArgs homeDispenserAtlanticFragmentArgs = (HomeDispenserAtlanticFragmentArgs) object;
        if (this.arguments.containsKey(AndroidContextPlugin.DEVICE_KEY) != homeDispenserAtlanticFragmentArgs.arguments.containsKey(AndroidContextPlugin.DEVICE_KEY)) {
            return false;
        }
        return getDevice() == null ? homeDispenserAtlanticFragmentArgs.getDevice() == null : getDevice().equals(homeDispenserAtlanticFragmentArgs.getDevice());
    }

    public int hashCode() {
        return 31 + (getDevice() != null ? getDevice().hashCode() : 0);
    }

    public String toString() {
        return "HomeDispenserAtlanticFragmentArgs{device=" + getDevice() + "}";
    }

    /* loaded from: classes3.dex */
    public static final class Builder {
        private final HashMap arguments;

        public Builder(HomeDispenserAtlanticFragmentArgs original) {
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

        public HomeDispenserAtlanticFragmentArgs build() {
            return new HomeDispenserAtlanticFragmentArgs(this.arguments);
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
