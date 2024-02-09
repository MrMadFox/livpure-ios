package com.livpure.safedrink.serviceRequest.view;

import android.os.Bundle;
import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.NavArgs;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class RaiseServiceRequestFragmentArgs implements NavArgs {
    private final HashMap arguments;

    private RaiseServiceRequestFragmentArgs() {
        this.arguments = new HashMap();
    }

    private RaiseServiceRequestFragmentArgs(HashMap argumentsMap) {
        HashMap hashMap = new HashMap();
        this.arguments = hashMap;
        hashMap.putAll(argumentsMap);
    }

    public static RaiseServiceRequestFragmentArgs fromBundle(Bundle bundle) {
        RaiseServiceRequestFragmentArgs raiseServiceRequestFragmentArgs = new RaiseServiceRequestFragmentArgs();
        bundle.setClassLoader(RaiseServiceRequestFragmentArgs.class.getClassLoader());
        if (bundle.containsKey("serialNumber")) {
            String string = bundle.getString("serialNumber");
            if (string == null) {
                throw new IllegalArgumentException("Argument \"serialNumber\" is marked as non-null but was passed a null value.");
            }
            raiseServiceRequestFragmentArgs.arguments.put("serialNumber", string);
            if (bundle.containsKey("cancelSubscription")) {
                String string2 = bundle.getString("cancelSubscription");
                if (string2 == null) {
                    throw new IllegalArgumentException("Argument \"cancelSubscription\" is marked as non-null but was passed a null value.");
                }
                raiseServiceRequestFragmentArgs.arguments.put("cancelSubscription", string2);
                return raiseServiceRequestFragmentArgs;
            }
            throw new IllegalArgumentException("Required argument \"cancelSubscription\" is missing and does not have an android:defaultValue");
        }
        throw new IllegalArgumentException("Required argument \"serialNumber\" is missing and does not have an android:defaultValue");
    }

    public static RaiseServiceRequestFragmentArgs fromSavedStateHandle(SavedStateHandle savedStateHandle) {
        RaiseServiceRequestFragmentArgs raiseServiceRequestFragmentArgs = new RaiseServiceRequestFragmentArgs();
        if (savedStateHandle.contains("serialNumber")) {
            String str = (String) savedStateHandle.get("serialNumber");
            if (str == null) {
                throw new IllegalArgumentException("Argument \"serialNumber\" is marked as non-null but was passed a null value.");
            }
            raiseServiceRequestFragmentArgs.arguments.put("serialNumber", str);
            if (savedStateHandle.contains("cancelSubscription")) {
                String str2 = (String) savedStateHandle.get("cancelSubscription");
                if (str2 == null) {
                    throw new IllegalArgumentException("Argument \"cancelSubscription\" is marked as non-null but was passed a null value.");
                }
                raiseServiceRequestFragmentArgs.arguments.put("cancelSubscription", str2);
                return raiseServiceRequestFragmentArgs;
            }
            throw new IllegalArgumentException("Required argument \"cancelSubscription\" is missing and does not have an android:defaultValue");
        }
        throw new IllegalArgumentException("Required argument \"serialNumber\" is missing and does not have an android:defaultValue");
    }

    public String getSerialNumber() {
        return (String) this.arguments.get("serialNumber");
    }

    public String getCancelSubscription() {
        return (String) this.arguments.get("cancelSubscription");
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        if (this.arguments.containsKey("serialNumber")) {
            bundle.putString("serialNumber", (String) this.arguments.get("serialNumber"));
        }
        if (this.arguments.containsKey("cancelSubscription")) {
            bundle.putString("cancelSubscription", (String) this.arguments.get("cancelSubscription"));
        }
        return bundle;
    }

    public SavedStateHandle toSavedStateHandle() {
        SavedStateHandle savedStateHandle = new SavedStateHandle();
        if (this.arguments.containsKey("serialNumber")) {
            savedStateHandle.set("serialNumber", (String) this.arguments.get("serialNumber"));
        }
        if (this.arguments.containsKey("cancelSubscription")) {
            savedStateHandle.set("cancelSubscription", (String) this.arguments.get("cancelSubscription"));
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
        RaiseServiceRequestFragmentArgs raiseServiceRequestFragmentArgs = (RaiseServiceRequestFragmentArgs) object;
        if (this.arguments.containsKey("serialNumber") != raiseServiceRequestFragmentArgs.arguments.containsKey("serialNumber")) {
            return false;
        }
        if (getSerialNumber() == null ? raiseServiceRequestFragmentArgs.getSerialNumber() == null : getSerialNumber().equals(raiseServiceRequestFragmentArgs.getSerialNumber())) {
            if (this.arguments.containsKey("cancelSubscription") != raiseServiceRequestFragmentArgs.arguments.containsKey("cancelSubscription")) {
                return false;
            }
            return getCancelSubscription() == null ? raiseServiceRequestFragmentArgs.getCancelSubscription() == null : getCancelSubscription().equals(raiseServiceRequestFragmentArgs.getCancelSubscription());
        }
        return false;
    }

    public int hashCode() {
        return (((getSerialNumber() != null ? getSerialNumber().hashCode() : 0) + 31) * 31) + (getCancelSubscription() != null ? getCancelSubscription().hashCode() : 0);
    }

    public String toString() {
        return "RaiseServiceRequestFragmentArgs{serialNumber=" + getSerialNumber() + ", cancelSubscription=" + getCancelSubscription() + "}";
    }

    /* loaded from: classes3.dex */
    public static final class Builder {
        private final HashMap arguments;

        public Builder(RaiseServiceRequestFragmentArgs original) {
            HashMap hashMap = new HashMap();
            this.arguments = hashMap;
            hashMap.putAll(original.arguments);
        }

        public Builder(String serialNumber, String cancelSubscription) {
            HashMap hashMap = new HashMap();
            this.arguments = hashMap;
            if (serialNumber == null) {
                throw new IllegalArgumentException("Argument \"serialNumber\" is marked as non-null but was passed a null value.");
            }
            hashMap.put("serialNumber", serialNumber);
            if (cancelSubscription == null) {
                throw new IllegalArgumentException("Argument \"cancelSubscription\" is marked as non-null but was passed a null value.");
            }
            hashMap.put("cancelSubscription", cancelSubscription);
        }

        public RaiseServiceRequestFragmentArgs build() {
            return new RaiseServiceRequestFragmentArgs(this.arguments);
        }

        public Builder setSerialNumber(String serialNumber) {
            if (serialNumber == null) {
                throw new IllegalArgumentException("Argument \"serialNumber\" is marked as non-null but was passed a null value.");
            }
            this.arguments.put("serialNumber", serialNumber);
            return this;
        }

        public Builder setCancelSubscription(String cancelSubscription) {
            if (cancelSubscription == null) {
                throw new IllegalArgumentException("Argument \"cancelSubscription\" is marked as non-null but was passed a null value.");
            }
            this.arguments.put("cancelSubscription", cancelSubscription);
            return this;
        }

        public String getSerialNumber() {
            return (String) this.arguments.get("serialNumber");
        }

        public String getCancelSubscription() {
            return (String) this.arguments.get("cancelSubscription");
        }
    }
}
