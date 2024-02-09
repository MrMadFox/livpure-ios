package com.livpure.safedrink.subscription.kyc.view;

import android.os.Bundle;
import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.NavArgs;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class UploadKycFragmentArgs implements NavArgs {
    private final HashMap arguments;

    private UploadKycFragmentArgs() {
        this.arguments = new HashMap();
    }

    private UploadKycFragmentArgs(HashMap argumentsMap) {
        HashMap hashMap = new HashMap();
        this.arguments = hashMap;
        hashMap.putAll(argumentsMap);
    }

    public static UploadKycFragmentArgs fromBundle(Bundle bundle) {
        UploadKycFragmentArgs uploadKycFragmentArgs = new UploadKycFragmentArgs();
        bundle.setClassLoader(UploadKycFragmentArgs.class.getClassLoader());
        if (bundle.containsKey("paymentId")) {
            String string = bundle.getString("paymentId");
            if (string == null) {
                throw new IllegalArgumentException("Argument \"paymentId\" is marked as non-null but was passed a null value.");
            }
            uploadKycFragmentArgs.arguments.put("paymentId", string);
            return uploadKycFragmentArgs;
        }
        throw new IllegalArgumentException("Required argument \"paymentId\" is missing and does not have an android:defaultValue");
    }

    public static UploadKycFragmentArgs fromSavedStateHandle(SavedStateHandle savedStateHandle) {
        UploadKycFragmentArgs uploadKycFragmentArgs = new UploadKycFragmentArgs();
        if (savedStateHandle.contains("paymentId")) {
            String str = (String) savedStateHandle.get("paymentId");
            if (str == null) {
                throw new IllegalArgumentException("Argument \"paymentId\" is marked as non-null but was passed a null value.");
            }
            uploadKycFragmentArgs.arguments.put("paymentId", str);
            return uploadKycFragmentArgs;
        }
        throw new IllegalArgumentException("Required argument \"paymentId\" is missing and does not have an android:defaultValue");
    }

    public String getPaymentId() {
        return (String) this.arguments.get("paymentId");
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        if (this.arguments.containsKey("paymentId")) {
            bundle.putString("paymentId", (String) this.arguments.get("paymentId"));
        }
        return bundle;
    }

    public SavedStateHandle toSavedStateHandle() {
        SavedStateHandle savedStateHandle = new SavedStateHandle();
        if (this.arguments.containsKey("paymentId")) {
            savedStateHandle.set("paymentId", (String) this.arguments.get("paymentId"));
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
        UploadKycFragmentArgs uploadKycFragmentArgs = (UploadKycFragmentArgs) object;
        if (this.arguments.containsKey("paymentId") != uploadKycFragmentArgs.arguments.containsKey("paymentId")) {
            return false;
        }
        return getPaymentId() == null ? uploadKycFragmentArgs.getPaymentId() == null : getPaymentId().equals(uploadKycFragmentArgs.getPaymentId());
    }

    public int hashCode() {
        return 31 + (getPaymentId() != null ? getPaymentId().hashCode() : 0);
    }

    public String toString() {
        return "UploadKycFragmentArgs{paymentId=" + getPaymentId() + "}";
    }

    /* loaded from: classes3.dex */
    public static final class Builder {
        private final HashMap arguments;

        public Builder(UploadKycFragmentArgs original) {
            HashMap hashMap = new HashMap();
            this.arguments = hashMap;
            hashMap.putAll(original.arguments);
        }

        public Builder(String paymentId) {
            HashMap hashMap = new HashMap();
            this.arguments = hashMap;
            if (paymentId == null) {
                throw new IllegalArgumentException("Argument \"paymentId\" is marked as non-null but was passed a null value.");
            }
            hashMap.put("paymentId", paymentId);
        }

        public UploadKycFragmentArgs build() {
            return new UploadKycFragmentArgs(this.arguments);
        }

        public Builder setPaymentId(String paymentId) {
            if (paymentId == null) {
                throw new IllegalArgumentException("Argument \"paymentId\" is marked as non-null but was passed a null value.");
            }
            this.arguments.put("paymentId", paymentId);
            return this;
        }

        public String getPaymentId() {
            return (String) this.arguments.get("paymentId");
        }
    }
}
