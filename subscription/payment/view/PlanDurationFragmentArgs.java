package com.livpure.safedrink.subscription.payment.view;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.NavArgs;
import com.livpure.safedrink.subscription.plan.data.model.deviceList.DeviceList;
import com.livpure.safedrink.subscription.plan.data.model.plan.PlansItem;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import java.io.Serializable;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class PlanDurationFragmentArgs implements NavArgs {
    private final HashMap arguments;

    private PlanDurationFragmentArgs() {
        this.arguments = new HashMap();
    }

    private PlanDurationFragmentArgs(HashMap argumentsMap) {
        HashMap hashMap = new HashMap();
        this.arguments = hashMap;
        hashMap.putAll(argumentsMap);
    }

    public static PlanDurationFragmentArgs fromBundle(Bundle bundle) {
        PlanDurationFragmentArgs planDurationFragmentArgs = new PlanDurationFragmentArgs();
        bundle.setClassLoader(PlanDurationFragmentArgs.class.getClassLoader());
        if (bundle.containsKey("plan")) {
            if (Parcelable.class.isAssignableFrom(PlansItem.class) || Serializable.class.isAssignableFrom(PlansItem.class)) {
                PlansItem plansItem = (PlansItem) bundle.get("plan");
                if (plansItem == null) {
                    throw new IllegalArgumentException("Argument \"plan\" is marked as non-null but was passed a null value.");
                }
                planDurationFragmentArgs.arguments.put("plan", plansItem);
                if (bundle.containsKey(AndroidContextPlugin.DEVICE_KEY)) {
                    if (Parcelable.class.isAssignableFrom(DeviceList.class) || Serializable.class.isAssignableFrom(DeviceList.class)) {
                        DeviceList deviceList = (DeviceList) bundle.get(AndroidContextPlugin.DEVICE_KEY);
                        if (deviceList == null) {
                            throw new IllegalArgumentException("Argument \"device\" is marked as non-null but was passed a null value.");
                        }
                        planDurationFragmentArgs.arguments.put(AndroidContextPlugin.DEVICE_KEY, deviceList);
                        return planDurationFragmentArgs;
                    }
                    throw new UnsupportedOperationException(DeviceList.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
                }
                throw new IllegalArgumentException("Required argument \"device\" is missing and does not have an android:defaultValue");
            }
            throw new UnsupportedOperationException(PlansItem.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
        }
        throw new IllegalArgumentException("Required argument \"plan\" is missing and does not have an android:defaultValue");
    }

    public static PlanDurationFragmentArgs fromSavedStateHandle(SavedStateHandle savedStateHandle) {
        PlanDurationFragmentArgs planDurationFragmentArgs = new PlanDurationFragmentArgs();
        if (savedStateHandle.contains("plan")) {
            PlansItem plansItem = (PlansItem) savedStateHandle.get("plan");
            if (plansItem == null) {
                throw new IllegalArgumentException("Argument \"plan\" is marked as non-null but was passed a null value.");
            }
            planDurationFragmentArgs.arguments.put("plan", plansItem);
            if (savedStateHandle.contains(AndroidContextPlugin.DEVICE_KEY)) {
                DeviceList deviceList = (DeviceList) savedStateHandle.get(AndroidContextPlugin.DEVICE_KEY);
                if (deviceList == null) {
                    throw new IllegalArgumentException("Argument \"device\" is marked as non-null but was passed a null value.");
                }
                planDurationFragmentArgs.arguments.put(AndroidContextPlugin.DEVICE_KEY, deviceList);
                return planDurationFragmentArgs;
            }
            throw new IllegalArgumentException("Required argument \"device\" is missing and does not have an android:defaultValue");
        }
        throw new IllegalArgumentException("Required argument \"plan\" is missing and does not have an android:defaultValue");
    }

    public PlansItem getPlan() {
        return (PlansItem) this.arguments.get("plan");
    }

    public DeviceList getDevice() {
        return (DeviceList) this.arguments.get(AndroidContextPlugin.DEVICE_KEY);
    }

    public Bundle toBundle() {
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

    public SavedStateHandle toSavedStateHandle() {
        SavedStateHandle savedStateHandle = new SavedStateHandle();
        if (this.arguments.containsKey("plan")) {
            PlansItem plansItem = (PlansItem) this.arguments.get("plan");
            if (Parcelable.class.isAssignableFrom(PlansItem.class) || plansItem == null) {
                savedStateHandle.set("plan", (Parcelable) Parcelable.class.cast(plansItem));
            } else if (Serializable.class.isAssignableFrom(PlansItem.class)) {
                savedStateHandle.set("plan", (Serializable) Serializable.class.cast(plansItem));
            } else {
                throw new UnsupportedOperationException(PlansItem.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
            }
        }
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
        PlanDurationFragmentArgs planDurationFragmentArgs = (PlanDurationFragmentArgs) object;
        if (this.arguments.containsKey("plan") != planDurationFragmentArgs.arguments.containsKey("plan")) {
            return false;
        }
        if (getPlan() == null ? planDurationFragmentArgs.getPlan() == null : getPlan().equals(planDurationFragmentArgs.getPlan())) {
            if (this.arguments.containsKey(AndroidContextPlugin.DEVICE_KEY) != planDurationFragmentArgs.arguments.containsKey(AndroidContextPlugin.DEVICE_KEY)) {
                return false;
            }
            return getDevice() == null ? planDurationFragmentArgs.getDevice() == null : getDevice().equals(planDurationFragmentArgs.getDevice());
        }
        return false;
    }

    public int hashCode() {
        return (((getPlan() != null ? getPlan().hashCode() : 0) + 31) * 31) + (getDevice() != null ? getDevice().hashCode() : 0);
    }

    public String toString() {
        return "PlanDurationFragmentArgs{plan=" + getPlan() + ", device=" + getDevice() + "}";
    }

    /* loaded from: classes3.dex */
    public static final class Builder {
        private final HashMap arguments;

        public Builder(PlanDurationFragmentArgs original) {
            HashMap hashMap = new HashMap();
            this.arguments = hashMap;
            hashMap.putAll(original.arguments);
        }

        public Builder(PlansItem plan, DeviceList device) {
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

        public PlanDurationFragmentArgs build() {
            return new PlanDurationFragmentArgs(this.arguments);
        }

        public Builder setPlan(PlansItem plan) {
            if (plan == null) {
                throw new IllegalArgumentException("Argument \"plan\" is marked as non-null but was passed a null value.");
            }
            this.arguments.put("plan", plan);
            return this;
        }

        public Builder setDevice(DeviceList device) {
            if (device == null) {
                throw new IllegalArgumentException("Argument \"device\" is marked as non-null but was passed a null value.");
            }
            this.arguments.put(AndroidContextPlugin.DEVICE_KEY, device);
            return this;
        }

        public PlansItem getPlan() {
            return (PlansItem) this.arguments.get("plan");
        }

        public DeviceList getDevice() {
            return (DeviceList) this.arguments.get(AndroidContextPlugin.DEVICE_KEY);
        }
    }
}
