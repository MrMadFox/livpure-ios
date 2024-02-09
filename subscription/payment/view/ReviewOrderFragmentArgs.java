package com.livpure.safedrink.subscription.payment.view;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.NavArgs;
import com.livpure.safedrink.subscription.plan.data.model.deviceList.DeviceList;
import com.livpure.safedrink.subscription.plan.data.model.plan.PriceItem;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import java.io.Serializable;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class ReviewOrderFragmentArgs implements NavArgs {
    private final HashMap arguments;

    private ReviewOrderFragmentArgs() {
        this.arguments = new HashMap();
    }

    private ReviewOrderFragmentArgs(HashMap argumentsMap) {
        HashMap hashMap = new HashMap();
        this.arguments = hashMap;
        hashMap.putAll(argumentsMap);
    }

    public static ReviewOrderFragmentArgs fromBundle(Bundle bundle) {
        ReviewOrderFragmentArgs reviewOrderFragmentArgs = new ReviewOrderFragmentArgs();
        bundle.setClassLoader(ReviewOrderFragmentArgs.class.getClassLoader());
        if (bundle.containsKey("plan")) {
            if (Parcelable.class.isAssignableFrom(PriceItem.class) || Serializable.class.isAssignableFrom(PriceItem.class)) {
                PriceItem priceItem = (PriceItem) bundle.get("plan");
                if (priceItem == null) {
                    throw new IllegalArgumentException("Argument \"plan\" is marked as non-null but was passed a null value.");
                }
                reviewOrderFragmentArgs.arguments.put("plan", priceItem);
                if (bundle.containsKey(AndroidContextPlugin.DEVICE_KEY)) {
                    if (Parcelable.class.isAssignableFrom(DeviceList.class) || Serializable.class.isAssignableFrom(DeviceList.class)) {
                        DeviceList deviceList = (DeviceList) bundle.get(AndroidContextPlugin.DEVICE_KEY);
                        if (deviceList == null) {
                            throw new IllegalArgumentException("Argument \"device\" is marked as non-null but was passed a null value.");
                        }
                        reviewOrderFragmentArgs.arguments.put(AndroidContextPlugin.DEVICE_KEY, deviceList);
                        if (bundle.containsKey("planName")) {
                            String string = bundle.getString("planName");
                            if (string == null) {
                                throw new IllegalArgumentException("Argument \"planName\" is marked as non-null but was passed a null value.");
                            }
                            reviewOrderFragmentArgs.arguments.put("planName", string);
                            if (bundle.containsKey("planNumber")) {
                                String string2 = bundle.getString("planNumber");
                                if (string2 == null) {
                                    throw new IllegalArgumentException("Argument \"planNumber\" is marked as non-null but was passed a null value.");
                                }
                                reviewOrderFragmentArgs.arguments.put("planNumber", string2);
                                return reviewOrderFragmentArgs;
                            }
                            throw new IllegalArgumentException("Required argument \"planNumber\" is missing and does not have an android:defaultValue");
                        }
                        throw new IllegalArgumentException("Required argument \"planName\" is missing and does not have an android:defaultValue");
                    }
                    throw new UnsupportedOperationException(DeviceList.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
                }
                throw new IllegalArgumentException("Required argument \"device\" is missing and does not have an android:defaultValue");
            }
            throw new UnsupportedOperationException(PriceItem.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
        }
        throw new IllegalArgumentException("Required argument \"plan\" is missing and does not have an android:defaultValue");
    }

    public static ReviewOrderFragmentArgs fromSavedStateHandle(SavedStateHandle savedStateHandle) {
        ReviewOrderFragmentArgs reviewOrderFragmentArgs = new ReviewOrderFragmentArgs();
        if (savedStateHandle.contains("plan")) {
            PriceItem priceItem = (PriceItem) savedStateHandle.get("plan");
            if (priceItem == null) {
                throw new IllegalArgumentException("Argument \"plan\" is marked as non-null but was passed a null value.");
            }
            reviewOrderFragmentArgs.arguments.put("plan", priceItem);
            if (savedStateHandle.contains(AndroidContextPlugin.DEVICE_KEY)) {
                DeviceList deviceList = (DeviceList) savedStateHandle.get(AndroidContextPlugin.DEVICE_KEY);
                if (deviceList == null) {
                    throw new IllegalArgumentException("Argument \"device\" is marked as non-null but was passed a null value.");
                }
                reviewOrderFragmentArgs.arguments.put(AndroidContextPlugin.DEVICE_KEY, deviceList);
                if (savedStateHandle.contains("planName")) {
                    String str = (String) savedStateHandle.get("planName");
                    if (str == null) {
                        throw new IllegalArgumentException("Argument \"planName\" is marked as non-null but was passed a null value.");
                    }
                    reviewOrderFragmentArgs.arguments.put("planName", str);
                    if (savedStateHandle.contains("planNumber")) {
                        String str2 = (String) savedStateHandle.get("planNumber");
                        if (str2 == null) {
                            throw new IllegalArgumentException("Argument \"planNumber\" is marked as non-null but was passed a null value.");
                        }
                        reviewOrderFragmentArgs.arguments.put("planNumber", str2);
                        return reviewOrderFragmentArgs;
                    }
                    throw new IllegalArgumentException("Required argument \"planNumber\" is missing and does not have an android:defaultValue");
                }
                throw new IllegalArgumentException("Required argument \"planName\" is missing and does not have an android:defaultValue");
            }
            throw new IllegalArgumentException("Required argument \"device\" is missing and does not have an android:defaultValue");
        }
        throw new IllegalArgumentException("Required argument \"plan\" is missing and does not have an android:defaultValue");
    }

    public PriceItem getPlan() {
        return (PriceItem) this.arguments.get("plan");
    }

    public DeviceList getDevice() {
        return (DeviceList) this.arguments.get(AndroidContextPlugin.DEVICE_KEY);
    }

    public String getPlanName() {
        return (String) this.arguments.get("planName");
    }

    public String getPlanNumber() {
        return (String) this.arguments.get("planNumber");
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        if (this.arguments.containsKey("plan")) {
            PriceItem priceItem = (PriceItem) this.arguments.get("plan");
            if (Parcelable.class.isAssignableFrom(PriceItem.class) || priceItem == null) {
                bundle.putParcelable("plan", (Parcelable) Parcelable.class.cast(priceItem));
            } else if (Serializable.class.isAssignableFrom(PriceItem.class)) {
                bundle.putSerializable("plan", (Serializable) Serializable.class.cast(priceItem));
            } else {
                throw new UnsupportedOperationException(PriceItem.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
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
        if (this.arguments.containsKey("planName")) {
            bundle.putString("planName", (String) this.arguments.get("planName"));
        }
        if (this.arguments.containsKey("planNumber")) {
            bundle.putString("planNumber", (String) this.arguments.get("planNumber"));
        }
        return bundle;
    }

    public SavedStateHandle toSavedStateHandle() {
        SavedStateHandle savedStateHandle = new SavedStateHandle();
        if (this.arguments.containsKey("plan")) {
            PriceItem priceItem = (PriceItem) this.arguments.get("plan");
            if (Parcelable.class.isAssignableFrom(PriceItem.class) || priceItem == null) {
                savedStateHandle.set("plan", (Parcelable) Parcelable.class.cast(priceItem));
            } else if (Serializable.class.isAssignableFrom(PriceItem.class)) {
                savedStateHandle.set("plan", (Serializable) Serializable.class.cast(priceItem));
            } else {
                throw new UnsupportedOperationException(PriceItem.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
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
        if (this.arguments.containsKey("planName")) {
            savedStateHandle.set("planName", (String) this.arguments.get("planName"));
        }
        if (this.arguments.containsKey("planNumber")) {
            savedStateHandle.set("planNumber", (String) this.arguments.get("planNumber"));
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
        ReviewOrderFragmentArgs reviewOrderFragmentArgs = (ReviewOrderFragmentArgs) object;
        if (this.arguments.containsKey("plan") != reviewOrderFragmentArgs.arguments.containsKey("plan")) {
            return false;
        }
        if (getPlan() == null ? reviewOrderFragmentArgs.getPlan() == null : getPlan().equals(reviewOrderFragmentArgs.getPlan())) {
            if (this.arguments.containsKey(AndroidContextPlugin.DEVICE_KEY) != reviewOrderFragmentArgs.arguments.containsKey(AndroidContextPlugin.DEVICE_KEY)) {
                return false;
            }
            if (getDevice() == null ? reviewOrderFragmentArgs.getDevice() == null : getDevice().equals(reviewOrderFragmentArgs.getDevice())) {
                if (this.arguments.containsKey("planName") != reviewOrderFragmentArgs.arguments.containsKey("planName")) {
                    return false;
                }
                if (getPlanName() == null ? reviewOrderFragmentArgs.getPlanName() == null : getPlanName().equals(reviewOrderFragmentArgs.getPlanName())) {
                    if (this.arguments.containsKey("planNumber") != reviewOrderFragmentArgs.arguments.containsKey("planNumber")) {
                        return false;
                    }
                    return getPlanNumber() == null ? reviewOrderFragmentArgs.getPlanNumber() == null : getPlanNumber().equals(reviewOrderFragmentArgs.getPlanNumber());
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        return (((((((getPlan() != null ? getPlan().hashCode() : 0) + 31) * 31) + (getDevice() != null ? getDevice().hashCode() : 0)) * 31) + (getPlanName() != null ? getPlanName().hashCode() : 0)) * 31) + (getPlanNumber() != null ? getPlanNumber().hashCode() : 0);
    }

    public String toString() {
        return "ReviewOrderFragmentArgs{plan=" + getPlan() + ", device=" + getDevice() + ", planName=" + getPlanName() + ", planNumber=" + getPlanNumber() + "}";
    }

    /* loaded from: classes3.dex */
    public static final class Builder {
        private final HashMap arguments;

        public Builder(ReviewOrderFragmentArgs original) {
            HashMap hashMap = new HashMap();
            this.arguments = hashMap;
            hashMap.putAll(original.arguments);
        }

        public Builder(PriceItem plan, DeviceList device, String planName, String planNumber) {
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
            if (planName == null) {
                throw new IllegalArgumentException("Argument \"planName\" is marked as non-null but was passed a null value.");
            }
            hashMap.put("planName", planName);
            if (planNumber == null) {
                throw new IllegalArgumentException("Argument \"planNumber\" is marked as non-null but was passed a null value.");
            }
            hashMap.put("planNumber", planNumber);
        }

        public ReviewOrderFragmentArgs build() {
            return new ReviewOrderFragmentArgs(this.arguments);
        }

        public Builder setPlan(PriceItem plan) {
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

        public Builder setPlanName(String planName) {
            if (planName == null) {
                throw new IllegalArgumentException("Argument \"planName\" is marked as non-null but was passed a null value.");
            }
            this.arguments.put("planName", planName);
            return this;
        }

        public Builder setPlanNumber(String planNumber) {
            if (planNumber == null) {
                throw new IllegalArgumentException("Argument \"planNumber\" is marked as non-null but was passed a null value.");
            }
            this.arguments.put("planNumber", planNumber);
            return this;
        }

        public PriceItem getPlan() {
            return (PriceItem) this.arguments.get("plan");
        }

        public DeviceList getDevice() {
            return (DeviceList) this.arguments.get(AndroidContextPlugin.DEVICE_KEY);
        }

        public String getPlanName() {
            return (String) this.arguments.get("planName");
        }

        public String getPlanNumber() {
            return (String) this.arguments.get("planNumber");
        }
    }
}
