package com.livpure.safedrink.app.support.views;

import android.os.Bundle;
import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.NavArgs;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class ContactUsFragmentArgs implements NavArgs {
    private final HashMap arguments;

    private ContactUsFragmentArgs() {
        this.arguments = new HashMap();
    }

    private ContactUsFragmentArgs(HashMap argumentsMap) {
        HashMap hashMap = new HashMap();
        this.arguments = hashMap;
        hashMap.putAll(argumentsMap);
    }

    public static ContactUsFragmentArgs fromBundle(Bundle bundle) {
        ContactUsFragmentArgs contactUsFragmentArgs = new ContactUsFragmentArgs();
        bundle.setClassLoader(ContactUsFragmentArgs.class.getClassLoader());
        if (bundle.containsKey("serialNumber")) {
            String string = bundle.getString("serialNumber");
            if (string == null) {
                throw new IllegalArgumentException("Argument \"serialNumber\" is marked as non-null but was passed a null value.");
            }
            contactUsFragmentArgs.arguments.put("serialNumber", string);
        } else {
            contactUsFragmentArgs.arguments.put("serialNumber", "1");
        }
        return contactUsFragmentArgs;
    }

    public static ContactUsFragmentArgs fromSavedStateHandle(SavedStateHandle savedStateHandle) {
        ContactUsFragmentArgs contactUsFragmentArgs = new ContactUsFragmentArgs();
        if (savedStateHandle.contains("serialNumber")) {
            String str = (String) savedStateHandle.get("serialNumber");
            if (str == null) {
                throw new IllegalArgumentException("Argument \"serialNumber\" is marked as non-null but was passed a null value.");
            }
            contactUsFragmentArgs.arguments.put("serialNumber", str);
        } else {
            contactUsFragmentArgs.arguments.put("serialNumber", "1");
        }
        return contactUsFragmentArgs;
    }

    public String getSerialNumber() {
        return (String) this.arguments.get("serialNumber");
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        if (this.arguments.containsKey("serialNumber")) {
            bundle.putString("serialNumber", (String) this.arguments.get("serialNumber"));
        } else {
            bundle.putString("serialNumber", "1");
        }
        return bundle;
    }

    public SavedStateHandle toSavedStateHandle() {
        SavedStateHandle savedStateHandle = new SavedStateHandle();
        if (this.arguments.containsKey("serialNumber")) {
            savedStateHandle.set("serialNumber", (String) this.arguments.get("serialNumber"));
        } else {
            savedStateHandle.set("serialNumber", "1");
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
        ContactUsFragmentArgs contactUsFragmentArgs = (ContactUsFragmentArgs) object;
        if (this.arguments.containsKey("serialNumber") != contactUsFragmentArgs.arguments.containsKey("serialNumber")) {
            return false;
        }
        return getSerialNumber() == null ? contactUsFragmentArgs.getSerialNumber() == null : getSerialNumber().equals(contactUsFragmentArgs.getSerialNumber());
    }

    public int hashCode() {
        return 31 + (getSerialNumber() != null ? getSerialNumber().hashCode() : 0);
    }

    public String toString() {
        return "ContactUsFragmentArgs{serialNumber=" + getSerialNumber() + "}";
    }

    /* loaded from: classes3.dex */
    public static final class Builder {
        private final HashMap arguments;

        public Builder(ContactUsFragmentArgs original) {
            HashMap hashMap = new HashMap();
            this.arguments = hashMap;
            hashMap.putAll(original.arguments);
        }

        public Builder() {
            this.arguments = new HashMap();
        }

        public ContactUsFragmentArgs build() {
            return new ContactUsFragmentArgs(this.arguments);
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
