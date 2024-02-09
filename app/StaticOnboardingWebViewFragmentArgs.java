package com.livpure.safedrink.app;

import android.os.Bundle;
import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.NavArgs;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class StaticOnboardingWebViewFragmentArgs implements NavArgs {
    private final HashMap arguments;

    private StaticOnboardingWebViewFragmentArgs() {
        this.arguments = new HashMap();
    }

    private StaticOnboardingWebViewFragmentArgs(HashMap argumentsMap) {
        HashMap hashMap = new HashMap();
        this.arguments = hashMap;
        hashMap.putAll(argumentsMap);
    }

    public static StaticOnboardingWebViewFragmentArgs fromBundle(Bundle bundle) {
        StaticOnboardingWebViewFragmentArgs staticOnboardingWebViewFragmentArgs = new StaticOnboardingWebViewFragmentArgs();
        bundle.setClassLoader(StaticOnboardingWebViewFragmentArgs.class.getClassLoader());
        if (bundle.containsKey("url")) {
            staticOnboardingWebViewFragmentArgs.arguments.put("url", Integer.valueOf(bundle.getInt("url")));
            return staticOnboardingWebViewFragmentArgs;
        }
        throw new IllegalArgumentException("Required argument \"url\" is missing and does not have an android:defaultValue");
    }

    public static StaticOnboardingWebViewFragmentArgs fromSavedStateHandle(SavedStateHandle savedStateHandle) {
        StaticOnboardingWebViewFragmentArgs staticOnboardingWebViewFragmentArgs = new StaticOnboardingWebViewFragmentArgs();
        if (savedStateHandle.contains("url")) {
            staticOnboardingWebViewFragmentArgs.arguments.put("url", Integer.valueOf(((Integer) savedStateHandle.get("url")).intValue()));
            return staticOnboardingWebViewFragmentArgs;
        }
        throw new IllegalArgumentException("Required argument \"url\" is missing and does not have an android:defaultValue");
    }

    public int getUrl() {
        return ((Integer) this.arguments.get("url")).intValue();
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        if (this.arguments.containsKey("url")) {
            bundle.putInt("url", ((Integer) this.arguments.get("url")).intValue());
        }
        return bundle;
    }

    public SavedStateHandle toSavedStateHandle() {
        SavedStateHandle savedStateHandle = new SavedStateHandle();
        if (this.arguments.containsKey("url")) {
            savedStateHandle.set("url", Integer.valueOf(((Integer) this.arguments.get("url")).intValue()));
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
        StaticOnboardingWebViewFragmentArgs staticOnboardingWebViewFragmentArgs = (StaticOnboardingWebViewFragmentArgs) object;
        return this.arguments.containsKey("url") == staticOnboardingWebViewFragmentArgs.arguments.containsKey("url") && getUrl() == staticOnboardingWebViewFragmentArgs.getUrl();
    }

    public int hashCode() {
        return 31 + getUrl();
    }

    public String toString() {
        return "StaticOnboardingWebViewFragmentArgs{url=" + getUrl() + "}";
    }

    /* loaded from: classes3.dex */
    public static final class Builder {
        private final HashMap arguments;

        public Builder(StaticOnboardingWebViewFragmentArgs original) {
            HashMap hashMap = new HashMap();
            this.arguments = hashMap;
            hashMap.putAll(original.arguments);
        }

        public Builder(int url) {
            HashMap hashMap = new HashMap();
            this.arguments = hashMap;
            hashMap.put("url", Integer.valueOf(url));
        }

        public StaticOnboardingWebViewFragmentArgs build() {
            return new StaticOnboardingWebViewFragmentArgs(this.arguments);
        }

        public Builder setUrl(int url) {
            this.arguments.put("url", Integer.valueOf(url));
            return this;
        }

        public int getUrl() {
            return ((Integer) this.arguments.get("url")).intValue();
        }
    }
}
