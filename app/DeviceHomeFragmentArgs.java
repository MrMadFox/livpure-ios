package com.livpure.safedrink.app;

import android.os.Bundle;
import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.NavArgs;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class DeviceHomeFragmentArgs implements NavArgs {
    private final HashMap arguments;

    private DeviceHomeFragmentArgs() {
        this.arguments = new HashMap();
    }

    private DeviceHomeFragmentArgs(HashMap argumentsMap) {
        HashMap hashMap = new HashMap();
        this.arguments = hashMap;
        hashMap.putAll(argumentsMap);
    }

    public static DeviceHomeFragmentArgs fromBundle(Bundle bundle) {
        DeviceHomeFragmentArgs deviceHomeFragmentArgs = new DeviceHomeFragmentArgs();
        bundle.setClassLoader(DeviceHomeFragmentArgs.class.getClassLoader());
        if (bundle.containsKey("serialNumber")) {
            String string = bundle.getString("serialNumber");
            if (string == null) {
                throw new IllegalArgumentException("Argument \"serialNumber\" is marked as non-null but was passed a null value.");
            }
            deviceHomeFragmentArgs.arguments.put("serialNumber", string);
            return deviceHomeFragmentArgs;
        }
        throw new IllegalArgumentException("Required argument \"serialNumber\" is missing and does not have an android:defaultValue");
    }

    public static DeviceHomeFragmentArgs fromSavedStateHandle(SavedStateHandle savedStateHandle) {
        DeviceHomeFragmentArgs deviceHomeFragmentArgs = new DeviceHomeFragmentArgs();
        if (savedStateHandle.contains("serialNumber")) {
            String str = (String) savedStateHandle.get("serialNumber");
            if (str == null) {
                throw new IllegalArgumentException("Argument \"serialNumber\" is marked as non-null but was passed a null value.");
            }
            deviceHomeFragmentArgs.arguments.put("serialNumber", str);
            return deviceHomeFragmentArgs;
        }
        throw new IllegalArgumentException("Required argument \"serialNumber\" is missing and does not have an android:defaultValue");
    }

    public String getSerialNumber() {
        return (String) this.arguments.get("serialNumber");
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        if (this.arguments.containsKey("serialNumber")) {
            bundle.putString("serialNumber", (String) this.arguments.get("serialNumber"));
        }
        return bundle;
    }

    public SavedStateHandle toSavedStateHandle() {
        SavedStateHandle savedStateHandle = new SavedStateHandle();
        if (this.arguments.containsKey("serialNumber")) {
            savedStateHandle.set("serialNumber", (String) this.arguments.get("serialNumber"));
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
        DeviceHomeFragmentArgs deviceHomeFragmentArgs = (DeviceHomeFragmentArgs) object;
        if (this.arguments.containsKey("serialNumber") != deviceHomeFragmentArgs.arguments.containsKey("serialNumber")) {
            return false;
        }
        return getSerialNumber() == null ? deviceHomeFragmentArgs.getSerialNumber() == null : getSerialNumber().equals(deviceHomeFragmentArgs.getSerialNumber());
    }

    public int hashCode() {
        return 31 + (getSerialNumber() != null ? getSerialNumber().hashCode() : 0);
    }

    public String toString() {
        return "DeviceHomeFragmentArgs{serialNumber=" + getSerialNumber() + "}";
    }

    /* loaded from: classes3.dex */
    public static final class Builder {
        private final HashMap arguments;

        public Builder(DeviceHomeFragmentArgs original) {
            HashMap hashMap = new HashMap();
            this.arguments = hashMap;
            hashMap.putAll(original.arguments);
        }

        public Builder(String serialNumber) {
            HashMap hashMap = new HashMap();
            this.arguments = hashMap;
            if (serialNumber == null) {
                throw new IllegalArgumentException("Argument \"serialNumber\" is marked as non-null but was passed a null value.");
            }
            hashMap.put("serialNumber", serialNumber);
        }

        public DeviceHomeFragmentArgs build() {
            return new DeviceHomeFragmentArgs(this.arguments);
        }

        public Builder setSerialNumber(String serialNumber) {
            if (serialNumber == null) {
                throw new IllegalArgumentException("Argument \"serialNumber\" is marked as non-null but was passed a null value.");
            }
            this.arguments.put("serialNumber", serialNumber);
            return this;
        }

        public String getSerialNumber() {
            return (String) this.arguments.get("serialNumber");
        }
    }
}
