package com.livpure.safedrink.login;

import android.os.Bundle;
import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.NavArgs;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class AuthPagerFragmentArgs implements NavArgs {
    private final HashMap arguments;

    private AuthPagerFragmentArgs() {
        this.arguments = new HashMap();
    }

    private AuthPagerFragmentArgs(HashMap argumentsMap) {
        HashMap hashMap = new HashMap();
        this.arguments = hashMap;
        hashMap.putAll(argumentsMap);
    }

    public static AuthPagerFragmentArgs fromBundle(Bundle bundle) {
        AuthPagerFragmentArgs authPagerFragmentArgs = new AuthPagerFragmentArgs();
        bundle.setClassLoader(AuthPagerFragmentArgs.class.getClassLoader());
        if (bundle.containsKey("authType")) {
            authPagerFragmentArgs.arguments.put("authType", Integer.valueOf(bundle.getInt("authType")));
            return authPagerFragmentArgs;
        }
        throw new IllegalArgumentException("Required argument \"authType\" is missing and does not have an android:defaultValue");
    }

    public static AuthPagerFragmentArgs fromSavedStateHandle(SavedStateHandle savedStateHandle) {
        AuthPagerFragmentArgs authPagerFragmentArgs = new AuthPagerFragmentArgs();
        if (savedStateHandle.contains("authType")) {
            authPagerFragmentArgs.arguments.put("authType", Integer.valueOf(((Integer) savedStateHandle.get("authType")).intValue()));
            return authPagerFragmentArgs;
        }
        throw new IllegalArgumentException("Required argument \"authType\" is missing and does not have an android:defaultValue");
    }

    public int getAuthType() {
        return ((Integer) this.arguments.get("authType")).intValue();
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        if (this.arguments.containsKey("authType")) {
            bundle.putInt("authType", ((Integer) this.arguments.get("authType")).intValue());
        }
        return bundle;
    }

    public SavedStateHandle toSavedStateHandle() {
        SavedStateHandle savedStateHandle = new SavedStateHandle();
        if (this.arguments.containsKey("authType")) {
            savedStateHandle.set("authType", Integer.valueOf(((Integer) this.arguments.get("authType")).intValue()));
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
        AuthPagerFragmentArgs authPagerFragmentArgs = (AuthPagerFragmentArgs) object;
        return this.arguments.containsKey("authType") == authPagerFragmentArgs.arguments.containsKey("authType") && getAuthType() == authPagerFragmentArgs.getAuthType();
    }

    public int hashCode() {
        return 31 + getAuthType();
    }

    public String toString() {
        return "AuthPagerFragmentArgs{authType=" + getAuthType() + "}";
    }

    /* loaded from: classes3.dex */
    public static final class Builder {
        private final HashMap arguments;

        public Builder(AuthPagerFragmentArgs original) {
            HashMap hashMap = new HashMap();
            this.arguments = hashMap;
            hashMap.putAll(original.arguments);
        }

        public Builder(int authType) {
            HashMap hashMap = new HashMap();
            this.arguments = hashMap;
            hashMap.put("authType", Integer.valueOf(authType));
        }

        public AuthPagerFragmentArgs build() {
            return new AuthPagerFragmentArgs(this.arguments);
        }

        public Builder setAuthType(int authType) {
            this.arguments.put("authType", Integer.valueOf(authType));
            return this;
        }

        public int getAuthType() {
            return ((Integer) this.arguments.get("authType")).intValue();
        }
    }
}
