package com.livpure.safedrink.login;

import android.os.Bundle;
import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.NavArgs;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class ResetPasswordFragmentArgs implements NavArgs {
    private final HashMap arguments;

    private ResetPasswordFragmentArgs() {
        this.arguments = new HashMap();
    }

    private ResetPasswordFragmentArgs(HashMap argumentsMap) {
        HashMap hashMap = new HashMap();
        this.arguments = hashMap;
        hashMap.putAll(argumentsMap);
    }

    public static ResetPasswordFragmentArgs fromBundle(Bundle bundle) {
        ResetPasswordFragmentArgs resetPasswordFragmentArgs = new ResetPasswordFragmentArgs();
        bundle.setClassLoader(ResetPasswordFragmentArgs.class.getClassLoader());
        if (bundle.containsKey("username")) {
            String string = bundle.getString("username");
            if (string == null) {
                throw new IllegalArgumentException("Argument \"username\" is marked as non-null but was passed a null value.");
            }
            resetPasswordFragmentArgs.arguments.put("username", string);
            return resetPasswordFragmentArgs;
        }
        throw new IllegalArgumentException("Required argument \"username\" is missing and does not have an android:defaultValue");
    }

    public static ResetPasswordFragmentArgs fromSavedStateHandle(SavedStateHandle savedStateHandle) {
        ResetPasswordFragmentArgs resetPasswordFragmentArgs = new ResetPasswordFragmentArgs();
        if (savedStateHandle.contains("username")) {
            String str = (String) savedStateHandle.get("username");
            if (str == null) {
                throw new IllegalArgumentException("Argument \"username\" is marked as non-null but was passed a null value.");
            }
            resetPasswordFragmentArgs.arguments.put("username", str);
            return resetPasswordFragmentArgs;
        }
        throw new IllegalArgumentException("Required argument \"username\" is missing and does not have an android:defaultValue");
    }

    public String getUsername() {
        return (String) this.arguments.get("username");
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        if (this.arguments.containsKey("username")) {
            bundle.putString("username", (String) this.arguments.get("username"));
        }
        return bundle;
    }

    public SavedStateHandle toSavedStateHandle() {
        SavedStateHandle savedStateHandle = new SavedStateHandle();
        if (this.arguments.containsKey("username")) {
            savedStateHandle.set("username", (String) this.arguments.get("username"));
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
        ResetPasswordFragmentArgs resetPasswordFragmentArgs = (ResetPasswordFragmentArgs) object;
        if (this.arguments.containsKey("username") != resetPasswordFragmentArgs.arguments.containsKey("username")) {
            return false;
        }
        return getUsername() == null ? resetPasswordFragmentArgs.getUsername() == null : getUsername().equals(resetPasswordFragmentArgs.getUsername());
    }

    public int hashCode() {
        return 31 + (getUsername() != null ? getUsername().hashCode() : 0);
    }

    public String toString() {
        return "ResetPasswordFragmentArgs{username=" + getUsername() + "}";
    }

    /* loaded from: classes3.dex */
    public static final class Builder {
        private final HashMap arguments;

        public Builder(ResetPasswordFragmentArgs original) {
            HashMap hashMap = new HashMap();
            this.arguments = hashMap;
            hashMap.putAll(original.arguments);
        }

        public Builder(String username) {
            HashMap hashMap = new HashMap();
            this.arguments = hashMap;
            if (username == null) {
                throw new IllegalArgumentException("Argument \"username\" is marked as non-null but was passed a null value.");
            }
            hashMap.put("username", username);
        }

        public ResetPasswordFragmentArgs build() {
            return new ResetPasswordFragmentArgs(this.arguments);
        }

        public Builder setUsername(String username) {
            if (username == null) {
                throw new IllegalArgumentException("Argument \"username\" is marked as non-null but was passed a null value.");
            }
            this.arguments.put("username", username);
            return this;
        }

        public String getUsername() {
            return (String) this.arguments.get("username");
        }
    }
}
