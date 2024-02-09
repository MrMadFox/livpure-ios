package com.livpure.safedrink.app;

import android.os.Bundle;
import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.NavArgs;
import com.livpure.safedrink.R;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class StaticWebViewFragmentArgs implements NavArgs {
    private final HashMap arguments;

    private StaticWebViewFragmentArgs() {
        this.arguments = new HashMap();
    }

    private StaticWebViewFragmentArgs(HashMap argumentsMap) {
        HashMap hashMap = new HashMap();
        this.arguments = hashMap;
        hashMap.putAll(argumentsMap);
    }

    public static StaticWebViewFragmentArgs fromBundle(Bundle bundle) {
        StaticWebViewFragmentArgs staticWebViewFragmentArgs = new StaticWebViewFragmentArgs();
        bundle.setClassLoader(StaticWebViewFragmentArgs.class.getClassLoader());
        if (bundle.containsKey("url")) {
            staticWebViewFragmentArgs.arguments.put("url", Integer.valueOf(bundle.getInt("url")));
        } else {
            staticWebViewFragmentArgs.arguments.put("url", Integer.valueOf((int) R.string.faq_url));
        }
        return staticWebViewFragmentArgs;
    }

    public static StaticWebViewFragmentArgs fromSavedStateHandle(SavedStateHandle savedStateHandle) {
        StaticWebViewFragmentArgs staticWebViewFragmentArgs = new StaticWebViewFragmentArgs();
        if (savedStateHandle.contains("url")) {
            staticWebViewFragmentArgs.arguments.put("url", Integer.valueOf(((Integer) savedStateHandle.get("url")).intValue()));
        } else {
            staticWebViewFragmentArgs.arguments.put("url", Integer.valueOf((int) R.string.faq_url));
        }
        return staticWebViewFragmentArgs;
    }

    public int getUrl() {
        return ((Integer) this.arguments.get("url")).intValue();
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        if (this.arguments.containsKey("url")) {
            bundle.putInt("url", ((Integer) this.arguments.get("url")).intValue());
        } else {
            bundle.putInt("url", R.string.faq_url);
        }
        return bundle;
    }

    public SavedStateHandle toSavedStateHandle() {
        SavedStateHandle savedStateHandle = new SavedStateHandle();
        if (this.arguments.containsKey("url")) {
            savedStateHandle.set("url", Integer.valueOf(((Integer) this.arguments.get("url")).intValue()));
        } else {
            savedStateHandle.set("url", Integer.valueOf((int) R.string.faq_url));
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
        StaticWebViewFragmentArgs staticWebViewFragmentArgs = (StaticWebViewFragmentArgs) object;
        return this.arguments.containsKey("url") == staticWebViewFragmentArgs.arguments.containsKey("url") && getUrl() == staticWebViewFragmentArgs.getUrl();
    }

    public int hashCode() {
        return 31 + getUrl();
    }

    public String toString() {
        return "StaticWebViewFragmentArgs{url=" + getUrl() + "}";
    }

    /* loaded from: classes3.dex */
    public static final class Builder {
        private final HashMap arguments;

        public Builder(StaticWebViewFragmentArgs original) {
            HashMap hashMap = new HashMap();
            this.arguments = hashMap;
            hashMap.putAll(original.arguments);
        }

        public Builder() {
            this.arguments = new HashMap();
        }

        public StaticWebViewFragmentArgs build() {
            return new StaticWebViewFragmentArgs(this.arguments);
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
